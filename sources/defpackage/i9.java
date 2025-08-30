package defpackage;

import android.content.Intent;
import android.content.res.Configuration;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;

/* renamed from: i9  reason: default package */
public final /* synthetic */ class i9 implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ FragmentActivity d;

    public /* synthetic */ i9(FragmentActivity fragmentActivity, int i) {
        this.c = i;
        this.d = fragmentActivity;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                this.d.lambda$init$1((Configuration) obj);
                return;
            default:
                this.d.lambda$init$2((Intent) obj);
                return;
        }
    }
}
