package kotlin.coroutines;

import com.facebook.places.model.PlaceFields;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0002J(\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0002¢\u0006\u0002\u0010\u000fJ5\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u0002H\u00112\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00110\u0014H\u0016¢\u0006\u0002\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002J\u0014\u0010\u0018\u001a\u00020\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/coroutines/EmptyCoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "<init>", "()V", "serialVersionUID", "", "readResolve", "", "get", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "plus", "context", "minusKey", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.3")
public final class EmptyCoroutineContext implements CoroutineContext, Serializable {
    @NotNull
    public static final EmptyCoroutineContext INSTANCE = new EmptyCoroutineContext();
    private static final long serialVersionUID = 0;

    private EmptyCoroutineContext() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return r;
    }

    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this;
    }

    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, PlaceFields.CONTEXT);
        return coroutineContext;
    }

    @NotNull
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
