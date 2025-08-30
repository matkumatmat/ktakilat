package defpackage;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import com.android.installreferrer.api.InstallReferrerClient;
import com.appsflyer.internal.AFj1sSDK;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.web.WebViewCache;
import java.util.ArrayDeque;

/* renamed from: v  reason: default package */
public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ int c;

    public /* synthetic */ v(int i) {
        this.c = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                AlarmManagerSchedulerBroadcastReceiver.lambda$onReceive$0();
                return;
            case 1:
                Camera2CameraControlImpl.lambda$clearInteropConfig$1();
                return;
            case 2:
                Camera2CameraControlImpl.lambda$addInteropConfig$0();
                return;
            case 3:
                CrashlyticsWorker.lambda$await$6();
                return;
            case 4:
                DefaultSurfaceProcessor.lambda$executeSafely$11();
                return;
            case 5:
                DualSurfaceProcessor.lambda$executeSafely$7();
                return;
            case 6:
                ArrayDeque arrayDeque = WebViewCache.b;
                if (arrayDeque.size() < 2) {
                    InstallReferrerClient installReferrerClient = KtakilatApplication.j;
                    arrayDeque.add(new CommonWebView(BaseApplication.e));
                    arrayDeque.add(new CommonWebView(BaseApplication.e));
                    arrayDeque.add(new CommonWebView(BaseApplication.e));
                    return;
                }
                return;
            default:
                AFj1sSDK.getCurrencyIso4217Code();
                return;
        }
    }
}
