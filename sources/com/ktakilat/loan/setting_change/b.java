package com.ktakilat.loan.setting_change;

import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.setting_change.SettingChangeActivity;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;

public final /* synthetic */ class b implements FaceLoginOnOffUtil.FaceEnableCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingChangeActivity.AnonymousClass2 f551a;

    public /* synthetic */ b(SettingChangeActivity.AnonymousClass2 r1) {
        this.f551a = r1;
    }

    public final void a(FaceEnableResp faceEnableResp) {
        SettingChangeActivity settingChangeActivity = SettingChangeActivity.this;
        SettingChangeActivity.z(settingChangeActivity, !settingChangeActivity.m);
    }
}
