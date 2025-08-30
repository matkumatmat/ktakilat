package com.google.android.material.textfield;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ EndIconDelegate d;

    public /* synthetic */ a(EndIconDelegate endIconDelegate, int i) {
        this.c = i;
        this.d = endIconDelegate;
    }

    public final void onClick(View view) {
        switch (this.c) {
            case 0:
                ((ClearTextEndIconDelegate) this.d).lambda$new$0(view);
                return;
            case 1:
                ((DropdownMenuEndIconDelegate) this.d).lambda$new$0(view);
                return;
            default:
                ((PasswordToggleEndIconDelegate) this.d).lambda$new$0(view);
                return;
        }
    }
}
