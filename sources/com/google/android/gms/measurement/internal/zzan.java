package com.google.android.gms.measurement.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.EnumMap;

final class zzan {
    private final EnumMap zza;

    public zzan() {
        this.zza = new EnumMap(zzjj.class);
    }

    public static zzan zzd(String str) {
        EnumMap enumMap = new EnumMap(zzjj.class);
        if (str.length() >= zzjj.values().length) {
            int i = 0;
            if (str.charAt(0) == '1') {
                zzjj[] values = zzjj.values();
                int length = values.length;
                int i2 = 1;
                while (i < length) {
                    enumMap.put(values[i], zzam.zza(str.charAt(i2)));
                    i++;
                    i2++;
                }
                return new zzan(enumMap);
            }
        }
        return new zzan();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        for (zzjj zzjj : zzjj.values()) {
            zzam zzam = (zzam) this.zza.get(zzjj);
            if (zzam == null) {
                zzam = zzam.UNSET;
            }
            sb.append(zzam.zzb());
        }
        return sb.toString();
    }

    public final zzam zza(zzjj zzjj) {
        zzam zzam = (zzam) this.zza.get(zzjj);
        if (zzam == null) {
            return zzam.UNSET;
        }
        return zzam;
    }

    public final void zzb(zzjj zzjj, int i) {
        zzam zzam = zzam.UNSET;
        if (i != -30) {
            if (i != -20) {
                if (i == -10) {
                    zzam = zzam.MANIFEST;
                } else if (i != 0) {
                    if (i == 30) {
                        zzam = zzam.INITIALIZATION;
                    }
                }
            }
            zzam = zzam.API;
        } else {
            zzam = zzam.TCF;
        }
        this.zza.put(zzjj, zzam);
    }

    public final void zzc(zzjj zzjj, zzam zzam) {
        this.zza.put(zzjj, zzam);
    }

    private zzan(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzjj.class);
        this.zza = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
