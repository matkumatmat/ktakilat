package com.google.android.gms.internal.common;

import java.util.Objects;
import javax.annotation.CheckForNull;
import org.jspecify.annotations.NullMarked;

@NullMarked
public final class zzt {
    public static final CharSequence zza(@CheckForNull Object obj, String str) {
        Objects.requireNonNull(obj);
        if (obj instanceof CharSequence) {
            return (CharSequence) obj;
        }
        return obj.toString();
    }
}
