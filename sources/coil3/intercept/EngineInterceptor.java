package coil3.intercept;

import coil3.Image;
import coil3.RealImageLoader;
import coil3.decode.DataSource;
import coil3.memory.MemoryCacheService;
import coil3.request.AndroidRequestService;
import coil3.util.AndroidSystemCallbacks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/intercept/EngineInterceptor;", "Lcoil3/intercept/Interceptor;", "ExecuteResult", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEngineInterceptor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EngineInterceptor.kt\ncoil3/intercept/EngineInterceptor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n1#2:230\n*E\n"})
public final class EngineInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final RealImageLoader f107a;
    public final AndroidSystemCallbacks b;
    public final AndroidRequestService c;
    public final MemoryCacheService d;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/intercept/EngineInterceptor$Companion;", "", "", "TAG", "Ljava/lang/String;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/intercept/EngineInterceptor$ExecuteResult;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ExecuteResult {

        /* renamed from: a  reason: collision with root package name */
        public final Image f108a;
        public final boolean b;
        public final DataSource c;
        public final String d;

        public ExecuteResult(Image image, boolean z, DataSource dataSource, String str) {
            this.f108a = image;
            this.b = z;
            this.c = dataSource;
            this.d = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExecuteResult)) {
                return false;
            }
            ExecuteResult executeResult = (ExecuteResult) obj;
            return Intrinsics.a(this.f108a, executeResult.f108a) && this.b == executeResult.b && this.c == executeResult.c && Intrinsics.a(this.d, executeResult.d);
        }

        public final int hashCode() {
            int i;
            int i2;
            int hashCode = this.f108a.hashCode() * 31;
            if (this.b) {
                i = 1231;
            } else {
                i = 1237;
            }
            int hashCode2 = (this.c.hashCode() + ((hashCode + i) * 31)) * 31;
            String str = this.d;
            if (str == null) {
                i2 = 0;
            } else {
                i2 = str.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "ExecuteResult(image=" + this.f108a + ", isSampled=" + this.b + ", dataSource=" + this.c + ", diskCacheKey=" + this.d + ')';
        }
    }

    public EngineInterceptor(RealImageLoader realImageLoader, AndroidSystemCallbacks androidSystemCallbacks, AndroidRequestService androidRequestService) {
        this.f107a = realImageLoader;
        this.b = androidSystemCallbacks;
        this.c = androidRequestService;
        this.d = new MemoryCacheService(realImageLoader, androidRequestService);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(coil3.intercept.EngineInterceptor r17, coil3.fetch.SourceFetchResult r18, coil3.ComponentRegistry r19, coil3.request.ImageRequest r20, java.lang.Object r21, coil3.request.Options r22, coil3.EventListener r23, kotlin.coroutines.jvm.internal.ContinuationImpl r24) {
        /*
            r0 = r24
            r17.getClass()
            boolean r1 = r0 instanceof coil3.intercept.EngineInterceptor$decode$1
            if (r1 == 0) goto L_0x001a
            r1 = r0
            coil3.intercept.EngineInterceptor$decode$1 r1 = (coil3.intercept.EngineInterceptor$decode$1) r1
            int r2 = r1.o
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x001a
            int r2 = r2 - r3
            r1.o = r2
            r2 = r17
            goto L_0x0021
        L_0x001a:
            coil3.intercept.EngineInterceptor$decode$1 r1 = new coil3.intercept.EngineInterceptor$decode$1
            r2 = r17
            r1.<init>(r2, r0)
        L_0x0021:
            java.lang.Object r0 = r1.m
            kotlin.coroutines.intrinsics.CoroutineSingletons r3 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r4 = r1.o
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0057
            if (r4 != r5) goto L_0x004f
            int r2 = r1.l
            coil3.EventListener r4 = r1.j
            coil3.request.Options r7 = r1.i
            java.lang.Object r8 = r1.g
            coil3.request.ImageRequest r9 = r1.f
            coil3.ComponentRegistry r10 = r1.e
            coil3.fetch.SourceFetchResult r11 = r1.d
            coil3.intercept.EngineInterceptor r12 = r1.c
            kotlin.ResultKt.b(r0)
            r14 = r12
            r12 = r1
            r1 = r10
            r10 = r2
            r2 = r14
            r15 = r9
            r9 = r4
            r4 = r15
            r16 = r8
            r8 = r7
            r7 = r16
            goto L_0x00d1
        L_0x004f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0057:
            kotlin.ResultKt.b(r0)
            r0 = 0
            r0 = r18
            r4 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r11 = r1
            r10 = 0
            r1 = r19
        L_0x0069:
            coil3.RealImageLoader r12 = r2.f107a
            kotlin.Lazy r12 = r1.g
            java.lang.Object r12 = r12.getValue()
            java.util.List r12 = (java.util.List) r12
            int r12 = r12.size()
        L_0x0077:
            if (r10 >= r12) goto L_0x009a
            kotlin.Lazy r13 = r1.g
            java.lang.Object r13 = r13.getValue()
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r13 = r13.get(r10)
            coil3.decode.Decoder$Factory r13 = (coil3.decode.Decoder.Factory) r13
            coil3.decode.Decoder r13 = r13.a(r0, r8)
            if (r13 == 0) goto L_0x0097
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            kotlin.Pair r12 = new kotlin.Pair
            r12.<init>(r13, r10)
            goto L_0x009b
        L_0x0097:
            int r10 = r10 + 1
            goto L_0x0077
        L_0x009a:
            r12 = r6
        L_0x009b:
            if (r12 == 0) goto L_0x00f6
            java.lang.Object r10 = r12.getFirst()
            coil3.decode.Decoder r10 = (coil3.decode.Decoder) r10
            java.lang.Object r12 = r12.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            int r12 = r12 + r5
            r9.getClass()
            r11.c = r2
            r11.d = r0
            r11.e = r1
            r11.f = r4
            r11.g = r7
            r11.i = r8
            r11.j = r9
            r11.k = r10
            r11.l = r12
            r11.o = r5
            java.lang.Object r10 = r10.a(r11)
            if (r10 != r3) goto L_0x00cc
            goto L_0x00f1
        L_0x00cc:
            r14 = r11
            r11 = r0
            r0 = r10
            r10 = r12
            r12 = r14
        L_0x00d1:
            coil3.decode.DecodeResult r0 = (coil3.decode.DecodeResult) r0
            r9.getClass()
            if (r0 == 0) goto L_0x00f2
            coil3.intercept.EngineInterceptor$ExecuteResult r3 = new coil3.intercept.EngineInterceptor$ExecuteResult
            coil3.decode.DataSource r1 = r11.c
            coil3.decode.ImageSource r2 = r11.f96a
            boolean r4 = r2 instanceof coil3.decode.FileImageSource
            if (r4 == 0) goto L_0x00e5
            coil3.decode.FileImageSource r2 = (coil3.decode.FileImageSource) r2
            goto L_0x00e6
        L_0x00e5:
            r2 = r6
        L_0x00e6:
            if (r2 == 0) goto L_0x00ea
            java.lang.String r6 = r2.e
        L_0x00ea:
            coil3.Image r2 = r0.f71a
            boolean r0 = r0.b
            r3.<init>(r2, r0, r1, r6)
        L_0x00f1:
            return r3
        L_0x00f2:
            r0 = r11
            r11 = r12
            goto L_0x0069
        L_0x00f6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to create a decoder that supports: "
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.b(coil3.intercept.EngineInterceptor, coil3.fetch.SourceFetchResult, coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01a8, code lost:
        if (r1 == r11) goto L_0x01bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0118 A[Catch:{ all -> 0x0154 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0158 A[SYNTHETIC, Splitter:B:53:0x0158] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(coil3.intercept.EngineInterceptor r26, coil3.request.ImageRequest r27, java.lang.Object r28, coil3.request.Options r29, coil3.EventListener r30, kotlin.coroutines.jvm.internal.ContinuationImpl r31) {
        /*
            r0 = r26
            r8 = r27
            r1 = r31
            r9 = 2
            r26.getClass()
            boolean r2 = r1 instanceof coil3.intercept.EngineInterceptor$execute$1
            if (r2 == 0) goto L_0x001e
            r2 = r1
            coil3.intercept.EngineInterceptor$execute$1 r2 = (coil3.intercept.EngineInterceptor$execute$1) r2
            int r3 = r2.n
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001e
            int r3 = r3 - r4
            r2.n = r3
        L_0x001c:
            r10 = r2
            goto L_0x0024
        L_0x001e:
            coil3.intercept.EngineInterceptor$execute$1 r2 = new coil3.intercept.EngineInterceptor$execute$1
            r2.<init>(r0, r1)
            goto L_0x001c
        L_0x0024:
            java.lang.Object r1 = r10.l
            kotlin.coroutines.intrinsics.CoroutineSingletons r11 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r10.n
            r12 = 3
            r3 = 1
            r13 = 0
            if (r2 == 0) goto L_0x0078
            if (r2 == r3) goto L_0x0058
            if (r2 == r9) goto L_0x0042
            if (r2 != r12) goto L_0x003a
            kotlin.ResultKt.b(r1)
            goto L_0x01ab
        L_0x003a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0042:
            kotlin.jvm.internal.Ref$ObjectRef r2 = r10.g
            java.lang.Object r0 = r10.f
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r3 = r10.e
            coil3.EventListener r3 = (coil3.EventListener) r3
            coil3.request.ImageRequest r4 = r10.d
            coil3.intercept.EngineInterceptor r5 = r10.c
            kotlin.ResultKt.b(r1)     // Catch:{ all -> 0x0055 }
            goto L_0x014c
        L_0x0055:
            r0 = move-exception
            goto L_0x01cc
        L_0x0058:
            kotlin.jvm.internal.Ref$ObjectRef r0 = r10.k
            kotlin.jvm.internal.Ref$ObjectRef r2 = r10.j
            kotlin.jvm.internal.Ref$ObjectRef r3 = r10.i
            kotlin.jvm.internal.Ref$ObjectRef r4 = r10.g
            java.lang.Object r5 = r10.f
            coil3.EventListener r5 = (coil3.EventListener) r5
            java.lang.Object r6 = r10.e
            coil3.request.ImageRequest r7 = r10.d
            coil3.intercept.EngineInterceptor r8 = r10.c
            kotlin.ResultKt.b(r1)     // Catch:{ all -> 0x0055 }
            r20 = r3
            r14 = r4
            r22 = r6
            r3 = r2
            r2 = r1
            r1 = r0
            r0 = r8
            goto L_0x010d
        L_0x0078:
            kotlin.ResultKt.b(r1)
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            r1 = r29
            r14.element = r1
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            coil3.RealImageLoader r1 = r0.f107a
            coil3.ComponentRegistry r1 = r1.d
            r15.element = r1
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            coil3.request.AndroidRequestService r1 = r0.c     // Catch:{ all -> 0x01c8 }
            T r2 = r14.element     // Catch:{ all -> 0x01c8 }
            coil3.request.Options r2 = (coil3.request.Options) r2     // Catch:{ all -> 0x01c8 }
            coil3.request.Options r1 = r1.d(r2)     // Catch:{ all -> 0x01c8 }
            r14.element = r1     // Catch:{ all -> 0x01c8 }
            r27.getClass()     // Catch:{ all -> 0x01c8 }
            coil3.decode.Decoder$Factory r1 = r8.f
            if (r1 == 0) goto L_0x00cf
            T r2 = r15.element     // Catch:{ all -> 0x00cd }
            coil3.ComponentRegistry r2 = (coil3.ComponentRegistry) r2     // Catch:{ all -> 0x00cd }
            r2.getClass()     // Catch:{ all -> 0x00cd }
            coil3.ComponentRegistry$Builder r4 = new coil3.ComponentRegistry$Builder     // Catch:{ all -> 0x00cd }
            r4.<init>(r2)     // Catch:{ all -> 0x00cd }
            kotlin.jvm.functions.Function1 r2 = coil3.util.UtilsKt.f161a     // Catch:{ all -> 0x00cd }
            if (r1 == 0) goto L_0x00c6
            java.util.ArrayList r2 = r4.e     // Catch:{ all -> 0x00cd }
            v3 r5 = new v3     // Catch:{ all -> 0x00cd }
            r5.<init>(r1, r9)     // Catch:{ all -> 0x00cd }
            r1 = 0
            r2.add(r1, r5)     // Catch:{ all -> 0x00cd }
            goto L_0x00c6
        L_0x00c3:
            r2 = r7
            goto L_0x01cc
        L_0x00c6:
            coil3.ComponentRegistry r1 = r4.c()     // Catch:{ all -> 0x00cd }
            r15.element = r1     // Catch:{ all -> 0x00cd }
            goto L_0x00cf
        L_0x00cd:
            r0 = move-exception
            goto L_0x00c3
        L_0x00cf:
            T r1 = r15.element     // Catch:{ all -> 0x01c8 }
            r2 = r1
            coil3.ComponentRegistry r2 = (coil3.ComponentRegistry) r2     // Catch:{ all -> 0x01c8 }
            T r1 = r14.element     // Catch:{ all -> 0x01c8 }
            r5 = r1
            coil3.request.Options r5 = (coil3.request.Options) r5     // Catch:{ all -> 0x01c8 }
            r10.c = r0     // Catch:{ all -> 0x01c8 }
            r10.d = r8     // Catch:{ all -> 0x01c8 }
            r6 = r28
            r10.e = r6     // Catch:{ all -> 0x01c8 }
            r4 = r30
            r10.f = r4     // Catch:{ all -> 0x01c8 }
            r10.g = r14     // Catch:{ all -> 0x01c8 }
            r10.i = r15     // Catch:{ all -> 0x01c8 }
            r10.j = r7     // Catch:{ all -> 0x01c8 }
            r10.k = r7     // Catch:{ all -> 0x01c8 }
            r10.n = r3     // Catch:{ all -> 0x01c8 }
            r1 = r26
            r3 = r27
            r4 = r28
            r6 = r30
            r16 = r7
            r7 = r10
            java.lang.Object r1 = r1.d(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x01c4 }
            if (r1 != r11) goto L_0x0102
            goto L_0x01bd
        L_0x0102:
            r22 = r28
            r5 = r30
            r2 = r1
            r7 = r8
            r20 = r15
            r1 = r16
            r3 = r1
        L_0x010d:
            r1.element = r2     // Catch:{ all -> 0x0154 }
            T r1 = r3.element     // Catch:{ all -> 0x0154 }
            r2 = r1
            coil3.fetch.FetchResult r2 = (coil3.fetch.FetchResult) r2     // Catch:{ all -> 0x0154 }
            boolean r4 = r2 instanceof coil3.fetch.SourceFetchResult     // Catch:{ all -> 0x0154 }
            if (r4 == 0) goto L_0x0158
            kotlin.coroutines.CoroutineContext r1 = r7.i     // Catch:{ all -> 0x0154 }
            coil3.intercept.EngineInterceptor$execute$executeResult$1 r2 = new coil3.intercept.EngineInterceptor$execute$executeResult$1     // Catch:{ all -> 0x0154 }
            r25 = 0
            r17 = r2
            r18 = r0
            r19 = r3
            r21 = r7
            r23 = r14
            r24 = r5
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ all -> 0x0154 }
            r10.c = r0     // Catch:{ all -> 0x0154 }
            r10.d = r7     // Catch:{ all -> 0x0154 }
            r10.e = r5     // Catch:{ all -> 0x0154 }
            r10.f = r14     // Catch:{ all -> 0x0154 }
            r10.g = r3     // Catch:{ all -> 0x0154 }
            r10.i = r13     // Catch:{ all -> 0x0154 }
            r10.j = r13     // Catch:{ all -> 0x0154 }
            r10.k = r13     // Catch:{ all -> 0x0154 }
            r10.n = r9     // Catch:{ all -> 0x0154 }
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.d(r2, r1, r10)     // Catch:{ all -> 0x0154 }
            if (r1 != r11) goto L_0x0147
            goto L_0x01bd
        L_0x0147:
            r2 = r3
            r3 = r5
            r4 = r7
            r5 = r0
            r0 = r14
        L_0x014c:
            coil3.intercept.EngineInterceptor$ExecuteResult r1 = (coil3.intercept.EngineInterceptor.ExecuteResult) r1     // Catch:{ all -> 0x0055 }
            r14 = r0
            r7 = r4
            r0 = r5
            r5 = r3
            r3 = r2
            goto L_0x0170
        L_0x0154:
            r0 = move-exception
            r2 = r3
            goto L_0x01cc
        L_0x0158:
            boolean r2 = r2 instanceof coil3.fetch.ImageFetchResult     // Catch:{ all -> 0x0154 }
            if (r2 == 0) goto L_0x01be
            coil3.intercept.EngineInterceptor$ExecuteResult r2 = new coil3.intercept.EngineInterceptor$ExecuteResult     // Catch:{ all -> 0x0154 }
            r4 = r1
            coil3.fetch.ImageFetchResult r4 = (coil3.fetch.ImageFetchResult) r4     // Catch:{ all -> 0x0154 }
            coil3.Image r4 = r4.f93a     // Catch:{ all -> 0x0154 }
            r6 = r1
            coil3.fetch.ImageFetchResult r6 = (coil3.fetch.ImageFetchResult) r6     // Catch:{ all -> 0x0154 }
            boolean r6 = r6.b     // Catch:{ all -> 0x0154 }
            coil3.fetch.ImageFetchResult r1 = (coil3.fetch.ImageFetchResult) r1     // Catch:{ all -> 0x0154 }
            coil3.decode.DataSource r1 = r1.c     // Catch:{ all -> 0x0154 }
            r2.<init>(r4, r6, r1, r13)     // Catch:{ all -> 0x0154 }
            r1 = r2
        L_0x0170:
            T r2 = r3.element
            boolean r3 = r2 instanceof coil3.fetch.SourceFetchResult
            if (r3 == 0) goto L_0x0179
            coil3.fetch.SourceFetchResult r2 = (coil3.fetch.SourceFetchResult) r2
            goto L_0x017a
        L_0x0179:
            r2 = r13
        L_0x017a:
            if (r2 == 0) goto L_0x018b
            coil3.decode.ImageSource r2 = r2.f96a
            if (r2 == 0) goto L_0x018b
            kotlin.jvm.functions.Function1 r3 = coil3.util.UtilsKt.f161a
            r2.close()     // Catch:{ RuntimeException -> 0x0188, Exception -> 0x0186 }
            goto L_0x018b
        L_0x0186:
            goto L_0x018b
        L_0x0188:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x018b:
            T r2 = r14.element
            coil3.request.Options r2 = (coil3.request.Options) r2
            r0.getClass()
            r10.c = r13
            r10.d = r13
            r10.e = r13
            r10.f = r13
            r10.g = r13
            r10.i = r13
            r10.j = r13
            r10.k = r13
            r10.n = r12
            java.lang.Object r1 = coil3.intercept.EngineInterceptorKt.a(r1, r7, r2, r5, r10)
            if (r1 != r11) goto L_0x01ab
            goto L_0x01bd
        L_0x01ab:
            r11 = r1
            coil3.intercept.EngineInterceptor$ExecuteResult r11 = (coil3.intercept.EngineInterceptor.ExecuteResult) r11
            coil3.Image r0 = r11.f108a
            android.graphics.Bitmap$Config[] r1 = coil3.util.Utils_androidKt.f162a
            boolean r1 = r0 instanceof coil3.BitmapImage
            if (r1 == 0) goto L_0x01bd
            coil3.BitmapImage r0 = (coil3.BitmapImage) r0
            android.graphics.Bitmap r0 = r0.f47a
            r0.prepareToDraw()
        L_0x01bd:
            return r11
        L_0x01be:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0154 }
            r0.<init>()     // Catch:{ all -> 0x0154 }
            throw r0     // Catch:{ all -> 0x0154 }
        L_0x01c4:
            r0 = move-exception
        L_0x01c5:
            r2 = r16
            goto L_0x01cc
        L_0x01c8:
            r0 = move-exception
            r16 = r7
            goto L_0x01c5
        L_0x01cc:
            T r1 = r2.element
            boolean r2 = r1 instanceof coil3.fetch.SourceFetchResult
            if (r2 == 0) goto L_0x01d5
            r13 = r1
            coil3.fetch.SourceFetchResult r13 = (coil3.fetch.SourceFetchResult) r13
        L_0x01d5:
            if (r13 == 0) goto L_0x01e4
            coil3.decode.ImageSource r1 = r13.f96a
            if (r1 == 0) goto L_0x01e4
            kotlin.jvm.functions.Function1 r2 = coil3.util.UtilsKt.f161a
            r1.close()     // Catch:{ RuntimeException -> 0x01e1, Exception -> 0x01e4 }
            goto L_0x01e4
        L_0x01e1:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x01e4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.c(coil3.intercept.EngineInterceptor, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: coil3.Uri} */
    /* JADX WARNING: type inference failed for: r1v14, types: [coil3.intercept.Interceptor$Chain] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(coil3.intercept.RealInterceptorChain r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            r18 = this;
            r10 = r18
            r11 = r19
            r0 = r20
            r12 = 1
            coil3.memory.MemoryCacheService r1 = r10.d
            boolean r2 = r0 instanceof coil3.intercept.EngineInterceptor$intercept$1
            if (r2 == 0) goto L_0x001d
            r2 = r0
            coil3.intercept.EngineInterceptor$intercept$1 r2 = (coil3.intercept.EngineInterceptor$intercept$1) r2
            int r3 = r2.f
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x001d
            int r3 = r3 - r4
            r2.f = r3
        L_0x001b:
            r0 = r2
            goto L_0x0023
        L_0x001d:
            coil3.intercept.EngineInterceptor$intercept$1 r2 = new coil3.intercept.EngineInterceptor$intercept$1
            r2.<init>(r10, r0)
            goto L_0x001b
        L_0x0023:
            java.lang.Object r2 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r13 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r0.f
            if (r3 == 0) goto L_0x0040
            if (r3 != r12) goto L_0x0038
            coil3.intercept.Interceptor$Chain r1 = r0.c
            kotlin.ResultKt.b(r2)     // Catch:{ all -> 0x0034 }
            goto L_0x00f3
        L_0x0034:
            r0 = move-exception
            r11 = r1
            goto L_0x00f4
        L_0x0038:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0040:
            kotlin.ResultKt.b(r2)
            coil3.request.ImageRequest r4 = r11.d     // Catch:{ all -> 0x009d }
            java.lang.Object r2 = r4.b     // Catch:{ all -> 0x009d }
            coil3.size.Size r3 = r11.e     // Catch:{ all -> 0x009d }
            kotlin.jvm.functions.Function1 r5 = coil3.util.UtilsKt.f161a     // Catch:{ all -> 0x009d }
            coil3.EventListener r6 = r11.f     // Catch:{ all -> 0x009d }
            coil3.request.AndroidRequestService r5 = r10.c     // Catch:{ all -> 0x009d }
            coil3.request.Options r5 = r5.c(r4, r3)     // Catch:{ all -> 0x009d }
            coil3.size.Scale r7 = r5.c     // Catch:{ all -> 0x009d }
            coil3.RealImageLoader r8 = r10.f107a     // Catch:{ all -> 0x009d }
            coil3.ComponentRegistry r8 = r8.d     // Catch:{ all -> 0x009d }
            java.util.List r8 = r8.b     // Catch:{ all -> 0x009d }
            r9 = r8
            java.util.Collection r9 = (java.util.Collection) r9     // Catch:{ all -> 0x009d }
            int r9 = r9.size()     // Catch:{ all -> 0x009d }
            r15 = r2
            r2 = 0
        L_0x0064:
            if (r2 >= r9) goto L_0x0091
            java.lang.Object r16 = r8.get(r2)     // Catch:{ all -> 0x009d }
            kotlin.Pair r16 = (kotlin.Pair) r16     // Catch:{ all -> 0x009d }
            java.lang.Object r17 = r16.component1()     // Catch:{ all -> 0x009d }
            r14 = r17
            coil3.map.Mapper r14 = (coil3.map.Mapper) r14     // Catch:{ all -> 0x009d }
            java.lang.Object r16 = r16.component2()     // Catch:{ all -> 0x009d }
            r12 = r16
            kotlin.reflect.KClass r12 = (kotlin.reflect.KClass) r12     // Catch:{ all -> 0x009d }
            boolean r12 = r12.d(r15)     // Catch:{ all -> 0x009d }
            if (r12 == 0) goto L_0x008e
            java.lang.String r12 = "null cannot be cast to non-null type coil3.map.Mapper<kotlin.Any, *>"
            kotlin.jvm.internal.Intrinsics.d(r14, r12)     // Catch:{ all -> 0x009d }
            coil3.Uri r12 = r14.a(r15, r5)     // Catch:{ all -> 0x009d }
            if (r12 == 0) goto L_0x008e
            r15 = r12
        L_0x008e:
            r12 = 1
            int r2 = r2 + r12
            goto L_0x0064
        L_0x0091:
            coil3.memory.MemoryCache$Key r8 = r1.b(r4, r15, r5, r6)     // Catch:{ all -> 0x009d }
            r2 = 0
            if (r8 == 0) goto L_0x009f
            coil3.memory.MemoryCache$Value r1 = r1.a(r4, r8, r3, r7)     // Catch:{ all -> 0x009d }
            goto L_0x00a0
        L_0x009d:
            r0 = move-exception
            goto L_0x00f4
        L_0x009f:
            r1 = r2
        L_0x00a0:
            if (r1 == 0) goto L_0x00d7
            java.util.Map r0 = r1.b
            coil3.request.SuccessResult r12 = new coil3.request.SuccessResult     // Catch:{ all -> 0x009d }
            coil3.Image r3 = r1.f113a     // Catch:{ all -> 0x009d }
            coil3.decode.DataSource r5 = coil3.decode.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x009d }
            java.lang.String r1 = "coil#disk_cache_key"
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x009d }
            boolean r6 = r1 instanceof java.lang.String     // Catch:{ all -> 0x009d }
            if (r6 == 0) goto L_0x00b8
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x009d }
            r7 = r1
            goto L_0x00b9
        L_0x00b8:
            r7 = r2
        L_0x00b9:
            java.lang.String r1 = "coil#is_sampled"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x009d }
            boolean r1 = r0 instanceof java.lang.Boolean     // Catch:{ all -> 0x009d }
            if (r1 == 0) goto L_0x00c6
            r2 = r0
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x009d }
        L_0x00c6:
            if (r2 == 0) goto L_0x00cd
            boolean r0 = r2.booleanValue()     // Catch:{ all -> 0x009d }
            goto L_0x00ce
        L_0x00cd:
            r0 = 0
        L_0x00ce:
            boolean r9 = r11.g     // Catch:{ all -> 0x009d }
            r2 = r12
            r6 = r8
            r8 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x009d }
            return r12
        L_0x00d7:
            kotlin.coroutines.CoroutineContext r12 = r4.h     // Catch:{ all -> 0x009d }
            coil3.intercept.EngineInterceptor$intercept$2 r14 = new coil3.intercept.EngineInterceptor$intercept$2     // Catch:{ all -> 0x009d }
            r9 = 0
            r1 = r14
            r2 = r18
            r3 = r4
            r4 = r15
            r7 = r8
            r8 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x009d }
            r0.c = r11     // Catch:{ all -> 0x009d }
            r1 = 1
            r0.f = r1     // Catch:{ all -> 0x009d }
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.d(r14, r12, r0)     // Catch:{ all -> 0x009d }
            if (r2 != r13) goto L_0x00f3
            return r13
        L_0x00f3:
            return r2
        L_0x00f4:
            boolean r1 = r0 instanceof java.util.concurrent.CancellationException
            if (r1 != 0) goto L_0x0101
            coil3.request.ImageRequest r1 = r11.a()
            coil3.request.ErrorResult r0 = coil3.util.UtilsKt.a(r1, r0)
            return r0
        L_0x0101:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.a(coil3.intercept.RealInterceptorChain, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [coil3.fetch.FetchResult, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ac A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(coil3.ComponentRegistry r20, coil3.request.ImageRequest r21, java.lang.Object r22, coil3.request.Options r23, coil3.EventListener r24, kotlin.coroutines.jvm.internal.ContinuationImpl r25) {
        /*
            r19 = this;
            r0 = r25
            r1 = 1
            boolean r2 = r0 instanceof coil3.intercept.EngineInterceptor$fetch$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            coil3.intercept.EngineInterceptor$fetch$1 r2 = (coil3.intercept.EngineInterceptor$fetch$1) r2
            int r3 = r2.n
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0018
            int r3 = r3 - r4
            r2.n = r3
            r3 = r19
            goto L_0x001f
        L_0x0018:
            coil3.intercept.EngineInterceptor$fetch$1 r2 = new coil3.intercept.EngineInterceptor$fetch$1
            r3 = r19
            r2.<init>(r3, r0)
        L_0x001f:
            java.lang.Object r0 = r2.l
            kotlin.coroutines.intrinsics.CoroutineSingletons r4 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r5 = r2.n
            r6 = 0
            if (r5 == 0) goto L_0x0054
            if (r5 != r1) goto L_0x004c
            int r5 = r2.k
            coil3.EventListener r7 = r2.i
            coil3.request.Options r8 = r2.g
            java.lang.Object r9 = r2.f
            coil3.request.ImageRequest r10 = r2.e
            coil3.ComponentRegistry r11 = r2.d
            coil3.intercept.EngineInterceptor r12 = r2.c
            kotlin.ResultKt.b(r0)
            r16 = r10
            r10 = r2
            r2 = r16
            r17 = r9
            r9 = r5
            r5 = r17
            r18 = r8
            r8 = r7
            r7 = r18
            goto L_0x00e2
        L_0x004c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0054:
            kotlin.ResultKt.b(r0)
            r0 = 0
            r0 = r20
            r5 = r22
            r7 = r23
            r8 = r24
            r10 = r2
            r12 = r3
            r9 = 0
            r2 = r21
        L_0x0065:
            coil3.RealImageLoader r11 = r12.f107a
            kotlin.Lazy r13 = r0.f
            java.lang.Object r13 = r13.getValue()
            java.util.List r13 = (java.util.List) r13
            int r13 = r13.size()
        L_0x0073:
            if (r9 >= r13) goto L_0x00ac
            kotlin.Lazy r14 = r0.f
            java.lang.Object r14 = r14.getValue()
            java.util.List r14 = (java.util.List) r14
            java.lang.Object r14 = r14.get(r9)
            kotlin.Pair r14 = (kotlin.Pair) r14
            java.lang.Object r15 = r14.component1()
            coil3.fetch.Fetcher$Factory r15 = (coil3.fetch.Fetcher.Factory) r15
            java.lang.Object r14 = r14.component2()
            kotlin.reflect.KClass r14 = (kotlin.reflect.KClass) r14
            boolean r14 = r14.d(r5)
            if (r14 == 0) goto L_0x00aa
            java.lang.String r14 = "null cannot be cast to non-null type coil3.fetch.Fetcher.Factory<kotlin.Any>"
            kotlin.jvm.internal.Intrinsics.d(r15, r14)
            coil3.fetch.Fetcher r14 = r15.a(r5, r7, r11)
            if (r14 == 0) goto L_0x00aa
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            kotlin.Pair r11 = new kotlin.Pair
            r11.<init>(r14, r9)
            goto L_0x00ad
        L_0x00aa:
            int r9 = r9 + r1
            goto L_0x0073
        L_0x00ac:
            r11 = r6
        L_0x00ad:
            if (r11 == 0) goto L_0x0107
            java.lang.Object r9 = r11.getFirst()
            coil3.fetch.Fetcher r9 = (coil3.fetch.Fetcher) r9
            java.lang.Object r11 = r11.getSecond()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            int r11 = r11 + r1
            r8.getClass()
            r10.c = r12
            r10.d = r0
            r10.e = r2
            r10.f = r5
            r10.g = r7
            r10.i = r8
            r10.j = r9
            r10.k = r11
            r10.n = r1
            java.lang.Object r9 = r9.a(r10)
            if (r9 != r4) goto L_0x00dc
            return r4
        L_0x00dc:
            r16 = r11
            r11 = r0
            r0 = r9
            r9 = r16
        L_0x00e2:
            r13 = r0
            coil3.fetch.FetchResult r13 = (coil3.fetch.FetchResult) r13
            r8.getClass()     // Catch:{ all -> 0x00ee }
            if (r13 == 0) goto L_0x00eb
            return r13
        L_0x00eb:
            r0 = r11
            goto L_0x0065
        L_0x00ee:
            r0 = move-exception
            r1 = r0
            boolean r0 = r13 instanceof coil3.fetch.SourceFetchResult
            if (r0 == 0) goto L_0x00f7
            r6 = r13
            coil3.fetch.SourceFetchResult r6 = (coil3.fetch.SourceFetchResult) r6
        L_0x00f7:
            if (r6 == 0) goto L_0x0106
            coil3.decode.ImageSource r0 = r6.f96a
            if (r0 == 0) goto L_0x0106
            kotlin.jvm.functions.Function1 r2 = coil3.util.UtilsKt.f161a
            r0.close()     // Catch:{ RuntimeException -> 0x0103, Exception -> 0x0106 }
            goto L_0x0106
        L_0x0103:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x0106:
            throw r1
        L_0x0107:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to create a fetcher that supports: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.intercept.EngineInterceptor.d(coil3.ComponentRegistry, coil3.request.ImageRequest, java.lang.Object, coil3.request.Options, coil3.EventListener, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
