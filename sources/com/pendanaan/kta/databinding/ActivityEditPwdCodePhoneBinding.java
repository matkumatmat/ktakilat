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

public final class ActivityEditPwdCodePhoneBinding implements ViewBinding {
    @NonNull
    public final EditText codeEdit;
    @NonNull
    public final TextView commitButton;
    @NonNull
    public final TextView getCodeHeader;
    @NonNull
    public final TextView getCodePhone;
    @NonNull
    public final LinearLayout layCode;
    @NonNull
    public final LinearLayout llSendVoiceCode;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView tvSendVoiceCode;
    @NonNull
    public final TextView verifyResendCodeTitle;
    @NonNull
    public final View viewSpliteHead;

    private ActivityEditPwdCodePhoneBinding(@NonNull RelativeLayout relativeLayout, @NonNull EditText editText, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull View view) {
        this.rootView = relativeLayout;
        this.codeEdit = editText;
        this.commitButton = textView;
        this.getCodeHeader = textView2;
        this.getCodePhone = textView3;
        this.layCode = linearLayout;
        this.llSendVoiceCode = linearLayout2;
        this.pageTitle = cWidgetActionBarBinding;
        this.tvSendVoiceCode = textView4;
        this.verifyResendCodeTitle = textView5;
        this.viewSpliteHead = view;
    }

    @NonNull
    public static ActivityEditPwdCodePhoneBinding bind(@NonNull View view) {
        int i = R.id.code_edit;
        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.code_edit);
        if (editText != null) {
            i = R.id.commit_button;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.commit_button);
            if (textView != null) {
                i = R.id.get_code_header;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.get_code_header);
                if (textView2 != null) {
                    i = R.id.get_code_phone;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.get_code_phone);
                    if (textView3 != null) {
                        i = R.id.lay_code;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.lay_code);
                        if (linearLayout != null) {
                            i = R.id.llSendVoiceCode;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.llSendVoiceCode);
                            if (linearLayout2 != null) {
                                i = R.id.page_title;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                                if (findChildViewById != null) {
                                    CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
                                    i = R.id.tvSendVoiceCode;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tvSendVoiceCode);
                                    if (textView4 != null) {
                                        i = R.id.verify_resend_code_title;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.verify_resend_code_title);
                                        if (textView5 != null) {
                                            i = R.id.viewSpliteHead;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.viewSpliteHead);
                                            if (findChildViewById2 != null) {
                                                return new ActivityEditPwdCodePhoneBinding((RelativeLayout) view, editText, textView, textView2, textView3, linearLayout, linearLayout2, bind, textView4, textView5, findChildViewById2);
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
    public static ActivityEditPwdCodePhoneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityEditPwdCodePhoneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_edit_pwd_code_phone, viewGroup, false);
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
