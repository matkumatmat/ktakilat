package com.chad.library.adapter.base;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
final /* synthetic */ class BaseQuickAdapter$emptyLayout$1 extends MutablePropertyReference0 {
    public final Object get() {
        FrameLayout frameLayout = ((BaseQuickAdapter) this.receiver).e;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.k("mEmptyLayout");
        throw null;
    }

    public final String getName() {
        return "mEmptyLayout";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.a(BaseQuickAdapter.class);
    }

    public final String getSignature() {
        return "getMEmptyLayout()Landroid/widget/FrameLayout;";
    }

    public final void set(Object obj) {
        ((BaseQuickAdapter) this.receiver).e = (FrameLayout) obj;
    }
}
