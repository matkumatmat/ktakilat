package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.ktakilat.loan.R;

public final class CItemSelectionsBinding implements ViewBinding {
    @NonNull
    private final TextView rootView;
    @NonNull
    public final TextView tv;

    private CItemSelectionsBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = textView;
        this.tv = textView2;
    }

    @NonNull
    public static CItemSelectionsBinding bind(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new CItemSelectionsBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CItemSelectionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CItemSelectionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_item_selections, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TextView getRoot() {
        return this.rootView;
    }
}
