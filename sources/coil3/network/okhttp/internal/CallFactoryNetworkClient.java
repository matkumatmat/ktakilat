package coil3.network.okhttp.internal;

import coil3.network.NetworkClient;
import coil3.network.NetworkRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b@\u0018\u00002\u00020\u0001\u0001\u0002\u0001\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/network/okhttp/internal/CallFactoryNetworkClient;", "Lcoil3/network/NetworkClient;", "callFactory", "Lokhttp3/Call$Factory;", "coil-network-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class CallFactoryNetworkClient implements NetworkClient {

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f134a;

    public /* synthetic */ CallFactoryNetworkClient(OkHttpClient okHttpClient) {
        this.f134a = okHttpClient;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: kotlin.jvm.functions.Function2} */
    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object b(okhttp3.OkHttpClient r8, coil3.network.NetworkRequest r9, kotlin.jvm.functions.Function2 r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            boolean r0 = r11 instanceof coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1 r0 = (coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1 r0 = new coil3.network.okhttp.internal.CallFactoryNetworkClient$executeRequest$1
            r0.<init>(r11)
        L_0x0018:
            java.lang.Object r11 = r0.e
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.f
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0051
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r8 = r0.c
            java.io.Closeable r8 = (java.io.Closeable) r8
            kotlin.ResultKt.b(r11)     // Catch:{ all -> 0x0033 }
            goto L_0x00a9
        L_0x0033:
            r9 = move-exception
            goto L_0x00b1
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            java.lang.Object r8 = r0.c
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.b(r11)
            goto L_0x0093
        L_0x0046:
            okhttp3.Call$Factory r8 = r0.d
            java.lang.Object r9 = r0.c
            r10 = r9
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.b(r11)
            goto L_0x0061
        L_0x0051:
            kotlin.ResultKt.b(r11)
            r0.c = r10
            r0.d = r8
            r0.f = r5
            java.lang.Object r11 = coil3.network.okhttp.internal.UtilsKt.b(r9, r0)
            if (r11 != r1) goto L_0x0061
            return r1
        L_0x0061:
            okhttp3.Request r11 = (okhttp3.Request) r11
            okhttp3.Call r8 = r8.newCall(r11)
            r0.c = r10
            r0.d = r6
            r0.f = r4
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)
            r9.<init>(r5, r11)
            r9.q()
            coil3.network.okhttp.internal.ContinuationCallback r11 = new coil3.network.okhttp.internal.ContinuationCallback
            r11.<init>(r8, r9)
            com.google.firebase.perf.network.FirebasePerfOkHttpClient.enqueue(r8, r11)
            r9.s(r11)
            java.lang.Object r11 = r9.p()
            if (r11 != r1) goto L_0x008f
            java.lang.String r8 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r8)
        L_0x008f:
            if (r11 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r8 = r10
        L_0x0093:
            r9 = r11
            java.io.Closeable r9 = (java.io.Closeable) r9
            r10 = r9
            okhttp3.Response r10 = (okhttp3.Response) r10     // Catch:{ all -> 0x00ad }
            coil3.network.NetworkResponse r10 = coil3.network.okhttp.internal.UtilsKt.a(r10)     // Catch:{ all -> 0x00ad }
            r0.c = r9     // Catch:{ all -> 0x00ad }
            r0.f = r3     // Catch:{ all -> 0x00ad }
            java.lang.Object r11 = r8.invoke(r10, r0)     // Catch:{ all -> 0x00ad }
            if (r11 != r1) goto L_0x00a8
            return r1
        L_0x00a8:
            r8 = r9
        L_0x00a9:
            kotlin.io.CloseableKt.a(r8, r6)
            return r11
        L_0x00ad:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x00b1:
            throw r9     // Catch:{ all -> 0x00b2 }
        L_0x00b2:
            r10 = move-exception
            kotlin.io.CloseableKt.a(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.CallFactoryNetworkClient.b(okhttp3.OkHttpClient, coil3.network.NetworkRequest, kotlin.jvm.functions.Function2, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final Object a(NetworkRequest networkRequest, Function2 function2, Continuation continuation) {
        return b(this.f134a, networkRequest, function2, (ContinuationImpl) continuation);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CallFactoryNetworkClient)) {
            return false;
        }
        if (!this.f134a.equals(((CallFactoryNetworkClient) obj).f134a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f134a.hashCode();
    }

    public final String toString() {
        return "CallFactoryNetworkClient(callFactory=" + this.f134a + ')';
    }
}
