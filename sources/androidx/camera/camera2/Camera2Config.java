package androidx.camera.camera2;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Set;

public final class Camera2Config {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class DefaultProvider implements CameraXConfig.Provider {
        @NonNull
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }

    private Camera2Config() {
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, androidx.camera.core.impl.CameraFactory$Provider] */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider] */
    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, androidx.camera.core.impl.UseCaseConfigFactory$Provider] */
    @NonNull
    public static CameraXConfig defaultConfig() {
        ? obj = new Object();
        ? obj2 = new Object();
        return new CameraXConfig.Builder().setCameraFactoryProvider(obj).setDeviceSurfaceManagerProvider(obj2).setUseCaseConfigFactoryProvider(new Object()).build();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ CameraDeviceSurfaceManager lambda$defaultConfig$0(Context context, Object obj, Set set) throws InitializationException {
        try {
            return new Camera2DeviceSurfaceManager(context, obj, set);
        } catch (CameraUnavailableException e) {
            throw new InitializationException((Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ UseCaseConfigFactory lambda$defaultConfig$1(Context context) throws InitializationException {
        return new Camera2UseCaseConfigFactory(context);
    }
}
