package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.cbase.weight.MaskEditText;
import com.ktakilat.loan.R;

public final class ActivityInputPwdBinding implements ViewBinding {
    @NonNull
    public final MaskEditText edtPassword;
    @NonNull
    public final LinearLayout formView;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    public final AppCompatButton passSubmit;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageButton showPassword;
    @NonNull
    public final TextView tvSetPassWordTip;

    private ActivityInputPwdBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaskEditText maskEditText, @NonNull LinearLayout linearLayout, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull AppCompatButton appCompatButton, @NonNull ImageButton imageButton, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.edtPassword = maskEditText;
        this.formView = linearLayout;
        this.pageTitle = cWidgetActionBarBinding;
        this.passSubmit = appCompatButton;
        this.showPassword = imageButton;
        this.tvSetPassWordTip = textView;
    }

    @NonNull
    public static ActivityInputPwdBinding bind(@NonNull View view) {
        int i = R.id.edt_password;
        MaskEditText maskEditText = (MaskEditText) ViewBindings.findChildViewById(view, R.id.edt_password);
        if (maskEditText != null) {
            i = R.id.form_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.form_view);
            if (linearLayout != null) {
                i = R.id.page_title;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                if (findChildViewById != null) {
                    CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                    i = R.id.pass_submit;
                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.pass_submit);
                    if (appCompatButton != null) {
                        i = R.id.show_password;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.show_password);
                        if (imageButton != null) {
                            i = R.id.tvSetPassWordTip;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tvSetPassWordTip);
                            if (textView != null) {
                                return new ActivityInputPwdBinding((RelativeLayout) view, maskEditText, linearLayout, bind, appCompatButton, imageButton, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityInputPwdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityInputPwdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_input_pwd, viewGroup, false);
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
