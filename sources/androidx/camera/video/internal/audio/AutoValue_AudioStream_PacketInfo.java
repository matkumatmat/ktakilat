package androidx.camera.video.internal.audio;

import androidx.camera.video.internal.audio.AudioStream;

final class AutoValue_AudioStream_PacketInfo extends AudioStream.PacketInfo {
    private final int sizeInBytes;
    private final long timestampNs;

    public AutoValue_AudioStream_PacketInfo(int i, long j) {
        this.sizeInBytes = i;
        this.timestampNs = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioStream.PacketInfo)) {
            return false;
        }
        AudioStream.PacketInfo packetInfo = (AudioStream.PacketInfo) obj;
        if (this.sizeInBytes == packetInfo.getSizeInBytes() && this.timestampNs == packetInfo.getTimestampNs()) {
            return true;
        }
        return false;
    }

    public int getSizeInBytes() {
        return this.sizeInBytes;
    }

    public long getTimestampNs() {
        return this.timestampNs;
    }

    public int hashCode() {
        long j = this.timestampNs;
        return ((this.sizeInBytes ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PacketInfo{sizeInBytes=");
        sb.append(this.sizeInBytes);
        sb.append(", timestampNs=");
        return ba.p(sb, this.timestampNs, "}");
    }
}
