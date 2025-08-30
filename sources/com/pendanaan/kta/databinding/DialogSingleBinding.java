package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class DialogSingleBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tvDetail;
    @NonNull
    public final Button tvOk;
    @NonNull
    public final TextView tvTitle;

    private DialogSingleBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull Button button, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.tvDetail = textView;
        this.tvOk = button;
        this.tvTitle = textView2;
    }

    @NonNull
    public static DialogSingleBinding bind(@NonNull View view) {
        int i = R.id.tv_detail;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_detail);
        if (textView != null) {
            i = R.id.tv_ok;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.tv_ok);
            if (button != null) {
                i = R.id.tv_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                if (textView2 != null) {
                    return new DialogSingleBinding((LinearLayout) view, textView, button, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogSingleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogSingleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_single, viewGroup, false);
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
