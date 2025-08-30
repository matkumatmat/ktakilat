package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import kotlin.jvm.functions.Function0;

/* renamed from: v6  reason: default package */
public final /* synthetic */ class v6 implements Function0 {
    public final /* synthetic */ Activity c;
    public final /* synthetic */ int d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    public /* synthetic */ v6(Activity activity, int i, String str, String str2) {
        this.c = activity;
        this.d = i;
        this.e = str;
        this.f = str2;
    }

    public final Object invoke() {
        Activity activity = this.c;
        Intent intent = new Intent(activity, FaceLoginOnOffActivity.class);
        int i = this.d;
        intent.putExtra("requestCode", i);
        intent.putExtra("scence", this.e);
        intent.putExtra("mobileNo", this.f);
        activity.startActivityForResult(intent, i);
        return null;
    }
}
