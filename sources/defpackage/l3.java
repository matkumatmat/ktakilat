package defpackage;

import android.location.GnssStatus;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.StringJoiner;
import java.util.concurrent.CompletionException;
import java.util.function.Consumer;

/* renamed from: l3  reason: default package */
public abstract /* synthetic */ class l3 {
    public static /* bridge */ /* synthetic */ boolean B(Object obj) {
        return obj instanceof CompletionException;
    }

    public static /* bridge */ /* synthetic */ GnssStatus f(Object obj) {
        return (GnssStatus) obj;
    }

    public static /* synthetic */ UncheckedIOException h(IOException iOException) {
        return new UncheckedIOException(iOException);
    }

    public static /* synthetic */ StringJoiner r() {
        return new StringJoiner(", ", "(one of: ", ")");
    }

    public static /* bridge */ /* synthetic */ CompletionException s(Object obj) {
        return (CompletionException) obj;
    }

    public static /* bridge */ /* synthetic */ Consumer t(Object obj) {
        return (Consumer) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void v() {
        /*
            java.io.UncheckedIOException r0 = new java.io.UncheckedIOException
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l3.v():void");
    }
}
