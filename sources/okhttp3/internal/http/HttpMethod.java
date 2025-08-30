package okhttp3.internal.http;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.FirebasePerformance;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HttpMethod {
    @NotNull
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        if (Intrinsics.a(str, FirebasePerformance.HttpMethod.GET) || Intrinsics.a(str, FirebasePerformance.HttpMethod.HEAD)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        if (Intrinsics.a(str, FirebasePerformance.HttpMethod.POST) || Intrinsics.a(str, FirebasePerformance.HttpMethod.PUT) || Intrinsics.a(str, FirebasePerformance.HttpMethod.PATCH) || Intrinsics.a(str, "PROPPATCH") || Intrinsics.a(str, "REPORT")) {
            return true;
        }
        return false;
    }

    public final boolean invalidatesCache(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        if (Intrinsics.a(str, FirebasePerformance.HttpMethod.POST) || Intrinsics.a(str, FirebasePerformance.HttpMethod.PATCH) || Intrinsics.a(str, FirebasePerformance.HttpMethod.PUT) || Intrinsics.a(str, FirebasePerformance.HttpMethod.DELETE) || Intrinsics.a(str, "MOVE")) {
            return true;
        }
        return false;
    }

    public final boolean redirectsToGet(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        return !Intrinsics.a(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.METHOD);
        return Intrinsics.a(str, "PROPFIND");
    }
}
