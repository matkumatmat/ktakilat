package com.chad.library.adapter.base;

import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class BaseQuickAdapter$hasHeaderLayout$1 extends MutablePropertyReference0 {
    public final Object get() {
        LinearLayout linearLayout = ((BaseQuickAdapter) this.receiver).c;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.k("mHeaderLayout");
        throw null;
    }

    public final String getName() {
        return "mHeaderLayout";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.a(BaseQuickAdapter.class);
    }

    public final String getSignature() {
        return "getMHeaderLayout()Landroid/widget/LinearLayout;";
    }

    public final void set(Object obj) {
        ((BaseQuickAdapter) this.receiver).c = (LinearLayout) obj;
    }
}
