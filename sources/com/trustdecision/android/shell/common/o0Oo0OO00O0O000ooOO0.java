package com.trustdecision.android.shell.common;

import com.google.common.base.Ascii;
import java.util.Hashtable;
import java.util.Map;
import org.apache.commons.lang3.CharEncoding;
import org.json.JSONException;
import org.json.JSONObject;

public class o0Oo0OO00O0O000ooOO0 {
    public static final String O00OO0oOOooooO00000Oo = o0Oo0OO00O0O000ooOO0("1244405c", 3);
    private static final Map O0OoOo00O000 = new Hashtable();
    public static final String O0oOO0ooO = o0Oo0OO00O0O000ooOO0("151103141e", 92);
    private static final String OO0000O0Ooo0OO000oo = o0Oo0OO00O0O000ooOO0("165f4a4751550611544040541117580c175f4e060a445952415650565e45420d07484f555b4b485956565e454203", 9);
    private static final String OoOOooOoooOoo = o0Oo0OO00O0O000ooOO0("164f5a5741451610585e555b185d0e4f1c155c565a4500164e42495409", 25);
    public static final String o00ooooooO00OO0O00 = o0Oo0OO00O0O000ooOO0("141704121c01", 74);
    public static final String o0O00o00OOoOo0oooOoo00 = o0Oo0OO00O0O000ooOO0("35190165400f155a470909131306030b1d110f46025e12070a1c184b5c190d0d195c5a15415a12034b4709141f0c1b1d1b13080f404a050218160605141b1b13080f4e", 68);
    public static final String o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0("3208352e67793c2528333f707c3d26677633343f7a703521362332362125357c3864283d30262271662337372366602f7b602839717d332e25362127212932357a703f38222c3c3f2e212129323574", 126);
    public static final String oO00o0OooO0OO0o0000o = o0Oo0OO00O0O000ooOO0("297f44110a4c0312534d5858424c021158414d1a5f", 15);

    public enum O00OO0oOOooooO00000Oo {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("4b003179693b22707f3e333c3d27687e3b79793421383169306c2035382e2a796e2b3f3f2b6e68277368203179753b262d3e292f29213a3d727837302a243437262929213a3d7c", 100));
        
        private final String o0O00o00OOoOo0oooOoo00;

        private O00OO0oOOooooO00000Oo(String str) {
            this.o0O00o00OOoOo0oooOoo00 = str;
        }

        public String o0Oo0OO00O0O000ooOO0() {
            return this.o0O00o00OOoOo0oooOoo00;
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
                byte b = (byte) (i ^ 88);
                byte b2 = (byte) (bArr[0] ^ Ascii.US);
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
    }

    public enum o0O00o00OOoOo0oooOoo00 {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("3573420a1f5e5c495544581d0c4d404f4e541b0d480a0a47524b421a431f53464b5d590a1d584c4c581d1b54001b53420a0648555e4d5a5c5a52494e010b444359574744555a5a52494e0f", 92));
        
        private final String o0O00o00OOoOo0oooOoo00;

        private o0O00o00OOoOo0oooOoo00(String str) {
            this.o0O00o00OOoOo0oooOoo00 = str;
        }

        public String o0Oo0OO00O0O000ooOO0() {
            return this.o0O00o00OOoOo0oooOoo00;
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
                byte b = (byte) (i ^ 19);
                byte b2 = (byte) (bArr[0] ^ 97);
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
    }

