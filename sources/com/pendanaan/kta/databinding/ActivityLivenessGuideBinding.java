package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class ActivityLivenessGuideBinding implements ViewBinding {
    @NonNull
    public final ImageView imageView2;
    @NonNull
    public final LinearLayout main;
    @NonNull
    public final AppCompatButton openFaceButton;
    @NonNull
    private final LinearLayout rootView;

    private ActivityLivenessGuideBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull AppCompatButton appCompatButton) {
        this.rootView = linearLayout;
        this.imageView2 = imageView;
        this.main = linearLayout2;
        this.openFaceButton = appCompatButton;
    }

    @NonNull
    public static ActivityLivenessGuideBinding bind(@NonNull View view) {
        int i = R.id.imageView2;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView2);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.open_face_button);
            if (appCompatButton != null) {
                return new ActivityLivenessGuideBinding(linearLayout, imageView, linearLayout, appCompatButton);
            }
            i = R.id.open_face_button;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityLivenessGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityLivenessGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_liveness_guide, viewGroup, false);
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
