package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.CaptureConfig;

public interface CaptureStage {

    public static final class DefaultCaptureStage implements CaptureStage {
        private final CaptureConfig mCaptureConfig = new CaptureConfig.Builder().build();

        @NonNull
        public CaptureConfig getCaptureConfig() {
            return this.mCaptureConfig;
        }

        public int getId() {
            return 0;
        }
    }

    @NonNull
    CaptureConfig getCaptureConfig();

    int getId();
}
