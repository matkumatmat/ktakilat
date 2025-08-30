package coil3.network;

import android.content.Context;
import android.os.Looper;
import android.os.NetworkOnMainThreadException;
import coil3.Extras;
import coil3.ExtrasKt;
import coil3.RealImageLoader;
import coil3.Uri;
import coil3.decode.FileImageSource;
import coil3.decode.ImageSourceKt;
import coil3.disk.DiskCache;
import coil3.fetch.Fetcher;
import coil3.network.NetworkHeaders;
import coil3.network.internal.SingleParameterLazy;
import coil3.network.internal.SingleParameterLazyKt;
import coil3.request.CachePolicy;
import coil3.request.Options;
import coil3.util.MimeTypeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/network/NetworkFetcher;", "Lcoil3/fetch/Fetcher;", "Factory", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetworkFetcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkFetcher.kt\ncoil3/network/NetworkFetcher\n+ 2 FileSystem.kt\nokio/FileSystem\n+ 3 Okio.kt\nokio/Okio__OkioKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,291:1\n80#2:292\n165#2:293\n81#2:294\n82#2:299\n67#2:330\n68#2:335\n52#3,4:295\n60#3,10:300\n56#3,18:310\n66#3:329\n52#3,4:331\n60#3,10:336\n56#3,3:346\n71#3,3:349\n1#4:328\n*S KotlinDebug\n*F\n+ 1 NetworkFetcher.kt\ncoil3/network/NetworkFetcher\n*L\n150#1:292\n150#1:293\n150#1:294\n150#1:299\n224#1:330\n224#1:335\n150#1:295,4\n150#1:300,10\n150#1:310,18\n224#1:329\n224#1:331,4\n224#1:336,10\n224#1:346,3\n224#1:349,3\n*E\n"})
public final class NetworkFetcher implements Fetcher {

    /* renamed from: a  reason: collision with root package name */
    public final String f126a;
    public final Options b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final ConnectivityChecker f;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcoil3/network/NetworkFetcher$Factory;", "Lcoil3/fetch/Fetcher$Factory;", "Lcoil3/Uri;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory implements Fetcher.Factory<Uri> {

        /* renamed from: a  reason: collision with root package name */
        public final Lazy f127a;
        public final Lazy b;
        public final SingleParameterLazy c;

        public Factory(q0 q0Var) {
            q0 q0Var2 = new q0(12);
            AnonymousClass2 r1 = AnonymousClass2.c;
            this.f127a = LazyKt.b(q0Var);
            this.b = LazyKt.b(q0Var2);
            this.c = SingleParameterLazyKt.a(r1);
        }

        public final Fetcher a(Object obj, Options options, RealImageLoader realImageLoader) {
            Uri uri = (Uri) obj;
            if (!Intrinsics.a(uri.c, "http") && !Intrinsics.a(uri.c, "https")) {
                return null;
            }
            Lazy lazy = this.f127a;
            Lazy b2 = LazyKt.b(new c(realImageLoader, 6));
            Lazy lazy2 = this.b;
            Context context = options.f145a;
            return new NetworkFetcher(uri.f65a, options, lazy, b2, lazy2, (ConnectivityChecker) this.c.a(context));
        }
    }

