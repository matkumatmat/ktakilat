package defpackage;

import android.view.View;
import com.ktakilat.cbase.ui.BaseDialog;

/* renamed from: m5  reason: default package */
public final /* synthetic */ class m5 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ View.OnClickListener d;
    public final /* synthetic */ BaseDialog e;

    public /* synthetic */ m5(View.OnClickListener onClickListener, BaseDialog baseDialog, int i) {
        this.c = i;
        this.d = onClickListener;
        this.e = baseDialog;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                this.d.onClick(view);
                this.e.dismiss();
                return;
            default:
                this.d.onClick(view);
                this.e.dismiss();
                return;
        }
    }
}
