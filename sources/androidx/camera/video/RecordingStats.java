package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class RecordingStats {
    @NonNull
    public static RecordingStats of(long j, long j2, @NonNull AudioStats audioStats) {
        boolean z;
        boolean z2 = false;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "duration must be positive value.");
        if (j2 >= 0) {
            z2 = true;
        }
        Preconditions.checkArgument(z2, "bytes must be positive value.");
        return new AutoValue_RecordingStats(j, j2, audioStats);
    }

    @NonNull
    public abstract AudioStats getAudioStats();

    public abstract long getNumBytesRecorded();

    public abstract long getRecordedDurationNanos();
}
