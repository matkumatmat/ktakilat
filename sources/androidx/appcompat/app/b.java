package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class b implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f4a;

    public /* synthetic */ b(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f4a = appCompatDelegateImpl;
    }

    public final void onBackInvoked() {
        this.f4a.onBackPressed();
    }
}
