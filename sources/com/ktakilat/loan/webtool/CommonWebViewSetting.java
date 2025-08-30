package com.ktakilat.loan.webtool;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.MimeTypeMap;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.places.model.PlaceFields;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.global.Domain;
import com.ktakilat.loan.service.sms.SmsVerificationService;
import com.ktakilat.loan.service.sms.SmsVerifyCodeReceiver;
import com.ktakilat.loan.web.CommonWebPopActivity;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.CharEncoding;

public class CommonWebViewSetting {

    /* renamed from: a  reason: collision with root package name */
    public File f574a;
    public boolean b = false;
    public int c = 0;
    public final BaseActivity d;
    public CommonWebView e;
    public boolean f = false;
    public CountDownTimer g;
    public SmsVerifyCodeReceiver h;
    public OnCommonWebViewSettingEventListener i;
    public final Handler j = new Handler(Looper.getMainLooper());
    public String k;

    public class JsCallAndroidInterface {

        /* renamed from: a  reason: collision with root package name */
        public final CommonWebView f577a;
        public final BaseActivity b;
        public final OnCommonWebViewSettingEventListener c;
        public final GestureUtil d;
        public final FaceLoginOnOffUtil e;

        /* renamed from: com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$3  reason: invalid class name */
        public class AnonymousClass3 implements Runnable {

            /* renamed from: com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$3$1  reason: invalid class name */
            class AnonymousClass1 implements WebCookieManager.CookieCallback {
                public final void d() {
                }
            }

            /* JADX WARNING: type inference failed for: r1v0, types: [com.ktakilat.loan.weiget.WebCookieManager$CookieCallback, java.lang.Object] */
            public final void run() {
                KtakilatApplication ktakilatApplication = KtakilatApplication.m;
                ? obj = new Object();
                ktakilatApplication.getClass();
                KtakilatApplication.b(obj);
            }
        }

        public JsCallAndroidInterface(BaseActivity baseActivity, CommonWebView commonWebView, OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener) {
            this.f577a = commonWebView;
            this.b = baseActivity;
            this.c = onCommonWebViewSettingEventListener;
            this.d = new GestureUtil(baseActivity);
            this.e = new FaceLoginOnOffUtil(baseActivity);
        }

