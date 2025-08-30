package com.google.android.gms.internal.location;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

public final class zzbj {
    public static Looper zza(@Nullable Looper looper) {
        return looper != null ? looper : zza();
    }

    public static Looper zza() {
        Preconditions.checkState(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
        return Looper.myLooper();
    }
}
