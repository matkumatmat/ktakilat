package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class CDialogPickOtpTypeBinding implements ViewBinding {
    @NonNull
    public final TextView contentText;
    @NonNull
    public final AppCompatButton defaultOtpType;
    @NonNull
    public final TextView phoneNumber;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatButton whatsappOtpType;

    private CDialogPickOtpTypeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull AppCompatButton appCompatButton, @NonNull TextView textView2, @NonNull AppCompatButton appCompatButton2) {
        this.rootView = constraintLayout;
        this.contentText = textView;
        this.defaultOtpType = appCompatButton;
        this.phoneNumber = textView2;
        this.whatsappOtpType = appCompatButton2;
    }

    @NonNull
    public static CDialogPickOtpTypeBinding bind(@NonNull View view) {
        int i = R.id.content_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.content_text);
        if (textView != null) {
            i = R.id.default_otp_type;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.default_otp_type);
            if (appCompatButton != null) {
                i = R.id.phone_number;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.phone_number);
                if (textView2 != null) {
                    i = R.id.whatsapp_otp_type;
                    AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.whatsapp_otp_type);
                    if (appCompatButton2 != null) {
                        return new CDialogPickOtpTypeBinding((ConstraintLayout) view, textView, appCompatButton, textView2, appCompatButton2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CDialogPickOtpTypeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CDialogPickOtpTypeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_dialog_pick_otp_type, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
