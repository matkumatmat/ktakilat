package com.ktakilat.cbase.http;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

public class ApiManager {
    public static ApiManager e;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f472a;
    public final OkHttpClient b;
    public final ApiInterceptor c;
    public final HashMap d = new HashMap(0);

    /* JADX WARNING: type inference failed for: r0v1, types: [okhttp3.Interceptor, com.ktakilat.cbase.http.ApiInterceptor, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v2, types: [okhttp3.Interceptor, java.lang.Object] */
    public ApiManager() {
        ? obj = new Object();
        HashMap hashMap = new HashMap(0);
        obj.f471a = hashMap;
        new HashMap(0);
        new HashMap(0);
        hashMap.put(HttpHeaders.ACCEPT, "application/json");
        this.c = obj;
        ? obj2 = new Object();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f472a = builder.connectTimeout(40, timeUnit).readTimeout(40, timeUnit).writeTimeout(40, timeUnit).addInterceptor(obj).build();
        this.b = new OkHttpClient.Builder().connectTimeout(40, timeUnit).readTimeout(40, timeUnit).writeTimeout(40, timeUnit).addInterceptor(obj2).build();
    }

    public static ApiManager b() {
        if (e == null) {
            synchronized (ApiManager.class) {
                try {
                    if (e == null) {
                        e = new ApiManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    public final void a(String str, String str2) {
        ApiInterceptor apiInterceptor = this.c;
        apiInterceptor.getClass();
        boolean isEmpty = TextUtils.isEmpty(str2);
        HashMap hashMap = apiInterceptor.f471a;
        if (isEmpty) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, str2);
        }
    }

    public final String c(String str) {
        return (String) this.c.f471a.get(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r1 = (com.ktakilat.cbase.http.BaseUrl) r7.getAnnotation(r1);
        r4 = r1.moduleName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3 = r1.isThirdDomain();
        r1 = (java.lang.String) r7.get(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002b, code lost:
        r2 = r4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d() {
        /*
            r9 = this;
            java.lang.Class<com.ktakilat.loan.http.AppHttpService> r0 = com.ktakilat.loan.http.AppHttpService.class
            java.lang.Class<com.ktakilat.cbase.http.BaseUrl> r1 = com.ktakilat.cbase.http.BaseUrl.class
            java.lang.String r2 = ""
            r3 = 0
            java.lang.reflect.Field[] r4 = r0.getFields()     // Catch:{ Exception -> 0x002f }
            int r5 = r4.length     // Catch:{ Exception -> 0x002f }
            r6 = 0
        L_0x000d:
            if (r6 >= r5) goto L_0x0035
            r7 = r4[r6]     // Catch:{ Exception -> 0x002f }
            boolean r8 = r7.isAnnotationPresent(r1)     // Catch:{ Exception -> 0x002f }
            if (r8 == 0) goto L_0x0032
            java.lang.annotation.Annotation r1 = r7.getAnnotation(r1)     // Catch:{ Exception -> 0x002f }
            com.ktakilat.cbase.http.BaseUrl r1 = (com.ktakilat.cbase.http.BaseUrl) r1     // Catch:{ Exception -> 0x002f }
            java.lang.String r4 = r1.moduleName()     // Catch:{ Exception -> 0x002f }
            boolean r3 = r1.isThirdDomain()     // Catch:{ Exception -> 0x002d }
            java.lang.Object r1 = r7.get(r0)     // Catch:{ Exception -> 0x002d }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x002d }
            r2 = r4
            goto L_0x0036
        L_0x002d:
            r1 = move-exception
            goto L_0x0039
        L_0x002f:
            r1 = move-exception
            r4 = r2
            goto L_0x0039
        L_0x0032:
            int r6 = r6 + 1
            goto L_0x000d
        L_0x0035:
            r1 = r2
        L_0x0036:
            r4 = r2
            r2 = r1
            goto L_0x003c
        L_0x0039:
            com.ktakilat.cbase.utils.LogUtil.a(r1)
        L_0x003c:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0091
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x0089
            java.util.HashMap r1 = r9.d
            java.lang.Object r5 = r1.get(r4)
            if (r5 != 0) goto L_0x0088
            retrofit2.Retrofit$Builder r5 = new retrofit2.Retrofit$Builder
            r5.<init>()
            retrofit2.Retrofit$Builder r2 = r5.baseUrl((java.lang.String) r2)
            com.google.gson.GsonBuilder r5 = new com.google.gson.GsonBuilder
            r5.<init>()
            com.google.gson.Gson r5 = r5.create()
            retrofit2.converter.gson.GsonConverterFactory r5 = retrofit2.converter.gson.GsonConverterFactory.create(r5)
            retrofit2.Retrofit$Builder r2 = r2.addConverterFactory(r5)
            retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory r5 = retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create()
            retrofit2.Retrofit$Builder r2 = r2.addCallAdapterFactory(r5)
            if (r3 == 0) goto L_0x0077
            okhttp3.OkHttpClient r3 = r9.b
            goto L_0x0079
        L_0x0077:
            okhttp3.OkHttpClient r3 = r9.f472a
        L_0x0079:
            retrofit2.Retrofit$Builder r2 = r2.client(r3)
            retrofit2.Retrofit r2 = r2.build()
            java.lang.Object r5 = r2.create(r0)
            r1.put(r4, r5)
        L_0x0088:
            return r5
        L_0x0089:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "BaseUrl注解，必须填写唯一标识"
            r0.<init>(r1)
            throw r0
        L_0x0091:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "必须配置BaseUrl注解，且赋值"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.cbase.http.ApiManager.d():java.lang.Object");
    }
}
