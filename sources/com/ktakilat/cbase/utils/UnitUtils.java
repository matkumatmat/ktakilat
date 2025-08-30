package com.ktakilat.cbase.utils;

import android.content.Context;

public class UnitUtils {
    public static int a(Context context) {
        return (int) ((((float) 48) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
