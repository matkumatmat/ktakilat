package androidx.camera.camera2.internal.concurrent;

import android.hardware.camera2.CameraCharacteristics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.concurrent.CameraCoordinator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Camera2CameraCoordinator implements CameraCoordinator {
    private static final String TAG = "Camera2CameraCoordinator";
    @NonNull
    private List<CameraInfo> mActiveConcurrentCameraInfos;
    @NonNull
    private final CameraManagerCompat mCameraManager;
    private int mCameraOperatingMode = 0;
    @NonNull
    private final Map<String, List<String>> mConcurrentCameraIdMap;
    @NonNull
    private Set<Set<String>> mConcurrentCameraIds;
    @NonNull
    private final List<CameraCoordinator.ConcurrentCameraModeListener> mConcurrentCameraModeListeners;

    public Camera2CameraCoordinator(@NonNull CameraManagerCompat cameraManagerCompat) {
        this.mCameraManager = cameraManagerCompat;
        this.mConcurrentCameraIdMap = new HashMap();
        this.mConcurrentCameraIds = new HashSet();
        this.mConcurrentCameraModeListeners = new ArrayList();
        this.mActiveConcurrentCameraInfos = new ArrayList();
        retrieveConcurrentCameraIds();
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    private static CameraSelector createCameraSelectorById(@NonNull CameraManagerCompat cameraManagerCompat, @NonNull String str) {
        CameraSelector.Builder addCameraFilter = new CameraSelector.Builder().addCameraFilter(new y1(str, 0));
        try {
            addCameraFilter.requireLensFacing(((Integer) cameraManagerCompat.getCameraCharacteristicsCompat(str).get(CameraCharacteristics.LENS_FACING)).intValue());
            return addCameraFilter.build();
        } catch (CameraAccessExceptionCompat e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List lambda$createCameraSelectorById$0(String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraInfo cameraInfo = (CameraInfo) it.next();
            if (str.equals(Camera2CameraInfo.from(cameraInfo).getCameraId())) {
                return Collections.singletonList(cameraInfo);
            }
        }
        throw new IllegalArgumentException(e.B("No camera can be find for id: ", str));
    }

    private void retrieveConcurrentCameraIds() {
        Set<Set> hashSet = new HashSet<>();
        try {
            hashSet = this.mCameraManager.getConcurrentCameraIds();
        } catch (CameraAccessExceptionCompat unused) {
            Logger.e(TAG, "Failed to get concurrent camera ids");
        }
        for (Set arrayList : hashSet) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            if (arrayList2.size() >= 2) {
                String str = (String) arrayList2.get(0);
                String str2 = (String) arrayList2.get(1);
                try {
                    if (CameraIdUtil.isBackwardCompatible(this.mCameraManager, str) && CameraIdUtil.isBackwardCompatible(this.mCameraManager, str2)) {
                        this.mConcurrentCameraIds.add(new HashSet(Arrays.asList(new String[]{str, str2})));
                        if (!this.mConcurrentCameraIdMap.containsKey(str)) {
                            this.mConcurrentCameraIdMap.put(str, new ArrayList());
                        }
                        if (!this.mConcurrentCameraIdMap.containsKey(str2)) {
                            this.mConcurrentCameraIdMap.put(str2, new ArrayList());
                        }
                        this.mConcurrentCameraIdMap.get(str).add((String) arrayList2.get(1));
                        this.mConcurrentCameraIdMap.get(str2).add((String) arrayList2.get(0));
                    }
                } catch (InitializationException unused2) {
                    Logger.d(TAG, e.o("Concurrent camera id pair: (", str, ", ", str2, ") is not backward compatible"));
                }
            }
        }
    }

    public void addListener(@NonNull CameraCoordinator.ConcurrentCameraModeListener concurrentCameraModeListener) {
        this.mConcurrentCameraModeListeners.add(concurrentCameraModeListener);
    }

    @NonNull
    public List<CameraInfo> getActiveConcurrentCameraInfos() {
        return this.mActiveConcurrentCameraInfos;
    }

    public int getCameraOperatingMode() {
        return this.mCameraOperatingMode;
    }

    @NonNull
    public List<List<CameraSelector>> getConcurrentCameraSelectors() {
        ArrayList arrayList = new ArrayList();
        for (Set<String> it : this.mConcurrentCameraIds) {
            ArrayList arrayList2 = new ArrayList();
            for (String createCameraSelectorById : it) {
                arrayList2.add(createCameraSelectorById(this.mCameraManager, createCameraSelectorById));
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    @Nullable
    public String getPairedConcurrentCameraId(@NonNull String str) {
        if (!this.mConcurrentCameraIdMap.containsKey(str)) {
            return null;
        }
        for (String str2 : this.mConcurrentCameraIdMap.get(str)) {
            Iterator<CameraInfo> it = this.mActiveConcurrentCameraInfos.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (str2.equals(Camera2CameraInfo.from(it.next()).getCameraId())) {
                        return str2;
                    }
                }
            }
        }
        return null;
    }

    public void removeListener(@NonNull CameraCoordinator.ConcurrentCameraModeListener concurrentCameraModeListener) {
        this.mConcurrentCameraModeListeners.remove(concurrentCameraModeListener);
    }

    public void setActiveConcurrentCameraInfos(@NonNull List<CameraInfo> list) {
        this.mActiveConcurrentCameraInfos = new ArrayList(list);
    }

    public void setCameraOperatingMode(int i) {
        if (i != this.mCameraOperatingMode) {
            for (CameraCoordinator.ConcurrentCameraModeListener onCameraOperatingModeUpdated : this.mConcurrentCameraModeListeners) {
                onCameraOperatingModeUpdated.onCameraOperatingModeUpdated(this.mCameraOperatingMode, i);
            }
        }
        if (this.mCameraOperatingMode == 2 && i != 2) {
            this.mActiveConcurrentCameraInfos.clear();
        }
        this.mCameraOperatingMode = i;
    }

    public void shutdown() {
        this.mConcurrentCameraModeListeners.clear();
        this.mConcurrentCameraIdMap.clear();
        this.mActiveConcurrentCameraInfos.clear();
        this.mConcurrentCameraIds.clear();
        this.mCameraOperatingMode = 0;
    }
}
