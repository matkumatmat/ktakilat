package com.google.android.material.textfield;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ EndIconDelegate d;

    public /* synthetic */ d(EndIconDelegate endIconDelegate, int i) {
        this.c = i;
        this.d = endIconDelegate;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((ClearTextEndIconDelegate) this.d).lambda$tearDown$2();
                return;
            default:
                ((DropdownMenuEndIconDelegate) this.d).lambda$afterEditTextChanged$3();
                return;
        }
    }
}
