package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class d implements Deferred.DeferredHandler {
    public final /* synthetic */ Deferred.DeferredHandler c;
    public final /* synthetic */ Deferred.DeferredHandler d;

    public /* synthetic */ d(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2) {
        this.c = deferredHandler;
        this.d = deferredHandler2;
    }

    public final void handle(Provider provider) {
        OptionalProvider.lambda$whenAvailable$2(this.c, this.d, provider);
    }
}
