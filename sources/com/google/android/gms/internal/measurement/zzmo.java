package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

public final class zzmo {
    static final Charset zza = Charset.forName(CharEncoding.UTF_8);
    public static final byte[] zzb;

    static {
        Charset.forName(CharEncoding.US_ASCII);
        Charset.forName(CharEncoding.ISO_8859_1);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new zzlh(bArr, 0, 0, false, (byte[]) null).zza(0);
        } catch (zzmq e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("messageType");
    }

    public static int zzb(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzc(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static boolean zzd(zznl zznl) {
        if (!(zznl instanceof zzks)) {
            return false;
        }
        throw null;
    }
}
