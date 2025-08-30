package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import java.util.concurrent.Callable;

/* renamed from: v4  reason: default package */
public final /* synthetic */ class v4 implements Continuation {
    public final /* synthetic */ int c;
    public final /* synthetic */ Callable d;

    public /* synthetic */ v4(Callable callable, int i) {
        this.c = i;
        this.d = callable;
    }

    public final Object then(Task task) {
        switch (this.c) {
            case 0:
                return Tasks.forResult(this.d.call());
            case 1:
                return CrashlyticsWorker.lambda$submitTask$2(this.d, task);
            case 2:
                return CrashlyticsWorker.lambda$submitTask$3(this.d, task);
            default:
                return CrashlyticsWorker.lambda$submitTaskOnSuccess$4(this.d, task);
        }
    }
}
