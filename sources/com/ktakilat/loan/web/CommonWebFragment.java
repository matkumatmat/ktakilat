package com.ktakilat.loan.web;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.common.net.HttpHeaders;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.http.ApiInfoUtil;
import com.ktakilat.cbase.http.ApiManager;
import com.ktakilat.cbase.ui.BaseFragment;
import com.ktakilat.cbase.utils.Dp2PxUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.cbase.weight.VerticalSwipeRefreshLayout;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.device.DeviceUtil;
import com.ktakilat.loan.global.Domain;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.ktakilat.loan.webtool.JsMap;
import com.pendanaan.kta.databinding.CFragmentCommonWebviewBinding;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressLint({"NonConstantResourceId"})
public class CommonWebFragment extends BaseFragment {
    public static ArrayList w;
    public CommonWebView e;
    public String f;
    public String g;
    public Boolean i;
    public Boolean j;
    public h3 k;
    public Integer l = 0;
    public CommonWebViewSetting m;
    public final Handler n = new Handler(Looper.getMainLooper());
    public int o = 0;
    public boolean p = true;
    public Boolean q;
    public CacheBuilder r;
    public ValueCallback s;
    public final SwipeRefreshLayout.OnRefreshListener t;
    public final ActivityResultLauncher u;
    public CFragmentCommonWebviewBinding v;

