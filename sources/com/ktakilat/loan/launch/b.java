package com.ktakilat.loan.launch;

import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.collect.LocationInfo;
import com.ktakilat.loan.weiget.GpsUtil;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.trello.rxlifecycle2.LifecycleTransformer;
import java.util.ArrayList;
import java.util.List;

public final /* synthetic */ class b implements GpsUtil.GpsIgnoreCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LauncherActivity f509a;

    public /* synthetic */ b(LauncherActivity launcherActivity) {
        this.f509a = launcherActivity;
    }

    public final void a(double d, double d2) {
        int i = LauncherActivity.q;
        this.f509a.getClass();
        if (d == 0.0d && d2 == 0.0d) {
            PhoneUploadUtil.f();
            return;
        }
        LocationInfo locationInfo = new LocationInfo();
        locationInfo.lat = d;
        locationInfo.lng = d2;
        AppHttp.uploadLocation((LifecycleTransformer<BaseResponse<Object>>) null, JsonUtil.a(locationInfo)).subscribe(new ApiObserver<BaseResponse<Object>>() {
            public final void a(BaseResponse baseResponse) {
                LocationInfo locationInfo = LocationInfo.this;
                List h = AppKv.h();
                if (h == null) {
                    h = new ArrayList(0);
                }
                h.add(locationInfo);
                AppKv.g().b("location_list", JsonUtil.a(h));
            }

            public final void b(BaseResponse baseResponse) {
                PhoneUploadUtil.f();
            }
        });
    }
}
