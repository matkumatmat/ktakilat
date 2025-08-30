package defpackage;

import android.content.ClipData;
import androidx.core.util.Predicate;

/* renamed from: i4  reason: default package */
public final /* synthetic */ class i4 implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ java.util.function.Predicate f200a;

    public /* synthetic */ i4(java.util.function.Predicate predicate) {
        this.f200a = predicate;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        return ed.a(this, predicate);
    }

    public final /* synthetic */ Predicate negate() {
        return ed.b(this);
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        return ed.c(this, predicate);
    }

    public final boolean test(Object obj) {
        return this.f200a.test((ClipData.Item) obj);
    }
}
