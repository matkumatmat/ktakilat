package com.google.android.material.textfield;

import android.view.MotionEvent;
import android.view.View;

public final /* synthetic */ class e implements View.OnTouchListener {
    public final /* synthetic */ DropdownMenuEndIconDelegate c;

    public /* synthetic */ e(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.c = dropdownMenuEndIconDelegate;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.c.lambda$setUpDropdownShowHideBehavior$4(view, motionEvent);
    }
}
