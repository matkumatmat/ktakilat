package androidx.camera.extensions;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Set;

class ExtensionsConfig implements CameraConfig {
    public static final Config.Option<Integer> OPTION_EXTENSION_MODE = Config.Option.create("camerax.extensions.extensionMode", Integer.TYPE);
    private final Config mConfig;

    public static final class Builder implements CameraConfig.Builder<Builder> {
        private final MutableOptionsBundle mConfig = MutableOptionsBundle.create();

        public ExtensionsConfig build() {
            return new ExtensionsConfig(this.mConfig);
        }

        public Builder setExtensionMode(int i) {
            this.mConfig.insertOption(ExtensionsConfig.OPTION_EXTENSION_MODE, Integer.valueOf(i));
            return this;
        }

        @NonNull
        public Builder setCaptureProcessProgressSupported(boolean z) {
            this.mConfig.insertOption(CameraConfig.OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED, Boolean.valueOf(z));
            return this;
        }

        @NonNull
        public Builder setCompatibilityId(@NonNull Identifier identifier) {
            this.mConfig.insertOption(CameraConfig.OPTION_COMPATIBILITY_ID, identifier);
            return this;
        }

        @NonNull
        public Builder setPostviewSupported(boolean z) {
            this.mConfig.insertOption(CameraConfig.OPTION_POSTVIEW_SUPPORTED, Boolean.valueOf(z));
            return this;
        }

        @NonNull
        public Builder setSessionProcessor(@NonNull SessionProcessor sessionProcessor) {
            this.mConfig.insertOption(CameraConfig.OPTION_SESSION_PROCESSOR, sessionProcessor);
            return this;
        }

        @NonNull
        public Builder setUseCaseCombinationRequiredRule(int i) {
            this.mConfig.insertOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, Integer.valueOf(i));
            return this;
        }

        @NonNull
        public Builder setUseCaseConfigFactory(@NonNull UseCaseConfigFactory useCaseConfigFactory) {
            this.mConfig.insertOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, useCaseConfigFactory);
            return this;
        }

        @NonNull
        public Builder setZslDisabled(boolean z) {
            this.mConfig.insertOption(CameraConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z));
            return this;
        }
    }

    public ExtensionsConfig(Config config) {
        this.mConfig = config;
    }

    public final /* synthetic */ boolean containsOption(Config.Option option) {
        return ld.a(this, option);
    }

    public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        ld.b(this, str, optionMatcher);
    }

    @NonNull
    public Identifier getCompatibilityId() {
        return (Identifier) ld.f(this, CameraConfig.OPTION_COMPATIBILITY_ID);
    }

    @NonNull
    public Config getConfig() {
        return this.mConfig;
    }

    public int getExtensionMode() {
        return ((Integer) ld.f(this, OPTION_EXTENSION_MODE)).intValue();
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
