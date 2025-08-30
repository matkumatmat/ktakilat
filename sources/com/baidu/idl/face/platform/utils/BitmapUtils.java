package com.baidu.idl.face.platform.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import androidx.core.view.ViewCompat;
import com.baidu.idl.main.facesdk.model.BDFaceImageInstance;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class BitmapUtils {
    public static final int IMAGEBOUND = 128;
    public static final int MAXLENTH = 1024;
    public static final int PIC_COMPRESS_SIZE = 4;
    private static final int QUALITY = 100;
    public static final int ROTATE0 = 0;
    public static final int ROTATE180 = 180;
    public static final int ROTATE270 = 270;
    public static final int ROTATE360 = 360;
    public static final int ROTATE90 = 90;
    private static final String TAG = "ImageUtils";

    private BitmapUtils() {
    }

    public static Bitmap BGR2Bitmap(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int i3 = i * i2;
        byte[] bArr2 = new byte[(i3 * 4)];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 3;
            byte b = bArr[i5];
            byte b2 = bArr[i5 + 1];
            int i6 = i4 * 4;
            bArr2[i6] = bArr[i5 + 2];
            bArr2[i6 + 1] = b2;
            bArr2[i6 + 2] = b;
            bArr2[i6 + 3] = -1;
        }
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
        return createBitmap;
    }

    public static Bitmap Depth2Bitmap(byte[] bArr, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i4 * 2;
            byte b = bArr[i5];
            byte b2 = bArr[i5 + 1];
            iArr[i4] = (((((b2 * Ascii.NUL) + b) / 10) & 255) << 16) | ((((b2 * Ascii.NUL) + b) / 10) & 255) | (((((b2 * Ascii.NUL) + b) / 10) & 255) << 8) | ViewCompat.MEASURED_STATE_MASK;
        }
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0024 A[SYNTHETIC, Splitter:B:17:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002f A[SYNTHETIC, Splitter:B:23:0x002f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bitmapCompress(android.graphics.Bitmap r3, int r4) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x001f, all -> 0x001d }
            r1.<init>()     // Catch:{ Exception -> 0x001f, all -> 0x001d }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r3.compress(r2, r4, r1)     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            byte[] r3 = r1.toByteArray()     // Catch:{ Exception -> 0x001b, all -> 0x0018 }
            r1.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0017:
            return r3
        L_0x0018:
            r3 = move-exception
            r0 = r1
            goto L_0x0022
        L_0x001b:
            goto L_0x002d
        L_0x001d:
            r3 = move-exception
            goto L_0x0022
        L_0x001f:
            r1 = r0
            goto L_0x002d
        L_0x0022:
            if (r0 == 0) goto L_0x002c
            r0.close()     // Catch:{ IOException -> 0x0028 }
            goto L_0x002c
        L_0x0028:
            r4 = move-exception
            r4.printStackTrace()
        L_0x002c:
            throw r3
        L_0x002d:
            if (r1 == 0) goto L_0x0037
            r1.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.utils.BitmapUtils.bitmapCompress(android.graphics.Bitmap, int):byte[]");
    }

    public static String bitmapToJpegBase64(Bitmap bitmap, int i, float f) {
        try {
            float max = f / ((float) Math.max(bitmap.getWidth(), bitmap.getHeight()));
            if (max < 1.0f) {
                bitmap = scale(bitmap, max);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return Base64Utils.encodeToString(byteArray, 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap calculateInSampleSize(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (height <= i2 && width <= i) {
            return bitmap;
        }
        float f = ((float) i2) / ((float) height);
        float f2 = ((float) i) / ((float) width);
        if (f >= f2) {
            f = f2;
        }
        return scale(bitmap, f);
    }

    public static int computeInitialSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i2 == -1) {
            i3 = 1;
        } else {
            i3 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        }
        if (i == -1) {
            i4 = 128;
        } else {
            double d3 = (double) i;
            i4 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i4 < i3) {
            return i3;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        if (i == -1) {
            return i3;
        }
        return i4;
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i, int i2) {
        int computeInitialSampleSize = computeInitialSampleSize(options, i, i2);
        if (computeInitialSampleSize > 8) {
            return ((computeInitialSampleSize + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < computeInitialSampleSize) {
            i3 <<= 1;
        }
        return i3;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, float f) {
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap3 = null;
        try {
            int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, min, 1048576);
            options.inJustDecodeBounds = false;
            bitmap2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            bitmap = rotateBitmap(f, bitmap2);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                bitmap3.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            bitmap = rotateBitmap(f, bitmap2);
        }
        if (!(bitmap == bitmap2 || bitmap2 == null)) {
            bitmap2.recycle();
        }
        return bitmap;
    }

    public static int decodeImageDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return ROTATE180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return ROTATE270;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static Bitmap getInstaceBmp(BDFaceImageInstance bDFaceImageInstance) {
        BDFaceSDKCommon.BDFaceImageType bDFaceImageType = bDFaceImageInstance.imageType;
        if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_RGBA) {
            Bitmap createBitmap = Bitmap.createBitmap(bDFaceImageInstance.width, bDFaceImageInstance.height, Bitmap.Config.ARGB_8888);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bDFaceImageInstance.data));
            return createBitmap;
        } else if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_BGR) {
            return BGR2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
        } else {
            if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_YUV_NV21) {
                return yuv2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
            }
            if (bDFaceImageType == BDFaceSDKCommon.BDFaceImageType.BDFACE_IMAGE_TYPE_GRAY) {
                return Depth2Bitmap(bDFaceImageInstance.data, bDFaceImageInstance.width, bDFaceImageInstance.height);
            }
            return null;
        }
    }

    public static Bitmap rotateBitmap(float f, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        if (f == 0.0f) {
            return bitmap;
        }
        matrix.setRotate(f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[SYNTHETIC, Splitter:B:18:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[SYNTHETIC, Splitter:B:23:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveBitmap(java.io.File r2, android.graphics.Bitmap r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001f }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r0 = 100
            r3.compress(r2, r0, r1)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r1.close()     // Catch:{ Exception -> 0x0011 }
            goto L_0x0015
        L_0x0011:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0015:
            r2 = 1
            return r2
        L_0x0017:
            r2 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x001a:
            r2 = move-exception
            r0 = r1
            goto L_0x0020
        L_0x001d:
            r2 = move-exception
            goto L_0x002f
        L_0x001f:
            r2 = move-exception
        L_0x0020:
            r2.printStackTrace()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x002d
            r0.close()     // Catch:{ Exception -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002d:
            r2 = 0
            return r2
        L_0x002f:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0039:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.utils.BitmapUtils.saveBitmap(java.io.File, android.graphics.Bitmap):boolean");
    }

    public static Bitmap scale(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap yuv2Bitmap(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = (i4 * i) + i5;
                int i7 = 255;
                byte b = bArr[i6] & UnsignedBytes.MAX_VALUE;
                int i8 = ((i4 >> 1) * i) + i3 + (i5 & -2);
                byte b2 = bArr[i8] & UnsignedBytes.MAX_VALUE;
                byte b3 = bArr[i8 + 1] & UnsignedBytes.MAX_VALUE;
                if (b < 16) {
                    b = Ascii.DLE;
                }
                float f = ((float) (b - Ascii.DLE)) * 1.164f;
                float f2 = (float) (b3 + UnsignedBytes.MAX_POWER_OF_TWO);
                int round = Math.round((1.596f * f2) + f);
                float f3 = (float) (b2 + UnsignedBytes.MAX_POWER_OF_TWO);
                int round2 = Math.round((f - (f2 * 0.813f)) - (0.391f * f3));
                int round3 = Math.round((f3 * 2.018f) + f);
                if (round < 0) {
                    round = 0;
                } else if (round > 255) {
                    round = 255;
                }
                if (round2 < 0) {
                    round2 = 0;
                } else if (round2 > 255) {
                    round2 = 255;
                }
                if (round3 < 0) {
                    i7 = 0;
                } else if (round3 <= 255) {
                    i7 = round3;
                }
                iArr[i6] = (i7 << 16) + ViewCompat.MEASURED_STATE_MASK + (round2 << 8) + round;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static Bitmap scale(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(((float) i) / ((float) width), ((float) i2) / ((float) height));
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap createBitmap(Context context, String str, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap3 = null;
        try {
            int min = Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = computeSampleSize(options, min, 1048576);
            options.inJustDecodeBounds = false;
            bitmap2 = BitmapFactory.decodeFile(str, options);
            bitmap = rotateBitmap((float) i, bitmap2);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (bitmap3 != null) {
                bitmap3.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap2 = BitmapFactory.decodeFile(str, options);
            bitmap = rotateBitmap((float) i, bitmap2);
        }
        if (!(bitmap == bitmap2 || bitmap2 == null)) {
            bitmap2.recycle();
        }
        return bitmap;
    }

    public static Bitmap createBitmap(Context context, byte[] bArr, int i) {
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap3 = null;
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            bitmap = rotateBitmap((float) i, bitmap2);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if (bitmap3 != null) {
                bitmap3.recycle();
            }
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            options.inSampleSize = computeSampleSize(options, -1, (options.outWidth * options.outHeight) / 4);
            options.inJustDecodeBounds = false;
            bitmap2 = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            bitmap = rotateBitmap((float) i, bitmap2);
        }
        if (!(bitmap == bitmap2 || bitmap2 == null)) {
            bitmap2.recycle();
        }
        return bitmap;
    }

    public static Bitmap createBitmap(Context context, int i, int i2, int[] iArr) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            Math.min(DensityUtils.getDisplayWidth(context), DensityUtils.getDisplayHeight(context));
            options.inJustDecodeBounds = false;
            bitmap = Bitmap.createBitmap(iArr, i, i2, Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            bitmap = null;
        }
        if (!(bitmap == null || bitmap == null)) {
            bitmap.recycle();
        }
        return null;
    }
}
