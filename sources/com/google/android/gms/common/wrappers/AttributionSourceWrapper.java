package com.google.android.gms.common.wrappers;

import android.content.AttributionSource;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class AttributionSourceWrapper {
    @Nullable
    private final AttributionSource zza;

    @KeepForSdk
    public AttributionSourceWrapper(@Nullable AttributionSource attributionSource) {
        this.zza = attributionSource;
    }

    @KeepForSdk
    @Nullable
    public AttributionSource getAttributionSource() {
        return this.zza;
    }
}
