package com.ktakilat.cbase.http;

import java.util.HashMap;
import okhttp3.Interceptor;

class ApiInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public HashMap f471a;

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cd A[SYNTHETIC, Splitter:B:37:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) {
        /*
            r8 = this;
            okhttp3.Request r0 = r9.request()
            okhttp3.HttpUrl r1 = r0.url()
            okhttp3.Headers r2 = r0.headers()
            java.lang.String r3 = "Authorization"
            java.lang.String r2 = r2.get(r3)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            okhttp3.Request$Builder r0 = r0.newBuilder()
            r0.url((okhttp3.HttpUrl) r1)
            java.util.HashMap r1 = r8.f471a
            com.ktakilat.cbase.http.ApiInfoUtil r4 = com.ktakilat.cbase.http.ApiInfoUtil.b()
            java.lang.String r4 = r4.a()
            byte[] r4 = r4.getBytes()
            r5 = 2
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r5)
            java.lang.String r5 = "Device-Info"
            r1.put(r5, r4)
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x003d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0062
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            if (r2 != 0) goto L_0x005e
            boolean r6 = r3.equals(r5)
            if (r6 == 0) goto L_0x005e
            goto L_0x003d
        L_0x005e:
            r0.addHeader(r5, r4)
            goto L_0x003d
        L_0x0062:
            okhttp3.Request r0 = r0.build()
            java.lang.System.currentTimeMillis()
            r1 = 0
            okhttp3.Response r9 = r9.proceed(r0)     // Catch:{ IOException -> 0x0077 }
            int r2 = r9.code()     // Catch:{ IOException -> 0x0075 }
            r3 = r2
            r2 = r1
            goto L_0x007b
        L_0x0075:
            r2 = move-exception
            goto L_0x0079
        L_0x0077:
            r2 = move-exception
            r9 = r1
        L_0x0079:
            r3 = 200(0xc8, float:2.8E-43)
        L_0x007b:
            java.lang.System.currentTimeMillis()
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x008b
            com.ktakilat.cbase.http.BaseResponse r5 = com.ktakilat.cbase.http.HttpExceptionController.a(r2)
            java.lang.String r5 = com.ktakilat.cbase.utils.JsonUtil.a(r5)
            goto L_0x009a
        L_0x008b:
            okhttp3.ResponseBody r5 = r9.body()
            java.lang.String r5 = r5.string()
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x009a
            r5 = r4
        L_0x009a:
            java.lang.Class<com.ktakilat.cbase.http.BaseResponse> r6 = com.ktakilat.cbase.http.BaseResponse.class
            java.lang.Object r6 = com.ktakilat.cbase.utils.JsonUtil.c(r5, r6)
            if (r6 == 0) goto L_0x00a3
            goto L_0x00c1
        L_0x00a3:
            com.ktakilat.cbase.http.BaseResponse r5 = com.ktakilat.cbase.http.BaseResponse.createNetError()
            com.ktakilat.cbase.http.ApiInfoUtil r6 = com.ktakilat.cbase.http.ApiInfoUtil.b()     // Catch:{ Exception -> 0x00bd }
            com.ktakilat.cbase.http.ApiInfoUtil$DeviceInfoCall r6 = r6.c     // Catch:{ Exception -> 0x00bd }
            if (r6 != 0) goto L_0x00b0
            goto L_0x00b4
        L_0x00b0:
            com.ktakilat.cbase.ui.BaseApplication r1 = r6.getContext()     // Catch:{ Exception -> 0x00bd }
        L_0x00b4:
            int r6 = com.ktakilat.cbase.R.string.http_error     // Catch:{ Exception -> 0x00bd }
            java.lang.String r1 = r1.getString(r6)     // Catch:{ Exception -> 0x00bd }
            r5.setMsg(r1)     // Catch:{ Exception -> 0x00bd }
        L_0x00bd:
            java.lang.String r5 = com.ktakilat.cbase.utils.JsonUtil.a(r5)
        L_0x00c1:
            okhttp3.RequestBody r1 = r0.body()
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            if (r1 != 0) goto L_0x00cd
            goto L_0x00ef
        L_0x00cd:
            r1.writeTo(r6)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r4 = "UTF-8"
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r4)
            okhttp3.MediaType r1 = r1.contentType()
            if (r1 == 0) goto L_0x00e4
            java.nio.charset.Charset r4 = java.nio.charset.Charset.forName(r4)
            java.nio.charset.Charset r7 = r1.charset(r4)
        L_0x00e4:
            java.lang.String r4 = r6.readString(r7)
            goto L_0x00ef
        L_0x00e9:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x00ef:
            r0.method()
            okhttp3.HttpUrl r1 = r0.url()
            java.util.Objects.toString(r1)
            okhttp3.RequestBody r1 = r0.body()
            if (r1 == 0) goto L_0x010c
            okhttp3.MediaType r6 = r1.contentType()
            if (r6 == 0) goto L_0x010c
            okhttp3.MediaType r1 = r1.contentType()
            r1.toString()
        L_0x010c:
            okhttp3.Headers r0 = r0.headers()
            r0.toString()
            r4.length()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
            if (r2 != 0) goto L_0x0137
            okhttp3.Response$Builder r0 = r9.newBuilder()
            okhttp3.Response$Builder r0 = r0.code(r3)
            okhttp3.ResponseBody r9 = r9.body()
            okhttp3.MediaType r9 = r9.contentType()
            okhttp3.ResponseBody r9 = okhttp3.ResponseBody.create((okhttp3.MediaType) r9, (java.lang.String) r5)
            okhttp3.Response$Builder r9 = r0.body(r9)
            okhttp3.Response r9 = r9.build()
            return r9
        L_0x0137:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.http.ApiInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
