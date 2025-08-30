package defpackage;

import androidx.camera.core.CameraExecutor;
import androidx.camera.core.Logger;
import com.appsflyer.internal.AFc1eSDK;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: h2  reason: default package */
public final /* synthetic */ class h2 implements RejectedExecutionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f196a;

    public /* synthetic */ h2(int i) {
        this.f196a = i;
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        switch (this.f196a) {
            case 0:
                Logger.e(CameraExecutor.TAG, "A rejected execution occurred in CameraExecutor!");
                return;
            default:
                AFc1eSDK.getMediationNetwork(runnable, threadPoolExecutor);
                return;
        }
    }
}
