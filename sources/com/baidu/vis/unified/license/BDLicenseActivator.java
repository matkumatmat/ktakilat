package com.baidu.vis.unified.license;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.facebook.internal.NativeProtocol;
import org.json.JSONException;
import org.json.JSONObject;

public class BDLicenseActivator {
    public static final String TAG = "BDLicenseActivator";

    public static int initLicenseOnLine(Context context, String str, String str2, int i) {
        String str3;
        if (context == null) {
            Log.e(TAG, "initLicenseOnLine parameter error context == null");
            return -1;
        } else if (TextUtils.isEmpty(str)) {
            Log.e(TAG, "initLicenseOnLine parameter error licenseID is empty");
            return -1;
        } else {
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            AndroidLicenser instance = AndroidLicenser.getInstance();
            if (instance.authFromFile(context, str, str2, true, i) == AndroidLicenser.ErrorCode.SUCCESS) {
                return 0;
            }
            String deviceId = AndroidLicenser.getDeviceId(context.getApplicationContext());
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("deviceId", deviceId);
                jSONObject.put("key", str);
                jSONObject.put("platformType", 2);
                jSONObject.put("version", 1);
                str3 = jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                str3 = null;
            }
            HttpStatus requestPost = HttpUtils.requestPost("https://ai.baidu.com/activation/key/activate", str3, "application/json", TAG);
            if (requestPost == null) {
                Log.e(TAG, "initLicenseOnLine.HttpUtils.requestPost error httpStatus == null ");
                return -2;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(requestPost.responseStr);
                if (jSONObject2.optInt(NativeProtocol.BRIDGE_ARG_ERROR_CODE) != 0) {
                    String optString = jSONObject2.optString("error_msg");
                    Log.e(TAG, "initLicenseOnLine.requestPost.response.error_code -> " + optString);
                    return -3;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                if (optJSONObject == null) {
                    Log.e(TAG, "initLicenseOnLine.requestPost.response error result == null");
                    return -3;
                }
                String optString2 = optJSONObject.optString("license");
                if (TextUtils.isEmpty(optString2)) {
                    Log.e(TAG, "initLicenseOnLine.requestPost.response error license is empty");
                    return -3;
                }
                String[] split = optString2.split(",");
                if (split != null) {
                    if (split.length == 2) {
                        if (instance.authFromMemory(context, str, split, str2, i) == AndroidLicenser.ErrorCode.SUCCESS) {
                            return 0;
                        }
                        BDLicenseLocalInfo authGetLocalInfo = instance.authGetLocalInfo(context, i);
                        Log.e(TAG, "BDLicenseLocalInfo -> " + authGetLocalInfo.toString());
                        String errorMsg = instance.getErrorMsg(i);
                        Log.e(TAG, "errMsg ->" + errorMsg);
                        return -4;
                    }
                }
                Log.e(TAG, "initLicenseOnLine.requestPost.response error licenses == null || licenses.length != 2");
                return -3;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return -5;
            }
        }
    }
}
