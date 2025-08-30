package com.ktakilat.loan.login_otp;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.utils.PhoneValidator;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.op_horse.OpHorseRaceType;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.http.user.OtpTypeResp;
import com.ktakilat.loan.login_face.BaseLoginActivity;
import com.ktakilat.loan.login_otp.LoginOtpContact;
import com.ktakilat.loan.mobile_check.HorseUtil;
import com.ktakilat.loan.service.sms.SmsVerificationService;
import com.ktakilat.loan.weiget.CommonPopUtil;
import com.ktakilat.loan.weiget.LoginUtil;
import com.ktakilat.loan.weiget.PhoneCodeUtil;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.ktakilat.loan.weiget.TongDunEnum;
import com.pendanaan.kta.databinding.CActivityLoginOtpBinding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.util.ArrayList;

@SuppressLint({"NonConstantResourceId"})
public class LoginOtpActivity extends BaseLoginActivity implements LoginOtpContact.View {
    public static boolean t = false;
    public static boolean u = false;
    public static OtpTypeEnum v;
    public LoginOtpPresenter n;
    public boolean o;
    public String p;
    public boolean q = false;
    public final BroadcastReceiver r = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("code");
                if (stringExtra != null) {
                    LoginOtpActivity.this.s.codeEt.setText(stringExtra);
                }
            } catch (Exception unused) {
            }
        }
    };
    public CActivityLoginOtpBinding s;

    /* renamed from: com.ktakilat.loan.login_otp.LoginOtpActivity$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f519a;

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
                f519a = r0
                com.ktakilat.loan.http.user.OtpTypeEnum r1 = com.ktakilat.loan.http.user.OtpTypeEnum.WA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f519a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ktakilat.loan.http.user.OtpTypeEnum r1 = com.ktakilat.loan.http.user.OtpTypeEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.login_otp.LoginOtpActivity.AnonymousClass4.<clinit>():void");
        }
    }

    public static void G(Context context, String str, boolean z) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, LoginOtpActivity.class);
            intent.putExtra("mobile", str);
            intent.putExtra("initSend", z);
            context.startActivity(intent);
        }
    }

    public final LifecycleTransformer C() {
        return RxLifecycle.a(this.c, ActivityEvent.DESTROY);
    }

    public final void D(Intent intent) {
        int i;
        String str;
        this.p = intent.getStringExtra("mobile");
        this.o = intent.getBooleanExtra("initSend", false);
        TextView textView = this.s.tip2Tv;
        if (!AppKv.f()) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        if (this.s.tip2Tv.getVisibility() == 0) {
            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        } else {
            str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        KtaCollect.n_login_otp_exposure(str);
        this.s.mobileTv.setText(PhoneValidator.a(this.p));
        LoginOtpPresenter loginOtpPresenter = this.n;
        String str2 = this.p;
        boolean z = this.o;
        loginOtpPresenter.getClass();
        boolean equals = str2.equals(LoginOtpPresenter.f);
        PhoneCodeUtil phoneCodeUtil = loginOtpPresenter.c;
        if (equals) {
            int max = Math.max(LoginOtpPresenter.d - ((int) ((System.currentTimeMillis() - LoginOtpPresenter.e) / 1000)), 0);
            if (LoginOtpPresenter.e != 0 || LoginOtpPresenter.d == 0) {
                if (max > 0) {
                    phoneCodeUtil.f = LoginOtpPresenter.g;
                    phoneCodeUtil.e = true;
                    phoneCodeUtil.c(max);
                } else if (!z) {
                    phoneCodeUtil.e();
                }
            }
        } else {
            LoginOtpPresenter.e = 0;
            LoginOtpPresenter.d = 0;
            LoginOtpPresenter.f = str2;
            LoginOtpPresenter.g = null;
            phoneCodeUtil.e();
        }
        new CommonPopUtil(this).b(CommonPopUtil.PageType.LoginOtp, (CommonPopUtil.CheckCallback) null);
    }

    public final void E() {
        OtpTypeEnum otpTypeEnum;
        if (!this.n.c.e || (otpTypeEnum = v) == null) {
            F((OtpTypeEnum) null);
            this.s.changeAnotherOtp.setVisibility(8);
            n();
            AppHttp.getOtpSendType().subscribe(new ApiObserver<BaseResponse<OtpTypeResp>>() {
                public final void a(BaseResponse baseResponse) {
                    LoginOtpActivity loginOtpActivity = LoginOtpActivity.this;
                    loginOtpActivity.u();
                    loginOtpActivity.F((OtpTypeEnum) null);
                    String msg = baseResponse.getMsg();
                    if (msg != null) {
                        ToastUtil.d(this, msg);
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    ArrayList arrayList = new ArrayList();
                    OtpTypeResp otpTypeResp = (OtpTypeResp) baseResponse.getData();
                    if (otpTypeResp != null) {
                        arrayList.addAll(otpTypeResp.methods);
                    }
                    boolean isEmpty = arrayList.isEmpty();
                    LoginOtpActivity loginOtpActivity = LoginOtpActivity.this;
                    if (isEmpty) {
                        LoginOtpPresenter loginOtpPresenter = loginOtpActivity.n;
                        String str = loginOtpActivity.p;
                        loginOtpPresenter.getClass();
                        loginOtpPresenter.c.a(str, PhoneCodeType.LOGIN, OtpTypeEnum.NORMAL);
                        return;
                    }
                    LoginOtpActivity.t = arrayList.contains("NORMAL");
                    LoginOtpActivity.u = arrayList.contains("WA");
                    loginOtpActivity.u();
                    loginOtpActivity.runOnUiThread(new b(this, this));
                }
            });
            return;
        }
        F(otpTypeEnum);
    }

    public final void F(OtpTypeEnum otpTypeEnum) {
        v = otpTypeEnum;
        if (otpTypeEnum == null) {
            this.s.tip2Tv.setVisibility(4);
            return;
        }
        this.s.tip2Tv.setVisibility(0);
        int i = AnonymousClass4.f519a[v.ordinal()];
        if (i == 1) {
            SpannableString spannableString = new SpannableString("Kode verifikasi sudah dikirimkan ke nomor Whatsapp diatas. Silahkan masukkan kode verifikasi anda.");
            spannableString.setSpan(new StyleSpan(1), 41, 51, 17);
            this.s.tip2Tv.setText(spannableString);
        } else if (i == 2) {
            SpannableString spannableString2 = new SpannableString("Kode verifikasi sudah dikirimkan ke nomor diatas via SMS, silahkan masukkan kode verifikasi anda.");
            spannableString2.setSpan(new StyleSpan(1), 52, 57, 17);
            this.s.tip2Tv.setText(spannableString2);
        }
    }

    public final void onBackPressed() {
        KtaCollect.n_login_otp_clc_back();
        super.onBackPressed();
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.Object, com.ktakilat.loan.login_otp.LoginOtpPresenter] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CActivityLoginOtpBinding inflate = CActivityLoginOtpBinding.inflate(getLayoutInflater());
        this.s = inflate;
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
        this.s.pageTitle.title.setText(R.string.application_name);
        ? obj = new Object();
        obj.f520a = this;
        obj.b = new LoginUtil(this);
        obj.c = new PhoneCodeUtil(this, new PhoneCodeUtil.PhoneCodeCallback() {
            public final void a(
/*
Method generation error in method: com.ktakilat.loan.login_otp.LoginOtpPresenter.1.a(int):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.login_otp.LoginOtpPresenter.1.a(int):void, class status: UNLOADED
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
Method generation error in method: com.ktakilat.loan.login_otp.LoginOtpPresenter.1.b():void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.login_otp.LoginOtpPresenter.1.b():void, class status: UNLOADED
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
Method generation error in method: com.ktakilat.loan.login_otp.LoginOtpPresenter.1.c(java.lang.String):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.login_otp.LoginOtpPresenter.1.c(java.lang.String):void, class status: UNLOADED
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
        this.n = obj;
        this.s.codeEt.setOnFocusChangeListener(new w9(3));
        this.s.codeEt.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                TextView textView = LoginOtpActivity.this.s.loginTv;
                if (charSequence.length() < 6) {
                    textView.setEnabled(false);
                } else {
                    textView.setEnabled(true);
                }
            }
        });
        D(getIntent());
        HorseUtil.b(this, OpHorseRaceType.VCJP, this.s.hourseTv);
        E();
        this.s.pageTitle.backward.setOnClickListener(new cc(this, 1));
        this.s.sendCodeTv.setOnClickListener(new cc(this, 2));
        this.s.loginTv.setOnClickListener(new cc(this, 3));
        this.s.moreTv.setOnClickListener(new c(this, 2));
        this.s.codeEt.setOnClickListener(new y9(4));
    }

    public final void onDestroy() {
        LoginOtpPresenter loginOtpPresenter = this.n;
        if (loginOtpPresenter != null) {
            PhoneCodeUtil phoneCodeUtil = loginOtpPresenter.c;
            if (!phoneCodeUtil.e) {
                v = null;
            }
            phoneCodeUtil.b();
            LoginOtpPresenter.e = System.currentTimeMillis();
        }
        try {
            unregisterReceiver(this.r);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        D(intent);
    }

    public final void onPause() {
        super.onPause();
        PhoneCodeUtil phoneCodeUtil = this.n.c;
        phoneCodeUtil.getClass();
        boolean z = SmsVerificationService.e;
        SmsVerificationService.Companion.b(phoneCodeUtil.g);
    }

    public final void onResume() {
        super.onResume();
        PhoneUploadUtil.a(TongDunEnum.USER_LOGIN_SUC);
        this.n.c.d();
    }

    public final int r() {
        return WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars();
    }
}
