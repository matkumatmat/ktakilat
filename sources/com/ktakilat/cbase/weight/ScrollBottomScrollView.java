package com.ktakilat.cbase.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class ScrollBottomScrollView extends ScrollView {

    public interface OnScrollBottomListener {
    }

    public ScrollBottomScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        getHeight();
        getScrollY();
        childAt.getHeight();
    }
}
