package defpackage;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: w1  reason: default package */
public final /* synthetic */ class w1 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControlImpl f216a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ w1(Camera2CameraControlImpl camera2CameraControlImpl, int i, int i2, int i3) {
        this.f216a = camera2CameraControlImpl;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final ListenableFuture apply(Object obj) {
        int i = this.b;
        int i2 = this.c;
        return this.f216a.lambda$getCameraCapturePipelineAsync$5(i, i2, this.d, (Void) obj);
    }
}
