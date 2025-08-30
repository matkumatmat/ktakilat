package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Timebase;

public interface EncoderConfig {
    public static final int CODEC_PROFILE_NONE = -1;

    @NonNull
    Timebase getInputTimebase();

    @NonNull
    String getMimeType();

    int getProfile();

    @NonNull
    MediaFormat toMediaFormat() throws InvalidConfigException;
}
