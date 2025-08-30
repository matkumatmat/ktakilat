package androidx.camera.core;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import com.google.auto.value.AutoValue;

@AutoValue
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ImmutableImageInfo implements ImageInfo {
    @NonNull
    public static ImageInfo create(@NonNull TagBundle tagBundle, long j, int i, @NonNull Matrix matrix) {
        return new AutoValue_ImmutableImageInfo(tagBundle, j, i, matrix);
    }

    public abstract int getRotationDegrees();

    @NonNull
    public abstract Matrix getSensorToBufferTransformMatrix();

    @NonNull
    public abstract TagBundle getTagBundle();

    public abstract long getTimestamp();

    public void populateExifData(@NonNull ExifData.Builder builder) {
        builder.setOrientationDegrees(getRotationDegrees());
    }
}
