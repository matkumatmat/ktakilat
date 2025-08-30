package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.Nullable;

public interface OutputConfig {
    @Nullable
    MediaFormat getMediaFormat();
}
