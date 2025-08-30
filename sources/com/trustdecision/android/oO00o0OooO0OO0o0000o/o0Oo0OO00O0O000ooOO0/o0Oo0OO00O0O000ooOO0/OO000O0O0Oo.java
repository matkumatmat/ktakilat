package com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;

import android.content.Context;
import androidx.annotation.Nullable;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.OoOOooOoooOoo;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o00ooooooO00OO0O00;
import com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.commons.lang3.CharEncoding;

public class OO000O0O0Oo extends o0Oo0OO00O0O000ooOO0 {
    private static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("59110e0b", 46);
    private static final String O0OoOo00O000 = o0Oo0OO00O0O000ooOO0("783821232c35", 14);
    private static final String O0o0o0O0OOOooOo0OOoOOO = o0Oo0OO00O0O000ooOO0("59061c0801", 57);
    private static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("4e282025", 0);
    private static final String OO0000O0Ooo0OO000oo = o0Oo0OO00O0O000ooOO0("4c4c415a514b5a0e55400c4c4203185f5f5901185b5e1d276d74625d595f4d41571d266d414b5a5d4f4f4c577b6d0b3957484d5b", 104);
    private static final String OoOOooOoooOoo = o0Oo0OO00O0O000ooOO0("4c272a313a2031653e2b67272968733434326a733035764c061f09363234262a3c764d062a2031362424273c100660452b232630", 3);
    private static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("4c040912190312461d0844040a4b5017171149501316556f253c2a15111705091f556e25090312150707041f33254368060005", 32);
    private static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("40313732", 23);

    public OO000O0O0Oo(Context context, o00ooooooO00OO0O00 o00ooooooo00oo0o00) {
        super(context, o00ooooooo00oo0o00);
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
            byte b = (byte) (i ^ 40);
            byte b2 = (byte) (bArr[0] ^ 47);
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

    private String oO00o0OooO0OO0o0000o() {
        return OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("5d471b024545431b1b460702494d5b405c5b", 114));
    }

    public String OO0000O0Ooo0OO000oo() {
        return o0Oo0OO00O0O000ooOO0("7968686e", 95);
    }

    public boolean OoOOooOoooOoo() {
        try {
            return o0Oo0OO00O0O000ooOO0("1e", 82).equals(OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("5f262432292934696e39396e743e3238292e3c3c3f24283e796e3536332c2e352232", 27)));
        } catch (Exception unused) {
            return false;
        }
    }

    public String o00ooooooO00OO0O00() {
        return o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("40575154", 113));
    }

    @Nullable
    public String o0O00o00OOoOo0oooOoo00() {
        return oO00o0OooO0OO0o0000o();
    }

    private String o0O00o00OOoOo0oooOoo00(String str) {
        return o0Oo0OO00O0O000ooOO0(str, "");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String o0Oo0OO00O0O000ooOO0(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 2986299(0x2d913b, float:4.184696E-39)
            r2 = 1
            r3 = 2
            if (r0 == r1) goto L_0x0036
            r1 = 3403373(0x33ee6d, float:4.769141E-39)
            if (r0 == r1) goto L_0x0026
            r1 = 3611910(0x371d06, float:5.061364E-39)
            if (r0 == r1) goto L_0x0016
            goto L_0x0046
        L_0x0016:
            java.lang.String r0 = "590f1015"
            r1 = 48
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0046
            r8 = 2
            goto L_0x0047
        L_0x0026:
            java.lang.String r0 = "40696f6a"
            r1 = 79
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0046
            r8 = 0
            goto L_0x0047
        L_0x0036:
            java.lang.String r0 = "4e5b5356"
            r1 = 115(0x73, float:1.61E-43)
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r1)
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L_0x0046
            r8 = 1
            goto L_0x0047
        L_0x0046:
            r8 = -1
        L_0x0047:
            r0 = 0
            if (r8 == 0) goto L_0x0080
            if (r8 == r2) goto L_0x0076
            if (r8 == r3) goto L_0x0059
            java.lang.String r8 = "6c09242b2a307f6d223130216f62266f7f26223e"
            r9 = 3
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r9)
            r7.o0Oo0OO00O0O000ooOO0((java.lang.String) r8)
            return r0
        L_0x0059:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "4c0d001b100a1b4f14014d0d0342591e1e1840591a1f5c662c35231c181e0c00165c672c000a1b1c0e0e0d163a2c4a7816090c1a"
            r2 = 41
        L_0x0062:
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r2)
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
        L_0x0070:
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r2 = r8
            goto L_0x0089
        L_0x0076:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "4c0f02191208194d16034f0f01405b1c1c1a425b181d5e642e37211e1a1c0e02145e652e0208191e0c0c0f14382e486d030b0e18"
            r2 = 43
            goto L_0x0062
        L_0x0080:
            java.lang.String r8 = "4c000d161d071642190c40000e4f541313154d541712516b21382e111513010d1b516a210d0716110303001b3721476c020401"
            r9 = 36
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r9)
            goto L_0x0070
        L_0x0089:
            android.content.Context r8 = r7.o0Oo0OO00O0O000ooOO0     // Catch:{ all -> 0x0098 }
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch:{ all -> 0x0098 }
            r5 = 0
            r6 = 0
            r3 = 0
            r4 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0098 }
            goto L_0x009a
        L_0x0098:
            r8 = r0
        L_0x009a:
            if (r8 == 0) goto L_0x0103
            boolean r9 = r8.moveToNext()
            if (r9 == 0) goto L_0x0103
            java.lang.String r9 = "59554f5b52"
            r1 = 106(0x6a, float:1.49E-43)
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r1)     // Catch:{ all -> 0x00b6 }
            int r9 = r8.getColumnIndex(r9)     // Catch:{ all -> 0x00b6 }
            java.lang.String r9 = r8.getString(r9)     // Catch:{ all -> 0x00b6 }
            r8.close()
            return r9
        L_0x00b6:
            r9 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            r1.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r2 = "6a7a4d50501f1a524046031f5a4948404a440a0e414c575c46576b7a5b514e575e5a1f044a03"
            r3 = 101(0x65, float:1.42E-43)
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x00fe }
            r1.append(r2)     // Catch:{ all -> 0x00fe }
            java.lang.Class r2 = r7.getClass()     // Catch:{ all -> 0x00fe }
            java.lang.String r2 = r2.getSimpleName()     // Catch:{ all -> 0x00fe }
            r1.append(r2)     // Catch:{ all -> 0x00fe }
            java.lang.String r2 = "257200263b2839203b3c6927"
            r3 = 21
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x00fe }
            r1.append(r2)     // Catch:{ all -> 0x00fe }
            r1.append(r9)     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00fe }
            r7.o0Oo0OO00O0O000ooOO0((java.lang.String) r1)     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = "787e67656a73"
            r2 = 72
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r2)     // Catch:{ all -> 0x00fe }
            java.lang.String r2 = "4a2e"
            r3 = 27
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)     // Catch:{ all -> 0x00fe }
            android.util.Log.e(r1, r2, r9)     // Catch:{ all -> 0x00fe }
            r8.close()
            goto L_0x0103
        L_0x00fe:
            r9 = move-exception
            r8.close()
            throw r9
        L_0x0103:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0.OO000O0O0Oo.o0Oo0OO00O0O000ooOO0(java.lang.String, java.lang.String):java.lang.String");
    }

    public void o0Oo0OO00O0O000ooOO0(ThreadPoolExecutor threadPoolExecutor) {
        this.o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(this);
    }
}
