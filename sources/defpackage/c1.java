package defpackage;

import android.content.DialogInterface;
import com.katkilat.baidu_face.manager.FacePointManager;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;

/* renamed from: c1  reason: default package */
public final /* synthetic */ class c1 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ c1(u9 u9Var, BaseDialog baseDialog) {
        this.c = 1;
        this.d = u9Var;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.c) {
            case 0:
                FacePointManager facePointManager = ((BaseVerifyFaceActivity) this.d).n;
                if (facePointManager != null) {
                    facePointManager.b();
                    return;
                }
                return;
            case 1:
                ((u9) this.d).getClass();
                KtaCollect.n_pattern_guide_clc_cancel();
                return;
            default:
                ((InputPwdActivity) this.d).m = null;
                return;
        }
    }

    public /* synthetic */ c1(BaseActivity baseActivity, int i) {
        this.c = i;
        this.d = baseActivity;
    }
}
