package com.katkilat.baidu_face.utils;

import android.graphics.Point;
import android.hardware.Camera;
import com.baidu.idl.face.platform.FaceEnvironment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/katkilat/baidu_face/utils/CameraPreviewUtils;", "", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraPreviewUtils {
    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Object, java.util.Comparator] */
    public static Point a(Camera.Parameters parameters, Point point) {
        double d;
        double d2;
        double d3;
        Point point2 = point;
        Intrinsics.checkNotNullParameter(point2, "screenResolution");
        if (parameters == null) {
            return new Point(FaceEnvironment.VALUE_CROP_HEIGHT, FaceEnvironment.VALUE_CROP_WIDTH);
        }
        Collection supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            parameters.getPreviewSize();
            return new Point(FaceEnvironment.VALUE_CROP_HEIGHT, FaceEnvironment.VALUE_CROP_WIDTH);
        }
        ArrayList arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Object());
        int i = point2.x;
        int i2 = point2.y;
        if (i > i2) {
            d = (double) i;
            d2 = (double) i2;
        } else {
            d = (double) i2;
            d2 = (double) i;
        }
        double d4 = d / d2;
        Iterator it = arrayList.iterator();
        Camera.Size size = null;
        double d5 = -1.0d;
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i3 = size2.width;
            int i4 = size2.height;
            int i5 = i3 * i4;
            if (i5 < 307200) {
                it.remove();
            } else if (i5 > 2073600) {
                it.remove();
            } else if (i4 > i3) {
                it.remove();
            } else if (i4 % 2 == 0 && i3 % 2 == 0) {
                if (i3 > i4) {
                    d3 = ((double) i3) / ((double) i4);
                } else {
                    d3 = ((double) i4) / ((double) i3);
                }
                double abs = Math.abs(d3 - d4);
                if ((d5 == -1.0d && abs <= 0.25d) || (d5 >= abs && abs <= 0.25d)) {
                    size = size2;
                    d5 = abs;
                }
            } else {
                it.remove();
            }
        }
        if (size != null) {
            return new Point(size.width, size.height);
        }
        parameters.getPreviewSize();
        return new Point(FaceEnvironment.VALUE_CROP_HEIGHT, FaceEnvironment.VALUE_CROP_WIDTH);
    }
}
