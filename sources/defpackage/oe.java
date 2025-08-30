package defpackage;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.TagBundle;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* renamed from: oe  reason: default package */
public abstract /* synthetic */ class oe {
    public static Pair a(SessionProcessor sessionProcessor) {
        return null;
    }

    public static Set b(SessionProcessor sessionProcessor) {
        return Collections.emptySet();
    }

    public static Map c(SessionProcessor sessionProcessor, Size size) {
        return Collections.emptyMap();
    }

    public static int d(SessionProcessor sessionProcessor, Config config, TagBundle tagBundle, SessionProcessor.CaptureCallback captureCallback) {
        return -1;
    }
}
