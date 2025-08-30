package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.facebook.places.model.PlaceFields;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oOO0ooO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0o000OO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.shell.TDOption;
import com.trustdecision.android.shell.common.HelperJNI;
import com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;

public class oOO0OooO0 {
    private static volatile oOO0OooO0 O00OO0oOOooooO00000Oo;
    public static final Object o0O00o00OOoOo0oooOoo00 = new Object();
    private static volatile oOO0OooO0 oO00o0OooO0OO0o0000o;
    /* access modifiers changed from: private */
    public WifiManager O0OoOo00O000 = null;
    /* access modifiers changed from: private */
    public ActivityManager O0o0o0O0OOOooOo0OOoOOO = null;
    /* access modifiers changed from: private */
    public LocationManager O0o0o0O0ooOooOoo = null;
    /* access modifiers changed from: private */
    public o0Oo0OO00O0O000ooOO0 O0oOO0ooO;
    /* access modifiers changed from: private */
    public Context OO0000O0Ooo0OO000oo;
    private Ooooo000OOoO Oo0O0Oo0OO0OOOoOO0O0 = null;
    /* access modifiers changed from: private */
    public TelephonyManager OoOOooOoooOoo = null;
    /* access modifiers changed from: private */
    public com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 o00ooooooO00OO0O00 = null;
    public long o0Oo0OO00O0O000ooOO0 = 0;
    /* access modifiers changed from: private */
    public SensorManager o0oOO0oO00OoO0 = null;
    /* access modifiers changed from: private */
    public ConnectivityManager o0ooOoo0Oo00oOOO = null;
    /* access modifiers changed from: private */
    public WindowManager oO0oOOOOoo = null;

