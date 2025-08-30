package defpackage;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.internal.ScreenFlashWrapper;

/* renamed from: he  reason: default package */
public final /* synthetic */ class he implements ImageCapture.ScreenFlashListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ScreenFlashWrapper f199a;

    public /* synthetic */ he(ScreenFlashWrapper screenFlashWrapper) {
        this.f199a = screenFlashWrapper;
    }

    public final void onCompleted() {
        ScreenFlashWrapper.apply$lambda$2(this.f199a);
    }
}
