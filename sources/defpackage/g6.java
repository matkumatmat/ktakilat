package defpackage;

import android.content.Context;
import android.content.pm.ShortcutInfo;
import android.view.inputmethod.InputContentInfo;

/* renamed from: g6  reason: default package */
public abstract /* synthetic */ class g6 {
    public static /* synthetic */ ShortcutInfo.Builder d(Context context, String str) {
        return new ShortcutInfo.Builder(context, str);
    }

    public static /* bridge */ /* synthetic */ ShortcutInfo h(Object obj) {
        return (ShortcutInfo) obj;
    }

    public static /* bridge */ /* synthetic */ InputContentInfo k(Object obj) {
        return (InputContentInfo) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void o() {
        /*
            android.content.pm.ShortcutInfo$Builder r0 = new android.content.pm.ShortcutInfo$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g6.o():void");
    }
}
