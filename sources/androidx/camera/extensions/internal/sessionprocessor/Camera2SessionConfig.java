package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;

interface Camera2SessionConfig {
    @NonNull
    List<Camera2OutputConfig> getOutputConfigs();

    @NonNull
    Map<CaptureRequest.Key<?>, Object> getSessionParameters();

    int getSessionTemplateId();

    int getSessionType();
}
