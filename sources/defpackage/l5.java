package defpackage;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

/* renamed from: l5  reason: default package */
public final /* synthetic */ class l5 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ l5(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                ((BaseDialog) this.d).dismiss();
                ((DialogUtils.CommonOkClickListern) this.e).b();
                return;
            case 1:
                ((mb) this.e).onClick(view);
                ((BaseDialog) this.d).dismiss();
                return;
            case 2:
                ((mb) this.e).onClick(view);
                ((BaseDialog) this.d).dismiss();
                return;
            case 3:
                ((f1) this.e).onClick(view);
                ((BaseDialog) this.d).dismiss();
                return;
            case 4:
                ((f1) this.e).onClick(view);
                ((BaseDialog) this.d).dismiss();
                return;
            default:
                ((Snackbar) this.d).lambda$setAction$0((View.OnClickListener) this.e, view);
                return;
        }
    }

    public /* synthetic */ l5(View.OnClickListener onClickListener, BaseDialog baseDialog, int i) {
        this.c = i;
        this.e = onClickListener;
        this.d = baseDialog;
    }
}
