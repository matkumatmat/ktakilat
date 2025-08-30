package com.katkilat.baidu_face.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.katkilat.baidu_face.R;

public abstract class WidgetActionBar2Binding extends ViewDataBinding {
    @NonNull
    public final Button backward;
    @NonNull
    public final TextView title;
    @NonNull
    public final RelativeLayout widgetActionBar;

    public WidgetActionBar2Binding(Object obj, View view, int i, Button button, TextView textView, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.backward = button;
        this.title = textView;
        this.widgetActionBar = relativeLayout;
    }

    public static WidgetActionBar2Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static WidgetActionBar2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static WidgetActionBar2Binding bind(@NonNull View view, @Nullable Object obj) {
        return (WidgetActionBar2Binding) ViewDataBinding.bind(obj, view, R.layout.widget_action_bar2);
    }

    @NonNull
    @Deprecated
    public static WidgetActionBar2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (WidgetActionBar2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.widget_action_bar2, viewGroup, z, obj);
    }

    @NonNull
    public static WidgetActionBar2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static WidgetActionBar2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (WidgetActionBar2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.widget_action_bar2, (ViewGroup) null, false, obj);
    }
}
