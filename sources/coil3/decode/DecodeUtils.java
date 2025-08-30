package coil3.decode;

import coil3.size.Dimension;
import coil3.size.Scale;
import coil3.size.Size;
import coil3.util.IntPair;
import coil3.util.UtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/decode/DecodeUtils;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDecodeUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DecodeUtils.kt\ncoil3/decode/DecodeUtils\n+ 2 Dimension.kt\ncoil3/size/DimensionKt\n*L\n1#1,127:1\n43#2:128\n*S KotlinDebug\n*F\n+ 1 DecodeUtils.kt\ncoil3/decode/DecodeUtils\n*L\n120#1:128\n*E\n"})
public final class DecodeUtils {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f72a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                coil3.size.Scale[] r0 = coil3.size.Scale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                coil3.size.Scale r1 = coil3.size.Scale.FILL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                coil3.size.Scale r1 = coil3.size.Scale.FIT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f72a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.decode.DecodeUtils.WhenMappings.<clinit>():void");
        }
    }

    public static final long a(int i, int i2, Size size, Scale scale, Size size2) {
        int i3;
        int i4;
        if (!Intrinsics.a(size, Size.c)) {
            i = c(size.f150a, scale);
            i2 = c(size.b, scale);
        }
        Dimension dimension = size2.f150a;
        if (dimension instanceof Dimension.Pixels) {
            Function1 function1 = UtilsKt.f161a;
            if (!(i == Integer.MIN_VALUE || i == Integer.MAX_VALUE || i <= (i4 = ((Dimension.Pixels) dimension).f148a))) {
                i = i4;
            }
        }
        Dimension dimension2 = size2.b;
        if (dimension2 instanceof Dimension.Pixels) {
            Function1 function12 = UtilsKt.f161a;
            if (!(i2 == Integer.MIN_VALUE || i2 == Integer.MAX_VALUE || i2 <= (i3 = ((Dimension.Pixels) dimension2).f148a))) {
                i2 = i3;
            }
        }
        return IntPair.a(i, i2);
    }

    public static final double b(int i, int i2, int i3, int i4, Scale scale) {
        double d = ((double) i3) / ((double) i);
        double d2 = ((double) i4) / ((double) i2);
        int i5 = WhenMappings.f72a[scale.ordinal()];
        if (i5 == 1) {
            return Math.max(d, d2);
        }
        if (i5 == 2) {
            return Math.min(d, d2);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static int c(Dimension dimension, Scale scale) {
        if (dimension instanceof Dimension.Pixels) {
            return ((Dimension.Pixels) dimension).f148a;
        }
        int i = WhenMappings.f72a[scale.ordinal()];
        if (i == 1) {
            return Integer.MIN_VALUE;
        }
        if (i == 2) {
            return Integer.MAX_VALUE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
