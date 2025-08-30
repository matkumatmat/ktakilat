package defpackage;

import android.os.Bundle;
import com.google.firebase.crashlytics.AnalyticsDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* renamed from: w  reason: default package */
public final /* synthetic */ class w implements BreadcrumbSource, AnalyticsEventLogger, Deferred.DeferredHandler {
    public final /* synthetic */ AnalyticsDeferredProxy c;

    public /* synthetic */ w(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.c = analyticsDeferredProxy;
    }

    public void handle(Provider provider) {
        this.c.lambda$init$2(provider);
    }

    public void logEvent(String str, Bundle bundle) {
        this.c.lambda$getAnalyticsEventLogger$1(str, bundle);
    }

    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        this.c.lambda$getDeferredBreadcrumbSource$0(breadcrumbHandler);
    }
}
