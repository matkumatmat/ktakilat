package androidx.activity;

import androidx.activity.ComponentActivity;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0((ComponentActivity.ReportFullyDrawnExecutorImpl) this.d);
                return;
            default:
                ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$0((ComponentActivity) this.d);
                return;
        }
    }
}
