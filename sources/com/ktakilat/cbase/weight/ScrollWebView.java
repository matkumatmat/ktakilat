package com.ktakilat.cbase.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;

public class ScrollWebView extends WebView {
    public ScrollInterface c;

    public interface ScrollInterface {
        void a();
    }

    public ScrollWebView(Context context) {
        super(context);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.c.a();
    }

    public void setOnCustomScrollChangeListener(ScrollInterface scrollInterface) {
        this.c = scrollInterface;
    }

    public void setOnScrollChangeListener(View.OnScrollChangeListener onScrollChangeListener) {
        super.setOnScrollChangeListener(onScrollChangeListener);
    }

    public ScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
