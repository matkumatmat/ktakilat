package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import bolts.MeasurementEvent;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhg;
import com.google.android.gms.internal.measurement.zzhl;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhq;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzis;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzlq;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.android.gms.internal.measurement.zznk;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.internal.measurement.zzqu;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.lang3.CharEncoding;
import org.apache.commons.lang3.StringUtils;

public final class zzpj extends zzor {
    public zzpj(zzpf zzpf) {
        super(zzpf);
    }

    public static final void zzC(zzhr zzhr, String str, Object obj) {
        List zza = zzhr.zza();
        int i = 0;
        while (true) {
            if (i >= zza.size()) {
                i = -1;
                break;
            } else if (str.equals(((zzhw) zza.get(i)).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzhv zzn = zzhw.zzn();
        zzn.zzb(str);
        zzn.zzf(((Long) obj).longValue());
        if (i >= 0) {
            zzhr.zze(i, zzn);
        } else {
            zzhr.zzg(zzn);
        }
    }

    @WorkerThread
    public static final boolean zzD(zzbg zzbg, zzr zzr) {
        Preconditions.checkNotNull(zzbg);
        Preconditions.checkNotNull(zzr);
        if (TextUtils.isEmpty(zzr.zzb)) {
            return false;
        }
        return true;
    }

    public static final Bundle zzE(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzhw zzhw = (zzhw) it.next();
            String zzb = zzhw.zzb();
            if (zzhw.zzi()) {
                bundle.putDouble(zzb, zzhw.zzj());
            } else if (zzhw.zzg()) {
                bundle.putFloat(zzb, zzhw.zzh());
            } else if (zzhw.zzc()) {
                bundle.putString(zzb, zzhw.zzd());
            } else if (zzhw.zze()) {
                bundle.putLong(zzb, zzhw.zzf());
            }
        }
        return bundle;
    }

    public static final zzhw zzF(zzhs zzhs, String str) {
        for (zzhw zzhw : zzhs.zza()) {
            if (zzhw.zzb().equals(str)) {
                return zzhw;
            }
        }
        return null;
    }

    public static final Map zzG(zzhs zzhs, String... strArr) {
        Object zzP;
        HashMap hashMap = new HashMap();
        for (zzhw zzhw : zzhs.zza()) {
            if (Arrays.asList(strArr).contains(zzhw.zzb()) && (zzP = zzP(zzhw)) != null) {
                hashMap.put(zzhw.zzb(), zzP);
            }
        }
        return hashMap;
    }

    public static final Map zzH(zzhs zzhs, String str) {
        Object zzP;
        HashMap hashMap = new HashMap();
        for (zzhw zzhw : zzhs.zza()) {
            if (zzhw.zzb().startsWith("gad_") && (zzP = zzP(zzhw)) != null) {
                hashMap.put(zzhw.zzb(), zzP);
            }
        }
        return hashMap;
    }

    public static final Object zzI(zzhs zzhs, String str) {
        zzhw zzF = zzF(zzhs, str);
        if (zzF == null) {
            return null;
        }
        return zzP(zzF);
    }

    public static final Object zzJ(zzhs zzhs, String str, Object obj) {
        Object zzI = zzI(zzhs, str);
        if (zzI == null) {
            return obj;
        }
        return zzI;
    }

    private final void zzK(StringBuilder sb, int i, List list) {
        String str;
        String str2;
        Long l;
        if (list != null) {
            int i2 = i + 1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzhw zzhw = (zzhw) it.next();
                if (zzhw != null) {
                    zzM(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    if (zzhw.zza()) {
                        str = this.zzu.zzl().zzb(zzhw.zzb());
                    } else {
                        str = null;
                    }
                    zzS(sb, i2, "name", str);
                    if (zzhw.zzc()) {
                        str2 = zzhw.zzd();
                    } else {
                        str2 = null;
                    }
                    zzS(sb, i2, "string_value", str2);
                    if (zzhw.zze()) {
                        l = Long.valueOf(zzhw.zzf());
                    } else {
                        l = null;
                    }
                    zzS(sb, i2, "int_value", l);
                    if (zzhw.zzi()) {
                        d = Double.valueOf(zzhw.zzj());
                    }
                    zzS(sb, i2, "double_value", d);
                    if (zzhw.zzm() > 0) {
                        zzK(sb, i2, zzhw.zzk());
                    }
                    zzM(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zzL(StringBuilder sb, int i, zzfh zzfh) {
        String str;
        if (zzfh != null) {
            zzM(sb, i);
            sb.append("filter {\n");
            if (zzfh.zze()) {
                zzS(sb, i, "complement", Boolean.valueOf(zzfh.zzf()));
            }
            if (zzfh.zzg()) {
                zzS(sb, i, "param_name", this.zzu.zzl().zzb(zzfh.zzh()));
            }
            if (zzfh.zza()) {
                int i2 = i + 1;
                zzfr zzb = zzfh.zzb();
                if (zzb != null) {
                    zzM(sb, i2);
                    sb.append("string_filter {\n");
                    if (zzb.zza()) {
                        switch (zzb.zzj()) {
                            case 1:
                                str = "UNKNOWN_MATCH_TYPE";
                                break;
                            case 2:
                                str = "REGEXP";
                                break;
                            case 3:
                                str = "BEGINS_WITH";
                                break;
                            case 4:
                                str = "ENDS_WITH";
                                break;
                            case 5:
                                str = "PARTIAL";
                                break;
                            case 6:
                                str = "EXACT";
                                break;
                            default:
                                str = "IN_LIST";
                                break;
                        }
                        zzS(sb, i2, "match_type", str);
                    }
                    if (zzb.zzb()) {
                        zzS(sb, i2, "expression", zzb.zzc());
                    }
                    if (zzb.zzd()) {
                        zzS(sb, i2, "case_sensitive", Boolean.valueOf(zzb.zze()));
                    }
                    if (zzb.zzg() > 0) {
                        zzM(sb, i + 2);
                        sb.append("expression_list {\n");
                        for (String append : zzb.zzf()) {
                            zzM(sb, i + 3);
                            sb.append(append);
                            sb.append(StringUtils.LF);
                        }
                        sb.append("}\n");
                    }
                    zzM(sb, i2);
                    sb.append("}\n");
                }
            }
            if (zzfh.zzc()) {
                zzT(sb, i + 1, "number_filter", zzfh.zzd());
            }
            zzM(sb, i);
            sb.append("}\n");
        }
    }

    private static final void zzM(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static final void zzN(Uri.Builder builder, String str, String str2, Set set) {
        if (!set.contains(str) && !TextUtils.isEmpty(str2)) {
            builder.appendQueryParameter(str, str2);
        }
    }

    private static final String zzO(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final Object zzP(zzhw zzhw) {
        if (zzhw.zzc()) {
            return zzhw.zzd();
        }
        if (zzhw.zze()) {
            return Long.valueOf(zzhw.zzf());
        }
        if (zzhw.zzi()) {
            return Double.valueOf(zzhw.zzj());
        }
        if (zzhw.zzm() > 0) {
            return zzy(zzhw.zzk());
        }
        return null;
    }

    private static final void zzQ(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String split : strArr) {
            String[] split2 = split.split(",");
            String str = split2[0];
            String str2 = split2[split2.length - 1];
            String string = bundle.getString(str);
            if (string != null) {
                zzN(builder, str2, string, set);
            }
        }
    }

    private static final void zzR(StringBuilder sb, int i, String str, zzii zzii) {
        Integer num;
        Integer num2;
        Long l;
        if (zzii != null) {
            zzM(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzii.zzd() != 0) {
                zzM(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l2 : zzii.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (zzii.zzb() != 0) {
                zzM(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l3 : zzii.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l3);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzii.zzf() != 0) {
                zzM(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzhq zzhq : zzii.zze()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    if (zzhq.zza()) {
                        num2 = Integer.valueOf(zzhq.zzb());
                    } else {
                        num2 = null;
                    }
                    sb.append(num2);
                    sb.append(":");
                    if (zzhq.zzc()) {
                        l = Long.valueOf(zzhq.zzd());
                    } else {
                        l = null;
                    }
                    sb.append(l);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zzii.zzh() != 0) {
                zzM(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzik zzik : zzii.zzg()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    if (zzik.zza()) {
                        num = Integer.valueOf(zzik.zzb());
                    } else {
                        num = null;
                    }
                    sb.append(num);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : zzik.zzc()) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            zzM(sb, 3);
            sb.append("}\n");
        }
    }

    private static final void zzS(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zzM(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static final void zzT(StringBuilder sb, int i, String str, zzfl zzfl) {
        String str2;
        if (zzfl != null) {
            zzM(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzfl.zza()) {
                int zzm = zzfl.zzm();
                if (zzm == 1) {
                    str2 = "UNKNOWN_COMPARISON_TYPE";
                } else if (zzm == 2) {
                    str2 = "LESS_THAN";
                } else if (zzm == 3) {
                    str2 = "GREATER_THAN";
                } else if (zzm != 4) {
                    str2 = "BETWEEN";
                } else {
                    str2 = "EQUAL";
                }
                zzS(sb, i, "comparison_type", str2);
            }
            if (zzfl.zzb()) {
                zzS(sb, i, "match_as_float", Boolean.valueOf(zzfl.zzc()));
            }
            if (zzfl.zzd()) {
                zzS(sb, i, "comparison_value", zzfl.zze());
            }
            if (zzfl.zzf()) {
                zzS(sb, i, "min_comparison_value", zzfl.zzg());
            }
            if (zzfl.zzh()) {
                zzS(sb, i, "max_comparison_value", zzfl.zzi());
            }
            zzM(sb, i);
            sb.append("}\n");
        }
    }

    public static boolean zzm(String str) {
        if (str == null || !str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") || str.length() > 310) {
            return false;
        }
        return true;
    }

    public static boolean zzn(List list, int i) {
        if (i >= list.size() * 64) {
            return false;
        }
        if (((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0) {
            return true;
        }
        return false;
    }

    public static List zzp(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static zznk zzw(zznk zznk, byte[] bArr) throws zzmq {
        zzlq zza = zzlq.zza();
        if (zza != null) {
            return zznk.zzaV(bArr, zza);
        }
        return zznk.zzaW(bArr);
    }

    public static int zzx(zzic zzic, String str) {
        for (int i = 0; i < zzic.zzl(); i++) {
            if (str.equals(zzic.zzm(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    public static Bundle[] zzy(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzhw zzhw = (zzhw) it.next();
            if (zzhw != null) {
                Bundle bundle = new Bundle();
                for (zzhw zzhw2 : zzhw.zzk()) {
                    if (zzhw2.zzc()) {
                        bundle.putString(zzhw2.zzb(), zzhw2.zzd());
                    } else if (zzhw2.zze()) {
                        bundle.putLong(zzhw2.zzb(), zzhw2.zzf());
                    } else if (zzhw2.zzi()) {
                        bundle.putDouble(zzhw2.zzb(), zzhw2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final zzbg zzA(zzaa zzaa) {
        String str;
        Object obj;
        Bundle zzB = zzB(zzaa.zzf(), true);
        if (!zzB.containsKey("_o") || (obj = zzB.get("_o")) == null) {
            str = "app";
        } else {
            str = obj.toString();
        }
        String str2 = str;
        String zzb = zzjl.zzb(zzaa.zzb());
        if (zzb == null) {
            zzb = zzaa.zzb();
        }
        return new zzbg(zzb, new zzbe(zzB), str2, zzaa.zza());
    }

    public final Bundle zzB(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, (String) null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(zzB((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public final boolean zzbb() {
        return false;
    }

    public final void zzc(zzit zzit, Object obj) {
        Preconditions.checkNotNull(obj);
        zzit.zzd();
        zzit.zzf();
        zzit.zzh();
        if (obj instanceof String) {
            zzit.zzc((String) obj);
        } else if (obj instanceof Long) {
            zzit.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzit.zzg(((Double) obj).doubleValue());
        } else {
            this.zzu.zzaV().zzb().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zzd(zzhv zzhv, Object obj) {
        Preconditions.checkNotNull(obj);
        zzhv.zze();
        zzhv.zzg();
        zzhv.zzi();
        zzhv.zzm();
        if (obj instanceof String) {
            zzhv.zzd((String) obj);
        } else if (obj instanceof Long) {
            zzhv.zzf(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzhv.zzh(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzhv zzn = zzhw.zzn();
                    for (String next : bundle.keySet()) {
                        zzhv zzn2 = zzhw.zzn();
                        zzn2.zzb(next);
                        Object obj2 = bundle.get(next);
                        if (obj2 instanceof Long) {
                            zzn2.zzf(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zzn2.zzd((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zzn2.zzh(((Double) obj2).doubleValue());
                        }
                        zzn.zzk(zzn2);
                    }
                    if (zzn.zzj() > 0) {
                        arrayList.add((zzhw) zzn.zzbc());
                    }
                }
            }
            zzhv.zzl(arrayList);
        } else {
            this.zzu.zzaV().zzb().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    @TargetApi(30)
    public final zzog zzf(String str, zzic zzic, zzhr zzhr, String str2) {
        int indexOf;
        String str3 = str;
        zzql.zza();
        zzib zzib = this.zzu;
        if (!zzib.zzc().zzp(str3, zzfx.zzaP)) {
            return null;
        }
        long currentTimeMillis = zzib.zzaZ().currentTimeMillis();
        String[] split = zzib.zzc().zzk(str3, zzfx.zzau).split(",");
        HashSet hashSet = new HashSet(split.length);
        int length = split.length;
        int i = 0;
        while (i < length) {
            String str4 = split[i];
            Objects.requireNonNull(str4);
            if (hashSet.add(str4)) {
                i++;
            } else {
                throw new IllegalArgumentException("duplicate element: " + str4);
            }
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        zzpf zzpf = this.zzg;
        zzot zzf = zzpf.zzf();
        String zzc = zzf.zzg.zzh().zzc(str3);
        Uri.Builder builder = new Uri.Builder();
        zzib zzib2 = zzf.zzu;
        builder.scheme(zzib2.zzc().zzk(str3, zzfx.zzan));
        if (!TextUtils.isEmpty(zzc)) {
            String zzk = zzib2.zzc().zzk(str3, zzfx.zzao);
            StringBuilder sb = new StringBuilder(ba.e(1, zzc) + String.valueOf(zzk).length());
            sb.append(zzc);
            sb.append(".");
            sb.append(zzk);
            builder.authority(sb.toString());
        } else {
            builder.authority(zzib2.zzc().zzk(str3, zzfx.zzao));
        }
        builder.path(zzib2.zzc().zzk(str3, zzfx.zzap));
        zzN(builder, "gmp_app_id", zzic.zzac(), unmodifiableSet);
        zzib.zzc().zzi();
        zzN(builder, "gmp_version", String.valueOf(130000), unmodifiableSet);
        String zzV = zzic.zzV();
        zzal zzc2 = zzib.zzc();
        zzfw zzfw = zzfx.zzaS;
        if (zzc2.zzp(str3, zzfw) && zzpf.zzh().zzt(str3)) {
            zzV = "";
        }
        zzN(builder, "app_instance_id", zzV, unmodifiableSet);
        zzN(builder, "rdid", zzic.zzP(), unmodifiableSet);
        zzN(builder, "bundle_id", zzic.zzK(), unmodifiableSet);
        String zzk2 = zzhr.zzk();
        String zza = zzjl.zza(zzk2);
        if (true != TextUtils.isEmpty(zza)) {
            zzk2 = zza;
        }
        zzN(builder, "app_event_name", zzk2, unmodifiableSet);
        zzN(builder, "app_version", String.valueOf(zzic.zzai()), unmodifiableSet);
        String zzD = zzic.zzD();
        if (zzib.zzc().zzp(str3, zzfw) && zzpf.zzh().zzq(str3) && !TextUtils.isEmpty(zzD) && (indexOf = zzD.indexOf(".")) != -1) {
            zzD = zzD.substring(0, indexOf);
        }
        zzN(builder, "os_version", zzD, unmodifiableSet);
        zzN(builder, "timestamp", String.valueOf(zzhr.zzn()), unmodifiableSet);
        boolean zzS = zzic.zzS();
        String str5 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        if (zzS) {
            zzN(builder, "lat", str5, unmodifiableSet);
        }
        zzN(builder, "privacy_sandbox_version", String.valueOf(zzic.zzaG()), unmodifiableSet);
        zzN(builder, "trigger_uri_source", str5, unmodifiableSet);
        zzN(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), unmodifiableSet);
        zzN(builder, "request_uuid", str2, unmodifiableSet);
        List<zzhw> zza2 = zzhr.zza();
        Bundle bundle = new Bundle();
        for (zzhw zzhw : zza2) {
            String zzb = zzhw.zzb();
            if (zzhw.zzi()) {
                bundle.putString(zzb, String.valueOf(zzhw.zzj()));
            } else if (zzhw.zzg()) {
                bundle.putString(zzb, String.valueOf(zzhw.zzh()));
            } else if (zzhw.zzc()) {
                bundle.putString(zzb, zzhw.zzd());
            } else if (zzhw.zze()) {
                bundle.putString(zzb, String.valueOf(zzhw.zzf()));
            }
        }
        zzQ(builder, zzib.zzc().zzk(str3, zzfx.zzat).split("\\|"), bundle, unmodifiableSet);
        List<zziu> zzk3 = zzic.zzk();
        Bundle bundle2 = new Bundle();
        for (zziu zziu : zzk3) {
            String zzc3 = zziu.zzc();
            if (zziu.zzj()) {
                bundle2.putString(zzc3, String.valueOf(zziu.zzk()));
            } else if (zziu.zzh()) {
                bundle2.putString(zzc3, String.valueOf(zziu.zzi()));
            } else if (zziu.zzd()) {
                bundle2.putString(zzc3, zziu.zze());
            } else if (zziu.zzf()) {
                bundle2.putString(zzc3, String.valueOf(zziu.zzg()));
            }
        }
        zzQ(builder, zzib.zzc().zzk(str3, zzfx.zzas).split("\\|"), bundle2, unmodifiableSet);
        if (true != zzic.zzaC()) {
            str5 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        zzN(builder, "dma", str5, unmodifiableSet);
        if (!zzic.zzaE().isEmpty()) {
            zzN(builder, "dma_cps", zzic.zzaE(), unmodifiableSet);
        }
        if (zzic.zzaK()) {
            zzha zzaL = zzic.zzaL();
            if (!zzaL.zzb().isEmpty()) {
                zzN(builder, "dl_gclid", zzaL.zzb(), unmodifiableSet);
            }
            if (!zzaL.zzd().isEmpty()) {
                zzN(builder, "dl_gbraid", zzaL.zzd(), unmodifiableSet);
            }
            if (!zzaL.zzf().isEmpty()) {
                zzN(builder, "dl_gs", zzaL.zzf(), unmodifiableSet);
            }
            if (zzaL.zzh() > 0) {
                zzN(builder, "dl_ss_ts", String.valueOf(zzaL.zzh()), unmodifiableSet);
            }
            if (!zzaL.zzj().isEmpty()) {
                zzN(builder, "mr_gclid", zzaL.zzj(), unmodifiableSet);
            }
            if (!zzaL.zzm().isEmpty()) {
                zzN(builder, "mr_gbraid", zzaL.zzm(), unmodifiableSet);
            }
            if (!zzaL.zzo().isEmpty()) {
                zzN(builder, "mr_gs", zzaL.zzo(), unmodifiableSet);
            }
            if (zzaL.zzq() > 0) {
                zzN(builder, "mr_click_ts", String.valueOf(zzaL.zzq()), unmodifiableSet);
            }
        }
        return new zzog(builder.build().toString(), currentTimeMillis, 1);
    }

    public final zzhs zzh(zzbb zzbb) {
        zzhr zzk = zzhs.zzk();
        zzk.zzq(zzbb.zze);
        zzbe zzbe = zzbb.zzf;
        zzbd zzbd = new zzbd(zzbe);
        while (zzbd.hasNext()) {
            String zza = zzbd.next();
            zzhv zzn = zzhw.zzn();
            zzn.zzb(zza);
            Object zza2 = zzbe.zza(zza);
            Preconditions.checkNotNull(zza2);
            zzd(zzn, zza2);
            zzk.zzg(zzn);
        }
        String str = zzbb.zzc;
        if (!TextUtils.isEmpty(str) && zzbe.zza("_o") == null) {
            zzhv zzn2 = zzhw.zzn();
            zzn2.zzb("_o");
            zzn2.zzd(str);
            zzk.zzf((zzhw) zzn2.zzbc());
        }
        return (zzhs) zzk.zzbc();
    }

    public final String zzi(zzib zzib) {
        Long l;
        Long l2;
        String str;
        String str2;
        String str3;
        String str4;
        zzhe zzat;
        if (zzib == null) {
            return "";
        }
        StringBuilder v = ba.v("\nbatch {\n");
        if (zzib.zzf()) {
            zzS(v, 0, "upload_subdomain", zzib.zzg());
        }
        if (zzib.zzd()) {
            zzS(v, 0, "sgtm_join_id", zzib.zze());
        }
        for (zzid zzid : zzib.zza()) {
            if (zzid != null) {
                zzM(v, 1);
                v.append("bundle {\n");
                if (zzid.zza()) {
                    zzS(v, 1, "protocol_version", Integer.valueOf(zzid.zzb()));
                }
                zzqu.zza();
                zzib zzib2 = this.zzu;
                if (zzib2.zzc().zzp(zzid.zzA(), zzfx.zzaM) && zzid.zzag()) {
                    zzS(v, 1, "session_stitching_token", zzid.zzah());
                }
                zzS(v, 1, "platform", zzid.zzt());
                if (zzid.zzC()) {
                    zzS(v, 1, "gmp_version", Long.valueOf(zzid.zzD()));
                }
                if (zzid.zzE()) {
                    zzS(v, 1, "uploading_gmp_version", Long.valueOf(zzid.zzF()));
                }
                if (zzid.zzac()) {
                    zzS(v, 1, "dynamite_version", Long.valueOf(zzid.zzad()));
                }
                if (zzid.zzW()) {
                    zzS(v, 1, "config_version", Long.valueOf(zzid.zzX()));
                }
                zzS(v, 1, "gmp_app_id", zzid.zzP());
                zzS(v, 1, "app_id", zzid.zzA());
                zzS(v, 1, "app_version", zzid.zzB());
                if (zzid.zzU()) {
                    zzS(v, 1, "app_version_major", Integer.valueOf(zzid.zzV()));
                }
                zzS(v, 1, "firebase_instance_id", zzid.zzT());
                if (zzid.zzK()) {
                    zzS(v, 1, "dev_cert_hash", Long.valueOf(zzid.zzL()));
                }
                zzS(v, 1, "app_store", zzid.zzz());
                if (zzid.zzi()) {
                    zzS(v, 1, "upload_timestamp_millis", Long.valueOf(zzid.zzj()));
                }
                if (zzid.zzk()) {
                    zzS(v, 1, "start_timestamp_millis", Long.valueOf(zzid.zzm()));
                }
                if (zzid.zzn()) {
                    zzS(v, 1, "end_timestamp_millis", Long.valueOf(zzid.zzo()));
                }
                if (zzid.zzp()) {
                    zzS(v, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzid.zzq()));
                }
                if (zzid.zzr()) {
                    zzS(v, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzid.zzs()));
                }
                zzS(v, 1, "app_instance_id", zzid.zzJ());
                zzS(v, 1, "resettable_device_id", zzid.zzG());
                zzS(v, 1, "ds_id", zzid.zzZ());
                if (zzid.zzH()) {
                    zzS(v, 1, "limited_ad_tracking", Boolean.valueOf(zzid.zzI()));
                }
                zzS(v, 1, "os_version", zzid.zzu());
                zzS(v, 1, "device_model", zzid.zzv());
                zzS(v, 1, "user_default_language", zzid.zzw());
                if (zzid.zzx()) {
                    zzS(v, 1, "time_zone_offset_minutes", Integer.valueOf(zzid.zzy()));
                }
                if (zzid.zzM()) {
                    zzS(v, 1, "bundle_sequential_index", Integer.valueOf(zzid.zzN()));
                }
                if (zzid.zzau()) {
                    zzS(v, 1, "delivery_index", Integer.valueOf(zzid.zzav()));
                }
                if (zzid.zzQ()) {
                    zzS(v, 1, "service_upload", Boolean.valueOf(zzid.zzR()));
                }
                zzS(v, 1, "health_monitor", zzid.zzO());
                if (zzid.zzaa()) {
                    zzS(v, 1, "retry_counter", Integer.valueOf(zzid.zzab()));
                }
                if (zzid.zzae()) {
                    zzS(v, 1, "consent_signals", zzid.zzaf());
                }
                if (zzid.zzan()) {
                    zzS(v, 1, "is_dma_region", Boolean.valueOf(zzid.zzao()));
                }
                if (zzid.zzap()) {
                    zzS(v, 1, "core_platform_services", zzid.zzaq());
                }
                if (zzid.zzal()) {
                    zzS(v, 1, "consent_diagnostics", zzid.zzam());
                }
                if (zzid.zzai()) {
                    zzS(v, 1, "target_os_version", Long.valueOf(zzid.zzaj()));
                }
                zzql.zza();
                if (zzib2.zzc().zzp(zzid.zzA(), zzfx.zzaP)) {
                    zzS(v, 1, "ad_services_version", Integer.valueOf(zzid.zzar()));
                    if (zzid.zzas() && (zzat = zzid.zzat()) != null) {
                        zzM(v, 2);
                        v.append("attribution_eligibility_status {\n");
                        zzS(v, 2, "eligible", Boolean.valueOf(zzat.zza()));
                        zzS(v, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzat.zzb()));
                        zzS(v, 2, "pre_r", Boolean.valueOf(zzat.zzc()));
                        zzS(v, 2, "r_extensions_too_old", Boolean.valueOf(zzat.zzd()));
                        zzS(v, 2, "adservices_extension_too_old", Boolean.valueOf(zzat.zze()));
                        zzS(v, 2, "ad_storage_not_allowed", Boolean.valueOf(zzat.zzf()));
                        zzS(v, 2, "measurement_manager_disabled", Boolean.valueOf(zzat.zzg()));
                        zzM(v, 2);
                        v.append("}\n");
                    }
                }
                if (zzid.zzaw()) {
                    zzha zzax = zzid.zzax();
                    zzM(v, 2);
                    v.append("ad_campaign_info {\n");
                    if (zzax.zza()) {
                        zzS(v, 2, "deep_link_gclid", zzax.zzb());
                    }
                    if (zzax.zzc()) {
                        zzS(v, 2, "deep_link_gbraid", zzax.zzd());
                    }
                    if (zzax.zze()) {
                        zzS(v, 2, "deep_link_gad_source", zzax.zzf());
                    }
                    if (zzax.zzg()) {
                        zzS(v, 2, "deep_link_session_millis", Long.valueOf(zzax.zzh()));
                    }
                    if (zzax.zzi()) {
                        zzS(v, 2, "market_referrer_gclid", zzax.zzj());
                    }
                    if (zzax.zzk()) {
                        zzS(v, 2, "market_referrer_gbraid", zzax.zzm());
                    }
                    if (zzax.zzn()) {
                        zzS(v, 2, "market_referrer_gad_source", zzax.zzo());
                    }
                    if (zzax.zzp()) {
                        zzS(v, 2, "market_referrer_click_millis", Long.valueOf(zzax.zzq()));
                    }
                    zzM(v, 2);
                    v.append("}\n");
                }
                if (zzid.zzaA()) {
                    zzS(v, 1, "batching_timestamp_millis", Long.valueOf(zzid.zzaB()));
                }
                if (zzid.zzay()) {
                    zzis zzaz = zzid.zzaz();
                    zzM(v, 2);
                    v.append("sgtm_diagnostics {\n");
                    int zzf = zzaz.zzf();
                    if (zzf == 1) {
                        str3 = "UPLOAD_TYPE_UNKNOWN";
                    } else if (zzf == 2) {
                        str3 = "GA_UPLOAD";
                    } else if (zzf == 3) {
                        str3 = "SDK_CLIENT_UPLOAD";
                    } else if (zzf != 4) {
                        str3 = "SDK_SERVICE_UPLOAD";
                    } else {
                        str3 = "PACKAGE_SERVICE_UPLOAD";
                    }
                    zzS(v, 2, "upload_type", str3);
                    zzS(v, 2, "client_upload_eligibility", zzaz.zza().name());
                    int zzg = zzaz.zzg();
                    if (zzg == 1) {
                        str4 = "SERVICE_UPLOAD_ELIGIBILITY_UNKNOWN";
                    } else if (zzg == 2) {
                        str4 = "SERVICE_UPLOAD_ELIGIBLE";
                    } else if (zzg == 3) {
                        str4 = "NOT_IN_ROLLOUT";
                    } else if (zzg == 4) {
                        str4 = "MISSING_SGTM_SETTINGS";
                    } else if (zzg != 5) {
                        str4 = "NON_PLAY_MISSING_SGTM_SERVER_URL";
                    } else {
                        str4 = "MISSING_SGTM_PROXY_INFO";
                    }
                    zzS(v, 2, "service_upload_eligibility", str4);
                    zzM(v, 2);
                    v.append("}\n");
                }
                if (zzid.zzaC()) {
                    zzho zzaD = zzid.zzaD();
                    zzM(v, 2);
                    v.append("consent_info_extra {\n");
                    for (zzhl zzhl : zzaD.zza()) {
                        zzM(v, 3);
                        v.append("limited_data_modes {\n");
                        int zzc = zzhl.zzc();
                        if (zzc == 1) {
                            str = "CONSENT_TYPE_UNSPECIFIED";
                        } else if (zzc == 2) {
                            str = "AD_STORAGE";
                        } else if (zzc == 3) {
                            str = "ANALYTICS_STORAGE";
                        } else if (zzc != 4) {
                            str = "AD_PERSONALIZATION";
                        } else {
                            str = "AD_USER_DATA";
                        }
                        zzS(v, 3, "type", str);
                        int zzd = zzhl.zzd();
                        if (zzd == 1) {
                            str2 = "NOT_LIMITED";
                        } else if (zzd != 2) {
                            str2 = "NO_DATA_MODE";
                        } else {
                            str2 = "LIMITED_MODE";
                        }
                        zzS(v, 3, "mode", str2);
                        zzM(v, 3);
                        v.append("}\n");
                    }
                    zzM(v, 2);
                    v.append("}\n");
                }
                List<zziu> zzf2 = zzid.zzf();
                if (zzf2 != null) {
                    for (zziu zziu : zzf2) {
                        if (zziu != null) {
                            zzM(v, 2);
                            v.append("user_property {\n");
                            Double d = null;
                            if (zziu.zza()) {
                                l = Long.valueOf(zziu.zzb());
                            } else {
                                l = null;
                            }
                            zzS(v, 2, "set_timestamp_millis", l);
                            zzS(v, 2, "name", zzib2.zzl().zzc(zziu.zzc()));
                            zzS(v, 2, "string_value", zziu.zze());
                            if (zziu.zzf()) {
                                l2 = Long.valueOf(zziu.zzg());
                            } else {
                                l2 = null;
                            }
                            zzS(v, 2, "int_value", l2);
                            if (zziu.zzj()) {
                                d = Double.valueOf(zziu.zzk());
                            }
                            zzS(v, 2, "double_value", d);
                            zzM(v, 2);
                            v.append("}\n");
                        }
                    }
                }
                List<zzhg> zzS = zzid.zzS();
                if (zzS != null) {
                    for (zzhg zzhg : zzS) {
                        if (zzhg != null) {
                            zzM(v, 2);
                            v.append("audience_membership {\n");
                            if (zzhg.zza()) {
                                zzS(v, 2, "audience_id", Integer.valueOf(zzhg.zzb()));
                            }
                            if (zzhg.zzf()) {
                                zzS(v, 2, "new_audience", Boolean.valueOf(zzhg.zzg()));
                            }
                            zzR(v, 2, "current_data", zzhg.zzc());
                            if (zzhg.zzd()) {
                                zzR(v, 2, "previous_data", zzhg.zze());
                            }
                            zzM(v, 2);
                            v.append("}\n");
                        }
                    }
                }
                List<zzhs> zzc2 = zzid.zzc();
                if (zzc2 != null) {
                    for (zzhs zzhs : zzc2) {
                        if (zzhs != null) {
                            zzM(v, 2);
                            v.append("event {\n");
                            zzS(v, 2, "name", zzib2.zzl().zza(zzhs.zzd()));
                            if (zzhs.zze()) {
                                zzS(v, 2, "timestamp_millis", Long.valueOf(zzhs.zzf()));
                            }
                            if (zzhs.zzg()) {
                                zzS(v, 2, "previous_timestamp_millis", Long.valueOf(zzhs.zzh()));
                            }
                            if (zzhs.zzi()) {
                                zzS(v, 2, "count", Integer.valueOf(zzhs.zzj()));
                            }
                            if (zzhs.zzb() != 0) {
                                zzK(v, 2, zzhs.zza());
                            }
                            zzM(v, 2);
                            v.append("}\n");
                        }
                    }
                }
                zzM(v, 1);
                v.append("}\n");
            }
        }
        v.append("} // End-of-batch\n");
        return v.toString();
    }

    public final String zzj(zzff zzff) {
        if (zzff == null) {
            return "null";
        }
        StringBuilder v = ba.v("\nevent_filter {\n");
        if (zzff.zza()) {
            zzS(v, 0, "filter_id", Integer.valueOf(zzff.zzb()));
        }
        zzS(v, 0, MeasurementEvent.MEASUREMENT_EVENT_NAME_KEY, this.zzu.zzl().zza(zzff.zzc()));
        String zzO = zzO(zzff.zzi(), zzff.zzj(), zzff.zzm());
        if (!zzO.isEmpty()) {
            zzS(v, 0, "filter_type", zzO);
        }
        if (zzff.zzg()) {
            zzT(v, 1, "event_count_filter", zzff.zzh());
        }
        if (zzff.zze() > 0) {
            v.append("  filters {\n");
            for (zzfh zzL : zzff.zzd()) {
                zzL(v, 2, zzL);
            }
        }
        zzM(v, 1);
        v.append("}\n}\n");
        return v.toString();
    }

    public final String zzk(zzfn zzfn) {
        if (zzfn == null) {
            return "null";
        }
        StringBuilder v = ba.v("\nproperty_filter {\n");
        if (zzfn.zza()) {
            zzS(v, 0, "filter_id", Integer.valueOf(zzfn.zzb()));
        }
        zzS(v, 0, "property_name", this.zzu.zzl().zzc(zzfn.zzc()));
        String zzO = zzO(zzfn.zze(), zzfn.zzf(), zzfn.zzh());
        if (!zzO.isEmpty()) {
            zzS(v, 0, "filter_type", zzO);
        }
        zzL(v, 1, zzfn.zzd());
        v.append("}\n");
        return v.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0018, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r4.zzu.zzaV().zzb().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable zzl(byte[] r5, android.os.Parcelable.Creator r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001a }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001a }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001a }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001a }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001a }
            r0 = r5
            goto L_0x0029
        L_0x0018:
            r5 = move-exception
            goto L_0x002d
        L_0x001a:
            com.google.android.gms.measurement.internal.zzib r5 = r4.zzu     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ all -> 0x0018 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ all -> 0x0018 }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x0018 }
        L_0x0029:
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpj.zzl(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    public final List zzq(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzu.zzaV().zze().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzu.zzaV().zze().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    public final boolean zzs(long j, long j2) {
        if (j == 0 || j2 <= 0 || Math.abs(this.zzu.zzaZ().currentTimeMillis() - j) > j2) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final long zzt(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzib zzib = this.zzu;
        zzib.zzk().zzg();
        MessageDigest zzO = zzpo.zzO();
        if (zzO != null) {
            return zzpo.zzP(zzO.digest(bArr));
        }
        e.w(zzib, "Failed to get MD5");
        return 0;
    }

    public final long zzu(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return zzt(str.getBytes(Charset.forName(CharEncoding.UTF_8)));
    }

    public final byte[] zzv(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            this.zzu.zzaV().zzb().zzb("Failed to gzip content", e);
            throw e;
        }
    }

    public final Map zzz(Bundle bundle, boolean z) {
        HashMap hashMap = new HashMap();
        for (String next : bundle.keySet()) {
            Object obj = bundle.get(next);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zzz((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = arrayList2.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zzz((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zzz((Bundle) obj, false));
                    }
                    hashMap.put(next, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }
}
