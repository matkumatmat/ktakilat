package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.WindowInsetsControllerCompat;

public final /* synthetic */ class d implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WindowInsetsControllerCompat.Impl30 f44a;
    public final /* synthetic */ WindowInsetsControllerCompat.OnControllableInsetsChangedListener b;

    public /* synthetic */ d(WindowInsetsControllerCompat.Impl30 impl30, WindowInsetsControllerCompat.OnControllableInsetsChangedListener onControllableInsetsChangedListener) {
        this.f44a = impl30;
        this.b = onControllableInsetsChangedListener;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        this.f44a.lambda$addOnControllableInsetsChangedListener$0(this.b, windowInsetsController, i);
    }
}
