package com.ktakilat.cbase.ui;

import android.view.View;
import java.util.Calendar;

public abstract class OnSafeClickListener implements View.OnClickListener {
    public long c = 0;

    public abstract void a(View view);

    public final void onClick(View view) {
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (timeInMillis - this.c > 1000) {
            this.c = timeInMillis;
            a(view);
        }
    }
}
