package com.google.android.gms.internal.auth;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import java.io.UnsupportedEncodingException;
import org.apache.commons.lang3.CharEncoding;

public abstract class zzbz extends FastSafeParcelableJsonResponse {
    @Nullable
    public final byte[] toByteArray() {
        try {
            return toString().getBytes(CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
            Log.e("AUTH", "Error serializing object.", e);
            return null;
        }
    }
}
