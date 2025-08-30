package com.google.firebase.platforminfo;

import androidx.annotation.Nullable;
import kotlin.KotlinVersion;

public final class KotlinDetector {
    private KotlinDetector() {
    }

    @Nullable
    public static String detectVersion() {
        try {
            KotlinVersion.e.getClass();
            return "2.1.0";
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
