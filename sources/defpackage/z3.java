package defpackage;

import androidx.lifecycle.ComputableLiveData;

/* renamed from: z3  reason: default package */
public final /* synthetic */ class z3 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ComputableLiveData d;

    public /* synthetic */ z3(ComputableLiveData computableLiveData, int i) {
        this.c = i;
        this.d = computableLiveData;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ComputableLiveData.refreshRunnable$lambda$0(this.d);
                return;
            default:
                ComputableLiveData.invalidationRunnable$lambda$1(this.d);
                return;
        }
    }
}
