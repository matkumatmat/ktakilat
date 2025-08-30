package com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.oO00o0OooO0OO0o0000o;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.commons.lang3.CharEncoding;

public class o0Oo0OO00O0O000ooOO0 implements oO00o0OooO0OO0o0000o.o0Oo0OO00O0O000ooOO0 {

    /* renamed from: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0  reason: collision with other inner class name */
    public static class C0017o0Oo0OO00O0O000ooOO0 {
        public ZipEntry o0O00o00OOoOo0oooOoo00;
        public ZipFile o0Oo0OO00O0O000ooOO0;

        public C0017o0Oo0OO00O0O000ooOO0(ZipFile zipFile, ZipEntry zipEntry) {
            this.o0Oo0OO00O0O000ooOO0 = zipFile;
            this.o0O00o00OOoOo0oooOoo00 = zipEntry;
        }
    }

    private long o0Oo0OO00O0O000ooOO0(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x004d A[LOOP:0: B:1:0x0003->B:25:0x004d, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o0O00o00OOoOo0oooOoo00(android.content.Context r7, java.lang.String[] r8, java.lang.String r9, java.io.File r10, com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.O00OO0oOOooooO00000Oo r11) {
        /*
            r6 = this;
            int r11 = r8.length
            r0 = 0
            r1 = 0
        L_0x0003:
            if (r1 >= r11) goto L_0x0050
            r2 = r8[r1]
            java.lang.StringBuilder r2 = defpackage.ba.v(r2)
            char r3 = java.io.File.separatorChar
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r3 = 0
            android.content.res.AssetManager r4 = r7.getAssets()     // Catch:{ all -> 0x003e }
            java.io.InputStream r2 = r4.open(r2)     // Catch:{ all -> 0x003e }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x003c }
            r4.<init>(r10)     // Catch:{ all -> 0x003c }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0033 }
        L_0x0029:
            int r5 = r2.read(r3)     // Catch:{ all -> 0x0033 }
            if (r5 <= 0) goto L_0x0035
            r4.write(r3, r0, r5)     // Catch:{ all -> 0x0033 }
            goto L_0x0029
        L_0x0033:
            r3 = r2
            goto L_0x003f
        L_0x0035:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r2)
        L_0x0038:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r4)
            goto L_0x0043
        L_0x003c:
            r4 = r3
            goto L_0x0033
        L_0x003e:
            r4 = r3
        L_0x003f:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r3)
            goto L_0x0038
        L_0x0043:
            r6.o0Oo0OO00O0O000ooOO0((java.io.File) r10)
            boolean r2 = r10.exists()
            if (r2 == 0) goto L_0x004d
            return
        L_0x004d:
            int r1 = r1 + 1
            goto L_0x0003
        L_0x0050:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.o0O00o00OOoOo0oooOoo00(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.O00OO0oOOooooO00000Oo):void");
    }

    private C0017o0Oo0OO00O0O000ooOO0 o0Oo0OO00O0O000ooOO0(Context context, String[] strArr, String str, O00OO0oOOooooO00000Oo o00OO0oOOooooO00000Oo) {
        String[] strArr2 = strArr;
        String str2 = str;
        String[] o0Oo0OO00O0O000ooOO0 = o0Oo0OO00O0O000ooOO0(context);
        int length = o0Oo0OO00O0O000ooOO0.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str3 = o0Oo0OO00O0O000ooOO0[i];
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str3), 1);
                    break;
                } catch (IOException unused) {
                    i2 = i3;
                }
            }
            if (zipFile != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < 5) {
                        for (String str4 : strArr2) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(o0Oo0OO00O0O000ooOO0("0c4e40", 86));
                            char c = File.separatorChar;
                            sb.append(c);
                            sb.append(str4);
                            sb.append(c);
                            sb.append(str2);
                            ZipEntry entry = zipFile.getEntry(sb.toString());
                            if (entry == null) {
                                entry = zipFile.getEntry(o0Oo0OO00O0O000ooOO0("015745535442", 88) + c + str4 + c + str2);
                            }
                            if (entry != null) {
                                return new C0017o0Oo0OO00O0O000ooOO0(zipFile, entry);
                            }
                        }
                        i4 = i5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
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
            byte b = (byte) (i ^ 29);
            byte b2 = (byte) (bArr[0] ^ 96);
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r7 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        r0 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x008b, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r7 = new java.lang.String[]{r7.toString()};
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x0042, B:59:0x0086] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x009d A[SYNTHETIC, Splitter:B:68:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o0Oo0OO00O0O000ooOO0(android.content.Context r7, java.lang.String[] r8, java.lang.String r9, java.io.File r10, com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.O00OO0oOOooooO00000Oo r11) {
        /*
            r6 = this;
            r0 = 0
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0$o0Oo0OO00O0O000ooOO0 r11 = r6.o0Oo0OO00O0O000ooOO0(r7, r8, r9, r11)     // Catch:{ all -> 0x009a }
            if (r11 == 0) goto L_0x0086
            r7 = 0
        L_0x0008:
            int r8 = r7 + 1
            r9 = 5
            if (r7 >= r9) goto L_0x007e
            boolean r7 = r10.exists()     // Catch:{ IOException -> 0x001f }
            if (r7 != 0) goto L_0x0022
            boolean r7 = r10.createNewFile()     // Catch:{ IOException -> 0x001f }
            if (r7 != 0) goto L_0x0022
            goto L_0x007c
        L_0x001b:
            r7 = move-exception
            r0 = r11
            goto L_0x009b
        L_0x001f:
            goto L_0x007c
        L_0x0022:
            java.util.zip.ZipFile r7 = r11.o0Oo0OO00O0O000ooOO0     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0067, all -> 0x0064 }
            java.util.zip.ZipEntry r9 = r11.o0O00o00OOoOo0oooOoo00     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0067, all -> 0x0064 }
            java.io.InputStream r7 = r7.getInputStream(r9)     // Catch:{ FileNotFoundException -> 0x006a, IOException -> 0x0067, all -> 0x0064 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060, all -> 0x005d }
            r9.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060, all -> 0x005d }
            long r1 = r6.o0Oo0OO00O0O000ooOO0((java.io.InputStream) r7, (java.io.OutputStream) r9)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0074, all -> 0x005a }
            java.io.FileDescriptor r3 = r9.getFD()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0074, all -> 0x005a }
            r3.sync()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0074, all -> 0x005a }
            long r3 = r10.length()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0074, all -> 0x005a }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0049
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r7)     // Catch:{ all -> 0x001b }
        L_0x0045:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r9)     // Catch:{ all -> 0x001b }
            goto L_0x007c
        L_0x0049:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r7)     // Catch:{ all -> 0x001b }
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r9)     // Catch:{ all -> 0x001b }
            r6.o0Oo0OO00O0O000ooOO0((java.io.File) r10)     // Catch:{ all -> 0x001b }
            java.util.zip.ZipFile r7 = r11.o0Oo0OO00O0O000ooOO0     // Catch:{ IOException -> 0x0059 }
            if (r7 == 0) goto L_0x0059
            r7.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            return
        L_0x005a:
            r8 = move-exception
        L_0x005b:
            r0 = r7
            goto L_0x006d
        L_0x005d:
            r8 = move-exception
            r9 = r0
            goto L_0x005b
        L_0x0060:
            r9 = r0
            goto L_0x0074
        L_0x0062:
            r9 = r0
            goto L_0x0078
        L_0x0064:
            r8 = move-exception
            r9 = r0
            goto L_0x006d
        L_0x0067:
            r7 = r0
            r9 = r7
            goto L_0x0074
        L_0x006a:
            r7 = r0
            r9 = r7
            goto L_0x0078
        L_0x006d:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r0)     // Catch:{ all -> 0x001b }
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r9)     // Catch:{ all -> 0x001b }
            throw r8     // Catch:{ all -> 0x001b }
        L_0x0074:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r7)     // Catch:{ all -> 0x001b }
            goto L_0x0045
        L_0x0078:
            r6.o0Oo0OO00O0O000ooOO0((java.io.Closeable) r7)     // Catch:{ all -> 0x001b }
            goto L_0x0045
        L_0x007c:
            r7 = r8
            goto L_0x0008
        L_0x007e:
            java.util.zip.ZipFile r7 = r11.o0Oo0OO00O0O000ooOO0     // Catch:{ IOException -> 0x0085 }
            if (r7 == 0) goto L_0x0085
            r7.close()     // Catch:{ IOException -> 0x0085 }
        L_0x0085:
            return
        L_0x0086:
            java.lang.String[] r7 = r6.o0Oo0OO00O0O000ooOO0((android.content.Context) r7, (java.lang.String) r9)     // Catch:{ Exception -> 0x008b }
            goto L_0x0094
        L_0x008b:
            r7 = move-exception
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x001b }
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ all -> 0x001b }
        L_0x0094:
            com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0O00o00OOoOo0oooOoo00 r10 = new com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0O00o00OOoOo0oooOoo00     // Catch:{ all -> 0x001b }
            r10.<init>(r9, r8, r7)     // Catch:{ all -> 0x001b }
            throw r10     // Catch:{ all -> 0x001b }
        L_0x009a:
            r7 = move-exception
        L_0x009b:
            if (r0 == 0) goto L_0x00a4
            java.util.zip.ZipFile r8 = r0.o0Oo0OO00O0O000ooOO0     // Catch:{ IOException -> 0x00a4 }
            if (r8 == 0) goto L_0x00a4
            r8.close()     // Catch:{ IOException -> 0x00a4 }
        L_0x00a4:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(android.content.Context, java.lang.String[], java.lang.String, java.io.File, com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.O00OO0oOOooooO00000Oo):void");
    }

    private void o0Oo0OO00O0O000ooOO0(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void o0Oo0OO00O0O000ooOO0(File file) {
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
    }

    private String[] o0Oo0OO00O0O000ooOO0(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String[] o0Oo0OO00O0O000ooOO0(android.content.Context r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "0c3b3520232c3e282f39"
            r2 = 35
            java.lang.String r1 = o0Oo0OO00O0O000ooOO0((java.lang.String) r1, (int) r2)
            r0.append(r1)
            char r1 = java.io.File.separatorChar
            r0.append(r1)
            java.lang.String r2 = "48186e69"
            r3 = 118(0x76, float:1.65E-43)
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            r0.append(r2)
            r0.append(r1)
            java.lang.String r2 = "3d5723"
            r3 = 61
            java.lang.String r2 = o0Oo0OO00O0O000ooOO0((java.lang.String) r2, (int) r3)
            r0.append(r2)
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.util.regex.Pattern r12 = java.util.regex.Pattern.compile(r12)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.lang.String[] r11 = r10.o0Oo0OO00O0O000ooOO0((android.content.Context) r11)
            int r1 = r11.length
            r2 = 0
        L_0x0047:
            if (r2 >= r1) goto L_0x0095
            r3 = r11[r2]
            java.util.zip.ZipFile r4 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x0092 }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x0092 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0092 }
            r3 = 1
            r4.<init>(r5, r3)     // Catch:{ IOException -> 0x0092 }
            java.util.Enumeration r5 = r4.entries()
        L_0x005a:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto L_0x008f
            java.lang.Object r6 = r5.nextElement()
            java.util.zip.ZipEntry r6 = (java.util.zip.ZipEntry) r6
            java.lang.String r7 = r6.getName()
            java.lang.String r8 = "4e7372"
            r9 = 110(0x6e, float:1.54E-43)
            java.lang.String r8 = o0Oo0OO00O0O000ooOO0((java.lang.String) r8, (int) r9)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x0079
            goto L_0x005a
        L_0x0079:
            java.lang.String r6 = r6.getName()
            java.util.regex.Matcher r6 = r12.matcher(r6)
            boolean r7 = r6.matches()
            if (r7 == 0) goto L_0x005a
            java.lang.String r6 = r6.group(r3)
            r0.add(r6)
            goto L_0x005a
        L_0x008f:
            r4.close()     // Catch:{  }
        L_0x0092:
            int r2 = r2 + 1
            goto L_0x0047
        L_0x0095:
            int r11 = r0.size()
            java.lang.String[] r11 = new java.lang.String[r11]
            java.lang.Object[] r11 = r0.toArray(r11)
            java.lang.String[] r11 = (java.lang.String[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.trustdecision.android.o0O00o00OOoOo0oooOoo00.OoOOooOoooOoo.o0Oo0OO00O0O000ooOO0.o0Oo0OO00O0O000ooOO0(android.content.Context, java.lang.String):java.lang.String[]");
    }
}
