package com.trustdecision.liveness.cw.api.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class TDWebView extends WebView {
    public TDWebView(Context context) {
        super(context);
        initWebView();
    }

    private static String i1i1iI1I11iI(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "fjVZ".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    private void initWebView() {
        setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }

            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public void onPermissionRequest(PermissionRequest permissionRequest) {
                permissionRequest.grant(permissionRequest.getResources());
                permissionRequest.getOrigin();
            }
        });
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setOverScrollMode(2);
        setScrollContainer(false);
        setLongClickable(false);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setCacheMode(-1);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(false);
        settings.setDisplayZoomControls(false);
        settings.setBuiltInZoomControls(false);
        securitySettings(settings);
    }

    private static String linkxxxxx(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            int i4 = 1;
            byte b = (byte) (i ^ 1);
            byte b2 = (byte) (bArr[0] ^ 42);
            bArr[0] = b2;
            while (i4 < length) {
                byte b3 = bArr[i4];
                bArr[i4] = (byte) ((b2 ^ b3) ^ b);
                i4++;
                b2 = b3;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void securitySettings(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        removeJavascriptInterface(i1i1iI1I11iI("FQ83KAUCFDUeIDcsBygkMwINMwU="));
        removeJavascriptInterface(i1i1iI1I11iI("Bwk1PxUZPzgPBj8uHw=="));
        removeJavascriptInterface(linkxxxxx("4b50615677566d5d665863456e68487b5f6848695a64", 83));
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

    public TDWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initWebView();
    }

    public TDWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initWebView();
    }

    public TDWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initWebView();
    }
}
