package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ View c;

    public /* synthetic */ b(View view) {
        this.c = view;
    }

    public final void run() {
        ((InputMethodManager) this.c.getContext().getSystemService("input_method")).showSoftInput(this.c, 0);
    }
}
