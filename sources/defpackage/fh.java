package defpackage;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* renamed from: fh  reason: default package */
public final /* synthetic */ class fh implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f193a;
    public final /* synthetic */ ViewConfiguration b;

    public /* synthetic */ fh(ViewConfiguration viewConfiguration, int i) {
        this.f193a = i;
        this.b = viewConfiguration;
    }

    public final Object get() {
        switch (this.f193a) {
            case 0:
                return Integer.valueOf(this.b.getScaledMaximumFlingVelocity());
            default:
                return Integer.valueOf(this.b.getScaledMinimumFlingVelocity());
        }
    }
}
