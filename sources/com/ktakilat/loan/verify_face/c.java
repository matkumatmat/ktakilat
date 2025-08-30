package com.ktakilat.loan.verify_face;

import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import java.util.ArrayList;

public final /* synthetic */ class c implements DialogUtils.SingleSelectCallback {
    public final /* synthetic */ BaseVerifyFaceActivity c;
    public final /* synthetic */ ArrayList d;

    public /* synthetic */ c(BaseVerifyFaceActivity baseVerifyFaceActivity, ArrayList arrayList) {
        this.c = baseVerifyFaceActivity;
        this.d = arrayList;
    }

    public final void a(int i, String str) {
        int i2 = BaseVerifyFaceActivity.s;
        BaseVerifyFaceActivity baseVerifyFaceActivity = this.c;
        baseVerifyFaceActivity.getClass();
        if (BaseVerifyFaceActivity.AnonymousClass8.f555a[((VerifyType) this.d.get(i)).ordinal()] == 1) {
            baseVerifyFaceActivity.I(baseVerifyFaceActivity.p);
        }
    }
}
