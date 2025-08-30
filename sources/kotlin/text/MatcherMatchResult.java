package kotlin.text;

import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MatcherMatchResult implements MatchResult {

    /* renamed from: a  reason: collision with root package name */
    public final Matcher f751a;
    public final CharSequence b;
    public final MatcherMatchResult$groups$1 c = new MatcherMatchResult$groups$1(this);

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(charSequence, "input");
        this.f751a = matcher;
        this.b = charSequence;
    }

    public final MatcherMatchResult$groups$1 a() {
        return this.c;
    }

    public final IntRange b() {
        Matcher matcher = this.f751a;
        return RangesKt.c(matcher.start(), matcher.end());
    }

    public final MatchResult next() {
        int i;
        Matcher matcher = this.f751a;
        int end = matcher.end();
        if (matcher.end() == matcher.start()) {
            i = 1;
        } else {
            i = 0;
        }
        int i2 = end + i;
        CharSequence charSequence = this.b;
        if (i2 > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher2, "matcher(...)");
        if (!matcher2.find(i2)) {
            return null;
        }
        return new MatcherMatchResult(matcher2, charSequence);
    }
}
