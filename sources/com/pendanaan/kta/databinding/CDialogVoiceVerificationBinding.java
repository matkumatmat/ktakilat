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

public final class CDialogVoiceVerificationBinding implements ViewBinding {
    @NonNull
    public final ImageView image;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textView2;
    @NonNull
    public final TextView textView4;
    @NonNull
    public final TextView tvCancle;
    @NonNull
    public final TextView tvOk;
    @NonNull
    public final TextView tvTips;
    @NonNull
    public final View viewSpliteHead;

    private CDialogVoiceVerificationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView3, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull TextView textView7, @NonNull View view) {
        this.rootView = constraintLayout;
        this.image = imageView;
        this.textView2 = textView;
        this.textView4 = textView3;
        this.tvCancle = textView5;
        this.tvOk = textView6;
        this.tvTips = textView7;
        this.viewSpliteHead = view;
    }

    @NonNull
    public static CDialogVoiceVerificationBinding bind(@NonNull View view) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.image);
        if (imageView != null) {
            i = R.id.textView2;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView2);
            if (textView != null) {
                i = R.id.textView4;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.textView4);
                if (textView3 != null) {
                    i = R.id.tvCancle;
                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tvCancle);
                    if (textView5 != null) {
                        i = R.id.tvOk;
                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tvOk);
                        if (textView6 != null) {
                            i = R.id.tvTips;
                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.tvTips);
                            if (textView7 != null) {
                                i = R.id.viewSpliteHead;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.viewSpliteHead);
                                if (findChildViewById != null) {
                                    return new CDialogVoiceVerificationBinding((ConstraintLayout) view, imageView, textView, textView3, textView5, textView6, textView7, findChildViewById);
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
    public static CDialogVoiceVerificationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CDialogVoiceVerificationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_dialog_voice_verification, viewGroup, false);
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
