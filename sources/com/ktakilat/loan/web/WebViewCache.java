package com.ktakilat.loan.web;

import android.view.ViewManager;
import com.android.installreferrer.api.InstallReferrerClient;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.KtakilatApplication;
import java.util.ArrayDeque;
import java.util.HashMap;

public class WebViewCache {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap f573a = new HashMap();
    public static final ArrayDeque b = new ArrayDeque(0);

    public static CommonWebView a(String str) {
        CommonWebView commonWebView;
        if (str == null) {
            return null;
        }
        synchronized (WebViewCache.class) {
            commonWebView = (CommonWebView) f573a.get(str);
            if (commonWebView == null) {
                ArrayDeque arrayDeque = b;
                if (arrayDeque.isEmpty()) {
                    InstallReferrerClient installReferrerClient = KtakilatApplication.j;
                    commonWebView = new CommonWebView(BaseApplication.e);
                } else {
                    CommonWebView commonWebView2 = (CommonWebView) arrayDeque.pop();
                    if (arrayDeque.size() < 2) {
                        InstallReferrerClient installReferrerClient2 = KtakilatApplication.j;
                        arrayDeque.add(new CommonWebView(BaseApplication.e));
                    }
                    commonWebView = commonWebView2;
                }
            }
            if (!(commonWebView == null || commonWebView.getParent() == null)) {
                try {
                    ((ViewManager) commonWebView.getParent()).removeView(commonWebView);
                } catch (Exception e) {
                    LogUtil.a(e);
                    InstallReferrerClient installReferrerClient3 = KtakilatApplication.j;
                    commonWebView = new CommonWebView(BaseApplication.e);
                    b.add(commonWebView);
                }
            }
        }
        return commonWebView;
    }
}
