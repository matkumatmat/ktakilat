package com.ktakilat.cbase.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.R;

public final class CWidgetActionBarBinding implements ViewBinding {
    @NonNull
    public final Button backward;
    @NonNull
    public final ImageView backwardIv;
    @NonNull
    public final Button forward;
    @NonNull
    public final ImageView forwardIv;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView title;
    @NonNull
    public final RelativeLayout widgetActionBar;

    private CWidgetActionBarBinding(@NonNull RelativeLayout relativeLayout, @NonNull Button button, @NonNull ImageView imageView, @NonNull Button button2, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.backward = button;
        this.backwardIv = imageView;
        this.forward = button2;
        this.forwardIv = imageView2;
        this.title = textView;
        this.widgetActionBar = relativeLayout2;
    }

    @NonNull
    public static CWidgetActionBarBinding bind(@NonNull View view) {
        int i = R.id.backward;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.backward_iv;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.forward;
                Button button2 = (Button) ViewBindings.findChildViewById(view, i);
                if (button2 != null) {
                    i = R.id.forward_iv;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view;
                            return new CWidgetActionBarBinding(relativeLayout, button, imageView, button2, imageView2, textView, relativeLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CWidgetActionBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CWidgetActionBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_widget_action_bar, viewGroup, false);
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
