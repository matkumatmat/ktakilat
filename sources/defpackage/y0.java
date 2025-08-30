package defpackage;

import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import kotlin.jvm.functions.Function0;

/* renamed from: y0  reason: default package */
public final /* synthetic */ class y0 implements Function0 {
    public final /* synthetic */ int c;
    public final /* synthetic */ BaseVerifyFaceActivity d;

    public /* synthetic */ y0(BaseVerifyFaceActivity baseVerifyFaceActivity, int i) {
        this.c = i;
        this.d = baseVerifyFaceActivity;
    }

    public final Object invoke() {
        BaseVerifyFaceActivity baseVerifyFaceActivity = this.d;
        switch (this.c) {
            case 0:
                int i = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.getClass();
                baseVerifyFaceActivity.runOnUiThread(new a1(baseVerifyFaceActivity, 4));
                baseVerifyFaceActivity.m.openFaceButton.setVisibility(0);
                baseVerifyFaceActivity.m.guideImage.setVisibility(0);
                return null;
            default:
                int i2 = BaseVerifyFaceActivity.s;
                baseVerifyFaceActivity.getClass();
                baseVerifyFaceActivity.runOnUiThread(new a1(baseVerifyFaceActivity, 1));
                return null;
        }
    }
}
