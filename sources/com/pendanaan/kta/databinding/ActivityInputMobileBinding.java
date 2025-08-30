package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivityInputMobileBinding implements ViewBinding {
    @NonNull
    public final LinearLayout formView;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    public final AppCompatButton passSubmit;
    @NonNull
    public final EditText phoneInputEdit;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView tipIvChangeMobile;
    @NonNull
    public final ImageView tipIvForgetPwd;
    @NonNull
    public final TextView top1Tv;
    @NonNull
    public final TextView top2Tv;

    private ActivityInputMobileBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull AppCompatButton appCompatButton, @NonNull EditText editText, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.formView = linearLayout;
        this.pageTitle = cWidgetActionBarBinding;
        this.passSubmit = appCompatButton;
        this.phoneInputEdit = editText;
        this.tipIvChangeMobile = imageView;
        this.tipIvForgetPwd = imageView2;
        this.top1Tv = textView;
        this.top2Tv = textView2;
    }

    @NonNull
    public static ActivityInputMobileBinding bind(@NonNull View view) {
        int i = R.id.form_view;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.form_view);
        if (linearLayout != null) {
            i = R.id.page_title;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
            if (findChildViewById != null) {
                CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                i = R.id.pass_submit;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.pass_submit);
                if (appCompatButton != null) {
                    i = R.id.phone_input_edit;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.phone_input_edit);
                    if (editText != null) {
                        i = R.id.tip_iv_change_mobile;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.tip_iv_change_mobile);
                        if (imageView != null) {
                            i = R.id.tip_iv_forget_pwd;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.tip_iv_forget_pwd);
                            if (imageView2 != null) {
                                i = R.id.top_1_tv;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.top_1_tv);
                                if (textView != null) {
                                    i = R.id.top_2_tv;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.top_2_tv);
                                    if (textView2 != null) {
                                        return new ActivityInputMobileBinding((RelativeLayout) view, linearLayout, bind, appCompatButton, editText, imageView, imageView2, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityInputMobileBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityInputMobileBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_input_mobile, viewGroup, false);
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
