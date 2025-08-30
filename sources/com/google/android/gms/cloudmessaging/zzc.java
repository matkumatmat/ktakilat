package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.util.Log;
import java.util.Objects;

public final class zzc extends ClassLoader {
    public final Class loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!Objects.equals(str, "com.google.android.gms.iid.MessengerCompat")) {
            return super.loadClass(str, z);
        }
        if (Log.isLoggable("CloudMessengerCompat", 3) || Build.VERSION.SDK_INT != 23) {
            return zzd.class;
        }
        Log.isLoggable("CloudMessengerCompat", 3);
        return zzd.class;
    }
}
