package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.chaos.view.PinView;
import com.ktakilat.cbase.databinding.ModernAppBarBinding;
import com.ktakilat.loan.R;

public final class ActivityRegistOtpBinding implements ViewBinding {
    @NonNull
    public final TextView changeAnotherOtp;
    @NonNull
    public final PinView codeEdit;
    @NonNull
    public final TextView commitButton;
    @NonNull
    public final TextView getCodePhone;
    @NonNull
    public final LinearLayout llSendVoiceCode;
    @NonNull
    public final ModernAppBarBinding pageTitle;
    @NonNull
    public final LinearLayout phoneLayout;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tip2Tv;
    @NonNull
    public final TextView tvSendVoiceCode;
    @NonNull
    public final TextView verifyResendCodeTitle;

    private ActivityRegistOtpBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull PinView pinView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout2, @NonNull ModernAppBarBinding modernAppBarBinding, @NonNull LinearLayout linearLayout3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.rootView = linearLayout;
        this.changeAnotherOtp = textView;
        this.codeEdit = pinView;
        this.commitButton = textView2;
        this.getCodePhone = textView3;
        this.llSendVoiceCode = linearLayout2;
        this.pageTitle = modernAppBarBinding;
        this.phoneLayout = linearLayout3;
        this.tip2Tv = textView4;
        this.tvSendVoiceCode = textView5;
        this.verifyResendCodeTitle = textView6;
    }

    @NonNull
    public static ActivityRegistOtpBinding bind(@NonNull View view) {
        int i = R.id.change_another_otp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.change_another_otp);
        if (textView != null) {
            i = R.id.code_edit;
            PinView pinView = (PinView) ViewBindings.findChildViewById(view, R.id.code_edit);
            if (pinView != null) {
                i = R.id.commit_button;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.commit_button);
                if (textView2 != null) {
                    i = R.id.get_code_phone;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.get_code_phone);
                    if (textView3 != null) {
                        i = R.id.llSendVoiceCode;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.llSendVoiceCode);
                        if (linearLayout != null) {
                            i = R.id.page_title;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                            if (findChildViewById != null) {
                                ModernAppBarBinding bind = ModernAppBarBinding.bind(findChildViewById);
                                i = R.id.phone_layout;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.phone_layout);
                                if (linearLayout2 != null) {
                                    i = R.id.tip_2_tv;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tip_2_tv);
                                    if (textView4 != null) {
                                        i = R.id.tvSendVoiceCode;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tvSendVoiceCode);
                                        if (textView5 != null) {
                                            i = R.id.verify_resend_code_title;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.verify_resend_code_title);
                                            if (textView6 != null) {
                                                return new ActivityRegistOtpBinding((LinearLayout) view, textView, pinView, textView2, textView3, linearLayout, bind, linearLayout2, textView4, textView5, textView6);
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
    public static ActivityRegistOtpBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityRegistOtpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_regist_otp, viewGroup, false);
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