    private oOO0OooO0(Context context) {
        this.OO0000O0Ooo0OO000oo = context;
        this.o00ooooooO00OO0O00 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0();
        this.Oo0O0Oo0OO0OOOoOO0O0 = new Ooooo000OOoO();
        try {
            this.OoOOooOoooOoo = (TelephonyManager) context.getSystemService(PlaceFields.PHONE);
            this.O0OoOo00O000 = (WifiManager) context.getSystemService("wifi");
            this.O0o0o0O0OOOooOo0OOoOOO = (ActivityManager) context.getSystemService("activity");
            this.oO0oOOOOoo = (WindowManager) context.getSystemService("window");
            this.o0ooOoo0Oo00oOOO = (ConnectivityManager) context.getSystemService("connectivity");
            this.O0o0o0O0ooOooOoo = (LocationManager) context.getSystemService("location");
            if (this.O0oOO0ooO.O0o0o0O0ooOooOoo) {
                this.o0oOO0oO00OoO0 = (SensorManager) context.getSystemService("sensor");
            }
        } catch (Exception unused) {
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO0oOOOOoo, "get system service error");
        }
    }

    public static String O0OOO0O0OO0oO0oOoO000() {
        return ooOoOooO.ooOoOooO();
    }

    public static String O0o0o0O0ooOooOoo() {
        return ooOoOooO.O0oOO0ooO();
    }

    public static String O0oOoo0oOo(Context context) {
        return ooOoOooO.OOOOO0o0ooo00oOo0(context);
    }

    public static String O0oOoooo0o0o0oOo() {
        return ooOoOooO.oO0oo00OooOooOOo();
    }

    public static Object O0oo0OOOOoO(Context context) {
        return ooOoOooO.O0oOoo0oOo(context);
    }

    public static String O0oo0o00oooo() {
        OO0000O0Ooo0OO000oo oO0000O0Ooo0OO000oo = (OO0000O0Ooo0OO000oo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0("com.trustdecision.android.sensor.g99q9ggq99qgq9gq9q_SN");
        if (oO0000O0Ooo0OO000oo != null) {
            return oO0000O0Ooo0OO000oo.o00ooooooO00OO0O00();
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static Integer OO000O0O0Oo() {
        return ooOoOooO.Oo0o000OO();
    }

    public static String OOOOO0o0ooo00oOo0(Context context) {
        return ooOoOooO.oO0OOO00(context);
    }

    public static String OOoOo00oo0Ooo0o0o0o000() {
        return ooOoOooO.ooooOO0OO0O0OOoo();
    }

    public static String Oo0O0Oo0OO0OOOoOO0O0() {
        return ooOoOooO.oOOO00oO00o0oOoOo();
    }

    public static Object Oo0OO00oooO0Ooo000ooOo(Context context) {
        return ooOoOooO.O0oo0OOOOoO(context);
    }

    public static String Oo0o000OO() {
        return ooOoOooO.oOO0OooO0();
    }

    public static String o0Oo0O0o0ooOOo0oO0() {
        return ooOoOooO.o0ooO0o000Oo0Oo0O0();
    }

    public static String o0oOO0oO00OoO0() {
        return ooOoOooO.O00OO0oOOooooO00000Oo();
    }

    public static String o0ooO0o000Oo0Oo0O0() {
        return ooOoOooO.O0oo0o00oooo();
    }

    public static int o0ooOoo0Oo00oOOO() {
        return ooOoOooO.oO00o0OooO0OO0o0000o();
    }

    public static String oO0OOO00() {
        return ooOoOooO.o00ooooooO00OO0O00();
    }

    public static String oO0oOOOOoo(Context context) {
        return ooOoOooO.O0OoOo00O000(context);
    }

    public static String oO0oo00OooOooOOo() {
        OO0000O0Ooo0OO000oo oO0000O0Ooo0OO000oo = (OO0000O0Ooo0OO000oo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0("com.trustdecision.android.sensor.g99q9ggq99qgq9gq9q_SN");
        if (oO0000O0Ooo0OO000oo != null) {
            return oO0000O0Ooo0OO000oo.O0oOO0ooO();
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static int oOO0Oo000oOO00oo0o0(Context context) {
        return ooOoOooO.Oo0OO00oooO0Ooo000ooOo(context);
    }

    public static String oOO0OooO0() {
        OO0000O0Ooo0OO000oo oO0000O0Ooo0OO000oo = (OO0000O0Ooo0OO000oo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0("com.trustdecision.android.sensor.g99q9ggq99qgq9gq9q_SN");
        if (oO0000O0Ooo0OO000oo != null) {
            return oO0000O0Ooo0OO000oo.oO00o0OooO0OO0o0000o();
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static String oOOO00oO00o0oOoOo() {
        return ooOoOooO.OO000O0O0Oo();
    }

    public static String ooOo0oO0O000o0O0O00oo() {
        return ooOoOooO.O0OOO0O0OO0oO0oOoO000();
    }

    public static String ooOoOooO() {
        return ooOoOooO.Oo0O0Oo0OO0OOOoOO0O0();
    }

    public static String ooooOO0OO0O0OOoo() {
        OO0000O0Ooo0OO000oo oO0000O0Ooo0OO000oo = (OO0000O0Ooo0OO000oo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0("com.trustdecision.android.sensor.g99q9ggq99qgq9gq9q_SN");
        if (oO0000O0Ooo0OO000oo != null) {
            return oO0000O0Ooo0OO000oo.O00OO0oOOooooO00000Oo();
        }
        return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    }

    public static String O00OO0oOOooooO00000Oo() {
        return ooOoOooO.o0O00o00OOoOo0oooOoo00();
    }

    public static String O0OOO0O0OO0oO0oOoO000(Context context) {
        return ooOoOooO.OOoOo00oo0Ooo0o0o0o000(context);
    }

    public static int O0OoOo00O000(Context context) {
        return ooOoOooO.oOOO00oO00o0oOoOo(context);
    }

    public static long O0o0o0O0OOOooOo0OOoOOO(Context context) {
        return ooOoOooO.OoOOooOoooOoo(context);
    }

    public static String O0o0o0O0ooOooOoo(Context context) {
        return ooOoOooO.o0ooOoo0Oo00oOOO(context);
    }

    public static String O0oOO0ooO(Context context) {
        return ooOoOooO.O0oOO0ooO(context);
    }

    public static String O0oOoooo0o0o0oOo(Context context) {
        return ooOoOooO.Oo0O0Oo0OO0OOOoOO0O0(context);
    }

    public static String OO0000O0Ooo0OO000oo(Context context) {
        return ooOoOooO.OO0000O0Ooo0OO000oo(context);
    }

    public static boolean OO000O0O0Oo(Context context) {
        return ooOoOooO.Oo0o000OO(context);
    }

    public static String OOOOO0o0ooo00oOo0() {
        return ooOoOooO.ooOo0oO0O000o0O0O00oo();
    }

    public static String OOoOo00oo0Ooo0o0o0o000(Context context) {
        return ooOoOooO.o0ooO0o000Oo0Oo0O0(context);
    }

    public static String Oo0O0Oo0OO0OOOoOO0O0(Context context) {
        return ooOoOooO.o0oOO0oO00OoO0(context);
    }

    public static String Oo0o000OO(Context context) {
        return ooOoOooO.O0oOoooo0o0o0oOo(context);
    }

    public static String OoOOooOoooOoo(Context context) {
        return Oo0o000OO.o0Oo0OO00O0O000ooOO0(context);
    }

    public static String o00ooooooO00OO0O00(Context context) {
        return ooOoOooO.o00ooooooO00OO0O00(context);
    }

    public static String o0Oo0O0o0ooOOo0oO0(Context context) {
        return ooOoOooO.o0Oo0O0o0ooOOo0oO0(context);
    }

    public static oOO0OooO0 o0Oo0OO00O0O000ooOO0(Context context, com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        if (oO00o0OooO0OO0o0000o == null) {
            synchronized (oOO0OooO0.class) {
                try {
                    if (oO00o0OooO0OO0o0000o == null) {
                        oO00o0OooO0OO0o0000o = new oOO0OooO0(context);
                    }
                    oO00o0OooO0OO0o0000o.O0oOO0ooO = o0oo0oo00o0o000oooo0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return oO00o0OooO0OO0o0000o;
    }

    public static String o0oOO0oO00OoO0(Context context) {
        return ooOoOooO.oO0oOOOOoo(context);
    }

    public static String o0ooO0o000Oo0Oo0O0(Context context) {
        return ooOoOooO.O0o0o0O0ooOooOoo(context);
    }

    public static String o0ooOoo0Oo00oOOO(Context context) {
        return ooOoOooO.O0o0o0O0OOOooOo0OOoOOO(context);
    }

    public static String oO00o0OooO0OO0o0000o() {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0();
    }

    public static Object oO0OOO00(Context context) {
        return ooOoOooO.ooOo0oO0O000o0O0O00oo(context);
    }

    public static String oO0oOOOOoo() throws Throwable {
        return ooOoOooO.o0Oo0O0o0ooOOo0oO0();
    }

    public static String oOOO00oO00o0oOoOo(Context context) {
        return ooOoOooO.OO000O0O0Oo(context);
    }

    public static String ooOo0oO0O000o0O0O00oo(Context context) {
        return ooOoOooO.O0OOO0O0OO0oO0oOoO000(context);
    }

    public static String ooOoOooO(Context context) {
        return ooOoOooO.ooOoOooO(context);
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        try {
            byte[] o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("demotion", false);
            if (o0Oo0OO00O0O000ooOO02 != null) {
                return new String(o0Oo0OO00O0O000ooOO02, StandardCharsets.UTF_8);
            }
            return null;
        } catch (Throwable th) {
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.OoOOooOoooOoo, com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(th));
            return null;
        }
    }

    public static String O00OO0oOOooooO00000Oo(Context context) {
        return ooOoOooO.O00OO0oOOooooO00000Oo(context);
    }

    public static String O0OoOo00O000() {
        return ooOoOooO.OoOOooOoooOoo();
    }

    public static String O0o0o0O0OOOooOo0OOoOOO() {
        return ooOoOooO.O0o0o0O0ooOooOoo();
    }

    public static String O0oOO0ooO() {
        return ooOoOooO.OO0000O0Ooo0OO000oo();
    }

    public static String OO0000O0Ooo0OO000oo() {
        return ooOoOooO.O0OoOo00O000();
    }

    public static String OoOOooOoooOoo() {
        return ooOoOooO.O0o0o0O0OOOooOo0OOoOOO();
    }

    public static String o00ooooooO00OO0O00() {
        return Oo0o000OO.o0Oo0OO00O0O000ooOO0();
    }

    public static String oO00o0OooO0OO0o0000o(Context context) {
        return ooOoOooO.oO00o0OooO0OO0o0000o(context);
    }

    public static boolean O0oo0o00oooo(Context context) {
        return ooOoOooO.ooooOO0OO0O0OOoo(context);
    }

    public static Integer oO00o0OooO0OO0o0000o(Context context, WifiManager wifiManager) {
        return ooOoOooO.oO00o0OooO0OO0o0000o(context, wifiManager);
    }

    public static String oO0oo00OooOooOOo(Context context) {
        return ooOoOooO.O0oo0o00oooo(context);
    }

    public static Integer oOO0OooO0(Context context) {
        return ooOoOooO.oOO0OooO0(context);
    }

    public static String ooooOO0OO0O0OOoo(Context context) {
        return ooOoOooO.oO0oo00OooOooOOo(context);
    }

    public static String o0O00o00OOoOo0oooOoo00(Context context) {
        return ooOoOooO.o0O00o00OOoOo0oooOoo00(context);
    }

    public static String o0O00o00OOoOo0oooOoo00(Context context, WifiManager wifiManager) {
        return ooOoOooO.o0O00o00OOoOo0oooOoo00(context, wifiManager);
    }

    public static String o0O00o00OOoOo0oooOoo00(Context context, ActivityManager activityManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context, activityManager);
    }

    public static int o0O00o00OOoOo0oooOoo00(Context context, LocationManager locationManager) {
        return ooOoOooO.o0O00o00OOoOo0oooOoo00(context, locationManager);
    }

    public void o0Oo0OO00O0O000ooOO0(TDOption tDOption, CountDownLatch countDownLatch, CountDownLatch countDownLatch2) {
        if (this.o00ooooooO00OO0O00 == null) {
            for (int i = 0; ((long) i) < countDownLatch2.getCount(); i++) {
                countDownLatch2.countDown();
            }
            return;
        }
        this.o0Oo0OO00O0O000ooOO0 = SystemClock.elapsedRealtime();
        String partnerCode = TextUtils.isEmpty(tDOption.getPartnerCode()) ? this.O0oOO0ooO.O0oOO0ooO : tDOption.getPartnerCode();
        String enterpriseUrl = TextUtils.isEmpty(tDOption.getEnterpriseUrl()) ? this.O0oOO0ooO.oO0OOO00 : tDOption.getEnterpriseUrl();
        HelperJNI.o0Oo0OO00O0O000ooOO0(7, (Object) null);
        o0oOO0oO00OoO0.o0O00o00OOoOo0oooOoo00();
        o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.SECONDS, new LinkedBlockingDeque(1), new oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00());
        com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO02 = com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0();
        ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
        threadPoolExecutor2.execute(new oO0oo00OooOooOOo(this, o0Oo0OO00O0O000ooOO02, tDOption, partnerCode, enterpriseUrl, countDownLatch, countDownLatch2));
        TDOption tDOption2 = tDOption;
        String str = partnerCode;
        String str2 = enterpriseUrl;
        threadPoolExecutor2.execute(new O0oo0o00oooo(this, tDOption2, str, str2, countDownLatch2));
        threadPoolExecutor2.execute(new ooooOO0OO0O0OOoo(this, tDOption2, str, str2, o0Oo0OO00O0O000ooOO02, countDownLatch2));
        threadPoolExecutor2.shutdown();
    }

    public void o0Oo0OO00O0O000ooOO0() {
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0 = this.o00ooooooO00OO0O00;
        if (o0oo0oo00o0o000oooo0 != null) {
            o0oo0oo00o0o000oooo0.oO0ooo00oooo0oOO0oO(oO0oOo0oooOO0O0OOooOo.o0Oo0OO00O0O000ooOO0(this.o0Oo0OO00O0O000ooOO0));
        }
    }

    @Nullable
    public byte[] o0Oo0OO00O0O000ooOO0(boolean z) {
        try {
            return o0Oo0OO00O0O000ooOO0("complete", z);
        } catch (Throwable th) {
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.OoOOooOoooOoo, com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(th));
            return null;
        }
    }

    public void o0Oo0OO00O0O000ooOO0(String str) throws IllegalAccessException {
        synchronized (o0O00o00OOoOo0oooOoo00) {
            O0oOO0ooO.o0Oo0OO00O0O000ooOO0(this.o00ooooooO00OO0O00, str);
        }
    }

    public boolean o0Oo0OO00O0O000ooOO0(int[] iArr) {
        synchronized (o0O00o00OOoOo0oooOoo00) {
            try {
                Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(81, (Object) new Object[]{iArr});
                if (o0Oo0OO00O0O000ooOO02 == null) {
                    return false;
                }
                boolean booleanValue = ((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue();
                return booleanValue;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    private byte[] o0Oo0OO00O0O000ooOO0(String str, boolean z) throws Throwable {
        synchronized (o0O00o00OOoOo0oooOoo00) {
            try {
                o0Oo0OO00O0O000ooOO0(str);
                byte[] bArr = (byte[]) HelperJNI.o0Oo0OO00O0O000ooOO0(12, (Object) new Object[]{Boolean.valueOf("demotion".equals(str)), Boolean.valueOf(z)});
                if (bArr == null) {
                    return null;
                }
                if ("complete".equals(str)) {
                    return bArr;
                }
                byte[] encode = Base64.encode(bArr, 11);
                return encode;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, TelephonyManager telephonyManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context, telephonyManager);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, WifiManager wifiManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context, wifiManager);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context, connectivityManager, wifiManager);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, ConnectivityManager connectivityManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context, connectivityManager);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, ActivityManager activityManager) {
        return new StringBuilder(Oo0o000OO.o0Oo0OO00O0O000ooOO0(context, activityManager)).toString();
    }

    public static String o0Oo0OO00O0O000ooOO0(SensorManager sensorManager, WindowManager windowManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(sensorManager, windowManager);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, LocationManager locationManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context, locationManager);
    }

    public static Long o0Oo0OO00O0O000ooOO0(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 1;
        }
        return Long.valueOf(elapsedRealtime);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, WifiManager wifiManager, ConnectivityManager connectivityManager, TelephonyManager telephonyManager) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(context, wifiManager, connectivityManager, telephonyManager);
    }

    public static String o0Oo0OO00O0O000ooOO0(com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        return ooOoOooO.o0Oo0OO00O0O000ooOO0(o0oo0oo00o0o000oooo0);
    }
}
