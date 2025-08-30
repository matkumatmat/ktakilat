package androidx.camera.video;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.video.AutoValue_AudioSpec;
import com.google.auto.value.AutoValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@AutoValue
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class AudioSpec {
    @NonNull
    public static final Range<Integer> BITRATE_RANGE_AUTO = new Range<>(0, Integer.MAX_VALUE);
    public static final int CHANNEL_COUNT_AUTO = -1;
    public static final int CHANNEL_COUNT_MONO = 1;
    public static final int CHANNEL_COUNT_NONE = 0;
    public static final int CHANNEL_COUNT_STEREO = 2;
    public static final AudioSpec NO_AUDIO = builder().setChannelCount(0).build();
    @NonNull
    public static final Range<Integer> SAMPLE_RATE_RANGE_AUTO = new Range<>(0, Integer.MAX_VALUE);
    public static final int SOURCE_AUTO = -1;
    public static final int SOURCE_CAMCORDER = 5;
    public static final int SOURCE_FORMAT_AUTO = -1;
    public static final int SOURCE_FORMAT_PCM_16BIT = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract AudioSpec build();

        @NonNull
        public abstract Builder setBitrate(@NonNull Range<Integer> range);

        @NonNull
        public abstract Builder setChannelCount(int i);

        @NonNull
        public abstract Builder setSampleRate(@NonNull Range<Integer> range);

        @NonNull
        public abstract Builder setSource(int i);

        @NonNull
        public abstract Builder setSourceFormat(int i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ChannelCount {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_AudioSpec.Builder().setSourceFormat(-1).setSource(-1).setChannelCount(-1).setBitrate(BITRATE_RANGE_AUTO).setSampleRate(SAMPLE_RATE_RANGE_AUTO);
    }

    @NonNull
    public abstract Range<Integer> getBitrate();

    public abstract int getChannelCount();

    @NonNull
    public abstract Range<Integer> getSampleRate();

    public abstract int getSource();

    public abstract int getSourceFormat();

    @NonNull
    public abstract Builder toBuilder();
}
