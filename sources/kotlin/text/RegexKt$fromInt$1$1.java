package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class RegexKt$fromInt$1$1 implements Function1<Enum<Object>, Boolean> {
    /* renamed from: a */
    public final Boolean invoke(Enum<Object> enumR) {
        boolean z;
        FlagEnum flagEnum = (FlagEnum) enumR;
        flagEnum.getMask();
        if (flagEnum.getValue() == 0) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
