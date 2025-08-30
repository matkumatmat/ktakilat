package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.config.AutoValue_VideoMimeInfo;
import androidx.camera.video.internal.config.MimeInfo;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class VideoMimeInfo extends MimeInfo {

    @AutoValue.Builder
    public static abstract class Builder extends MimeInfo.Builder<Builder> {
        @NonNull
        public abstract VideoMimeInfo build();

        @NonNull
        public abstract Builder setCompatibleVideoProfile(@Nullable EncoderProfilesProxy.VideoProfileProxy videoProfileProxy);
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return (Builder) new AutoValue_VideoMimeInfo.Builder().setMimeType(str).setProfile(-1);
    }

    @Nullable
    public abstract EncoderProfilesProxy.VideoProfileProxy getCompatibleVideoProfile();
}
