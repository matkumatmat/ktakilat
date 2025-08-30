package com.pendanaan.kta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.ktakilat.loan.R;

public final class CDialogUserDiversionBinding implements ViewBinding {
    @NonNull
    private final WebView rootView;
    @NonNull
    public final WebView webView;

    private CDialogUserDiversionBinding(@NonNull WebView webView2, @NonNull WebView webView3) {
        this.rootView = webView2;
        this.webView = webView3;
    }

    @NonNull
    public static CDialogUserDiversionBinding bind(@NonNull View view) {
        if (view != null) {
            WebView webView2 = (WebView) view;
            return new CDialogUserDiversionBinding(webView2, webView2);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static CDialogUserDiversionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CDialogUserDiversionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_dialog_user_diversion, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public WebView getRoot() {
        return this.rootView;
    }
}
