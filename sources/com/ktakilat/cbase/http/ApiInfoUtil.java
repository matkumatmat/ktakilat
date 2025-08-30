package com.ktakilat.cbase.http;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.ktakilat.cbase.BaseKv;
import com.ktakilat.cbase.http.phone.DeviceExInfo;
import com.ktakilat.cbase.http.phone.DeviceInfo;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.JsonUtil;

public class ApiInfoUtil {
    public static volatile ApiInfoUtil d;

    /* renamed from: a  reason: collision with root package name */
    public final DeviceInfo f470a;
    public final DeviceExInfo b;
    public DeviceInfoCall c;

    public interface DeviceInfoCall {
        void a(DeviceExInfo deviceExInfo);

        void b(DeviceInfo deviceInfo);

        void c(DeviceInfo deviceInfo, DeviceExInfo deviceExInfo);

        BaseApplication getContext();
    }

    public ApiInfoUtil() {
        DeviceInfo deviceInfo = (DeviceInfo) JsonUtil.c(BaseKv.a().f465a.getString(DeviceRequestsHelper.DEVICE_INFO_PARAM, ""), DeviceInfo.class);
        this.f470a = deviceInfo;
        DeviceExInfo deviceExInfo = (DeviceExInfo) JsonUtil.c(BaseKv.a().f465a.getString("device_ex_info", ""), DeviceExInfo.class);
        this.b = deviceExInfo;
        if (deviceInfo == null) {
            this.f470a = new DeviceInfo();
        }
        if (deviceExInfo == null) {
            this.b = new DeviceExInfo();
        }
    }

    public static ApiInfoUtil b() {
        if (d == null) {
            synchronized (ApiInfoUtil.class) {
                try {
                    if (d == null) {
                        d = new ApiInfoUtil();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public final synchronized String a() {
        try {
            if (this.f470a != null) {
                if (this.b == null) {
                }
                this.c.b(this.f470a);
                BaseKv.a().b("device_ex_info", JsonUtil.a(this.b));
            }
            c();
            this.c.b(this.f470a);
            BaseKv.a().b("device_ex_info", JsonUtil.a(this.b));
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return JsonUtil.a(this.f470a);
    }

    public final synchronized void c() {
        this.c.c(this.f470a, this.b);
        BaseKv.a().b(DeviceRequestsHelper.DEVICE_INFO_PARAM, JsonUtil.a(this.f470a));
        BaseKv.a().b("device_ex_info", JsonUtil.a(this.b));
    }

    public final synchronized void d(DeviceInfoCall deviceInfoCall) {
        this.c = deviceInfoCall;
    }
}
