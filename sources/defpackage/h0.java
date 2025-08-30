package defpackage;

import androidx.camera.video.internal.config.AudioConfigUtil;
import java.util.Comparator;

/* renamed from: h0  reason: default package */
public final /* synthetic */ class h0 implements Comparator {
    public final /* synthetic */ int c;

    public /* synthetic */ h0(int i) {
        this.c = i;
    }

    public final int compare(Object obj, Object obj2) {
        return AudioConfigUtil.lambda$selectSampleRateOrNearestSupported$0(this.c, (Integer) obj, (Integer) obj2);
    }
}
