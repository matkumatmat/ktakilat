package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000;

import android.os.Process;
import com.trustdecision.android.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00.o0O00o00OOoOo0oooOoo00;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.CharEncoding;

public class o0oOO0oO00OoO0 {
    private static final Object o0O00o00OOoOo0oooOoo00 = new Object();
    private static final List o0Oo0OO00O0O000ooOO0 = new CopyOnWriteArrayList();

    public static void o0O00o00OOoOo0oooOoo00() {
        List list = o0Oo0OO00O0O000ooOO0;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0043 A[SYNTHETIC, Splitter:B:30:0x0043] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0049 A[SYNTHETIC, Splitter:B:35:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0OO00O0O000ooOO0(java.io.File r6) {
        /*
            r0 = 0
            boolean r1 = r6.exists()     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            if (r1 == 0) goto L_0x0040
            boolean r1 = r6.canRead()     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            if (r1 == 0) goto L_0x0040
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            r1.<init>(r6)     // Catch:{ Exception -> 0x003d, all -> 0x003b }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            int r2 = r1.read(r6)     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            r1.close()     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            r3 = -1
            if (r2 != r3) goto L_0x0024
            r1.close()     // Catch:{ IOException -> 0x0023 }
        L_0x0023:
            return r0
        L_0x0024:
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            java.lang.String r4 = "2c190a530d"
            r5 = 116(0x74, float:1.63E-43)
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            r5 = 0
            r3.<init>(r6, r5, r2, r4)     // Catch:{ Exception -> 0x0039, all -> 0x0036 }
            r1.close()     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            return r3
        L_0x0036:
            r6 = move-exception
            r0 = r1
            goto L_0x0041
        L_0x0039:
            goto L_0x0047
        L_0x003b:
            r6 = move-exception
            goto L_0x0041
        L_0x003d:
            r1 = r0
            goto L_0x0047
        L_0x0040:
            return r0
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r0.close()     // Catch:{ IOException -> 0x0046 }
        L_0x0046:
            throw r6
        L_0x0047:
            if (r1 == 0) goto L_0x004c
            r1.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(java.io.File):java.lang.String");
    }

    public static boolean o0O00o00OOoOo0oooOoo00(File file) {
        return file.delete();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:23|24|25|26|27|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:38|37|(0)|49|50|51) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0065 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x006c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x007a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0083 */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077 A[SYNTHETIC, Splitter:B:40:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0080 A[SYNTHETIC, Splitter:B:47:0x0080] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o0Oo0OO00O0O000ooOO0(java.lang.String r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream
            r7.<init>()
            boolean r1 = r0.exists()
            r2 = 0
            if (r1 == 0) goto L_0x0086
            boolean r1 = r0.canRead()
            if (r1 == 0) goto L_0x0086
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0072, all -> 0x0070 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0072, all -> 0x0070 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x002f, all -> 0x002c }
        L_0x0020:
            int r3 = r1.read(r0)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r4 = -1
            if (r3 == r4) goto L_0x0031
            r4 = 0
            r7.write(r0, r4, r3)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            goto L_0x0020
        L_0x002c:
            r0 = move-exception
            r2 = r1
            goto L_0x0075
        L_0x002f:
            goto L_0x007e
        L_0x0031:
            byte[] r0 = r7.toByteArray()     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0069
            int r4 = r0.length     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            if (r4 != 0) goto L_0x003d
            goto L_0x0069
        L_0x003d:
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r5 = "2c7e6d346a"
            r6 = 19
            java.lang.String r5 = o0Oo0OO00O0O000ooOO0((java.lang.String) r5, (int) r6)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r4.<init>(r0, r5)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r0 = "0561"
            r5 = 63
            java.lang.String r0 = o0Oo0OO00O0O000ooOO0((java.lang.String) r0, (int) r5)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r0 = r4.replaceAll(r0, r3)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r4 = "79"
            r5 = 72
            java.lang.String r4 = o0Oo0OO00O0O000ooOO0((java.lang.String) r4, (int) r5)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.String r0 = r0.replaceAll(r4, r3)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r1.close()     // Catch:{ IOException -> 0x0065 }
        L_0x0065:
            r7.close()     // Catch:{ IOException -> 0x0068 }
        L_0x0068:
            return r0
        L_0x0069:
            r1.close()     // Catch:{ IOException -> 0x006c }
        L_0x006c:
            r7.close()     // Catch:{ IOException -> 0x006f }
        L_0x006f:
            return r3
        L_0x0070:
            r0 = move-exception
            goto L_0x0075
        L_0x0072:
            r1 = r2
            goto L_0x007e
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.close()     // Catch:{ IOException -> 0x007a }
        L_0x007a:
            r7.close()     // Catch:{ IOException -> 0x007d }
        L_0x007d:
            throw r0
        L_0x007e:
            if (r1 == 0) goto L_0x0083
            r1.close()     // Catch:{ IOException -> 0x0083 }
        L_0x0083:
            r7.close()     // Catch:{ IOException -> 0x0086 }
        L_0x0086:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(java.lang.String):java.lang.String");
    }

    public static byte[] o0O00o00OOoOo0oooOoo00(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream2);
            } catch (Exception unused) {
                fileInputStream = fileInputStream2;
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream);
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream);
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception unused2) {
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream);
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream);
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(byteArrayOutputStream);
            throw th;
        }
        o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
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
            byte b = (byte) (i ^ 108);
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

    public static List o0Oo0OO00O0O000ooOO0() {
        int i = 0;
        synchronized (o0O00o00OOoOo0oooOoo00) {
            List list = o0Oo0OO00O0O000ooOO0;
            if (!list.isEmpty()) {
                return list;
            }
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(String.format(Locale.US, o0Oo0OO00O0O000ooOO0("763469766727612a2029677a68", 7), new Object[]{Integer.valueOf(Process.myPid())})));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            if (i >= 10240) {
                                break;
                            }
                            o0Oo0OO00O0O000ooOO0.add(readLine);
                            i++;
                        }
                    } catch (Throwable unused) {
                        bufferedReader = bufferedReader2;
                        o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(bufferedReader);
                        List list2 = o0Oo0OO00O0O000ooOO0;
                        return list2;
                    }
                }
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(bufferedReader2);
            } catch (Throwable unused2) {
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(bufferedReader);
                List list22 = o0Oo0OO00O0O000ooOO0;
                return list22;
            }
            List list222 = o0Oo0OO00O0O000ooOO0;
            return list222;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009b A[SYNTHETIC, Splitter:B:38:0x009b] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1 A[SYNTHETIC, Splitter:B:43:0x00a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map o0Oo0OO00O0O000ooOO0(java.lang.String r6, java.util.List r7, java.lang.String r8) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r6 == 0) goto L_0x00a4
            if (r7 == 0) goto L_0x00a4
            java.io.File r1 = new java.io.File
            r1.<init>(r6)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x00a4
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            r4.<init>(r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            java.lang.String r6 = "2c27346d33"
            r5 = 74
            java.lang.String r6 = o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (int) r5)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            r3.<init>(r4, r6)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0097, all -> 0x0095 }
        L_0x002c:
            java.lang.String r6 = r2.readLine()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r6 == 0) goto L_0x008e
            boolean r1 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r8)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r1 != 0) goto L_0x0074
            java.util.List r6 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oo0o00oooo.o0Oo0OO00O0O000ooOO0((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            boolean r1 = r6.isEmpty()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r1 != 0) goto L_0x002c
            r1 = 0
            java.lang.Object r1 = r6.get(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            int r3 = r1.length()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r3 == 0) goto L_0x002c
            boolean r3 = r7.contains(r1)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r3 == 0) goto L_0x002c
            int r3 = r6.size()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r4 = 1
            if (r3 <= r4) goto L_0x002c
            java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r6 = r6.trim()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r0.put(r1, r6)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            goto L_0x002c
        L_0x006e:
            r6 = move-exception
            r1 = r2
            goto L_0x0099
        L_0x0071:
            r1 = r2
            goto L_0x009f
        L_0x0074:
            java.util.Iterator r1 = r7.iterator()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
        L_0x0078:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            boolean r4 = r6.contains(r3)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            if (r4 == 0) goto L_0x0078
            r0.put(r3, r6)     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            goto L_0x0078
        L_0x008e:
            r2.close()     // Catch:{ Exception -> 0x0071, all -> 0x006e }
            r2.close()     // Catch:{ IOException -> 0x00a4 }
            goto L_0x00a4
        L_0x0095:
            r6 = move-exception
            goto L_0x0099
        L_0x0097:
            goto L_0x009f
        L_0x0099:
            if (r1 == 0) goto L_0x009e
            r1.close()     // Catch:{ IOException -> 0x009e }
        L_0x009e:
            throw r6
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            r1.close()     // Catch:{ IOException -> 0x00a4 }
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(java.lang.String, java.util.List, java.lang.String):java.util.Map");
    }

    public static boolean o0Oo0OO00O0O000ooOO0(File file, File file2) {
        return o0Oo0OO00O0O000ooOO0(file.getAbsolutePath(), file2.getAbsolutePath());
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d A[SYNTHETIC, Splitter:B:35:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[SYNTHETIC, Splitter:B:40:0x0093] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean o0Oo0OO00O0O000ooOO0(java.io.File r7, java.lang.String r8) {
        /*
            r0 = 2
            r1 = 1
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            java.lang.String r5 = r7.toString()     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            if (r5 != 0) goto L_0x001d
            r4.createNewFile()     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            goto L_0x001d
        L_0x0017:
            r7 = move-exception
            goto L_0x008b
        L_0x001a:
            goto L_0x0091
        L_0x001d:
            boolean r4 = r7.canWrite()     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            if (r4 == 0) goto L_0x008a
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r4.<init>(r7)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            if (r8 != 0) goto L_0x002e
            r4.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            return r2
        L_0x002e:
            java.lang.String r3 = "2c27346d33"
            r5 = 74
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            byte[] r8 = r8.getBytes(r3)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r4.write(r8)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r8 = 9
            boolean r8 = com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.O0oOoooo0o0o0oOo.o0O00o00OOoOo0oooOoo00(r8)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r8 == 0) goto L_0x0061
            boolean r8 = r7.setReadable(r1, r2)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r8 != 0) goto L_0x0086
            java.lang.String r7 = r7.getAbsolutePath()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            int r8 = android.system.OsConstants.S_IRUSR     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            int r0 = android.system.OsConstants.S_IRGRP     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r8 = r8 | r0
            int r0 = android.system.OsConstants.S_IROTH     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r8 = r8 | r0
            android.system.Os.chmod(r7, r8)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            goto L_0x0086
        L_0x005b:
            r7 = move-exception
            r3 = r4
            goto L_0x008b
        L_0x005e:
            r3 = r4
            goto L_0x0091
        L_0x0061:
            java.lang.Class r8 = r7.getClass()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r3 = "2a5057607142434345484f"
            r5 = 42
            java.lang.String r3 = o0Oo0OO00O0O000ooOO0((java.lang.String) r3, (int) r5)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.Class r6 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r5[r2] = r6     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r5[r1] = r6     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.reflect.Method r8 = r8.getMethod(r3, r5)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r0[r2] = r3     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.Boolean r3 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r0[r1] = r3     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r8.invoke(r7, r0)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
        L_0x0086:
            r4.close()     // Catch:{ IOException -> 0x0089 }
        L_0x0089:
            return r1
        L_0x008a:
            return r2
        L_0x008b:
            if (r3 == 0) goto L_0x0090
            r3.close()     // Catch:{ IOException -> 0x0090 }
        L_0x0090:
            throw r7
        L_0x0091:
            if (r3 == 0) goto L_0x0096
            r3.close()     // Catch:{ IOException -> 0x0096 }
        L_0x0096:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.O0OoOo00O000.o0oOO0oO00OoO0.o0Oo0OO00O0O000ooOO0(java.io.File, java.lang.String):boolean");
    }

    public static boolean o0Oo0OO00O0O000ooOO0(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
            } catch (Throwable unused) {
                fileOutputStream = null;
                fileInputStream = fileInputStream2;
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream);
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileOutputStream);
                return false;
            }
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream2);
                        o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileOutputStream);
                        return true;
                    }
                }
            } catch (Throwable unused2) {
                fileInputStream = fileInputStream2;
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream);
                o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileOutputStream);
                return false;
            }
        } catch (Throwable unused3) {
            fileOutputStream = null;
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileInputStream);
            o0O00o00OOoOo0oooOoo00.o0Oo0OO00O0O000ooOO0(fileOutputStream);
            return false;
        }
    }
}
