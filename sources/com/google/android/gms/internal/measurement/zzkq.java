package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkr;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class zzkq<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkq<MessageType, BuilderType>> implements zznk {
    private static void zza(List list, int i) {
        int size = list.size() - i;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String sb2 = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 >= i) {
                list.remove(size2);
            } else {
                throw new NullPointerException(sb2);
            }
        }
    }

    public static void zzaU(Iterable iterable, List list) {
        byte[] bArr = zzmo.zzb;
        iterable.getClass();
        if (iterable instanceof zzmw) {
            List zza = ((zzmw) iterable).zza();
            zzmw zzmw = (zzmw) list;
            int size = list.size();
            for (Object next : zza) {
                if (next == null) {
                    int size2 = zzmw.size() - size;
                    StringBuilder sb = new StringBuilder(String.valueOf(size2).length() + 26);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = zzmw.size();
                    while (true) {
                        size3--;
                        if (size3 >= size) {
                            zzmw.remove(size3);
                        } else {
                            throw new NullPointerException(sb2);
                        }
                    }
                } else if (next instanceof zzlg) {
                    zzlg zzlg = (zzlg) next;
                    zzmw.zzb();
                } else if (next instanceof byte[]) {
                    byte[] bArr2 = (byte[]) next;
                    zzlg.zzh(bArr2, 0, bArr2.length);
                    zzmw.zzb();
                } else {
                    zzmw.add((String) next);
                }
            }
        } else if (!(iterable instanceof zzns)) {
            if (iterable instanceof Collection) {
                int size4 = ((Collection) iterable).size();
                if (list instanceof ArrayList) {
                    ((ArrayList) list).ensureCapacity(list.size() + size4);
                } else if (list instanceof zznu) {
                    ((zznu) list).zze(list.size() + size4);
                }
            }
            int size5 = list.size();
            if (!(iterable instanceof List) || !(iterable instanceof RandomAccess)) {
                for (Object next2 : iterable) {
                    if (next2 == null) {
                        zza(list, size5);
                    }
                    list.add(next2);
                }
                return;
            }
            List list2 = (List) iterable;
            int size6 = list2.size();
            for (int i = 0; i < size6; i++) {
                Object obj = list2.get(i);
                if (obj == null) {
                    zza(list, size5);
                }
                list.add(obj);
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    /* renamed from: zzaR */
    public abstract zzkq clone();

    public zzkq zzaS(byte[] bArr, int i, int i2) throws zzmq {
        throw null;
    }

    public zzkq zzaT(byte[] bArr, int i, int i2, zzlq zzlq) throws zzmq {
        throw null;
    }

    public final /* synthetic */ zznk zzaV(byte[] bArr, zzlq zzlq) throws zzmq {
        return zzaT(bArr, 0, bArr.length, zzlq);
    }

    public final /* synthetic */ zznk zzaW(byte[] bArr) throws zzmq {
        return zzaS(bArr, 0, bArr.length);
    }
}
