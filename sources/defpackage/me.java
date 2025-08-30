package defpackage;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.search.SearchView;

/* renamed from: me  reason: default package */
public final /* synthetic */ class me implements ViewUtils.OnApplyWindowInsetsListener, OnApplyWindowInsetsListener {
    public final /* synthetic */ SearchView c;

    public /* synthetic */ me(SearchView searchView) {
        this.c = searchView;
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.c.lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return this.c.lambda$setUpToolbarInsetListener$4(view, windowInsetsCompat, relativePadding);
    }
}
