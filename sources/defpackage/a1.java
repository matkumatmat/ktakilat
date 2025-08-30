package defpackage;

import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;

/* renamed from: a1  reason: default package */
public final /* synthetic */ class a1 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ BaseVerifyFaceActivity d;

    public /* synthetic */ a1(BaseVerifyFaceActivity baseVerifyFaceActivity, int i) {
        this.c = i;
        this.d = baseVerifyFaceActivity;
    }

    public final void run() {
        BaseVerifyFaceActivity baseVerifyFaceActivity = this.d;
        switch (this.c) {
            case 0:
                int i = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.o();
                return;
            case 1:
                int i2 = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.o();
                ToastUtil.b(baseVerifyFaceActivity, R.string.liveness_retry_toast);
                return;
            case 2:
                int i3 = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.y();
                return;
            case 3:
                int i4 = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.o();
                return;
            case 4:
                int i5 = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.o();
                return;
            default:
                int i6 = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.y();
                return;
        }
    }
}
