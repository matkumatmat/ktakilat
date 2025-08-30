package coil3.memory;

import coil3.EventListener;
import coil3.ExtrasKt;
import coil3.RealImageLoader;
import coil3.key.Keyer;
import coil3.memory.MemoryCache;
import coil3.request.AndroidRequestService;
import coil3.request.ImageRequest;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/memory/MemoryCacheService;", "", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMemoryCacheService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MemoryCacheService.kt\ncoil3/memory/MemoryCacheService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 logging.kt\ncoil3/util/LoggingKt\n+ 4 Dimension.kt\ncoil3/size/DimensionKt\n*L\n1#1,247:1\n1#2:248\n68#3,4:249\n68#3,4:253\n68#3,4:261\n68#3,4:265\n43#4:257\n43#4:258\n43#4:259\n43#4:260\n*S KotlinDebug\n*F\n+ 1 MemoryCacheService.kt\ncoil3/memory/MemoryCacheService\n*L\n82#1:249,4\n107#1:253,4\n173#1:261,4\n183#1:265,4\n129#1:257\n130#1:258\n133#1:259\n134#1:260\n*E\n"})
public final class MemoryCacheService {

    /* renamed from: a  reason: collision with root package name */
    public final RealImageLoader f114a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcoil3/memory/MemoryCacheService$Companion;", "", "", "TAG", "Ljava/lang/String;", "EXTRA_SIZE", "EXTRA_IS_SAMPLED", "EXTRA_DISK_CACHE_KEY", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f115a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        static {
            /*
                coil3.size.Scale[] r0 = coil3.size.Scale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                coil3.size.Scale r2 = coil3.size.Scale.FILL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                coil3.size.Scale r3 = coil3.size.Scale.FIT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f115a = r0
                coil3.size.Precision[] r0 = coil3.size.Precision.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                coil3.size.Precision r3 = coil3.size.Precision.EXACT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                coil3.size.Precision r1 = coil3.size.Precision.INEXACT     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: coil3.memory.MemoryCacheService.WhenMappings.<clinit>():void");
        }
    }

    public MemoryCacheService(RealImageLoader realImageLoader, AndroidRequestService androidRequestService) {
        this.f114a = realImageLoader;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r1.equals(r19.toString()) != false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0137, code lost:
        if (r12 <= 1.0d) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0142, code lost:
        if (r12 == 1.0d) goto L_0x0144;
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil3.memory.MemoryCache.Value a(coil3.request.ImageRequest r17, coil3.memory.MemoryCache.Key r18, coil3.size.Size r19, coil3.size.Scale r20) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            coil3.request.CachePolicy r3 = r0.j
            boolean r3 = r3.getReadEnabled()
            r4 = 0
            if (r3 != 0) goto L_0x0010
            return r4
        L_0x0010:
            r3 = r16
            coil3.RealImageLoader r5 = r3.f114a
            coil3.memory.MemoryCache r5 = r5.c()
            if (r5 == 0) goto L_0x001f
            coil3.memory.MemoryCache$Value r5 = r5.a(r1)
            goto L_0x0020
        L_0x001f:
            r5 = r4
        L_0x0020:
            if (r5 == 0) goto L_0x0146
            coil3.Image r6 = r5.f113a
            boolean r7 = r6 instanceof coil3.BitmapImage
            if (r7 == 0) goto L_0x002c
            r7 = r6
            coil3.BitmapImage r7 = (coil3.BitmapImage) r7
            goto L_0x002d
        L_0x002c:
            r7 = r4
        L_0x002d:
            r8 = 1
            if (r7 != 0) goto L_0x0032
            r7 = 1
            goto L_0x0040
        L_0x0032:
            android.graphics.Bitmap r7 = r7.f47a
            android.graphics.Bitmap$Config r7 = r7.getConfig()
            if (r7 != 0) goto L_0x003c
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
        L_0x003c:
            boolean r7 = coil3.request.AndroidRequestService.b(r0, r7)
        L_0x0040:
            if (r7 != 0) goto L_0x0044
            goto L_0x0146
        L_0x0044:
            java.lang.String r7 = "coil#size"
            java.util.Map r1 = r1.b
            java.lang.Object r1 = r1.get(r7)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x005d
            java.lang.String r0 = r19.toString()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0146
        L_0x005a:
            r10 = r5
            goto L_0x0144
        L_0x005d:
            java.lang.String r1 = "coil#is_sampled"
            java.util.Map r7 = r5.b
            java.lang.Object r1 = r7.get(r1)
            boolean r7 = r1 instanceof java.lang.Boolean
            if (r7 == 0) goto L_0x006c
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            goto L_0x006d
        L_0x006c:
            r1 = r4
        L_0x006d:
            if (r1 == 0) goto L_0x0074
            boolean r1 = r1.booleanValue()
            goto L_0x0075
        L_0x0074:
            r1 = 0
        L_0x0075:
            coil3.size.Precision r7 = r0.r
            if (r1 != 0) goto L_0x0086
            coil3.size.Size r1 = coil3.size.Size.c
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r2, r1)
            if (r1 != 0) goto L_0x005a
            coil3.size.Precision r1 = coil3.size.Precision.INEXACT
            if (r7 != r1) goto L_0x0086
            goto L_0x005a
        L_0x0086:
            int r1 = r6.getWidth()
            int r9 = r6.getHeight()
            boolean r6 = r6 instanceof coil3.BitmapImage
            if (r6 == 0) goto L_0x009b
            coil3.Extras$Key r6 = coil3.request.ImageRequestsKt.f141a
            java.lang.Object r0 = coil3.ExtrasKt.a(r0, r6)
            coil3.size.Size r0 = (coil3.size.Size) r0
            goto L_0x009d
        L_0x009b:
            coil3.size.Size r0 = coil3.size.Size.c
        L_0x009d:
            coil3.size.Dimension r6 = r2.f150a
            boolean r10 = r6 instanceof coil3.size.Dimension.Pixels
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r10 == 0) goto L_0x00ab
            coil3.size.Dimension$Pixels r6 = (coil3.size.Dimension.Pixels) r6
            int r6 = r6.f148a
            goto L_0x00ae
        L_0x00ab:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L_0x00ae:
            coil3.size.Dimension r10 = r0.f150a
            boolean r12 = r10 instanceof coil3.size.Dimension.Pixels
            if (r12 == 0) goto L_0x00b9
            coil3.size.Dimension$Pixels r10 = (coil3.size.Dimension.Pixels) r10
            int r10 = r10.f148a
            goto L_0x00bc
        L_0x00b9:
            r10 = 2147483647(0x7fffffff, float:NaN)
        L_0x00bc:
            int r6 = java.lang.Math.min(r6, r10)
            coil3.size.Dimension r2 = r2.b
            boolean r10 = r2 instanceof coil3.size.Dimension.Pixels
            if (r10 == 0) goto L_0x00cb
            coil3.size.Dimension$Pixels r2 = (coil3.size.Dimension.Pixels) r2
            int r2 = r2.f148a
            goto L_0x00ce
        L_0x00cb:
            r2 = 2147483647(0x7fffffff, float:NaN)
        L_0x00ce:
            coil3.size.Dimension r0 = r0.b
            boolean r10 = r0 instanceof coil3.size.Dimension.Pixels
            if (r10 == 0) goto L_0x00d9
            coil3.size.Dimension$Pixels r0 = (coil3.size.Dimension.Pixels) r0
            int r0 = r0.f148a
            goto L_0x00dc
        L_0x00d9:
            r0 = 2147483647(0x7fffffff, float:NaN)
        L_0x00dc:
            int r0 = java.lang.Math.min(r2, r0)
            double r12 = (double) r6
            double r14 = (double) r1
            double r12 = r12 / r14
            double r14 = (double) r0
            r10 = r5
            double r4 = (double) r9
            double r14 = r14 / r4
            if (r6 == r11) goto L_0x00ee
            if (r0 == r11) goto L_0x00ee
            r4 = r20
            goto L_0x00f0
        L_0x00ee:
            coil3.size.Scale r4 = coil3.size.Scale.FIT
        L_0x00f0:
            int[] r5 = coil3.memory.MemoryCacheService.WhenMappings.f115a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 2
            if (r4 == r8) goto L_0x0114
            if (r4 != r5) goto L_0x010e
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 >= 0) goto L_0x0107
            int r6 = r6 - r1
            int r0 = java.lang.Math.abs(r6)
            goto L_0x0124
        L_0x0107:
            int r0 = r0 - r9
            int r0 = java.lang.Math.abs(r0)
        L_0x010c:
            r12 = r14
            goto L_0x0124
        L_0x010e:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0114:
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x011e
            int r6 = r6 - r1
            int r0 = java.lang.Math.abs(r6)
            goto L_0x0124
        L_0x011e:
            int r0 = r0 - r9
            int r0 = java.lang.Math.abs(r0)
            goto L_0x010c
        L_0x0124:
            if (r0 > r8) goto L_0x0127
            goto L_0x0144
        L_0x0127:
            int[] r0 = coil3.memory.MemoryCacheService.WhenMappings.b
            int r1 = r7.ordinal()
            r0 = r0[r1]
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r0 == r8) goto L_0x0140
            if (r0 != r5) goto L_0x013a
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0146
            goto L_0x0144
        L_0x013a:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0140:
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0146
        L_0x0144:
            r4 = r10
            goto L_0x0147
        L_0x0146:
            r4 = 0
        L_0x0147:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.memory.MemoryCacheService.a(coil3.request.ImageRequest, coil3.memory.MemoryCache$Key, coil3.size.Size, coil3.size.Scale):coil3.memory.MemoryCache$Value");
    }

    public final MemoryCache.Key b(ImageRequest imageRequest, Object obj, Options options, EventListener eventListener) {
        String str;
        Map map = imageRequest.d;
        List list = this.f114a.d.c;
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                str = null;
                break;
            }
            Pair pair = (Pair) list.get(i);
            Keyer keyer = (Keyer) pair.component1();
            if (((KClass) pair.component2()).d(obj)) {
                Intrinsics.d(keyer, "null cannot be cast to non-null type coil3.key.Keyer<kotlin.Any>");
                str = keyer.a(obj, options);
                if (str != null) {
                    break;
                }
            }
            i++;
        }
        if (str == null) {
            return null;
        }
        LinkedHashMap i2 = MapsKt.i(map);
        if (!((List) ExtrasKt.a(imageRequest, ImageRequests_androidKt.f142a)).isEmpty()) {
            i2.put("coil#size", options.b.toString());
        }
        return new MemoryCache.Key(str, i2);
    }
}
