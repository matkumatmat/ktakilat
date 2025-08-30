package defpackage;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import com.ktakilat.loan.web.CommonWebActivity;

/* renamed from: o  reason: default package */
public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Activity d;

    public /* synthetic */ o(Activity activity, int i) {
        this.c = i;
        this.d = activity;
    }

    public final void run() {
        Activity activity = this.d;
        switch (this.c) {
            case 0:
                ActivityCompat.lambda$recreate$0(activity);
                return;
            default:
                int i = BaseVerifyFaceActivity.s;
                CommonWebActivity.C(activity, (String) null, "/UserCenter/PusatBantuan", false, 0);
                return;
        }
    }
}
