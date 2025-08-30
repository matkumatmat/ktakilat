package androidx.activity;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ ComponentActivity c;
    public final /* synthetic */ OnBackPressedDispatcher d;

    public /* synthetic */ b(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.c = componentActivity;
        this.d = onBackPressedDispatcher;
    }

    public final void run() {
        ComponentActivity$onBackPressedDispatcher$2.invoke$lambda$2$lambda$1(this.c, this.d);
    }
}
