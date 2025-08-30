package com.appsflyer.internal;

import androidx.annotation.NonNull;
import java.util.Locale;

public enum AFi1ySDK {
    SUCCESS,
    FAILURE,
    NA,
    INTERNAL_ERROR;

    @NonNull
    public final String toString() {
        return super.toString().toLowerCase(Locale.getDefault());
    }
}
