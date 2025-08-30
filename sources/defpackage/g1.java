package defpackage;

import android.content.DialogInterface;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.verify_face.BaseVeritySecondActivity;
import com.pendanaan.kta.databinding.DialogEktpVerifyBinding;

/* renamed from: g1  reason: default package */
public final /* synthetic */ class g1 implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f652a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g1(Object obj, int i) {
        this.f652a = i;
        this.b = obj;
    }

    public final void onShow(DialogInterface dialogInterface) {
        switch (this.f652a) {
            case 0:
                KeybordUtils.b(((BaseVeritySecondActivity) this.b).j);
                return;
            case 1:
                KeybordUtils.b(((DialogEktpVerifyBinding) this.b).ektpEt);
                return;
            default:
                KeybordUtils.b(((InputPwdActivity) this.b).m);
                return;
        }
    }
}
