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

public final class CDialogVoiceVerificationTipsBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout clContent;
    @NonNull
    public final ImageView iv99Percent;
    @NonNull
    public final ImageView ivCanNotTakePhone;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final ImageView ivHead;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvPleaseTry;
    @NonNull
    public final TextView tvTips;
    @NonNull
    public final View viewSpliteHead;

    private CDialogVoiceVerificationTipsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view) {
        this.rootView = constraintLayout;
        this.clContent = constraintLayout2;
        this.iv99Percent = imageView;
        this.ivCanNotTakePhone = imageView2;
        this.ivClose = imageView3;
        this.ivHead = imageView4;
        this.tvPleaseTry = textView;
        this.tvTips = textView2;
        this.viewSpliteHead = view;
    }

    @NonNull
    public static CDialogVoiceVerificationTipsBinding bind(@NonNull View view) {
        int i = R.id.clContent;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.clContent);
        if (constraintLayout != null) {
            i = R.id.iv99Percent;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv99Percent);
            if (imageView != null) {
                i = R.id.ivCanNotTakePhone;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivCanNotTakePhone);
                if (imageView2 != null) {
                    i = R.id.ivClose;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivClose);
                    if (imageView3 != null) {
                        i = R.id.ivHead;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivHead);
                        if (imageView4 != null) {
                            i = R.id.tvPleaseTry;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tvPleaseTry);
                            if (textView != null) {
                                i = R.id.tvTips;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvTips);
                                if (textView2 != null) {
                                    i = R.id.viewSpliteHead;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.viewSpliteHead);
                                    if (findChildViewById != null) {
                                        return new CDialogVoiceVerificationTipsBinding((ConstraintLayout) view, constraintLayout, imageView, imageView2, imageView3, imageView4, textView, textView2, findChildViewById);
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
    public static CDialogVoiceVerificationTipsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CDialogVoiceVerificationTipsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_dialog_voice_verification_tips, viewGroup, false);
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
