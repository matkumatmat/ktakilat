package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.logging.type.LogSeverity;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import org.apache.commons.lang3.function.FailableIntConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

/* renamed from: g3  reason: default package */
public final /* synthetic */ class g3 implements BaseVerifyFaceActivity.IntentCallback, CallbackToFutureAdapter.Resolver, FailableRunnable, AccessibilityViewCommand {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ g3(Activity activity, int i) {
        this.c = i;
        this.d = activity;
    }

    public void a(Intent intent) {
        intent.putExtra("SMS_TYPE", this.c);
        int i = BaseVerifyFaceActivity.s;
        ((Activity) this.d).startActivityForResult(intent, LogSeverity.EMERGENCY_VALUE);
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((ExposureControl) this.d).lambda$setExposureCompensationIndex$2(this.c, completer);
    }

    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((SideSheetBehavior) this.d).lambda$createAccessibilityViewCommandForState$2(this.c, view, commandArguments);
    }

    public void run() {
        ((FailableIntConsumer) this.d).accept(this.c);
    }

    public /* synthetic */ g3(Object obj, int i) {
        this.d = obj;
        this.c = i;
    }
}
