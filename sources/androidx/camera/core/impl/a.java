package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c = 1;
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.Result result) {
        this.d = liveDataObserverAdapter;
        this.e = result;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((LiveDataObservable) this.e).lambda$removeObserver$3(this.d);
                return;
            default:
                this.d.lambda$onChanged$0((LiveDataObservable.Result) this.e);
                return;
        }
    }

    public /* synthetic */ a(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter) {
        this.e = liveDataObservable;
        this.d = liveDataObserverAdapter;
    }
}
