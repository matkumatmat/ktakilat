package defpackage;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;

/* renamed from: t  reason: default package */
public final /* synthetic */ class t implements Executor {
    public final /* synthetic */ int c;

    public /* synthetic */ t(int i) {
        this.c = i;
    }

    public final void execute(Runnable runnable) {
        switch (this.c) {
            case 0:
                runnable.run();
                return;
            case 1:
                ArchTaskExecutor.getInstance().postToMainThread(runnable);
                return;
            default:
                ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
                return;
        }
    }
}
