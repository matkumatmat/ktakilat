package defpackage;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* renamed from: d3  reason: default package */
public final /* synthetic */ class d3 implements Function2 {
    public final /* synthetic */ CoroutineContext[] c;
    public final /* synthetic */ Ref.IntRef d;

    public /* synthetic */ d3(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        this.c = coroutineContextArr;
        this.d = intRef;
    }

    public final Object invoke(Object obj, Object obj2) {
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        Intrinsics.checkNotNullParameter((Unit) obj, "<unused var>");
        Intrinsics.checkNotNullParameter(element, "element");
        Ref.IntRef intRef = this.d;
        int i = intRef.element;
        intRef.element = i + 1;
        this.c[i] = element;
        return Unit.f696a;
    }
}
