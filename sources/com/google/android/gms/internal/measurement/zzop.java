package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import okio.Utf8;

final class zzop {
    public static /* synthetic */ boolean zza(byte b) {
        return b >= 0;
    }

    public static /* synthetic */ void zzb(byte b, byte b2, char[] cArr, int i) {
        if (b < -62 || zze(b2)) {
            throw new zzmq("Protocol message had invalid UTF-8.");
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | (b2 & Utf8.REPLACEMENT_BYTE));
    }

    public static /* synthetic */ void zzc(byte b, byte b2, byte b3, char[] cArr, int i) {
        if (!zze(b2)) {
            if (b == -32) {
                if (b2 >= -96) {
                    b = -32;
                }
            }
            if (b == -19) {
                if (b2 < -96) {
                    b = -19;
                }
            }
            if (!zze(b3)) {
                byte b4 = b & Ascii.SI;
                byte b5 = b2 & Utf8.REPLACEMENT_BYTE;
                cArr[i] = (char) ((b4 << Ascii.FF) | (b5 << 6) | (b3 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw new zzmq("Protocol message had invalid UTF-8.");
    }

    public static /* synthetic */ void zzd(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) {
        if (!zze(b2)) {
            if ((((b2 + 112) + (b << Ascii.FS)) >> 30) == 0 && !zze(b3) && !zze(b4)) {
                byte b5 = b2 & Utf8.REPLACEMENT_BYTE;
                byte b6 = b3 & Utf8.REPLACEMENT_BYTE;
                byte b7 = ((b & 7) << Ascii.DC2) | (b5 << Ascii.FF) | (b6 << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
                cArr[i] = (char) ((b7 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                cArr[i + 1] = (char) ((b7 & UnsignedBytes.MAX_VALUE) + Utf8.LOG_SURROGATE_HEADER);
                return;
            }
        }
        throw new zzmq("Protocol message had invalid UTF-8.");
    }

    private static boolean zze(byte b) {
        return b > -65;
    }
}
