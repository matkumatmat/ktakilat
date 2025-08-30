package androidx.camera.video;

import android.util.Size;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public final /* synthetic */ int c;

    public /* synthetic */ a(int i) {
        this.c = i;
    }

    public final int compare(Object obj, Object obj2) {
        return QualityRatioToResolutionsTable.lambda$sortQualityRatioRow$0(this.c, (Size) obj, (Size) obj2);
    }
}
