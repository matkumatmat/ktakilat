package kotlin.collections;

import java.util.AbstractCollection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u001a\u001f\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"T", "", "firstOrNull", "(Ljava/util/List;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension({"SMAP\n_Collections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,3686:1\n295#1,2:3687\n528#1,7:3689\n543#1,6:3696\n865#1,2:3703\n796#1:3705\n1872#1,2:3706\n797#1,2:3708\n1874#1:3710\n799#1:3711\n1872#1,3:3712\n817#1,2:3715\n855#1,2:3717\n1261#1,4:3727\n1230#1,4:3731\n1246#1,4:3735\n1293#1,4:3739\n1454#1,5:3743\n1469#1,5:3748\n1510#1,3:3753\n1513#1,3:3763\n1528#1,3:3766\n1531#1,3:3776\n1628#1,3:3793\n1598#1,4:3796\n1587#1:3800\n1872#1,2:3801\n1874#1:3804\n1588#1:3805\n1872#1,3:3806\n1619#1:3809\n1863#1:3810\n1864#1:3812\n1620#1:3813\n1863#1,2:3814\n1872#1,3:3816\n2853#1,3:3819\n2856#1,6:3823\n2878#1,3:3829\n2881#1,7:3833\n865#1,2:3840\n827#1:3842\n855#1,2:3843\n827#1:3845\n855#1,2:3846\n827#1:3848\n855#1,2:3849\n3408#1,8:3855\n3436#1,7:3863\n3467#1,10:3870\n1#2:3702\n1#2:3803\n1#2:3811\n1#2:3822\n1#2:3832\n37#3:3719\n36#3,3:3720\n37#3:3723\n36#3,3:3724\n381#4,7:3756\n381#4,7:3769\n381#4,7:3779\n381#4,7:3786\n32#5,2:3851\n32#5,2:3853\n*S KotlinDebug\n*F\n+ 1 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n174#1:3687,2\n184#1:3689,7\n194#1:3696,6\n774#1:3703,2\n785#1:3705\n785#1:3706,2\n785#1:3708,2\n785#1:3710\n785#1:3711\n796#1:3712,3\n808#1:3715,2\n827#1:3717,2\n1188#1:3727,4\n1203#1:3731,4\n1217#1:3735,4\n1280#1:3739,4\n1368#1:3743,5\n1381#1:3748,5\n1485#1:3753,3\n1485#1:3763,3\n1498#1:3766,3\n1498#1:3776,3\n1557#1:3793,3\n1567#1:3796,4\n1577#1:3800\n1577#1:3801,2\n1577#1:3804\n1577#1:3805\n1587#1:3806,3\n1611#1:3809\n1611#1:3810\n1611#1:3812\n1611#1:3813\n1619#1:3814,2\n2653#1:3816,3\n2953#1:3819,3\n2953#1:3823,6\n2970#1:3829,3\n2970#1:3833,7\n3146#1:3840,2\n3154#1:3842\n3154#1:3843,2\n3164#1:3845\n3164#1:3846,2\n3174#1:3848\n3174#1:3849,2\n3397#1:3855,8\n3425#1:3863,7\n3454#1:3870,10\n1577#1:3803\n1611#1:3811\n2953#1:3822\n2970#1:3832\n1040#1:3719\n1040#1:3720,3\n1083#1:3723\n1083#1:3724,3\n1485#1:3756,7\n1498#1:3769,7\n1512#1:3779,7\n1530#1:3786,7\n3342#1:3851,2\n3384#1:3853,2\n*E\n"})
class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {
    public static final void d(Iterable iterable, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, Function1 function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(sb, "buffer");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        sb.append(charSequence2);
        int i2 = 0;
        for (Object next : iterable) {
            i2++;
            if (i2 > 1) {
                sb.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            StringsKt.j(sb, next, function1);
        }
        if (i >= 0 && i2 > i) {
            sb.append(charSequence4);
        }
        sb.append(charSequence3);
    }

    public static final void e(Iterable iterable, AbstractCollection abstractCollection) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(abstractCollection, "destination");
        for (Object add : iterable) {
            abstractCollection.add(add);
        }
    }

    @Nullable
    public static <T> T firstOrNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
