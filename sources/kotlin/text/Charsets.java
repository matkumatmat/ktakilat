package kotlin.text;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.CharEncoding;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/text/Charsets;", "", "Ljava/nio/charset/Charset;", "UTF_8", "Ljava/nio/charset/Charset;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Charsets {
    @NotNull
    @JvmField
    public static final Charset UTF_8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final Charsets f744a = new Object();
    public static volatile Charset b;
    public static volatile Charset c;

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, kotlin.text.Charsets] */
    static {
        Charset forName = Charset.forName(CharEncoding.UTF_8);
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        UTF_8 = forName;
        Intrinsics.checkNotNullExpressionValue(Charset.forName(CharEncoding.UTF_16), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName(CharEncoding.UTF_16BE), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName(CharEncoding.UTF_16LE), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName(CharEncoding.US_ASCII), "forName(...)");
        Intrinsics.checkNotNullExpressionValue(Charset.forName(CharEncoding.ISO_8859_1), "forName(...)");
    }
}
