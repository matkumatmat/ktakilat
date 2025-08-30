package defpackage;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import com.google.android.material.motion.MaterialBackHandler;
import kotlin.jvm.functions.Function0;

/* renamed from: ec  reason: default package */
public final /* synthetic */ class ec implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f343a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ec(Object obj, int i) {
        this.f343a = i;
        this.b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f343a) {
            case 0:
                ((MaterialBackHandler) this.b).handleBackInvoked();
                return;
            case 1:
                OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0((Function0) this.b);
                return;
            default:
                ((Runnable) this.b).run();
                return;
        }
    }
}
