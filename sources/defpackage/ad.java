package defpackage;

/* renamed from: ad  reason: default package */
public final /* synthetic */ class ad implements Runnable {
    public final /* synthetic */ z0 c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ ad(z0 z0Var, boolean z, boolean z2) {
        this.c = z0Var;
        this.d = z;
        this.e = z2;
    }

    public final void run() {
        this.c.invoke(Boolean.valueOf(this.d), Boolean.valueOf(this.e));
    }
}
