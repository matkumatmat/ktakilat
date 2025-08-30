package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.firebase.perf.util.FirstDrawDoneListener;

/* renamed from: h9  reason: default package */
public final /* synthetic */ class h9 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ FirstDrawDoneListener c;
    public final /* synthetic */ View d;

    public /* synthetic */ h9(FirstDrawDoneListener firstDrawDoneListener, View view) {
        this.c = firstDrawDoneListener;
        this.d = view;
    }

    public final void onGlobalLayout() {
        this.c.lambda$onDraw$0(this.d);
    }
}
