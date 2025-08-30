package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzme;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzme<MessageType extends zzme<MessageType, BuilderType>, BuilderType extends zzma<MessageType, BuilderType>> extends zzkr<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzoi zzc = zzoi.zza();

    private final int zzc(zznw zznw) {
        return zznt.zza().zzb(getClass()).zze(this);
    }

    public static zzme zzco(Class cls) {
        Map map = zzd;
        zzme zzme = (zzme) map.get(cls);
        if (zzme == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzme = (zzme) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzme == null) {
            zzme = (zzme) ((zzme) zzoo.zzc(cls)).zzl(6, (Object) null, (Object) null);
            if (zzme != null) {
                map.put(cls, zzme);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzme;
    }

    public static void zzcp(Class cls, zzme zzme) {
        zzme.zzcg();
        zzd.put(cls, zzme);
    }

    public static Object zzcq(zznl zznl, String str, Object[] objArr) {
        return new zznv(zznl, str, objArr);
    }

    public static Object zzcr(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static zzml zzcs() {
        return zzmf.zzd();
    }

    public static zzmm zzct() {
        return zzmz.zze();
    }

    public static zzmm zzcu(zzmm zzmm) {
        int size = zzmm.size();
        return zzmm.zzd(size + size);
    }

    public static zzmn zzcv() {
        return zznu.zzd();
    }

    public static zzmn zzcw(zzmn zzmn) {
        int size = zzmn.size();
        return zzmn.zzg(size + size);
    }

    /* access modifiers changed from: private */
    public static final boolean zzd(zzme zzme, boolean z) {
        zzme zzme2;
        byte byteValue = ((Byte) zzme.zzl(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zznt.zza().zzb(zzme.getClass()).zzk(zzme);
        if (z) {
            if (true != zzk) {
                zzme2 = null;
            } else {
                zzme2 = zzme;
            }
            zzme.zzl(2, zzme2, (Object) null);
        }
        return zzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zznt.zza().zzb(getClass()).zzb(this, (zzme) obj);
    }

    public final int hashCode() {
        if (zzcf()) {
            return zzci();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int zzci = zzci();
        this.zza = zzci;
        return zzci;
    }

    public final String toString() {
        return zznn.zza(this, super.toString());
    }

    public final void zzcB(zzll zzll) throws IOException {
        zznt.zza().zzb(getClass()).zzf(this, zzlm.zza(zzll));
    }

    public final /* synthetic */ zznk zzcC() {
        return (zzma) zzl(5, (Object) null, (Object) null);
    }

    public final boolean zzcD() {
        return zzd(this, true);
    }

    public final /* synthetic */ zznl zzcE() {
        return (zzme) zzl(6, (Object) null, (Object) null);
    }

    public final int zzcd(zznw zznw) {
        if (zzcf()) {
            int zze = zznw.zze(this);
            if (zze >= 0) {
                return zze;
            }
            throw new IllegalStateException(ba.j(String.valueOf(zze).length() + 42, zze, "serialized size must be non-negative, was "));
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int zze2 = zznw.zze(this);
        if (zze2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | zze2;
            return zze2;
        }
        throw new IllegalStateException(ba.j(String.valueOf(zze2).length() + 42, zze2, "serialized size must be non-negative, was "));
    }

    public final boolean zzcf() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final void zzcg() {
        this.zzb &= Integer.MAX_VALUE;
    }

    public final zzme zzch() {
        return (zzme) zzl(4, (Object) null, (Object) null);
    }

    public final int zzci() {
        return zznt.zza().zzb(getClass()).zzc(this);
    }

    public final void zzcj() {
        zznt.zza().zzb(getClass()).zzj(this);
        zzcg();
    }

    public final zzma zzck() {
        return (zzma) zzl(5, (Object) null, (Object) null);
    }

    public final zzma zzcl() {
        zzma zzma = (zzma) zzl(5, (Object) null, (Object) null);
        zzma.zzbd(this);
        return zzma;
    }

    public final void zzcm(int i) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final int zzcn() {
        int i;
        if (zzcf()) {
            i = zzc((zznw) null);
            if (i < 0) {
                throw new IllegalStateException(ba.j(String.valueOf(i).length() + 42, i, "serialized size must be non-negative, was "));
            }
        } else {
            i = this.zzb & Integer.MAX_VALUE;
            if (i == Integer.MAX_VALUE) {
                i = zzc((zznw) null);
                if (i >= 0) {
                    this.zzb = (this.zzb & Integer.MIN_VALUE) | i;
                } else {
                    throw new IllegalStateException(ba.j(String.valueOf(i).length() + 42, i, "serialized size must be non-negative, was "));
                }
            }
        }
        return i;
    }

    public abstract Object zzl(int i, Object obj, Object obj2);
}
