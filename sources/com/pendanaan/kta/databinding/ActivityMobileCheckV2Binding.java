package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.ktakilat.loan.R;
import com.ktakilat.loan.mobile_check.MobileCheckEditText;

public final class ActivityMobileCheckV2Binding implements ViewBinding {
    @NonNull
    public final TextView bottomLink;
    @NonNull
    public final TextView editHint;
    @NonNull
    public final MobileCheckEditText editText;
    @NonNull
    public final ImageView header;
    @NonNull
    public final LinearLayout linearLayout;
    @NonNull
    public final CircularProgressIndicator loading;
    @NonNull
    public final ScrollView main;
    @NonNull
    public final AppCompatButton next;
    @NonNull
    public final TextView phoneNumberPrefix;
    @NonNull
    private final ScrollView rootView;
    @NonNull
    public final LinearLayout start8Hint;
    @NonNull
    public final TextView title;

    private ActivityMobileCheckV2Binding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MobileCheckEditText mobileCheckEditText, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull CircularProgressIndicator circularProgressIndicator, @NonNull ScrollView scrollView2, @NonNull AppCompatButton appCompatButton, @NonNull TextView textView3, @NonNull LinearLayout linearLayout3, @NonNull TextView textView4) {
        this.rootView = scrollView;
        this.bottomLink = textView;
        this.editHint = textView2;
        this.editText = mobileCheckEditText;
        this.header = imageView;
        this.linearLayout = linearLayout2;
        this.loading = circularProgressIndicator;
        this.main = scrollView2;
        this.next = appCompatButton;
        this.phoneNumberPrefix = textView3;
        this.start8Hint = linearLayout3;
        this.title = textView4;
    }

    @NonNull
    public static ActivityMobileCheckV2Binding bind(@NonNull View view) {
        int i = R.id.bottom_link;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bottom_link);
        if (textView != null) {
            i = R.id.edit_hint;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.edit_hint);
            if (textView2 != null) {
                i = R.id.edit_text;
                MobileCheckEditText mobileCheckEditText = (MobileCheckEditText) ViewBindings.findChildViewById(view, R.id.edit_text);
                if (mobileCheckEditText != null) {
                    i = R.id.header;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.header);
                    if (imageView != null) {
                        i = R.id.linearLayout;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout);
                        if (linearLayout2 != null) {
                            i = R.id.loading;
                            CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, R.id.loading);
                            if (circularProgressIndicator != null) {
                                ScrollView scrollView = (ScrollView) view;
                                i = R.id.next;
                                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.next);
                                if (appCompatButton != null) {
                                    i = R.id.phone_number_prefix;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.phone_number_prefix);
                                    if (textView3 != null) {
                                        i = R.id.start_8_hint;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.start_8_hint);
                                        if (linearLayout3 != null) {
                                            i = R.id.title;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                            if (textView4 != null) {
                                                return new ActivityMobileCheckV2Binding(scrollView, textView, textView2, mobileCheckEditText, imageView, linearLayout2, circularProgressIndicator, scrollView, appCompatButton, textView3, linearLayout3, textView4);
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
    public static ActivityMobileCheckV2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityMobileCheckV2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_mobile_check_v2, viewGroup, false);
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
