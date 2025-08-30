package com.google.android.material.color;

import android.os.Build;

public abstract /* synthetic */ class a {
    public static ColorResourcesOverride a() {
        int i = Build.VERSION.SDK_INT;
        if (30 <= i && i <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }
}
