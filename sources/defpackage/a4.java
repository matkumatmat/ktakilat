package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* renamed from: a4  reason: default package */
public final /* synthetic */ class a4 implements Executor {
    public final /* synthetic */ Handler c;

    public /* synthetic */ a4(Handler handler) {
        this.c = handler;
    }

    public final void execute(Runnable runnable) {
        this.c.post(runnable);
    }
}
