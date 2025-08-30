package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivityBaseVerifyCodeBinding implements ViewBinding {
    @NonNull
    public final TextView changeAnotherOtp;
    @NonNull
    public final EditText codeEdit;
    @NonNull
    public final TextView commitButton;
    @NonNull
    public final TextView getCodePhone;
    @NonNull
    public final LinearLayout layCode;
    @NonNull
    public final TextView moreTv;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    public final LinearLayout phoneLayout;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView tip2Tv;
    @NonNull
    public final TextView verifyResendCodeTitle;
    @NonNull
    public final View viewSpliteHead;

    private ActivityBaseVerifyCodeBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull EditText editText, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull TextView textView4, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull LinearLayout linearLayout2, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull View view) {
        this.rootView = relativeLayout;
        this.changeAnotherOtp = textView;
        this.codeEdit = editText;
        this.commitButton = textView2;
        this.getCodePhone = textView3;
        this.layCode = linearLayout;
        this.moreTv = textView4;
        this.pageTitle = cWidgetActionBarBinding;
        this.phoneLayout = linearLayout2;
        this.tip2Tv = textView5;
        this.verifyResendCodeTitle = textView6;
        this.viewSpliteHead = view;
    }

    @NonNull
    public static ActivityBaseVerifyCodeBinding bind(@NonNull View view) {
        int i = R.id.change_another_otp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.change_another_otp);
        if (textView != null) {
            i = R.id.code_edit;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.code_edit);
            if (editText != null) {
                i = R.id.commit_button;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.commit_button);
                if (textView2 != null) {
                    i = R.id.get_code_phone;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.get_code_phone);
                    if (textView3 != null) {
                        i = R.id.lay_code;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.lay_code);
                        if (linearLayout != null) {
                            i = R.id.more_tv;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.more_tv);
                            if (textView4 != null) {
                                i = R.id.page_title;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                                if (findChildViewById != null) {
                                    CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                                    i = R.id.phone_layout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.phone_layout);
                                    if (linearLayout2 != null) {
                                        i = R.id.tip_2_tv;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tip_2_tv);
                                        if (textView5 != null) {
                                            i = R.id.verify_resend_code_title;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.verify_resend_code_title);
                                            if (textView6 != null) {
                                                i = R.id.viewSpliteHead;
                                                View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.viewSpliteHead);
                                                if (findChildViewById2 != null) {
                                                    return new ActivityBaseVerifyCodeBinding((RelativeLayout) view, textView, editText, textView2, textView3, linearLayout, textView4, bind, linearLayout2, textView5, textView6, findChildViewById2);
                                                }
                                            }
                                        }
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
    public static ActivityBaseVerifyCodeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityBaseVerifyCodeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_base_verify_code, viewGroup, false);
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
