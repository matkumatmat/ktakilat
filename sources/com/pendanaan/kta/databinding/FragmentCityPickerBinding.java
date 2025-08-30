package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

public final class FragmentCityPickerBinding implements ViewBinding {
    @NonNull
    public final SwipeRefreshLayout refresher;
    @NonNull
    public final FastScrollRecyclerView regionList;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final EditText searchBar;

    private FragmentCityPickerBinding(@NonNull LinearLayout linearLayout, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull FastScrollRecyclerView fastScrollRecyclerView, @NonNull EditText editText) {
        this.rootView = linearLayout;
        this.refresher = swipeRefreshLayout;
        this.regionList = fastScrollRecyclerView;
        this.searchBar = editText;
    }

    @NonNull
    public static FragmentCityPickerBinding bind(@NonNull View view) {
        int i = R.id.refresher;
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, R.id.refresher);
        if (swipeRefreshLayout != null) {
            i = R.id.region_list;
            FastScrollRecyclerView fastScrollRecyclerView = (FastScrollRecyclerView) ViewBindings.findChildViewById(view, R.id.region_list);
            if (fastScrollRecyclerView != null) {
                i = R.id.search_bar;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.search_bar);
                if (editText != null) {
                    return new FragmentCityPickerBinding((LinearLayout) view, swipeRefreshLayout, fastScrollRecyclerView, editText);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static FragmentCityPickerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCityPickerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_city_picker, viewGroup, false);
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
