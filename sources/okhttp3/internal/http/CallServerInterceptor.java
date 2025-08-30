package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Interceptor;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", "code", "", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i) {
        if (i == 100) {
            return true;
        }
        return 102 <= i && i < 200;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0098, code lost:
        if (r4.isDuplex() == false) goto L_0x009a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab A[SYNTHETIC, Splitter:B:41:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00e6 A[Catch:{ IOException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0121 A[Catch:{ IOException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0130 A[Catch:{ IOException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x016a A[Catch:{ IOException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x016f A[Catch:{ IOException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0177 A[Catch:{ IOException -> 0x00b9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a8  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "close"
            java.lang.String r2 = "HTTP "
            java.lang.String r3 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r3)
            okhttp3.internal.http.RealInterceptorChain r14 = (okhttp3.internal.http.RealInterceptorChain) r14
            okhttp3.internal.connection.Exchange r3 = r14.getExchange$okhttp()
            kotlin.jvm.internal.Intrinsics.c(r3)
            okhttp3.Request r14 = r14.getRequest$okhttp()
            okhttp3.RequestBody r4 = r14.body()
            long r5 = java.lang.System.currentTimeMillis()
            r7 = 0
            r8 = 1
            r9 = 0
            r3.writeRequestHeaders(r14)     // Catch:{ IOException -> 0x004e }
            java.lang.String r10 = r14.method()     // Catch:{ IOException -> 0x004e }
            boolean r10 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r10)     // Catch:{ IOException -> 0x004e }
            if (r10 == 0) goto L_0x008e
            if (r4 == 0) goto L_0x008e
            java.lang.String r10 = "100-continue"
            java.lang.String r11 = "Expect"
            java.lang.String r11 = r14.header(r11)     // Catch:{ IOException -> 0x004e }
            boolean r10 = r10.equalsIgnoreCase(r11)     // Catch:{ IOException -> 0x004e }
            if (r10 == 0) goto L_0x0051
            r3.flushRequest()     // Catch:{ IOException -> 0x004e }
            okhttp3.Response$Builder r10 = r3.readResponseHeaders(r8)     // Catch:{ IOException -> 0x004e }
            r3.responseHeadersStart()     // Catch:{ IOException -> 0x004c }
            r11 = 0
            goto L_0x0053
        L_0x004c:
            r4 = move-exception
            goto L_0x009f
        L_0x004e:
            r4 = move-exception
            r10 = r9
            goto L_0x009f
        L_0x0051:
            r10 = r9
            r11 = 1
        L_0x0053:
            if (r10 != 0) goto L_0x007c
            boolean r12 = r4.isDuplex()     // Catch:{ IOException -> 0x006a }
            if (r12 == 0) goto L_0x006d
            r3.flushRequest()     // Catch:{ IOException -> 0x006a }
            okio.Sink r8 = r3.createRequestBody(r14, r8)     // Catch:{ IOException -> 0x006a }
            okio.BufferedSink r8 = okio.Okio.buffer((okio.Sink) r8)     // Catch:{ IOException -> 0x006a }
            r4.writeTo(r8)     // Catch:{ IOException -> 0x006a }
            goto L_0x008c
        L_0x006a:
            r4 = move-exception
            r8 = r11
            goto L_0x009f
        L_0x006d:
            okio.Sink r8 = r3.createRequestBody(r14, r7)     // Catch:{ IOException -> 0x006a }
            okio.BufferedSink r8 = okio.Okio.buffer((okio.Sink) r8)     // Catch:{ IOException -> 0x006a }
            r4.writeTo(r8)     // Catch:{ IOException -> 0x006a }
            r8.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x008c
        L_0x007c:
            r3.noRequestBody()     // Catch:{ IOException -> 0x006a }
            okhttp3.internal.connection.RealConnection r8 = r3.getConnection$okhttp()     // Catch:{ IOException -> 0x006a }
            boolean r8 = r8.isMultiplexed$okhttp()     // Catch:{ IOException -> 0x006a }
            if (r8 != 0) goto L_0x008c
            r3.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x006a }
        L_0x008c:
            r8 = r11
            goto L_0x0092
        L_0x008e:
            r3.noRequestBody()     // Catch:{ IOException -> 0x004e }
            r10 = r9
        L_0x0092:
            if (r4 == 0) goto L_0x009a
            boolean r4 = r4.isDuplex()     // Catch:{ IOException -> 0x004c }
            if (r4 != 0) goto L_0x009d
        L_0x009a:
            r3.finishRequest()     // Catch:{ IOException -> 0x004c }
        L_0x009d:
            r4 = r9
            goto L_0x00a9
        L_0x009f:
            boolean r11 = r4 instanceof okhttp3.internal.http2.ConnectionShutdownException
            if (r11 != 0) goto L_0x01a8
            boolean r11 = r3.getHasFailure$okhttp()
            if (r11 == 0) goto L_0x01a7
        L_0x00a9:
            if (r10 != 0) goto L_0x00bc
            okhttp3.Response$Builder r10 = r3.readResponseHeaders(r7)     // Catch:{ IOException -> 0x00b9 }
            kotlin.jvm.internal.Intrinsics.c(r10)     // Catch:{ IOException -> 0x00b9 }
            if (r8 == 0) goto L_0x00bc
            r3.responseHeadersStart()     // Catch:{ IOException -> 0x00b9 }
            r8 = 0
            goto L_0x00bc
        L_0x00b9:
            r14 = move-exception
            goto L_0x01a0
        L_0x00bc:
            okhttp3.Response$Builder r10 = r10.request(r14)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.internal.connection.RealConnection r11 = r3.getConnection$okhttp()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Handshake r11 = r11.handshake()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r10 = r10.handshake(r11)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r10 = r10.sentRequestAtMillis(r5)     // Catch:{ IOException -> 0x00b9 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r10 = r10.receivedResponseAtMillis(r11)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response r10 = r10.build()     // Catch:{ IOException -> 0x00b9 }
            int r11 = r10.code()     // Catch:{ IOException -> 0x00b9 }
            boolean r12 = r13.shouldIgnoreAndWaitForRealResponse(r11)     // Catch:{ IOException -> 0x00b9 }
            if (r12 == 0) goto L_0x0116
            okhttp3.Response$Builder r7 = r3.readResponseHeaders(r7)     // Catch:{ IOException -> 0x00b9 }
            kotlin.jvm.internal.Intrinsics.c(r7)     // Catch:{ IOException -> 0x00b9 }
            if (r8 == 0) goto L_0x00f2
            r3.responseHeadersStart()     // Catch:{ IOException -> 0x00b9 }
        L_0x00f2:
            okhttp3.Response$Builder r14 = r7.request(r14)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.internal.connection.RealConnection r7 = r3.getConnection$okhttp()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Handshake r7 = r7.handshake()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r14 = r14.handshake(r7)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r14 = r14.sentRequestAtMillis(r5)     // Catch:{ IOException -> 0x00b9 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r14 = r14.receivedResponseAtMillis(r5)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response r10 = r14.build()     // Catch:{ IOException -> 0x00b9 }
            int r11 = r10.code()     // Catch:{ IOException -> 0x00b9 }
        L_0x0116:
            r3.responseHeadersEnd(r10)     // Catch:{ IOException -> 0x00b9 }
            boolean r14 = r13.forWebSocket     // Catch:{ IOException -> 0x00b9 }
            if (r14 == 0) goto L_0x0130
            r14 = 101(0x65, float:1.42E-43)
            if (r11 != r14) goto L_0x0130
            okhttp3.Response$Builder r14 = r10.newBuilder()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.ResponseBody r5 = okhttp3.internal.Util.EMPTY_RESPONSE     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r14 = r14.body(r5)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response r14 = r14.build()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x0140
        L_0x0130:
            okhttp3.Response$Builder r14 = r10.newBuilder()     // Catch:{ IOException -> 0x00b9 }
            okhttp3.ResponseBody r5 = r3.openResponseBody(r10)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response$Builder r14 = r14.body(r5)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.Response r14 = r14.build()     // Catch:{ IOException -> 0x00b9 }
        L_0x0140:
            okhttp3.Request r5 = r14.request()     // Catch:{ IOException -> 0x00b9 }
            java.lang.String r5 = r5.header(r0)     // Catch:{ IOException -> 0x00b9 }
            boolean r5 = r1.equalsIgnoreCase(r5)     // Catch:{ IOException -> 0x00b9 }
            if (r5 != 0) goto L_0x0159
            r5 = 2
            java.lang.String r0 = okhttp3.Response.header$default(r14, r0, r9, r5, r9)     // Catch:{ IOException -> 0x00b9 }
            boolean r0 = r1.equalsIgnoreCase(r0)     // Catch:{ IOException -> 0x00b9 }
            if (r0 == 0) goto L_0x015c
        L_0x0159:
            r3.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x00b9 }
        L_0x015c:
            r0 = 204(0xcc, float:2.86E-43)
            if (r11 == r0) goto L_0x0164
            r0 = 205(0xcd, float:2.87E-43)
            if (r11 != r0) goto L_0x019f
        L_0x0164:
            okhttp3.ResponseBody r0 = r14.body()     // Catch:{ IOException -> 0x00b9 }
            if (r0 == 0) goto L_0x016f
            long r0 = r0.contentLength()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x0171
        L_0x016f:
            r0 = -1
        L_0x0171:
            r5 = 0
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x019f
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x00b9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b9 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x00b9 }
            r1.append(r11)     // Catch:{ IOException -> 0x00b9 }
            java.lang.String r2 = " had non-zero Content-Length: "
            r1.append(r2)     // Catch:{ IOException -> 0x00b9 }
            okhttp3.ResponseBody r14 = r14.body()     // Catch:{ IOException -> 0x00b9 }
            if (r14 == 0) goto L_0x0194
            long r2 = r14.contentLength()     // Catch:{ IOException -> 0x00b9 }
            java.lang.Long r9 = java.lang.Long.valueOf(r2)     // Catch:{ IOException -> 0x00b9 }
        L_0x0194:
            r1.append(r9)     // Catch:{ IOException -> 0x00b9 }
            java.lang.String r14 = r1.toString()     // Catch:{ IOException -> 0x00b9 }
            r0.<init>(r14)     // Catch:{ IOException -> 0x00b9 }
            throw r0     // Catch:{ IOException -> 0x00b9 }
        L_0x019f:
            return r14
        L_0x01a0:
            if (r4 == 0) goto L_0x01a6
            kotlin.ExceptionsKt.a(r4, r14)
            throw r4
        L_0x01a6:
            throw r14
        L_0x01a7:
            throw r4
        L_0x01a8:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
