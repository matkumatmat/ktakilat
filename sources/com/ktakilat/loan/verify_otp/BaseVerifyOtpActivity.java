package com.ktakilat.loan.verify_otp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.utils.FastClickUtil;
import com.ktakilat.cbase.utils.KeybordUtils;
import com.ktakilat.cbase.utils.PhoneValidator;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.http.verify.VerifyOtpResp;
import com.ktakilat.loan.service.sms.SmsVerificationService;
import com.ktakilat.loan.utils.OtpUtil$Companion$getOtpType$1;
import com.ktakilat.loan.verify_face.BaseVeritySecondActivity;
import com.ktakilat.loan.verify_face.EventVerifyMethodUpdate;
import com.ktakilat.loan.verify_face.VerifyType;
import com.ktakilat.loan.weiget.GpsUtil;
import com.ktakilat.loan.weiget.PhoneCodeUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.pendanaan.kta.databinding.ActivityBaseVerifyCodeBinding;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@SuppressLint({"NonConstantResourceId"})
public abstract class BaseVerifyOtpActivity extends BaseVeritySecondActivity implements View.OnClickListener {
    public static BaseVerifyOtpSms s;
    public static boolean t;
    public static boolean u;
    public static OtpTypeEnum v;
    public String m;
    public int n;
    public ArrayList o;
    public int p = 0;
    public ActivityBaseVerifyCodeBinding q;
    public final BroadcastReceiver r = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("code");
                if (stringExtra != null) {
                    BaseVerifyOtpActivity.this.q.codeEdit.setText(stringExtra);
                }
            } catch (Exception unused) {
            }
        }
    };

    /* renamed from: com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f567a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0023 */
        static {
            /*
                com.ktakilat.loan.verify_face.VerifyType[] r0 = com.ktakilat.loan.verify_face.VerifyType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.ktakilat.loan.verify_face.VerifyType r2 = com.ktakilat.loan.verify_face.VerifyType.FACE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                com.ktakilat.loan.http.user.OtpTypeEnum[] r0 = com.ktakilat.loan.http.user.OtpTypeEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f567a = r0
                com.ktakilat.loan.http.user.OtpTypeEnum r2 = com.ktakilat.loan.http.user.OtpTypeEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x0023 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0023 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r0 = f567a     // Catch:{ NoSuchFieldError -> 0x002e }
                com.ktakilat.loan.http.user.OtpTypeEnum r1 = com.ktakilat.loan.http.user.OtpTypeEnum.WA     // Catch:{ NoSuchFieldError -> 0x002e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity.AnonymousClass4.<clinit>():void");
        }
    }

    public static Intent I(Activity activity, Class cls, String str, int i, ArrayList arrayList) {
        Intent intent = new Intent(activity, cls);
        intent.putExtra("mobile", str);
        intent.putExtra("scence", i);
        intent.putIntegerArrayListExtra("methodList", arrayList);
        return intent;
    }

    public final boolean B() {
        return this.o.contains(Integer.valueOf(VerifyType.OTP.type));
    }

    public abstract void F();

    public abstract void G(int i);

    public abstract void H(boolean z);

    public abstract PhoneCodeType J();

    public final String K() {
        int intExtra = getIntent().getIntExtra("scence", -1);
        return intExtra + "";
    }

    public abstract String L();

    public final void M(Intent intent) {
        P(intent);
        this.m = intent.getStringExtra("mobile");
        this.n = intent.getIntExtra("scence", 0);
        this.o = getIntent().getIntegerArrayListExtra("methodList");
        this.q.getCodePhone.setText(PhoneValidator.a(this.m));
        KtaCollect.n_otp_verification_page_exposure(K());
        ArrayList arrayList = this.o;
        if (arrayList == null || arrayList.size() <= 1) {
            this.q.moreTv.setVisibility(8);
        } else {
            this.q.moreTv.setVisibility(0);
        }
        T();
        BaseVerifyOtpSms baseVerifyOtpSms = s;
        String str = this.m;
        baseVerifyOtpSms.getClass();
        boolean equals = str.equals(BaseVerifyOtpSms.e);
        PhoneCodeUtil phoneCodeUtil = baseVerifyOtpSms.b;
        if (equals) {
            int max = Math.max(BaseVerifyOtpSms.c - ((int) ((System.currentTimeMillis() - BaseVerifyOtpSms.d) / 1000)), 0);
            if ((BaseVerifyOtpSms.d != 0 || BaseVerifyOtpSms.c == 0) && max > 0) {
                phoneCodeUtil.f = BaseVerifyOtpSms.f;
                phoneCodeUtil.e = true;
                phoneCodeUtil.c(max);
            }
        } else {
            BaseVerifyOtpSms.d = 0;
            BaseVerifyOtpSms.c = 0;
            BaseVerifyOtpSms.e = str;
            BaseVerifyOtpSms.f = null;
            phoneCodeUtil.e();
        }
        this.q.changeAnotherOtp.setVisibility(8);
        N();
    }

    public final void N() {
        OtpTypeEnum otpTypeEnum;
        if (!s.b.e || (otpTypeEnum = v) == null) {
            R((OtpTypeEnum) null);
            this.q.changeAnotherOtp.setVisibility(8);
            z0 z0Var = new z0(this, 1);
            a aVar = new a(this, 2);
            Intrinsics.checkNotNullParameter(this, "bAct");
            Intrinsics.checkNotNullParameter(z0Var, "onSuccess");
            Intrinsics.checkNotNullParameter(aVar, "onFailed");
            n();
            AppHttp.getOtpSendType().subscribe(new OtpUtil$Companion$getOtpType$1(this, z0Var, aVar));
            return;
        }
        R(otpTypeEnum);
    }

    public abstract void O(String str);

    public abstract void P(Intent intent);

    public abstract void Q();

    public final void R(OtpTypeEnum otpTypeEnum) {
        v = otpTypeEnum;
        if (otpTypeEnum == null) {
            this.q.tip2Tv.setVisibility(4);
            return;
        }
        this.q.tip2Tv.setVisibility(0);
        int i = AnonymousClass4.f567a[otpTypeEnum.ordinal()];
        if (i == 1) {
            SpannableString spannableString = new SpannableString("Demi keamanan akun Anda, kami perlu melakukan verifikasi keamanan. Kode verifikasi telah dikirim ke SMS Anda");
            spannableString.setSpan(new StyleSpan(1), 99, 104, 17);
            this.q.tip2Tv.setText(spannableString);
        } else if (i == 2) {
            SpannableString spannableString2 = new SpannableString("Demi keamanan akun Anda, kami perlu melakukan verifikasi keamanan. Kode verifikasi telah dikirim ke WhatsApp Anda");
            spannableString2.setSpan(new StyleSpan(1), 99, 109, 17);
            this.q.tip2Tv.setText(spannableString2);
        }
    }

    public abstract void S();

    public abstract void T();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void distributeEvent(EventVerifyMethodUpdate eventVerifyMethodUpdate) {
        if (s()) {
            ArrayList arrayList = eventVerifyMethodUpdate.f559a;
            this.o = arrayList;
            if (arrayList == null || arrayList.size() <= 1) {
                this.q.moreTv.setVisibility(8);
            } else {
                this.q.moreTv.setVisibility(0);
            }
        }
    }

    public void onClick(View view) {
        if (FastClickUtil.a(view)) {
            switch (view.getId()) {
                case R.id.backward:
                    KtaCollect.n_otp_verification_page_click(K(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    F();
                    finish();
                    return;
                case R.id.code_edit:
                    H(true);
                    return;
                case R.id.commit_button:
                    final String obj = this.q.codeEdit.getText().toString();
                    final String str = s.b.f;
                    Q();
                    y();
                    GpsUtil.b(this, new GpsUtil.GpsIgnoreCallback() {
                        public final void a(double d, double d2) {
                            ActivityEvent activityEvent = ActivityEvent.DESTROY;
                            BaseVerifyOtpActivity baseVerifyOtpActivity = BaseVerifyOtpActivity.this;
                            AppHttp.commonFirstVerifyByOtp(RxLifecycle.a(baseVerifyOtpActivity.c, activityEvent), str, obj, baseVerifyOtpActivity.n, d, d2).subscribe(new ApiObserver<BaseResponse<VerifyOtpResp>>() {
                                public final void a(BaseResponse baseResponse) {
                                    AnonymousClass3 r0 = AnonymousClass3.this;
                                    BaseVerifyOtpActivity baseVerifyOtpActivity = BaseVerifyOtpActivity.this;
                                    BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                                    baseVerifyOtpActivity.o();
                                    ResponseCodeDeal.a(baseResponse);
                                    KtaCollect.n_otp_verification_page_result(BaseVerifyOtpActivity.this.K(), ExifInterface.GPS_MEASUREMENT_2D);
                                }

                                public final void b(BaseResponse baseResponse) {
                                    AnonymousClass3 r0 = AnonymousClass3.this;
                                    BaseVerifyOtpActivity baseVerifyOtpActivity = BaseVerifyOtpActivity.this;
                                    BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                                    baseVerifyOtpActivity.o();
                                    int result = ((VerifyOtpResp) baseResponse.getData()).getResult();
                                    BaseVerifyOtpActivity baseVerifyOtpActivity2 = BaseVerifyOtpActivity.this;
                                    if (result == 1) {
                                        KtaCollect.n_otp_verification_page_result(baseVerifyOtpActivity2.K(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                        baseVerifyOtpActivity2.E(((VerifyOtpResp) baseResponse.getData()).getSuccessfulValidationToken(), ((VerifyOtpResp) baseResponse.getData()).getAuthStatusList(), ((VerifyOtpResp) baseResponse.getData()).getLoginResp());
                                    } else if (((VerifyOtpResp) baseResponse.getData()).getResult() == 2) {
                                        KtaCollect.n_otp_verification_page_result(baseVerifyOtpActivity2.K(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                        baseVerifyOtpActivity2.D(((VerifyOtpResp) baseResponse.getData()).getTwoFactorVerificationToken(), ((VerifyOtpResp) baseResponse.getData()).getEktp());
                                    } else {
                                        KtaCollect.n_otp_verification_page_result(baseVerifyOtpActivity2.K(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                                    }
                                }
                            });
                        }
                    });
                    return;
                case R.id.more_tv:
                    KtaCollect.n_otp_verification_page_click(K(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    ArrayList arrayList = new ArrayList(1);
                    ArrayList arrayList2 = new ArrayList(1);
                    ArrayList arrayList3 = this.o;
                    VerifyType verifyType = VerifyType.FACE;
                    if (arrayList3.contains(Integer.valueOf(verifyType.type))) {
                        arrayList.add(verifyType);
                        arrayList2.add(getString(R.string.verity_face));
                    }
                    DialogUtils.k(this, (String[]) arrayList2.toArray(new String[arrayList2.size()]), getString(R.string.login_pwd_more_cancel), new a(this, arrayList));
                    return;
                case R.id.verify_resend_code_title:
                    G(this.p);
                    N();
                    KtaCollect.OTP_verification_page_click_resend(K());
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [com.ktakilat.loan.verify_otp.BaseVerifyOtpSms, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityBaseVerifyCodeBinding inflate = ActivityBaseVerifyCodeBinding.inflate(getLayoutInflater());
        this.q = inflate;
        setContentView((View) inflate.getRoot());
        try {
            int i = Build.VERSION.SDK_INT;
            BroadcastReceiver broadcastReceiver = this.r;
            if (i >= 33) {
                registerReceiver(broadcastReceiver, new IntentFilter("com.ktakilat.loan.WA_CODE_BROADCAST"), 4);
            } else {
                registerReceiver(broadcastReceiver, new IntentFilter("com.ktakilat.loan.WA_CODE_BROADCAST"));
            }
        } catch (Exception unused) {
        }
        ? obj = new Object();
        obj.f568a = this;
        obj.b = new PhoneCodeUtil(this, new PhoneCodeUtil.PhoneCodeCallback() {
            public final void a(
/*
Method generation error in method: com.ktakilat.loan.verify_otp.BaseVerifyOtpSms.1.a(int):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.verify_otp.BaseVerifyOtpSms.1.a(int):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void b(
/*
Method generation error in method: com.ktakilat.loan.verify_otp.BaseVerifyOtpSms.1.b():void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.verify_otp.BaseVerifyOtpSms.1.b():void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/

            public final void c(
/*
Method generation error in method: com.ktakilat.loan.verify_otp.BaseVerifyOtpSms.1.c(java.lang.String):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.verify_otp.BaseVerifyOtpSms.1.c(java.lang.String):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:640)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:429)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
        s = obj;
        this.q.pageTitle.title.setText(L());
        this.q.codeEdit.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int length = charSequence.length();
                BaseVerifyOtpActivity baseVerifyOtpActivity = BaseVerifyOtpActivity.this;
                if (length < 6) {
                    baseVerifyOtpActivity.q.commitButton.setEnabled(false);
                } else {
                    baseVerifyOtpActivity.q.commitButton.setEnabled(true);
                }
            }
        });
        this.q.codeEdit.setOnFocusChangeListener(new e1(this, 0));
        M(getIntent());
        KeybordUtils.c(this.q.codeEdit);
        this.q.pageTitle.backward.setOnClickListener(this);
        this.q.verifyResendCodeTitle.setOnClickListener(this);
        this.q.commitButton.setOnClickListener(this);
        this.q.codeEdit.setOnClickListener(this);
        this.q.moreTv.setOnClickListener(this);
        EventBus.b().i(this);
    }

    public final void onDestroy() {
        BaseVerifyOtpSms baseVerifyOtpSms = s;
        if (baseVerifyOtpSms != null) {
            PhoneCodeUtil phoneCodeUtil = baseVerifyOtpSms.b;
            if (!phoneCodeUtil.e) {
                v = null;
            }
            phoneCodeUtil.b();
            BaseVerifyOtpSms.d = System.currentTimeMillis();
        }
        EventBus.b().k(this);
        try {
            unregisterReceiver(this.r);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        M(intent);
    }

    public final void onPause() {
        super.onPause();
        PhoneCodeUtil phoneCodeUtil = s.b;
        phoneCodeUtil.getClass();
        boolean z = SmsVerificationService.e;
        SmsVerificationService.Companion.b(phoneCodeUtil.g);
    }

    public final void onResume() {
        super.onResume();
        s.b.d();
    }

    public final int r() {
        return WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars();
    }
}
