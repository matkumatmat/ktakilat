package com.ktakilat.loan.verify_face;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.http.verify.VerifyEktpResp;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.util.List;

public final /* synthetic */ class f implements TextView.OnEditorActionListener {
    public final /* synthetic */ BaseVeritySecondActivity c;
    public final /* synthetic */ String d;

    public /* synthetic */ f(BaseVeritySecondActivity baseVeritySecondActivity, String str) {
        this.c = baseVeritySecondActivity;
        this.d = str;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        BaseVeritySecondActivity baseVeritySecondActivity = this.c;
        if (i != 4) {
            int i2 = BaseVeritySecondActivity.l;
            baseVeritySecondActivity.getClass();
            return true;
        } else if (baseVeritySecondActivity.j.getText() == null) {
            return true;
        } else {
            String obj = baseVeritySecondActivity.j.getText().toString();
            baseVeritySecondActivity.y();
            baseVeritySecondActivity.z();
            AppHttp.commonSecondVerifyByEktp(RxLifecycle.a(baseVeritySecondActivity.c, ActivityEvent.DESTROY), this.d, obj).subscribe(new ApiObserver<BaseResponse<VerifyEktpResp>>() {
                public final void a(BaseResponse baseResponse) {
                    int i = BaseVeritySecondActivity.l;
                    BaseVeritySecondActivity baseVeritySecondActivity = BaseVeritySecondActivity.this;
                    baseVeritySecondActivity.o();
                    ResponseCodeDeal.a(baseResponse);
                    baseVeritySecondActivity.A();
                    EditText editText = baseVeritySecondActivity.j;
                    if (editText != null) {
                        editText.setText("");
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    int i = BaseVeritySecondActivity.l;
                    BaseVeritySecondActivity baseVeritySecondActivity = BaseVeritySecondActivity.this;
                    baseVeritySecondActivity.o();
                    if (!TextUtils.isEmpty(((VerifyEktpResp) baseResponse.getData()).getSuccessfulValidationToken())) {
                        String successfulValidationToken = ((VerifyEktpResp) baseResponse.getData()).getSuccessfulValidationToken();
                        List<String> authStatusList = ((VerifyEktpResp) baseResponse.getData()).getAuthStatusList();
                        UserLoginResp loginResp = ((VerifyEktpResp) baseResponse.getData()).getLoginResp();
                        BaseDialog baseDialog = baseVeritySecondActivity.i;
                        if (baseDialog != null && baseDialog.isShowing()) {
                            baseVeritySecondActivity.i.dismiss();
                        }
                        baseVeritySecondActivity.E(successfulValidationToken, authStatusList, loginResp);
                    } else {
                        EditText editText = baseVeritySecondActivity.j;
                        if (editText != null) {
                            editText.setText("");
                        }
                    }
                    baseVeritySecondActivity.A();
                }
            });
            return true;
        }
    }
}
