package defpackage;

import android.app.Activity;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import com.ktakilat.loan.verify_face.CommonVerifyFaceActivity;
import java.util.ArrayList;

/* renamed from: f3  reason: default package */
public final /* synthetic */ class f3 implements BaseVerifyFaceActivity.PermissionCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ yg f651a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ ArrayList e;
    public final /* synthetic */ int f;

    public /* synthetic */ f3(yg ygVar, Activity activity, String str, int i, ArrayList arrayList, int i2) {
        this.f651a = ygVar;
        this.b = activity;
        this.c = str;
        this.d = i;
        this.e = arrayList;
        this.f = i2;
    }

    public final void c(boolean z) {
        this.f651a.c(z);
        if (z) {
            int i = this.f;
            Activity activity = this.b;
            g3 g3Var = new g3(activity, i);
            BaseVerifyFaceActivity.F(activity, CommonVerifyFaceActivity.class, this.c, this.d, this.e, g3Var);
        }
    }
}
