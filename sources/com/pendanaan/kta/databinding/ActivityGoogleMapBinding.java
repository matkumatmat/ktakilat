package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ktakilat.cbase.databinding.CWidgetActionBarBinding;
import com.ktakilat.loan.R;

public final class ActivityGoogleMapBinding implements ViewBinding {
    @NonNull
    public final TextView addr;
    @NonNull
    public final TextView addrM;
    @NonNull
    public final EditText address;
    @NonNull
    public final EditText addressMore;
    @NonNull
    public final Button btnOk;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final RelativeLayout rootView;

    private ActivityGoogleMapBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull EditText editText, @NonNull EditText editText2, @NonNull Button button, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding) {
        this.rootView = relativeLayout;
        this.addr = textView;
        this.addrM = textView2;
        this.address = editText;
        this.addressMore = editText2;
        this.btnOk = button;
        this.pageTitle = cWidgetActionBarBinding;
    }

    @NonNull
    public static ActivityGoogleMapBinding bind(@NonNull View view) {
        int i = R.id.addr;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.addr);
        if (textView != null) {
            i = R.id.addr_m;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.addr_m);
            if (textView2 != null) {
                i = R.id.address;
                EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.address);
                if (editText != null) {
                    i = R.id.address_more;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.address_more);
                    if (editText2 != null) {
                        i = R.id.btn_ok;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.btn_ok);
                        if (button != null) {
                            i = R.id.page_title;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.page_title);
                            if (findChildViewById != null) {
                                return new ActivityGoogleMapBinding((RelativeLayout) view, textView, textView2, editText, editText2, button, CWidgetActionBarBinding.bind(findChildViewById));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @NonNull
    public static ActivityGoogleMapBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityGoogleMapBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_google_map, viewGroup, false);
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
