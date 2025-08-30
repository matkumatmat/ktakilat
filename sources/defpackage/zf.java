package defpackage;

import android.view.View;
import com.katkilat.baidu_face.widget.TimeoutDialog;

/* renamed from: zf  reason: default package */
public final /* synthetic */ class zf implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ TimeoutDialog d;

    public /* synthetic */ zf(TimeoutDialog timeoutDialog, int i) {
        this.c = i;
        this.d = timeoutDialog;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                this.d.c.a();
                return;
            default:
                this.d.c.b();
                return;
        }
    }
}
