package com.ktakilat.loan.mobile_check;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class MobileCheckV2Activity$sam$androidx_lifecycle_Observer$0 implements Observer, FunctionAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function1 f526a;

    public MobileCheckV2Activity$sam$androidx_lifecycle_Observer$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        this.f526a = function1;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Observer) || !(obj instanceof FunctionAdapter)) {
            return false;
        }
        return Intrinsics.a(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
    }

    public final Function getFunctionDelegate() {
        return this.f526a;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.f526a.invoke(obj);
    }
}
