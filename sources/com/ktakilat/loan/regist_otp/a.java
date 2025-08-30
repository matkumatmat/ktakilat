package com.ktakilat.loan.regist_otp;

import android.text.TextUtils;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiInfoUtil;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.user.AcountVerifyResp;
import com.ktakilat.loan.weiget.GpsUtil;
import com.ktakilat.loan.weiget.PhoneCodeUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;

public final /* synthetic */ class a implements GpsUtil.GpsIgnoreCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RegistOtpActivity f539a;

    public /* synthetic */ a(RegistOtpActivity registOtpActivity) {
        this.f539a = registOtpActivity;
    }

    public final void a(double d, double d2) {
        RegistOtpActivity registOtpActivity = this.f539a;
        registOtpActivity.o = d;
        registOtpActivity.p = d2;
        RegistOtpPresenter registOtpPresenter = registOtpActivity.i;
        String obj = registOtpActivity.r.codeEdit.getText().toString();
        registOtpPresenter.getClass();
        boolean isEmpty = TextUtils.isEmpty(obj);
        RegistOtpActivity registOtpActivity2 = registOtpPresenter.b;
        if (isEmpty) {
            registOtpActivity2.getClass();
            ToastUtil.c(registOtpActivity2, R.string.no_verify_code);
            return;
        }
        PhoneCodeUtil phoneCodeUtil = registOtpPresenter.f537a;
        if (TextUtils.isEmpty(phoneCodeUtil.f)) {
            registOtpActivity2.getClass();
            ToastUtil.c(registOtpActivity2, R.string.need_send_code);
            return;
        }
        registOtpActivity2.n();
        new AcountVerifyResp();
        AppHttp.userRegist(registOtpActivity2.z(), "Indonesia", obj, phoneCodeUtil.f, d, d2, ApiInfoUtil.b().f470a.uuid, AppKv.b(), ApiInfoUtil.b().f470a.appName).subscribe(new ApiObserver<BaseResponse<AcountVerifyResp>>() {
            public final void a(BaseResponse baseResponse) {
                KtaCollect.n_register_verify_failed();
                RegistOtpPresenter registOtpPresenter = RegistOtpPresenter.this;
                registOtpPresenter.b.u();
                if ("A000007".equals(baseResponse.getCode())) {
                    RegistOtpActivity registOtpActivity = registOtpPresenter.b;
                    registOtpActivity.getClass();
                    KtaCollect.n_data_transfer_pop_exposure();
                    registOtpActivity.n = DialogUtils.i(registOtpActivity, registOtpActivity.getResources().getString(R.string.attention), baseResponse.getMsg(), new c(registOtpActivity, 2));
                    return;
                }
                ResponseCodeDeal.b(baseResponse);
                registOtpPresenter.b.r.codeEdit.setText("");
            }

            public final void b(BaseResponse baseResponse) {
                KtaCollect.n_register_verify_success();
                RegistOtpPresenter registOtpPresenter = RegistOtpPresenter.this;
                registOtpPresenter.b.u();
                registOtpPresenter.b.C((AcountVerifyResp) baseResponse.getData());
            }
        });
    }
}
