package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzd;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzjc extends zzfz {
    private final zzpf zza;
    private Boolean zzb;
    private String zzc = null;

    public zzjc(zzpf zzpf, String str) {
        Preconditions.checkNotNull(zzpf);
        this.zza = zzpf;
    }

    private final void zzM(zzbg zzbg, zzr zzr) {
        zzpf zzpf = this.zza;
        zzpf.zzY();
        zzpf.zzF(zzbg, zzr);
    }

    @BinderThread
    private final void zzN(zzr zzr, boolean z) {
        Preconditions.checkNotNull(zzr);
        String str = zzr.zza;
        Preconditions.checkNotEmpty(str);
        zzO(str, false);
        this.zza.zzt().zzA(zzr.zzb);
    }

    @BinderThread
    private final void zzO(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        boolean z2 = true;
                        if (!"com.google.android.gms".equals(this.zzc)) {
                            zzpf zzpf = this.zza;
                            if (!UidVerifier.isGooglePlayServicesUid(zzpf.zzaY(), Binder.getCallingUid())) {
                                if (!GoogleSignatureVerifier.getInstance(zzpf.zzaY()).isUidGoogleSigned(Binder.getCallingUid())) {
                                    z2 = false;
                                }
                            }
                        }
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzaV().zzb().zzb("Measurement Service called with invalid calling package. appId", zzgt.zzl(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzaY(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException("Unknown calling package name '" + str + "'.");
            }
            return;
        }
        this.zza.zzaV().zzb().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @BinderThread
    public final void zzA(zzr zzr) {
        zzN(zzr, false);
        zzd(new zzie(this, zzr));
    }

    @BinderThread
    public final void zzB(zzr zzr, zzon zzon, zzgg zzgg) {
        zzN(zzr, false);
        this.zza.zzaW().zzj(new zziy(this, (String) Preconditions.checkNotNull(zzr.zza), zzon, zzgg));
    }

    @BinderThread
    public final void zzC(zzr zzr, zzaf zzaf) {
        zzN(zzr, false);
        zzd(new zziz(this, zzr, zzaf));
    }

    @BinderThread
    public final void zzD(zzr zzr, Bundle bundle, zzgd zzgd) {
        zzN(zzr, false);
        this.zza.zzaW().zzj(new zzix(this, zzr, bundle, zzgd, (String) Preconditions.checkNotNull(zzr.zza)));
    }

    @VisibleForTesting
    public final void zzE(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpf zzpf = this.zza;
        if (zzpf.zzaW().zze()) {
            runnable.run();
        } else {
            zzpf.zzaW().zzl(runnable);
        }
    }

    public final /* synthetic */ void zzF(zzr zzr) {
        zzpf zzpf = this.zza;
        zzpf.zzY();
        zzpf.zzv(zzr);
    }

    public final /* synthetic */ void zzG(zzr zzr) {
        zzpf zzpf = this.zza;
        zzpf.zzY();
        zzpf.zzw(zzr);
    }

    public final /* synthetic */ void zzH(zzr zzr, Bundle bundle, zzgd zzgd, String str) {
        zzpf zzpf = this.zza;
        zzpf.zzY();
        try {
            zzgd.zze(zzpf.zzap(zzr, bundle));
        } catch (RemoteException e) {
            this.zza.zzaV().zzb().zzc("Failed to return trigger URIs for app", str, e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00a6, code lost:
        if (r0.zzaZ().currentTimeMillis() >= (r2.zzh() + java.lang.Math.min(((java.lang.Long) com.google.android.gms.measurement.internal.zzfx.zzw.zzb((java.lang.Object) null)).longValue() * (1 << (r4 - 1)), ((java.lang.Long) com.google.android.gms.measurement.internal.zzfx.zzx.zzb((java.lang.Object) null)).longValue()))) goto L_0x00a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzI(java.lang.String r11, com.google.android.gms.measurement.internal.zzon r12, com.google.android.gms.measurement.internal.zzgg r13) {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzpf r0 = r10.zza
            r0.zzY()
            com.google.android.gms.measurement.internal.zzhy r1 = r0.zzaW()
            r1.zzg()
            r0.zzu()
            com.google.android.gms.measurement.internal.zzav r1 = r0.zzj()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzA
            r3 = 0
            java.lang.Object r2 = r2.zzb(r3)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.util.List r12 = r1.zzC(r11, r12, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r12 = r12.iterator()
        L_0x002d:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x0138
            java.lang.Object r2 = r12.next()
            com.google.android.gms.measurement.internal.zzpi r2 = (com.google.android.gms.measurement.internal.zzpi) r2
            java.lang.String r4 = r2.zze()
            boolean r4 = r0.zzO(r11, r4)
            if (r4 != 0) goto L_0x005d
            com.google.android.gms.measurement.internal.zzgt r4 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzk()
            long r5 = r2.zzc()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r2 = r2.zze()
            java.lang.String r6 = "[sgtm] batch skipped due to destination in backoff. appId, rowId, url"
            r4.zzd(r6, r11, r5, r2)
            goto L_0x002d
        L_0x005d:
            int r4 = r2.zzi()
            if (r4 > 0) goto L_0x0064
            goto L_0x00a8
        L_0x0064:
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzy
            java.lang.Object r5 = r5.zzb(r3)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r4 <= r5) goto L_0x0074
            goto L_0x0119
        L_0x0074:
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzw
            java.lang.Object r5 = r5.zzb(r3)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r4 = r4 + -1
            r7 = 1
            long r7 = r7 << r4
            long r5 = r5 * r7
            com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.zzx
            java.lang.Object r4 = r4.zzb(r3)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            long r4 = java.lang.Math.min(r5, r7)
            com.google.android.gms.common.util.Clock r6 = r0.zzaZ()
            long r6 = r6.currentTimeMillis()
            long r8 = r2.zzh()
            long r8 = r8 + r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0119
        L_0x00a8:
            com.google.android.gms.measurement.internal.zzol r2 = r2.zzb()
            com.google.android.gms.internal.measurement.zzhz r4 = com.google.android.gms.internal.measurement.zzib.zzh()     // Catch:{ zzmq -> 0x010a }
            byte[] r5 = r2.zzb     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.internal.measurement.zznk r4 = com.google.android.gms.measurement.internal.zzpj.zzw(r4, r5)     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.internal.measurement.zzhz r4 = (com.google.android.gms.internal.measurement.zzhz) r4     // Catch:{ zzmq -> 0x010a }
            r5 = 0
        L_0x00b9:
            int r6 = r4.zzb()     // Catch:{ zzmq -> 0x010a }
            if (r5 >= r6) goto L_0x00da
            com.google.android.gms.internal.measurement.zzid r6 = r4.zzc(r5)     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.internal.measurement.zzma r6 = r6.zzcl()     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.internal.measurement.zzic r6 = (com.google.android.gms.internal.measurement.zzic) r6     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.common.util.Clock r7 = r0.zzaZ()     // Catch:{ zzmq -> 0x010a }
            long r7 = r7.currentTimeMillis()     // Catch:{ zzmq -> 0x010a }
            r6.zzs(r7)     // Catch:{ zzmq -> 0x010a }
            r4.zzd(r5, r6)     // Catch:{ zzmq -> 0x010a }
            int r5 = r5 + 1
            goto L_0x00b9
        L_0x00da:
            com.google.android.gms.internal.measurement.zzme r5 = r4.zzbc()     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.internal.measurement.zzib r5 = (com.google.android.gms.internal.measurement.zzib) r5     // Catch:{ zzmq -> 0x010a }
            byte[] r5 = r5.zzcc()     // Catch:{ zzmq -> 0x010a }
            r2.zzb = r5     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.measurement.internal.zzgt r5 = r0.zzaV()     // Catch:{ zzmq -> 0x010a }
            java.lang.String r5 = r5.zzn()     // Catch:{ zzmq -> 0x010a }
            r6 = 2
            boolean r5 = android.util.Log.isLoggable(r5, r6)     // Catch:{ zzmq -> 0x010a }
            if (r5 == 0) goto L_0x0105
            com.google.android.gms.measurement.internal.zzpj r5 = r0.zzp()     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.internal.measurement.zzme r4 = r4.zzbc()     // Catch:{ zzmq -> 0x010a }
            com.google.android.gms.internal.measurement.zzib r4 = (com.google.android.gms.internal.measurement.zzib) r4     // Catch:{ zzmq -> 0x010a }
            java.lang.String r4 = r5.zzi(r4)     // Catch:{ zzmq -> 0x010a }
            r2.zzg = r4     // Catch:{ zzmq -> 0x010a }
        L_0x0105:
            r1.add(r2)
            goto L_0x002d
        L_0x010a:
            com.google.android.gms.measurement.internal.zzgt r2 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zze()
            java.lang.String r4 = "Failed to parse queued batch. appId"
            r2.zzb(r4, r11)
            goto L_0x002d
        L_0x0119:
            com.google.android.gms.measurement.internal.zzgt r4 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzk()
            long r5 = r2.zzc()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            long r6 = r2.zzh()
            java.lang.Long r2 = java.lang.Long.valueOf(r6)
            java.lang.String r6 = "[sgtm] batch skipped waiting for next retry. appId, rowId, lastUploadMillis"
            r4.zzd(r6, r11, r5, r2)
            goto L_0x002d
        L_0x0138:
            com.google.android.gms.measurement.internal.zzop r12 = new com.google.android.gms.measurement.internal.zzop
            r12.<init>(r1)
            r13.zze(r12)     // Catch:{ RemoteException -> 0x015a }
            com.google.android.gms.measurement.internal.zzpf r13 = r10.zza     // Catch:{ RemoteException -> 0x015a }
            com.google.android.gms.measurement.internal.zzgt r13 = r13.zzaV()     // Catch:{ RemoteException -> 0x015a }
            com.google.android.gms.measurement.internal.zzgr r13 = r13.zzk()     // Catch:{ RemoteException -> 0x015a }
            java.lang.String r0 = "[sgtm] Sending queued upload batches to client. appId, count"
            java.util.List r12 = r12.zza     // Catch:{ RemoteException -> 0x015a }
            int r12 = r12.size()     // Catch:{ RemoteException -> 0x015a }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ RemoteException -> 0x015a }
            r13.zzc(r0, r11, r12)     // Catch:{ RemoteException -> 0x015a }
            return
        L_0x015a:
            r12 = move-exception
            com.google.android.gms.measurement.internal.zzpf r13 = r10.zza
            com.google.android.gms.measurement.internal.zzgt r13 = r13.zzaV()
            com.google.android.gms.measurement.internal.zzgr r13 = r13.zzb()
            java.lang.String r0 = "[sgtm] Failed to return upload batches for app"
            r13.zzc(r0, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjc.zzI(java.lang.String, com.google.android.gms.measurement.internal.zzon, com.google.android.gms.measurement.internal.zzgg):void");
    }

    public final /* synthetic */ void zzJ(zzr zzr, zzaf zzaf) {
        zzpf zzpf = this.zza;
        zzpf.zzY();
        zzpf.zzaq((String) Preconditions.checkNotNull(zzr.zza), zzaf);
    }

    public final /* synthetic */ void zzK(Bundle bundle, String str, zzr zzr) {
        String str2 = str;
        zzpf zzpf = this.zza;
        boolean zzp = zzpf.zzd().zzp((String) null, zzfx.zzaV);
        if (!bundle.isEmpty() || !zzp) {
            zzav zzj = zzpf.zzj();
            zzj.zzg();
            zzj.zzay();
            byte[] zzcc = zzj.zzg.zzp().zzh(new zzbb(zzj.zzu, "", str, "dep", 0, 0, bundle)).zzcc();
            zzib zzib = zzj.zzu;
            zzib.zzaV().zzk().zzc("Saving default event parameters, appId, data size", str2, Integer.valueOf(zzcc.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str2);
            contentValues.put("parameters", zzcc);
            try {
                if (zzj.zze().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) == -1) {
                    zzib.zzaV().zzb().zzb("Failed to insert default event parameters (got -1). appId", zzgt.zzl(str));
                }
            } catch (SQLiteException e) {
                zzj.zzu.zzaV().zzb().zzc("Error storing default event parameters. appId", zzgt.zzl(str), e);
            }
            zzpf zzpf2 = this.zza;
            zzav zzj2 = zzpf2.zzj();
            long j = zzr.zzD;
            if (zzj2.zzX(str2, j)) {
                zzpf2.zzj().zzY(str2, Long.valueOf(j), (String) null, bundle);
                return;
            }
            return;
        }
        zzav zzj3 = this.zza.zzj();
        zzj3.zzg();
        zzj3.zzay();
        try {
            zzj3.zze().execSQL("delete from default_event_params where app_id=?", new String[]{str});
        } catch (SQLiteException e2) {
            zzj3.zzu.zzaV().zzb().zzb("Error clearing default event params", e2);
        }
    }

    public final /* synthetic */ zzpf zzL() {
        return this.zza;
    }

    public final void zzb(zzbg zzbg, zzr zzr) {
        zzc zzc2;
        zzpf zzpf = this.zza;
        zzhs zzh = zzpf.zzh();
        String str = zzr.zza;
        if (TextUtils.isEmpty(str)) {
            zzc2 = null;
        } else {
            zzc2 = (zzc) zzh.zzd.get(str);
        }
        if (zzc2 != null) {
            try {
                Map zzz = zzpf.zzp().zzz(zzbg.zzb.zzf(), true);
                String str2 = zzbg.zza;
                String zza2 = zzjl.zza(str2);
                if (zza2 != null) {
                    str2 = zza2;
                }
                if (zzc2.zzb(new zzaa(str2, zzbg.zzd, zzz))) {
                    if (zzc2.zzc()) {
                        zzpf zzpf2 = this.zza;
                        zzpf2.zzaV().zzk().zzb("EES edited event", zzbg.zza);
                        zzM(zzpf2.zzp().zzA(zzc2.zze().zzc()), zzr);
                    } else {
                        zzM(zzbg, zzr);
                    }
                    if (zzc2.zzd()) {
                        for (zzaa zzaa : zzc2.zze().zzf()) {
                            zzpf zzpf3 = this.zza;
                            zzpf3.zzaV().zzk().zzb("EES logging created event", zzaa.zzb());
                            zzM(zzpf3.zzp().zzA(zzaa), zzr);
                        }
                        return;
                    }
                    return;
                }
            } catch (zzd unused) {
                this.zza.zzaV().zzb().zzc("EES error. appId, eventName", zzr.zzb, zzbg.zza);
            }
            this.zza.zzaV().zzk().zzb("EES was not applied to event", zzbg.zza);
            zzM(zzbg, zzr);
            return;
        }
        this.zza.zzaV().zzk().zzb("EES not loaded for", zzr.zza);
        zzM(zzbg, zzr);
    }

    @VisibleForTesting
    public final zzbg zzc(zzbg zzbg, zzr zzr) {
        zzbe zzbe;
        if (!(!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzbg.zza) || (zzbe = zzbg.zzb) == null || zzbe.zze() == 0)) {
            String zzd = zzbe.zzd("_cis");
            if ("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) {
                this.zza.zzaV().zzi().zzb("Event has been filtered ", zzbg.toString());
                return new zzbg("_cmpx", zzbe, zzbg.zzc, zzbg.zzd);
            }
        }
        return zzbg;
    }

    @VisibleForTesting
    public final void zzd(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        zzpf zzpf = this.zza;
        if (zzpf.zzaW().zze()) {
            runnable.run();
        } else {
            zzpf.zzaW().zzj(runnable);
        }
    }

    @BinderThread
    public final void zze(zzbg zzbg, zzr zzr) {
        Preconditions.checkNotNull(zzbg);
        zzN(zzr, false);
        zzd(new zziq(this, zzbg, zzr));
    }

    @BinderThread
    public final void zzf(zzpk zzpk, zzr zzr) {
        Preconditions.checkNotNull(zzpk);
        zzN(zzr, false);
        zzd(new zzit(this, zzpk, zzr));
    }

    @BinderThread
    public final void zzg(zzr zzr) {
        zzN(zzr, false);
        zzd(new zzid(this, zzr));
    }

    @BinderThread
    public final void zzh(zzbg zzbg, String str, String str2) {
        Preconditions.checkNotNull(zzbg);
        Preconditions.checkNotEmpty(str);
        zzO(str, true);
        zzd(new zzir(this, zzbg, str));
    }

    @BinderThread
    public final void zzi(zzr zzr) {
        zzN(zzr, false);
        zzd(new zzim(this, zzr));
    }

    @BinderThread
    public final List zzj(zzr zzr, boolean z) {
        zzN(zzr, false);
        String str = zzr.zza;
        Preconditions.checkNotNull(str);
        try {
            List<zzpm> list = (List) this.zza.zzaW().zzh(new zzic(this, str)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpm zzpm : list) {
                if (!z) {
                    if (!zzpo.zzZ(zzpm.zzc)) {
                    }
                }
                arrayList.add(new zzpk(zzpm));
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.zza.zzaV().zzb().zzc("Failed to get user properties. appId", zzgt.zzl(zzr.zza), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            this.zza.zzaV().zzb().zzc("Failed to get user properties. appId", zzgt.zzl(zzr.zza), e);
            return null;
        }
    }

    @BinderThread
    public final byte[] zzk(zzbg zzbg, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbg);
        zzO(str, true);
        zzpf zzpf = this.zza;
        zzgr zzj = zzpf.zzaV().zzj();
        zzgm zzs = zzpf.zzs();
        String str2 = zzbg.zza;
        zzj.zzb("Log and bundle. event", zzs.zza(str2));
        long nanoTime = zzpf.zzaZ().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) zzpf.zzaW().zzi(new zzis(this, zzbg, str)).get();
            if (bArr == null) {
                zzpf.zzaV().zzb().zzb("Log and bundle returned null. appId", zzgt.zzl(str));
                bArr = new byte[0];
            }
            zzpf.zzaV().zzj().zzd("Log and bundle processed. event, size, time_ms", zzpf.zzs().zza(str2), Integer.valueOf(bArr.length), Long.valueOf((zzpf.zzaZ().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            zzpf zzpf2 = this.zza;
            zzpf2.zzaV().zzb().zzd("Failed to log and bundle. appId, event, error", zzgt.zzl(str), zzpf2.zzs().zza(zzbg.zza), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            zzpf zzpf22 = this.zza;
            zzpf22.zzaV().zzb().zzd("Failed to log and bundle. appId, event, error", zzgt.zzl(str), zzpf22.zzs().zza(zzbg.zza), e);
            return null;
        }
    }

    @BinderThread
    public final void zzl(long j, String str, String str2, String str3) {
        zzd(new zzif(this, str2, str3, str, j));
    }

    @BinderThread
    public final String zzm(zzr zzr) {
        zzN(zzr, false);
        return this.zza.zzao(zzr);
    }

    @BinderThread
    public final void zzn(zzah zzah, zzr zzr) {
        Preconditions.checkNotNull(zzah);
        Preconditions.checkNotNull(zzah.zzc);
        zzN(zzr, false);
        zzah zzah2 = new zzah(zzah);
        zzah2.zza = zzr.zza;
        zzd(new zzig(this, zzah2, zzr));
    }

    @BinderThread
    public final void zzo(zzah zzah) {
        Preconditions.checkNotNull(zzah);
        Preconditions.checkNotNull(zzah.zzc);
        Preconditions.checkNotEmpty(zzah.zza);
        zzO(zzah.zza, true);
        zzd(new zzih(this, new zzah(zzah)));
    }

    @BinderThread
    public final List zzp(String str, String str2, boolean z, zzr zzr) {
        zzN(zzr, false);
        String str3 = zzr.zza;
        Preconditions.checkNotNull(str3);
        try {
            List<zzpm> list = (List) this.zza.zzaW().zzh(new zzii(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpm zzpm : list) {
                if (!z) {
                    if (!zzpo.zzZ(zzpm.zzc)) {
                    }
                }
                arrayList.add(new zzpk(zzpm));
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.zza.zzaV().zzb().zzc("Failed to query user properties. appId", zzgt.zzl(zzr.zza), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            this.zza.zzaV().zzb().zzc("Failed to query user properties. appId", zzgt.zzl(zzr.zza), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List zzq(String str, String str2, String str3, boolean z) {
        zzO(str, true);
        try {
            List<zzpm> list = (List) this.zza.zzaW().zzh(new zzij(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzpm zzpm : list) {
                if (!z) {
                    if (!zzpo.zzZ(zzpm.zzc)) {
                    }
                }
                arrayList.add(new zzpk(zzpm));
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.zza.zzaV().zzb().zzc("Failed to get user properties as. appId", zzgt.zzl(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            this.zza.zzaV().zzb().zzc("Failed to get user properties as. appId", zzgt.zzl(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List zzr(String str, String str2, zzr zzr) {
        zzN(zzr, false);
        String str3 = zzr.zza;
        Preconditions.checkNotNull(str3);
        try {
            return (List) this.zza.zzaW().zzh(new zzik(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaV().zzb().zzb("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List zzs(String str, String str2, String str3) {
        zzO(str, true);
        try {
            return (List) this.zza.zzaW().zzh(new zzil(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzaV().zzb().zzb("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zzt(zzr zzr) {
        String str = zzr.zza;
        Preconditions.checkNotEmpty(str);
        zzO(str, false);
        zzd(new zzin(this, zzr));
    }

    @BinderThread
    public final void zzu(Bundle bundle, zzr zzr) {
        zzN(zzr, false);
        String str = zzr.zza;
        Preconditions.checkNotNull(str);
        zzd(new zzja(this, bundle, str, zzr));
    }

    @BinderThread
    public final void zzv(zzr zzr) {
        Preconditions.checkNotEmpty(zzr.zza);
        Preconditions.checkNotNull(zzr.zzs);
        zzE(new zzio(this, zzr));
    }

    @BinderThread
    public final zzao zzw(zzr zzr) {
        zzN(zzr, false);
        Preconditions.checkNotEmpty(zzr.zza);
        try {
            return (zzao) this.zza.zzaW().zzi(new zzip(this, zzr)).get(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zza.zzaV().zzb().zzc("Failed to get consent. appId", zzgt.zzl(zzr.zza), e);
            return new zzao((Bundle) null);
        }
    }

    @BinderThread
    public final List zzx(zzr zzr, Bundle bundle) {
        zzN(zzr, false);
        Preconditions.checkNotNull(zzr.zza);
        zzpf zzpf = this.zza;
        if (zzpf.zzd().zzp((String) null, zzfx.zzaY)) {
            try {
                return (List) zzpf.zzaW().zzi(new zziu(this, zzr, bundle)).get(10000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                this.zza.zzaV().zzb().zzc("Failed to get trigger URIs. appId", zzgt.zzl(zzr.zza), e);
                return Collections.emptyList();
            }
        } else {
            try {
                return (List) this.zza.zzaW().zzh(new zziv(this, zzr, bundle)).get();
            } catch (InterruptedException | ExecutionException e2) {
                this.zza.zzaV().zzb().zzc("Failed to get trigger URIs. appId", zzgt.zzl(zzr.zza), e2);
                return Collections.emptyList();
            }
        }
    }

    @BinderThread
    public final void zzy(zzr zzr) {
        Preconditions.checkNotEmpty(zzr.zza);
        Preconditions.checkNotNull(zzr.zzs);
        zzE(new zzjb(this, zzr));
    }

    @BinderThread
    public final void zzz(zzr zzr) {
        Preconditions.checkNotEmpty(zzr.zza);
        Preconditions.checkNotNull(zzr.zzs);
        zzE(new zziw(this, zzr));
    }
}
