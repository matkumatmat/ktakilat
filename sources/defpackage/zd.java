package defpackage;

import android.adservices.adselection.ReportImpressionRequest;
import android.adservices.adselection.UpdateAdCounterHistogramRequest;
import android.adservices.common.AdTechIdentifier;

/* renamed from: zd  reason: default package */
public abstract /* synthetic */ class zd {
    public static /* synthetic */ ReportImpressionRequest a(long j) {
        return new ReportImpressionRequest(j);
    }

    public static /* synthetic */ UpdateAdCounterHistogramRequest.Builder b(long j, int i, AdTechIdentifier adTechIdentifier) {
        return new UpdateAdCounterHistogramRequest.Builder(j, i, adTechIdentifier);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void d() {
        /*
            android.adservices.adselection.UpdateAdCounterHistogramRequest$Builder r0 = new android.adservices.adselection.UpdateAdCounterHistogramRequest$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zd.d():void");
    }
}
