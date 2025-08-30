package com.ktakilat.cbase.weight;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.webkit.WebSettings;
import com.ktakilat.cbase.datacollect.PCollectorManager;

public class CommonWebView extends NestedScrollWebView {
    public boolean i = false;

    public CommonWebView(Context context) {
        super(context);
        a();
    }

    public final void a() {
        clearHistory();
        setBackgroundColor(Color.argb(255, 255, 255, 255));
        WebSettings settings = getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(false);
        settings.setLoadsImagesAutomatically(true);
        settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        settings.setAllowFileAccess(true);
        settings.setCacheMode(2);
        try {
            String str = PCollectorManager.f469a;
            PCollectorManager.h = settings.getUserAgentString();
        } catch (Exception unused) {
        }
    }

    public CommonWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CommonWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
