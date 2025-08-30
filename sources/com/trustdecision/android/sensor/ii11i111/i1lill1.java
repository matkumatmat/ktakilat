package com.trustdecision.android.sensor.ii11i111;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import com.google.common.primitives.SignedBytes;
import java.util.List;
import org.apache.commons.lang3.CharEncoding;

public class i1lill1 {
    private static ii11i111 ii11i111;

    public static String i1lill1() {
        return ii11i111 != null ? ii11i111.i1lill1() : ii11i111("1b20", 53);
    }

    public static String ii11i111() {
        return ii11i111 != null ? ii11i111.ii11i111() : ii11i111("1b5a", 79);
    }

    public static String ili11l1lll111i1() {
        return ii11i111 != null ? ii11i111.llilllii1ili1111ll11() : ii11i111("1b00", 21);
    }

    public static String llilllii1ili1111ll11() {
        return ii11i111 != null ? ii11i111.llliilil1ill1lii() : ii11i111("1b19", 12);
    }

    public static String llliilil1ill1lii() {
        return ii11i111 != null ? ii11i111.ili11l1lll111i1() : ii11i111("1b3a", 47);
    }

    public static void i1lill1(SensorManager sensorManager) {
        if (sensorManager != null) {
            sensorManager.unregisterListener(ii11i111);
        }
    }

    private static String ii11i111(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 19);
            byte b2 = (byte) (bArr[0] ^ SignedBytes.MAX_POWER_OF_TWO);
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

    public static List ili11l1lll111i1(SensorManager sensorManager) {
        return sensorManager.getSensorList(-1);
    }

    public static void ii11i111(SensorManager sensorManager) {
        ii11i111.li1lilil11i();
        ii11i111 = new ii11i111();
        if (sensorManager != null) {
            int i = Build.VERSION.SDK_INT > 30 ? 3 : 0;
            try {
                Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                if (defaultSensor != null) {
                    sensorManager.registerListener(ii11i111, defaultSensor, i);
                }
                Sensor defaultSensor2 = sensorManager.getDefaultSensor(9);
                if (defaultSensor2 != null) {
                    sensorManager.registerListener(ii11i111, defaultSensor2, i);
                }
                Sensor defaultSensor3 = sensorManager.getDefaultSensor(5);
                if (defaultSensor3 != null) {
                    sensorManager.registerListener(ii11i111, defaultSensor3, i);
                }
                Sensor defaultSensor4 = sensorManager.getDefaultSensor(2);
                if (defaultSensor4 != null) {
                    sensorManager.registerListener(ii11i111, defaultSensor4, i);
                }
                Sensor defaultSensor5 = sensorManager.getDefaultSensor(4);
                if (defaultSensor5 != null) {
                    sensorManager.registerListener(ii11i111, defaultSensor5, i);
                }
                Sensor defaultSensor6 = sensorManager.getDefaultSensor(3);
                if (defaultSensor6 != null) {
                    sensorManager.registerListener(ii11i111, defaultSensor6, i);
                }
            } catch (Exception unused) {
            }
        }
    }
}
