package defpackage;

import androidx.arch.core.util.Function;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraController;
import kotlin.jvm.functions.Function1;

/* renamed from: g2  reason: default package */
public final /* synthetic */ class g2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f194a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g2(Object obj, int i) {
        this.f194a = i;
        this.b = obj;
    }

    public final Object apply(Object obj) {
        switch (this.f194a) {
            case 0:
                return ((CameraController) this.b).enableTorch(((Boolean) obj).booleanValue());
            case 1:
                return ((CameraController) this.b).setLinearZoom(((Float) obj).floatValue());
            case 2:
                return ((CameraController) this.b).setZoomRatio(((Float) obj).floatValue());
            default:
                return ProcessCameraProvider.Companion.getInstance$lambda$0((Function1) this.b, obj);
        }
    }
}
