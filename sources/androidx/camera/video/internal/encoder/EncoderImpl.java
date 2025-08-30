package androidx.camera.video.internal.encoder;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.compat.quirk.AudioEncoderIgnoresInputTimestampQuirk;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.compat.quirk.CodecStuckOnFlushQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.compat.quirk.SignalEosOutputBufferNotComeQuirk;
import androidx.camera.video.internal.compat.quirk.StopCodecAfterSurfaceRemovalCrashMediaServerQuirk;
import androidx.camera.video.internal.compat.quirk.VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.utils.CodecUtil;
import androidx.camera.video.internal.workaround.VideoTimebaseConverter;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class EncoderImpl implements Encoder {
    private static final boolean DEBUG = false;
    private static final long NO_LIMIT_LONG = Long.MAX_VALUE;
    private static final Range<Long> NO_RANGE = Range.create(Long.MAX_VALUE, Long.MAX_VALUE);
    private static final long SIGNAL_EOS_TIMEOUT_MS = 1000;
    private static final long STOP_TIMEOUT_MS = 1000;
    private final Queue<CallbackToFutureAdapter.Completer<InputBuffer>> mAcquisitionQueue = new ArrayDeque();
    final Deque<Range<Long>> mActivePauseResumeTimeRanges = new ArrayDeque();
    final Set<EncodedDataImpl> mEncodedDataSet = new HashSet();
    @GuardedBy("mLock")
    EncoderCallback mEncoderCallback = EncoderCallback.EMPTY;
    @GuardedBy("mLock")
    Executor mEncoderCallbackExecutor = CameraXExecutors.directExecutor();
    final Executor mEncoderExecutor;
    private final EncoderInfo mEncoderInfo;
    final Encoder.EncoderInput mEncoderInput;
    final Queue<Integer> mFreeInputBufferIndexQueue = new ArrayDeque();
    private final Set<InputBuffer> mInputBufferSet = new HashSet();
    final Timebase mInputTimebase;
    private boolean mIsFlushedAfterEndOfStream = false;
    final boolean mIsVideoEncoder;
    Long mLastDataStopTimestamp = null;
    final Object mLock = new Object();
    final MediaCodec mMediaCodec;
    private MediaCodecCallback mMediaCodecCallback = null;
    boolean mMediaCodecEosSignalled = false;
    /* access modifiers changed from: private */
    public final MediaFormat mMediaFormat;
    boolean mPendingCodecStop = false;
    private final CallbackToFutureAdapter.Completer<Void> mReleasedCompleter;
    private final ListenableFuture<Void> mReleasedFuture;
    /* access modifiers changed from: private */
    @Nullable
    public Future<?> mSignalEosTimeoutFuture;
    private boolean mSourceStoppedSignalled = false;
    Range<Long> mStartStopTimeRangeUs = NO_RANGE;
    InternalState mState;
    Future<?> mStopTimeoutFuture = null;
    final String mTag;
    final TimeProvider mTimeProvider = new SystemTimeProvider();
    long mTotalPausedDurationUs = 0;

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @NonNull
        public static Surface createPersistentInputSurface() {
            return MediaCodec.createPersistentInputSurface();
        }

        public static void setInputSurface(@NonNull MediaCodec mediaCodec, @NonNull Surface surface) {
            mediaCodec.setInputSurface(surface);
        }
    }

    public class ByteBufferInput implements Encoder.ByteBufferInput {
        private final List<ListenableFuture<InputBuffer>> mAcquisitionList = new ArrayList();
        private BufferProvider.State mBufferProviderState = BufferProvider.State.INACTIVE;
        private final Map<Observable.Observer<? super BufferProvider.State>, Executor> mStateObservers = new LinkedHashMap();

        public ByteBufferInput() {
        }

        /* access modifiers changed from: private */
        /* renamed from: cancelInputBuffer */
        public void lambda$acquireBuffer$2(@NonNull ListenableFuture<InputBuffer> listenableFuture) {
            if (!listenableFuture.cancel(true)) {
                Preconditions.checkState(listenableFuture.isDone());
                try {
                    listenableFuture.get().cancel();
                } catch (InterruptedException | CancellationException | ExecutionException e) {
                    String str = EncoderImpl.this.mTag;
                    Logger.w(str, "Unable to cancel the input buffer: " + e);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$acquireBuffer$3(ListenableFuture listenableFuture) {
            this.mAcquisitionList.remove(listenableFuture);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$acquireBuffer$4(CallbackToFutureAdapter.Completer completer) {
            BufferProvider.State state = this.mBufferProviderState;
            if (state == BufferProvider.State.ACTIVE) {
                ListenableFuture<InputBuffer> acquireInputBuffer = EncoderImpl.this.acquireInputBuffer();
                Futures.propagate(acquireInputBuffer, completer);
                completer.addCancellationListener(new f(this, acquireInputBuffer, 0), CameraXExecutors.directExecutor());
                this.mAcquisitionList.add(acquireInputBuffer);
                acquireInputBuffer.addListener(new f(this, acquireInputBuffer, 1), EncoderImpl.this.mEncoderExecutor);
            } else if (state == BufferProvider.State.INACTIVE) {
                completer.setException(new IllegalStateException("BufferProvider is not active."));
            } else {
                completer.setException(new IllegalStateException("Unknown state: " + this.mBufferProviderState));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$acquireBuffer$5(CallbackToFutureAdapter.Completer completer) throws Exception {
            EncoderImpl.this.mEncoderExecutor.execute(new e(this, completer, 0));
            return "acquireBuffer";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$addObserver$7(Observable.Observer observer, Executor executor) {
            this.mStateObservers.put((Observable.Observer) Preconditions.checkNotNull(observer), (Executor) Preconditions.checkNotNull(executor));
            executor.execute(new a(3, (Object) observer, (Object) this.mBufferProviderState));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$fetchData$0(CallbackToFutureAdapter.Completer completer) {
            completer.set(this.mBufferProviderState);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object lambda$fetchData$1(CallbackToFutureAdapter.Completer completer) throws Exception {
            EncoderImpl.this.mEncoderExecutor.execute(new e(this, completer, 1));
            return "fetchData";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$removeObserver$8(Observable.Observer observer) {
            this.mStateObservers.remove(Preconditions.checkNotNull(observer));
        }

        @NonNull
        public ListenableFuture<InputBuffer> acquireBuffer() {
            return CallbackToFutureAdapter.getFuture(new d(this, 1));
        }

        public void addObserver(@NonNull Executor executor, @NonNull Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new c(this, (Observable.Observer) observer, executor));
        }

        @NonNull
        public ListenableFuture<BufferProvider.State> fetchData() {
            return CallbackToFutureAdapter.getFuture(new d(this, 0));
        }

        public void removeObserver(@NonNull Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.mEncoderExecutor.execute(new a(4, (Object) this, (Object) observer));
        }

        public void setActive(boolean z) {
            BufferProvider.State state;
            if (z) {
                state = BufferProvider.State.ACTIVE;
            } else {
                state = BufferProvider.State.INACTIVE;
            }
            if (this.mBufferProviderState != state) {
                this.mBufferProviderState = state;
                if (state == BufferProvider.State.INACTIVE) {
                    for (ListenableFuture<InputBuffer> cancel : this.mAcquisitionList) {
                        cancel.cancel(true);
                    }
                    this.mAcquisitionList.clear();
                }
                for (Map.Entry next : this.mStateObservers.entrySet()) {
                    try {
                        ((Executor) next.getValue()).execute(new a(2, (Object) next, (Object) state));
                    } catch (RejectedExecutionException e) {
                        Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                    }
                }
            }
        }
    }

    public enum InternalState {
        CONFIGURED,
        STARTED,
        PAUSED,
        STOPPING,
        PENDING_START,
        PENDING_START_PAUSED,
        PENDING_RELEASE,
        ERROR,
        RELEASED
    }

    public class MediaCodecCallback extends MediaCodec.Callback {
        private boolean mHasEndData = false;
        private boolean mHasFirstData = false;
        private boolean mHasSendStartCallback = false;
        private boolean mIsKeyFrameRequired = false;
        private boolean mIsOutputBufferInPauseState = false;
        private long mLastPresentationTimeUs = 0;
        private long mLastSentAdjustedTimeUs = 0;
        private boolean mReachStopTimeAsEos = true;
        private boolean mStopped = false;
        @Nullable
        private final VideoTimebaseConverter mVideoTimestampConverter;

        public MediaCodecCallback() {
            if (EncoderImpl.this.mIsVideoEncoder) {
                this.mVideoTimestampConverter = new VideoTimebaseConverter(EncoderImpl.this.mTimeProvider, EncoderImpl.this.mInputTimebase, (CameraUseInconsistentTimebaseQuirk) DeviceQuirks.get(CameraUseInconsistentTimebaseQuirk.class));
            } else {
                this.mVideoTimestampConverter = null;
            }
            CodecStuckOnFlushQuirk codecStuckOnFlushQuirk = (CodecStuckOnFlushQuirk) DeviceQuirks.get(CodecStuckOnFlushQuirk.class);
            if (codecStuckOnFlushQuirk != null && codecStuckOnFlushQuirk.isProblematicMimeType(EncoderImpl.this.mMediaFormat.getString("mime"))) {
                this.mReachStopTimeAsEos = false;
            }
        }

        private boolean checkBufferInfo(@NonNull MediaCodec.BufferInfo bufferInfo) {
            if (this.mHasEndData) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by already reach end of stream.");
                return false;
            } else if (bufferInfo.size <= 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by invalid buffer size.");
                return false;
            } else if ((bufferInfo.flags & 2) != 0) {
                Logger.d(EncoderImpl.this.mTag, "Drop buffer by codec config.");
                return false;
            } else {
                VideoTimebaseConverter videoTimebaseConverter = this.mVideoTimestampConverter;
                if (videoTimebaseConverter != null) {
                    bufferInfo.presentationTimeUs = videoTimebaseConverter.convertToUptimeUs(bufferInfo.presentationTimeUs);
                }
                long j = bufferInfo.presentationTimeUs;
                if (j <= this.mLastPresentationTimeUs) {
                    Logger.d(EncoderImpl.this.mTag, "Drop buffer by out of order buffer from MediaCodec.");
                    return false;
                }
                this.mLastPresentationTimeUs = j;
                if (!EncoderImpl.this.mStartStopTimeRangeUs.contains(Long.valueOf(j))) {
                    Logger.d(EncoderImpl.this.mTag, "Drop buffer by not in start-stop range.");
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    if (encoderImpl.mPendingCodecStop && bufferInfo.presentationTimeUs >= encoderImpl.mStartStopTimeRangeUs.getUpper().longValue()) {
                        Future<?> future = EncoderImpl.this.mStopTimeoutFuture;
                        if (future != null) {
                            future.cancel(true);
                        }
                        EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                        EncoderImpl.this.signalCodecStop();
                        EncoderImpl.this.mPendingCodecStop = false;
                    }
                    return false;
                } else if (updatePauseRangeStateAndCheckIfBufferPaused(bufferInfo)) {
                    Logger.d(EncoderImpl.this.mTag, "Drop buffer by pause.");
                    return false;
                } else if (EncoderImpl.this.getAdjustedTimeUs(bufferInfo) <= this.mLastSentAdjustedTimeUs) {
                    Logger.d(EncoderImpl.this.mTag, "Drop buffer by adjusted time is less than the last sent time.");
                    if (EncoderImpl.this.mIsVideoEncoder && EncoderImpl.isKeyFrame(bufferInfo)) {
                        this.mIsKeyFrameRequired = true;
                    }
                    return false;
                } else {
                    if (!this.mHasFirstData && !this.mIsKeyFrameRequired && EncoderImpl.this.mIsVideoEncoder) {
                        this.mIsKeyFrameRequired = true;
                    }
                    if (this.mIsKeyFrameRequired) {
                        if (!EncoderImpl.isKeyFrame(bufferInfo)) {
                            Logger.d(EncoderImpl.this.mTag, "Drop buffer by not a key frame.");
                            EncoderImpl.this.requestKeyFrameToMediaCodec();
                            return false;
                        }
                        this.mIsKeyFrameRequired = false;
                    }
                    return true;
                }
            }
        }

        private boolean isEndOfStream(@NonNull MediaCodec.BufferInfo bufferInfo) {
            if (EncoderImpl.hasEndOfStreamFlag(bufferInfo) || (this.mReachStopTimeAsEos && isEosSignalledAndStopTimeReached(bufferInfo))) {
                return true;
            }
            return false;
        }

        private boolean isEosSignalledAndStopTimeReached(@NonNull MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl encoderImpl = EncoderImpl.this;
            if (!encoderImpl.mMediaCodecEosSignalled || bufferInfo.presentationTimeUs <= encoderImpl.mStartStopTimeRangeUs.getUpper().longValue()) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$4(MediaCodec.CodecException codecException) {
            switch (EncoderImpl.this.mState.ordinal()) {
                case 0:
                case 7:
                case 8:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    EncoderImpl.this.handleEncodeError(codecException);
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onInputBufferAvailable$0(int i) {
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives input frame after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.mState.ordinal()) {
                case 0:
                case 7:
                case 8:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    EncoderImpl.this.mFreeInputBufferIndexQueue.offer(Integer.valueOf(i));
                    EncoderImpl.this.matchAcquisitionsAndFreeBufferIndexes();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputBufferAvailable$1(MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i) {
            EncoderCallback encoderCallback;
            Executor executor;
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives frame after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.mState.ordinal()) {
                case 0:
                case 7:
                case 8:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    synchronized (EncoderImpl.this.mLock) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        encoderCallback = encoderImpl.mEncoderCallback;
                        executor = encoderImpl.mEncoderCallbackExecutor;
                    }
                    if (!this.mHasSendStartCallback) {
                        this.mHasSendStartCallback = true;
                        try {
                            Objects.requireNonNull(encoderCallback);
                            executor.execute(new p6(encoderCallback, 1));
                        } catch (RejectedExecutionException e) {
                            Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                        }
                    }
                    if (checkBufferInfo(bufferInfo)) {
                        if (!this.mHasFirstData) {
                            this.mHasFirstData = true;
                            String str = EncoderImpl.this.mTag;
                            Logger.d(str, "data timestampUs = " + bufferInfo.presentationTimeUs + ", data timebase = " + EncoderImpl.this.mInputTimebase + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
                        }
                        MediaCodec.BufferInfo resolveOutputBufferInfo = resolveOutputBufferInfo(bufferInfo);
                        this.mLastSentAdjustedTimeUs = resolveOutputBufferInfo.presentationTimeUs;
                        try {
                            sendEncodedData(new EncodedDataImpl(mediaCodec, i, resolveOutputBufferInfo), encoderCallback, executor);
                        } catch (MediaCodec.CodecException e2) {
                            EncoderImpl.this.handleEncodeError(e2);
                            return;
                        }
                    } else {
                        try {
                            EncoderImpl.this.mMediaCodec.releaseOutputBuffer(i, false);
                        } catch (MediaCodec.CodecException e3) {
                            EncoderImpl.this.handleEncodeError(e3);
                            return;
                        }
                    }
                    if (!this.mHasEndData && isEndOfStream(bufferInfo)) {
                        reachEndData();
                        return;
                    }
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaFormat lambda$onOutputFormatChanged$5(MediaFormat mediaFormat) {
            return mediaFormat;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onOutputFormatChanged$7(MediaFormat mediaFormat) {
            EncoderCallback encoderCallback;
            Executor executor;
            if (this.mStopped) {
                Logger.w(EncoderImpl.this.mTag, "Receives onOutputFormatChanged after codec is reset.");
                return;
            }
            switch (EncoderImpl.this.mState.ordinal()) {
                case 0:
                case 7:
                case 8:
                    return;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    synchronized (EncoderImpl.this.mLock) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        encoderCallback = encoderImpl.mEncoderCallback;
                        executor = encoderImpl.mEncoderCallbackExecutor;
                    }
                    try {
                        executor.execute(new a(7, (Object) encoderCallback, (Object) mediaFormat));
                        return;
                    } catch (RejectedExecutionException e) {
                        Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.mState);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$reachEndData$2(Executor executor, EncoderCallback encoderCallback) {
            if (EncoderImpl.this.mState != InternalState.ERROR) {
                try {
                    Objects.requireNonNull(encoderCallback);
                    executor.execute(new p6(encoderCallback, 0));
                } catch (RejectedExecutionException e) {
                    Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                }
            }
        }

        @NonNull
        private MediaCodec.BufferInfo resolveOutputBufferInfo(@NonNull MediaCodec.BufferInfo bufferInfo) {
            boolean z;
            long adjustedTimeUs = EncoderImpl.this.getAdjustedTimeUs(bufferInfo);
            if (bufferInfo.presentationTimeUs == adjustedTimeUs) {
                return bufferInfo;
            }
            if (adjustedTimeUs > this.mLastSentAdjustedTimeUs) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, adjustedTimeUs, bufferInfo.flags);
            return bufferInfo2;
        }

        private void sendEncodedData(@NonNull final EncodedDataImpl encodedDataImpl, @NonNull EncoderCallback encoderCallback, @NonNull Executor executor) {
            EncoderImpl.this.mEncodedDataSet.add(encodedDataImpl);
            Futures.addCallback(encodedDataImpl.getClosedFuture(), new FutureCallback<Void>() {
                public void onFailure(@NonNull Throwable th) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                    if (th instanceof MediaCodec.CodecException) {
                        EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                    } else {
                        EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                    }
                }

                public void onSuccess(@Nullable Void voidR) {
                    EncoderImpl.this.mEncodedDataSet.remove(encodedDataImpl);
                }
            }, EncoderImpl.this.mEncoderExecutor);
            try {
                executor.execute(new a(6, (Object) encoderCallback, (Object) encodedDataImpl));
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
                encodedDataImpl.close();
            }
        }

        private boolean updatePauseRangeStateAndCheckIfBufferPaused(@NonNull MediaCodec.BufferInfo bufferInfo) {
            Executor executor;
            EncoderCallback encoderCallback;
            EncoderImpl.this.updateTotalPausedDuration(bufferInfo.presentationTimeUs);
            boolean isInPauseRange = EncoderImpl.this.isInPauseRange(bufferInfo.presentationTimeUs);
            boolean z = this.mIsOutputBufferInPauseState;
            if (!z && isInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to pause state");
                this.mIsOutputBufferInPauseState = true;
                synchronized (EncoderImpl.this.mLock) {
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    executor = encoderImpl.mEncoderCallbackExecutor;
                    encoderCallback = encoderImpl.mEncoderCallback;
                }
                Objects.requireNonNull(encoderCallback);
                executor.execute(new p6(encoderCallback, 2));
                EncoderImpl encoderImpl2 = EncoderImpl.this;
                if (encoderImpl2.mState == InternalState.PAUSED && ((encoderImpl2.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!EncoderImpl.this.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null))) {
                    Encoder.EncoderInput encoderInput = EncoderImpl.this.mEncoderInput;
                    if (encoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput).setActive(false);
                    }
                    EncoderImpl.this.setMediaCodecPaused(true);
                }
                EncoderImpl.this.mLastDataStopTimestamp = Long.valueOf(bufferInfo.presentationTimeUs);
                EncoderImpl encoderImpl3 = EncoderImpl.this;
                if (encoderImpl3.mPendingCodecStop) {
                    Future<?> future = encoderImpl3.mStopTimeoutFuture;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.signalCodecStop();
                    EncoderImpl.this.mPendingCodecStop = false;
                }
            } else if (z && !isInPauseRange) {
                Logger.d(EncoderImpl.this.mTag, "Switch to resume state");
                this.mIsOutputBufferInPauseState = false;
                if (EncoderImpl.this.mIsVideoEncoder && !EncoderImpl.isKeyFrame(bufferInfo)) {
                    this.mIsKeyFrameRequired = true;
                }
            }
            return this.mIsOutputBufferInPauseState;
        }

        public void onError(@NonNull MediaCodec mediaCodec, @NonNull MediaCodec.CodecException codecException) {
            EncoderImpl.this.mEncoderExecutor.execute(new a(this, (Object) codecException, 8));
        }

        public void onInputBufferAvailable(@NonNull MediaCodec mediaCodec, int i) {
            EncoderImpl.this.mEncoderExecutor.execute(new g(this, i));
        }

        public void onOutputBufferAvailable(@NonNull MediaCodec mediaCodec, int i, @NonNull MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl.this.mEncoderExecutor.execute(new h(this, bufferInfo, mediaCodec, i));
        }

        public void onOutputFormatChanged(@NonNull MediaCodec mediaCodec, @NonNull MediaFormat mediaFormat) {
            EncoderImpl.this.mEncoderExecutor.execute(new a(this, (Object) mediaFormat, 5));
        }

        public void reachEndData() {
            EncoderImpl encoderImpl;
            EncoderCallback encoderCallback;
            Executor executor;
            if (!this.mHasEndData) {
                this.mHasEndData = true;
                if (EncoderImpl.this.mSignalEosTimeoutFuture != null) {
                    EncoderImpl.this.mSignalEosTimeoutFuture.cancel(false);
                    Future unused = EncoderImpl.this.mSignalEosTimeoutFuture = null;
                }
                synchronized (EncoderImpl.this.mLock) {
                    encoderImpl = EncoderImpl.this;
                    encoderCallback = encoderImpl.mEncoderCallback;
                    executor = encoderImpl.mEncoderCallbackExecutor;
                }
                encoderImpl.stopMediaCodec(new c(this, executor, encoderCallback));
            }
        }

        public void stop() {
            this.mStopped = true;
        }
    }

    public class SurfaceInput implements Encoder.SurfaceInput {
        private final Object mLock = new Object();
        @GuardedBy("mLock")
        private final Set<Surface> mObsoleteSurfaces = new HashSet();
        @GuardedBy("mLock")
        private Surface mSurface;
        @GuardedBy("mLock")
        private Executor mSurfaceUpdateExecutor;
        @GuardedBy("mLock")
        private Encoder.SurfaceInput.OnSurfaceUpdateListener mSurfaceUpdateListener;

        public SurfaceInput() {
        }

        private void notifySurfaceUpdate(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener, @NonNull Surface surface) {
            try {
                executor.execute(new a(9, (Object) onSurfaceUpdateListener, (Object) surface));
            } catch (RejectedExecutionException e) {
                Logger.e(EncoderImpl.this.mTag, "Unable to post to the supplied executor.", e);
            }
        }

        public void releaseSurface() {
            Surface surface;
            HashSet hashSet;
            synchronized (this.mLock) {
                surface = this.mSurface;
                this.mSurface = null;
                hashSet = new HashSet(this.mObsoleteSurfaces);
                this.mObsoleteSurfaces.clear();
            }
            if (surface != null) {
                surface.release();
            }
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((Surface) it.next()).release();
            }
        }

        @SuppressLint({"NewApi"})
        public void resetSurface() {
            Surface surface;
            Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener;
            Executor executor;
            EncoderNotUsePersistentInputSurfaceQuirk encoderNotUsePersistentInputSurfaceQuirk = (EncoderNotUsePersistentInputSurfaceQuirk) DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class);
            synchronized (this.mLock) {
                if (encoderNotUsePersistentInputSurfaceQuirk == null) {
                    try {
                        if (this.mSurface == null) {
                            surface = Api23Impl.createPersistentInputSurface();
                            this.mSurface = surface;
                        } else {
                            surface = null;
                        }
                        Api23Impl.setInputSurface(EncoderImpl.this.mMediaCodec, this.mSurface);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                } else {
                    Surface surface2 = this.mSurface;
                    if (surface2 != null) {
                        this.mObsoleteSurfaces.add(surface2);
                    }
                    surface = EncoderImpl.this.mMediaCodec.createInputSurface();
                    this.mSurface = surface;
                }
                onSurfaceUpdateListener = this.mSurfaceUpdateListener;
                executor = this.mSurfaceUpdateExecutor;
            }
            if (surface != null && onSurfaceUpdateListener != null && executor != null) {
                notifySurfaceUpdate(executor, onSurfaceUpdateListener, surface);
            }
        }

        public void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
            Surface surface;
            synchronized (this.mLock) {
                this.mSurfaceUpdateListener = (Encoder.SurfaceInput.OnSurfaceUpdateListener) Preconditions.checkNotNull(onSurfaceUpdateListener);
                this.mSurfaceUpdateExecutor = (Executor) Preconditions.checkNotNull(executor);
                surface = this.mSurface;
            }
            if (surface != null) {
                notifySurfaceUpdate(executor, onSurfaceUpdateListener, surface);
            }
        }
    }

    public EncoderImpl(@NonNull Executor executor, @NonNull EncoderConfig encoderConfig) throws InvalidConfigException {
        Preconditions.checkNotNull(executor);
        Preconditions.checkNotNull(encoderConfig);
        MediaCodec createCodec = CodecUtil.createCodec(encoderConfig);
        this.mMediaCodec = createCodec;
        MediaCodecInfo codecInfo = createCodec.getCodecInfo();
        this.mEncoderExecutor = CameraXExecutors.newSequentialExecutor(executor);
        MediaFormat mediaFormat = encoderConfig.toMediaFormat();
        this.mMediaFormat = mediaFormat;
        Timebase inputTimebase = encoderConfig.getInputTimebase();
        this.mInputTimebase = inputTimebase;
        if (encoderConfig instanceof AudioEncoderConfig) {
            this.mTag = "AudioEncoder";
            this.mIsVideoEncoder = false;
            this.mEncoderInput = new ByteBufferInput();
            this.mEncoderInfo = new AudioEncoderInfoImpl(codecInfo, encoderConfig.getMimeType());
        } else if (encoderConfig instanceof VideoEncoderConfig) {
            this.mTag = "VideoEncoder";
            this.mIsVideoEncoder = true;
            this.mEncoderInput = new SurfaceInput();
            VideoEncoderInfoImpl videoEncoderInfoImpl = new VideoEncoderInfoImpl(codecInfo, encoderConfig.getMimeType());
            clampVideoBitrateIfNotSupported(videoEncoderInfoImpl, mediaFormat);
            this.mEncoderInfo = videoEncoderInfoImpl;
        } else {
            throw new InvalidConfigException("Unknown encoder config type");
        }
        String str = this.mTag;
        Logger.d(str, "mInputTimebase = " + inputTimebase);
        String str2 = this.mTag;
        Logger.d(str2, "mMediaFormat = " + mediaFormat);
        try {
            reset();
            AtomicReference atomicReference = new AtomicReference();
            this.mReleasedFuture = Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new i1(atomicReference, 3)));
            this.mReleasedCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
            setState(InternalState.CONFIGURED);
        } catch (MediaCodec.CodecException e) {
            throw new InvalidConfigException((Throwable) e);
        }
    }

    private void addSignalEosTimeoutIfNeeded() {
        if (DeviceQuirks.get(SignalEosOutputBufferNotComeQuirk.class) != null) {
            MediaCodecCallback mediaCodecCallback = this.mMediaCodecCallback;
            Executor executor = this.mEncoderExecutor;
            Future<?> future = this.mSignalEosTimeoutFuture;
            if (future != null) {
                future.cancel(false);
            }
            this.mSignalEosTimeoutFuture = CameraXExecutors.mainThreadExecutor().schedule(new a(0, (Object) executor, (Object) mediaCodecCallback), 1000, TimeUnit.MILLISECONDS);
        }
    }

    private void clampVideoBitrateIfNotSupported(@NonNull VideoEncoderInfo videoEncoderInfo, @NonNull MediaFormat mediaFormat) {
        Preconditions.checkState(this.mIsVideoEncoder);
        if (mediaFormat.containsKey("bitrate")) {
            int integer = mediaFormat.getInteger("bitrate");
            int intValue = videoEncoderInfo.getSupportedBitrateRange().clamp(Integer.valueOf(integer)).intValue();
            if (integer != intValue) {
                mediaFormat.setInteger("bitrate", intValue);
                String str = this.mTag;
                Logger.d(str, "updated bitrate from " + integer + " to " + intValue);
            }
        }
    }

    public static boolean hasEndOfStreamFlag(@NonNull MediaCodec.BufferInfo bufferInfo) {
        if ((bufferInfo.flags & 4) != 0) {
            return true;
        }
        return false;
    }

    private boolean hasStopCodecAfterSurfaceRemovalCrashMediaServerQuirk() {
        if (DeviceQuirks.get(StopCodecAfterSurfaceRemovalCrashMediaServerQuirk.class) != null) {
            return true;
        }
        return false;
    }

    public static boolean isKeyFrame(@NonNull MediaCodec.BufferInfo bufferInfo) {
        if ((bufferInfo.flags & 1) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$acquireInputBuffer$14(CallbackToFutureAdapter.Completer completer) {
        this.mAcquisitionQueue.remove(completer);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addSignalEosTimeoutIfNeeded$9(Executor executor, MediaCodecCallback mediaCodecCallback) {
        Objects.requireNonNull(mediaCodecCallback);
        executor.execute(new b(mediaCodecCallback));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$matchAcquisitionsAndFreeBufferIndexes$15(InputBufferImpl inputBufferImpl) {
        this.mInputBufferSet.remove(inputBufferImpl);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$pause$5(long j) {
        switch (this.mState.ordinal()) {
            case 0:
            case 2:
            case 3:
            case 5:
            case 7:
                return;
            case 1:
                String str = this.mTag;
                Logger.d(str, "Pause on " + DebugUtils.readableUs(j));
                this.mActivePauseResumeTimeRanges.addLast(Range.create(Long.valueOf(j), Long.MAX_VALUE));
                setState(InternalState.PAUSED);
                return;
            case 4:
                setState(InternalState.PENDING_START_PAUSED);
                return;
            case 6:
            case 8:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$6() {
        switch (this.mState.ordinal()) {
            case 0:
            case 1:
            case 2:
            case 7:
                releaseInternal();
                return;
            case 3:
            case 4:
            case 5:
                setState(InternalState.PENDING_RELEASE);
                return;
            case 6:
            case 8:
                return;
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestKeyFrame$8() {
        int ordinal = this.mState.ordinal();
        if (ordinal == 1) {
            requestKeyFrameToMediaCodec();
        } else if (ordinal == 6 || ordinal == 8) {
            throw new IllegalStateException("Encoder is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$signalSourceStopped$7() {
        this.mSourceStoppedSignalled = true;
        if (this.mIsFlushedAfterEndOfStream) {
            this.mMediaCodec.stop();
            reset();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1(long j) {
        boolean z;
        switch (this.mState.ordinal()) {
            case 0:
                this.mLastDataStopTimestamp = null;
                String str = this.mTag;
                Logger.d(str, "Start on " + DebugUtils.readableUs(j));
                try {
                    if (this.mIsFlushedAfterEndOfStream) {
                        reset();
                    }
                    this.mStartStopTimeRangeUs = Range.create(Long.valueOf(j), Long.MAX_VALUE);
                    this.mMediaCodec.start();
                    Encoder.EncoderInput encoderInput = this.mEncoderInput;
                    if (encoderInput instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput).setActive(true);
                    }
                    setState(InternalState.STARTED);
                    return;
                } catch (MediaCodec.CodecException e) {
                    handleEncodeError(e);
                    return;
                }
            case 1:
            case 4:
            case 7:
                return;
            case 2:
                this.mLastDataStopTimestamp = null;
                Range removeLast = this.mActivePauseResumeTimeRanges.removeLast();
                if (removeLast == null || ((Long) removeLast.getUpper()).longValue() != Long.MAX_VALUE) {
                    z = false;
                } else {
                    z = true;
                }
                Preconditions.checkState(z, "There should be a \"pause\" before \"resume\"");
                Long l = (Long) removeLast.getLower();
                long longValue = l.longValue();
                this.mActivePauseResumeTimeRanges.addLast(Range.create(l, Long.valueOf(j)));
                String str2 = this.mTag;
                Logger.d(str2, "Resume on " + DebugUtils.readableUs(j) + "\nPaused duration = " + DebugUtils.readableUs(j - longValue));
                if ((this.mIsVideoEncoder || DeviceQuirks.get(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!this.mIsVideoEncoder || DeviceQuirks.get(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null)) {
                    setMediaCodecPaused(false);
                    Encoder.EncoderInput encoderInput2 = this.mEncoderInput;
                    if (encoderInput2 instanceof ByteBufferInput) {
                        ((ByteBufferInput) encoderInput2).setActive(true);
                    }
                }
                if (this.mIsVideoEncoder) {
                    requestKeyFrameToMediaCodec();
                }
                setState(InternalState.STARTED);
                return;
            case 3:
            case 5:
                setState(InternalState.PENDING_START);
                return;
            case 6:
            case 8:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$2() {
        if (this.mPendingCodecStop) {
            Logger.w(this.mTag, "The data didn't reach the expected timestamp before timeout, stop the codec.");
            this.mLastDataStopTimestamp = null;
            signalCodecStop();
            this.mPendingCodecStop = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$3() {
        this.mEncoderExecutor.execute(new o6(this, 0));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$stop$4(long r8, long r10) {
        /*
            r7 = this;
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r0 = r7.mState
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L_0x00b6;
                case 1: goto L_0x002e;
                case 2: goto L_0x002e;
                case 3: goto L_0x00b6;
                case 4: goto L_0x0027;
                case 5: goto L_0x0027;
                case 6: goto L_0x001f;
                case 7: goto L_0x00b6;
                case 8: goto L_0x001f;
                default: goto L_0x0009;
            }
        L_0x0009:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Unknown state: "
            r9.<init>(r10)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r10 = r7.mState
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x001f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Encoder is released"
            r8.<init>(r9)
            throw r8
        L_0x0027:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r8 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.CONFIGURED
            r7.setState(r8)
            goto L_0x00b6
        L_0x002e:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r0 = r7.mState
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STOPPING
            r7.setState(r1)
            android.util.Range<java.lang.Long> r1 = r7.mStartStopTimeRangeUs
            java.lang.Comparable r1 = r1.getLower()
            java.lang.Long r1 = (java.lang.Long) r1
            long r2 = r1.longValue()
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00ae
            r4 = -1
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0051
            goto L_0x005c
        L_0x0051:
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x005d
            java.lang.String r8 = r7.mTag
            java.lang.String r9 = "The expected stop time is less than the start time. Use current time as stop time."
            androidx.camera.core.Logger.w(r8, r9)
        L_0x005c:
            r8 = r10
        L_0x005d:
            int r10 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r10 < 0) goto L_0x00a6
            java.lang.Long r10 = java.lang.Long.valueOf(r8)
            android.util.Range r10 = android.util.Range.create(r1, r10)
            r7.mStartStopTimeRangeUs = r10
            java.lang.String r10 = r7.mTag
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Stop on "
            r11.<init>(r1)
            java.lang.String r8 = androidx.camera.video.internal.DebugUtils.readableUs(r8)
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            androidx.camera.core.Logger.d(r10, r8)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r8 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PAUSED
            if (r0 != r8) goto L_0x008e
            java.lang.Long r8 = r7.mLastDataStopTimestamp
            if (r8 == 0) goto L_0x008e
            r7.signalCodecStop()
            goto L_0x00b6
        L_0x008e:
            r8 = 1
            r7.mPendingCodecStop = r8
            java.util.concurrent.ScheduledExecutorService r8 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            o6 r9 = new o6
            r10 = 5
            r9.<init>(r7, r10)
            r10 = 1000(0x3e8, double:4.94E-321)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r8 = r8.schedule(r9, r10, r0)
            r7.mStopTimeoutFuture = r8
            goto L_0x00b6
        L_0x00a6:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.String r9 = "The start time should be before the stop time."
            r8.<init>(r9)
            throw r8
        L_0x00ae:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.String r9 = "There should be a \"start\" before \"stop\""
            r8.<init>(r9)
            throw r8
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.encoder.EncoderImpl.lambda$stop$4(long, long):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stopMediaCodec$12(List list, Runnable runnable) {
        if (this.mState != InternalState.ERROR) {
            if (!list.isEmpty()) {
                Logger.d(this.mTag, "encoded data and input buffers are returned");
            }
            if (!(this.mEncoderInput instanceof SurfaceInput) || this.mSourceStoppedSignalled || hasStopCodecAfterSurfaceRemovalCrashMediaServerQuirk()) {
                this.mMediaCodec.stop();
            } else {
                this.mMediaCodec.flush();
                this.mIsFlushedAfterEndOfStream = true;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        handleStopped();
    }

    private void releaseInternal() {
        if (this.mIsFlushedAfterEndOfStream) {
            this.mMediaCodec.stop();
            this.mIsFlushedAfterEndOfStream = false;
        }
        this.mMediaCodec.release();
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).releaseSurface();
        }
        setState(InternalState.RELEASED);
        this.mReleasedCompleter.set(null);
    }

    private void reset() {
        this.mStartStopTimeRangeUs = NO_RANGE;
        this.mTotalPausedDurationUs = 0;
        this.mActivePauseResumeTimeRanges.clear();
        this.mFreeInputBufferIndexQueue.clear();
        for (CallbackToFutureAdapter.Completer<InputBuffer> cancelled : this.mAcquisitionQueue) {
            cancelled.setCancelled();
        }
        this.mAcquisitionQueue.clear();
        this.mMediaCodec.reset();
        this.mIsFlushedAfterEndOfStream = false;
        this.mSourceStoppedSignalled = false;
        this.mMediaCodecEosSignalled = false;
        this.mPendingCodecStop = false;
        Future<?> future = this.mStopTimeoutFuture;
        if (future != null) {
            future.cancel(true);
            this.mStopTimeoutFuture = null;
        }
        Future<?> future2 = this.mSignalEosTimeoutFuture;
        if (future2 != null) {
            future2.cancel(false);
            this.mSignalEosTimeoutFuture = null;
        }
        MediaCodecCallback mediaCodecCallback = this.mMediaCodecCallback;
        if (mediaCodecCallback != null) {
            mediaCodecCallback.stop();
        }
        MediaCodecCallback mediaCodecCallback2 = new MediaCodecCallback();
        this.mMediaCodecCallback = mediaCodecCallback2;
        this.mMediaCodec.setCallback(mediaCodecCallback2);
        this.mMediaCodec.configure(this.mMediaFormat, (Surface) null, (MediaCrypto) null, 1);
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof SurfaceInput) {
            ((SurfaceInput) encoderInput).resetSurface();
        }
    }

    private void setState(InternalState internalState) {
        if (this.mState != internalState) {
            String str = this.mTag;
            Logger.d(str, "Transitioning encoder internal state: " + this.mState + " --> " + internalState);
            this.mState = internalState;
        }
    }

    /* access modifiers changed from: private */
    public void signalEndOfInputStream() {
        Futures.addCallback(acquireInputBuffer(), new FutureCallback<InputBuffer>() {
            public void onFailure(@NonNull Throwable th) {
                EncoderImpl.this.handleEncodeError(0, "Unable to acquire InputBuffer.", th);
            }

            public void onSuccess(InputBuffer inputBuffer) {
                inputBuffer.setPresentationTimeUs(EncoderImpl.this.generatePresentationTimeUs());
                inputBuffer.setEndOfStream(true);
                inputBuffer.submit();
                Futures.addCallback(inputBuffer.getTerminationFuture(), new FutureCallback<Void>() {
                    public void onFailure(@NonNull Throwable th) {
                        if (th instanceof MediaCodec.CodecException) {
                            EncoderImpl.this.handleEncodeError((MediaCodec.CodecException) th);
                        } else {
                            EncoderImpl.this.handleEncodeError(0, th.getMessage(), th);
                        }
                    }

                    public void onSuccess(@Nullable Void voidR) {
                    }
                }, EncoderImpl.this.mEncoderExecutor);
            }
        }, this.mEncoderExecutor);
    }

    @NonNull
    public ListenableFuture<InputBuffer> acquireInputBuffer() {
        switch (this.mState.ordinal()) {
            case 0:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is not started yet."));
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                AtomicReference atomicReference = new AtomicReference();
                ListenableFuture<InputBuffer> future = CallbackToFutureAdapter.getFuture(new i1(atomicReference, 2));
                CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) atomicReference.get());
                this.mAcquisitionQueue.offer(completer);
                completer.addCancellationListener(new e0(24, this, completer), this.mEncoderExecutor);
                matchAcquisitionsAndFreeBufferIndexes();
                return future;
            case 7:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is in error state."));
            case 8:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is released."));
            default:
                throw new IllegalStateException("Unknown state: " + this.mState);
        }
    }

    public long generatePresentationTimeUs() {
        return this.mTimeProvider.uptimeUs();
    }

    public long getAdjustedTimeUs(@NonNull MediaCodec.BufferInfo bufferInfo) {
        long j = this.mTotalPausedDurationUs;
        if (j > 0) {
            return bufferInfo.presentationTimeUs - j;
        }
        return bufferInfo.presentationTimeUs;
    }

    public int getConfiguredBitrate() {
        if (this.mMediaFormat.containsKey("bitrate")) {
            return this.mMediaFormat.getInteger("bitrate");
        }
        return 0;
    }

    @NonNull
    public EncoderInfo getEncoderInfo() {
        return this.mEncoderInfo;
    }

    @NonNull
    public Encoder.EncoderInput getInput() {
        return this.mEncoderInput;
    }

    @NonNull
    public ListenableFuture<Void> getReleasedFuture() {
        return this.mReleasedFuture;
    }

    public void handleEncodeError(@NonNull MediaCodec.CodecException codecException) {
        handleEncodeError(1, codecException.getMessage(), codecException);
    }

    public void handleStopped() {
        InternalState internalState = this.mState;
        if (internalState == InternalState.PENDING_RELEASE) {
            releaseInternal();
            return;
        }
        if (!this.mIsFlushedAfterEndOfStream) {
            reset();
        }
        setState(InternalState.CONFIGURED);
        if (internalState == InternalState.PENDING_START || internalState == InternalState.PENDING_START_PAUSED) {
            start();
            if (internalState == InternalState.PENDING_START_PAUSED) {
                pause();
            }
        }
    }

    public boolean isInPauseRange(long j) {
        for (Range next : this.mActivePauseResumeTimeRanges) {
            if (!next.contains(Long.valueOf(j))) {
                if (j < ((Long) next.getLower()).longValue()) {
                    break;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public void matchAcquisitionsAndFreeBufferIndexes() {
        while (!this.mAcquisitionQueue.isEmpty() && !this.mFreeInputBufferIndexQueue.isEmpty()) {
            CallbackToFutureAdapter.Completer poll = this.mAcquisitionQueue.poll();
            Objects.requireNonNull(poll);
            Integer poll2 = this.mFreeInputBufferIndexQueue.poll();
            Objects.requireNonNull(poll2);
            try {
                InputBufferImpl inputBufferImpl = new InputBufferImpl(this.mMediaCodec, poll2.intValue());
                if (poll.set(inputBufferImpl)) {
                    this.mInputBufferSet.add(inputBufferImpl);
                    inputBufferImpl.getTerminationFuture().addListener(new a(1, (Object) this, (Object) inputBufferImpl), this.mEncoderExecutor);
                } else {
                    inputBufferImpl.cancel();
                }
            } catch (MediaCodec.CodecException e) {
                handleEncodeError(e);
                return;
            }
        }
    }

    /* renamed from: notifyError */
    public void lambda$handleEncodeError$10(int i, @Nullable String str, @Nullable Throwable th) {
        EncoderCallback encoderCallback;
        Executor executor;
        synchronized (this.mLock) {
            encoderCallback = this.mEncoderCallback;
            executor = this.mEncoderCallbackExecutor;
        }
        try {
            executor.execute(new l6(encoderCallback, i, str, th, 0));
        } catch (RejectedExecutionException e) {
            Logger.e(this.mTag, "Unable to post to the supplied executor.", e);
        }
    }

    public void pause() {
        this.mEncoderExecutor.execute(new m6(this, generatePresentationTimeUs(), 1));
    }

    public void release() {
        this.mEncoderExecutor.execute(new o6(this, 1));
    }

    public void requestKeyFrame() {
        this.mEncoderExecutor.execute(new o6(this, 2));
    }

    public void requestKeyFrameToMediaCodec() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.mMediaCodec.setParameters(bundle);
    }

    public void setEncoderCallback(@NonNull EncoderCallback encoderCallback, @NonNull Executor executor) {
        synchronized (this.mLock) {
            this.mEncoderCallback = encoderCallback;
            this.mEncoderCallbackExecutor = executor;
        }
    }

    public void setMediaCodecPaused(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putInt("drop-input-frames", z ? 1 : 0);
        this.mMediaCodec.setParameters(bundle);
    }

    public void signalCodecStop() {
        Logger.d(this.mTag, "signalCodecStop");
        Encoder.EncoderInput encoderInput = this.mEncoderInput;
        if (encoderInput instanceof ByteBufferInput) {
            ((ByteBufferInput) encoderInput).setActive(false);
            ArrayList arrayList = new ArrayList();
            for (InputBuffer terminationFuture : this.mInputBufferSet) {
                arrayList.add(terminationFuture.getTerminationFuture());
            }
            Futures.successfulAsList(arrayList).addListener(new o6(this, 4), this.mEncoderExecutor);
        } else if (encoderInput instanceof SurfaceInput) {
            try {
                addSignalEosTimeoutIfNeeded();
                this.mMediaCodec.signalEndOfInputStream();
                this.mMediaCodecEosSignalled = true;
            } catch (MediaCodec.CodecException e) {
                handleEncodeError(e);
            }
        }
    }

    public void signalSourceStopped() {
        this.mEncoderExecutor.execute(new o6(this, 3));
    }

    public void start() {
        this.mEncoderExecutor.execute(new m6(this, generatePresentationTimeUs(), 0));
    }

    public void stop() {
        stop(-1);
    }

    public void stopMediaCodec(@Nullable Runnable runnable) {
        Logger.d(this.mTag, "stopMediaCodec");
        ArrayList arrayList = new ArrayList();
        for (EncodedDataImpl closedFuture : this.mEncodedDataSet) {
            arrayList.add(closedFuture.getClosedFuture());
        }
        for (InputBuffer terminationFuture : this.mInputBufferSet) {
            arrayList.add(terminationFuture.getTerminationFuture());
        }
        if (!arrayList.isEmpty()) {
            String str = this.mTag;
            Logger.d(str, "Waiting for resources to return. encoded data = " + this.mEncodedDataSet.size() + ", input buffers = " + this.mInputBufferSet.size());
        }
        Futures.successfulAsList(arrayList).addListener(new m0(this, 7, arrayList, runnable), this.mEncoderExecutor);
    }

    public void updateTotalPausedDuration(long j) {
        while (!this.mActivePauseResumeTimeRanges.isEmpty()) {
            Range first = this.mActivePauseResumeTimeRanges.getFirst();
            if (j > ((Long) first.getUpper()).longValue()) {
                this.mActivePauseResumeTimeRanges.removeFirst();
                this.mTotalPausedDurationUs = (((Long) first.getUpper()).longValue() - ((Long) first.getLower()).longValue()) + this.mTotalPausedDurationUs;
                String str = this.mTag;
                Logger.d(str, "Total paused duration = " + DebugUtils.readableUs(this.mTotalPausedDurationUs));
            } else {
                return;
            }
        }
    }

    public void handleEncodeError(int i, @Nullable String str, @Nullable Throwable th) {
        switch (this.mState.ordinal()) {
            case 0:
                lambda$handleEncodeError$10(i, str, th);
                reset();
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                setState(InternalState.ERROR);
                stopMediaCodec(new l6(this, i, str, th, 1));
                return;
            case 7:
                String str2 = this.mTag;
                Logger.w(str2, "Get more than one error: " + str + "(" + i + ")", th);
                return;
            default:
                return;
        }
    }

    public void stop(long j) {
        this.mEncoderExecutor.execute(new n6(this, j, generatePresentationTimeUs()));
    }
}
