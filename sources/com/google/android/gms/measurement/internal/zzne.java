package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Objects;

public final class zzne implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zznk zza;
    private volatile boolean zzb;
    private volatile zzgn zzc;

    public zzne(zznk zznk) {
        Objects.requireNonNull(zznk);
        this.zza = zznk;
    }

    @MainThread
    public final void onConnected(Bundle bundle) {
        this.zza.zzu.zzaW().zzd();
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzu.zzaW().zzj(new zzmz(this, (zzga) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zznk zznk = this.zza;
        zznk.zzu.zzaW().zzd();
        zzgt zzf = zznk.zzu.zzf();
        if (zzf != null) {
            zzf.zzk().zzb("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzu.zzaW().zzj(new zznd(this, connectionResult));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        zzib zzib = this.zza.zzu;
        zzib.zzaW().zzd();
        zzib.zzaV().zzj().zza("Service connection suspended");
        zzib.zzaW().zzj(new zzna(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r3.zza.zzu.zzaV().zzb().zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006c */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zznk r4 = r3.zza
            com.google.android.gms.measurement.internal.zzib r4 = r4.zzu
            com.google.android.gms.measurement.internal.zzhy r4 = r4.zzaW()
            r4.zzd()
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x0027
            r3.zzb = r4     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zznk r4 = r3.zza     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzib r4 = r4.zzu     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x0024 }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x0024 }
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            return
        L_0x0024:
            r4 = move-exception
            goto L_0x00a7
        L_0x0027:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x006c }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x006c }
            if (r2 == 0) goto L_0x005a
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x006c }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzga     // Catch:{ RemoteException -> 0x006c }
            if (r2 == 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzga r1 = (com.google.android.gms.measurement.internal.zzga) r1     // Catch:{ RemoteException -> 0x006c }
        L_0x0040:
            r0 = r1
            goto L_0x0048
        L_0x0042:
            com.google.android.gms.measurement.internal.zzfy r1 = new com.google.android.gms.measurement.internal.zzfy     // Catch:{ RemoteException -> 0x006c }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x006c }
            goto L_0x0040
        L_0x0048:
            com.google.android.gms.measurement.internal.zznk r5 = r3.zza     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.zzib r5 = r5.zzu     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzk()     // Catch:{ RemoteException -> 0x006c }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x006c }
            goto L_0x007d
        L_0x005a:
            com.google.android.gms.measurement.internal.zznk r5 = r3.zza     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.zzib r5 = r5.zzu     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ RemoteException -> 0x006c }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ RemoteException -> 0x006c }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zzb(r2, r1)     // Catch:{ RemoteException -> 0x006c }
            goto L_0x007d
        L_0x006c:
            com.google.android.gms.measurement.internal.zznk r5 = r3.zza     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzib r5 = r5.zzu     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ all -> 0x0024 }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x0024 }
        L_0x007d:
            if (r0 != 0) goto L_0x0095
            r3.zzb = r4     // Catch:{ all -> 0x0024 }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zznk r5 = r3.zza     // Catch:{ IllegalArgumentException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzib r0 = r5.zzu     // Catch:{ IllegalArgumentException -> 0x00a5 }
            android.content.Context r0 = r0.zzaY()     // Catch:{ IllegalArgumentException -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzne r5 = r5.zzY()     // Catch:{ IllegalArgumentException -> 0x00a5 }
            r4.unbindService(r0, r5)     // Catch:{ IllegalArgumentException -> 0x00a5 }
            goto L_0x00a5
        L_0x0095:
            com.google.android.gms.measurement.internal.zznk r4 = r3.zza     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzib r4 = r4.zzu     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzhy r4 = r4.zzaW()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.measurement.internal.zzmx r5 = new com.google.android.gms.measurement.internal.zzmx     // Catch:{ all -> 0x0024 }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x0024 }
            r4.zzj(r5)     // Catch:{ all -> 0x0024 }
        L_0x00a5:
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            return
        L_0x00a7:
            monitor-exit(r3)     // Catch:{ all -> 0x0024 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzne.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzib zzib = this.zza.zzu;
        zzib.zzaW().zzd();
        zzib.zzaV().zzj().zza("Service disconnected");
        zzib.zzaW().zzj(new zzmy(this, componentName));
    }

    @WorkerThread
    public final void zza(Intent intent) {
        zznk zznk = this.zza;
        zznk.zzg();
        Context zzaY = zznk.zzu.zzaY();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            try {
                if (this.zzb) {
                    this.zza.zzu.zzaV().zzk().zza("Connection attempt already in progress");
                    return;
                }
                zznk zznk2 = this.zza;
                zznk2.zzu.zzaV().zzk().zza("Using local app measurement service");
                this.zzb = true;
                instance.bindService(zzaY, intent, zznk2.zzY(), 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @WorkerThread
    public final void zzb() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    @WorkerThread
    public final void zzc() {
        zznk zznk = this.zza;
        zznk.zzg();
        Context zzaY = zznk.zzu.zzaY();
        synchronized (this) {
            try {
                if (this.zzb) {
                    this.zza.zzu.zzaV().zzk().zza("Connection attempt already in progress");
                } else if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                    this.zzc = new zzgn(zzaY, Looper.getMainLooper(), this, this);
                    this.zza.zzu.zzaV().zzk().zza("Connecting to remote service");
                    this.zzb = true;
                    Preconditions.checkNotNull(this.zzc);
                    this.zzc.checkAvailabilityAndConnect();
                } else {
                    this.zza.zzu.zzaV().zzk().zza("Already awaiting connection attempt");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void zzd(boolean z) {
        this.zzb = false;
    }
}
