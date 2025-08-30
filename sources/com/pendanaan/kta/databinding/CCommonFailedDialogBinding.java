package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class CCommonFailedDialogBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout clContent;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final ImageView ivHead;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvConfirm;
    @NonNull
    public final TextView tvContent;
    @NonNull
    public final TextView tvTitle;

    private CCommonFailedDialogBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.ivClose = imageView;
        this.ivHead = imageView2;
        this.tvConfirm = textView;
        this.tvContent = textView2;
        this.tvTitle = textView3;
    }

    @NonNull
    public static CCommonFailedDialogBinding bind(@NonNull View view) {
        int i = R.id.clContent;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.clContent);
        if (constraintLayout != null) {
            i = R.id.ivClose;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.ivClose);
            if (imageView != null) {
                i = R.id.ivHead;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivHead);
                if (imageView2 != null) {
                    i = R.id.tvConfirm;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tvConfirm);
                    if (textView != null) {
                        i = R.id.tvContent;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvContent);
                        if (textView2 != null) {
                            i = R.id.tvTitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tvTitle);
                            if (textView3 != null) {
                                return new CCommonFailedDialogBinding((ConstraintLayout) view, constraintLayout, imageView, imageView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CCommonFailedDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CCommonFailedDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_common_failed_dialog, viewGroup, false);
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
