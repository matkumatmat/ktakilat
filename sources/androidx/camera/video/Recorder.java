package androidx.camera.video;

import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.MediaMuxer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.MutableStateObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.utils.ArrayRingBuffer;
import androidx.camera.core.internal.utils.RingBuffer;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.StreamInfo;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.VideoRecordEvent;
import androidx.camera.video.internal.DebugUtils;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioSourceAccessException;
import androidx.camera.video.internal.compat.Api26Impl;
import androidx.camera.video.internal.compat.quirk.DeactivateEncoderSurfaceBeforeStopEncoderQuirk;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.config.AudioConfigUtil;
import androidx.camera.video.internal.config.AudioMimeInfo;
import androidx.camera.video.internal.encoder.BufferCopiedEncodedData;
import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncodedData;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderCallback;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.OutputConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.camera.video.internal.encoder.VideoEncoderInfoImpl;
import androidx.camera.video.internal.utils.OutputUtil;
import androidx.camera.video.internal.workaround.CorrectNegativeLatLongForMediaMuxer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.location.LocationRequestCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class Recorder implements VideoOutput {
    private static final int AUDIO_CACHE_SIZE = 60;
    private static final Executor AUDIO_EXECUTOR = CameraXExecutors.newSequentialExecutor(CameraXExecutors.ioExecutor());
    @VisibleForTesting
    static final EncoderFactory DEFAULT_ENCODER_FACTORY = new t9(12);
    public static final QualitySelector DEFAULT_QUALITY_SELECTOR;
    private static final String MEDIA_COLUMN = "_data";
    private static final MediaSpec MEDIA_SPEC_DEFAULT;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final Exception PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE = new RuntimeException("The video frame producer became inactive before any data was received.");
    private static final Set<State> PENDING_STATES = Collections.unmodifiableSet(EnumSet.of(State.PENDING_RECORDING, State.PENDING_PAUSED));
    private static final long RETRY_SETUP_VIDEO_DELAY_MS = 1000;
    private static final int RETRY_SETUP_VIDEO_MAX_COUNT = 3;
    private static final long SOURCE_NON_STREAMING_TIMEOUT_MS = 1000;
    private static final String TAG = "Recorder";
    private static final Set<State> VALID_NON_PENDING_STATES_WHILE_PENDING = Collections.unmodifiableSet(EnumSet.of(State.CONFIGURING, State.IDLING, State.RESETTING, State.STOPPING, State.ERROR));
    public static final int VIDEO_CAPABILITIES_SOURCE_CAMCORDER_PROFILE = 0;
    public static final int VIDEO_CAPABILITIES_SOURCE_CODEC_CAPABILITIES = 1;
    private static final VideoSpec VIDEO_SPEC_DEFAULT;
    @VisibleForTesting
    static long sRetrySetupVideoDelayMs = 1000;
    @VisibleForTesting
    static int sRetrySetupVideoMaxCount = 3;
    @GuardedBy("mLock")
    RecordingRecord mActiveRecordingRecord;
    Surface mActiveSurface;
    double mAudioAmplitude;
    Encoder mAudioEncoder;
    private final EncoderFactory mAudioEncoderFactory;
    Throwable mAudioErrorCause;
    OutputConfig mAudioOutputConfig;
    AudioSource mAudioSource;
    AudioState mAudioState;
    Integer mAudioTrackIndex;
    long mDurationLimitNs;
    private final boolean mEncoderNotUsePersistentInputSurface;
    final List<ListenableFuture<Void>> mEncodingFutures;
    /* access modifiers changed from: private */
    public final Executor mExecutor;
    long mFileSizeLimitInBytes;
    @VisibleForTesting
    long mFirstRecordingAudioDataTimeUs;
    @VisibleForTesting
    int mFirstRecordingVideoBitrate;
    @VisibleForTesting
    long mFirstRecordingVideoDataTimeUs;
    RecordingRecord mInProgressRecording;
    boolean mInProgressRecordingStopping;
    @Nullable
    private SurfaceRequest.TransformationInfo mInProgressTransformationInfo;
    boolean mIsAudioSourceSilenced;
    /* access modifiers changed from: private */
    public final MutableStateObservable<Boolean> mIsRecording;
    @GuardedBy("mLock")
    private long mLastGeneratedRecordingId;
    Surface mLatestSurface;
    SurfaceRequest mLatestSurfaceRequest;
    private final Object mLock = new Object();
    MediaMuxer mMediaMuxer;
    final MutableStateObservable<MediaSpec> mMediaSpec;
    private boolean mNeedsResetBeforeNextStart;
    @GuardedBy("mLock")
    private State mNonPendingState;
    @NonNull
    Uri mOutputUri;
    @NonNull
    final RingBuffer<EncodedData> mPendingAudioRingBuffer;
    EncodedData mPendingFirstVideoData;
    @GuardedBy("mLock")
    RecordingRecord mPendingRecordingRecord;
    long mPreviousRecordingAudioDataTimeUs;
    long mPreviousRecordingVideoDataTimeUs;
    long mRecordingBytes;
    long mRecordingDurationNs;
    int mRecordingStopError;
    Throwable mRecordingStopErrorCause;
    /* access modifiers changed from: private */
    public VideoValidatedEncoderProfilesProxy mResolvedEncoderProfiles;
    final Executor mSequentialExecutor;
    @Nullable
    private SetupVideoTask mSetupVideoTask;
    private boolean mShouldSendResumeEvent;
    ScheduledFuture<?> mSourceNonStreamingTimeout;
    VideoOutput.SourceState mSourceState;
    @Nullable
    private SurfaceRequest.TransformationInfo mSourceTransformationInfo;
    @GuardedBy("mLock")
    private State mState;
    @GuardedBy("mLock")
    int mStreamId;
    private final MutableStateObservable<StreamInfo> mStreamInfo;
    private final Executor mUserProvidedExecutor;
    private final int mVideoCapabilitiesSource;
    Encoder mVideoEncoder;
    @VisibleForTesting
    Range<Integer> mVideoEncoderBitrateRange;
    /* access modifiers changed from: private */
    public final EncoderFactory mVideoEncoderFactory;
    @NonNull
    VideoEncoderSession mVideoEncoderSession;
    @Nullable
    VideoEncoderSession mVideoEncoderSessionToRelease;
    OutputConfig mVideoOutputConfig;
    Timebase mVideoSourceTimebase;
    Integer mVideoTrackIndex;

    public enum AudioState {
        INITIALIZING,
        IDLING,
        DISABLED,
        ENABLED,
        ERROR_ENCODER,
        ERROR_SOURCE
    }

    public static final class Builder {
        private EncoderFactory mAudioEncoderFactory;
        private Executor mExecutor = null;
        private final MediaSpec.Builder mMediaSpecBuilder;
        private int mVideoCapabilitiesSource = 0;
        private EncoderFactory mVideoEncoderFactory;

        public Builder() {
            EncoderFactory encoderFactory = Recorder.DEFAULT_ENCODER_FACTORY;
            this.mVideoEncoderFactory = encoderFactory;
            this.mAudioEncoderFactory = encoderFactory;
            this.mMediaSpecBuilder = MediaSpec.builder();
        }

        @NonNull
        public Recorder build() {
            return new Recorder(this.mExecutor, this.mMediaSpecBuilder.build(), this.mVideoCapabilitiesSource, this.mVideoEncoderFactory, this.mAudioEncoderFactory);
        }

        @NonNull
        public Builder setAspectRatio(int i) {
            this.mMediaSpecBuilder.configureVideo(new pd(i, 2));
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setAudioEncoderFactory(@NonNull EncoderFactory encoderFactory) {
            this.mAudioEncoderFactory = encoderFactory;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setAudioSource(int i) {
            this.mMediaSpecBuilder.configureAudio(new pd(i, 1));
            return this;
        }

        @NonNull
        public Builder setExecutor(@NonNull Executor executor) {
            Preconditions.checkNotNull(executor, "The specified executor can't be null.");
            this.mExecutor = executor;
            return this;
        }

        @NonNull
        public Builder setQualitySelector(@NonNull QualitySelector qualitySelector) {
            Preconditions.checkNotNull(qualitySelector, "The specified quality selector can't be null.");
            this.mMediaSpecBuilder.configureVideo(new od(qualitySelector, 1));
            return this;
        }

        @NonNull
        public Builder setTargetVideoEncodingBitRate(@IntRange(from = 1) int i) {
            if (i > 0) {
                this.mMediaSpecBuilder.configureVideo(new pd(i, 0));
                return this;
            }
            throw new IllegalArgumentException(ba.l(i, "The requested target bitrate ", " is not supported. Target bitrate must be greater than 0."));
        }

        @NonNull
        public Builder setVideoCapabilitiesSource(int i) {
            boolean z = true;
            if (!(i == 0 || i == 1)) {
                z = false;
            }
            Preconditions.checkArgument(z, "Not a supported video capabilities source: " + i);
            this.mVideoCapabilitiesSource = i;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder setVideoEncoderFactory(@NonNull EncoderFactory encoderFactory) {
            this.mVideoEncoderFactory = encoderFactory;
            return this;
        }
    }

    @AutoValue
    public static abstract class RecordingRecord implements AutoCloseable {
        private final AtomicReference<AudioSourceSupplier> mAudioSourceSupplier = new AtomicReference<>((Object) null);
        private final CloseGuardHelper mCloseGuard = CloseGuardHelper.create();
        private final AtomicBoolean mInitialized = new AtomicBoolean(false);
        private final AtomicReference<MediaMuxerSupplier> mMediaMuxerSupplier = new AtomicReference<>((Object) null);
        private final AtomicBoolean mMuted = new AtomicBoolean(false);
        private final AtomicReference<Consumer<Uri>> mRecordingFinalizer = new AtomicReference<>(new Object());
        @NonNull
        private final MutableStateObservable<Boolean> mRecordingState = MutableStateObservable.withInitialState(Boolean.FALSE);

        public interface AudioSourceSupplier {
            @RequiresPermission("android.permission.RECORD_AUDIO")
            @NonNull
            AudioSource get(@NonNull AudioSettings audioSettings, @NonNull Executor executor) throws AudioSourceAccessException;
        }

        public interface MediaMuxerSupplier {
            @NonNull
            MediaMuxer get(int i, @NonNull Consumer<Uri> consumer) throws IOException;
        }

        private void finalizeRecordingInternal(@Nullable Consumer<Uri> consumer, @NonNull Uri uri) {
            if (consumer != null) {
                this.mCloseGuard.close();
                consumer.accept(uri);
                return;
            }
            throw new AssertionError("Recording " + this + " has already been finalized");
        }

        @NonNull
        public static RecordingRecord from(@NonNull PendingRecording pendingRecording, long j) {
            return new AutoValue_Recorder_RecordingRecord(pendingRecording.getOutputOptions(), pendingRecording.getListenerExecutor(), pendingRecording.getEventListener(), pendingRecording.isAudioEnabled(), pendingRecording.isPersistent(), j);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaMuxer lambda$initializeRecording$1(OutputOptions outputOptions, ParcelFileDescriptor parcelFileDescriptor, int i, Consumer consumer) throws IOException {
            MediaMuxer mediaMuxer;
            MediaMuxer mediaMuxer2;
            Uri uri = Uri.EMPTY;
            if (outputOptions instanceof FileOutputOptions) {
                File file = ((FileOutputOptions) outputOptions).getFile();
                if (!OutputUtil.createParentFolder(file)) {
                    Logger.w(Recorder.TAG, "Failed to create folder for " + file.getAbsolutePath());
                }
                mediaMuxer = new MediaMuxer(file.getAbsolutePath(), i);
                uri = Uri.fromFile(file);
            } else if (outputOptions instanceof FileDescriptorOutputOptions) {
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaMuxer = Api26Impl.createMediaMuxer(parcelFileDescriptor.getFileDescriptor(), i);
                } else {
                    throw new IOException("MediaMuxer doesn't accept FileDescriptor as output destination.");
                }
            } else if (outputOptions instanceof MediaStoreOutputOptions) {
                MediaStoreOutputOptions mediaStoreOutputOptions = (MediaStoreOutputOptions) outputOptions;
                ContentValues contentValues = new ContentValues(mediaStoreOutputOptions.getContentValues());
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 29) {
                    contentValues.put("is_pending", 1);
                }
                try {
                    Uri insert = mediaStoreOutputOptions.getContentResolver().insert(mediaStoreOutputOptions.getCollectionUri(), contentValues);
                    if (insert != null) {
                        if (i2 < 26) {
                            String absolutePathFromUri = OutputUtil.getAbsolutePathFromUri(mediaStoreOutputOptions.getContentResolver(), insert, Recorder.MEDIA_COLUMN);
                            if (absolutePathFromUri != null) {
                                if (!OutputUtil.createParentFolder(new File(absolutePathFromUri))) {
                                    Logger.w(Recorder.TAG, "Failed to create folder for ".concat(absolutePathFromUri));
                                }
                                mediaMuxer2 = new MediaMuxer(absolutePathFromUri, i);
                            } else {
                                throw new IOException("Unable to get path from uri " + insert);
                            }
                        } else {
                            ParcelFileDescriptor openFileDescriptor = mediaStoreOutputOptions.getContentResolver().openFileDescriptor(insert, "rw");
                            mediaMuxer2 = Api26Impl.createMediaMuxer(openFileDescriptor.getFileDescriptor(), i);
                            openFileDescriptor.close();
                        }
                        uri = insert;
                        mediaMuxer = mediaMuxer2;
                    } else {
                        throw new IOException("Unable to create MediaStore entry.");
                    }
                } catch (RuntimeException e) {
                    throw new IOException("Unable to create MediaStore entry by " + e, e);
                }
            } else {
                throw new AssertionError("Invalid output options type: ".concat(outputOptions.getClass().getSimpleName()));
            }
            consumer.accept(uri);
            return mediaMuxer;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$initializeRecording$2(MediaStoreOutputOptions mediaStoreOutputOptions, Uri uri) {
            if (!uri.equals(Uri.EMPTY)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_pending", 0);
                mediaStoreOutputOptions.getContentResolver().update(uri, contentValues, (String) null, (String[]) null);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$initializeRecording$3(String str, Uri uri) {
            if (uri == null) {
                Logger.e(Recorder.TAG, "File scanning operation failed [path: " + str + "]");
                return;
            }
            Logger.d(Recorder.TAG, String.format("File scan completed successfully [path: %s, URI: %s]", new Object[]{str, uri}));
        }

        /* JADX WARNING: type inference failed for: r3v1, types: [java.lang.Object, android.media.MediaScannerConnection$OnScanCompletedListener] */
        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$initializeRecording$4(MediaStoreOutputOptions mediaStoreOutputOptions, Context context, Uri uri) {
            if (!uri.equals(Uri.EMPTY)) {
                String absolutePathFromUri = OutputUtil.getAbsolutePathFromUri(mediaStoreOutputOptions.getContentResolver(), uri, Recorder.MEDIA_COLUMN);
                if (absolutePathFromUri != null) {
                    MediaScannerConnection.scanFile(context, new String[]{absolutePathFromUri}, (String[]) null, new Object());
                    return;
                }
                Logger.d(Recorder.TAG, "Skipping media scanner scan. Unable to retrieve file path from URI: " + uri);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$initializeRecording$5(ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
                Logger.e(Recorder.TAG, "Failed to close dup'd ParcelFileDescriptor", e);
            }
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$new$0(Uri uri) {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$updateVideoRecordEvent$6(VideoRecordEvent videoRecordEvent) {
            getEventListener().accept(videoRecordEvent);
        }

        private void updateRecordingState(@NonNull VideoRecordEvent videoRecordEvent) {
            if ((videoRecordEvent instanceof VideoRecordEvent.Start) || (videoRecordEvent instanceof VideoRecordEvent.Resume)) {
                this.mRecordingState.setState(Boolean.TRUE);
            } else if ((videoRecordEvent instanceof VideoRecordEvent.Pause) || (videoRecordEvent instanceof VideoRecordEvent.Finalize)) {
                this.mRecordingState.setState(Boolean.FALSE);
            }
        }

        public void close() {
            finalizeRecording(Uri.EMPTY);
        }

        public void finalize() throws Throwable {
            try {
                this.mCloseGuard.warnIfOpen();
                Consumer andSet = this.mRecordingFinalizer.getAndSet((Object) null);
                if (andSet != null) {
                    finalizeRecordingInternal(andSet, Uri.EMPTY);
                }
            } finally {
                super.finalize();
            }
        }

        public void finalizeRecording(@NonNull Uri uri) {
            if (this.mInitialized.get()) {
                finalizeRecordingInternal(this.mRecordingFinalizer.getAndSet((Object) null), uri);
            }
        }

        @Nullable
        public abstract Executor getCallbackExecutor();

        @Nullable
        public abstract Consumer<VideoRecordEvent> getEventListener();

        @NonNull
        public abstract OutputOptions getOutputOptions();

        public abstract long getRecordingId();

        @NonNull
        public StateObservable<Boolean> getRecordingState() {
            return this.mRecordingState;
        }

        public abstract boolean hasAudioEnabled();

        public void initializeRecording(@NonNull final Context context) throws IOException {
            ParcelFileDescriptor parcelFileDescriptor;
            if (!this.mInitialized.getAndSet(true)) {
                OutputOptions outputOptions = getOutputOptions();
                boolean z = outputOptions instanceof FileDescriptorOutputOptions;
                Consumer consumer = null;
                if (z) {
                    parcelFileDescriptor = ((FileDescriptorOutputOptions) outputOptions).getParcelFileDescriptor().dup();
                } else {
                    parcelFileDescriptor = null;
                }
                this.mCloseGuard.open("finalizeRecording");
                this.mMediaMuxerSupplier.set(new f(outputOptions, parcelFileDescriptor));
                if (hasAudioEnabled()) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        this.mAudioSourceSupplier.set(new AudioSourceSupplier() {
                            @RequiresPermission("android.permission.RECORD_AUDIO")
                            @NonNull
                            public AudioSource get(@NonNull AudioSettings audioSettings, @NonNull Executor executor) throws AudioSourceAccessException {
                                return new AudioSource(audioSettings, executor, context);
                            }
                        });
                    } else {
                        this.mAudioSourceSupplier.set(new AudioSourceSupplier() {
                            @RequiresPermission("android.permission.RECORD_AUDIO")
                            @NonNull
                            public AudioSource get(@NonNull AudioSettings audioSettings, @NonNull Executor executor) throws AudioSourceAccessException {
                                return new AudioSource(audioSettings, executor, (Context) null);
                            }
                        });
                    }
                }
                if (outputOptions instanceof MediaStoreOutputOptions) {
                    MediaStoreOutputOptions mediaStoreOutputOptions = (MediaStoreOutputOptions) outputOptions;
                    if (Build.VERSION.SDK_INT >= 29) {
                        consumer = new g(mediaStoreOutputOptions, 0);
                    } else {
                        consumer = new h(context, mediaStoreOutputOptions);
                    }
                } else if (z) {
                    consumer = new g(parcelFileDescriptor, 1);
                }
                if (consumer != null) {
                    this.mRecordingFinalizer.set(consumer);
                    return;
                }
                return;
            }
            throw new AssertionError("Recording " + this + " has already been initialized");
        }

        public boolean isMuted() {
            return this.mMuted.get();
        }

        public abstract boolean isPersistent();

        public void mute(boolean z) {
            this.mMuted.set(z);
        }

        @RequiresPermission("android.permission.RECORD_AUDIO")
        @NonNull
        public AudioSource performOneTimeAudioSourceCreation(@NonNull AudioSettings audioSettings, @NonNull Executor executor) throws AudioSourceAccessException {
            if (hasAudioEnabled()) {
                AudioSourceSupplier andSet = this.mAudioSourceSupplier.getAndSet((Object) null);
                if (andSet != null) {
                    return andSet.get(audioSettings, executor);
                }
                throw new AssertionError("One-time audio source creation has already occurred for recording " + this);
            }
            throw new AssertionError("Recording does not have audio enabled. Unable to create audio source for recording " + this);
        }

        @NonNull
        public MediaMuxer performOneTimeMediaMuxerCreation(int i, @NonNull Consumer<Uri> consumer) throws IOException {
            if (this.mInitialized.get()) {
                MediaMuxerSupplier andSet = this.mMediaMuxerSupplier.getAndSet((Object) null);
                if (andSet != null) {
                    try {
                        return andSet.get(i, consumer);
                    } catch (RuntimeException e) {
                        throw new IOException("Failed to create MediaMuxer by " + e, e);
                    }
                } else {
                    throw new AssertionError("One-time media muxer creation has already occurred for recording " + this);
                }
            } else {
                throw new AssertionError("Recording " + this + " has not been initialized");
            }
        }

        public void updateVideoRecordEvent(@NonNull VideoRecordEvent videoRecordEvent) {
            if (Objects.equals(videoRecordEvent.getOutputOptions(), getOutputOptions())) {
                String concat = "Sending VideoRecordEvent ".concat(videoRecordEvent.getClass().getSimpleName());
                if (videoRecordEvent instanceof VideoRecordEvent.Finalize) {
                    VideoRecordEvent.Finalize finalize = (VideoRecordEvent.Finalize) videoRecordEvent;
                    if (finalize.hasError()) {
                        StringBuilder v = ba.v(concat);
                        String errorToString = VideoRecordEvent.Finalize.errorToString(finalize.getError());
                        v.append(" [error: " + errorToString + "]");
                        concat = v.toString();
                    }
                }
                Logger.d(Recorder.TAG, concat);
                updateRecordingState(videoRecordEvent);
                if (getCallbackExecutor() != null && getEventListener() != null) {
                    try {
                        getCallbackExecutor().execute(new k(0, this, videoRecordEvent));
                    } catch (RejectedExecutionException e) {
                        Logger.e(Recorder.TAG, "The callback executor is invalid.", e);
                    }
                }
            } else {
                throw new AssertionError("Attempted to update event listener with event from incorrect recording [Recording: " + videoRecordEvent.getOutputOptions() + ", Expected: " + getOutputOptions() + "]");
            }
        }
    }

    public class SetupVideoTask {
        /* access modifiers changed from: private */
        public boolean mIsFailedRetryCanceled = false;
        /* access modifiers changed from: private */
        public final int mMaxRetryCount;
        /* access modifiers changed from: private */
        public int mRetryCount = 0;
        /* access modifiers changed from: private */
        @Nullable
        public ScheduledFuture<?> mRetryFuture = null;
        /* access modifiers changed from: private */
        public final SurfaceRequest mSurfaceRequest;
        /* access modifiers changed from: private */
        public final Timebase mTimebase;

        public SetupVideoTask(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase, int i) {
            this.mSurfaceRequest = surfaceRequest;
            this.mTimebase = timebase;
            this.mMaxRetryCount = i;
        }

        public static /* synthetic */ int access$408(SetupVideoTask setupVideoTask) {
            int i = setupVideoTask.mRetryCount;
            setupVideoTask.mRetryCount = i + 1;
            return i;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$setupVideo$0(SurfaceRequest surfaceRequest, Timebase timebase) {
            if (surfaceRequest.isServiced() || (Recorder.this.mVideoEncoderSession.isConfiguredSurfaceRequest(surfaceRequest) && !Recorder.this.isPersistentRecordingInProgress())) {
                Logger.w(Recorder.TAG, "Ignore the SurfaceRequest " + surfaceRequest + " isServiced: " + surfaceRequest.isServiced() + " VideoEncoderSession: " + Recorder.this.mVideoEncoderSession + " has been configured with a persistent in-progress recording.");
                return;
            }
            EncoderFactory access$100 = Recorder.this.mVideoEncoderFactory;
            Recorder recorder = Recorder.this;
            final VideoEncoderSession videoEncoderSession = new VideoEncoderSession(access$100, recorder.mSequentialExecutor, recorder.mExecutor);
            Recorder recorder2 = Recorder.this;
            ListenableFuture<Encoder> configure = videoEncoderSession.configure(surfaceRequest, timebase, (MediaSpec) recorder2.getObservableData(recorder2.mMediaSpec), Recorder.this.mResolvedEncoderProfiles);
            Recorder.this.mVideoEncoderSession = videoEncoderSession;
            Futures.addCallback(configure, new FutureCallback<Encoder>() {
                /* access modifiers changed from: private */
                public /* synthetic */ void lambda$onFailure$0() {
                    if (!SetupVideoTask.this.mIsFailedRetryCanceled) {
                        Logger.d(Recorder.TAG, "Retry setupVideo #" + SetupVideoTask.this.mRetryCount);
                        SetupVideoTask setupVideoTask = SetupVideoTask.this;
                        setupVideoTask.setupVideo(setupVideoTask.mSurfaceRequest, SetupVideoTask.this.mTimebase);
                    }
                }

                public void onFailure(@NonNull Throwable th) {
                    Logger.w(Recorder.TAG, "VideoEncoder Setup error: " + th, th);
                    if (SetupVideoTask.this.mRetryCount < SetupVideoTask.this.mMaxRetryCount) {
                        SetupVideoTask.access$408(SetupVideoTask.this);
                        SetupVideoTask setupVideoTask = SetupVideoTask.this;
                        ScheduledFuture unused = setupVideoTask.mRetryFuture = Recorder.scheduleTask(new m(this, 0), Recorder.this.mSequentialExecutor, Recorder.sRetrySetupVideoDelayMs, TimeUnit.MILLISECONDS);
                        return;
                    }
                    Recorder.this.onEncoderSetupError(th);
                }

                public void onSuccess(@Nullable Encoder encoder) {
                    Logger.d(Recorder.TAG, "VideoEncoder is created. " + encoder);
                    if (encoder != null) {
                        boolean z = false;
                        Preconditions.checkState(Recorder.this.mVideoEncoderSession == videoEncoderSession);
                        if (Recorder.this.mVideoEncoder == null) {
                            z = true;
                        }
                        Preconditions.checkState(z);
                        Recorder.this.onVideoEncoderReady(videoEncoderSession);
                        Recorder.this.onConfigured();
                    }
                }
            }, Recorder.this.mSequentialExecutor);
        }

        /* access modifiers changed from: private */
        public void setupVideo(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
            Recorder.this.safeToCloseVideoEncoder().addListener(new l(this, surfaceRequest, timebase), Recorder.this.mSequentialExecutor);
        }

        public void cancelFailedRetry() {
            if (!this.mIsFailedRetryCanceled) {
                this.mIsFailedRetryCanceled = true;
                ScheduledFuture<?> scheduledFuture = this.mRetryFuture;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    this.mRetryFuture = null;
                }
            }
        }

        public void start() {
            setupVideo(this.mSurfaceRequest, this.mTimebase);
        }
    }

    public enum State {
        CONFIGURING,
        PENDING_RECORDING,
        PENDING_PAUSED,
        IDLING,
        RECORDING,
        PAUSED,
        STOPPING,
        RESETTING,
        ERROR
    }

    static {
        Quality quality = Quality.FHD;
        QualitySelector fromOrderedList = QualitySelector.fromOrderedList(Arrays.asList(new Quality[]{quality, Quality.HD, Quality.SD}), FallbackStrategy.higherQualityOrLowerThan(quality));
        DEFAULT_QUALITY_SELECTOR = fromOrderedList;
        VideoSpec build = VideoSpec.builder().setQualitySelector(fromOrderedList).setAspectRatio(-1).build();
        VIDEO_SPEC_DEFAULT = build;
        MEDIA_SPEC_DEFAULT = MediaSpec.builder().setOutputFormat(-1).setVideoSpec(build).build();
    }

    public Recorder(@Nullable Executor executor, @NonNull MediaSpec mediaSpec, int i, @NonNull EncoderFactory encoderFactory, @NonNull EncoderFactory encoderFactory2) {
        boolean z;
        if (DeviceQuirks.get(EncoderNotUsePersistentInputSurfaceQuirk.class) != null) {
            z = true;
        } else {
            z = false;
        }
        this.mEncoderNotUsePersistentInputSurface = z;
        this.mState = State.CONFIGURING;
        this.mNonPendingState = null;
        this.mStreamId = 0;
        this.mActiveRecordingRecord = null;
        this.mPendingRecordingRecord = null;
        this.mLastGeneratedRecordingId = 0;
        this.mInProgressRecording = null;
        this.mInProgressRecordingStopping = false;
        this.mInProgressTransformationInfo = null;
        this.mSourceTransformationInfo = null;
        this.mResolvedEncoderProfiles = null;
        this.mEncodingFutures = new ArrayList();
        this.mAudioTrackIndex = null;
        this.mVideoTrackIndex = null;
        this.mLatestSurface = null;
        this.mActiveSurface = null;
        this.mMediaMuxer = null;
        this.mAudioSource = null;
        this.mVideoEncoder = null;
        this.mVideoOutputConfig = null;
        this.mAudioEncoder = null;
        this.mAudioOutputConfig = null;
        this.mAudioState = AudioState.INITIALIZING;
        this.mOutputUri = Uri.EMPTY;
        this.mRecordingBytes = 0;
        this.mRecordingDurationNs = 0;
        this.mFirstRecordingVideoDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
        this.mFirstRecordingVideoBitrate = 0;
        this.mVideoEncoderBitrateRange = null;
        this.mFirstRecordingAudioDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
        this.mPreviousRecordingVideoDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
        this.mPreviousRecordingAudioDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
        this.mFileSizeLimitInBytes = 0;
        this.mDurationLimitNs = 0;
        this.mRecordingStopError = 1;
        this.mRecordingStopErrorCause = null;
        this.mPendingFirstVideoData = null;
        this.mPendingAudioRingBuffer = new ArrayRingBuffer(60);
        this.mAudioErrorCause = null;
        this.mIsAudioSourceSilenced = false;
        this.mSourceState = VideoOutput.SourceState.INACTIVE;
        this.mSourceNonStreamingTimeout = null;
        this.mNeedsResetBeforeNextStart = false;
        this.mVideoEncoderSessionToRelease = null;
        this.mAudioAmplitude = 0.0d;
        this.mShouldSendResumeEvent = false;
        this.mSetupVideoTask = null;
        this.mUserProvidedExecutor = executor;
        executor = executor == null ? CameraXExecutors.ioExecutor() : executor;
        this.mExecutor = executor;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mSequentialExecutor = newSequentialExecutor;
        this.mMediaSpec = MutableStateObservable.withInitialState(composeRecorderMediaSpec(mediaSpec));
        this.mVideoCapabilitiesSource = i;
        this.mStreamInfo = MutableStateObservable.withInitialState(StreamInfo.of(this.mStreamId, internalStateToStreamState(this.mState)));
        this.mIsRecording = MutableStateObservable.withInitialState(Boolean.FALSE);
        this.mVideoEncoderFactory = encoderFactory;
        this.mAudioEncoderFactory = encoderFactory2;
        this.mVideoEncoderSession = new VideoEncoderSession(encoderFactory, newSequentialExecutor, executor);
    }

    private void clearPendingAudioRingBuffer() {
        while (!this.mPendingAudioRingBuffer.isEmpty()) {
            this.mPendingAudioRingBuffer.dequeue();
        }
    }

    @NonNull
    private MediaSpec composeRecorderMediaSpec(@NonNull MediaSpec mediaSpec) {
        MediaSpec.Builder builder = mediaSpec.toBuilder();
        if (mediaSpec.getVideoSpec().getAspectRatio() == -1) {
            builder.configureVideo(new k5(7));
        }
        return builder.build();
    }

    private void configureInternal(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase, boolean z) {
        int i;
        if (surfaceRequest.isServiced()) {
            Logger.w(TAG, "Ignore the SurfaceRequest since it is already served.");
            return;
        }
        surfaceRequest.setTransformationInfoListener(this.mSequentialExecutor, new lb(this, 13));
        Size resolution = surfaceRequest.getResolution();
        DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
        VideoCapabilities videoCapabilities = getVideoCapabilities(surfaceRequest.getCamera().getCameraInfo());
        Quality findNearestHigherSupportedQualityFor = videoCapabilities.findNearestHigherSupportedQualityFor(resolution, dynamicRange);
        Logger.d(TAG, "Using supported quality of " + findNearestHigherSupportedQualityFor + " for surface size " + resolution);
        if (findNearestHigherSupportedQualityFor != Quality.NONE) {
            VideoValidatedEncoderProfilesProxy profiles = videoCapabilities.getProfiles(findNearestHigherSupportedQualityFor, dynamicRange);
            this.mResolvedEncoderProfiles = profiles;
            if (profiles == null) {
                throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles  for advertised quality.");
            }
        }
        SetupVideoTask setupVideoTask = this.mSetupVideoTask;
        if (setupVideoTask != null) {
            setupVideoTask.cancelFailedRetry();
        }
        if (z) {
            i = sRetrySetupVideoMaxCount;
        } else {
            i = 0;
        }
        SetupVideoTask setupVideoTask2 = new SetupVideoTask(surfaceRequest, timebase, i);
        this.mSetupVideoTask = setupVideoTask2;
        setupVideoTask2.start();
    }

    private void finalizePendingRecording(@NonNull RecordingRecord recordingRecord, int i, @Nullable Throwable th) {
        Uri uri = Uri.EMPTY;
        recordingRecord.finalizeRecording(uri);
        recordingRecord.updateVideoRecordEvent(VideoRecordEvent.finalizeWithError(recordingRecord.getOutputOptions(), RecordingStats.of(0, 0, AudioStats.of(1, this.mAudioErrorCause, 0.0d)), OutputResults.of(uri), i, th));
    }

    @NonNull
    private List<EncodedData> getAudioDataToWriteAndClearCache(long j) {
        ArrayList arrayList = new ArrayList();
        while (!this.mPendingAudioRingBuffer.isEmpty()) {
            EncodedData dequeue = this.mPendingAudioRingBuffer.dequeue();
            if (dequeue.getPresentationTimeUs() >= j) {
                arrayList.add(dequeue);
            }
        }
        return arrayList;
    }

    @NonNull
    public static VideoCapabilities getVideoCapabilities(@NonNull CameraInfo cameraInfo) {
        return getVideoCapabilities(cameraInfo, 0);
    }

    private int internalAudioStateToAudioStatsState(@NonNull AudioState audioState) {
        int ordinal = audioState.ordinal();
        if (ordinal == 0 || ordinal == 2) {
            return 1;
        }
        if (ordinal == 3) {
            RecordingRecord recordingRecord = this.mInProgressRecording;
            if (recordingRecord != null && recordingRecord.isMuted()) {
                return 5;
            }
            if (this.mIsAudioSourceSilenced) {
                return 2;
            }
            return 0;
        } else if (ordinal == 4) {
            return 3;
        } else {
            if (ordinal == 5) {
                return 4;
            }
            throw new AssertionError("Invalid internal audio state: " + audioState);
        }
    }

    @NonNull
    private StreamInfo.StreamState internalStateToStreamState(@NonNull State state) {
        DeactivateEncoderSurfaceBeforeStopEncoderQuirk deactivateEncoderSurfaceBeforeStopEncoderQuirk = (DeactivateEncoderSurfaceBeforeStopEncoderQuirk) DeviceQuirks.get(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class);
        if (state == State.RECORDING || (state == State.STOPPING && deactivateEncoderSurfaceBeforeStopEncoderQuirk == null)) {
            return StreamInfo.StreamState.ACTIVE;
        }
        return StreamInfo.StreamState.INACTIVE;
    }

    private static boolean isSameRecording(@NonNull Recording recording, @Nullable RecordingRecord recordingRecord) {
        if (recordingRecord != null && recording.getRecordingId() == recordingRecord.getRecordingId()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$configureInternal$7(SurfaceRequest.TransformationInfo transformationInfo) {
        this.mSourceTransformationInfo = transformationInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAndStartMediaMuxer$9(Uri uri) {
        this.mOutputUri = uri;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$2() {
        SurfaceRequest surfaceRequest = this.mLatestSurfaceRequest;
        if (surfaceRequest != null) {
            configureInternal(surfaceRequest, this.mVideoSourceTimebase, false);
            return;
        }
        throw new AssertionError("surface request is required to retry initialization.");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopInternal$13(Encoder encoder) {
        Logger.d(TAG, "The source didn't become non-streaming before timeout. Waited 1000ms");
        if (DeviceQuirks.get(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class) != null) {
            notifyEncoderSourceStopped(encoder);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateEncoderCallbacks$10(final RecordingRecord recordingRecord, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mVideoEncoder.setEncoderCallback(new EncoderCallback() {
            public void onEncodeError(@NonNull EncodeException encodeException) {
                completer.setException(encodeException);
            }

            public final /* synthetic */ void onEncodePaused() {
                k6.a(this);
            }

            public void onEncodeStart() {
            }

            public void onEncodeStop() {
                completer.set(null);
            }

            public void onEncodedData(@NonNull EncodedData encodedData) {
                boolean z;
                Recorder recorder = Recorder.this;
                if (recorder.mMediaMuxer != null) {
                    try {
                        recorder.writeVideoData(encodedData, recordingRecord);
                        if (encodedData != null) {
                            encodedData.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else if (!recorder.mInProgressRecordingStopping) {
                    EncodedData encodedData2 = recorder.mPendingFirstVideoData;
                    if (encodedData2 != null) {
                        encodedData2.close();
                        Recorder.this.mPendingFirstVideoData = null;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (encodedData.isKeyFrame()) {
                        Recorder recorder2 = Recorder.this;
                        recorder2.mPendingFirstVideoData = encodedData;
                        if (!recorder2.isAudioEnabled() || !Recorder.this.mPendingAudioRingBuffer.isEmpty()) {
                            Logger.d(Recorder.TAG, "Received video keyframe. Starting muxer...");
                            Recorder.this.setupAndStartMediaMuxer(recordingRecord);
                            return;
                        } else if (z) {
                            Logger.d(Recorder.TAG, "Replaced cached video keyframe with newer keyframe.");
                            return;
                        } else {
                            Logger.d(Recorder.TAG, "Cached video keyframe while we wait for first audio sample before starting muxer.");
                            return;
                        }
                    } else {
                        if (z) {
                            Logger.d(Recorder.TAG, "Dropped cached keyframe since we have new video data and have not yet received audio data.");
                        }
                        Logger.d(Recorder.TAG, "Dropped video data since muxer has not yet started and data is not a keyframe.");
                        Recorder.this.mVideoEncoder.requestKeyFrame();
                        encodedData.close();
                        return;
                    }
                } else {
                    Logger.d(Recorder.TAG, "Drop video data since recording is stopping.");
                    encodedData.close();
                    return;
                }
                throw th;
            }

            public void onOutputConfigUpdate(@NonNull OutputConfig outputConfig) {
                Recorder.this.mVideoOutputConfig = outputConfig;
            }
        }, this.mSequentialExecutor);
        return "videoEncodingFuture";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateEncoderCallbacks$11(CallbackToFutureAdapter.Completer completer, Throwable th) {
        if (this.mAudioErrorCause == null) {
            if (th instanceof EncodeException) {
                setAudioState(AudioState.ERROR_ENCODER);
            } else {
                setAudioState(AudioState.ERROR_SOURCE);
            }
            this.mAudioErrorCause = th;
            updateInProgressStatusEvent();
            completer.set(null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateEncoderCallbacks$12(final RecordingRecord recordingRecord, final CallbackToFutureAdapter.Completer completer) throws Exception {
        final q2 q2Var = new q2(3, this, completer);
        this.mAudioSource.setAudioSourceCallback(this.mSequentialExecutor, new AudioSource.AudioSourceCallback() {
            public void onAmplitudeValue(double d) {
                Recorder.this.mAudioAmplitude = d;
            }

            public void onError(@NonNull Throwable th) {
                Logger.e(Recorder.TAG, "Error occurred after audio source started.", th);
                if (th instanceof AudioSourceAccessException) {
                    q2Var.accept(th);
                }
            }

            public void onSilenceStateChanged(boolean z) {
                Recorder recorder = Recorder.this;
                if (recorder.mIsAudioSourceSilenced != z) {
                    recorder.mIsAudioSourceSilenced = z;
                    recorder.updateInProgressStatusEvent();
                    return;
                }
                Logger.w(Recorder.TAG, "Audio source silenced transitions to the same state " + z);
            }

            public final /* synthetic */ void onSuspendStateChanged(boolean z) {
                n0.a(this, z);
            }
        });
        this.mAudioEncoder.setEncoderCallback(new EncoderCallback() {
            public void onEncodeError(@NonNull EncodeException encodeException) {
                if (Recorder.this.mAudioErrorCause == null) {
                    q2Var.accept(encodeException);
                }
            }

            public final /* synthetic */ void onEncodePaused() {
                k6.a(this);
            }

            public void onEncodeStart() {
            }

            public void onEncodeStop() {
                completer.set(null);
            }

            public void onEncodedData(@NonNull EncodedData encodedData) {
                Recorder recorder = Recorder.this;
                if (recorder.mAudioState == AudioState.DISABLED) {
                    encodedData.close();
                    throw new AssertionError("Audio is not enabled but audio encoded data is being produced.");
                } else if (recorder.mMediaMuxer == null) {
                    if (!recorder.mInProgressRecordingStopping) {
                        recorder.mPendingAudioRingBuffer.enqueue(new BufferCopiedEncodedData(encodedData));
                        if (Recorder.this.mPendingFirstVideoData != null) {
                            Logger.d(Recorder.TAG, "Received audio data. Starting muxer...");
                            Recorder.this.setupAndStartMediaMuxer(recordingRecord);
                        } else {
                            Logger.d(Recorder.TAG, "Cached audio data while we wait for video keyframe before starting muxer.");
                        }
                    } else {
                        Logger.d(Recorder.TAG, "Drop audio data since recording is stopping.");
                    }
                    encodedData.close();
                    return;
                } else {
                    try {
                        recorder.writeAudioData(encodedData, recordingRecord);
                        if (encodedData != null) {
                            encodedData.close();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
                throw th;
            }

            public void onOutputConfigUpdate(@NonNull OutputConfig outputConfig) {
                Recorder.this.mAudioOutputConfig = outputConfig;
            }
        }, this.mSequentialExecutor);
        return "audioEncodingFuture";
    }

    @GuardedBy("mLock")
    @NonNull
    private RecordingRecord makePendingRecordingActiveLocked(@NonNull State state) {
        boolean z;
        if (state == State.PENDING_PAUSED) {
            z = true;
        } else if (state == State.PENDING_RECORDING) {
            z = false;
        } else {
            throw new AssertionError("makePendingRecordingActiveLocked() can only be called from a pending state.");
        }
        if (this.mActiveRecordingRecord == null) {
            RecordingRecord recordingRecord = this.mPendingRecordingRecord;
            if (recordingRecord != null) {
                this.mActiveRecordingRecord = recordingRecord;
                recordingRecord.getRecordingState().addObserver(CameraXExecutors.directExecutor(), new Observable.Observer<Boolean>() {
                    public void onError(@NonNull Throwable th) {
                        Recorder.this.mIsRecording.setError(th);
                    }

                    public void onNewData(@Nullable Boolean bool) {
                        Recorder.this.mIsRecording.setState(bool);
                    }
                });
                this.mPendingRecordingRecord = null;
                if (z) {
                    setState(State.PAUSED);
                } else {
                    setState(State.RECORDING);
                }
                return recordingRecord;
            }
            throw new AssertionError("Pending recording should exist when in a PENDING state.");
        }
        throw new AssertionError("Cannot make pending recording active because another recording is already active.");
    }

    /* access modifiers changed from: private */
    /* renamed from: muteInternal */
    public void lambda$mute$6(@NonNull RecordingRecord recordingRecord, boolean z) {
        AudioSource audioSource;
        if (recordingRecord.isMuted() != z) {
            recordingRecord.mute(z);
            if (this.mInProgressRecording == recordingRecord && !this.mInProgressRecordingStopping && (audioSource = this.mAudioSource) != null) {
                audioSource.mute(z);
            }
        }
    }

    public static void notifyEncoderSourceStopped(@NonNull Encoder encoder) {
        if (encoder instanceof EncoderImpl) {
            ((EncoderImpl) encoder).signalSourceStopped();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.camera.video.Recorder$RecordingRecord} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: androidx.camera.video.Recorder$RecordingRecord} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: androidx.camera.video.Recorder$RecordingRecord} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: androidx.camera.video.Recorder$RecordingRecord} */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        r6 = false;
        r7 = 0;
        r3 = r2;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
        r2 = null;
        r3 = null;
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r5 = false;
        r6 = false;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006f, code lost:
        if (r8.mSourceState != androidx.camera.video.VideoOutput.SourceState.INACTIVE) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0071, code lost:
        r2 = r8.mPendingRecordingRecord;
        r8.mPendingRecordingRecord = null;
        setState(androidx.camera.video.Recorder.State.CONFIGURING);
        r3 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
        r5 = false;
        r6 = false;
        r7 = 4;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
        if (r8.mEncoderNotUsePersistentInputSurface == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0085, code lost:
        r8.mActiveSurface = null;
        r2 = r8.mLatestSurfaceRequest;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        if (r2 == null) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        if (r2.isServiced() != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0093, code lost:
        updateNonPendingState(androidx.camera.video.Recorder.State.CONFIGURING);
        r2 = null;
        r5 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009d, code lost:
        if (r8.mVideoEncoder == null) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x009f, code lost:
        r3 = null;
        r5 = false;
        r6 = false;
        r7 = 0;
        r9 = makePendingRecordingActiveLocked(r8.mState);
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ac, code lost:
        r2 = null;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        r7 = 0;
        r2 = r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onRecordingFinalized(@androidx.annotation.NonNull androidx.camera.video.Recorder.RecordingRecord r9) {
        /*
            r8 = this;
            java.lang.String r0 = "Unexpected state on finalize of recording: "
            java.lang.Object r1 = r8.mLock
            monitor-enter(r1)
            androidx.camera.video.Recorder$RecordingRecord r2 = r8.mActiveRecordingRecord     // Catch:{ all -> 0x0038 }
            if (r2 != r9) goto L_0x00d8
            androidx.camera.core.impl.StateObservable r9 = r2.getRecordingState()     // Catch:{ all -> 0x0038 }
            r9.removeObservers()     // Catch:{ all -> 0x0038 }
            r9 = 0
            r8.mActiveRecordingRecord = r9     // Catch:{ all -> 0x0038 }
            androidx.camera.video.Recorder$State r2 = r8.mState     // Catch:{ all -> 0x0038 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0038 }
            r3 = 1
            r4 = 0
            switch(r2) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0068;
                case 3: goto L_0x0054;
                case 4: goto L_0x0027;
                case 5: goto L_0x0027;
                case 6: goto L_0x0027;
                case 7: goto L_0x001f;
                default: goto L_0x001e;
            }     // Catch:{ all -> 0x0038 }
        L_0x001e:
            goto L_0x004e
        L_0x001f:
            r2 = r9
            r3 = r2
            r0 = 0
            r5 = 0
            r6 = 1
        L_0x0024:
            r7 = 0
            goto L_0x00af
        L_0x0027:
            boolean r0 = r8.mEncoderNotUsePersistentInputSurface     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x0049
            r8.mActiveSurface = r9     // Catch:{ all -> 0x0038 }
            androidx.camera.core.SurfaceRequest r0 = r8.mLatestSurfaceRequest     // Catch:{ all -> 0x0038 }
            if (r0 == 0) goto L_0x003b
            boolean r0 = r0.isServiced()     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x003b
            goto L_0x003c
        L_0x0038:
            r9 = move-exception
            goto L_0x00e0
        L_0x003b:
            r3 = 0
        L_0x003c:
            androidx.camera.video.Recorder$State r0 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x0038 }
            r8.setState(r0)     // Catch:{ all -> 0x0038 }
            r2 = r9
            r5 = r3
            r0 = 0
        L_0x0044:
            r6 = 0
            r7 = 0
            r3 = r2
            goto L_0x00af
        L_0x0049:
            androidx.camera.video.Recorder$State r0 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x0038 }
            r8.setState(r0)     // Catch:{ all -> 0x0038 }
        L_0x004e:
            r2 = r9
            r3 = r2
            r0 = 0
        L_0x0051:
            r5 = 0
            r6 = 0
            goto L_0x0024
        L_0x0054:
            java.lang.AssertionError r9 = new java.lang.AssertionError     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r2.<init>(r0)     // Catch:{ all -> 0x0038 }
            androidx.camera.video.Recorder$State r0 = r8.mState     // Catch:{ all -> 0x0038 }
            r2.append(r0)     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0038 }
            r9.<init>(r0)     // Catch:{ all -> 0x0038 }
            throw r9     // Catch:{ all -> 0x0038 }
        L_0x0068:
            r0 = 1
            goto L_0x006b
        L_0x006a:
            r0 = 0
        L_0x006b:
            androidx.camera.video.VideoOutput$SourceState r2 = r8.mSourceState     // Catch:{ all -> 0x0038 }
            androidx.camera.video.VideoOutput$SourceState r5 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x0038 }
            if (r2 != r5) goto L_0x0081
            androidx.camera.video.Recorder$RecordingRecord r2 = r8.mPendingRecordingRecord     // Catch:{ all -> 0x0038 }
            r8.mPendingRecordingRecord = r9     // Catch:{ all -> 0x0038 }
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x0038 }
            r8.setState(r3)     // Catch:{ all -> 0x0038 }
            java.lang.Exception r3 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE     // Catch:{ all -> 0x0038 }
            r5 = 4
            r5 = 0
            r6 = 0
            r7 = 4
            goto L_0x00af
        L_0x0081:
            boolean r2 = r8.mEncoderNotUsePersistentInputSurface     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x009b
            r8.mActiveSurface = r9     // Catch:{ all -> 0x0038 }
            androidx.camera.core.SurfaceRequest r2 = r8.mLatestSurfaceRequest     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x0092
            boolean r2 = r2.isServiced()     // Catch:{ all -> 0x0038 }
            if (r2 != 0) goto L_0x0092
            goto L_0x0093
        L_0x0092:
            r3 = 0
        L_0x0093:
            androidx.camera.video.Recorder$State r2 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x0038 }
            r8.updateNonPendingState(r2)     // Catch:{ all -> 0x0038 }
            r2 = r9
            r5 = r3
            goto L_0x0044
        L_0x009b:
            androidx.camera.video.internal.encoder.Encoder r2 = r8.mVideoEncoder     // Catch:{ all -> 0x0038 }
            if (r2 == 0) goto L_0x00ac
            androidx.camera.video.Recorder$State r2 = r8.mState     // Catch:{ all -> 0x0038 }
            androidx.camera.video.Recorder$RecordingRecord r2 = r8.makePendingRecordingActiveLocked(r2)     // Catch:{ all -> 0x0038 }
            r3 = r9
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = r2
            r2 = r3
            goto L_0x00af
        L_0x00ac:
            r2 = r9
            r3 = r2
            goto L_0x0051
        L_0x00af:
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x00ba
            androidx.camera.core.SurfaceRequest r9 = r8.mLatestSurfaceRequest
            androidx.camera.core.impl.Timebase r0 = r8.mVideoSourceTimebase
            r8.configureInternal(r9, r0, r4)
            goto L_0x00d7
        L_0x00ba:
            if (r6 == 0) goto L_0x00c0
            r8.reset()
            goto L_0x00d7
        L_0x00c0:
            if (r9 == 0) goto L_0x00d2
            boolean r1 = r8.mEncoderNotUsePersistentInputSurface
            if (r1 != 0) goto L_0x00ca
            r8.startRecording(r9, r0)
            goto L_0x00d7
        L_0x00ca:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            java.lang.String r0 = "Attempt to start a pending recording while the Recorder is waiting for a new surface request."
            r9.<init>(r0)
            throw r9
        L_0x00d2:
            if (r2 == 0) goto L_0x00d7
            r8.finalizePendingRecording(r2, r7, r3)
        L_0x00d7:
            return
        L_0x00d8:
            java.lang.AssertionError r9 = new java.lang.AssertionError     // Catch:{ all -> 0x0038 }
            java.lang.String r0 = "Active recording did not match finalized recording on finalize."
            r9.<init>(r0)     // Catch:{ all -> 0x0038 }
            throw r9     // Catch:{ all -> 0x0038 }
        L_0x00e0:
            monitor-exit(r1)     // Catch:{ all -> 0x0038 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.onRecordingFinalized(androidx.camera.video.Recorder$RecordingRecord):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        setState(androidx.camera.video.Recorder.State.CONFIGURING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResetVideo() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            androidx.camera.video.Recorder$State r1 = r3.mState     // Catch:{ all -> 0x0016 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0016 }
            r2 = 0
            switch(r1) {
                case 1: goto L_0x001e;
                case 2: goto L_0x001e;
                case 3: goto L_0x0018;
                case 4: goto L_0x000e;
                case 5: goto L_0x000e;
                case 6: goto L_0x0018;
                case 7: goto L_0x0018;
                case 8: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ all -> 0x0016 }
        L_0x000d:
            goto L_0x0023
        L_0x000e:
            boolean r1 = r3.isPersistentRecordingInProgress()     // Catch:{ all -> 0x0016 }
            if (r1 == 0) goto L_0x0018
            r1 = 0
            goto L_0x0024
        L_0x0016:
            r1 = move-exception
            goto L_0x003b
        L_0x0018:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x0016 }
            r3.setState(r1)     // Catch:{ all -> 0x0016 }
            goto L_0x0023
        L_0x001e:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x0016 }
            r3.updateNonPendingState(r1)     // Catch:{ all -> 0x0016 }
        L_0x0023:
            r1 = 1
        L_0x0024:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            r3.mNeedsResetBeforeNextStart = r2
            if (r1 == 0) goto L_0x003a
            androidx.camera.core.SurfaceRequest r0 = r3.mLatestSurfaceRequest
            if (r0 == 0) goto L_0x003a
            boolean r0 = r0.isServiced()
            if (r0 != 0) goto L_0x003a
            androidx.camera.core.SurfaceRequest r0 = r3.mLatestSurfaceRequest
            androidx.camera.core.impl.Timebase r1 = r3.mVideoSourceTimebase
            r3.configureInternal(r0, r1, r2)
        L_0x003a:
            return
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.onResetVideo():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onSurfaceRequestedInternal */
    public void lambda$onSurfaceRequested$0(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        SurfaceRequest surfaceRequest2 = this.mLatestSurfaceRequest;
        if (surfaceRequest2 != null && !surfaceRequest2.isServiced()) {
            this.mLatestSurfaceRequest.willNotProvideSurface();
        }
        this.mLatestSurfaceRequest = surfaceRequest;
        this.mVideoSourceTimebase = timebase;
        configureInternal(surfaceRequest, timebase, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: pauseInternal */
    public void lambda$pause$3(@NonNull RecordingRecord recordingRecord) {
        if (this.mInProgressRecording == recordingRecord && !this.mInProgressRecordingStopping) {
            if (isAudioEnabled()) {
                this.mAudioEncoder.pause();
            }
            this.mVideoEncoder.pause();
            RecordingRecord recordingRecord2 = this.mInProgressRecording;
            recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.pause(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
        }
    }

    @NonNull
    private PendingRecording prepareRecordingInternal(@NonNull Context context, @NonNull OutputOptions outputOptions) {
        Preconditions.checkNotNull(outputOptions, "The OutputOptions cannot be null.");
        return new PendingRecording(context, this, outputOptions);
    }

    private void releaseCurrentAudioSource() {
        final AudioSource audioSource = this.mAudioSource;
        if (audioSource != null) {
            this.mAudioSource = null;
            Logger.d(TAG, String.format("Releasing audio source: 0x%x", new Object[]{Integer.valueOf(audioSource.hashCode())}));
            Futures.addCallback(audioSource.release(), new FutureCallback<Void>() {
                public void onFailure(@NonNull Throwable th) {
                    Logger.d(Recorder.TAG, String.format("An error occurred while attempting to release audio source: 0x%x", new Object[]{Integer.valueOf(audioSource.hashCode())}));
                }

                public void onSuccess(@Nullable Void voidR) {
                    Logger.d(Recorder.TAG, String.format("Released audio source successfully: 0x%x", new Object[]{Integer.valueOf(audioSource.hashCode())}));
                }
            }, CameraXExecutors.directExecutor());
            return;
        }
        throw new AssertionError("Cannot release null audio source.");
    }

    private void reset() {
        if (this.mAudioEncoder != null) {
            Logger.d(TAG, "Releasing audio encoder.");
            this.mAudioEncoder.release();
            this.mAudioEncoder = null;
            this.mAudioOutputConfig = null;
        }
        if (this.mAudioSource != null) {
            releaseCurrentAudioSource();
        }
        setAudioState(AudioState.INITIALIZING);
        resetVideo();
    }

    private void resetVideo() {
        if (this.mVideoEncoder != null) {
            Logger.d(TAG, "Releasing video encoder.");
            tryReleaseVideoEncoder();
        }
        onResetVideo();
    }

    @GuardedBy("mLock")
    private void restoreNonPendingState() {
        if (PENDING_STATES.contains(this.mState)) {
            setState(this.mNonPendingState);
            return;
        }
        throw new AssertionError("Cannot restore non-pending state when in state " + this.mState);
    }

    /* access modifiers changed from: private */
    /* renamed from: resumeInternal */
    public void lambda$resume$4(@NonNull RecordingRecord recordingRecord) {
        if (this.mInProgressRecording == recordingRecord && !this.mInProgressRecordingStopping) {
            if (isAudioEnabled()) {
                this.mAudioEncoder.start();
            }
            Encoder encoder = this.mVideoEncoder;
            if (encoder != null) {
                encoder.start();
                RecordingRecord recordingRecord2 = this.mInProgressRecording;
                recordingRecord2.updateVideoRecordEvent(VideoRecordEvent.resume(recordingRecord2.getOutputOptions(), getInProgressRecordingStats()));
                return;
            }
            this.mShouldSendResumeEvent = true;
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public ListenableFuture<Void> safeToCloseVideoEncoder() {
        Logger.d(TAG, "Try to safely release video encoder: " + this.mVideoEncoder);
        return this.mVideoEncoderSession.signalTermination();
    }

    /* access modifiers changed from: private */
    @NonNull
    public static ScheduledFuture<?> scheduleTask(@NonNull Runnable runnable, @NonNull Executor executor, long j, TimeUnit timeUnit) {
        return CameraXExecutors.mainThreadExecutor().schedule(new ib(8, executor, runnable), j, timeUnit);
    }

    @GuardedBy("mLock")
    private void setStreamId(int i) {
        if (this.mStreamId != i) {
            Logger.d(TAG, "Transitioning streamId: " + this.mStreamId + " --> " + i);
            this.mStreamId = i;
            this.mStreamInfo.setState(StreamInfo.of(i, internalStateToStreamState(this.mState), this.mInProgressTransformationInfo));
        }
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    private void setupAudio(@NonNull RecordingRecord recordingRecord) throws AudioSourceAccessException, InvalidConfigException {
        MediaSpec mediaSpec = (MediaSpec) getObservableData(this.mMediaSpec);
        AudioMimeInfo resolveAudioMimeInfo = AudioConfigUtil.resolveAudioMimeInfo(mediaSpec, this.mResolvedEncoderProfiles);
        Timebase timebase = Timebase.UPTIME;
        AudioSettings resolveAudioSettings = AudioConfigUtil.resolveAudioSettings(resolveAudioMimeInfo, mediaSpec.getAudioSpec());
        if (this.mAudioSource != null) {
            releaseCurrentAudioSource();
        }
        AudioSource audioSource = setupAudioSource(recordingRecord, resolveAudioSettings);
        this.mAudioSource = audioSource;
        Logger.d(TAG, String.format("Set up new audio source: 0x%x", new Object[]{Integer.valueOf(audioSource.hashCode())}));
        Encoder createEncoder = this.mAudioEncoderFactory.createEncoder(this.mExecutor, AudioConfigUtil.resolveAudioEncoderConfig(resolveAudioMimeInfo, timebase, resolveAudioSettings, mediaSpec.getAudioSpec()));
        this.mAudioEncoder = createEncoder;
        Encoder.EncoderInput input = createEncoder.getInput();
        if (input instanceof Encoder.ByteBufferInput) {
            this.mAudioSource.setBufferProvider((Encoder.ByteBufferInput) input);
            return;
        }
        throw new AssertionError("The EncoderInput of audio isn't a ByteBufferInput.");
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @NonNull
    private AudioSource setupAudioSource(@NonNull RecordingRecord recordingRecord, @NonNull AudioSettings audioSettings) throws AudioSourceAccessException {
        return recordingRecord.performOneTimeAudioSourceCreation(audioSettings, AUDIO_EXECUTOR);
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fe  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void startInternal(@androidx.annotation.NonNull androidx.camera.video.Recorder.RecordingRecord r8) {
        /*
            r7 = this;
            androidx.camera.video.Recorder$RecordingRecord r0 = r7.mInProgressRecording
            if (r0 != 0) goto L_0x0123
            androidx.camera.video.OutputOptions r0 = r8.getOutputOptions()
            long r0 = r0.getFileSizeLimit()
            java.lang.String r2 = "Recorder"
            r3 = 0
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x003e
            androidx.camera.video.OutputOptions r0 = r8.getOutputOptions()
            long r0 = r0.getFileSizeLimit()
            double r0 = (double) r0
            r5 = 4606732058837280358(0x3fee666666666666, double:0.95)
            double r0 = r0 * r5
            long r0 = java.lang.Math.round(r0)
            r7.mFileSizeLimitInBytes = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "File size limit in bytes: "
            r0.<init>(r1)
            long r5 = r7.mFileSizeLimitInBytes
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            androidx.camera.core.Logger.d(r2, r0)
            goto L_0x0040
        L_0x003e:
            r7.mFileSizeLimitInBytes = r3
        L_0x0040:
            androidx.camera.video.OutputOptions r0 = r8.getOutputOptions()
            long r0 = r0.getDurationLimitMillis()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0070
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            androidx.camera.video.OutputOptions r1 = r8.getOutputOptions()
            long r3 = r1.getDurationLimitMillis()
            long r0 = r0.toNanos(r3)
            r7.mDurationLimitNs = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Duration limit in nanoseconds: "
            r0.<init>(r1)
            long r3 = r7.mDurationLimitNs
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            androidx.camera.core.Logger.d(r2, r0)
            goto L_0x0072
        L_0x0070:
            r7.mDurationLimitNs = r3
        L_0x0072:
            r7.mInProgressRecording = r8
            androidx.camera.video.Recorder$AudioState r0 = r7.mAudioState
            int r0 = r0.ordinal()
            if (r0 == 0) goto L_0x00b2
            r1 = 1
            if (r0 == r1) goto L_0x00a3
            r1 = 2
            if (r0 == r1) goto L_0x008d
            r1 = 3
            if (r0 == r1) goto L_0x008d
            r1 = 4
            if (r0 == r1) goto L_0x008d
            r1 = 5
            if (r0 == r1) goto L_0x008d
            goto L_0x00f4
        L_0x008d:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Incorrectly invoke startInternal in audio state "
            r0.<init>(r1)
            androidx.camera.video.Recorder$AudioState r1 = r7.mAudioState
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L_0x00a3:
            boolean r0 = r8.hasAudioEnabled()
            if (r0 == 0) goto L_0x00ac
            androidx.camera.video.Recorder$AudioState r0 = androidx.camera.video.Recorder.AudioState.ENABLED
            goto L_0x00ae
        L_0x00ac:
            androidx.camera.video.Recorder$AudioState r0 = androidx.camera.video.Recorder.AudioState.DISABLED
        L_0x00ae:
            r7.setAudioState(r0)
            goto L_0x00f4
        L_0x00b2:
            boolean r0 = r8.hasAudioEnabled()
            if (r0 == 0) goto L_0x00f4
            boolean r0 = r7.isAudioSupported()
            if (r0 == 0) goto L_0x00ec
            androidx.camera.video.Recorder$RecordingRecord r0 = r7.mInProgressRecording     // Catch:{ AudioSourceAccessException -> 0x00cd, InvalidConfigException -> 0x00cb }
            boolean r0 = r0.isPersistent()     // Catch:{ AudioSourceAccessException -> 0x00cd, InvalidConfigException -> 0x00cb }
            if (r0 == 0) goto L_0x00cf
            androidx.camera.video.internal.encoder.Encoder r0 = r7.mAudioEncoder     // Catch:{ AudioSourceAccessException -> 0x00cd, InvalidConfigException -> 0x00cb }
            if (r0 != 0) goto L_0x00d2
            goto L_0x00cf
        L_0x00cb:
            r0 = move-exception
            goto L_0x00d8
        L_0x00cd:
            r0 = move-exception
            goto L_0x00d8
        L_0x00cf:
            r7.setupAudio(r8)     // Catch:{ AudioSourceAccessException -> 0x00cd, InvalidConfigException -> 0x00cb }
        L_0x00d2:
            androidx.camera.video.Recorder$AudioState r0 = androidx.camera.video.Recorder.AudioState.ENABLED     // Catch:{ AudioSourceAccessException -> 0x00cd, InvalidConfigException -> 0x00cb }
            r7.setAudioState(r0)     // Catch:{ AudioSourceAccessException -> 0x00cd, InvalidConfigException -> 0x00cb }
            goto L_0x00f4
        L_0x00d8:
            java.lang.String r1 = "Unable to create audio resource with error: "
            androidx.camera.core.Logger.e(r2, r1, r0)
            boolean r1 = r0 instanceof androidx.camera.video.internal.encoder.InvalidConfigException
            if (r1 == 0) goto L_0x00e4
            androidx.camera.video.Recorder$AudioState r1 = androidx.camera.video.Recorder.AudioState.ERROR_ENCODER
            goto L_0x00e6
        L_0x00e4:
            androidx.camera.video.Recorder$AudioState r1 = androidx.camera.video.Recorder.AudioState.ERROR_SOURCE
        L_0x00e6:
            r7.setAudioState(r1)
            r7.mAudioErrorCause = r0
            goto L_0x00f4
        L_0x00ec:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.String r0 = "The Recorder doesn't support recording with audio"
            r8.<init>(r0)
            throw r8
        L_0x00f4:
            r0 = 0
            r7.updateEncoderCallbacks(r8, r0)
            boolean r0 = r7.isAudioEnabled()
            if (r0 == 0) goto L_0x010c
            androidx.camera.video.internal.audio.AudioSource r0 = r7.mAudioSource
            boolean r8 = r8.isMuted()
            r0.start(r8)
            androidx.camera.video.internal.encoder.Encoder r8 = r7.mAudioEncoder
            r8.start()
        L_0x010c:
            androidx.camera.video.internal.encoder.Encoder r8 = r7.mVideoEncoder
            r8.start()
            androidx.camera.video.Recorder$RecordingRecord r8 = r7.mInProgressRecording
            androidx.camera.video.OutputOptions r0 = r8.getOutputOptions()
            androidx.camera.video.RecordingStats r1 = r7.getInProgressRecordingStats()
            androidx.camera.video.VideoRecordEvent$Start r0 = androidx.camera.video.VideoRecordEvent.start(r0, r1)
            r8.updateVideoRecordEvent(r0)
            return
        L_0x0123:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.String r0 = "Attempted to start a new recording while another was in progress."
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.startInternal(androidx.camera.video.Recorder$RecordingRecord):void");
    }

    private void startRecording(@NonNull RecordingRecord recordingRecord, boolean z) {
        startInternal(recordingRecord);
        if (z) {
            lambda$pause$3(recordingRecord);
        }
    }

    private static int supportedMuxerFormatOrDefaultFrom(@Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, int i) {
        if (videoValidatedEncoderProfilesProxy != null) {
            int recommendedFileFormat = videoValidatedEncoderProfilesProxy.getRecommendedFileFormat();
            if (recommendedFileFormat != 1) {
                if (recommendedFileFormat == 2) {
                    return 0;
                }
                if (recommendedFileFormat != 9) {
                    return i;
                }
                return 1;
            } else if (Build.VERSION.SDK_INT < 26) {
                return 0;
            } else {
                return 2;
            }
        }
        return i;
    }

    private void tryReleaseVideoEncoder() {
        boolean z;
        VideoEncoderSession videoEncoderSession = this.mVideoEncoderSessionToRelease;
        if (videoEncoderSession != null) {
            if (videoEncoderSession.getVideoEncoder() == this.mVideoEncoder) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            Logger.d(TAG, "Releasing video encoder: " + this.mVideoEncoder);
            this.mVideoEncoderSessionToRelease.terminateNow();
            this.mVideoEncoderSessionToRelease = null;
            this.mVideoEncoder = null;
            this.mVideoOutputConfig = null;
            setLatestSurface((Surface) null);
            return;
        }
        safeToCloseVideoEncoder();
    }

    private void updateEncoderCallbacks(@NonNull RecordingRecord recordingRecord, boolean z) {
        if (!this.mEncodingFutures.isEmpty()) {
            ListenableFuture<List<V>> allAsList = Futures.allAsList(this.mEncodingFutures);
            if (!allAsList.isDone()) {
                allAsList.cancel(true);
            }
            this.mEncodingFutures.clear();
        }
        this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new b(this, recordingRecord, 0)));
        if (isAudioEnabled() && !z) {
            this.mEncodingFutures.add(CallbackToFutureAdapter.getFuture(new b(this, recordingRecord, 1)));
        }
        Futures.addCallback(Futures.allAsList(this.mEncodingFutures), new FutureCallback<List<Void>>() {
            public void onFailure(@NonNull Throwable th) {
                boolean z;
                int i;
                if (Recorder.this.mInProgressRecording != null) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z, "In-progress recording shouldn't be null");
                if (!Recorder.this.mInProgressRecording.isPersistent()) {
                    Logger.d(Recorder.TAG, "Encodings end with error: " + th);
                    Recorder recorder = Recorder.this;
                    if (recorder.mMediaMuxer == null) {
                        i = 8;
                    } else {
                        i = 6;
                    }
                    recorder.finalizeInProgressRecording(i, th);
                }
            }

            public void onSuccess(@Nullable List<Void> list) {
                Logger.d(Recorder.TAG, "Encodings end successfully.");
                Recorder recorder = Recorder.this;
                recorder.finalizeInProgressRecording(recorder.mRecordingStopError, recorder.mRecordingStopErrorCause);
            }
        }, CameraXExecutors.directExecutor());
    }

    @GuardedBy("mLock")
    private void updateNonPendingState(@NonNull State state) {
        if (!PENDING_STATES.contains(this.mState)) {
            throw new AssertionError("Can only updated non-pending state from a pending state, but state is " + this.mState);
        } else if (!VALID_NON_PENDING_STATES_WHILE_PENDING.contains(state)) {
            throw new AssertionError("Invalid state transition. State is not a valid non-pending state while in a pending state: " + state);
        } else if (this.mNonPendingState != state) {
            this.mNonPendingState = state;
            this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, internalStateToStreamState(state), this.mInProgressTransformationInfo));
        }
    }

    public void finalizeInProgressRecording(int i, @Nullable Throwable th) {
        VideoRecordEvent.Finalize finalize;
        if (this.mInProgressRecording != null) {
            MediaMuxer mediaMuxer = this.mMediaMuxer;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.stop();
                    this.mMediaMuxer.release();
                } catch (IllegalStateException e) {
                    Logger.e(TAG, "MediaMuxer failed to stop or release with error: " + e.getMessage());
                    if (i == 0) {
                        i = 1;
                    }
                }
                this.mMediaMuxer = null;
            } else if (i == 0) {
                i = 8;
            }
            this.mInProgressRecording.finalizeRecording(this.mOutputUri);
            OutputOptions outputOptions = this.mInProgressRecording.getOutputOptions();
            RecordingStats inProgressRecordingStats = getInProgressRecordingStats();
            OutputResults of = OutputResults.of(this.mOutputUri);
            RecordingRecord recordingRecord = this.mInProgressRecording;
            if (i == 0) {
                finalize = VideoRecordEvent.finalize(outputOptions, inProgressRecordingStats, of);
            } else {
                finalize = VideoRecordEvent.finalizeWithError(outputOptions, inProgressRecordingStats, of, i, th);
            }
            recordingRecord.updateVideoRecordEvent(finalize);
            RecordingRecord recordingRecord2 = this.mInProgressRecording;
            this.mInProgressRecording = null;
            this.mInProgressRecordingStopping = false;
            this.mAudioTrackIndex = null;
            this.mVideoTrackIndex = null;
            this.mEncodingFutures.clear();
            this.mOutputUri = Uri.EMPTY;
            this.mRecordingBytes = 0;
            this.mRecordingDurationNs = 0;
            this.mFirstRecordingVideoDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
            this.mFirstRecordingAudioDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
            this.mPreviousRecordingVideoDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
            this.mPreviousRecordingAudioDataTimeUs = LocationRequestCompat.PASSIVE_INTERVAL;
            this.mRecordingStopError = 1;
            this.mRecordingStopErrorCause = null;
            this.mAudioErrorCause = null;
            this.mAudioAmplitude = 0.0d;
            clearPendingAudioRingBuffer();
            setInProgressTransformationInfo((SurfaceRequest.TransformationInfo) null);
            int ordinal = this.mAudioState.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2 || ordinal == 3) {
                    setAudioState(AudioState.IDLING);
                    this.mAudioSource.stop();
                } else if (ordinal == 4 || ordinal == 5) {
                    setAudioState(AudioState.INITIALIZING);
                }
                onRecordingFinalized(recordingRecord2);
                return;
            }
            throw new AssertionError("Incorrectly finalize recording when audio state is IDLING");
        }
        throw new AssertionError("Attempted to finalize in-progress recording, but no recording is in progress.");
    }

    public int getAspectRatio() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getAspectRatio();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int getAudioSource() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getSource();
    }

    @Nullable
    public Executor getExecutor() {
        return this.mUserProvidedExecutor;
    }

    @NonNull
    public RecordingStats getInProgressRecordingStats() {
        return RecordingStats.of(this.mRecordingDurationNs, this.mRecordingBytes, AudioStats.of(internalAudioStateToAudioStatsState(this.mAudioState), this.mAudioErrorCause, this.mAudioAmplitude));
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public VideoCapabilities getMediaCapabilities(@NonNull CameraInfo cameraInfo) {
        return getVideoCapabilities(cameraInfo, this.mVideoCapabilitiesSource);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Observable<MediaSpec> getMediaSpec() {
        return this.mMediaSpec;
    }

    public <T> T getObservableData(@NonNull StateObservable<T> stateObservable) {
        try {
            return stateObservable.fetchData().get();
        } catch (InterruptedException | ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    @NonNull
    public QualitySelector getQualitySelector() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getQualitySelector();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Observable<StreamInfo> getStreamInfo() {
        return this.mStreamInfo;
    }

    public int getTargetVideoEncodingBitRate() {
        return ((MediaSpec) getObservableData(this.mMediaSpec)).getVideoSpec().getBitrate().getLower().intValue();
    }

    public int getVideoCapabilitiesSource() {
        return this.mVideoCapabilitiesSource;
    }

    public boolean isAudioEnabled() {
        if (this.mAudioState == AudioState.ENABLED) {
            return true;
        }
        return false;
    }

    public boolean isAudioSupported() {
        if (((MediaSpec) getObservableData(this.mMediaSpec)).getAudioSpec().getChannelCount() != 0) {
            return true;
        }
        return false;
    }

    public boolean isPersistentRecordingInProgress() {
        RecordingRecord recordingRecord = this.mInProgressRecording;
        if (recordingRecord == null || !recordingRecord.isPersistent()) {
            return false;
        }
        return true;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Observable<Boolean> isSourceStreamRequired() {
        return this.mIsRecording;
    }

    public void mute(@NonNull Recording recording, boolean z) {
        RecordingRecord recordingRecord;
        synchronized (this.mLock) {
            try {
                if (isSameRecording(recording, this.mPendingRecordingRecord) || isSameRecording(recording, this.mActiveRecordingRecord)) {
                    if (isSameRecording(recording, this.mPendingRecordingRecord)) {
                        recordingRecord = this.mPendingRecordingRecord;
                    } else {
                        recordingRecord = this.mActiveRecordingRecord;
                    }
                    this.mSequentialExecutor.execute(new d(this, recordingRecord, z));
                    return;
                }
                Logger.d(TAG, "mute() called on a recording that is no longer active: " + recording.getOutputOptions());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        androidx.core.util.Preconditions.checkState(isPersistentRecordingInProgress(), "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording");
        r2 = null;
        r6 = null;
        r7 = 0;
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (r9.mActiveRecordingRecord == null) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        r2 = null;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005a, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        if (r9.mSourceState != androidx.camera.video.VideoOutput.SourceState.INACTIVE) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        r2 = r9.mPendingRecordingRecord;
        r9.mPendingRecordingRecord = null;
        restoreNonPendingState();
        r6 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE;
        r7 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
        r6 = null;
        r7 = 0;
        r8 = false;
        r4 = makePendingRecordingActiveLocked(r9.mState);
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007f, code lost:
        r2 = null;
        r6 = null;
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onConfigured() {
        /*
            r9 = this;
            java.lang.String r0 = "Incorrectly invoke onConfigured() in state "
            java.lang.Object r1 = r9.mLock
            monitor-enter(r1)
            androidx.camera.video.Recorder$State r2 = r9.mState     // Catch:{ all -> 0x001c }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x001c }
            r3 = 1
            r4 = 0
            r5 = 0
            switch(r2) {
                case 0: goto L_0x007a;
                case 1: goto L_0x0053;
                case 2: goto L_0x0051;
                case 3: goto L_0x003d;
                case 4: goto L_0x002e;
                case 5: goto L_0x002c;
                case 6: goto L_0x001f;
                case 7: goto L_0x003d;
                case 8: goto L_0x0013;
                default: goto L_0x0011;
            }     // Catch:{ all -> 0x001c }
        L_0x0011:
            goto L_0x007f
        L_0x0013:
            java.lang.String r0 = "Recorder"
            java.lang.String r2 = "onConfigured() was invoked when the Recorder had encountered error"
            androidx.camera.core.Logger.e(r0, r2)     // Catch:{ all -> 0x001c }
            goto L_0x007f
        L_0x001c:
            r0 = move-exception
            goto L_0x00bb
        L_0x001f:
            boolean r0 = r9.mEncoderNotUsePersistentInputSurface     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0024
            goto L_0x007f
        L_0x0024:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x001c }
            java.lang.String r2 = "Unexpectedly invoke onConfigured() in a STOPPING state when it's not waiting for a new surface."
            r0.<init>(r2)     // Catch:{ all -> 0x001c }
            throw r0     // Catch:{ all -> 0x001c }
        L_0x002c:
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            boolean r2 = r9.isPersistentRecordingInProgress()     // Catch:{ all -> 0x001c }
            java.lang.String r6 = "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording"
            androidx.core.util.Preconditions.checkState(r2, r6)     // Catch:{ all -> 0x001c }
            r2 = r4
            r6 = r2
            r7 = 0
            r8 = 1
            goto L_0x0083
        L_0x003d:
            java.lang.AssertionError r2 = new java.lang.AssertionError     // Catch:{ all -> 0x001c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x001c }
            r3.<init>(r0)     // Catch:{ all -> 0x001c }
            androidx.camera.video.Recorder$State r0 = r9.mState     // Catch:{ all -> 0x001c }
            r3.append(r0)     // Catch:{ all -> 0x001c }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x001c }
            r2.<init>(r0)     // Catch:{ all -> 0x001c }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0051:
            r0 = 1
            goto L_0x0054
        L_0x0053:
            r0 = 0
        L_0x0054:
            androidx.camera.video.Recorder$RecordingRecord r2 = r9.mActiveRecordingRecord     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x005d
            r2 = r4
            r6 = r2
        L_0x005a:
            r7 = 0
        L_0x005b:
            r8 = 0
            goto L_0x0083
        L_0x005d:
            androidx.camera.video.VideoOutput$SourceState r2 = r9.mSourceState     // Catch:{ all -> 0x001c }
            androidx.camera.video.VideoOutput$SourceState r6 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x001c }
            if (r2 != r6) goto L_0x006e
            androidx.camera.video.Recorder$RecordingRecord r2 = r9.mPendingRecordingRecord     // Catch:{ all -> 0x001c }
            r9.mPendingRecordingRecord = r4     // Catch:{ all -> 0x001c }
            r9.restoreNonPendingState()     // Catch:{ all -> 0x001c }
            java.lang.Exception r6 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE     // Catch:{ all -> 0x001c }
            r7 = 4
            goto L_0x005b
        L_0x006e:
            androidx.camera.video.Recorder$State r2 = r9.mState     // Catch:{ all -> 0x001c }
            androidx.camera.video.Recorder$RecordingRecord r2 = r9.makePendingRecordingActiveLocked(r2)     // Catch:{ all -> 0x001c }
            r6 = r4
            r7 = 0
            r8 = 0
            r4 = r2
            r2 = r6
            goto L_0x0083
        L_0x007a:
            androidx.camera.video.Recorder$State r0 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x001c }
            r9.setState(r0)     // Catch:{ all -> 0x001c }
        L_0x007f:
            r2 = r4
            r6 = r2
            r0 = 0
            goto L_0x005a
        L_0x0083:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            if (r8 == 0) goto L_0x00af
            androidx.camera.video.Recorder$RecordingRecord r1 = r9.mInProgressRecording
            r9.updateEncoderCallbacks(r1, r3)
            androidx.camera.video.internal.encoder.Encoder r1 = r9.mVideoEncoder
            r1.start()
            boolean r1 = r9.mShouldSendResumeEvent
            if (r1 == 0) goto L_0x00a7
            androidx.camera.video.Recorder$RecordingRecord r1 = r9.mInProgressRecording
            androidx.camera.video.OutputOptions r2 = r1.getOutputOptions()
            androidx.camera.video.RecordingStats r3 = r9.getInProgressRecordingStats()
            androidx.camera.video.VideoRecordEvent$Resume r2 = androidx.camera.video.VideoRecordEvent.resume(r2, r3)
            r1.updateVideoRecordEvent(r2)
            r9.mShouldSendResumeEvent = r5
        L_0x00a7:
            if (r0 == 0) goto L_0x00ba
            androidx.camera.video.internal.encoder.Encoder r0 = r9.mVideoEncoder
            r0.pause()
            goto L_0x00ba
        L_0x00af:
            if (r4 == 0) goto L_0x00b5
            r9.startRecording(r4, r0)
            goto L_0x00ba
        L_0x00b5:
            if (r2 == 0) goto L_0x00ba
            r9.finalizePendingRecording(r2, r7, r6)
        L_0x00ba:
            return
        L_0x00bb:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.onConfigured():void");
    }

    public void onEncoderSetupError(@Nullable Throwable th) {
        RecordingRecord recordingRecord;
        synchronized (this.mLock) {
            try {
                recordingRecord = null;
                switch (this.mState.ordinal()) {
                    case 0:
                        break;
                    case 1:
                    case 2:
                        RecordingRecord recordingRecord2 = this.mPendingRecordingRecord;
                        this.mPendingRecordingRecord = null;
                        recordingRecord = recordingRecord2;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        throw new AssertionError("Encountered encoder setup error while in unexpected state " + this.mState + ": " + th);
                }
                setStreamId(-1);
                setState(State.ERROR);
            } catch (Throwable th2) {
                while (true) {
                    throw th2;
                }
            }
        }
        if (recordingRecord != null) {
            finalizePendingRecording(recordingRecord, 7, th);
        }
    }

    public void onInProgressRecordingInternalError(@NonNull RecordingRecord recordingRecord, int i, @Nullable Throwable th) {
        boolean z;
        if (recordingRecord == this.mInProgressRecording) {
            synchronized (this.mLock) {
                try {
                    z = false;
                    switch (this.mState.ordinal()) {
                        case 0:
                        case 3:
                        case 8:
                            throw new AssertionError("In-progress recording error occurred while in unexpected state: " + this.mState);
                        case 1:
                        case 2:
                        case 6:
                        case 7:
                            break;
                        case 4:
                        case 5:
                            setState(State.STOPPING);
                            z = true;
                            break;
                    }
                    if (recordingRecord != this.mActiveRecordingRecord) {
                        throw new AssertionError("Internal error occurred for recording but it is not the active recording.");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z) {
                lambda$stop$5(recordingRecord, -1, i, th);
                return;
            }
            return;
        }
        throw new AssertionError("Internal error occurred on recording that is not the current in-progress recording.");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onSourceStateChanged(@NonNull VideoOutput.SourceState sourceState) {
        this.mSequentialExecutor.execute(new ib(9, this, sourceState));
    }

    /* renamed from: onSourceStateChangedInternal */
    public void lambda$onSourceStateChanged$1(@NonNull VideoOutput.SourceState sourceState) {
        ScheduledFuture<?> scheduledFuture;
        Encoder encoder;
        VideoOutput.SourceState sourceState2 = this.mSourceState;
        this.mSourceState = sourceState;
        if (sourceState2 != sourceState) {
            Logger.d(TAG, "Video source has transitioned to state: " + sourceState);
            if (sourceState == VideoOutput.SourceState.INACTIVE) {
                if (this.mActiveSurface == null) {
                    SetupVideoTask setupVideoTask = this.mSetupVideoTask;
                    if (setupVideoTask != null) {
                        setupVideoTask.cancelFailedRetry();
                        this.mSetupVideoTask = null;
                    }
                    requestReset(4, (Throwable) null, false);
                    return;
                }
                this.mNeedsResetBeforeNextStart = true;
                RecordingRecord recordingRecord = this.mInProgressRecording;
                if (recordingRecord != null && !recordingRecord.isPersistent()) {
                    onInProgressRecordingInternalError(this.mInProgressRecording, 4, (Throwable) null);
                }
            } else if (sourceState == VideoOutput.SourceState.ACTIVE_NON_STREAMING && (scheduledFuture = this.mSourceNonStreamingTimeout) != null && scheduledFuture.cancel(false) && (encoder = this.mVideoEncoder) != null) {
                notifyEncoderSourceStopped(encoder);
            }
        } else {
            Logger.d(TAG, "Video source transitions to the same state: " + sourceState);
        }
    }

    public void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest) {
        onSurfaceRequested(surfaceRequest, Timebase.UPTIME);
    }

    public void onVideoEncoderReady(@NonNull final VideoEncoderSession videoEncoderSession) {
        Encoder videoEncoder = videoEncoderSession.getVideoEncoder();
        this.mVideoEncoder = videoEncoder;
        this.mVideoEncoderBitrateRange = ((VideoEncoderInfo) videoEncoder.getEncoderInfo()).getSupportedBitrateRange();
        this.mFirstRecordingVideoBitrate = this.mVideoEncoder.getConfiguredBitrate();
        Surface activeSurface = videoEncoderSession.getActiveSurface();
        this.mActiveSurface = activeSurface;
        setLatestSurface(activeSurface);
        videoEncoderSession.setOnSurfaceUpdateListener(this.mSequentialExecutor, new nd(this));
        Futures.addCallback(videoEncoderSession.getReadyToReleaseFuture(), new FutureCallback<Encoder>() {
            public void onFailure(@NonNull Throwable th) {
                Logger.d(Recorder.TAG, "Error in ReadyToReleaseFuture: " + th);
            }

            public void onSuccess(@Nullable Encoder encoder) {
                Encoder encoder2;
                Logger.d(Recorder.TAG, "VideoEncoder can be released: " + encoder);
                if (encoder != null) {
                    ScheduledFuture<?> scheduledFuture = Recorder.this.mSourceNonStreamingTimeout;
                    if (scheduledFuture != null && scheduledFuture.cancel(false) && (encoder2 = Recorder.this.mVideoEncoder) != null && encoder2 == encoder) {
                        Recorder.notifyEncoderSourceStopped(encoder2);
                    }
                    Recorder recorder = Recorder.this;
                    recorder.mVideoEncoderSessionToRelease = videoEncoderSession;
                    recorder.setLatestSurface((Surface) null);
                    Recorder recorder2 = Recorder.this;
                    recorder2.requestReset(4, (Throwable) null, recorder2.isPersistentRecordingInProgress());
                }
            }
        }, this.mSequentialExecutor);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pause(@androidx.annotation.NonNull androidx.camera.video.Recording r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Called pause() from invalid state: "
            java.lang.String r1 = "pause() called on a recording that is no longer active: "
            java.lang.Object r2 = r4.mLock
            monitor-enter(r2)
            androidx.camera.video.Recorder$RecordingRecord r3 = r4.mPendingRecordingRecord     // Catch:{ all -> 0x002e }
            boolean r3 = isSameRecording(r5, r3)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x0030
            androidx.camera.video.Recorder$RecordingRecord r3 = r4.mActiveRecordingRecord     // Catch:{ all -> 0x002e }
            boolean r3 = isSameRecording(r5, r3)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x0030
            java.lang.String r0 = "Recorder"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r3.<init>(r1)     // Catch:{ all -> 0x002e }
            androidx.camera.video.OutputOptions r5 = r5.getOutputOptions()     // Catch:{ all -> 0x002e }
            r3.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x002e }
            androidx.camera.core.Logger.d(r0, r5)     // Catch:{ all -> 0x002e }
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            return
        L_0x002e:
            r5 = move-exception
            goto L_0x0070
        L_0x0030:
            androidx.camera.video.Recorder$State r5 = r4.mState     // Catch:{ all -> 0x002e }
            int r5 = r5.ordinal()     // Catch:{ all -> 0x002e }
            if (r5 == 0) goto L_0x005c
            r1 = 1
            if (r5 == r1) goto L_0x0055
            r1 = 3
            if (r5 == r1) goto L_0x005c
            r0 = 4
            if (r5 == r0) goto L_0x0042
            goto L_0x005a
        L_0x0042:
            androidx.camera.video.Recorder$State r5 = androidx.camera.video.Recorder.State.PAUSED     // Catch:{ all -> 0x002e }
            r4.setState(r5)     // Catch:{ all -> 0x002e }
            androidx.camera.video.Recorder$RecordingRecord r5 = r4.mActiveRecordingRecord     // Catch:{ all -> 0x002e }
            java.util.concurrent.Executor r0 = r4.mSequentialExecutor     // Catch:{ all -> 0x002e }
            androidx.camera.video.c r1 = new androidx.camera.video.c     // Catch:{ all -> 0x002e }
            r3 = 1
            r1.<init>(r4, r5, r3)     // Catch:{ all -> 0x002e }
            r0.execute(r1)     // Catch:{ all -> 0x002e }
            goto L_0x005a
        L_0x0055:
            androidx.camera.video.Recorder$State r5 = androidx.camera.video.Recorder.State.PENDING_PAUSED     // Catch:{ all -> 0x002e }
            r4.setState(r5)     // Catch:{ all -> 0x002e }
        L_0x005a:
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            return
        L_0x005c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r1.<init>(r0)     // Catch:{ all -> 0x002e }
            androidx.camera.video.Recorder$State r0 = r4.mState     // Catch:{ all -> 0x002e }
            r1.append(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x002e }
            r5.<init>(r0)     // Catch:{ all -> 0x002e }
            throw r5     // Catch:{ all -> 0x002e }
        L_0x0070:
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.pause(androidx.camera.video.Recording):void");
    }

    @NonNull
    public PendingRecording prepareRecording(@NonNull Context context, @NonNull FileOutputOptions fileOutputOptions) {
        return prepareRecordingInternal(context, fileOutputOptions);
    }

    public void requestReset(int i, @Nullable Throwable th, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        synchronized (this.mLock) {
            try {
                z2 = true;
                z3 = false;
                switch (this.mState.ordinal()) {
                    case 0:
                    case 3:
                    case 8:
                        break;
                    case 1:
                    case 2:
                        updateNonPendingState(State.RESETTING);
                        break;
                    case 4:
                    case 5:
                        if (this.mInProgressRecording != null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        Preconditions.checkState(z4, "In-progress recording shouldn't be null when in state " + this.mState);
                        if (this.mActiveRecordingRecord == this.mInProgressRecording) {
                            if (!isPersistentRecordingInProgress()) {
                                setState(State.RESETTING);
                                z2 = false;
                                z3 = true;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            throw new AssertionError("In-progress recording does not match the active recording. Unable to reset encoder.");
                        }
                    case 6:
                        setState(State.RESETTING);
                        break;
                }
                z2 = false;
            } catch (Throwable th2) {
                while (true) {
                    throw th2;
                }
            }
        }
        if (z2) {
            if (z) {
                resetVideo();
            } else {
                reset();
            }
        } else if (z3) {
            lambda$stop$5(this.mInProgressRecording, -1, i, th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resume(@androidx.annotation.NonNull androidx.camera.video.Recording r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Called resume() from invalid state: "
            java.lang.String r1 = "resume() called on a recording that is no longer active: "
            java.lang.Object r2 = r4.mLock
            monitor-enter(r2)
            androidx.camera.video.Recorder$RecordingRecord r3 = r4.mPendingRecordingRecord     // Catch:{ all -> 0x002e }
            boolean r3 = isSameRecording(r5, r3)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x0030
            androidx.camera.video.Recorder$RecordingRecord r3 = r4.mActiveRecordingRecord     // Catch:{ all -> 0x002e }
            boolean r3 = isSameRecording(r5, r3)     // Catch:{ all -> 0x002e }
            if (r3 != 0) goto L_0x0030
            java.lang.String r0 = "Recorder"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r3.<init>(r1)     // Catch:{ all -> 0x002e }
            androidx.camera.video.OutputOptions r5 = r5.getOutputOptions()     // Catch:{ all -> 0x002e }
            r3.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = r3.toString()     // Catch:{ all -> 0x002e }
            androidx.camera.core.Logger.d(r0, r5)     // Catch:{ all -> 0x002e }
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            return
        L_0x002e:
            r5 = move-exception
            goto L_0x0070
        L_0x0030:
            androidx.camera.video.Recorder$State r5 = r4.mState     // Catch:{ all -> 0x002e }
            int r5 = r5.ordinal()     // Catch:{ all -> 0x002e }
            if (r5 == 0) goto L_0x005c
            r1 = 5
            if (r5 == r1) goto L_0x0048
            r1 = 2
            if (r5 == r1) goto L_0x0042
            r1 = 3
            if (r5 == r1) goto L_0x005c
            goto L_0x005a
        L_0x0042:
            androidx.camera.video.Recorder$State r5 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ all -> 0x002e }
            r4.setState(r5)     // Catch:{ all -> 0x002e }
            goto L_0x005a
        L_0x0048:
            androidx.camera.video.Recorder$State r5 = androidx.camera.video.Recorder.State.RECORDING     // Catch:{ all -> 0x002e }
            r4.setState(r5)     // Catch:{ all -> 0x002e }
            androidx.camera.video.Recorder$RecordingRecord r5 = r4.mActiveRecordingRecord     // Catch:{ all -> 0x002e }
            java.util.concurrent.Executor r0 = r4.mSequentialExecutor     // Catch:{ all -> 0x002e }
            androidx.camera.video.c r1 = new androidx.camera.video.c     // Catch:{ all -> 0x002e }
            r3 = 0
            r1.<init>(r4, r5, r3)     // Catch:{ all -> 0x002e }
            r0.execute(r1)     // Catch:{ all -> 0x002e }
        L_0x005a:
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            return
        L_0x005c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r1.<init>(r0)     // Catch:{ all -> 0x002e }
            androidx.camera.video.Recorder$State r0 = r4.mState     // Catch:{ all -> 0x002e }
            r1.append(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x002e }
            r5.<init>(r0)     // Catch:{ all -> 0x002e }
            throw r5     // Catch:{ all -> 0x002e }
        L_0x0070:
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.resume(androidx.camera.video.Recording):void");
    }

    public void setAudioState(@NonNull AudioState audioState) {
        Logger.d(TAG, "Transitioning audio state: " + this.mAudioState + " --> " + audioState);
        this.mAudioState = audioState;
    }

    public void setInProgressTransformationInfo(@Nullable SurfaceRequest.TransformationInfo transformationInfo) {
        Logger.d(TAG, "Update stream transformation info: " + transformationInfo);
        this.mInProgressTransformationInfo = transformationInfo;
        synchronized (this.mLock) {
            this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, internalStateToStreamState(this.mState), transformationInfo));
        }
    }

    public void setLatestSurface(@Nullable Surface surface) {
        int i;
        if (this.mLatestSurface != surface) {
            this.mLatestSurface = surface;
            synchronized (this.mLock) {
                if (surface != null) {
                    try {
                        i = surface.hashCode();
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    i = 0;
                }
                setStreamId(i);
            }
        }
    }

    @GuardedBy("mLock")
    public void setState(@NonNull State state) {
        if (this.mState != state) {
            Logger.d(TAG, "Transitioning Recorder internal state: " + this.mState + " --> " + state);
            Set<State> set = PENDING_STATES;
            StreamInfo.StreamState streamState = null;
            if (set.contains(state)) {
                if (!set.contains(this.mState)) {
                    if (VALID_NON_PENDING_STATES_WHILE_PENDING.contains(this.mState)) {
                        State state2 = this.mState;
                        this.mNonPendingState = state2;
                        streamState = internalStateToStreamState(state2);
                    } else {
                        throw new AssertionError("Invalid state transition. Should not be transitioning to a PENDING state from state " + this.mState);
                    }
                }
            } else if (this.mNonPendingState != null) {
                this.mNonPendingState = null;
            }
            this.mState = state;
            if (streamState == null) {
                streamState = internalStateToStreamState(state);
            }
            this.mStreamInfo.setState(StreamInfo.of(this.mStreamId, streamState, this.mInProgressTransformationInfo));
            return;
        }
        throw new AssertionError("Attempted to transition to state " + state + ", but Recorder is already in state " + state);
    }

    public void setupAndStartMediaMuxer(@NonNull RecordingRecord recordingRecord) {
        int i;
        if (this.mMediaMuxer != null) {
            throw new AssertionError("Unable to set up media muxer when one already exists.");
        } else if (!isAudioEnabled() || !this.mPendingAudioRingBuffer.isEmpty()) {
            EncodedData encodedData = this.mPendingFirstVideoData;
            if (encodedData != null) {
                try {
                    this.mPendingFirstVideoData = null;
                    List<EncodedData> audioDataToWriteAndClearCache = getAudioDataToWriteAndClearCache(encodedData.getPresentationTimeUs());
                    long size = encodedData.size();
                    for (EncodedData size2 : audioDataToWriteAndClearCache) {
                        size += size2.size();
                    }
                    long j = this.mFileSizeLimitInBytes;
                    if (j == 0 || size <= j) {
                        try {
                            MediaSpec mediaSpec = (MediaSpec) getObservableData(this.mMediaSpec);
                            if (mediaSpec.getOutputFormat() == -1) {
                                i = supportedMuxerFormatOrDefaultFrom(this.mResolvedEncoderProfiles, MediaSpec.outputFormatToMuxerFormat(MEDIA_SPEC_DEFAULT.getOutputFormat()));
                            } else {
                                i = MediaSpec.outputFormatToMuxerFormat(mediaSpec.getOutputFormat());
                            }
                            MediaMuxer performOneTimeMediaMuxerCreation = recordingRecord.performOneTimeMediaMuxerCreation(i, new od(this, 0));
                            SurfaceRequest.TransformationInfo transformationInfo = this.mSourceTransformationInfo;
                            if (transformationInfo != null) {
                                setInProgressTransformationInfo(transformationInfo);
                                performOneTimeMediaMuxerCreation.setOrientationHint(transformationInfo.getRotationDegrees());
                            }
                            Location location = recordingRecord.getOutputOptions().getLocation();
                            if (location != null) {
                                try {
                                    Pair<Double, Double> adjustGeoLocation = CorrectNegativeLatLongForMediaMuxer.adjustGeoLocation(location.getLatitude(), location.getLongitude());
                                    performOneTimeMediaMuxerCreation.setLocation((float) ((Double) adjustGeoLocation.first).doubleValue(), (float) ((Double) adjustGeoLocation.second).doubleValue());
                                } catch (IllegalArgumentException e) {
                                    performOneTimeMediaMuxerCreation.release();
                                    onInProgressRecordingInternalError(recordingRecord, 5, e);
                                    encodedData.close();
                                    return;
                                }
                            }
                            this.mVideoTrackIndex = Integer.valueOf(performOneTimeMediaMuxerCreation.addTrack(this.mVideoOutputConfig.getMediaFormat()));
                            if (isAudioEnabled()) {
                                this.mAudioTrackIndex = Integer.valueOf(performOneTimeMediaMuxerCreation.addTrack(this.mAudioOutputConfig.getMediaFormat()));
                            }
                            performOneTimeMediaMuxerCreation.start();
                            this.mMediaMuxer = performOneTimeMediaMuxerCreation;
                            writeVideoData(encodedData, recordingRecord);
                            for (EncodedData writeAudioData : audioDataToWriteAndClearCache) {
                                writeAudioData(writeAudioData, recordingRecord);
                            }
                            encodedData.close();
                            return;
                        } catch (IOException e2) {
                            onInProgressRecordingInternalError(recordingRecord, 5, e2);
                            encodedData.close();
                            return;
                        }
                    } else {
                        Logger.d(TAG, String.format("Initial data exceeds file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)}));
                        onInProgressRecordingInternalError(recordingRecord, 2, (Throwable) null);
                        encodedData.close();
                        return;
                    }
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw new AssertionError("Media muxer cannot be started without an encoded video frame.");
            }
        } else {
            throw new AssertionError("Audio is enabled but no audio sample is ready. Cannot start media muxer.");
        }
        throw th;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001e, code lost:
        r4 = r3;
        r3 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.video.Recording start(@androidx.annotation.NonNull androidx.camera.video.PendingRecording r10) {
        /*
            r9 = this;
            java.lang.String r0 = "The given PendingRecording cannot be null."
            androidx.core.util.Preconditions.checkNotNull(r10, r0)
            java.lang.Object r0 = r9.mLock
            monitor-enter(r0)
            long r1 = r9.mLastGeneratedRecordingId     // Catch:{ all -> 0x0022 }
            r3 = 1
            long r1 = r1 + r3
            r9.mLastGeneratedRecordingId = r1     // Catch:{ all -> 0x0022 }
            androidx.camera.video.Recorder$State r3 = r9.mState     // Catch:{ all -> 0x0022 }
            int r3 = r3.ordinal()     // Catch:{ all -> 0x0022 }
            r4 = 0
            r5 = 0
            switch(r3) {
                case 0: goto L_0x002e;
                case 1: goto L_0x0025;
                case 2: goto L_0x0025;
                case 3: goto L_0x002e;
                case 4: goto L_0x001c;
                case 5: goto L_0x001c;
                case 6: goto L_0x002e;
                case 7: goto L_0x002e;
                case 8: goto L_0x002e;
                default: goto L_0x001a;
            }     // Catch:{ all -> 0x0022 }
        L_0x001a:
            goto L_0x0082
        L_0x001c:
            androidx.camera.video.Recorder$RecordingRecord r3 = r9.mActiveRecordingRecord     // Catch:{ all -> 0x0022 }
        L_0x001e:
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x0085
        L_0x0022:
            r10 = move-exception
            goto L_0x00b6
        L_0x0025:
            androidx.camera.video.Recorder$RecordingRecord r3 = r9.mPendingRecordingRecord     // Catch:{ all -> 0x0022 }
            java.lang.Object r3 = androidx.core.util.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0022 }
            androidx.camera.video.Recorder$RecordingRecord r3 = (androidx.camera.video.Recorder.RecordingRecord) r3     // Catch:{ all -> 0x0022 }
            goto L_0x001e
        L_0x002e:
            androidx.camera.video.Recorder$State r3 = r9.mState     // Catch:{ all -> 0x0022 }
            androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x0022 }
            if (r3 != r6) goto L_0x0044
            androidx.camera.video.Recorder$RecordingRecord r3 = r9.mActiveRecordingRecord     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x003e
            androidx.camera.video.Recorder$RecordingRecord r3 = r9.mPendingRecordingRecord     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            java.lang.String r7 = "Expected recorder to be idle but a recording is either pending or in progress."
            androidx.core.util.Preconditions.checkState(r3, r7)     // Catch:{ all -> 0x0022 }
        L_0x0044:
            androidx.camera.video.Recorder$RecordingRecord r3 = androidx.camera.video.Recorder.RecordingRecord.from(r10, r1)     // Catch:{ IOException -> 0x0066 }
            android.content.Context r7 = r10.getApplicationContext()     // Catch:{ IOException -> 0x0066 }
            r3.initializeRecording(r7)     // Catch:{ IOException -> 0x0066 }
            r9.mPendingRecordingRecord = r3     // Catch:{ IOException -> 0x0066 }
            androidx.camera.video.Recorder$State r3 = r9.mState     // Catch:{ IOException -> 0x0066 }
            if (r3 != r6) goto L_0x0068
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0066 }
            r9.setState(r3)     // Catch:{ IOException -> 0x0066 }
            java.util.concurrent.Executor r3 = r9.mSequentialExecutor     // Catch:{ IOException -> 0x0066 }
            md r6 = new md     // Catch:{ IOException -> 0x0066 }
            r7 = 0
            r6.<init>(r9, r7)     // Catch:{ IOException -> 0x0066 }
            r3.execute(r6)     // Catch:{ IOException -> 0x0066 }
            goto L_0x0082
        L_0x0066:
            r3 = move-exception
            goto L_0x0084
        L_0x0068:
            androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.ERROR     // Catch:{ IOException -> 0x0066 }
            if (r3 != r6) goto L_0x007d
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0066 }
            r9.setState(r3)     // Catch:{ IOException -> 0x0066 }
            java.util.concurrent.Executor r3 = r9.mSequentialExecutor     // Catch:{ IOException -> 0x0066 }
            md r6 = new md     // Catch:{ IOException -> 0x0066 }
            r7 = 1
            r6.<init>(r9, r7)     // Catch:{ IOException -> 0x0066 }
            r3.execute(r6)     // Catch:{ IOException -> 0x0066 }
            goto L_0x0082
        L_0x007d:
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0066 }
            r9.setState(r3)     // Catch:{ IOException -> 0x0066 }
        L_0x0082:
            r3 = r4
            goto L_0x0085
        L_0x0084:
            r5 = 5
        L_0x0085:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            if (r4 != 0) goto L_0x00ae
            if (r5 == 0) goto L_0x00a9
            java.lang.String r0 = "Recorder"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Recording was started when the Recorder had encountered error "
            r4.<init>(r6)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            androidx.camera.core.Logger.e(r0, r4)
            androidx.camera.video.Recorder$RecordingRecord r0 = androidx.camera.video.Recorder.RecordingRecord.from(r10, r1)
            r9.finalizePendingRecording(r0, r5, r3)
            androidx.camera.video.Recording r10 = androidx.camera.video.Recording.createFinalizedFrom(r10, r1)
            return r10
        L_0x00a9:
            androidx.camera.video.Recording r10 = androidx.camera.video.Recording.from(r10, r1)
            return r10
        L_0x00ae:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "A recording is already in progress. Previous recordings must be stopped before a new recording can be started."
            r10.<init>(r0)
            throw r10
        L_0x00b6:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.start(androidx.camera.video.PendingRecording):androidx.camera.video.Recording");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0075, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0079, code lost:
        if (r14 != 10) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        androidx.camera.core.Logger.e(TAG, "Recording was stopped due to recording being garbage collected before any valid data has been produced.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0082, code lost:
        finalizePendingRecording(r2, 8, new java.lang.RuntimeException("Recording was stopped before any data could be produced.", r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void stop(@androidx.annotation.NonNull androidx.camera.video.Recording r13, int r14, @androidx.annotation.Nullable java.lang.Throwable r15) {
        /*
            r12 = this;
            java.lang.String r0 = "stop() called on a recording that is no longer active: "
            java.lang.Object r1 = r12.mLock
            monitor-enter(r1)
            androidx.camera.video.Recorder$RecordingRecord r2 = r12.mPendingRecordingRecord     // Catch:{ all -> 0x002c }
            boolean r2 = isSameRecording(r13, r2)     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x002e
            androidx.camera.video.Recorder$RecordingRecord r2 = r12.mActiveRecordingRecord     // Catch:{ all -> 0x002c }
            boolean r2 = isSameRecording(r13, r2)     // Catch:{ all -> 0x002c }
            if (r2 != 0) goto L_0x002e
            java.lang.String r14 = "Recorder"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x002c }
            r15.<init>(r0)     // Catch:{ all -> 0x002c }
            androidx.camera.video.OutputOptions r13 = r13.getOutputOptions()     // Catch:{ all -> 0x002c }
            r15.append(r13)     // Catch:{ all -> 0x002c }
            java.lang.String r13 = r15.toString()     // Catch:{ all -> 0x002c }
            androidx.camera.core.Logger.d(r14, r13)     // Catch:{ all -> 0x002c }
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            return
        L_0x002c:
            r13 = move-exception
            goto L_0x0097
        L_0x002e:
            androidx.camera.video.Recorder$State r0 = r12.mState     // Catch:{ all -> 0x002c }
            int r0 = r0.ordinal()     // Catch:{ all -> 0x002c }
            r2 = 0
            switch(r0) {
                case 0: goto L_0x008f;
                case 1: goto L_0x0063;
                case 2: goto L_0x0063;
                case 3: goto L_0x008f;
                case 4: goto L_0x0043;
                case 5: goto L_0x0043;
                case 6: goto L_0x0039;
                case 7: goto L_0x0039;
                default: goto L_0x0038;
            }     // Catch:{ all -> 0x002c }
        L_0x0038:
            goto L_0x0074
        L_0x0039:
            androidx.camera.video.Recorder$RecordingRecord r0 = r12.mActiveRecordingRecord     // Catch:{ all -> 0x002c }
            boolean r13 = isSameRecording(r13, r0)     // Catch:{ all -> 0x002c }
            androidx.core.util.Preconditions.checkState(r13)     // Catch:{ all -> 0x002c }
            goto L_0x0074
        L_0x0043:
            androidx.camera.video.Recorder$State r13 = androidx.camera.video.Recorder.State.STOPPING     // Catch:{ all -> 0x002c }
            r12.setState(r13)     // Catch:{ all -> 0x002c }
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x002c }
            long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x002c }
            long r8 = r13.toMicros(r3)     // Catch:{ all -> 0x002c }
            androidx.camera.video.Recorder$RecordingRecord r7 = r12.mActiveRecordingRecord     // Catch:{ all -> 0x002c }
            java.util.concurrent.Executor r13 = r12.mSequentialExecutor     // Catch:{ all -> 0x002c }
            androidx.camera.video.e r0 = new androidx.camera.video.e     // Catch:{ all -> 0x002c }
            r5 = r0
            r6 = r12
            r10 = r14
            r11 = r15
            r5.<init>(r6, r7, r8, r10, r11)     // Catch:{ all -> 0x002c }
            r13.execute(r0)     // Catch:{ all -> 0x002c }
            goto L_0x0074
        L_0x0063:
            androidx.camera.video.Recorder$RecordingRecord r0 = r12.mPendingRecordingRecord     // Catch:{ all -> 0x002c }
            boolean r13 = isSameRecording(r13, r0)     // Catch:{ all -> 0x002c }
            androidx.core.util.Preconditions.checkState(r13)     // Catch:{ all -> 0x002c }
            androidx.camera.video.Recorder$RecordingRecord r13 = r12.mPendingRecordingRecord     // Catch:{ all -> 0x002c }
            r12.mPendingRecordingRecord = r2     // Catch:{ all -> 0x002c }
            r12.restoreNonPendingState()     // Catch:{ all -> 0x002c }
            r2 = r13
        L_0x0074:
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            if (r2 == 0) goto L_0x008e
            r13 = 10
            if (r14 != r13) goto L_0x0082
            java.lang.String r13 = "Recorder"
            java.lang.String r14 = "Recording was stopped due to recording being garbage collected before any valid data has been produced."
            androidx.camera.core.Logger.e(r13, r14)
        L_0x0082:
            java.lang.RuntimeException r13 = new java.lang.RuntimeException
            java.lang.String r14 = "Recording was stopped before any data could be produced."
            r13.<init>(r14, r15)
            r14 = 8
            r12.finalizePendingRecording(r2, r14, r13)
        L_0x008e:
            return
        L_0x008f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002c }
            java.lang.String r14 = "Calling stop() while idling or initializing is invalid."
            r13.<init>(r14)     // Catch:{ all -> 0x002c }
            throw r13     // Catch:{ all -> 0x002c }
        L_0x0097:
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.stop(androidx.camera.video.Recording, int, java.lang.Throwable):void");
    }

    /* renamed from: stopInternal */
    public void lambda$stop$5(@NonNull RecordingRecord recordingRecord, long j, int i, @Nullable Throwable th) {
        if (this.mInProgressRecording == recordingRecord && !this.mInProgressRecordingStopping) {
            this.mInProgressRecordingStopping = true;
            this.mRecordingStopError = i;
            this.mRecordingStopErrorCause = th;
            if (isAudioEnabled()) {
                clearPendingAudioRingBuffer();
                this.mAudioEncoder.stop(j);
            }
            EncodedData encodedData = this.mPendingFirstVideoData;
            if (encodedData != null) {
                encodedData.close();
                this.mPendingFirstVideoData = null;
            }
            if (this.mSourceState != VideoOutput.SourceState.ACTIVE_NON_STREAMING) {
                this.mSourceNonStreamingTimeout = scheduleTask(new gd(this.mVideoEncoder, 2), this.mSequentialExecutor, 1000, TimeUnit.MILLISECONDS);
            } else {
                notifyEncoderSourceStopped(this.mVideoEncoder);
            }
            this.mVideoEncoder.stop(j);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r1 != 2) goto L_0x0011;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void tryServicePendingRecording() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.mLock
            monitor-enter(r0)
            androidx.camera.video.Recorder$State r1 = r7.mState     // Catch:{ all -> 0x0033 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0033 }
            r2 = 1
            r3 = 0
            r4 = 0
            if (r1 == r2) goto L_0x0015
            r5 = 2
            if (r1 == r5) goto L_0x0016
        L_0x0011:
            r1 = r4
            r2 = r1
            r5 = 0
            goto L_0x0047
        L_0x0015:
            r2 = 0
        L_0x0016:
            androidx.camera.video.Recorder$RecordingRecord r1 = r7.mActiveRecordingRecord     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x0045
            boolean r1 = r7.mNeedsResetBeforeNextStart     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x001f
            goto L_0x0045
        L_0x001f:
            androidx.camera.video.VideoOutput$SourceState r1 = r7.mSourceState     // Catch:{ all -> 0x0033 }
            androidx.camera.video.VideoOutput$SourceState r5 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x0033 }
            if (r1 != r5) goto L_0x0035
            androidx.camera.video.Recorder$RecordingRecord r1 = r7.mPendingRecordingRecord     // Catch:{ all -> 0x0033 }
            r7.mPendingRecordingRecord = r4     // Catch:{ all -> 0x0033 }
            r7.restoreNonPendingState()     // Catch:{ all -> 0x0033 }
            java.lang.Exception r3 = PENDING_RECORDING_ERROR_CAUSE_SOURCE_INACTIVE     // Catch:{ all -> 0x0033 }
            r5 = 4
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x0047
        L_0x0033:
            r1 = move-exception
            goto L_0x0054
        L_0x0035:
            androidx.camera.video.internal.encoder.Encoder r1 = r7.mVideoEncoder     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0045
            androidx.camera.video.Recorder$State r1 = r7.mState     // Catch:{ all -> 0x0033 }
            androidx.camera.video.Recorder$RecordingRecord r1 = r7.makePendingRecordingActiveLocked(r1)     // Catch:{ all -> 0x0033 }
            r3 = r2
            r2 = r4
            r5 = 0
            r4 = r1
            r1 = r2
            goto L_0x0047
        L_0x0045:
            r3 = r2
            goto L_0x0011
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x004e
            r7.startRecording(r4, r3)
            goto L_0x0053
        L_0x004e:
            if (r1 == 0) goto L_0x0053
            r7.finalizePendingRecording(r1, r5, r2)
        L_0x0053:
            return
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.tryServicePendingRecording():void");
    }

    public void updateInProgressStatusEvent() {
        RecordingRecord recordingRecord = this.mInProgressRecording;
        if (recordingRecord != null) {
            recordingRecord.updateVideoRecordEvent(VideoRecordEvent.status(recordingRecord.getOutputOptions(), getInProgressRecordingStats()));
        }
    }

    public void writeAudioData(@NonNull EncodedData encodedData, @NonNull RecordingRecord recordingRecord) {
        boolean z;
        RecordingRecord recordingRecord2 = recordingRecord;
        long size = encodedData.size() + this.mRecordingBytes;
        long j = this.mFileSizeLimitInBytes;
        if (j == 0 || size <= j) {
            long presentationTimeUs = encodedData.getPresentationTimeUs();
            long j2 = this.mFirstRecordingAudioDataTimeUs;
            if (j2 == LocationRequestCompat.PASSIVE_INTERVAL) {
                this.mFirstRecordingAudioDataTimeUs = presentationTimeUs;
                Logger.d(TAG, String.format("First audio time: %d (%s)", new Object[]{Long.valueOf(presentationTimeUs), DebugUtils.readableUs(this.mFirstRecordingAudioDataTimeUs)}));
            } else {
                TimeUnit timeUnit = TimeUnit.MICROSECONDS;
                long nanos = timeUnit.toNanos(presentationTimeUs - Math.min(this.mFirstRecordingVideoDataTimeUs, j2));
                if (this.mPreviousRecordingAudioDataTimeUs != LocationRequestCompat.PASSIVE_INTERVAL) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkState(z, "There should be a previous data for adjusting the duration.");
                long nanos2 = timeUnit.toNanos(presentationTimeUs - this.mPreviousRecordingAudioDataTimeUs) + nanos;
                long j3 = this.mDurationLimitNs;
                if (j3 != 0 && nanos2 > j3) {
                    Logger.d(TAG, String.format("Audio data reaches duration limit %d > %d", new Object[]{Long.valueOf(nanos2), Long.valueOf(this.mDurationLimitNs)}));
                    onInProgressRecordingInternalError(recordingRecord2, 9, (Throwable) null);
                    return;
                }
            }
            this.mMediaMuxer.writeSampleData(this.mAudioTrackIndex.intValue(), encodedData.getByteBuffer(), encodedData.getBufferInfo());
            this.mRecordingBytes = size;
            this.mPreviousRecordingAudioDataTimeUs = presentationTimeUs;
            return;
        }
        Logger.d(TAG, String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)}));
        onInProgressRecordingInternalError(recordingRecord2, 2, (Throwable) null);
    }

    public void writeVideoData(@NonNull EncodedData encodedData, @NonNull RecordingRecord recordingRecord) {
        long j;
        boolean z;
        RecordingRecord recordingRecord2 = recordingRecord;
        if (this.mVideoTrackIndex != null) {
            long size = encodedData.size() + this.mRecordingBytes;
            long j2 = this.mFileSizeLimitInBytes;
            long j3 = 0;
            if (j2 == 0 || size <= j2) {
                long presentationTimeUs = encodedData.getPresentationTimeUs();
                long j4 = this.mFirstRecordingVideoDataTimeUs;
                if (j4 == LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.mFirstRecordingVideoDataTimeUs = presentationTimeUs;
                    Logger.d(TAG, String.format("First video time: %d (%s)", new Object[]{Long.valueOf(presentationTimeUs), DebugUtils.readableUs(this.mFirstRecordingVideoDataTimeUs)}));
                    j = presentationTimeUs;
                } else {
                    TimeUnit timeUnit = TimeUnit.MICROSECONDS;
                    long nanos = timeUnit.toNanos(presentationTimeUs - Math.min(j4, this.mFirstRecordingAudioDataTimeUs));
                    if (this.mPreviousRecordingVideoDataTimeUs != LocationRequestCompat.PASSIVE_INTERVAL) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Preconditions.checkState(z, "There should be a previous data for adjusting the duration.");
                    long nanos2 = timeUnit.toNanos(presentationTimeUs - this.mPreviousRecordingVideoDataTimeUs) + nanos;
                    j = presentationTimeUs;
                    long j5 = this.mDurationLimitNs;
                    if (j5 == 0 || nanos2 <= j5) {
                        j3 = nanos;
                    } else {
                        Logger.d(TAG, String.format("Video data reaches duration limit %d > %d", new Object[]{Long.valueOf(nanos2), Long.valueOf(this.mDurationLimitNs)}));
                        onInProgressRecordingInternalError(recordingRecord2, 9, (Throwable) null);
                        return;
                    }
                }
                this.mMediaMuxer.writeSampleData(this.mVideoTrackIndex.intValue(), encodedData.getByteBuffer(), encodedData.getBufferInfo());
                this.mRecordingBytes = size;
                this.mRecordingDurationNs = j3;
                this.mPreviousRecordingVideoDataTimeUs = j;
                updateInProgressStatusEvent();
                return;
            }
            Logger.d(TAG, String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.mFileSizeLimitInBytes)}));
            onInProgressRecordingInternalError(recordingRecord2, 2, (Throwable) null);
            return;
        }
        throw new AssertionError("Video data comes before the track is added to MediaMuxer.");
    }

    @NonNull
    public static VideoCapabilities getVideoCapabilities(@NonNull CameraInfo cameraInfo, int i) {
        return new RecorderVideoCapabilities(i, (CameraInfoInternal) cameraInfo, VideoEncoderInfoImpl.FINDER);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onSurfaceRequested(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase) {
        synchronized (this.mLock) {
            try {
                Logger.d(TAG, "Surface is requested in state: " + this.mState + ", Current surface: " + this.mStreamId);
                if (this.mState == State.ERROR) {
                    setState(State.CONFIGURING);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.mSequentialExecutor.execute(new m0(this, 11, surfaceRequest, timebase));
    }

    @RequiresApi(26)
    @NonNull
    public PendingRecording prepareRecording(@NonNull Context context, @NonNull FileDescriptorOutputOptions fileDescriptorOutputOptions) {
        if (Build.VERSION.SDK_INT >= 26) {
            return prepareRecordingInternal(context, fileDescriptorOutputOptions);
        }
        throw new UnsupportedOperationException("File descriptors as output destinations are not supported on pre-Android O (API 26) devices.");
    }

    @NonNull
    public PendingRecording prepareRecording(@NonNull Context context, @NonNull MediaStoreOutputOptions mediaStoreOutputOptions) {
        return prepareRecordingInternal(context, mediaStoreOutputOptions);
    }
}
