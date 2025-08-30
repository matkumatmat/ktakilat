package androidx.camera.video.internal.encoder;

final class AutoValue_VideoEncoderDataSpace extends VideoEncoderDataSpace {
    private final int range;
    private final int standard;
    private final int transfer;

    public AutoValue_VideoEncoderDataSpace(int i, int i2, int i3) {
        this.standard = i;
        this.transfer = i2;
        this.range = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoEncoderDataSpace)) {
            return false;
        }
        VideoEncoderDataSpace videoEncoderDataSpace = (VideoEncoderDataSpace) obj;
        if (this.standard == videoEncoderDataSpace.getStandard() && this.transfer == videoEncoderDataSpace.getTransfer() && this.range == videoEncoderDataSpace.getRange()) {
            return true;
        }
        return false;
    }

    public int getRange() {
        return this.range;
    }

    public int getStandard() {
        return this.standard;
    }

    public int getTransfer() {
        return this.transfer;
    }

    public int hashCode() {
        return ((((this.standard ^ 1000003) * 1000003) ^ this.transfer) * 1000003) ^ this.range;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoEncoderDataSpace{standard=");
        sb.append(this.standard);
        sb.append(", transfer=");
        sb.append(this.transfer);
        sb.append(", range=");
        return ba.q(sb, "}", this.range);
    }
}
