package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

class MeteringRepeatingSession {
    private static final int IMAGE_FORMAT = 34;
    private static final String TAG = "MeteringRepeating";
    @Nullable
    private SessionConfig.CloseableErrorListener mCloseableErrorListener = null;
    @NonNull
    private final MeteringRepeatingConfig mConfigWithDefaults = new MeteringRepeatingConfig();
    private DeferrableSurface mDeferrableSurface;
    @NonNull
    private final Size mMeteringRepeatingSize;
    @NonNull
    private SessionConfig mSessionConfig;
    @NonNull
    private final SupportedRepeatingSurfaceSize mSupportedRepeatingSurfaceSize = new SupportedRepeatingSurfaceSize();
    @Nullable
    private final SurfaceResetCallback mSurfaceResetCallback;

    public static class MeteringRepeatingConfig implements UseCaseConfig<UseCase> {
        @NonNull
        private final Config mConfig;

        public MeteringRepeatingConfig() {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new Camera2SessionOptionUnpacker());
            create.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
            setTargetConfigs(create);
            this.mConfig = create;
        }

        private void setTargetConfigs(MutableOptionsBundle mutableOptionsBundle) {
            Class<MeteringRepeatingSession> cls = MeteringRepeatingSession.class;
            mutableOptionsBundle.insertOption(TargetConfig.OPTION_TARGET_CLASS, cls);
            mutableOptionsBundle.insertOption(TargetConfig.OPTION_TARGET_NAME, cls.getCanonicalName() + "-" + UUID.randomUUID());
        }

        public final /* synthetic */ boolean containsOption(Config.Option option) {
            return ld.a(this, option);
        }

