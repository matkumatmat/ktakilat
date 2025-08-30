package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class CDialogSelectionBinding implements ViewBinding {
    @NonNull
    public final CItemSelectionsBinding cancelBtn;
    @NonNull
    public final View divider;
    @NonNull
    public final ListView lvSelections;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tvTitle;

    private CDialogSelectionBinding(@NonNull LinearLayout linearLayout, @NonNull CItemSelectionsBinding cItemSelectionsBinding, @NonNull View view, @NonNull ListView listView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.cancelBtn = cItemSelectionsBinding;
        this.divider = view;
        this.lvSelections = listView;
        this.tvTitle = textView;
    }

    @NonNull
    public static CDialogSelectionBinding bind(@NonNull View view) {
        int i = R.id.cancelBtn;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.cancelBtn);
        if (findChildViewById != null) {
            CItemSelectionsBinding bind = CItemSelectionsBinding.bind(findChildViewById);
            i = R.id.divider;
            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.divider);
            if (findChildViewById2 != null) {
                i = R.id.lv_selections;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.lv_selections);
                if (listView != null) {
                    i = R.id.tv_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tv_title);
                    if (textView != null) {
                        return new CDialogSelectionBinding((LinearLayout) view, bind, findChildViewById2, listView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CDialogSelectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CDialogSelectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_dialog_selection, viewGroup, false);
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
