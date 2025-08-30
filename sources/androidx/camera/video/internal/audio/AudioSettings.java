package androidx.camera.video.internal.audio;

import android.annotation.SuppressLint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.camera.video.internal.audio.AutoValue_AudioSettings;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class AudioSettings {
    public static final List<Integer> COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(new Integer[]{48000, 44100, 22050, 11025, 8000, 4800}));

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract AudioSettings autoBuild();

        @NonNull
        public final AudioSettings build() {
            String str;
            AudioSettings autoBuild = autoBuild();
            if (autoBuild.getAudioSource() == -1) {
                str = " audioSource";
            } else {
                str = "";
            }
            if (autoBuild.getSampleRate() <= 0) {
                str = e.l(str, " sampleRate");
            }
            if (autoBuild.getChannelCount() <= 0) {
                str = e.l(str, " channelCount");
            }
            if (autoBuild.getAudioFormat() == -1) {
                str = e.l(str, " audioFormat");
            }
            if (str.isEmpty()) {
                return autoBuild;
            }
            throw new IllegalArgumentException("Required settings missing or non-positive:".concat(str));
        }

        @NonNull
        public abstract Builder setAudioFormat(int i);

        @NonNull
        public abstract Builder setAudioSource(int i);

        @NonNull
        public abstract Builder setChannelCount(@IntRange(from = 1) int i);

        @NonNull
        public abstract Builder setSampleRate(@IntRange(from = 1) int i);
    }

    @SuppressLint({"Range"})
    @NonNull
    public static Builder builder() {
        return new AutoValue_AudioSettings.Builder().setAudioSource(-1).setSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
    }

    public abstract int getAudioFormat();

    public abstract int getAudioSource();

    public int getBytesPerFrame() {
        return AudioUtils.getBytesPerFrame(getAudioFormat(), getChannelCount());
    }

    @IntRange(from = 1)
    public abstract int getChannelCount();

    @IntRange(from = 1)
    public abstract int getSampleRate();

    @NonNull
    public abstract Builder toBuilder();
}
