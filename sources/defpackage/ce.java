package defpackage;

import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.reset_pwd.ResetPwdActivity;
import com.ktakilat.loan.weiget.GestureUtil;

/* renamed from: ce  reason: default package */
public final /* synthetic */ class ce implements FaceLoginOnOffActivity.PermissionCallback, GestureUtil.CheckCallback {
    public final /* synthetic */ ResetPwdActivity c;

    public /* synthetic */ ce(ResetPwdActivity resetPwdActivity) {
        this.c = resetPwdActivity;
    }

    public void a(boolean z) {
        int i = ResetPwdActivity.n;
        ResetPwdActivity resetPwdActivity = this.c;
        if (!z) {
            resetPwdActivity.z();
        } else {
            resetPwdActivity.getClass();
        }
    }

    public void c(boolean z) {
        int i = ResetPwdActivity.n;
        ResetPwdActivity resetPwdActivity = this.c;
        if (!z) {
            resetPwdActivity.z();
        } else {
            resetPwdActivity.getClass();
        }
    }
}
