package defpackage;

import android.view.View;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.video.internal.audio.AudioStream;
import com.google.android.material.internal.ViewUtils;

/* renamed from: p0  reason: default package */
public final /* synthetic */ class p0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Object e;

    public /* synthetic */ p0(int i, Object obj, boolean z) {
        this.c = i;
        this.e = obj;
        this.d = z;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((AudioStream.AudioStreamCallback) this.e).onSilenceStateChanged(this.d);
                return;
            case 1:
                ((Camera2CameraControl) this.e).lambda$setActive$6(this.d);
                return;
            default:
                ViewUtils.showKeyboard((View) this.e, this.d);
                return;
        }
    }
}