    public static class CacheBuilder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f572a;
        public Boolean b;
    }

    public interface WebCallback {
    }

    public CommonWebFragment() {
        Boolean bool = Boolean.FALSE;
        this.j = bool;
        this.q = bool;
        this.t = new SwipeRefreshLayout.OnRefreshListener() {
            public final void onRefresh() {
                CommonWebFragment commonWebFragment = CommonWebFragment.this;
                commonWebFragment.i(false);
                commonWebFragment.n.postDelayed(new a(this), 500);
            }
        };
        this.u = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k0(this, 11));
    }

    public static CommonWebFragment e(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putBoolean("isNeedLogin", false);
        bundle.putBoolean("isHome", z);
        bundle.putString("createKey", str2);
        CommonWebFragment commonWebFragment = new CommonWebFragment();
        commonWebFragment.setArguments(bundle);
        return commonWebFragment;
    }

    public final void c(String str) {
        if (this.e != null && !TextUtils.isEmpty(str)) {
            JsMap.a(this.e, "naviCallParams", str);
        }
    }

    public final boolean d() {
        CommonWebView commonWebView = this.e;
        if (commonWebView == null || !commonWebView.i) {
            return false;
        }
        JsMap.a(commonWebView, "naviClickBackBtn", "");
        return true;
    }

    public final void f(Runnable runnable) {
        Bitmap bitmap;
        CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding = this.v;
        if (!(cFragmentCommonWebviewBinding == null || this.p || cFragmentCommonWebviewBinding.holderLayout.getVisibility() == 0 || this.v.errorLayout.getVisibility() == 0)) {
            LinearLayout linearLayout = this.v.webContainer;
            try {
                bitmap = Bitmap.createBitmap(linearLayout.getWidth(), linearLayout.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawColor(-1);
                linearLayout.draw(canvas);
            } catch (Exception unused) {
                bitmap = null;
            }
            if (bitmap != null) {
                this.v.holderCacheIv.setImageBitmap(bitmap);
                this.v.holderCacheIv.setVisibility(0);
            } else {
                this.v.holderCacheIv.setVisibility(8);
            }
        }
        runnable.run();
    }

    public void g(Bundle bundle) {
        if (bundle != null) {
            this.f = bundle.getString("url");
            this.i = Boolean.valueOf(bundle.getBoolean("isNeedLogin", false));
            this.j = Boolean.valueOf(bundle.getBoolean("isHome", false));
            this.g = bundle.getString("createKey");
            StringBuilder sb = new StringBuilder();
            if (!this.f.contains("?")) {
                sb.append("?");
            } else {
                sb.append("&");
            }
            sb.append("Accept-Language=");
            sb.append(Base64.encodeToString(ApiManager.b().c(HttpHeaders.ACCEPT_LANGUAGE).getBytes(), 2));
            sb.append("&Device-Info=");
            sb.append(Base64.encodeToString(ApiInfoUtil.b().a().getBytes(), 2));
            this.f += sb.toString();
        }
    }

    public void h() {
        if (this.e != null) {
            String str = this.g;
            HashMap hashMap = WebViewCache.f573a;
            if (!hashMap.containsKey(str)) {
                Boolean bool = Boolean.FALSE;
                this.q = bool;
                CacheBuilder cacheBuilder = this.r;
                cacheBuilder.b = bool;
                cacheBuilder.f572a = false;
                if (this.i.booleanValue()) {
                    KtakilatApplication.m.getClass();
                    if (!KtakilatApplication.h() && this.f.startsWith(Domain.a())) {
                        this.e.loadUrl("");
                        return;
                    }
                }
                this.e.loadUrl(this.f);
                return;
            }
            String str2 = this.g;
            synchronized (WebViewCache.class) {
                hashMap.remove(str2);
            }
            CacheBuilder cacheBuilder2 = this.r;
            if (!cacheBuilder2.f572a) {
                cacheBuilder2.b = Boolean.FALSE;
                i(true);
                return;
            }
            this.q = cacheBuilder2.b;
            this.p = false;
        }
    }

    public void i(boolean z) {
        if (this.e == null) {
            return;
        }
        if (!this.q.booleanValue() || z) {
            if (this.i.booleanValue()) {
                KtakilatApplication.m.getClass();
                if (!KtakilatApplication.h()) {
                    this.e.loadUrl("");
                    return;
                }
            }
            if (TextUtils.isEmpty(this.e.getUrl())) {
                this.q = Boolean.FALSE;
                this.r.f572a = false;
                this.e.loadUrl(this.f);
                return;
            }
            f(new Runnable() {
                public final void run() {
                    CommonWebFragment.this.e.reload();
                }
            });
            return;
        }
        JsMap.a(this.e, "naviCallRefresh", new JsonObject().toString());
    }

    public void j() {
        if (this.e != null) {
            if (this.i.booleanValue()) {
                KtakilatApplication.m.getClass();
                if (!KtakilatApplication.h()) {
                    this.e.loadUrl("");
                    return;
                }
            }
            if (TextUtils.isEmpty(this.e.getUrl())) {
                this.e.loadUrl(this.f);
            }
        }
    }

    public final void k() {
        String str = this.g;
        CommonWebView commonWebView = this.e;
        HashMap hashMap = WebViewCache.f573a;
        synchronized (WebViewCache.class) {
            WebViewCache.f573a.put(str, commonWebView);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x021d, code lost:
        if (r9 != null) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x021f, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0231, code lost:
        if (r9 != null) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0234, code lost:
        r0 = r8.e;
        r1 = r3[0];
        r2 = r3[1];
        r3 = new com.google.gson.JsonObject();
        r3.addProperty(com.facebook.places.model.PlaceFields.PHONE, r1);
        r3.addProperty("name", r2);
        com.ktakilat.loan.webtool.JsMap.a(r0, "naviCallContactResult", r3.toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0257  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r17, int r18, android.content.Intent r19) {
        /*
            r16 = this;
            r8 = r16
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = 2
            super.onActivityResult(r17, r18, r19)
            r5 = 11000(0x2af8, float:1.5414E-41)
            r6 = 0
            if (r0 != r5) goto L_0x0020
            if (r2 == 0) goto L_0x0020
            java.lang.String r0 = "needRefresh"
            boolean r0 = r2.getBooleanExtra(r0, r6)
            if (r0 == 0) goto L_0x046f
            r8.i(r6)
            goto L_0x046f
        L_0x0020:
            r5 = 200(0xc8, float:2.8E-43)
            r7 = 1000(0x3e8, float:1.401E-42)
            r9 = 0
            r10 = 3000(0xbb8, float:4.204E-42)
            java.lang.String r11 = ".jpg"
            if (r0 != r10) goto L_0x00a7
            com.ktakilat.loan.webtool.CommonWebViewSetting r1 = r8.m
            java.io.File r1 = r1.f574a
            boolean r2 = r1.exists()
            if (r2 == 0) goto L_0x046f
            com.ktakilat.loan.KtakilatApplication r2 = com.ktakilat.loan.KtakilatApplication.m
            r2.getClass()
            com.ktakilat.loan.KtakilatApplication.j()
            java.io.File r2 = new java.io.File
            com.ktakilat.loan.KtakilatApplication r3 = com.ktakilat.loan.KtakilatApplication.m
            r3.getClass()
            com.ktakilat.cbase.ui.BaseApplication r3 = com.ktakilat.cbase.ui.BaseApplication.e
            java.io.File r3 = r3.getCacheDir()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r12 = java.lang.System.currentTimeMillis()
            r4.append(r12)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            java.lang.String r2 = r2.getPath()
            java.lang.String r1 = r1.getPath()
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r1)
            if (r1 == 0) goto L_0x046f
            byte[] r1 = com.ktakilat.cbase.utils.CompressUtil.a(r1, r7, r7, r5)
            int r3 = r1.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r6, r3)
            boolean r1 = com.ktakilat.cbase.utils.ImageUtil.a(r1, r2)
            if (r1 == 0) goto L_0x046f
            com.ktakilat.loan.http.upload.FileUploadEnum r3 = com.ktakilat.loan.http.upload.FileUploadEnum.OCR
            com.ktakilat.cbase.ui.BaseActivity r1 = r16.b()
            if (r1 == 0) goto L_0x008c
            com.ktakilat.cbase.ui.BaseActivity r1 = r16.b()
            r1.n()
        L_0x008c:
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            io.reactivex.Observable r9 = com.ktakilat.loan.http.AppHttp.commonUploadFile(r9, r3, r1, r9)
            com.ktakilat.loan.web.CommonWebFragment$5 r10 = new com.ktakilat.loan.web.CommonWebFragment$5
            r6 = 0
            r7 = 0
            r5 = 0
            r1 = r10
            r2 = r16
            r4 = r17
            r1.<init>(r3, r4, r5, r6, r7)
            r9.subscribe(r10)
            goto L_0x046f
        L_0x00a7:
            r10 = 3003(0xbbb, float:4.208E-42)
            if (r0 != r10) goto L_0x0135
            if (r2 == 0) goto L_0x0135
            java.lang.String r1 = "self-result"
            android.os.Bundle r1 = r2.getBundleExtra(r1)
            if (r1 == 0) goto L_0x046f
            java.lang.String r2 = "result"
            java.lang.String r5 = r1.getString(r2)
            java.lang.String r2 = "code"
            int r7 = r1.getInt(r2)
            r2 = 2131755486(0x7f1001de, float:1.9141853E38)
            if (r7 != r2) goto L_0x046f
            java.lang.String r2 = "delta"
            java.lang.String r10 = r1.getString(r2)
            java.lang.String r2 = "photo"
            byte[] r1 = r1.getByteArray(r2)
            com.ktakilat.loan.KtakilatApplication r2 = com.ktakilat.loan.KtakilatApplication.m
            r2.getClass()
            com.ktakilat.loan.KtakilatApplication.j()
            java.io.File r2 = new java.io.File
            com.ktakilat.loan.KtakilatApplication r3 = com.ktakilat.loan.KtakilatApplication.m
            r3.getClass()
            com.ktakilat.cbase.ui.BaseApplication r3 = com.ktakilat.cbase.ui.BaseApplication.e
            java.io.File r3 = r3.getCacheDir()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            long r12 = java.lang.System.currentTimeMillis()
            r4.append(r12)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            java.lang.String r2 = r2.getPath()
            int r3 = r1.length
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r6, r3)
            boolean r1 = com.ktakilat.cbase.utils.ImageUtil.a(r1, r2)
            if (r1 == 0) goto L_0x046f
            com.ktakilat.loan.http.upload.FileUploadEnum r3 = com.ktakilat.loan.http.upload.FileUploadEnum.FACE
            com.ktakilat.cbase.ui.BaseActivity r1 = r16.b()
            if (r1 == 0) goto L_0x011b
            com.ktakilat.cbase.ui.BaseActivity r1 = r16.b()
            r1.n()
        L_0x011b:
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            io.reactivex.Observable r9 = com.ktakilat.loan.http.AppHttp.commonUploadFile(r9, r3, r1, r9)
            com.ktakilat.loan.web.CommonWebFragment$5 r11 = new com.ktakilat.loan.web.CommonWebFragment$5
            r1 = r11
            r2 = r16
            r4 = r17
            r6 = r7
            r7 = r10
            r1.<init>(r3, r4, r5, r6, r7)
            r9.subscribe(r11)
            goto L_0x046f
        L_0x0135:
            r10 = 5000(0x1388, float:7.006E-42)
            r12 = -1
            if (r0 != r10) goto L_0x019a
            if (r2 == 0) goto L_0x019a
            if (r1 != r12) goto L_0x046f
            java.lang.String r0 = "provName"
            java.lang.String r0 = r2.getStringExtra(r0)
            java.lang.String r1 = "provId"
            int r1 = r2.getIntExtra(r1, r6)
            java.lang.String r3 = "cityName"
            java.lang.String r3 = r2.getStringExtra(r3)
            java.lang.String r4 = "cityId"
            int r5 = r2.getIntExtra(r4, r6)
            java.lang.String r7 = "districtName"
            java.lang.String r7 = r2.getStringExtra(r7)
            java.lang.String r9 = "districtId"
            int r2 = r2.getIntExtra(r9, r6)
            com.ktakilat.cbase.weight.CommonWebView r6 = r8.e
            com.google.gson.JsonObject r10 = new com.google.gson.JsonObject
            r10.<init>()
            java.lang.String r11 = "province"
            r10.addProperty((java.lang.String) r11, (java.lang.String) r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            java.lang.String r1 = "provinceId"
            r10.addProperty((java.lang.String) r1, (java.lang.Number) r0)
            java.lang.String r0 = "city"
            r10.addProperty((java.lang.String) r0, (java.lang.String) r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r10.addProperty((java.lang.String) r4, (java.lang.Number) r0)
            java.lang.String r0 = "district"
            r10.addProperty((java.lang.String) r0, (java.lang.String) r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            r10.addProperty((java.lang.String) r9, (java.lang.Number) r0)
            java.lang.String r0 = "naviCallRegionResult"
            java.lang.String r1 = r10.toString()
            com.ktakilat.loan.webtool.JsMap.a(r6, r0, r1)
            goto L_0x046f
        L_0x019a:
            r10 = 5001(0x1389, float:7.008E-42)
            java.lang.String r13 = "address"
            java.lang.String r14 = "lng"
            r4 = 0
            java.lang.String r15 = "lat"
            if (r0 != r10) goto L_0x01d7
            if (r2 == 0) goto L_0x01d7
            java.lang.String r0 = r2.getStringExtra(r13)
            double r6 = r2.getDoubleExtra(r15, r4)
            double r1 = r2.getDoubleExtra(r14, r4)
            com.ktakilat.cbase.weight.CommonWebView r3 = r8.e
            com.google.gson.JsonObject r4 = new com.google.gson.JsonObject
            r4.<init>()
            r4.addProperty((java.lang.String) r13, (java.lang.String) r0)
            java.lang.Double r0 = java.lang.Double.valueOf(r6)
            r4.addProperty((java.lang.String) r15, (java.lang.Number) r0)
            java.lang.Double r0 = java.lang.Double.valueOf(r1)
            r4.addProperty((java.lang.String) r14, (java.lang.Number) r0)
            java.lang.String r0 = "naviCallCompanyAddressResult"
            java.lang.String r1 = r4.toString()
            com.ktakilat.loan.webtool.JsMap.a(r3, r0, r1)
            goto L_0x046f
        L_0x01d7:
            r10 = 6000(0x1770, float:8.408E-42)
            if (r0 != r10) goto L_0x025b
            if (r2 == 0) goto L_0x025b
            android.content.Context r1 = r16.getContext()
            java.lang.String[] r3 = new java.lang.String[r3]
            android.content.ContentResolver r10 = r1.getContentResolver()     // Catch:{ Exception -> 0x0225 }
            android.net.Uri r11 = r19.getData()     // Catch:{ Exception -> 0x0225 }
            java.lang.String r0 = "data1"
            java.lang.String r2 = "display_name"
            java.lang.String[] r12 = new java.lang.String[]{r0, r2}     // Catch:{ Exception -> 0x0225 }
            r13 = 0
            r14 = 0
            r15 = 0
            android.database.Cursor r2 = r10.query(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0225 }
            if (r2 == 0) goto L_0x021a
        L_0x01fc:
            boolean r0 = r2.moveToNext()     // Catch:{ Exception -> 0x0213, all -> 0x0210 }
            if (r0 == 0) goto L_0x0216
            java.lang.String r0 = r2.getString(r6)     // Catch:{ Exception -> 0x0213, all -> 0x0210 }
            r4 = 1
            java.lang.String r5 = r2.getString(r4)     // Catch:{ Exception -> 0x0213, all -> 0x0210 }
            r3[r6] = r0     // Catch:{ Exception -> 0x0213, all -> 0x0210 }
            r3[r4] = r5     // Catch:{ Exception -> 0x0213, all -> 0x0210 }
            goto L_0x01fc
        L_0x0210:
            r0 = move-exception
            r9 = r2
            goto L_0x0255
        L_0x0213:
            r0 = move-exception
            r9 = r2
            goto L_0x0226
        L_0x0216:
            r2.close()     // Catch:{ Exception -> 0x0213, all -> 0x0210 }
            goto L_0x021d
        L_0x021a:
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ Exception -> 0x0213, all -> 0x0210 }
            r9 = r2
        L_0x021d:
            if (r9 == 0) goto L_0x0234
        L_0x021f:
            r9.close()
            goto L_0x0234
        L_0x0223:
            r0 = move-exception
            goto L_0x0255
        L_0x0225:
            r0 = move-exception
        L_0x0226:
            com.ktakilat.cbase.utils.LogUtil.b(r0)     // Catch:{ all -> 0x0223 }
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k     // Catch:{ all -> 0x0223 }
            r0 = 2131755153(0x7f100091, float:1.9141177E38)
            com.ktakilat.cbase.utils.ToastUtil.c(r1, r0)     // Catch:{ all -> 0x0223 }
            if (r9 == 0) goto L_0x0234
            goto L_0x021f
        L_0x0234:
            com.ktakilat.cbase.weight.CommonWebView r0 = r8.e
            r1 = r3[r6]
            r2 = 1
            r2 = r3[r2]
            com.google.gson.JsonObject r3 = new com.google.gson.JsonObject
            r3.<init>()
            java.lang.String r4 = "phone"
            r3.addProperty((java.lang.String) r4, (java.lang.String) r1)
            java.lang.String r1 = "name"
            r3.addProperty((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = "naviCallContactResult"
            java.lang.String r2 = r3.toString()
            com.ktakilat.loan.webtool.JsMap.a(r0, r1, r2)
            goto L_0x046f
        L_0x0255:
            if (r9 == 0) goto L_0x025a
            r9.close()
        L_0x025a:
            throw r0
        L_0x025b:
            r10 = 4001(0xfa1, float:5.607E-42)
            if (r0 != r10) goto L_0x029a
            if (r2 == 0) goto L_0x029a
            java.lang.String r0 = "location-result"
            android.os.Bundle r0 = r2.getBundleExtra(r0)
            if (r0 == 0) goto L_0x046f
            java.lang.String r1 = "location-address"
            java.lang.String r1 = r0.getString(r1)
            double r2 = r0.getDouble(r15, r4)
            double r4 = r0.getDouble(r14, r4)
            com.ktakilat.cbase.weight.CommonWebView r0 = r8.e
            com.google.gson.JsonObject r6 = new com.google.gson.JsonObject
            r6.<init>()
            r6.addProperty((java.lang.String) r13, (java.lang.String) r1)
            java.lang.Double r1 = java.lang.Double.valueOf(r2)
            r6.addProperty((java.lang.String) r15, (java.lang.Number) r1)
            java.lang.Double r1 = java.lang.Double.valueOf(r4)
            r6.addProperty((java.lang.String) r14, (java.lang.Number) r1)
            java.lang.String r1 = "naviCallMyAddressResult"
            java.lang.String r2 = r6.toString()
            com.ktakilat.loan.webtool.JsMap.a(r0, r1, r2)
            goto L_0x046f
        L_0x029a:
            r4 = 7000(0x1b58, float:9.809E-42)
            if (r0 != r4) goto L_0x02d9
            if (r2 == 0) goto L_0x02d9
            java.lang.String r0 = "bank_result"
            java.io.Serializable r0 = r2.getSerializableExtra(r0)
            com.ktakilat.loan.http.bank_card.BankResp r0 = (com.ktakilat.loan.http.bank_card.BankResp) r0
            com.ktakilat.cbase.weight.CommonWebView r1 = r8.e
            java.lang.String r2 = r0.getName()
            java.lang.String r3 = r0.getCode()
            long r4 = r0.getId()
            com.google.gson.JsonObject r0 = new com.google.gson.JsonObject
            r0.<init>()
            java.lang.String r6 = "bankName"
            r0.addProperty((java.lang.String) r6, (java.lang.String) r2)
            java.lang.String r2 = "bankCode"
            r0.addProperty((java.lang.String) r2, (java.lang.String) r3)
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r3 = "bankId"
            r0.addProperty((java.lang.String) r3, (java.lang.Number) r2)
            java.lang.String r2 = "naviCallBankListResult"
            java.lang.String r0 = r0.toString()
            com.ktakilat.loan.webtool.JsMap.a(r1, r2, r0)
            goto L_0x046f
        L_0x02d9:
            r4 = 3004(0xbbc, float:4.21E-42)
            if (r0 != r4) goto L_0x036c
            if (r2 == 0) goto L_0x036c
            androidx.fragment.app.FragmentActivity r4 = r16.getActivity()
            if (r4 == 0) goto L_0x036c
            android.net.Uri r1 = r19.getData()     // Catch:{ Exception -> 0x035f }
            android.content.Context r2 = r16.getContext()     // Catch:{ Exception -> 0x035f }
            java.lang.String r1 = com.ktakilat.cbase.utils.FileUtil.b(r2, r1)     // Catch:{ Exception -> 0x035f }
            com.ktakilat.loan.KtakilatApplication r2 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x035f }
            r2.getClass()     // Catch:{ Exception -> 0x035f }
            com.ktakilat.loan.KtakilatApplication.j()     // Catch:{ Exception -> 0x035f }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x035f }
            com.ktakilat.loan.KtakilatApplication r3 = com.ktakilat.loan.KtakilatApplication.m     // Catch:{ Exception -> 0x035f }
            r3.getClass()     // Catch:{ Exception -> 0x035f }
            com.ktakilat.cbase.ui.BaseApplication r3 = com.ktakilat.cbase.ui.BaseApplication.e     // Catch:{ Exception -> 0x035f }
            java.io.File r3 = r3.getCacheDir()     // Catch:{ Exception -> 0x035f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x035f }
            r4.<init>()     // Catch:{ Exception -> 0x035f }
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x035f }
            r4.append(r12)     // Catch:{ Exception -> 0x035f }
            r4.append(r11)     // Catch:{ Exception -> 0x035f }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x035f }
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x035f }
            java.lang.String r2 = r2.getPath()     // Catch:{ Exception -> 0x035f }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeFile(r1)     // Catch:{ Exception -> 0x035f }
            r3 = 200(0xc8, float:2.8E-43)
            byte[] r1 = com.ktakilat.cbase.utils.CompressUtil.a(r1, r7, r7, r3)     // Catch:{ Exception -> 0x035f }
            int r3 = r1.length     // Catch:{ Exception -> 0x035f }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeByteArray(r1, r6, r3)     // Catch:{ Exception -> 0x035f }
            boolean r1 = com.ktakilat.cbase.utils.ImageUtil.a(r1, r2)     // Catch:{ Exception -> 0x035f }
            if (r1 == 0) goto L_0x046f
            com.ktakilat.loan.http.upload.FileUploadEnum r3 = com.ktakilat.loan.http.upload.FileUploadEnum.FEED_BACK     // Catch:{ Exception -> 0x035f }
            com.ktakilat.cbase.ui.BaseActivity r1 = r16.b()     // Catch:{ Exception -> 0x035f }
            if (r1 == 0) goto L_0x0344
            com.ktakilat.cbase.ui.BaseActivity r1 = r16.b()     // Catch:{ Exception -> 0x035f }
            r1.n()     // Catch:{ Exception -> 0x035f }
        L_0x0344:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x035f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x035f }
            io.reactivex.Observable r9 = com.ktakilat.loan.http.AppHttp.commonUploadFile(r9, r3, r1, r9)     // Catch:{ Exception -> 0x035f }
            com.ktakilat.loan.web.CommonWebFragment$5 r10 = new com.ktakilat.loan.web.CommonWebFragment$5     // Catch:{ Exception -> 0x035f }
            r6 = 0
            r7 = 0
            r5 = 0
            r1 = r10
            r2 = r16
            r4 = r17
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x035f }
            r9.subscribe(r10)     // Catch:{ Exception -> 0x035f }
            goto L_0x046f
        L_0x035f:
            android.content.Context r0 = r16.getContext()
            java.lang.String r1 = "error"
            com.ktakilat.cbase.utils.ToastUtil.d(r0, r1)
            java.util.ArrayList r0 = com.ktakilat.cbase.ui.LogActivity.k
            goto L_0x046f
        L_0x036c:
            r4 = 800(0x320, float:1.121E-42)
            if (r0 != r4) goto L_0x03fe
            if (r2 == 0) goto L_0x03f7
            java.lang.String r0 = "processType"
            int r0 = r2.getIntExtra(r0, r12)
            java.lang.String r3 = "processToken"
            java.lang.String r3 = r2.getStringExtra(r3)
            java.lang.String r4 = "loginResp"
            java.io.Serializable r5 = r2.getSerializableExtra(r4)
            if (r5 == 0) goto L_0x038c
            java.io.Serializable r2 = r2.getSerializableExtra(r4)
            com.ktakilat.loan.http.user.UserLoginResp r2 = (com.ktakilat.loan.http.user.UserLoginResp) r2
        L_0x038c:
            r2 = 108(0x6c, float:1.51E-43)
            if (r0 != r2) goto L_0x039c
            com.ktakilat.cbase.weight.CommonWebView r0 = r8.e
            if (r1 != r12) goto L_0x0396
            r4 = 1
            goto L_0x0397
        L_0x0396:
            r4 = 0
        L_0x0397:
            com.ktakilat.loan.webtool.JsMap.ThirdMap.a(r0, r4, r3)
            goto L_0x046f
        L_0x039c:
            r2 = 106(0x6a, float:1.49E-43)
            if (r0 != r2) goto L_0x03b4
            if (r1 != r12) goto L_0x03b4
            com.ktakilat.cbase.weight.CommonWebView r0 = r8.e
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            java.lang.String r2 = "naviCallSafeVerifySuc"
            java.lang.String r1 = r1.toString()
            com.ktakilat.loan.webtool.JsMap.a(r0, r2, r1)
            goto L_0x046f
        L_0x03b4:
            r2 = 101(0x65, float:1.42E-43)
            if (r0 == r2) goto L_0x03e1
            r2 = 102(0x66, float:1.43E-43)
            if (r0 != r2) goto L_0x03bd
            goto L_0x03e1
        L_0x03bd:
            r2 = 109(0x6d, float:1.53E-43)
            if (r0 != r2) goto L_0x03cd
            com.ktakilat.cbase.weight.CommonWebView r0 = r8.e
            if (r1 != r12) goto L_0x03c7
            r4 = 1
            goto L_0x03c8
        L_0x03c7:
            r4 = 0
        L_0x03c8:
            com.ktakilat.loan.webtool.JsMap.ThirdMap.a(r0, r4, r3)
            goto L_0x046f
        L_0x03cd:
            r1 = 103(0x67, float:1.44E-43)
            if (r0 == r1) goto L_0x03d5
            r1 = 104(0x68, float:1.46E-43)
            if (r0 != r1) goto L_0x046f
        L_0x03d5:
            com.ktakilat.loan.weiget.GestureUtil r0 = new com.ktakilat.loan.weiget.GestureUtil
            r0.<init>((com.ktakilat.loan.web.CommonWebFragment) r8)
            com.ktakilat.loan.weiget.GestureUtil$GestureSetEnum r1 = com.ktakilat.loan.weiget.GestureUtil.GestureSetEnum.SETTING
            r0.f(r1, r9)
            goto L_0x046f
        L_0x03e1:
            androidx.fragment.app.FragmentActivity r0 = r16.getActivity()
            int r1 = com.ktakilat.loan.reset_pwd.ResetPwdActivity.n
            if (r0 != 0) goto L_0x03eb
            goto L_0x046f
        L_0x03eb:
            android.content.Intent r1 = new android.content.Intent
            java.lang.Class<com.ktakilat.loan.reset_pwd.ResetPwdActivity> r2 = com.ktakilat.loan.reset_pwd.ResetPwdActivity.class
            r1.<init>(r0, r2)
            r0.startActivity(r1)
            goto L_0x046f
        L_0x03f7:
            com.ktakilat.cbase.weight.CommonWebView r0 = r8.e
            com.ktakilat.loan.webtool.JsMap.ThirdMap.a(r0, r6, r9)
            goto L_0x046f
        L_0x03fe:
            r4 = 10001(0x2711, float:1.4014E-41)
            if (r0 != r4) goto L_0x0413
            com.ktakilat.cbase.weight.CommonWebView r0 = r8.e
            com.google.gson.JsonObject r1 = new com.google.gson.JsonObject
            r1.<init>()
            java.lang.String r2 = "naviCallFaceOpenResult"
            java.lang.String r1 = r1.toString()
            com.ktakilat.loan.webtool.JsMap.a(r0, r2, r1)
            goto L_0x046f
        L_0x0413:
            r4 = 11002(0x2afa, float:1.5417E-41)
            if (r0 != r4) goto L_0x0436
            if (r2 == 0) goto L_0x042c
            android.webkit.ValueCallback r0 = r8.s
            java.lang.String r1 = r19.getDataString()
            android.net.Uri r1 = android.net.Uri.parse(r1)
            r2 = 1
            android.net.Uri[] r2 = new android.net.Uri[r2]
            r2[r6] = r1
            r0.onReceiveValue(r2)
            goto L_0x0433
        L_0x042c:
            android.webkit.ValueCallback r0 = r8.s
            android.net.Uri[] r1 = new android.net.Uri[r6]
            r0.onReceiveValue(r1)
        L_0x0433:
            r8.s = r9
            goto L_0x046f
        L_0x0436:
            r4 = 11451400(0xaebc08, float:1.6046829E-38)
            if (r0 != r4) goto L_0x0459
            if (r1 != r12) goto L_0x046f
            android.content.Context r0 = r16.getContext()
            if (r0 == 0) goto L_0x046f
            com.ktakilat.cbase.datacollect.KtaCollect.n_liveness_exposure()
            android.content.Context r0 = r16.getContext()
            z0 r1 = new z0
            r1.<init>(r8, r3)
            c r2 = new c
            r3 = 1
            r2.<init>(r8, r3)
            com.ktakilat.loan.utils.TrustLivenessUtil.Companion.b(r0, r1, r2)
            goto L_0x046f
        L_0x0459:
            com.ktakilat.loan.weiget.ShareUtil r3 = new com.ktakilat.loan.weiget.ShareUtil     // Catch:{ Exception -> 0x046f }
            com.ktakilat.cbase.ui.BaseActivity r4 = r16.b()     // Catch:{ Exception -> 0x046f }
            r3.<init>(r4)     // Catch:{ Exception -> 0x046f }
            com.facebook.share.widget.ShareDialog r4 = r3.b     // Catch:{ Exception -> 0x046f }
            int r4 = r4.getRequestCode()     // Catch:{ Exception -> 0x046f }
            if (r0 != r4) goto L_0x046f
            com.facebook.CallbackManager r3 = r3.c     // Catch:{ Exception -> 0x046f }
            r3.onActivityResult(r0, r1, r2)     // Catch:{ Exception -> 0x046f }
        L_0x046f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.web.CommonWebFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.ktakilat.loan.web.CommonWebFragment$CacheBuilder, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g(getArguments());
        ? obj = new Object();
        obj.f572a = false;
        obj.b = Boolean.FALSE;
        this.r = obj;
        if (bundle != null) {
            obj.f572a = bundle.getBoolean("mIsPageSuc", false);
            this.r.b = Boolean.valueOf(bundle.getBoolean("mIsH5Refresh", false));
        }
        this.o = 0;
        this.m = new CommonWebViewSetting(b());
        CommonWebView a2 = WebViewCache.a(this.g);
        this.e = a2;
        a2.setScrollBarSize(0);
        this.e.setWebChromeClient(new WebChromeClient() {
            public void onReceivedTitle(WebView webView, String str) {
                h3 h3Var;
                if (!TextUtils.isEmpty(str) && !"null".equalsIgnoreCase(str) && (h3Var = CommonWebFragment.this.k) != null) {
                    h3Var.c.o.pageTitle.title.setText(str);
                }
                super.onReceivedTitle(webView, str);
            }

            public final boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                if (fileChooserParams == null) {
                    return false;
                }
                CommonWebFragment commonWebFragment = CommonWebFragment.this;
                commonWebFragment.s = valueCallback;
                try {
                    commonWebFragment.u.launch(fileChooserParams.createIntent());
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        this.m.c(this.e, new CommonWebViewSetting.OnCommonWebViewSettingEventListener() {
            public final void a() {
                hashCode();
                CommonWebFragment commonWebFragment = CommonWebFragment.this;
                CommonWebView commonWebView = commonWebFragment.e;
                if (commonWebView != null) {
                    commonWebView.i = false;
                }
                if (commonWebFragment.b() != null) {
                    commonWebFragment.b().n();
                }
            }

            public final void b(boolean z) {
                CommonWebFragment.this.i(z);
            }

            public final void c() {
                CommonWebFragment commonWebFragment = CommonWebFragment.this;
                commonWebFragment.r.f572a = false;
                commonWebFragment.p = false;
                CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding = commonWebFragment.v;
                if (cFragmentCommonWebviewBinding != null) {
                    cFragmentCommonWebviewBinding.errorLayout.setVisibility(8);
                    commonWebFragment.v.holderLayout.setVisibility(0);
                }
            }

            public final void d() {
                hashCode();
                CommonWebFragment commonWebFragment = CommonWebFragment.this;
                if (commonWebFragment.b() != null) {
                    if (commonWebFragment.b() != null) {
                        commonWebFragment.b().u();
                    }
                    commonWebFragment.c(commonWebFragment.b().q());
                }
            }

            public final void e(boolean z) {
                CommonWebFragment commonWebFragment = CommonWebFragment.this;
                commonWebFragment.r.b = Boolean.valueOf(z);
                commonWebFragment.q = Boolean.valueOf(z);
            }

            public final void f(boolean z) {
                int i;
                CommonWebFragment commonWebFragment = CommonWebFragment.this;
                commonWebFragment.r.f572a = !z;
                commonWebFragment.p = z;
                CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding = commonWebFragment.v;
                if (cFragmentCommonWebviewBinding != null) {
                    RelativeLayout relativeLayout = cFragmentCommonWebviewBinding.errorLayout;
                    if (z) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    relativeLayout.setVisibility(i);
                    commonWebFragment.v.holderLayout.setVisibility(8);
                }
                if (z) {
                    ToastUtil.c(commonWebFragment.getContext(), R.string.h5_page_load_error);
                }
            }

            public final void g(boolean z) {
                CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding = CommonWebFragment.this.v;
                if (cFragmentCommonWebviewBinding != null) {
                    cFragmentCommonWebviewBinding.refreshLayout.setEnabled(z);
                }
            }
        });
        h();
        synchronized (CommonWebFragment.class) {
            try {
                if (w == null) {
                    w = new ArrayList(0);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    w.add(this.f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding;
        System.currentTimeMillis();
        this.v = CFragmentCommonWebviewBinding.inflate(layoutInflater, viewGroup, false);
        if (this.j.booleanValue()) {
            this.v.homeErrorLayout.setVisibility(0);
            this.v.holderPageTitle.getRoot().setVisibility(0);
            this.v.oopsLayout.setVisibility(8);
        } else {
            this.v.homeErrorLayout.setVisibility(8);
            this.v.holderPageTitle.getRoot().setVisibility(0);
            this.v.oopsLayout.setVisibility(0);
        }
        if (this.r.f572a && (cFragmentCommonWebviewBinding = this.v) != null) {
            cFragmentCommonWebviewBinding.errorLayout.setVisibility(8);
            this.v.holderLayout.setVisibility(8);
        }
        CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding2 = this.v;
        if (cFragmentCommonWebviewBinding2 != null) {
            cFragmentCommonWebviewBinding2.holderOtherView.removeAllViews();
            LinearLayout linearLayout = this.v.holderOtherView;
            boolean booleanValue = this.j.booleanValue();
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            if (booleanValue) {
                layoutParams.topMargin = Dp2PxUtil.a(getContext(), 6.0f);
                layoutParams.leftMargin = Dp2PxUtil.a(getContext(), 12.0f);
                layoutParams.rightMargin = Dp2PxUtil.a(getContext(), 12.0f);
                imageView.setImageResource(R.drawable.default_page_guide);
            } else {
                String str = this.f;
                if (!TextUtils.isEmpty(str)) {
                    if (!str.startsWith(Domain.a() + "Authenticate/Pribadi")) {
                        if (!str.startsWith(Domain.a() + "Authenticate/Pekerjaan")) {
                            if (!str.startsWith(Domain.a() + "Authenticate/Darurat")) {
                                if (!str.startsWith(Domain.a() + "Authenticate/Bank")) {
                                    if (str.startsWith(Domain.a() + "Authenticate/Identitas")) {
                                        imageView.setImageResource(R.drawable.ic_h5_identity);
                                    } else {
                                        if (!str.startsWith(Domain.a() + "Authenticate/LoanAudit")) {
                                            if (!str.startsWith(Domain.a() + "Home/InquiryApply/index")) {
                                                if (!str.startsWith(Domain.a() + "Home/GuideRepay/index")) {
                                                    if (!str.startsWith(Domain.a() + "Home/ChangeRepay/index")) {
                                                        imageView.setImageResource(R.drawable.ic_h5_normal);
                                                    }
                                                }
                                                imageView.setImageResource(R.drawable.ic_h5_cdtime);
                                            }
                                        }
                                        imageView.setImageResource(R.drawable.ic_h5_cdtime);
                                    }
                                }
                            }
                        }
                    }
                    imageView.setImageResource(R.drawable.ic_h5_auth);
                }
            }
            imageView.setLayoutParams(layoutParams);
            linearLayout.addView(imageView);
        }
        int i2 = this.o;
        if (i2 < Integer.MAX_VALUE) {
            this.o = i2 + 1;
        }
        CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding3 = this.v;
        if (cFragmentCommonWebviewBinding3 != null) {
            cFragmentCommonWebviewBinding3.pageTitle.title.setText(DeviceUtil.f(getContext()));
            this.v.pageTitle.backward.setOnClickListener(new i3(this, 0));
        }
        if (b() instanceof HomeActivity) {
            CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding4 = this.v;
            if (cFragmentCommonWebviewBinding4 != null) {
                cFragmentCommonWebviewBinding4.pageTitle.backward.setVisibility(4);
                this.v.holderPageTitle.backward.setVisibility(4);
            }
        } else {
            CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding5 = this.v;
            if (cFragmentCommonWebviewBinding5 != null) {
                cFragmentCommonWebviewBinding5.pageTitle.backward.setVisibility(0);
                this.v.holderPageTitle.backward.setVisibility(0);
            }
        }
        CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding6 = this.v;
        if (cFragmentCommonWebviewBinding6 != null) {
            cFragmentCommonWebviewBinding6.pageTitle.backward.setOnClickListener(new i3(this, 1));
            this.v.homeErrorLayout.setOnClickListener(new i3(this, 2));
            this.v.tryAgainTv.setOnClickListener(new i3(this, 3));
            VerticalSwipeRefreshLayout verticalSwipeRefreshLayout = this.v.refreshLayout;
            verticalSwipeRefreshLayout.setColorSchemeResources(R.color.redMain);
            verticalSwipeRefreshLayout.setSize(1);
            verticalSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.white);
            verticalSwipeRefreshLayout.setProgressViewEndTarget(true, 160);
            verticalSwipeRefreshLayout.setOnRefreshListener(this.t);
            if (this.o > 1 || !this.p) {
                this.v.holderLayout.setVisibility(8);
            } else {
                this.v.holderLayout.setVisibility(0);
            }
        }
        if (this.e != null) {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(new ViewGroup.LayoutParams(-1, -1));
            CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding7 = this.v;
            if (cFragmentCommonWebviewBinding7 != null) {
                cFragmentCommonWebviewBinding7.webContainer.addView(this.e, layoutParams2);
            }
        }
        if (this.v == null) {
            return new View(getContext());
        }
        if (this.l.intValue() != 0) {
            ColorDrawable colorDrawable = new ColorDrawable(this.l.intValue());
            try {
                this.v.holderPageTitle.getRoot().setBackground(colorDrawable);
                this.v.pageTitle.getRoot().setBackground(colorDrawable);
            } catch (Exception unused) {
            }
        }
        return this.v.getRoot();
    }

    public final void onDestroy() {
        CommonWebView commonWebView;
        synchronized (CommonWebActivity.class) {
            w.remove(this.f);
        }
        if (!WebViewCache.f573a.containsKey(this.g) && (commonWebView = this.e) != null) {
            commonWebView.clearCache(true);
            WebViewCache.b.add(commonWebView);
            this.e = null;
        }
        CommonWebViewSetting commonWebViewSetting = this.m;
        if (commonWebViewSetting != null) {
            commonWebViewSetting.d();
        }
        super.onDestroy();
    }

    public final void onDestroyView() {
        CFragmentCommonWebviewBinding cFragmentCommonWebviewBinding = this.v;
        if (cFragmentCommonWebviewBinding != null) {
            CommonWebView commonWebView = this.e;
            if (commonWebView != null) {
                cFragmentCommonWebviewBinding.webContainer.removeView(commonWebView);
            }
            this.v = null;
        }
        super.onDestroyView();
    }

    public final void onResume() {
        super.onResume();
        j();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("mIsH5Refresh", this.r.b.booleanValue());
        bundle.putBoolean("mIsPageSuc", this.r.f572a);
        super.onSaveInstanceState(bundle);
    }
}
