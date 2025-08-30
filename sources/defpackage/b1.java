package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* renamed from: b1  reason: default package */
public final /* synthetic */ class b1 implements Function0 {
    public final /* synthetic */ Activity c;
    public final /* synthetic */ Class d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ BaseVerifyFaceActivity.IntentCallback i;

    public /* synthetic */ b1(Activity activity, Class cls, String str, int i2, ArrayList arrayList, BaseVerifyFaceActivity.IntentCallback intentCallback) {
        this.c = activity;
        this.d = cls;
        this.e = str;
        this.f = i2;
        this.g = arrayList;
        this.i = intentCallback;
    }

    public final Object invoke() {
        int i2 = BaseVerifyFaceActivity.s;
        Intent intent = new Intent(this.c, this.d);
        intent.putExtra("mobileNo", this.e);
        intent.putExtra("scence", this.f);
        intent.putIntegerArrayListExtra("methodList", this.g);
        BaseVerifyFaceActivity.IntentCallback intentCallback = this.i;
        if (intentCallback == null) {
            return null;
        }
        intentCallback.a(intent);
        return null;
    }
}
