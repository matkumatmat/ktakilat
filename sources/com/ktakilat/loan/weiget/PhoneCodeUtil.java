package com.ktakilat.loan.weiget;

import android.os.Handler;
import android.os.Looper;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.places.model.PlaceFields;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.service.sms.SmsVerificationService;
import com.ktakilat.loan.service.sms.SmsVerifyCodeReceiver;
import com.ktakilat.loan.utils.WhatsappOtpUtil;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.jvm.internal.Intrinsics;

public class PhoneCodeUtil {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f596a = new Handler(Looper.getMainLooper());
    public final SmsVerifyCodeReceiver b;
    public Timer c;
    public int d = 0;
    public boolean e;
    public String f;
    public final BaseActivity g;
    public PhoneCodeCallback h;

    /* renamed from: com.ktakilat.loan.weiget.PhoneCodeUtil$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f597a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.ktakilat.loan.http.user.OtpTypeEnum[] r0 = com.ktakilat.loan.http.user.OtpTypeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f597a = r0
                com.ktakilat.loan.http.user.OtpTypeEnum r1 = com.ktakilat.loan.http.user.OtpTypeEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f597a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ktakilat.loan.http.user.OtpTypeEnum r1 = com.ktakilat.loan.http.user.OtpTypeEnum.WA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.weiget.PhoneCodeUtil.AnonymousClass4.<clinit>():void");
        }
    }

    public interface PhoneCodeCallback {
        void a(int i);

        void b();

        void c(String str);
    }

    public PhoneCodeUtil(BaseActivity baseActivity, PhoneCodeCallback phoneCodeCallback) {
        this.g = baseActivity;
        this.h = phoneCodeCallback;
        SmsVerifyCodeReceiver smsVerifyCodeReceiver = new SmsVerifyCodeReceiver();
        this.b = smsVerifyCodeReceiver;
        lb lbVar = new lb(this, 10);
        Intrinsics.checkNotNullParameter(lbVar, "callback");
        smsVerifyCodeReceiver.f544a = lbVar;
        this.b.a(baseActivity);
    }

    public final void a(String str, PhoneCodeType phoneCodeType, OtpTypeEnum otpTypeEnum) {
        boolean z = this.e;
        BaseActivity baseActivity = this.g;
        if (z) {
            ToastUtil.c(baseActivity, R.string.get_code_countdown_toast);
        } else if (this.d <= 0 && PhoneCheckUtil.a(baseActivity, str) == 0) {
            String b2 = PhoneCheckUtil.b(baseActivity, str, false);
            int i = AnonymousClass4.f597a[otpTypeEnum.ordinal()];
            if (i != 1) {
                if (i == 2 && PhoneCheckUtil.a(baseActivity, b2) == 0) {
                    String b3 = PhoneCheckUtil.b(baseActivity, b2, false);
                    baseActivity.n();
                    AppHttp.sendWhatsAppOtp(RxLifecycle.a(baseActivity.c, ActivityEvent.DESTROY), b3, phoneCodeType).subscribe(new ApiObserver<BaseResponse<String>>() {
                        public final void a(BaseResponse baseResponse) {
                            PhoneCodeUtil.this.g.u();
                            ResponseCodeDeal.a(baseResponse);
                        }

                        public final void b(BaseResponse baseResponse) {
                            PhoneCodeUtil phoneCodeUtil = PhoneCodeUtil.this;
                            phoneCodeUtil.g.u();
                            phoneCodeUtil.e = true;
                            phoneCodeUtil.f = (String) baseResponse.getData();
                            phoneCodeUtil.d();
                            phoneCodeUtil.c(60);
                            PhoneCodeCallback phoneCodeCallback = phoneCodeUtil.h;
                            if (phoneCodeCallback != null) {
                                phoneCodeCallback.b();
                            }
                            BaseActivity baseActivity = phoneCodeUtil.g;
                            Intrinsics.checkNotNullParameter(baseActivity, PlaceFields.CONTEXT);
                            if (WhatsappOtpUtil.Companion.a(baseActivity, "com.whatsapp") || WhatsappOtpUtil.Companion.a(baseActivity, "com.whatsapp.w4b")) {
                                WhatsappOtpUtil.Companion.b(baseActivity, "com.whatsapp");
                                WhatsappOtpUtil.Companion.b(baseActivity, "com.whatsapp.w4b");
                            }
                        }
                    });
                }
            } else if (PhoneCheckUtil.a(baseActivity, b2) == 0) {
                String b4 = PhoneCheckUtil.b(baseActivity, b2, false);
                baseActivity.n();
                AppHttp.sendPhoneCode(RxLifecycle.a(baseActivity.c, ActivityEvent.DESTROY), b4, phoneCodeType).subscribe(new ApiObserver<BaseResponse<String>>() {
                    public final void a(BaseResponse baseResponse) {
                        PhoneCodeUtil.this.g.u();
                        ResponseCodeDeal.a(baseResponse);
                    }

                    public final void b(BaseResponse baseResponse) {
                        PhoneCodeUtil phoneCodeUtil = PhoneCodeUtil.this;
                        phoneCodeUtil.g.u();
                        phoneCodeUtil.e = true;
                        phoneCodeUtil.f = (String) baseResponse.getData();
                        phoneCodeUtil.d();
                        phoneCodeUtil.c(60);
                        PhoneCodeCallback phoneCodeCallback = phoneCodeUtil.h;
                        if (phoneCodeCallback != null) {
                            phoneCodeCallback.b();
                        }
                    }
                });
            }
        }
    }

    public final void b() {
        BaseActivity baseActivity = this.g;
        boolean z = SmsVerificationService.e;
        SmsVerificationService.Companion.b(baseActivity);
        SmsVerifyCodeReceiver smsVerifyCodeReceiver = this.b;
        if (smsVerifyCodeReceiver != null) {
            Intrinsics.checkNotNullParameter(baseActivity, PlaceFields.CONTEXT);
            try {
                LocalBroadcastManager.getInstance(baseActivity).unregisterReceiver(smsVerifyCodeReceiver);
            } catch (Exception unused) {
            }
        }
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
        this.d = 0;
        this.h = null;
    }

    public final void c(int i) {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
        this.d = i;
        Timer timer2 = new Timer();
        this.c = timer2;
        timer2.schedule(new TimerTask() {
            public final void run() {
                PhoneCodeUtil phoneCodeUtil = PhoneCodeUtil.this;
                int i = phoneCodeUtil.d;
                if (i > 0) {
                    phoneCodeUtil.d = i - 1;
                    phoneCodeUtil.f596a.post(new e(this, 1));
                }
            }
        }, 0, 1000);
    }

    public final void d() {
        boolean z = SmsVerificationService.e;
        SmsVerificationService.Companion.a(this.g);
    }

    public final void e() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
        this.d = 0;
        this.e = false;
        this.h.a(0);
    }
}
