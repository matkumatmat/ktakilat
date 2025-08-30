package com.appsflyer.internal;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

@SourceDebugExtension({"SMAP\nExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extensions.kt\ncom/appsflyer/internal/components/monitorsdk/helpers/ExtensionsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,24:1\n1549#2:25\n1620#2,3:26\n*S KotlinDebug\n*F\n+ 1 Extensions.kt\ncom/appsflyer/internal/components/monitorsdk/helpers/ExtensionsKt\n*L\n16#1:25\n16#1:26,3\n*E\n"})
public final class AFd1tSDK {
    @NotNull
    public static final JSONArray getCurrencyIso4217Code(@NotNull List<AFc1cSDK> list) {
        Intrinsics.checkNotNullParameter(list, "");
        Iterable<AFc1cSDK> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.h(iterable));
        for (AFc1cSDK revenue : iterable) {
            arrayList.add(revenue.getRevenue());
        }
        return new JSONArray(arrayList);
    }

    public static final boolean getRevenue(@NotNull HttpURLConnection httpURLConnection) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "");
        if (httpURLConnection.getResponseCode() / 100 == 2) {
            return true;
        }
        return false;
    }
}
