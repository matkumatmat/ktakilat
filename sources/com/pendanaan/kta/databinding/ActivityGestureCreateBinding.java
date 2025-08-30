package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.gesture.PatternIndicatorView;
import com.ktakilat.loan.weiget.gesture.PatternLockerView;

public final class ActivityGestureCreateBinding implements ViewBinding {
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final PatternIndicatorView smallView;
    @NonNull
    public final TextView statusTv;
    @NonNull
    public final PatternLockerView touchView;

    private ActivityGestureCreateBinding(@NonNull RelativeLayout relativeLayout, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull PatternIndicatorView patternIndicatorView, @NonNull TextView textView, @NonNull PatternLockerView patternLockerView) {
        this.rootView = relativeLayout;
        this.pageTitle = cWidgetActionBarBinding;
        this.smallView = patternIndicatorView;
        this.statusTv = textView;
        this.touchView = patternLockerView;
    }

    @NonNull
    public static ActivityGestureCreateBinding bind(@NonNull View view) {
        int i = R.id.page_title;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
        if (findChildViewById != null) {
            CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
            i = R.id.small_view;
            PatternIndicatorView patternIndicatorView = (PatternIndicatorView) ViewBindings.findChildViewById(view, R.id.small_view);
            if (patternIndicatorView != null) {
                i = R.id.status_tv;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.status_tv);
                if (textView != null) {
                    i = R.id.touch_view;
                    PatternLockerView patternLockerView = (PatternLockerView) ViewBindings.findChildViewById(view, R.id.touch_view);
                    if (patternLockerView != null) {
                        return new ActivityGestureCreateBinding((RelativeLayout) view, bind, patternIndicatorView, textView, patternLockerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityGestureCreateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityGestureCreateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_gesture_create, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
