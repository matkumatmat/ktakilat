package com.baidu.idl.main.facesdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileUitls {
    public static boolean assetOpen(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getAssets().open(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void deleteLicense(Context context, String str) {
        File file = new File(context.getFilesDir().getParent() + RemoteSettings.FORWARD_SLASH_STRING + str);
        if (file.exists()) {
            file.delete();
        }
        File dir = context.getDir(str, 0);
        if (dir != null && dir.exists()) {
            dir.delete();
        }
    }

    public static boolean fileIsExists(String str) {
        try {
            if (!new File(str).exists()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public static File getBatchFaceDirectory(String str) {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, str);
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002a A[SYNTHETIC, Splitter:B:20:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0035 A[SYNTHETIC, Splitter:B:26:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap getBitmap(android.content.Context r1, java.lang.String r2) {
        /*
            r0 = 0
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ Exception -> 0x0023, all -> 0x0021 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x001f }
            if (r1 == 0) goto L_0x001b
            r1.close()     // Catch:{ IOException -> 0x0017 }
            goto L_0x001b
        L_0x0017:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001b:
            return r2
        L_0x001c:
            r2 = move-exception
            r0 = r1
            goto L_0x0033
        L_0x001f:
            r2 = move-exception
            goto L_0x0025
        L_0x0021:
            r2 = move-exception
            goto L_0x0033
        L_0x0023:
            r2 = move-exception
            r1 = r0
        L_0x0025:
            r2.printStackTrace()     // Catch:{ all -> 0x001c }
            if (r1 == 0) goto L_0x0032
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0032:
            return r0
        L_0x0033:
            if (r0 == 0) goto L_0x003d
            r0.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.getBitmap(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static byte[] getByteArrayFromAssets(Context context, String str) {
        byte[] bArr = null;
        try {
            InputStream open = context.getAssets().open(str);
            bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (IOException e) {
            Log.e("zq", "e-->" + e.getMessage());
            e.printStackTrace();
            return bArr;
        }
    }

    public static File getFaceDirectory() {
        File sDRootFile = getSDRootFile();
        if (sDRootFile == null || !sDRootFile.exists()) {
            return null;
        }
        File file = new File(sDRootFile, "faces");
        if (file.exists()) {
            return file;
        }
        file.mkdirs();
        return file;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        if (r3 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r3 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0067, code lost:
        if (r3 == null) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035 A[SYNTHETIC, Splitter:B:20:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getModelContent(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            byte[] r0 = new byte[r0]
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 == 0) goto L_0x0044
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f, all -> 0x002d }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0031, IOException -> 0x002f, all -> 0x002d }
            int r1 = r2.available()     // Catch:{ FileNotFoundException -> 0x002a, IOException -> 0x0027, all -> 0x0024 }
            byte[] r0 = new byte[r1]     // Catch:{ FileNotFoundException -> 0x002a, IOException -> 0x0027, all -> 0x0024 }
            r2.read(r0)     // Catch:{ FileNotFoundException -> 0x002a, IOException -> 0x0027, all -> 0x0024 }
            r2.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0022
        L_0x0021:
        L_0x0022:
            r3 = r2
            goto L_0x0044
        L_0x0024:
            r4 = move-exception
            r3 = r2
            goto L_0x0033
        L_0x0027:
            r3 = r2
            goto L_0x0039
        L_0x002a:
            r3 = r2
            goto L_0x0041
        L_0x002d:
            r4 = move-exception
            goto L_0x0033
        L_0x002f:
            goto L_0x0039
        L_0x0031:
            goto L_0x0041
        L_0x0033:
            if (r3 == 0) goto L_0x0038
            r3.close()     // Catch:{ IOException -> 0x0038 }
        L_0x0038:
            throw r4
        L_0x0039:
            if (r3 == 0) goto L_0x0044
        L_0x003b:
            r3.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0044
        L_0x003f:
            goto L_0x0044
        L_0x0041:
            if (r3 == 0) goto L_0x0044
            goto L_0x003b
        L_0x0044:
            int r1 = r0.length
            if (r1 <= 0) goto L_0x0048
            return r0
        L_0x0048:
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ IOException -> 0x0063 }
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ IOException -> 0x0063 }
            java.io.InputStream r3 = r4.open(r5)     // Catch:{ IOException -> 0x0063 }
            int r4 = r3.available()     // Catch:{ IOException -> 0x0063 }
            byte[] r0 = new byte[r4]     // Catch:{ IOException -> 0x0063 }
            r3.read(r0)     // Catch:{ IOException -> 0x0063 }
        L_0x005d:
            r3.close()     // Catch:{ IOException -> 0x006a }
            goto L_0x006a
        L_0x0061:
            r4 = move-exception
            goto L_0x006b
        L_0x0063:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0061 }
            if (r3 == 0) goto L_0x006a
            goto L_0x005d
        L_0x006a:
            return r0
        L_0x006b:
            if (r3 == 0) goto L_0x0070
            r3.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.getModelContent(android.content.Context, java.lang.String):byte[]");
    }

    public static String getSDPath() {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = Environment.getExternalStorageDirectory();
        } else {
            file = null;
        }
        if (file != null) {
            return file.toString();
        }
        return null;
    }

    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String readFile(String str) {
        File file = new File(str);
        String str2 = "";
        if (!file.isDirectory()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    str2 = readLine;
                }
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return str2;
    }

    public static ArrayList<String> readLicense(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(str);
        if (!file.isDirectory()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                fileInputStream.close();
            } catch (FileNotFoundException unused) {
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[SYNTHETIC, Splitter:B:18:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[SYNTHETIC, Splitter:B:23:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveFile(java.io.File r2, android.graphics.Bitmap r3) {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x001f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x001f }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r0 = 100
            r3.compress(r2, r0, r1)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r1.close()     // Catch:{ Exception -> 0x0011 }
            goto L_0x0015
        L_0x0011:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0015:
            r2 = 1
            return r2
        L_0x0017:
            r2 = move-exception
            r0 = r1
            goto L_0x002f
        L_0x001a:
            r2 = move-exception
            r0 = r1
            goto L_0x0020
        L_0x001d:
            r2 = move-exception
            goto L_0x002f
        L_0x001f:
            r2 = move-exception
        L_0x0020:
            r2.printStackTrace()     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x002d
            r0.close()     // Catch:{ Exception -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002d:
            r2 = 0
            return r2
        L_0x002f:
            if (r0 == 0) goto L_0x0039
            r0.close()     // Catch:{ Exception -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0039:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.saveFile(java.io.File, android.graphics.Bitmap):boolean");
    }
}
