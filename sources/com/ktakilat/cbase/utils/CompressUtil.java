package com.ktakilat.cbase.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.io.ByteArrayOutputStream;

public class CompressUtil {
    public static byte[] a(Bitmap bitmap, int i, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width > i || height > i2) {
            Matrix matrix = new Matrix();
            if (width > i) {
                float f = ((float) i) / ((float) width);
                matrix.postScale(f, f);
            } else {
                float f2 = ((float) i2) / ((float) height);
                matrix.postScale(f2, f2);
            }
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > i3) {
            byteArrayOutputStream.reset();
            i4 -= 10;
            if (i4 <= 0) {
                break;
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG, i4, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }
}
