package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class zzhy extends zzje {
    /* access modifiers changed from: private */
    public static final AtomicLong zzj = new AtomicLong(Long.MIN_VALUE);
    @Nullable
    private zzhx zza;
    @Nullable
    private zzhx zzb;
    private final PriorityBlockingQueue zzc = new PriorityBlockingQueue();
    private final BlockingQueue zzd = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler zze = new zzhv(this, "Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler zzf = new zzhv(this, "Thread death: Uncaught exception on network thread");
    private final Object zzg = new Object();
    private final Semaphore zzh = new Semaphore(2);
    private volatile boolean zzi;

    public zzhy(zzib zzib) {
        super(zzib);
    }

    private final void zzz(zzhw zzhw) {
        synchronized (this.zzg) {
            try {
                PriorityBlockingQueue priorityBlockingQueue = this.zzc;
                priorityBlockingQueue.add(zzhw);
                zzhx zzhx = this.zza;
                if (zzhx == null) {
                    zzhx zzhx2 = new zzhx(this, "Measurement Worker", priorityBlockingQueue);
                    this.zza = zzhx2;
                    zzhx2.setUncaughtExceptionHandler(this.zze);
                    this.zza.start();
                } else {
                    zzhx.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zza() {
        return false;
    }

    public final void zzaX() {
        if (Thread.currentThread() != this.zzb) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void zzd() {
        if (Thread.currentThread() == this.zza) {
            throw new IllegalStateException("Call not expected from worker thread");
        }
    }

    public final boolean zze() {
        if (Thread.currentThread() == this.zza) {
            return true;
        }
        return false;
    }

    public final boolean zzf() {
        if (Thread.currentThread() == this.zzb) {
            return true;
        }
        return false;
    }

    public final void zzg() {
        if (Thread.currentThread() != this.zza) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Future zzh(Callable callable) throws IllegalStateException {
        zzw();
        Preconditions.checkNotNull(callable);
        zzhw zzhw = new zzhw(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            if (!this.zzc.isEmpty()) {
                e.C(this.zzu, "Callable skipped the worker queue.");
            }
            zzhw.run();
        } else {
            zzz(zzhw);
        }
        return zzhw;
    }

    public final Future zzi(Callable callable) throws IllegalStateException {
        zzw();
        Preconditions.checkNotNull(callable);
        zzhw zzhw = new zzhw(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.zza) {
            zzhw.run();
        } else {
            zzz(zzhw);
        }
        return zzhw;
    }

    public final void zzj(Runnable runnable) throws IllegalStateException {
        zzw();
        Preconditions.checkNotNull(runnable);
        zzz(new zzhw(this, runnable, false, "Task exception on worker thread"));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:13|14|15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2.zzu.zzaV().zze().zza("Timed out waiting for ".concat(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4 = r2.zzu.zzaV().zze();
        r7 = new java.lang.StringBuilder(r6.length() + 24);
        r7.append("Interrupted waiting for ");
        r7.append(r6);
        r4.zza(r7.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r3 = r3.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        if (r3 != null) goto L_0x0029;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002c */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzk(java.util.concurrent.atomic.AtomicReference r3, long r4, java.lang.String r6, java.lang.Runnable r7) {
        /*
            r2 = this;
            java.lang.String r0 = "Interrupted waiting for "
            monitor-enter(r3)
            com.google.android.gms.measurement.internal.zzib r1 = r2.zzu     // Catch:{ all -> 0x002a }
            com.google.android.gms.measurement.internal.zzhy r1 = r1.zzaW()     // Catch:{ all -> 0x002a }
            r1.zzj(r7)     // Catch:{ all -> 0x002a }
            r3.wait(r4)     // Catch:{ InterruptedException -> 0x002c }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            java.lang.Object r3 = r3.get()
            if (r3 != 0) goto L_0x0029
            com.google.android.gms.measurement.internal.zzib r4 = r2.zzu
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zze()
            java.lang.String r5 = "Timed out waiting for "
            java.lang.String r5 = r5.concat(r6)
            r4.zza(r5)
        L_0x0029:
            return r3
        L_0x002a:
            r4 = move-exception
            goto L_0x0051
        L_0x002c:
            com.google.android.gms.measurement.internal.zzib r4 = r2.zzu     // Catch:{ all -> 0x002a }
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()     // Catch:{ all -> 0x002a }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zze()     // Catch:{ all -> 0x002a }
            int r5 = r6.length()     // Catch:{ all -> 0x002a }
            int r5 = r5 + 24
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
            r7.<init>(r5)     // Catch:{ all -> 0x002a }
            r7.append(r0)     // Catch:{ all -> 0x002a }
            r7.append(r6)     // Catch:{ all -> 0x002a }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x002a }
            r4.zza(r5)     // Catch:{ all -> 0x002a }
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            r3 = 0
            return r3
        L_0x0051:
            monitor-exit(r3)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhy.zzk(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final void zzl(Runnable runnable) throws IllegalStateException {
        zzw();
        Preconditions.checkNotNull(runnable);
        zzz(new zzhw(this, runnable, true, "Task exception on worker thread"));
    }

    public final void zzm(Runnable runnable) throws IllegalStateException {
        zzw();
        Preconditions.checkNotNull(runnable);
        zzhw zzhw = new zzhw(this, runnable, false, "Task exception on network thread");
        synchronized (this.zzg) {
            try {
                BlockingQueue blockingQueue = this.zzd;
                blockingQueue.add(zzhw);
                zzhx zzhx = this.zzb;
                if (zzhx == null) {
                    zzhx zzhx2 = new zzhx(this, "Measurement Network", blockingQueue);
                    this.zzb = zzhx2;
                    zzhx2.setUncaughtExceptionHandler(this.zzf);
                    this.zzb.start();
                } else {
                    zzhx.zza();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ zzhx zzn() {
        return this.zza;
    }

    public final /* synthetic */ void zzo(zzhx zzhx) {
        this.zza = null;
    }

    public final /* synthetic */ zzhx zzp() {
        return this.zzb;
    }

    public final /* synthetic */ void zzq(zzhx zzhx) {
        this.zzb = null;
    }

    public final /* synthetic */ Object zzr() {
        return this.zzg;
    }

    public final /* synthetic */ Semaphore zzs() {
        return this.zzh;
    }

    public final /* synthetic */ boolean zzt() {
        return false;
    }
}
