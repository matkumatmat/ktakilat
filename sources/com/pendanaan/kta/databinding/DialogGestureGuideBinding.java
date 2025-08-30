package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class DialogGestureGuideBinding implements ViewBinding {
    @NonNull
    public final ImageView gestureGifImage;
    @NonNull
    public final TextView nextTv;
    @NonNull
    private final RelativeLayout rootView;

    private DialogGestureGuideBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = relativeLayout;
        this.gestureGifImage = imageView;
        this.nextTv = textView;
    }

    @NonNull
    public static DialogGestureGuideBinding bind(@NonNull View view) {
        int i = R.id.gesture_gif_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.gesture_gif_image);
        if (imageView != null) {
            i = R.id.next_tv;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.next_tv);
            if (textView != null) {
                return new DialogGestureGuideBinding((RelativeLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogGestureGuideBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogGestureGuideBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_gesture_guide, viewGroup, false);
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
