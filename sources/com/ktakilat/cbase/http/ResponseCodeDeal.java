package com.ktakilat.cbase.http;

import android.widget.Toast;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.ToastUtil;

public class ResponseCodeDeal {

    /* renamed from: a  reason: collision with root package name */
    public static lb f473a;
    public static BaseApplication b;

    public interface ResponseCodeCall {
    }

    public static void a(BaseResponse baseResponse) {
        boolean z;
        BaseApplication baseApplication;
        lb lbVar;
        if (baseResponse.isSuc() || (lbVar = f473a) == null) {
            z = true;
        } else {
            z = lbVar.e(baseResponse.getCode());
        }
        if (z && !baseResponse.isSuc() && (baseApplication = b) != null) {
            ToastUtil.d(baseApplication, baseResponse.getMsg());
        }
    }

    public static void b(BaseResponse baseResponse) {
        boolean z;
        BaseApplication baseApplication;
        lb lbVar;
        if (baseResponse.isSuc() || (lbVar = f473a) == null) {
            z = true;
        } else {
            z = lbVar.e(baseResponse.getCode());
        }
        if (z && !baseResponse.isSuc() && (baseApplication = b) != null) {
            Toast.makeText(baseApplication, baseResponse.getMsg(), 0).show();
        }
    }
}
