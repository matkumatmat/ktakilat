package kotlin.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/io/LineReader;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n1#2:300\n*E\n"})
public final class LineReader {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final LineReader f711a = new Object();

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlin.io.LineReader, java.lang.Object] */
    static {
        Intrinsics.checkNotNullExpressionValue(ByteBuffer.wrap(new byte[32]), "wrap(...)");
        Intrinsics.checkNotNullExpressionValue(CharBuffer.wrap(new char[32]), "wrap(...)");
    }
}
