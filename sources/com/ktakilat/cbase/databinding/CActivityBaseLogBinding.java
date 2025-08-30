package com.ktakilat.cbase.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ktakilat.cbase.R;

public final class CActivityBaseLogBinding implements ViewBinding {
    @NonNull
    public final RecyclerView recycler;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final EditText searchEt;
    @NonNull
    public final ModernAppBarBinding titleLayout;

    private CActivityBaseLogBinding(@NonNull RelativeLayout relativeLayout, @NonNull RecyclerView recyclerView, @NonNull EditText editText, @NonNull ModernAppBarBinding modernAppBarBinding) {
        this.rootView = relativeLayout;
        this.recycler = recyclerView;
        this.searchEt = editText;
        this.titleLayout = modernAppBarBinding;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.ktakilat.cbase.R.id.title_layout;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ktakilat.cbase.databinding.CActivityBaseLogBinding bind(@androidx.annotation.NonNull android.view.View r4) {
        /*
            int r0 = com.ktakilat.cbase.R.id.recycler
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto L_0x0028
            int r0 = com.ktakilat.cbase.R.id.search_et
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.EditText r2 = (android.widget.EditText) r2
            if (r2 == 0) goto L_0x0028
            int r0 = com.ktakilat.cbase.R.id.title_layout
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0028
            com.ktakilat.cbase.databinding.ModernAppBarBinding r0 = com.ktakilat.cbase.databinding.ModernAppBarBinding.bind(r3)
            com.ktakilat.cbase.databinding.CActivityBaseLogBinding r3 = new com.ktakilat.cbase.databinding.CActivityBaseLogBinding
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r3.<init>(r4, r1, r2, r0)
            return r3
        L_0x0028:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.databinding.CActivityBaseLogBinding.bind(android.view.View):com.ktakilat.cbase.databinding.CActivityBaseLogBinding");
    }

    @NonNull
    public static CActivityBaseLogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CActivityBaseLogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.c_activity_base_log, viewGroup, false);
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
