package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.SurfaceRequest;

final class AutoValue_SurfaceRequest_TransformationInfo extends SurfaceRequest.TransformationInfo {
    private final Rect getCropRect;
    private final int getRotationDegrees;
    private final Matrix getSensorToBufferTransform;
    private final int getTargetRotation;
    private final boolean hasCameraTransform;
    private final boolean isMirroring;

    public AutoValue_SurfaceRequest_TransformationInfo(Rect rect, int i, int i2, boolean z, Matrix matrix, boolean z2) {
        if (rect != null) {
            this.getCropRect = rect;
            this.getRotationDegrees = i;
            this.getTargetRotation = i2;
            this.hasCameraTransform = z;
            if (matrix != null) {
                this.getSensorToBufferTransform = matrix;
                this.isMirroring = z2;
                return;
            }
            throw new NullPointerException("Null getSensorToBufferTransform");
        }
        throw new NullPointerException("Null getCropRect");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SurfaceRequest.TransformationInfo)) {
            return false;
        }
        SurfaceRequest.TransformationInfo transformationInfo = (SurfaceRequest.TransformationInfo) obj;
        if (this.getCropRect.equals(transformationInfo.getCropRect()) && this.getRotationDegrees == transformationInfo.getRotationDegrees() && this.getTargetRotation == transformationInfo.getTargetRotation() && this.hasCameraTransform == transformationInfo.hasCameraTransform() && this.getSensorToBufferTransform.equals(transformationInfo.getSensorToBufferTransform()) && this.isMirroring == transformationInfo.isMirroring()) {
            return true;
        }
        return false;
    }

    @NonNull
    public Rect getCropRect() {
        return this.getCropRect;
    }

    public int getRotationDegrees() {
        return this.getRotationDegrees;
    }

    @NonNull
    public Matrix getSensorToBufferTransform() {
        return this.getSensorToBufferTransform;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getTargetRotation() {
        return this.getTargetRotation;
    }

    public boolean hasCameraTransform() {
        return this.hasCameraTransform;
    }

    public int hashCode() {
        int i;
        int hashCode = (((((this.getCropRect.hashCode() ^ 1000003) * 1000003) ^ this.getRotationDegrees) * 1000003) ^ this.getTargetRotation) * 1000003;
        int i2 = 1237;
        if (this.hasCameraTransform) {
            i = 1231;
        } else {
            i = 1237;
        }
        int hashCode2 = (((hashCode ^ i) * 1000003) ^ this.getSensorToBufferTransform.hashCode()) * 1000003;
        if (this.isMirroring) {
            i2 = 1231;
        }
        return hashCode2 ^ i2;
    }

    public boolean isMirroring() {
        return this.isMirroring;
    }

    public String toString() {
        return "TransformationInfo{getCropRect=" + this.getCropRect + ", getRotationDegrees=" + this.getRotationDegrees + ", getTargetRotation=" + this.getTargetRotation + ", hasCameraTransform=" + this.hasCameraTransform + ", getSensorToBufferTransform=" + this.getSensorToBufferTransform + ", isMirroring=" + this.isMirroring + "}";
    }
}
