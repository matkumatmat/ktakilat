package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class DialogOjkStatementBinding implements ViewBinding {
    @NonNull
    public final Button cancel;
    @NonNull
    public final TextView message;
    @NonNull
    public final AppCompatButton ok;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final NestedScrollView scroll;
    @NonNull
    public final LinearLayout scrollLl;
    @NonNull
    public final TextView title;

    private DialogOjkStatementBinding(@NonNull RelativeLayout relativeLayout, @NonNull Button button, @NonNull TextView textView, @NonNull AppCompatButton appCompatButton, @NonNull NestedScrollView nestedScrollView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2) {
        this.rootView = relativeLayout;
        this.cancel = button;
        this.message = textView;
        this.ok = appCompatButton;
        this.scroll = nestedScrollView;
        this.scrollLl = linearLayout;
        this.title = textView2;
    }

    @NonNull
    public static DialogOjkStatementBinding bind(@NonNull View view) {
        int i = R.id.cancel;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancel);
        if (button != null) {
            i = R.id.message;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.message);
            if (textView != null) {
                i = R.id.ok;
                AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.ok);
                if (appCompatButton != null) {
                    i = R.id.scroll;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scroll);
                    if (nestedScrollView != null) {
                        i = R.id.scroll_ll;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.scroll_ll);
                        if (linearLayout != null) {
                            i = R.id.title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (textView2 != null) {
                                return new DialogOjkStatementBinding((RelativeLayout) view, button, textView, appCompatButton, nestedScrollView, linearLayout, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static DialogOjkStatementBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogOjkStatementBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ojk_statement, viewGroup, false);
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
