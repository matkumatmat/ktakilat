package com.ktakilat.cbase.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ktakilat.cbase.http.phone.BatteryStatusInfo;
import com.ktakilat.cbase.ui.BaseApplication;
import java.lang.reflect.Field;
import java.util.List;

public class TelephonyUtils {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i]);
            int length = hexString.length();
            if (length == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(hexString);
            }
            if (length > 2) {
                hexString = hexString.substring(length - 2, length);
            }
            sb.append(hexString.toUpperCase());
            if (i < bArr.length - 1) {
                sb.append(':');
            }
        }
        return sb.toString();
    }

    public static String b(String str) {
        if (str.length() != 14) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < charArray.length; i3 += 2) {
            int parseInt = Integer.parseInt(String.valueOf(charArray[i3]));
            int parseInt2 = Integer.parseInt(String.valueOf(charArray[i3 + 1])) * 2;
            if (parseInt2 >= 10) {
                parseInt2 -= 9;
            }
            i2 += parseInt + parseInt2;
        }
        int i4 = i2 % 10;
        if (i4 != 0) {
            i = 10 - i4;
        }
        return str + "" + i + "";
    }

    public static BatteryStatusInfo c(BaseApplication baseApplication) {
        Intent intent;
        boolean z;
        boolean z2;
        boolean z3;
        BatteryStatusInfo batteryStatusInfo = null;
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            if (Build.VERSION.SDK_INT >= 33) {
                intent = baseApplication.registerReceiver((BroadcastReceiver) null, intentFilter, 1);
            } else {
                intent = baseApplication.registerReceiver((BroadcastReceiver) null, intentFilter);
            }
            int intExtra = intent.getIntExtra("plugged", -1);
            int intExtra2 = intent.getIntExtra("temperature", -1);
            BatteryStatusInfo batteryStatusInfo2 = new BatteryStatusInfo();
            boolean z4 = true;
            if (1 == intExtra) {
                z = true;
            } else {
                z = false;
            }
            try {
                batteryStatusInfo2.isAcCharge = z;
                if (2 == intExtra) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                batteryStatusInfo2.isUsbCharge = z2;
                if (4 == intExtra) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z && !z2) {
                    if (!z3) {
                        z4 = false;
                    }
                }
                batteryStatusInfo2.isCharging = z4;
                batteryStatusInfo2.level = intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0);
                batteryStatusInfo2.scale = intent.getIntExtra("scale", 0);
                batteryStatusInfo2.batteryTemperature = intExtra2;
                return batteryStatusInfo2;
            } catch (Exception e) {
                e = e;
                batteryStatusInfo = batteryStatusInfo2;
                e.printStackTrace();
                return batteryStatusInfo;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return batteryStatusInfo;
        }
    }

    public static String d() {
        Object invoke;
        try {
            if (Build.VERSION.SDK_INT < 23) {
                return BluetoothAdapter.getDefaultAdapter().getAddress();
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            Field declaredField = defaultAdapter.getClass().getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(defaultAdapter);
            if (obj == null || (invoke = obj.getClass().getMethod("getAddress", (Class[]) null).invoke(obj, (Object[]) null)) == null || !(invoke instanceof String)) {
                return null;
            }
            return (String) invoke;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(com.ktakilat.cbase.ui.BaseApplication r3) {
        /*
            java.lang.String r0 = ""
            android.content.pm.PackageManager r1 = r3.getPackageManager()     // Catch:{  }
            java.lang.String r3 = r3.getPackageName()     // Catch:{  }
            r2 = 64
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r2)     // Catch:{  }
            android.content.pm.Signature[] r3 = r3.signatures     // Catch:{  }
            r1 = 0
            r3 = r3[r1]     // Catch:{  }
            byte[] r3 = r3.toByteArray()     // Catch:{  }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{  }
            r1.<init>(r3)     // Catch:{  }
            java.lang.String r3 = "X509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3)     // Catch:{  }
            java.security.cert.Certificate r3 = r3.generateCertificate(r1)     // Catch:{  }
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3     // Catch:{  }
            java.lang.String r1 = "SHA1"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch:{ Exception -> 0x003d }
            byte[] r3 = r3.getEncoded()     // Catch:{ Exception -> 0x003d }
            byte[] r3 = r1.digest(r3)     // Catch:{ Exception -> 0x003d }
            java.lang.String r3 = a(r3)     // Catch:{ Exception -> 0x003d }
            return r3
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.utils.TelephonyUtils.e(com.ktakilat.cbase.ui.BaseApplication):java.lang.String");
    }

    public static int f(BaseApplication baseApplication) {
        int i = -1;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) baseApplication.getSystemService("telecom");
            if (ContextCompat.checkSelfPermission(baseApplication, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                return -1;
            }
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo != null) {
                for (CellInfo next : allCellInfo) {
                    if (next instanceof CellInfoGsm) {
                        i = ((CellInfoGsm) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoCdma) {
                        i = ((CellInfoCdma) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoLte) {
                        i = ((CellInfoLte) next).getCellSignalStrength().getDbm();
                    } else if (next instanceof CellInfoWcdma) {
                        i = ((CellInfoWcdma) next).getCellSignalStrength().getDbm();
                    }
                }
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean g(BaseApplication baseApplication) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                LocationManager locationManager = (LocationManager) baseApplication.getSystemService("location");
                LocationProvider provider = locationManager.getProvider("gps");
                if (provider != null) {
                    locationManager.addTestProvider(provider.getName(), provider.requiresNetwork(), provider.requiresSatellite(), provider.requiresCell(), provider.hasMonetaryCost(), provider.supportsAltitude(), provider.supportsSpeed(), provider.supportsBearing(), provider.getPowerRequirement(), provider.getAccuracy());
                } else {
                    locationManager.addTestProvider("gps", true, true, false, false, true, true, true, 3, 1);
                }
                locationManager.setTestProviderEnabled("gps", true);
                locationManager.setTestProviderStatus("gps", 2, (Bundle) null, System.currentTimeMillis());
            } else if (Settings.Secure.getInt(baseApplication.getContentResolver(), "mock_location", 0) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
