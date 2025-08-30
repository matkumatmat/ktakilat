package com.ktakilat.loan.webtool;

import com.google.android.gms.maps.model.LatLng;
import com.ktakilat.cbase.utils.location.LocationUtils;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public final /* synthetic */ class g implements ObservableOnSubscribe {
    public final /* synthetic */ CommonWebViewSetting.JsCallAndroidInterface c;
    public final /* synthetic */ double d;
    public final /* synthetic */ double e;

    public /* synthetic */ g(CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface, double d2, double d3) {
        this.c = jsCallAndroidInterface;
        this.d = d2;
        this.e = d3;
    }

    public final void d(ObservableEmitter observableEmitter) {
        CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface = this.c;
        jsCallAndroidInterface.getClass();
        observableEmitter.onNext(LocationUtils.a(jsCallAndroidInterface.b, new LatLng(this.d, this.e)));
        observableEmitter.onComplete();
    }
}
