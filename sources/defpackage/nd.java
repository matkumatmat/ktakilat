package defpackage;

import android.view.Surface;
import androidx.camera.video.Recorder;
import androidx.camera.video.internal.encoder.Encoder;

/* renamed from: nd  reason: default package */
public final /* synthetic */ class nd implements Encoder.SurfaceInput.OnSurfaceUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f205a;

    public /* synthetic */ nd(Recorder recorder) {
        this.f205a = recorder;
    }

    public final void onSurfaceUpdate(Surface surface) {
        this.f205a.setLatestSurface(surface);
    }
}
