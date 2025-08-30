package defpackage;

import kotlin.collections.ArraysKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* renamed from: l4  reason: default package */
public final /* synthetic */ class l4 implements Function1 {
    public final /* synthetic */ int c;

    public /* synthetic */ l4(int i) {
        this.c = i;
    }

    public final Object invoke(Object obj) {
        boolean z;
        switch (this.c) {
            case 0:
                CoroutineContext.Element element = (CoroutineContext.Element) obj;
                if (element instanceof CoroutineDispatcher) {
                    return (CoroutineDispatcher) element;
                }
                return null;
            case 1:
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj;
                if (element2 instanceof ExecutorCoroutineDispatcher) {
                    return (ExecutorCoroutineDispatcher) element2;
                }
                return null;
            case 2:
                return obj;
            case 3:
                if (obj == null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                ArraysKt.h((Object[]) null, obj);
                throw null;
            default:
                CharSequence charSequence = (CharSequence) obj;
                Intrinsics.checkNotNullParameter(charSequence, "it");
                return charSequence.toString();
        }
    }
}
