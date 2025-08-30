package defpackage;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;

/* renamed from: p4  reason: default package */
public final /* synthetic */ class p4 implements BreadcrumbHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsCore f353a;

    public /* synthetic */ p4(CrashlyticsCore crashlyticsCore) {
        this.f353a = crashlyticsCore;
    }

    public final void handleBreadcrumb(String str) {
        this.f353a.log(str);
    }
}
