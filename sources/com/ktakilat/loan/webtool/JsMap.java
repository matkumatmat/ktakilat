package com.ktakilat.loan.webtool;

import android.webkit.WebView;
import com.google.gson.JsonObject;

public class JsMap {

    public static class DialogMap {
    }

    public static class PermissionMap {
    }

    public static class ThirdMap {
        public static void a(WebView webView, boolean z, String str) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("result", Boolean.valueOf(z));
            jsonObject.addProperty("processToken", str);
            JsMap.a(webView, "naviCallLoanVerifyResult", jsonObject.toString());
        }

        public static void b(WebView webView, double d, double d2, String str) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("lat", (Number) Double.valueOf(d));
            jsonObject.addProperty("lng", (Number) Double.valueOf(d2));
            jsonObject.addProperty("address", str);
            if (webView != null) {
                JsMap.a(webView, "naviCallLocationResult", jsonObject.toString());
            }
        }
    }

    public static void a(WebView webView, String str, String str2) {
        webView.postDelayed(new ib(0, webView, str + "('" + str2 + "')"), 10);
    }
}
