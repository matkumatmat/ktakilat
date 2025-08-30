package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo;

import android.content.Context;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.CharEncoding;

public class O00OO0oOOooooO00000Oo {
    private static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("35525c", 8);
    protected boolean O00OO0oOOooooO00000Oo;
    protected boolean O0oOO0ooO;
    protected final oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0O00o00OOoOo0oooOoo00;
    protected final Set o0Oo0OO00O0O000ooOO0;
    protected final oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 oO00o0OooO0OO0o0000o;

    public O00OO0oOOooooO00000Oo() {
        this(new OO0000O0Ooo0OO000oo(), new o0Oo0OO00O0O000ooOO0());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ee A[Catch:{ Exception -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0149 A[Catch:{ all -> 0x00df, all -> 0x0141, all -> 0x0146, all -> 0x0143, all -> 0x0164 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void oO00o0OooO0OO0o0000o(android.content.Context r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.util.Set r0 = r9.o0Oo0OO00O0O000ooOO0
            boolean r0 = r0.contains(r11)
            if (r0 == 0) goto L_0x000d
            boolean r0 = r9.O00OO0oOOooooO00000Oo
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r0 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x0018 }
            r0.o0Oo0OO00O0O000ooOO0(r11)     // Catch:{ all -> 0x0018 }
            java.util.Set r0 = r9.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0018 }
            r0.add(r11)     // Catch:{ all -> 0x0018 }
            return
        L_0x0018:
            r0 = move-exception
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r1 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.O0oOoooo0o0o0oOo
            java.lang.String r0 = r0.getLocalizedMessage()
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r1, (java.lang.String) r0)
            if (r10 != 0) goto L_0x0030
            java.lang.String r10 = "1e01303c24616c232e353e32237b66357c6134362f"
            r11 = 112(0x70, float:1.57E-43)
            java.lang.String r10 = o0Oo0OO00O0O000ooOO0((java.lang.String) r10, (int) r11)
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r1, (java.lang.String) r10)
            return
        L_0x0030:
            java.io.File r0 = r9.o0Oo0OO00O0O000ooOO0(r10, r11, r12)
            boolean r2 = r0.exists()     // Catch:{ all -> 0x0052 }
            if (r2 != 0) goto L_0x0054
            r9.o0O00o00OOoOo0oooOoo00(r10, r11, r12)     // Catch:{ all -> 0x0052 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0Oo0OO00O0O000ooOO0 r2 = r9.oO00o0OooO0OO0o0000o     // Catch:{ all -> 0x0052 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r3 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x0052 }
            java.lang.String[] r4 = r3.o0Oo0OO00O0O000ooOO0()     // Catch:{ all -> 0x0052 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r3 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x0052 }
            java.lang.String r5 = r3.oO00o0OooO0OO0o0000o(r11)     // Catch:{ all -> 0x0052 }
            r3 = r10
            r6 = r0
            r7 = r9
            r2.o0O00o00OOoOo0oooOoo00(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0052 }
            goto L_0x0054
        L_0x0052:
            r1 = move-exception
            goto L_0x0066
        L_0x0054:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r2 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = r0.getAbsolutePath()     // Catch:{ all -> 0x0052 }
            r2.o0O00o00OOoOo0oooOoo00(r3)     // Catch:{ all -> 0x0052 }
            java.util.Set r2 = r9.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0052 }
            r2.add(r11)     // Catch:{ all -> 0x0052 }
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r1)     // Catch:{ all -> 0x0052 }
            return
        L_0x0066:
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r8 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO0oo00OooOooOOo
            java.lang.String r2 = r1.getLocalizedMessage()
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r8, (java.lang.String) r2)
            boolean r2 = r1 instanceof java.lang.UnsatisfiedLinkError
            if (r2 == 0) goto L_0x00e8
            java.lang.String r2 = r1.getMessage()
            boolean r3 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(r2)
            if (r3 != 0) goto L_0x00e8
            java.lang.String r3 = "30094005110a5c180e475a140e14021716575c1a5500120c5c180e"
            r4 = 76
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r4)
            boolean r3 = r2.endsWith(r3)
            java.lang.String r4 = "300049091b055511074e531d071d0b1e1f5e55135c0c1803551107"
            r5 = 69
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r5)
            boolean r2 = r2.endsWith(r4)
            if (r3 != 0) goto L_0x0099
            if (r2 == 0) goto L_0x00e8
        L_0x0099:
            r9.o0O00o00OOoOo0oooOoo00(r10, r11, r12)     // Catch:{ all -> 0x00df }
            java.lang.String r2 = "38515d4a46414906190314"
            r4 = 29
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r4)     // Catch:{ all -> 0x00df }
            java.lang.String r4 = "383a36212d2a22"
            r6 = 118(0x76, float:1.65E-43)
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r6)     // Catch:{ all -> 0x00df }
            java.lang.String[] r2 = new java.lang.String[]{r2, r4}     // Catch:{ all -> 0x00df }
            java.lang.String r4 = "380905411803415443"
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r5)     // Catch:{ all -> 0x00df }
            java.lang.String[] r4 = new java.lang.String[]{r4}     // Catch:{ all -> 0x00df }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0Oo0OO00O0O000ooOO0 r5 = r9.oO00o0OooO0OO0o0000o     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x00bf
            r4 = r2
        L_0x00bf:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r2 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x00df }
            java.lang.String r6 = r2.oO00o0OooO0OO0o0000o(r11)     // Catch:{ all -> 0x00df }
            r2 = r5
            r3 = r10
            r5 = r6
            r6 = r0
            r7 = r9
            r2.o0O00o00OOoOo0oooOoo00(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x00df }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r2 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x00df }
            java.lang.String r3 = r0.getAbsolutePath()     // Catch:{ all -> 0x00df }
            r2.o0O00o00OOoOo0oooOoo00(r3)     // Catch:{ all -> 0x00df }
            java.util.Set r2 = r9.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x00df }
            r2.add(r11)     // Catch:{ all -> 0x00df }
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r8)     // Catch:{ all -> 0x00df }
            return
        L_0x00df:
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r2 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oO0oo00OooOooOOo
            java.lang.String r1 = r1.getLocalizedMessage()
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r2, (java.lang.String) r1)
        L_0x00e8:
            boolean r1 = r0.exists()     // Catch:{ Exception -> 0x00f3 }
            if (r1 == 0) goto L_0x00f5
            boolean r1 = r9.O00OO0oOOooooO00000Oo     // Catch:{ Exception -> 0x00f3 }
            if (r1 == 0) goto L_0x0116
            goto L_0x00f5
        L_0x00f3:
            r12 = move-exception
            goto L_0x010d
        L_0x00f5:
            r9.o0O00o00OOoOo0oooOoo00(r10, r11, r12)     // Catch:{ Exception -> 0x00f3 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0Oo0OO00O0O000ooOO0 r2 = r9.oO00o0OooO0OO0o0000o     // Catch:{ Exception -> 0x00f3 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r12 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ Exception -> 0x00f3 }
            java.lang.String[] r4 = r12.o0Oo0OO00O0O000ooOO0()     // Catch:{ Exception -> 0x00f3 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r12 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r5 = r12.oO00o0OooO0OO0o0000o(r11)     // Catch:{ Exception -> 0x00f3 }
            r3 = r10
            r6 = r0
            r7 = r9
            r2.o0Oo0OO00O0O000ooOO0(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00f3 }
            goto L_0x0116
        L_0x010d:
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r1 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.o0ooO0o000Oo0Oo0O0
            java.lang.String r12 = r12.getLocalizedMessage()
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r1, (java.lang.String) r12)
        L_0x0116:
            boolean r12 = r9.O0oOO0ooO     // Catch:{ all -> 0x0141 }
            if (r12 == 0) goto L_0x0156
            r12 = 0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00 r1 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00     // Catch:{ all -> 0x0146 }
            r1.<init>(r0)     // Catch:{ all -> 0x0146 }
            java.util.List r12 = r1.o0O00o00OOoOo0oooOoo00()     // Catch:{ all -> 0x0143 }
            r1.close()     // Catch:{ all -> 0x0141 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0141 }
        L_0x012b:
            boolean r1 = r12.hasNext()     // Catch:{ all -> 0x0141 }
            if (r1 == 0) goto L_0x0156
            java.lang.Object r1 = r12.next()     // Catch:{ all -> 0x0141 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0141 }
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r2 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x0141 }
            java.lang.String r1 = r2.O00OO0oOOooooO00000Oo(r1)     // Catch:{ all -> 0x0141 }
            r9.o0Oo0OO00O0O000ooOO0((android.content.Context) r10, (java.lang.String) r1)     // Catch:{ all -> 0x0141 }
            goto L_0x012b
        L_0x0141:
            r10 = move-exception
            goto L_0x014d
        L_0x0143:
            r10 = move-exception
            r12 = r1
            goto L_0x0147
        L_0x0146:
            r10 = move-exception
        L_0x0147:
            if (r12 == 0) goto L_0x014c
            r12.close()     // Catch:{ all -> 0x0141 }
        L_0x014c:
            throw r10     // Catch:{ all -> 0x0141 }
        L_0x014d:
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$oO00o0OooO0OO0o0000o r12 = com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o.oOO0OooO0
            java.lang.String r10 = r10.getLocalizedMessage()
            com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0((com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o) r12, (java.lang.String) r10)
        L_0x0156:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o$o0O00o00OOoOo0oooOoo00 r10 = r9.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x0164 }
            java.lang.String r12 = r0.getAbsolutePath()     // Catch:{ all -> 0x0164 }
            r10.o0O00o00OOoOo0oooOoo00(r12)     // Catch:{ all -> 0x0164 }
            java.util.Set r10 = r9.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0164 }
            r10.add(r11)     // Catch:{ all -> 0x0164 }
        L_0x0164:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.O00OO0oOOooooO00000Oo.oO00o0OooO0OO0o0000o(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public void o0O00o00OOoOo0oooOoo00(Context context, String str, String str2) {
        File o0Oo0OO00O0O000ooOO02 = o0Oo0OO00O0O000ooOO0(context);
        File o0Oo0OO00O0O000ooOO03 = o0Oo0OO00O0O000ooOO0(context, str, str2);
        File[] listFiles = o0Oo0OO00O0O000ooOO02.listFiles(new o00ooooooO00OO0O00(this, this.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o(str)));
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.O00OO0oOOooooO00000Oo || !file.getAbsolutePath().equals(o0Oo0OO00O0O000ooOO03.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }

    public File o0Oo0OO00O0O000ooOO0(Context context) {
        return context.getDir(o0Oo0OO00O0O000ooOO0("355e50", 4), 0);
    }

    public O00OO0oOOooooO00000Oo(oO00o0OooO0OO0o0000o.o0O00o00OOoOo0oooOoo00 o0o00o00ooooo0oooooo00, oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 o0oo0oo00o0o000oooo0) {
        this.o0Oo0OO00O0O000ooOO0 = new HashSet();
        if (o0o00o00ooooo0oooooo00 == null) {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("1a567b74756f2024656674273a6f6d743838717f6467677f2d38777a717563", 43));
        } else if (o0oo0oo00o0o000oooo0 != null) {
            this.o0O00o00OOoOo0oooOoo00 = o0o00o00ooooo0oooooo00;
            this.oO00o0OooO0OO0o0000o = o0oo0oo00o0o000oooo0;
        } else {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("1a311c1312084743020113405d080a135f5f1618030000184a5a140e14061e131a04", 76));
        }
    }

    public File o0Oo0OO00O0O000ooOO0(Context context, String str, String str2) {
        String oO00o0OooO0OO0o0000o2 = this.o0O00o00OOoOo0oooOoo00.oO00o0OooO0OO0o0000o(str);
        if (OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(str2)) {
            return new File(o0Oo0OO00O0O000ooOO0(context), oO00o0OooO0OO0o0000o2);
        }
        return new File(o0Oo0OO00O0O000ooOO0(context), ba.r(ba.v(oO00o0OooO0OO0o0000o2), o0Oo0OO00O0O000ooOO0("77", 23), str2));
    }

    private static String o0Oo0OO00O0O000ooOO0(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 95);
            byte b2 = (byte) (bArr[0] ^ 89);
            bArr[0] = b2;
            for (int i4 = 1; i4 < length; i4++) {
                b2 = (byte) ((b2 ^ bArr[i4]) ^ b);
                bArr[i4] = b2;
            }
            return new String(bArr, CharEncoding.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void o0Oo0OO00O0O000ooOO0(Context context, String str) {
        o0Oo0OO00O0O000ooOO0(context, str, (String) null, (oO00o0OooO0OO0o0000o.C0019oO00o0OooO0OO0o0000o) null);
    }

    public void o0Oo0OO00O0O000ooOO0(Context context, String str, String str2, oO00o0OooO0OO0o0000o.C0019oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o) {
        if (OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(str)) {
            throw new IllegalArgumentException(o0Oo0OO00O0O000ooOO0("1e4574786025276e607b787860322271382e677677667c392570726b272476392e63766f66", 52));
        } else if (oo00o0oooo0oo0o0000o == null) {
            oO00o0OooO0OO0o0000o(context, str, str2);
        } else {
            new Thread(new O0oOO0ooO(this, context, str, str2, oo00o0oooo0oo0o0000o)).start();
        }
    }
}
