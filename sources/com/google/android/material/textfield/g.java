package com.google.android.material.textfield;

import androidx.core.view.accessibility.AccessibilityManagerCompat;

public final /* synthetic */ class g implements AccessibilityManagerCompat.TouchExplorationStateChangeListener {
    public final /* synthetic */ DropdownMenuEndIconDelegate c;

    public /* synthetic */ g(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.c = dropdownMenuEndIconDelegate;
    }

    public final void onTouchExplorationStateChanged(boolean z) {
        this.c.lambda$new$2(z);
    }
}
