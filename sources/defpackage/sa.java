package defpackage;

import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.input_code.InputCodeActivity;
import com.ktakilat.loan.weiget.GestureUtil;

/* renamed from: sa  reason: default package */
public final /* synthetic */ class sa implements FaceLoginOnOffActivity.PermissionCallback, GestureUtil.CheckCallback {
    public final /* synthetic */ InputCodeActivity c;

    public /* synthetic */ sa(InputCodeActivity inputCodeActivity) {
        this.c = inputCodeActivity;
    }

    public void a(boolean z) {
        int i = InputCodeActivity.r;
        InputCodeActivity inputCodeActivity = this.c;
        if (!z) {
            inputCodeActivity.A();
        } else {
            inputCodeActivity.getClass();
        }
    }

    public void c(boolean z) {
        int i = InputCodeActivity.r;
        InputCodeActivity inputCodeActivity = this.c;
        if (!z) {
            inputCodeActivity.A();
        } else {
            inputCodeActivity.getClass();
        }
    }
}
