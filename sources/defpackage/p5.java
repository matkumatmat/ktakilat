package defpackage;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.DragStartHelper;
import com.google.android.material.search.SearchView;

/* renamed from: p5  reason: default package */
public final /* synthetic */ class p5 implements View.OnTouchListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ p5(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.c) {
            case 0:
                return ((DragStartHelper) this.d).onTouch(view, motionEvent);
            default:
                return ((SearchView) this.d).lambda$setUpContentOnTouchListener$3(view, motionEvent);
        }
    }
}
