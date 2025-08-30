package defpackage;

import android.content.ComponentName;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.core.content.UriMatcherCompat;
import androidx.core.util.Predicate;

/* renamed from: va  reason: default package */
public final /* synthetic */ class va implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f215a;
    public final /* synthetic */ Object b;

    public /* synthetic */ va(Object obj, int i) {
        this.f215a = i;
        this.b = obj;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f215a;
        return ed.a(this, predicate);
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f215a) {
            case 0:
                return ed.b(this);
            case 1:
                return ed.b(this);
            case 2:
                return ed.b(this);
            default:
                return ed.b(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f215a;
        return ed.c(this, predicate);
    }

    public final boolean test(Object obj) {
        switch (this.f215a) {
            case 0:
                return ((ComponentName) this.b).equals((ComponentName) obj);
            case 1:
                return this.b.equals(obj);
            case 2:
                return ed.e((Predicate) this.b, obj);
            default:
                return UriMatcherCompat.lambda$asPredicate$0((UriMatcher) this.b, (Uri) obj);
        }
    }
}
