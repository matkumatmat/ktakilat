package androidx.camera.extensions.internal;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import java.util.Set;

public class RequestOptionConfig implements ReadableConfig {
    static final String CAPTURE_REQUEST_ID_STEM = "camera2.captureRequest.option.";
    @NonNull
    private Config mConfig;

    public static class Builder {
        private MutableOptionsBundle mMutableOptionsBundle = MutableOptionsBundle.create();

        @NonNull
        public static Builder from(@NonNull Config config) {
            Builder builder = new Builder();
            config.findOptions("camera2.captureRequest.option.", new t2(27, builder, config));
            return builder;
        }

        @NonNull
        public RequestOptionConfig build() {
            return new RequestOptionConfig(OptionsBundle.from(this.mMutableOptionsBundle));
        }

        @NonNull
        public <ValueT> Builder setCaptureRequestOption(@NonNull CaptureRequest.Key<ValueT> key, @NonNull ValueT valuet) {
            this.mMutableOptionsBundle.insertOption(RequestOptionConfig.createOptionFromKey(key), valuet);
            return this;
        }
    }

    @VisibleForTesting
    @NonNull
    public static Config.Option<Object> createOptionFromKey(@NonNull CaptureRequest.Key<?> key) {
        return Config.Option.create("camera2.captureRequest.option." + key.getName(), Object.class, key);
    }

    public final /* synthetic */ boolean containsOption(Config.Option option) {
        return ld.a(this, option);
    }

    public final /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        ld.b(this, str, optionMatcher);
    }

    @NonNull
    public Config getConfig() {
        return this.mConfig;
    }

    public final /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
        return ld.c(this, option);
    }

    public final /* synthetic */ Set getPriorities(Config.Option option) {
        return ld.d(this, option);
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

    private RequestOptionConfig(@NonNull Config config) {
        this.mConfig = config;
    }

    public final /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
        return ld.g(this, option, obj);
    }
}
