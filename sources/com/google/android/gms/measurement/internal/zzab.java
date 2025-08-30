package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfr;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class zzab {
    final String zzb;
    final int zzc;
    Boolean zzd;
    Boolean zze;
    Long zzf;
    Long zzg;

    public zzab(String str, int i) {
        this.zzb = str;
        this.zzc = i;
    }

    private static Boolean zzd(String str, int i, boolean z, String str2, List list, String str3, zzgt zzgt) {
        int i2;
        if (i == 7) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i - 1) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                if (true != z) {
                    i2 = 66;
                } else {
                    i2 = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, i2).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzgt != null) {
                        zzgt.zze().zzb("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    @VisibleForTesting
    public static Boolean zze(Boolean bool, boolean z) {
        boolean z2;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    @VisibleForTesting
    public static Boolean zzf(String str, zzfr zzfr, zzgt zzgt) {
        String zzc2;
        List list;
        String str2;
        Preconditions.checkNotNull(zzfr);
        if (str == null || !zzfr.zza() || zzfr.zzj() == 1 || (zzfr.zzj() != 7 ? !zzfr.zzb() : zzfr.zzg() == 0)) {
            return null;
        }
        int zzj = zzfr.zzj();
        boolean zze2 = zzfr.zze();
        if (zze2 || zzj == 2 || zzj == 7) {
            zzc2 = zzfr.zzc();
        } else {
            zzc2 = zzfr.zzc().toUpperCase(Locale.ENGLISH);
        }
        String str3 = zzc2;
        if (zzfr.zzg() == 0) {
            list = null;
        } else {
            List<String> zzf2 = zzfr.zzf();
            if (!zze2) {
                ArrayList arrayList = new ArrayList(zzf2.size());
                for (String upperCase : zzf2) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzf2 = Collections.unmodifiableList(arrayList);
            }
            list = zzf2;
        }
        if (zzj == 2) {
            str2 = str3;
        } else {
            str2 = null;
        }
        return zzd(str, zzj, zze2, str3, list, str2, zzgt);
    }

    public static Boolean zzg(long j, zzfl zzfl) {
        try {
            return zzj(new BigDecimal(j), zzfl, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zzh(double d, zzfl zzfl) {
        try {
            return zzj(new BigDecimal(d), zzfl, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zzi(String str, zzfl zzfl) {
        if (!zzpj.zzm(str)) {
            return null;
        }
        try {
            return zzj(new BigDecimal(str), zzfl, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    public static Boolean zzj(BigDecimal bigDecimal, zzfl zzfl, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzfl);
        if (zzfl.zza()) {
            boolean z = true;
            if (zzfl.zzm() != 1) {
                if (zzfl.zzm() == 5) {
                    if (!zzfl.zzf() || !zzfl.zzh()) {
                        return null;
                    }
                } else if (!zzfl.zzd()) {
                    return null;
                }
                int zzm = zzfl.zzm();
                if (zzfl.zzm() == 5) {
                    if (zzpj.zzm(zzfl.zzg()) && zzpj.zzm(zzfl.zzi())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzfl.zzg());
                            bigDecimal3 = new BigDecimal(zzfl.zzi());
                            bigDecimal2 = bigDecimal5;
                            bigDecimal4 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                } else if (!zzpj.zzm(zzfl.zze())) {
                    return null;
                } else {
                    try {
                        bigDecimal4 = new BigDecimal(zzfl.zze());
                        bigDecimal2 = null;
                        bigDecimal3 = null;
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (zzm == 5) {
                    if (bigDecimal2 == null) {
                        return null;
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                }
                int i = zzm - 1;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4 || bigDecimal2 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal2) < 0 || bigDecimal.compareTo(bigDecimal3) > 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        } else if (bigDecimal4 == null) {
                            return null;
                        } else {
                            if (d != 0.0d) {
                                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d).multiply(new BigDecimal(2)))) >= 0) {
                                    z = false;
                                }
                                return Boolean.valueOf(z);
                            }
                            if (bigDecimal.compareTo(bigDecimal4) != 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                    } else if (bigDecimal4 == null) {
                        return null;
                    } else {
                        if (bigDecimal.compareTo(bigDecimal4) <= 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                } else if (bigDecimal4 == null) {
                    return null;
                } else {
                    if (bigDecimal.compareTo(bigDecimal4) >= 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            }
        }
        return null;
    }

    public abstract int zza();

    public abstract boolean zzb();

    public abstract boolean zzc();
}
