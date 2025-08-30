package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhu;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

final class zzis implements Callable {
    final /* synthetic */ zzbg zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjc zzc;

    public zzis(zzjc zzjc, zzbg zzbg, String str) {
        this.zza = zzbg;
        this.zzb = str;
        Objects.requireNonNull(zzjc);
        this.zzc = zzjc;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzlo zzlo;
        byte[] bArr;
        zzpf zzpf;
        zzpf zzpf2;
        zzpm zzpm;
        zzpf zzpf3;
        zzib zzib;
        Bundle bundle;
        zzlo zzlo2;
        String str;
        zzh zzh;
        String str2;
        zzhz zzhz;
        zzpf zzpf4;
        zzib zzib2;
        String str3;
        Bundle bundle2;
        Object obj;
        long j;
        zzic zzic;
        zzbc zzbc;
        zzlo zzlo3;
        byte[] bArr2;
        zzav zzj;
        zzjc zzjc = this.zzc;
        zzjc.zzL().zzY();
        zzlo zzn = zzjc.zzL().zzn();
        zzn.zzg();
        zzib zzib3 = zzn.zzu;
        zzib.zzL();
        zzbg zzbg = this.zza;
        Preconditions.checkNotNull(zzbg);
        String str4 = this.zzb;
        Preconditions.checkNotEmpty(str4);
        String str5 = zzbg.zza;
        if ("_iap".equals(str5) || "_iapx".equals(str5)) {
            zzpf zzpf5 = zzn.zzg;
            zzhz zzh2 = zzib.zzh();
            zzpf5.zzj().zzb();
            zzh zzu = zzpf5.zzj().zzu(str4);
            if (zzu == null) {
                zzn.zzu.zzaV().zzj().zzb("Log and bundle not available. package_name", str4);
                bArr2 = new byte[0];
            } else if (!zzu.zzD()) {
                zzn.zzu.zzaV().zzj().zzb("Log and bundle disabled. package_name", str4);
                bArr2 = new byte[0];
            } else {
                zzic zzaE = zzid.zzaE();
                zzaE.zza(1);
                zzaE.zzC(FaceEnvironment.OS);
                if (!TextUtils.isEmpty(zzu.zzc())) {
                    zzaE.zzL(zzu.zzc());
                }
                if (!TextUtils.isEmpty(zzu.zzv())) {
                    zzaE.zzJ((String) Preconditions.checkNotNull(zzu.zzv()));
                }
                if (!TextUtils.isEmpty(zzu.zzr())) {
                    zzaE.zzM((String) Preconditions.checkNotNull(zzu.zzr()));
                }
                if (zzu.zzt() != -2147483648L) {
                    zzaE.zzaj((int) zzu.zzt());
                }
                zzaE.zzN(zzu.zzx());
                zzaE.zzar(zzu.zzB());
                String zzf = zzu.zzf();
                if (!TextUtils.isEmpty(zzf)) {
                    zzaE.zzad(zzf);
                }
                zzaE.zzay(zzu.zzak());
                zzjk zzB = zzn.zzg.zzB(str4);
                zzaE.zzY(zzu.zzz());
                if (zzib3.zzB() && zzn.zzu.zzc().zzC(zzaE.zzK()) && zzB.zzo(zzjj.AD_STORAGE) && !TextUtils.isEmpty((CharSequence) null)) {
                    zzaE.zzam((String) null);
                }
                zzaE.zzat(zzB.zzk());
                if (zzB.zzo(zzjj.AD_STORAGE) && zzu.zzac()) {
                    Pair zzc2 = zzpf5.zzq().zzc(zzu.zzc(), zzB);
                    if (zzu.zzac() && !TextUtils.isEmpty((CharSequence) zzc2.first)) {
                        try {
                            zzaE.zzQ(zzlo.zzc((String) zzc2.first, Long.toString(zzbg.zzd)));
                            Object obj2 = zzc2.second;
                            if (obj2 != null) {
                                zzaE.zzT(((Boolean) obj2).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzn.zzu.zzaV().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                            bArr = new byte[0];
                            zzpf = zzn.zzg;
                            zzj = zzpf.zzj();
                            zzj.zzd();
                            return bArr2;
                        } catch (Throwable th) {
                            th = th;
                            zzlo = zzn;
                            zzlo.zzg.zzj().zzd();
                            throw th;
                        }
                    }
                }
                zzib zzib4 = zzn.zzu;
                zzib4.zzu().zzw();
                zzaE.zzF(Build.MODEL);
                zzib4.zzu().zzw();
                zzaE.zzE(Build.VERSION.RELEASE);
                zzaE.zzI((int) zzib4.zzu().zzb());
                zzaE.zzH(zzib4.zzu().zzc());
                try {
                    if (zzB.zzo(zzjj.ANALYTICS_STORAGE) && zzu.zzd() != null) {
                        zzaE.zzW(zzlo.zzc((String) Preconditions.checkNotNull(zzu.zzd()), Long.toString(zzbg.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzu.zzl())) {
                        zzaE.zzah((String) Preconditions.checkNotNull(zzu.zzl()));
                    }
                    String zzc3 = zzu.zzc();
                    zzpf2 = zzn.zzg;
                    List zzn2 = zzpf2.zzj().zzn(zzc3);
                    Iterator it = zzn2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzpm = null;
                            break;
                        }
                        zzpm = (zzpm) it.next();
                        if ("_lte".equals(zzpm.zzc)) {
                            break;
                        }
                    }
                    if (zzpm == null || zzpm.zze == null) {
                        zzpm zzpm2 = new zzpm(zzc3, "auto", "_lte", zzn.zzu.zzaZ().currentTimeMillis(), 0L);
                        zzn2.add(zzpm2);
                        zzpf2.zzj().zzl(zzpm2);
                    }
                    zziu[] zziuArr = new zziu[zzn2.size()];
                    for (int i = 0; i < zzn2.size(); i++) {
                        zzit zzm = zziu.zzm();
                        zzm.zzb(((zzpm) zzn2.get(i)).zzc);
                        zzm.zza(((zzpm) zzn2.get(i)).zzd);
                        zzpf2.zzp().zzc(zzm, ((zzpm) zzn2.get(i)).zze);
                        zziuArr[i] = (zziu) zzm.zzbc();
                    }
                    zzaE.zzq(Arrays.asList(zziuArr));
                    zzpf3 = zzn.zzg;
                    zzpf3.zzI(zzu, zzaE);
                    zzpf3.zzJ(zzu, zzaE);
                    zzgu zza2 = zzgu.zza(zzbg);
                    zzib = zzn.zzu;
                    zzpo zzk = zzib.zzk();
                    bundle = zza2.zzd;
                    zzk.zzI(bundle, zzpf2.zzj().zzW(str4));
                    zzib.zzk().zzG(zza2, zzib.zzc().zzd(str4));
                    zzlo2 = zzn;
                } catch (SecurityException e2) {
                    zzlo = zzn;
                    zzlo.zzu.zzaV().zzj().zzb("app instance id encryption failed", e2.getMessage());
                    bArr = new byte[0];
                    zzpf = zzlo.zzg;
                } catch (Throwable th2) {
                    th = th2;
                    zzlo.zzg.zzj().zzd();
                    throw th;
                }
                try {
                    bundle.putLong("_c", 1);
                    zzib.zzaV().zzj().zza("Marking in-app purchase as real-time");
                    bundle.putLong("_r", 1);
                    String str6 = zzbg.zzc;
                    bundle.putString("_o", str6);
                    if (zzib.zzk().zzaa(zzaE.zzK(), zzu.zzay())) {
                        zzib.zzk().zzM(bundle, "_dbg", 1L);
                        zzib.zzk().zzM(bundle, "_r", 1L);
                    }
                    zzav zzj2 = zzpf2.zzj();
                    str = zzbg.zza;
                    zzbc zzf2 = zzj2.zzf(str4, str);
                    if (zzf2 == null) {
                        bundle2 = bundle;
                        str3 = str6;
                        zzib2 = zzib;
                        zzic = zzaE;
                        zzpf4 = zzpf2;
                        zzhz = zzh2;
                        str2 = str4;
                        zzh = zzu;
                        obj = null;
                        zzbc = new zzbc(str4, str, 0, 0, 0, zzbg.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j = 0;
                    } else {
                        zzpf4 = zzpf2;
                        zzh = zzu;
                        zzhz = zzh2;
                        bundle2 = bundle;
                        str3 = str6;
                        zzib2 = zzib;
                        zzic = zzaE;
                        str2 = str4;
                        obj = null;
                        long j2 = zzf2.zzf;
                        zzbc = zzf2.zza(zzbg.zzd);
                        j = j2;
                    }
                    zzpf4.zzj().zzh(zzbc);
                    zzlo3 = zzlo2;
                } catch (Throwable th3) {
                    th = th3;
                    zzlo = zzlo2;
                    zzlo.zzg.zzj().zzd();
                    throw th;
                }
                try {
                    zzib zzib5 = zzlo3.zzu;
                    long j3 = zzbg.zzd;
                    zzlo = zzlo3;
                    zzbb zzbb = new zzbb(zzib5, str3, str2, str, j3, j, bundle2);
                    zzhr zzk2 = zzhs.zzk();
                    zzk2.zzo(zzbb.zzd);
                    zzk2.zzl(zzbb.zzb);
                    zzk2.zzq(zzbb.zze);
                    zzbe zzbe = zzbb.zzf;
                    zzbd zzbd = new zzbd(zzbe);
                    while (zzbd.hasNext()) {
                        String zza3 = zzbd.next();
                        zzhv zzn3 = zzhw.zzn();
                        zzn3.zzb(zza3);
                        Object zza4 = zzbe.zza(zza3);
                        if (zza4 != null) {
                            zzpf4.zzp().zzd(zzn3, zza4);
                            zzk2.zzg(zzn3);
                        }
                    }
                    zzic.zzg(zzk2);
                    zzie zza5 = zzig.zza();
                    zzht zza6 = zzhu.zza();
                    zza6.zzb(zzbc.zzc);
                    zza6.zza(str);
                    zza5.zza(zza6);
                    zzic.zzap(zza5);
                    zzic.zzaf(zzpf4.zzm().zzb(zzh.zzc(), Collections.emptyList(), zzic.zzk(), Long.valueOf(zzk2.zzn()), Long.valueOf(zzk2.zzn()), false));
                    if (zzk2.zzm()) {
                        zzic.zzv(zzk2.zzn());
                        zzic.zzx(zzk2.zzn());
                    }
                    long zzp = zzh.zzp();
                    int i2 = (zzp > 0 ? 1 : (zzp == 0 ? 0 : -1));
                    if (i2 != 0) {
                        zzic.zzA(zzp);
                    }
                    long zzn4 = zzh.zzn();
                    if (zzn4 != 0) {
                        zzic.zzy(zzn4);
                    } else if (i2 != 0) {
                        zzic.zzy(zzp);
                    }
                    String zzh3 = zzh.zzh();
                    zzqu.zza();
                    String str7 = str2;
                    if (zzib2.zzc().zzp(str7, zzfx.zzaM) && zzh3 != null) {
                        zzic.zzau(zzh3);
                    }
                    zzh.zzL();
                    zzic.zzZ((int) zzh.zzG());
                    zzib2.zzc().zzi();
                    zzic.zzO(130000);
                    zzic.zzs(zzib2.zzaZ().currentTimeMillis());
                    zzic.zzae(true);
                    zzpf3.zzS(zzic.zzK(), zzic);
                    zzhz zzhz2 = zzhz;
                    zzhz2.zze(zzic);
                    zzh zzh4 = zzh;
                    zzh4.zzo(zzic.zzu());
                    zzh4.zzq(zzic.zzw());
                    zzpf4.zzj().zzv(zzh4, false, false);
                    zzpf4.zzj().zzc();
                    zzpf4.zzj().zzd();
                    try {
                        return zzpf4.zzp().zzv(((zzib) zzhz2.zzbc()).zzcc());
                    } catch (IOException e3) {
                        zzlo.zzu.zzaV().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgt.zzl(str7), e3);
                        return obj;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    zzlo = zzlo3;
                    zzlo.zzg.zzj().zzd();
                    throw th;
                }
            }
            zzj = zzpf5.zzj();
            zzj.zzd();
            return bArr2;
        }
        zzn.zzu.zzaV().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str4, str5);
        return null;
    }
}
