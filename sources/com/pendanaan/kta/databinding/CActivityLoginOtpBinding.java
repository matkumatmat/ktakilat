package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.cbase.weight.MarqueeTextView;
import com.ktakilat.loan.R;

public final class CActivityLoginOtpBinding implements ViewBinding {
    @NonNull
    public final TextView changeAnotherOtp;
    @NonNull
    public final EditText codeEt;
    @NonNull
    public final MarqueeTextView hourseTv;
    @NonNull
    public final TextView loginTv;
    @NonNull
    public final ImageView loginV1Tip1;
    @NonNull
    public final TextView mobileTv;
    @NonNull
    public final TextView moreTv;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView sendCodeTv;
    @NonNull
    public final TextView tip2Tv;
    @NonNull
    public final TextView tip3Tv;

    private CActivityLoginOtpBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull EditText editText, @NonNull MarqueeTextView marqueeTextView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7) {
        this.rootView = relativeLayout;
        this.changeAnotherOtp = textView;
        this.codeEt = editText;
        this.hourseTv = marqueeTextView;
        this.loginTv = textView2;
        this.loginV1Tip1 = imageView;
        this.mobileTv = textView3;
        this.moreTv = textView4;
        this.pageTitle = cWidgetActionBarBinding;
        this.sendCodeTv = textView5;
        this.tip2Tv = textView6;
        this.tip3Tv = textView7;
    }

    @NonNull
    public static CActivityLoginOtpBinding bind(@NonNull View view) {
        int i = R.id.change_another_otp;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.change_another_otp);
        if (textView != null) {
            i = R.id.code_et;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.code_et);
            if (editText != null) {
                i = R.id.hourse_tv;
                MarqueeTextView marqueeTextView = (MarqueeTextView) ViewBindings.findChildViewById(view, R.id.hourse_tv);
                if (marqueeTextView != null) {
                    i = R.id.login_tv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.login_tv);
                    if (textView2 != null) {
                        i = R.id.login_v1_tip_1;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.login_v1_tip_1);
                        if (imageView != null) {
                            i = R.id.mobile_tv;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.mobile_tv);
                            if (textView3 != null) {
                                i = R.id.more_tv;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.more_tv);
                                if (textView4 != null) {
                                    i = R.id.page_title;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                                    if (findChildViewById != null) {
                                        CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                                        i = R.id.send_code_tv;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.send_code_tv);
                                        if (textView5 != null) {
                                            i = R.id.tip_2_tv;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tip_2_tv);
                                            if (textView6 != null) {
                                                i = R.id.tip_3_tv;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tip_3_tv);
                                                if (textView7 != null) {
                                                    return new CActivityLoginOtpBinding((RelativeLayout) view, textView, editText, marqueeTextView, textView2, imageView, textView3, textView4, bind, textView5, textView6, textView7);
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
    public static CActivityLoginOtpBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CActivityLoginOtpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_activity_login_otp, viewGroup, false);
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
