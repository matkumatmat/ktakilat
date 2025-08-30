package com.chuckerteam.chucker.api;

import android.content.Context;
import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/chuckerteam/chucker/api/ChuckerInterceptor;", "Lokhttp3/Interceptor;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Builder", "com.github.ChuckerTeam.Chucker.library-no-op"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChuckerInterceptor implements Interceptor {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/chuckerteam/chucker/api/ChuckerInterceptor$Builder;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "com.github.ChuckerTeam.Chucker.library-no-op"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Builder {
        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        }
    }

    public ChuckerInterceptor(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
        new Builder(context);
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request());
    }
}
