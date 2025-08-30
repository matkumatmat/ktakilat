package coil3;

import coil3.decode.Decoder;
import coil3.fetch.Fetcher;
import coil3.map.Mapper;
import coil3.util.Collections_jvmCommonKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/ComponentRegistry;", "", "Builder", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nComponentRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry\n+ 2 collections.kt\ncoil3/util/CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n43#2,2:200\n46#2:203\n43#2,4:204\n69#2,5:208\n69#2,5:213\n1#3:202\n*S KotlinDebug\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry\n*L\n48#1:200,2\n48#1:203\n63#1:204,4\n33#1:208,5\n37#1:213,5\n*E\n"})
public final class ComponentRegistry {

    /* renamed from: a  reason: collision with root package name */
    public final List f48a;
    public final List b;
    public final List c;
    public List d;
    public List e;
    public final Lazy f = LazyKt.b(new u3(this, 0));
    public final Lazy g = LazyKt.b(new u3(this, 1));

    @SourceDebugExtension({"SMAP\nComponentRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry$Builder\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,199:1\n1628#2,3:200\n1628#2,3:203\n*S KotlinDebug\n*F\n+ 1 ComponentRegistry.kt\ncoil3/ComponentRegistry$Builder\n*L\n140#1:200,3\n141#1:203,3\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/ComponentRegistry$Builder;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList f49a;
        public final ArrayList b;
        public final ArrayList c;
        public final ArrayList d;
        public final ArrayList e;

        public Builder(ComponentRegistry componentRegistry) {
            this.f49a = CollectionsKt.E(componentRegistry.f48a);
            this.b = CollectionsKt.E(componentRegistry.b);
            this.c = CollectionsKt.E(componentRegistry.c);
            ArrayList arrayList = new ArrayList();
            for (Pair cVar : (List) componentRegistry.f.getValue()) {
                arrayList.add(new c(cVar, 2));
            }
            this.d = arrayList;
            ArrayList arrayList2 = new ArrayList();
            for (Decoder.Factory v3Var : (List) componentRegistry.g.getValue()) {
                arrayList2.add(new v3(v3Var, 0));
            }
            this.e = arrayList2;
        }

        public final void a(Fetcher.Factory factory, ClassReference classReference) {
            this.d.add(new x(2, factory, classReference));
        }

        public final void b(Mapper mapper, ClassReference classReference) {
            this.b.add(new Pair(mapper, classReference));
        }

        public final ComponentRegistry c() {
            return new ComponentRegistry(Collections_jvmCommonKt.a(this.f49a), Collections_jvmCommonKt.a(this.b), Collections_jvmCommonKt.a(this.c), Collections_jvmCommonKt.a(this.d), Collections_jvmCommonKt.a(this.e));
        }
    }

    public ComponentRegistry(List list, List list2, List list3, List list4, List list5) {
        this.f48a = list;
        this.b = list2;
        this.c = list3;
        this.d = list4;
        this.e = list5;
    }
}
