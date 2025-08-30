package okio;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00060\u0004j\u0002`\u0005:\u0001\u0016B\u001b\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0015R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lokio/TypedOptions;", "T", "", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "", "options", "Lokio/Options;", "(Ljava/util/List;Lokio/Options;)V", "getList$okio", "()Ljava/util/List;", "getOptions$okio", "()Lokio/Options;", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "Companion", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TypedOptions<T> extends AbstractList<T> implements RandomAccess {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final List<T> list;
    @NotNull
    private final Options options;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\n0\tH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000b"}, d2 = {"Lokio/TypedOptions$Companion;", "", "()V", "of", "Lokio/TypedOptions;", "T", "values", "", "encode", "Lkotlin/Function1;", "Lokio/ByteString;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: okio.ByteString[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        @kotlin.jvm.JvmStatic
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> okio.TypedOptions<T> of(@org.jetbrains.annotations.NotNull java.lang.Iterable<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends okio.ByteString> r7) {
            /*
                r5 = this;
                java.lang.String r0 = "values"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
                java.lang.String r0 = "encode"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.util.List r6 = kotlin.collections.CollectionsKt.D(r6)
                okio.Options$Companion r0 = okio.Options.Companion
                int r1 = r6.size()
                okio.ByteString[] r2 = new okio.ByteString[r1]
                r3 = 0
            L_0x0017:
                if (r3 >= r1) goto L_0x0026
                java.lang.Object r4 = r6.get(r3)
                java.lang.Object r4 = r7.invoke(r4)
                r2[r3] = r4
                int r3 = r3 + 1
                goto L_0x0017
            L_0x0026:
                okio.Options r7 = r0.of(r2)
                okio.TypedOptions r0 = new okio.TypedOptions
                r0.<init>(r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.TypedOptions.Companion.of(java.lang.Iterable, kotlin.jvm.functions.Function1):okio.TypedOptions");
        }

        private Companion() {
        }
    }

    public TypedOptions(@NotNull List<? extends T> list2, @NotNull Options options2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(options2, "options");
        this.options = options2;
        List<T> D = CollectionsKt.D(list2);
        this.list = D;
        if (D.size() != options2.size()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @JvmStatic
    @NotNull
    public static final <T> TypedOptions<T> of(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, ? extends ByteString> function1) {
        return Companion.of(iterable, function1);
    }

    @NotNull
    public T get(int i) {
        return this.list.get(i);
    }

    @NotNull
    public final List<T> getList$okio() {
        return this.list;
    }

    @NotNull
    public final Options getOptions$okio() {
        return this.options;
    }

    public int getSize() {
        return this.list.size();
    }
}
