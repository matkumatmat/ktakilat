package androidx.camera.extensions.internal.sessionprocessor;

import android.media.Image;
import androidx.annotation.Nullable;

public interface ImageReference {
    boolean decrement();

    @Nullable
    Image get();

    boolean increment();
}
