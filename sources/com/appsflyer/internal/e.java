package com.appsflyer.internal;

import com.appsflyer.internal.AFa1tSDK;
import kotlin.jvm.functions.Function0;

public final /* synthetic */ class e implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Object invoke() {
        switch (this.c) {
            case 0:
                return ((AFa1tSDK.AFa1vSDK) this.d).getRevenue();
            default:
                return ((AFc1eSDK) this.d).m_();
        }
    }
}
