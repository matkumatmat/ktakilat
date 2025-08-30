package com.google.android.material.timepicker;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ RadialViewGroup c;

    public /* synthetic */ b(RadialViewGroup radialViewGroup) {
        this.c = radialViewGroup;
    }

    public final void run() {
        this.c.updateLayoutParams();
    }
}
