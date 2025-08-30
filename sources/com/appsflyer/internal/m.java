package com.appsflyer.internal;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.appsflyer.internal.AFi1aSDK;

public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ AFi1aSDK.AnonymousClass2 c;
    public final /* synthetic */ InstallReferrerClient d;
    public final /* synthetic */ Context e;
    public final /* synthetic */ int f;

    public /* synthetic */ m(AFi1aSDK.AnonymousClass2 r1, InstallReferrerClient installReferrerClient, Context context, int i) {
        this.c = r1;
        this.d = installReferrerClient;
        this.e = context;
        this.f = i;
    }

    public final void run() {
        this.c.lambda$onInstallReferrerSetupFinished$0(this.d, this.e, this.f);
    }
}
