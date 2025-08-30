package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.weight.circleprogress.CircleProgressBar;
import com.ktakilat.loan.R;

public final class ActivityLaunchLauncherBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout ignoreLayout;
    @NonNull
    public final CircleProgressBar ignoreProgress;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView splashSrc;

    private ActivityLaunchLauncherBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull CircleProgressBar circleProgressBar, @NonNull ImageView imageView) {
        this.rootView = relativeLayout;
        this.ignoreLayout = relativeLayout2;
        this.ignoreProgress = circleProgressBar;
        this.splashSrc = imageView;
    }

    @NonNull
    public static ActivityLaunchLauncherBinding bind(@NonNull View view) {
        int i = R.id.ignore_layout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.ignore_layout);
        if (relativeLayout != null) {
            i = R.id.ignore_progress;
            CircleProgressBar circleProgressBar = (CircleProgressBar) ViewBindings.findChildViewById(view, R.id.ignore_progress);
            if (circleProgressBar != null) {
                i = R.id.splash_src;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.splash_src);
                if (imageView != null) {
                    return new ActivityLaunchLauncherBinding((RelativeLayout) view, relativeLayout, circleProgressBar, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityLaunchLauncherBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityLaunchLauncherBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_launch_launcher, viewGroup, false);
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
