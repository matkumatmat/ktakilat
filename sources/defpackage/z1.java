package defpackage;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;

/* renamed from: z1  reason: default package */
public final /* synthetic */ class z1 implements CameraFactory.Provider {
    public final CameraFactory newInstance(Context context, CameraThreadConfig cameraThreadConfig, CameraSelector cameraSelector, long j) {
        return new Camera2CameraFactory(context, cameraThreadConfig, cameraSelector, j);
    }
}
