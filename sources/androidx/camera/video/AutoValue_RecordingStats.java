package androidx.camera.video;

import androidx.annotation.NonNull;

final class AutoValue_RecordingStats extends RecordingStats {
    private final AudioStats audioStats;
    private final long numBytesRecorded;
    private final long recordedDurationNanos;

    public AutoValue_RecordingStats(long j, long j2, AudioStats audioStats2) {
        this.recordedDurationNanos = j;
        this.numBytesRecorded = j2;
        if (audioStats2 != null) {
            this.audioStats = audioStats2;
            return;
        }
        throw new NullPointerException("Null audioStats");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RecordingStats)) {
            return false;
        }
        RecordingStats recordingStats = (RecordingStats) obj;
        if (this.recordedDurationNanos == recordingStats.getRecordedDurationNanos() && this.numBytesRecorded == recordingStats.getNumBytesRecorded() && this.audioStats.equals(recordingStats.getAudioStats())) {
            return true;
        }
        return false;
    }

    @NonNull
    public AudioStats getAudioStats() {
        return this.audioStats;
    }

    public long getNumBytesRecorded() {
        return this.numBytesRecorded;
    }

    public long getRecordedDurationNanos() {
        return this.recordedDurationNanos;
    }

    public int hashCode() {
        long j = this.recordedDurationNanos;
        long j2 = this.numBytesRecorded;
        return this.audioStats.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        return "RecordingStats{recordedDurationNanos=" + this.recordedDurationNanos + ", numBytesRecorded=" + this.numBytesRecorded + ", audioStats=" + this.audioStats + "}";
    }
}
