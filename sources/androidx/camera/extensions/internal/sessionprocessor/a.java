package androidx.camera.extensions.internal.sessionprocessor;

import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.extensions.internal.sessionprocessor.PreviewProcessor;
import java.util.List;

public final /* synthetic */ class a implements PreviewProcessor.OnCaptureResultCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasicExtenderSessionProcessor f30a;
    public final /* synthetic */ SessionProcessor.CaptureCallback b;
    public final /* synthetic */ int c;
    public final /* synthetic */ TagBundle d;

    public /* synthetic */ a(BasicExtenderSessionProcessor basicExtenderSessionProcessor, SessionProcessor.CaptureCallback captureCallback, int i, TagBundle tagBundle) {
        this.f30a = basicExtenderSessionProcessor;
        this.b = captureCallback;
        this.c = i;
        this.d = tagBundle;
    }

    public final void onCaptureResult(long j, List list) {
        this.f30a.lambda$startRepeating$0(this.b, this.c, this.d, j, list);
    }
}
