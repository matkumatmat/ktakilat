package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.inject.Provider;
import java.util.Map;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(int i, Object obj, Object obj2) {
        this.c = i;
        this.e = obj;
        this.d = obj2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((OptionalProvider) this.e).set((Provider) this.d);
                return;
            case 1:
                ((LazySet) this.e).add((Provider) this.d);
                return;
            default:
                ((EventHandler) ((Map.Entry) this.e).getKey()).handle((Event) this.d);
                return;
        }
    }
}
