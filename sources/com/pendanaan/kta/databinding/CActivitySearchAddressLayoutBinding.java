package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.loan.R;

public final class CActivitySearchAddressLayoutBinding implements ViewBinding {
    @NonNull
    public final ImageView backward;
    @NonNull
    public final EditText et;
    @NonNull
    public final ImageView ivRight;
    @NonNull
    public final ListView lv;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView title;
    @NonNull
    public final TextView tvOk;

    private CActivitySearchAddressLayoutBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull EditText editText, @NonNull ImageView imageView2, @NonNull ListView listView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.backward = imageView;
        this.et = editText;
        this.ivRight = imageView2;
        this.lv = listView;
        this.title = textView;
        this.tvOk = textView2;
    }

    @NonNull
    public static CActivitySearchAddressLayoutBinding bind(@NonNull View view) {
        int i = R.id.backward;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.backward);
        if (imageView != null) {
            i = R.id.et;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.et);
            if (editText != null) {
                i = R.id.iv_right;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_right);
                if (imageView2 != null) {
                    i = R.id.lv;
                    ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.lv);
                    if (listView != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                        if (textView != null) {
                            i = R.id.tv_ok;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_ok);
                            if (textView2 != null) {
                                return new CActivitySearchAddressLayoutBinding((LinearLayout) view, imageView, editText, imageView2, listView, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static CActivitySearchAddressLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CActivitySearchAddressLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_activity_search_address_layout, viewGroup, false);
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
