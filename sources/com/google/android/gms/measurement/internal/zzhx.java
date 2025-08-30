package com.google.android.gms.measurement.internal;

import android.os.Process;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

final class zzhx extends Thread {
    final /* synthetic */ zzhy zza;
    private final Object zzb;
    private final BlockingQueue zzc;
    @GuardedBy("threadLifeCycleLock")
    private boolean zzd = false;

    public zzhx(zzhy zzhy, String str, BlockingQueue blockingQueue) {
        Objects.requireNonNull(zzhy);
        this.zza = zzhy;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzb = new Object();
        this.zzc = blockingQueue;
        setName(str);
    }

    private final void zzb() {
        zzhy zzhy = this.zza;
        synchronized (zzhy.zzr()) {
            try {
                if (!this.zzd) {
                    zzhy.zzs().release();
                    zzhy.zzr().notifyAll();
                    if (this == zzhy.zzn()) {
                        zzhy.zzo((zzhx) null);
                    } else if (this == zzhy.zzp()) {
                        zzhy.zzq((zzhx) null);
                    } else {
                        zzhy.zzu.zzaV().zzb().zza("Current scheduler thread is neither worker nor network");
                    }
                    this.zzd = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzc(InterruptedException interruptedException) {
        this.zza.zzu.zzaV().zze().zzb(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void run() {
        int i;
        boolean z = false;
        while (!z) {
            try {
                this.zza.zzs().acquire();
                z = true;
            } catch (InterruptedException e) {
                zzc(e);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                BlockingQueue blockingQueue = this.zzc;
                zzhw zzhw = (zzhw) blockingQueue.poll();
                if (zzhw != null) {
                    if (true != zzhw.zza) {
                        i = 10;
                    } else {
                        i = threadPriority;
                    }
                    Process.setThreadPriority(i);
                    zzhw.run();
                } else {
                    Object obj = this.zzb;
                    synchronized (obj) {
                        if (blockingQueue.peek() == null) {
                            this.zza.zzt();
                            try {
                                obj.wait(30000);
                            } catch (InterruptedException e2) {
                                zzc(e2);
                            }
                        }
                    }
                    synchronized (this.zza.zzr()) {
                        if (this.zzc.peek() == null) {
                            zzb();
                            zzb();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            zzb();
            throw th;
        }
    }

    public final void zza() {
        Object obj = this.zzb;
        synchronized (obj) {
            obj.notifyAll();
        }
    }
}
