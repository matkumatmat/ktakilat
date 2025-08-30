package defpackage;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* renamed from: v1  reason: default package */
public final /* synthetic */ class v1 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControlImpl f213a;
    public final /* synthetic */ List b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public /* synthetic */ v1(Camera2CameraControlImpl camera2CameraControlImpl, List list, int i, int i2, int i3) {
        this.f213a = camera2CameraControlImpl;
        this.b = list;
        this.c = i;
        this.d = i2;
        this.e = i3;
    }

    public final ListenableFuture apply(Object obj) {
        int i = this.c;
        int i2 = this.d;
        return this.f213a.lambda$submitStillCaptureRequests$4(this.b, i, i2, this.e, (Void) obj);
    }
}
