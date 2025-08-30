package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class CFragmentMultiLevelSelectBinding implements ViewBinding {
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    public final RecyclerView refreshListView;
    @NonNull
    private final FrameLayout rootView;

    private CFragmentMultiLevelSelectBinding(@NonNull FrameLayout frameLayout, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding, @NonNull RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.pageTitle = cWidgetActionBarBinding;
        this.refreshListView = recyclerView;
    }

    @NonNull
    public static CFragmentMultiLevelSelectBinding bind(@NonNull View view) {
        int i = R.id.page_title;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
        if (findChildViewById != null) {
            CWidgetActionBarBinding bind = CWidgetActionBarBinding.bind(findChildViewById);
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.refresh_list_view);
            if (recyclerView != null) {
                return new CFragmentMultiLevelSelectBinding((FrameLayout) view, bind, recyclerView);
            }
            i = R.id.refresh_list_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CFragmentMultiLevelSelectBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CFragmentMultiLevelSelectBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_fragment_multi_level_select, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
