package defpackage;

import androidx.datastore.core.MulticastFileObserver;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

/* renamed from: ca  reason: default package */
public final /* synthetic */ class ca implements DisposableHandle {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ ca(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    public final void dispose() {
        switch (this.c) {
            case 0:
                ((HandlerContext) this.d).c.removeCallbacks((Runnable) this.e);
                return;
            default:
                MulticastFileObserver.Companion.observe$lambda$4((String) this.d, (Function1) this.e);
                return;
        }
    }
}
