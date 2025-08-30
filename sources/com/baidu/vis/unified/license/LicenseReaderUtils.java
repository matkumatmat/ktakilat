package com.baidu.vis.unified.license;

import android.content.Context;
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

class LicenseReaderUtils {
    public static final String TAG = "License-SDK";

    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0052 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0065 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getSuccessInfo(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "License-SDK"
            java.lang.String r1 = "reade_success_content FileNotFoundException "
            java.lang.String r2 = "reade_success_content IOException "
            java.lang.String r3 = "reade_success_content Exception "
            r4 = 0
            if (r7 == 0) goto L_0x0081
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 == 0) goto L_0x0013
            goto L_0x0081
        L_0x0013:
            java.io.FileInputStream r7 = read_license_from_data(r7, r8)
            if (r7 == 0) goto L_0x0081
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0052, Exception -> 0x0032 }
            r5.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0052, Exception -> 0x0032 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0052, Exception -> 0x0032 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0052, Exception -> 0x0032 }
            java.lang.String r4 = r6.readLine()     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0052, Exception -> 0x0032 }
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0081
        L_0x002b:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0081
        L_0x0030:
            r8 = move-exception
            goto L_0x0078
        L_0x0032:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r2.<init>(r3)     // Catch:{ all -> 0x0030 }
            r2.append(r8)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = " "
            r2.append(r8)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r1.getMessage()     // Catch:{ all -> 0x0030 }
            r2.append(r8)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0030 }
            android.util.Log.e(r0, r8)     // Catch:{ all -> 0x0030 }
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0081
        L_0x0052:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ all -> 0x0030 }
            r1.append(r8)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0030 }
            android.util.Log.e(r0, r8)     // Catch:{ all -> 0x0030 }
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0081
        L_0x0065:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r2.<init>(r1)     // Catch:{ all -> 0x0030 }
            r2.append(r8)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x0030 }
            android.util.Log.e(r0, r8)     // Catch:{ all -> 0x0030 }
            r7.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0081
        L_0x0078:
            r7.close()     // Catch:{ IOException -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0080:
            throw r8
        L_0x0081:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseReaderUtils.getSuccessInfo(android.content.Context, java.lang.String):java.lang.String");
    }

    public static InputStream get_local_license_file_inputstream(Context context, String str, ReadStatusCode readStatusCode) {
        FileInputStream fileInputStream;
        if (context == null) {
            return null;
        }
        readStatusCode.is_from_asset = false;
        if (str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            fileInputStream = read_license_from_system_path(str);
        } else {
            fileInputStream = read_license_from_data(context, str);
        }
        if (fileInputStream != null) {
            return fileInputStream;
        }
        Log.e("License-SDK", "read_license_from_asset");
        InputStream read_license_from_asset = read_license_from_asset(context, str);
        readStatusCode.is_from_asset = true;
        return read_license_from_asset;
    }

    private static ArrayList<String> read_license_content(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    private static InputStream read_license_from_asset(Context context, String str) {
        if (context == null) {
            Log.e("License-SDK", "read_license_from_asset context is null");
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (IOException e) {
            Log.e("License-SDK", "read_license_from_asset IOException");
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            Log.e("License-SDK", "read_license_from_asset Exception " + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    private static FileInputStream read_license_from_data(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            File dir = context.getDir(str, 0);
            if (dir != null && dir.exists()) {
                if (dir.isFile()) {
                    if (dir.length() != 0) {
                        return new FileInputStream(dir);
                    }
                    Log.e("License-SDK", "read_license_from_data file is empty");
                    return null;
                }
            }
            Log.e("License-SDK", "read_license_from_data file not found");
            return null;
        } catch (FileNotFoundException e) {
            Log.e("License-SDK", "read_license_from_data FileNotFoundException");
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            Log.e("License-SDK", "read_license_from_data Exception " + e2.getMessage());
            e2.printStackTrace();
            return null;
        }
    }

    private static FileInputStream read_license_from_system_path(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e) {
            Log.e("License-SDK", "read_license_from_system_path FileNotFoundException");
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x006f A[SYNTHETIC, Splitter:B:42:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007e A[SYNTHETIC, Splitter:B:48:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0084 A[SYNTHETIC, Splitter:B:51:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int setSuccessInfo(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = -1
            if (r4 == 0) goto L_0x008d
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L_0x008d
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L_0x0011
            goto L_0x008d
        L_0x0011:
            r1 = 0
            java.io.File r4 = r4.getDir(r5, r1)
            if (r4 == 0) goto L_0x0021
            boolean r5 = r4.exists()
            if (r5 == 0) goto L_0x0021
            r4.delete()
        L_0x0021:
            java.lang.String r5 = "License-SDK"
            if (r4 == 0) goto L_0x0039
            boolean r2 = r4.exists()
            if (r2 != 0) goto L_0x0039
            r4.createNewFile()     // Catch:{ IOException -> 0x002f }
            goto L_0x0039
        L_0x002f:
            r2 = move-exception
            java.lang.String r3 = "write_success_info_content IOException"
            android.util.Log.e(r5, r3)
            r2.printStackTrace()
        L_0x0039:
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0062, IOException -> 0x0060 }
            byte[] r4 = r6.getBytes()     // Catch:{ FileNotFoundException -> 0x005b, IOException -> 0x0058, all -> 0x0055 }
            r3.write(r4)     // Catch:{ FileNotFoundException -> 0x005b, IOException -> 0x0058, all -> 0x0055 }
            r4 = 10
            r3.write(r4)     // Catch:{ FileNotFoundException -> 0x005b, IOException -> 0x0058, all -> 0x0055 }
            r3.close()     // Catch:{ IOException -> 0x0050 }
            r0 = 0
            goto L_0x0081
        L_0x0050:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0081
        L_0x0055:
            r4 = move-exception
            r2 = r3
            goto L_0x0082
        L_0x0058:
            r4 = move-exception
            r2 = r3
            goto L_0x0064
        L_0x005b:
            r4 = move-exception
            r2 = r3
            goto L_0x0073
        L_0x005e:
            r4 = move-exception
            goto L_0x0082
        L_0x0060:
            r4 = move-exception
            goto L_0x0064
        L_0x0062:
            r4 = move-exception
            goto L_0x0073
        L_0x0064:
            java.lang.String r6 = "write_success_content IOException"
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x005e }
            r4.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0081
        L_0x0073:
            java.lang.String r6 = "write_success_content FileNotFoundException"
            android.util.Log.e(r5, r6)     // Catch:{ all -> 0x005e }
            r4.printStackTrace()     // Catch:{ all -> 0x005e }
            if (r2 == 0) goto L_0x0081
            r2.close()     // Catch:{ IOException -> 0x0050 }
        L_0x0081:
            return r0
        L_0x0082:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008c:
            throw r4
        L_0x008d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseReaderUtils.setSuccessInfo(android.content.Context, java.lang.String, java.lang.String):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x007e A[SYNTHETIC, Splitter:B:43:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d A[SYNTHETIC, Splitter:B:49:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0093 A[SYNTHETIC, Splitter:B:52:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean write_license_content(android.content.Context r4, java.lang.String r5, java.util.ArrayList<java.lang.String> r6) {
        /*
            java.lang.String r0 = "write_license_content"
            java.lang.String r1 = "License-SDK"
            android.util.Log.e(r1, r0)
            r0 = 0
            if (r6 == 0) goto L_0x009c
            int r2 = r6.size()
            if (r2 == 0) goto L_0x009c
            if (r4 != 0) goto L_0x0015
            goto L_0x009c
        L_0x0015:
            java.io.File r4 = r4.getDir(r5, r0)
            if (r4 == 0) goto L_0x0024
            boolean r5 = r4.exists()
            if (r5 == 0) goto L_0x0024
            r4.delete()
        L_0x0024:
            java.lang.String r5 = "write_license_content IOException"
            if (r4 == 0) goto L_0x003a
            boolean r2 = r4.exists()
            if (r2 != 0) goto L_0x003a
            r4.createNewFile()     // Catch:{ IOException -> 0x0033 }
            goto L_0x003a
        L_0x0033:
            r2 = move-exception
            android.util.Log.e(r1, r5)
            r2.printStackTrace()
        L_0x003a:
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x0072 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0074, IOException -> 0x0072 }
            java.util.Iterator r4 = r6.iterator()     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0060, all -> 0x005d }
        L_0x0044:
            boolean r6 = r4.hasNext()     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0060, all -> 0x005d }
            if (r6 == 0) goto L_0x0066
            java.lang.Object r6 = r4.next()     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0060, all -> 0x005d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0060, all -> 0x005d }
            byte[] r6 = r6.getBytes()     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0060, all -> 0x005d }
            r3.write(r6)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0060, all -> 0x005d }
            r6 = 10
            r3.write(r6)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x0060, all -> 0x005d }
            goto L_0x0044
        L_0x005d:
            r4 = move-exception
            r2 = r3
            goto L_0x0091
        L_0x0060:
            r4 = move-exception
            r2 = r3
            goto L_0x0076
        L_0x0063:
            r4 = move-exception
            r2 = r3
            goto L_0x0082
        L_0x0066:
            r3.close()     // Catch:{ IOException -> 0x006b }
            r0 = 1
            goto L_0x0090
        L_0x006b:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0090
        L_0x0070:
            r4 = move-exception
            goto L_0x0091
        L_0x0072:
            r4 = move-exception
            goto L_0x0076
        L_0x0074:
            r4 = move-exception
            goto L_0x0082
        L_0x0076:
            android.util.Log.e(r1, r5)     // Catch:{ all -> 0x0070 }
            r4.printStackTrace()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0090
            r2.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0090
        L_0x0082:
            java.lang.String r5 = "write_license_content FileNotFoundException"
            android.util.Log.e(r1, r5)     // Catch:{ all -> 0x0070 }
            r4.printStackTrace()     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x0090
            r2.close()     // Catch:{ IOException -> 0x006b }
        L_0x0090:
            return r0
        L_0x0091:
            if (r2 == 0) goto L_0x009b
            r2.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x009b
        L_0x0097:
            r5 = move-exception
            r5.printStackTrace()
        L_0x009b:
            throw r4
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseReaderUtils.write_license_content(android.content.Context, java.lang.String, java.util.ArrayList):boolean");
    }
}
