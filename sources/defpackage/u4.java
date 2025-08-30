package defpackage;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.ktakilat.loan.weiget.VersionUtil;

/* renamed from: u4  reason: default package */
public final /* synthetic */ class u4 implements Continuation, VersionUtil.VersionCall {
    public final /* synthetic */ Runnable c;

    public /* synthetic */ u4(Runnable runnable) {
        this.c = runnable;
    }

    public Object then(Task task) {
        return this.c.run();
    }
}
