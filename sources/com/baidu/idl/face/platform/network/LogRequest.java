package com.baidu.idl.face.platform.network;

public class LogRequest extends BaseRequest {
    public static final String URL_GET_LOG = "";

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.OutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v52, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v61, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v62, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v63, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v64, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v65, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v66, resolved type: java.io.InputStream} */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v6, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v55 */
    /* JADX WARNING: type inference failed for: r4v56 */
    /* JADX WARNING: type inference failed for: r4v57 */
    /* JADX WARNING: type inference failed for: r4v58 */
    /* JADX WARNING: type inference failed for: r4v59 */
    /* JADX WARNING: type inference failed for: r4v60 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0131 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0136 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x013b A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0146 A[SYNTHETIC, Splitter:B:111:0x0146] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x014b A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0150 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0155 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x015e A[SYNTHETIC, Splitter:B:122:0x015e] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0163 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0168 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x016d A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0176 A[SYNTHETIC, Splitter:B:133:0x0176] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x017b A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0180 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0185 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x018e A[SYNTHETIC, Splitter:B:144:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0193 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x0198 A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x019d A[Catch:{ IOException -> 0x00e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01a3 A[SYNTHETIC, Splitter:B:153:0x01a3] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x01ab A[Catch:{ IOException -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x01b0 A[Catch:{ IOException -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x01b5 A[Catch:{ IOException -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:172:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x012c A[SYNTHETIC, Splitter:B:99:0x012c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:108:0x0141=Splitter:B:108:0x0141, B:130:0x0171=Splitter:B:130:0x0171, B:96:0x0127=Splitter:B:96:0x0127, B:119:0x0159=Splitter:B:119:0x0159, B:141:0x0189=Splitter:B:141:0x0189} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void httpUrlConnectionPost(java.lang.String r9) {
        /*
            java.lang.String r0 = "utf-8"
            java.lang.String r1 = "8000"
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r3 = 0
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            r4.<init>(r9)     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            java.lang.String r5 = ""
            r9.<init>(r5)     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ MalformedURLException -> 0x0123, UnsupportedEncodingException -> 0x011f, ProtocolException -> 0x011b, IOException -> 0x0117, Exception -> 0x0113, all -> 0x010f }
            java.lang.String r5 = "sun.net.client.defaultConnectTimeout"
            java.lang.System.setProperty(r5, r1)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            java.lang.String r5 = "sun.net.client.defaultReadTimeout"
            java.lang.System.setProperty(r5, r1)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            r1 = 1
            r9.setDoOutput(r1)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            r9.setDoInput(r1)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            java.lang.String r5 = "GET"
            r9.setRequestMethod(r5)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            java.lang.String r5 = "Charset"
            java.lang.String r6 = "UTF-8"
            r9.setRequestProperty(r5, r6)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            r5 = 0
            r9.setUseCaches(r5)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            r9.setInstanceFollowRedirects(r1)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            java.lang.String r1 = "contentType"
            java.lang.String r6 = "application/json"
            r9.setRequestProperty(r1, r6)     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            r9.connect()     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            java.io.OutputStream r1 = r9.getOutputStream()     // Catch:{ MalformedURLException -> 0x010a, UnsupportedEncodingException -> 0x0105, ProtocolException -> 0x0100, IOException -> 0x00fc, Exception -> 0x00f8, all -> 0x00f3 }
            java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x00d4, UnsupportedEncodingException -> 0x00d0, ProtocolException -> 0x00cc, IOException -> 0x00c8, Exception -> 0x00c4, all -> 0x00c0 }
            byte[] r4 = r4.getBytes(r0)     // Catch:{ MalformedURLException -> 0x00d4, UnsupportedEncodingException -> 0x00d0, ProtocolException -> 0x00cc, IOException -> 0x00c8, Exception -> 0x00c4, all -> 0x00c0 }
            r1.write(r4)     // Catch:{ MalformedURLException -> 0x00d4, UnsupportedEncodingException -> 0x00d0, ProtocolException -> 0x00cc, IOException -> 0x00c8, Exception -> 0x00c4, all -> 0x00c0 }
            r1.flush()     // Catch:{ MalformedURLException -> 0x00d4, UnsupportedEncodingException -> 0x00d0, ProtocolException -> 0x00cc, IOException -> 0x00c8, Exception -> 0x00c4, all -> 0x00c0 }
            r1.close()     // Catch:{ MalformedURLException -> 0x00d4, UnsupportedEncodingException -> 0x00d0, ProtocolException -> 0x00cc, IOException -> 0x00c8, Exception -> 0x00c4, all -> 0x00c0 }
            int r4 = r9.getResponseCode()     // Catch:{ MalformedURLException -> 0x00d4, UnsupportedEncodingException -> 0x00d0, ProtocolException -> 0x00cc, IOException -> 0x00c8, Exception -> 0x00c4, all -> 0x00c0 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r6 != r4) goto L_0x00d8
            java.io.InputStream r4 = r9.getInputStream()     // Catch:{ MalformedURLException -> 0x00d4, UnsupportedEncodingException -> 0x00d0, ProtocolException -> 0x00cc, IOException -> 0x00c8, Exception -> 0x00c4, all -> 0x00c0 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ MalformedURLException -> 0x00bd, UnsupportedEncodingException -> 0x00ba, ProtocolException -> 0x00b7, IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00ae }
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ MalformedURLException -> 0x00bd, UnsupportedEncodingException -> 0x00ba, ProtocolException -> 0x00b7, IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00ae }
            r7.<init>()     // Catch:{ MalformedURLException -> 0x00bd, UnsupportedEncodingException -> 0x00ba, ProtocolException -> 0x00b7, IOException -> 0x00b4, Exception -> 0x00b1, all -> 0x00ae }
        L_0x007a:
            int r3 = r4.read(r6)     // Catch:{ MalformedURLException -> 0x0099, UnsupportedEncodingException -> 0x0095, ProtocolException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0085 }
            r8 = -1
            if (r3 == r8) goto L_0x009d
            r7.write(r6, r5, r3)     // Catch:{ MalformedURLException -> 0x0099, UnsupportedEncodingException -> 0x0095, ProtocolException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0085 }
            goto L_0x007a
        L_0x0085:
            r0 = move-exception
        L_0x0086:
            r3 = r1
            goto L_0x01a1
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            r3 = r1
            goto L_0x0127
        L_0x008d:
            r0 = move-exception
        L_0x008e:
            r3 = r1
            goto L_0x0141
        L_0x0091:
            r0 = move-exception
        L_0x0092:
            r3 = r1
            goto L_0x0159
        L_0x0095:
            r0 = move-exception
        L_0x0096:
            r3 = r1
            goto L_0x0171
        L_0x0099:
            r0 = move-exception
        L_0x009a:
            r3 = r1
            goto L_0x0189
        L_0x009d:
            byte[] r3 = r7.toByteArray()     // Catch:{ MalformedURLException -> 0x0099, UnsupportedEncodingException -> 0x0095, ProtocolException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0085 }
            java.lang.String r5 = new java.lang.String     // Catch:{ MalformedURLException -> 0x0099, UnsupportedEncodingException -> 0x0095, ProtocolException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0085 }
            r5.<init>(r3, r0)     // Catch:{ MalformedURLException -> 0x0099, UnsupportedEncodingException -> 0x0095, ProtocolException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0085 }
            r2.append(r5)     // Catch:{ MalformedURLException -> 0x0099, UnsupportedEncodingException -> 0x0095, ProtocolException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0085 }
            r7.flush()     // Catch:{ MalformedURLException -> 0x0099, UnsupportedEncodingException -> 0x0095, ProtocolException -> 0x0091, IOException -> 0x008d, Exception -> 0x0089, all -> 0x0085 }
            r3 = r7
            goto L_0x00d9
        L_0x00ae:
            r0 = move-exception
            r7 = r3
            goto L_0x0086
        L_0x00b1:
            r0 = move-exception
            r7 = r3
            goto L_0x008a
        L_0x00b4:
            r0 = move-exception
            r7 = r3
            goto L_0x008e
        L_0x00b7:
            r0 = move-exception
            r7 = r3
            goto L_0x0092
        L_0x00ba:
            r0 = move-exception
            r7 = r3
            goto L_0x0096
        L_0x00bd:
            r0 = move-exception
            r7 = r3
            goto L_0x009a
        L_0x00c0:
            r0 = move-exception
            r4 = r3
            r7 = r4
            goto L_0x0086
        L_0x00c4:
            r0 = move-exception
            r4 = r3
            r7 = r4
            goto L_0x008a
        L_0x00c8:
            r0 = move-exception
            r4 = r3
            r7 = r4
            goto L_0x008e
        L_0x00cc:
            r0 = move-exception
            r4 = r3
            r7 = r4
            goto L_0x0092
        L_0x00d0:
            r0 = move-exception
            r4 = r3
            r7 = r4
            goto L_0x0096
        L_0x00d4:
            r0 = move-exception
            r4 = r3
            r7 = r4
            goto L_0x009a
        L_0x00d8:
            r4 = r3
        L_0x00d9:
            r1.close()     // Catch:{ IOException -> 0x00e2 }
            if (r3 == 0) goto L_0x00e4
            r3.close()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x00e4
        L_0x00e2:
            r9 = move-exception
            goto L_0x00ee
        L_0x00e4:
            if (r4 == 0) goto L_0x00e9
            r4.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x00e9:
            r9.disconnect()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x01a0
        L_0x00ee:
            r9.printStackTrace()
            goto L_0x01a0
        L_0x00f3:
            r0 = move-exception
            r4 = r3
        L_0x00f5:
            r7 = r4
            goto L_0x01a1
        L_0x00f8:
            r0 = move-exception
            r4 = r3
        L_0x00fa:
            r7 = r4
            goto L_0x0127
        L_0x00fc:
            r0 = move-exception
            r4 = r3
        L_0x00fe:
            r7 = r4
            goto L_0x0141
        L_0x0100:
            r0 = move-exception
            r4 = r3
        L_0x0102:
            r7 = r4
            goto L_0x0159
        L_0x0105:
            r0 = move-exception
            r4 = r3
        L_0x0107:
            r7 = r4
            goto L_0x0171
        L_0x010a:
            r0 = move-exception
            r4 = r3
        L_0x010c:
            r7 = r4
            goto L_0x0189
        L_0x010f:
            r0 = move-exception
            r9 = r3
            r4 = r9
            goto L_0x00f5
        L_0x0113:
            r0 = move-exception
            r9 = r3
            r4 = r9
            goto L_0x00fa
        L_0x0117:
            r0 = move-exception
            r9 = r3
            r4 = r9
            goto L_0x00fe
        L_0x011b:
            r0 = move-exception
            r9 = r3
            r4 = r9
            goto L_0x0102
        L_0x011f:
            r0 = move-exception
            r9 = r3
            r4 = r9
            goto L_0x0107
        L_0x0123:
            r0 = move-exception
            r9 = r3
            r4 = r9
            goto L_0x010c
        L_0x0127:
            r0.printStackTrace()     // Catch:{ all -> 0x013f }
            if (r3 == 0) goto L_0x012f
            r3.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x012f:
            if (r7 == 0) goto L_0x0134
            r7.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0134:
            if (r4 == 0) goto L_0x0139
            r4.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0139:
            if (r9 == 0) goto L_0x01a0
            r9.disconnect()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x01a0
        L_0x013f:
            r0 = move-exception
            goto L_0x01a1
        L_0x0141:
            r0.printStackTrace()     // Catch:{ all -> 0x013f }
            if (r3 == 0) goto L_0x0149
            r3.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0149:
            if (r7 == 0) goto L_0x014e
            r7.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x014e:
            if (r4 == 0) goto L_0x0153
            r4.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0153:
            if (r9 == 0) goto L_0x01a0
            r9.disconnect()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x01a0
        L_0x0159:
            r0.printStackTrace()     // Catch:{ all -> 0x013f }
            if (r3 == 0) goto L_0x0161
            r3.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0161:
            if (r7 == 0) goto L_0x0166
            r7.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0166:
            if (r4 == 0) goto L_0x016b
            r4.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x016b:
            if (r9 == 0) goto L_0x01a0
            r9.disconnect()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x01a0
        L_0x0171:
            r0.printStackTrace()     // Catch:{ all -> 0x013f }
            if (r3 == 0) goto L_0x0179
            r3.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0179:
            if (r7 == 0) goto L_0x017e
            r7.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x017e:
            if (r4 == 0) goto L_0x0183
            r4.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0183:
            if (r9 == 0) goto L_0x01a0
            r9.disconnect()     // Catch:{ IOException -> 0x00e2 }
            goto L_0x01a0
        L_0x0189:
            r0.printStackTrace()     // Catch:{ all -> 0x013f }
            if (r3 == 0) goto L_0x0191
            r3.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0191:
            if (r7 == 0) goto L_0x0196
            r7.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0196:
            if (r4 == 0) goto L_0x019b
            r4.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x019b:
            if (r9 == 0) goto L_0x01a0
            r9.disconnect()     // Catch:{ IOException -> 0x00e2 }
        L_0x01a0:
            return
        L_0x01a1:
            if (r3 == 0) goto L_0x01a9
            r3.close()     // Catch:{ IOException -> 0x01a7 }
            goto L_0x01a9
        L_0x01a7:
            r9 = move-exception
            goto L_0x01b9
        L_0x01a9:
            if (r7 == 0) goto L_0x01ae
            r7.close()     // Catch:{ IOException -> 0x01a7 }
        L_0x01ae:
            if (r4 == 0) goto L_0x01b3
            r4.close()     // Catch:{ IOException -> 0x01a7 }
        L_0x01b3:
            if (r9 == 0) goto L_0x01bc
            r9.disconnect()     // Catch:{ IOException -> 0x01a7 }
            goto L_0x01bc
        L_0x01b9:
            r9.printStackTrace()
        L_0x01bc:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.face.platform.network.LogRequest.httpUrlConnectionPost(java.lang.String):void");
    }

    public static void sendLogMessage(final String str) {
        if (str != null && str.length() > 0) {
            new Thread(new Runnable() {
                public void run() {
                    LogRequest.httpUrlConnectionPost(str);
                }
            }).start();
        }
    }
}
