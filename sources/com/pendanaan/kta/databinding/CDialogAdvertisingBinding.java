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

public final class CDialogAdvertisingBinding implements ViewBinding {
    @NonNull
    public final Button cancel;
    @NonNull
    public final Button ok;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView title;
    @NonNull
    public final View vLine;

    private CDialogAdvertisingBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView, @NonNull View view) {
        this.rootView = linearLayout;
        this.cancel = button;
        this.ok = button2;
        this.title = textView;
        this.vLine = view;
    }

    @NonNull
    public static CDialogAdvertisingBinding bind(@NonNull View view) {
        int i = R.id.cancel;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancel);
        if (button != null) {
            i = R.id.ok;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.ok);
            if (button2 != null) {
                i = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                if (textView != null) {
                    i = R.id.v_line;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.v_line);
                    if (findChildViewById != null) {
                        return new CDialogAdvertisingBinding((LinearLayout) view, button, button2, textView, findChildViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CDialogAdvertisingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CDialogAdvertisingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_dialog_advertising, viewGroup, false);
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
