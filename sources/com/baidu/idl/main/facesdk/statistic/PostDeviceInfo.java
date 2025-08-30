package com.baidu.idl.main.facesdk.statistic;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.idl.main.facesdk.callback.Callback;
import com.baidu.vis.unified.license.AndroidLicenser;
import com.baidu.vis.unified.license.HttpStatus;
import com.baidu.vis.unified.license.HttpUtils;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class PostDeviceInfo {
    public static void uploadDeviceInfo(final Context context, final Callback callback) {
        new Thread(new Runnable() {
            public void run() {
                String str;
                String str2;
                String deviceId = AndroidLicenser.getDeviceId(context.getApplicationContext());
                String systemVersion = DeviceInfoUtil.getSystemVersion();
                float ramInfo = (float) ((DeviceInfoUtil.getRamInfo(context) / 1024) / 1024);
                float deviceBasicFrequency = (float) (DeviceInfoUtil.getDeviceBasicFrequency() / 1000);
                int numberOfCPUCores = DeviceInfoUtil.getNumberOfCPUCores();
                int intValue = DeviceInfoUtil.getCPUBit().intValue();
                Integer networkState = NetWorkUtil.getNetworkState(context);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("analysisType", "offline_Sdk");
                    jSONObject.put("deviceId", deviceId);
                    jSONObject.put("cpuCore", numberOfCPUCores);
                    jSONObject.put("cpuBit", intValue);
                    jSONObject.put("ghz", Math.round(deviceBasicFrequency));
                    jSONObject.put("ram", Math.round(ramInfo));
                    jSONObject.put("networkType", networkState);
                    if (networkState.intValue() == 1) {
                        str2 = "WIFI网络";
                    } else if (networkState.intValue() == 2) {
                        str2 = "2G网络";
                    } else if (networkState.intValue() == 3) {
                        str2 = "3G网络";
                    } else if (networkState.intValue() == 4) {
                        str2 = "4G网络";
                    } else if (networkState.intValue() == 5) {
                        str2 = "有线网卡";
                    } else {
                        str2 = "其他网络模块";
                    }
                    jSONObject.put("networkDesc", str2);
                    jSONObject.put("os", 1);
                    jSONObject.put("osVersion", systemVersion);
                    jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, 1);
                    jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "4.1");
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("mh", "offlineSdkStatistic");
                    jSONObject2.put("dt", jSONObject);
                    str = jSONObject2.toString();
                } catch (JSONException e) {
                    e.getStackTrace();
                    str = null;
                }
                HttpStatus requestPost = HttpUtils.requestPost("http://brain.baidu.com/record/api", str, "application/json", "zxq");
                if (requestPost == null) {
                    callback.onResponse(-1, "请求失败");
                    return;
                }
                String str3 = requestPost.responseStr;
                try {
                    if (TextUtils.isEmpty(str3)) {
                        callback.onResponse(-1, "request error");
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject(str3);
                    callback.onResponse(jSONObject3.optInt("code"), jSONObject3.optString("msg"));
                } catch (JSONException e2) {
                    e2.getStackTrace();
                    Callback callback = callback;
                    callback.onResponse(-1, "request error = " + e2.getMessage());
                } catch (Exception e3) {
                    e3.getStackTrace();
                    Callback callback2 = callback;
                    callback2.onResponse(-1, "request error = " + e3.getMessage());
                }
            }
        }).start();
    }
}
