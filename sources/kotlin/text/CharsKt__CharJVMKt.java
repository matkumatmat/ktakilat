package kotlin.text;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ranges.IntProgression;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "radix", "checkRadix", "(I)I", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    public static final boolean a(char c) {
        if (Character.isWhitespace(c) || Character.isSpaceChar(c)) {
            return true;
        }
        return false;
    }

    @PublishedApi
    public static int checkRadix(int i) {
        if (2 <= i && i < 37) {
            return i;
        }
        StringBuilder t = ba.t(i, "radix ", " was not in valid range ");
        t.append(new IntProgression(2, 36, 1));
        throw new IllegalArgumentException(t.toString());
    }
}
