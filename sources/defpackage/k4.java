package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CopyableThreadContextElement;

/* renamed from: k4  reason: default package */
public final /* synthetic */ class k4 implements Function2 {
    public final /* synthetic */ Ref.ObjectRef c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ k4(Ref.ObjectRef objectRef, boolean z) {
        this.c = objectRef;
        this.d = z;
    }

    public final Object invoke(Object obj, Object obj2) {
        CoroutineContext coroutineContext = (CoroutineContext) obj;
        CoroutineContext.Element element = (CoroutineContext.Element) obj2;
        if (!(element instanceof CopyableThreadContextElement)) {
            return coroutineContext.plus(element);
        }
        Ref.ObjectRef objectRef = this.c;
        if (((CoroutineContext) objectRef.element).get(element.getKey()) == null) {
            CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element;
            if (this.d) {
                copyableThreadContextElement = copyableThreadContextElement.q();
            }
            return coroutineContext.plus(copyableThreadContextElement);
        }
        objectRef.element = ((CoroutineContext) objectRef.element).minusKey(element.getKey());
        return coroutineContext.plus(((CopyableThreadContextElement) element).B());
    }
}
