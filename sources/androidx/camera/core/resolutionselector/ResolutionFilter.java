package androidx.camera.core.resolutionselector;

import android.util.Size;
import androidx.annotation.NonNull;
import java.util.List;

public interface ResolutionFilter {
    @NonNull
    List<Size> filter(@NonNull List<Size> list, int i);
}
