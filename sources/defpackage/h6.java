package defpackage;

import android.view.View;
import com.ktakilat.loan.normal_ui.EktpCameraActivity;

/* renamed from: h6  reason: default package */
public final /* synthetic */ class h6 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ EktpCameraActivity d;

    public /* synthetic */ h6(EktpCameraActivity ektpCameraActivity, int i) {
        this.c = i;
        this.d = ektpCameraActivity;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                EktpCameraActivity.A(this.d);
                return;
            case 1:
                EktpCameraActivity.z(this.d);
                return;
            default:
                EktpCameraActivity.B(this.d);
                return;
        }
    }
}
