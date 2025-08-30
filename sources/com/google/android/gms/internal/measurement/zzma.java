package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzme;
import java.io.IOException;

public class zzma<MessageType extends zzme<MessageType, BuilderType>, BuilderType extends zzma<MessageType, BuilderType>> extends zzkq<MessageType, BuilderType> {
    protected zzme zza;
    private final zzme zzb;

    public zzma(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzcf()) {
            this.zza = messagetype.zzch();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zznt.zza().zzb(obj.getClass()).zzd(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ zzkq zzaS(byte[] bArr, int i, int i2) throws zzmq {
        int i3 = zzlq.zzb;
        int i4 = zznt.zza;
        zzbe(bArr, 0, i2, zzlq.zza);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzkq zzaT(byte[] bArr, int i, int i2, zzlq zzlq) throws zzmq {
        zzbe(bArr, 0, i2, zzlq);
        return this;
    }

    public final void zzaX() {
        if (!this.zza.zzcf()) {
            zzaY();
        }
    }

    public void zzaY() {
        zzme zzch = this.zzb.zzch();
        zza(zzch, this.zza);
        this.zza = zzch;
    }

    /* renamed from: zzba */
    public final zzma zzaR() {
        zzma zzma = (zzma) this.zzb.zzl(5, (Object) null, (Object) null);
        zzma.zza = zzbf();
        return zzma;
    }

    /* renamed from: zzbb */
    public MessageType zzbf() {
        if (!this.zza.zzcf()) {
            return this.zza;
        }
        this.zza.zzcj();
        return this.zza;
    }

    public final MessageType zzbc() {
        MessageType zzbb = zzbf();
        if (zzbb.zzcD()) {
            return zzbb;
        }
        throw new zzog(zzbb);
    }

    public final zzma zzbd(zzme zzme) {
        if (!this.zzb.equals(zzme)) {
            if (!this.zza.zzcf()) {
                zzaY();
            }
            zza(this.zza, zzme);
        }
        return this;
    }

    public final zzma zzbe(byte[] bArr, int i, int i2, zzlq zzlq) throws zzmq {
        if (!this.zza.zzcf()) {
            zzaY();
        }
        try {
            zznt.zza().zzb(this.zza.getClass()).zzi(this.zza, bArr, 0, i2, new zzkv(zzlq));
            return this;
        } catch (zzmq e) {
            throw e;
        } catch (IndexOutOfBoundsException unused) {
            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        }
    }

    public final boolean zzcD() {
        return zzme.zzd(this.zza, false);
    }

    public final /* bridge */ /* synthetic */ zznl zzcE() {
        throw null;
    }
}
