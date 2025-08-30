package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public final class zzaz {
    public static final zzaz zza = new zzaz((Boolean) null, 100, (Boolean) null, (String) null);
    private final int zzb;
    private final String zzc = zzl();
    private final Boolean zzd;
    private final String zze;
    private final EnumMap zzf;

    public zzaz(Boolean bool, int i, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        this.zzf = enumMap;
        enumMap.put(zzjj.AD_USER_DATA, zzjk.zzh(bool));
        this.zzb = i;
        this.zzd = bool2;
        this.zze = str;
    }

    public static zzaz zza(zzjh zzjh, int i) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        enumMap.put(zzjj.AD_USER_DATA, zzjh);
        return new zzaz(enumMap, -10, (Boolean) null, (String) null);
    }

    public static zzaz zzg(String str) {
        if (str == null || str.length() <= 0) {
            return zza;
        }
        String[] split = str.split(":");
        int parseInt = Integer.parseInt(split[0]);
        EnumMap enumMap = new EnumMap(zzjj.class);
        zzjj[] zza2 = zzji.DMA.zza();
        int length = zza2.length;
        int i = 1;
        int i2 = 0;
        while (i2 < length) {
            enumMap.put(zza2[i2], zzjk.zzj(split[i].charAt(0)));
            i2++;
            i++;
        }
        return new zzaz(enumMap, parseInt, (Boolean) null, (String) null);
    }

    public static zzaz zzh(Bundle bundle, int i) {
        Boolean bool = null;
        if (bundle == null) {
            return new zzaz((Boolean) null, i, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(zzjj.class);
        for (zzjj zzjj : zzji.DMA.zza()) {
            enumMap.put(zzjj, zzjk.zzg(bundle.getString(zzjj.zze)));
        }
        if (bundle.containsKey("is_dma_region")) {
            bool = Boolean.valueOf(bundle.getString("is_dma_region"));
        }
        return new zzaz(enumMap, i, bool, bundle.getString("cps_display_str"));
    }

    public static Boolean zzi(Bundle bundle) {
        zzjh zzg;
        if (bundle == null || (zzg = zzjk.zzg(bundle.getString("ad_personalization"))) == null) {
            return null;
        }
        int ordinal = zzg.ordinal();
        if (ordinal == 2) {
            return Boolean.FALSE;
        }
        if (ordinal != 3) {
            return null;
        }
        return Boolean.TRUE;
    }

    private final String zzl() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        for (zzjj zzjj : zzji.DMA.zza()) {
            sb.append(":");
            sb.append(zzjk.zzm((zzjh) this.zzf.get(zzjj)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzaz)) {
            return false;
        }
        zzaz zzaz = (zzaz) obj;
        if (!this.zzc.equalsIgnoreCase(zzaz.zzc) || !Objects.equals(this.zzd, zzaz.zzd)) {
            return false;
        }
        return Objects.equals(this.zze, zzaz.zze);
    }

    public final int hashCode() {
        int i;
        int i2;
        Boolean bool = this.zzd;
        if (bool == null) {
            i = 3;
        } else if (true != bool.booleanValue()) {
            i = 13;
        } else {
            i = 7;
        }
        String str = this.zze;
        if (str == null) {
            i2 = 17;
        } else {
            i2 = str.hashCode();
        }
        return (i2 * 137) + this.zzc.hashCode() + (i * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(zzjk.zzd(this.zzb));
        for (zzjj zzjj : zzji.DMA.zza()) {
            sb.append(",");
            sb.append(zzjj.zze);
            sb.append("=");
            zzjh zzjh = (zzjh) this.zzf.get(zzjj);
            if (zzjh == null) {
                sb.append("uninitialized");
            } else {
                int ordinal = zzjh.ordinal();
                if (ordinal == 0) {
                    sb.append("uninitialized");
                } else if (ordinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (ordinal == 2) {
                    sb.append("denied");
                } else if (ordinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.zze;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzjh zzc() {
        zzjh zzjh = (zzjh) this.zzf.get(zzjj.AD_USER_DATA);
        if (zzjh == null) {
            return zzjh.UNINITIALIZED;
        }
        return zzjh;
    }

    public final boolean zzd() {
        for (zzjh zzjh : this.zzf.values()) {
            if (zzjh != zzjh.UNINITIALIZED) {
                return true;
            }
        }
        return false;
    }

    public final String zze() {
        return this.zzc;
    }

    public final Bundle zzf() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.zzf.entrySet()) {
            String zzi = zzjk.zzi((zzjh) entry.getValue());
            if (zzi != null) {
                bundle.putString(((zzjj) entry.getKey()).zze, zzi);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            bundle.putString("is_dma_region", bool.toString());
        }
        String str = this.zze;
        if (str != null) {
            bundle.putString("cps_display_str", str);
        }
        return bundle;
    }

    public final Boolean zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zze;
    }

    private zzaz(EnumMap enumMap, int i, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.zzf = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzb = i;
        this.zzd = bool;
        this.zze = str;
    }
}
