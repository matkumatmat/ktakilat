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

public final class ActivityCommonWebviewPopBinding implements ViewBinding {
    @NonNull
    public final FrameLayout frameLayout;
    @NonNull
    private final RelativeLayout rootView;

    private ActivityCommonWebviewPopBinding(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = relativeLayout;
        this.frameLayout = frameLayout2;
    }

    @NonNull
    public static ActivityCommonWebviewPopBinding bind(@NonNull View view) {
        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.frame_layout);
        if (frameLayout2 != null) {
            return new ActivityCommonWebviewPopBinding((RelativeLayout) view, frameLayout2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.frame_layout)));
    }

    @NonNull
    public static ActivityCommonWebviewPopBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityCommonWebviewPopBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_common_webview_pop, viewGroup, false);
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
