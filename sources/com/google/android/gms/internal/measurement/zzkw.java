package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

final class zzkw {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    public static int zza(byte[] bArr, int i, zzkv zzkv) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzkv);
        }
        zzkv.zza = b;
        return i2;
    }

    public static int zzb(int i, byte[] bArr, int i2, zzkv zzkv) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzkv.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & Ascii.DEL) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzkv.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Ascii.DEL) << Ascii.SO);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzkv.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Ascii.DEL) << Ascii.NAK);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzkv.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Ascii.DEL) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                zzkv.zza = i11;
                return i12;
            }
        }
    }

    public static int zzc(byte[] bArr, int i, zzkv zzkv) {
        long j = (long) bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzkv.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Ascii.DEL)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Ascii.DEL)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzkv.zzb = j2;
        return i3;
    }

    public static int zzd(byte[] bArr, int i) {
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        byte b2 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        byte b3 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (b2 << 8) | b | (b3 << Ascii.DLE);
    }

    public static long zze(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public static int zzf(byte[] bArr, int i, zzkv zzkv) throws zzmq {
        int i2;
        int i3;
        int i4;
        int zza2 = zza(bArr, i, zzkv);
        int i5 = zzkv.zza;
        if (i5 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i5 == 0) {
            zzkv.zzc = "";
            return zza2;
        } else {
            int i6 = zzor.zza;
            int length = bArr.length;
            if ((((length - zza2) - i5) | zza2 | i5) >= 0) {
                int i7 = zza2 + i5;
                char[] cArr = new char[i5];
                int i8 = 0;
                while (i2 < i7) {
                    byte b = bArr[i2];
                    if (!zzop.zza(b)) {
                        break;
                    }
                    zza2 = i2 + 1;
                    cArr[i8] = (char) b;
                    i8++;
                }
                int i9 = i8;
                while (i2 < i7) {
                    int i10 = i2 + 1;
                    byte b2 = bArr[i2];
                    if (zzop.zza(b2)) {
                        cArr[i9] = (char) b2;
                        i9++;
                        i2 = i10;
                        while (i2 < i7) {
                            byte b3 = bArr[i2];
                            if (!zzop.zza(b3)) {
                                break;
                            }
                            i2++;
                            cArr[i9] = (char) b3;
                            i9++;
                        }
                    } else {
                        if (b2 < -32) {
                            if (i10 < i7) {
                                i3 = i9 + 1;
                                i4 = i2 + 2;
                                zzop.zzb(b2, bArr[i10], cArr, i9);
                            } else {
                                throw new zzmq("Protocol message had invalid UTF-8.");
                            }
                        } else if (b2 < -16) {
                            if (i10 < i7 - 1) {
                                i3 = i9 + 1;
                                int i11 = i2 + 2;
                                i4 = i2 + 3;
                                zzop.zzc(b2, bArr[i10], bArr[i11], cArr, i9);
                            } else {
                                throw new zzmq("Protocol message had invalid UTF-8.");
                            }
                        } else if (i10 < i7 - 2) {
                            byte b4 = bArr[i10];
                            int i12 = i2 + 3;
                            byte b5 = bArr[i2 + 2];
                            i2 += 4;
                            zzop.zzd(b2, b4, b5, bArr[i12], cArr, i9);
                            i9 += 2;
                        } else {
                            throw new zzmq("Protocol message had invalid UTF-8.");
                        }
                        i9 = i3;
                    }
                }
                zzkv.zzc = new String(cArr, 0, i9);
                return i7;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(zza2), Integer.valueOf(i5)}));
        }
    }

    public static int zzg(byte[] bArr, int i, zzkv zzkv) throws zzmq {
        int zza2 = zza(bArr, i, zzkv);
        int i2 = zzkv.zza;
        if (i2 < 0) {
            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        } else if (i2 > bArr.length - zza2) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } else if (i2 == 0) {
            zzkv.zzc = zzlg.zzb;
            return zza2;
        } else {
            zzkv.zzc = zzlg.zzh(bArr, zza2, i2);
            return zza2 + i2;
        }
    }

    public static int zzh(zznw zznw, byte[] bArr, int i, int i2, zzkv zzkv) throws IOException {
        Object zza2 = zznw.zza();
        int zzj = zzj(zza2, zznw, bArr, i, i2, zzkv);
        zznw.zzj(zza2);
        zzkv.zzc = zza2;
        return zzj;
    }

    public static int zzi(zznw zznw, byte[] bArr, int i, int i2, int i3, zzkv zzkv) throws IOException {
        Object zza2 = zznw.zza();
        int zzk = zzk(zza2, zznw, bArr, i, i2, i3, zzkv);
        zznw.zzj(zza2);
        zzkv.zzc = zza2;
        return zzk;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzj(java.lang.Object r6, com.google.android.gms.internal.measurement.zznw r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.zzkv r11) throws java.io.IOException {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzb(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x002d
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x002d
            int r10 = r11.zze
            int r10 = r10 + 1
            r11.zze = r10
            zzq(r10)
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzi(r1, r2, r3, r4, r5)
            int r7 = r11.zze
            int r7 = r7 + -1
            r11.zze = r7
            r11.zzc = r6
            return r9
        L_0x002d:
            com.google.android.gms.internal.measurement.zzmq r6 = new com.google.android.gms.internal.measurement.zzmq
            java.lang.String r7 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkw.zzj(java.lang.Object, com.google.android.gms.internal.measurement.zznw, byte[], int, int, com.google.android.gms.internal.measurement.zzkv):int");
    }

    public static int zzk(Object obj, zznw zznw, byte[] bArr, int i, int i2, int i3, zzkv zzkv) throws IOException {
        int i4 = zzkv.zze + 1;
        zzkv.zze = i4;
        zzq(i4);
        int zzh = ((zzno) zznw).zzh(obj, bArr, i, i2, i3, zzkv);
        zzkv.zze--;
        zzkv.zzc = obj;
        return zzh;
    }

    public static int zzl(int i, byte[] bArr, int i2, int i3, zzmn zzmn, zzkv zzkv) {
        zzmf zzmf = (zzmf) zzmn;
        int zza2 = zza(bArr, i2, zzkv);
        zzmf.zzh(zzkv.zza);
        while (zza2 < i3) {
            int zza3 = zza(bArr, zza2, zzkv);
            if (i != zzkv.zza) {
                break;
            }
            zza2 = zza(bArr, zza3, zzkv);
            zzmf.zzh(zzkv.zza);
        }
        return zza2;
    }

    public static int zzm(byte[] bArr, int i, zzmn zzmn, zzkv zzkv) throws IOException {
        zzmf zzmf = (zzmf) zzmn;
        int zza2 = zza(bArr, i, zzkv);
        int i2 = zzkv.zza + zza2;
        while (zza2 < i2) {
            zza2 = zza(bArr, zza2, zzkv);
            zzmf.zzh(zzkv.zza);
        }
        if (zza2 == i2) {
            return zza2;
        }
        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public static int zzn(zznw zznw, int i, byte[] bArr, int i2, int i3, zzmn zzmn, zzkv zzkv) throws IOException {
        int zzh = zzh(zznw, bArr, i2, i3, zzkv);
        zzmn.add(zzkv.zzc);
        while (zzh < i3) {
            int zza2 = zza(bArr, zzh, zzkv);
            if (i != zzkv.zza) {
                break;
            }
            zzh = zzh(zznw, bArr, zza2, i3, zzkv);
            zzmn.add(zzkv.zzc);
        }
        return zzh;
    }

    public static int zzo(int i, byte[] bArr, int i2, int i3, zzoi zzoi, zzkv zzkv) throws zzmq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzc = zzc(bArr, i2, zzkv);
                zzoi.zzk(i, Long.valueOf(zzkv.zzb));
                return zzc;
            } else if (i4 == 1) {
                zzoi.zzk(i, Long.valueOf(zze(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza2 = zza(bArr, i2, zzkv);
                int i5 = zzkv.zza;
                if (i5 < 0) {
                    throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                } else if (i5 <= bArr.length - zza2) {
                    if (i5 == 0) {
                        zzoi.zzk(i, zzlg.zzb);
                    } else {
                        zzoi.zzk(i, zzlg.zzh(bArr, zza2, i5));
                    }
                    return zza2 + i5;
                } else {
                    throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                zzoi zzb2 = zzoi.zzb();
                int i7 = zzkv.zze + 1;
                zzkv.zze = i7;
                zzq(i7);
                int i8 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza3 = zza(bArr, i2, zzkv);
                    i8 = zzkv.zza;
                    if (i8 == i6) {
                        i2 = zza3;
                        break;
                    }
                    i2 = zzo(i8, bArr, zza3, i3, zzb2, zzkv);
                }
                zzkv.zze--;
                if (i2 > i3 || i8 != i6) {
                    throw new zzmq("Failed to parse the message.");
                }
                zzoi.zzk(i, zzb2);
                return i2;
            } else if (i4 == 5) {
                zzoi.zzk(i, Integer.valueOf(zzd(bArr, i2)));
                return i2 + 4;
            } else {
                throw new zzmq("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
    }

    public static int zzp(int i, byte[] bArr, int i2, int i3, zzkv zzkv) throws zzmq {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzc(bArr, i2, zzkv);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzkv) + zzkv.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzkv);
                    i6 = zzkv.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zzp(i6, bArr, i2, i3, zzkv);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw new zzmq("Failed to parse the message.");
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw new zzmq("Protocol message contained an invalid tag (zero).");
            }
        } else {
            throw new zzmq("Protocol message contained an invalid tag (zero).");
        }
    }

    private static void zzq(int i) throws zzmq {
        if (i >= zzb) {
            throw new zzmq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
