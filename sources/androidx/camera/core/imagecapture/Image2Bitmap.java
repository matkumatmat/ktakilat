package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;

public class Image2Bitmap implements Operation<Packet<ImageProxy>, Bitmap> {
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9 A[Catch:{ all -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bc A[Catch:{ all -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap apply(@androidx.annotation.NonNull androidx.camera.core.processing.Packet<androidx.camera.core.ImageProxy> r11) throws androidx.camera.core.ImageCaptureException {
        /*
            r10 = this;
            java.lang.String r0 = "Can't convert "
            java.lang.String r1 = "Invalid postview image format : "
            r2 = 35
            r3 = 0
            r4 = 0
            int r5 = r11.getFormat()     // Catch:{ UnsupportedOperationException -> 0x002a }
            if (r5 != r2) goto L_0x007a
            java.lang.Object r1 = r11.getData()     // Catch:{ UnsupportedOperationException -> 0x002a }
            androidx.camera.core.ImageProxy r1 = (androidx.camera.core.ImageProxy) r1     // Catch:{ UnsupportedOperationException -> 0x002a }
            int r5 = r11.getRotationDegrees()     // Catch:{ UnsupportedOperationException -> 0x002a }
            int r5 = r5 % 180
            r6 = 1
            if (r5 == 0) goto L_0x001f
            r5 = 1
            goto L_0x0020
        L_0x001f:
            r5 = 0
        L_0x0020:
            if (r5 == 0) goto L_0x002d
            int r7 = r1.getHeight()     // Catch:{ UnsupportedOperationException -> 0x002a }
            goto L_0x0031
        L_0x0027:
            r11 = move-exception
            goto L_0x00d5
        L_0x002a:
            r1 = move-exception
            goto L_0x00b3
        L_0x002d:
            int r7 = r1.getWidth()     // Catch:{ UnsupportedOperationException -> 0x002a }
        L_0x0031:
            if (r5 == 0) goto L_0x0038
            int r5 = r1.getWidth()     // Catch:{ UnsupportedOperationException -> 0x002a }
            goto L_0x003c
        L_0x0038:
            int r5 = r1.getHeight()     // Catch:{ UnsupportedOperationException -> 0x002a }
        L_0x003c:
            androidx.camera.core.SafeCloseImageReaderProxy r8 = new androidx.camera.core.SafeCloseImageReaderProxy     // Catch:{ UnsupportedOperationException -> 0x002a }
            r9 = 2
            androidx.camera.core.impl.ImageReaderProxy r5 = androidx.camera.core.ImageReaderProxys.createIsolatedReader(r7, r5, r6, r9)     // Catch:{ UnsupportedOperationException -> 0x002a }
            r8.<init>(r5)     // Catch:{ UnsupportedOperationException -> 0x002a }
            int r5 = r1.getWidth()     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            int r6 = r1.getHeight()     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            int r5 = r5 * r6
            int r5 = r5 * 4
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.allocateDirect(r5)     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            int r6 = r11.getRotationDegrees()     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            androidx.camera.core.ImageProxy r5 = androidx.camera.core.ImageProcessingUtil.convertYUVToRGB(r1, r8, r5, r6, r3)     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            r1.close()     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            if (r5 == 0) goto L_0x0072
            android.graphics.Bitmap r1 = androidx.camera.core.internal.utils.ImageUtil.createBitmapFromImageProxy(r5)     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            r5.close()     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            r4 = r8
            goto L_0x0097
        L_0x006c:
            r11 = move-exception
            r4 = r8
            goto L_0x00d5
        L_0x006f:
            r1 = move-exception
            r4 = r8
            goto L_0x00b3
        L_0x0072:
            androidx.camera.core.ImageCaptureException r1 = new androidx.camera.core.ImageCaptureException     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            java.lang.String r5 = "Can't covert YUV to RGB"
            r1.<init>(r3, r5, r4)     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
            throw r1     // Catch:{ UnsupportedOperationException -> 0x006f, all -> 0x006c }
        L_0x007a:
            int r5 = r11.getFormat()     // Catch:{ UnsupportedOperationException -> 0x002a }
            r6 = 256(0x100, float:3.59E-43)
            if (r5 != r6) goto L_0x009d
            java.lang.Object r1 = r11.getData()     // Catch:{ UnsupportedOperationException -> 0x002a }
            androidx.camera.core.ImageProxy r1 = (androidx.camera.core.ImageProxy) r1     // Catch:{ UnsupportedOperationException -> 0x002a }
            android.graphics.Bitmap r5 = androidx.camera.core.internal.utils.ImageUtil.createBitmapFromImageProxy(r1)     // Catch:{ UnsupportedOperationException -> 0x002a }
            r1.close()     // Catch:{ UnsupportedOperationException -> 0x002a }
            int r1 = r11.getRotationDegrees()     // Catch:{ UnsupportedOperationException -> 0x002a }
            android.graphics.Bitmap r1 = androidx.camera.core.internal.utils.ImageUtil.rotateBitmap(r5, r1)     // Catch:{ UnsupportedOperationException -> 0x002a }
        L_0x0097:
            if (r4 == 0) goto L_0x009c
            r4.close()
        L_0x009c:
            return r1
        L_0x009d:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ UnsupportedOperationException -> 0x002a }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ UnsupportedOperationException -> 0x002a }
            r6.<init>(r1)     // Catch:{ UnsupportedOperationException -> 0x002a }
            int r1 = r11.getFormat()     // Catch:{ UnsupportedOperationException -> 0x002a }
            r6.append(r1)     // Catch:{ UnsupportedOperationException -> 0x002a }
            java.lang.String r1 = r6.toString()     // Catch:{ UnsupportedOperationException -> 0x002a }
            r5.<init>(r1)     // Catch:{ UnsupportedOperationException -> 0x002a }
            throw r5     // Catch:{ UnsupportedOperationException -> 0x002a }
        L_0x00b3:
            int r11 = r11.getFormat()     // Catch:{ all -> 0x0027 }
            if (r11 != r2) goto L_0x00bc
            java.lang.String r11 = "YUV"
            goto L_0x00be
        L_0x00bc:
            java.lang.String r11 = "JPEG"
        L_0x00be:
            androidx.camera.core.ImageCaptureException r2 = new androidx.camera.core.ImageCaptureException     // Catch:{ all -> 0x0027 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0027 }
            r5.<init>(r0)     // Catch:{ all -> 0x0027 }
            r5.append(r11)     // Catch:{ all -> 0x0027 }
            java.lang.String r11 = " to bitmap"
            r5.append(r11)     // Catch:{ all -> 0x0027 }
            java.lang.String r11 = r5.toString()     // Catch:{ all -> 0x0027 }
            r2.<init>(r3, r11, r1)     // Catch:{ all -> 0x0027 }
            throw r2     // Catch:{ all -> 0x0027 }
        L_0x00d5:
            if (r4 == 0) goto L_0x00da
            r4.close()
        L_0x00da:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.Image2Bitmap.apply(androidx.camera.core.processing.Packet):android.graphics.Bitmap");
    }
}
