package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivityBaseVerifyFaceBinding implements ViewBinding {
    @NonNull
    public final LinearLayout faceContentLayout;
    @NonNull
    public final TextView faceSecondTip;
    @NonNull
    public final TextView faceTopTip;
    @NonNull
    public final ImageView guideImage;
    @NonNull
    public final LinearLayout linearLayout2;
    @NonNull
    public final AppCompatButton moreTv;
    @NonNull
    public final AppCompatButton openFaceButton;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityBaseVerifyFaceBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout3, @NonNull AppCompatButton appCompatButton, @NonNull AppCompatButton appCompatButton2, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding) {
        this.rootView = constraintLayout;
        this.faceContentLayout = linearLayout;
        this.faceSecondTip = textView;
        this.faceTopTip = textView2;
        this.guideImage = imageView;
        this.linearLayout2 = linearLayout3;
        this.moreTv = appCompatButton;
        this.openFaceButton = appCompatButton2;
        this.pageTitle = cWidgetActionBarBinding;
    }

    @NonNull
    public static ActivityBaseVerifyFaceBinding bind(@NonNull View view) {
        int i = R.id.face_content_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.face_content_layout);
        if (linearLayout != null) {
            i = R.id.face_second_tip;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.face_second_tip);
            if (textView != null) {
                i = R.id.face_top_tip;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.face_top_tip);
                if (textView2 != null) {
                    i = R.id.guide_image;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.guide_image);
                    if (imageView != null) {
                        i = R.id.linearLayout2;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout2);
                        if (linearLayout3 != null) {
                            i = R.id.more_tv;
                            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.more_tv);
                            if (appCompatButton != null) {
                                i = R.id.open_face_button;
                                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.open_face_button);
                                if (appCompatButton2 != null) {
                                    i = R.id.page_title;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                                    if (findChildViewById != null) {
                                        return new ActivityBaseVerifyFaceBinding((ConstraintLayout) view, linearLayout, textView, textView2, imageView, linearLayout3, appCompatButton, appCompatButton2, CWidgetActionBarBinding.bind(findChildViewById));
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
    public static ActivityBaseVerifyFaceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityBaseVerifyFaceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_base_verify_face, viewGroup, false);
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
