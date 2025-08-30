package androidx.camera.view;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class g implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreviewStreamStateObserver f38a;

    public /* synthetic */ g(PreviewStreamStateObserver previewStreamStateObserver) {
        this.f38a = previewStreamStateObserver;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f38a.lambda$startPreviewStreamStateFlow$0((Void) obj);
    }
}
