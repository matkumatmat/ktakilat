package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ LiveDataObservable c;
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter d;
    public final /* synthetic */ LiveDataObservable.LiveDataObserverAdapter e;

    public /* synthetic */ b(LiveDataObservable liveDataObservable, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObservable.LiveDataObserverAdapter liveDataObserverAdapter2) {
        this.c = liveDataObservable;
        this.d = liveDataObserverAdapter;
        this.e = liveDataObserverAdapter2;
    }

    public final void run() {
        this.c.lambda$addObserver$2(this.d, this.e);
    }
}
