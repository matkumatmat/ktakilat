package defpackage;

import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;

/* renamed from: z6  reason: default package */
public final /* synthetic */ class z6 implements FaceLoginOnOffActivity.PermissionCallback {
    public final /* synthetic */ int c;
    public final /* synthetic */ FaceLoginOnOffUtil.ScenceEnableCall d;
    public final /* synthetic */ FaceEnableResp e;

    public /* synthetic */ z6(FaceLoginOnOffUtil.ScenceEnableCall scenceEnableCall, FaceEnableResp faceEnableResp, int i) {
        this.c = i;
        this.d = scenceEnableCall;
        this.e = faceEnableResp;
    }

    public final void c(boolean z) {
        switch (this.c) {
            case 0:
                FaceLoginOnOffUtil.ScenceEnableCall scenceEnableCall = this.d;
                if (scenceEnableCall != null) {
                    scenceEnableCall.a(this.e, true, false, z);
                    return;
                }
                return;
            default:
                FaceLoginOnOffUtil.ScenceEnableCall scenceEnableCall2 = this.d;
                if (scenceEnableCall2 != null) {
                    scenceEnableCall2.a(this.e, true, false, z);
                    return;
                }
                return;
        }
    }
}
