package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.google.common.base.Ascii;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.CharEncoding;

public class Ooooo000OOoO implements SensorEventListener {
    private static final List O00OO0oOOooooO00000Oo = new CopyOnWriteArrayList();
    private static long O0OoOo00O000;
    private static long O0o0o0O0OOOooOo0OOoOOO;
    private static final List O0oOO0ooO = new CopyOnWriteArrayList();
    private static long OO0000O0Ooo0OO000oo;
    private static long OoOOooOoooOoo;
    private static final List o00ooooooO00OO0O00 = new CopyOnWriteArrayList();
    private static final List o0O00o00OOoOo0oooOoo00 = new CopyOnWriteArrayList();
    private static final List o0Oo0OO00O0O000ooOO0 = new CopyOnWriteArrayList();
    private static long o0ooOoo0Oo00oOOO;
    private static final List oO00o0OooO0OO0o0000o = new CopyOnWriteArrayList();
    private static long oO0oOOOOoo;
    private final DecimalFormat O0o0o0O0ooOooOoo;
    private final DecimalFormatSymbols o0oOO0oO00OoO0;

    public Ooooo000OOoO() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        this.o0oOO0oO00OoO0 = decimalFormatSymbols;
        this.O0o0o0O0ooOooOoo = new DecimalFormat(o0Oo0OO00O0O000ooOO0("3c141919070707", 36), decimalFormatSymbols);
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
            byte b = (byte) (i ^ 35);
            byte b2 = (byte) (bArr[0] ^ Ascii.US);
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

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values.length >= 3) {
            try {
                o0Oo0OO00O0O000ooOO0(sensorEvent);
            } catch (Throwable unused) {
            }
        }
    }

    private void o0Oo0OO00O0O000ooOO0(SensorEvent sensorEvent) {
        SensorEvent sensorEvent2 = sensorEvent;
        long currentTimeMillis = System.currentTimeMillis();
        int type = sensorEvent2.sensor.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        if (type != 5) {
                            if (type == 9 && currentTimeMillis - OO0000O0Ooo0OO000oo > 80) {
                                float[] fArr = sensorEvent2.values;
                                double d = (double) fArr[0];
                                double d2 = (double) fArr[1];
                                double d3 = (double) fArr[2];
                                List list = o0Oo0OO00O0O000ooOO0;
                                if (list.size() < 5) {
                                    list.add(o0Oo0OO00O0O000ooOO0("37", 99) + this.O0o0o0O0ooOooOoo.format(d) + o0Oo0OO00O0O000ooOO0("33", 94) + this.O0o0o0O0ooOooOoo.format(d2) + o0Oo0OO00O0O000ooOO0("33", 41) + this.O0o0o0O0ooOooOoo.format(d3) + o0Oo0OO00O0O000ooOO0("36", 115));
                                }
                                OO0000O0Ooo0OO000oo = System.currentTimeMillis();
                            }
                        } else if (currentTimeMillis - oO0oOOOOoo > 80) {
                            int i = (int) sensorEvent2.values[0];
                            List list2 = O0oOO0ooO;
                            if (list2.size() < 5) {
                                list2.add(String.valueOf(i));
                            }
                            oO0oOOOOoo = System.currentTimeMillis();
                        }
                    } else if (currentTimeMillis - O0o0o0O0OOOooOo0OOoOOO > 80) {
                        float[] fArr2 = sensorEvent2.values;
                        double d4 = (double) fArr2[0];
                        double d5 = (double) fArr2[1];
                        double d6 = (double) fArr2[2];
                        List list3 = O00OO0oOOooooO00000Oo;
                        if (list3.size() < 5) {
                            list3.add(o0Oo0OO00O0O000ooOO0("37", 125) + this.O0o0o0O0ooOooOoo.format(d4) + o0Oo0OO00O0O000ooOO0("33", 53) + this.O0o0o0O0ooOooOoo.format(d5) + o0Oo0OO00O0O000ooOO0("33", 89) + this.O0o0o0O0ooOooOoo.format(d6) + o0Oo0OO00O0O000ooOO0("36", 47));
                        }
                        O0o0o0O0OOOooOo0OOoOOO = System.currentTimeMillis();
                    }
                } else if (currentTimeMillis - o0ooOoo0Oo00oOOO > 50) {
                    float[] fArr3 = sensorEvent2.values;
                    double d7 = (double) fArr3[0];
                    double d8 = (double) fArr3[1];
                    double d9 = (double) fArr3[2];
                    List list4 = o00ooooooO00OO0O00;
                    if (list4.size() < 5) {
                        list4.add(o0Oo0OO00O0O000ooOO0("37", 23) + this.O0o0o0O0ooOooOoo.format(d7) + o0Oo0OO00O0O000ooOO0("33", 38) + this.O0o0o0O0ooOooOoo.format(d8) + o0Oo0OO00O0O000ooOO0("33", 40) + this.O0o0o0O0ooOooOoo.format(d9) + o0Oo0OO00O0O000ooOO0("36", 126));
                    }
                    o0ooOoo0Oo00oOOO = System.currentTimeMillis();
                }
            } else if (currentTimeMillis - O0OoOo00O000 > 80) {
                float[] fArr4 = sensorEvent2.values;
                float f = fArr4[0];
                float f2 = fArr4[1];
                float f3 = fArr4[2];
                List list5 = oO00o0OooO0OO0o0000o;
                if (list5.size() < 5) {
                    list5.add(o0Oo0OO00O0O000ooOO0("37", 76) + this.O0o0o0O0ooOooOoo.format((double) f) + o0Oo0OO00O0O000ooOO0("33", 9) + this.O0o0o0O0ooOooOoo.format((double) f2) + o0Oo0OO00O0O000ooOO0("33", 120) + this.O0o0o0O0ooOooOoo.format((double) f3) + o0Oo0OO00O0O000ooOO0("36", 86));
                }
                O0OoOo00O000 = System.currentTimeMillis();
            }
        } else if (currentTimeMillis - OoOOooOoooOoo > 40) {
            float[] fArr5 = sensorEvent2.values;
            float f4 = fArr5[0];
            float f5 = fArr5[1];
            float f6 = fArr5[2];
            List list6 = o0O00o00OOoOo0oooOoo00;
            if (list6.size() < 5) {
                list6.add(o0Oo0OO00O0O000ooOO0("37", 21) + this.O0o0o0O0ooOooOoo.format((double) f4) + o0Oo0OO00O0O000ooOO0("33", 89) + this.O0o0o0O0ooOooOoo.format((double) f5) + o0Oo0OO00O0O000ooOO0("33", 2) + this.O0o0o0O0ooOooOoo.format((double) f6) + o0Oo0OO00O0O000ooOO0("36", 27));
            }
            OoOOooOoooOoo = System.currentTimeMillis();
        }
    }
}
