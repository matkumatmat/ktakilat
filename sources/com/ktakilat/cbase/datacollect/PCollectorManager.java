package com.ktakilat.cbase.datacollect;

import android.os.Build;
import android.os.Bundle;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/ktakilat/cbase/datacollect/PCollectorManager;", "", "Companion", "CBase_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PCollectorManager {

    /* renamed from: a  reason: collision with root package name */
    public static String f469a;
    public static String b;
    public static String c;
    public static String d;
    public static final int e = Build.VERSION.SDK_INT;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static final OkHttpClient j;
    public static final Gson k = new Gson();

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/ktakilat/cbase/datacollect/PCollectorManager$Companion;", "", "", "traceId", "Ljava/lang/Void;", "", "CLIENT_CATEGORY", "Ljava/lang/String;", "CLIENT_OS", "", "clientOsVersion", "I", "wv", "bn", "Lokhttp3/Dispatcher;", "clientDispatcher", "Lokhttp3/Dispatcher;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "CBase_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, okhttp3.Callback] */
        public static void a(Map map) {
            try {
                MediaType mediaType = MediaType.Companion.get("application/json");
                RequestBody.Companion companion = RequestBody.Companion;
                String json = PCollectorManager.k.toJson((Object) map);
                Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                FirebasePerfOkHttpClient.enqueue(PCollectorManager.j.newCall(new Request.Builder().url("https://logcus.pendanaan.com").post(companion.create(json, mediaType)).build()), new Object());
            } catch (Exception unused) {
            }
        }

        public static void b(Bundle bundle, String str, String str2) {
            LinkedHashMap linkedHashMap;
            Bundle bundle2 = bundle;
            try {
                Pair pair = new Pair("timestamp", Long.valueOf(System.currentTimeMillis()));
                Pair pair2 = new Pair("uid", PCollectorManager.f469a);
                Pair pair3 = new Pair("eventType", str);
                Pair pair4 = new Pair("url", str2);
                if (bundle2 == null) {
                    linkedHashMap = null;
                } else {
                    linkedHashMap = new LinkedHashMap();
                    for (String next : bundle.keySet()) {
                        linkedHashMap.put(next, bundle2.get(next));
                    }
                }
                Pair pair5 = new Pair("extend", linkedHashMap);
                String str3 = PCollectorManager.f469a;
                a(MapsKt.e(pair, pair2, pair3, pair4, pair5, new Pair("traceId", null), new Pair("clientNo", PCollectorManager.b), new Pair("clientModel", PCollectorManager.c), new Pair("clientCategory", PlaceFields.PHONE), new Pair("clientManufacture", PCollectorManager.d), new Pair("clientOs", "Android"), new Pair("clientOsVersion", Integer.valueOf(PCollectorManager.e)), new Pair("ai", PCollectorManager.f), new Pair("av", PCollectorManager.g), new Pair("wv", null), new Pair("bn", "Webview"), new Pair("bv", PCollectorManager.h), new Pair("gaid", PCollectorManager.i), new Pair("idfv", null), new Pair("idfa", null)));
            } catch (Exception unused) {
            }
        }
    }

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(4);
        j = new OkHttpClient().newBuilder().dispatcher(dispatcher).build();
    }
}
