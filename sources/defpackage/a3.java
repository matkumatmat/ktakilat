package defpackage;

import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath;

/* renamed from: a3  reason: default package */
public final /* synthetic */ class a3 implements Predicate {
    public final /* synthetic */ int c;

    public /* synthetic */ a3(int i) {
        this.c = i;
    }

    public final boolean apply(Object obj) {
        switch (this.c) {
            case 0:
                return ((ClassPath.ClassInfo) obj).isTopLevel();
            default:
                return ((Class) obj).isInterface();
        }
    }
}
