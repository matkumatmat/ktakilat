package defpackage;

import java.lang.reflect.Method;
import java.util.function.Predicate;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailablePredicate;

/* renamed from: h7  reason: default package */
public final /* synthetic */ class h7 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f654a;
    public final /* synthetic */ Object b;

    public /* synthetic */ h7(Object obj, int i) {
        this.f654a = i;
        this.b = obj;
    }

    public final boolean test(Object obj) {
        switch (this.f654a) {
            case 0:
                return Failable.test((FailablePredicate) this.b, obj);
            case 1:
                return Functions.test((Functions.FailablePredicate) this.b, obj);
            default:
                return ClassUtils.isAssignable((Class<?>[]) (Class[]) this.b, (Class<?>[]) ((Method) obj).getParameterTypes(), true);
        }
    }
}
