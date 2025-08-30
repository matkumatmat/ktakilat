package defpackage;

import android.view.View;
import com.google.android.material.search.SearchView;

/* renamed from: ke  reason: default package */
public final /* synthetic */ class ke implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ SearchView d;

    public /* synthetic */ ke(SearchView searchView, int i) {
        this.c = i;
        this.d = searchView;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                this.d.lambda$setUpBackButton$1(view);
                return;
            case 1:
                this.d.lambda$setUpClearButton$2(view);
                return;
            default:
                this.d.lambda$setupWithSearchBar$7(view);
                return;
        }
    }
}
