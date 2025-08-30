package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.AudioExecutor;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ Runnable c;

    public /* synthetic */ a(Runnable runnable) {
        this.c = runnable;
    }

    public final void run() {
        AudioExecutor.AnonymousClass1.lambda$newThread$0(this.c);
    }
}
