package androidx.core.view;

import android.view.WindowInsetsController;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import java.util.concurrent.atomic.AtomicBoolean;

public final /* synthetic */ class c implements WindowInsetsController.OnControllableInsetsChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f43a;

    public /* synthetic */ c(AtomicBoolean atomicBoolean) {
        this.f43a = atomicBoolean;
    }

    public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController, int i) {
        SoftwareKeyboardControllerCompat.Impl30.lambda$hide$0(this.f43a, windowInsetsController, i);
    }
}
