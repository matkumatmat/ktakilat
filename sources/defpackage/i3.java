package defpackage;

import android.view.View;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.web.CommonWebFragment;

/* renamed from: i3  reason: default package */
public final /* synthetic */ class i3 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ CommonWebFragment d;

    public /* synthetic */ i3(CommonWebFragment commonWebFragment, int i) {
        this.c = i;
        this.d = commonWebFragment;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                BaseActivity b = this.d.b();
                if (b != null) {
                    b.finish();
                    return;
                }
                return;
            case 1:
                this.d.b().finish();
                return;
            case 2:
                this.d.i(true);
                return;
            default:
                this.d.i(true);
                return;
        }
    }
}
