package com.google.android.gms.auth.api.signin.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@KeepForSdk
public class HashAccumulator {
    private int zaa = 1;

    @NonNull
    @KeepForSdk
    @CanIgnoreReturnValue
    public HashAccumulator addObject(@Nullable Object obj) {
        int i;
        int i2 = this.zaa * 31;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        this.zaa = i2 + i;
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zaa;
    }

    @NonNull
    @CanIgnoreReturnValue
    public final HashAccumulator zaa(boolean z) {
        this.zaa = (this.zaa * 31) + (z ? 1 : 0);
        return this;
    }
}
