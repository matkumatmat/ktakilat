package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class ActivityCityPickerBinding implements ViewBinding {
    @NonNull
    public final TextView citySwitch;
    @NonNull
    public final TextView districtSwitch;
    @NonNull
    public final FrameLayout fragmentContainer;
    @NonNull
    public final LinearLayout main;
    @NonNull
    public final TextView provinceSwitch;
    @NonNull
    private final LinearLayout rootView;

    private ActivityCityPickerBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3) {
        this.rootView = linearLayout;
        this.citySwitch = textView;
        this.districtSwitch = textView2;
        this.fragmentContainer = frameLayout;
        this.main = linearLayout2;
        this.provinceSwitch = textView3;
    }

    @NonNull
    public static ActivityCityPickerBinding bind(@NonNull View view) {
        int i = R.id.city_switch;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.city_switch);
        if (textView != null) {
            i = R.id.district_switch;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.district_switch);
            if (textView2 != null) {
                i = R.id.fragment_container;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.fragment_container);
                if (frameLayout != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    i = R.id.province_switch;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.province_switch);
                    if (textView3 != null) {
                        return new ActivityCityPickerBinding(linearLayout, textView, textView2, frameLayout, linearLayout, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityCityPickerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityCityPickerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_city_picker, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
