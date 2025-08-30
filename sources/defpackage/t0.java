package defpackage;

import android.view.View;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.katkilat.baidu_face.manager.BaiduFaceManager;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.CrashActivity;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.loan.banks.BanksActivity;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.gesture_create.GestureCreateActivity;
import com.ktakilat.loan.input_mobile.InputMobileActivity;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.login_gesture.LoginGestureActivity;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;
import com.ktakilat.loan.normal_ui.LivenessGuideActivity;
import com.ktakilat.loan.normal_ui.TDLivenessGuideActivity;
import com.ktakilat.loan.reset_pwd.ResetPwdActivity;
import com.ktakilat.loan.utils.TrustLivenessUtil;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import com.ktakilat.loan.web.CommonWebActivity;
import java.util.ArrayList;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0  reason: default package */
public final /* synthetic */ class t0 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ t0(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    /* JADX WARNING: type inference failed for: r12v13, types: [java.lang.Object, kotlin.Lazy] */
    public final void onClick(View view) {
        int i = 0;
        Object obj = this.d;
        switch (this.c) {
            case 0:
                int i2 = BanksActivity.l;
                ((BanksActivity) obj).onBackPressed();
                return;
            case 1:
                int i3 = BaseVerifyFaceActivity.s;
                BaseVerifyFaceActivity baseVerifyFaceActivity = (BaseVerifyFaceActivity) obj;
                baseVerifyFaceActivity.getClass();
                baseVerifyFaceActivity.runOnUiThread(new a1(baseVerifyFaceActivity, 5));
                TrustLivenessUtil.Companion.b(baseVerifyFaceActivity, new z0(baseVerifyFaceActivity, 0), new y0(baseVerifyFaceActivity, 1));
                return;
            case 2:
                int i4 = CommonWebActivity.p;
                ((CommonWebActivity) obj).z(true);
                return;
            case 3:
                int i5 = CrashActivity.j;
                ((CrashActivity) obj).finish();
                return;
            case 4:
                int i6 = FaceLoginOnOffActivity.p;
                ((FaceLoginOnOffActivity) obj).onBackPressed();
                return;
            case 5:
                int i7 = GestureCreateActivity.o;
                ((GestureCreateActivity) obj).onBackPressed();
                return;
            case 6:
                int i8 = GoogleMapActivity.q;
                ((GoogleMapActivity) obj).onBackPressed();
                return;
            case 7:
                int i9 = InputMobileActivity.o;
                InputMobileActivity inputMobileActivity = (InputMobileActivity) obj;
                inputMobileActivity.getClass();
                KtaCollect.n_change_pho_update_pho_clc_back();
                inputMobileActivity.finish();
                return;
            case 8:
                int i10 = InputPwdActivity.p;
                ((InputPwdActivity) obj).onBackPressed();
                return;
            case 9:
                int i11 = LivenessGuideActivity.e;
                LivenessGuideActivity livenessGuideActivity = (LivenessGuideActivity) obj;
                livenessGuideActivity.getClass();
                ub ubVar = new ub(livenessGuideActivity, 0);
                ub ubVar2 = new ub(livenessGuideActivity, 1);
                ((BaiduFaceManager) BaiduFaceManager.f457a.getValue()).getClass();
                Intrinsics.checkNotNullParameter(livenessGuideActivity, "mContext");
                Intrinsics.checkNotNullParameter(ubVar, "onSuccess");
                Intrinsics.checkNotNullParameter(ubVar2, "onFail");
                ArrayList arrayList = new ArrayList();
                arrayList.clear();
                arrayList.add(LivenessTypeEnum.Eye);
                arrayList.add(LivenessTypeEnum.Mouth);
                arrayList.add(LivenessTypeEnum.HeadRight);
                arrayList.add(LivenessTypeEnum.HeadDown);
                arrayList.add(LivenessTypeEnum.HeadLeft);
                arrayList.add(LivenessTypeEnum.HeadUp);
                Intrinsics.checkNotNullParameter(arrayList, "paramList");
                if (arrayList.size() >= 3) {
                    Random random = new Random();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (i < 3) {
                        int nextInt = random.nextInt(arrayList.size());
                        if (!arrayList2.contains(Integer.valueOf(nextInt))) {
                            arrayList2.add(Integer.valueOf(nextInt));
                            arrayList3.add(arrayList.get(nextInt));
                            i++;
                        }
                    }
                    arrayList = arrayList3;
                }
                BaiduFaceManager.a(livenessGuideActivity, arrayList, ubVar, ubVar2);
                return;
            case 10:
                ArrayList arrayList4 = LogActivity.k;
                ((LogActivity) obj).finish();
                return;
            case 11:
                int i12 = LoginGestureActivity.s;
                ((LoginGestureActivity) obj).onBackPressed();
                return;
            case 12:
                ((MaterialDatePicker) obj).lambda$initHeaderToggle$0(view);
                return;
            case 13:
                int i13 = ResetPwdActivity.n;
                ((ResetPwdActivity) obj).onBackPressed();
                return;
            default:
                int i14 = TDLivenessGuideActivity.d;
                TDLivenessGuideActivity tDLivenessGuideActivity = (TDLivenessGuideActivity) obj;
                tDLivenessGuideActivity.setResult(-1);
                tDLivenessGuideActivity.finish();
                return;
        }
    }
}
