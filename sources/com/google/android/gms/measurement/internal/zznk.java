package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzcu;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.DateUtils;

public final class zznk extends zzg {
    private final zzne zza;
    private zzga zzb;
    private volatile Boolean zzc;
    private final zzay zzd;
    private ScheduledExecutorService zze;
    private final zzof zzf;
    private final List zzg = new ArrayList();
    private final zzay zzh;

    public zznk(zzib zzib) {
        super(zzib);
        this.zzf = new zzof(zzib.zzaZ());
        this.zza = new zzne(this);
        this.zzd = new zzml(this, zzib);
        this.zzh = new zzmp(this, zzib);
    }

    private final boolean zzad() {
        this.zzu.zzaU();
        return true;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: zzae */
    public final void zzV() {
        zzg();
        this.zzf.zza();
        this.zzu.zzc();
        this.zzd.zzb(((Long) zzfx.zzY.zzb((Object) null)).longValue());
    }

    @WorkerThread
    private final void zzaf(Runnable runnable) throws IllegalStateException {
        zzg();
        if (zzh()) {
            runnable.run();
            return;
        }
        List list = this.zzg;
        zzib zzib = this.zzu;
        zzib.zzc();
        if (((long) list.size()) >= 1000) {
            e.w(zzib, "Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.zzh.zzb(DateUtils.MILLIS_PER_MINUTE);
        zzI();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: zzag */
    public final void zzX() {
        zzg();
        zzgr zzk = this.zzu.zzaV().zzk();
        List<Runnable> list = this.zzg;
        zzk.zzb("Processing queued up service tasks", Integer.valueOf(list.size()));
        for (Runnable run : list) {
            try {
                run.run();
            } catch (RuntimeException e) {
                this.zzu.zzaV().zzb().zzb("Task exception while flushing queue", e);
            }
        }
        this.zzg.clear();
        this.zzh.zzd();
    }

    @WorkerThread
    private final zzr zzah(boolean z) {
        Pair zzb2;
        zzib zzib = this.zzu;
        zzib.zzaU();
        zzgh zzv = this.zzu.zzv();
        String str = null;
        if (z) {
            zzib zzib2 = zzib.zzaV().zzu;
            if (!(zzib2.zzd().zzb == null || (zzb2 = zzib2.zzd().zzb.zzb()) == null || zzb2 == zzhg.zza)) {
                String valueOf = String.valueOf(zzb2.second);
                String str2 = (String) zzb2.first;
                str = e.q(new StringBuilder(valueOf.length() + 1 + String.valueOf(str2).length()), valueOf, ":", str2);
            }
        }
        return zzv.zzh(str);
    }

    @WorkerThread
    public final void zzA(zzpk zzpk) {
        zzg();
        zzb();
        zzad();
        zzaf(new zzmf(this, zzah(true), this.zzu.zzm().zzj(zzpk), zzpk));
    }

    @WorkerThread
    public final void zzB() {
        zzg();
        zzb();
        zzr zzah = zzah(false);
        zzad();
        this.zzu.zzm().zzh();
        zzaf(new zzmg(this, zzah));
    }

    @WorkerThread
    public final void zzC(AtomicReference atomicReference) {
        zzg();
        zzb();
        zzaf(new zzmh(this, atomicReference, zzah(false)));
    }

    @WorkerThread
    public final void zzD(zzcu zzcu) {
        zzg();
        zzb();
        zzaf(new zzmi(this, zzah(false), zzcu));
    }

    @WorkerThread
    public final void zzE() {
        zzg();
        zzb();
        zzr zzah = zzah(true);
        zzad();
        this.zzu.zzc().zzp((String) null, zzfx.zzbc);
        this.zzu.zzm().zzn();
        zzaf(new zzmj(this, zzah, true));
    }

    @WorkerThread
    public final void zzF() {
        zzg();
        zzb();
        zzaf(new zzmk(this, zzah(true)));
    }

    @WorkerThread
    public final void zzG(zzlt zzlt) {
        zzg();
        zzb();
        zzaf(new zzmm(this, zzlt));
    }

    @WorkerThread
    public final void zzH(Bundle bundle) {
        boolean z;
        zzg();
        zzb();
        zzbe zzbe = new zzbe(bundle);
        zzad();
        if (!this.zzu.zzc().zzp((String) null, zzfx.zzbc) || !this.zzu.zzm().zzl(zzbe)) {
            z = false;
        } else {
            z = true;
        }
        zzaf(new zzmn(this, true, zzah(false), z, zzbe, bundle));
    }

    @WorkerThread
    public final void zzI() {
        zzg();
        zzb();
        if (!zzh()) {
            if (!zzK()) {
                zzib zzib = this.zzu;
                if (!zzib.zzc().zzE()) {
                    zzib.zzaU();
                    List<ResolveInfo> queryIntentServices = zzib.zzaY().getPackageManager().queryIntentServices(new Intent().setClassName(zzib.zzaY(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        e.w(zzib, "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
                        return;
                    }
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    Context zzaY = zzib.zzaY();
                    zzib.zzaU();
                    intent.setComponent(new ComponentName(zzaY, "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                return;
            }
            this.zza.zzc();
        }
    }

    public final Boolean zzJ() {
        return this.zzc;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ef  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzK() {
        /*
            r7 = this;
            r7.zzg()
            r7.zzb()
            java.lang.Boolean r0 = r7.zzc
            if (r0 != 0) goto L_0x010d
            r7.zzg()
            r7.zzb()
            com.google.android.gms.measurement.internal.zzib r0 = r7.zzu
            com.google.android.gms.measurement.internal.zzhg r1 = r0.zzd()
            r1.zzg()
            android.content.SharedPreferences r2 = r1.zzd()
            java.lang.String r3 = "use_service"
            boolean r2 = r2.contains(r3)
            r4 = 0
            if (r2 != 0) goto L_0x0028
            r1 = 0
            goto L_0x0034
        L_0x0028:
            android.content.SharedPreferences r1 = r1.zzd()
            boolean r1 = r1.getBoolean(r3, r4)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
        L_0x0034:
            r2 = 1
            if (r1 == 0) goto L_0x003f
            boolean r5 = r1.booleanValue()
            if (r5 == 0) goto L_0x003f
            goto L_0x0107
        L_0x003f:
            r0.zzaU()
            com.google.android.gms.measurement.internal.zzib r5 = r7.zzu
            com.google.android.gms.measurement.internal.zzgh r5 = r5.zzv()
            int r5 = r5.zzo()
            if (r5 != r2) goto L_0x0051
        L_0x004e:
            r4 = 1
            goto L_0x00dd
        L_0x0051:
            com.google.android.gms.measurement.internal.zzgt r5 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzk()
            java.lang.String r6 = "Checking service availability"
            r5.zza(r6)
            com.google.android.gms.measurement.internal.zzpo r5 = r0.zzk()
            r6 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r5 = r5.zzai(r6)
            if (r5 == 0) goto L_0x00ce
            if (r5 == r2) goto L_0x00c0
            r6 = 2
            if (r5 == r6) goto L_0x00a0
            r1 = 3
            if (r5 == r1) goto L_0x009a
            r1 = 9
            if (r5 == r1) goto L_0x0094
            r1 = 18
            if (r5 == r1) goto L_0x008e
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zze()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = "Unexpected service status"
            r1.zzb(r5, r2)
        L_0x008c:
            r2 = 0
            goto L_0x00dd
        L_0x008e:
            java.lang.String r1 = "Service updating"
            defpackage.e.C(r0, r1)
            goto L_0x004e
        L_0x0094:
            java.lang.String r1 = "Service invalid"
            defpackage.e.C(r0, r1)
            goto L_0x008c
        L_0x009a:
            java.lang.String r1 = "Service disabled"
            defpackage.e.C(r0, r1)
            goto L_0x008c
        L_0x00a0:
            com.google.android.gms.measurement.internal.zzgt r5 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzj()
            java.lang.String r6 = "Service container out of date"
            r5.zza(r6)
            com.google.android.gms.measurement.internal.zzpo r5 = r0.zzk()
            int r5 = r5.zzah()
            r6 = 17443(0x4423, float:2.4443E-41)
            if (r5 >= r6) goto L_0x00ba
            goto L_0x00dd
        L_0x00ba:
            if (r1 != 0) goto L_0x00bd
            goto L_0x00be
        L_0x00bd:
            r2 = 0
        L_0x00be:
            r4 = r2
            goto L_0x008c
        L_0x00c0:
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.String r5 = "Service missing"
            r1.zza(r5)
            goto L_0x00dd
        L_0x00ce:
            com.google.android.gms.measurement.internal.zzgt r1 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.String r4 = "Service available"
            r1.zza(r4)
            goto L_0x004e
        L_0x00dd:
            if (r4 != 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.zzal r1 = r0.zzc()
            boolean r1 = r1.zzE()
            if (r1 == 0) goto L_0x00ef
            java.lang.String r1 = "No way to upload. Consider using the full version of Analytics"
            defpackage.e.w(r0, r1)
            goto L_0x0106
        L_0x00ef:
            if (r2 == 0) goto L_0x0106
            com.google.android.gms.measurement.internal.zzhg r0 = r0.zzd()
            r0.zzg()
            android.content.SharedPreferences r0 = r0.zzd()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r3, r4)
            r0.apply()
        L_0x0106:
            r2 = r4
        L_0x0107:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r2)
            r7.zzc = r0
        L_0x010d:
            java.lang.Boolean r0 = r7.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznk.zzK():boolean");
    }

    @WorkerThread
    public final void zzL(zzga zzga) {
        zzg();
        Preconditions.checkNotNull(zzga);
        this.zzb = zzga;
        zzV();
        zzX();
    }

    @WorkerThread
    public final void zzM() {
        zzg();
        zzb();
        zzne zzne = this.zza;
        zzne.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(this.zzu.zzaY(), zzne);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    @WorkerThread
    public final void zzN(zzcu zzcu, zzbg zzbg, String str) {
        zzg();
        zzb();
        zzib zzib = this.zzu;
        if (zzib.zzk().zzai(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzib.zzaV().zze().zza("Not bundling data. Service unavailable or out of date");
            zzib.zzk().zzao(zzcu, new byte[0]);
            return;
        }
        zzaf(new zzmo(this, zzbg, str, zzcu));
    }

    @WorkerThread
    public final boolean zzO() {
        zzg();
        zzb();
        if (!zzK() || this.zzu.zzk().zzah() >= ((Integer) zzfx.zzaJ.zzb((Object) null)).intValue()) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzP() {
        zzg();
        zzb();
        if (!zzK() || this.zzu.zzk().zzah() >= 241200) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ void zzQ() {
        zzga zzga = this.zzb;
        if (zzga == null) {
            e.w(this.zzu, "Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzga.zzy(zzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to send storage consent settings to the service", e);
        }
    }

    public final /* synthetic */ void zzR() {
        zzga zzga = this.zzb;
        if (zzga == null) {
            e.w(this.zzu, "Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr zzah = zzah(false);
            Preconditions.checkNotNull(zzah);
            zzga.zzz(zzah);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to send Dma consent settings to the service", e);
        }
    }

    public final /* synthetic */ void zzS(AtomicReference atomicReference, zzr zzr, Bundle bundle) {
        synchronized (atomicReference) {
            try {
                zzga zzga = this.zzb;
                if (zzga == null) {
                    this.zzu.zzaV().zzb().zza("Failed to request trigger URIs; not connected to service");
                    return;
                }
                Preconditions.checkNotNull(zzr);
                zzga.zzD(zzr, bundle, new zzmd(this, atomicReference));
                zzV();
            } catch (RemoteException e) {
                this.zzu.zzaV().zzb().zzb("Failed to request trigger URIs; remote exception", e);
                atomicReference.notifyAll();
            }
        }
    }

    public final /* synthetic */ void zzT(AtomicReference atomicReference, zzr zzr, zzon zzon) {
        synchronized (atomicReference) {
            try {
                zzga zzga = this.zzb;
                if (zzga == null) {
                    this.zzu.zzaV().zzb().zza("[sgtm] Failed to get upload batches; not connected to service");
                    return;
                }
                Preconditions.checkNotNull(zzr);
                zzga.zzB(zzr, zzon, new zzme(this, atomicReference));
                zzV();
            } catch (RemoteException e) {
                this.zzu.zzaV().zzb().zzb("[sgtm] Failed to get upload batches; remote exception", e);
                atomicReference.notifyAll();
            }
        }
    }

    public final /* synthetic */ void zzU(zzr zzr, zzaf zzaf) {
        zzga zzga = this.zzb;
        if (zzga == null) {
            e.w(this.zzu, "[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzga.zzC(zzr, zzaf);
            zzV();
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzc("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzaf.zza), e);
        }
    }

    public final /* synthetic */ void zzW(ComponentName componentName) {
        zzg();
        if (this.zzb != null) {
            this.zzb = null;
            this.zzu.zzaV().zzk().zzb("Disconnected from device MeasurementService", componentName);
            zzg();
            zzI();
        }
    }

    public final /* synthetic */ zzne zzY() {
        return this.zza;
    }

    public final /* synthetic */ zzga zzZ() {
        return this.zzb;
    }

    public final /* synthetic */ void zzaa(zzga zzga) {
        this.zzb = null;
    }

    public final /* synthetic */ ScheduledExecutorService zzab() {
        return this.zze;
    }

    public final /* synthetic */ void zzac(ScheduledExecutorService scheduledExecutorService) {
        this.zze = scheduledExecutorService;
    }

    public final boolean zze() {
        return false;
    }

    @WorkerThread
    public final boolean zzh() {
        zzg();
        zzb();
        if (this.zzb != null) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final void zzi() {
        zzg();
        zzb();
        zzaf(new zzmq(this, zzah(true)));
    }

    @WorkerThread
    public final void zzj(boolean z) {
        zzg();
        zzb();
        if (zzO()) {
            zzaf(new zzmr(this, zzah(false)));
        }
    }

    @WorkerThread
    public final void zzk(boolean z) {
        zzg();
        zzb();
        zzaf(new zznj(this));
    }

    @WorkerThread
    public final void zzl() {
        zzg();
        zzb();
        zzaf(new zznf(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a8  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzm(com.google.android.gms.measurement.internal.zzga r58, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r59, com.google.android.gms.measurement.internal.zzr r60) {
        /*
            r57 = this;
            r1 = r57
            r2 = r58
            r3 = r59
            r57.zzg()
            r57.zzb()
            r57.zzad()
            com.google.android.gms.measurement.internal.zzib r4 = r1.zzu
            r4.zzc()
            r6 = 100
            r0 = r60
            r7 = 0
            r8 = 100
        L_0x001b:
            r9 = 1001(0x3e9, float:1.403E-42)
            if (r7 >= r9) goto L_0x021e
            if (r8 != r6) goto L_0x021e
            com.google.android.gms.measurement.internal.zzib r8 = r1.zzu
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            com.google.android.gms.measurement.internal.zzgk r8 = r8.zzm()
            java.util.List r8 = r8.zzm(r6)
            if (r8 == 0) goto L_0x003a
            r9.addAll(r8)
            int r8 = r8.size()
            goto L_0x003b
        L_0x003a:
            r8 = 0
        L_0x003b:
            if (r3 == 0) goto L_0x004b
            if (r8 >= r6) goto L_0x004b
            java.lang.String r10 = r0.zzc
            long r11 = r0.zzj
            com.google.android.gms.measurement.internal.zzgj r13 = new com.google.android.gms.measurement.internal.zzgj
            r13.<init>(r3, r10, r11)
            r9.add(r13)
        L_0x004b:
            com.google.android.gms.measurement.internal.zzal r10 = r4.zzc()
            com.google.android.gms.measurement.internal.zzfw r11 = com.google.android.gms.measurement.internal.zzfx.zzaO
            r12 = 0
            boolean r10 = r10.zzp(r12, r11)
            int r11 = r9.size()
            r13 = 0
        L_0x005b:
            if (r13 >= r11) goto L_0x0218
            java.lang.Object r14 = r9.get(r13)
            com.google.android.gms.measurement.internal.zzgj r14 = (com.google.android.gms.measurement.internal.zzgj) r14
            com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r15 = r14.zza
            com.google.android.gms.measurement.internal.zzal r5 = r4.zzc()
            com.google.android.gms.measurement.internal.zzfw r6 = com.google.android.gms.measurement.internal.zzfx.zzbc
            boolean r5 = r5.zzp(r12, r6)
            if (r5 == 0) goto L_0x00fe
            java.lang.String r5 = r14.zzb
            boolean r16 = android.text.TextUtils.isEmpty(r5)
            if (r16 != 0) goto L_0x00fe
            r56 = r13
            long r12 = r14.zzc
            r20 = r12
            java.lang.String r12 = r0.zza
            r17 = r12
            java.lang.String r12 = r0.zzb
            r18 = r12
            java.lang.String r12 = r0.zzd
            r22 = r12
            long r12 = r0.zze
            r23 = r12
            long r12 = r0.zzf
            r25 = r12
            java.lang.String r12 = r0.zzg
            r27 = r12
            boolean r12 = r0.zzh
            r28 = r12
            boolean r12 = r0.zzi
            r29 = r12
            java.lang.String r12 = r0.zzk
            r30 = r12
            long r12 = r0.zzl
            r31 = r12
            int r12 = r0.zzm
            r33 = r12
            boolean r12 = r0.zzn
            r34 = r12
            boolean r12 = r0.zzo
            r35 = r12
            java.lang.Boolean r12 = r0.zzp
            r36 = r12
            long r12 = r0.zzq
            r37 = r12
            java.util.List r12 = r0.zzr
            r39 = r12
            java.lang.String r12 = r0.zzs
            r40 = r12
            java.lang.String r12 = r0.zzt
            r41 = r12
            java.lang.String r12 = r0.zzu
            r42 = r12
            boolean r12 = r0.zzv
            r43 = r12
            long r12 = r0.zzw
            r44 = r12
            int r12 = r0.zzx
            r46 = r12
            java.lang.String r12 = r0.zzy
            r47 = r12
            int r12 = r0.zzz
            r48 = r12
            long r12 = r0.zzA
            r49 = r12
            java.lang.String r12 = r0.zzB
            r51 = r12
            java.lang.String r12 = r0.zzC
            r52 = r12
            long r12 = r0.zzD
            r53 = r12
            int r0 = r0.zzE
            r55 = r0
            com.google.android.gms.measurement.internal.zzr r0 = new com.google.android.gms.measurement.internal.zzr
            r16 = r0
            r19 = r5
            r16.<init>((java.lang.String) r17, (java.lang.String) r18, (java.lang.String) r19, (long) r20, (java.lang.String) r22, (long) r23, (long) r25, (java.lang.String) r27, (boolean) r28, (boolean) r29, (java.lang.String) r30, (long) r31, (int) r33, (boolean) r34, (boolean) r35, (java.lang.Boolean) r36, (long) r37, (java.util.List) r39, (java.lang.String) r40, (java.lang.String) r41, (java.lang.String) r42, (boolean) r43, (long) r44, (int) r46, (java.lang.String) r47, (int) r48, (long) r49, (java.lang.String) r51, (java.lang.String) r52, (long) r53, (int) r55)
        L_0x00fc:
            r5 = r0
            goto L_0x0101
        L_0x00fe:
            r56 = r13
            goto L_0x00fc
        L_0x0101:
            boolean r0 = r15 instanceof com.google.android.gms.measurement.internal.zzbg
            if (r0 == 0) goto L_0x01a8
            r12 = 0
            if (r10 == 0) goto L_0x012c
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ RemoteException -> 0x0126 }
            com.google.android.gms.common.util.Clock r6 = r0.zzaZ()     // Catch:{ RemoteException -> 0x0126 }
            long r16 = r6.currentTimeMillis()     // Catch:{ RemoteException -> 0x0126 }
            com.google.android.gms.common.util.Clock r0 = r0.zzaZ()     // Catch:{ RemoteException -> 0x0120 }
            long r18 = r0.elapsedRealtime()     // Catch:{ RemoteException -> 0x0120 }
            r24 = r16
            r26 = r18
            goto L_0x0130
        L_0x0120:
            r0 = move-exception
            r26 = r12
            r19 = r16
            goto L_0x016f
        L_0x0126:
            r0 = move-exception
            r19 = r12
            r26 = r19
            goto L_0x016f
        L_0x012c:
            r24 = r12
            r26 = r24
        L_0x0130:
            com.google.android.gms.measurement.internal.zzbg r15 = (com.google.android.gms.measurement.internal.zzbg) r15     // Catch:{ RemoteException -> 0x016c }
            r2.zze(r15, r5)     // Catch:{ RemoteException -> 0x016c }
            if (r10 == 0) goto L_0x0169
            com.google.android.gms.measurement.internal.zzgt r0 = r4.zzaV()     // Catch:{ RemoteException -> 0x016c }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()     // Catch:{ RemoteException -> 0x016c }
            java.lang.String r6 = "Logging telemetry for logEvent from database"
            r0.zza(r6)     // Catch:{ RemoteException -> 0x016c }
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ RemoteException -> 0x016c }
            com.google.android.gms.measurement.internal.zzgp r16 = com.google.android.gms.measurement.internal.zzgp.zza(r0)     // Catch:{ RemoteException -> 0x016c }
            com.google.android.gms.common.util.Clock r6 = r0.zzaZ()     // Catch:{ RemoteException -> 0x016c }
            long r21 = r6.currentTimeMillis()     // Catch:{ RemoteException -> 0x016c }
            com.google.android.gms.common.util.Clock r0 = r0.zzaZ()     // Catch:{ RemoteException -> 0x016c }
            long r14 = r0.elapsedRealtime()     // Catch:{ RemoteException -> 0x016c }
            long r14 = r14 - r26
            int r0 = (int) r14     // Catch:{ RemoteException -> 0x016c }
            r17 = 36301(0x8dcd, float:5.0869E-41)
            r18 = 0
            r19 = r24
            r23 = r0
            r16.zzb(r17, r18, r19, r21, r23)     // Catch:{ RemoteException -> 0x016c }
        L_0x0169:
            r13 = 0
            goto L_0x020f
        L_0x016c:
            r0 = move-exception
            r19 = r24
        L_0x016f:
            com.google.android.gms.measurement.internal.zzib r6 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()
            java.lang.String r14 = "Failed to send event to the service"
            r6.zzb(r14, r0)
            if (r10 == 0) goto L_0x0169
            int r0 = (r19 > r12 ? 1 : (r19 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x0169
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzgp r16 = com.google.android.gms.measurement.internal.zzgp.zza(r0)
            com.google.android.gms.common.util.Clock r6 = r0.zzaZ()
            long r21 = r6.currentTimeMillis()
            com.google.android.gms.common.util.Clock r0 = r0.zzaZ()
            long r12 = r0.elapsedRealtime()
            long r12 = r12 - r26
            int r0 = (int) r12
            r17 = 36301(0x8dcd, float:5.0869E-41)
            r18 = 13
            r23 = r0
            r16.zzb(r17, r18, r19, r21, r23)
            goto L_0x0169
        L_0x01a8:
            boolean r0 = r15 instanceof com.google.android.gms.measurement.internal.zzpk
            if (r0 == 0) goto L_0x01c3
            com.google.android.gms.measurement.internal.zzpk r15 = (com.google.android.gms.measurement.internal.zzpk) r15     // Catch:{ RemoteException -> 0x01b2 }
            r2.zzf(r15, r5)     // Catch:{ RemoteException -> 0x01b2 }
            goto L_0x0169
        L_0x01b2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r6 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()
            java.lang.String r12 = "Failed to send user property to the service"
            r6.zzb(r12, r0)
            goto L_0x0169
        L_0x01c3:
            boolean r0 = r15 instanceof com.google.android.gms.measurement.internal.zzah
            if (r0 == 0) goto L_0x01de
            com.google.android.gms.measurement.internal.zzah r15 = (com.google.android.gms.measurement.internal.zzah) r15     // Catch:{ RemoteException -> 0x01cd }
            r2.zzn(r15, r5)     // Catch:{ RemoteException -> 0x01cd }
            goto L_0x0169
        L_0x01cd:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r6 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()
            java.lang.String r12 = "Failed to send conditional user property to the service"
            r6.zzb(r12, r0)
            goto L_0x0169
        L_0x01de:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzal r12 = r0.zzc()
            r13 = 0
            boolean r6 = r12.zzp(r13, r6)
            if (r6 == 0) goto L_0x020a
            boolean r6 = r15 instanceof com.google.android.gms.measurement.internal.zzbe
            if (r6 == 0) goto L_0x020a
            com.google.android.gms.measurement.internal.zzbe r15 = (com.google.android.gms.measurement.internal.zzbe) r15     // Catch:{ RemoteException -> 0x01f9 }
            android.os.Bundle r0 = r15.zzf()     // Catch:{ RemoteException -> 0x01f9 }
            r2.zzu(r0, r5)     // Catch:{ RemoteException -> 0x01f9 }
            goto L_0x020f
        L_0x01f9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r6 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()
            java.lang.String r12 = "Failed to send default event parameters to the service"
            r6.zzb(r12, r0)
            goto L_0x020f
        L_0x020a:
            java.lang.String r6 = "Discarding data. Unrecognized parcel type."
            defpackage.e.w(r0, r6)
        L_0x020f:
            int r0 = r56 + 1
            r12 = r13
            r6 = 100
            r13 = r0
            r0 = r5
            goto L_0x005b
        L_0x0218:
            int r7 = r7 + 1
            r6 = 100
            goto L_0x001b
        L_0x021e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznk.zzm(com.google.android.gms.measurement.internal.zzga, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzr):void");
    }

    @WorkerThread
    public final void zzn(zzbg zzbg, String str) {
        Preconditions.checkNotNull(zzbg);
        zzg();
        zzb();
        zzad();
        zzaf(new zzms(this, true, zzah(true), this.zzu.zzm().zzi(zzbg), zzbg, str));
    }

    @WorkerThread
    public final void zzp(zzah zzah) {
        Preconditions.checkNotNull(zzah);
        zzg();
        zzb();
        this.zzu.zzaU();
        zzaf(new zzmt(this, true, zzah(true), this.zzu.zzm().zzk(zzah), new zzah(zzah), zzah));
    }

    @WorkerThread
    public final void zzq(AtomicReference atomicReference, String str, String str2, String str3) {
        zzg();
        zzb();
        zzaf(new zzmu(this, atomicReference, (String) null, str2, str3, zzah(false)));
    }

    @WorkerThread
    public final void zzs(zzcu zzcu, String str, String str2) {
        zzg();
        zzb();
        zzaf(new zzmv(this, str, str2, zzah(false), zzcu));
    }

    @WorkerThread
    public final void zzt(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmw(this, atomicReference, (String) null, str2, str3, zzah(false), z));
    }

    @WorkerThread
    public final void zzu(zzcu zzcu, String str, String str2, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmb(this, str, str2, zzah(false), z, zzcu));
    }

    @WorkerThread
    public final void zzv(AtomicReference atomicReference, boolean z) {
        zzg();
        zzb();
        zzaf(new zzmc(this, atomicReference, zzah(false), z));
    }

    @WorkerThread
    public final void zzw(AtomicReference atomicReference, Bundle bundle) {
        zzg();
        zzb();
        zzaf(new zzng(this, atomicReference, zzah(false), bundle));
    }

    @WorkerThread
    public final void zzx(AtomicReference atomicReference, zzon zzon) {
        zzg();
        zzb();
        zzaf(new zznh(this, atomicReference, zzah(false), zzon));
    }

    @WorkerThread
    public final void zzy(zzaf zzaf) {
        zzg();
        zzb();
        zzr zzah = zzah(true);
        Preconditions.checkNotNull(zzah);
        zzaf(new zzni(this, zzah, zzaf));
    }

    @WorkerThread
    public final zzao zzz() {
        zzg();
        zzb();
        zzga zzga = this.zzb;
        if (zzga == null) {
            zzI();
            this.zzu.zzaV().zzj().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzah = zzah(false);
        Preconditions.checkNotNull(zzah);
        try {
            zzao zzw = zzga.zzw(zzah);
            zzV();
            return zzw;
        } catch (RemoteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to get consents; remote exception", e);
            return null;
        }
    }
}
