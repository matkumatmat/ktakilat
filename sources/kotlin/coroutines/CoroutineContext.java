package kotlin.coroutines;

import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "", "Key", "Element", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.3")
public interface CoroutineContext {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Element extends CoroutineContext {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static Element a(Element element, Key key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (Intrinsics.a(element.getKey(), key)) {
                    return element;
                }
                return null;
            }

            public static CoroutineContext b(Element element, Key key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (Intrinsics.a(element.getKey(), key)) {
                    return EmptyCoroutineContext.INSTANCE;
                }
                return element;
            }

            public static CoroutineContext c(CoroutineContext coroutineContext, Element element) {
                Intrinsics.checkNotNullParameter(coroutineContext, PlaceFields.CONTEXT);
                Intrinsics.checkNotNullParameter(coroutineContext, PlaceFields.CONTEXT);
                if (coroutineContext == EmptyCoroutineContext.INSTANCE) {
                    return element;
                }
                return (CoroutineContext) coroutineContext.fold(element, new e3(2));
            }
        }

        Key getKey();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Key<E extends Element> {
    }

    Object fold(Object obj, Function2 function2);

    Element get(Key key);

    CoroutineContext minusKey(Key key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
