package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ktakilat.loan.R;

public final class ActivityReceiveWacodeBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout main;
    @NonNull
    private final ConstraintLayout rootView;

    private ActivityReceiveWacodeBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.main = constraintLayout2;
    }

    @NonNull
    public static ActivityReceiveWacodeBinding bind(@NonNull View view) {
        if (view != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            return new ActivityReceiveWacodeBinding(constraintLayout, constraintLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ActivityReceiveWacodeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityReceiveWacodeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_receive_wacode, viewGroup, false);
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
