package androidx.camera.view;

import androidx.lifecycle.Observer;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ForwardingLiveData f37a;

    public /* synthetic */ d(ForwardingLiveData forwardingLiveData) {
        this.f37a = forwardingLiveData;
    }

    public final void onChanged(Object obj) {
        this.f37a.setValue(obj);
    }
}
