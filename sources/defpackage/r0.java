package defpackage;

import android.content.IntentSender;
import android.util.Log;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.profileinstaller.DeviceProfileWriter;
import kotlin.jvm.functions.Function0;
import org.apache.commons.lang3.StringUtils;

/* renamed from: r0  reason: default package */
public final /* synthetic */ class r0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ r0(int i, ExposureControl exposureControl, CallbackToFutureAdapter.Completer completer) {
        this.c = 4;
        this.e = exposureControl;
        this.f = completer;
        this.d = i;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                Log.e("baidu_face", "百度sdk初始化失败 = " + this.d + StringUtils.SPACE + ((String) this.e));
                ((Function0) this.f).invoke();
                return;
            case 1:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0((ComponentActivity$activityResultRegistry$1) this.e, this.d, (ActivityResultContract.SynchronousResult) this.f);
                return;
            case 2:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1((ComponentActivity$activityResultRegistry$1) this.e, this.d, (IntentSender.SendIntentException) this.f);
                return;
            case 3:
                ((DeviceProfileWriter) this.e).lambda$result$0(this.d, this.f);
                return;
            default:
                ((ExposureControl) this.e).lambda$setExposureCompensationIndex$1((CallbackToFutureAdapter.Completer) this.f, this.d);
                return;
        }
    }

    public /* synthetic */ r0(int i, String str, Function0 function0) {
        this.c = 0;
        this.d = i;
        this.e = str;
        this.f = function0;
    }

    public /* synthetic */ r0(Object obj, int i, Object obj2, int i2) {
        this.c = i2;
        this.e = obj;
        this.d = i;
        this.f = obj2;
    }
}
