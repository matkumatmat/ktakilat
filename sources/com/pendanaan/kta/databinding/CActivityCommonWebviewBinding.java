package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class CActivityCommonWebviewBinding implements ViewBinding {
    @NonNull
    public final FrameLayout frameLayout;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final LinearLayout rootView;

    private CActivityCommonWebviewBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding) {
        this.rootView = linearLayout;
        this.frameLayout = frameLayout2;
        this.pageTitle = cWidgetActionBarBinding;
    }

    @NonNull
    public static CActivityCommonWebviewBinding bind(@NonNull View view) {
        int i = R.id.frame_layout;
        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.frame_layout);
        if (frameLayout2 != null) {
            i = R.id.page_title;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
            if (findChildViewById != null) {
                return new CActivityCommonWebviewBinding((LinearLayout) view, frameLayout2, CWidgetActionBarBinding.bind(findChildViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CActivityCommonWebviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CActivityCommonWebviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_activity_common_webview, viewGroup, false);
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
