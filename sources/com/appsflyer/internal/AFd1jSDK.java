package com.appsflyer.internal;

public final class AFd1jSDK {
    private final int getRevenue;

    public AFd1jSDK(int i) {
        this.getRevenue = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getMediationNetwork(java.net.HttpURLConnection r11) throws java.io.IOException {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.io.InputStream r11 = r11.getInputStream()     // Catch:{ Exception -> 0x000b }
            goto L_0x0027
        L_0x0008:
            r11 = move-exception
            r0 = r1
            goto L_0x0065
        L_0x000b:
            r5 = move-exception
            java.io.InputStream r11 = r11.getErrorStream()     // Catch:{ all -> 0x0008 }
            com.appsflyer.AFLogger r2 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x0008 }
            com.appsflyer.internal.AFg1cSDK r3 = com.appsflyer.internal.AFg1cSDK.HTTP_CLIENT     // Catch:{ all -> 0x0008 }
            java.lang.String r4 = r5.getMessage()     // Catch:{ all -> 0x0008 }
            if (r4 == 0) goto L_0x001f
            java.lang.String r4 = r5.getMessage()     // Catch:{ all -> 0x0008 }
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            r8 = 0
            r9 = 0
            r6 = 0
            r7 = 0
            r2.e(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0008 }
        L_0x0027:
            if (r11 != 0) goto L_0x002a
            return r0
        L_0x002a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0008 }
            r0.<init>()     // Catch:{ all -> 0x0008 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x0008 }
            java.nio.charset.Charset r3 = java.nio.charset.Charset.defaultCharset()     // Catch:{ all -> 0x0008 }
            r2.<init>(r11, r3)     // Catch:{ all -> 0x0008 }
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ all -> 0x0062 }
            r11.<init>(r2)     // Catch:{ all -> 0x0062 }
            r1 = 1
        L_0x003e:
            java.lang.String r3 = r11.readLine()     // Catch:{ all -> 0x004c }
            if (r3 == 0) goto L_0x0057
            if (r1 != 0) goto L_0x0052
            r1 = 10
            r0.append(r1)     // Catch:{ all -> 0x004c }
            goto L_0x0052
        L_0x004c:
            r0 = move-exception
            r1 = r2
            r10 = r0
            r0 = r11
            r11 = r10
            goto L_0x0065
        L_0x0052:
            r0.append(r3)     // Catch:{ all -> 0x004c }
            r1 = 0
            goto L_0x003e
        L_0x0057:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x004c }
            r2.close()
            r11.close()
            return r0
        L_0x0062:
            r11 = move-exception
            r0 = r1
            r1 = r2
        L_0x0065:
            if (r1 == 0) goto L_0x006a
            r1.close()
        L_0x006a:
            if (r0 == 0) goto L_0x006f
            r0.close()
        L_0x006f:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1jSDK.getMediationNetwork(java.net.HttpURLConnection):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0155 A[Catch:{ all -> 0x014e, all -> 0x00f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appsflyer.internal.AFd1aSDK<java.lang.String> getMonetizationNetwork(com.appsflyer.internal.AFd1cSDK r21) throws java.io.IOException {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r2 = "ms"
            java.lang.String r3 = "\n took "
            java.lang.String r4 = "] "
            java.lang.String r5 = "["
            long r6 = java.lang.System.currentTimeMillis()
            byte[] r0 = r21.getRevenue()     // Catch:{ all -> 0x01ed }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ed }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ed }
            r10.<init>()     // Catch:{ all -> 0x01ed }
            java.lang.String r11 = r1.getRevenue     // Catch:{ all -> 0x01ed }
            r10.append(r11)     // Catch:{ all -> 0x01ed }
            java.lang.String r11 = ":"
            r10.append(r11)     // Catch:{ all -> 0x01ed }
            java.lang.String r11 = r1.getMonetizationNetwork     // Catch:{ all -> 0x01ed }
            r10.append(r11)     // Catch:{ all -> 0x01ed }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01ed }
            r9.<init>(r10)     // Catch:{ all -> 0x01ed }
            byte[] r10 = r21.getRevenue()     // Catch:{ all -> 0x01ed }
            boolean r11 = r21.getCurrencyIso4217Code()     // Catch:{ all -> 0x01ed }
            if (r11 == 0) goto L_0x005c
            if (r10 == 0) goto L_0x005c
            boolean r11 = r21.AFAdRevenueData()     // Catch:{ all -> 0x0044 }
            if (r11 == 0) goto L_0x004a
            java.lang.String r10 = "<encrypted>"
            goto L_0x0054
        L_0x0044:
            r0 = move-exception
            r8 = 0
            r10 = r20
            goto L_0x01f2
        L_0x004a:
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0044 }
            java.nio.charset.Charset r12 = java.nio.charset.Charset.defaultCharset()     // Catch:{ all -> 0x0044 }
            r11.<init>(r10, r12)     // Catch:{ all -> 0x0044 }
            r10 = r11
        L_0x0054:
            java.lang.String r11 = "\n payload: "
            r9.append(r11)     // Catch:{ all -> 0x0044 }
            r9.append(r10)     // Catch:{ all -> 0x0044 }
        L_0x005c:
            java.util.Map<java.lang.String, java.lang.String> r10 = r1.AFAdRevenueData     // Catch:{ all -> 0x01ed }
            java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x01ed }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x01ed }
        L_0x0066:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x01ed }
            if (r11 == 0) goto L_0x008f
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0044 }
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11     // Catch:{ all -> 0x0044 }
            java.lang.String r12 = "\n "
            r9.append(r12)     // Catch:{ all -> 0x0044 }
            java.lang.Object r12 = r11.getKey()     // Catch:{ all -> 0x0044 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0044 }
            r9.append(r12)     // Catch:{ all -> 0x0044 }
            java.lang.String r12 = ": "
            r9.append(r12)     // Catch:{ all -> 0x0044 }
            java.lang.Object r11 = r11.getValue()     // Catch:{ all -> 0x0044 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0044 }
            r9.append(r11)     // Catch:{ all -> 0x0044 }
            goto L_0x0066
        L_0x008f:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ed }
            r10.<init>(r5)     // Catch:{ all -> 0x01ed }
            int r11 = r21.hashCode()     // Catch:{ all -> 0x01ed }
            r10.append(r11)     // Catch:{ all -> 0x01ed }
            r10.append(r4)     // Catch:{ all -> 0x01ed }
            r10.append(r9)     // Catch:{ all -> 0x01ed }
            java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x01ed }
            com.appsflyer.AFLogger r10 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x01ed }
            com.appsflyer.internal.AFg1cSDK r11 = com.appsflyer.internal.AFg1cSDK.HTTP_CLIENT     // Catch:{ all -> 0x01ed }
            r10.d(r11, r9)     // Catch:{ all -> 0x01ed }
            java.net.URL r9 = new java.net.URL     // Catch:{ all -> 0x01ed }
            java.lang.String r10 = r1.getMonetizationNetwork     // Catch:{ all -> 0x01ed }
            r9.<init>(r10)     // Catch:{ all -> 0x01ed }
            java.net.URLConnection r9 = r9.openConnection()     // Catch:{ all -> 0x01ed }
            java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ all -> 0x01ed }
            java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ all -> 0x01ed }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ all -> 0x01ed }
            java.lang.String r10 = r1.getRevenue     // Catch:{ all -> 0x00cf }
            r9.setRequestMethod(r10)     // Catch:{ all -> 0x00cf }
            boolean r10 = r21.getMonetizationNetwork()     // Catch:{ all -> 0x00cf }
            r11 = 0
            if (r10 == 0) goto L_0x00d5
            r9.setUseCaches(r11)     // Catch:{ all -> 0x00cf }
            goto L_0x00d5
        L_0x00cf:
            r0 = move-exception
            r10 = r20
        L_0x00d2:
            r8 = r9
            goto L_0x01f2
        L_0x00d5:
            boolean r10 = r21.component3()     // Catch:{ all -> 0x00cf }
            if (r10 != 0) goto L_0x00de
            r9.setInstanceFollowRedirects(r11)     // Catch:{ all -> 0x00cf }
        L_0x00de:
            r10 = r20
            int r12 = r10.getRevenue     // Catch:{ all -> 0x00f7 }
            int r13 = r1.component4     // Catch:{ all -> 0x00f7 }
            r14 = -1
            if (r13 == r14) goto L_0x00e8
            r12 = r13
        L_0x00e8:
            r9.setConnectTimeout(r12)     // Catch:{ all -> 0x00f7 }
            r9.setReadTimeout(r12)     // Catch:{ all -> 0x00f7 }
            boolean r12 = r21.AFAdRevenueData()     // Catch:{ all -> 0x00f7 }
            if (r12 == 0) goto L_0x00f9
            java.lang.String r12 = "application/octet-stream"
            goto L_0x00fb
        L_0x00f7:
            r0 = move-exception
            goto L_0x00d2
        L_0x00f9:
            java.lang.String r12 = "application/json"
        L_0x00fb:
            java.lang.String r13 = "Content-Type"
            r9.addRequestProperty(r13, r12)     // Catch:{ all -> 0x00f7 }
            java.util.Map<java.lang.String, java.lang.String> r12 = r1.AFAdRevenueData     // Catch:{ all -> 0x00f7 }
            java.util.Set r12 = r12.entrySet()     // Catch:{ all -> 0x00f7 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00f7 }
        L_0x010a:
            boolean r13 = r12.hasNext()     // Catch:{ all -> 0x00f7 }
            if (r13 == 0) goto L_0x0126
            java.lang.Object r13 = r12.next()     // Catch:{ all -> 0x00f7 }
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13     // Catch:{ all -> 0x00f7 }
            java.lang.Object r14 = r13.getKey()     // Catch:{ all -> 0x00f7 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x00f7 }
            java.lang.Object r13 = r13.getValue()     // Catch:{ all -> 0x00f7 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x00f7 }
            r9.setRequestProperty(r14, r13)     // Catch:{ all -> 0x00f7 }
            goto L_0x010a
        L_0x0126:
            r12 = 1
            if (r0 == 0) goto L_0x0159
            r9.setDoOutput(r12)     // Catch:{ all -> 0x00f7 }
            java.lang.String r13 = "Content-Length"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r14.<init>()     // Catch:{ all -> 0x00f7 }
            int r15 = r0.length     // Catch:{ all -> 0x00f7 }
            r14.append(r15)     // Catch:{ all -> 0x00f7 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00f7 }
            r9.setRequestProperty(r13, r14)     // Catch:{ all -> 0x00f7 }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0151 }
            java.io.OutputStream r14 = r9.getOutputStream()     // Catch:{ all -> 0x0151 }
            r13.<init>(r14)     // Catch:{ all -> 0x0151 }
            r13.write(r0)     // Catch:{ all -> 0x014e }
            r13.close()     // Catch:{ all -> 0x00f7 }
            goto L_0x0159
        L_0x014e:
            r0 = move-exception
            r8 = r13
            goto L_0x0153
        L_0x0151:
            r0 = move-exception
            r8 = 0
        L_0x0153:
            if (r8 == 0) goto L_0x0158
            r8.close()     // Catch:{ all -> 0x00f7 }
        L_0x0158:
            throw r0     // Catch:{ all -> 0x00f7 }
        L_0x0159:
            int r0 = r9.getResponseCode()     // Catch:{ all -> 0x00f7 }
            int r0 = r0 / 100
            r13 = 2
            if (r0 != r13) goto L_0x0165
            r17 = 1
            goto L_0x0167
        L_0x0165:
            r17 = 0
        L_0x0167:
            boolean r0 = r21.getMediationNetwork()     // Catch:{ all -> 0x00f7 }
            java.lang.String r11 = ""
            if (r0 == 0) goto L_0x0175
            java.lang.String r0 = getMediationNetwork(r9)     // Catch:{ all -> 0x00f7 }
            r15 = r0
            goto L_0x0176
        L_0x0175:
            r15 = r11
        L_0x0176:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00f7 }
            long r11 = r11 - r6
            com.appsflyer.internal.AFd1hSDK r0 = new com.appsflyer.internal.AFd1hSDK     // Catch:{ all -> 0x00f7 }
            r0.<init>(r11)     // Catch:{ all -> 0x00f7 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            java.lang.String r12 = "response code:"
            r11.<init>(r12)     // Catch:{ all -> 0x00f7 }
            int r12 = r9.getResponseCode()     // Catch:{ all -> 0x00f7 }
            r11.append(r12)     // Catch:{ all -> 0x00f7 }
            java.lang.String r12 = " "
            r11.append(r12)     // Catch:{ all -> 0x00f7 }
            java.lang.String r12 = r9.getResponseMessage()     // Catch:{ all -> 0x00f7 }
            r11.append(r12)     // Catch:{ all -> 0x00f7 }
            java.lang.String r12 = "\n body:"
            r11.append(r12)     // Catch:{ all -> 0x00f7 }
            r11.append(r15)     // Catch:{ all -> 0x00f7 }
            r11.append(r3)     // Catch:{ all -> 0x00f7 }
            long r12 = r0.getRevenue     // Catch:{ all -> 0x00f7 }
            r11.append(r12)     // Catch:{ all -> 0x00f7 }
            r11.append(r2)     // Catch:{ all -> 0x00f7 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00f7 }
            com.appsflyer.AFLogger r12 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x00f7 }
            com.appsflyer.internal.AFg1cSDK r13 = com.appsflyer.internal.AFg1cSDK.HTTP_CLIENT     // Catch:{ all -> 0x00f7 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f7 }
            r14.<init>(r5)     // Catch:{ all -> 0x00f7 }
            int r8 = r21.hashCode()     // Catch:{ all -> 0x00f7 }
            r14.append(r8)     // Catch:{ all -> 0x00f7 }
            r14.append(r4)     // Catch:{ all -> 0x00f7 }
            r14.append(r11)     // Catch:{ all -> 0x00f7 }
            java.lang.String r8 = r14.toString()     // Catch:{ all -> 0x00f7 }
            r12.d(r13, r8)     // Catch:{ all -> 0x00f7 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ all -> 0x00f7 }
            java.util.Map r11 = r9.getHeaderFields()     // Catch:{ all -> 0x00f7 }
            r8.<init>(r11)     // Catch:{ all -> 0x00f7 }
            r11 = 0
            r8.remove(r11)     // Catch:{ all -> 0x00f7 }
            com.appsflyer.internal.AFd1aSDK r11 = new com.appsflyer.internal.AFd1aSDK     // Catch:{ all -> 0x00f7 }
            int r16 = r9.getResponseCode()     // Catch:{ all -> 0x00f7 }
            r14 = r11
            r18 = r8
            r19 = r0
            r14.<init>(r15, r16, r17, r18, r19)     // Catch:{ all -> 0x00f7 }
            r9.disconnect()
            return r11
        L_0x01ed:
            r0 = move-exception
            r10 = r20
            r11 = 0
            r8 = r11
        L_0x01f2:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x023e }
            long r11 = r11 - r6
            com.appsflyer.internal.AFd1hSDK r6 = new com.appsflyer.internal.AFd1hSDK     // Catch:{ all -> 0x023e }
            r6.<init>(r11)     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            java.lang.String r9 = "error: "
            r7.<init>(r9)     // Catch:{ all -> 0x023e }
            r7.append(r0)     // Catch:{ all -> 0x023e }
            r7.append(r3)     // Catch:{ all -> 0x023e }
            long r11 = r6.getRevenue     // Catch:{ all -> 0x023e }
            r7.append(r11)     // Catch:{ all -> 0x023e }
            r7.append(r2)     // Catch:{ all -> 0x023e }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x023e }
            com.appsflyer.AFLogger r11 = com.appsflyer.AFLogger.INSTANCE     // Catch:{ all -> 0x023e }
            com.appsflyer.internal.AFg1cSDK r12 = com.appsflyer.internal.AFg1cSDK.HTTP_CLIENT     // Catch:{ all -> 0x023e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x023e }
            r3.<init>(r5)     // Catch:{ all -> 0x023e }
            int r1 = r21.hashCode()     // Catch:{ all -> 0x023e }
            r3.append(r1)     // Catch:{ all -> 0x023e }
            r3.append(r4)     // Catch:{ all -> 0x023e }
            r3.append(r2)     // Catch:{ all -> 0x023e }
            java.lang.String r13 = r3.toString()     // Catch:{ all -> 0x023e }
            r16 = 0
            r17 = 0
            r15 = 0
            r14 = r0
            r11.e(r12, r13, r14, r15, r16, r17)     // Catch:{ all -> 0x023e }
            com.appsflyer.internal.components.network.http.exceptions.HttpException r1 = new com.appsflyer.internal.components.network.http.exceptions.HttpException     // Catch:{ all -> 0x023e }
            r1.<init>(r0, r6)     // Catch:{ all -> 0x023e }
            throw r1     // Catch:{ all -> 0x023e }
        L_0x023e:
            r0 = move-exception
            if (r8 == 0) goto L_0x0244
            r8.disconnect()
        L_0x0244:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1jSDK.getMonetizationNetwork(com.appsflyer.internal.AFd1cSDK):com.appsflyer.internal.AFd1aSDK");
    }
}
