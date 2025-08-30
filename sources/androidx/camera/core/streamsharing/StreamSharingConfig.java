package androidx.camera.core.streamsharing;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class StreamSharingConfig implements UseCaseConfig<StreamSharing>, ImageOutputConfig, ThreadConfig {
    static final Config.Option<List<UseCaseConfigFactory.CaptureType>> OPTION_CAPTURE_TYPES = Config.Option.create("camerax.core.streamSharing.captureTypes", List.class);
    private final OptionsBundle mConfig;

    public StreamSharingConfig(@NonNull OptionsBundle optionsBundle) {
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

    public final /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return qg.a(this);
    }

    public final /* synthetic */ UseCaseConfigFactory.CaptureType getCaptureType() {
        return qg.c(this);
    }

    @NonNull
    public List<UseCaseConfigFactory.CaptureType> getCaptureTypes() {
        return (List) ld.f(this, OPTION_CAPTURE_TYPES);
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

    public final /* synthetic */ int getInputFormat() {
        return ma.b(this);
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
