package defpackage;

import android.view.ViewTreeObserver;
import com.facebook.internal.NativeProtocol;
import com.ktakilat.cbase.utils.Debouncer;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: n5  reason: default package */
public final /* synthetic */ class n5 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Debouncer f824a;

    public /* synthetic */ n5(Debouncer debouncer) {
        this.f824a = debouncer;
    }

    public final void onScrollChanged() {
        q0 q0Var = new q0(6);
        Debouncer debouncer = this.f824a;
        Intrinsics.checkNotNullParameter(q0Var, NativeProtocol.WEB_DIALOG_ACTION);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - debouncer.f475a >= 1000) {
            debouncer.f475a = currentTimeMillis;
            q0Var.invoke();
        }
    }
}
