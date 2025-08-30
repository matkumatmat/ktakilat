package defpackage;

import android.adservices.adselection.AdSelectionFromOutcomesConfig;
import android.adservices.adselection.GetAdSelectionDataOutcome;
import android.adservices.common.AdFilters;
import android.adservices.customaudience.FetchAndJoinCustomAudienceRequest;
import android.net.Uri;

/* renamed from: s  reason: default package */
public abstract /* synthetic */ class s {
    public static /* synthetic */ AdSelectionFromOutcomesConfig.Builder a() {
        return new AdSelectionFromOutcomesConfig.Builder();
    }

    public static /* bridge */ /* synthetic */ GetAdSelectionDataOutcome g(Object obj) {
        return (GetAdSelectionDataOutcome) obj;
    }

    public static /* synthetic */ AdFilters.Builder k() {
        return new AdFilters.Builder();
    }

    public static /* synthetic */ FetchAndJoinCustomAudienceRequest.Builder r(Uri uri) {
        return new FetchAndJoinCustomAudienceRequest.Builder(uri);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void t() {
        /*
            android.adservices.customaudience.FetchAndJoinCustomAudienceRequest$Builder r0 = new android.adservices.customaudience.FetchAndJoinCustomAudienceRequest$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.s.t():void");
    }
}
