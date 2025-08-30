package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.lifecycle.Observer;

public final /* synthetic */ class o implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Camera2CameraInfoImpl.RedirectableLiveData f12a;

    public /* synthetic */ o(Camera2CameraInfoImpl.RedirectableLiveData redirectableLiveData) {
        this.f12a = redirectableLiveData;
    }

    public final void onChanged(Object obj) {
        this.f12a.setValue(obj);
    }
}
