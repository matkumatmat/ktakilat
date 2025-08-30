package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraInternal;

final class AutoValue_SurfaceOutput_CameraInputInfo extends SurfaceOutput.CameraInputInfo {
    private final CameraInternal cameraInternal;
    private final Rect inputCropRect;
    private final Size inputSize;
    private final boolean mirroring;
    private final int rotationDegrees;

    public AutoValue_SurfaceOutput_CameraInputInfo(Size size, Rect rect, @Nullable CameraInternal cameraInternal2, int i, boolean z) {
        if (size != null) {
            this.inputSize = size;
            if (rect != null) {
                this.inputCropRect = rect;
                this.cameraInternal = cameraInternal2;
                this.rotationDegrees = i;
                this.mirroring = z;
                return;
            }
            throw new NullPointerException("Null inputCropRect");
        }
        throw new NullPointerException("Null inputSize");
    }

    public boolean equals(Object obj) {
        CameraInternal cameraInternal2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceOutput.CameraInputInfo)) {
            return false;
        }
        SurfaceOutput.CameraInputInfo cameraInputInfo = (SurfaceOutput.CameraInputInfo) obj;
        if (!this.inputSize.equals(cameraInputInfo.getInputSize()) || !this.inputCropRect.equals(cameraInputInfo.getInputCropRect()) || ((cameraInternal2 = this.cameraInternal) != null ? !cameraInternal2.equals(cameraInputInfo.getCameraInternal()) : cameraInputInfo.getCameraInternal() != null) || this.rotationDegrees != cameraInputInfo.getRotationDegrees() || this.mirroring != cameraInputInfo.getMirroring()) {
            return false;
        }
        return true;
    }

    @Nullable
    public CameraInternal getCameraInternal() {
        return this.cameraInternal;
    }

    @NonNull
    public Rect getInputCropRect() {
        return this.inputCropRect;
    }

    @NonNull
    public Size getInputSize() {
        return this.inputSize;
    }

    public boolean getMirroring() {
        return this.mirroring;
    }

    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    public int hashCode() {
        int i;
        int i2;
        int hashCode = (((this.inputSize.hashCode() ^ 1000003) * 1000003) ^ this.inputCropRect.hashCode()) * 1000003;
        CameraInternal cameraInternal2 = this.cameraInternal;
        if (cameraInternal2 == null) {
            i = 0;
        } else {
            i = cameraInternal2.hashCode();
        }
        int i3 = (((hashCode ^ i) * 1000003) ^ this.rotationDegrees) * 1000003;
        if (this.mirroring) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        return i3 ^ i2;
    }

    public String toString() {
        return "CameraInputInfo{inputSize=" + this.inputSize + ", inputCropRect=" + this.inputCropRect + ", cameraInternal=" + this.cameraInternal + ", rotationDegrees=" + this.rotationDegrees + ", mirroring=" + this.mirroring + "}";
    }
}
