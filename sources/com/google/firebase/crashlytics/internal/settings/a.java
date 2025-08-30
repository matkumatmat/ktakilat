package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {
    public final /* synthetic */ SettingsController.AnonymousClass1 c;

    public /* synthetic */ a(SettingsController.AnonymousClass1 r1) {
        this.c = r1;
    }

    public final Object call() {
        return this.c.lambda$then$0();
    }
}
