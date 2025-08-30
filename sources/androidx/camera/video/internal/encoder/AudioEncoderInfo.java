package androidx.camera.video.internal.encoder;

import android.util.Range;
import androidx.annotation.NonNull;

public interface AudioEncoderInfo extends EncoderInfo {
    @NonNull
    Range<Integer> getBitrateRange();
}
