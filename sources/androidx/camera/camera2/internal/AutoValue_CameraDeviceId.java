package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;

final class AutoValue_CameraDeviceId extends CameraDeviceId {
    private final String brand;
    private final String cameraId;
    private final String device;
    private final String model;

    public AutoValue_CameraDeviceId(String str, String str2, String str3, String str4) {
        if (str != null) {
            this.brand = str;
            if (str2 != null) {
                this.device = str2;
                if (str3 != null) {
                    this.model = str3;
                    if (str4 != null) {
                        this.cameraId = str4;
                        return;
                    }
                    throw new NullPointerException("Null cameraId");
                }
                throw new NullPointerException("Null model");
            }
            throw new NullPointerException("Null device");
        }
        throw new NullPointerException("Null brand");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CameraDeviceId)) {
            return false;
        }
        CameraDeviceId cameraDeviceId = (CameraDeviceId) obj;
        if (!this.brand.equals(cameraDeviceId.getBrand()) || !this.device.equals(cameraDeviceId.getDevice()) || !this.model.equals(cameraDeviceId.getModel()) || !this.cameraId.equals(cameraDeviceId.getCameraId())) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getBrand() {
        return this.brand;
    }

    @NonNull
    public String getCameraId() {
        return this.cameraId;
    }

    @NonNull
    public String getDevice() {
        return this.device;
    }

    @NonNull
    public String getModel() {
        return this.model;
    }

    public int hashCode() {
        return ((((((this.brand.hashCode() ^ 1000003) * 1000003) ^ this.device.hashCode()) * 1000003) ^ this.model.hashCode()) * 1000003) ^ this.cameraId.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CameraDeviceId{brand=");
        sb.append(this.brand);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", cameraId=");
        return ba.r(sb, this.cameraId, "}");
    }
}
