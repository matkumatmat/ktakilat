package com.ktakilat.loan.webtool;

import android.content.Intent;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.cbase.utils.LogUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.main.EventHomeAct;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.setting_change.SettingChangeActivity;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.verify_face.VerifyScence;
import com.ktakilat.loan.web.CommonWebActivity;
import com.ktakilat.loan.web.CommonWebFragment;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.LoginRegistUtil;
import com.ktakilat.loan.weiget.ShareUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import org.greenrobot.eventbus.EventBus;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        VerifyScence verifyScence;
        BaseActivity baseActivity;
        Object obj = this.d;
        switch (this.c) {
            case 0:
                ((CommonWebViewSetting.JsCallAndroidInterface) obj).getClass();
                return;
            case 1:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface.getClass();
                KtakilatApplication.m.getClass();
                if (KtakilatApplication.h()) {
                    KtakilatApplication.m.getClass();
                    InputPwdActivity.B(jsCallAndroidInterface.b, KtakilatApplication.f().getMobileNo(), 3);
                    return;
                }
                return;
            case 2:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface2 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface2.getClass();
                KtakilatApplication.m.getClass();
                if (KtakilatApplication.h()) {
                    KtakilatApplication.m.getClass();
                    VerifyMgr.j(jsCallAndroidInterface2.b, KtakilatApplication.f().getMobileNo(), VerifyScence.SAFE_LOAN);
                    return;
                }
                return;
            case 3:
                new ShareUtil(((CommonWebViewSetting.JsCallAndroidInterface) obj).b).d();
                return;
            case 4:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface3 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface3.getClass();
                KtakilatApplication.m.getClass();
                boolean h = KtakilatApplication.h();
                KtaCollect.n_pwd_manage_clc_forgetpwd();
                KtakilatApplication.m.getClass();
                String mobileNo = KtakilatApplication.f().getMobileNo();
                if (h) {
                    verifyScence = VerifyScence.CHANGE_PWD;
                } else {
                    verifyScence = VerifyScence.FORGOT_PWD;
                }
                VerifyMgr.j(jsCallAndroidInterface3.b, mobileNo, verifyScence);
                return;
            case 5:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface4 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface4.getClass();
                try {
                    BaseActivity baseActivity2 = jsCallAndroidInterface4.b;
                    if (baseActivity2 instanceof CommonWebActivity) {
                        CommonWebActivity commonWebActivity = (CommonWebActivity) baseActivity2;
                        CommonWebFragment A = commonWebActivity.A(commonWebActivity.k);
                        commonWebActivity.m = A;
                        commonWebActivity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, A).commitAllowingStateLoss();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    LogUtil.a(e);
                    return;
                }
            case 6:
                ((CommonWebViewSetting.JsCallAndroidInterface) obj).b.n();
                return;
            case 7:
                ((CommonWebViewSetting.JsCallAndroidInterface) obj).b.u();
                return;
            case 8:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface5 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                GestureUtil gestureUtil = jsCallAndroidInterface5.d;
                if (gestureUtil != null) {
                    KtakilatApplication.m.getClass();
                    boolean h2 = KtakilatApplication.h();
                    KtaCollect.n_pwd_manage_clc_set_gesture();
                    gestureUtil.j(new GestureUtil.LoadGestureOpenCallback(h2) {

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ boolean f578a;

                        /* renamed from: com.ktakilat.loan.webtool.CommonWebViewSetting$JsCallAndroidInterface$5$1  reason: invalid class name */
                        class AnonymousClass1 implements GestureUtil.CheckCallback {
                            public final void a(boolean z) {
                            }
                        }

                        {
                            this.f578a = r2;
                        }

                        /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.ktakilat.loan.weiget.GestureUtil$CheckCallback] */
                        public final void a(boolean z, boolean z2) {
                            VerifyScence verifyScence;
                            if (z) {
                                JsCallAndroidInterface jsCallAndroidInterface = JsCallAndroidInterface.this;
                                if (z2) {
                                    BaseActivity baseActivity = jsCallAndroidInterface.b;
                                    KtakilatApplication.m.getClass();
                                    String mobileNo = KtakilatApplication.f().getMobileNo();
                                    if (this.f578a) {
                                        verifyScence = VerifyScence.CHANGE_GESTURE;
                                    } else {
                                        verifyScence = VerifyScence.FORGOT_GESTURE;
                                    }
                                    VerifyMgr.j(baseActivity, mobileNo, verifyScence);
                                    return;
                                }
                                jsCallAndroidInterface.d.f(GestureUtil.GestureSetEnum.SETTING, new Object());
                            }
                        }
                    });
                    return;
                }
                return;
            case 9:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface6 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface6.getClass();
                KtakilatApplication.m.getClass();
                if (KtakilatApplication.h()) {
                    jsCallAndroidInterface6.e.f(FaceLoginOnOffUtil.ScenceEnum.SETTING, new FaceLoginOnOffUtil.ScenceEnableCall() {
                        public final void a(FaceEnableResp faceEnableResp, boolean z, boolean z2, boolean z3) {
                            if (faceEnableResp != null) {
                                boolean isVersionSupportedOn = faceEnableResp.isVersionSupportedOn();
                                JsCallAndroidInterface jsCallAndroidInterface = JsCallAndroidInterface.this;
                                if (!isVersionSupportedOn || !z) {
                                    ToastUtil.c(jsCallAndroidInterface.b, R.string.face_login_not_enable);
                                } else if (faceEnableResp.isIdentityVerified() && !z2 && !z3) {
                                    BaseActivity baseActivity = jsCallAndroidInterface.b;
                                    DialogUtils.h(baseActivity, baseActivity.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                                }
                            }
                        }
                    });
                    return;
                }
                LoginRegistUtil.a(jsCallAndroidInterface6.b);
                return;
            case 10:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface7 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface7.getClass();
                KtaCollect.n_app_log_out();
                KtakilatApplication ktakilatApplication = KtakilatApplication.m;
                CommonWebViewSetting.JsCallAndroidInterface.AnonymousClass7 r2 = new WebCookieManager.CookieCallback() {
                    public final void d() {
                        JsCallAndroidInterface jsCallAndroidInterface = JsCallAndroidInterface.this;
                        if (jsCallAndroidInterface.b.s()) {
                            HomeActivity.C(jsCallAndroidInterface.b, (String) null, false);
                            EventBus.b().e(new EventHomeAct());
                            KtakilatApplication.m.i();
                        }
                    }
                };
                ktakilatApplication.getClass();
                KtakilatApplication.b(r2);
                return;
            case 11:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface8 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface8.getClass();
                KtaCollect.n_setting_clc_forget_pwd();
                KtakilatApplication.m.getClass();
                boolean h3 = KtakilatApplication.h();
                BaseActivity baseActivity3 = jsCallAndroidInterface8.b;
                if (h3) {
                    int i = SettingChangeActivity.q;
                    if (baseActivity3 != null) {
                        baseActivity3.startActivity(new Intent(baseActivity3, SettingChangeActivity.class));
                        return;
                    }
                    return;
                }
                LoginRegistUtil.a(baseActivity3);
                return;
            case 12:
                ((CommonWebViewSetting.JsCallAndroidInterface) obj).f577a.i = true;
                return;
            case 13:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface9 = (CommonWebViewSetting.JsCallAndroidInterface) obj;
                jsCallAndroidInterface9.getClass();
                try {
                    KeybordUtils.a(jsCallAndroidInterface9.b);
                    KtakilatApplication ktakilatApplication2 = KtakilatApplication.m;
                    CommonWebViewSetting.JsCallAndroidInterface.AnonymousClass4 r22 = new WebCookieManager.CookieCallback() {
                        public final void d() {
                            JsCallAndroidInterface jsCallAndroidInterface = JsCallAndroidInterface.this;
                            BaseActivity baseActivity = jsCallAndroidInterface.b;
                            if (baseActivity != null && !baseActivity.isFinishing() && !jsCallAndroidInterface.b.isDestroyed()) {
                                HomeActivity.C(jsCallAndroidInterface.b, (String) null, true);
                            }
                        }
                    };
                    ktakilatApplication2.getClass();
                    KtakilatApplication.b(r22);
                    return;
                } catch (Exception e2) {
                    LogUtil.a(e2);
                    return;
                }
            default:
                CommonWebViewSetting commonWebViewSetting = CommonWebViewSetting.this;
                if (commonWebViewSetting.e != null && (baseActivity = commonWebViewSetting.d) != null && !baseActivity.isDestroyed() && !baseActivity.isFinishing()) {
                    commonWebViewSetting.b();
                    return;
                }
                return;
        }
    }
}
