package com.ktakilat.loan;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.net.HttpHeaders;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.checkvalue.CheckValueManager;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.datacollect.PCollectorManager;
import com.ktakilat.cbase.http.ApiInfoUtil;
import com.ktakilat.cbase.http.ApiManager;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.http.phone.DeviceExInfo;
import com.ktakilat.cbase.http.phone.DeviceInfo;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.loan.device.DeviceUtil;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.global.Config;
import com.ktakilat.loan.global.H5Kv;
import com.ktakilat.loan.http.user.UserInfo;
import com.ktakilat.loan.login_face.BaseLoginActivity;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;
import com.ktakilat.loan.webtool.FixWebProcess;
import com.ktakilat.loan.weiget.ErrorCaseUpload;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.ktakilat.loan.weiget.PushTokenUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

public class KtakilatApplication extends BaseApplication {
    public static InstallReferrerClient j;
    public static volatile Boolean k;
    public static volatile Boolean l;
    public static KtakilatApplication m;
    public boolean g = false;
    public final Handler i = new Handler(Looper.getMainLooper());

    /* renamed from: com.ktakilat.loan.KtakilatApplication$1  reason: invalid class name */
    class AnonymousClass1 implements CheckValueManager.CheckValueCall {
        public final void a(String str) {
            ErrorCaseUpload.a(str);
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$10  reason: invalid class name */
    class AnonymousClass10 extends ApiObserver<BaseResponse<Object>> {
        public final void a(BaseResponse baseResponse) {
        }

        public final void b(BaseResponse baseResponse) {
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$2  reason: invalid class name */
    class AnonymousClass2 implements ApiInfoUtil.DeviceInfoCall {
        public final void a(DeviceExInfo deviceExInfo) {
            InstallReferrerClient installReferrerClient = KtakilatApplication.j;
            DeviceUtil.c(BaseApplication.e, deviceExInfo);
        }

        public final void b(DeviceInfo deviceInfo) {
            deviceInfo.mac = AppKv.g().f465a.getString("mac_address", "");
            deviceInfo.adChannel = AppKv.b();
            deviceInfo.adId = AppKv.d();
        }

        /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[Catch:{ Exception -> 0x00b6 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c(com.ktakilat.cbase.http.phone.DeviceInfo r8, com.ktakilat.cbase.http.phone.DeviceExInfo r9) {
            /*
                r7 = this;
                java.lang.String r0 = "phone"
                java.lang.String r1 = ""
                java.lang.String r2 = "KtaKilat"
                r8.appName = r2
                java.lang.String r2 = "5.3.4"
                com.ktakilat.cbase.datacollect.PCollectorManager.g = r2
                r8.appVersion = r2
                java.lang.String r2 = "ID"
                r8.countryCode = r2
                java.lang.String r2 = "Indonesia"
                r8.countryName = r2
                java.lang.String r2 = android.os.Build.MANUFACTURER
                r8.phoneBrand = r2
                java.lang.String r2 = android.os.Build.MODEL
                com.ktakilat.cbase.datacollect.PCollectorManager.c = r2
                r8.phoneBrandModel = r2
                com.android.installreferrer.api.InstallReferrerClient r2 = com.ktakilat.loan.KtakilatApplication.j
                com.ktakilat.cbase.ui.BaseApplication r2 = com.ktakilat.cbase.ui.BaseApplication.e
                java.lang.Object r2 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x0066 }
                android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch:{ Exception -> 0x0066 }
                if (r2 == 0) goto L_0x0066
                java.lang.String r2 = r2.getDeviceId()     // Catch:{ Exception -> 0x0066 }
                int r3 = r2.length()     // Catch:{ Exception -> 0x0066 }
                r4 = 15
                if (r3 != r4) goto L_0x0039
                goto L_0x0067
            L_0x0039:
                int r3 = r2.length()     // Catch:{ Exception -> 0x0066 }
                java.lang.String r4 = "[0-9]+"
                r5 = 14
                if (r3 != r5) goto L_0x004e
                boolean r3 = r2.matches(r4)     // Catch:{ Exception -> 0x0066 }
                if (r3 == 0) goto L_0x004e
                java.lang.String r2 = com.ktakilat.cbase.utils.TelephonyUtils.b(r2)     // Catch:{ Exception -> 0x0066 }
                goto L_0x0067
            L_0x004e:
                int r3 = r2.length()     // Catch:{ Exception -> 0x0066 }
                r6 = 16
                if (r3 != r6) goto L_0x0067
                boolean r3 = r2.matches(r4)     // Catch:{ Exception -> 0x0066 }
                if (r3 == 0) goto L_0x0067
                r3 = 0
                java.lang.String r2 = r2.substring(r3, r5)     // Catch:{ Exception -> 0x0066 }
                java.lang.String r2 = com.ktakilat.cbase.utils.TelephonyUtils.b(r2)     // Catch:{ Exception -> 0x0066 }
                goto L_0x0067
            L_0x0066:
                r2 = r1
            L_0x0067:
                com.ktakilat.cbase.ui.BaseApplication r3 = com.ktakilat.cbase.ui.BaseApplication.e
                java.lang.String r3 = com.ktakilat.loan.device.DeviceUtil.b(r3)
                com.ktakilat.cbase.datacollect.PCollectorManager.b = r3     // Catch:{ Exception -> 0x0073 }
                java.lang.String r4 = r8.phoneBrand     // Catch:{ Exception -> 0x0073 }
                com.ktakilat.cbase.datacollect.PCollectorManager.d = r4     // Catch:{ Exception -> 0x0073 }
            L_0x0073:
                com.ktakilat.cbase.cache.KvSave r4 = com.ktakilat.loan.global.AppKv.g()
                com.tencent.mmkv.MMKV r4 = r4.f465a
                java.lang.String r5 = "uuid"
                java.lang.String r4 = r4.getString(r5, r1)
                boolean r6 = android.text.TextUtils.isEmpty(r4)
                if (r6 != 0) goto L_0x0088
                r8.uuid = r4
                goto L_0x00a6
            L_0x0088:
                boolean r4 = android.text.TextUtils.isEmpty(r2)
                java.lang.String r6 = "_"
                if (r4 != 0) goto L_0x0097
                java.lang.String r4 = defpackage.e.m(r2, r6, r3)
                r8.uuid = r4
                goto L_0x009d
            L_0x0097:
                java.lang.String r4 = defpackage.e.m(r3, r6, r3)
                r8.uuid = r4
            L_0x009d:
                java.lang.String r4 = r8.uuid
                com.ktakilat.cbase.cache.KvSave r6 = com.ktakilat.loan.global.AppKv.g()
                r6.b(r5, r4)
            L_0x00a6:
                r8.imei = r2
                com.ktakilat.cbase.ui.BaseApplication r2 = com.ktakilat.cbase.ui.BaseApplication.e
                java.lang.Object r0 = r2.getSystemService(r0)     // Catch:{ Exception -> 0x00b6 }
                android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ Exception -> 0x00b6 }
                if (r0 == 0) goto L_0x00b6
                java.lang.String r1 = r0.getSubscriberId()     // Catch:{ Exception -> 0x00b6 }
            L_0x00b6:
                r8.imsi = r1
                r8.androidId = r3
                java.lang.String r0 = "android"
                r8.systemPlatform = r0
                java.lang.String r0 = android.os.Build.VERSION.RELEASE
                r8.systemVersion = r0
                java.lang.String r0 = "google play"
                r8.deliveryPlatform = r0
                java.lang.String r0 = com.ktakilat.loan.global.AppKv.d()
                r8.adId = r0
                com.ktakilat.cbase.ui.BaseApplication r0 = com.ktakilat.cbase.ui.BaseApplication.e
                java.lang.String r0 = com.ktakilat.loan.device.DeviceUtil.d(r0)
                com.ktakilat.cbase.cache.KvSave r1 = com.ktakilat.loan.global.AppKv.g()
                java.lang.String r2 = "mac_address"
                r1.b(r2, r0)
                r8.mac = r0
                java.lang.String r0 = com.ktakilat.loan.global.AppKv.b()
                r8.adChannel = r0
                r8.deviceNo = r3
                java.lang.String r0 = "com.ktakilat.loan"
                com.ktakilat.cbase.datacollect.PCollectorManager.f = r0
                r8.packageName = r0
                int r0 = com.ktakilat.cbase.utils.CPUUtil.a()
                r8.cpuCores = r0
                long r0 = com.ktakilat.loan.device.DeviceUtil.g()
                r8.memoryTotal = r0
                long r0 = com.ktakilat.loan.device.DeviceUtil.e()
                r8.sdCardTotal = r0
                com.ktakilat.cbase.ui.BaseApplication r8 = com.ktakilat.cbase.ui.BaseApplication.e
                com.ktakilat.loan.device.DeviceUtil.c(r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.KtakilatApplication.AnonymousClass2.c(com.ktakilat.cbase.http.phone.DeviceInfo, com.ktakilat.cbase.http.phone.DeviceExInfo):void");
        }

        public final BaseApplication getContext() {
            InstallReferrerClient installReferrerClient = KtakilatApplication.j;
            return BaseApplication.e;
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$3  reason: invalid class name */
    class AnonymousClass3 extends OnSafeClickListener {
        public final void a(View view) {
            view.getContext();
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$4  reason: invalid class name */
    class AnonymousClass4 implements WebCookieManager.CookieCallback {
        public final void d() {
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$6  reason: invalid class name */
    class AnonymousClass6 implements Observer<String> {
        public final void onComplete() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
            String str = (String) obj;
            if (str != null) {
                KtakilatApplication.g(str);
            }
        }

        public final void onSubscribe(Disposable disposable) {
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$7  reason: invalid class name */
    class AnonymousClass7 implements Runnable {

        /* renamed from: com.ktakilat.loan.KtakilatApplication$7$1  reason: invalid class name */
        class AnonymousClass1 implements AppsFlyerConversionListener {
            public final void onAppOpenAttribution(Map map) {
            }

            public final void onAttributionFailure(String str) {
            }

            public final void onConversionDataFail(String str) {
            }

            public final void onConversionDataSuccess(Map map) {
                for (String str : map.keySet()) {
                    Objects.toString(map.get(str));
                    if (TextUtils.equals(str, "media_source")) {
                        AppKv.g().b(AppsFlyerProperties.CHANNEL, String.valueOf(map.get(str)));
                    }
                    TextUtils.equals(str, "campaign");
                }
                map.toString();
                InstallReferrerClient installReferrerClient = KtakilatApplication.j;
                PhoneUploadUtil.c(BaseApplication.e);
            }
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [com.appsflyer.AppsFlyerConversionListener, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v8, types: [java.lang.Object, com.ktakilat.loan.KtakilatApplication$CrashHandler] */
        public final void run() {
            ? obj = new Object();
            InstallReferrerClient installReferrerClient = KtakilatApplication.j;
            DataCollectManager.a(BaseApplication.e, obj);
            if (CrashHandler.f485a == null) {
                CrashHandler.f485a = new Object();
            }
            CrashHandler crashHandler = CrashHandler.f485a;
            crashHandler.getClass();
            Thread.setDefaultUncaughtExceptionHandler(crashHandler);
            Typeface createFromAsset = Typeface.createFromAsset(BaseApplication.e.getAssets(), "fonts/Roboto-Regular.ttf");
            try {
                Field declaredField = Typeface.class.getDeclaredField("MONOSPACE");
                declaredField.setAccessible(true);
                declaredField.set((Object) null, createFromAsset);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$8  reason: invalid class name */
    class AnonymousClass8 implements InstallReferrerStateListener {
        public final void onInstallReferrerServiceDisconnected() {
        }

        public final void onInstallReferrerSetupFinished(int i) {
            if (i == 0) {
                try {
                    ReferrerDetails installReferrer = KtakilatApplication.j.getInstallReferrer();
                    installReferrer.getInstallReferrer();
                    installReferrer.getReferrerClickTimestampSeconds();
                    installReferrer.getInstallBeginTimestampSeconds();
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("install_referrer", installReferrer.getInstallReferrer());
                    jsonObject.addProperty("install_begin_timestamp_seconds", (Number) Long.valueOf(installReferrer.getInstallBeginTimestampSeconds()));
                    jsonObject.addProperty("referrer_click_timestamp_seconds", (Number) Long.valueOf(installReferrer.getReferrerClickTimestampSeconds()));
                    jsonObject.addProperty("install_version", installReferrer.getInstallVersion());
                    jsonObject.addProperty("google_play_instant", Boolean.valueOf(installReferrer.getGooglePlayInstantParam()));
                    jsonObject.addProperty("install_begin_timestamp_server_seconds", (Number) Long.valueOf(installReferrer.getInstallBeginTimestampServerSeconds()));
                    jsonObject.addProperty("referrer_click_timestamp_server_seconds", (Number) Long.valueOf(installReferrer.getReferrerClickTimestampServerSeconds()));
                    PhoneUploadUtil.d(jsonObject.toString());
                } catch (Exception e) {
                    e.toString();
                    ArrayList arrayList = LogActivity.k;
                }
                try {
                    KtakilatApplication.j.endConnection();
                } catch (Exception e2) {
                    e2.toString();
                    ArrayList arrayList2 = LogActivity.k;
                }
            } else if (i == 1) {
                try {
                    KtakilatApplication.j.endConnection();
                } catch (Exception e3) {
                    e3.toString();
                    ArrayList arrayList3 = LogActivity.k;
                }
            } else if (i != 2) {
                try {
                    KtakilatApplication.j.endConnection();
                } catch (Exception e4) {
                    e4.toString();
                    ArrayList arrayList4 = LogActivity.k;
                }
            } else {
                try {
                    KtakilatApplication.j.endConnection();
                } catch (Exception e5) {
                    e5.toString();
                    ArrayList arrayList5 = LogActivity.k;
                }
            }
        }
    }

    /* renamed from: com.ktakilat.loan.KtakilatApplication$9  reason: invalid class name */
    class AnonymousClass9 implements OnCompleteListener<String> {
        public final void onComplete(Task task) {
            String str;
            if (!task.isSuccessful()) {
                str = null;
            } else {
                str = (String) task.getResult();
            }
            if (TextUtils.isEmpty(Config.f495a) && !TextUtils.isEmpty(str)) {
                Config.f495a = str;
                PushTokenUtil.a(str);
            }
        }
    }

    public static class CrashHandler implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        public static CrashHandler f485a;

        public final void uncaughtException(Thread thread, Throwable th) {
            if (th != null) {
                Throwable th2 = th;
                while (true) {
                    if (th2 == null) {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th.printStackTrace(printWriter);
                        printWriter.flush();
                        stringWriter.toString();
                        break;
                    } else if (th2 instanceof UnknownHostException) {
                        break;
                    } else {
                        th2 = th2.getCause();
                    }
                }
            }
            DataCollectManager.c(th);
            ArrayList arrayList = LogActivity.k;
            System.exit(1);
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        k = bool;
        l = bool;
    }

    public static void b(WebCookieManager.CookieCallback cookieCallback) {
        DataCollectManager.d("");
        ApiManager.b().a(HttpHeaders.AUTHORIZATION, (String) null);
        AppKv.l((UserInfo) null);
        WebCookieManager.a(cookieCallback);
    }

    public static void c() {
        BaseApplication.f = Boolean.TRUE;
        ArrayList arrayList = BaseApplication.e.d;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && !((Activity) weakReference.get()).isFinishing() && !((Activity) weakReference.get()).isDestroyed()) {
                    "finish act = ".concat(((Activity) weakReference.get()).getClass().getName());
                    ((Activity) weakReference.get()).finish();
                }
            }
        }
    }

    public static void d() {
        ArrayList arrayList = BaseApplication.e.d;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference != null && weakReference.get() != null && !(weakReference.get() instanceof HomeActivity) && !((Activity) weakReference.get()).isFinishing() && !((Activity) weakReference.get()).isDestroyed()) {
                    ((Activity) weakReference.get()).finish();
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.android.installreferrer.api.InstallReferrerStateListener, java.lang.Object] */
    public static synchronized void e() {
        synchronized (KtakilatApplication.class) {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(BaseApplication.e).build();
            j = build;
            build.startConnection(new Object());
        }
    }

    public static UserInfo f() {
        UserInfo k2 = AppKv.k();
        if (k2 != null && !TextUtils.isEmpty(k2.getToken())) {
            DataCollectManager.d(k2.getUserId());
            ApiManager.b().a(HttpHeaders.AUTHORIZATION, k2.getToken());
        }
        return k2;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [io.reactivex.Observer, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Object, java.lang.Runnable] */
    /* JADX WARNING: type inference failed for: r2v10, types: [io.reactivex.ObservableOnSubscribe, java.lang.Object] */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:6|7|8|9|10|(1:12)|13|(2:15|16)|17|21) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0037 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d A[Catch:{ Exception -> 0x004c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.String r2) {
        /*
            java.lang.Boolean r0 = l
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            if (r2 == 0) goto L_0x007c
            com.ktakilat.cbase.cache.KvSave r0 = com.ktakilat.loan.global.AppKv.g()
            java.lang.String r1 = "gaid"
            r0.b(r1, r2)
            java.lang.Boolean r2 = l
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x001e
            goto L_0x009c
        L_0x001e:
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            l = r2
            java.lang.Thread r2 = new java.lang.Thread
            com.ktakilat.loan.KtakilatApplication$7 r0 = new com.ktakilat.loan.KtakilatApplication$7
            r0.<init>()
            r2.<init>(r0)
            r2.start()
            com.ktakilat.loan.KtakilatApplication r2 = m     // Catch:{ Exception -> 0x0037 }
            r2.getClass()     // Catch:{ Exception -> 0x0037 }
            f()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x004c }
            r0 = 24
            if (r2 < r0) goto L_0x004c
            android.os.StrictMode$VmPolicy$Builder r2 = new android.os.StrictMode$VmPolicy$Builder     // Catch:{ Exception -> 0x004c }
            r2.<init>()     // Catch:{ Exception -> 0x004c }
            android.os.StrictMode$VmPolicy r0 = r2.build()     // Catch:{ Exception -> 0x004c }
            android.os.StrictMode.setVmPolicy(r0)     // Catch:{ Exception -> 0x004c }
            r2.detectFileUriExposure()     // Catch:{ Exception -> 0x004c }
        L_0x004c:
            java.lang.String r2 = "122389081753608"
            com.facebook.FacebookSdk.setApplicationId(r2)     // Catch:{ Exception -> 0x005b }
            com.ktakilat.cbase.ui.BaseApplication r2 = com.ktakilat.cbase.ui.BaseApplication.e     // Catch:{ Exception -> 0x005b }
            com.facebook.FacebookSdk.sdkInitialize(r2)     // Catch:{ Exception -> 0x005b }
            com.ktakilat.cbase.ui.BaseApplication r2 = com.ktakilat.cbase.ui.BaseApplication.e     // Catch:{ Exception -> 0x005b }
            com.facebook.appevents.AppEventsLogger.activateApp((android.content.Context) r2)     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            com.ktakilat.loan.a r2 = new com.ktakilat.loan.a
            r2.<init>()
            io.reactivex.Observable r2 = io.reactivex.Observable.create(r2)
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.e
            io.reactivex.Observable r2 = r2.subscribeOn(r0)
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.a()
            io.reactivex.Observable r2 = r2.observeOn(r0)
            t9 r0 = new t9
            r1 = 4
            r0.<init>((int) r1)
            r2.subscribe(r0)
            goto L_0x009c
        L_0x007c:
            t9 r2 = new t9
            r0 = 3
            r2.<init>((int) r0)
            io.reactivex.Observable r2 = io.reactivex.Observable.create(r2)
            io.reactivex.Scheduler r0 = io.reactivex.schedulers.Schedulers.c
            io.reactivex.Observable r2 = r2.subscribeOn(r0)
            io.reactivex.Scheduler r0 = io.reactivex.android.schedulers.AndroidSchedulers.a()
            io.reactivex.Observable r2 = r2.observeOn(r0)
            com.ktakilat.loan.KtakilatApplication$6 r0 = new com.ktakilat.loan.KtakilatApplication$6
            r0.<init>()
            r2.subscribe(r0)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.KtakilatApplication.g(java.lang.String):void");
    }

    public static boolean h() {
        UserInfo k2 = AppKv.k();
        if (k2 == null || TextUtils.isEmpty(k2.getToken())) {
            return false;
        }
        return true;
    }

    public static void j() {
        try {
            if (!BaseApplication.e.getCacheDir().exists()) {
                BaseApplication.e.getCacheDir().mkdirs();
            }
        } catch (Exception unused) {
        }
    }

    public static void k(String str, String str2, String str3, WebCookieManager.CookieCallback cookieCallback) {
        Config.f495a = null;
        DataCollectManager.d(str2);
        KtaCollect.n_app_log_in();
        ApiManager.b().a(HttpHeaders.AUTHORIZATION, str);
        AppKv.l(new UserInfo(str, str2, str3));
        AppKv.g().f465a.putBoolean("has-login", true);
        WebCookieManager.a(cookieCallback);
    }

    public final void a(int i2) {
        if (i2 > 0 && !this.g) {
            this.g = true;
            KtaCollect.n_app_wake_from_the_background();
        } else if (i2 <= 0 && this.g) {
            this.g = false;
            KtaCollect.n_app_exit_to_the_background();
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.ktakilat.loan.weiget.WebCookieManager$CookieCallback, java.lang.Object] */
    public final void i() {
        KtakilatApplication ktakilatApplication = m;
        ? obj = new Object();
        ktakilatApplication.getClass();
        b(obj);
        this.i.postDelayed(new Runnable() {
            public final void run() {
                InstallReferrerClient installReferrerClient = KtakilatApplication.j;
                ArrayList arrayList = KtakilatApplication.this.d;
                if (arrayList != null && arrayList.size() > 0) {
                    WeakReference weakReference = (WeakReference) arrayList.get(arrayList.size() - 1);
                    if (weakReference == null || weakReference.get() == null || (!(weakReference.get() instanceof MobileCheckV2Activity) && !(weakReference.get() instanceof BaseLoginActivity) && !(weakReference.get() instanceof RegistOtpActivity))) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            WeakReference weakReference2 = (WeakReference) it.next();
                            if (weakReference2 != null && weakReference2.get() != null && !((Activity) weakReference2.get()).isFinishing() && !((Activity) weakReference2.get()).isDestroyed()) {
                                if (!(weakReference2.get() instanceof HomeActivity)) {
                                    ((Activity) weakReference2.get()).finish();
                                } else {
                                    ((HomeActivity) weakReference2.get()).A();
                                }
                            }
                        }
                        Intent intent = new Intent(BaseApplication.e, HomeActivity.class);
                        intent.putExtra("isNeedCheckAndJumpLogin", true);
                        intent.addFlags(268435456);
                        BaseApplication.e.startActivity(intent);
                    }
                }
            }
        }, 200);
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [com.ktakilat.cbase.checkvalue.CheckValueManager$CheckValueCall, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r2v4, types: [com.ktakilat.cbase.http.ApiInfoUtil$DeviceInfoCall, java.lang.Object] */
    public final void onCreate() {
        super.onCreate();
        BaseApplication.f = Boolean.FALSE;
        m = this;
        j();
        if (Build.VERSION.SDK_INT >= 28) {
            String str = "";
            try {
                String r = Application.getProcessName();
                if (!TextUtils.equals(getPackageName(), r)) {
                    if (TextUtils.isEmpty(r)) {
                        r = getPackageName();
                    }
                    WebView.setDataDirectorySuffix(r);
                    str = "_" + r;
                }
                FixWebProcess.a(this, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        H5Kv.a().f465a.clearAll();
        ResponseCodeDeal.b = BaseApplication.e;
        ResponseCodeDeal.f473a = new lb(this, 0);
        ? obj = new Object();
        ExecutorService executorService = CheckValueManager.f466a;
        synchronized (CheckValueManager.class) {
            CheckValueManager.b = obj;
        }
        String d = AppKv.d();
        if (!TextUtils.isEmpty(d)) {
            PCollectorManager.i = d;
        }
        ApiInfoUtil.b().d(new Object());
        ApiManager.b().a(HttpHeaders.ACCEPT_LANGUAGE, "in-ID");
        ArrayList arrayList = LogActivity.k;
        if (AppKv.g().f465a.getBoolean("isCanUse", false)) {
            g((String) null);
        }
    }
}
