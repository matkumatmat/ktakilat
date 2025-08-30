package com.google.firebase.messaging;

import com.google.firebase.messaging.WithinAppServiceConnection;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ i(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((SharedPreferencesQueue) this.d).syncState();
                return;
            default:
                ((WithinAppServiceConnection.BindRequest) this.d).lambda$arrangeTimeout$0();
                return;
        }
    }
}
