package androidx.camera.core.processing.util;

import androidx.annotation.NonNull;
import androidx.camera.core.processing.util.GraphicDeviceInfo;

final class AutoValue_GraphicDeviceInfo extends GraphicDeviceInfo {
    private final String eglExtensions;
    private final String eglVersion;
    private final String glExtensions;
    private final String glVersion;

    public static final class Builder extends GraphicDeviceInfo.Builder {
        private String eglExtensions;
        private String eglVersion;
        private String glExtensions;
        private String glVersion;

        public GraphicDeviceInfo build() {
            String str;
            if (this.glVersion == null) {
                str = " glVersion";
            } else {
                str = "";
            }
            if (this.eglVersion == null) {
                str = e.l(str, " eglVersion");
            }
            if (this.glExtensions == null) {
                str = e.l(str, " glExtensions");
            }
            if (this.eglExtensions == null) {
                str = e.l(str, " eglExtensions");
            }
            if (str.isEmpty()) {
                return new AutoValue_GraphicDeviceInfo(this.glVersion, this.eglVersion, this.glExtensions, this.eglExtensions);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public GraphicDeviceInfo.Builder setEglExtensions(String str) {
            if (str != null) {
                this.eglExtensions = str;
                return this;
            }
            throw new NullPointerException("Null eglExtensions");
        }

        public GraphicDeviceInfo.Builder setEglVersion(String str) {
            if (str != null) {
                this.eglVersion = str;
                return this;
            }
            throw new NullPointerException("Null eglVersion");
        }

        public GraphicDeviceInfo.Builder setGlExtensions(String str) {
            if (str != null) {
                this.glExtensions = str;
                return this;
            }
            throw new NullPointerException("Null glExtensions");
        }

        public GraphicDeviceInfo.Builder setGlVersion(String str) {
            if (str != null) {
                this.glVersion = str;
                return this;
            }
            throw new NullPointerException("Null glVersion");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GraphicDeviceInfo)) {
            return false;
        }
        GraphicDeviceInfo graphicDeviceInfo = (GraphicDeviceInfo) obj;
        if (!this.glVersion.equals(graphicDeviceInfo.getGlVersion()) || !this.eglVersion.equals(graphicDeviceInfo.getEglVersion()) || !this.glExtensions.equals(graphicDeviceInfo.getGlExtensions()) || !this.eglExtensions.equals(graphicDeviceInfo.getEglExtensions())) {
            return false;
        }
        return true;
    }

    @NonNull
    public String getEglExtensions() {
        return this.eglExtensions;
    }

    @NonNull
    public String getEglVersion() {
        return this.eglVersion;
    }

    @NonNull
    public String getGlExtensions() {
        return this.glExtensions;
    }

    @NonNull
    public String getGlVersion() {
        return this.glVersion;
    }

    public int hashCode() {
        return ((((((this.glVersion.hashCode() ^ 1000003) * 1000003) ^ this.eglVersion.hashCode()) * 1000003) ^ this.glExtensions.hashCode()) * 1000003) ^ this.eglExtensions.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GraphicDeviceInfo{glVersion=");
        sb.append(this.glVersion);
        sb.append(", eglVersion=");
        sb.append(this.eglVersion);
        sb.append(", glExtensions=");
        sb.append(this.glExtensions);
        sb.append(", eglExtensions=");
        return ba.r(sb, this.eglExtensions, "}");
    }

    private AutoValue_GraphicDeviceInfo(String str, String str2, String str3, String str4) {
        this.glVersion = str;
        this.eglVersion = str2;
        this.glExtensions = str3;
        this.eglExtensions = str4;
    }
}
