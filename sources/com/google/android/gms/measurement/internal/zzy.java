package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzhf;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhp;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

final class zzy {
    final /* synthetic */ zzad zza;
    private String zzb;
    private boolean zzc;
    private zzii zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public /* synthetic */ zzy(zzad zzad, String str, zzii zzii, BitSet bitSet, BitSet bitSet2, Map map, Map map2, byte[] bArr) {
        Objects.requireNonNull(zzad);
        this.zza = zzad;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzii;
    }

    public final void zza(@NonNull zzab zzab) {
        int zza2 = zzab.zza();
        if (zzab.zzd != null) {
            this.zzf.set(zza2, true);
        }
        Boolean bool = zzab.zze;
        if (bool != null) {
            this.zze.set(zza2, bool.booleanValue());
        }
        if (zzab.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza2);
            Long l = (Long) map.get(valueOf);
            long longValue = zzab.zzf.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzab.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza2);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzab.zzb()) {
                list.clear();
            }
            zzpq.zza();
            zzib zzib = this.zza.zzu;
            zzal zzc2 = zzib.zzc();
            String str = this.zzb;
            zzfw zzfw = zzfx.zzaF;
            if (zzc2.zzp(str, zzfw) && zzab.zzc()) {
                list.clear();
            }
            zzpq.zza();
            if (zzib.zzc().zzp(this.zzb, zzfw)) {
                Long valueOf3 = Long.valueOf(zzab.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzab.zzg.longValue() / 1000));
        }
    }

    @NonNull
    public final zzhg zzb(int i) {
        ArrayList arrayList;
        List list;
        zzhf zzh2 = zzhg.zzh();
        zzh2.zza(i);
        zzh2.zzd(this.zzc);
        zzii zzii = this.zzd;
        if (zzii != null) {
            zzh2.zzc(zzii);
        }
        zzih zzi = zzii.zzi();
        zzi.zzc(zzpj.zzp(this.zze));
        zzi.zza(zzpj.zzp(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.zzg.keySet()) {
                int intValue = num.intValue();
                Long l = (Long) this.zzg.get(num);
                if (l != null) {
                    zzhp zze2 = zzhq.zze();
                    zze2.zza(intValue);
                    zze2.zzb(l.longValue());
                    arrayList2.add((zzhq) zze2.zzbc());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzi.zze(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.zzh.keySet()) {
                zzij zzf2 = zzik.zzf();
                zzf2.zza(num2.intValue());
                List list2 = (List) this.zzh.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzf2.zzb(list2);
                }
                arrayList3.add((zzik) zzf2.zzbc());
            }
            list = arrayList3;
        }
        zzi.zzg(list);
        zzh2.zzb(zzi);
        return (zzhg) zzh2.zzbc();
    }

    public final /* synthetic */ BitSet zzc() {
        return this.zze;
    }

    public /* synthetic */ zzy(zzad zzad, String str, byte[] bArr) {
        Objects.requireNonNull(zzad);
        this.zza = zzad;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }
}
