package com.chuckerteam.chucker.api;

import android.content.Context;
import com.chuckerteam.chucker.api.RetentionManager;
import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/chuckerteam/chucker/api/ChuckerCollector;", "", "com.github.ChuckerTeam.Chucker.library-no-op"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChuckerCollector {
    @JvmOverloads
    public ChuckerCollector(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        RetentionManager.Period period = RetentionManager.Period.ONE_WEEK;
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(period, "retentionPeriod");
    }
}
