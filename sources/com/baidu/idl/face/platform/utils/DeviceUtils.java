package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.facebook.places.model.PlaceFields;
import java.util.UUID;

public class DeviceUtils {
    private static final String TAG = "DeviceUtils";

    public static String getAndroidID(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        try {
            return MD5Utils.encryption(string.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return string;
        }
    }

    public static String getDeviceCode(Context context) {
        try {
            return MD5Utils.encryption(((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getDeviceId().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getSerialNumber(Context context) {
        return Build.SERIAL;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
