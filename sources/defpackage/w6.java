package defpackage;

import android.view.KeyEvent;
import android.widget.TextView;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.pendanaan.kta.databinding.DialogEktpVerifyBinding;

/* renamed from: w6  reason: default package */
public final /* synthetic */ class w6 implements TextView.OnEditorActionListener {
    public final /* synthetic */ FaceLoginOnOffUtil c;
    public final /* synthetic */ DialogEktpVerifyBinding d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ String f;
    public final /* synthetic */ FaceLoginOnOffUtil.EktpCall g;

    public /* synthetic */ w6(FaceLoginOnOffUtil faceLoginOnOffUtil, DialogEktpVerifyBinding dialogEktpVerifyBinding, boolean z, String str, FaceLoginOnOffUtil.EktpCall ektpCall) {
        this.c = faceLoginOnOffUtil;
        this.d = dialogEktpVerifyBinding;
        this.e = z;
        this.f = str;
        this.g = ektpCall;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        FaceLoginOnOffUtil faceLoginOnOffUtil = this.c;
        faceLoginOnOffUtil.getClass();
        if (i != 4) {
            return true;
        }
        DialogEktpVerifyBinding dialogEktpVerifyBinding = this.d;
        if (dialogEktpVerifyBinding.ektpEt.getText() == null) {
            return true;
        }
        FaceLoginOnOffUtil.EktpCall ektpCall = this.g;
        boolean z = this.e;
        String str = this.f;
        if (z) {
            faceLoginOnOffUtil.e(str, dialogEktpVerifyBinding.ektpEt.getText().toString(), dialogEktpVerifyBinding.ektpEt, ektpCall);
            return true;
        }
        faceLoginOnOffUtil.d(str, dialogEktpVerifyBinding.ektpEt.getText().toString(), dialogEktpVerifyBinding.ektpEt, ektpCall);
        return true;
    }
}
