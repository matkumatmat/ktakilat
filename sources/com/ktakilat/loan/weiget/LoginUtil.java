package com.ktakilat.loan.weiget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.login.MobileCheckResp;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.login_face.LoginFaceActivity;
import com.ktakilat.loan.login_gesture.LoginGestureActivity;
import com.ktakilat.loan.login_otp.LoginOtpActivity;
import com.ktakilat.loan.login_pwd.LoginPwdActivity;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.verify_face.VerifyScence;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import kotlin.jvm.internal.Intrinsics;

public class LoginUtil {

    /* renamed from: a  reason: collision with root package name */
    public final Context f593a;

    public interface FirstLoginType {
    }

    public interface LastLoginMobileCall {
        void a(String str, Boolean bool, int i);
    }

    public interface MobileStatusCall {
    }

    public interface MoreTypeDefine {
    }

    public LoginUtil(Context context) {
        this.f593a = context;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.getClass();
        Context context = this.f593a;
        char c = 65535;
        switch (str.hashCode()) {
            case -1981665561:
                if (str.equals("FACE_LOGIN")) {
                    c = 0;
                    break;
                }
                break;
            case -1811980115:
                if (str.equals("FORGET_PASSWORD")) {
                    c = 1;
                    break;
                }
                break;
            case -1545997431:
                if (str.equals("CHANGE_PHONE_NUMBER")) {
                    c = 2;
                    break;
                }
                break;
            case -1457625947:
                if (str.equals("PASSWORD_LOGIN")) {
                    c = 3;
                    break;
                }
                break;
            case -895109885:
                if (str.equals("FORGET_GESTURE_PASSWORD")) {
                    c = 4;
                    break;
                }
                break;
            case -395484867:
                if (str.equals("SMS_CODE_LOGIN")) {
                    c = 5;
                    break;
                }
                break;
            case 282001587:
                if (str.equals("GESTURE_LOGIN")) {
                    c = 6;
                    break;
                }
                break;
            case 1774777346:
                if (str.equals("SWITCH_ACCOUNT")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return context.getString(R.string.login_pwd_more_face);
            case 1:
                return context.getString(R.string.login_pwd_more_forget);
            case 2:
                return context.getString(R.string.login_pwd_more_change);
            case 3:
                return context.getString(R.string.login_pwd_more_pwd);
            case 4:
                return context.getString(R.string.login_pwd_more_forget_gesture);
            case 5:
                return context.getString(R.string.login_pwd_more_otp);
            case 6:
                return context.getString(R.string.login_pwd_more_gesture);
            case 7:
                return context.getString(R.string.login_pwd_more_switch);
            default:
                ErrorCaseUpload.a("type = ".concat(str));
                return null;
        }
    }

    public final boolean b() {
        Context context = this.f593a;
        if (context == null || !(context instanceof Activity) || ((Activity) context).isDestroyed() || ((Activity) context).isFinishing()) {
            return false;
        }
        return true;
    }

    public final void c(BaseActivity baseActivity, String str, String str2, boolean z) {
        Context context = this.f593a;
        char c = 65535;
        switch (str.hashCode()) {
            case -1981665561:
                if (str.equals("FACE_LOGIN")) {
                    c = 0;
                    break;
                }
                break;
            case -1811980115:
                if (str.equals("FORGET_PASSWORD")) {
                    c = 1;
                    break;
                }
                break;
            case -1545997431:
                if (str.equals("CHANGE_PHONE_NUMBER")) {
                    c = 2;
                    break;
                }
                break;
            case -1457625947:
                if (str.equals("PASSWORD_LOGIN")) {
                    c = 3;
                    break;
                }
                break;
            case -895109885:
                if (str.equals("FORGET_GESTURE_PASSWORD")) {
                    c = 4;
                    break;
                }
                break;
            case -395484867:
                if (str.equals("SMS_CODE_LOGIN")) {
                    c = 5;
                    break;
                }
                break;
            case 282001587:
                if (str.equals("GESTURE_LOGIN")) {
                    c = 6;
                    break;
                }
                break;
            case 1774777346:
                if (str.equals("SWITCH_ACCOUNT")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                LoginFaceActivity.E(baseActivity, str2, z);
                return;
            case 1:
                VerifyMgr.j(baseActivity, str2, VerifyScence.FORGOT_PWD);
                return;
            case 2:
                InputPwdActivity.B(baseActivity, str2, 0);
                return;
            case 3:
                LoginPwdActivity.F(context, str2, z);
                return;
            case 4:
                VerifyMgr.j(baseActivity, str2, VerifyScence.FORGOT_GESTURE);
                return;
            case 5:
                LoginOtpActivity.G(context, str2, z);
                return;
            case 6:
                LoginGestureActivity.C(context, str2, z);
                return;
            case 7:
                int i = MobileCheckV2Activity.g;
                Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
                context.startActivity(new Intent(context, MobileCheckV2Activity.class));
                return;
            default:
                ErrorCaseUpload.a("type = ".concat(str));
                return;
        }
    }

    public final void d(int i, String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        Context context = this.f593a;
        if (isEmpty) {
            int i2 = MobileCheckV2Activity.g;
            Intrinsics.checkNotNullParameter(context, PlaceFields.CONTEXT);
            context.startActivity(new Intent(context, MobileCheckV2Activity.class));
        } else if (i == 1) {
            LoginPwdActivity.F(context, str, false);
        } else if (i == 2) {
            LoginOtpActivity.G(context, str, false);
        } else if (i == 4) {
            LoginFaceActivity.E(context, str, false);
        } else if (i != 5) {
            ErrorCaseUpload.a("firstLoginType = " + i);
        } else {
            LoginGestureActivity.C(context, str, false);
        }
    }

    public final void e(final LastLoginMobileCall lastLoginMobileCall) {
        if (b()) {
            final String string = AppKv.g().f465a.getString("last_login_mobile", "");
            LifecycleTransformer lifecycleTransformer = null;
            if (TextUtils.isEmpty(string)) {
                lastLoginMobileCall.a((String) null, (Boolean) null, -1);
                return;
            }
            AnonymousClass2 r1 = new MobileStatusCall() {
                public final void a(int i, boolean z) {
                    LastLoginMobileCall.this.a(string, Boolean.valueOf(z), i);
                }
            };
            if (b()) {
                boolean b = b();
                Context context = this.f593a;
                if (b && (context instanceof BaseActivity)) {
                    ((BaseActivity) context).n();
                }
                if (context instanceof BaseActivity) {
                    lifecycleTransformer = RxLifecycle.a(((BaseActivity) context).c, ActivityEvent.DESTROY);
                }
                AppHttp.mobileCheck(lifecycleTransformer, string).subscribe(new ApiObserver<BaseResponse<MobileCheckResp>>(r1, string) {
                    public final /* synthetic */ MobileStatusCall c;

                    {
                        this.c = r2;
                    }

                    public final void a(BaseResponse baseResponse) {
                        LoginUtil loginUtil = LoginUtil.this;
                        if (loginUtil.b()) {
                            if (loginUtil.b()) {
                                Context context = loginUtil.f593a;
                                if (context instanceof BaseActivity) {
                                    ((BaseActivity) context).u();
                                }
                            }
                            ((AnonymousClass2) this.c).a(1, true);
                        }
                    }

                    public final void b(BaseResponse baseResponse) {
                        LoginUtil loginUtil = LoginUtil.this;
                        if (loginUtil.b()) {
                            if (loginUtil.b()) {
                                Context context = loginUtil.f593a;
                                if (context instanceof BaseActivity) {
                                    ((BaseActivity) context).u();
                                }
                            }
                            if (baseResponse.getData() != null) {
                                AppKv.g().b("support_login_type", JsonUtil.a(((MobileCheckResp) baseResponse.getData()).getSupportedLoginTypes()));
                                boolean isExist = ((MobileCheckResp) baseResponse.getData()).isExist();
                                ((AnonymousClass2) this.c).a(((MobileCheckResp) baseResponse.getData()).getLoginType(), isExist);
                            }
                        }
                    }
                });
            }
        }
    }
}
