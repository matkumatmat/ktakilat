package defpackage;

import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;

/* renamed from: y6  reason: default package */
public final /* synthetic */ class y6 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ FaceLoginOnOffUtil d;

    public /* synthetic */ y6(FaceLoginOnOffUtil faceLoginOnOffUtil, int i) {
        this.c = i;
        this.d = faceLoginOnOffUtil;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.n();
                return;
            default:
                ToastUtil.b(this.d.f584a, R.string.liveness_retry_toast);
                return;
        }
    }
}
