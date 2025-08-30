package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class ImageCaptureConfig implements UseCaseConfig<ImageCapture>, ImageOutputConfig, IoConfig {
    public static final Config.Option<Integer> OPTION_BUFFER_FORMAT;
    public static final Config.Option<CaptureBundle> OPTION_CAPTURE_BUNDLE = Config.Option.create("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
    public static final Config.Option<Integer> OPTION_FLASH_MODE;
    public static final Config.Option<Integer> OPTION_FLASH_TYPE;
    public static final Config.Option<Integer> OPTION_IMAGE_CAPTURE_MODE;
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
    public static final Config.Option<Integer> OPTION_JPEG_COMPRESSION_QUALITY;
    public static final Config.Option<Integer> OPTION_MAX_CAPTURE_STAGES;
    public static final Config.Option<Integer> OPTION_OUTPUT_FORMAT;
    public static final Config.Option<Boolean> OPTION_POSTVIEW_ENABLED = Config.Option.create("camerax.core.useCase.isPostviewEnabled", Boolean.class);
    public static final Config.Option<ResolutionSelector> OPTION_POSTVIEW_RESOLUTION_SELECTOR = Config.Option.create("camerax.core.useCase.postviewResolutionSelector", ResolutionSelector.class);
    public static final Config.Option<ImageCapture.ScreenFlash> OPTION_SCREEN_FLASH = Config.Option.create("camerax.core.imageCapture.screenFlash", ImageCapture.ScreenFlash.class);
    public static final Config.Option<Boolean> OPTION_USE_SOFTWARE_JPEG_ENCODER = Config.Option.create("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
    private final OptionsBundle mConfig;

    static {
        Class cls = Integer.TYPE;
        OPTION_IMAGE_CAPTURE_MODE = Config.Option.create("camerax.core.imageCapture.captureMode", cls);
        OPTION_FLASH_MODE = Config.Option.create("camerax.core.imageCapture.flashMode", cls);
        Class<Integer> cls2 = Integer.class;
        OPTION_BUFFER_FORMAT = Config.Option.create("camerax.core.imageCapture.bufferFormat", cls2);
        OPTION_OUTPUT_FORMAT = Config.Option.create("camerax.core.imageCapture.outputFormat", cls2);
        OPTION_MAX_CAPTURE_STAGES = Config.Option.create("camerax.core.imageCapture.maxCaptureStages", cls2);
        OPTION_FLASH_TYPE = Config.Option.create("camerax.core.imageCapture.flashType", cls);
        OPTION_JPEG_COMPRESSION_QUALITY = Config.Option.create("camerax.core.imageCapture.jpegCompressionQuality", cls);
    }

    public ImageCaptureConfig(@NonNull OptionsBundle optionsBundle) {
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

    @Nullable
    public Integer getBufferFormat(@Nullable Integer num) {
        return (Integer) ld.g(this, OPTION_BUFFER_FORMAT, num);
    }

    @Nullable
    public CaptureBundle getCaptureBundle(@Nullable CaptureBundle captureBundle) {
        return (CaptureBundle) ld.g(this, OPTION_CAPTURE_BUNDLE, captureBundle);
    }

    public int getCaptureMode() {
        return ((Integer) ld.f(this, OPTION_IMAGE_CAPTURE_MODE)).intValue();
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

    public int getFlashMode(int i) {
        return ((Integer) ld.g(this, OPTION_FLASH_MODE, Integer.valueOf(i))).intValue();
    }

    public int getFlashType(int i) {
        return ((Integer) ld.g(this, OPTION_FLASH_TYPE, Integer.valueOf(i))).intValue();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return (ImageReaderProxyProvider) ld.g(this, OPTION_IMAGE_READER_PROXY_PROVIDER, (Object) null);
    }

    public int getInputFormat() {
        return ((Integer) ld.f(this, ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
    }

    @Nullable
    public Executor getIoExecutor(@Nullable Executor executor) {
        return (Executor) ld.g(this, IoConfig.OPTION_IO_EXECUTOR, executor);
    }

    @IntRange(from = 1, to = 100)
    public int getJpegQuality(@IntRange(from = 1, to = 100) int i) {
        return ((Integer) ld.g(this, OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(i))).intValue();
    }

    public int getMaxCaptureStages(int i) {
        return ((Integer) ld.g(this, OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(i))).intValue();
    }

    public final /* synthetic */ Size getMaxResolution() {
        return na.f(this);
    }

    public final /* synthetic */ int getMirrorMode(int i) {
        return na.h(this, i);
    }

    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return ld.c(this, option);
    }

    @Nullable
    public ResolutionSelector getPostviewResolutionSelector() {
        return (ResolutionSelector) ld.g(this, OPTION_POSTVIEW_RESOLUTION_SELECTOR, (Object) null);
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

    @Nullable
    public ImageCapture.ScreenFlash getScreenFlash() {
        return (ImageCapture.ScreenFlash) ld.g(this, OPTION_SCREEN_FLASH, (Object) null);
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

    public boolean hasCaptureMode() {
        return ld.a(this, OPTION_IMAGE_CAPTURE_MODE);
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

    public boolean isPostviewEnabled() {
        return ((Boolean) ld.g(this, OPTION_POSTVIEW_ENABLED, Boolean.FALSE)).booleanValue();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isSoftwareJpegEncoderRequested() {
        return ((Boolean) ld.g(this, OPTION_USE_SOFTWARE_JPEG_ENCODER, Boolean.FALSE)).booleanValue();
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

    @NonNull
    public Integer getBufferFormat() {
        return (Integer) ld.f(this, OPTION_BUFFER_FORMAT);
    }

    @NonNull
    public CaptureBundle getCaptureBundle() {
        return (CaptureBundle) ld.f(this, OPTION_CAPTURE_BUNDLE);
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

    public int getFlashMode() {
        return ((Integer) ld.f(this, OPTION_FLASH_MODE)).intValue();
    }

    public int getFlashType() {
        return ((Integer) ld.f(this, OPTION_FLASH_TYPE)).intValue();
    }

    @NonNull
    public Executor getIoExecutor() {
        return (Executor) ld.f(this, IoConfig.OPTION_IO_EXECUTOR);
    }

    @IntRange(from = 1, to = 100)
    public int getJpegQuality() {
        return ((Integer) ld.f(this, OPTION_JPEG_COMPRESSION_QUALITY)).intValue();
    }

    public int getMaxCaptureStages() {
        return ((Integer) ld.f(this, OPTION_MAX_CAPTURE_STAGES)).intValue();
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
