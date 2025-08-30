package defpackage;

import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: dd  reason: default package */
public final /* synthetic */ class dd implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f189a;
    public final /* synthetic */ Predicate b;
    public final /* synthetic */ Object c;

    public /* synthetic */ dd(Predicate predicate, Predicate predicate2, int i) {
        this.f189a = i;
        this.b = predicate;
        this.c = predicate2;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f189a;
        return ed.a(this, predicate);
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f189a) {
            case 0:
                return ed.b(this);
            case 1:
                return ed.b(this);
            default:
                return ed.b(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f189a;
        return ed.c(this, predicate);
    }

    public final boolean test(Object obj) {
        switch (this.f189a) {
            case 0:
                return ed.f(this.b, (Predicate) this.c, obj);
            case 1:
                return ed.d(this.b, (Predicate) this.c, obj);
            default:
                return IntentSanitizer.Builder.lambda$allowExtra$13((Class) this.c, this.b, obj);
        }
    }

    public /* synthetic */ dd(Class cls, Predicate predicate) {
        this.f189a = 2;
        this.c = cls;
        this.b = predicate;
    }
}
