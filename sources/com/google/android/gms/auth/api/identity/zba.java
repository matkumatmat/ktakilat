package com.google.android.gms.auth.api.identity;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class zba implements Api.ApiOptions.Optional {
    public zba(String str) {
    }

    public final boolean equals(@Nullable Object obj) {
        return obj instanceof zba;
    }

    public final int hashCode() {
        return Objects.hashCode(zba.class);
    }
}
