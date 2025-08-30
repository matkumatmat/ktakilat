package com.baidu.idl.face.platform.network;

import android.os.Handler;

public class NoMotionRequest extends BaseRequest {
    private static final String TAG = "NoMotionRequest";
    public static final String URL_POST_NOMOTION_LIVENESS = "";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v44, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v46, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v48, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v50, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v68, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v69, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v70, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v71, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v72, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v73, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v74, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v75, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v76, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v77, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v78, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v79, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r3v62 */
    /* JADX WARNING: type inference failed for: r3v63 */
    /* JADX WARNING: type inference failed for: r3v64 */
    /* JADX WARNING: type inference failed for: r3v65 */
    /* JADX WARNING: type inference failed for: r3v66 */
    /* JADX WARNING: type inference failed for: r3v67 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x017f A[SYNTHETIC, Splitter:B:115:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0187 A[Catch:{ IOException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x018c A[Catch:{ IOException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0191 A[Catch:{ IOException -> 0x0183 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01a1 A[SYNTHETIC, Splitter:B:130:0x01a1] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01a9 A[Catch:{ IOException -> 0x01a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01ae A[Catch:{ IOException -> 0x01a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b3 A[Catch:{ IOException -> 0x01a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01c3 A[SYNTHETIC, Splitter:B:145:0x01c3] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01cb A[Catch:{ IOException -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01d0 A[Catch:{ IOException -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01d5 A[Catch:{ IOException -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01e5 A[SYNTHETIC, Splitter:B:160:0x01e5] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x01ed A[Catch:{ IOException -> 0x01e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x01f2 A[Catch:{ IOException -> 0x01e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01f7 A[Catch:{ IOException -> 0x01e9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0207 A[SYNTHETIC, Splitter:B:175:0x0207] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x020f A[Catch:{ IOException -> 0x020b }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0214 A[Catch:{ IOException -> 0x020b }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0219 A[Catch:{ IOException -> 0x020b }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0227 A[SYNTHETIC, Splitter:B:188:0x0227] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x022f A[Catch:{ IOException -> 0x022b }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0234 A[Catch:{ IOException -> 0x022b }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0239 A[Catch:{ IOException -> 0x022b }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:205:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:206:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:208:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:209:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:157:0x01e0=Splitter:B:157:0x01e0, B:172:0x0202=Splitter:B:172:0x0202, B:112:0x017a=Splitter:B:112:0x017a, B:127:0x019c=Splitter:B:127:0x019c, B:142:0x01be=Splitter:B:142:0x01be} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void httpUrlConnectionPost(java.lang.String r9, android.os.Handler r10) {
        /*
            java.lang.String r0 = "8000"
            java.lang.String r1 = "pic_file="
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = ""
            r2.<init>(r3)
            r4 = 0
            r5 = 0
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            r6.<init>(r1)     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.lang.String r1 = "UTF-8"
            java.lang.String r9 = java.net.URLEncoder.encode(r9, r1)     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            r6.append(r9)     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.lang.String r9 = r6.toString()     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.net.URL r1 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            r1.<init>(r3)     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ MalformedURLException -> 0x0175, UnsupportedEncodingException -> 0x0170, ProtocolException -> 0x016b, IOException -> 0x0166, Exception -> 0x0161, all -> 0x015c }
            java.lang.String r3 = "sun.net.client.defaultConnectTimeout"
            java.lang.System.setProperty(r3, r0)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            java.lang.String r3 = "sun.net.client.defaultReadTimeout"
            java.lang.System.setProperty(r3, r0)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            r0 = 1
            r1.setDoOutput(r0)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            r1.setDoInput(r0)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            java.lang.String r3 = "POST"
            r1.setRequestMethod(r3)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            r1.setUseCaches(r5)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            r1.setInstanceFollowRedirects(r0)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            java.lang.String r0 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r1.setRequestProperty(r0, r3)     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            r1.connect()     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            java.io.OutputStream r0 = r1.getOutputStream()     // Catch:{ MalformedURLException -> 0x0158, UnsupportedEncodingException -> 0x0154, ProtocolException -> 0x0150, IOException -> 0x014c, Exception -> 0x0148, all -> 0x0144 }
            byte[] r9 = r9.getBytes()     // Catch:{ MalformedURLException -> 0x013d, UnsupportedEncodingException -> 0x0136, ProtocolException -> 0x012f, IOException -> 0x0128, Exception -> 0x0121, all -> 0x011a }
            r0.write(r9)     // Catch:{ MalformedURLException -> 0x013d, UnsupportedEncodingException -> 0x0136, ProtocolException -> 0x012f, IOException -> 0x0128, Exception -> 0x0121, all -> 0x011a }
            r0.flush()     // Catch:{ MalformedURLException -> 0x013d, UnsupportedEncodingException -> 0x0136, ProtocolException -> 0x012f, IOException -> 0x0128, Exception -> 0x0121, all -> 0x011a }
            r0.close()     // Catch:{ MalformedURLException -> 0x013d, UnsupportedEncodingException -> 0x0136, ProtocolException -> 0x012f, IOException -> 0x0128, Exception -> 0x0121, all -> 0x011a }
            int r9 = r1.getResponseCode()     // Catch:{ MalformedURLException -> 0x013d, UnsupportedEncodingException -> 0x0136, ProtocolException -> 0x012f, IOException -> 0x0128, Exception -> 0x0121, all -> 0x011a }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r9) goto L_0x00ef
            java.io.InputStream r3 = r1.getInputStream()     // Catch:{ MalformedURLException -> 0x00e9, UnsupportedEncodingException -> 0x00e3, ProtocolException -> 0x00dd, IOException -> 0x00d7, Exception -> 0x00d1, all -> 0x00cb }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ MalformedURLException -> 0x00c6, UnsupportedEncodingException -> 0x00c1, ProtocolException -> 0x00bc, IOException -> 0x00b7, Exception -> 0x00b2, all -> 0x00ad }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00c6, UnsupportedEncodingException -> 0x00c1, ProtocolException -> 0x00bc, IOException -> 0x00b7, Exception -> 0x00b2, all -> 0x00ad }
            r7.<init>()     // Catch:{ MalformedURLException -> 0x00c6, UnsupportedEncodingException -> 0x00c1, ProtocolException -> 0x00bc, IOException -> 0x00b7, Exception -> 0x00b2, all -> 0x00ad }
        L_0x007c:
            int r4 = r3.read(r6)     // Catch:{ MalformedURLException -> 0x0096, UnsupportedEncodingException -> 0x0093, ProtocolException -> 0x0090, IOException -> 0x008d, Exception -> 0x008a }
            r8 = -1
            if (r4 == r8) goto L_0x0099
            r7.write(r6, r5, r4)     // Catch:{ MalformedURLException -> 0x0096, UnsupportedEncodingException -> 0x0093, ProtocolException -> 0x0090, IOException -> 0x008d, Exception -> 0x008a }
            goto L_0x007c
        L_0x0087:
            r4 = move-exception
            goto L_0x0225
        L_0x008a:
            r4 = move-exception
            goto L_0x017a
        L_0x008d:
            r4 = move-exception
            goto L_0x019c
        L_0x0090:
            r4 = move-exception
            goto L_0x01be
        L_0x0093:
            r4 = move-exception
            goto L_0x01e0
        L_0x0096:
            r4 = move-exception
            goto L_0x0202
        L_0x0099:
            byte[] r4 = r7.toByteArray()     // Catch:{ MalformedURLException -> 0x0096, UnsupportedEncodingException -> 0x0093, ProtocolException -> 0x0090, IOException -> 0x008d, Exception -> 0x008a }
            java.lang.String r6 = new java.lang.String     // Catch:{ MalformedURLException -> 0x0096, UnsupportedEncodingException -> 0x0093, ProtocolException -> 0x0090, IOException -> 0x008d, Exception -> 0x008a }
            java.lang.String r8 = "utf-8"
            r6.<init>(r4, r8)     // Catch:{ MalformedURLException -> 0x0096, UnsupportedEncodingException -> 0x0093, ProtocolException -> 0x0090, IOException -> 0x008d, Exception -> 0x008a }
            r2.append(r6)     // Catch:{ MalformedURLException -> 0x0096, UnsupportedEncodingException -> 0x0093, ProtocolException -> 0x0090, IOException -> 0x008d, Exception -> 0x008a }
            r7.flush()     // Catch:{ MalformedURLException -> 0x0096, UnsupportedEncodingException -> 0x0093, ProtocolException -> 0x0090, IOException -> 0x008d, Exception -> 0x008a }
            r4 = r7
            goto L_0x00f0
        L_0x00ad:
            r6 = move-exception
            r7 = r4
            r4 = r6
            goto L_0x0225
        L_0x00b2:
            r6 = move-exception
            r7 = r4
            r4 = r6
            goto L_0x017a
        L_0x00b7:
            r6 = move-exception
            r7 = r4
            r4 = r6
            goto L_0x019c
        L_0x00bc:
            r6 = move-exception
            r7 = r4
            r4 = r6
            goto L_0x01be
        L_0x00c1:
            r6 = move-exception
            r7 = r4
            r4 = r6
            goto L_0x01e0
        L_0x00c6:
            r6 = move-exception
            r7 = r4
            r4 = r6
            goto L_0x0202
        L_0x00cb:
            r3 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x0225
        L_0x00d1:
            r3 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x017a
        L_0x00d7:
            r3 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x019c
        L_0x00dd:
            r3 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x01be
        L_0x00e3:
            r3 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x01e0
        L_0x00e9:
            r3 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x0202
        L_0x00ef:
            r3 = r4
        L_0x00f0:
            r0.close()     // Catch:{ IOException -> 0x00f9 }
            if (r4 == 0) goto L_0x00fb
            r4.close()     // Catch:{ IOException -> 0x00f9 }
            goto L_0x00fb
        L_0x00f9:
            r0 = move-exception
            goto L_0x0104
        L_0x00fb:
            if (r3 == 0) goto L_0x0100
            r3.close()     // Catch:{ IOException -> 0x00f9 }
        L_0x0100:
            r1.disconnect()     // Catch:{ IOException -> 0x00f9 }
            goto L_0x0107
        L_0x0104:
            r0.printStackTrace()
        L_0x0107:
            if (r10 == 0) goto L_0x0224
        L_0x0109:
            android.os.Message r0 = r10.obtainMessage(r5)
            r0.arg1 = r9
            java.lang.String r9 = r2.toString()
            r0.obj = r9
            r10.sendMessage(r0)
            goto L_0x0224
        L_0x011a:
            r9 = move-exception
            r3 = r4
        L_0x011c:
            r7 = r3
            r4 = r9
            r9 = 0
            goto L_0x0225
        L_0x0121:
            r9 = move-exception
            r3 = r4
        L_0x0123:
            r7 = r3
            r4 = r9
            r9 = 0
            goto L_0x017a
        L_0x0128:
            r9 = move-exception
            r3 = r4
        L_0x012a:
            r7 = r3
            r4 = r9
            r9 = 0
            goto L_0x019c
        L_0x012f:
            r9 = move-exception
            r3 = r4
        L_0x0131:
            r7 = r3
            r4 = r9
            r9 = 0
            goto L_0x01be
        L_0x0136:
            r9 = move-exception
            r3 = r4
        L_0x0138:
            r7 = r3
            r4 = r9
            r9 = 0
            goto L_0x01e0
        L_0x013d:
            r9 = move-exception
            r3 = r4
        L_0x013f:
            r7 = r3
            r4 = r9
            r9 = 0
            goto L_0x0202
        L_0x0144:
            r9 = move-exception
            r0 = r4
            r3 = r0
            goto L_0x011c
        L_0x0148:
            r9 = move-exception
            r0 = r4
            r3 = r0
            goto L_0x0123
        L_0x014c:
            r9 = move-exception
            r0 = r4
            r3 = r0
            goto L_0x012a
        L_0x0150:
            r9 = move-exception
            r0 = r4
            r3 = r0
            goto L_0x0131
        L_0x0154:
            r9 = move-exception
            r0 = r4
            r3 = r0
            goto L_0x0138
        L_0x0158:
            r9 = move-exception
            r0 = r4
            r3 = r0
            goto L_0x013f
        L_0x015c:
            r9 = move-exception
            r0 = r4
            r1 = r0
            r3 = r1
            goto L_0x011c
        L_0x0161:
            r9 = move-exception
            r0 = r4
            r1 = r0
            r3 = r1
            goto L_0x0123
        L_0x0166:
            r9 = move-exception
            r0 = r4
            r1 = r0
            r3 = r1
            goto L_0x012a
        L_0x016b:
            r9 = move-exception
            r0 = r4
            r1 = r0
            r3 = r1
            goto L_0x0131
        L_0x0170:
            r9 = move-exception
            r0 = r4
            r1 = r0
            r3 = r1
            goto L_0x0138
        L_0x0175:
            r9 = move-exception
            r0 = r4
            r1 = r0
            r3 = r1
            goto L_0x013f
        L_0x017a:
            r4.printStackTrace()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0185
            r0.close()     // Catch:{ IOException -> 0x0183 }
            goto L_0x0185
        L_0x0183:
            r0 = move-exception
            goto L_0x0195
        L_0x0185:
            if (r7 == 0) goto L_0x018a
            r7.close()     // Catch:{ IOException -> 0x0183 }
        L_0x018a:
            if (r3 == 0) goto L_0x018f
            r3.close()     // Catch:{ IOException -> 0x0183 }
        L_0x018f:
            if (r1 == 0) goto L_0x0198
            r1.disconnect()     // Catch:{ IOException -> 0x0183 }
            goto L_0x0198
        L_0x0195:
            r0.printStackTrace()
        L_0x0198:
            if (r10 == 0) goto L_0x0224
            goto L_0x0109
        L_0x019c:
            r4.printStackTrace()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x01a7
            r0.close()     // Catch:{ IOException -> 0x01a5 }
            goto L_0x01a7
        L_0x01a5:
            r0 = move-exception
            goto L_0x01b7
        L_0x01a7:
            if (r7 == 0) goto L_0x01ac
            r7.close()     // Catch:{ IOException -> 0x01a5 }
        L_0x01ac:
            if (r3 == 0) goto L_0x01b1
            r3.close()     // Catch:{ IOException -> 0x01a5 }
        L_0x01b1:
            if (r1 == 0) goto L_0x01ba
            r1.disconnect()     // Catch:{ IOException -> 0x01a5 }
            goto L_0x01ba
        L_0x01b7:
            r0.printStackTrace()
        L_0x01ba:
            if (r10 == 0) goto L_0x0224
            goto L_0x0109
        L_0x01be:
            r4.printStackTrace()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x01c9
            r0.close()     // Catch:{ IOException -> 0x01c7 }
            goto L_0x01c9
        L_0x01c7:
            r0 = move-exception
            goto L_0x01d9
        L_0x01c9:
            if (r7 == 0) goto L_0x01ce
            r7.close()     // Catch:{ IOException -> 0x01c7 }
        L_0x01ce:
            if (r3 == 0) goto L_0x01d3
            r3.close()     // Catch:{ IOException -> 0x01c7 }
        L_0x01d3:
            if (r1 == 0) goto L_0x01dc
            r1.disconnect()     // Catch:{ IOException -> 0x01c7 }
            goto L_0x01dc
        L_0x01d9:
            r0.printStackTrace()
        L_0x01dc:
            if (r10 == 0) goto L_0x0224
            goto L_0x0109
        L_0x01e0:
            r4.printStackTrace()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x01eb
            r0.close()     // Catch:{ IOException -> 0x01e9 }
            goto L_0x01eb
        L_0x01e9:
            r0 = move-exception
            goto L_0x01fb
        L_0x01eb:
            if (r7 == 0) goto L_0x01f0
            r7.close()     // Catch:{ IOException -> 0x01e9 }
        L_0x01f0:
            if (r3 == 0) goto L_0x01f5
            r3.close()     // Catch:{ IOException -> 0x01e9 }
        L_0x01f5:
            if (r1 == 0) goto L_0x01fe
            r1.disconnect()     // Catch:{ IOException -> 0x01e9 }
            goto L_0x01fe
        L_0x01fb:
            r0.printStackTrace()
        L_0x01fe:
            if (r10 == 0) goto L_0x0224
            goto L_0x0109
        L_0x0202:
            r4.printStackTrace()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x020d
            r0.close()     // Catch:{ IOException -> 0x020b }
            goto L_0x020d
        L_0x020b:
            r0 = move-exception
            goto L_0x021d
        L_0x020d:
            if (r7 == 0) goto L_0x0212
            r7.close()     // Catch:{ IOException -> 0x020b }
        L_0x0212:
            if (r3 == 0) goto L_0x0217
            r3.close()     // Catch:{ IOException -> 0x020b }
        L_0x0217:
            if (r1 == 0) goto L_0x0220
            r1.disconnect()     // Catch:{ IOException -> 0x020b }
            goto L_0x0220
        L_0x021d:
            r0.printStackTrace()
        L_0x0220:
            if (r10 == 0) goto L_0x0224
            goto L_0x0109
        L_0x0224:
            return
        L_0x0225:
            if (r0 == 0) goto L_0x022d
            r0.close()     // Catch:{ IOException -> 0x022b }
            goto L_0x022d
        L_0x022b:
            r0 = move-exception
            goto L_0x023d
        L_0x022d:
            if (r7 == 0) goto L_0x0232
            r7.close()     // Catch:{ IOException -> 0x022b }
        L_0x0232:
            if (r3 == 0) goto L_0x0237
            r3.close()     // Catch:{ IOException -> 0x022b }
        L_0x0237:
            if (r1 == 0) goto L_0x0240
            r1.disconnect()     // Catch:{ IOException -> 0x022b }
            goto L_0x0240
        L_0x023d:
            r0.printStackTrace()
        L_0x0240:
            if (r10 == 0) goto L_0x0251
            android.os.Message r0 = r10.obtainMessage(r5)
            r0.arg1 = r9
            java.lang.String r9 = r2.toString()
            r0.obj = r9
            r10.sendMessage(r0)
        L_0x0251:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.network.NoMotionRequest.httpUrlConnectionPost(java.lang.String, android.os.Handler):void");
    }

    public static void sendMessage(final String str, final Handler handler) {
        if (str != null && str.length() > 0) {
            new Thread(new Runnable() {
                public void run() {
                    NoMotionRequest.httpUrlConnectionPost(str, handler);
                }
            }).start();
        }
    }
}
