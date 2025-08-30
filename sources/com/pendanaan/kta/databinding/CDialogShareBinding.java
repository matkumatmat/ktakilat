package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class CDialogShareBinding implements ViewBinding {
    @NonNull
    public final TextView onlineServiceTv;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tvCancel;
    @NonNull
    public final TextView tvFacebook;
    @NonNull
    public final TextView tvInstagram;
    @NonNull
    public final TextView tvLine;

    private CDialogShareBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.rootView = linearLayout;
        this.onlineServiceTv = textView;
        this.tvCancel = textView2;
        this.tvFacebook = textView3;
        this.tvInstagram = textView4;
        this.tvLine = textView5;
    }

    @NonNull
    public static CDialogShareBinding bind(@NonNull View view) {
        int i = R.id.onlineServiceTv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.onlineServiceTv);
        if (textView != null) {
            i = R.id.tv_cancel;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_cancel);
            if (textView2 != null) {
                i = R.id.tv_facebook;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_facebook);
                if (textView3 != null) {
                    i = R.id.tv_instagram;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_instagram);
                    if (textView4 != null) {
                        i = R.id.tv_line;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_line);
                        if (textView5 != null) {
                            return new CDialogShareBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CDialogShareBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CDialogShareBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_dialog_share, viewGroup, false);
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
