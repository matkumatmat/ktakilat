package defpackage;

import android.hardware.camera2.params.InputConfiguration;
import android.security.keystore.KeyGenParameterSpec;
import android.view.ViewStructure;

/* renamed from: gh  reason: default package */
public abstract /* synthetic */ class gh {
    public static /* synthetic */ InputConfiguration d(int i, int i2, int i3) {
        return new InputConfiguration(i, i2, i3);
    }

    public static /* synthetic */ KeyGenParameterSpec.Builder h(String str) {
        return new KeyGenParameterSpec.Builder(str, 3);
    }

    public static /* bridge */ /* synthetic */ ViewStructure j(Object obj) {
        return (ViewStructure) obj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void l() {
        /*
            android.hardware.camera2.params.InputConfiguration r0 = new android.hardware.camera2.params.InputConfiguration
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gh.l():void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void u() {
        /*
            android.security.keystore.KeyGenParameterSpec$Builder r0 = new android.security.keystore.KeyGenParameterSpec$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gh.u():void");
    }
}
