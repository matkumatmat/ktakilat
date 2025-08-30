package com.google.zxing.oned;

import com.facebook.appevents.AppEventsConstants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;

public final class UPCAWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    public final EAN13Writer f430a = new Object();

    public final BitMatrix a(String str, BarcodeFormat barcodeFormat, EnumMap enumMap) {
        int i;
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            int length = str.length();
            if (length == 11) {
                int i2 = 0;
                for (int i3 = 0; i3 < 11; i3++) {
                    int charAt = str.charAt(i3) - '0';
                    if (i3 % 2 == 0) {
                        i = 3;
                    } else {
                        i = 1;
                    }
                    i2 += charAt * i;
                }
                StringBuilder v = ba.v(str);
                v.append((1000 - i2) % 10);
                str = v.toString();
            } else if (length != 12) {
                throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + str.length());
            }
            return this.f430a.a(e.B(AppEventsConstants.EVENT_PARAM_VALUE_NO, str), BarcodeFormat.EAN_13, enumMap);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
    }
}
