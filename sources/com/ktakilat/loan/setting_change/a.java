package com.ktakilat.loan.setting_change;

import android.view.View;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.verify_face.VerifyScence;
import com.ktakilat.loan.weiget.GestureUtil;

public final /* synthetic */ class a implements View.OnClickListener {
    public final /* synthetic */ SettingChangeActivity c;

    public /* synthetic */ a(SettingChangeActivity settingChangeActivity) {
        this.c = settingChangeActivity;
    }

    public final void onClick(View view) {
        int i = SettingChangeActivity.q;
        SettingChangeActivity settingChangeActivity = this.c;
        settingChangeActivity.getClass();
        if (FastClickUtil.a(view)) {
            settingChangeActivity.j.j(new GestureUtil.LoadGestureOpenCallback() {

                /* renamed from: com.ktakilat.loan.setting_change.SettingChangeActivity$1$1  reason: invalid class name */
                class AnonymousClass1 implements GestureUtil.CheckCallback {
                    public final void a(boolean z) {
                    }
                }

                /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, com.ktakilat.loan.weiget.GestureUtil$CheckCallback] */
                public final void a(boolean z, boolean z2) {
                    if (z) {
                        SettingChangeActivity settingChangeActivity = SettingChangeActivity.this;
                        if (z2) {
                            KtakilatApplication.m.getClass();
                            VerifyMgr.j(settingChangeActivity, KtakilatApplication.f().getMobileNo(), VerifyScence.CHANGE_GESTURE);
                            return;
                        }
                        settingChangeActivity.j.f(GestureUtil.GestureSetEnum.SETTING, new Object());
                    }
                }
            });
        }
    }
}
