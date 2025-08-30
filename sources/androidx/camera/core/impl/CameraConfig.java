package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.Config;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface CameraConfig extends ReadableConfig {
    public static final Config.Option<Boolean> OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED;
    public static final Config.Option<Identifier> OPTION_COMPATIBILITY_ID = Config.Option.create("camerax.core.camera.compatibilityId", Identifier.class);
    public static final Config.Option<Boolean> OPTION_POSTVIEW_SUPPORTED;
    public static final Config.Option<SessionProcessor> OPTION_SESSION_PROCESSOR = Config.Option.create("camerax.core.camera.SessionProcessor", SessionProcessor.class);
    public static final Config.Option<UseCaseConfigFactory> OPTION_USECASE_CONFIG_FACTORY = Config.Option.create("camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);
    public static final Config.Option<Integer> OPTION_USE_CASE_COMBINATION_REQUIRED_RULE = Config.Option.create("camerax.core.camera.useCaseCombinationRequiredRule", Integer.class);
    public static final Config.Option<Boolean> OPTION_ZSL_DISABLED;
    public static final int REQUIRED_RULE_COEXISTING_PREVIEW_AND_IMAGE_CAPTURE = 1;
    public static final int REQUIRED_RULE_NONE = 0;

    public interface Builder<B> {
        B setCaptureProcessProgressSupported(boolean z);

        @NonNull
        B setCompatibilityId(@NonNull Identifier identifier);

        B setPostviewSupported(boolean z);

        @NonNull
        B setSessionProcessor(@NonNull SessionProcessor sessionProcessor);

        @NonNull
        B setUseCaseCombinationRequiredRule(int i);

        @NonNull
        B setUseCaseConfigFactory(@NonNull UseCaseConfigFactory useCaseConfigFactory);

        @NonNull
        B setZslDisabled(boolean z);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RequiredRule {
    }

    static {
        Class<Boolean> cls = Boolean.class;
        OPTION_ZSL_DISABLED = Config.Option.create("camerax.core.camera.isZslDisabled", cls);
        OPTION_POSTVIEW_SUPPORTED = Config.Option.create("camerax.core.camera.isPostviewSupported", cls);
        OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED = Config.Option.create("camerax.core.camera.isCaptureProcessProgressSupported", cls);
    }

    @NonNull
    Identifier getCompatibilityId();

    @NonNull
    SessionProcessor getSessionProcessor();

    @Nullable
    SessionProcessor getSessionProcessor(@Nullable SessionProcessor sessionProcessor);

    int getUseCaseCombinationRequiredRule();

    @NonNull
    UseCaseConfigFactory getUseCaseConfigFactory();

    boolean isCaptureProcessProgressSupported();

    boolean isPostviewSupported();
}
