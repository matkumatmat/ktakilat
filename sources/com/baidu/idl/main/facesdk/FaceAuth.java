package com.baidu.idl.main.facesdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseAuthInfo;
import com.baidu.idl.main.facesdk.license.BDFaceLicenseLocalInfo;
import com.baidu.idl.main.facesdk.model.BDFaceSDKCommon;
import com.baidu.idl.main.facesdk.statistic.PostDeviceInfo;
import com.baidu.idl.main.facesdk.utils.PreferencesUtil;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.BDLicenseAuthInfo;
import com.baidu.vis.unified.license.BDLicenseLocalInfo;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.facebook.internal.NativeProtocol;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceAuth {
    /* access modifiers changed from: private */
    public static int ALGORITHM_ID = 3;
    private static final String LICENSE_FILE_NAME = "idl-license.face-android";
    private static final String TAG = "FaceSDK";

    static {
        try {
            System.loadLibrary("bdface_sdk");
            System.loadLibrary("bd_unifylicense");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public native int nativeCreatInstance();

    private native void nativeSetActiveLog(int i, int i2);

    private native void nativeSetCoreConfigure(int i, int i2);

    public BDFaceLicenseAuthInfo getAuthInfo(Context context) {
        BDLicenseAuthInfo authGetAuthInfo = AndroidLicenser.getInstance().authGetAuthInfo(context, ALGORITHM_ID);
        BDFaceLicenseAuthInfo bDFaceLicenseAuthInfo = new BDFaceLicenseAuthInfo();
        bDFaceLicenseAuthInfo.algorithmId = authGetAuthInfo.algorithmId;
        bDFaceLicenseAuthInfo.deviceId = authGetAuthInfo.deviceId;
        bDFaceLicenseAuthInfo.expireTime = authGetAuthInfo.expireTime;
        bDFaceLicenseAuthInfo.functionList = authGetAuthInfo.functionList;
        bDFaceLicenseAuthInfo.licenseKey = authGetAuthInfo.licenseKey;
        bDFaceLicenseAuthInfo.md5 = authGetAuthInfo.md5;
        bDFaceLicenseAuthInfo.packageName = authGetAuthInfo.packageName;
        return bDFaceLicenseAuthInfo;
    }

    public String getDeviceId(Context context) {
        return AndroidLicenser.getDeviceId(context.getApplicationContext());
    }

    public BDFaceLicenseLocalInfo getLocalInfo(Context context) {
        BDLicenseLocalInfo authGetLocalInfo = AndroidLicenser.getInstance().authGetLocalInfo(context, ALGORITHM_ID);
        BDFaceLicenseLocalInfo bDFaceLicenseLocalInfo = new BDFaceLicenseLocalInfo();
        bDFaceLicenseLocalInfo.algorithmId = authGetLocalInfo.algorithmId;
        bDFaceLicenseLocalInfo.deviceId = authGetLocalInfo.deviceId;
        bDFaceLicenseLocalInfo.fingerVersion = authGetLocalInfo.fingerVersion;
        bDFaceLicenseLocalInfo.licenseSdkVersion = authGetLocalInfo.licenseSdkVersion;
        bDFaceLicenseLocalInfo.licenseKey = authGetLocalInfo.licenseKey;
        bDFaceLicenseLocalInfo.md5 = authGetLocalInfo.md5;
        bDFaceLicenseLocalInfo.packageName = authGetLocalInfo.packageName;
        return bDFaceLicenseLocalInfo;
    }

    public void initLicense(Context context, String str, String str2, boolean z, Callback callback) {
        final Context context2 = context;
        final Callback callback2 = callback;
        final String str3 = str;
        final String str4 = str2;
        final boolean z2 = z;
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                if (context2 == null) {
                    callback2.onResponse(1, "没有初始化上下文");
                } else if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                    callback2.onResponse(2, "license 关键字为空");
                } else {
                    AndroidLicenser instance = AndroidLicenser.getInstance();
                    AndroidLicenser.ErrorCode authFromFile = instance.authFromFile(context2, str3, str4, z2, FaceAuth.ALGORITHM_ID);
                    if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                        BDLicenseLocalInfo authGetLocalInfo = instance.authGetLocalInfo(context2, FaceAuth.ALGORITHM_ID);
                        if (authGetLocalInfo != null) {
                            authGetLocalInfo.toString();
                        }
                    } else {
                        int unused = FaceAuth.this.nativeCreatInstance();
                    }
                    callback2.onResponse(authFromFile.ordinal(), instance.getErrorMsg(FaceAuth.ALGORITHM_ID));
                }
            }
        });
    }

    public void initLicenseBatchLine(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                Context context = context;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                PreferencesUtil.initPrefs(context);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() {
                        public void onResponse(int i, String str) {
                            if (i == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(FaceAuth.LICENSE_FILE_NAME)) {
                    callback.onResponse(2, "license 关键字为空");
                    return;
                }
                AndroidLicenser instance = AndroidLicenser.getInstance();
                AndroidLicenser.ErrorCode authFromFile = instance.authFromFile(context, str, FaceAuth.LICENSE_FILE_NAME, true, FaceAuth.ALGORITHM_ID);
                if (authFromFile != AndroidLicenser.ErrorCode.SUCCESS) {
                    BDLicenseLocalInfo authGetLocalInfo = instance.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                    if (authGetLocalInfo != null) {
                        authGetLocalInfo.toString();
                    }
                } else {
                    int unused = FaceAuth.this.nativeCreatInstance();
                }
                callback.onResponse(authFromFile.ordinal(), instance.getErrorMsg(FaceAuth.ALGORITHM_ID));
            }
        });
    }

    public void initLicenseOnLine(final Context context, final String str, final Callback callback) {
        FaceQueue.getInstance().execute(new Runnable() {
            public void run() {
                String str;
                String[] split;
                Context context = context;
                if (context == null) {
                    callback.onResponse(1, "没有初始化上下文");
                    return;
                }
                PreferencesUtil.initPrefs(context);
                if (TextUtils.isEmpty(PreferencesUtil.getString("statics", ""))) {
                    PostDeviceInfo.uploadDeviceInfo(context, new Callback() {
                        public void onResponse(int i, String str) {
                            if (i == 0) {
                                PreferencesUtil.putString("statics", "ok");
                            }
                        }
                    });
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(FaceAuth.LICENSE_FILE_NAME)) {
                    callback.onResponse(2, "license 关键字为空");
                    return;
                }
                AndroidLicenser instance = AndroidLicenser.getInstance();
                AndroidLicenser.ErrorCode authFromFile = instance.authFromFile(context, str, FaceAuth.LICENSE_FILE_NAME, false, FaceAuth.ALGORITHM_ID);
                Log.e(FaceAuth.TAG, "errCode = " + authFromFile);
                if (authFromFile == AndroidLicenser.ErrorCode.SUCCESS) {
                    int unused = FaceAuth.this.nativeCreatInstance();
                    callback.onResponse(authFromFile.ordinal(), instance.getErrorMsg(FaceAuth.ALGORITHM_ID));
                    return;
                }
                String deviceId = AndroidLicenser.getDeviceId(context.getApplicationContext());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", deviceId);
                    jSONObject.put("key", str);
                    jSONObject.put("platformType", 2);
                    jSONObject.put("version", 5);
                    str = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = null;
                }
                HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str, "application/json", FaceAuth.TAG);
                if (requestPost == null) {
                    callback.onResponse(-1, "在线激活失败");
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(requestPost.responseStr);
                    if (jSONObject2.optInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != 0) {
                        callback.onResponse(-1, jSONObject2.optString("error_msg"));
                        return;
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("license");
                        if (!TextUtils.isEmpty(optString) && (split = optString.split(",")) != null && split.length == 2) {
                            PreferencesUtil.putString("activate_online_key", str);
                            AndroidLicenser.ErrorCode authFromMemory = instance.authFromMemory(context, str, split, FaceAuth.LICENSE_FILE_NAME, FaceAuth.ALGORITHM_ID);
                            if (authFromMemory != AndroidLicenser.ErrorCode.SUCCESS) {
                                BDLicenseLocalInfo authGetLocalInfo = instance.authGetLocalInfo(context, FaceAuth.ALGORITHM_ID);
                                if (authGetLocalInfo != null) {
                                    authGetLocalInfo.toString();
                                }
                            } else {
                                int unused2 = FaceAuth.this.nativeCreatInstance();
                            }
                            callback.onResponse(authFromMemory.ordinal(), instance.getErrorMsg(FaceAuth.ALGORITHM_ID));
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public void setActiveLog(BDFaceSDKCommon.BDFaceLogInfo bDFaceLogInfo, int i) {
        nativeSetActiveLog(bDFaceLogInfo.ordinal(), i);
    }

    public void setCoreConfigure(BDFaceSDKCommon.BDFaceCoreRunMode bDFaceCoreRunMode, int i) {
        nativeSetCoreConfigure(bDFaceCoreRunMode.ordinal(), i);
    }
}