        /* JADX WARNING: type inference failed for: r2v44, types: [java.lang.Object, java.lang.Runnable] */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String jsCallCommon(java.lang.String r27, java.lang.String r28) {
            /*
                r26 = this;
                r1 = r26
                r2 = r27
                r3 = r28
                java.lang.String r13 = "5.3.4"
                java.lang.String r14 = "isScrollEnable"
                com.ktakilat.loan.webtool.CommonWebViewSetting r15 = com.ktakilat.loan.webtool.CommonWebViewSetting.this
                com.android.installreferrer.api.InstallReferrerClient r0 = com.ktakilat.loan.KtakilatApplication.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.ui.BaseApplication r0 = com.ktakilat.cbase.ui.BaseApplication.e     // Catch:{ Exception -> 0x004a }
                java.util.ArrayList r8 = r0.d     // Catch:{ Exception -> 0x004a }
                com.google.gson.JsonObject r16 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x004a }
                r16.<init>()     // Catch:{ Exception -> 0x004a }
                boolean r0 = com.ktakilat.loan.webtool.CommonWebViewSetting.a(r15, r3)     // Catch:{ Exception -> 0x0026 }
                if (r0 == 0) goto L_0x0028
                com.google.gson.JsonElement r0 = com.google.gson.JsonParser.parseString(r28)     // Catch:{ Exception -> 0x0026 }
                com.google.gson.JsonObject r16 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x0026 }
                goto L_0x0028
            L_0x0026:
                r0 = move-exception
                goto L_0x002b
            L_0x0028:
                r0 = r16
                goto L_0x002f
            L_0x002b:
                com.ktakilat.cbase.utils.LogUtil.a(r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x0028
            L_0x002f:
                com.google.gson.JsonObject r5 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x004a }
                r5.<init>()     // Catch:{ Exception -> 0x004a }
                int r17 = r27.hashCode()     // Catch:{ Exception -> 0x004a }
                r18 = 0
                switch(r17) {
                    case -2073092409: goto L_0x0169;
                    case -2050082469: goto L_0x015e;
                    case -1915886140: goto L_0x0153;
                    case -1701046071: goto L_0x0148;
                    case -1535272691: goto L_0x013e;
                    case -1251609234: goto L_0x0134;
                    case -1183046236: goto L_0x0129;
                    case -1038933882: goto L_0x011f;
                    case -1005034362: goto L_0x0114;
                    case -954130694: goto L_0x0109;
                    case -615968815: goto L_0x00fe;
                    case -506961628: goto L_0x00f2;
                    case -482515612: goto L_0x00e6;
                    case -357638142: goto L_0x00da;
                    case -307857532: goto L_0x00ce;
                    case -237568069: goto L_0x00c3;
                    case -160760533: goto L_0x00b7;
                    case -75605984: goto L_0x00ab;
                    case 8171422: goto L_0x009f;
                    case 94756344: goto L_0x0094;
                    case 110532135: goto L_0x0088;
                    case 242672169: goto L_0x007c;
                    case 242723862: goto L_0x0070;
                    case 309659947: goto L_0x0065;
                    case 859984188: goto L_0x0059;
                    case 1532142616: goto L_0x004d;
                    case 1811096719: goto L_0x003f;
                    default: goto L_0x003d;
                }     // Catch:{ Exception -> 0x004a }
            L_0x003d:
                goto L_0x0174
            L_0x003f:
                java.lang.String r6 = "getUserInfo"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 1
                goto L_0x0175
            L_0x004a:
                r0 = move-exception
                goto L_0x04d7
            L_0x004d:
                java.lang.String r6 = "removeLoading"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 23
                goto L_0x0175
            L_0x0059:
                java.lang.String r6 = "getUserId"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 19
                goto L_0x0175
            L_0x0065:
                java.lang.String r6 = "getHttpHeader"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 0
                goto L_0x0175
            L_0x0070:
                java.lang.String r6 = "getAppName"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 18
                goto L_0x0175
            L_0x007c:
                java.lang.String r6 = "getAppList"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 21
                goto L_0x0175
            L_0x0088:
                java.lang.String r6 = "toast"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 10
                goto L_0x0175
            L_0x0094:
                java.lang.String r6 = "close"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 7
                goto L_0x0175
            L_0x009f:
                java.lang.String r6 = "returnSelfRoot"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 11
                goto L_0x0175
            L_0x00ab:
                java.lang.String r6 = "getData"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 16
                goto L_0x0175
            L_0x00b7:
                java.lang.String r6 = "getTmpData"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 14
                goto L_0x0175
            L_0x00c3:
                java.lang.String r6 = "getTopBarHeight"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 5
                goto L_0x0175
            L_0x00ce:
                java.lang.String r6 = "getAppVersionStr"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 20
                goto L_0x0175
            L_0x00da:
                java.lang.String r6 = "setScrollState"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 25
                goto L_0x0175
            L_0x00e6:
                java.lang.String r6 = "closeSelf"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 8
                goto L_0x0175
            L_0x00f2:
                java.lang.String r6 = "saveTmpData"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 13
                goto L_0x0175
            L_0x00fe:
                java.lang.String r6 = "getNavigationHeight"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 4
                goto L_0x0175
            L_0x0109:
                java.lang.String r6 = "getAppVersionCode"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 17
                goto L_0x0175
            L_0x0114:
                java.lang.String r6 = "clearUserInfo"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 24
                goto L_0x0175
            L_0x011f:
                java.lang.String r6 = "getPhoneInfo"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 2
                goto L_0x0175
            L_0x0129:
                java.lang.String r6 = "webReturn"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 9
                goto L_0x0175
            L_0x0134:
                java.lang.String r6 = "getUserProduct"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 3
                goto L_0x0175
            L_0x013e:
                java.lang.String r6 = "googlePlay"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 6
                goto L_0x0175
            L_0x0148:
                java.lang.String r6 = "returnMainAct"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 12
                goto L_0x0175
            L_0x0153:
                java.lang.String r6 = "getWifiMac"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 26
                goto L_0x0175
            L_0x015e:
                java.lang.String r6 = "addLoading"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 22
                goto L_0x0175
            L_0x0169:
                java.lang.String r6 = "saveData"
                boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x0174
                r2 = 15
                goto L_0x0175
            L_0x0174:
                r2 = -1
            L_0x0175:
                com.ktakilat.cbase.ui.BaseActivity r6 = r1.b
                java.lang.String r12 = "h5"
                java.lang.String r7 = "Device-Info"
                java.lang.String r10 = "mobileNo"
                java.lang.String r4 = "userId"
                java.lang.String r9 = "Authorization"
                java.lang.String r11 = "userLogin"
                r27 = r7
                java.lang.String r7 = "screenHeight"
                r19 = 1065353216(0x3f800000, float:1.0)
                r20 = r10
                java.lang.String r10 = "heightPercent"
                r21 = r4
                java.lang.String r4 = "tmpData"
                r22 = r9
                java.lang.String r9 = "data"
                r23 = r11
                java.lang.String r11 = "Accept"
                r24 = r11
                java.lang.String r11 = "Accept-Language"
                r25 = r11
                java.lang.String r11 = "key"
                switch(r2) {
                    case 0: goto L_0x0485;
                    case 1: goto L_0x0431;
                    case 2: goto L_0x03ac;
                    case 3: goto L_0x01a4;
                    case 4: goto L_0x036a;
                    case 5: goto L_0x0342;
                    case 6: goto L_0x0335;
                    case 7: goto L_0x0327;
                    case 8: goto L_0x031a;
                    case 9: goto L_0x030d;
                    case 10: goto L_0x0300;
                    case 11: goto L_0x02f3;
                    case 12: goto L_0x02e5;
                    case 13: goto L_0x02cc;
                    case 14: goto L_0x02ab;
                    case 15: goto L_0x027e;
                    case 16: goto L_0x025a;
                    case 17: goto L_0x024d;
                    case 18: goto L_0x0244;
                    case 19: goto L_0x0225;
                    case 20: goto L_0x021c;
                    case 21: goto L_0x0201;
                    case 22: goto L_0x01f4;
                    case 23: goto L_0x01e7;
                    case 24: goto L_0x01db;
                    case 25: goto L_0x01ba;
                    case 26: goto L_0x01a6;
                    default: goto L_0x01a4;
                }
            L_0x01a4:
                goto L_0x04d2
            L_0x01a6:
                java.lang.String r0 = com.ktakilat.loan.device.DeviceUtil.d(r6)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.cache.KvSave r2 = com.ktakilat.loan.global.AppKv.g()     // Catch:{ Exception -> 0x004a }
                java.lang.String r3 = "mac_address"
                r2.b(r3, r0)     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = "mac"
                r5.addProperty((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x01ba:
                com.google.gson.JsonElement r2 = r0.get(r14)     // Catch:{ Exception -> 0x004a }
                if (r2 == 0) goto L_0x01cd
                com.google.gson.JsonElement r0 = r0.get(r14)     // Catch:{ Exception -> 0x004a }
                boolean r0 = r0.getAsBoolean()     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x01cb
                goto L_0x01cd
            L_0x01cb:
                r0 = 0
                goto L_0x01ce
            L_0x01cd:
                r0 = 1
            L_0x01ce:
                android.os.Handler r2 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.b r3 = new com.ktakilat.loan.webtool.b     // Catch:{ Exception -> 0x004a }
                r4 = 1
                r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x004a }
                r2.post(r3)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x01db:
                android.os.Handler r0 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$3 r2 = new com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$3     // Catch:{ Exception -> 0x004a }
                r2.<init>()     // Catch:{ Exception -> 0x004a }
                r0.post(r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x01e7:
                android.os.Handler r0 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x004a }
                r3 = 7
                r2.<init>(r1, r3)     // Catch:{ Exception -> 0x004a }
                r0.post(r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x01f4:
                android.os.Handler r0 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x004a }
                r3 = 6
                r2.<init>(r1, r3)     // Catch:{ Exception -> 0x004a }
                r0.post(r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0201:
                java.lang.String r2 = "appList"
                java.util.ArrayList r0 = com.ktakilat.loan.device.DeviceUtil.a(r6)     // Catch:{ Exception -> 0x004a }
                com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0211 }
                r3.<init>()     // Catch:{ Exception -> 0x0211 }
                com.google.gson.JsonElement r0 = r3.toJsonTree(r0)     // Catch:{ Exception -> 0x0211 }
                goto L_0x0217
            L_0x0211:
                r0 = move-exception
                com.ktakilat.cbase.utils.LogUtil.a(r0)     // Catch:{ Exception -> 0x004a }
                com.google.gson.JsonNull r0 = com.google.gson.JsonNull.INSTANCE     // Catch:{ Exception -> 0x004a }
            L_0x0217:
                r5.add(r2, r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x021c:
                java.lang.String r0 = "VersionName"
                com.ktakilat.cbase.datacollect.PCollectorManager.g = r13     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r0, (java.lang.String) r13)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0225:
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                boolean r0 = com.ktakilat.loan.KtakilatApplication.h()     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x04d2
                java.lang.String r0 = "UserId"
                com.ktakilat.loan.KtakilatApplication r2 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r2.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r2 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = r2.getUserId()     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0244:
                java.lang.String r0 = "AppName"
                java.lang.String r2 = "KtaKilat"
                r5.addProperty((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x024d:
                java.lang.String r0 = "VersionCode"
                r2 = 534(0x216, float:7.48E-43)
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r0, (java.lang.Number) r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x025a:
                com.google.gson.JsonElement r0 = r0.get(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.cache.KvSave r2 = com.ktakilat.loan.global.AppKv.g()     // Catch:{ Exception -> 0x004a }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
                r3.<init>(r12)     // Catch:{ Exception -> 0x004a }
                r3.append(r0)     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x004a }
                com.tencent.mmkv.MMKV r2 = r2.f465a     // Catch:{ Exception -> 0x004a }
                r3 = 0
                java.lang.String r0 = r2.getString(r0, r3)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r9, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x027e:
                com.google.gson.JsonElement r2 = r0.get(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = r2.getAsString()     // Catch:{ Exception -> 0x004a }
                com.google.gson.JsonElement r3 = r0.get(r9)     // Catch:{ Exception -> 0x004a }
                if (r3 != 0) goto L_0x028e
                r0 = 0
                goto L_0x0296
            L_0x028e:
                com.google.gson.JsonElement r0 = r0.get(r9)     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x004a }
            L_0x0296:
                com.ktakilat.cbase.cache.KvSave r3 = com.ktakilat.loan.global.AppKv.g()     // Catch:{ Exception -> 0x004a }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
                r4.<init>(r12)     // Catch:{ Exception -> 0x004a }
                r4.append(r2)     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x004a }
                r3.b(r2, r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x02ab:
                com.google.gson.JsonElement r0 = r0.get(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.cache.KvSave r2 = com.ktakilat.loan.global.H5Kv.a()     // Catch:{ Exception -> 0x004a }
                com.tencent.mmkv.MMKV r2 = r2.f465a     // Catch:{ Exception -> 0x004a }
                java.lang.String r3 = ""
                java.lang.String r2 = r2.getString(r0, r3)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.cache.KvSave r3 = com.ktakilat.loan.global.H5Kv.a()     // Catch:{ Exception -> 0x004a }
                r6 = 0
                r3.b(r0, r6)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r4, (java.lang.String) r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x02cc:
                com.google.gson.JsonElement r2 = r0.get(r11)     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = r2.getAsString()     // Catch:{ Exception -> 0x004a }
                com.google.gson.JsonElement r0 = r0.get(r4)     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.cache.KvSave r3 = com.ktakilat.loan.global.H5Kv.a()     // Catch:{ Exception -> 0x004a }
                r3.b(r2, r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x02e5:
                android.os.Handler r0 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.a r2 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x004a }
                r4 = 8
                r2.<init>(r1, r3, r4)     // Catch:{ Exception -> 0x004a }
                r0.post(r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x02f3:
                android.os.Handler r0 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x004a }
                r3 = 5
                r2.<init>(r1, r3)     // Catch:{ Exception -> 0x004a }
                r0.post(r2)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0300:
                android.os.Handler r2 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x004a }
                r4 = 5
                r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x004a }
                r2.post(r3)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x030d:
                android.os.Handler r2 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x004a }
                r4 = 4
                r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x004a }
                r2.post(r3)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x031a:
                android.os.Handler r2 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x004a }
                r4 = 3
                r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x004a }
                r2.post(r3)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0327:
                android.os.Handler r2 = r15.j     // Catch:{ Exception -> 0x004a }
                e0 r3 = new e0     // Catch:{ Exception -> 0x004a }
                r4 = 11
                r3.<init>(r4, r0, r8)     // Catch:{ Exception -> 0x004a }
                r2.post(r3)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0335:
                android.os.Handler r2 = r15.j     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x004a }
                r4 = 2
                r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x004a }
                r2.post(r3)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0342:
                android.content.res.Resources r0 = r6.getResources()     // Catch:{ Exception -> 0x004a }
                r2 = 2131100509(0x7f06035d, float:1.7813401E38)
                int r0 = r0.getDimensionPixelSize(r2)     // Catch:{ Exception -> 0x004a }
                float r0 = (float) r0     // Catch:{ Exception -> 0x004a }
                float r0 = r0 * r19
                int r2 = com.ktakilat.cbase.utils.ScreenUtils.a(r6)     // Catch:{ Exception -> 0x004a }
                float r2 = (float) r2     // Catch:{ Exception -> 0x004a }
                float r0 = r0 / r2
                java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r10, (java.lang.Number) r0)     // Catch:{ Exception -> 0x004a }
                int r0 = com.ktakilat.cbase.utils.ScreenUtils.a(r6)     // Catch:{ Exception -> 0x004a }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r7, (java.lang.Number) r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x036a:
                boolean r0 = com.ktakilat.cbase.utils.ScreenUtils.b(r6)     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x038e
                boolean r0 = com.ktakilat.cbase.utils.ScreenUtils.b(r6)     // Catch:{ Exception -> 0x004a }
                if (r0 != 0) goto L_0x0377
                goto L_0x038b
            L_0x0377:
                android.content.res.Resources r0 = r6.getResources()     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = "dimen"
                java.lang.String r3 = "android"
                java.lang.String r4 = "navigation_bar_height"
                int r2 = r0.getIdentifier(r4, r2, r3)     // Catch:{ Exception -> 0x004a }
                if (r2 <= 0) goto L_0x038b
                int r18 = r0.getDimensionPixelSize(r2)     // Catch:{ Exception -> 0x004a }
            L_0x038b:
                r0 = r18
                goto L_0x038f
            L_0x038e:
                r0 = 0
            L_0x038f:
                float r0 = (float) r0     // Catch:{ Exception -> 0x004a }
                float r0 = r0 * r19
                int r2 = com.ktakilat.cbase.utils.ScreenUtils.a(r6)     // Catch:{ Exception -> 0x004a }
                float r2 = (float) r2     // Catch:{ Exception -> 0x004a }
                float r0 = r0 / r2
                java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r10, (java.lang.Number) r0)     // Catch:{ Exception -> 0x004a }
                int r0 = com.ktakilat.cbase.utils.ScreenUtils.a(r6)     // Catch:{ Exception -> 0x004a }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r7, (java.lang.Number) r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x03ac:
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                boolean r0 = com.ktakilat.loan.KtakilatApplication.h()     // Catch:{ Exception -> 0x004a }
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x004a }
                r2 = r23
                r5.addProperty((java.lang.String) r2, (java.lang.Boolean) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                boolean r0 = com.ktakilat.loan.KtakilatApplication.h()     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x03ff
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r0 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getToken()     // Catch:{ Exception -> 0x004a }
                r2 = r22
                r5.addProperty((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r0 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getUserId()     // Catch:{ Exception -> 0x004a }
                r3 = r21
                r5.addProperty((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r0 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getMobileNo()     // Catch:{ Exception -> 0x004a }
                r4 = r20
                r5.addProperty((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
            L_0x03ff:
                com.ktakilat.cbase.http.ApiManager r0 = com.ktakilat.cbase.http.ApiManager.b()     // Catch:{ Exception -> 0x004a }
                r3 = r25
                java.lang.String r0 = r0.c(r3)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.http.ApiManager r0 = com.ktakilat.cbase.http.ApiManager.b()     // Catch:{ Exception -> 0x004a }
                r4 = r24
                java.lang.String r0 = r0.c(r4)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.http.ApiInfoUtil r0 = com.ktakilat.cbase.http.ApiInfoUtil.b()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x004a }
                byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x004a }
                r2 = 2
                java.lang.String r0 = android.util.Base64.encodeToString(r0, r2)     // Catch:{ Exception -> 0x004a }
                r6 = r27
                r5.addProperty((java.lang.String) r6, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0431:
                r4 = r20
                r3 = r21
                r2 = r23
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                boolean r0 = com.ktakilat.loan.KtakilatApplication.h()     // Catch:{ Exception -> 0x004a }
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r2, (java.lang.Boolean) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                boolean r0 = com.ktakilat.loan.KtakilatApplication.h()     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x04d2
                java.lang.String r0 = "token"
                com.ktakilat.loan.KtakilatApplication r2 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r2.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r2 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r2 = r2.getToken()     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r0 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getUserId()     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r0 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getMobileNo()     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                goto L_0x04d2
            L_0x0485:
                r6 = r27
                r2 = r22
                r4 = r24
                r3 = r25
                com.ktakilat.cbase.http.ApiManager r0 = com.ktakilat.cbase.http.ApiManager.b()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.c(r3)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r3, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.http.ApiManager r0 = com.ktakilat.cbase.http.ApiManager.b()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.c(r4)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.cbase.http.ApiInfoUtil r0 = com.ktakilat.cbase.http.ApiInfoUtil.b()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.a()     // Catch:{ Exception -> 0x004a }
                byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x004a }
                r3 = 2
                java.lang.String r0 = android.util.Base64.encodeToString(r0, r3)     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r6, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                boolean r0 = com.ktakilat.loan.KtakilatApplication.h()     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x04d2
                com.ktakilat.loan.KtakilatApplication r0 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x004a }
                r0.getClass()     // Catch:{ Exception -> 0x004a }
                com.ktakilat.loan.http.user.UserInfo r0 = com.ktakilat.loan.KtakilatApplication.f()     // Catch:{ Exception -> 0x004a }
                java.lang.String r0 = r0.getToken()     // Catch:{ Exception -> 0x004a }
                r5.addProperty((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x004a }
            L_0x04d2:
                java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x004a }
                return r0
            L_0x04d7:
                r0.toString()
                java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.webtool.CommonWebViewSetting.JsCallAndroidInterface.jsCallCommon(java.lang.String, java.lang.String):java.lang.String");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(14:6|7|8|(1:10)|14|(1:16)(1:19)|20|(3:22|(1:24)|31)|25|26|27|28|29|35) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0092 */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void jsCallDataCollect(java.lang.String r8, java.lang.String r9) {
            /*
                r7 = this;
                java.lang.String r0 = "jsonParams"
                com.ktakilat.loan.webtool.CommonWebViewSetting r1 = com.ktakilat.loan.webtool.CommonWebViewSetting.this
                java.lang.String r2 = "trackEvent"
                boolean r8 = r2.equals(r8)     // Catch:{ Exception -> 0x003d }
                if (r8 == 0) goto L_0x009a
                boolean r8 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x003d }
                if (r8 != 0) goto L_0x009a
                com.google.gson.JsonObject r8 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x003d }
                r8.<init>()     // Catch:{ Exception -> 0x003d }
                boolean r2 = com.ktakilat.loan.webtool.CommonWebViewSetting.a(r1, r9)     // Catch:{ Exception -> 0x0026 }
                if (r2 == 0) goto L_0x002a
                com.google.gson.JsonElement r9 = com.google.gson.JsonParser.parseString(r9)     // Catch:{ Exception -> 0x0026 }
                com.google.gson.JsonObject r8 = r9.getAsJsonObject()     // Catch:{ Exception -> 0x0026 }
                goto L_0x002a
            L_0x0026:
                r9 = move-exception
                com.ktakilat.cbase.utils.LogUtil.a(r9)     // Catch:{ Exception -> 0x003d }
            L_0x002a:
                java.lang.String r9 = "eventName"
                com.google.gson.JsonElement r9 = r8.get(r9)     // Catch:{ Exception -> 0x003d }
                java.lang.String r9 = r9.getAsString()     // Catch:{ Exception -> 0x003d }
                com.google.gson.JsonElement r2 = r8.get(r0)     // Catch:{ Exception -> 0x003d }
                if (r2 != 0) goto L_0x003f
                java.lang.String r8 = ""
                goto L_0x0047
            L_0x003d:
                r8 = move-exception
                goto L_0x0095
            L_0x003f:
                com.google.gson.JsonElement r8 = r8.get(r0)     // Catch:{ Exception -> 0x003d }
                java.lang.String r8 = r8.getAsString()     // Catch:{ Exception -> 0x003d }
            L_0x0047:
                android.os.Bundle r0 = new android.os.Bundle     // Catch:{ Exception -> 0x003d }
                r0.<init>()     // Catch:{ Exception -> 0x003d }
                boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x003d }
                if (r2 != 0) goto L_0x008b
                com.google.gson.JsonElement r8 = com.google.gson.JsonParser.parseString(r8)     // Catch:{ Exception -> 0x003d }
                com.google.gson.JsonArray r8 = r8.getAsJsonArray()     // Catch:{ Exception -> 0x003d }
                int r2 = r8.size()     // Catch:{ Exception -> 0x003d }
                r3 = 0
            L_0x005f:
                if (r3 >= r2) goto L_0x008b
                com.google.gson.JsonElement r4 = r8.get(r3)     // Catch:{ Exception -> 0x003d }
                com.google.gson.JsonObject r4 = r4.getAsJsonObject()     // Catch:{ Exception -> 0x003d }
                java.lang.String r5 = "key"
                com.google.gson.JsonElement r4 = r4.get(r5)     // Catch:{ Exception -> 0x003d }
                java.lang.String r4 = r4.getAsString()     // Catch:{ Exception -> 0x003d }
                com.google.gson.JsonElement r5 = r8.get(r3)     // Catch:{ Exception -> 0x003d }
                com.google.gson.JsonObject r5 = r5.getAsJsonObject()     // Catch:{ Exception -> 0x003d }
                java.lang.String r6 = "value"
                com.google.gson.JsonElement r5 = r5.get(r6)     // Catch:{ Exception -> 0x003d }
                java.lang.String r5 = r5.getAsString()     // Catch:{ Exception -> 0x003d }
                r0.putString(r4, r5)     // Catch:{ Exception -> 0x003d }
                int r3 = r3 + 1
                goto L_0x005f
            L_0x008b:
                java.lang.String r8 = r1.k     // Catch:{ Exception -> 0x003d }
                java.lang.String r1 = com.ktakilat.cbase.datacollect.PCollectorManager.f469a     // Catch:{ Exception -> 0x0092 }
                com.ktakilat.cbase.datacollect.PCollectorManager.Companion.b(r0, r9, r8)     // Catch:{ Exception -> 0x0092 }
            L_0x0092:
                java.util.ArrayList r8 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ Exception -> 0x003d }
                goto L_0x009a
            L_0x0095:
                r8.toString()
                java.util.ArrayList r8 = com.ktakilat.cbase.ui.LogActivity.k
            L_0x009a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.webtool.CommonWebViewSetting.JsCallAndroidInterface.jsCallDataCollect(java.lang.String, java.lang.String):void");
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0113, code lost:
            r5.j.post(new com.ktakilat.loan.webtool.c(r1, 10));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x011d, code lost:
            r5.j.post(new com.ktakilat.loan.webtool.c(r1, 11));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0127, code lost:
            r5.j.post(new com.ktakilat.loan.webtool.a(r1, r0, 6));
         */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x01f2 A[Catch:{ Exception -> 0x0052 }] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String jsCallPage(java.lang.String r20, java.lang.String r21) {
            /*
                r19 = this;
                r1 = r19
                r2 = r20
                r3 = 9
                r6 = 10
                r7 = 4
                r8 = 3
                r9 = 8
                r10 = 6
                r11 = 2
                r12 = 11
                r14 = 1
                java.lang.String r13 = "needForced"
                com.ktakilat.loan.webtool.CommonWebViewSetting r5 = com.ktakilat.loan.webtool.CommonWebViewSetting.this
                java.lang.String r4 = "#"
                r16 = 0
                com.google.gson.JsonObject r17 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x0052 }
                r17.<init>()     // Catch:{ Exception -> 0x0052 }
                r0 = r21
                boolean r18 = com.ktakilat.loan.webtool.CommonWebViewSetting.a(r5, r0)     // Catch:{ Exception -> 0x002f }
                if (r18 == 0) goto L_0x0031
                com.google.gson.JsonElement r0 = com.google.gson.JsonParser.parseString(r21)     // Catch:{ Exception -> 0x002f }
                com.google.gson.JsonObject r17 = r0.getAsJsonObject()     // Catch:{ Exception -> 0x002f }
                goto L_0x0031
            L_0x002f:
                r0 = move-exception
                goto L_0x0034
            L_0x0031:
                r0 = r17
                goto L_0x0038
            L_0x0034:
                com.ktakilat.cbase.utils.LogUtil.a(r0)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0031
            L_0x0038:
                com.google.gson.JsonObject r17 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x0052 }
                r17.<init>()     // Catch:{ Exception -> 0x0052 }
                int r18 = r20.hashCode()     // Catch:{ Exception -> 0x0052 }
                switch(r18) {
                    case -1984492615: goto L_0x00f9;
                    case -1964567964: goto L_0x00ee;
                    case -1960900638: goto L_0x00e3;
                    case -1758355716: goto L_0x00d9;
                    case -1595090828: goto L_0x00ce;
                    case -1234574196: goto L_0x00c3;
                    case -1172322898: goto L_0x00b9;
                    case -978449605: goto L_0x00ae;
                    case -776902455: goto L_0x00a4;
                    case -758029486: goto L_0x0099;
                    case -502670236: goto L_0x008e;
                    case 1349127999: goto L_0x0083;
                    case 1772256232: goto L_0x0077;
                    case 1773805421: goto L_0x006c;
                    case 1956665398: goto L_0x0060;
                    case 1981793336: goto L_0x0055;
                    case 2022744869: goto L_0x0046;
                    default: goto L_0x0044;
                }     // Catch:{ Exception -> 0x0052 }
            L_0x0044:
                goto L_0x0103
            L_0x0046:
                java.lang.String r15 = "loginOut"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 14
                goto L_0x0104
            L_0x0052:
                r0 = move-exception
                goto L_0x022c
            L_0x0055:
                java.lang.String r15 = "setSurfaceColor"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 1
                goto L_0x0104
            L_0x0060:
                java.lang.String r15 = "toVerification"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 16
                goto L_0x0104
            L_0x006c:
                java.lang.String r15 = "cutHolderImage"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 7
                goto L_0x0104
            L_0x0077:
                java.lang.String r15 = "toModifyPwd"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 11
                goto L_0x0104
            L_0x0083:
                java.lang.String r15 = "newActH5"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 2
                goto L_0x0104
            L_0x008e:
                java.lang.String r15 = "forceReload"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 6
                goto L_0x0104
            L_0x0099:
                java.lang.String r15 = "toChangePhonePage"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 8
                goto L_0x0104
            L_0x00a4:
                java.lang.String r15 = "interceptBack"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 3
                goto L_0x0104
            L_0x00ae:
                java.lang.String r15 = "toPasswordManage"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 15
                goto L_0x0104
            L_0x00b9:
                java.lang.String r15 = "toLogin"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 4
                goto L_0x0104
            L_0x00c3:
                java.lang.String r15 = "toShareDialog"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 10
                goto L_0x0104
            L_0x00ce:
                java.lang.String r15 = "toModifyGesture"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 12
                goto L_0x0104
            L_0x00d9:
                java.lang.String r15 = "updateTopBarColor"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 0
                goto L_0x0104
            L_0x00e3:
                java.lang.String r15 = "openFaceLogin"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 13
                goto L_0x0104
            L_0x00ee:
                java.lang.String r15 = "toLoanVerify"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 9
                goto L_0x0104
            L_0x00f9:
                java.lang.String r15 = "interceptRefresh"
                boolean r2 = r2.equals(r15)     // Catch:{ Exception -> 0x0052 }
                if (r2 == 0) goto L_0x0103
                r2 = 5
                goto L_0x0104
            L_0x0103:
                r2 = -1
            L_0x0104:
                switch(r2) {
                    case 0: goto L_0x021c;
                    case 1: goto L_0x01cb;
                    case 2: goto L_0x01bf;
                    case 3: goto L_0x01b2;
                    case 4: goto L_0x01a4;
                    case 5: goto L_0x0198;
                    case 6: goto L_0x017c;
                    case 7: goto L_0x016f;
                    case 8: goto L_0x0163;
                    case 9: goto L_0x0157;
                    case 10: goto L_0x014b;
                    case 11: goto L_0x013f;
                    case 12: goto L_0x0133;
                    case 13: goto L_0x0109;
                    case 14: goto L_0x0113;
                    case 15: goto L_0x011d;
                    case 16: goto L_0x0127;
                    default: goto L_0x0107;
                }     // Catch:{ Exception -> 0x0052 }
            L_0x0107:
                goto L_0x0227
            L_0x0109:
                android.os.Handler r2 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r4 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r4.<init>(r1, r3)     // Catch:{ Exception -> 0x0052 }
                r2.post(r4)     // Catch:{ Exception -> 0x0052 }
            L_0x0113:
                android.os.Handler r2 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r3 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r3.<init>(r1, r6)     // Catch:{ Exception -> 0x0052 }
                r2.post(r3)     // Catch:{ Exception -> 0x0052 }
            L_0x011d:
                android.os.Handler r2 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r3 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r3.<init>(r1, r12)     // Catch:{ Exception -> 0x0052 }
                r2.post(r3)     // Catch:{ Exception -> 0x0052 }
            L_0x0127:
                android.os.Handler r2 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x0052 }
                r3.<init>(r1, r0, r10)     // Catch:{ Exception -> 0x0052 }
                r2.post(r3)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x0133:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r2.<init>(r1, r9)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x013f:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r2.<init>(r1, r7)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x014b:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r2.<init>(r1, r8)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x0157:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r2.<init>(r1, r11)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x0163:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r2.<init>(r1, r14)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x016f:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r3 = 0
                r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x017c:
                com.google.gson.JsonElement r2 = r0.get(r13)     // Catch:{ Exception -> 0x0052 }
                if (r2 != 0) goto L_0x0183
                goto L_0x018b
            L_0x0183:
                com.google.gson.JsonElement r0 = r0.get(r13)     // Catch:{ Exception -> 0x0052 }
                boolean r14 = r0.getAsBoolean()     // Catch:{ Exception -> 0x0052 }
            L_0x018b:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.b r2 = new com.ktakilat.loan.webtool.b     // Catch:{ Exception -> 0x0052 }
                r3 = 0
                r2.<init>(r1, r14, r3)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x0198:
                android.os.Handler r2 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x0052 }
                r3.<init>(r1, r0, r14)     // Catch:{ Exception -> 0x0052 }
                r2.post(r3)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x01a4:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r3 = 13
                r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x01b2:
                android.os.Handler r0 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.c r2 = new com.ktakilat.loan.webtool.c     // Catch:{ Exception -> 0x0052 }
                r3 = 12
                r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0052 }
                r0.post(r2)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x01bf:
                android.os.Handler r2 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x0052 }
                r4 = 7
                r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x0052 }
                r2.post(r3)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x01cb:
                java.lang.String r2 = "surfaceColor"
                com.google.gson.JsonElement r0 = r0.get(r2)     // Catch:{ Exception -> 0x0052 }
                if (r0 != 0) goto L_0x01d6
                r0 = r16
                goto L_0x01da
            L_0x01d6:
                java.lang.String r0 = r0.getAsString()     // Catch:{ Exception -> 0x0052 }
            L_0x01da:
                if (r0 == 0) goto L_0x01eb
                boolean r2 = r0.startsWith(r4)     // Catch:{ Exception -> 0x0052 }
                if (r2 != 0) goto L_0x01e6
                java.lang.String r0 = r4.concat(r0)     // Catch:{ Exception -> 0x0052 }
            L_0x01e6:
                int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ Exception -> 0x01eb }
                goto L_0x01ec
            L_0x01eb:
                r0 = 0
            L_0x01ec:
                com.ktakilat.cbase.ui.BaseActivity r2 = r1.b     // Catch:{ Exception -> 0x0052 }
                boolean r3 = r2 instanceof com.ktakilat.loan.web.CommonWebActivity     // Catch:{ Exception -> 0x0052 }
                if (r3 == 0) goto L_0x0227
                com.ktakilat.loan.web.CommonWebActivity r2 = (com.ktakilat.loan.web.CommonWebActivity) r2     // Catch:{ Exception -> 0x0052 }
                com.pendanaan.kta.databinding.CActivityCommonWebviewBinding r3 = r2.o     // Catch:{ Exception -> 0x0052 }
                android.widget.LinearLayout r3 = r3.getRoot()     // Catch:{ Exception -> 0x0052 }
                if (r0 != 0) goto L_0x0203
                r0 = 2131165421(0x7f0700ed, float:1.7945059E38)
                r3.setBackgroundResource(r0)     // Catch:{ Exception -> 0x0052 }
                goto L_0x0227
            L_0x0203:
                android.graphics.drawable.ColorDrawable r4 = new android.graphics.drawable.ColorDrawable     // Catch:{ Exception -> 0x0052 }
                r4.<init>(r0)     // Catch:{ Exception -> 0x0052 }
                r3.setBackground(r4)     // Catch:{ Exception -> 0x0052 }
                android.view.Window r0 = r2.getWindow()     // Catch:{ Exception -> 0x0227 }
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r0.addFlags(r2)     // Catch:{ Exception -> 0x0227 }
                r2 = 0
                r0.setStatusBarColor(r2)     // Catch:{ Exception -> 0x0227 }
                r0.setBackgroundDrawable(r4)     // Catch:{ Exception -> 0x0227 }
                goto L_0x0227
            L_0x021c:
                android.os.Handler r2 = r5.j     // Catch:{ Exception -> 0x0052 }
                com.ktakilat.loan.webtool.a r3 = new com.ktakilat.loan.webtool.a     // Catch:{ Exception -> 0x0052 }
                r4 = 0
                r3.<init>(r1, r0, r4)     // Catch:{ Exception -> 0x0052 }
                r2.post(r3)     // Catch:{ Exception -> 0x0052 }
            L_0x0227:
                java.lang.String r0 = r17.toString()     // Catch:{ Exception -> 0x0052 }
                return r0
            L_0x022c:
                r0.toString()
                java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
                return r16
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.webtool.CommonWebViewSetting.JsCallAndroidInterface.jsCallPage(java.lang.String, java.lang.String):java.lang.String");
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0067 A[Catch:{ Exception -> 0x0030 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007e A[Catch:{ Exception -> 0x0030 }] */
        @android.webkit.JavascriptInterface
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String jsCallPermission(java.lang.String r9, java.lang.String r10) {
            /*
                r8 = this;
                r0 = 1
                java.lang.String r1 = "type"
                com.ktakilat.loan.webtool.CommonWebViewSetting r2 = com.ktakilat.loan.webtool.CommonWebViewSetting.this
                com.google.gson.JsonObject r3 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x0030 }
                r3.<init>()     // Catch:{ Exception -> 0x0030 }
                boolean r4 = com.ktakilat.loan.webtool.CommonWebViewSetting.a(r2, r10)     // Catch:{ Exception -> 0x0019 }
                if (r4 == 0) goto L_0x001d
                com.google.gson.JsonElement r10 = com.google.gson.JsonParser.parseString(r10)     // Catch:{ Exception -> 0x0019 }
                com.google.gson.JsonObject r3 = r10.getAsJsonObject()     // Catch:{ Exception -> 0x0019 }
                goto L_0x001d
            L_0x0019:
                r10 = move-exception
                com.ktakilat.cbase.utils.LogUtil.a(r10)     // Catch:{ Exception -> 0x0030 }
            L_0x001d:
                java.lang.String r10 = "permissionName"
                com.google.gson.JsonElement r10 = r3.get(r10)     // Catch:{ Exception -> 0x0030 }
                java.lang.String r10 = r10.getAsString()     // Catch:{ Exception -> 0x0030 }
                com.google.gson.JsonElement r4 = r3.get(r1)     // Catch:{ Exception -> 0x0030 }
                if (r4 != 0) goto L_0x0032
                java.lang.String r1 = ""
                goto L_0x003a
            L_0x0030:
                r9 = move-exception
                goto L_0x008d
            L_0x0032:
                com.google.gson.JsonElement r1 = r3.get(r1)     // Catch:{ Exception -> 0x0030 }
                java.lang.String r1 = r1.getAsString()     // Catch:{ Exception -> 0x0030 }
            L_0x003a:
                com.google.gson.JsonObject r3 = new com.google.gson.JsonObject     // Catch:{ Exception -> 0x0030 }
                r3.<init>()     // Catch:{ Exception -> 0x0030 }
                int r4 = r9.hashCode()     // Catch:{ Exception -> 0x0030 }
                r5 = 686218487(0x28e6dcf7, float:2.5630958E-14)
                r6 = 0
                r7 = -1
                if (r4 == r5) goto L_0x005a
                r5 = 746581438(0x2c7fedbe, float:3.6369653E-12)
                if (r4 == r5) goto L_0x0050
                goto L_0x0064
            L_0x0050:
                java.lang.String r4 = "requestPermission"
                boolean r9 = r9.equals(r4)     // Catch:{ Exception -> 0x0030 }
                if (r9 == 0) goto L_0x0064
                r9 = 0
                goto L_0x0065
            L_0x005a:
                java.lang.String r4 = "checkPermission"
                boolean r9 = r9.equals(r4)     // Catch:{ Exception -> 0x0030 }
                if (r9 == 0) goto L_0x0064
                r9 = 1
                goto L_0x0065
            L_0x0064:
                r9 = -1
            L_0x0065:
                if (r9 == 0) goto L_0x007e
                if (r9 == r0) goto L_0x006a
                goto L_0x0088
            L_0x006a:
                java.lang.String r9 = "isPermission"
                com.ktakilat.cbase.ui.BaseActivity r1 = r8.b     // Catch:{ Exception -> 0x0030 }
                int r10 = androidx.core.content.ContextCompat.checkSelfPermission(r1, r10)     // Catch:{ Exception -> 0x0030 }
                if (r10 != r7) goto L_0x0075
                goto L_0x0076
            L_0x0075:
                r0 = 0
            L_0x0076:
                java.lang.Boolean r10 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0030 }
                r3.addProperty((java.lang.String) r9, (java.lang.Boolean) r10)     // Catch:{ Exception -> 0x0030 }
                goto L_0x0088
            L_0x007e:
                android.os.Handler r9 = r2.j     // Catch:{ Exception -> 0x0030 }
                com.ktakilat.loan.webtool.d r2 = new com.ktakilat.loan.webtool.d     // Catch:{ Exception -> 0x0030 }
                r2.<init>((com.ktakilat.loan.webtool.CommonWebViewSetting.JsCallAndroidInterface) r8, (java.lang.String) r10, (java.lang.String) r1, (int) r0)     // Catch:{ Exception -> 0x0030 }
                r9.post(r2)     // Catch:{ Exception -> 0x0030 }
            L_0x0088:
                java.lang.String r9 = r3.toString()     // Catch:{ Exception -> 0x0030 }
                return r9
            L_0x008d:
                r9.toString()
                java.util.ArrayList r9 = com.ktakilat.cbase.ui.LogActivity.k
                r9 = 0
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.webtool.CommonWebViewSetting.JsCallAndroidInterface.jsCallPermission(java.lang.String, java.lang.String):java.lang.String");
        }

        @JavascriptInterface
        public void jsCallShare(String str, String str2) {
            CommonWebViewSetting.this.j.post(new d(this, str2, str, 0));
        }

        @JavascriptInterface
        public void jsCallThird(String str, String str2) {
            CommonWebViewSetting commonWebViewSetting = CommonWebViewSetting.this;
            JsonObject jsonObject = new JsonObject();
            try {
                if (CommonWebViewSetting.a(commonWebViewSetting, str2)) {
                    jsonObject = JsonParser.parseString(str2).getAsJsonObject();
                }
            } catch (Exception e2) {
                LogUtil.a(e2);
            }
            commonWebViewSetting.j.post(new d(this, str, jsonObject, str2));
        }

        @JavascriptInterface
        public void jsCallTip(String str, String str2) {
            CommonWebViewSetting.this.j.post(new d(this, str2, str, 2));
        }
    }

    public static class LocalAssets {
        public static LocalAssets b;

        /* renamed from: a  reason: collision with root package name */
        public AssetManager f580a;

        public static String b(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith(Domain.a() + "_nuxt/img/") && (str.endsWith(".png") || str.endsWith(".jpg") || str.endsWith(".jpeg"))) {
                    String substring = str.substring(str.indexOf("_nuxt/img/") + 10);
                    return e.l(substring.substring(0, substring.indexOf(".")), substring.substring(substring.lastIndexOf(".")));
                }
            }
            return null;
        }

        public final WebResourceResponse a(String str) {
            try {
                String b2 = b(str);
                if (!TextUtils.isEmpty(b2)) {
                    AssetManager assetManager = this.f580a;
                    InputStream open = assetManager.open("H5Res/" + b2);
                    if (open == null) {
                        return null;
                    }
                    return new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)), CharEncoding.UTF_8, open);
                }
            } catch (FileNotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public interface OnCommonWebViewSettingEventListener {
        void a();

        void b(boolean z);

        void c();

        void d();

        void e(boolean z);

        void f(boolean z);

        void g(boolean z);
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [com.ktakilat.loan.webtool.CommonWebViewSetting$LocalAssets, java.lang.Object] */
    public CommonWebViewSetting(BaseActivity baseActivity) {
        this.d = baseActivity;
        LocalAssets localAssets = LocalAssets.b;
        LocalAssets localAssets2 = localAssets;
        if (localAssets == null) {
            ? obj = new Object();
            obj.f580a = null;
            LocalAssets.b = obj;
            localAssets2 = obj;
        }
        localAssets2.f580a = baseActivity.getAssets();
    }

    public static boolean a(CommonWebViewSetting commonWebViewSetting, String str) {
        commonWebViewSetting.getClass();
        if (str == null || str.trim().equalsIgnoreCase("") || str.equals("undefined")) {
            return false;
        }
        return true;
    }

    public final void b() {
        this.e.stopLoading();
        try {
            this.f = false;
            d();
            this.c = 0;
            OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener = this.i;
            if (onCommonWebViewSettingEventListener != null) {
                onCommonWebViewSettingEventListener.d();
                this.i.f(this.b);
            }
        } catch (Exception e2) {
            LogUtil.a(e2);
        }
    }

    public final void c(final CommonWebView commonWebView, final OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener) {
        this.i = onCommonWebViewSettingEventListener;
        this.e = commonWebView;
        KtakilatApplication.m.getClass();
        this.f574a = new File(BaseApplication.e.getCacheDir(), "ektp.jpg");
        WebSettings settings = commonWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        commonWebView.setWebViewClient(new WebViewClient() {

            /* renamed from: a  reason: collision with root package name */
            public String f575a;

            public final void onLoadResource(WebView webView, String str) {
                if (str.contains("api")) {
                    "H5:".concat(str);
                }
            }

            public final void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                CommonWebViewSetting commonWebViewSetting = CommonWebViewSetting.this;
                commonWebViewSetting.k = str;
                commonWebView.getProgress();
                OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener = onCommonWebViewSettingEventListener;
                if (webView.getProgress() == 100 || commonWebViewSetting.b) {
                    commonWebViewSetting.f = false;
                    commonWebViewSetting.d();
                    onCommonWebViewSettingEventListener.d();
                    if (!commonWebViewSetting.b || commonWebViewSetting.c >= 3 || !this.f575a.equals(str)) {
                        commonWebViewSetting.c = 0;
                        onCommonWebViewSettingEventListener.f(commonWebViewSetting.b);
                        if (commonWebViewSetting.d instanceof CommonWebPopActivity) {
                            commonWebViewSetting.j.post(new Runnable() {

                                /* renamed from: com.ktakilat.loan.webtool.CommonWebViewSetting$1$1$1  reason: invalid class name */
                                class AnonymousClass1 implements ValueCallback<String> {
                                    public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
                                        String str = (String) obj;
                                    }
                                }

                                /* JADX WARNING: type inference failed for: r1v2, types: [android.webkit.ValueCallback, java.lang.Object] */
                                public final void run() {
                                    AnonymousClass1 r0 = AnonymousClass1.this;
                                    if (CommonWebViewSetting.this.e != null) {
                                        commonWebView.evaluateJavascript("javascript:window.tempArr = {};window.closeTemp = (value) => {window.mobile.jsCallCommon('closeSelf', '')}", new Object());
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    onCommonWebViewSettingEventListener.b(true);
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                this.f575a = str;
                CommonWebViewSetting commonWebViewSetting = CommonWebViewSetting.this;
                commonWebViewSetting.k = str;
                commonWebViewSetting.b = false;
                int i = commonWebViewSetting.c + 1;
                commonWebViewSetting.c = i;
                if (i > 3) {
                    commonWebViewSetting.c = 3;
                }
                commonWebViewSetting.f = true;
                CountDownTimer countDownTimer = commonWebViewSetting.g;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    commonWebViewSetting.g = null;
                }
                AnonymousClass2 r4 = new CountDownTimer((long) 60000) {
                    public final void onFinish() {
                        CommonWebViewSetting commonWebViewSetting = CommonWebViewSetting.this;
                        if (commonWebViewSetting.f) {
                            commonWebViewSetting.j.post(new c(this, 14));
                        }
                    }

                    public final void onTick(long j) {
                    }
                };
                commonWebViewSetting.g = r4;
                r4.start();
                OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener = onCommonWebViewSettingEventListener;
                onCommonWebViewSettingEventListener.c();
                onCommonWebViewSettingEventListener.a();
            }

            public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                CommonWebViewSetting commonWebViewSetting = CommonWebViewSetting.this;
                commonWebViewSetting.b = true;
                OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener = onCommonWebViewSettingEventListener;
                if (commonWebViewSetting.c >= 3) {
                    onCommonWebViewSettingEventListener.d();
                    onCommonWebViewSettingEventListener.f(commonWebViewSetting.b);
                }
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
                if (sslErrorHandler != null) {
                    sslErrorHandler.cancel();
                }
            }

            /* JADX WARNING: type inference failed for: r0v3, types: [com.ktakilat.loan.webtool.CommonWebViewSetting$LocalAssets, java.lang.Object] */
            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                LocalAssets localAssets = LocalAssets.b;
                LocalAssets localAssets2 = localAssets;
                if (localAssets == null) {
                    ? obj = new Object();
                    obj.f580a = null;
                    LocalAssets.b = obj;
                    localAssets2 = obj;
                }
                WebResourceResponse a2 = localAssets2.a(webResourceRequest.getUrl().toString());
                if (a2 != null) {
                    return a2;
                }
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                this.f575a = str;
                return true;
            }

            public final void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                CommonWebViewSetting commonWebViewSetting = CommonWebViewSetting.this;
                commonWebViewSetting.b = true;
                OnCommonWebViewSettingEventListener onCommonWebViewSettingEventListener = onCommonWebViewSettingEventListener;
                if (commonWebViewSetting.c >= 3) {
                    onCommonWebViewSettingEventListener.d();
                    onCommonWebViewSettingEventListener.f(commonWebViewSetting.b);
                }
            }

            /* JADX WARNING: type inference failed for: r0v3, types: [com.ktakilat.loan.webtool.CommonWebViewSetting$LocalAssets, java.lang.Object] */
            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                LocalAssets localAssets = LocalAssets.b;
                LocalAssets localAssets2 = localAssets;
                if (localAssets == null) {
                    ? obj = new Object();
                    obj.f580a = null;
                    LocalAssets.b = obj;
                    localAssets2 = obj;
                }
                WebResourceResponse a2 = localAssets2.a(str);
                if (a2 != null) {
                    return a2;
                }
                return super.shouldInterceptRequest(webView, str);
            }
        });
        BaseActivity baseActivity = this.d;
        commonWebView.addJavascriptInterface(new JsCallAndroidInterface(baseActivity, commonWebView, onCommonWebViewSettingEventListener), "mobile");
        SmsVerifyCodeReceiver smsVerifyCodeReceiver = new SmsVerifyCodeReceiver();
        this.h = smsVerifyCodeReceiver;
        k0 k0Var = new k0(this, 12);
        Intrinsics.checkNotNullParameter(k0Var, "callback");
        smsVerifyCodeReceiver.f544a = k0Var;
        this.h.a(baseActivity);
    }

    public final void d() {
        BaseActivity baseActivity = this.d;
        if (baseActivity != null && !baseActivity.isDestroyed() && !baseActivity.isFinishing()) {
            try {
                boolean z = SmsVerificationService.e;
                SmsVerificationService.Companion.b(baseActivity);
            } catch (Exception unused) {
            }
        }
        SmsVerifyCodeReceiver smsVerifyCodeReceiver = this.h;
        if (smsVerifyCodeReceiver != null) {
            Intrinsics.checkNotNullParameter(baseActivity, PlaceFields.CONTEXT);
            try {
                LocalBroadcastManager.getInstance(baseActivity).unregisterReceiver(smsVerifyCodeReceiver);
            } catch (Exception unused2) {
            }
        }
        CountDownTimer countDownTimer = this.g;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.g = null;
        }
    }
}
