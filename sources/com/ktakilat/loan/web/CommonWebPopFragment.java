package com.ktakilat.loan.web;

import android.graphics.Color;
import android.os.Bundle;
import com.google.gson.JsonObject;
import com.ktakilat.loan.web.CommonWebFragment;
import com.ktakilat.loan.webtool.JsMap;
import java.util.HashMap;
import org.apache.commons.lang3.CharEncoding;

public class CommonWebPopFragment extends CommonWebFragment {
    public String x;

    public final void g(Bundle bundle) {
        if (bundle != null) {
            this.x = bundle.getString("htmlCode");
            this.x = ba.r(new StringBuilder(" <div style=\"align-items: center;display: flex;justify-content: center;height:100%\">"), this.x, "</div>");
            this.i = Boolean.valueOf(bundle.getBoolean("isNeedLogin", false));
            this.j = Boolean.valueOf(bundle.getBoolean("isHome", false));
            this.g = bundle.getString("createKey");
        }
    }

    public final void h() {
        this.e.setBackgroundColor(Color.argb(0, 255, 255, 255));
        this.e.setBackgroundColor(0);
        String str = this.g;
        HashMap hashMap = WebViewCache.f573a;
        if (!hashMap.containsKey(str)) {
            Boolean bool = Boolean.FALSE;
            this.q = bool;
            CommonWebFragment.CacheBuilder cacheBuilder = this.r;
            cacheBuilder.b = bool;
            cacheBuilder.f572a = false;
            this.e.loadDataWithBaseURL((String) null, this.x, "text/html", CharEncoding.UTF_8, (String) null);
            return;
        }
        String str2 = this.g;
        synchronized (WebViewCache.class) {
            hashMap.remove(str2);
        }
        CommonWebFragment.CacheBuilder cacheBuilder2 = this.r;
        if (!cacheBuilder2.f572a) {
            cacheBuilder2.b = Boolean.FALSE;
            i(true);
            return;
        }
        this.q = cacheBuilder2.b;
        this.p = false;
    }

    public final void i(boolean z) {
        if (this.e == null) {
            return;
        }
        if (!this.q.booleanValue() || z) {
            f(new Runnable() {
                public final void run() {
                    CommonWebPopFragment.this.e.reload();
                }
            });
        } else {
            JsMap.a(this.e, "naviCallRefresh", new JsonObject().toString());
        }
    }

    public final void j() {
    }
}
