package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;

public final class ImmediateSurface extends DeferrableSurface {
    private final Surface mSurface;

    public ImmediateSurface(@NonNull Surface surface, @NonNull Size size, int i) {
        super(size, i);
        this.mSurface = surface;
    }

    @NonNull
    public ListenableFuture<Surface> provideSurface() {
        return Futures.immediateFuture(this.mSurface);
    }

    public ImmediateSurface(@NonNull Surface surface) {
        this.mSurface = surface;
    }
}
