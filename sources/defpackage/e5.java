package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.search.SearchView;

/* renamed from: e5  reason: default package */
public final /* synthetic */ class e5 implements CallbackToFutureAdapter.Resolver, OnApplyWindowInsetsListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ e5(Object obj, int i, int i2) {
        this.e = obj;
        this.c = i;
        this.d = i2;
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((DefaultSurfaceProcessor) this.e).lambda$snapshot$8(this.c, this.d, completer);
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.lambda$setUpDividerInsetListener$6((ViewGroup.MarginLayoutParams) this.e, this.c, this.d, view, windowInsetsCompat);
    }
}
