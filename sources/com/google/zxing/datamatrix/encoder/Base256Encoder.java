package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.ItemTouchHelper;

final class Base256Encoder implements Encoder {
    public final void a(EncoderContext encoderContext) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!encoderContext.b()) {
                break;
            }
            sb.append(encoderContext.a());
            int i = encoderContext.f + 1;
            encoderContext.f = i;
            int g = HighLevelEncoder.g(encoderContext.f420a, i, 5);
            if (g != 5) {
                encoderContext.g = g;
                break;
            }
        }
        int length = sb.length() - 1;
        StringBuilder sb2 = encoderContext.e;
        int length2 = sb2.length() + length + 1;
        encoderContext.c(length2);
        if (encoderContext.h.b - length2 > 0) {
            z = true;
        } else {
            z = false;
        }
        if (encoderContext.b() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) + 249));
                sb.insert(1, (char) (length % ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            } else {
                throw new IllegalStateException(ba.k(length, "Message length not in valid ranges: "));
            }
        }
        int length3 = sb.length();
        for (int i2 = 0; i2 < length3; i2++) {
            int length4 = (((sb2.length() + 1) * 149) % 255) + 1 + sb.charAt(i2);
            if (length4 > 255) {
                length4 += InputDeviceCompat.SOURCE_ANY;
            }
            encoderContext.d((char) length4);
        }
    }
}
