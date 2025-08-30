package defpackage;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import kotlin.jvm.functions.Function0;

/* renamed from: x6  reason: default package */
public final /* synthetic */ class x6 implements Function0 {
    public final /* synthetic */ FaceLoginOnOffUtil c;
    public final /* synthetic */ FaceLoginOnOffUtil.ScenceEnum d;
    public final /* synthetic */ FaceLoginOnOffUtil.ScenceEnableCall e;
    public final /* synthetic */ FaceEnableResp f;

    public /* synthetic */ x6(FaceEnableResp faceEnableResp, FaceLoginOnOffUtil.ScenceEnableCall scenceEnableCall, FaceLoginOnOffUtil.ScenceEnum scenceEnum, FaceLoginOnOffUtil faceLoginOnOffUtil) {
        this.c = faceLoginOnOffUtil;
        this.d = scenceEnum;
        this.e = scenceEnableCall;
        this.f = faceEnableResp;
    }

    public final Object invoke() {
        FaceLoginOnOffUtil faceLoginOnOffUtil = this.c;
        faceLoginOnOffUtil.getClass();
        String str = this.d.type;
        FaceLoginOnOffActivity.A(CameraAccessExceptionCompat.CAMERA_UNAVAILABLE_DO_NOT_DISTURB, faceLoginOnOffUtil.f584a, new z6(this.e, this.f, 0), (String) null, str);
        return null;
    }
}
