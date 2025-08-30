package com.google.android.material.search;

import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchBarAnimationHelper;

public final /* synthetic */ class b implements SearchBarAnimationHelper.OnLoadAnimationInvocation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f237a;

    public /* synthetic */ b(int i) {
        this.f237a = i;
    }

    public final void invoke(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        switch (this.f237a) {
            case 0:
                onLoadAnimationCallback.onAnimationStart();
                return;
            default:
                onLoadAnimationCallback.onAnimationEnd();
                return;
        }
    }
}
