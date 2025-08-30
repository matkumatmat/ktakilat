package com.katkilat.baidu_face.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.katkilat.baidu_face.R;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;

public final class ViewFacePointBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout addImageLayout;
    @NonNull
    public final RelativeLayout facePointRootView;
    @NonNull
    public final FaceDetectRoundView faceView;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final FrameLayout surfaceLayout;

    private ViewFacePointBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull RelativeLayout relativeLayout3, @NonNull FaceDetectRoundView faceDetectRoundView, @NonNull FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.addImageLayout = relativeLayout2;
        this.facePointRootView = relativeLayout3;
        this.faceView = faceDetectRoundView;
        this.surfaceLayout = frameLayout;
    }

    @NonNull
    public static ViewFacePointBinding bind(@NonNull View view) {
        int i = R.id.add_image_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) view;
            i = R.id.face_view;
            FaceDetectRoundView faceDetectRoundView = (FaceDetectRoundView) ViewBindings.findChildViewById(view, i);
            if (faceDetectRoundView != null) {
                i = R.id.surface_layout;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    return new ViewFacePointBinding(relativeLayout2, relativeLayout, relativeLayout2, faceDetectRoundView, frameLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ViewFacePointBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewFacePointBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_face_point, viewGroup, false);
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
