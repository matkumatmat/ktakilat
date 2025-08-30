package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class CWidgetPrivateDialogBinding implements ViewBinding {
    @NonNull
    public final AppCompatButton cancel;
    @NonNull
    public final TextView message;
    @NonNull
    public final AppCompatButton ok;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ScrollView scrollView;
    @NonNull
    public final TextView title;

    private CWidgetPrivateDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppCompatButton appCompatButton, @NonNull TextView textView, @NonNull AppCompatButton appCompatButton2, @NonNull ScrollView scrollView2, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.cancel = appCompatButton;
        this.message = textView;
        this.ok = appCompatButton2;
        this.scrollView = scrollView2;
        this.title = textView2;
    }

    @NonNull
    public static CWidgetPrivateDialogBinding bind(@NonNull View view) {
        int i = R.id.cancel;
        AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.cancel);
        if (appCompatButton != null) {
            i = R.id.message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.message);
            if (textView != null) {
                i = R.id.ok;
                AppCompatButton appCompatButton2 = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.ok);
                if (appCompatButton2 != null) {
                    i = R.id.scroll_view;
                    ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                    if (scrollView2 != null) {
                        i = R.id.title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (textView2 != null) {
                            return new CWidgetPrivateDialogBinding((RelativeLayout) view, appCompatButton, textView, appCompatButton2, scrollView2, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CWidgetPrivateDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CWidgetPrivateDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_widget_private_dialog, viewGroup, false);
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
