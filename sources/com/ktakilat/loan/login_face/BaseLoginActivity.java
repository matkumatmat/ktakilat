package com.ktakilat.loan.login_face;

import android.content.Intent;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.main.EventHomeAct;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.reset_pwd.ResetPwdActivity;
import com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public abstract class BaseLoginActivity extends BaseActivity {
    public static final /* synthetic */ int m = 0;
    public final FaceLoginOnOffUtil i = new FaceLoginOnOffUtil(this);
    public final GestureUtil j = new GestureUtil((BaseActivity) this);
    public boolean k = false;
    public FaceLoginOnOffUtil.ScenceEnum l;

    public final void A(GestureUtil.GestureSetEnum gestureSetEnum) {
        this.j.f(gestureSetEnum, new GestureUtil.CheckCallback() {
            public final void a(boolean z) {
                if (!z) {
                    BaseLoginActivity.this.B();
                }
            }
        });
    }

    public void B() {
        this.l = null;
        this.k = false;
        HomeActivity.C(this, (String) null, false);
        EventBus.b().e(new EventHomeAct());
        finish();
        KtakilatApplication.m.getClass();
        KtakilatApplication.d();
    }

    public void onActivityResult(int i2, int i3, final Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 800) {
            if (i3 == -1 && intent != null) {
                int intExtra = intent.getIntExtra("processType", -1);
                if (intExtra == 101 || intExtra == 102) {
                    startActivity(new Intent(this, ResetPwdActivity.class));
                } else if (intExtra == 103 || intExtra == 104) {
                    new GestureUtil((BaseActivity) this).f(GestureUtil.GestureSetEnum.SETTING, (GestureUtil.CheckCallback) null);
                } else if (intExtra == 106) {
                    ChangeMobileAndForgotPwdTmpLoginUtil.b(new WebCookieManager.CookieCallback() {
                        public final void d() {
                            boolean booleanExtra = intent.getBooleanExtra("safe_device", true);
                            BaseLoginActivity baseLoginActivity = BaseLoginActivity.this;
                            if (booleanExtra) {
                                int i = BaseLoginActivity.m;
                                baseLoginActivity.getClass();
                                List j = AppKv.j();
                                if (!j.contains("4")) {
                                    baseLoginActivity.z(FaceLoginOnOffUtil.ScenceEnum.VERIFY_BY_DEVICE_SUC);
                                } else if (!j.contains("5")) {
                                    baseLoginActivity.A(GestureUtil.GestureSetEnum.DEVICE_VERIFY);
                                } else {
                                    baseLoginActivity.B();
                                }
                            } else {
                                int i2 = BaseLoginActivity.m;
                                baseLoginActivity.getClass();
                                List j2 = AppKv.j();
                                if (!j2.contains("4")) {
                                    baseLoginActivity.z(FaceLoginOnOffUtil.ScenceEnum.VERIFY_BY_OUTTIME_SUC);
                                } else if (!j2.contains("5")) {
                                    baseLoginActivity.A(GestureUtil.GestureSetEnum.OVERDUE_VERIFY);
                                } else {
                                    baseLoginActivity.B();
                                }
                            }
                        }
                    });
                }
            }
        } else if (i2 == 20000) {
            if (this.k) {
                this.i.l(this.l, new k0(this, 3));
            }
        } else if (i2 == 500) {
            B();
        } else if (i2 == 10001) {
            B();
        }
    }

    public final void z(final FaceLoginOnOffUtil.ScenceEnum scenceEnum) {
        if (scenceEnum == null) {
            B();
            return;
        }
        this.i.f(scenceEnum, new FaceLoginOnOffUtil.ScenceEnableCall() {
            public final void a(FaceEnableResp faceEnableResp, boolean z, boolean z2, boolean z3) {
                BaseLoginActivity baseLoginActivity = BaseLoginActivity.this;
                if (faceEnableResp == null || !z || z2) {
                    baseLoginActivity.B();
                } else if (z3) {
                } else {
                    if (baseLoginActivity.k) {
                        baseLoginActivity.B();
                        return;
                    }
                    baseLoginActivity.l = scenceEnum;
                    DialogUtils.h(baseLoginActivity, baseLoginActivity.getText(R.string.camera).toString(), new DialogUtils.SettingStatusCall() {
                        public final void a() {
                            BaseLoginActivity.this.k = true;
                        }

                        public final void cancel() {
                            BaseLoginActivity.this.B();
                        }
                    });
                }
            }
        });
    }
}
