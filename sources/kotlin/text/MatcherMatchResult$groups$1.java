package kotlin.text;

import java.util.Iterator;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.TransformingSequence;
import kotlin.sequences.TransformingSequence$iterator$1;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002¨\u0006\u0004"}, d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {
    public final /* synthetic */ MatcherMatchResult c;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.c = matcherMatchResult;
    }

    public final MatchGroup a(int i) {
        MatcherMatchResult matcherMatchResult = this.c;
        Matcher matcher = matcherMatchResult.f751a;
        IntRange c2 = RangesKt.c(matcher.start(i), matcher.end(i));
        if (c2.c < 0) {
            return null;
        }
        String group = matcherMatchResult.f751a.group(i);
        Intrinsics.checkNotNullExpressionValue(group, "group(...)");
        return new MatchGroup(group, c2);
    }

    public final /* bridge */ boolean contains(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof MatchGroup;
        }
        if (!z) {
            return false;
        }
        return super.contains((MatchGroup) obj);
    }

    public final int getSize() {
        return this.c.f751a.groupCount() + 1;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final Iterator iterator() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        IntProgression intProgression = new IntProgression(0, size() - 1, 1);
        Intrinsics.checkNotNullParameter(intProgression, "<this>");
        CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 = new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(intProgression);
        a aVar = new a(this, 5);
        Intrinsics.checkNotNullParameter(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1, "<this>");
        Intrinsics.checkNotNullParameter(aVar, "transform");
        return new TransformingSequence$iterator$1(new TransformingSequence(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1, aVar));
    }
}
