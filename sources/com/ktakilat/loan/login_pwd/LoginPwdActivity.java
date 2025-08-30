package com.ktakilat.loan.login_pwd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.cbase.utils.PhoneValidator;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.op_horse.OpHorseRaceType;
import com.ktakilat.loan.login_face.BaseLoginActivity;
import com.ktakilat.loan.login_pwd.LoginPwdContact;
import com.ktakilat.loan.mobile_check.HorseUtil;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.verify_face.VerifyScence;
import com.ktakilat.loan.weiget.CommonPopUtil;
import com.ktakilat.loan.weiget.LoginUtil;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.ktakilat.loan.weiget.PwdHideShowUtil;
import com.ktakilat.loan.weiget.TongDunEnum;
import com.pendanaan.kta.databinding.CActivityLoginPwdBinding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;

public class LoginPwdActivity extends BaseLoginActivity implements LoginPwdContact.View {
    public static final /* synthetic */ int r = 0;
    public LoginPwdPresenter n;
    public boolean o;
    public String p;
    public CActivityLoginPwdBinding q;

    public static void F(Context context, String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, LoginPwdActivity.class);
            intent.putExtra("mobile", str);
            intent.putExtra("initSend", z);
            context.startActivity(intent);
        }
    }

    public final LifecycleTransformer C() {
        return RxLifecycle.a(this.c, ActivityEvent.DESTROY);
    }

    public final void D(Intent intent) {
        String str;
        this.p = intent.getStringExtra("mobile");
        int i = 0;
        this.o = intent.getBooleanExtra("initSend", false);
        TextView textView = this.q.tip2Tv;
        if (AppKv.f()) {
            i = 8;
        }
        textView.setVisibility(i);
        if (this.q.tip2Tv.getVisibility() == 0) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        KtaCollect.n_login_password_exposure(str);
        this.q.mobileTv.setText(PhoneValidator.a(this.p));
        CActivityLoginPwdBinding cActivityLoginPwdBinding = this.q;
        PwdHideShowUtil.a(cActivityLoginPwdBinding.pwdEt, cActivityLoginPwdBinding.pwdIv, R.drawable.icon_pass_gone_gray, R.drawable.icon_pass_visible_gray);
        KeybordUtils.c(this.q.pwdEt);
        new CommonPopUtil(this).b(CommonPopUtil.PageType.LoginPwd, (CommonPopUtil.CheckCallback) null);
    }

    public final void E(String str, boolean z) {
        VerifyScence verifyScence;
        if (z) {
            verifyScence = VerifyScence.SAFE_DEVICE;
        } else {
            verifyScence = VerifyScence.SAFE_PHONE;
        }
        VerifyMgr.j(this, str, verifyScence);
    }

    public final void onBackPressed() {
        KtaCollect.n_login_password_clc_back();
        super.onBackPressed();
    }

    /* JADX WARNING: type inference failed for: r3v21, types: [java.lang.Object, com.ktakilat.loan.login_pwd.LoginPwdPresenter] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CActivityLoginPwdBinding inflate = CActivityLoginPwdBinding.inflate(getLayoutInflater());
        this.q = inflate;
        setContentView((View) inflate.getRoot());
        this.q.pageTitle.title.setText(R.string.application_name);
        this.q.pwdEt.setOnFocusChangeListener(new w9(4));
        this.q.pageTitle.backward.setOnClickListener(new dc(this, 0));
        this.q.loginTv.setOnClickListener(new dc(this, 1));
        this.q.moreTv.setOnClickListener(new a(this));
        this.q.pwdEt.setOnClickListener(new y9(5));
        this.q.pwdEt.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int length = charSequence.length();
                LoginPwdActivity loginPwdActivity = LoginPwdActivity.this;
                if (length <= 0) {
                    loginPwdActivity.q.loginTv.setEnabled(false);
                } else {
                    loginPwdActivity.q.loginTv.setEnabled(true);
                }
            }
        });
        D(getIntent());
        ? obj = new Object();
        obj.f523a = this;
        obj.b = new LoginUtil(this);
        this.n = obj;
        HorseUtil.b(this, OpHorseRaceType.PJP, this.q.hourseTv);
    }

    public final void onDestroy() {
        LoginPwdPresenter loginPwdPresenter = this.n;
        if (loginPwdPresenter != null) {
            loginPwdPresenter.getClass();
        }
        super.onDestroy();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        D(intent);
    }

    public final void onResume() {
        super.onResume();
        PhoneUploadUtil.a(TongDunEnum.USER_LOGIN_SUC);
    }

    public final int r() {
        return WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars();
    }
}
