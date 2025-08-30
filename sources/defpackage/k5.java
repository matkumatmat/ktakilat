package defpackage;

import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.Recorder;
import androidx.camera.video.VideoSpec;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Consumer;

/* renamed from: k5  reason: default package */
public final /* synthetic */ class k5 implements Consumer {
    public final /* synthetic */ int c;

    public /* synthetic */ k5(int i) {
        this.c = i;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                return;
            case 1:
                androidx.camera.extensions.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                return;
            case 2:
                androidx.camera.video.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                return;
            case 3:
                androidx.camera.view.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                return;
            case 4:
                androidx.camera.camera2.internal.compat.quirk.DeviceQuirks.lambda$static$0((QuirkSettings) obj);
                return;
            case 5:
                IntentSanitizer.lambda$sanitizeByThrowing$1((String) obj);
                return;
            case 6:
                IntentSanitizer.lambda$sanitizeByFiltering$0((String) obj);
                return;
            default:
                ((VideoSpec.Builder) obj).setAspectRatio(Recorder.VIDEO_SPEC_DEFAULT.getAspectRatio());
                return;
        }
    }
}
