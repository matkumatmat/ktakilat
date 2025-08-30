package defpackage;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import java.util.Set;

/* renamed from: a2  reason: default package */
public final /* synthetic */ class a2 implements CameraDeviceSurfaceManager.Provider {
    public final CameraDeviceSurfaceManager newInstance(Context context, Object obj, Set set) {
        return Camera2Config.lambda$defaultConfig$0(context, obj, set);
    }
}
