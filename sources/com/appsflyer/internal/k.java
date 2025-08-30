package com.appsflyer.internal;

import java.util.Observable;
import java.util.Observer;

public final /* synthetic */ class k implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AFj1qSDK f175a;
    public final /* synthetic */ AFf1xSDK b;

    public /* synthetic */ k(AFj1qSDK aFj1qSDK, AFf1xSDK aFf1xSDK) {
        this.f175a = aFj1qSDK;
        this.b = aFf1xSDK;
    }

    public final void update(Observable observable, Object obj) {
        AFf1xSDK.getMonetizationNetwork(this.f175a, this.b, observable, obj);
    }
}
