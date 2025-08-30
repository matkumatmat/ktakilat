package androidx.camera.video;

import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

final class VideoEncoderSession {
    private static final String TAG = "VideoEncoderSession";
    private Surface mActiveSurface = null;
    private final Executor mExecutor;
    private Executor mOnSurfaceUpdateExecutor = null;
    private Encoder.SurfaceInput.OnSurfaceUpdateListener mOnSurfaceUpdateListener = null;
    private CallbackToFutureAdapter.Completer<Encoder> mReadyToReleaseCompleter = null;
    private ListenableFuture<Encoder> mReadyToReleaseFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private CallbackToFutureAdapter.Completer<Void> mReleasedCompleter = null;
    private ListenableFuture<Void> mReleasedFuture = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));
    private final Executor mSequentialExecutor;
    private SurfaceRequest mSurfaceRequest = null;
    private Encoder mVideoEncoder = null;
    private final EncoderFactory mVideoEncoderFactory;
    private VideoEncoderState mVideoEncoderState = VideoEncoderState.NOT_INITIALIZED;

    public enum VideoEncoderState {
        NOT_INITIALIZED,
        INITIALIZING,
        PENDING_RELEASE,
        READY,
        RELEASED
    }

    public VideoEncoderSession(@NonNull EncoderFactory encoderFactory, @NonNull Executor executor, @NonNull Executor executor2) {
        this.mExecutor = executor2;
        this.mSequentialExecutor = executor;
        this.mVideoEncoderFactory = encoderFactory;
    }

    private void closeInternal() {
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            terminateNow();
        } else if (ordinal == 2 || ordinal == 3) {
            Logger.d(TAG, "closeInternal in " + this.mVideoEncoderState + " state");
            this.mVideoEncoderState = VideoEncoderState.PENDING_RELEASE;
        } else if (ordinal == 4) {
            Logger.d(TAG, "closeInternal in RELEASED state, No-op");
        } else {
            throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
        }
    }

    private void configureVideoEncoderInternal(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, @NonNull MediaSpec mediaSpec, @NonNull CallbackToFutureAdapter.Completer<Encoder> completer) {
        DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
        try {
            Encoder createEncoder = this.mVideoEncoderFactory.createEncoder(this.mExecutor, VideoConfigUtil.resolveVideoEncoderConfig(VideoConfigUtil.resolveVideoMimeInfo(mediaSpec, dynamicRange, videoValidatedEncoderProfilesProxy), timebase, mediaSpec.getVideoSpec(), surfaceRequest.getResolution(), dynamicRange, surfaceRequest.getExpectedFrameRate()));
            this.mVideoEncoder = createEncoder;
            Encoder.EncoderInput input = createEncoder.getInput();
            if (!(input instanceof Encoder.SurfaceInput)) {
                completer.setException(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
            } else {
                ((Encoder.SurfaceInput) input).setOnSurfaceUpdateListener(this.mSequentialExecutor, new o(this, completer, surfaceRequest));
            }
        } catch (InvalidConfigException e) {
            Logger.e(TAG, "Unable to initialize video encoder.", e);
            completer.setException(e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$0(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReleasedCompleter = completer;
        return "ReleasedFuture " + this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$1(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mReadyToReleaseCompleter = completer;
        return "ReadyToReleaseFuture " + this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$configure$2(SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, MediaSpec mediaSpec, CallbackToFutureAdapter.Completer completer) throws Exception {
        configureVideoEncoderInternal(surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec, completer);
        return "ConfigureVideoEncoderFuture " + this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$configureVideoEncoderInternal$4(Surface surface) {
        this.mOnSurfaceUpdateListener.onSurfaceUpdate(surface);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$configureVideoEncoderInternal$5(CallbackToFutureAdapter.Completer completer, SurfaceRequest surfaceRequest, Surface surface) {
        Executor executor;
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        if (!(this.mOnSurfaceUpdateListener == null || (executor = this.mOnSurfaceUpdateExecutor) == null)) {
                            executor.execute(new k(2, this, surface));
                        }
                        Logger.w(TAG, "Surface is updated in READY state: " + surface);
                        return;
                    } else if (ordinal != 4) {
                        throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
                    }
                }
            } else if (surfaceRequest.isServiced()) {
                Logger.d(TAG, "Not provide surface, " + Objects.toString(surfaceRequest, "EMPTY") + " is already serviced.");
                completer.set(null);
                closeInternal();
                return;
            } else {
                this.mActiveSurface = surface;
                Logger.d(TAG, "provide surface: " + surface);
                surfaceRequest.provideSurface(surface, this.mSequentialExecutor, new g(this, 2));
                this.mVideoEncoderState = VideoEncoderState.READY;
                completer.set(this.mVideoEncoder);
                return;
            }
        }
        Logger.d(TAG, "Not provide surface in " + this.mVideoEncoderState);
        completer.set(null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$terminateNow$3() {
        this.mReleasedCompleter.set(null);
    }

    /* access modifiers changed from: private */
    public void onSurfaceRequestComplete(@NonNull SurfaceRequest.Result result) {
        Logger.d(TAG, "Surface can be closed: " + result.getSurface().hashCode());
        Surface surface = result.getSurface();
        if (surface == this.mActiveSurface) {
            this.mActiveSurface = null;
            this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
            closeInternal();
            return;
        }
        surface.release();
    }

    @NonNull
    public ListenableFuture<Encoder> configure(@NonNull SurfaceRequest surfaceRequest, @NonNull Timebase timebase, @NonNull MediaSpec mediaSpec, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        if (this.mVideoEncoderState.ordinal() != 0) {
            return Futures.immediateFailedFuture(new IllegalStateException("configure() shouldn't be called in " + this.mVideoEncoderState));
        }
        this.mVideoEncoderState = VideoEncoderState.INITIALIZING;
        this.mSurfaceRequest = surfaceRequest;
        Logger.d(TAG, "Create VideoEncoderSession: " + this);
        this.mReleasedFuture = CallbackToFutureAdapter.getFuture(new p(this, 0));
        this.mReadyToReleaseFuture = CallbackToFutureAdapter.getFuture(new p(this, 1));
        ListenableFuture future = CallbackToFutureAdapter.getFuture(new q(this, surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, mediaSpec));
        Futures.addCallback(future, new FutureCallback<Encoder>() {
            public void onFailure(@NonNull Throwable th) {
                Logger.w(VideoEncoderSession.TAG, "VideoEncoder configuration failed.", th);
                VideoEncoderSession.this.terminateNow();
            }

            public void onSuccess(@Nullable Encoder encoder) {
            }
        }, this.mSequentialExecutor);
        return Futures.nonCancellationPropagating(future);
    }

    @Nullable
    public Surface getActiveSurface() {
        if (this.mVideoEncoderState != VideoEncoderState.READY) {
            return null;
        }
        return this.mActiveSurface;
    }

    @NonNull
    public ListenableFuture<Encoder> getReadyToReleaseFuture() {
        return Futures.nonCancellationPropagating(this.mReadyToReleaseFuture);
    }

    @Nullable
    public Encoder getVideoEncoder() {
        return this.mVideoEncoder;
    }

    public boolean isConfiguredSurfaceRequest(@NonNull SurfaceRequest surfaceRequest) {
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal == 0) {
            return false;
        }
        if (ordinal != 1) {
            if (ordinal == 2) {
                return false;
            }
            if (ordinal != 3) {
                if (ordinal == 4) {
                    return false;
                }
                throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
            }
        }
        if (this.mSurfaceRequest == surfaceRequest) {
            return true;
        }
        return false;
    }

    public void setOnSurfaceUpdateListener(@NonNull Executor executor, @NonNull Encoder.SurfaceInput.OnSurfaceUpdateListener onSurfaceUpdateListener) {
        this.mOnSurfaceUpdateExecutor = executor;
        this.mOnSurfaceUpdateListener = onSurfaceUpdateListener;
    }

    @NonNull
    public ListenableFuture<Void> signalTermination() {
        closeInternal();
        return Futures.nonCancellationPropagating(this.mReleasedFuture);
    }

    public void terminateNow() {
        int ordinal = this.mVideoEncoderState.ordinal();
        if (ordinal == 0) {
            this.mVideoEncoderState = VideoEncoderState.RELEASED;
        } else if (ordinal == 1 || ordinal == 2 || ordinal == 3) {
            this.mVideoEncoderState = VideoEncoderState.RELEASED;
            this.mReadyToReleaseCompleter.set(this.mVideoEncoder);
            this.mSurfaceRequest = null;
            if (this.mVideoEncoder != null) {
                Logger.d(TAG, "VideoEncoder is releasing: " + this.mVideoEncoder);
                this.mVideoEncoder.release();
                this.mVideoEncoder.getReleasedFuture().addListener(new m(this, 1), this.mSequentialExecutor);
                this.mVideoEncoder = null;
                return;
            }
            Logger.w(TAG, "There's no VideoEncoder to release! Finish release completer.");
            this.mReleasedCompleter.set(null);
        } else if (ordinal == 4) {
            Logger.d(TAG, "terminateNow in " + this.mVideoEncoderState + ", No-op");
        } else {
            throw new IllegalStateException("State " + this.mVideoEncoderState + " is not handled");
        }
    }

    @NonNull
    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.mSurfaceRequest, "SURFACE_REQUEST_NOT_CONFIGURED");
    }
}
