package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkq;
import com.google.android.gms.internal.measurement.zzkr;
import java.io.IOException;
import java.util.List;

public abstract class zzkr<MessageType extends zzkr<MessageType, BuilderType>, BuilderType extends zzkq<MessageType, BuilderType>> implements zznl {
    protected int zza = 0;

    public static void zzce(Iterable iterable, List list) {
        zzkq.zzaU(iterable, list);
    }

    public final zzlg zzcb() {
        try {
            int zzcn = zzcn();
            zzlg zzlg = zzlg.zzb;
            byte[] bArr = new byte[zzcn];
            int i = zzll.zzb;
            zzlj zzlj = new zzlj(bArr, 0, zzcn);
            zzcB(zzlj);
            return zzld.zza(zzlj, bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(e.q(new StringBuilder(name.length() + 72), "Serializing ", name, " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzcc() {
        try {
            int zzcn = zzcn();
            byte[] bArr = new byte[zzcn];
            int i = zzll.zzb;
            zzlj zzlj = new zzlj(bArr, 0, zzcn);
            zzcB(zzlj);
            zzlj.zzE();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(e.q(new StringBuilder(name.length() + 72), "Serializing ", name, " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public int zzcd(zznw zznw) {
        throw null;
    }
}
