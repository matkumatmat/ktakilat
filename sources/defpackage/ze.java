package defpackage;

import com.ktakilat.loan.service.sms.SmsVerificationService;

/* renamed from: ze  reason: default package */
public final /* synthetic */ class ze implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ SmsVerificationService d;

    public /* synthetic */ ze(SmsVerificationService smsVerificationService, int i) {
        this.c = i;
        this.d = smsVerificationService;
    }

    public final void run() {
        SmsVerificationService smsVerificationService = this.d;
        switch (this.c) {
            case 0:
                int i = SmsVerificationService.SmsBrReceiver.d;
                boolean z = SmsVerificationService.e;
                smsVerificationService.getClass();
                smsVerificationService.stopSelf();
                return;
            default:
                int i2 = SmsVerificationService.SmsBrReceiver.d;
                boolean z2 = SmsVerificationService.e;
                smsVerificationService.getClass();
                smsVerificationService.stopSelf();
                return;
        }
    }
}
