package com.google.android.gms.internal.measurement;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzae implements Iterable, zzao, zzak {
    @VisibleForTesting
    final SortedMap zza;
    @VisibleForTesting
    final Map zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzae = (zzae) obj;
        if (zzh() != zzae.zzh()) {
            return false;
        }
        SortedMap sortedMap = this.zza;
        if (sortedMap.isEmpty()) {
            return zzae.zza.isEmpty();
        }
        for (int intValue = ((Integer) sortedMap.firstKey()).intValue(); intValue <= ((Integer) sortedMap.lastKey()).intValue(); intValue++) {
            if (!zzl(intValue).equals(zzae.zzl(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    public final Iterator iterator() {
        return new zzad(this);
    }

    public final String toString() {
        return zzs(",");
    }

    public final List zzb() {
        ArrayList arrayList = new ArrayList(zzh());
        for (int i = 0; i < zzh(); i++) {
            arrayList.add(zzl(i));
        }
        return arrayList;
    }

    public final String zzc() {
        return zzs(",");
    }

    public final zzao zzcA(String str, zzg zzg, List list) {
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) {
            return zzba.zza(str, this, zzg, list);
        }
        return a.a(this, new zzas(str), zzg, list);
    }

    public final Double zzd() {
        SortedMap sortedMap = this.zza;
        if (sortedMap.size() == 1) {
            return zzl(0).zzd();
        }
        if (sortedMap.size() <= 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.NaN);
    }

    public final Boolean zze() {
        return Boolean.TRUE;
    }

    public final Iterator zzf() {
        return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final Iterator zzg() {
        return this.zza.keySet().iterator();
    }

    public final int zzh() {
        SortedMap sortedMap = this.zza;
        if (sortedMap.isEmpty()) {
            return 0;
        }
        return ((Integer) sortedMap.lastKey()).intValue() + 1;
    }

    public final int zzi() {
        return this.zza.size();
    }

    public final boolean zzj(String str) {
        if ("length".equals(str) || this.zzb.containsKey(str)) {
            return true;
        }
        return false;
    }

    public final zzao zzk(String str) {
        zzao zzao;
        if ("length".equals(str)) {
            return new zzah(Double.valueOf((double) zzh()));
        }
        if (!zzj(str) || (zzao = (zzao) this.zzb.get(str)) == null) {
            return zzao.zzf;
        }
        return zzao;
    }

    public final zzao zzl(int i) {
        zzao zzao;
        if (i >= zzh()) {
            throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
        } else if (!zzo(i) || (zzao = (zzao) this.zza.get(Integer.valueOf(i))) == null) {
            return zzao.zzf;
        } else {
            return zzao;
        }
    }

    public final void zzm(String str, zzao zzao) {
        if (zzao == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzao);
        }
    }

    @RequiresNonNull({"elements"})
    public final void zzn(int i, zzao zzao) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        } else if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (zzao == null) {
            this.zza.remove(Integer.valueOf(i));
        } else {
            this.zza.put(Integer.valueOf(i), zzao);
        }
    }

    public final boolean zzo(int i) {
        if (i >= 0) {
            SortedMap sortedMap = this.zza;
            if (i <= ((Integer) sortedMap.lastKey()).intValue()) {
                return sortedMap.containsKey(Integer.valueOf(i));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void zzp() {
        this.zza.clear();
    }

    public final void zzq(int i, zzao zzao) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Invalid value index: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= zzh()) {
            zzn(i, zzao);
        } else {
            SortedMap sortedMap = this.zza;
            for (int intValue = ((Integer) sortedMap.lastKey()).intValue(); intValue >= i; intValue--) {
                Integer valueOf = Integer.valueOf(intValue);
                zzao zzao2 = (zzao) sortedMap.get(valueOf);
                if (zzao2 != null) {
                    zzn(intValue + 1, zzao2);
                    sortedMap.remove(valueOf);
                }
            }
            zzn(i, zzao);
        }
    }

    public final void zzr(int i) {
        SortedMap sortedMap = this.zza;
        int intValue = ((Integer) sortedMap.lastKey()).intValue();
        if (i <= intValue && i >= 0) {
            sortedMap.remove(Integer.valueOf(i));
            if (i == intValue) {
                int i2 = i - 1;
                Integer valueOf = Integer.valueOf(i2);
                if (!sortedMap.containsKey(valueOf) && i2 >= 0) {
                    sortedMap.put(valueOf, zzao.zzf);
                    return;
                }
                return;
            }
            while (true) {
                i++;
                if (i <= ((Integer) sortedMap.lastKey()).intValue()) {
                    Integer valueOf2 = Integer.valueOf(i);
                    zzao zzao = (zzao) sortedMap.get(valueOf2);
                    if (zzao != null) {
                        sortedMap.put(Integer.valueOf(i - 1), zzao);
                        sortedMap.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final String zzs(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            int i = 0;
            while (true) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i >= zzh()) {
                    break;
                }
                zzao zzl = zzl(i);
                sb.append(str2);
                if (!(zzl instanceof zzat) && !(zzl instanceof zzam)) {
                    sb.append(zzl.zzc());
                }
                i++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final zzao zzt() {
        zzae zzae = new zzae();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzak) {
                zzae.zza.put((Integer) entry.getKey(), (zzao) entry.getValue());
            } else {
                zzae.zza.put((Integer) entry.getKey(), ((zzao) entry.getValue()).zzt());
            }
        }
        return zzae;
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                zzn(i, (zzao) list.get(i));
            }
        }
    }
}
