package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzll extends zzky {
    public static final /* synthetic */ int zzb = 0;
    private static final Logger zzc = Logger.getLogger(zzll.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzd = zzoo.zza();
    zzlm zza;

    private zzll() {
        throw null;
    }

    public static int zzA(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zzB(String str) {
        int i;
        try {
            i = zzor.zzb(str);
        } catch (zzoq unused) {
            i = str.getBytes(zzmo.zza).length;
        }
        return zzz(i) + i;
    }

    public static int zzC(zznl zznl) {
        int zzcn = zznl.zzcn();
        return zzz(zzcn) + zzcn;
    }

    public static int zzD(zznl zznl, zznw zznw) {
        int zzcd = ((zzkr) zznl).zzcd(zznw);
        return zzz(zzcd) + zzcd;
    }

    @Deprecated
    public static int zzG(int i, zznl zznl, zznw zznw) {
        int zzz = zzz(i << 3);
        return ((zzkr) zznl).zzcd(zznw) + zzz + zzz;
    }

    public static int zzz(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void zzE() {
        if (zzy() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzF(String str, zzoq zzoq) throws IOException {
        zzc.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzoq);
        byte[] bytes = str.getBytes(zzmo.zza);
        try {
            int length = bytes.length;
            zzr(length);
            zzw(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzlk(e);
        }
    }

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, long j) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzg(int i, boolean z) throws IOException;

    public abstract void zzh(int i, String str) throws IOException;

    public abstract void zzi(int i, zzlg zzlg) throws IOException;

    public abstract void zzj(zzlg zzlg) throws IOException;

    public abstract void zzk(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzl(int i, zznl zznl, zznw zznw) throws IOException;

    public abstract void zzm(int i, zznl zznl) throws IOException;

    public abstract void zzn(int i, zzlg zzlg) throws IOException;

    public abstract void zzo(zznl zznl) throws IOException;

    public abstract void zzp(byte b) throws IOException;

    public abstract void zzq(int i) throws IOException;

    public abstract void zzr(int i) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(long j) throws IOException;

    public abstract void zzu(long j) throws IOException;

    public abstract void zzw(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzx(String str) throws IOException;

    public abstract int zzy();

    public /* synthetic */ zzll(byte[] bArr) {
    }
}
