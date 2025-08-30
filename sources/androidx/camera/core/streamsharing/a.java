package androidx.camera.core.streamsharing;

import androidx.camera.core.streamsharing.StreamSharing;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class a implements StreamSharing.Control {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamSharing f28a;

    public /* synthetic */ a(StreamSharing streamSharing) {
        this.f28a = streamSharing;
    }

    public final ListenableFuture jpegSnapshot(int i, int i2) {
        return this.f28a.lambda$new$0(i, i2);
    }
}