    /* renamed from: com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public enum C0025o0Oo0OO00O0O000ooOO0 {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("1d65544f5a480d11495c4d4f4355", 51)),
        o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("1d1b2a31243673632d323d272f2762267a36232e383c6f783d29293d787e31657e36276f632d303b283f393f372c2b646e21263c322221303f3f372c2b6a", 77)),
        oO00o0OooO0OO0o0000o(o0Oo0OO00O0O000ooOO0("1d30011a0f1d58481b5244091c050c", 102)),
        O00OO0oOOooooO00000Oo(o0Oo0OO00O0O000ooOO0("1d26170c190b4e531611061c1e134351101f12571b470b1e13050152450014140045430c58430b1a525e100d06150204020a111659531c1b010f1f1c0d02020a111657", 112)),
        O0oOO0ooO(o0Oo0OO00O0O000ooOO0("1d7c4d56435114034c56190b4457564709044a031e5b5a495e5a", 42)),
        o00ooooooO00OO0O00(o0Oo0OO00O0O000ooOO0("085d6c242070617a6f7d3822636e61607a3523662424697c656c346d317d6865737724337662627633357a2e357d6c2428667b70637472747c67602f256a6d7779696a7b74747c676021", 6)),
        OO0000O0Ooo0OO000oo(o0Oo0OO00O0O000ooOO0("086d5c141040514a5f4d08155057405a58550517565954115d014d5855434714125a5c57591a5f0c4d1e175e54584702144c404b560b", 54)),
        OoOOooOoooOoo(o0Oo0OO00O0O000ooOO0("1d2c1d06130144541a050a10181055114d0114190f0b585e16101b1556490110584d0110080f140002505e11001d0a0b1e021c17101a145a490652490110585c0c1d0613014a", 122));
        
        private final String O0OoOo00O000;

        private C0025o0Oo0OO00O0O000ooOO0(String str) {
            this.O0OoOo00O000 = str;
        }

        public String o0Oo0OO00O0O000ooOO0() {
            return this.O0OoOo00O000;
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
                byte b = (byte) (i ^ 103);
                byte b2 = (byte) (bArr[0] ^ 92);
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
    }

    static {
        o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0, o0Oo0OO00O0O000ooOO0("2266460f054a501f024c53524f450e024c4c56", 1));
    }

    public static String o0O00o00OOoOo0oooOoo00() {
        return O0OoOo00O000.keySet().toString();
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
            byte b = (byte) (i ^ 74);
            byte b2 = (byte) (bArr[0] ^ 102);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: java.util.Iterator} */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.util.Iterator] */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f6 A[Catch:{ Exception -> 0x0019 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0103 A[Catch:{ Exception -> 0x0019 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String oO00o0OooO0OO0o0000o() {
        /*
            java.util.Map r0 = O0OoOo00O000
            int r1 = r0.size()
            if (r1 != 0) goto L_0x000b
            java.lang.String r0 = ""
            return r0
        L_0x000b:
            monitor-enter(r0)
            java.util.Collection r1 = r0.values()     // Catch:{ all -> 0x0089 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0089 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0089 }
            r2.<init>()     // Catch:{ all -> 0x0089 }
        L_0x0019:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0089 }
            if (r3 == 0) goto L_0x012c
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0089 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0089 }
            if (r4 == 0) goto L_0x002c
            goto L_0x0019
        L_0x002c:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0019 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = "142f3c2a2439"
            r5 = 114(0x72, float:1.6E-43)
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = r4.optString(r3)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = "12292d31"
            r6 = 110(0x6e, float:1.54E-43)
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = r4.optString(r5)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r6 = "156b796e64"
            r7 = 38
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r4 = r4.optString(r6)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r6 = "146073656b76"
            r7 = 61
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r6 = r2.optString(r6)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r8 = "1213170b"
            r9 = 84
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r9)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r8 = r2.optString(r8)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r9 = "157062757f"
            java.lang.String r7 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r7)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r7 = r2.optString(r7)     // Catch:{ Exception -> 0x0019 }
            boolean r9 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0019 }
            r10 = 123(0x7b, float:1.72E-43)
            if (r9 == 0) goto L_0x008c
            java.lang.String r6 = "142635232d30"
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r10)     // Catch:{ Exception -> 0x0019 }
            r2.put(r6, r3)     // Catch:{ Exception -> 0x0019 }
            goto L_0x00b5
        L_0x0089:
            r1 = move-exception
            goto L_0x0193
        L_0x008c:
            boolean r9 = r6.contains(r3)     // Catch:{ Exception -> 0x0019 }
            if (r9 != 0) goto L_0x00b5
            java.lang.String r9 = "142635232d30"
            java.lang.String r9 = o0Oo0OO00O0O000ooOO0((java.lang.String) r9, (int) r10)     // Catch:{ Exception -> 0x0019 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0019 }
            r10.<init>()     // Catch:{ Exception -> 0x0019 }
            r10.append(r6)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r6 = "1a"
            r11 = 30
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r11)     // Catch:{ Exception -> 0x0019 }
            r10.append(r6)     // Catch:{ Exception -> 0x0019 }
            r10.append(r3)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r3 = r10.toString()     // Catch:{ Exception -> 0x0019 }
            r2.put(r9, r3)     // Catch:{ Exception -> 0x0019 }
        L_0x00b5:
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x00c7
            java.lang.String r3 = "1226223e"
            r6 = 97
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r6)     // Catch:{ Exception -> 0x0019 }
        L_0x00c3:
            r2.put(r3, r5)     // Catch:{ Exception -> 0x0019 }
            goto L_0x00f0
        L_0x00c7:
            boolean r3 = r8.contains(r5)     // Catch:{ Exception -> 0x0019 }
            if (r3 != 0) goto L_0x00f0
            java.lang.String r3 = "1203071b"
            r6 = 68
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r6)     // Catch:{ Exception -> 0x0019 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0019 }
            r6.<init>()     // Catch:{ Exception -> 0x0019 }
            r6.append(r8)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r8 = "1a"
            r9 = 13
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r9)     // Catch:{ Exception -> 0x0019 }
            r6.append(r8)     // Catch:{ Exception -> 0x0019 }
            r6.append(r5)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0019 }
            goto L_0x00c3
        L_0x00f0:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0019 }
            if (r3 == 0) goto L_0x0103
            java.lang.String r3 = "155547505a"
            r5 = 24
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)     // Catch:{ Exception -> 0x0019 }
        L_0x00fe:
            r2.put(r3, r4)     // Catch:{ Exception -> 0x0019 }
            goto L_0x0019
        L_0x0103:
            boolean r3 = r7.contains(r4)     // Catch:{ Exception -> 0x0019 }
            if (r3 != 0) goto L_0x0019
            java.lang.String r3 = "153022353f"
            r5 = 125(0x7d, float:1.75E-43)
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)     // Catch:{ Exception -> 0x0019 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0019 }
            r5.<init>()     // Catch:{ Exception -> 0x0019 }
            r5.append(r7)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r6 = "1a"
            r7 = 104(0x68, float:1.46E-43)
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r7)     // Catch:{ Exception -> 0x0019 }
            r5.append(r6)     // Catch:{ Exception -> 0x0019 }
            r5.append(r4)     // Catch:{ Exception -> 0x0019 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0019 }
            goto L_0x00fe
        L_0x012c:
            int r1 = r2.length()     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0136
            java.lang.String r1 = ""
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r1
        L_0x0136:
            java.lang.String r1 = "143724323c21"
            r3 = 106(0x6a, float:1.49E-43)
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r2.optString(r1)     // Catch:{ all -> 0x0089 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0153
            java.lang.String r1 = "144053454b56"
            r3 = 29
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)     // Catch:{ all -> 0x0089 }
            r2.remove(r1)     // Catch:{ all -> 0x0089 }
        L_0x0153:
            java.lang.String r1 = "121a1e02"
            r3 = 93
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r2.optString(r1)     // Catch:{ all -> 0x0089 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0170
            java.lang.String r1 = "127b7f63"
            r3 = 60
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)     // Catch:{ all -> 0x0089 }
            r2.remove(r1)     // Catch:{ all -> 0x0089 }
        L_0x0170:
            java.lang.String r1 = "152f3d2a20"
            r3 = 98
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r2.optString(r1)     // Catch:{ all -> 0x0089 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x018d
            java.lang.String r1 = "156577606a"
            r3 = 40
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r3)     // Catch:{ all -> 0x0089 }
            r2.remove(r1)     // Catch:{ all -> 0x0089 }
        L_0x018d:
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0089 }
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            return r1
        L_0x0193:
            monitor-exit(r0)     // Catch:{ all -> 0x0089 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.shell.common.o0Oo0OO00O0O000ooOO0.oO00o0OooO0OO0o0000o():java.lang.String");
    }

    public enum oO00o0OooO0OO0o0000o {
        o0Oo0OO00O0O000ooOO0(o0Oo0OO00O0O000ooOO0("337373", 53)),
        o0O00o00OOoOo0oooOoo00(o0Oo0OO00O0O000ooOO0("335b5a", 29)),
        oO00o0OooO0OO0o0000o(o0Oo0OO00O0O000ooOO0("332322", 100)),
        O00OO0oOOooooO00000Oo(o0Oo0OO00O0O000ooOO0("337f7d", 56)),
        O0oOO0ooO(o0Oo0OO00O0O000ooOO0("332625", 97)),
        o00ooooooO00OO0O00(o0Oo0OO00O0O000ooOO0("336561", 34)),
        OO0000O0Ooo0OO000oo(o0Oo0OO00O0O000ooOO0("332227", 101)),
        OoOOooOoooOoo(o0Oo0OO00O0O000ooOO0("330b0d", 76)),
        O0OoOo00O000(o0Oo0OO00O0O000ooOO0("337c7b", 59)),
        O0o0o0O0OOOooOo0OOoOOO(o0Oo0OO00O0O000ooOO0("331c14", 91)),
        oO0oOOOOoo(o0Oo0OO00O0O000ooOO0("33343d", 115)),
        o0ooOoo0Oo00oOOO(o0Oo0OO00O0O000ooOO0("333a3a", 126)),
        o0oOO0oO00OoO0(o0Oo0OO00O0O000ooOO0("334041", 4)),
        O0o0o0O0ooOooOoo(o0Oo0OO00O0O000ooOO0("330c0e", 72)),
        Oo0O0Oo0OO0OOOoOO0O0(o0Oo0OO00O0O000ooOO0("332427", 96)),
        oOOO00oO00o0oOoOo(o0Oo0OO00O0O000ooOO0("324d4d", 10)),
        OO000O0O0Oo(o0Oo0OO00O0O000ooOO0("313534", 115)),
        o0Oo0O0o0ooOOo0oO0(o0Oo0OO00O0O000ooOO0("317771", 49)),
        Oo0o000OO(o0Oo0OO00O0O000ooOO0("311314", 85)),
        O0oOoooo0o0o0oOo(o0Oo0OO00O0O000ooOO0("310105", 71)),
        o0ooO0o000Oo0Oo0O0(o0Oo0OO00O0O000ooOO0("316065", 38)),
        oOO0OooO0(o0Oo0OO00O0O000ooOO0("31151f", 83)),
        oO0oo00OooOooOOo(o0Oo0OO00O0O000ooOO0("311c17", 90)),
        O0oo0o00oooo(o0Oo0OO00O0O000ooOO0("312b29", 108)),
        ooooOO0OO0O0OOoo(o0Oo0OO00O0O000ooOO0("317d7e", 58)),
        ooOoOooO(o0Oo0OO00O0O000ooOO0("313e3e", 121)),
        OOoOo00oo0Ooo0o0o0o000(o0Oo0OO00O0O000ooOO0("314a4b", 13)),
        O0OOO0O0OO0oO0oOoO000(o0Oo0OO00O0O000ooOO0("312721", 96)),
        ooOo0oO0O000o0O0O00oo(o0Oo0OO00O0O000ooOO0("312c2b", 107)),
        oO0OOO00(o0Oo0OO00O0O000ooOO0("315256", 21)),
        OOOOO0o0ooo00oOo0(o0Oo0OO00O0O000ooOO0("31797c", 62)),
        O0oOoo0oOo(o0Oo0OO00O0O000ooOO0("311c16", 91)),
        O0oo0OOOOoO(o0Oo0OO00O0O000ooOO0("310e05", 73)),
        Oo0OO00oooO0Ooo000ooOo(o0Oo0OO00O0O000ooOO0("31282a", 104)),
        oOO0Oo000oOO00oo0o0(o0Oo0OO00O0O000ooOO0("311a19", 90));
        
        /* access modifiers changed from: private */
        public final String oO0o0oOoOO0OO;

        private oO00o0OooO0OO0o0000o(String str) {
            this.oO0o0oOoOO0OO = str;
        }

        public String o0Oo0OO00O0O000ooOO0() {
            return this.oO0o0oOoOO0OO;
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
                byte b = (byte) (i ^ 70);
                byte b2 = (byte) (bArr[0] ^ 3);
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
    }

    public static JSONObject o0Oo0OO00O0O000ooOO0(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(o0Oo0OO00O0O000ooOO0("14081b0d031e", 85), th.getLocalizedMessage());
            jSONObject.put(o0Oo0OO00O0O000ooOO0("1252564a", 21), th.getClass().getName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement.getClassName().contains(o0Oo0OO00O0O000ooOO0("051d13524b171617160110171b0b0b1710515e1e1b070c171c", 91))) {
                    jSONObject.put(o0Oo0OO00O0O000ooOO0("153321363c", 126), stackTraceElement.toString());
                    break;
                }
                i++;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static void o0Oo0OO00O0O000ooOO0() {
        O0OoOo00O000.clear();
    }

    public static void o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o) {
        Map map = O0OoOo00O000;
        if (map.containsKey(oo00o0oooo0oo0o0000o.oO0o0oOoOO0OO)) {
            map.remove(oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0());
        }
    }

    public static void o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(o0Oo0OO00O0O000ooOO0("147a697f716c", 39), str);
        } catch (JSONException unused) {
        }
        o0Oo0OO00O0O000ooOO0(oo00o0oooo0oo0o0000o, jSONObject);
    }

    public static void o0Oo0OO00O0O000ooOO0(oO00o0OooO0OO0o0000o oo00o0oooo0oo0o0000o, JSONObject jSONObject) {
        String str;
        String str2;
        Map map = O0OoOo00O000;
        if (map.containsKey(oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0())) {
            if (jSONObject != null) {
                String jSONObject2 = jSONObject.toString();
                String str3 = (String) map.get(oo00o0oooo0oo0o0000o.oO0o0oOoOO0OO);
                if (str3 == null) {
                    map.put(oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0(), jSONObject2);
                    return;
                } else if (!str3.contains(jSONObject2)) {
                    str = ba.r(ba.v(str3), o0Oo0OO00O0O000ooOO0("4a51", 23), jSONObject2);
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (jSONObject != null) {
            str = jSONObject.toString();
        } else {
            str2 = oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0();
            str = o0Oo0OO00O0O000ooOO0("1d54", 24);
            map.put(str2, str);
        }
        str2 = oo00o0oooo0oo0o0000o.o0Oo0OO00O0O000ooOO0();
        map.put(str2, str);
    }
}
