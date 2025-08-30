package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class ImageAnalysisConfig implements UseCaseConfig<ImageAnalysis>, ImageOutputConfig, ThreadConfig {
    public static final Config.Option<Integer> OPTION_BACKPRESSURE_STRATEGY = Config.Option.create("camerax.core.imageAnalysis.backpressureStrategy", ImageAnalysis.BackpressureStrategy.class);
    public static final Config.Option<Integer> OPTION_IMAGE_QUEUE_DEPTH = Config.Option.create("camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create("camerax.core.imageAnalysis.imageReaderProxyProvider", ImageReaderProxyProvider.class);
    public static final Config.Option<Boolean> OPTION_ONE_PIXEL_SHIFT_ENABLED;
    public static final Config.Option<Integer> OPTION_OUTPUT_IMAGE_FORMAT = Config.Option.create("camerax.core.imageAnalysis.outputImageFormat", ImageAnalysis.OutputImageFormat.class);
    public static final Config.Option<Boolean> OPTION_OUTPUT_IMAGE_ROTATION_ENABLED;
    private final OptionsBundle mConfig;

    static {
        Class<Boolean> cls = Boolean.class;
        OPTION_ONE_PIXEL_SHIFT_ENABLED = Config.Option.create("camerax.core.imageAnalysis.onePixelShiftEnabled", cls);
        OPTION_OUTPUT_IMAGE_ROTATION_ENABLED = Config.Option.create("camerax.core.imageAnalysis.outputImageRotationEnabled", cls);
    }

    public ImageAnalysisConfig(@NonNull OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public final /* synthetic */ boolean containsOption(Config.Option option) {
        return ld.a(this, option);
    }

    public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        ld.b(this, str, optionMatcher);
    }

    public final /* synthetic */ int getAppTargetRotation(int i) {
        return na.a(this, i);
    }

    public final /* synthetic */ Executor getBackgroundExecutor() {
        return yf.a(this);
    }

    public int getBackpressureStrategy(int i) {
        return ((Integer) ld.g(this, OPTION_BACKPRESSURE_STRATEGY, Integer.valueOf(i))).intValue();
    }

    public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return qg.a(this);
    }

    public final /* synthetic */ UseCaseConfigFactory.CaptureType getCaptureType() {
        return qg.c(this);
    }

    @NonNull
    public Config getConfig() {
        return this.mConfig;
    }

    public final /* synthetic */ List getCustomOrderedResolutions() {
        return na.b(this);
    }

    public final /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
        return qg.d(this);
    }

    public final /* synthetic */ Size getDefaultResolution() {
        return na.d(this);
    }

    public final /* synthetic */ SessionConfig getDefaultSessionConfig() {
        return qg.f(this);
    }

    public final /* synthetic */ DynamicRange getDynamicRange() {
        return ma.a(this);
    }

    public int getImageQueueDepth(int i) {
        return ((Integer) ld.g(this, OPTION_IMAGE_QUEUE_DEPTH, Integer.valueOf(i))).intValue();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return (ImageReaderProxyProvider) ld.g(this, OPTION_IMAGE_READER_PROXY_PROVIDER, (Object) null);
    }

    public int getInputFormat() {
        return 35;
    }

    public final /* synthetic */ Size getMaxResolution() {
        return na.f(this);
    }

    public final /* synthetic */ int getMirrorMode(int i) {
        return na.h(this, i);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Boolean getOnePixelShiftEnabled(@Nullable Boolean bool) {
        return (Boolean) ld.g(this, OPTION_ONE_PIXEL_SHIFT_ENABLED, bool);
    }

    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return ld.c(this, option);
    }

    public int getOutputImageFormat(int i) {
        return ((Integer) ld.g(this, OPTION_OUTPUT_IMAGE_FORMAT, Integer.valueOf(i))).intValue();
    }

    public final /* synthetic */ int getPreviewStabilizationMode() {
        return qg.h(this);
    }

    public final /* synthetic */ Set getPriorities(Config.Option option) {
        return ld.d(this, option);
    }

    public final /* synthetic */ ResolutionSelector getResolutionSelector() {
        return na.i(this);
    }

    public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return qg.i(this);
    }

    public final /* synthetic */ List getSupportedResolutions() {
        return na.k(this);
    }

    public final /* synthetic */ int getSurfaceOccupancyPriority() {
        return qg.k(this);
    }

    public final /* synthetic */ int getTargetAspectRatio() {
        return na.m(this);
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

    public final /* synthetic */ Size getTargetResolution() {
        return na.n(this);
    }

    public final /* synthetic */ int getTargetRotation() {
        return na.p(this);
    }

    public final /* synthetic */ int getVideoStabilizationMode() {
        return qg.o(this);
    }

    public final /* synthetic */ boolean hasDynamicRange() {
        return ma.c(this);
    }

    public final /* synthetic */ boolean hasTargetAspectRatio() {
        return na.r(this);
    }

    public final /* synthetic */ boolean isHighResolutionDisabled(boolean z) {
        return qg.p(this, z);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Boolean isOutputImageRotationEnabled(@Nullable Boolean bool) {
        return (Boolean) ld.g(this, OPTION_OUTPUT_IMAGE_ROTATION_ENABLED, bool);
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

    public final /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return yf.b(this, executor);
    }

    public int getBackpressureStrategy() {
        return ((Integer) ld.f(this, OPTION_BACKPRESSURE_STRATEGY)).intValue();
    }

    public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        return qg.b(this, optionUnpacker);
    }

    public final /* synthetic */ List getCustomOrderedResolutions(List list) {
        return na.c(this, list);
    }

    public final /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
        return qg.e(this, captureConfig);
    }

    public final /* synthetic */ Size getDefaultResolution(Size size) {
        return na.e(this, size);
    }

    public final /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
        return qg.g(this, sessionConfig);
    }

    public int getImageQueueDepth() {
        return ((Integer) ld.f(this, OPTION_IMAGE_QUEUE_DEPTH)).intValue();
    }

    public final /* synthetic */ Size getMaxResolution(Size size) {
        return na.g(this, size);
    }

    public final /* synthetic */ ResolutionSelector getResolutionSelector(ResolutionSelector resolutionSelector) {
        return na.j(this, resolutionSelector);
    }

    public final /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        return qg.j(this, optionUnpacker);
    }

    public final /* synthetic */ List getSupportedResolutions(List list) {
        return na.l(this, list);
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

    public final /* synthetic */ Size getTargetResolution(Size size) {
        return na.o(this, size);
    }

    public final /* synthetic */ int getTargetRotation(int i) {
        return na.q(this, i);
    }

    public final /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
        return ld.g(this, option, obj);
    }
}
