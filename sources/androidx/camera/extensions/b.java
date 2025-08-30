package androidx.camera.extensions;

import android.content.Context;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;
import androidx.camera.core.impl.Identifier;

public final /* synthetic */ class b implements CameraConfigProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtensionsInfo f29a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Identifier c;

    public /* synthetic */ b(ExtensionsInfo extensionsInfo, int i, Identifier identifier) {
        this.f29a = extensionsInfo;
        this.b = i;
        this.c = identifier;
    }

    public final CameraConfig getConfig(CameraInfo cameraInfo, Context context) {
        return this.f29a.lambda$injectExtensionCameraConfig$1(this.b, this.c, cameraInfo, context);
    }
}
