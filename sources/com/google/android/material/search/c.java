package com.google.android.material.search;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ SearchBarAnimationHelper c;
    public final /* synthetic */ SearchBar d;
    public final /* synthetic */ View e;
    public final /* synthetic */ AppBarLayout f;
    public final /* synthetic */ boolean g;

    public /* synthetic */ c(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        this.c = searchBarAnimationHelper;
        this.d = searchBar;
        this.e = view;
        this.f = appBarLayout;
        this.g = z;
    }

    public final void run() {
        this.c.lambda$startExpandAnimation$0(this.d, this.e, this.f, this.g);
    }
}
