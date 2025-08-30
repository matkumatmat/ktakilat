package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzaq;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzap {
    private final zzbi<zzal> zza;
    private final Context zzb;
    private boolean zzc = false;
    private final Map<ListenerHolder.ListenerKey<LocationListener>, zzaw> zzd = new HashMap();
    private final Map<ListenerHolder.ListenerKey<Object>, zzat> zze = new HashMap();
    private final Map<ListenerHolder.ListenerKey<LocationCallback>, zzas> zzf = new HashMap();

    public zzap(Context context, zzbi<zzal> zzbi) {
        this.zzb = context;
        this.zza = zzbi;
    }

    public final Location zza(@Nullable String str) throws RemoteException {
        this.zza.zza();
        return this.zza.zzb().zza(str);
    }

    public final LocationAvailability zzb() throws RemoteException {
        this.zza.zza();
        return this.zza.zzb().zzb(this.zzb.getPackageName());
    }

    public final void zzc() throws RemoteException {
        synchronized (this.zzd) {
            try {
                for (zzaw next : this.zzd.values()) {
                    if (next != null) {
                        this.zza.zzb().zza(zzbe.zza((zzaq) next, (zzai) null));
                    }
                }
                this.zzd.clear();
            } finally {
                while (true) {
                }
            }
        }
        synchronized (this.zzf) {
            try {
                for (zzas next2 : this.zzf.values()) {
                    if (next2 != null) {
                        this.zza.zzb().zza(zzbe.zza((com.google.android.gms.location.zzap) next2, (zzai) null));
                    }
                }
                this.zzf.clear();
            } finally {
                while (true) {
                }
            }
        }
        synchronized (this.zze) {
            try {
                for (zzat next3 : this.zze.values()) {
                    if (next3 != null) {
                        this.zza.zzb().zza(new zzl(2, (zzj) null, next3.asBinder(), (IBinder) null));
                    }
                }
                this.zze.clear();
            } finally {
            }
        }
    }

    public final void zzd() throws RemoteException {
        if (this.zzc) {
            zza(false);
        }
    }

    private final zzas zzb(ListenerHolder<LocationCallback> listenerHolder) {
        zzas zzas;
        ListenerHolder.ListenerKey<LocationCallback> listenerKey = listenerHolder.getListenerKey();
        if (listenerKey == null) {
            return null;
        }
        synchronized (this.zzf) {
            try {
                zzas = this.zzf.get(listenerKey);
                if (zzas == null) {
                    zzas = new zzas(listenerHolder);
                }
                this.zzf.put(listenerKey, zzas);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzas;
    }

    @Deprecated
    public final Location zza() throws RemoteException {
        this.zza.zza();
        return this.zza.zzb().zza();
    }

    public final void zza(LocationRequest locationRequest, ListenerHolder<LocationListener> listenerHolder, zzai zzai) throws RemoteException {
        this.zza.zza();
        zzaw zza2 = zza(listenerHolder);
        if (zza2 != null) {
            zzal zzb2 = this.zza.zzb();
            IBinder iBinder = null;
            zzbc zza3 = zzbc.zza((String) null, locationRequest);
            IBinder asBinder = zza2.asBinder();
            if (zzai != null) {
                iBinder = zzai.asBinder();
            }
            zzb2.zza(new zzbe(1, zza3, asBinder, (PendingIntent) null, (IBinder) null, iBinder));
        }
    }

    public final void zzb(ListenerHolder.ListenerKey<LocationCallback> listenerKey, zzai zzai) throws RemoteException {
        this.zza.zza();
        Preconditions.checkNotNull(listenerKey, "Invalid null listener key");
        synchronized (this.zzf) {
            try {
                zzas remove = this.zzf.remove(listenerKey);
                if (remove != null) {
                    remove.zza();
                    this.zza.zzb().zza(zzbe.zza((com.google.android.gms.location.zzap) remove, zzai));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza(zzbc zzbc, ListenerHolder<LocationCallback> listenerHolder, zzai zzai) throws RemoteException {
        this.zza.zza();
        zzas zzb2 = zzb(listenerHolder);
        if (zzb2 != null) {
            this.zza.zzb().zza(new zzbe(1, zzbc, (IBinder) null, (PendingIntent) null, zzb2.asBinder(), zzai != null ? zzai.asBinder() : null));
        }
    }

    private final zzaw zza(ListenerHolder<LocationListener> listenerHolder) {
        zzaw zzaw;
        ListenerHolder.ListenerKey<LocationListener> listenerKey = listenerHolder.getListenerKey();
        if (listenerKey == null) {
            return null;
        }
        synchronized (this.zzd) {
            try {
                zzaw = this.zzd.get(listenerKey);
                if (zzaw == null) {
                    zzaw = new zzaw(listenerHolder);
                }
                this.zzd.put(listenerKey, zzaw);
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaw;
    }

    public final void zza(zzbc zzbc, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(zzbe.zza(zzbc, pendingIntent, zzai));
    }

    public final void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(zzbe.zza(zzbc.zza((String) null, locationRequest), pendingIntent, zzai));
    }

    public final void zza(ListenerHolder.ListenerKey<LocationListener> listenerKey, zzai zzai) throws RemoteException {
        this.zza.zza();
        Preconditions.checkNotNull(listenerKey, "Invalid null listener key");
        synchronized (this.zzd) {
            try {
                zzaw remove = this.zzd.remove(listenerKey);
                if (remove != null) {
                    remove.zza();
                    this.zza.zzb().zza(zzbe.zza((zzaq) remove, zzai));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zza(PendingIntent pendingIntent, zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(new zzbe(2, (zzbc) null, (IBinder) null, pendingIntent, (IBinder) null, zzai != null ? zzai.asBinder() : null));
    }

    public final void zza(boolean z) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(z);
        this.zzc = z;
    }

    public final void zza(Location location) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(location);
    }

    public final void zza(zzai zzai) throws RemoteException {
        this.zza.zza();
        this.zza.zzb().zza(zzai);
    }
}
