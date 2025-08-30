package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Instrumentation;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.O00OO0oOOooooO00000Oo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0o0o0O0OOOooOo0OOoOOO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0o0o0O0ooOooOoo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oOoooo0o0o0oOo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OO0000O0Ooo0OO000oo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.Oo0o000OO;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0ooO0o000Oo0Oo0O0;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oO00o0OooO0OO0o0000o;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oO0oOOOOoo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.O0oOO0ooO;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0;
import com.trustdecision.android.shell.common.HelperJNI;
import com.trustdecision.android.shell.inter.InvokeHandler;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ooOoOooO {
    public static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("483520230e143b", 29);
    private static final String O0OoOo00O000 = o0Oo0OO00O0O000ooOO0("711c", 35);
    private static final String O0o0o0O0OOOooOo0OOoOOO = o0Oo0OO00O0O000ooOO0("47465c504d4e58", 112);
    private static final String O0o0o0O0ooOooOoo = o0Oo0OO00O0O000ooOO0("1f", 95);
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("5f4242022d704e505a", 125);
    private static final String O0oOoooo0o0o0oOo = o0Oo0OO00O0O000ooOO0("1e47", 124);
    private static final String[] O0oo0o00oooo = {o0Oo0OO00O0O000ooOO0("003563636e78612b2a6c62242a6c6268555b6564696a655552686e7e7b51477d6171323475", 86), o0Oo0OO00O0O000ooOO0("005d0b0b5d5f1509192b2a07120307", 62), o0Oo0OO00O0O000ooOO0("00386e6e63756c26296f63253a706c7c3c3966797b67", 91), o0Oo0OO00O0O000ooOO0("002963713b3e7e6e6a6c73393c766a7a73", 93), o0Oo0OO00O0O000ooOO0("00347e6c26216b7767555066666a", 64), o0Oo0OO00O0O000ooOO0("005e14064c4909191d1b044e5d171e0208", 42), o0Oo0OO00O0O000ooOO0("00460c1e5451110105031c56400e1f1b0a0e020736350f061a10", 50), o0Oo0OO00O0O000ooOO0("0040161640571d0f03161a0a404016161b0d145e500f1946500f195903500f190f080b0842400c1e11191b1524200a1b3125080b08", 35), o0Oo0OO00O0O000ooOO0("001a4c4c41574e040b4d410708494c505b7f5d261b445b59", 121), o0Oo0OO00O0O000ooOO0("00580e0e03150c46490f034546000e15191d1b1f025d5906191b", 59), o0Oo0OO00O0O000ooOO0("002f797974627b313076783e30767875656e757e233f252e6f", 76), o0Oo0OO00O0O000ooOO0("002e787875637a303f7975332a6c7578646f646e73", 77), o0Oo0OO00O0O000ooOO0("004f191914021b515e181452511719020e0a0c081503", 44), o0Oo0OO00O0O000ooOO0("005701010c1a034946000c4a4a0a1c5e56091614", 52), o0Oo0OO00O0O000ooOO0("00396f6f62746d27286e62243e65477e053867787a", 90), o0Oo0OO00O0O000ooOO0("007e282825332a606f29256369343f242f726e777f203f3d", 29), o0Oo0OO00O0O000ooOO0("00014f5f5f044b0644535a5c4d5f4842521714485755", 117), o0Oo0OO00O0O000ooOO0("0026687878232e6e616f602e36747032367a212f6f60666864696b6f6677", 82), o0Oo0OO00O0O000ooOO0("00206b7b7e6f6a377d34287c", 67), o0Oo0OO00O0O000ooOO0("00551e0e0b1a1f4208415d091476310e0802252e010048415d09", 54), o0Oo0OO00O0O000ooOO0("002269797c6d68357f362a7e632671766774", 65), o0Oo0OO00O0O000ooOO0("003973612b2b667f657f746465", 77), o0Oo0OO00O0O000ooOO0("006a20327878352c363e33313726", 30), o0Oo0OO00O0O000ooOO0("000553535e48511b14525e18115b524e425a4b4f5e5a5653", 102)};
    public static String OO0000O0Ooo0OO000oo = null;
    private static final String OO000O0O0Oo = o0Oo0OO00O0O000ooOO0("1e27", 25);
    private static final String Oo0O0Oo0OO0OOOoOO0O0 = o0Oo0OO00O0O000ooOO0("1e", 98);
    private static final String Oo0o000OO = o0Oo0OO00O0O000ooOO0("1e21", 27);
    public static int OoOOooOoooOoo = 0;
    public static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("5b322802013f212b", 12);
    public static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("5b253f", 27);
    private static final String o0Oo0O0o0ooOOo0oO0 = o0Oo0OO00O0O000ooOO0("1e3b", 6);
    public static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("5f040444", 59);
    private static final String o0oOO0oO00OoO0 = o0Oo0OO00O0O000ooOO0("023e", 29);
    private static final String o0ooO0o000Oo0Oo0O0 = o0Oo0OO00O0O000ooOO0("1d02", 62);
    private static final String o0ooOoo0Oo00oOOO = o0Oo0OO00O0O000ooOO0("4e6065797269622522636e757e64753531722c08765e6d6765696d47436060696d783918486e78291b4d72786e", 80);
    public static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("4e070a", 53);
    private static final String oO0oOOOOoo = o0Oo0OO00O0O000ooOO0("4e22273b302b20676f2e212f38302b2c6d4a280e212f38302b2c0e0122222b2f3a7b5a0a2c3a6b590f303a2c", 18);
    private static final String[] oO0oo00OooOooOOo = {o0Oo0OO00O0O000ooOO0("4c010f4e4103185a470216110018", 50), o0Oo0OO00O0O000ooOO0("4c090746470b024e5b14161608050c0c", 58), o0Oo0OO00O0O000ooOO0("4c000e4f4711170a050c090403010a47461d1801010401", 51), o0Oo0OO00O0O000ooOO0("4631766f20787c2a3f282b2136", 8), o0Oo0OO00O0O000ooOO0("4c626c2d2c6d657339367175686f7a63", 81), o0Oo0OO00O0O000ooOO0("4c47490814534a4c4b0a08474d4541", 116), o0Oo0OO00O0O000ooOO0("461c5b4205011c1b0e17170b1a", 37), o0Oo0OO00O0O000ooOO0("4c1816575e151f13084f570c0d0c09", 43), o0Oo0OO00O0O000ooOO0("572334373d2a", 20), o0Oo0OO00O0O000ooOO0("4c0907464a0a0f131803084f4d0007090d1216", 58)};
    private static final String oOO0OooO0 = o0Oo0OO00O0O000ooOO0("4e36332f243f34737e3e2328322363763b2e243f3879553a2c39282e323f25323036303b38", 6);
    private static final String oOOO00oO00o0oOoOo = o0Oo0OO00O0O000ooOO0("1d", 71);

    public static String O00OO0oOOooooO00000Oo() {
        String[] strArr = {o0Oo0OO00O0O000ooOO0("5d732f33787f6f6b69707d757d78242d6c656f", 81), o0Oo0OO00O0O000ooOO0("5d5a060249505b4c4e0518534f5f", 120)};
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < 2; i++) {
            Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(52, (Object) new Object[]{strArr[i]});
            if (o0Oo0OO00O0O000ooOO02 != null) {
                String str = (String) o0Oo0OO00O0O000ooOO02;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        jSONObject.put(String.valueOf(i), str);
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject.length() == 0 ? "" : jSONObject.toString();
    }

    public static String O0OOO0O0OO0oO0oOoO000() {
        JSONObject jSONObject = new JSONObject();
        String[] strArr = {o0Oo0OO00O0O000ooOO0("463c3c2661663e2e76632f362c7b3520652d2a3a3e", 4), o0Oo0OO00O0O000ooOO0("460c0c1651560e1e46411d160d065b47", 52), o0Oo0OO00O0O000ooOO0("461e1e0443441c0c54460d110108", 38), o0Oo0OO00O0O000ooOO0("461d1d0740471f0f57471c302e01080b36211f1e12181b", 37), o0Oo0OO00O0O000ooOO0("462e2e3473742c3c6469283e35", 22), o0Oo0OO00O0O000ooOO0("4659594304035b4b13045e7c454c791e504500484f5f5b", 97), o0Oo0OO00O0O000ooOO0("4607071d5a5d05154d560013061e14", 63), o0Oo0OO00O0O000ooOO0("465a5a4007005848101e59574c404442465b4d", 98), o0Oo0OO00O0O000ooOO0("5d1f43470c151e090b404d0d08141f040f485d160a1a13", 61), o0Oo0OO00O0O000ooOO0("4e3134282307255d662a332919052a27", 1), o0Oo0OO00O0O000ooOO0("4e75706c67436119226e776d5d426f696b624d4878717b", 69), o0Oo0OO00O0O000ooOO0("5d7c203f637c6a7077763b226d6e7a7266637660667676", 94), o0Oo0OO00O0O000ooOO0("5f7371677c7c613c387e61676d2d216b", 89), o0Oo0OO00O0O000ooOO0("5f6765736868752834737f73481c73727575", 77), o0Oo0OO00O0O000ooOO0("5f4745534848550814535f536875525252", 109), o0Oo0OO00O0O000ooOO0("5e4c504003054d10105f525662645a54504f4b", 103), o0Oo0OO00O0O000ooOO0("5e4c504003054d101a575f6363595345424555", 103), o0Oo0OO00O0O000ooOO0("5d603c31707d66657e73787c6a", 66), o0Oo0OO00O0O000ooOO0("460202185f580010485a110d1d5d5807181a06", 58)};
        int i = 0;
        while (i < 19) {
            try {
                Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(52, (Object) new Object[]{strArr[i]});
                if (o0Oo0OO00O0O000ooOO02 != null) {
                    String str = (String) o0Oo0OO00O0O000ooOO02;
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(String.valueOf(i), str);
                    }
                }
                i++;
            } catch (Exception unused) {
            }
        }
        if (jSONObject.length() > 0) {
            return jSONObject.toString();
        }
        return null;
    }

    public static String O0OoOo00O000() {
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("4e494c505b404b0c095746182964515b59595b4b6b7a5c514243", 121));
            Method declaredMethod = cls.getDeclaredMethod(o0Oo0OO00O0O000ooOO0("4c6e7f786f73624d5a6f65676765755544626f7c7d", 71), (Class[]) null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((Object) null, (Object[]) null);
            Field declaredField = cls.getDeclaredField(o0Oo0OO00O0O000ooOO0("4244477d67666778686b7a75757d6661", 95));
            declaredField.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) declaredField.get(invoke);
            return instrumentation.toString() + o0Oo0OO00O0O000ooOO0("0c", 44) + instrumentation.getClass().getName();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static String O0o0o0O0OOOooOo0OOoOOO() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(34, (Object) new Object[]{0});
            if (str != null && str.contains(o0Oo0OO00O0O000ooOO0("4c404e0f0343465a514a410601404e4c4043465b110f4e4d494250", 115))) {
                jSONObject.put(o0Oo0OO00O0O000ooOO0("42", 49), 1);
            }
        } catch (Throwable unused) {
        }
        if (ActivityManager.isUserAMonkey()) {
            try {
                jSONObject.put(o0Oo0OO00O0O000ooOO0("42", 37), 1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public static String O0o0o0O0ooOooOoo() {
        return (String) HelperJNI.o0Oo0OO00O0O000ooOO0(18, (Object) null);
    }

    public static String O0oOO0ooO() {
        String[] split;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        ArrayList arrayList = new ArrayList();
        try {
            int length = oO0oo00OooOooOOo.length;
            Iterator it = o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0().iterator();
            String str2 = "";
            if (it == null) {
                return str2;
            }
            ApplicationInfo applicationInfo = o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0().getApplicationInfo();
            if (applicationInfo != null) {
                str2 = applicationInfo.nativeLibraryDir;
                if (!TextUtils.isEmpty(str2)) {
                    str2 = str2.substring(1);
                    stringBuffer.append(str2);
                    stringBuffer.append(o0Oo0OO00O0O000ooOO0("0b72", 77));
                }
            }
            o0Oo0OO00O0O000ooOO0("016829", 10);
            o0Oo0OO00O0O000ooOO0("00642a3a3a", 16);
            o0Oo0OO00O0O000ooOO0("05", 68);
            o0Oo0OO00O0O000ooOO0("0c", 34);
            o0Oo0OO00O0O000ooOO0("0f21", 17);
            while (it.hasNext()) {
                String str3 = (String) it.next();
                if (!TextUtils.isEmpty(str3)) {
                    if (str3.contains(o0Oo0OO00O0O000ooOO0("016627", 4)) && str3.contains(o0Oo0OO00O0O000ooOO0("00551b0b0b", 33)) && (split = str3.split(o0Oo0OO00O0O000ooOO0("0f17", 39))) != null && split.length > 1 && !stringBuffer.toString().contains(split[1])) {
                        if (TextUtils.isEmpty(str2) || !split[1].startsWith(str2)) {
                            str = split[1] + o0Oo0OO00O0O000ooOO0("0c", 90);
                            if (!arrayList.contains(str)) {
                                stringBuffer.append(str);
                            }
                        } else {
                            str = split[1].replaceAll(str2, o0Oo0OO00O0O000ooOO0("05", 80)) + o0Oo0OO00O0O000ooOO0("0c", 62);
                            if (!arrayList.contains(str)) {
                                stringBuffer.append(str);
                            }
                        }
                        arrayList.add(str);
                    }
                    for (int i = 0; i < length; i++) {
                        if (str3.contains(oO0oo00OooOooOOo[i]) && !stringBuffer2.toString().contains(String.valueOf(i))) {
                            stringBuffer2.append(i);
                            stringBuffer2.append(o0Oo0OO00O0O000ooOO0("0c", 76));
                        }
                    }
                }
            }
            if (stringBuffer.toString().endsWith(o0Oo0OO00O0O000ooOO0("0b73", 76))) {
                stringBuffer.delete(0, stringBuffer.length());
            }
            return o0Oo0OO00O0O000ooOO0(stringBuffer2.toString(), stringBuffer.toString());
        } catch (Exception unused) {
        }
    }

    @Nullable
    private static ClassLoader O0oOoo0oOo() throws Exception {
        Field declaredField = Class.forName(o0Oo0OO00O0O000ooOO0("4e7c79656e757e39326f2e0e4564776c79755b5f7c7c757164", 76)).getDeclaredField(o0Oo0OO00O0O000ooOO0("5c2436161f19", 43));
        declaredField.setAccessible(true);
        Map map = (Map) declaredField.get((Object) null);
        for (String str : map.keySet()) {
            ClassLoader classLoader = ((IBinder) map.get(str)).getClass().getClassLoader();
            if (classLoader instanceof PathClassLoader) {
                return classLoader;
            }
        }
        return null;
    }

    public static String O0oOoooo0o0o0oOo() {
        int i = 0;
        try {
            File[] listFiles = new File(o0Oo0OO00O0O000ooOO0("003d6b6b3d2a60727e6b67773d3d6b6b667069232d72643b", 94)).listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i2 = 0;
                while (i < length) {
                    try {
                        if (listFiles[i].getName().matches(o0Oo0OO00O0O000ooOO0("71301e0823661019697b02", 50))) {
                            i2++;
                        }
                        i++;
                    } catch (Throwable unused) {
                    }
                }
                i = i2;
            }
        } catch (Throwable unused2) {
        }
        return i == 0 ? "" : String.valueOf(i);
    }

    public static String O0oo0OOOOoO(Context context) {
        return context != null ? context.getApplicationInfo().sourceDir : "";
    }

    public static String O0oo0o00oooo() {
        StringBuilder v;
        StringBuilder sb;
        int i;
        Object obj;
        String str = "";
        int i2 = 0;
        while (true) {
            String[] strArr = O0oo0o00oooo;
            if (i2 >= strArr.length) {
                return str;
            }
            if (new File(strArr[i2]).exists()) {
                if (i2 != 7) {
                    v = ba.v(str);
                    if (str.length() > 0) {
                        sb = new StringBuilder();
                        i = 115;
                    }
                    obj = Integer.valueOf(i2);
                    v.append(obj);
                    str = v.toString();
                    i2++;
                } else {
                    i2++;
                }
            } else if (i2 == 7) {
                v = ba.v(str);
                if (str.length() > 0) {
                    sb = new StringBuilder();
                    i = 23;
                }
                obj = Integer.valueOf(i2);
                v.append(obj);
                str = v.toString();
                i2++;
            } else {
                i2++;
            }
            sb.append(o0Oo0OO00O0O000ooOO0("03", i));
            sb.append(i2);
            obj = sb.toString();
            v.append(obj);
            str = v.toString();
            i2++;
        }
    }

    public static String OO0000O0Ooo0OO000oo() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long uptimeMillis = SystemClock.uptimeMillis();
        return o0Oo0OO00O0O000ooOO0(Long.valueOf(System.currentTimeMillis()), Long.valueOf(elapsedRealtime), Long.valueOf(uptimeMillis));
    }

    public static String OO000O0O0Oo() {
        String str = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(6, (Object) new Object[]{1});
        return str == null ? "" : str;
    }

    public static String OOOOO0o0ooo00oOo0(Context context) {
        return ooOO0Oo0o.o0Oo0OO00O0O000ooOO0(context);
    }

    public static String OOoOo00oo0Ooo0o0o0o000(Context context) {
        String o0Oo0OO00O0O000ooOO02 = o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("4b191b1f0c0100332e1f061d19332a1009041f13", 39));
        if (o0Oo0OO00O0O000ooOO02 == null) {
            o0Oo0OO00O0O000ooOO02 = "";
        }
        return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02, o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO02));
    }

    public static String Oo0O0Oo0OO0OOOoOO0O0() {
        return (String) HelperJNI.o0Oo0OO00O0O000ooOO0(19, (Object) null);
    }

    public static int Oo0OO00oooO0Ooo000ooOo(Context context) {
        return ((AudioManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("4e181d010a", 51))).getMode();
    }

    public static Integer Oo0o000OO() {
        String str = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(8, (Object) new Object[]{0});
        int parseInt = !TextUtils.isEmpty(str) ? Integer.parseInt(str) : 0;
        if (Debug.isDebuggerConnected()) {
            parseInt |= 32;
        }
        if (!com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().OO0000O0Ooo0OO000oo && parseInt != 0) {
            HelperJNI.o0Oo0OO00O0O000ooOO0(9, (Object) new Object[]{0});
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
        return Integer.valueOf(parseInt);
    }

    public static long OoOOooOoooOoo(Context context) {
        int i;
        int o00ooooooO00OO0O002 = oOOO0oO0O0Oo0.o00ooooooO00OO0O00();
        if ((OoOOooOoooOoo & 1) == 1) {
            return (long) o00ooooooO00OO0O002;
        }
        int o0O00o00OOoOo0oooOoo002 = oOOO0oO0O0Oo0.o0O00o00OOoOo0oooOoo00(context);
        int o0O00o00OOoOo0oooOoo003 = oOOO0oO0O0Oo0.o0O00o00OOoOo0oooOoo00();
        int oO00o0OooO0OO0o0000o2 = oOOO0oO0O0Oo0.oO00o0OooO0OO0o0000o();
        if ((oO00o0OooO0OO0o0000o2 & 8) == 0 && oOOO0oO0O0Oo0.O00OO0oOOooooO00000Oo() == 1) {
            oO00o0OooO0OO0o0000o2 |= 8;
        }
        int i2 = 0;
        Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(38, (Object) new Object[0]);
        if (o0Oo0OO00O0O000ooOO02 != null ? ((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue() : false) {
            Object o0Oo0OO00O0O000ooOO03 = HelperJNI.o0Oo0OO00O0O000ooOO0(39, (Object) new Object[0]);
            i = (o0Oo0OO00O0O000ooOO03 == null || !((Boolean) o0Oo0OO00O0O000ooOO03).booleanValue()) ? 16384 : 49152;
        } else {
            i = 0;
        }
        int i3 = oO0oOOOOoo() ? 65536 : 0;
        int i4 = OOOOO0o0ooo00oOo0() ? 16 : 0;
        int i5 = o0ooOoo0Oo00oOOO() ? 262144 : 0;
        int O0oOO0ooO2 = oOOO0oO0O0Oo0.O0oOO0ooO();
        if (o0oOO0oO00OoO0()) {
            i2 = 4194304;
        }
        return (long) (o0O00o00OOoOo0oooOoo002 | i4 | o0O00o00OOoOo0oooOoo003 | oO00o0OooO0OO0o0000o2 | o00ooooooO00OO0O002 | i | i3 | i5 | O0oOO0ooO2 | i2);
    }

    public static String o00ooooooO00OO0O00() {
        try {
            JSONObject jSONObject = new JSONObject();
            String[] strArr = {o0Oo0OO00O0O000ooOO0("5c0b565f1f1a060d161d", 47), o0Oo0OO00O0O000ooOO0("5c0a575615191d", 46), o0Oo0OO00O0O000ooOO0("5c28756a2d3c3c373f31", 12)};
            String[] strArr2 = {o0Oo0OO00O0O000ooOO0("4e", 31), o0Oo0OO00O0O000ooOO0("4d", 47), o0Oo0OO00O0O000ooOO0("4c", 36)};
            for (int i = 0; i < 3; i++) {
                Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(52, (Object) new Object[]{strArr[i]});
                if (o0Oo0OO00O0O000ooOO02 != null) {
                    String str = (String) o0Oo0OO00O0O000ooOO02;
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put(strArr2[i], str);
                    }
                }
            }
            return jSONObject.toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static int o0O00o00OOoOo0oooOoo00(Context context, LocationManager locationManager) {
        if (!com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o00ooooooO00OO0O00) {
            return -1;
        }
        boolean o0Oo0OO00O0O000ooOO02 = O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("4e72776b607b703723686a6279677d677b7c3d127f7d7b6b7d716171736e7c6b676e7e717f68607b7c", 66), o0Oo0OO00O0O000ooOO0("4e72776b607b703723686a6279677d677b7c3d127f7d7b6b7d7164727a76676e7e717f68607b7c", 66));
        int i = (locationManager.isProviderEnabled(o0Oo0OO00O0O000ooOO0("480410", 44)) || locationManager.isProviderEnabled(o0Oo0OO00O0O000ooOO0("41302a38232622", 4))) ? 1 : 0;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            return i | 2;
        }
        if (o0Oo0OO00O0O000ooOO02) {
            i |= 2;
        }
        return (i2 <= 28 || !O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("4e686d717a616a2d39727078637d677d6166270865676171676b7a64656f6b727a7d7c6d7c74646b65727a6166", 88))) ? i : i | 4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r4 = O0oOoo0oOo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r4 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        r2 = o0Oo0OO00O0O000ooOO0("4b357f682939206c7b3b3e222932397e623c2b2822357e5e15293c2b28223512042f393736", 11);
        r5 = r4.loadClass(r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0O0o0ooOOo0oO0() throws java.lang.Throwable {
        /*
            r0 = 0
            r1 = 1
            java.lang.String r2 = "4b367c6b2a3a236f78383d212a313a7d613f282b21367d411f282b213611072c3a3435"
            r3 = 8
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            r3 = 0
            java.lang.ClassLoader r4 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ Exception -> 0x0026 }
            java.lang.Class r5 = r4.loadClass(r2)     // Catch:{ Exception -> 0x0024 }
            if (r5 == 0) goto L_0x0016
            goto L_0x003c
        L_0x0016:
            java.lang.NullPointerException r6 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0028 }
            java.lang.String r7 = "4c0a08170529022d1a19130423351e080607404c1f564b1e1c05"
            r8 = 58
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r8)     // Catch:{ Exception -> 0x0028 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0028 }
            throw r6     // Catch:{ Exception -> 0x0028 }
        L_0x0024:
            r5 = r3
            goto L_0x0028
        L_0x0026:
            r4 = r3
            r5 = r4
        L_0x0028:
            java.lang.ClassLoader r4 = O0oOoo0oOo()     // Catch:{ all -> 0x003b }
            if (r4 == 0) goto L_0x003c
            java.lang.String r6 = "4b357f682939206c7b3b3e222932397e623c2b2822357e5e15293c2b28223512042f393736"
            r7 = 11
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x003b }
            java.lang.Class r5 = r4.loadClass(r2)     // Catch:{ all -> 0x003b }
            goto L_0x003c
        L_0x003b:
        L_0x003c:
            if (r4 == 0) goto L_0x0040
            if (r5 != 0) goto L_0x004a
        L_0x0040:
            java.lang.Class r5 = java.lang.Class.forName(r2)     // Catch:{ all -> 0x0049 }
            java.lang.ClassLoader r4 = r5.getClassLoader()     // Catch:{ all -> 0x0049 }
            goto L_0x004a
        L_0x0049:
        L_0x004a:
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x0186
            if (r5 != 0) goto L_0x0052
            goto L_0x0186
        L_0x0052:
            java.lang.reflect.Field[] r7 = r5.getDeclaredFields()     // Catch:{ Exception -> 0x0079 }
            int r8 = r7.length     // Catch:{ Exception -> 0x0079 }
            r9 = 0
        L_0x0058:
            if (r9 >= r8) goto L_0x0098
            r10 = r7[r9]     // Catch:{ Exception -> 0x0079 }
            java.lang.String r11 = "5c04183f3b313e16172e233834181d323f313c3d3727"
            java.lang.String r11 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r0)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r12 = r10.getName()     // Catch:{ Exception -> 0x0079 }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x0079 }
            if (r11 == 0) goto L_0x007b
            java.lang.String r7 = "5c1e0225212b240c0d3439222e020728252b26272d3d"
            r8 = 26
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r8)     // Catch:{ Exception -> 0x0079 }
        L_0x0074:
            java.lang.reflect.Field r5 = r5.getDeclaredField(r7)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0099
        L_0x0079:
            goto L_0x00a5
        L_0x007b:
            java.lang.String r11 = "477770747e715958616c777b57527d707e73727868"
            r12 = 79
            java.lang.String r11 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r12)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r10 = r10.getName()     // Catch:{ Exception -> 0x0079 }
            boolean r10 = r11.equals(r10)     // Catch:{ Exception -> 0x0079 }
            if (r10 == 0) goto L_0x0096
            java.lang.String r7 = "473235313b341c1d2429323e121738353b36373d2d"
            r8 = 10
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r8)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0074
        L_0x0096:
            int r9 = r9 + r1
            goto L_0x0058
        L_0x0098:
            r5 = r3
        L_0x0099:
            if (r5 == 0) goto L_0x00a5
            r5.setAccessible(r1)     // Catch:{ Exception -> 0x0079 }
            java.lang.Object r5 = r5.get(r3)     // Catch:{ Exception -> 0x0079 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0079 }
            goto L_0x00a6
        L_0x00a5:
            r5 = r3
        L_0x00a6:
            if (r5 != 0) goto L_0x00a9
            return r6
        L_0x00a9:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o r6 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o
            r6.<init>()
            r6.o0Oo0OO00O0O000ooOO0()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0181 }
            r7.<init>()     // Catch:{ Exception -> 0x0181 }
            r7.append(r2)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r2 = "0b2b6053457a6d756957515d7a70514a5d4d7b7a5d"
            r8 = 115(0x73, float:1.61E-43)
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r8)     // Catch:{ Exception -> 0x0181 }
            r7.append(r2)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0181 }
            java.lang.Class r2 = r4.loadClass(r2)     // Catch:{ Exception -> 0x0181 }
            java.lang.String r4 = "48293a0c16243a28302c30"
            r7 = 20
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r7)     // Catch:{ Exception -> 0x0181 }
            java.lang.reflect.Method r4 = r2.getDeclaredMethod(r4, r3)     // Catch:{ Exception -> 0x0181 }
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ Exception -> 0x0181 }
            r7.<init>()     // Catch:{ Exception -> 0x0181 }
            java.util.Set r5 = r5.entrySet()     // Catch:{ Exception -> 0x0181 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0181 }
        L_0x00e5:
            boolean r8 = r5.hasNext()     // Catch:{ Exception -> 0x0181 }
            if (r8 == 0) goto L_0x0173
            java.lang.Object r8 = r5.next()     // Catch:{ Exception -> 0x0181 }
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8     // Catch:{ Exception -> 0x0181 }
            java.lang.Object r9 = r8.getKey()     // Catch:{ Exception -> 0x0181 }
            java.lang.reflect.Member r9 = (java.lang.reflect.Member) r9     // Catch:{ Exception -> 0x0181 }
            boolean r10 = r9 instanceof java.lang.reflect.Method     // Catch:{ Exception -> 0x0181 }
            if (r10 == 0) goto L_0x0119
            int r10 = r7.size()     // Catch:{ Exception -> 0x0181 }
            r11 = 50
            if (r10 >= r11) goto L_0x0119
            java.lang.String r10 = r7.toString()     // Catch:{ Exception -> 0x0181 }
            int r10 = r10.length()     // Catch:{ Exception -> 0x0181 }
            r11 = 5000(0x1388, float:7.006E-42)
            if (r10 >= r11) goto L_0x0119
            r10 = r9
            java.lang.reflect.Method r10 = (java.lang.reflect.Method) r10     // Catch:{ Exception -> 0x0181 }
            java.lang.String r10 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oOO0OooO0.o0Oo0OO00O0O000ooOO0(r10)     // Catch:{ Exception -> 0x0181 }
            r7.add(r10)     // Catch:{ Exception -> 0x0181 }
        L_0x0119:
            java.lang.Object r8 = r8.getValue()     // Catch:{ Exception -> 0x0181 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0181 }
            int r9 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0((java.lang.String) r9)     // Catch:{ Exception -> 0x0181 }
            r10 = -1
            if (r9 == r10) goto L_0x00e5
            boolean r10 = r2.isInstance(r8)     // Catch:{ Exception -> 0x0181 }
            if (r10 == 0) goto L_0x0135
            java.lang.Object r8 = r4.invoke(r8, r3)     // Catch:{ Exception -> 0x0181 }
            java.lang.Object[] r8 = (java.lang.Object[]) r8     // Catch:{ Exception -> 0x0181 }
            goto L_0x0141
        L_0x0135:
            boolean r10 = r8 instanceof java.util.TreeSet     // Catch:{ Exception -> 0x0181 }
            if (r10 == 0) goto L_0x0140
            java.util.TreeSet r8 = (java.util.TreeSet) r8     // Catch:{ Exception -> 0x0181 }
            java.lang.Object[] r8 = r8.toArray()     // Catch:{ Exception -> 0x0181 }
            goto L_0x0141
        L_0x0140:
            r8 = r3
        L_0x0141:
            if (r8 != 0) goto L_0x0144
            goto L_0x00e5
        L_0x0144:
            int r10 = r8.length     // Catch:{ Exception -> 0x0181 }
            r11 = 0
        L_0x0146:
            if (r11 >= r10) goto L_0x00e5
            r12 = r8[r11]     // Catch:{ Exception -> 0x0181 }
            java.lang.Class r12 = r12.getClass()     // Catch:{ Exception -> 0x0181 }
            java.lang.ClassLoader r12 = r12.getClassLoader()     // Catch:{ Exception -> 0x0181 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0181 }
            java.lang.String r13 = new java.lang.String     // Catch:{ Exception -> 0x0181 }
            byte[] r14 = new byte[r1]     // Catch:{ Exception -> 0x0181 }
            r15 = 34
            r14[r0] = r15     // Catch:{ Exception -> 0x0181 }
            r13.<init>(r14)     // Catch:{ Exception -> 0x0181 }
            java.lang.String[] r14 = r12.split(r13)     // Catch:{ Exception -> 0x0181 }
            int r14 = r14.length     // Catch:{ Exception -> 0x0181 }
            if (r14 <= r1) goto L_0x0171
            java.lang.String[] r12 = r12.split(r13)     // Catch:{ Exception -> 0x0181 }
            r12 = r12[r1]     // Catch:{ Exception -> 0x0181 }
            r6.o0Oo0OO00O0O000ooOO0(r12, r9)     // Catch:{ Exception -> 0x0181 }
        L_0x0171:
            int r11 = r11 + r1
            goto L_0x0146
        L_0x0173:
            java.lang.String r2 = r6.toString()     // Catch:{ Exception -> 0x0181 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0181 }
            r1[r0] = r7     // Catch:{ Exception -> 0x0181 }
            r0 = 57
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r0, (java.lang.Object) r1)     // Catch:{ Exception -> 0x0181 }
            goto L_0x0185
        L_0x0181:
            java.lang.String r2 = r6.toString()
        L_0x0185:
            return r2
        L_0x0186:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooOoOooO.o0Oo0O0o0ooOOo0oO0():java.lang.String");
    }

    public static String o0Oo0OO00O0O000ooOO0() {
        return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("1a20242427", 4), o0Oo0OO00O0O000ooOO0("4e4a4f53584348", 122));
    }

    public static String o0oOO0oO00OoO0(Context context) {
        try {
            return o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("4e0b0e121902093f3209", 59));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String o0ooO0o000Oo0Oo0O0() {
        String[] strArr = {o0Oo0OO00O0O000ooOO0("7f7c435258485e4243", 97), o0Oo0OO00O0O000ooOO0("670a303530353034", 28), o0Oo0OO00O0O000ooOO0("4238313b337674353632", 5)};
        Map map = (Map) o00ooooooO00OO0O00.O0oOO0ooO(o00ooooooO00OO0O00.o00ooooooO00OO0O00[0], new oO0o0oOoOO0OO(strArr));
        String o0Oo0OO00O0O000ooOO02 = o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("005b0d0d5b4c0614180d01115b5b0d0d00160f454b14025d4b140242184b140214131013594b14021b000f0e37350b1e203e131013", 56));
        String O0oOoooo0o0o0oOo2 = O0oOoooo0o0o0oOo();
        if (map.isEmpty() || map.size() < 2) {
            return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02, null, null, O0oOoooo0o0o0oOo2);
        }
        return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02, map.get(strArr[0]), map.get(strArr[1]), O0oOoooo0o0o0oOo2);
    }

    public static String o0ooOoo0Oo00oOOO(Context context) {
        TimeZone timeZone = TimeZone.getDefault();
        String id = timeZone != null ? timeZone.getID() : "";
        String language = Locale.getDefault().getLanguage();
        String o0Oo0OO00O0O000ooOO02 = o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("5c707177606b515d707b6e6f7c7a6b7660", 95));
        int parseInt = !TextUtils.isEmpty(o0Oo0OO00O0O000ooOO02) ? Integer.parseInt(o0Oo0OO00O0O000ooOO02) : 0;
        if (parseInt < 0) {
            parseInt = -1;
        } else if (parseInt > 255) {
            parseInt = 256;
        }
        return o0Oo0OO00O0O000ooOO0(id, language, Integer.valueOf(parseInt));
    }

    public static int oO00o0OooO0OO0o0000o() {
        return oO0OOO00() ? 1 : 0;
    }

    public static String oO0OOO00(Context context) {
        return O0oOO0ooO.o0Oo0OO00O0O000ooOO0(context);
    }

    public static String oO0oOOOOoo(Context context) {
        String str;
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter(o0Oo0OO00O0O000ooOO0("4e484d515a414a0d00405d564c5d1d0845505a4146072b44524756504c415b4c4e484e4546", 120)), o0Oo0OO00O0O000ooOO0("4c3f31706d26242c372933293532737f232e3d3634312134696923", 12), (Handler) null);
        if (registerReceiver == null) {
            return o0Oo0OO00O0O000ooOO0(null, null, null);
        }
        int intExtra = registerReceiver.getIntExtra(o0Oo0OO00O0O000ooOO0("5c1f0d0d191e", 39), 0);
        int intExtra2 = registerReceiver.getIntExtra(o0Oo0OO00O0O000ooOO0("43776d6d77", 65), 0);
        int intExtra3 = registerReceiver.getIntExtra(o0Oo0OO00O0O000ooOO0("5b445d4840424640545242", 106), 0);
        int i = 59;
        int i2 = -1;
        int intExtra4 = registerReceiver.getIntExtra(o0Oo0OO00O0O000ooOO0("5f181d16040605", 59), -1);
        if (Build.VERSION.SDK_INT >= 34) {
            i2 = registerReceiver.getIntExtra(o0Oo0OO00O0O000ooOO0("4e35302c273c37707b26677127363c29755720203533202636202120", 5), -1);
        }
        String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("5a4759595d4445", 99);
        if (intExtra == 1) {
            str = "5a312f2f2b3233";
            i = 21;
        } else if (intExtra == 2) {
            str = "4c0f0d17110a030d";
        } else if (intExtra == 3) {
            str = "4b091e140f0d17110a030d";
        } else if (intExtra != 4) {
            if (intExtra == 5) {
                str = "495f554c";
                i = 115;
            }
            HelperJNI.o0Oo0OO00O0O000ooOO0(45, (Object) new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra4)});
            return o0Oo0OO00O0O000ooOO0(Integer.valueOf(intExtra2), o0Oo0OO00O0O000ooOO02, Integer.valueOf(intExtra3), Integer.valueOf(i2));
        } else {
            str = "41011b54430b0913150e0709";
            i = 63;
        }
        o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0(str, i);
        HelperJNI.o0Oo0OO00O0O000ooOO0(45, (Object) new Object[]{Integer.valueOf(intExtra), Integer.valueOf(intExtra4)});
        return o0Oo0OO00O0O000ooOO0(Integer.valueOf(intExtra2), o0Oo0OO00O0O000ooOO02, Integer.valueOf(intExtra3), Integer.valueOf(i2));
    }

    public static String oO0oo00OooOooOOo() {
        long j;
        long j2;
        long j3;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(18)) {
            j2 = (long) statFs.getBlockSize();
            j = (long) statFs.getAvailableBlocks();
            j3 = (long) statFs.getBlockCount();
        } else {
            j2 = statFs.getBlockSizeLong();
            j = statFs.getAvailableBlocksLong();
            j3 = statFs.getBlockCountLong();
        }
        return o0Oo0OO00O0O000ooOO0(Long.valueOf(j3 * j2), Long.valueOf(j * j2));
    }

    private static JSONObject oOO0Oo000oOO00oo0o0(Context context) {
        Object obj;
        try {
            Field declaredField = Class.forName(o0Oo0OO00O0O000ooOO0("4e37322e253e35727a3b343a2d253e39785a1b343a2d253e391b1437373e3a2f", 7)).getDeclaredField(o0Oo0OO00O0O000ooOO0("4268604152495c50", 105));
            declaredField.setAccessible(true);
            obj = declaredField.get(context.getSystemService(o0Oo0OO00O0O000ooOO0("4376797760687374", 74)));
        } catch (Throwable unused) {
            obj = null;
        }
        Class<?> cls = obj != null ? obj.getClass() : null;
        Class<?> cls2 = obj instanceof Proxy ? Proxy.getInvocationHandler(obj).getClass() : null;
        try {
            JSONObject jSONObject = new JSONObject();
            if (cls != null && !o0Oo0OO00O0O000ooOO0("4e55504c475c5710185956584f475c5b1a3d5f7956584f475c5b797655555c584d0c2d7d5b4d1c2e78474d5b", 101).equals(cls.getName())) {
                jSONObject.put(o0Oo0OO00O0O000ooOO0("5c5a5b4853464a", 115), cls.getName());
            }
            if (cls2 != null) {
                jSONObject.put(o0Oo0OO00O0O000ooOO0("475c5a5f5d5c42", 106), cls2.getName());
            }
            if (jSONObject.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(o0Oo0OO00O0O000ooOO0("4338", 24), jSONObject);
            return jSONObject2;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static Integer oOO0OooO0(Context context) {
        return Integer.valueOf(Integer.parseInt(o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("4e2e2d161120242825222a", 20), o0Oo0OO00O0O000ooOO0("1f", 27))));
    }

    public static int oOOO00oO00o0oOoOo(Context context) {
        return context.getResources().getConfiguration().keyboard;
    }

    public static Object ooOo0oO0O000o0O0O00oo(Context context) {
        OO0000O0Ooo0OO000oo o0Oo0OO00O0O000ooOO02 = OO0000O0Ooo0OO000oo.o0Oo0OO00O0O000ooOO0();
        O00OO0oOOooooO00000Oo o0O00o00OOoOo0oooOoo002 = o0Oo0OO00O0O000ooOO02.o0O00o00OOoOo0oooOoo00(context);
        if (o0O00o00OOoOo0oooOoo002 != null) {
            HelperJNI.o0Oo0OO00O0O000ooOO0(63, (Object) new Object[]{o0O00o00OOoOo0oooOoo002.o0Oo0OO00O0O000ooOO0(), o0O00o00OOoOo0oooOoo002.o0O00o00OOoOo0oooOoo00(), o0O00o00OOoOo0oooOoo002.oO00o0OooO0OO0o0000o()});
        }
        return o0Oo0OO00O0O000ooOO02.o0Oo0OO00O0O000ooOO0(context);
    }

    public static String ooOoOooO() {
        long mobileRxBytes = TrafficStats.getMobileRxBytes();
        long mobileTxBytes = TrafficStats.getMobileTxBytes();
        long totalTxBytes = TrafficStats.getTotalTxBytes();
        long totalRxBytes = TrafficStats.getTotalRxBytes();
        return String.format(Locale.US, o0Oo0OO00O0O000ooOO0("0a513d7c513d7c513d7c51", 47), new Object[]{Long.valueOf(mobileRxBytes), Long.valueOf(mobileTxBytes), Long.valueOf(totalTxBytes), Long.valueOf(totalRxBytes)});
    }

    public static String ooooOO0OO0O0OOoo() {
        String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("7420", 25);
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo oO0000O0Ooo0OO000oo = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4c6967263f636263627564636f7f7f6364252a6a6f737863682f38736e787978392c3b652d2d3b65732d652d73732d3b732d2d4b6978", 90));
        return oO0000O0Ooo0OO000oo != null ? oO0000O0Ooo0OO000oo.o0O00o00OOoOo0oooOoo00() : o0Oo0OO00O0O000ooOO02;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0(r2) != false) goto L_0x003c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String O00OO0oOOooooO00000Oo(android.content.Context r6) {
        /*
            java.lang.String r0 = "5f7b7b3b"
            r1 = 68
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            java.util.Map r6 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0((android.content.Context) r6, (java.lang.String) r0)
            java.lang.String r0 = ""
            if (r6 == 0) goto L_0x0033
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x0033
            java.lang.String r1 = "5f484808"
            r2 = 119(0x77, float:1.67E-43)
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r2)
            java.lang.Object r1 = r6.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "5b617b"
            r3 = 95
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            java.lang.Object r2 = r6.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0035
        L_0x0033:
            r1 = r0
            r2 = r1
        L_0x0035:
            java.lang.String r3 = "03"
            if (r1 != 0) goto L_0x003e
            if (r2 == 0) goto L_0x003c
            goto L_0x003e
        L_0x003c:
            r2 = r0
            goto L_0x0074
        L_0x003e:
            boolean r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r1)
            if (r4 == 0) goto L_0x0045
            r1 = r0
        L_0x0045:
            boolean r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r1)
            if (r4 == 0) goto L_0x0052
            boolean r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r2)
            if (r1 == 0) goto L_0x0074
            goto L_0x003c
        L_0x0052:
            java.lang.StringBuilder r1 = defpackage.ba.v(r1)
            boolean r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r2)
            if (r4 == 0) goto L_0x005e
            r2 = r0
            goto L_0x006d
        L_0x005e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = 84
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)
            java.lang.String r2 = defpackage.ba.r(r4, r5, r2)
        L_0x006d:
            r1.append(r2)
            java.lang.String r2 = r1.toString()
        L_0x0074:
            boolean r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r2)
            if (r1 != 0) goto L_0x00cd
            java.lang.String r1 = "5f4242022d704e505a"
            r4 = 125(0x7d, float:1.75E-43)
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r4)
            java.lang.Object r1 = r6.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r4 = "5b041e343709171d"
            r5 = 58
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r5)
            java.lang.Object r6 = r6.get(r4)
            java.lang.String r6 = (java.lang.String) r6
            boolean r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r1)
            if (r4 == 0) goto L_0x009d
            r1 = r0
        L_0x009d:
            boolean r4 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r6)
            if (r4 == 0) goto L_0x00a4
            r6 = r0
        L_0x00a4:
            java.lang.StringBuilder r4 = defpackage.ba.v(r1)
            boolean r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r1)
            if (r1 == 0) goto L_0x00b0
            r0 = r6
            goto L_0x00c6
        L_0x00b0:
            boolean r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r6)
            if (r1 == 0) goto L_0x00b7
            goto L_0x00c6
        L_0x00b7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 43
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r1)
            java.lang.String r0 = defpackage.ba.r(r0, r1, r6)
        L_0x00c6:
            r4.append(r0)
            java.lang.String r0 = r4.toString()
        L_0x00cd:
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r1 = 0
            r6[r1] = r2
            r1 = 1
            r6[r1] = r0
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.Object[]) r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooOoOooO.O00OO0oOOooooO00000Oo(android.content.Context):java.lang.String");
    }

    public static String O0OOO0O0OO0oO0oOoO000(Context context) {
        JSONArray jSONArray = new JSONArray();
        JSONObject oOO0Oo000oOO00oo0o0 = oOO0Oo000oOO00oo0o0(context);
        if (oOO0Oo000oOO00oo0o0 != null) {
            jSONArray.put(oOO0Oo000oOO00oo0o0);
        }
        JSONObject O0oo0OOOOoO = O0oo0OOOOoO();
        if (O0oo0OOOOoO != null) {
            jSONArray.put(O0oo0OOOOoO);
        }
        return jSONArray.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012 A[SYNTHETIC, Splitter:B:10:0x0012] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String O0OoOo00O000(android.content.Context r16) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0250 }
            r2 = 26
            r3 = 1
            if (r1 < r2) goto L_0x000f
            java.lang.Class<java.lang.ClassLoader> r1 = java.lang.ClassLoader.class
            java.util.ArrayList r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0((java.lang.Class) r1, (boolean) r3)     // Catch:{ all -> 0x000e }
            goto L_0x0010
        L_0x000e:
        L_0x000f:
            r1 = 0
        L_0x0010:
            if (r1 == 0) goto L_0x0250
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0250 }
            r2.<init>()     // Catch:{ all -> 0x0250 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x0250 }
            r4.<init>()     // Catch:{ all -> 0x0250 }
            r5 = 0
            r6 = 0
        L_0x001e:
            int r7 = r1.size()     // Catch:{ all -> 0x0250 }
            r8 = 57
            if (r6 >= r7) goto L_0x01ea
            int r7 = r4.size()     // Catch:{ all -> 0x01e5 }
            r9 = 25
            if (r7 < r9) goto L_0x0030
            goto L_0x01ea
        L_0x0030:
            java.lang.Object r7 = r1.get(r6)     // Catch:{ all -> 0x01e5 }
            java.lang.ClassLoader r7 = (java.lang.ClassLoader) r7     // Catch:{ all -> 0x01e5 }
            java.lang.Class r9 = r7.getClass()     // Catch:{ all -> 0x01e5 }
            java.lang.String r9 = r9.getName()     // Catch:{ all -> 0x01e5 }
            java.lang.String r10 = "45627e7e262b64666020054469725e46647b69564a676c687e"
            r11 = 86
            java.lang.String r10 = o0Oo0OO00O0O000ooOO0((java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x01e5 }
            boolean r10 = r9.equals(r10)     // Catch:{ all -> 0x01e5 }
            if (r10 == 0) goto L_0x004e
            goto L_0x01e5
        L_0x004e:
            java.lang.String r10 = "4b0f071015084f5700000d1b02496629181c2b2b17312507180a3529040f0b1d"
            r12 = 53
            java.lang.String r10 = o0Oo0OO00O0O000ooOO0((java.lang.String) r10, (int) r12)     // Catch:{ all -> 0x01e5 }
            java.lang.Class r10 = java.lang.Class.forName(r10, r5, r7)     // Catch:{ all -> 0x01e5 }
            java.lang.String r13 = "5f1b1f162e2f100d"
            java.lang.String r12 = o0Oo0OO00O0O000ooOO0((java.lang.String) r13, (int) r12)     // Catch:{ all -> 0x01e5 }
            java.lang.reflect.Field r10 = r10.getDeclaredField(r12)     // Catch:{ all -> 0x01e5 }
            r10.setAccessible(r3)     // Catch:{ all -> 0x01e5 }
            java.lang.Object r7 = r10.get(r7)     // Catch:{ all -> 0x01e5 }
            java.lang.Class r10 = r7.getClass()     // Catch:{ all -> 0x01e5 }
            java.lang.String r12 = "4b6d71514565646467766b"
            r13 = 83
            java.lang.String r12 = o0Oo0OO00O0O000ooOO0((java.lang.String) r12, (int) r13)     // Catch:{ all -> 0x01e5 }
            java.lang.reflect.Field r12 = r10.getDeclaredField(r12)     // Catch:{ all -> 0x01e5 }
            r12.setAccessible(r3)     // Catch:{ all -> 0x01e5 }
            java.lang.Object r12 = r12.get(r7)     // Catch:{ all -> 0x01e5 }
            java.lang.Object[] r12 = (java.lang.Object[]) r12     // Catch:{ all -> 0x01e5 }
            java.lang.String r13 = "41263c34363a000c22393a3a221404323e2f3e323432253f"
            r14 = 22
            java.lang.String r13 = o0Oo0OO00O0O000ooOO0((java.lang.String) r13, (int) r14)     // Catch:{ all -> 0x01e5 }
            java.lang.reflect.Field r13 = r10.getDeclaredField(r13)     // Catch:{ all -> 0x01e5 }
            r13.setAccessible(r3)     // Catch:{ all -> 0x01e5 }
            java.lang.Object r13 = r13.get(r7)     // Catch:{ all -> 0x01e5 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = "5c10101d0b1239350f070509333f110a0909112737010d1c0d010701160c"
            r15 = 37
            java.lang.String r14 = o0Oo0OO00O0O000ooOO0((java.lang.String) r14, (int) r15)     // Catch:{ all -> 0x01e5 }
            java.lang.reflect.Field r10 = r10.getDeclaredField(r14)     // Catch:{ all -> 0x01e5 }
            r10.setAccessible(r3)     // Catch:{ all -> 0x01e5 }
            java.lang.Object r7 = r10.get(r7)     // Catch:{ all -> 0x01e5 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x01e5 }
            int r10 = r12.length     // Catch:{ all -> 0x01e5 }
            if (r10 != 0) goto L_0x00bf
            int r10 = r13.size()     // Catch:{ all -> 0x01e5 }
            if (r10 != 0) goto L_0x00bf
            int r10 = r7.size()     // Catch:{ all -> 0x01e5 }
            if (r10 != 0) goto L_0x00bf
            goto L_0x01e5
        L_0x00bf:
            java.lang.String r10 = java.util.Arrays.toString(r12)     // Catch:{ all -> 0x01e5 }
            java.lang.Object[] r12 = r13.toArray()     // Catch:{ all -> 0x01e5 }
            java.lang.String r12 = java.util.Arrays.toString(r12)     // Catch:{ all -> 0x01e5 }
            java.lang.Object[] r7 = r7.toArray()     // Catch:{ all -> 0x01e5 }
            java.lang.String r7 = java.util.Arrays.toString(r7)     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = r16.getPackageName()     // Catch:{ all -> 0x01e5 }
            boolean r15 = r12.contains(r14)     // Catch:{ all -> 0x01e5 }
            if (r15 == 0) goto L_0x00ed
            java.lang.String r15 = "402a227e752834282b21367d75283423"
            r0 = 8
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r15, (int) r0)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r9.contains(r0)     // Catch:{ all -> 0x01e5 }
            if (r0 != 0) goto L_0x00ed
            goto L_0x01e5
        L_0x00ed:
            java.lang.String r0 = "4b0e061114094e5601010c1a0348753a1e17202406190b3428050e0a1c"
            r15 = 52
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r15)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r0.equals(r9)     // Catch:{ all -> 0x01e5 }
            r5 = 109(0x6d, float:1.53E-43)
            if (r0 == 0) goto L_0x0161
            boolean r0 = r10.contains(r14)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0105
            goto L_0x01e5
        L_0x0105:
            java.lang.String r0 = "743406101c0d1c1016005209070774"
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r15)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r10.equals(r0)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0113
            goto L_0x01e5
        L_0x0113:
            java.lang.String r0 = "5c585855435a101b46415e5a404a4f4b16"
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r5)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r10.contains(r0)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0121
            goto L_0x01e5
        L_0x0121:
            java.lang.String r0 = "002177777a6c753f336c7d22"
            r14 = 66
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r14)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r10.contains(r0)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0131
            goto L_0x01e5
        L_0x0131:
            java.lang.String r0 = "00257867716b6c6d21346b7a25"
            r14 = 69
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r14)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r10.contains(r0)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0141
            goto L_0x01e5
        L_0x0141:
            java.lang.String r0 = "004a1c1c11071e5449140b1d0700014d"
            r14 = 41
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r14)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r12.contains(r0)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0151
            goto L_0x01e5
        L_0x0151:
            java.lang.String r0 = "00287e7e73657c464e69782f"
            r14 = 75
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r14)     // Catch:{ all -> 0x01e5 }
            boolean r0 = r12.contains(r0)     // Catch:{ all -> 0x01e5 }
            if (r0 == 0) goto L_0x0161
            goto L_0x01e5
        L_0x0161:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            r0.<init>()     // Catch:{ all -> 0x01e5 }
            r0.append(r9)     // Catch:{ all -> 0x01e5 }
            java.lang.String r14 = "15134d534f6f7b5b5a5a5948551c"
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r14, (int) r5)     // Catch:{ all -> 0x01e5 }
            r0.append(r5)     // Catch:{ all -> 0x01e5 }
            r0.append(r10)     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = "034409131b19152f230d1615150d3b2b1d1100111d1b1d0a1048"
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r8)     // Catch:{ all -> 0x01e5 }
            r0.append(r5)     // Catch:{ all -> 0x01e5 }
            r0.append(r12)     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = "033663636e78614a467c74767a404c62797a7a625444727e6f7e727472657f27"
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r11)     // Catch:{ all -> 0x01e5 }
            r0.append(r5)     // Catch:{ all -> 0x01e5 }
            r0.append(r7)     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = "52"
            r7 = 33
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r7)     // Catch:{ all -> 0x01e5 }
            r0.append(r5)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = "4b040c1b1e03445c0b0b061009426626222909031c0a3c201c3a2e0c13013e220f040016"
            r7 = 62
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r7)     // Catch:{ all -> 0x01e5 }
            boolean r5 = r5.equals(r9)     // Catch:{ all -> 0x01e5 }
            if (r5 == 0) goto L_0x01c7
            boolean r5 = r13.isEmpty()     // Catch:{ all -> 0x01e5 }
            if (r5 == 0) goto L_0x01c7
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e5 }
            r0.<init>()     // Catch:{ all -> 0x01e5 }
            r0.append(r9)     // Catch:{ all -> 0x01e5 }
            java.lang.String r5 = "15247a6478584c6c6d6d6e7f622b036314276a70787a764c406e7576766e58487e7263727e787e69732b0363143a6f6f62746d464a70787a764c406e7576766e58487e7263727e787e69732b036345"
            r7 = 90
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r7)     // Catch:{ all -> 0x01e5 }
            r0.append(r5)     // Catch:{ all -> 0x01e5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01e5 }
        L_0x01c7:
            boolean r5 = r4.containsKey(r0)     // Catch:{ all -> 0x01e5 }
            if (r5 == 0) goto L_0x01e0
            java.lang.Object r5 = r4.get(r0)     // Catch:{ all -> 0x01e5 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x01e5 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x01e5 }
            int r5 = r5 + r3
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01e5 }
        L_0x01dc:
            r4.put(r0, r5)     // Catch:{ all -> 0x01e5 }
            goto L_0x01e5
        L_0x01e0:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01e5 }
            goto L_0x01dc
        L_0x01e5:
            int r6 = r6 + 1
            r5 = 0
            goto L_0x001e
        L_0x01ea:
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0250 }
            if (r0 != 0) goto L_0x0250
            java.util.Set r0 = r4.entrySet()     // Catch:{ all -> 0x0250 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0250 }
        L_0x01f8:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0250 }
            java.lang.String r4 = "0c"
            if (r1 == 0) goto L_0x0235
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0250 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0250 }
            java.lang.Object r5 = r1.getKey()     // Catch:{ all -> 0x0250 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0250 }
            r2.append(r5)     // Catch:{ all -> 0x0250 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0250 }
            r5.<init>()     // Catch:{ all -> 0x0250 }
            java.lang.String r6 = "12"
            r7 = 17
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x0250 }
            r5.append(r6)     // Catch:{ all -> 0x0250 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0250 }
            r5.append(r1)     // Catch:{ all -> 0x0250 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x0250 }
            r2.append(r1)     // Catch:{ all -> 0x0250 }
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r8)     // Catch:{ all -> 0x0250 }
            r2.append(r1)     // Catch:{ all -> 0x0250 }
            goto L_0x01f8
        L_0x0235:
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0250 }
            r1 = 99
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r1)     // Catch:{ all -> 0x0251 }
            boolean r1 = r0.endsWith(r1)     // Catch:{ all -> 0x0251 }
            if (r1 == 0) goto L_0x0251
            int r1 = r0.length()     // Catch:{ all -> 0x0251 }
            int r1 = r1 - r3
            r2 = 0
            java.lang.String r0 = r0.substring(r2, r1)     // Catch:{ all -> 0x0251 }
            goto L_0x0251
        L_0x0250:
            r0 = 0
        L_0x0251:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooOoOooO.O0OoOo00O000(android.content.Context):java.lang.String");
    }

    public static String O0o0o0O0OOOooOo0OOoOOO(Context context) {
        return o0Oo0OO00O0O000ooOO0(oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0(context));
    }

    public static String O0o0o0O0ooOooOoo(Context context) {
        return com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().OOOOO0o0ooo00oOo0;
    }

    public static String O0oOO0ooO(Context context) {
        Map o0Oo0OO00O0O000ooOO02 = oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("4e1d10", 47));
        return (o0Oo0OO00O0O000ooOO02 == null || o0Oo0OO00O0O000ooOO02.isEmpty()) ? "" : (String) o0Oo0OO00O0O000ooOO02.get(o0Oo0OO00O0O000ooOO0("4e2b26", 25));
    }

    public static String O0oOoo0oOo(Context context) {
        try {
            Display[] displays = ((DisplayManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("4b5c4b524d5c49", 110))).getDisplays();
            if (displays == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= displays.length) {
                    break;
                }
                Display display = displays[i];
                if (display != null) {
                    sb.append(display.getName());
                    sb.append(o0Oo0OO00O0O000ooOO0("0c", 96));
                    sb2.append(display.getFlags());
                    sb2.append(o0Oo0OO00O0O000ooOO0("0c", 101));
                    sb3.append(o0Oo0OO00O0O000ooOO0(display));
                    sb3.append(o0Oo0OO00O0O000ooOO0("0c", 10));
                    i2++;
                    if (i2 == 10) {
                        break;
                    }
                }
                i++;
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            if (sb3.length() > 0) {
                sb3.deleteCharAt(sb3.length() - 1);
            }
            return String.format(Locale.US, o0Oo0OO00O0O000ooOO0("0a451c4a451c4a520b4a45", 44), new Object[]{sb, sb2, Integer.valueOf(displays.length), sb3});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String O0oOoooo0o0o0oOo(Context context) {
        String o0Oo0OO00O0O000ooOO02 = OO0oo0ooOO00OOO.o0Oo0OO00O0O000ooOO0().o0Oo0OO00O0O000ooOO0(context);
        if (o0Oo0OO00O0O000ooOO02 == null || o0Oo0OO00O0O000ooOO02.length() > 70) {
            return o0Oo0OO00O0O000ooOO02;
        }
        return null;
    }

    private static JSONObject O0oo0OOOOoO() {
        Object obj;
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("4e0e0b171c070c4b4e10015f6e23161c1e1e1c0c2c3d1b160504", 62));
            Method declaredMethod = cls.getDeclaredMethod(o0Oo0OO00O0O000ooOO0("487261544172787a7672585c7f7f767267", 79), (Class[]) null);
            declaredMethod.setAccessible(true);
            obj = declaredMethod.invoke(cls, (Object[]) null);
        } catch (Exception unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        try {
            Class<?> cls2 = obj instanceof Proxy ? Proxy.getInvocationHandler(obj).getClass() : null;
            JSONObject jSONObject = new JSONObject();
            if (!o0Oo0OO00O0O000ooOO0("4e06031f140f0443440508131802135357144a6e10380b01030f0b212506060f0b1e5f7e2e081e4f7d2b141e08", 54).equals(obj.getClass().getName())) {
                jSONObject.put(o0Oo0OO00O0O000ooOO0("5c414053485d51", 104), obj.getClass().getName());
            }
            if (cls2 != null) {
                jSONObject.put(o0Oo0OO00O0O000ooOO0("47383e3b393826", 14), cls2.getName());
            }
            if (jSONObject.length() <= 0) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(o0Oo0OO00O0O000ooOO0("5f49", 117), jSONObject);
            return jSONObject2;
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String OO0000O0Ooo0OO000oo(Context context) {
        return context.getFilesDir() != null ? context.getFilesDir().getAbsolutePath() : o0Oo0OO00O0O000ooOO0("4c5b564d464a5b0d1e55466578525e41607a4c0d565e1e4d04194c4e57", 104);
    }

    public static String OO000O0O0Oo(Context context) {
        return oOOO0oO0O0Oo0.oO00o0OooO0OO0o0000o(context);
    }

    private static boolean OOOOO0o0ooo00oOo0() {
        try {
            Class.forName(o0Oo0OO00O0O000ooOO0("421754460d13050402445402170003091e557422170003091e392f04121c1d", 32));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean OOoOo00oo0Ooo0o0o0o000() {
        String str = Build.BRAND;
        String str2 = Build.MODEL;
        if (o0Oo0OO00O0O000ooOO0("5c657b69716c7e", 72).equals(str)) {
            return !o0Oo0OO00O0O000ooOO0("7c047a766b191b6e", 37).equals(str2) && !o0Oo0OO00O0O000ooOO0("7c7e000c1163611f", 95).equals(str2);
        }
        return true;
    }

    public static String Oo0O0Oo0OO0OOOoOO0O0(Context context) {
        String str;
        String str2;
        int i;
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("5f0c13151f", 43));
        if (O0oOoooo0o0o0oOo.o0O00o00OOoOo0oooOoo00(23)) {
            int intValue = ((Integer) o00ooooooO00OO0O00.o0O00o00OOoOo0oooOoo00(o00ooooooO00OO0O00.o0O00o00OOoOo0oooOoo00[0], new Oo0oOo00ooOo0OOO0oO0(telephonyManager))).intValue();
            String o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("024b", 107);
            if (!com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().Oo0o000OO || !O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(context)) {
                o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0("0235", 22);
            } else {
                O0oOO0ooO o0oOO0ooO = (O0oOO0ooO) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4c5a54150c505150514657505c4c4c50571619595c404b505b1c0a415253424e51575d1d1f08561e1e0856401e561e40401e08401e1e785b54", 105));
                if (o0oOO0ooO != null) {
                    o0Oo0OO00O0O000ooOO02 = o0oOO0ooO.o0Oo0OO00O0O000ooOO0(context);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(intValue);
            str = ba.r(sb, o0Oo0OO00O0O000ooOO0("53", 11), o0Oo0OO00O0O000ooOO02);
            JSONArray jSONArray = new JSONArray();
            if (intValue > 2) {
                intValue--;
            }
            for (int i2 = 0; i2 < intValue; i2++) {
                try {
                    i = telephonyManager.getSimState(i2);
                } catch (Throwable unused) {
                    i = -1;
                }
                jSONArray.put(i);
            }
            str2 = jSONArray.toString();
        } else {
            str = o0Oo0OO00O0O000ooOO0("0250", 115);
            str2 = "";
        }
        return o0Oo0OO00O0O000ooOO0(str, str2);
    }

    public static boolean Oo0o000OO(Context context) {
        return Integer.parseInt(o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(context, o0Oo0OO00O0O000ooOO0("42303e3a0601313e30272f3433", 13), o0Oo0OO00O0O000ooOO0("1f", 66))) != 0;
    }

    public static String OoOOooOoooOoo() {
        String[] strArr = {o0Oo0OO00O0O000ooOO0("7f053a2b2131273b3a", 24), o0Oo0OO00O0O000ooOO0("67251f1a1f1a1f1b", 51), o0Oo0OO00O0O000ooOO0("422d242e266361202327", 16)};
        Map map = (Map) o00ooooooO00OO0O00.O0oOO0ooO(o00ooooooO00OO0O00.o00ooooooO00OO0O00[0], new oOO0Oo000oOO00oo0o0(strArr));
        if (map != null) {
            return (String) map.get(strArr[2]);
        }
        return null;
    }

    public static String o00ooooooO00OO0O00(Context context) {
        String[] strArr = {o0Oo0OO00O0O000ooOO0("4c3937767a3931727f242f2933302130202422696e29", 10), o0Oo0OO00O0O000ooOO0("4c727c3d31727a393c736a6573757b766f7863", 65), o0Oo0OO00O0O000ooOO0("4c2d23626e2d25667c2b362c26303b3d213736253e2b2737", 30), o0Oo0OO00O0O000ooOO0("4c707e3f3072656c6a7b697e7464213a7b7e74", 67), o0Oo0OO00O0O000ooOO0("4c444a0b044651585e4f5d4a40501511564f4243504c5d474d41404447474e4a5f", 119), o0Oo0OO00O0O000ooOO0("4c6769282765727b7d6c7e69637336367d7a6b766c627f", 84), o0Oo0OO00O0O000ooOO0("4c2729686725323b3d2c3e292333766725323b3d2c3e292333342827293e362d2a3529363234262a3c", 20), o0Oo0OO00O0O000ooOO0("4c595716195b4c45435240575d4d081a44555643445548525c41", 106), o0Oo0OO00O0O000ooOO0("4c313f7e7133242d2b3a283f352560712c3a2f343e353c2a", 2), o0Oo0OO00O0O000ooOO0("4c383677783a2d24223321363c2c6958053303183634383b3e001629383222342829", 11), o0Oo0OO00O0O000ooOO0("4c656b2a256770797f6e7c6b61713434282b", 86), o0Oo0OO00O0O000ooOO0("4c414f0e0143545d5b4a584f455510105b5c4c48", 114), o0Oo0OO00O0O000ooOO0("4c232d6c6a2521302a6a2f2e3075322720353227203239382b3c38", 16), o0Oo0OO00O0O000ooOO0("4c202e6f69372625716a212530393b3d2a27363d3b", 19), o0Oo0OO00O0O000ooOO0("4c3c3273753a3e2f357530312f6a2d383f2a2d383f373438", 15), o0Oo0OO00O0O000ooOO0("4c0806474b0b0e121902094e4e0517170d071b190c0f1e2f2812150419030d10", 59), o0Oo0OO00O0O000ooOO0("4c4e40010d4d48545f444f08084351514b415d5f4a4958", 125), o0Oo0OO00O0O000ooOO0("4c3638797535302c273c3770772c3c3d21383b39363837336d", 5), o0Oo0OO00O0O000ooOO0("4c5a54151d4b4f5a4b4a5f1d19595c404b505b1c19474f4c", 105), o0Oo0OO00O0O000ooOO0("4c5b55141e555c4043554c4a5156170a5152424050514140", 104), o0Oo0OO00O0O000ooOO0("4c0f01404a0108141701181e0502434e0c061a110e0d101517011e1402", 60), o0Oo0OO00O0O000ooOO0("4c1c12534b065d461012194d551e0c0b1d1e0306", 47), o0Oo0OO00O0O000ooOO0("4c3c32736b267d66303239", 15), o0Oo0OO00O0O000ooOO0("4c7779383775626b303d666f74722d7d62347d797061", 68), o0Oo0OO00O0O000ooOO0("4c191756591b0c055e5308011a1c43130c5718010e181e1802", 42), o0Oo0OO00O0O000ooOO0("4c010f4e4103141d464b101902045b0b144a0905", 50), o0Oo0OO00O0O000ooOO0("4c79773636717f64686c6a6e732f3c67697874", 74), o0Oo0OO00O0O000ooOO0("4c28266767202e35393d3b3f227e6728373d2a35", 27), o0Oo0OO00O0O000ooOO0("4c414f0e0e49475c505452564b170e454555514945", 114), o0Oo0OO00O0O000ooOO0("4c581512484e55564a080d4e161758414e585e5842", 106), o0Oo0OO00O0O000ooOO0("4c266b6c36302b2834767330687529363c2a", 20), o0Oo0OO00O0O000ooOO0("4c5a17104a4c5754480a0f4c140a4b5e4548594b4c5a594441", 104), o0Oo0OO00O0O000ooOO0("4c54191e4442595a4604164e4b50554a405748", 102), o0Oo0OO00O0O000ooOO0("4c1c12534d1a0d5a771418", 47), o0Oo0OO00O0O000ooOO0("4c3a34757a3d383f372160792736686b312d2b217d703a", 9), o0Oo0OO00O0O000ooOO0("4c313f7e713633343c2a6b7f3029263036302a", 2), o0Oo0OO00O0O000ooOO0("4c797736397e7b7c7462233a64752b2b6d72747e", 74), o0Oo0OO00O0O000ooOO0("4c030d4c430401060e1859401e0f514f0e180419180b100509", 48), o0Oo0OO00O0O000ooOO0("4c252b6a6626233f342f246369283e212c2f32", 22), o0Oo0OO00O0O000ooOO0("4c7c7233367978747c66667f302e75766b", 79), o0Oo0OO00O0O000ooOO0("424a09044b4a464e0d044f4b5e514449585355", 125), o0Oo0OO00O0O000ooOO0("4226656827262a2261612124383328232b3c2e343429", 17), o0Oo0OO00O0O000ooOO0("4c0d0342581f060b171c1756430c151a0c0a0c16", 62), o0Oo0OO00O0O000ooOO0("4c020c4d571009041813185953080b1b1909081819", 49), o0Oo0OO00O0O000ooOO0("4c46480913544d405c575c1d08475e514741475d", 117), o0Oo0OO00O0O000ooOO0("4c7e70312b6c7578646f642535767a", 77), o0Oo0OO00O0O000ooOO0("4c4648090545405c574c47000d4d505b5d56454708004750495647521d075c4b51504b1001425253475f574c4b0a0142520f4b", 117), o0Oo0OO00O0O000ooOO0("4c0e00414d0d08141f040f48490a1a1b0f17191f5e5f1c00060c1313140505", 61), o0Oo0OO00O0O000ooOO0("4c7b75343e757c6063756c6a7176373e757c606a", 72), o0Oo0OO00O0O000ooOO0("4c3b3574723d392832723736286d2a3f382d2a3f3830333f", 8), o0Oo0OO00O0O000ooOO0("4c6e6021387f6a6d787f6a6d2225666a", 93), o0Oo0OO00O0O000ooOO0("4c767839396262622138776e617771776d", 69), o0Oo0OO00O0O000ooOO0("45535a504349551a1757524e455e5548494f47", 103), o0Oo0OO00O0O000ooOO0("422e6d642f7b3069292c303b202b2334263c3c21", 25), o0Oo0OO00O0O000ooOO0("4c606e2f3a777f7061743b3a77636178776167617b", 83), o0Oo0OO00O0O000ooOO0("4c1d13525e1e1b111a1b074c531c050a1c1a1c06", 46), o0Oo0OO00O0O000ooOO0("40333b67673b392a3b3c3a293233746121243379613f2e332c2f29333533", 17), o0Oo0OO00O0O000ooOO0("407a722e2e727063727573607b7a3d28686d7a3020636f", 88), o0Oo0OO00O0O000ooOO0("4c434d0c174957484e444d4949490007485f495d48", 112), o0Oo0OO00O0O000ooOO0("4c262869673039286c62252f23222625252c283d", 21), o0Oo0OO00O0O000ooOO0("4c5d53121c4b4253171b514c", 110), o0Oo0OO00O0O000ooOO0("4c676928267178692d227c68", 84), o0Oo0OO00O0O000ooOO0("4c292766683f3627636f25387278353432252e383e223e", 26), o0Oo0OO00O0O000ooOO0("4c505e1f11464f5e1a134d5c41504f45524d", 99), o0Oo0OO00O0O000ooOO0("4c77793839757d31317b666b7f73", 68), o0Oo0OO00O0O000ooOO0("4c505e1f1052454c1714535955545053535a5e4b", 99), o0Oo0OO00O0O000ooOO0("4c5d5312135c5e5354415d0a125d42485f40", 110), o0Oo0OO00O0O000ooOO0("4c2f2160653e372c2a6a64272b", 28), o0Oo0OO00O0O000ooOO0("4c343a7b7325233e31383d3037353e73623e2b37252d373d31", 7), o0Oo0OO00O0O000ooOO0("4c0b054450171f1f0f080e4e48021510080a0106101116071a000e", 56), o0Oo0OO00O0O000ooOO0("4c2f21607b38213f7e7f3e212b3e", 28), o0Oo0OO00O0O000ooOO0("4c6967263d7e67793828707e6977657f7f62706a7f", 90), o0Oo0OO00O0O000ooOO0("4c0907465d1e07195848101e1b0f0f02140d1c1e0506", 58)};
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        for (int i = 0; i < 73; i++) {
            try {
                if (Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, strArr[i]) != null) {
                    arrayList.add(Integer.valueOf(i));
                }
            } catch (Throwable unused) {
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        if (arrayList.size() <= 10) {
            return arrayList.toString();
        }
        OoOOooOoooOoo |= 1;
        return "";
    }

    public static String o0O00o00OOoOo0oooOoo00() {
        String str = "";
        String lowerCase = (TextUtils.isEmpty(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().oOO0OooO0) || com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().oOO0OooO0.length() != 64) ? str : com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().oOO0OooO0.toLowerCase();
        if (!TextUtils.isEmpty(com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().oO0oo00OooOooOOo) && com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().oO0oo00OooOooOOo.length() == 64) {
            str = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().oO0oo00OooOooOOo.toLowerCase();
        }
        return o0Oo0OO00O0O000ooOO0(lowerCase, str);
    }

    public static String o0Oo0O0o0ooOOo0oO0(Context context) {
        try {
            Set<String> keySet = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.keySet();
            if (keySet != null) {
                return TextUtils.join(o0Oo0OO00O0O000ooOO0("0c", 52), keySet);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context) {
        return o0Oo0OO00O0O000ooOO0(OO000O0O0Oo.o0Oo0OO00O0O000ooOO0(context), Integer.valueOf(OO000O0O0Oo.o0Oo0OO00O0O000ooOO0()), OO000O0O0Oo.o0O00o00OOoOo0oooOoo00());
    }

    public static boolean o0oOO0oO00OoO0() {
        Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(84, (Object) new Object[]{23});
        if (o0Oo0OO00O0O000ooOO02 != null) {
            return ((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue();
        }
        return false;
    }

    public static String o0ooO0o000Oo0Oo0O0(Context context) {
        return O0o0o0O0OOOooOo0OOoOOO.o0Oo0OO00O0O000ooOO0().o0Oo0OO00O0O000ooOO0(context);
    }

    public static boolean o0ooOoo0Oo00oOOO() {
        Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(68, (Object) new Object[]{22});
        if (o0Oo0OO00O0O000ooOO02 != null) {
            return ((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue();
        }
        return false;
    }

    public static Integer oO00o0OooO0OO0o0000o(Context context, WifiManager wifiManager) {
        String str;
        int i = 3;
        if (!com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o00ooooooO00OO0O00 || !O0oOoooo0o0o0oOo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0("4e07021e150e0542561d1f170c1208120e0948670a080e1e08041404061b091e121b0b040a1d150e09", 55), o0Oo0OO00O0O000ooOO0("4e7d78646f747f382c67656d766872687473321d70727464727e6b7d75796861717e70676f7473", 77))) {
            str = "";
        } else {
            String[] strArr = o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0;
            str = (String) o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(strArr[3], (InvokeHandler) new O0OOO0O0OO0oO0oOoO000((WifiInfo) o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(strArr[0], (InvokeHandler) new OOo0o00oOO00o00o(wifiManager))));
        }
        PackageManager packageManager = context.getPackageManager();
        if (Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("4c377a602b2c3d273d7a7d272b2c3d273d", 5)) != null) {
            i = 1;
        } else if (!TextUtils.isEmpty(str) && str.contains(o0Oo0OO00O0O000ooOO0("400309171e111f", 35))) {
            i = 2;
        } else if (Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("4c232d6c753e242229243575763d3e3e3928", 16)) == null && Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("4c2927667f342e28232e3f7f7c37343433227f78392c373a2b393e282b3633", 26)) == null) {
            i = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(packageManager, str) ? 4 : oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0(packageManager) ? 5 : com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.ooOoOooO.o0Oo0OO00O0O000ooOO0(str) ? 6 : o0ooO0o000Oo0Oo0O0.o0Oo0OO00O0O000ooOO0(context, str) ? 7 : O0o0o0O0ooOooOoo.o0Oo0OO00O0O000ooOO0() ? 8 : (Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("4c2a24656b29253c376c642b323d2b2d2b3167", 25)) == null && Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("4c6f6120216b29346f787e64787e74", 92)) == null && Oo0o000OO.o0Oo0OO00O0O000ooOO0(packageManager, o0Oo0OO00O0O000ooOO0("4c2b2564652f6d702b3c3a313023382d21", 24)) == null) ? -1 : 23;
        }
        return Integer.valueOf(i);
    }

    private static boolean oO0OOO00() {
        try {
            Class<?> cls = Class.forName(o0Oo0OO00O0O000ooOO0("4c3e3071742f2624203e756f383835233a715e052e373a130f", 13));
            return o0Oo0OO00O0O000ooOO0("47647e726f6c7a", 82).equals(cls.getMethod(o0Oo0OO00O0O000ooOO0("486073595e5352716d68", 93), (Class[]) null).invoke(cls, (Object[]) null));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean oO0oOOOOoo() {
        Object o0Oo0OO00O0O000ooOO02 = HelperJNI.o0Oo0OO00O0O000ooOO0(56, (Object) new Object[]{21});
        if (o0Oo0OO00O0O000ooOO02 != null) {
            return ((Boolean) o0Oo0OO00O0O000ooOO02).booleanValue();
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String oO0oo00OooOooOOo(android.content.Context r13) {
        /*
            r0 = 0
            r1 = 1
            boolean r2 = OOoOo00oo0Ooo0o0o0o000()
            r3 = 0
            if (r2 != 0) goto L_0x000a
            return r3
        L_0x000a:
            java.lang.String r2 = "5b0b52521614"
            r4 = 36
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r4)
            java.lang.String r2 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oO0oo00OooOooOOo.o0O00o00OOoOo0oooOoo00(r13, r2, r3)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            r5 = 79
            r6 = 76
            r7 = 57
            if (r4 != 0) goto L_0x005e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x005e }
            r4.<init>(r2)     // Catch:{ all -> 0x005e }
            java.lang.String r2 = "4b333a171328"
            r8 = 26
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r8)     // Catch:{ all -> 0x005e }
            java.lang.String r2 = r4.optString(r2)     // Catch:{ all -> 0x005e }
            java.lang.String r8 = "4b101934291f0b"
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r7)     // Catch:{ all -> 0x005e }
            java.lang.String r8 = r4.optString(r8)     // Catch:{ all -> 0x005e }
            java.lang.String r9 = "4b727b56487b7e"
            r10 = 91
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r10)     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r4.optString(r9)     // Catch:{ all -> 0x005e }
            java.lang.Object[] r9 = new java.lang.Object[r1]     // Catch:{ all -> 0x005e }
            r9[r0] = r4     // Catch:{ all -> 0x005e }
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r6, (java.lang.Object) r9)     // Catch:{ all -> 0x005e }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x005e }
            r4[r0] = r8     // Catch:{ all -> 0x005e }
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r5, (java.lang.Object) r4)     // Catch:{ all -> 0x005e }
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x005e }
            if (r4 != 0) goto L_0x005e
            return r2
        L_0x005e:
            int r2 = android.os.Build.VERSION.SDK_INT
            java.util.UUID r4 = new java.util.UUID
            r8 = -1301668207276963122(0xedef8ba979d64ace, double:-3.563403477674908E221)
            r10 = -6645017420763422227(0xa3c827dcd51d21ed, double:-2.5964014370906125E-136)
            r4.<init>(r8, r10)
            r8 = 28
            boolean r9 = android.media.MediaDrm.isCryptoSchemeSupported(r4)     // Catch:{ all -> 0x00f6 }
            if (r9 != 0) goto L_0x0078
            return r3
        L_0x0078:
            android.media.MediaDrm r9 = new android.media.MediaDrm     // Catch:{ all -> 0x00f6 }
            r9.<init>(r4)     // Catch:{ all -> 0x00f6 }
            java.lang.String r4 = "4b796b67727e48437f607c685455"
            r10 = 71
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r10)     // Catch:{ all -> 0x00f4 }
            byte[] r4 = r9.getPropertyByteArray(r4)     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = "5f312e2a2c2929353234343a0108342b37231f1e"
            r11 = 12
            java.lang.String r10 = o0Oo0OO00O0O000ooOO0((java.lang.String) r10, (int) r11)     // Catch:{ all -> 0x00f4 }
            byte[] r10 = r9.getPropertyByteArray(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.String r11 = "5c5e4e5e4f5355457d615b5b41"
            r12 = 119(0x77, float:1.67E-43)
            java.lang.String r11 = o0Oo0OO00O0O000ooOO0((java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x00f4 }
            java.lang.String r11 = r9.getPropertyString(r11)     // Catch:{ all -> 0x00f4 }
            java.lang.String r4 = com.trustdecision.android.shell.common.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(r4)     // Catch:{ all -> 0x00f4 }
            java.lang.String r10 = com.trustdecision.android.shell.common.O00OO0oOOooooO00000Oo.o0Oo0OO00O0O000ooOO0(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ all -> 0x00f4 }
            r12[r0] = r11     // Catch:{ all -> 0x00f4 }
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r6, (java.lang.Object) r12)     // Catch:{ all -> 0x00f4 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00f4 }
            r1[r0] = r10     // Catch:{ all -> 0x00f4 }
            com.trustdecision.android.shell.common.HelperJNI.o0Oo0OO00O0O000ooOO0((int) r5, (java.lang.Object) r1)     // Catch:{ all -> 0x00f4 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x00f4 }
            r0.<init>()     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = "4b020b262219"
            r5 = 43
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r5)     // Catch:{ all -> 0x00f4 }
            r0.put(r1, r4)     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = "4b5b527f625440"
            r5 = 114(0x72, float:1.6E-43)
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r5)     // Catch:{ all -> 0x00f4 }
            r0.put(r1, r10)     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = "4b1019342a191c"
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r7)     // Catch:{ all -> 0x00f4 }
            r0.put(r1, r11)     // Catch:{ all -> 0x00f4 }
            java.lang.String r1 = "5b075e5e1a18"
            r5 = 40
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r5)     // Catch:{ all -> 0x00f4 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00f4 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.oO0oo00OooOooOOo.o0Oo0OO00O0O000ooOO0(r13, r1, r0)     // Catch:{ all -> 0x00f4 }
            if (r2 < r8) goto L_0x00f0
            r9.release()
            goto L_0x00f3
        L_0x00f0:
            r9.release()
        L_0x00f3:
            return r4
        L_0x00f4:
            goto L_0x00f8
        L_0x00f6:
            r9 = r3
        L_0x00f8:
            if (r9 == 0) goto L_0x0105
            int r13 = android.os.Build.VERSION.SDK_INT
            if (r13 < r8) goto L_0x0102
            r9.release()
            goto L_0x0105
        L_0x0102:
            r9.release()
        L_0x0105:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooOoOooO.oO0oo00OooOooOOo(android.content.Context):java.lang.String");
    }

    public static String oOO0OooO0() {
        String str = "";
        try {
            oO0oOOOOoo oo0ooooooo = new oO0oOOOOoo((EGLContext) null, 2);
            oo0ooooooo.o0Oo0OO00O0O000ooOO0(EGL14.EGL_NO_SURFACE);
            String glGetString = GLES20.glGetString(7937);
            String glGetString2 = GLES20.glGetString(7936);
            String glGetString3 = GLES20.glGetString(7938);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(o0Oo0OO00O0O000ooOO0("5d667a7b70666666", 78), glGetString);
            jSONObject.put(o0Oo0OO00O0O000ooOO0("595840414056", 116), glGetString2);
            jSONObject.put(o0Oo0OO00O0O000ooOO0("593e3a", 18), glGetString3);
            str = jSONObject.toString();
            oo0ooooooo.o0Oo0OO00O0O000ooOO0();
            return str;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String oOOO00oO00o0oOoOo() {
        String str = (String) HelperJNI.o0Oo0OO00O0O000ooOO0(5, (Object) new Object[]{1});
        return str == null ? "" : str;
    }

    public static String ooOo0oO0O000o0O0O00oo() {
        return Locale.getDefault().getCountry();
    }

    @TargetApi(14)
    public static String ooOoOooO(Context context) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        ServiceInfo serviceInfo;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("4e12101606100a1b1b15150d1d", 47));
        PackageManager packageManager = context.getPackageManager();
        if (accessibilityManager == null || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() == 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AccessibilityServiceInfo resolveInfo : enabledAccessibilityServiceList) {
            ResolveInfo resolveInfo2 = resolveInfo.getResolveInfo();
            if (!(resolveInfo2 == null || (serviceInfo = resolveInfo2.serviceInfo) == null)) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!TextUtils.isEmpty(str2) && !hashSet.contains(str2)) {
                    hashSet.add(str2);
                    String charSequence = packageManager != null ? resolveInfo2.loadLabel(packageManager).toString() : "";
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(str);
                    arrayList2.add(str2);
                    arrayList2.add(charSequence);
                    arrayList.add(arrayList2.toString());
                }
            }
        }
        return arrayList.toString();
    }

    public static boolean ooooOO0OO0O0OOoo(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = (PackageInfo) o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(o00ooooooO00OO0O00.O0oOO0ooO[0], new O0oOoo0oOo(context));
        } catch (Throwable unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        int i = packageInfo.applicationInfo.flags;
        return ((i & 1) == 1) || ((i & 128) == 1);
    }

    public static String o0O00o00OOoOo0oooOoo00(Context context) {
        int i = Build.VERSION.SDK_INT;
        String str = Build.MODEL;
        if (str != null && str.length() > 30) {
            str = str.substring(0, 30);
        }
        String str2 = Build.BRAND;
        if (str2 != null && str2.length() > 30) {
            str2 = str2.substring(0, 30);
        }
        String str3 = Build.HARDWARE;
        if (str3 != null && str3.length() > 30) {
            str3 = str3.substring(0, 30);
        }
        return o0Oo0OO00O0O000ooOO0(Integer.valueOf(i), Build.VERSION.RELEASE, str, Build.PRODUCT, str2, "", Build.DISPLAY, Build.HOST, Build.DEVICE, str3, Build.TAGS, Build.FINGERPRINT);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, ActivityManager activityManager) {
        long j;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j2 = memoryInfo.availMem;
        if (O0oOoooo0o0o0oOo.o0O00o00OOoOo0oooOoo00(16)) {
            j = memoryInfo.totalMem;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(o0Oo0OO00O0O000ooOO0("6211310002222c34", 6));
            Map o0Oo0OO00O0O000ooOO02 = o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("0029746b7a3a347e7e72717e7f", 73), arrayList, o0Oo0OO00O0O000ooOO0("15", 20));
            j = !o0Oo0OO00O0O000ooOO02.isEmpty() ? (o0Oo0OO00O0O000ooOO02.get(o0Oo0OO00O0O000ooOO0("6256764745656b73", 65)) == null || "".equals(o0Oo0OO00O0O000ooOO02.get(o0Oo0OO00O0O000ooOO0("6205251416363820", 18)))) ? -1 : Long.parseLong(((String) o0Oo0OO00O0O000ooOO02.get(o0Oo0OO00O0O000ooOO0("622b0b3a3818160e", 60))).replaceAll(o0Oo0OO00O0O000ooOO0("737a0d", 93), "")) * 1024 : 0;
        }
        return o0Oo0OO00O0O000ooOO0(Long.valueOf(j), Long.valueOf(j2));
    }

    public static String oO00o0OooO0OO0o0000o(Context context) {
        String str;
        int i;
        if (O0oOoooo0o0o0oOo.o0O00o00OOoOo0oooOoo00(14)) {
            str = System.getProperty(o0Oo0OO00O0O000ooOO0("4744585c06065a454f59697f445f", 103));
            String property = System.getProperty(o0Oo0OO00O0O000ooOO0("472f33376d6d312e24321a0c2e35", 12));
            if (property == null || "".equals(property)) {
                property = o0Oo0OO00O0O000ooOO0("024d", 110);
            }
            i = Integer.parseInt(property);
        } else {
            String host = android.net.Proxy.getHost(context);
            i = android.net.Proxy.getPort(context);
            str = host;
        }
        if (O0oo0o00oooo.o0Oo0OO00O0O000ooOO0(str)) {
            return "";
        }
        StringBuilder v = ba.v(str);
        v.append(o0Oo0OO00O0O000ooOO0("15", 44));
        v.append(i);
        return v.toString();
    }

    public static String o0O00o00OOoOo0oooOoo00(Context context, WifiManager wifiManager) {
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o;
        if (!com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().o00ooooooO00OO0O00 || !O0oOoooo0o0o0oOo.o0O00o00OOoOo0oooOoo00(context, o0Oo0OO00O0O000ooOO0("4e17120e051e1552460d0f071c0218021e1958771a181e0e18140414160b190e020b1b141a0d051e19", 39), o0Oo0OO00O0O000ooOO0("4e4b4e525942490e1a51535b405e445e4245042b4644425244485d4b434f5e5747484651594245", 123)) || (oo00o0oooo0oo0o0000o = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.oO00o0OooO0OO0o0000o) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4c767839207c7d7c7d6a7b7c7060607c7b3a3575706c677c7730387976786f677c7b3a33247a3232247a6c327a326c6c32246c3232546271", 69))) == null) {
            return null;
        }
        return oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0(wifiManager);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, LocationManager locationManager) {
        com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.oO00o0OooO0OO0o0000o) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4c505e1f065a5b5a5b4c5d5a5646465a5d1c1353564a415a51161e5f505e49415a5d1c15025c1414025c4a145c144a4a14024a1414724457", 99));
        return oo00o0oooo0oo0o0000o != null ? oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0(context, locationManager) : "";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0OO00O0O000ooOO0(android.content.Context r5, android.net.ConnectivityManager r6) {
        /*
            java.lang.String[] r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo
            r1 = 0
            r0 = r0[r1]
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Oo0OO00oooO0Ooo000ooOo r2 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.Oo0OO00oooO0Ooo000ooOo
            r2.<init>(r6)
            java.lang.Object r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.oO00o0OooO0OO0o0000o(r0, r2)
            android.net.NetworkInfo r0 = (android.net.NetworkInfo) r0
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x006b
            int r3 = r0.getType()
            if (r3 != 0) goto L_0x0066
            java.lang.String r3 = "484c595a776d42"
            r4 = 100
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r4)
            java.util.Map r5 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0((android.content.Context) r5, (java.lang.String) r3)
            if (r5 == 0) goto L_0x003d
            boolean r3 = r5.isEmpty()
            if (r3 != 0) goto L_0x003d
            java.lang.String r2 = "48584d4e637956"
            r3 = 112(0x70, float:1.57E-43)
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            java.lang.Object r5 = r5.get(r2)
            r2 = r5
            java.lang.String r2 = (java.lang.String) r2
        L_0x003d:
            int r5 = r0.getSubtype()
            switch(r5) {
                case 1: goto L_0x0061;
                case 2: goto L_0x0061;
                case 3: goto L_0x005c;
                case 4: goto L_0x0061;
                case 5: goto L_0x005c;
                case 6: goto L_0x005c;
                case 7: goto L_0x005c;
                case 8: goto L_0x005c;
                case 9: goto L_0x005c;
                case 10: goto L_0x005c;
                case 11: goto L_0x0061;
                case 12: goto L_0x005c;
                case 13: goto L_0x0057;
                case 14: goto L_0x005c;
                case 15: goto L_0x005c;
                case 16: goto L_0x0061;
                case 17: goto L_0x0061;
                case 18: goto L_0x0052;
                case 19: goto L_0x0044;
                case 20: goto L_0x004d;
                default: goto L_0x0044;
            }
        L_0x0044:
            java.lang.String r5 = "7a001e1e1a0302"
            r0 = 36
        L_0x0048:
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r0)
            goto L_0x006c
        L_0x004d:
            java.lang.String r5 = "1a7b"
            r0 = 54
            goto L_0x0048
        L_0x0052:
            java.lang.String r5 = "66484d5b59"
            r0 = 105(0x69, float:1.47E-43)
            goto L_0x0048
        L_0x0057:
            java.lang.String r5 = "1b05"
            r0 = 73
            goto L_0x0048
        L_0x005c:
            java.lang.String r5 = "1c7a"
            r0 = 49
            goto L_0x0048
        L_0x0061:
            java.lang.String r5 = "1d19"
            r0 = 83
            goto L_0x0048
        L_0x0066:
            java.lang.String r5 = r0.getTypeName()
            goto L_0x006c
        L_0x006b:
            r5 = r2
        L_0x006c:
            o0Oo0OO00O0O000ooOO0((android.net.ConnectivityManager) r6)
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r1] = r2
            r0 = 1
            r6[r0] = r5
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.Object[]) r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooOoOooO.o0Oo0OO00O0O000ooOO0(android.content.Context, android.net.ConnectivityManager):java.lang.String");
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, ConnectivityManager connectivityManager, WifiManager wifiManager) {
        return oOOO0oO0O0Oo0.o0Oo0OO00O0O000ooOO0(context, connectivityManager, wifiManager);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0080, code lost:
        r2 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OoOOooOoooOoo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4c575918015d5c5d5c4b5a5d5141415d5a1b1454514d465d5611024554545b5c53521a12055b1313055b4d135b134d4d13054d131375534a", 100));
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0OO00O0O000ooOO0(android.content.Context r7, android.net.wifi.WifiManager r8) {
        /*
            java.lang.String[] r0 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0
            r1 = 2
            r2 = r0[r1]
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OOoOo00oo0Ooo0o0o0o000 r3 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.OOoOo00oo0Ooo0o0o0o000
            r3.<init>(r8)
            java.lang.Object r2 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (com.trustdecision.android.shell.inter.InvokeHandler) r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            java.lang.String r3 = "4e7b7e626972793e2a61636b706e746e7275341b7674726274787c6a7b7b627873616165"
            r4 = 75
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r4)
            boolean r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0((android.content.Context) r7, (java.lang.String) r3)
            java.lang.String r4 = ""
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            if (r3 == 0) goto L_0x0097
            if (r2 == 0) goto L_0x0097
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            boolean r2 = r2.o00ooooooO00OO0O00
            if (r2 == 0) goto L_0x0076
            r0 = r0[r5]
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oo0OOOOoO r2 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.O0oo0OOOOoO
            r2.<init>(r8)
            java.lang.Object r8 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (com.trustdecision.android.shell.inter.InvokeHandler) r2)
            android.net.wifi.WifiInfo r8 = (android.net.wifi.WifiInfo) r8
            java.lang.String r0 = "4e686d717a616a2d39727078637d677d6166270865676171676b7b6b697466717d74646b65727a6166"
            r2 = 88
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r2)
            java.lang.String r2 = "4e282d313a212a6d79323038233d273d2126674825272131272b3e28202c3d34242b25323a2126"
            r3 = 24
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            java.lang.String[] r0 = new java.lang.String[]{r0, r2}
            boolean r7 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oOoooo0o0o0oOo.o0O00o00OOoOo0oooOoo00(r7, r0)
            if (r7 == 0) goto L_0x0073
            java.lang.String r7 = "4c656b2a336f6e6f6e79686f6373736f68292666637f746f64232b6a656b7c746f6829203769212137697f2169217f7f21377f2121477162"
            r0 = 86
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r7, (int) r0)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00 r7 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r7)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.oO00o0OooO0OO0o0000o r7 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.oO00o0OooO0OO0o0000o) r7
            if (r7 == 0) goto L_0x0073
            java.lang.String r0 = r7.o0Oo0OO00O0O000ooOO0((android.net.wifi.WifiInfo) r8)
            java.lang.String r7 = r7.o0O00o00OOoOo0oooOoo00(r8)
            goto L_0x0078
        L_0x0073:
            r7 = r4
            r0 = r7
            goto L_0x0078
        L_0x0076:
            r8 = 0
            goto L_0x0073
        L_0x0078:
            com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0 r2 = com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo()
            boolean r2 = r2.Oo0O0Oo0OO0OOOoOO0O0
            if (r2 == 0) goto L_0x0095
            java.lang.String r2 = "4c575918015d5c5d5c4b5a5d5141415d5a1b1454514d465d5611024554545b5c53521a12055b1313055b4d135b134d4d13054d131375534a"
            r3 = 100
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o00ooooooO00OO0O00 r2 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(r2)
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OoOOooOoooOoo r2 = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OoOOooOoooOoo) r2
            if (r2 == 0) goto L_0x0095
            java.lang.String r8 = r2.o0Oo0OO00O0O000ooOO0((android.net.wifi.WifiInfo) r8, (java.lang.String) r4)
            goto L_0x009a
        L_0x0095:
            r8 = r4
            goto L_0x009a
        L_0x0097:
            r7 = r4
            r8 = r7
            r0 = r8
        L_0x009a:
            r2 = 6
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r4
            r3 = 1
            r2[r3] = r8
            r2[r1] = r0
            r8 = 3
            r2[r8] = r6
            r8 = 4
            r2[r8] = r6
            r8 = 5
            r2[r8] = r7
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.Object[]) r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00.ooOoOooO.o0Oo0OO00O0O000ooOO0(android.content.Context, android.net.wifi.WifiManager):java.lang.String");
    }

    public static String O0oo0o00oooo(Context context) {
        try {
            PackageInfo packageInfo = (PackageInfo) o00ooooooO00OO0O00.O00OO0oOOooooO00000Oo(o00ooooooO00OO0O00.O0oOO0ooO[0], new OOOOO0o0ooo00oOo0(context));
            long j = packageInfo.firstInstallTime;
            long j2 = packageInfo.lastUpdateTime;
            return String.valueOf(j) + o0Oo0OO00O0O000ooOO0("0c", 33) + String.valueOf(j2);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, WifiManager wifiManager, ConnectivityManager connectivityManager, TelephonyManager telephonyManager) {
        Context context2 = context;
        WifiManager wifiManager2 = wifiManager;
        String[] strArr = {o0Oo0OO00O0O000ooOO0("4e65607c776c6720347f7d756e706a706c6b2a167d6e6f7165726d6b6170666d7f7f7b", 85), o0Oo0OO00O0O000ooOO0("4e01041813080344501b19110a140e14080f4e72190a0b151413021f191201031d020915131d080c", 49), o0Oo0OO00O0O000ooOO0("4e4c49555e454e091d56545c475943594542032c41434555434f5a4c44485950404f41565e4542", 124), o0Oo0OO00O0O000ooOO0("4e74716d667d7631256e6c647f617b617d7a3b027e60666a616166776a6c67747668777c6066687d79", 68), o0Oo0OO00O0O000ooOO0("4e71746863787334206b69617a647e64787f3e1979646f6962756f", 65), o0Oo0OO00O0O000ooOO0("4e3c39252e353e796d26242c372933293532735c31333525333f3b2d3c3c253f34262622", 12), o0Oo0OO00O0O000ooOO0("4e64617d766d6621357e7c746f716b716d6a2b0c6c766c7e666b78647a6963616d697d", 84), o0Oo0OO00O0O000ooOO0("4e5c59454e555e190d46444c574953495552133f5d4a43424853484f", 108), o0Oo0OO00O0O000ooOO0("4e51544843585314004b49415a445e44585f1e315c5e58485e524252504d5f48444d5d525c4b43585f", 97), o0Oo0OO00O0O000ooOO0("4e43465a514a410612595b5348564c564a4d0c2042555c5d574c57505b50404d4c474a5b", 115), o0Oo0OO00O0O000ooOO0("4e383d212a313a7d69222028332d372d313677483327203c31293a37243826353f3d313521", 8), o0Oo0OO00O0O000ooOO0("4c7c7233397870787b793b3f7f7a666d767d3a397a6e2d2e65676f746a706a7671301f756b667d", 79), o0Oo0OO00O0O000ooOO0("4c525c1d17565e565557151151544843585314005c434741535f495f03174a4b16004b49415a445e44585f1e22495a5b45464a48495a41545848", 97)};
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            if (O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(context2, strArr[i3])) {
                i2 |= 1 << i3;
            }
        }
        try {
            BluetoothAdapter bluetoothAdapter = (BluetoothAdapter) o00ooooooO00OO0O00.O0oOO0ooO(o00ooooooO00OO0O00.o00ooooooO00OO0O00[1], new ooOo0oO0O000o0O0O00oo());
            if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
                i = 1;
            }
        } catch (Exception unused) {
        }
        boolean booleanValue = ((Boolean) o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0(o00ooooooO00OO0O00.o0Oo0OO00O0O000ooOO0[2], (InvokeHandler) new oO0OOO00(wifiManager2))).booleanValue();
        if (wifiManager2 != null && booleanValue) {
            i |= 2;
        }
        if (Build.VERSION.SDK_INT > 21) {
            TelephonyManager telephonyManager2 = (TelephonyManager) context2.getSystemService(o0Oo0OO00O0O000ooOO0("5f3d22242e", 26));
            try {
                Method declaredMethod = telephonyManager2.getClass().getDeclaredMethod(o0Oo0OO00O0O000ooOO0("48776445506060515e7a767b7c74", 74), (Class[]) null);
                if (declaredMethod != null && ((Boolean) declaredMethod.invoke(telephonyManager2, (Object[]) null)).booleanValue()) {
                    i |= 4;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            if (((Boolean) telephonyManager.getClass().getMethod(o0Oo0OO00O0O000ooOO0("4861725346767647486c606d6a62", 92), (Class[]) null).invoke(telephonyManager, (Object[]) null)).booleanValue()) {
                i |= 4;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return String.valueOf(i2) + o0Oo0OO00O0O000ooOO0("0c", 16) + String.valueOf(i);
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, TelephonyManager telephonyManager) {
        O0oOO0ooO o0oOO0ooO;
        if (!com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().Oo0o000OO) {
            return o0Oo0OO00O0O000ooOO0("", "", "", "", "", "", "", "", "", "", "", "", "");
        } else if (!O0oOoooo0o0o0oOo.o0Oo0OO00O0O000ooOO0(context) || (o0oOO0ooO = (O0oOO0ooO) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4c7f713029757475746372757969697572333c7c79656e757e392f647776676b747278383a2d733b3b2d73653b733b65653b2d653b3b5d7e71", 76))) == null) {
            Context context2 = context;
            TelephonyManager telephonyManager2 = telephonyManager;
            Map o0Oo0OO00O0O000ooOO02 = o00O0O0o00o.o0Oo0OO00O0O000ooOO0(context, telephonyManager);
            String[] strArr = o00O0O0o00o.o0O00o00OOoOo0oooOoo00;
            return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO02.get(strArr[1]), o0Oo0OO00O0O000ooOO02.get(strArr[2]), o0Oo0OO00O0O000ooOO02.get(strArr[3]), o0Oo0OO00O0O000ooOO02.get(strArr[4]), o0Oo0OO00O0O000ooOO02.get(strArr[5]), o0Oo0OO00O0O000ooOO02.get(strArr[6]), o0Oo0OO00O0O000ooOO02.get(strArr[7]), o0Oo0OO00O0O000ooOO02.get(strArr[8]), o0Oo0OO00O0O000ooOO02.get(strArr[9]), o0Oo0OO00O0O000ooOO02.get(strArr[10]), o0Oo0OO00O0O000ooOO02.get(strArr[11]), o0Oo0OO00O0O000ooOO02.get(strArr[12]), o0Oo0OO00O0O000ooOO02.get(strArr[15]));
        } else {
            Map o0Oo0OO00O0O000ooOO03 = o0oOO0ooO.o0Oo0OO00O0O000ooOO0(context, telephonyManager);
            if (o0Oo0OO00O0O000ooOO03 == null) {
                o0Oo0OO00O0O000ooOO03 = new HashMap();
            }
            String[] strArr2 = o00O0O0o00o.o0O00o00OOoOo0oooOoo00;
            return o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO03.get(strArr2[1]), o0Oo0OO00O0O000ooOO03.get(strArr2[2]), o0Oo0OO00O0O000ooOO03.get(strArr2[3]), o0Oo0OO00O0O000ooOO03.get(strArr2[4]), o0Oo0OO00O0O000ooOO03.get(strArr2[5]), o0Oo0OO00O0O000ooOO03.get(strArr2[6]), o0Oo0OO00O0O000ooOO03.get(strArr2[7]), o0Oo0OO00O0O000ooOO03.get(strArr2[8]), o0Oo0OO00O0O000ooOO03.get(strArr2[9]), o0Oo0OO00O0O000ooOO03.get(strArr2[10]), o0Oo0OO00O0O000ooOO03.get(strArr2[11]), o0Oo0OO00O0O000ooOO03.get(strArr2[12]), o0Oo0OO00O0O000ooOO03.get(strArr2[15]));
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Context context, String str) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(o0Oo0OO00O0O000ooOO0("4669706b6f455c667f726965", 81));
        if (inputMethodManager == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (InputMethodInfo next : inputMethodManager.getInputMethodList()) {
            StringBuilder sb = new StringBuilder();
            String packageName = next.getPackageName();
            String replace = next.getServiceName().replace(packageName, o0Oo0OO00O0O000ooOO0("00", 15));
            sb.append(packageName);
            sb.append(replace);
            if (!str.equals(sb.toString())) {
                arrayList.add(sb.toString());
            }
        }
        return arrayList.size() == 0 ? "" : TextUtils.join(o0Oo0OO00O0O000ooOO0("03", 33), arrayList);
    }

    public static String o0Oo0OO00O0O000ooOO0(SensorManager sensorManager, WindowManager windowManager) {
        if (com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.O00OO0oOOooooO00000Oo().O0o0o0O0ooOooOoo && sensorManager != null) {
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo oO0000O0Ooo0OO000oo = (com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.OO0000O0Ooo0OO000oo) com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0oOO0ooO.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4c0806475e020302031405020e1e1e0205444b0b0e121902094e59120f191819584d5a044c4c5a04124c044c12124c5a124c4c2a0819", 59));
            List oO00o0OooO0OO0o0000o2 = oO0000O0Ooo0OO000oo != null ? oO0000O0Ooo0OO000oo.oO00o0OooO0OO0o0000o(sensorManager) : null;
            if (oO00o0OooO0OO0o0000o2 != null) {
                HelperJNI.o0Oo0OO00O0O000ooOO0(42, (Object) new Object[]{oO00o0OooO0OO0o0000o2});
            }
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager.getDefaultDisplay();
        defaultDisplay.getRealMetrics(displayMetrics);
        return o0Oo0OO00O0O000ooOO0("", displayMetrics.widthPixels + o0Oo0OO00O0O000ooOO0("57", 8) + displayMetrics.heightPixels, oOOO0oO0O0Oo0.OO0000O0Ooo0OO000oo(), "", oOOO0oO0O0Oo0.OoOOooOoooOoo(), (String) HelperJNI.o0Oo0OO00O0O000ooOO0(71, (Object) null), displayMetrics.xdpi + o0Oo0OO00O0O000ooOO0("57", 27) + displayMetrics.ydpi, o0Oo0OO00O0O000ooOO0(defaultDisplay, displayMetrics.widthPixels, displayMetrics.heightPixels));
    }

    public static String o0Oo0OO00O0O000ooOO0(Display display) {
        try {
            Object invoke = Display.class.getDeclaredMethod(o0Oo0OO00O0O000ooOO0("481b08222100120e3b281b11131f1b32361511", 38), (Class[]) null).invoke(display, (Object[]) null);
            return invoke != null ? (String) invoke : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String o0Oo0OO00O0O000ooOO0(Display display, int i, int i2) {
        Display.Mode[] q;
        String str = null;
        if (Build.VERSION.SDK_INT >= 23 && (q = display.getSupportedModes()) != null) {
            float f = (float) (i * i2);
            for (Display.Mode mode : q) {
                if (mode != null) {
                    int c = mode.getPhysicalWidth();
                    int r = mode.getPhysicalHeight();
                    float f2 = (float) (c * r);
                    if (f2 >= f) {
                        str = c + o0Oo0OO00O0O000ooOO0("57", 47) + r;
                        f = f2;
                    }
                }
            }
        }
        return str;
    }

    public static String o0Oo0OO00O0O000ooOO0(com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        if (o0oo0oo00o0o000oooo0 == null || o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00() == null || o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00().o0Oo0OO00O0O000ooOO0() == null) {
            return null;
        }
        return o0oo0oo00o0o000oooo0.o0O00o00OOoOo0oooOoo00().o0Oo0OO00O0O000ooOO0().toString();
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 63);
            byte b2 = (byte) (bArr[0] ^ 47);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String o0Oo0OO00O0O000ooOO0(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                obj = "";
            }
            if (i != 0) {
                sb.append(o0Oo0OO00O0O000ooOO0("712a", 21));
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    private static void o0Oo0OO00O0O000ooOO0(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        int i = 6;
        if (Build.VERSION.SDK_INT < 23) {
            int type = connectivityManager.getActiveNetworkInfo().getType();
            if (type >= 0 && type <= 1) {
                i = type;
            }
            HelperJNI.o0Oo0OO00O0O000ooOO0(61, (Object) new Object[]{Integer.valueOf(i)});
            return;
        }
        try {
            networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (Exception unused) {
            networkCapabilities = null;
        }
        if (networkCapabilities == null) {
            HelperJNI.o0Oo0OO00O0O000ooOO0(61, (Object) new Object[]{-1});
            return;
        }
        if (networkCapabilities.hasTransport(0)) {
            i = 0;
        } else if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(5)) {
            i = 1;
        } else if (!networkCapabilities.hasCapability(12) || !networkCapabilities.hasCapability(16)) {
            i = 2;
        } else if (networkCapabilities.hasTransport(2)) {
            i = 3;
        } else if (networkCapabilities.hasTransport(3)) {
            i = 4;
        } else if (networkCapabilities.hasTransport(4)) {
            i = 5;
        }
        HelperJNI.o0Oo0OO00O0O000ooOO0(61, (Object) new Object[]{Integer.valueOf(i)});
    }
}
