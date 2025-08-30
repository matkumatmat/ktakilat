package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class DialogGestureSkipBinding implements ViewBinding {
    @NonNull
    public final TextView cancelTv;
    @NonNull
    public final TextView nextTv;
    @NonNull
    private final RelativeLayout rootView;

    private DialogGestureSkipBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.cancelTv = textView;
        this.nextTv = textView2;
    }

    @NonNull
    public static DialogGestureSkipBinding bind(@NonNull View view) {
        int i = R.id.cancel_tv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.cancel_tv);
        if (textView != null) {
            i = R.id.next_tv;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.next_tv);
            if (textView2 != null) {
                return new DialogGestureSkipBinding((RelativeLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogGestureSkipBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogGestureSkipBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_gesture_skip, viewGroup, false);
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
