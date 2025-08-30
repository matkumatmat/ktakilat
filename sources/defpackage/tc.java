package defpackage;

import android.app.PendingIntent;
import android.content.Intent;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.http.login.MobileCheckResp;
import com.ktakilat.loan.http.ojk.OjkStatementResp;
import com.ktakilat.loan.login_face.LoginFaceActivity;
import com.ktakilat.loan.login_gesture.LoginGestureActivity;
import com.ktakilat.loan.login_otp.LoginOtpActivity;
import com.ktakilat.loan.login_pwd.LoginPwdActivity;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.regist_otp.RegistOtpActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: tc  reason: default package */
public final /* synthetic */ class tc implements Function1 {
    public final /* synthetic */ int c;
    public final /* synthetic */ MobileCheckV2Activity d;

    public /* synthetic */ tc(MobileCheckV2Activity mobileCheckV2Activity, int i) {
        this.c = i;
        this.d = mobileCheckV2Activity;
    }

    public final Object invoke(Object obj) {
        int i = 0;
        MobileCheckV2Activity mobileCheckV2Activity = this.d;
        switch (this.c) {
            case 0:
                PendingIntent pendingIntent = (PendingIntent) obj;
                ActivityResultLauncher activityResultLauncher = mobileCheckV2Activity.f;
                Intrinsics.c(pendingIntent);
                activityResultLauncher.launch(new IntentSenderRequest.Builder(pendingIntent).build());
                return Unit.f696a;
            case 1:
                Boolean bool = (Boolean) obj;
                int i2 = MobileCheckV2Activity.g;
                mobileCheckV2Activity.n().next.setEnabled(!bool.booleanValue());
                mobileCheckV2Activity.n().editText.setEnabled(true ^ bool.booleanValue());
                CircularProgressIndicator circularProgressIndicator = mobileCheckV2Activity.n().loading;
                if (!bool.booleanValue()) {
                    i = 8;
                }
                circularProgressIndicator.setVisibility(i);
                return Unit.f696a;
            case 2:
                int i3 = MobileCheckV2Activity.g;
                Toast toast = ToastUtil.f478a;
                Toast.makeText(mobileCheckV2Activity, (String) obj, 0).show();
                return Unit.f696a;
            case 3:
                MobileCheckResp mobileCheckResp = (MobileCheckResp) obj;
                int i4 = MobileCheckV2Activity.g;
                String valueOf = String.valueOf(mobileCheckV2Activity.n().editText.getText());
                if (mobileCheckResp.isExist()) {
                    int loginType = mobileCheckResp.getLoginType();
                    if (loginType == 1) {
                        LoginPwdActivity.F(mobileCheckV2Activity, valueOf, true);
                    } else if (loginType == 2) {
                        LoginOtpActivity.G(mobileCheckV2Activity, valueOf, true);
                    } else if (loginType == 4) {
                        LoginFaceActivity.E(mobileCheckV2Activity, valueOf, true);
                    } else if (loginType == 5) {
                        LoginGestureActivity.C(mobileCheckV2Activity, valueOf, true);
                    }
                } else {
                    int i5 = RegistOtpActivity.s;
                    Intent intent = new Intent(mobileCheckV2Activity, RegistOtpActivity.class);
                    intent.putExtra("mobile", valueOf);
                    intent.putExtra("processRequestCode", 300);
                    mobileCheckV2Activity.startActivity(intent);
                }
                return Unit.f696a;
            default:
                OjkStatementResp ojkStatementResp = (OjkStatementResp) obj;
                int i6 = MobileCheckV2Activity.g;
                if (ojkStatementResp.isChecked()) {
                    return Unit.f696a;
                }
                String title = ojkStatementResp.getTitle();
                String content = ojkStatementResp.getContent();
                mobileCheckV2Activity.getClass();
                if (!(content == null || content.length() == 0)) {
                    if (title == null) {
                        title = "";
                    }
                    try {
                        DialogUtils.f(mobileCheckV2Activity, title, content, new y9(6), new uc(mobileCheckV2Activity, 0));
                    } catch (Exception unused) {
                    }
                }
                return Unit.f696a;
        }
    }
}
