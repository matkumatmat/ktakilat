package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.encoder.InputBuffer;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class AudioSource {
    @VisibleForTesting
    static final long DEFAULT_START_RETRY_INTERVAL_MS = 3000;
    private static final String TAG = "AudioSource";
    @Nullable
    private FutureCallback<InputBuffer> mAcquireBufferCallback;
    long mAmplitudeTimestamp;
    double mAudioAmplitude;
    private final int mAudioFormat;
    @VisibleForTesting
    public final int mAudioSource;
    @Nullable
    AudioSourceCallback mAudioSourceCallback;
    final AudioStream mAudioStream;
    boolean mAudioStreamSilenced;
    @Nullable
    BufferProvider<? extends InputBuffer> mBufferProvider;
    @NonNull
    BufferProvider.State mBufferProviderState;
    @Nullable
    Executor mCallbackExecutor;
    final Executor mExecutor;
    boolean mInSilentStartState;
    boolean mIsSendingAudio;
    private long mLatestFailedStartTimeNs;
    boolean mMuted;
    final AtomicReference<Boolean> mNotifiedSilenceState;
    final AtomicBoolean mNotifiedSuspendState;
    final SilentAudioStream mSilentAudioStream;
    private final long mStartRetryIntervalNs;
    @NonNull
    InternalState mState;
    @Nullable
    private Observable.Observer<BufferProvider.State> mStateObserver;
    @Nullable
    private byte[] mZeroBytes;

    public interface AudioSourceCallback {
        void onAmplitudeValue(double d);

        void onError(@NonNull Throwable th);

        void onSilenceStateChanged(boolean z);

        @VisibleForTesting
        void onSuspendStateChanged(boolean z);
    }

    public class AudioStreamCallback implements AudioStream.AudioStreamCallback {
        public AudioStreamCallback() {
        }

        public void onSilenceStateChanged(boolean z) {
            AudioSource audioSource = AudioSource.this;
            audioSource.mAudioStreamSilenced = z;
            if (audioSource.mState == InternalState.STARTED) {
                audioSource.notifySilenced();
            }
        }
    }

    public enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [androidx.camera.video.internal.audio.AudioStreamFactory, java.lang.Object] */
    @RequiresPermission("android.permission.RECORD_AUDIO")
    public AudioSource(@NonNull AudioSettings audioSettings, @NonNull Executor executor, @Nullable Context context) throws AudioSourceAccessException {
        this(audioSettings, executor, context, new Object(), DEFAULT_START_RETRY_INTERVAL_MS);
    }

    @Nullable
    private static BufferProvider.State fetchBufferProviderState(@NonNull BufferProvider<? extends InputBuffer> bufferProvider) {
        try {
            ListenableFuture<? extends InputBuffer> fetchData = bufferProvider.fetchData();
            if (fetchData.isDone()) {
                return (BufferProvider.State) fetchData.get();
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    private static long getCurrentSystemTimeNs() {
        return System.nanoTime();
    }

    public static boolean isSettingsSupported(int i, int i2, int i3) {
        return AudioStreamImpl.isSettingsSupported(i, i2, i3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$mute$7(boolean z) {
        int ordinal = this.mState.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            if (this.mMuted != z) {
                this.mMuted = z;
                if (this.mState == InternalState.STARTED) {
                    notifySilenced();
                }
            }
        } else if (ordinal == 2) {
            throw new AssertionError("AudioSource is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postMaxAmplitude$11(AudioSourceCallback audioSourceCallback) {
        audioSourceCallback.onAmplitudeValue(this.mAudioAmplitude);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4(CallbackToFutureAdapter.Completer completer) {
        try {
            int ordinal = this.mState.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                resetBufferProvider((BufferProvider<? extends InputBuffer>) null);
                this.mSilentAudioStream.release();
                this.mAudioStream.release();
                stopSendingAudio();
                setState(InternalState.RELEASED);
            }
            completer.set(null);
        } catch (Throwable th) {
            completer.setException(th);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$release$5(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new e0(3, this, completer));
        return "AudioSource-release";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setAudioSourceCallback$6(Executor executor, AudioSourceCallback audioSourceCallback) {
        int ordinal = this.mState.ordinal();
        if (ordinal == 0) {
            this.mCallbackExecutor = executor;
            this.mAudioSourceCallback = audioSourceCallback;
        } else if (ordinal == 1 || ordinal == 2) {
            throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setBufferProvider$0(BufferProvider bufferProvider) {
        int ordinal = this.mState.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            if (this.mBufferProvider != bufferProvider) {
                resetBufferProvider(bufferProvider);
            }
        } else if (ordinal == 2) {
            throw new AssertionError("AudioSource is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$1() {
        start(this.mMuted);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$start$2(boolean z) {
        int ordinal = this.mState.ordinal();
        if (ordinal == 0) {
            this.mNotifiedSilenceState.set((Object) null);
            this.mNotifiedSuspendState.set(false);
            setState(InternalState.STARTED);
            mute(z);
            updateSendingAudio();
        } else if (ordinal == 2) {
            throw new AssertionError("AudioSource is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stop$3() {
        int ordinal = this.mState.ordinal();
        if (ordinal == 1) {
            setState(InternalState.CONFIGURED);
            updateSendingAudio();
        } else if (ordinal == 2) {
            Logger.w(TAG, "AudioSource is released. Calling stop() is a no-op.");
        }
    }

    private void resetBufferProvider(@Nullable final BufferProvider<? extends InputBuffer> bufferProvider) {
        BufferProvider<? extends InputBuffer> bufferProvider2 = this.mBufferProvider;
        if (bufferProvider2 != null) {
            Observable.Observer<BufferProvider.State> observer = this.mStateObserver;
            Objects.requireNonNull(observer);
            bufferProvider2.removeObserver(observer);
            this.mBufferProvider = null;
            this.mStateObserver = null;
            this.mAcquireBufferCallback = null;
            this.mBufferProviderState = BufferProvider.State.INACTIVE;
            updateSendingAudio();
        }
        if (bufferProvider != null) {
            this.mBufferProvider = bufferProvider;
            this.mStateObserver = new Observable.Observer<BufferProvider.State>() {
                public void onError(@NonNull Throwable th) {
                    AudioSource audioSource = AudioSource.this;
                    if (audioSource.mBufferProvider == bufferProvider) {
                        audioSource.notifyError(th);
                    }
                }

                public void onNewData(@Nullable BufferProvider.State state) {
                    Objects.requireNonNull(state);
                    if (AudioSource.this.mBufferProvider == bufferProvider) {
                        Logger.d(AudioSource.TAG, "Receive BufferProvider state change: " + AudioSource.this.mBufferProviderState + " to " + state);
                        AudioSource audioSource = AudioSource.this;
                        if (audioSource.mBufferProviderState != state) {
                            audioSource.mBufferProviderState = state;
                            audioSource.updateSendingAudio();
                        }
                    }
                }
            };
            this.mAcquireBufferCallback = new FutureCallback<InputBuffer>() {
                public void onFailure(@NonNull Throwable th) {
                    if (AudioSource.this.mBufferProvider == bufferProvider) {
                        Logger.d(AudioSource.TAG, "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
                        if (!(th instanceof IllegalStateException)) {
                            AudioSource.this.notifyError(th);
                        }
                    }
                }

                public void onSuccess(InputBuffer inputBuffer) {
                    AudioSource audioSource = AudioSource.this;
                    if (!audioSource.mIsSendingAudio || audioSource.mBufferProvider != bufferProvider) {
                        inputBuffer.cancel();
                        return;
                    }
                    if (audioSource.mInSilentStartState && audioSource.isStartRetryIntervalReached()) {
                        AudioSource.this.retryStartAudioStream();
                    }
                    AudioStream currentAudioStream = AudioSource.this.getCurrentAudioStream();
                    ByteBuffer byteBuffer = inputBuffer.getByteBuffer();
                    AudioStream.PacketInfo read = currentAudioStream.read(byteBuffer);
                    if (read.getSizeInBytes() > 0) {
                        AudioSource audioSource2 = AudioSource.this;
                        if (audioSource2.mMuted) {
                            audioSource2.overrideBySilence(byteBuffer, read.getSizeInBytes());
                        }
                        if (AudioSource.this.mCallbackExecutor != null) {
                            long timestampNs = read.getTimestampNs();
                            AudioSource audioSource3 = AudioSource.this;
                            if (timestampNs - audioSource3.mAmplitudeTimestamp >= 200) {
                                audioSource3.mAmplitudeTimestamp = read.getTimestampNs();
                                AudioSource.this.postMaxAmplitude(byteBuffer);
                            }
                        }
                        byteBuffer.limit(read.getSizeInBytes() + byteBuffer.position());
                        inputBuffer.setPresentationTimeUs(TimeUnit.NANOSECONDS.toMicros(read.getTimestampNs()));
                        inputBuffer.submit();
                    } else {
                        Logger.w(AudioSource.TAG, "Unable to read data from AudioStream.");
                        inputBuffer.cancel();
                    }
                    AudioSource.this.sendNextAudio();
                }
            };
            BufferProvider.State fetchBufferProviderState = fetchBufferProviderState(bufferProvider);
            if (fetchBufferProviderState != null) {
                this.mBufferProviderState = fetchBufferProviderState;
                updateSendingAudio();
            }
            this.mBufferProvider.addObserver(this.mExecutor, this.mStateObserver);
        }
    }

    private void startSendingAudio() {
        if (!this.mIsSendingAudio) {
            try {
                Logger.d(TAG, "startSendingAudio");
                this.mAudioStream.start();
                this.mInSilentStartState = false;
            } catch (AudioStream.AudioStreamException e) {
                Logger.w(TAG, "Failed to start AudioStream", e);
                this.mInSilentStartState = true;
                this.mSilentAudioStream.start();
                this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
                notifySilenced();
            }
            this.mIsSendingAudio = true;
            sendNextAudio();
        }
    }

    private void stopSendingAudio() {
        if (this.mIsSendingAudio) {
            this.mIsSendingAudio = false;
            Logger.d(TAG, "stopSendingAudio");
            this.mAudioStream.stop();
        }
    }

    @NonNull
    public AudioStream getCurrentAudioStream() {
        if (this.mInSilentStartState) {
            return this.mSilentAudioStream;
        }
        return this.mAudioStream;
    }

    public boolean isStartRetryIntervalReached() {
        boolean z;
        if (this.mLatestFailedStartTimeNs > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (getCurrentSystemTimeNs() - this.mLatestFailedStartTimeNs >= this.mStartRetryIntervalNs) {
            return true;
        }
        return false;
    }

    public void mute(boolean z) {
        this.mExecutor.execute(new i0(this, z, 0));
    }

    public void notifyError(@NonNull Throwable th) {
        Executor executor = this.mCallbackExecutor;
        AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor != null && audioSourceCallback != null) {
            executor.execute(new e0(2, audioSourceCallback, th));
        }
    }

    public void notifySilenced() {
        boolean z;
        Executor executor = this.mCallbackExecutor;
        AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor != null && audioSourceCallback != null) {
            if (this.mMuted || this.mInSilentStartState || this.mAudioStreamSilenced) {
                z = true;
            } else {
                z = false;
            }
            if (!Objects.equals(this.mNotifiedSilenceState.getAndSet(Boolean.valueOf(z)), Boolean.valueOf(z))) {
                executor.execute(new l0(audioSourceCallback, z, 0));
            }
        }
    }

    public void notifySuspended(boolean z) {
        Executor executor = this.mCallbackExecutor;
        AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (executor != null && audioSourceCallback != null && this.mNotifiedSuspendState.getAndSet(z) != z) {
            executor.execute(new l0(audioSourceCallback, z, 1));
        }
    }

    public void overrideBySilence(@NonNull ByteBuffer byteBuffer, int i) {
        byte[] bArr = this.mZeroBytes;
        if (bArr == null || bArr.length < i) {
            this.mZeroBytes = new byte[i];
        }
        int position = byteBuffer.position();
        byteBuffer.put(this.mZeroBytes, 0, i);
        byteBuffer.limit(byteBuffer.position()).position(position);
    }

    public void postMaxAmplitude(ByteBuffer byteBuffer) {
        Executor executor = this.mCallbackExecutor;
        AudioSourceCallback audioSourceCallback = this.mAudioSourceCallback;
        if (this.mAudioFormat == 2) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            double d = 0.0d;
            while (asShortBuffer.hasRemaining()) {
                d = Math.max(d, (double) Math.abs(asShortBuffer.get()));
            }
            this.mAudioAmplitude = d / 32767.0d;
            if (executor != null && audioSourceCallback != null) {
                executor.execute(new e0(4, this, audioSourceCallback));
            }
        }
    }

    @NonNull
    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.getFuture(new k0(this, 0));
    }

    public void retryStartAudioStream() {
        Preconditions.checkState(this.mInSilentStartState);
        try {
            this.mAudioStream.start();
            Logger.d(TAG, "Retry start AudioStream succeed");
            this.mSilentAudioStream.stop();
            this.mInSilentStartState = false;
        } catch (AudioStream.AudioStreamException e) {
            Logger.w(TAG, "Retry start AudioStream failed", e);
            this.mLatestFailedStartTimeNs = getCurrentSystemTimeNs();
        }
    }

    public void sendNextAudio() {
        BufferProvider<? extends InputBuffer> bufferProvider = this.mBufferProvider;
        Objects.requireNonNull(bufferProvider);
        ListenableFuture acquireBuffer = bufferProvider.acquireBuffer();
        FutureCallback<InputBuffer> futureCallback = this.mAcquireBufferCallback;
        Objects.requireNonNull(futureCallback);
        Futures.addCallback(acquireBuffer, futureCallback, this.mExecutor);
    }

    public void setAudioSourceCallback(@NonNull Executor executor, @NonNull AudioSourceCallback audioSourceCallback) {
        this.mExecutor.execute(new m0(this, 0, executor, audioSourceCallback));
    }

    public void setBufferProvider(@NonNull BufferProvider<? extends InputBuffer> bufferProvider) {
        this.mExecutor.execute(new e0(1, this, bufferProvider));
    }

    public void setState(InternalState internalState) {
        Logger.d(TAG, "Transitioning internal state: " + this.mState + " --> " + internalState);
        this.mState = internalState;
    }

    public void start() {
        this.mExecutor.execute(new j0(this, 1));
    }

    public void stop() {
        this.mExecutor.execute(new j0(this, 0));
    }

    public void updateSendingAudio() {
        boolean z;
        if (this.mState == InternalState.STARTED) {
            if (this.mBufferProviderState == BufferProvider.State.ACTIVE) {
                z = true;
            } else {
                z = false;
            }
            notifySuspended(!z);
            if (z) {
                startSendingAudio();
            } else {
                stopSendingAudio();
            }
        } else {
            stopSendingAudio();
        }
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @VisibleForTesting
    public AudioSource(@NonNull AudioSettings audioSettings, @NonNull Executor executor, @Nullable Context context, @NonNull AudioStreamFactory audioStreamFactory, long j) throws AudioSourceAccessException {
        this.mNotifiedSilenceState = new AtomicReference<>((Object) null);
        this.mNotifiedSuspendState = new AtomicBoolean(false);
        this.mState = InternalState.CONFIGURED;
        this.mBufferProviderState = BufferProvider.State.INACTIVE;
        this.mAmplitudeTimestamp = 0;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = newSequentialExecutor;
        this.mStartRetryIntervalNs = TimeUnit.MILLISECONDS.toNanos(j);
        try {
            BufferedAudioStream bufferedAudioStream = new BufferedAudioStream(audioStreamFactory.create(audioSettings, context), audioSettings);
            this.mAudioStream = bufferedAudioStream;
            bufferedAudioStream.setCallback(new AudioStreamCallback(), newSequentialExecutor);
            this.mSilentAudioStream = new SilentAudioStream(audioSettings);
            this.mAudioFormat = audioSettings.getAudioFormat();
            this.mAudioSource = audioSettings.getAudioSource();
        } catch (AudioStream.AudioStreamException | IllegalArgumentException e) {
            throw new AudioSourceAccessException("Unable to create AudioStream", e);
        }
    }

    public void start(boolean z) {
        this.mExecutor.execute(new i0(this, z, 1));
    }
}
