package com.ktakilat.cbase.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.ktakilat.cbase.R;

public final class CWidgetDanaDialogBinding implements ViewBinding {
    @NonNull
    public final Button cancel;
    @NonNull
    public final TextView message;
    @NonNull
    public final Button ok;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView title;
    @NonNull
    public final View vLine;

    private CWidgetDanaDialogBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull TextView textView, @NonNull Button button2, @NonNull TextView textView2, @NonNull View view) {
        this.rootView = linearLayout;
        this.cancel = button;
        this.message = textView;
        this.ok = button2;
        this.title = textView2;
        this.vLine = view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.ktakilat.cbase.R.id.v_line;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ktakilat.cbase.databinding.CWidgetDanaDialogBinding bind(@androidx.annotation.NonNull android.view.View r9) {
        /*
            int r0 = com.ktakilat.cbase.R.id.cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.Button r4 = (android.widget.Button) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.ktakilat.cbase.R.id.message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.ktakilat.cbase.R.id.ok
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.Button r6 = (android.widget.Button) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.ktakilat.cbase.R.id.title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.ktakilat.cbase.R.id.v_line
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r8 == 0) goto L_0x003e
            com.ktakilat.cbase.databinding.CWidgetDanaDialogBinding r0 = new com.ktakilat.cbase.databinding.CWidgetDanaDialogBinding
            r3 = r9
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.databinding.CWidgetDanaDialogBinding.bind(android.view.View):com.ktakilat.cbase.databinding.CWidgetDanaDialogBinding");
    }

    @NonNull
    public static CWidgetDanaDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CWidgetDanaDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_widget_dana_dialog, viewGroup, false);
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
