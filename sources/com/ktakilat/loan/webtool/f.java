package com.ktakilat.loan.webtool;

import com.google.gson.JsonObject;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

public final /* synthetic */ class f implements DialogUtils.SingleSelectCallback {
    public final /* synthetic */ CommonWebViewSetting.JsCallAndroidInterface c;
    public final /* synthetic */ String d;

    public /* synthetic */ f(CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface, String str) {
        this.c = jsCallAndroidInterface;
        this.d = str;
    }

    public final void a(int i, String str) {
        CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface = this.c;
        jsCallAndroidInterface.getClass();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("chooseStr", str);
        jsonObject.addProperty("choosePosition", (Number) Integer.valueOf(i));
        jsonObject.addProperty("type", this.d);
        JsMap.a(jsCallAndroidInterface.f577a, "naviCallSingleChooseResult", jsonObject.toString());
    }
}
