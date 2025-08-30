package androidx.camera.lifecycle;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.camera.core.impl.utils.ContextUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Landroidx/camera/lifecycle/ProcessCameraProvider;", "kotlin.jvm.PlatformType", "cameraX", "Landroidx/camera/core/CameraX;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class ProcessCameraProvider$Companion$getInstance$1 extends Lambda implements Function1<CameraX, ProcessCameraProvider> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProcessCameraProvider$Companion$getInstance$1(Context context) {
        super(1);
        this.$context = context;
    }

    public final ProcessCameraProvider invoke(CameraX cameraX) {
        ProcessCameraProvider access$getSAppInstance$cp = ProcessCameraProvider.sAppInstance;
        Intrinsics.checkNotNullExpressionValue(cameraX, "cameraX");
        access$getSAppInstance$cp.setCameraX(cameraX);
        ProcessCameraProvider access$getSAppInstance$cp2 = ProcessCameraProvider.sAppInstance;
        Context applicationContext = ContextUtil.getApplicationContext(this.$context);
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(context)");
        access$getSAppInstance$cp2.setContext(applicationContext);
        return ProcessCameraProvider.sAppInstance;
    }
}
