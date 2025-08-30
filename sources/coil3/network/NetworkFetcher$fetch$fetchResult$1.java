package coil3.network;

import coil3.fetch.SourceFetchResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcoil3/fetch/SourceFetchResult;", "response", "Lcoil3/network/NetworkResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.NetworkFetcher$fetch$fetchResult$1", f = "NetworkFetcher.kt", i = {0, 1}, l = {76, 87}, m = "invokeSuspend", n = {"response", "response"}, s = {"L$0", "L$0"})
final class NetworkFetcher$fetch$fetchResult$1 extends SuspendLambda implements Function2<NetworkResponse, Continuation<? super SourceFetchResult>, Object> {
    public Ref.ObjectRef c;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ Ref.ObjectRef f;
    public final /* synthetic */ NetworkFetcher g;
    public final /* synthetic */ Ref.ObjectRef i;
    public final /* synthetic */ NetworkRequest j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NetworkFetcher$fetch$fetchResult$1(Ref.ObjectRef objectRef, NetworkFetcher networkFetcher, Ref.ObjectRef objectRef2, NetworkRequest networkRequest, Continuation continuation) {
        super(2, continuation);
        this.f = objectRef;
        this.g = networkFetcher;
        this.i = objectRef2;
        this.j = networkRequest;
    }

    public final Continuation create(Object obj, Continuation continuation) {
        NetworkFetcher$fetch$fetchResult$1 networkFetcher$fetch$fetchResult$1 = new NetworkFetcher$fetch$fetchResult$1(this.f, this.g, this.i, this.j, continuation);
        networkFetcher$fetch$fetchResult$1.e = obj;
        return networkFetcher$fetch$fetchResult$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((NetworkFetcher$fetch$fetchResult$1) create((NetworkResponse) obj, (Continuation) obj2)).invokeSuspend(Unit.f696a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(T r15) {
        /*
            r14 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r14.d
            r2 = 0
            r3 = 2
            r4 = 1
            kotlin.jvm.internal.Ref$ObjectRef r5 = r14.i
            kotlin.jvm.internal.Ref$ObjectRef r6 = r14.f
            coil3.network.NetworkFetcher r7 = r14.g
            if (r1 == 0) goto L_0x002e
            if (r1 == r4) goto L_0x0024
            if (r1 != r3) goto L_0x001c
            java.lang.Object r0 = r14.e
            coil3.network.NetworkResponse r0 = (coil3.network.NetworkResponse) r0
            kotlin.ResultKt.b(r15)
            goto L_0x009c
        L_0x001c:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0024:
            kotlin.jvm.internal.Ref$ObjectRef r1 = r14.c
            java.lang.Object r4 = r14.e
            coil3.network.NetworkResponse r4 = (coil3.network.NetworkResponse) r4
            kotlin.ResultKt.b(r15)
            goto L_0x0055
        L_0x002e:
            kotlin.ResultKt.b(r15)
            java.lang.Object r15 = r14.e
            coil3.network.NetworkResponse r15 = (coil3.network.NetworkResponse) r15
            T r1 = r6.element
            r9 = r1
            coil3.disk.DiskCache$Snapshot r9 = (coil3.disk.DiskCache.Snapshot) r9
            T r1 = r5.element
            r10 = r1
            coil3.network.NetworkResponse r10 = (coil3.network.NetworkResponse) r10
            r14.e = r15
            r14.c = r6
            r14.d = r4
            coil3.network.NetworkRequest r11 = r14.j
            coil3.network.NetworkFetcher r8 = r14.g
            r12 = r15
            r13 = r14
            java.lang.Object r1 = coil3.network.NetworkFetcher.c(r8, r9, r10, r11, r12, r13)
            if (r1 != r0) goto L_0x0052
            return r0
        L_0x0052:
            r4 = r15
            r15 = r1
            r1 = r6
        L_0x0055:
            r1.element = r15
            T r15 = r6.element
            if (r15 == 0) goto L_0x008a
            coil3.disk.DiskCache$Snapshot r15 = (coil3.disk.DiskCache.Snapshot) r15
            coil3.network.NetworkResponse r15 = r7.i(r15)
            r5.element = r15
            coil3.fetch.SourceFetchResult r15 = new coil3.fetch.SourceFetchResult
            T r0 = r6.element
            kotlin.jvm.internal.Intrinsics.c(r0)
            coil3.disk.DiskCache$Snapshot r0 = (coil3.disk.DiskCache.Snapshot) r0
            coil3.decode.FileImageSource r0 = r7.h(r0)
            T r1 = r5.element
            coil3.network.NetworkResponse r1 = (coil3.network.NetworkResponse) r1
            if (r1 == 0) goto L_0x007e
            coil3.network.NetworkHeaders r1 = r1.d
            if (r1 == 0) goto L_0x007e
            java.lang.String r2 = r1.a()
        L_0x007e:
            java.lang.String r1 = r7.f126a
            java.lang.String r1 = coil3.network.NetworkFetcher.f(r1, r2)
            coil3.decode.DataSource r2 = coil3.decode.DataSource.NETWORK
            r15.<init>(r0, r1, r2)
            return r15
        L_0x008a:
            coil3.network.NetworkResponseBody r15 = r4.e
            if (r15 == 0) goto L_0x00c6
            r14.e = r4
            r14.c = r2
            r14.d = r3
            java.lang.Object r15 = coil3.network.internal.UtilsKt.a(r15, r14)
            if (r15 != r0) goto L_0x009b
            return r0
        L_0x009b:
            r0 = r4
        L_0x009c:
            okio.Buffer r15 = (okio.Buffer) r15
            long r3 = r15.size()
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c5
            coil3.fetch.SourceFetchResult r1 = new coil3.fetch.SourceFetchResult
            okio.FileSystem r3 = r7.e()
            coil3.decode.SourceImageSource r4 = new coil3.decode.SourceImageSource
            r4.<init>(r15, r3, r2)
            coil3.network.NetworkHeaders r15 = r0.d
            java.lang.String r15 = r15.a()
            java.lang.String r0 = r7.f126a
            java.lang.String r15 = coil3.network.NetworkFetcher.f(r0, r15)
            coil3.decode.DataSource r0 = coil3.decode.DataSource.NETWORK
            r1.<init>(r4, r15, r0)
            return r1
        L_0x00c5:
            return r2
        L_0x00c6:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "body == null"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.NetworkFetcher$fetch$fetchResult$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
