package coil3.network.okhttp.internal;

import coil3.network.NetworkClientKt;
import coil3.network.NetworkHeaders;
import coil3.network.NetworkResponse;
import coil3.network.NetworkResponseBody;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-network-okhttp"}, k = 2, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nutils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 utils.kt\ncoil3/network/okhttp/internal/UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
public final class UtilsKt {
    public static final NetworkResponse a(Response response) {
        NetworkResponseBody networkResponseBody;
        BufferedSource source;
        int code = response.code();
        long sentRequestAtMillis = response.sentRequestAtMillis();
        long receivedResponseAtMillis = response.receivedResponseAtMillis();
        Headers headers = response.headers();
        NetworkHeaders.Builder builder = new NetworkHeaders.Builder();
        Iterator<Pair<String, String>> it = headers.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            builder.a((String) next.component1(), (String) next.component2());
        }
        NetworkHeaders b = builder.b();
        ResponseBody body = response.body();
        if (body == null || (source = body.source()) == null) {
            networkResponseBody = null;
        } else {
            networkResponseBody = NetworkClientKt.a(source);
        }
        return new NetworkResponse(code, sentRequestAtMillis, receivedResponseAtMillis, b, networkResponseBody, response);
    }

    /* JADX WARNING: type inference failed for: r0v17, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(coil3.network.NetworkRequest r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            boolean r0 = r8 instanceof coil3.network.okhttp.internal.UtilsKt$toRequest$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            coil3.network.okhttp.internal.UtilsKt$toRequest$1 r0 = (coil3.network.okhttp.internal.UtilsKt$toRequest$1) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.i = r1
            goto L_0x0018
        L_0x0013:
            coil3.network.okhttp.internal.UtilsKt$toRequest$1 r0 = new coil3.network.okhttp.internal.UtilsKt$toRequest$1
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.g
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.i
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.String r7 = r0.f
            okhttp3.Request$Builder r1 = r0.e
            okhttp3.Request$Builder r2 = r0.d
            coil3.network.NetworkRequest r0 = r0.c
            kotlin.ResultKt.b(r8)
            goto L_0x0062
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            kotlin.ResultKt.b(r8)
            okhttp3.Request$Builder r8 = new okhttp3.Request$Builder
            r8.<init>()
            java.lang.String r2 = r7.f130a
            r8.url((java.lang.String) r2)
            java.lang.String r2 = r7.b
            coil3.network.NetworkRequestBody r5 = r7.d
            if (r5 == 0) goto L_0x0072
            r0.c = r7
            r0.d = r8
            r0.e = r8
            r0.f = r2
            r0.i = r4
            java.lang.Object r0 = c(r5, r0)
            if (r0 != r1) goto L_0x005d
            goto L_0x00c3
        L_0x005d:
            r1 = r8
            r8 = r0
            r0 = r7
            r7 = r2
            r2 = r1
        L_0x0062:
            okio.ByteString r8 = (okio.ByteString) r8
            if (r8 == 0) goto L_0x006d
            okhttp3.RequestBody$Companion r5 = okhttp3.RequestBody.Companion
            okhttp3.RequestBody r3 = okhttp3.RequestBody.Companion.create$default((okhttp3.RequestBody.Companion) r5, (okio.ByteString) r8, (okhttp3.MediaType) r3, (int) r4, (java.lang.Object) r3)
            goto L_0x0078
        L_0x006d:
            r8 = r1
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x0074
        L_0x0072:
            r0 = r2
            r2 = r8
        L_0x0074:
            r1 = r8
            r6 = r0
            r0 = r7
            r7 = r6
        L_0x0078:
            r1.method(r7, r3)
            coil3.network.NetworkHeaders r7 = r0.c
            okhttp3.Headers$Builder r8 = new okhttp3.Headers$Builder
            r8.<init>()
            java.util.Map r7 = r7.f128a
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L_0x008c:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x00b8
            java.lang.Object r0 = r7.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00a8:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x008c
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            r8.addUnsafeNonAscii(r1, r3)
            goto L_0x00a8
        L_0x00b8:
            okhttp3.Headers r7 = r8.build()
            r2.headers(r7)
            okhttp3.Request r1 = r2.build()
        L_0x00c3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.UtilsKt.b(coil3.network.NetworkRequest, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [kotlin.coroutines.jvm.internal.ContinuationImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(coil3.network.NetworkRequestBody r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            boolean r0 = r5 instanceof coil3.network.okhttp.internal.UtilsKt$readByteString$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            coil3.network.okhttp.internal.UtilsKt$readByteString$1 r0 = (coil3.network.okhttp.internal.UtilsKt$readByteString$1) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            coil3.network.okhttp.internal.UtilsKt$readByteString$1 r0 = new coil3.network.okhttp.internal.UtilsKt$readByteString$1
            r0.<init>(r5)
        L_0x0018:
            java.lang.Object r5 = r0.d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            okio.Buffer r4 = r0.c
            kotlin.ResultKt.b(r5)
            goto L_0x0045
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.b(r5)
            okio.Buffer r5 = new okio.Buffer
            r5.<init>()
            r0.c = r5
            r0.e = r3
            kotlin.Unit r4 = r4.a(r5)
            if (r4 != r1) goto L_0x0044
            return r1
        L_0x0044:
            r4 = r5
        L_0x0045:
            okio.ByteString r4 = r4.readByteString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.okhttp.internal.UtilsKt.c(coil3.network.NetworkRequestBody, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
