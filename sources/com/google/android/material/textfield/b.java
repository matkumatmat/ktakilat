package com.google.android.material.textfield;

import android.view.View;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f240a;
    public final /* synthetic */ EndIconDelegate b;

    public /* synthetic */ b(EndIconDelegate endIconDelegate, int i) {
        this.f240a = i;
        this.b = endIconDelegate;
    }

    public final void onFocusChange(View view, boolean z) {
        switch (this.f240a) {
            case 0:
                ((ClearTextEndIconDelegate) this.b).lambda$new$1(view, z);
                return;
            default:
                ((DropdownMenuEndIconDelegate) this.b).lambda$new$1(view, z);
                return;
        }
    }
}
