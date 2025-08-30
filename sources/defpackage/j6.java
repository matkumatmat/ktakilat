package defpackage;

import androidx.camera.lifecycle.ProcessCameraProvider;
import com.ktakilat.loan.normal_ui.EktpCameraActivity;

/* renamed from: j6  reason: default package */
public final /* synthetic */ class j6 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ EktpCameraActivity d;

    public /* synthetic */ j6(EktpCameraActivity ektpCameraActivity, int i) {
        this.c = i;
        this.d = ektpCameraActivity;
    }

    public final void run() {
        EktpCameraActivity ektpCameraActivity = this.d;
        switch (this.c) {
            case 0:
                int i = EktpCameraActivity.x;
                ektpCameraActivity.getClass();
                try {
                    ektpCameraActivity.r = (ProcessCameraProvider) ektpCameraActivity.q.get();
                    ektpCameraActivity.C();
                    return;
                } catch (Exception unused) {
                    ektpCameraActivity.finish();
                    return;
                }
            default:
                ektpCameraActivity.n.progressBar.setVisibility(8);
                ektpCameraActivity.n.ivOk.setVisibility(0);
                return;
        }
    }
}