    public NetworkFetcher(String str, Options options, Lazy lazy, Lazy lazy2, Lazy lazy3, ConnectivityChecker connectivityChecker) {
        this.f126a = str;
        this.b = options;
        this.c = lazy;
        this.d = lazy2;
        this.e = lazy3;
        this.f = connectivityChecker;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(coil3.network.NetworkFetcher r4, coil3.network.NetworkResponseBody r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            boolean r0 = r6 instanceof coil3.network.NetworkFetcher$toImageSource$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            coil3.network.NetworkFetcher$toImageSource$1 r0 = (coil3.network.NetworkFetcher$toImageSource$1) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            coil3.network.NetworkFetcher$toImageSource$1 r0 = new coil3.network.NetworkFetcher$toImageSource$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            okio.Buffer r4 = r0.d
            coil3.network.NetworkFetcher r5 = r0.c
            kotlin.ResultKt.b(r6)
            r6 = r4
            r4 = r5
            goto L_0x004a
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.b(r6)
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            r0.c = r4
            r0.d = r6
            r0.g = r3
            kotlin.Unit r5 = r5.a(r6)
            if (r5 != r1) goto L_0x004a
            goto L_0x0054
        L_0x004a:
            okio.FileSystem r4 = r4.e()
            coil3.decode.SourceImageSource r1 = new coil3.decode.SourceImageSource
            r5 = 0
            r1.<init>(r6, r4, r5)
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.b(coil3.network.NetworkFetcher, coil3.network.NetworkResponseBody, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: coil3.network.NetworkResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: coil3.disk.DiskCache$Snapshot} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x010c A[SYNTHETIC, Splitter:B:72:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0116 A[SYNTHETIC, Splitter:B:79:0x0116] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(coil3.network.NetworkFetcher r5, coil3.disk.DiskCache.Snapshot r6, coil3.network.NetworkResponse r7, coil3.network.NetworkRequest r8, coil3.network.NetworkResponse r9, kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r5.getClass()
            boolean r8 = r10 instanceof coil3.network.NetworkFetcher$writeToDiskCache$1
            if (r8 == 0) goto L_0x0016
            r8 = r10
            coil3.network.NetworkFetcher$writeToDiskCache$1 r8 = (coil3.network.NetworkFetcher$writeToDiskCache$1) r8
            int r0 = r8.i
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0016
            int r0 = r0 - r1
            r8.i = r0
            goto L_0x001b
        L_0x0016:
            coil3.network.NetworkFetcher$writeToDiskCache$1 r8 = new coil3.network.NetworkFetcher$writeToDiskCache$1
            r8.<init>(r5, r10)
        L_0x001b:
            java.lang.Object r10 = r8.f
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r8.i
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0058
            if (r1 == r3) goto L_0x0046
            if (r1 != r2) goto L_0x003e
            java.lang.Object r5 = r8.e
            coil3.disk.DiskCache$Editor r5 = (coil3.disk.DiskCache.Editor) r5
            java.lang.Object r6 = r8.d
            coil3.network.NetworkResponse r6 = (coil3.network.NetworkResponse) r6
            java.lang.Object r7 = r8.c
            coil3.network.NetworkResponse r7 = (coil3.network.NetworkResponse) r7
            kotlin.ResultKt.b(r10)     // Catch:{ Exception -> 0x003b }
            goto L_0x00ff
        L_0x003b:
            r8 = move-exception
            goto L_0x0105
        L_0x003e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0046:
            java.lang.Object r5 = r8.e
            r9 = r5
            coil3.network.NetworkResponse r9 = (coil3.network.NetworkResponse) r9
            java.lang.Object r5 = r8.d
            r6 = r5
            coil3.disk.DiskCache$Snapshot r6 = (coil3.disk.DiskCache.Snapshot) r6
            java.lang.Object r5 = r8.c
            coil3.network.NetworkFetcher r5 = (coil3.network.NetworkFetcher) r5
            kotlin.ResultKt.b(r10)
            goto L_0x0088
        L_0x0058:
            kotlin.ResultKt.b(r10)
            coil3.request.Options r10 = r5.b
            coil3.request.CachePolicy r10 = r10.h
            boolean r10 = r10.getWriteEnabled()
            if (r10 != 0) goto L_0x0070
            if (r6 == 0) goto L_0x006d
            r6.close()     // Catch:{ RuntimeException -> 0x006b, Exception -> 0x006d }
            goto L_0x006d
        L_0x006b:
            r5 = move-exception
            throw r5
        L_0x006d:
            r0 = r4
            goto L_0x0103
        L_0x0070:
            kotlin.Lazy r10 = r5.e
            java.lang.Object r10 = r10.getValue()
            coil3.network.CacheStrategy r10 = (coil3.network.CacheStrategy) r10
            r8.c = r5
            r8.d = r6
            r8.e = r9
            r8.i = r3
            coil3.network.CacheStrategy$WriteResult r10 = r10.b(r7, r9)
            if (r10 != r0) goto L_0x0088
            goto L_0x0103
        L_0x0088:
            coil3.network.CacheStrategy$WriteResult r10 = (coil3.network.CacheStrategy.WriteResult) r10
            coil3.network.NetworkResponse r7 = r10.f123a
            if (r7 != 0) goto L_0x008f
            goto L_0x006d
        L_0x008f:
            if (r6 == 0) goto L_0x0096
            coil3.disk.DiskCache$Editor r6 = r6.l()
            goto L_0x00ae
        L_0x0096:
            kotlin.Lazy r6 = r5.d
            java.lang.Object r6 = r6.getValue()
            coil3.disk.DiskCache r6 = (coil3.disk.DiskCache) r6
            if (r6 == 0) goto L_0x00ad
            coil3.request.Options r10 = r5.b
            java.lang.String r10 = r10.e
            if (r10 != 0) goto L_0x00a8
            java.lang.String r10 = r5.f126a
        L_0x00a8:
            coil3.disk.DiskCache$Editor r6 = r6.a(r10)
            goto L_0x00ae
        L_0x00ad:
            r6 = r4
        L_0x00ae:
            if (r6 != 0) goto L_0x00b1
            goto L_0x006d
        L_0x00b1:
            okio.FileSystem r10 = r5.e()     // Catch:{ Exception -> 0x00da }
            okio.Path r1 = r6.getMetadata()     // Catch:{ Exception -> 0x00da }
            r3 = 0
            okio.Sink r10 = r10.sink(r1, r3)     // Catch:{ Exception -> 0x00da }
            okio.BufferedSink r10 = okio.Okio.buffer((okio.Sink) r10)     // Catch:{ Exception -> 0x00da }
            coil3.network.CacheNetworkResponse.b(r7, r10)     // Catch:{ all -> 0x00cd }
            kotlin.Unit r1 = kotlin.Unit.f696a     // Catch:{ all -> 0x00cd }
            r10.close()     // Catch:{ all -> 0x00cb }
            goto L_0x00df
        L_0x00cb:
            r4 = move-exception
            goto L_0x00df
        L_0x00cd:
            r1 = move-exception
            r4 = r1
            if (r10 == 0) goto L_0x00df
            r10.close()     // Catch:{ all -> 0x00d5 }
            goto L_0x00df
        L_0x00d5:
            r10 = move-exception
            kotlin.ExceptionsKt.a(r4, r10)     // Catch:{ Exception -> 0x00da }
            goto L_0x00df
        L_0x00da:
            r8 = move-exception
            r5 = r6
            r6 = r7
            r7 = r9
            goto L_0x0105
        L_0x00df:
            if (r4 != 0) goto L_0x0104
            coil3.network.NetworkResponseBody r10 = r7.e     // Catch:{ Exception -> 0x00da }
            if (r10 == 0) goto L_0x00fc
            okio.FileSystem r5 = r5.e()     // Catch:{ Exception -> 0x00da }
            okio.Path r1 = r6.getData()     // Catch:{ Exception -> 0x00da }
            r8.c = r9     // Catch:{ Exception -> 0x00da }
            r8.d = r7     // Catch:{ Exception -> 0x00da }
            r8.e = r6     // Catch:{ Exception -> 0x00da }
            r8.i = r2     // Catch:{ Exception -> 0x00da }
            kotlin.Unit r5 = r10.n(r5, r1)     // Catch:{ Exception -> 0x00da }
            if (r5 != r0) goto L_0x00fc
            goto L_0x0103
        L_0x00fc:
            r5 = r6
            r6 = r7
            r7 = r9
        L_0x00ff:
            coil3.disk.DiskCache$Snapshot r0 = r5.a()     // Catch:{ Exception -> 0x003b }
        L_0x0103:
            return r0
        L_0x0104:
            throw r4     // Catch:{ Exception -> 0x00da }
        L_0x0105:
            r5.abort()     // Catch:{ Exception -> 0x0108 }
        L_0x0108:
            coil3.network.NetworkResponseBody r5 = r7.e
            if (r5 == 0) goto L_0x0112
            r5.close()     // Catch:{ RuntimeException -> 0x0110, Exception -> 0x0112 }
            goto L_0x0112
        L_0x0110:
            r5 = move-exception
            throw r5
        L_0x0112:
            coil3.network.NetworkResponseBody r5 = r6.e
            if (r5 == 0) goto L_0x011c
            r5.close()     // Catch:{ RuntimeException -> 0x011a, Exception -> 0x011c }
            goto L_0x011c
        L_0x011a:
            r5 = move-exception
            throw r5
        L_0x011c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.c(coil3.network.NetworkFetcher, coil3.disk.DiskCache$Snapshot, coil3.network.NetworkResponse, coil3.network.NetworkRequest, coil3.network.NetworkResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static String f(String str, String str2) {
        String b2;
        if ((str2 == null || StringsKt.I(str2, "text/plain", false)) && (b2 = MimeTypeMap.b(str)) != null) {
            return b2;
        }
        if (str2 == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(str2, "<this>");
        Intrinsics.checkNotNullParameter(str2, "missingDelimiterValue");
        int r = StringsKt.r(str2, ';', 0, false, 6);
        if (r == -1) {
            return str2;
        }
        String substring = str2.substring(0, r);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0108 A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0126 A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0147 A[Catch:{ Exception -> 0x004f }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0148 A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0151 A[Catch:{ Exception -> 0x004f }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            boolean r2 = r0 instanceof coil3.network.NetworkFetcher$fetch$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            coil3.network.NetworkFetcher$fetch$1 r2 = (coil3.network.NetworkFetcher$fetch$1) r2
            int r3 = r2.i
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.i = r3
            goto L_0x001e
        L_0x0017:
            coil3.network.NetworkFetcher$fetch$1 r2 = new coil3.network.NetworkFetcher$fetch$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r0 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r0
            r2.<init>(r1, r0)
        L_0x001e:
            java.lang.Object r0 = r2.f
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r2.i
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 == r7) goto L_0x0053
            if (r4 == r6) goto L_0x0044
            if (r4 != r5) goto L_0x003c
            java.lang.Object r2 = r2.c
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            kotlin.ResultKt.b(r0)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0168
        L_0x0039:
            r0 = move-exception
            goto L_0x016b
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0044:
            kotlin.jvm.internal.Ref$ObjectRef r4 = r2.d
            java.lang.Object r6 = r2.c
            coil3.network.NetworkFetcher r6 = (coil3.network.NetworkFetcher) r6
            kotlin.ResultKt.b(r0)     // Catch:{ Exception -> 0x004f }
            goto L_0x014d
        L_0x004f:
            r0 = move-exception
            r2 = r4
            goto L_0x016b
        L_0x0053:
            kotlin.jvm.internal.Ref$ObjectRef r4 = r2.e
            kotlin.jvm.internal.Ref$ObjectRef r7 = r2.d
            java.lang.Object r9 = r2.c
            coil3.network.NetworkFetcher r9 = (coil3.network.NetworkFetcher) r9
            kotlin.ResultKt.b(r0)     // Catch:{ Exception -> 0x0065 }
            r16 = r7
            r7 = r4
            r4 = r16
            goto L_0x0102
        L_0x0065:
            r0 = move-exception
            r2 = r7
            goto L_0x016b
        L_0x0069:
            kotlin.ResultKt.b(r0)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            coil3.request.Options r0 = r1.b
            coil3.request.CachePolicy r9 = r0.h
            boolean r9 = r9.getReadEnabled()
            java.lang.String r10 = r1.f126a
            if (r9 == 0) goto L_0x0091
            kotlin.Lazy r9 = r1.d
            java.lang.Object r9 = r9.getValue()
            coil3.disk.DiskCache r9 = (coil3.disk.DiskCache) r9
            if (r9 == 0) goto L_0x0091
            java.lang.String r0 = r0.e
            if (r0 != 0) goto L_0x008c
            r0 = r10
        L_0x008c:
            coil3.disk.DiskCache$Snapshot r0 = r9.c(r0)
            goto L_0x0092
        L_0x0091:
            r0 = r8
        L_0x0092:
            r4.element = r0
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x004f }
            r0.<init>()     // Catch:{ Exception -> 0x004f }
            T r9 = r4.element     // Catch:{ Exception -> 0x004f }
            if (r9 == 0) goto L_0x0129
            okio.FileSystem r9 = r17.e()     // Catch:{ Exception -> 0x004f }
            T r11 = r4.element     // Catch:{ Exception -> 0x004f }
            coil3.disk.DiskCache$Snapshot r11 = (coil3.disk.DiskCache.Snapshot) r11     // Catch:{ Exception -> 0x004f }
            okio.Path r11 = r11.getMetadata()     // Catch:{ Exception -> 0x004f }
            okio.FileMetadata r9 = r9.metadata(r11)     // Catch:{ Exception -> 0x004f }
            java.lang.Long r9 = r9.getSize()     // Catch:{ Exception -> 0x004f }
            if (r9 != 0) goto L_0x00b4
            goto L_0x00d2
        L_0x00b4:
            long r11 = r9.longValue()     // Catch:{ Exception -> 0x004f }
            r13 = 0
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 != 0) goto L_0x00d2
            coil3.fetch.SourceFetchResult r0 = new coil3.fetch.SourceFetchResult     // Catch:{ Exception -> 0x004f }
            T r2 = r4.element     // Catch:{ Exception -> 0x004f }
            coil3.disk.DiskCache$Snapshot r2 = (coil3.disk.DiskCache.Snapshot) r2     // Catch:{ Exception -> 0x004f }
            coil3.decode.FileImageSource r2 = r1.h(r2)     // Catch:{ Exception -> 0x004f }
            java.lang.String r3 = f(r10, r8)     // Catch:{ Exception -> 0x004f }
            coil3.decode.DataSource r5 = coil3.decode.DataSource.DISK     // Catch:{ Exception -> 0x004f }
            r0.<init>(r2, r3, r5)     // Catch:{ Exception -> 0x004f }
            return r0
        L_0x00d2:
            T r9 = r4.element     // Catch:{ Exception -> 0x004f }
            coil3.disk.DiskCache$Snapshot r9 = (coil3.disk.DiskCache.Snapshot) r9     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkResponse r9 = r1.i(r9)     // Catch:{ Exception -> 0x004f }
            r0.element = r9     // Catch:{ Exception -> 0x004f }
            if (r9 == 0) goto L_0x0129
            kotlin.Lazy r9 = r1.e     // Catch:{ Exception -> 0x004f }
            java.lang.Object r9 = r9.getValue()     // Catch:{ Exception -> 0x004f }
            coil3.network.CacheStrategy r9 = (coil3.network.CacheStrategy) r9     // Catch:{ Exception -> 0x004f }
            T r10 = r0.element     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkResponse r10 = (coil3.network.NetworkResponse) r10     // Catch:{ Exception -> 0x004f }
            r17.g()     // Catch:{ Exception -> 0x004f }
            r2.c = r1     // Catch:{ Exception -> 0x004f }
            r2.d = r4     // Catch:{ Exception -> 0x004f }
            r2.e = r0     // Catch:{ Exception -> 0x004f }
            r2.i = r7     // Catch:{ Exception -> 0x004f }
            coil3.network.CacheStrategy$ReadResult r7 = r9.a(r10)     // Catch:{ Exception -> 0x004f }
            if (r7 != r3) goto L_0x00fc
            return r3
        L_0x00fc:
            r9 = r1
            r16 = r7
            r7 = r0
            r0 = r16
        L_0x0102:
            coil3.network.CacheStrategy$ReadResult r0 = (coil3.network.CacheStrategy.ReadResult) r0     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkResponse r10 = r0.f122a     // Catch:{ Exception -> 0x004f }
            if (r10 == 0) goto L_0x0126
            coil3.fetch.SourceFetchResult r2 = new coil3.fetch.SourceFetchResult     // Catch:{ Exception -> 0x004f }
            T r3 = r4.element     // Catch:{ Exception -> 0x004f }
            coil3.disk.DiskCache$Snapshot r3 = (coil3.disk.DiskCache.Snapshot) r3     // Catch:{ Exception -> 0x004f }
            coil3.decode.FileImageSource r3 = r9.h(r3)     // Catch:{ Exception -> 0x004f }
            java.lang.String r5 = r9.f126a     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkResponse r0 = r0.f122a     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkHeaders r0 = r0.d     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x004f }
            java.lang.String r0 = f(r5, r0)     // Catch:{ Exception -> 0x004f }
            coil3.decode.DataSource r5 = coil3.decode.DataSource.DISK     // Catch:{ Exception -> 0x004f }
            r2.<init>(r3, r0, r5)     // Catch:{ Exception -> 0x004f }
            return r2
        L_0x0126:
            r12 = r7
            r0 = r9
            goto L_0x012b
        L_0x0129:
            r12 = r0
            r0 = r1
        L_0x012b:
            coil3.network.NetworkRequest r7 = r0.g()     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkFetcher$fetch$fetchResult$1 r15 = new coil3.network.NetworkFetcher$fetch$fetchResult$1     // Catch:{ Exception -> 0x004f }
            r14 = 0
            r9 = r15
            r10 = r4
            r11 = r0
            r13 = r7
            r9.<init>(r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x004f }
            r2.c = r0     // Catch:{ Exception -> 0x004f }
            r2.d = r4     // Catch:{ Exception -> 0x004f }
            r2.e = r8     // Catch:{ Exception -> 0x004f }
            r2.i = r6     // Catch:{ Exception -> 0x004f }
            java.lang.Object r6 = r0.d(r7, r15, r2)     // Catch:{ Exception -> 0x004f }
            if (r6 != r3) goto L_0x0148
            return r3
        L_0x0148:
            r16 = r6
            r6 = r0
            r0 = r16
        L_0x014d:
            coil3.fetch.SourceFetchResult r0 = (coil3.fetch.SourceFetchResult) r0     // Catch:{ Exception -> 0x004f }
            if (r0 != 0) goto L_0x016a
            coil3.network.NetworkRequest r0 = r6.g()     // Catch:{ Exception -> 0x004f }
            coil3.network.NetworkFetcher$fetch$2 r7 = new coil3.network.NetworkFetcher$fetch$2     // Catch:{ Exception -> 0x004f }
            r7.<init>(r6, r8)     // Catch:{ Exception -> 0x004f }
            r2.c = r4     // Catch:{ Exception -> 0x004f }
            r2.d = r8     // Catch:{ Exception -> 0x004f }
            r2.i = r5     // Catch:{ Exception -> 0x004f }
            java.lang.Object r0 = r6.d(r0, r7, r2)     // Catch:{ Exception -> 0x004f }
            if (r0 != r3) goto L_0x0167
            return r3
        L_0x0167:
            r2 = r4
        L_0x0168:
            coil3.fetch.SourceFetchResult r0 = (coil3.fetch.SourceFetchResult) r0     // Catch:{ Exception -> 0x0039 }
        L_0x016a:
            return r0
        L_0x016b:
            T r2 = r2.element
            coil3.disk.DiskCache$Snapshot r2 = (coil3.disk.DiskCache.Snapshot) r2
            if (r2 == 0) goto L_0x0178
            r2.close()     // Catch:{ RuntimeException -> 0x0175, Exception -> 0x0178 }
            goto L_0x0178
        L_0x0175:
            r0 = move-exception
            r2 = r0
            throw r2
        L_0x0178:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object d(NetworkRequest networkRequest, Function2 function2, Continuation continuation) {
        if (!this.b.i.getReadEnabled() || !Intrinsics.a(Looper.myLooper(), Looper.getMainLooper())) {
            return ((NetworkClient) this.c.getValue()).a(networkRequest, new NetworkFetcher$executeNetworkRequest$2(function2, (Continuation) null), continuation);
        }
        throw new NetworkOnMainThreadException();
    }

    public final FileSystem e() {
        FileSystem b2;
        DiskCache diskCache = (DiskCache) this.d.getValue();
        if (diskCache == null || (b2 = diskCache.b()) == null) {
            return this.b.f;
        }
        return b2;
    }

    public final NetworkRequest g() {
        boolean z;
        Extras.Key key = ImageRequestsKt.b;
        Options options = this.b;
        NetworkHeaders networkHeaders = (NetworkHeaders) ExtrasKt.b(options, key);
        networkHeaders.getClass();
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder(networkHeaders);
        CachePolicy cachePolicy = options.h;
        boolean readEnabled = cachePolicy.getReadEnabled();
        if (!options.i.getReadEnabled() || !this.f.a()) {
            z = false;
        } else {
            z = true;
        }
        if (!z && readEnabled) {
            builder.c("only-if-cached, max-stale=2147483647");
        } else if (!z || readEnabled) {
            if (!z && !readEnabled) {
                builder.c("no-cache, only-if-cached");
            }
        } else if (cachePolicy.getWriteEnabled()) {
            builder.c("no-cache");
        } else {
            builder.c("no-cache, no-store");
        }
        return new NetworkRequest(this.f126a, (String) ExtrasKt.b(options, ImageRequestsKt.f125a), builder.b(), (NetworkRequestBody) ExtrasKt.b(options, ImageRequestsKt.c));
    }

    public final FileImageSource h(DiskCache.Snapshot snapshot) {
        Path data = snapshot.getData();
        FileSystem e2 = e();
        String str = this.b.e;
        if (str == null) {
            str = this.f126a;
        }
        return ImageSourceKt.a(data, e2, str, snapshot, 16);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002b A[Catch:{ IOException -> 0x002d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[Catch:{ IOException -> 0x002d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil3.network.NetworkResponse i(coil3.disk.DiskCache.Snapshot r3) {
        /*
            r2 = this;
            r0 = 0
            okio.FileSystem r1 = r2.e()     // Catch:{ IOException -> 0x002d }
            okio.Path r3 = r3.getMetadata()     // Catch:{ IOException -> 0x002d }
            okio.Source r3 = r1.source(r3)     // Catch:{ IOException -> 0x002d }
            okio.BufferedSource r3 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ IOException -> 0x002d }
            coil3.network.NetworkResponse r1 = coil3.network.CacheNetworkResponse.a(r3)     // Catch:{ all -> 0x001c }
            r3.close()     // Catch:{ all -> 0x001a }
            r3 = r0
            goto L_0x0029
        L_0x001a:
            r3 = move-exception
            goto L_0x0029
        L_0x001c:
            r1 = move-exception
            if (r3 == 0) goto L_0x0027
            r3.close()     // Catch:{ all -> 0x0023 }
            goto L_0x0027
        L_0x0023:
            r3 = move-exception
            kotlin.ExceptionsKt.a(r1, r3)     // Catch:{ IOException -> 0x002d }
        L_0x0027:
            r3 = r1
            r1 = r0
        L_0x0029:
            if (r3 != 0) goto L_0x002c
            return r1
        L_0x002c:
            throw r3     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher.i(coil3.disk.DiskCache$Snapshot):coil3.network.NetworkResponse");
    }
}
