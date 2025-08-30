package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.ktakilat.loan.R;

public final class ActivityNewPasswordBinding implements ViewBinding {
    @NonNull
    public final CircularProgressIndicator loading;
    @NonNull
    public final ScrollView main;
    @NonNull
    public final EditText newPassword;
    @NonNull
    public final TextView newPasswordHint;
    @NonNull
    public final AppCompatButton nextOperation;
    @NonNull
    private final ScrollView rootView;
    @NonNull
    public final AppCompatButton visibilityToggle;

    private ActivityNewPasswordBinding(@NonNull ScrollView scrollView, @NonNull CircularProgressIndicator circularProgressIndicator, @NonNull ScrollView scrollView2, @NonNull EditText editText, @NonNull TextView textView, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatButton appCompatButton2) {
        this.rootView = scrollView;
        this.loading = circularProgressIndicator;
        this.main = scrollView2;
        this.newPassword = editText;
        this.newPasswordHint = textView;
        this.nextOperation = appCompatButton;
        this.visibilityToggle = appCompatButton2;
    }

    @NonNull
    public static ActivityNewPasswordBinding bind(@NonNull View view) {
        int i = R.id.loading;
        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, R.id.loading);
        if (circularProgressIndicator != null) {
            ScrollView scrollView = (ScrollView) view;
            i = R.id.new_password;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.new_password);
            if (editText != null) {
                i = R.id.new_password_hint;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.new_password_hint);
                if (textView != null) {
                    i = R.id.next_operation;
                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.next_operation);
                    if (appCompatButton != null) {
                        i = R.id.visibility_toggle;
                        AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.visibility_toggle);
                        if (appCompatButton2 != null) {
                            return new ActivityNewPasswordBinding(scrollView, circularProgressIndicator, scrollView, editText, textView, appCompatButton, appCompatButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityNewPasswordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityNewPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_new_password, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ScrollView getRoot() {
        return this.rootView;
    }
}
