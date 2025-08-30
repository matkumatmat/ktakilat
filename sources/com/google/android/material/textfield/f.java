package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;

public final /* synthetic */ class f implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DropdownMenuEndIconDelegate f242a;

    public /* synthetic */ f(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f242a = dropdownMenuEndIconDelegate;
    }

    public final void onDismiss() {
        this.f242a.lambda$setUpDropdownShowHideBehavior$5();
    }
}
