package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivityFaceLoginOnoffBinding implements ViewBinding {
    @NonNull
    public final LinearLayout faceContentLayout;
    @NonNull
    public final TextView faceTipBottom;
    @NonNull
    public final TextView faceTipTop;
    @NonNull
    public final ImageView iv;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final LinearLayout rootView;

    private ActivityFaceLoginOnoffBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding) {
        this.rootView = linearLayout;
        this.faceContentLayout = linearLayout2;
        this.faceTipBottom = textView;
        this.faceTipTop = textView2;
        this.iv = imageView;
        this.pageTitle = cWidgetActionBarBinding;
    }

    @NonNull
    public static ActivityFaceLoginOnoffBinding bind(@NonNull View view) {
        int i = R.id.face_content_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.face_content_layout);
        if (linearLayout != null) {
            i = R.id.face_tip_bottom;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.face_tip_bottom);
            if (textView != null) {
                i = R.id.face_tip_top;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.face_tip_top);
                if (textView2 != null) {
                    i = R.id.iv;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv);
                    if (imageView != null) {
                        i = R.id.page_title;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                        if (findChildViewById != null) {
                            return new ActivityFaceLoginOnoffBinding((LinearLayout) view, linearLayout, textView, textView2, imageView, CWidgetActionBarBinding.bind(findChildViewById));
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityFaceLoginOnoffBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityFaceLoginOnoffBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_face_login_onoff, viewGroup, false);
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
