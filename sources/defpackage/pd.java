package defpackage;

import android.util.Range;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.VideoSpec;
import androidx.core.util.Consumer;

/* renamed from: pd  reason: default package */
public final /* synthetic */ class pd implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ pd(int i, int i2) {
        this.c = i2;
        this.d = i;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                ((VideoSpec.Builder) obj).setBitrate(new Range(Integer.valueOf(this.d), Integer.valueOf(this.d)));
                return;
            case 1:
                ((AudioSpec.Builder) obj).setSource(this.d);
                return;
            default:
                ((VideoSpec.Builder) obj).setAspectRatio(this.d);
                return;
        }
    }
}
