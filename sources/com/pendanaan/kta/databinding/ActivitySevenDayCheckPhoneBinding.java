package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivitySevenDayCheckPhoneBinding implements ViewBinding {
    @NonNull
    public final TextView buttonChangePhone;
    @NonNull
    public final Button buttonGetCode;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    public final TextView phoneTxt;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView verifyInputPhoneTitle;
    @NonNull
    public final ImageView verifyPhoneIcon;

    private ActivitySevenDayCheckPhoneBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull Button button, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView) {
        this.rootView = relativeLayout;
        this.buttonChangePhone = textView;
        this.buttonGetCode = button;
        this.pageTitle = cWidgetActionBarBinding;
        this.phoneTxt = textView2;
        this.verifyInputPhoneTitle = textView3;
        this.verifyPhoneIcon = imageView;
    }

    @NonNull
    public static ActivitySevenDayCheckPhoneBinding bind(@NonNull View view) {
        int i = R.id.button_change_phone;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.button_change_phone);
        if (textView != null) {
            i = R.id.button_get_code;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_get_code);
            if (button != null) {
                i = R.id.page_title;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                if (findChildViewById != null) {
                    CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                    i = R.id.phone_txt;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.phone_txt);
                    if (textView2 != null) {
                        i = R.id.verify_input_phone_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.verify_input_phone_title);
                        if (textView3 != null) {
                            i = R.id.verify_phone_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.verify_phone_icon);
                            if (imageView != null) {
                                return new ActivitySevenDayCheckPhoneBinding((RelativeLayout) view, textView, button, bind, textView2, textView3, imageView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivitySevenDayCheckPhoneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivitySevenDayCheckPhoneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_seven_day_check_phone, viewGroup, false);
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
