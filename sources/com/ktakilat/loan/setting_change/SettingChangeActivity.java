package com.ktakilat.loan.setting_change;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.kta_face.FaceEnableResp;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.reset_pwd.ResetPwdActivity;
import com.ktakilat.loan.setting_change.SettingChangeContact;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.pendanaan.kta.databinding.ActivityMoreSettingBinding;
import com.pendanaan.kta.databinding.DialogFaceOnoffEktpBinding;
import com.pendanaan.kta.databinding.DialogFaceOnoffOffBinding;

@SuppressLint({"NonConstantResourceId"})
public class SettingChangeActivity extends BaseActivity implements SettingChangeContact.View {
    public static final /* synthetic */ int q = 0;
    public SettingChangePresenter i;
    public GestureUtil j;
    public FaceLoginOnOffUtil k;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public ActivityMoreSettingBinding p;

    public static void z(SettingChangeActivity settingChangeActivity, boolean z) {
        if (!settingChangeActivity.n) {
            ToastUtil.c(settingChangeActivity, R.string.face_login_not_enable);
        } else if (!settingChangeActivity.o) {
            DialogFaceOnoffEktpBinding inflate = DialogFaceOnoffEktpBinding.inflate(LayoutInflater.from(settingChangeActivity));
            DialogUtils.b(settingChangeActivity, inflate.getRoot(), inflate.nextTv, new DialogUtils.CommonOkClickListern() {
                public final void b() {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("path", "/Authenticate?Refresh=9");
                    HomeActivity.C(SettingChangeActivity.this, jsonObject.toString(), false);
                }
            }, (u9) null).show();
        } else if (z) {
            settingChangeActivity.k.f(FaceLoginOnOffUtil.ScenceEnum.SETTING, new FaceLoginOnOffUtil.ScenceEnableCall() {
                public final void a(FaceEnableResp faceEnableResp, boolean z, boolean z2, boolean z3) {
                    if (faceEnableResp != null) {
                        boolean isVersionSupportedOn = faceEnableResp.isVersionSupportedOn();
                        SettingChangeActivity settingChangeActivity = SettingChangeActivity.this;
                        if (!isVersionSupportedOn || !z) {
                            ToastUtil.c(settingChangeActivity, R.string.face_login_not_enable);
                        } else if (!faceEnableResp.isIdentityVerified()) {
                            settingChangeActivity.getClass();
                            DialogFaceOnoffEktpBinding inflate = DialogFaceOnoffEktpBinding.inflate(LayoutInflater.from(settingChangeActivity));
                            DialogUtils.b(settingChangeActivity, inflate.getRoot(), inflate.nextTv, new DialogUtils.CommonOkClickListern() {
                                public final void b() {
                                    JsonObject jsonObject = new JsonObject();
                                    jsonObject.addProperty("path", "/Authenticate?Refresh=9");
                                    HomeActivity.C(SettingChangeActivity.this, jsonObject.toString(), false);
                                }
                            }, (u9) null).show();
                        } else if (!z2 && !z3) {
                            DialogUtils.h(settingChangeActivity, settingChangeActivity.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                        }
                    }
                }
            });
        } else {
            settingChangeActivity.k.c(new FaceLoginOnOffUtil.FaceEnableCall() {
                public final void a(FaceEnableResp faceEnableResp) {
                    if (faceEnableResp != null) {
                        boolean isVersionSupportedOn = faceEnableResp.isVersionSupportedOn();
                        SettingChangeActivity settingChangeActivity = SettingChangeActivity.this;
                        if (!isVersionSupportedOn) {
                            ToastUtil.c(settingChangeActivity, R.string.face_login_not_enable);
                        } else if (faceEnableResp.isFaceLoginEnable()) {
                            settingChangeActivity.getClass();
                            DialogFaceOnoffOffBinding inflate = DialogFaceOnoffOffBinding.inflate(LayoutInflater.from(settingChangeActivity));
                            DialogUtils.c(settingChangeActivity, inflate.getRoot(), inflate.nextTv, inflate.cancelTv, new DialogUtils.CommonOkAndCancleClickListern() {
                                public final void a() {
                                }

                                public final void b() {
                                    SettingChangeActivity.this.k.i(new FaceLoginOnOffUtil.FaceCloseCall() {
                                        public final void a(boolean z) {
                                            if (z) {
                                                SettingChangeActivity.this.A((b) null);
                                            }
                                        }
                                    });
                                }
                            }).show();
                        }
                    }
                }
            });
        }
    }

    public final void A(final b bVar) {
        this.k.c(new FaceLoginOnOffUtil.FaceEnableCall() {
            public final void a(FaceEnableResp faceEnableResp) {
                if (faceEnableResp != null) {
                    SettingChangeActivity settingChangeActivity = SettingChangeActivity.this;
                    settingChangeActivity.l = true;
                    settingChangeActivity.m = faceEnableResp.isFaceLoginEnable();
                    settingChangeActivity.n = faceEnableResp.isVersionSupportedOn();
                    settingChangeActivity.o = faceEnableResp.isIdentityVerified();
                    if (settingChangeActivity.n) {
                        settingChangeActivity.p.faceCardView.setVisibility(0);
                    } else {
                        settingChangeActivity.p.faceCardView.setVisibility(8);
                    }
                    settingChangeActivity.p.setFaceOffTv.setSelected(true ^ settingChangeActivity.m);
                    settingChangeActivity.p.setFaceOnTv.setSelected(settingChangeActivity.m);
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.a(faceEnableResp);
                    }
                }
            }
        });
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 500) {
            if (i2 == 10001) {
                A((b) null);
            } else if (i2 == 800 && i3 == -1 && intent != null) {
                int intExtra = intent.getIntExtra("processType", -1);
                intent.getStringExtra("processToken");
                if (intent.getSerializableExtra("loginResp") != null) {
                    UserLoginResp userLoginResp = (UserLoginResp) intent.getSerializableExtra("loginResp");
                }
                if (intExtra == 101 || intExtra == 102) {
                    startActivity(new Intent(this, ResetPwdActivity.class));
                } else if (intExtra == 103 || intExtra == 104) {
                    new GestureUtil((BaseActivity) this).f(GestureUtil.GestureSetEnum.SETTING, (GestureUtil.CheckCallback) null);
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v17, types: [com.ktakilat.loan.setting_change.SettingChangePresenter, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityMoreSettingBinding inflate = ActivityMoreSettingBinding.inflate(getLayoutInflater());
        this.p = inflate;
        setContentView((View) inflate.getRoot());
        KtaCollect.n_pwd_manage_exposure();
        this.j = new GestureUtil((BaseActivity) this);
        this.k = new FaceLoginOnOffUtil(this);
        this.p.pageTitle.title.setText(R.string.set_more_title);
        this.p.pageTitle.backward.setOnClickListener(new re(this, 0));
        this.p.forgetPassTv.setOnClickListener(new re(this, 1));
        this.p.setGestureTv.setOnClickListener(new a(this));
        AnonymousClass2 r3 = new OnSafeClickListener() {
            public final void a(View view) {
                String str;
                if (FastClickUtil.a(view)) {
                    SettingChangeActivity settingChangeActivity = SettingChangeActivity.this;
                    if (!settingChangeActivity.l) {
                        settingChangeActivity.A(new b(this));
                        return;
                    }
                    if (settingChangeActivity.m) {
                        str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                    } else {
                        str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    }
                    KtaCollect.n_pwd_manage_clc_face_switch(str);
                    SettingChangeActivity.z(settingChangeActivity, !settingChangeActivity.m);
                }
            }
        };
        this.p.setFaceOffTv.setOnClickListener(r3);
        this.p.setFaceOnTv.setOnClickListener(r3);
        this.i = new Object();
        this.p.setFaceOffTv.setSelected(true);
        this.p.setFaceOnTv.setSelected(false);
        A((b) null);
    }

    public final void onDestroy() {
        SettingChangePresenter settingChangePresenter = this.i;
        if (settingChangePresenter != null) {
            settingChangePresenter.getClass();
        }
        super.onDestroy();
    }
}
