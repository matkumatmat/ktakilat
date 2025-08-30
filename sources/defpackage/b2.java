package defpackage;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.UseCaseConfigFactory;

/* renamed from: b2  reason: default package */
public final /* synthetic */ class b2 implements UseCaseConfigFactory.Provider {
    public final UseCaseConfigFactory newInstance(Context context) {
        return Camera2Config.lambda$defaultConfig$1(context);
    }
}
