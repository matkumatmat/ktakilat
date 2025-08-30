package com.trustdecision.liveness.cw.api.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.trustdecision.liveness.cw.R;
import com.trustdecision.liveness.cw.api.il111liilil.il111liilil;
import com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1;
import com.trustdecision.liveness.cw.api.ui.TDJsBridge;
import org.json.JSONObject;

public class TDH5LivenessActivity extends Activity {
    public int CAMERA_PERMISSION_REQUEST_CODE = 100;
    private TDJsBridge jsBridge;
    /* access modifiers changed from: private */
    public PermissionRequest mRequest = null;
    /* access modifiers changed from: private */
    public TDWebView mWebView;

    /* access modifiers changed from: private */
    public static String i1i1iI1I11iI(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            int length = decode.length;
            byte[] bytes = "caRppI".getBytes();
            int length2 = bytes.length;
            for (int i = 0; i < length; i++) {
                decode[i] = (byte) (decode[i] ^ bytes[i % length2]);
            }
            return new String(decode, "utf-8");
        } catch (Exception unused) {
            return null;
        }
    }

    private void initRBBtn() {
        this.mWebView = (TDWebView) findViewById(R.id.wb_h5_liveness);
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TDH5LivenessActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    public static String linkxxxxx(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b = (byte) (i ^ 105);
            byte b2 = (byte) (bArr[0] ^ 96);
            bArr[0] = b2;
            int i4 = 1;
            while (i4 < length) {
                byte b3 = bArr[i4];
                bArr[i4] = (byte) ((b2 ^ b3) ^ b);
                i4++;
                b2 = b3;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void loadWebView() {
        this.mWebView.setWebViewClient(new WebViewClient() {
            private boolean isReceivedError;

            public void onPageFinished(WebView webView, String str) {
                if (!this.isReceivedError) {
                    TDH5LivenessActivity.this.mWebView.setVisibility(0);
                }
            }

            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                TDH5LivenessActivity.this.mWebView.setVisibility(8);
            }

            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                this.isReceivedError = true;
                try {
                    String str = illill1ll1.l1lliiiil1lll1lil1i1;
                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str, TDH5LivenessActivity.linkxxxxx("2e095f0a47175e5c1d501c501756004b064a480c4f044a0d4b", 75), "");
                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str, TDH5LivenessActivity.linkxxxxx("2e585f5b47465e0d1d011c011707001a061b485d4f554a5c4b", 26));
                    TDH5LivenessActivity.this.finish();
                } catch (Throwable unused) {
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return super.shouldOverrideUrlLoading(webView, str);
            }
        });
        this.mWebView.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                return super.onConsoleMessage(consoleMessage);
            }

            public void onPermissionRequest(PermissionRequest permissionRequest) {
                PermissionRequest unused = TDH5LivenessActivity.this.mRequest = permissionRequest;
                if (ContextCompat.checkSelfPermission(TDH5LivenessActivity.this, "android.permission.CAMERA") == 0) {
                    permissionRequest.grant(permissionRequest.getResources());
                } else {
                    ActivityCompat.requestPermissions(TDH5LivenessActivity.this, new String[]{"android.permission.CAMERA"}, 100);
                }
            }
        });
        this.jsBridge = new TDJsBridge(new TDJsBridge.JSCallBack() {
            public void jsLiveResult(String str, String str2) {
                String str3;
                String str4;
                String str5;
                if (TDH5LivenessActivity.linkxxxxx("50", 100).equals(str2) || TDH5LivenessActivity.linkxxxxx("52", 17).equals(str2)) {
                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1((il111liilil) new il111liilil() {
                        public void onError(String str) {
                            String str2;
                            String str3 = illill1ll1.l1lliiiil1lll1lil1i1;
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                str3 = jSONObject.optString(TDH5LivenessActivity.linkxxxxx("031d681c", 120));
                                str = jSONObject.optString(TDH5LivenessActivity.i1i1iI1I11iI("DgQhAxEuBg=="));
                                str2 = jSONObject.optString(TDH5LivenessActivity.i1i1iI1I11iI("EAQjBRUnAAQNGRQ="));
                            } catch (Throwable unused) {
                                str2 = "";
                            }
                            com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str3, str, str2);
                            com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str3, str);
                            com.trustdecision.liveness.cw.api.i11iliil1li1.il111liilil.illill1ll1((Runnable) new gd(TDH5LivenessActivity.this, 7));
                        }

                        public void onSuccess(String str) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                String optString = jSONObject.optString(TDH5LivenessActivity.i1i1iI1I11iI("AA42FQ=="));
                                String optString2 = jSONObject.optString(TDH5LivenessActivity.linkxxxxx("0d017b0169076b", 96));
                                String optString3 = jSONObject.optString(TDH5LivenessActivity.linkxxxxx("13706774777f7a79404f4d", 15));
                                if (TDH5LivenessActivity.linkxxxxx("5132313236", 88).equals(optString)) {
                                    String access$000 = TDH5LivenessActivity.linkxxxxx("5211351636", 122);
                                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(access$000, optString2, optString3);
                                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(access$000, optString2);
                                } else if (TDH5LivenessActivity.linkxxxxx("5115311535", 127).equals(optString)) {
                                    String access$300 = TDH5LivenessActivity.i1i1iI1I11iI("UVFlQEI=");
                                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(access$300, optString2, optString3);
                                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(access$300, optString2);
                                } else {
                                    if (!TDH5LivenessActivity.i1i1iI1I11iI("UVFi").equals(optString)) {
                                        com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(optString, optString2);
                                    }
                                    com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str);
                                }
                            } catch (Throwable unused) {
                                String str2 = illill1ll1.ii1lilli;
                                com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str2, TDH5LivenessActivity.i1i1iI1I11iI("KTIdPlA5AhMhGR4uQwczGRwsBw=="), "");
                                com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str2, TDH5LivenessActivity.linkxxxxx("2a1d561c384c295f28452f4c680a6f026a0b6b", 109));
                            }
                            com.trustdecision.liveness.cw.api.i11iliil1li1.il111liilil.illill1ll1((Runnable) new gd(TDH5LivenessActivity.this, 7));
                        }
                    });
                    return;
                }
                if (TDH5LivenessActivity.i1i1iI1I11iI("Vw==").equals(str2)) {
                    str4 = illill1ll1.li1li1ii1ii11ii;
                    str3 = TDH5LivenessActivity.linkxxxxx("2e550116031a0b0d184c48595f465b5c5b465d47", 29);
                } else if (TDH5LivenessActivity.i1i1iI1I11iI("Vg==").equals(str2) || TDH5LivenessActivity.i1i1iI1I11iI("VQ==").equals(str2)) {
                    str4 = illill1ll1.lilli1ii1i;
                    StringBuilder sb = new StringBuilder();
                    sb.append(TDH5LivenessActivity.i1i1iI1I11iI("LQQmBx87CEE7AwM8Bk1yFhEgDwQ2UAQmQwIzHBxpAg8mGV0hAgI5Xg=="));
                    if (TDH5LivenessActivity.i1i1iI1I11iI("VQ==").equals(str2)) {
                        str5 = TDH5LivenessActivity.i1i1iI1I11iI("TQ==");
                    } else {
                        str5 = "";
                    }
                    sb.append(str5);
                    str3 = sb.toString();
                } else {
                    str4 = illill1ll1.ii1lilli;
                    str3 = TDH5LivenessActivity.i1i1iI1I11iI("Kg8mFQInAg1yFQI7DBM=");
                }
                com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str4, str3, "");
                com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str4, str3);
                com.trustdecision.liveness.cw.api.i11iliil1li1.il111liilil.illill1ll1((Runnable) new gd(TDH5LivenessActivity.this, 7));
            }

            public void jsLog(String str) {
            }
        });
        String stringExtra = getIntent().getStringExtra(i1i1iI1I11iI("FAQwJhksFDQgHA=="));
        TDWebView tDWebView = this.mWebView;
        if (stringExtra == null) {
            stringExtra = illill1ll1.iill11lliiil1l1i11l11;
        }
        tDWebView.loadUrl(stringExtra);
        this.mWebView.addJavascriptInterface(this.jsBridge, i1i1iI1I11iI("NyUQAhktBAQ="));
        if (this.mWebView.isAttachedToWindow()) {
            this.mWebView.buildLayer();
        }
    }

    private void updateSystemUiVisibility() {
        getWindow().getDecorView().setSystemUiVisibility(5380);
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
            String str = illill1ll1.ll11li11l11il1lillll;
            com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str, i1i1iI1I11iI("NhI3AlAoABU7BhUlGkExER4qBg0hUBQsFwQxBBkmDUE9HlA9CwRyFBU9BgImGR8nQxEzFxU="), "");
            com.trustdecision.liveness.cw.api.illill1ll1.illill1ll1(str, i1i1iI1I11iI("NhI3AlAoABU7BhUlGkExER4qBg0hUBQsFwQxBBkmDUE9HlA9CwRyFBU9BgImGR8nQxEzFxU="));
            finish();
        } catch (Throwable unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        }
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.td_activitiy_h5_liveness);
        initRBBtn();
        loadWebView();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.jsBridge != null) {
            this.jsBridge = null;
        }
        TDWebView tDWebView = this.mWebView;
        if (tDWebView != null) {
            tDWebView.destroy();
            this.mWebView.clearAnimation();
            this.mWebView = null;
        }
        this.mRequest = null;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != this.CAMERA_PERMISSION_REQUEST_CODE) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            PermissionRequest permissionRequest = this.mRequest;
            if (permissionRequest != null) {
                permissionRequest.deny();
                this.mRequest = null;
                return;
            }
            return;
        }
        PermissionRequest permissionRequest2 = this.mRequest;
        if (permissionRequest2 != null) {
            permissionRequest2.grant(permissionRequest2.getResources());
            this.mRequest = null;
            return;
        }
        loadWebView();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            updateSystemUiVisibility();
        }
    }
}
