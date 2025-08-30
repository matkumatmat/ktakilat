package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class ActivityHomeHomeBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final View titleBar;
    @NonNull
    public final FrameLayout vpFrameLayout;

    private ActivityHomeHomeBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.titleBar = view;
        this.vpFrameLayout = frameLayout;
    }

    @NonNull
    public static ActivityHomeHomeBinding bind(@NonNull View view) {
        int i = R.id.title_bar;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.title_bar);
        if (findChildViewById != null) {
            i = R.id.vp_frame_layout;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.vp_frame_layout);
            if (frameLayout != null) {
                return new ActivityHomeHomeBinding((RelativeLayout) view, findChildViewById, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityHomeHomeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityHomeHomeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_home_home, viewGroup, false);
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
