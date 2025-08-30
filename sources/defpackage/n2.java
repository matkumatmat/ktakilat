package defpackage;

import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.LensFacingCameraFilter;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: n2  reason: default package */
public abstract /* synthetic */ class n2 {
    public static CameraSelector a(CameraInfoInternal cameraInfoInternal) {
        return new CameraSelector.Builder().addCameraFilter(new y1(cameraInfoInternal, 1)).addCameraFilter(new LensFacingCameraFilter(cameraInfoInternal.getLensFacing())).build();
    }

    public static boolean c(CameraInfoInternal cameraInfoInternal) {
        return false;
    }

    public static boolean d(CameraInfoInternal cameraInfoInternal) {
        return false;
    }

    public static /* synthetic */ List e(CameraInfoInternal cameraInfoInternal, List list) {
        String cameraId = cameraInfoInternal.getCameraId();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraInfo cameraInfo = (CameraInfo) it.next();
            Preconditions.checkArgument(cameraInfo instanceof CameraInfoInternal);
            if (((CameraInfoInternal) cameraInfo).getCameraId().equals(cameraId)) {
                return Collections.singletonList(cameraInfo);
            }
        }
        throw new IllegalStateException(ba.o("Unable to find camera with id ", cameraId, " from list of available cameras."));
    }

    public static CameraInfoInternal b(CameraInfoInternal cameraInfoInternal) {
        return cameraInfoInternal;
    }
}
