package com.google.android.material.datepicker;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ DateFormatTextWatcher c;
    public final /* synthetic */ String d;

    public /* synthetic */ a(DateFormatTextWatcher dateFormatTextWatcher, String str) {
        this.c = dateFormatTextWatcher;
        this.d = str;
    }

    public final void run() {
        this.c.lambda$new$0(this.d);
    }
}
