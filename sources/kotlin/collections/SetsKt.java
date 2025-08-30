package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"kotlin/collections/SetsKt__SetsJVMKt", "kotlin/collections/SetsKt__SetsKt", "kotlin/collections/SetsKt___SetsKt"}, k = 4, mv = {2, 1, 0}, xi = 49)
public final class SetsKt extends SetsKt___SetsKt {
    public static LinkedHashSet a(Set set, Set set2) {
        Integer num;
        int i;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(set2, MessengerShareContentUtility.ELEMENTS);
        Intrinsics.checkNotNullParameter(set2, "<this>");
        if (set2 instanceof Collection) {
            num = Integer.valueOf(set2.size());
        } else {
            num = null;
        }
        if (num != null) {
            i = set.size() + num.intValue();
        } else {
            i = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.c(i));
        linkedHashSet.addAll(set);
        CollectionsKt.f(linkedHashSet, set2);
        return linkedHashSet;
    }
}
