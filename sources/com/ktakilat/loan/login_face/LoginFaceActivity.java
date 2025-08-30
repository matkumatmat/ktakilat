package com.ktakilat.loan.login_face;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.cbase.utils.PhoneValidator;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.login_face.LoginFaceContact;
import com.ktakilat.loan.weiget.CommonPopUtil;
import com.ktakilat.loan.weiget.LoginUtil;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.ktakilat.loan.weiget.TongDunEnum;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.pendanaan.kta.databinding.CActivityLoginFaceBinding;
import com.pendanaan.kta.databinding.DialogFaceLoginLimitBinding;

@SuppressLint({"NonConstantResourceId"})
public class LoginFaceActivity extends BaseLoginActivity implements LoginFaceContact.View {
    public static final /* synthetic */ int r = 0;
    public LoginFacePresenter n;
    public boolean o;
    public String p;
    public CActivityLoginFaceBinding q;

    public static void E(Context context, String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, LoginFaceActivity.class);
            intent.putExtra("mobile", str);
            intent.putExtra("initSend", z);
            context.startActivity(intent);
        }
    }

    public final void C(Intent intent) {
        this.p = intent.getStringExtra("mobile");
        this.o = intent.getBooleanExtra("initSend", false);
        this.q.mobileTv.setText(PhoneValidator.a(this.p));
        KtaCollect.n_login_page_exposure((String) null, "4");
        new CommonPopUtil(this).b(CommonPopUtil.PageType.LoginFace, (CommonPopUtil.CheckCallback) null);
    }

    public final void D(UserLoginResp userLoginResp) {
        KtaCollect.n_face_login_suc();
        KtaCollect.n_login_page_result("4", AppEventsConstants.EVENT_PARAM_VALUE_YES, "");
        KtakilatApplication ktakilatApplication = KtakilatApplication.m;
        String token = userLoginResp.getToken();
        String userId = userLoginResp.getUserId();
        String mobileNo = userLoginResp.getMobileNo();
        bc bcVar = new bc(this, 1);
        ktakilatApplication.getClass();
        KtakilatApplication.k(token, userId, mobileNo, bcVar);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 10000 && i2 == -1 && intent != null) {
            BaseResponse baseResponse = (BaseResponse) JsonUtil.c(intent.getStringExtra("response"), BaseResponse.class);
            UserLoginResp userLoginResp = (UserLoginResp) JsonUtil.c(intent.getStringExtra("userLoginResp"), UserLoginResp.class);
            if (baseResponse != null && baseResponse.isSuc() && userLoginResp != null) {
                KtaCollect.n_login_page_result("4", AppEventsConstants.EVENT_PARAM_VALUE_YES, "");
                KtakilatApplication ktakilatApplication = KtakilatApplication.m;
                String token = userLoginResp.getToken();
                String userId = userLoginResp.getUserId();
                String mobileNo = userLoginResp.getMobileNo();
                bc bcVar = new bc(this, 0);
                ktakilatApplication.getClass();
                KtakilatApplication.k(token, userId, mobileNo, bcVar);
            } else if (baseResponse == null || !baseResponse.getCode().equals("A000306")) {
                KtaCollect.n_login_page_result("4", AppEventsConstants.EVENT_PARAM_VALUE_NO, "");
            } else {
                KtaCollect.n_login_page_result("4", AppEventsConstants.EVENT_PARAM_VALUE_NO, "");
                DialogFaceLoginLimitBinding inflate = DialogFaceLoginLimitBinding.inflate(LayoutInflater.from(this));
                DialogUtils.b(this, inflate.getRoot(), inflate.nextTv, new bc(this, 2), (u9) null).show();
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [com.ktakilat.loan.login_face.LoginFacePresenter, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CActivityLoginFaceBinding inflate = CActivityLoginFaceBinding.inflate(getLayoutInflater());
        this.q = inflate;
        setContentView((View) inflate.getRoot());
        C(getIntent());
        ? obj = new Object();
        obj.f513a = this;
        obj.b = new LoginUtil(this);
        this.n = obj;
        this.q.pageTitle.title.setText(R.string.application_name);
        this.q.pageTitle.backward.setOnClickListener(new yb(this, 0));
        this.q.loginTv.setOnClickListener(new yb(this, 1));
        this.q.moreTv.setOnClickListener(new b(this));
    }

    public final void onDestroy() {
        LoginFacePresenter loginFacePresenter = this.n;
        if (loginFacePresenter != null) {
            loginFacePresenter.getClass();
        }
        super.onDestroy();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C(intent);
    }

    public final void onResume() {
        super.onResume();
        PhoneUploadUtil.a(TongDunEnum.USER_LOGIN_SUC);
    }
}
