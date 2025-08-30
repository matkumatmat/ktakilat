package defpackage;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.compat.workaround.SurfaceSorter;
import androidx.camera.video.VideoCapture;
import com.katkilat.baidu_face.LivenessBaiduActivity;
import java.util.Comparator;

/* renamed from: a7  reason: default package */
public final /* synthetic */ class a7 implements Comparator {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a7(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final int compare(Object obj, Object obj2) {
        Object obj3 = this.d;
        switch (this.c) {
            case 0:
                return ((Number) ((e3) obj3).invoke(obj, obj2)).intValue();
            case 1:
                int i = LivenessBaiduActivity.G;
                return ((Number) ((e3) obj3).invoke(obj, obj2)).intValue();
            case 2:
                return ((SurfaceSorter) obj3).lambda$sort$0((SessionConfig.OutputConfig) obj, (SessionConfig.OutputConfig) obj2);
            default:
                return VideoCapture.lambda$adjustCropRectToValidSize$4((Rect) obj3, (Size) obj, (Size) obj2);
        }
    }
}
