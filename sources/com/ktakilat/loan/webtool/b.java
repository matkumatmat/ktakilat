package com.ktakilat.loan.webtool;

import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.loan.webtool.CommonWebViewSetting;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CommonWebViewSetting.JsCallAndroidInterface d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ b(CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface, boolean z, int i) {
        this.c = i;
        this.d = jsCallAndroidInterface;
        this.e = z;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                boolean z = this.e;
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface = this.d;
                jsCallAndroidInterface.getClass();
                try {
                    CommonWebViewSetting.OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener = jsCallAndroidInterface.c;
                    if (onCommonWebViewSettingEventListener != null) {
                        onCommonWebViewSettingEventListener.b(z);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    LogUtil.a(e2);
                    return;
                }
            default:
                this.d.c.g(this.e);
                return;
        }
    }
}
