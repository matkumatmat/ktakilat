package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Camera2SessionConfigBuilder {
    private List<Camera2OutputConfig> mCamera2OutputConfigs = new ArrayList();
    private Map<CaptureRequest.Key<?>, Object> mSessionParameters = new HashMap();
    private int mSessionTemplateId = 1;
    private int mSessionType = 0;

    public static class SessionConfigImpl implements Camera2SessionConfig {
        private final List<Camera2OutputConfig> mCamera2OutputConfigs;
        private final Map<CaptureRequest.Key<?>, Object> mSessionParameters;
        private final int mSessionTemplateId;
        private final int mSessionType;

        public SessionConfigImpl(int i, int i2, Map<CaptureRequest.Key<?>, Object> map, List<Camera2OutputConfig> list) {
            this.mSessionTemplateId = i;
            this.mSessionType = i2;
            this.mSessionParameters = map;
            this.mCamera2OutputConfigs = list;
        }

        @NonNull
        public List<Camera2OutputConfig> getOutputConfigs() {
            return this.mCamera2OutputConfigs;
        }

        @NonNull
        public Map<CaptureRequest.Key<?>, Object> getSessionParameters() {
            return this.mSessionParameters;
        }

        public int getSessionTemplateId() {
            return this.mSessionTemplateId;
        }

        public int getSessionType() {
            return this.mSessionType;
        }
    }

    @NonNull
    public Camera2SessionConfigBuilder addOutputConfig(@NonNull Camera2OutputConfig camera2OutputConfig) {
        this.mCamera2OutputConfigs.add(camera2OutputConfig);
        return this;
    }

    @NonNull
    public Camera2SessionConfigBuilder addSessionParameter(@NonNull CaptureRequest.Key key, @Nullable Object obj) {
        this.mSessionParameters.put(key, obj);
        return this;
    }

    @NonNull
    public Camera2SessionConfig build() {
        return new SessionConfigImpl(this.mSessionTemplateId, this.mSessionType, this.mSessionParameters, this.mCamera2OutputConfigs);
    }

    @NonNull
    public List<Camera2OutputConfig> getCamera2OutputConfigs() {
        return this.mCamera2OutputConfigs;
    }

    @NonNull
    public Map<CaptureRequest.Key<?>, Object> getSessionParameters() {
        return this.mSessionParameters;
    }

    public int getSessionTemplateId() {
        return this.mSessionTemplateId;
    }

    @NonNull
    public Camera2SessionConfigBuilder setSessionTemplateId(int i) {
        this.mSessionTemplateId = i;
        return this;
    }

    @NonNull
    public Camera2SessionConfigBuilder setSessionType(int i) {
        this.mSessionType = i;
        return this;
    }
}
