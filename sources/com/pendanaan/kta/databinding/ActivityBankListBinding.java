package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivityBankListBinding implements ViewBinding {
    @NonNull
    public final RecyclerView bankList;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final RelativeLayout rootView;

    private ActivityBankListBinding(@NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding) {
        this.rootView = relativeLayout;
        this.bankList = recyclerView;
        this.pageTitle = cWidgetActionBarBinding;
    }

    @NonNull
    public static ActivityBankListBinding bind(@NonNull View view) {
        int i = R.id.bank_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.bank_list);
        if (recyclerView != null) {
            i = R.id.page_title;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
            if (findChildViewById != null) {
                return new ActivityBankListBinding((RelativeLayout) view, recyclerView, CWidgetActionBarBinding.bind(findChildViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityBankListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityBankListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_bank_list, viewGroup, false);
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
