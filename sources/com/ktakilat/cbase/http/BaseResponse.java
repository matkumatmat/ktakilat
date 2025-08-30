package com.ktakilat.cbase.http;

import com.ktakilat.cbase.R;
import com.ktakilat.cbase.http.ApiInfoUtil;
import com.ktakilat.cbase.ui.BaseApplication;

public class BaseResponse<T> {
    private String code = "000000";
    private T data;
    private String msg;
    private boolean success = false;

    public static <T> BaseResponse<T> createNetError() {
        BaseApplication baseApplication;
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setCode("1000000");
        baseResponse.setSuccess(false);
        if (ApiInfoUtil.b() != null) {
            ApiInfoUtil.DeviceInfoCall deviceInfoCall = ApiInfoUtil.b().c;
            BaseApplication baseApplication2 = null;
            if (deviceInfoCall == null) {
                baseApplication = null;
            } else {
                baseApplication = deviceInfoCall.getContext();
            }
            if (baseApplication != null) {
                ApiInfoUtil.DeviceInfoCall deviceInfoCall2 = ApiInfoUtil.b().c;
                if (deviceInfoCall2 != null) {
                    baseApplication2 = deviceInfoCall2.getContext();
                }
                baseResponse.setMsg(baseApplication2.getString(R.string.http_error));
                return baseResponse;
            }
        }
        baseResponse.setMsg("Jaringan tidak normal, harap periksa jaringan");
        return baseResponse;
    }

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuc() {
        return isSuccess();
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
