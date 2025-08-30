package com.simplecityapps.recyclerview_fastscroll.utils;

import android.content.res.Resources;

public class Utils {
    public static boolean a(Resources resources) {
        if (resources.getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
