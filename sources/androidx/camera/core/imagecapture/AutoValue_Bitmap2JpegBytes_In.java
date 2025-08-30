package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.camera.core.imagecapture.Bitmap2JpegBytes;
import androidx.camera.core.processing.Packet;

final class AutoValue_Bitmap2JpegBytes_In extends Bitmap2JpegBytes.In {
    private final int jpegQuality;
    private final Packet<Bitmap> packet;

    public AutoValue_Bitmap2JpegBytes_In(Packet<Bitmap> packet2, int i) {
        if (packet2 != null) {
            this.packet = packet2;
            this.jpegQuality = i;
            return;
        }
        throw new NullPointerException("Null packet");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bitmap2JpegBytes.In)) {
            return false;
        }
        Bitmap2JpegBytes.In in = (Bitmap2JpegBytes.In) obj;
        if (!this.packet.equals(in.getPacket()) || this.jpegQuality != in.getJpegQuality()) {
            return false;
        }
        return true;
    }

    public int getJpegQuality() {
        return this.jpegQuality;
    }

    public Packet<Bitmap> getPacket() {
        return this.packet;
    }

    public int hashCode() {
        return ((this.packet.hashCode() ^ 1000003) * 1000003) ^ this.jpegQuality;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("In{packet=");
        sb.append(this.packet);
        sb.append(", jpegQuality=");
        return ba.q(sb, "}", this.jpegQuality);
    }
}
