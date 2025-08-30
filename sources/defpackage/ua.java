package defpackage;

import android.content.ComponentName;
import android.net.Uri;
import androidx.core.util.Predicate;

/* renamed from: ua  reason: default package */
public final /* synthetic */ class ua implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f212a;
    public final /* synthetic */ String b;

    public /* synthetic */ ua(String str, int i) {
        this.f212a = i;
        this.b = str;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f212a;
        return ed.a(this, predicate);
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f212a) {
            case 0:
                return ed.b(this);
            case 1:
                return ed.b(this);
            case 2:
                return ed.b(this);
            case 3:
                return ed.b(this);
            case 4:
                return ed.b(this);
            default:
                return ed.b(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f212a;
        return ed.c(this, predicate);
    }

    public final boolean test(Object obj) {
        switch (this.f212a) {
            case 0:
                return this.b.equals(((Uri) obj).getAuthority());
            case 1:
                return this.b.equals((String) obj);
            case 2:
                return this.b.equals(((ComponentName) obj).getPackageName());
            case 3:
                return this.b.equals(((Uri) obj).getAuthority());
            case 4:
                return this.b.equals(((Uri) obj).getAuthority());
            default:
                return this.b.equals(((Uri) obj).getAuthority());
        }
    }
}
