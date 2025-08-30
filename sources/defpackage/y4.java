package defpackage;

import java.lang.reflect.Method;
import java.util.function.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

/* renamed from: y4  reason: default package */
public final /* synthetic */ class y4 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f847a;
    public final /* synthetic */ String b;

    public /* synthetic */ y4(String str, int i) {
        this.f847a = i;
        this.b = str;
    }

    public final boolean test(Object obj) {
        switch (this.f847a) {
            case 0:
                return StringUtils.equals(this.b, (CharSequence) ((Pair) obj).getKey());
            case 1:
                return ((Method) obj).getName().equals(this.b);
            default:
                return ((Method) obj).getName().equals(this.b);
        }
    }
}
