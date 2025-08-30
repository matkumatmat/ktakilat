package com.ktakilat.cbase.utils.filter;

import android.text.InputFilter;
import android.text.Spanned;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class ValueLimitFilter implements InputFilter {

    public interface onExceedValueListener {
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (!Pattern.compile("[0-9]").matcher(charSequence).matches()) {
            return "";
        }
        BigDecimal bigDecimal = new BigDecimal(spanned.toString() + charSequence.toString());
        charSequence.toString();
        spanned.toString();
        bigDecimal.toString();
        throw null;
    }
}
