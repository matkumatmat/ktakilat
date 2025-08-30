package defpackage;

import android.app.ApplicationExitInfo;
import android.content.res.loader.ResourcesLoader;

/* renamed from: n  reason: default package */
public abstract /* synthetic */ class n {
    public static /* bridge */ /* synthetic */ ApplicationExitInfo d(Object obj) {
        return (ApplicationExitInfo) obj;
    }

    public static /* synthetic */ ResourcesLoader e() {
        return new ResourcesLoader();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void p() {
        /*
            android.content.res.loader.ResourcesLoader r0 = new android.content.res.loader.ResourcesLoader
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n.p():void");
    }
}
