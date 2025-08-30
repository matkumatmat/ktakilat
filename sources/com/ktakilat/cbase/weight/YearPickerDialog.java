package com.ktakilat.cbase.weight;

import android.app.DatePickerDialog;
import android.widget.DatePicker;

public class YearPickerDialog extends DatePickerDialog {
    public final void onDateChanged(DatePicker datePicker, int i, int i2, int i3) {
        super.onDateChanged(datePicker, i, i2, i3);
        new StringBuilder().append(i);
        throw null;
    }
}
