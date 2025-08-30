package androidx.camera.video;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class OutputResults {
    @NonNull
    public static OutputResults of(@NonNull Uri uri) {
        Preconditions.checkNotNull(uri, "OutputUri cannot be null.");
        return new AutoValue_OutputResults(uri);
    }

    @NonNull
    public abstract Uri getOutputUri();
}