        public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            ld.b(this, str, optionMatcher);
        }

        public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
            return qg.a(this);
        }

        @NonNull
        public UseCaseConfigFactory.CaptureType getCaptureType() {
            return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        }

        @NonNull
        public Config getConfig() {
            return this.mConfig;
        }

        public final /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
            return qg.d(this);
        }

        public final /* synthetic */ SessionConfig getDefaultSessionConfig() {
            return qg.f(this);
        }

        public final /* synthetic */ DynamicRange getDynamicRange() {
            return ma.a(this);
        }

        public final /* synthetic */ int getInputFormat() {
            return ma.b(this);
        }

        public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return ld.c(this, option);
        }

        public final /* synthetic */ int getPreviewStabilizationMode() {
            return qg.h(this);
        }

        public final /* synthetic */ Set getPriorities(Config.Option option) {
            return ld.d(this, option);
        }

        public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
            return qg.i(this);
        }

        public final /* synthetic */ int getSurfaceOccupancyPriority() {
            return qg.k(this);
        }

        public final /* synthetic */ Class getTargetClass() {
            return xf.a(this);
        }

        public final /* synthetic */ Range getTargetFrameRate() {
            return qg.m(this);
        }

        public final /* synthetic */ String getTargetName() {
            return xf.c(this);
        }

        public final /* synthetic */ int getVideoStabilizationMode() {
            return qg.o(this);
        }

        public final /* synthetic */ boolean hasDynamicRange() {
            return ma.c(this);
        }

        public final /* synthetic */ boolean isHighResolutionDisabled(boolean z) {
            return qg.p(this, z);
        }

        public final /* synthetic */ boolean isZslDisabled(boolean z) {
            return qg.q(this, z);
        }

        public final /* synthetic */ Set listOptions() {
            return ld.e(this);
        }

        public final /* synthetic */ Object retrieveOption(Config.Option option) {
            return ld.f(this, option);
        }

        public final /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return ld.h(this, option, optionPriority);
        }

        public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            return qg.b(this, optionUnpacker);
        }

        public final /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
            return qg.e(this, captureConfig);
        }

        public final /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
            return qg.g(this, sessionConfig);
        }

        public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            return qg.j(this, optionUnpacker);
        }

        public final /* synthetic */ int getSurfaceOccupancyPriority(int i) {
            return qg.l(this, i);
        }

        public final /* synthetic */ Class getTargetClass(Class cls) {
            return xf.b(this, cls);
        }

        public final /* synthetic */ Range getTargetFrameRate(Range range) {
            return qg.n(this, range);
        }

        public final /* synthetic */ String getTargetName(String str) {
            return xf.d(this, str);
        }

        public final /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return ld.g(this, option, obj);
        }
    }

    public interface SurfaceResetCallback {
        void onSurfaceReset();
    }

    public MeteringRepeatingSession(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull DisplayInfoManager displayInfoManager, @Nullable SurfaceResetCallback surfaceResetCallback) {
        this.mSurfaceResetCallback = surfaceResetCallback;
        Size properPreviewSize = getProperPreviewSize(cameraCharacteristicsCompat, displayInfoManager);
        this.mMeteringRepeatingSize = properPreviewSize;
        Logger.d(TAG, "MeteringSession SurfaceTexture size: " + properPreviewSize);
        this.mSessionConfig = createSessionConfig();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, java.util.Comparator] */
    @NonNull
    private Size getProperPreviewSize(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull DisplayInfoManager displayInfoManager) {
        Size[] outputSizes = cameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(34);
        if (outputSizes == null) {
            Logger.e(TAG, "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] supportedSizes = this.mSupportedRepeatingSurfaceSize.getSupportedSizes(outputSizes);
        List asList = Arrays.asList(supportedSizes);
        Collections.sort(asList, new Object());
        Size previewSize = displayInfoManager.getPreviewSize();
        long min = Math.min(((long) previewSize.getWidth()) * ((long) previewSize.getHeight()), 307200);
        int length = supportedSizes.length;
        Size size = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Size size2 = supportedSizes[i];
            int i2 = ((((long) size2.getWidth()) * ((long) size2.getHeight())) > min ? 1 : ((((long) size2.getWidth()) * ((long) size2.getHeight())) == min ? 0 : -1));
            if (i2 == 0) {
                return size2;
            }
            if (i2 <= 0) {
                i++;
                size = size2;
            } else if (size != null) {
                return size;
            }
        }
        return (Size) asList.get(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createSessionConfig$0(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.mSessionConfig = createSessionConfig();
        SurfaceResetCallback surfaceResetCallback = this.mSurfaceResetCallback;
        if (surfaceResetCallback != null) {
            surfaceResetCallback.onSurfaceReset();
        }
    }

    public void clear() {
        Logger.d(TAG, "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = null;
    }

    @NonNull
    public SessionConfig createSessionConfig() {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(this.mMeteringRepeatingSize.getWidth(), this.mMeteringRepeatingSize.getHeight());
        final Surface surface = new Surface(surfaceTexture);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(this.mConfigWithDefaults, this.mMeteringRepeatingSize);
        createFrom.setTemplateType(1);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        this.mDeferrableSurface = immediateSurface;
        Futures.addCallback(immediateSurface.getTerminationFuture(), new FutureCallback<Void>() {
            public void onFailure(@NonNull Throwable th) {
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            }

            public void onSuccess(@Nullable Void voidR) {
                surface.release();
                surfaceTexture.release();
            }
        }, CameraXExecutors.directExecutor());
        createFrom.addSurface(this.mDeferrableSurface);
        SessionConfig.CloseableErrorListener closeableErrorListener = this.mCloseableErrorListener;
        if (closeableErrorListener != null) {
            closeableErrorListener.close();
        }
        SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new k0(this));
        this.mCloseableErrorListener = closeableErrorListener2;
        createFrom.setErrorListener(closeableErrorListener2);
        return createFrom.build();
    }

    @NonNull
    public Size getMeteringRepeatingSize() {
        return this.mMeteringRepeatingSize;
    }

    @NonNull
    public String getName() {
        return TAG;
    }

    @NonNull
    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    @NonNull
    public UseCaseConfig<?> getUseCaseConfig() {
        return this.mConfigWithDefaults;
    }
}
