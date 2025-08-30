package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class e implements EventHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging.AutoInit f314a;

    public /* synthetic */ e(FirebaseMessaging.AutoInit autoInit) {
        this.f314a = autoInit;
    }

    public final void handle(Event event) {
        this.f314a.lambda$initialize$0(event);
    }
}
