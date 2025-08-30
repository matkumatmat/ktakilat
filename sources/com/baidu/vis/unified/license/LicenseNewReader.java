package com.baidu.vis.unified.license;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.actions.SearchIntents;
import org.json.JSONObject;

class LicenseNewReader {
    public static final String TAG = "License-SDK";

    public static HttpStatus httpPostRequest(Context context, String str, String str2) {
        String str3 = "";
        HttpStatus httpStatus = null;
        try {
            if (!str3.equals(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                str3 = "sdk_v=" + jSONObject.getString("sdk_v") + "&query=" + jSONObject.getString(SearchIntents.EXTRA_QUERY);
            }
            Log.e("License-SDK", "request get_remote_license =" + str);
            httpStatus = HttpUtils.requestPost(str, str3, "application/x-www-form-urlencoded", "License-SDK");
            if (httpStatus != null) {
                Log.e("jni", "java result = " + httpStatus.responseStr);
            }
        } catch (Exception e) {
            Log.e("License-SDK", "Exception " + e.getMessage());
            e.printStackTrace();
        }
        return httpStatus;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00b4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d3 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:53:0x00d3=Splitter:B:53:0x00d3, B:45:0x00b4=Splitter:B:45:0x00b4} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int readFile(android.content.Context r8, java.lang.String r9, java.util.ArrayList<java.lang.String> r10) {
        /*
            java.lang.String r0 = "License-SDK"
            r1 = -1
            if (r8 == 0) goto L_0x00fd
            if (r9 == 0) goto L_0x00fd
            if (r10 != 0) goto L_0x000b
            goto L_0x00fd
        L_0x000b:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.baidu.vis.unified.license.ReadStatusCode r3 = new com.baidu.vis.unified.license.ReadStatusCode
            r3.<init>()
            r4 = 0
            r3.is_from_asset = r4
            r4 = -2
            r5 = 0
            java.io.InputStream r5 = com.baidu.vis.unified.license.LicenseReaderUtils.get_local_license_file_inputstream(r8, r9, r3)     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
            if (r5 != 0) goto L_0x0035
            java.lang.String r8 = "open license file error."
            android.util.Log.e(r0, r8)     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
            if (r5 == 0) goto L_0x002f
            r5.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r8 = move-exception
            r8.printStackTrace()
        L_0x002f:
            return r1
        L_0x0030:
            r8 = move-exception
            goto L_0x00f2
        L_0x0033:
            r8 = move-exception
            goto L_0x0089
        L_0x0035:
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
            r6.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
        L_0x003f:
            java.lang.String r6 = r7.readLine()     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
            if (r6 == 0) goto L_0x0049
            r2.add(r6)     // Catch:{ FileNotFoundException -> 0x00d3, IOException -> 0x00b4, Exception -> 0x0033 }
            goto L_0x003f
        L_0x0049:
            r5.close()     // Catch:{ IOException -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0051:
            int r1 = r2.size()
            if (r1 <= 0) goto L_0x0084
            boolean r1 = r3.is_from_asset
            r3 = 1
            if (r1 != r3) goto L_0x005f
            com.baidu.vis.unified.license.LicenseReaderUtils.write_license_content(r8, r9, r2)
        L_0x005f:
            java.util.Iterator r8 = r2.iterator()
        L_0x0063:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0084
            java.lang.Object r9 = r8.next()
            java.lang.String r9 = (java.lang.String) r9
            r10.add(r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "license file info ="
            r1.<init>(r3)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            android.util.Log.e(r0, r9)
            goto L_0x0063
        L_0x0084:
            int r8 = r2.size()
            return r8
        L_0x0089:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r10.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r1 = "license file Exception "
            r10.append(r1)     // Catch:{ all -> 0x0030 }
            r10.append(r9)     // Catch:{ all -> 0x0030 }
            java.lang.String r9 = " "
            r10.append(r9)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x0030 }
            r10.append(r8)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x0030 }
            android.util.Log.e(r0, r8)     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x00b3
            r5.close()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b3
        L_0x00af:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00b3:
            return r4
        L_0x00b4:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r8.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r10 = "license file IOException "
            r8.append(r10)     // Catch:{ all -> 0x0030 }
            r8.append(r9)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0030 }
            android.util.Log.e(r0, r8)     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x00d2
            r5.close()     // Catch:{ IOException -> 0x00ce }
            goto L_0x00d2
        L_0x00ce:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00d2:
            return r4
        L_0x00d3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r8.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r10 = "license file FileNotFoundException "
            r8.append(r10)     // Catch:{ all -> 0x0030 }
            r8.append(r9)     // Catch:{ all -> 0x0030 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0030 }
            android.util.Log.e(r0, r8)     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x00f1
            r5.close()     // Catch:{ IOException -> 0x00ed }
            goto L_0x00f1
        L_0x00ed:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00f1:
            return r1
        L_0x00f2:
            if (r5 == 0) goto L_0x00fc
            r5.close()     // Catch:{ IOException -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00fc:
            throw r8
        L_0x00fd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseNewReader.readFile(android.content.Context, java.lang.String, java.util.ArrayList):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0077 A[SYNTHETIC, Splitter:B:42:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0083 A[SYNTHETIC, Splitter:B:47:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0091 A[SYNTHETIC, Splitter:B:53:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0097 A[SYNTHETIC, Splitter:B:56:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int writeFile(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            r0 = -1
            if (r5 == 0) goto L_0x00a0
            if (r6 == 0) goto L_0x00a0
            if (r7 != 0) goto L_0x0009
            goto L_0x00a0
        L_0x0009:
            java.lang.String r1 = "/"
            boolean r1 = r6.startsWith(r1)
            java.lang.String r2 = "License-SDK"
            if (r1 == 0) goto L_0x0019
            java.io.File r5 = new java.io.File
            r5.<init>(r6)
            goto L_0x0033
        L_0x0019:
            r1 = 0
            java.io.File r5 = r5.getDir(r6, r1)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r1 = "put_local_license ="
            r6.<init>(r1)
            java.lang.String r1 = r5.getAbsolutePath()
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            android.util.Log.e(r2, r6)
        L_0x0033:
            r5.delete()
            boolean r6 = r5.exists()
            java.lang.String r1 = "IOException"
            r3 = -2
            if (r6 != 0) goto L_0x0047
            r5.createNewFile()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            android.util.Log.e(r2, r1)
            return r3
        L_0x0047:
            r6 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x006e, IOException -> 0x006c, Exception -> 0x0070 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x006e, IOException -> 0x006c, Exception -> 0x0070 }
            byte[] r5 = r7.getBytes()     // Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0064, Exception -> 0x0062, all -> 0x005f }
            r4.write(r5)     // Catch:{ FileNotFoundException -> 0x0067, IOException -> 0x0064, Exception -> 0x0062, all -> 0x005f }
            r4.close()     // Catch:{ IOException -> 0x0059 }
            r0 = 1
            goto L_0x0094
        L_0x0059:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005d:
            r0 = -2
            goto L_0x0094
        L_0x005f:
            r5 = move-exception
            r6 = r4
            goto L_0x0095
        L_0x0062:
            r6 = r4
            goto L_0x0070
        L_0x0064:
            r5 = move-exception
            r6 = r4
            goto L_0x007b
        L_0x0067:
            r5 = move-exception
            r6 = r4
            goto L_0x0087
        L_0x006a:
            r5 = move-exception
            goto L_0x0095
        L_0x006c:
            r5 = move-exception
            goto L_0x007b
        L_0x006e:
            r5 = move-exception
            goto L_0x0087
        L_0x0070:
            java.lang.String r5 = "Exception"
            android.util.Log.e(r2, r5)     // Catch:{ all -> 0x006a }
            if (r6 == 0) goto L_0x005d
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x007b:
            android.util.Log.e(r2, r1)     // Catch:{ all -> 0x006a }
            r5.printStackTrace()     // Catch:{ all -> 0x006a }
            if (r6 == 0) goto L_0x005d
            r6.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x005d
        L_0x0087:
            java.lang.String r7 = "FileNotFoundException"
            android.util.Log.e(r2, r7)     // Catch:{ all -> 0x006a }
            r5.printStackTrace()     // Catch:{ all -> 0x006a }
            if (r6 == 0) goto L_0x0094
            r6.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0094:
            return r0
        L_0x0095:
            if (r6 == 0) goto L_0x009f
            r6.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x009f:
            throw r5
        L_0x00a0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseNewReader.writeFile(android.content.Context, java.lang.String, java.lang.String):int");
    }
}
