package com.ktakilat.cbase.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.ktakilat.cbase.R;

public final class CActivityCommonTextviewBinding implements ViewBinding {
    @NonNull
    public final TextView contentTv;
    @NonNull
    public final CWidgetActionBarBinding pageTitle;
    @NonNull
    private final LinearLayout rootView;

    private CActivityCommonTextviewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull CWidgetActionBarBinding cWidgetActionBarBinding) {
        this.rootView = linearLayout;
        this.contentTv = textView;
        this.pageTitle = cWidgetActionBarBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.ktakilat.cbase.R.id.page_title;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ktakilat.cbase.databinding.CActivityCommonTextviewBinding bind(@androidx.annotation.NonNull android.view.View r3) {
        /*
            int r0 = com.ktakilat.cbase.R.id.content_tv
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x001e
            int r0 = com.ktakilat.cbase.R.id.page_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            if (r2 == 0) goto L_0x001e
            com.ktakilat.cbase.databinding.CWidgetActionBarBinding r0 = com.ktakilat.cbase.databinding.CWidgetActionBarBinding.bind(r2)
            com.ktakilat.cbase.databinding.CActivityCommonTextviewBinding r2 = new com.ktakilat.cbase.databinding.CActivityCommonTextviewBinding
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2.<init>(r3, r1, r0)
            return r2
        L_0x001e:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.databinding.CActivityCommonTextviewBinding.bind(android.view.View):com.ktakilat.cbase.databinding.CActivityCommonTextviewBinding");
    }

    @NonNull
    public static CActivityCommonTextviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CActivityCommonTextviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_activity_common_textview, viewGroup, false);
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
