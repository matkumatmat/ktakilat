package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegate;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ AppCompatDelegate.SerialExecutor c;
    public final /* synthetic */ Runnable d;

    public /* synthetic */ a(AppCompatDelegate.SerialExecutor serialExecutor, Runnable runnable) {
        this.c = serialExecutor;
        this.d = runnable;
    }

    public final void run() {
        this.c.lambda$execute$0(this.d);
    }
}
