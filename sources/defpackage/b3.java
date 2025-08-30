package defpackage;

import java.util.Iterator;
import org.apache.commons.lang3.ClassUtils;

/* renamed from: b3  reason: default package */
public final /* synthetic */ class b3 implements Iterable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ b3(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final Iterator iterator() {
        switch (this.c) {
            case 0:
                return ClassUtils.lambda$hierarchy$0((Class) this.d);
            default:
                return ClassUtils.lambda$hierarchy$1((b3) this.d);
        }
    }
}
