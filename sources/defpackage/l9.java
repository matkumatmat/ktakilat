package defpackage;

import android.adservices.adselection.GetAdSelectionDataRequest;
import android.adservices.adselection.PersistAdSelectionResultRequest;
import android.adservices.adselection.ReportEventRequest;
import android.adservices.common.FrequencyCapFilters;
import android.adservices.common.KeyedFrequencyCap;
import android.adservices.signals.UpdateSignalsRequest;
import android.adservices.topics.EncryptedTopic;
import android.net.Uri;
import java.time.Duration;

/* renamed from: l9  reason: default package */
public abstract /* synthetic */ class l9 {
    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void B() {
        /*
            android.adservices.signals.UpdateSignalsRequest$Builder r0 = new android.adservices.signals.UpdateSignalsRequest$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l9.B():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void D() {
        /*
            android.adservices.adselection.ReportEventRequest$Builder r0 = new android.adservices.adselection.ReportEventRequest$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l9.D():void");
    }

    public static /* synthetic */ GetAdSelectionDataRequest.Builder b() {
        return new GetAdSelectionDataRequest.Builder();
    }

    public static /* synthetic */ PersistAdSelectionResultRequest.Builder f() {
        return new PersistAdSelectionResultRequest.Builder();
    }

    public static /* synthetic */ ReportEventRequest.Builder k(long j, String str, String str2, int i) {
        return new ReportEventRequest.Builder(j, str, str2, i);
    }

    public static /* synthetic */ FrequencyCapFilters.Builder n() {
        return new FrequencyCapFilters.Builder();
    }

    public static /* synthetic */ KeyedFrequencyCap.Builder p(int i, int i2, Duration duration) {
        return new KeyedFrequencyCap.Builder(i, i2, duration);
    }

    public static /* synthetic */ UpdateSignalsRequest.Builder s(Uri uri) {
        return new UpdateSignalsRequest.Builder(uri);
    }

    public static /* bridge */ /* synthetic */ EncryptedTopic u(Object obj) {
        return (EncryptedTopic) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void x() {
        /*
            android.adservices.common.KeyedFrequencyCap$Builder r0 = new android.adservices.common.KeyedFrequencyCap$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l9.x():void");
    }
}
