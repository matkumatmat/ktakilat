package androidx.camera.camera2.internal.compat;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;

public abstract /* synthetic */ class k {
    public static CameraManagerCompat.CameraManagerCompatImpl a(Context context, Handler handler) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            return new CameraManagerCompatApi30Impl(context);
        }
        if (i >= 29) {
            return new CameraManagerCompatApi29Impl(context);
        }
        if (i >= 28) {
            return CameraManagerCompatApi28Impl.create(context);
        }
        return CameraManagerCompatBaseImpl.create(context, handler);
    }
}
