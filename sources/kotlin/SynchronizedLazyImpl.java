package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    public Function0 c;
    public volatile Object d;
    public final Object e;

    public SynchronizedLazyImpl(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        obj = (i & 2) != 0 ? null : obj;
        Intrinsics.checkNotNullParameter(function0, "initializer");
        this.c = function0;
        this.d = UNINITIALIZED_VALUE.f695a;
        this.e = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    public final Object getValue() {
        Object obj;
        Object obj2 = this.d;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f695a;
        if (obj2 != uninitialized_value) {
            return obj2;
        }
        synchronized (this.e) {
            obj = this.d;
            if (obj == uninitialized_value) {
                Function0 function0 = this.c;
                Intrinsics.c(function0);
                obj = function0.invoke();
                this.d = obj;
                this.c = null;
            }
        }
        return obj;
    }

    public final boolean isInitialized() {
        if (this.d != UNINITIALIZED_VALUE.f695a) {
            return true;
        }
        return false;
    }

    public final String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
