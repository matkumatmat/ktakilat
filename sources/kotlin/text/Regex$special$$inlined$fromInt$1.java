package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class Regex$special$$inlined$fromInt$1 implements Function1<RegexOption, Boolean> {
    public final /* synthetic */ int c;

    public Regex$special$$inlined$fromInt$1(int i) {
        this.c = i;
    }

    /* renamed from: a */
    public final Boolean invoke(RegexOption regexOption) {
        boolean z;
        FlagEnum flagEnum = regexOption;
        if ((flagEnum.getMask() & this.c) == flagEnum.getValue()) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
