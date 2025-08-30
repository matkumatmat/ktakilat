package androidx.camera.video.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class VideoValidatedEncoderProfilesProxy implements EncoderProfilesProxy {
    @NonNull
    public static VideoValidatedEncoderProfilesProxy create(int i, int i2, @NonNull List<EncoderProfilesProxy.AudioProfileProxy> list, @NonNull List<EncoderProfilesProxy.VideoProfileProxy> list2) {
        EncoderProfilesProxy.AudioProfileProxy audioProfileProxy;
        Preconditions.checkArgument(!list2.isEmpty(), "Should contain at least one VideoProfile.");
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy = list2.get(0);
        if (!list.isEmpty()) {
            audioProfileProxy = list.get(0);
        } else {
            audioProfileProxy = null;
        }
        return new AutoValue_VideoValidatedEncoderProfilesProxy(i, i2, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)), audioProfileProxy, videoProfileProxy);
    }

    @NonNull
    public static VideoValidatedEncoderProfilesProxy from(@NonNull EncoderProfilesProxy encoderProfilesProxy) {
        return create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), encoderProfilesProxy.getVideoProfiles());
    }

    @Nullable
    public abstract EncoderProfilesProxy.AudioProfileProxy getDefaultAudioProfile();

    @NonNull
    public abstract EncoderProfilesProxy.VideoProfileProxy getDefaultVideoProfile();
}
