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
import com.ktakilat.loan.weiget.gesture.PatternLockerView;

public final class ActivityGestureLoginBinding implements ViewBinding {
    @NonNull
    public final TextView mobileTv;
    @NonNull
    public final TextView moreTv;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView statusTv;
    @NonNull
    public final TextView tipTv;
    @NonNull
    public final PatternLockerView touchView;

    private ActivityGestureLoginBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull PatternLockerView patternLockerView) {
        this.rootView = relativeLayout;
        this.mobileTv = textView;
        this.moreTv = textView2;
        this.pageTitle = cWidgetActionBarBinding;
        this.statusTv = textView3;
        this.tipTv = textView4;
        this.touchView = patternLockerView;
    }

    @NonNull
    public static ActivityGestureLoginBinding bind(@NonNull View view) {
        int i = R.id.mobile_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.mobile_tv);
        if (textView != null) {
            i = R.id.more_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.more_tv);
            if (textView2 != null) {
                i = R.id.page_title;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                if (findChildViewById != null) {
                    CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                    i = R.id.status_tv;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.status_tv);
                    if (textView3 != null) {
                        i = R.id.tip_tv;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tip_tv);
                        if (textView4 != null) {
                            i = R.id.touch_view;
                            PatternLockerView patternLockerView = (PatternLockerView) ViewBindings.findChildViewById(view, R.id.touch_view);
                            if (patternLockerView != null) {
                                return new ActivityGestureLoginBinding((RelativeLayout) view, textView, textView2, bind, textView3, textView4, patternLockerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityGestureLoginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityGestureLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_gesture_login, viewGroup, false);
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
