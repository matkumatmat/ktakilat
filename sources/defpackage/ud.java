package defpackage;

import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.loan.main.EventHomeAct;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import org.greenrobot.eventbus.EventBus;

/* renamed from: ud  reason: default package */
public final /* synthetic */ class ud implements WebCookieManager.CookieCallback, GestureUtil.CheckCallback {
    public final /* synthetic */ RegistOtpActivity c;

    public /* synthetic */ ud(RegistOtpActivity registOtpActivity) {
        this.c = registOtpActivity;
    }

    public void a(boolean z) {
        int i = RegistOtpActivity.s;
        RegistOtpActivity registOtpActivity = this.c;
        if (!z) {
            registOtpActivity.getClass();
            HomeActivity.C(registOtpActivity, (String) null, false);
            EventBus.b().e(new EventHomeAct());
            registOtpActivity.finish();
            return;
        }
        registOtpActivity.getClass();
    }

    public void d() {
        int i = RegistOtpActivity.s;
        RegistOtpActivity registOtpActivity = this.c;
        if (!registOtpActivity.isFinishing() && !registOtpActivity.isDestroyed()) {
            new GestureUtil((BaseActivity) registOtpActivity).f(GestureUtil.GestureSetEnum.REGISTER, new ud(registOtpActivity));
        }
    }
}
