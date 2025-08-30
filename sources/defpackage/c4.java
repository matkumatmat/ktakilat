package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.internal.ConfigAutoFetch;

/* renamed from: c4  reason: default package */
public final /* synthetic */ class c4 implements Continuation {
    public final /* synthetic */ ConfigAutoFetch c;
    public final /* synthetic */ Task d;
    public final /* synthetic */ Task e;
    public final /* synthetic */ long f;
    public final /* synthetic */ int g;

    public /* synthetic */ c4(ConfigAutoFetch configAutoFetch, Task task, Task task2, long j, int i) {
        this.c = configAutoFetch;
        this.d = task;
        this.e = task2;
        this.f = j;
        this.g = i;
    }

    public final Object then(Task task) {
        return this.c.lambda$fetchLatestConfig$0(this.d, this.e, this.f, this.g, task);
    }
}
