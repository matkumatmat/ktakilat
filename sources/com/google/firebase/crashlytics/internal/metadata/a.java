package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ UserMetadata.SerializeableKeysMap c;

    public /* synthetic */ a(UserMetadata.SerializeableKeysMap serializeableKeysMap) {
        this.c = serializeableKeysMap;
    }

    public final void run() {
        this.c.lambda$scheduleSerializationTaskIfNeeded$0();
    }
}
