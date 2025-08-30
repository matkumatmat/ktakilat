package com.ktakilat.loan.webtool;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.web.CommonWebActivity;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.ktakilat.loan.weiget.VersionUtil;
import org.greenrobot.eventbus.EventBus;

public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ CommonWebViewSetting.JsCallAndroidInterface d;
    public final /* synthetic */ Object e;

    public /* synthetic */ a(CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface, Object obj, int i) {
        this.c = i;
        this.d = jsCallAndroidInterface;
        this.e = obj;
    }

    /* JADX WARNING: type inference failed for: r4v12, types: [com.ktakilat.loan.main.EventHomeAct, java.lang.Object] */
    public final void run() {
        String str;
        boolean z;
        boolean z2;
        String str2;
        int i;
        switch (this.c) {
            case 0:
                JsonObject jsonObject = (JsonObject) this.e;
                this.d.getClass();
                try {
                    jsonObject.get("startColor").getAsString();
                    jsonObject.get("endColor").getAsString();
                    return;
                } catch (Exception e2) {
                    LogUtil.a(e2);
                    return;
                }
            case 1:
                JsonObject jsonObject2 = (JsonObject) this.e;
                CommonWebViewSetting.OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener = this.d.c;
                try {
                    if (jsonObject2.get("needIntercept") != null) {
                        onCommonWebViewSettingEventListener.e(jsonObject2.get("needIntercept").getAsBoolean());
                        return;
                    }
                    return;
                } catch (Exception e3) {
                    LogUtil.a(e3);
                    return;
                }
            case 2:
                JsonObject jsonObject3 = (JsonObject) this.e;
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface = this.d;
                jsCallAndroidInterface.getClass();
                try {
                    if (jsonObject3.get("url") == null) {
                        str = null;
                    } else {
                        str = jsonObject3.get("url").getAsString();
                    }
                    boolean isEmpty = TextUtils.isEmpty(str);
                    BaseActivity baseActivity = jsCallAndroidInterface.b;
                    if (!isEmpty) {
                        if (!str.startsWith("https://play.google.com/store/apps/details?id=") && !str.startsWith("market://details?id=")) {
                            if (str.startsWith("http")) {
                                VersionUtil.c(baseActivity, str);
                                return;
                            }
                        }
                    }
                    VersionUtil.b(baseActivity, str);
                    return;
                } catch (Exception e4) {
                    LogUtil.a(e4);
                    return;
                }
            case 3:
                JsonObject jsonObject4 = (JsonObject) this.e;
                BaseActivity baseActivity2 = this.d.b;
                try {
                    boolean z3 = false;
                    if (jsonObject4.get("needRefresh") == null || !jsonObject4.get("needRefresh").getAsBoolean()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (jsonObject4.get("needPreventClose") != null && jsonObject4.get("needPreventClose").getAsBoolean()) {
                        z3 = true;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("needRefresh", z);
                    baseActivity2.setResult(-1, intent);
                    if (baseActivity2 instanceof CommonWebActivity) {
                        ((CommonWebActivity) baseActivity2).z(z3);
                        return;
                    } else {
                        baseActivity2.finish();
                        return;
                    }
                } catch (Exception e5) {
                    LogUtil.a(e5);
                    return;
                }
            case 4:
                JsonObject jsonObject5 = (JsonObject) this.e;
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface2 = this.d;
                BaseActivity baseActivity3 = jsCallAndroidInterface2.b;
                CommonWebView commonWebView = jsCallAndroidInterface2.f577a;
                if (commonWebView != null) {
                    try {
                        if (commonWebView.canGoBack()) {
                            commonWebView.goBack();
                            return;
                        }
                    } catch (Exception e6) {
                        LogUtil.a(e6);
                        return;
                    }
                }
                if (jsonObject5.get("needRefresh") == null || !jsonObject5.get("needRefresh").getAsBoolean()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("needRefresh", z2);
                baseActivity3.setResult(-1, intent2);
                baseActivity3.finish();
                return;
            case 5:
                JsonObject jsonObject6 = (JsonObject) this.e;
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface3 = this.d;
                jsCallAndroidInterface3.getClass();
                try {
                    ToastUtil.d(jsCallAndroidInterface3.b, jsonObject6.get("toastStr").getAsString());
                    return;
                } catch (Exception e7) {
                    LogUtil.a(e7);
                    return;
                }
            case 6:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface4 = this.d;
                jsCallAndroidInterface4.getClass();
                JsonObject jsonObject7 = (JsonObject) this.e;
                JsonElement jsonElement = jsonObject7.get("scene");
                if (jsonElement != null) {
                    int asInt = jsonElement.getAsInt();
                    JsonElement jsonElement2 = jsonObject7.get("otpType");
                    if (jsonElement2 != null) {
                        int asInt2 = jsonElement2.getAsInt();
                        KtakilatApplication.m.getClass();
                        if (KtakilatApplication.h()) {
                            KtakilatApplication.m.getClass();
                            VerifyMgr.k(jsCallAndroidInterface4.b, KtakilatApplication.f().getMobileNo(), Integer.valueOf(asInt), Integer.valueOf(asInt2));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 7:
                JsonObject jsonObject8 = (JsonObject) this.e;
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface5 = this.d;
                jsCallAndroidInterface5.getClass();
                try {
                    KeybordUtils.a(jsCallAndroidInterface5.b);
                    String str3 = null;
                    if (jsonObject8.get("title") == null) {
                        str2 = null;
                    } else {
                        str2 = jsonObject8.get("title").getAsString();
                    }
                    String asString = jsonObject8.get("url").getAsString();
                    JsonElement jsonElement3 = jsonObject8.get("surfaceColor");
                    if (jsonElement3 != null) {
                        str3 = jsonElement3.getAsString();
                    }
                    boolean z4 = false;
                    if (str3 != null) {
                        if (!str3.startsWith("#")) {
                            str3 = "#".concat(str3);
                        }
                        try {
                            i = Color.parseColor(str3);
                        } catch (Exception unused) {
                        }
                        JsonElement jsonElement4 = jsonObject8.get("showStatusBar");
                        if (jsonElement4 != null && jsonElement4.getAsBoolean()) {
                            z4 = true;
                        }
                        CommonWebActivity.C(jsCallAndroidInterface5.b, str2, asString, z4, i);
                        return;
                    }
                    i = 0;
                    JsonElement jsonElement42 = jsonObject8.get("showStatusBar");
                    z4 = true;
                    CommonWebActivity.C(jsCallAndroidInterface5.b, str2, asString, z4, i);
                    return;
                } catch (Exception e8) {
                    LogUtil.a(e8);
                    return;
                }
            default:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface6 = this.d;
                jsCallAndroidInterface6.getClass();
                String str4 = (String) this.e;
                if (TextUtils.isEmpty(str4) || str4.equals("{}")) {
                    str4 = null;
                }
                EventBus b = EventBus.b();
                boolean isEmpty2 = TextUtils.isEmpty(str4);
                ? obj = new Object();
                obj.f525a = null;
                obj.b = null;
                obj.f525a = Boolean.valueOf(isEmpty2);
                obj.b = str4;
                b.e(obj);
                CommonWebViewSetting.this.j.postDelayed(new Runnable(str4) {
                    public final /* synthetic */ String c;

                    {
                        this.c = r2;
                    }

                    public final void run() {
                        HomeActivity.C(JsCallAndroidInterface.this.b, this.c, false);
                    }
                }, 500);
                return;
        }
    }
}
