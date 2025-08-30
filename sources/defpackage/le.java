package defpackage;

import com.google.android.material.search.SearchView;

/* renamed from: le  reason: default package */
public final /* synthetic */ class le implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SearchView d;

    public /* synthetic */ le(SearchView searchView, int i) {
        this.c = i;
        this.d = searchView;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$clearFocusAndHideKeyboard$9();
                return;
            case 1:
                this.d.lambda$requestFocusAndShowKeyboard$8();
                return;
            case 2:
                this.d.show();
                return;
            default:
                this.d.requestFocusAndShowKeyboardIfNeeded();
                return;
        }
    }
}
