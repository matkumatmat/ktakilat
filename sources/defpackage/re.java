package defpackage;

import android.view.View;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.setting_change.SettingChangeActivity;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.verify_face.VerifyScence;

/* renamed from: re  reason: default package */
public final /* synthetic */ class re implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ SettingChangeActivity d;

    public /* synthetic */ re(SettingChangeActivity settingChangeActivity, int i) {
        this.c = i;
        this.d = settingChangeActivity;
    }

    public final void onClick(View view) {
        SettingChangeActivity settingChangeActivity = this.d;
        switch (this.c) {
            case 0:
                int i = SettingChangeActivity.q;
                settingChangeActivity.onBackPressed();
                return;
            default:
                int i2 = SettingChangeActivity.q;
                settingChangeActivity.getClass();
                if (FastClickUtil.a(view)) {
                    KtaCollect.n_pwd_manage_clc_forgetpwd();
                    KtakilatApplication.m.getClass();
                    VerifyMgr.j(settingChangeActivity, KtakilatApplication.f().getMobileNo(), VerifyScence.CHANGE_PWD);
                    return;
                }
                return;
        }
    }
}
