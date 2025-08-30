package com.trustdecision.android.sensor.ii11i111;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.CharEncoding;

public class ii11i111 implements SensorEventListener {
    private static long i11lli1i111i1i1;
    private static final List i1lill1 = new CopyOnWriteArrayList();
    private static long i1lill1i;
    private static final List ii11i111 = new CopyOnWriteArrayList();
    private static final List ili11l1lll111i1 = new CopyOnWriteArrayList();
    private static long l11lliiil1i;
    private static final List li1lilil11i = new CopyOnWriteArrayList();
    private static long liilili1lil1lill1lliii;
    private static long liill1ll1il1illl1;
    private static long lillillliill1ill1i;
    private static final List llilllii1ili1111ll11 = new CopyOnWriteArrayList();
    private static final List llliilil1ill1lii = new CopyOnWriteArrayList();
    private final DecimalFormat i1lill1lil;
    private final DecimalFormatSymbols lili11lli1lill;

    public ii11i111() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        this.lili11lli1lill = decimalFormatSymbols;
        this.i1lill1lil = new DecimalFormat(ii11i111("662a2727393939", 58), decimalFormatSymbols);
    }

    public static synchronized String i1lill1() {
        String obj;
        synchronized (ii11i111.class) {
            obj = ii11i111.toString();
        }
        return obj;
    }

    public static synchronized String ii11i111() {
        String obj;
        synchronized (ii11i111.class) {
            obj = i1lill1.toString();
        }
        return obj;
    }

    public static synchronized String ili11l1lll111i1() {
        String obj;
        synchronized (ii11i111.class) {
            obj = ili11l1lll111i1.toString();
        }
        return obj;
    }

    public static void li1lilil11i() {
        i1lill1.clear();
        ii11i111.clear();
        ili11l1lll111i1.clear();
        llilllii1ili1111ll11.clear();
        llliilil1ill1lii.clear();
        li1lilil11i.clear();
    }

    public static synchronized String llilllii1ili1111ll11() {
        String obj;
        synchronized (ii11i111.class) {
            obj = llilllii1ili1111ll11.toString();
        }
        return obj;
    }

    public static synchronized String llliilil1ill1lii() {
        String obj;
        synchronized (ii11i111.class) {
            obj = llliilil1ill1lii.toString();
        }
        return obj;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values.length >= 3) {
            try {
                ii11i111(sensorEvent);
            } catch (Throwable unused) {
            }
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
            byte b = (byte) (i ^ 3);
            byte b2 = (byte) (bArr[0] ^ 69);
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

    private void ii11i111(SensorEvent sensorEvent) {
        SensorEvent sensorEvent2 = sensorEvent;
        long currentTimeMillis = System.currentTimeMillis();
        int type = sensorEvent2.sensor.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        if (type != 5) {
                            if (type == 9 && currentTimeMillis - l11lliiil1i > 80) {
                                float[] fArr = sensorEvent2.values;
                                double d = (double) fArr[0];
                                double d2 = (double) fArr[1];
                                double d3 = (double) fArr[2];
                                List list = ii11i111;
                                if (list.size() < 5) {
                                    list.add(ii11i111("6d", 89) + this.i1lill1lil.format(d) + ii11i111("69", 83) + this.i1lill1lil.format(d2) + ii11i111("69", 60) + this.i1lill1lil.format(d3) + ii11i111("6c", 11));
                                }
                                l11lliiil1i = System.currentTimeMillis();
                            }
                        } else if (currentTimeMillis - liill1ll1il1illl1 > 80) {
                            int i = (int) sensorEvent2.values[0];
                            List list2 = llliilil1ill1lii;
                            if (list2.size() < 5) {
                                list2.add(String.valueOf(i));
                            }
                            liill1ll1il1illl1 = System.currentTimeMillis();
                        }
                    } else if (currentTimeMillis - i11lli1i111i1i1 > 80) {
                        float[] fArr2 = sensorEvent2.values;
                        double d4 = (double) fArr2[0];
                        double d5 = (double) fArr2[1];
                        double d6 = (double) fArr2[2];
                        List list3 = llilllii1ili1111ll11;
                        if (list3.size() < 5) {
                            list3.add(ii11i111("6d", 5) + this.i1lill1lil.format(d4) + ii11i111("69", 115) + this.i1lill1lil.format(d5) + ii11i111("69", 123) + this.i1lill1lil.format(d6) + ii11i111("6c", 33));
                        }
                        i11lli1i111i1i1 = System.currentTimeMillis();
                    }
                } else if (currentTimeMillis - lillillliill1ill1i > 50) {
                    float[] fArr3 = sensorEvent2.values;
                    double d7 = (double) fArr3[0];
                    double d8 = (double) fArr3[1];
                    double d9 = (double) fArr3[2];
                    List list4 = li1lilil11i;
                    if (list4.size() < 5) {
                        list4.add(ii11i111("6d", 112) + this.i1lill1lil.format(d7) + ii11i111("69", 25) + this.i1lill1lil.format(d8) + ii11i111("69", 30) + this.i1lill1lil.format(d9) + ii11i111("6c", 10));
                    }
                    lillillliill1ill1i = System.currentTimeMillis();
                }
            } else if (currentTimeMillis - liilili1lil1lill1lliii > 80) {
                float[] fArr4 = sensorEvent2.values;
                float f = fArr4[0];
                float f2 = fArr4[1];
                float f3 = fArr4[2];
                List list5 = ili11l1lll111i1;
                if (list5.size() < 5) {
                    list5.add(ii11i111("6d", 39) + this.i1lill1lil.format((double) f) + ii11i111("69", 115) + this.i1lill1lil.format((double) f2) + ii11i111("69", 23) + this.i1lill1lil.format((double) f3) + ii11i111("6c", 59));
                }
                liilili1lil1lill1lliii = System.currentTimeMillis();
            }
        } else if (currentTimeMillis - i1lill1i > 40) {
            float[] fArr5 = sensorEvent2.values;
            float f4 = fArr5[0];
            float f5 = fArr5[1];
            float f6 = fArr5[2];
            List list6 = i1lill1;
            if (list6.size() < 5) {
                list6.add(ii11i111("6d", 23) + this.i1lill1lil.format((double) f4) + ii11i111("69", 68) + this.i1lill1lil.format((double) f5) + ii11i111("69", 98) + this.i1lill1lil.format((double) f6) + ii11i111("6c", 70));
            }
            i1lill1i = System.currentTimeMillis();
        }
    }
}
