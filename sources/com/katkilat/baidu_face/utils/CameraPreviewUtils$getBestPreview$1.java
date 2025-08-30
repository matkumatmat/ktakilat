package com.katkilat.baidu_face.utils;

import android.hardware.Camera;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"com/katkilat/baidu_face/utils/CameraPreviewUtils$getBestPreview$1", "Ljava/util/Comparator;", "Landroid/hardware/Camera$Size;", "Landroid/hardware/Camera;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraPreviewUtils$getBestPreview$1 implements Comparator<Camera.Size> {
    public final int compare(Object obj, Object obj2) {
        int i;
        int i2;
        int i3;
        int i4;
        Camera.Size size = (Camera.Size) obj;
        Camera.Size size2 = (Camera.Size) obj2;
        int i5 = 0;
        if (size != null) {
            i = size.height;
        } else {
            i = 0;
        }
        if (size != null) {
            i2 = size.width;
        } else {
            i2 = 0;
        }
        int i6 = i * i2;
        if (size2 != null) {
            i3 = size2.height;
        } else {
            i3 = 0;
        }
        if (size2 != null) {
            i4 = size2.width;
        } else {
            i4 = 0;
        }
        int i7 = i3 * i4;
        if (i7 < i6) {
            return -1;
        }
        if (i7 > i6) {
            i5 = 1;
        }
        return i5;
    }
}
