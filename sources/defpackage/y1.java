package defpackage;

import androidx.camera.camera2.internal.concurrent.Camera2CameraCoordinator;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Identifier;
import java.util.List;

/* renamed from: y1  reason: default package */
public final /* synthetic */ class y1 implements CameraFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f218a;
    public final /* synthetic */ Object b;

    public /* synthetic */ y1(Object obj, int i) {
        this.f218a = i;
        this.b = obj;
    }

    public final List filter(List list) {
        switch (this.f218a) {
            case 0:
                return Camera2CameraCoordinator.lambda$createCameraSelectorById$0((String) this.b, list);
            default:
                return n2.e((CameraInfoInternal) this.b, list);
        }
    }

    public final /* synthetic */ Identifier getIdentifier() {
        switch (this.f218a) {
            case 0:
                return k2.a(this);
            default:
                return k2.a(this);
        }
    }
}
