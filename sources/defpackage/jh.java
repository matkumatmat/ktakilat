package defpackage;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.streamsharing.VirtualCameraControl;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* renamed from: jh  reason: default package */
public final /* synthetic */ class jh implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VirtualCameraControl f203a;
    public final /* synthetic */ List b;

    public /* synthetic */ jh(VirtualCameraControl virtualCameraControl, List list) {
        this.f203a = virtualCameraControl;
        this.b = list;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f203a.lambda$submitStillCaptureRequests$1(this.b, (Void) obj);
    }
}
