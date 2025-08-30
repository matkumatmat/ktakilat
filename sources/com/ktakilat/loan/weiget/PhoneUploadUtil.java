package com.ktakilat.loan.weiget;

import com.appsflyer.AppsFlyerLib;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.BaseKv;
import com.ktakilat.cbase.http.ApiInfoUtil;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trustdecision.mobrisk.TDRisk;
import java.util.List;

public class PhoneUploadUtil {

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$10  reason: invalid class name */
    class AnonymousClass10 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$11  reason: invalid class name */
    class AnonymousClass11 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$3  reason: invalid class name */
    class AnonymousClass3 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
            AppKv.g().b("location_list", (String) null);
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$4  reason: invalid class name */
    class AnonymousClass4 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$5  reason: invalid class name */
    class AnonymousClass5 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$6  reason: invalid class name */
    class AnonymousClass6 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$7  reason: invalid class name */
    class AnonymousClass7 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$8  reason: invalid class name */
    class AnonymousClass8 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.weiget.PhoneUploadUtil$9  reason: invalid class name */
    class AnonymousClass9 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    public static void a(TongDunEnum tongDunEnum) {
        String str;
        try {
            str = TDRisk.getBlackBox();
        } catch (Throwable unused) {
            str = null;
        }
        i(str, tongDunEnum.type);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [io.reactivex.Observer, java.lang.Object] */
    public static void b() {
        AppHttp.updateGaid((LifecycleTransformer<BaseResponse<Object>>) null).subscribe(new Object());
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [io.reactivex.Observer, java.lang.Object] */
    public static void c(BaseApplication baseApplication) {
        AppHttp.bindAppsflyerId((LifecycleTransformer<BaseResponse<Object>>) null, AppsFlyerLib.getInstance().getAppsFlyerUID(baseApplication)).subscribe(new Object());
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.Observer, java.lang.Object] */
    public static void d(String str) {
        AppHttp.uploadAppsflyerReferrer((LifecycleTransformer<BaseResponse<Object>>) null, str).subscribe(new Object());
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [io.reactivex.Observer, java.lang.Object] */
    public static void e() {
        String a2;
        ApiInfoUtil b = ApiInfoUtil.b();
        synchronized (b) {
            try {
                if (b.f470a != null) {
                    if (b.b == null) {
                    }
                    b.c.a(b.b);
                    BaseKv.a().b("device_ex_info", JsonUtil.a(b.b));
                    a2 = JsonUtil.a(b.b);
                }
                b.c();
                b.c.a(b.b);
                BaseKv.a().b("device_ex_info", JsonUtil.a(b.b));
                a2 = JsonUtil.a(b.b);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        AppHttp.uploadDevicesInfo((LifecycleTransformer<BaseResponse<Object>>) null, a2).subscribe(new Object());
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [io.reactivex.Observer, java.lang.Object] */
    public static void f() {
        List h = AppKv.h();
        if (h != null && !h.isEmpty()) {
            AppHttp.uploadLocationList((LifecycleTransformer<BaseResponse<Object>>) null, JsonUtil.a(h)).subscribe(new Object());
        }
    }

    /* JADX WARNING: type inference failed for: r0v16, types: [io.reactivex.Observer, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002b, code lost:
        if (android.net.ConnectivityManager.isNetworkTypeValid(r1) != false) goto L_0x002f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x021c A[SYNTHETIC, Splitter:B:121:0x021c] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0228 A[SYNTHETIC, Splitter:B:126:0x0228] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0282 A[SYNTHETIC, Splitter:B:160:0x0282] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x028e A[SYNTHETIC, Splitter:B:165:0x028e] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x02b0 A[SYNTHETIC, Splitter:B:171:0x02b0] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x02bc A[SYNTHETIC, Splitter:B:176:0x02bc] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02c9 A[SYNTHETIC, Splitter:B:182:0x02c9] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x02d5 A[SYNTHETIC, Splitter:B:187:0x02d5] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02e2 A[SYNTHETIC, Splitter:B:193:0x02e2] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02ee A[SYNTHETIC, Splitter:B:198:0x02ee] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x02fb A[SYNTHETIC, Splitter:B:204:0x02fb] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0303 A[Catch:{ IOException -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0155 A[SYNTHETIC, Splitter:B:45:0x0155] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x015d A[Catch:{ IOException -> 0x0159 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b4 A[SYNTHETIC, Splitter:B:82:0x01b4] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c0 A[SYNTHETIC, Splitter:B:87:0x01c0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(android.content.Context r8) {
        /*
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
            r0.<init>()
            java.lang.String r1 = "mac"
            java.lang.String r2 = com.ktakilat.loan.device.DeviceUtil.d(r8)
            r0.addProperty((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r8.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            r2 = -1
            if (r1 == 0) goto L_0x002e
            boolean r3 = r1.isAvailable()
            if (r3 == 0) goto L_0x002e
            int r1 = r1.getType()
            boolean r3 = android.net.ConnectivityManager.isNetworkTypeValid(r1)
            if (r3 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r1 = -1
        L_0x002f:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "net_mode"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            long r3 = com.ktakilat.loan.device.DeviceUtil.g()
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "memory_total"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r8.getSystemService(r1)
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1
            android.app.ActivityManager$MemoryInfo r3 = new android.app.ActivityManager$MemoryInfo
            r3.<init>()
            r1.getMemoryInfo(r3)
            long r3 = r3.availMem
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "memory_available"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            long r3 = com.ktakilat.loan.device.DeviceUtil.e()
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "sd_card_total"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            r3 = -1
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x009f }
            java.lang.String r5 = "mounted"
            boolean r1 = r1.equals(r5)     // Catch:{ Exception -> 0x009f }
            if (r1 == 0) goto L_0x00a5
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x009f }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x009f }
            android.os.StatFs r5 = new android.os.StatFs     // Catch:{ Exception -> 0x0098 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0098 }
            r5.restat(r1)     // Catch:{ Exception -> 0x0098 }
            int r1 = r5.getBlockSize()     // Catch:{ Exception -> 0x0098 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x0098 }
            int r1 = r5.getAvailableBlocks()     // Catch:{ Exception -> 0x0098 }
            long r3 = (long) r1
            long r3 = r3 * r6
            goto L_0x00a5
        L_0x0098:
            r1 = move-exception
            r1.toString()     // Catch:{ Exception -> 0x009f }
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ Exception -> 0x009f }
            goto L_0x00a5
        L_0x009f:
            r1 = move-exception
            r1.toString()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x00a5:
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "sd_card_available"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            long r3 = android.os.SystemClock.elapsedRealtime()
            r5 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r5
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "up_time"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.util.DisplayMetrics r3 = new android.util.DisplayMetrics
            r3.<init>()
            android.content.Context r8 = r8.getApplicationContext()
            android.content.res.Resources r8 = r8.getResources()
            android.util.DisplayMetrics r8 = r8.getDisplayMetrics()
            int r3 = r8.widthPixels
            int r4 = r8.heightPixels
            float r5 = r8.density
            float r6 = r8.xdpi
            float r8 = r8.ydpi
            r1.append(r3)
            java.lang.String r3 = ","
            r1.append(r3)
            r1.append(r4)
            r1.append(r3)
            r1.append(r5)
            r1.append(r3)
            r1.append(r6)
            r1.append(r3)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            java.lang.String r1 = "display_metrics"
            r0.addProperty((java.lang.String) r1, (java.lang.String) r8)
            int r8 = com.ktakilat.cbase.utils.CPUUtil.a()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r1 = "cpu_cores"
            r0.addProperty((java.lang.String) r1, (java.lang.Number) r8)
            r8 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x014b, all -> 0x0147 }
            java.lang.String r3 = "/proc/cpuinfo"
            r1.<init>(r3)     // Catch:{ IOException -> 0x014b, all -> 0x0147 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0144, all -> 0x013f }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0144, all -> 0x013f }
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x013d }
            java.lang.String r5 = ":\\s+"
            r6 = 2
            java.lang.String[] r4 = r4.split(r5, r6)     // Catch:{ IOException -> 0x013d }
            r5 = 1
            r4 = r4[r5]     // Catch:{ IOException -> 0x013d }
            r1.close()     // Catch:{ IOException -> 0x0133 }
            r3.close()     // Catch:{ IOException -> 0x0133 }
            goto L_0x0167
        L_0x0133:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
            goto L_0x0167
        L_0x013a:
            r8 = move-exception
            goto L_0x02f9
        L_0x013d:
            r4 = move-exception
            goto L_0x014e
        L_0x013f:
            r0 = move-exception
            r3 = r8
        L_0x0141:
            r8 = r0
            goto L_0x02f9
        L_0x0144:
            r4 = move-exception
            r3 = r8
            goto L_0x014e
        L_0x0147:
            r0 = move-exception
            r1 = r8
            r3 = r1
            goto L_0x0141
        L_0x014b:
            r4 = move-exception
            r1 = r8
            r3 = r1
        L_0x014e:
            r4.getMessage()     // Catch:{ all -> 0x013a }
            java.util.ArrayList r4 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ all -> 0x013a }
            if (r1 == 0) goto L_0x015b
            r1.close()     // Catch:{ IOException -> 0x0159 }
            goto L_0x015b
        L_0x0159:
            r1 = move-exception
            goto L_0x0161
        L_0x015b:
            if (r3 == 0) goto L_0x0166
            r3.close()     // Catch:{ IOException -> 0x0159 }
            goto L_0x0166
        L_0x0161:
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x0166:
            r4 = r8
        L_0x0167:
            java.lang.String r1 = "cpu_name"
            r0.addProperty((java.lang.String) r1, (java.lang.String) r4)
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x01aa, all -> 0x01a6 }
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"
            r1.<init>(r3)     // Catch:{ IOException -> 0x01aa, all -> 0x01a6 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x01a3, all -> 0x019e }
            r3.<init>(r1)     // Catch:{ IOException -> 0x01a3, all -> 0x019e }
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x019c }
            java.lang.String r4 = r4.trim()     // Catch:{ IOException -> 0x019c }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x019c }
            r1.close()     // Catch:{ IOException -> 0x0188 }
            goto L_0x018e
        L_0x0188:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x018e:
            r3.close()     // Catch:{ IOException -> 0x0192 }
            goto L_0x01cb
        L_0x0192:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
            goto L_0x01cb
        L_0x0199:
            r8 = move-exception
            goto L_0x02e0
        L_0x019c:
            r4 = move-exception
            goto L_0x01ad
        L_0x019e:
            r0 = move-exception
            r3 = r8
        L_0x01a0:
            r8 = r0
            goto L_0x02e0
        L_0x01a3:
            r4 = move-exception
            r3 = r8
            goto L_0x01ad
        L_0x01a6:
            r0 = move-exception
            r1 = r8
            r3 = r1
            goto L_0x01a0
        L_0x01aa:
            r4 = move-exception
            r1 = r8
            r3 = r1
        L_0x01ad:
            r4.getMessage()     // Catch:{ all -> 0x0199 }
            java.util.ArrayList r4 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ all -> 0x0199 }
            if (r1 == 0) goto L_0x01be
            r1.close()     // Catch:{ IOException -> 0x01b8 }
            goto L_0x01be
        L_0x01b8:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x01be:
            if (r3 == 0) goto L_0x01ca
            r3.close()     // Catch:{ IOException -> 0x01c4 }
            goto L_0x01ca
        L_0x01c4:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x01ca:
            r4 = -1
        L_0x01cb:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r3 = "cpu_max_freq"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x0212, all -> 0x020e }
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"
            r1.<init>(r3)     // Catch:{ IOException -> 0x0212, all -> 0x020e }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x020b, all -> 0x0206 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x020b, all -> 0x0206 }
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x0204 }
            java.lang.String r4 = r4.trim()     // Catch:{ IOException -> 0x0204 }
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x0204 }
            r1.close()     // Catch:{ IOException -> 0x01f0 }
            goto L_0x01f6
        L_0x01f0:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x01f6:
            r3.close()     // Catch:{ IOException -> 0x01fa }
            goto L_0x0233
        L_0x01fa:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
            goto L_0x0233
        L_0x0201:
            r8 = move-exception
            goto L_0x02c7
        L_0x0204:
            r4 = move-exception
            goto L_0x0215
        L_0x0206:
            r0 = move-exception
            r3 = r8
        L_0x0208:
            r8 = r0
            goto L_0x02c7
        L_0x020b:
            r4 = move-exception
            r3 = r8
            goto L_0x0215
        L_0x020e:
            r0 = move-exception
            r1 = r8
            r3 = r1
            goto L_0x0208
        L_0x0212:
            r4 = move-exception
            r1 = r8
            r3 = r1
        L_0x0215:
            r4.getMessage()     // Catch:{ all -> 0x0201 }
            java.util.ArrayList r4 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ all -> 0x0201 }
            if (r1 == 0) goto L_0x0226
            r1.close()     // Catch:{ IOException -> 0x0220 }
            goto L_0x0226
        L_0x0220:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x0226:
            if (r3 == 0) goto L_0x0232
            r3.close()     // Catch:{ IOException -> 0x022c }
            goto L_0x0232
        L_0x022c:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x0232:
            r4 = -1
        L_0x0233:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            java.lang.String r3 = "cpu_min_freq"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r1)
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ IOException -> 0x0278, all -> 0x0274 }
            java.lang.String r3 = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"
            r1.<init>(r3)     // Catch:{ IOException -> 0x0278, all -> 0x0274 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0271, all -> 0x026d }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0271, all -> 0x026d }
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x026b }
            java.lang.String r4 = r4.trim()     // Catch:{ IOException -> 0x026b }
            int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x026b }
            r1.close()     // Catch:{ IOException -> 0x0258 }
            goto L_0x025e
        L_0x0258:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x025e:
            r3.close()     // Catch:{ IOException -> 0x0262 }
            goto L_0x0294
        L_0x0262:
            r1 = move-exception
        L_0x0263:
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
            goto L_0x0294
        L_0x0269:
            r8 = move-exception
            goto L_0x02ae
        L_0x026b:
            r4 = move-exception
            goto L_0x027b
        L_0x026d:
            r0 = move-exception
            r3 = r8
        L_0x026f:
            r8 = r0
            goto L_0x02ae
        L_0x0271:
            r4 = move-exception
            r3 = r8
            goto L_0x027b
        L_0x0274:
            r0 = move-exception
            r1 = r8
            r3 = r1
            goto L_0x026f
        L_0x0278:
            r4 = move-exception
            r1 = r8
            r3 = r1
        L_0x027b:
            r4.getMessage()     // Catch:{ all -> 0x0269 }
            java.util.ArrayList r4 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ all -> 0x0269 }
            if (r1 == 0) goto L_0x028c
            r1.close()     // Catch:{ IOException -> 0x0286 }
            goto L_0x028c
        L_0x0286:
            r1 = move-exception
            r1.getMessage()
            java.util.ArrayList r1 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x028c:
            if (r3 == 0) goto L_0x0294
            r3.close()     // Catch:{ IOException -> 0x0292 }
            goto L_0x0294
        L_0x0292:
            r1 = move-exception
            goto L_0x0263
        L_0x0294:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "cpu_cur_freq"
            r0.addProperty((java.lang.String) r2, (java.lang.Number) r1)
            java.lang.String r0 = r0.toString()
            io.reactivex.Observable r8 = com.ktakilat.loan.http.AppHttp.uploadDevices(r8, r0)
            com.ktakilat.loan.weiget.PhoneUploadUtil$4 r0 = new com.ktakilat.loan.weiget.PhoneUploadUtil$4
            r0.<init>()
            r8.subscribe(r0)
            return
        L_0x02ae:
            if (r1 == 0) goto L_0x02ba
            r1.close()     // Catch:{ IOException -> 0x02b4 }
            goto L_0x02ba
        L_0x02b4:
            r0 = move-exception
            r0.getMessage()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x02ba:
            if (r3 == 0) goto L_0x02c6
            r3.close()     // Catch:{ IOException -> 0x02c0 }
            goto L_0x02c6
        L_0x02c0:
            r0 = move-exception
            r0.getMessage()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x02c6:
            throw r8
        L_0x02c7:
            if (r1 == 0) goto L_0x02d3
            r1.close()     // Catch:{ IOException -> 0x02cd }
            goto L_0x02d3
        L_0x02cd:
            r0 = move-exception
            r0.getMessage()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x02d3:
            if (r3 == 0) goto L_0x02df
            r3.close()     // Catch:{ IOException -> 0x02d9 }
            goto L_0x02df
        L_0x02d9:
            r0 = move-exception
            r0.getMessage()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x02df:
            throw r8
        L_0x02e0:
            if (r1 == 0) goto L_0x02ec
            r1.close()     // Catch:{ IOException -> 0x02e6 }
            goto L_0x02ec
        L_0x02e6:
            r0 = move-exception
            r0.getMessage()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x02ec:
            if (r3 == 0) goto L_0x02f8
            r3.close()     // Catch:{ IOException -> 0x02f2 }
            goto L_0x02f8
        L_0x02f2:
            r0 = move-exception
            r0.getMessage()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x02f8:
            throw r8
        L_0x02f9:
            if (r1 == 0) goto L_0x0301
            r1.close()     // Catch:{ IOException -> 0x02ff }
            goto L_0x0301
        L_0x02ff:
            r0 = move-exception
            goto L_0x0307
        L_0x0301:
            if (r3 == 0) goto L_0x030c
            r3.close()     // Catch:{ IOException -> 0x02ff }
            goto L_0x030c
        L_0x0307:
            r0.getMessage()
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
        L_0x030c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.weiget.PhoneUploadUtil.g(android.content.Context):void");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [io.reactivex.Observer, java.lang.Object] */
    public static void h(String str) {
        AppHttp.uploadThirdException((LifecycleTransformer<BaseResponse<Object>>) null, str).subscribe(new Object());
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [io.reactivex.Observer, java.lang.Object] */
    public static void i(String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tongdunKey", str);
        jsonObject.addProperty("sceneType", str2);
        AppHttp.uploadTondun((LifecycleTransformer<BaseResponse<Object>>) null, jsonObject.toString()).subscribe(new Object());
    }
}
