package com.google.android.gms.auth.api.identity;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

public final class zbf implements Api.ApiOptions.Optional {
    public final boolean equals(@Nullable Object obj) {
        return obj instanceof zbf;
    }

    public final int hashCode() {
        return Objects.hashCode(zbf.class);
    }
}
