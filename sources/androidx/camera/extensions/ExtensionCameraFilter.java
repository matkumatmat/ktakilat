package androidx.camera.extensions;

import androidx.annotation.NonNull;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Identifier;
import androidx.camera.extensions.internal.ExtensionsUtils;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class ExtensionCameraFilter implements CameraFilter {
    private final Identifier mId;
    private final VendorExtender mVendorExtender;

    public ExtensionCameraFilter(@NonNull String str, @NonNull VendorExtender vendorExtender) {
        this.mId = Identifier.create(str);
        this.mVendorExtender = vendorExtender;
    }

    @NonNull
    public List<CameraInfo> filter(@NonNull List<CameraInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (CameraInfo next : list) {
            Preconditions.checkArgument(next instanceof CameraInfoInternal, "The camera info doesn't contain internal implementation.");
            CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) next;
            if (this.mVendorExtender.isExtensionAvailable(cameraInfoInternal.getCameraId(), ExtensionsUtils.getCameraCharacteristicsMap(cameraInfoInternal))) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NonNull
    public Identifier getIdentifier() {
        return this.mId;
    }
}
