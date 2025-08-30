package androidx.camera.camera2.internal;

import androidx.camera.core.impl.ImageReaderProxy;

public final /* synthetic */ class t0 implements ImageReaderProxy.OnImageAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ZslControlImpl f18a;

    public /* synthetic */ t0(ZslControlImpl zslControlImpl) {
        this.f18a = zslControlImpl;
    }

    public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
        this.f18a.lambda$addZslConfig$1(imageReaderProxy);
    }
}
