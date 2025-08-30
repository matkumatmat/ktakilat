package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.ktakilat.loan.R;

public final class CItemMultiLevelSelectBinding implements ViewBinding {
    @NonNull
    private final TextView rootView;
    @NonNull
    public final TextView text1;

    private CItemMultiLevelSelectBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = textView;
        this.text1 = textView2;
    }

    @NonNull
    public static CItemMultiLevelSelectBinding bind(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new CItemMultiLevelSelectBinding(textView, textView);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CItemMultiLevelSelectBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CItemMultiLevelSelectBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_item_multi_level_select, viewGroup, false);
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
