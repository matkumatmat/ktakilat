package com.appsflyer.internal;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class f implements OnSuccessListener {
    public final /* synthetic */ AFb1cSDK c;

    public /* synthetic */ f(AFb1cSDK aFb1cSDK) {
        this.c = aFb1cSDK;
    }

    public final void onSuccess(Object obj) {
        AFb1cSDK.AFAdRevenueData(this.c, (AppSetIdInfo) obj);
    }
}
