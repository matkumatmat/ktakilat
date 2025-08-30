package com.google.android.material.search;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SearchViewAnimationHelper d;

    public /* synthetic */ f(SearchViewAnimationHelper searchViewAnimationHelper, int i) {
        this.c = i;
        this.d = searchViewAnimationHelper;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$startShowAnimationExpand$0();
                return;
            default:
                this.d.lambda$startShowAnimationTranslate$1();
                return;
        }
    }
}
