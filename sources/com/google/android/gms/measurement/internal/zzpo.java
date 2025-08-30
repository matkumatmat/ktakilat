package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzpo extends zzje {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"firebase_", "google_", "ga_"};
    private static final String[] zzc = {"_err"};
    private SecureRandom zzd;
    private final AtomicLong zze = new AtomicLong(0);
    private int zzf;
    private MeasurementManagerFutures zzg;
    private Boolean zzh;
    private Integer zzi = null;

    public zzpo(zzib zzib) {
        super(zzib);
    }

    public static MessageDigest zzO() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    @VisibleForTesting
    public static long zzP(byte[] bArr) {
        boolean z;
        Preconditions.checkNotNull(bArr);
        int length = bArr.length;
        int i = 0;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        int i2 = length - 1;
        long j = 0;
        while (i2 >= 0 && i2 >= bArr.length - 8) {
            j += (((long) bArr[i2]) & 255) << i;
            i += 8;
            i2--;
        }
        return j;
    }

    public static boolean zzQ(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzR(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzR(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public static boolean zzR(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static boolean zzZ(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("_")) {
            return false;
        }
        return true;
    }

    private static boolean zzaA(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String equals : strArr) {
            if (Objects.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zzaf(String str) {
        if (zzc[0].equals(str)) {
            return false;
        }
        return true;
    }

    public static ArrayList zzas(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzah zzah = (zzah) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzah.zza);
            bundle.putString("origin", zzah.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzah.zzd);
            bundle.putString("name", zzah.zzc.zzb);
            zzjg.zza(bundle, Preconditions.checkNotNull(zzah.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzah.zze);
            String str = zzah.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzbg zzbg = zzah.zzg;
            if (zzbg != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbg.zza);
                zzbe zzbe = zzbg.zzb;
                if (zzbe != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbe.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzah.zzh);
            zzbg zzbg2 = zzah.zzi;
            if (zzbg2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbg2.zza);
                zzbe zzbe2 = zzbg2.zzb;
                if (zzbe2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbe2.zzf());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzah.zzc.zzc);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzah.zzj);
            zzbg zzbg3 = zzah.zzk;
            if (zzbg3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbg3.zza);
                zzbe zzbe3 = zzbg3.zzb;
                if (zzbe3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbe3.zzf());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean zzau(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @WorkerThread
    public static void zzav(zzlt zzlt, Bundle bundle, boolean z) {
        if (!(bundle == null || zzlt == null)) {
            if (!bundle.containsKey("_sc") || z) {
                String str = zzlt.zza;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = zzlt.zzb;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", zzlt.zzc);
                return;
            }
            z = false;
        }
        if (bundle != null && zzlt == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static final boolean zzax(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    private final Object zzay(int i, Object obj, boolean z, boolean z2, String str) {
        long j;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            if (true != ((Boolean) obj).booleanValue()) {
                j = 0;
            } else {
                j = 1;
            }
            return Long.valueOf(j);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zzC(obj.toString(), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle zzab = zzab((Bundle) parcelable, (String) null);
                    if (!zzab.isEmpty()) {
                        arrayList.add(zzab);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    private final int zzaz(String str) {
        if ("_ldl".equals(str)) {
            this.zzu.zzc();
            return 2048;
        } else if ("_id".equals(str)) {
            this.zzu.zzc();
            return 256;
        } else if ("_lgclid".equals(str)) {
            this.zzu.zzc();
            return 100;
        } else {
            this.zzu.zzc();
            return 36;
        }
    }

    public static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    public final boolean zzA(String str) {
        if (!TextUtils.isEmpty(str)) {
            Preconditions.checkNotNull(str);
            if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
                return true;
            }
            this.zzu.zzaV().zzd().zzb("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgt.zzl(str));
            return false;
        }
        this.zzu.zzaV().zzd().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        return false;
    }

    public final boolean zzB(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final String zzC(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d5  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzD(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.Object r17, android.os.Bundle r18, java.util.List r19, boolean r20, boolean r21) {
        /*
            r13 = this;
            r7 = r13
            r8 = r16
            r0 = r17
            r1 = r18
            r13.zzg()
            boolean r2 = r13.zzt(r0)
            java.lang.String r3 = "param"
            r4 = 0
            if (r2 == 0) goto L_0x00a6
            if (r21 == 0) goto L_0x00a8
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzjm.zzc
            boolean r2 = zzaA(r8, r2)
            if (r2 != 0) goto L_0x0020
            r0 = 20
            return r0
        L_0x0020:
            com.google.android.gms.measurement.internal.zzib r2 = r7.zzu
            com.google.android.gms.measurement.internal.zznk r2 = r2.zzt()
            r2.zzg()
            r2.zzb()
            boolean r5 = r2.zzK()
            if (r5 != 0) goto L_0x0033
            goto L_0x0045
        L_0x0033:
            com.google.android.gms.measurement.internal.zzib r2 = r2.zzu
            com.google.android.gms.measurement.internal.zzpo r2 = r2.zzk()
            int r2 = r2.zzah()
            r5 = 200900(0x310c4, float:2.81521E-40)
            if (r2 >= r5) goto L_0x0045
            r0 = 25
            return r0
        L_0x0045:
            com.google.android.gms.measurement.internal.zzib r2 = r7.zzu
            r2.zzc()
            boolean r5 = r0 instanceof android.os.Parcelable[]
            if (r5 == 0) goto L_0x0053
            r6 = r0
            android.os.Parcelable[] r6 = (android.os.Parcelable[]) r6
            int r6 = r6.length
            goto L_0x005e
        L_0x0053:
            boolean r6 = r0 instanceof java.util.ArrayList
            if (r6 == 0) goto L_0x00a6
            r6 = r0
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r6.size()
        L_0x005e:
            r9 = 200(0xc8, float:2.8E-43)
            if (r6 <= r9) goto L_0x00a6
            com.google.android.gms.measurement.internal.zzgt r10 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zzh()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r10.zzd(r11, r3, r8, r6)
            r2.zzc()
            r2 = 17
            if (r5 == 0) goto L_0x008c
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r6 = r5.length
            if (r6 <= r9) goto L_0x0089
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r9)
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            r1.putParcelableArray(r8, r5)
        L_0x0089:
            r9 = 17
            goto L_0x00ab
        L_0x008c:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x0089
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r6 = r5.size()
            if (r6 <= r9) goto L_0x0089
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r5 = r5.subList(r4, r9)
            r6.<init>(r5)
            r1.putParcelableArrayList(r8, r6)
            goto L_0x0089
        L_0x00a6:
            r9 = 0
            goto L_0x00ab
        L_0x00a8:
            r0 = 21
            return r0
        L_0x00ab:
            boolean r1 = zzZ(r15)
            r2 = 0
            if (r1 != 0) goto L_0x00c4
            boolean r1 = zzZ(r16)
            if (r1 == 0) goto L_0x00b9
            goto L_0x00c4
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu
            com.google.android.gms.measurement.internal.zzal r1 = r1.zzc()
            int r1 = r1.zze(r2, r4)
            goto L_0x00ce
        L_0x00c4:
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu
            com.google.android.gms.measurement.internal.zzal r1 = r1.zzc()
            int r1 = r1.zzf(r2, r4)
        L_0x00ce:
            boolean r1 = r13.zzu(r3, r8, r1, r0)
            if (r1 == 0) goto L_0x00d5
            return r9
        L_0x00d5:
            if (r21 == 0) goto L_0x0165
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00ec
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzz(r1, r2, r3, r4, r5, r6)
            goto L_0x0164
        L_0x00ec:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x0123
            r10 = r0
            android.os.Parcelable[] r10 = (android.os.Parcelable[]) r10
            int r11 = r10.length
            r12 = 0
        L_0x00f5:
            if (r12 >= r11) goto L_0x0164
            r0 = r10[r12]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x0111
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzh()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0165
        L_0x0111:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzz(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x00f5
        L_0x0123:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0165
            r10 = r0
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            int r11 = r10.size()
            r12 = 0
        L_0x012f:
            if (r12 >= r11) goto L_0x0164
            java.lang.Object r0 = r10.get(r12)
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x0152
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzh()
            if (r0 == 0) goto L_0x014a
            java.lang.Class r0 = r0.getClass()
            goto L_0x014c
        L_0x014a:
            java.lang.String r0 = "null"
        L_0x014c:
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r1.zzc(r2, r0, r8)
            goto L_0x0165
        L_0x0152:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r5 = r19
            r6 = r20
            r0.zzz(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 1
            goto L_0x012f
        L_0x0164:
            return r9
        L_0x0165:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpo.zzD(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    public final Object zzE(String str, Object obj) {
        int zze2;
        if ("_ev".equals(str)) {
            return zzay(this.zzu.zzc().zzf((String) null, false), obj, true, true, (String) null);
        }
        if (zzZ(str)) {
            zze2 = this.zzu.zzc().zzf((String) null, false);
        } else {
            zze2 = this.zzu.zzc().zze((String) null, false);
        }
        return zzay(zze2, obj, false, true, (String) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzF(java.lang.String r22, java.lang.String r23, android.os.Bundle r24, java.util.List r25, boolean r26) {
        /*
            r21 = this;
            r9 = r21
            r10 = r23
            r11 = r24
            r12 = r25
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzjl.zzd
            boolean r13 = zzaA(r10, r0)
            if (r11 == 0) goto L_0x0113
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r11)
            com.google.android.gms.measurement.internal.zzib r8 = r9.zzu
            com.google.android.gms.measurement.internal.zzal r0 = r8.zzc()
            int r7 = r0.zzc()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r24.keySet()
            r0.<init>(r1)
            java.util.Iterator r16 = r0.iterator()
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x0032:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x0111
            java.lang.Object r0 = r16.next()
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            if (r12 == 0) goto L_0x004a
            boolean r0 = r12.contains(r6)
            if (r0 != 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r0 = 0
            goto L_0x0058
        L_0x004a:
            if (r26 != 0) goto L_0x0051
            int r0 = r9.zzq(r6)
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 != 0) goto L_0x0058
            int r0 = r9.zzs(r6)
        L_0x0058:
            if (r0 == 0) goto L_0x006c
            r1 = 3
            if (r0 != r1) goto L_0x005f
            r1 = r6
            goto L_0x0060
        L_0x005f:
            r1 = 0
        L_0x0060:
            r9.zzJ(r15, r0, r6, r1)
            r15.remove(r6)
            r12 = r7
            r20 = r8
        L_0x0069:
            r3 = 0
            goto L_0x010a
        L_0x006c:
            java.lang.Object r4 = r11.get(r6)
            r0 = r21
            r1 = r22
            r2 = r23
            r3 = r6
            r5 = r15
            r14 = r6
            r6 = r25
            r12 = r7
            r7 = r26
            r20 = r8
            r8 = r13
            int r0 = r0.zzD(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = 17
            if (r0 != r1) goto L_0x008f
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r9.zzJ(r15, r1, r14, r0)
            goto L_0x00ab
        L_0x008f:
            if (r0 == 0) goto L_0x00ab
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x00ab
            r1 = 21
            if (r0 != r1) goto L_0x009f
            r6 = r10
            goto L_0x00a0
        L_0x009f:
            r6 = r14
        L_0x00a0:
            java.lang.Object r1 = r11.get(r14)
            r9.zzJ(r15, r0, r6, r1)
            r15.remove(r14)
            goto L_0x0069
        L_0x00ab:
            boolean r0 = zzh(r14)
            if (r0 == 0) goto L_0x0069
            int r0 = r18 + 1
            if (r0 <= r12) goto L_0x0108
            com.google.android.gms.measurement.internal.zzal r1 = r20.zzc()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzbf
            r3 = 0
            boolean r1 = r1.zzp(r3, r2)
            if (r1 == 0) goto L_0x00c4
            if (r19 != 0) goto L_0x00ff
        L_0x00c4:
            java.lang.String r1 = java.lang.String.valueOf(r12)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 37
            r2.<init>(r1)
            java.lang.String r1 = "Event can't contain more than "
            r2.append(r1)
            r2.append(r12)
            java.lang.String r1 = " params"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.measurement.internal.zzgt r2 = r20.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzd()
            com.google.android.gms.measurement.internal.zzgm r4 = r20.zzl()
            java.lang.String r4 = r4.zza(r10)
            com.google.android.gms.measurement.internal.zzgm r5 = r20.zzl()
            java.lang.String r5 = r5.zze(r11)
            r2.zzc(r1, r4, r5)
        L_0x00ff:
            r1 = 5
            zzax(r15, r1)
            r15.remove(r14)
            r19 = 1
        L_0x0108:
            r18 = r0
        L_0x010a:
            r7 = r12
            r8 = r20
            r12 = r25
            goto L_0x0032
        L_0x0111:
            r14 = r15
            goto L_0x0115
        L_0x0113:
            r3 = 0
            r14 = r3
        L_0x0115:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpo.zzF(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    public final void zzG(zzgu zzgu, int i) {
        Bundle bundle = zzgu.zzd;
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        int i2 = 0;
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (zzh(str) && (i2 = i2 + 1) > i) {
                zzib zzib = this.zzu;
                if (!zzib.zzc().zzp((String) null, zzfx.zzbf) || !z) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i);
                    sb.append(" params");
                    zzib.zzaV().zzd().zzc(sb.toString(), zzib.zzl().zza(zzgu.zza), zzib.zzl().zze(bundle));
                    zzax(bundle, 5);
                }
                bundle.remove(str);
                z = true;
            }
        }
    }

    public final void zzH(Parcelable[] parcelableArr, int i) {
        Preconditions.checkNotNull(parcelableArr);
        for (Bundle bundle : parcelableArr) {
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i2 = 0;
            boolean z = false;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (zzh(str) && !zzaA(str, zzjm.zzd) && (i2 = i2 + 1) > i) {
                    zzib zzib = this.zzu;
                    if (!zzib.zzc().zzp((String) null, zzfx.zzbf) || !z) {
                        zzgr zzd2 = zzib.zzaV().zzd();
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i);
                        sb.append(" item-scoped custom parameters");
                        zzd2.zzc(sb.toString(), zzib.zzl().zzb(str), zzib.zzl().zze(bundle));
                    }
                    zzax(bundle, 28);
                    bundle.remove(str);
                    z = true;
                }
            }
        }
    }

    public final void zzI(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String next : bundle2.keySet()) {
                if (!bundle.containsKey(next)) {
                    this.zzu.zzk().zzM(bundle, next, bundle2.get(next));
                }
            }
        }
    }

    public final void zzJ(Bundle bundle, int i, String str, Object obj) {
        if (zzax(bundle, i)) {
            this.zzu.zzc();
            bundle.putString("_ev", zzC(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) obj.toString().length());
                }
            }
        }
    }

    public final int zzK(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zzu("user property referrer", str, zzaz(str), obj);
        } else {
            z = zzu("user property", str, zzaz(str), obj);
        }
        if (z) {
            return 0;
        }
        return 7;
    }

    public final Object zzL(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zzay(zzaz(str), obj, true, false, (String) null);
        }
        return zzay(zzaz(str), obj, false, false, (String) null);
    }

    public final void zzM(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                if (obj != null) {
                    str2 = obj.getClass().getSimpleName();
                } else {
                    str2 = null;
                }
                zzib zzib = this.zzu;
                zzib.zzaV().zzh().zzc("Not putting event parameter. Invalid value type. name, type", zzib.zzl().zzb(str), str2);
            }
        }
    }

    public final void zzN(zzpn zzpn, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzax(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        zzpn.zza(str, "_err", bundle);
    }

    @WorkerThread
    public final boolean zzS() {
        zzg();
        if (zzV() == 1) {
            return true;
        }
        return false;
    }

    public final MeasurementManagerFutures zzT() {
        if (this.zzg == null) {
            this.zzg = MeasurementManagerFutures.from(this.zzu.zzaY());
        }
        return this.zzg;
    }

    public final int zzU() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    @WorkerThread
    public final long zzV() {
        long j;
        zzg();
        if (!zzX(this.zzu.zzv().zzj())) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j = 8;
        } else {
            zzib zzib = this.zzu;
            int zzU = zzU();
            zzib.zzc();
            if (zzU < ((Integer) zzfx.zzal.zzb((Object) null)).intValue()) {
                j = 16;
            } else {
                j = 0;
            }
        }
        if (!zzY("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0 && !zzW()) {
            j = 64;
        }
        if (j == 0) {
            return 1;
        }
        return j;
    }

    @WorkerThread
    @TargetApi(30)
    public final boolean zzW() {
        Integer num;
        Object e;
        if (this.zzh == null) {
            MeasurementManagerFutures zzT = zzT();
            boolean z = false;
            if (zzT == null) {
                return false;
            }
            try {
                num = zzT.getMeasurementApiStatusAsync().get(10000, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z = true;
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    } catch (ExecutionException e3) {
                        e = e3;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    } catch (InterruptedException e4) {
                        e = e4;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    } catch (TimeoutException e5) {
                        e = e5;
                        this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                        this.zzh = Boolean.FALSE;
                        this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                        return this.zzh.booleanValue();
                    }
                }
                this.zzh = Boolean.valueOf(z);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e6) {
                e = e6;
                num = null;
                this.zzu.zzaV().zze().zzb("Measurement manager api exception", e);
                this.zzh = Boolean.FALSE;
                this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
                return this.zzh.booleanValue();
            }
            this.zzu.zzaV().zzk().zzb("Measurement manager api status result", num);
        }
        return this.zzh.booleanValue();
    }

    public final boolean zzX(String str) {
        String str2 = (String) zzfx.zzar.zzb((Object) null);
        if (str2.equals("*") || Arrays.asList(str2.split(",")).contains(str)) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final boolean zzY(String str) {
        zzg();
        zzib zzib = this.zzu;
        if (Wrappers.packageManager(zzib.zzaY()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzib.zzaV().zzj().zzb("Permission not granted", str);
        return false;
    }

    public final boolean zza() {
        return true;
    }

    public final boolean zzaa(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        zzib zzib = this.zzu;
        String zzA = zzib.zzc().zzA();
        zzib.zzaU();
        return zzA.equals(str);
    }

    public final Bundle zzab(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object zzE = zzE(next, bundle.get(next));
                if (zzE == null) {
                    zzib zzib = this.zzu;
                    zzib.zzaV().zzh().zzb("Param value can't be null", zzib.zzl().zzb(next));
                } else {
                    zzM(bundle2, next, zzE);
                }
            }
        }
        return bundle2;
    }

    public final zzbg zzac(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zzn(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle zzF = zzF(str, str2, bundle3, CollectionUtils.listOf("_o"), true);
            if (z) {
                zzF = zzab(zzF, str);
            }
            Preconditions.checkNotNull(zzF);
            return new zzbg(str2, new zzbe(zzF), str3, j);
        }
        zzib zzib = this.zzu;
        zzib.zzaV().zzb().zzb("Invalid conditional property event name", zzib.zzl().zzc(str2));
        throw new IllegalArgumentException();
    }

    @VisibleForTesting
    public final boolean zzad(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            this.zzu.zzaV().zzb().zzb("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            this.zzu.zzaV().zzb().zzb("Package name not found", e2);
            return true;
        }
    }

    public final byte[] zzae(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public final boolean zzag(int i, boolean z) {
        Boolean zzJ = this.zzu.zzt().zzJ();
        if (zzah() >= i / 1000) {
            return true;
        }
        if (zzJ == null || zzJ.booleanValue()) {
            return false;
        }
        return true;
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzah() {
        if (this.zzi == null) {
            this.zzi = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzu.zzaY()) / 1000);
        }
        return this.zzi.intValue();
    }

    public final int zzai(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.zzu.zzaY(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    public final long zzaj(long j, long j2) {
        return ((j2 * DateUtils.MILLIS_PER_MINUTE) + j) / DateUtils.MILLIS_PER_DAY;
    }

    @WorkerThread
    public final void zzak(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            this.zzu.zzaV().zze().zzb("Params already contained engagement", Long.valueOf(j2));
        } else {
            j2 = 0;
        }
        bundle.putLong("_et", j + j2);
    }

    public final void zzal(zzcu zzcu, String str) {
        try {
            zzcu.zzb(e.c("r", str));
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning string value to wrapper", e);
        }
    }

    public final void zzam(zzcu zzcu, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcu.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning long value to wrapper", e);
        }
    }

    public final void zzan(zzcu zzcu, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcu.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning int value to wrapper", e);
        }
    }

    public final void zzao(zzcu zzcu, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcu.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning byte array to wrapper", e);
        }
    }

    public final void zzap(zzcu zzcu, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcu.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning boolean value to wrapper", e);
        }
    }

    public final void zzaq(zzcu zzcu, Bundle bundle) {
        try {
            zzcu.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning bundle value to wrapper", e);
        }
    }

    public final void zzar(zzcu zzcu, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcu.zzb(bundle);
        } catch (RemoteException e) {
            this.zzu.zzaV().zze().zzb("Error returning bundle list to wrapper", e);
        }
    }

    public final URL zzat(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String str4 = "https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=" + ("v130000." + zzah()) + "&rdid=" + str2 + "&bundleid=" + str + "&retry=" + j2;
            if (str.equals(this.zzu.zzc().zzB())) {
                str4 = str4.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    str4 = str4.concat("&");
                }
                str4 = str4.concat(str3);
            }
            return new URL(str4);
        } catch (MalformedURLException e) {
            e = e;
            this.zzu.zzaV().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (IllegalArgumentException e2) {
            e = e2;
            this.zzu.zzaV().zzb().zzb("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final String zzaw() {
        byte[] bArr = new byte[16];
        zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    @WorkerThread
    public final void zzba() {
        zzg();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                e.C(this.zzu, "Utils falling back to Random for random id");
            }
        }
        this.zze.set(nextLong);
    }

    public final long zzd() {
        long andIncrement;
        long j;
        AtomicLong atomicLong = this.zze;
        if (atomicLong.get() == 0) {
            synchronized (atomicLong) {
                long nextLong = new Random(System.nanoTime() ^ this.zzu.zzaZ().currentTimeMillis()).nextLong();
                int i = this.zzf + 1;
                this.zzf = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        AtomicLong atomicLong2 = this.zze;
        synchronized (atomicLong2) {
            atomicLong2.compareAndSet(-1, 1);
            andIncrement = atomicLong2.getAndIncrement();
        }
        return andIncrement;
    }

    @WorkerThread
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzf() {
        zzg();
        if (this.zzd == null) {
            this.zzd = new SecureRandom();
        }
        return this.zzd;
    }

    public final Bundle zzi(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Uri uri2 = uri;
        if (uri2 != null) {
            try {
                if (uri.isHierarchical()) {
                    str9 = uri2.getQueryParameter("utm_campaign");
                    str8 = uri2.getQueryParameter("utm_source");
                    str7 = uri2.getQueryParameter("utm_medium");
                    str6 = uri2.getQueryParameter("gclid");
                    str5 = uri2.getQueryParameter("gbraid");
                    str4 = uri2.getQueryParameter("utm_id");
                    str3 = uri2.getQueryParameter("dclid");
                    str2 = uri2.getQueryParameter("srsltid");
                    str = uri2.getQueryParameter("sfmc_id");
                } else {
                    str9 = null;
                    str8 = null;
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str9) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str9)) {
                    str10 = "sfmc_id";
                    bundle.putString("campaign", str9);
                } else {
                    str10 = "sfmc_id";
                }
                if (!TextUtils.isEmpty(str8)) {
                    bundle.putString("source", str8);
                }
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("medium", str7);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString("gclid", str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("gbraid", str5);
                }
                String queryParameter = uri2.getQueryParameter("gad_source");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("gad_source", queryParameter);
                }
                String queryParameter2 = uri2.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter2);
                }
                String queryParameter3 = uri2.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString(FirebaseAnalytics.Param.CONTENT, queryParameter3);
                }
                String queryParameter4 = uri2.getQueryParameter(FirebaseAnalytics.Param.ACLID);
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter4);
                }
                String queryParameter5 = uri2.getQueryParameter(FirebaseAnalytics.Param.CP1);
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter5);
                }
                String queryParameter6 = uri2.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("anid", queryParameter6);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str4);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("dclid", str3);
                }
                String queryParameter7 = uri2.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter7);
                }
                String queryParameter8 = uri2.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter8);
                }
                String queryParameter9 = uri2.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter9);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("srsltid", str2);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString(str10, str);
                }
                for (String next : uri.getQueryParameterNames()) {
                    if (next.startsWith("gad_")) {
                        String queryParameter10 = uri2.getQueryParameter(next);
                        if (!TextUtils.isEmpty(queryParameter10)) {
                            bundle.putString(next, queryParameter10);
                        }
                    }
                }
                return bundle;
            } catch (UnsupportedOperationException e) {
                this.zzu.zzaV().zze().zzb("Install referrer url isn't a hierarchical URI", e);
                return null;
            }
        } else {
            return null;
        }
    }

    public final boolean zzj(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.zzu.zzaV().zzd().zzc("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean zzk(String str, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.zzu.zzaV().zzd().zzc("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.zzu.zzaV().zzd().zzc("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean zzl(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zzb;
        for (int i = 0; i < 3; i++) {
            if (str2.startsWith(strArr3[i])) {
                this.zzu.zzaV().zzd().zzc("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zzaA(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zzaA(str2, strArr2)) {
            return true;
        }
        this.zzu.zzaV().zzd().zzc("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final boolean zzm(String str, int i, String str2) {
        if (str2 == null) {
            this.zzu.zzaV().zzd().zzb("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            this.zzu.zzaV().zzd().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    public final int zzn(String str) {
        if (!zzk(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!zzl(NotificationCompat.CATEGORY_EVENT, zzjl.zza, zzjl.zzb, str)) {
            return 13;
        }
        this.zzu.zzc();
        if (!zzm(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    public final int zzp(String str) {
        if (!zzk("user property", str)) {
            return 6;
        }
        if (!zzl("user property", zzjn.zza, (String[]) null, str)) {
            return 15;
        }
        this.zzu.zzc();
        if (!zzm("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    public final int zzq(String str) {
        if (!zzj("event param", str)) {
            return 3;
        }
        if (!zzl("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.zzu.zzc();
        if (!zzm("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final int zzs(String str) {
        if (!zzk("event param", str)) {
            return 3;
        }
        if (!zzl("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.zzu.zzc();
        if (!zzm("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    public final boolean zzt(Object obj) {
        if ((obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
            return true;
        }
        return false;
    }

    public final boolean zzu(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i) {
                this.zzu.zzaV().zzh().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    public final void zzz(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str4;
        int i6;
        int i7;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            zzib zzib = this.zzu;
            if (true != zzib.zzc().zzu.zzk().zzag(231100000, true)) {
                i = 0;
            } else {
                i = 35;
            }
            Iterator it = new TreeSet(bundle.keySet()).iterator();
            int i8 = 0;
            boolean z2 = false;
            while (it.hasNext()) {
                String str6 = (String) it.next();
                if (list2 == null || !list2.contains(str6)) {
                    if (!z) {
                        i2 = zzq(str6);
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        i2 = zzs(str6);
                    }
                } else {
                    i2 = 0;
                }
                String str7 = null;
                if (i2 != 0) {
                    if (i2 == 3) {
                        str7 = str6;
                    }
                    zzJ(bundle2, i2, str6, str7);
                    bundle2.remove(str6);
                    i3 = i;
                } else {
                    if (zzt(bundle2.get(str6))) {
                        zzib.zzaV().zzh().zzd("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        i6 = 22;
                        str4 = str6;
                        i5 = i;
                    } else {
                        String str8 = str3;
                        str4 = str6;
                        i5 = i;
                        i6 = zzD(str, str2, str6, bundle2.get(str6), bundle, list, z, false);
                    }
                    if (i6 != 0 && !"_ev".equals(str4)) {
                        zzJ(bundle2, i6, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (zzh(str4) && !zzaA(str4, zzjm.zzd)) {
                        int i9 = i8 + 1;
                        if (!zzag(231100000, true)) {
                            zzib.zzaV().zzd().zzc("Item array not supported on client's version of Google Play Services (Android Only)", zzib.zzl().zza(str5), zzib.zzl().zze(bundle2));
                            zzax(bundle2, 23);
                            bundle2.remove(str4);
                            i7 = i5;
                        } else {
                            i7 = i5;
                            if (i9 > i7) {
                                if (!zzib.zzc().zzp((String) null, zzfx.zzbf) || !z2) {
                                    zzgr zzd2 = zzib.zzaV().zzd();
                                    StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 55);
                                    sb.append("Item can't contain more than ");
                                    sb.append(i7);
                                    sb.append(" item-scoped custom params");
                                    zzd2.zzc(sb.toString(), zzib.zzl().zza(str5), zzib.zzl().zze(bundle2));
                                }
                                zzax(bundle2, 28);
                                bundle2.remove(str4);
                                i8 = i9;
                                i4 = i7;
                                z2 = true;
                            }
                        }
                        i8 = i9;
                        i4 = i3;
                    }
                    i3 = i5;
                }
                i4 = i3;
            }
        }
    }
}
