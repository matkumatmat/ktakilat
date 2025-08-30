package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.ModernAppBarBinding;
import com.ktakilat.loan.R;

public final class ActivityResetPwdBinding implements ViewBinding {
    @NonNull
    public final EditText edtPassword;
    @NonNull
    public final EditText edtPassword2;
    @NonNull
    public final LinearLayout formView;
    @NonNull
    public final ModernAppBarBinding pageTitle;
    @NonNull
    public final AppCompatButton passSubmit;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView showPassword;
    @NonNull
    public final ImageView showPassword2;
    @NonNull
    public final TextView tvSetPassWordTip;

    private ActivityResetPwdBinding(@NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull EditText editText2, @NonNull LinearLayout linearLayout2, @NonNull ModernAppBarBinding modernAppBarBinding, @NonNull AppCompatButton appCompatButton, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.edtPassword = editText;
        this.edtPassword2 = editText2;
        this.formView = linearLayout2;
        this.pageTitle = modernAppBarBinding;
        this.passSubmit = appCompatButton;
        this.showPassword = imageView;
        this.showPassword2 = imageView2;
        this.tvSetPassWordTip = textView;
    }

    @NonNull
    public static ActivityResetPwdBinding bind(@NonNull View view) {
        int i = R.id.edt_password;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.edt_password);
        if (editText != null) {
            i = R.id.edt_password_2;
            EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.edt_password_2);
            if (editText2 != null) {
                i = R.id.form_view;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.form_view);
                if (linearLayout != null) {
                    i = R.id.page_title;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                    if (findChildViewById != null) {
                        ModernAppBarBinding bind = ModernAppBarBinding.bind(findChildViewById);
                        i = R.id.pass_submit;
                        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.pass_submit);
                        if (appCompatButton != null) {
                            i = R.id.show_password;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.show_password);
                            if (imageView != null) {
                                i = R.id.show_password_2;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.show_password_2);
                                if (imageView2 != null) {
                                    i = R.id.tvSetPassWordTip;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tvSetPassWordTip);
                                    if (textView != null) {
                                        return new ActivityResetPwdBinding((LinearLayout) view, editText, editText2, linearLayout, bind, appCompatButton, imageView, imageView2, textView);
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
    public static ActivityResetPwdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityResetPwdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_reset_pwd, viewGroup, false);
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
