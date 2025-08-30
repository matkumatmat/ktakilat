package com.chad.library.adapter.base.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"com.github.CymChad.brvah"}, k = 2, mv = {1, 4, 0})
public final class AdapterUtilsKt {
    public static final View a(ViewGroup viewGroup, int i) {
        Intrinsics.e(viewGroup, "$this$getItemView");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        Intrinsics.b(inflate, "LayoutInflater.from(this…layoutResId, this, false)");
        return inflate;
    }
}
