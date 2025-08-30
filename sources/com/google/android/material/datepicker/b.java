package com.google.android.material.datepicker;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ DateFormatTextWatcher c;
    public final /* synthetic */ long d;

    public /* synthetic */ b(DateFormatTextWatcher dateFormatTextWatcher, long j) {
        this.c = dateFormatTextWatcher;
        this.d = j;
    }

    public final void run() {
        this.c.lambda$createRangeErrorCallback$1(this.d);
    }
}
