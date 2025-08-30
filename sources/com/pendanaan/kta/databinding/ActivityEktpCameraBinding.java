package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.weight.VerticallyTextView;
import com.ktakilat.loan.R;
import com.ktakilat.loan.normal_ui.HoleView;

public final class ActivityEktpCameraBinding implements ViewBinding {
    @NonNull
    public final PreviewView cameraxPreview;
    @NonNull
    public final HoleView holeView;
    @NonNull
    public final ImageView ivBack;
    @NonNull
    public final ImageView ivCancle;
    @NonNull
    public final ImageView ivOk;
    @NonNull
    public final ImageView ivShutter;
    @NonNull
    public final ImageView llCameraMask;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final VerticallyTextView verticallyTextView;
    @NonNull
    public final View viewClickBack;

    private ActivityEktpCameraBinding(@NonNull ConstraintLayout constraintLayout, @NonNull PreviewView previewView, @NonNull HoleView holeView2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ProgressBar progressBar2, @NonNull VerticallyTextView verticallyTextView2, @NonNull View view) {
        this.rootView = constraintLayout;
        this.cameraxPreview = previewView;
        this.holeView = holeView2;
        this.ivBack = imageView;
        this.ivCancle = imageView2;
        this.ivOk = imageView3;
        this.ivShutter = imageView4;
        this.llCameraMask = imageView5;
        this.progressBar = progressBar2;
        this.verticallyTextView = verticallyTextView2;
        this.viewClickBack = view;
    }

    @NonNull
    public static ActivityEktpCameraBinding bind(@NonNull View view) {
        int i = R.id.cameraxPreview;
        PreviewView previewView = (PreviewView) ViewBindings.findChildViewById(view, R.id.cameraxPreview);
        if (previewView != null) {
            i = R.id.holeView;
            HoleView holeView2 = (HoleView) ViewBindings.findChildViewById(view, R.id.holeView);
            if (holeView2 != null) {
                i = R.id.ivBack;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ivBack);
                if (imageView != null) {
                    i = R.id.ivCancle;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivCancle);
                    if (imageView2 != null) {
                        i = R.id.ivOk;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivOk);
                        if (imageView3 != null) {
                            i = R.id.ivShutter;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivShutter);
                            if (imageView4 != null) {
                                i = R.id.llCameraMask;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.llCameraMask);
                                if (imageView5 != null) {
                                    i = R.id.progressBar;
                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
                                    if (progressBar2 != null) {
                                        i = R.id.verticallyTextView;
                                        VerticallyTextView verticallyTextView2 = (VerticallyTextView) ViewBindings.findChildViewById(view, R.id.verticallyTextView);
                                        if (verticallyTextView2 != null) {
                                            i = R.id.viewClickBack;
                                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.viewClickBack);
                                            if (findChildViewById != null) {
                                                return new ActivityEktpCameraBinding((ConstraintLayout) view, previewView, holeView2, imageView, imageView2, imageView3, imageView4, imageView5, progressBar2, verticallyTextView2, findChildViewById);
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
    public static ActivityEktpCameraBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityEktpCameraBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_ektp_camera, viewGroup, false);
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
