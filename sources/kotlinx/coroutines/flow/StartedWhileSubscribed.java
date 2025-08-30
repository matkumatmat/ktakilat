package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSharingStarted.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharingStarted.kt\nkotlinx/coroutines/flow/StartedWhileSubscribed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,205:1\n1#2:206\n*E\n"})
final class StartedWhileSubscribed implements SharingStarted {
    public final boolean equals(Object obj) {
        if (!(obj instanceof StartedWhileSubscribed)) {
            return false;
        }
        StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
        startedWhileSubscribed.getClass();
        startedWhileSubscribed.getClass();
        return true;
    }

    public final int hashCode() {
        int i = (int) 0;
        return (i * 31) + i;
    }

    public final String toString() {
        ListBuilder listBuilder = new ListBuilder(2);
        listBuilder.add("replayExpiration=0ms");
        Intrinsics.checkNotNullParameter(listBuilder, "builder");
        List build = listBuilder.build();
        return "SharingStarted.WhileSubscribed(" + CollectionsKt.p(build, (CharSequence) null, (String) null, (String) null, (Function1) null, 63) + ')';
    }
}
