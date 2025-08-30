package defpackage;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpSms;

/* renamed from: f1  reason: default package */
public final /* synthetic */ class f1 implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ BaseVerifyOtpActivity d;

    public /* synthetic */ f1(BaseVerifyOtpActivity baseVerifyOtpActivity, int i) {
        this.c = i;
        this.d = baseVerifyOtpActivity;
    }

    public final void onClick(View view) {
        BaseVerifyOtpActivity baseVerifyOtpActivity = this.d;
        switch (this.c) {
            case 0:
                BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                KtaCollect.OTP_verification_page_click_switch(baseVerifyOtpActivity.K(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                baseVerifyOtpActivity.q.changeAnotherOtp.setVisibility(8);
                int i = baseVerifyOtpActivity.p;
                if (i < Integer.MAX_VALUE) {
                    baseVerifyOtpActivity.p = i + 1;
                }
                BaseVerifyOtpSms baseVerifyOtpSms2 = BaseVerifyOtpActivity.s;
                String str = baseVerifyOtpActivity.m;
                PhoneCodeType J = baseVerifyOtpActivity.J();
                OtpTypeEnum otpTypeEnum = OtpTypeEnum.NORMAL;
                baseVerifyOtpSms2.b.a(str, J, otpTypeEnum);
                baseVerifyOtpActivity.R(otpTypeEnum);
                return;
            case 1:
                BaseVerifyOtpSms baseVerifyOtpSms3 = BaseVerifyOtpActivity.s;
                KtaCollect.OTP_verification_page_click_switch(baseVerifyOtpActivity.K(), ExifInterface.GPS_MEASUREMENT_2D);
                baseVerifyOtpActivity.q.changeAnotherOtp.setVisibility(8);
                int i2 = baseVerifyOtpActivity.p;
                if (i2 < Integer.MAX_VALUE) {
                    baseVerifyOtpActivity.p = i2 + 1;
                }
                BaseVerifyOtpSms baseVerifyOtpSms4 = BaseVerifyOtpActivity.s;
                String str2 = baseVerifyOtpActivity.m;
                PhoneCodeType J2 = baseVerifyOtpActivity.J();
                OtpTypeEnum otpTypeEnum2 = OtpTypeEnum.WA;
                baseVerifyOtpSms4.b.a(str2, J2, otpTypeEnum2);
                baseVerifyOtpActivity.R(otpTypeEnum2);
                return;
            case 2:
                BaseVerifyOtpSms baseVerifyOtpSms5 = BaseVerifyOtpActivity.s;
                KtaCollect.n_safe_auth_otp_select_popup_selected(baseVerifyOtpActivity.K(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                int i3 = baseVerifyOtpActivity.p;
                if (i3 < Integer.MAX_VALUE) {
                    baseVerifyOtpActivity.p = i3 + 1;
                }
                OtpTypeEnum otpTypeEnum3 = OtpTypeEnum.NORMAL;
                baseVerifyOtpActivity.R(otpTypeEnum3);
                BaseVerifyOtpSms baseVerifyOtpSms6 = BaseVerifyOtpActivity.s;
                baseVerifyOtpSms6.b.a(baseVerifyOtpActivity.m, baseVerifyOtpActivity.J(), otpTypeEnum3);
                return;
            default:
                BaseVerifyOtpSms baseVerifyOtpSms7 = BaseVerifyOtpActivity.s;
                KtaCollect.n_safe_auth_otp_select_popup_selected(baseVerifyOtpActivity.K(), ExifInterface.GPS_MEASUREMENT_2D);
                int i4 = baseVerifyOtpActivity.p;
                if (i4 < Integer.MAX_VALUE) {
                    baseVerifyOtpActivity.p = i4 + 1;
                }
                OtpTypeEnum otpTypeEnum4 = OtpTypeEnum.WA;
                baseVerifyOtpActivity.R(otpTypeEnum4);
                BaseVerifyOtpSms baseVerifyOtpSms8 = BaseVerifyOtpActivity.s;
                baseVerifyOtpSms8.b.a(baseVerifyOtpActivity.m, baseVerifyOtpActivity.J(), otpTypeEnum4);
                return;
        }
    }
}
