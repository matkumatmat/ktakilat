package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.Config;
import java.util.Set;

public class CameraConfigs {
    private static final CameraConfig DEFAULT_CAMERA_CONFIG = new DefaultCameraConfig();

    public static final class DefaultCameraConfig implements CameraConfig {
        private final Identifier mIdentifier = Identifier.create(new Object());

        public final /* synthetic */ boolean containsOption(Config.Option option) {
            return ld.a(this, option);
        }

        public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            ld.b(this, str, optionMatcher);
        }

        @NonNull
        public Identifier getCompatibilityId() {
            return this.mIdentifier;
        }

        @NonNull
        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }

        public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return ld.c(this, option);
        }

        public final /* synthetic */ Set getPriorities(Config.Option option) {
            return ld.d(this, option);
        }

        public final /* synthetic */ SessionProcessor getSessionProcessor() {
            return d2.a(this);
        }

        public final /* synthetic */ int getUseCaseCombinationRequiredRule() {
            return d2.c(this);
        }

        public final /* synthetic */ UseCaseConfigFactory getUseCaseConfigFactory() {
            return d2.d(this);
        }

        public final /* synthetic */ boolean isCaptureProcessProgressSupported() {
            return d2.e(this);
        }

        public final /* synthetic */ boolean isPostviewSupported() {
            return d2.f(this);
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

        public final /* synthetic */ SessionProcessor getSessionProcessor(SessionProcessor sessionProcessor) {
            return d2.b(this, sessionProcessor);
        }

        public final /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return ld.g(this, option, obj);
        }
    }

    private CameraConfigs() {
    }

    @NonNull
    public static CameraConfig defaultConfig() {
        return DEFAULT_CAMERA_CONFIG;
    }
}
