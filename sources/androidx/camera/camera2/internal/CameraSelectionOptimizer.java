package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInfoInternal;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class CameraSelectionOptimizer {
    private CameraSelectionOptimizer() {
    }

    private static String decideSkippedCameraIdByHeuristic(CameraManagerCompat cameraManagerCompat, Integer num, List<String> list) throws CameraAccessExceptionCompat {
        if (num == null || !list.contains(AppEventsConstants.EVENT_PARAM_VALUE_NO) || !list.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            return null;
        }
        if (num.intValue() == 1) {
            if (((Integer) cameraManagerCompat.getCameraCharacteristicsCompat(AppEventsConstants.EVENT_PARAM_VALUE_NO).get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                return AppEventsConstants.EVENT_PARAM_VALUE_YES;
            }
            return null;
        } else if (num.intValue() == 0 && ((Integer) cameraManagerCompat.getCameraCharacteristicsCompat(AppEventsConstants.EVENT_PARAM_VALUE_YES).get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
            return AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            return null;
        }
    }

    public static List<String> getSelectedAvailableCameraIds(@NonNull Camera2CameraFactory camera2CameraFactory, @Nullable CameraSelector cameraSelector) throws InitializationException {
        String str;
        try {
            ArrayList arrayList = new ArrayList();
            List<String> asList = Arrays.asList(camera2CameraFactory.getCameraManager().getCameraIdList());
            if (cameraSelector == null) {
                for (String add : asList) {
                    arrayList.add(add);
                }
                return arrayList;
            }
            try {
                str = decideSkippedCameraIdByHeuristic(camera2CameraFactory.getCameraManager(), cameraSelector.getLensFacing(), asList);
            } catch (IllegalStateException unused) {
                str = null;
            }
            ArrayList arrayList2 = new ArrayList();
            for (String str2 : asList) {
                if (!str2.equals(str)) {
                    arrayList2.add(camera2CameraFactory.getCameraInfo(str2));
                }
            }
            Iterator<CameraInfo> it = cameraSelector.filter((List<CameraInfo>) arrayList2).iterator();
            while (it.hasNext()) {
                arrayList.add(((CameraInfoInternal) it.next()).getCameraId());
            }
            return arrayList;
        } catch (CameraAccessExceptionCompat e) {
            throw new InitializationException((Throwable) CameraUnavailableExceptionHelper.createFrom(e));
        } catch (CameraUnavailableException e2) {
            throw new InitializationException((Throwable) e2);
        }
    }
}
