package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.Recorder;
import androidx.core.util.Consumer;
import java.util.concurrent.Executor;

final class AutoValue_Recorder_RecordingRecord extends Recorder.RecordingRecord {
    private final Executor getCallbackExecutor;
    private final Consumer<VideoRecordEvent> getEventListener;
    private final OutputOptions getOutputOptions;
    private final long getRecordingId;
    private final boolean hasAudioEnabled;
    private final boolean isPersistent;

    public AutoValue_Recorder_RecordingRecord(OutputOptions outputOptions, @Nullable Executor executor, @Nullable Consumer<VideoRecordEvent> consumer, boolean z, boolean z2, long j) {
        if (outputOptions != null) {
            this.getOutputOptions = outputOptions;
            this.getCallbackExecutor = executor;
            this.getEventListener = consumer;
            this.hasAudioEnabled = z;
            this.isPersistent = z2;
            this.getRecordingId = j;
            return;
        }
        throw new NullPointerException("Null getOutputOptions");
    }

    public boolean equals(Object obj) {
        Executor executor;
        Consumer<VideoRecordEvent> consumer;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Recorder.RecordingRecord)) {
            return false;
        }
        Recorder.RecordingRecord recordingRecord = (Recorder.RecordingRecord) obj;
        if (!this.getOutputOptions.equals(recordingRecord.getOutputOptions()) || ((executor = this.getCallbackExecutor) != null ? !executor.equals(recordingRecord.getCallbackExecutor()) : recordingRecord.getCallbackExecutor() != null) || ((consumer = this.getEventListener) != null ? !consumer.equals(recordingRecord.getEventListener()) : recordingRecord.getEventListener() != null) || this.hasAudioEnabled != recordingRecord.hasAudioEnabled() || this.isPersistent != recordingRecord.isPersistent() || this.getRecordingId != recordingRecord.getRecordingId()) {
            return false;
        }
        return true;
    }

    @Nullable
    public Executor getCallbackExecutor() {
        return this.getCallbackExecutor;
    }

    @Nullable
    public Consumer<VideoRecordEvent> getEventListener() {
        return this.getEventListener;
    }

    @NonNull
    public OutputOptions getOutputOptions() {
        return this.getOutputOptions;
    }

    public long getRecordingId() {
        return this.getRecordingId;
    }

    public boolean hasAudioEnabled() {
        return this.hasAudioEnabled;
    }

    public int hashCode() {
        int i;
        int i2;
        int hashCode = (this.getOutputOptions.hashCode() ^ 1000003) * 1000003;
        Executor executor = this.getCallbackExecutor;
        int i3 = 0;
        if (executor == null) {
            i = 0;
        } else {
            i = executor.hashCode();
        }
        int i4 = (hashCode ^ i) * 1000003;
        Consumer<VideoRecordEvent> consumer = this.getEventListener;
        if (consumer != null) {
            i3 = consumer.hashCode();
        }
        int i5 = (i4 ^ i3) * 1000003;
        int i6 = 1237;
        if (this.hasAudioEnabled) {
            i2 = 1231;
        } else {
            i2 = 1237;
        }
        int i7 = (i5 ^ i2) * 1000003;
        if (this.isPersistent) {
            i6 = 1231;
        }
        long j = this.getRecordingId;
        return ((i7 ^ i6) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RecordingRecord{getOutputOptions=");
        sb.append(this.getOutputOptions);
        sb.append(", getCallbackExecutor=");
        sb.append(this.getCallbackExecutor);
        sb.append(", getEventListener=");
        sb.append(this.getEventListener);
        sb.append(", hasAudioEnabled=");
        sb.append(this.hasAudioEnabled);
        sb.append(", isPersistent=");
        sb.append(this.isPersistent);
        sb.append(", getRecordingId=");
        return ba.p(sb, this.getRecordingId, "}");
    }
}
