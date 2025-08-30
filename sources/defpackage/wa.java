package defpackage;

import android.content.ClipData;
import android.content.ComponentName;
import android.net.Uri;
import androidx.core.content.IntentSanitizer;
import androidx.core.util.Predicate;

/* renamed from: wa  reason: default package */
public final /* synthetic */ class wa implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f217a;

    public /* synthetic */ wa(int i) {
        this.f217a = i;
    }

    public final /* synthetic */ Predicate and(Predicate predicate) {
        int i = this.f217a;
        return ed.a(this, predicate);
    }

    public final /* synthetic */ Predicate negate() {
        switch (this.f217a) {
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
            case 5:
                return ed.b(this);
            case 6:
                return ed.b(this);
            case 7:
                return ed.b(this);
            case 8:
                return ed.b(this);
            case 9:
                return ed.b(this);
            case 10:
                return ed.b(this);
            default:
                return ed.b(this);
        }
    }

    public final /* synthetic */ Predicate or(Predicate predicate) {
        int i = this.f217a;
        return ed.c(this, predicate);
    }

    public final boolean test(Object obj) {
        switch (this.f217a) {
            case 0:
                return IntentSanitizer.Builder.lambda$allowAnyComponent$10((ComponentName) obj);
            case 1:
                return IntentSanitizer.Builder.lambda$allowExtra$14(obj);
            case 2:
                return IntentSanitizer.Builder.lambda$new$0((String) obj);
            case 3:
                return IntentSanitizer.Builder.lambda$new$1((Uri) obj);
            case 4:
                return IntentSanitizer.Builder.lambda$new$2((String) obj);
            case 5:
                return IntentSanitizer.Builder.lambda$new$3((String) obj);
            case 6:
                return IntentSanitizer.Builder.lambda$new$4((String) obj);
            case 7:
                return IntentSanitizer.Builder.lambda$new$5((ComponentName) obj);
            case 8:
                return IntentSanitizer.Builder.lambda$new$6((Uri) obj);
            case 9:
                return IntentSanitizer.Builder.lambda$new$7((ClipData) obj);
            case 10:
                return IntentSanitizer.Builder.lambda$allowExtra$12(obj);
            default:
                return ed.h(obj);
        }
    }
}
