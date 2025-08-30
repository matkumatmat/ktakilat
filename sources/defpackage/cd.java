package defpackage;

import java.util.StringJoiner;

/* renamed from: cd  reason: default package */
public abstract /* synthetic */ class cd {
    public static /* synthetic */ StringJoiner n(String str) {
        return new StringJoiner(str);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void r() {
        /*
            java.util.StringJoiner r0 = new java.util.StringJoiner
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.cd.r():void");
    }
}
