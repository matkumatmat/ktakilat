package com.ktakilat.cbase.utils;

import android.content.Context;

public class Dp2PxUtil {
    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
