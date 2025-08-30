package com.ktakilat.loan.regist_otp;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.places.model.PlaceFields;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.cbase.utils.BarUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.phone_code.PhoneCodeType;
import com.ktakilat.loan.http.user.AcountVerifyResp;
import com.ktakilat.loan.http.user.OtpTypeEnum;
import com.ktakilat.loan.http.user.OtpTypeResp;
import com.ktakilat.loan.main.EventHomeAct;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.new_pwd.NewPasswordActivity;
import com.ktakilat.loan.regist_otp.RegistOtpContact;
import com.ktakilat.loan.service.sms.SmsVerificationService;
import com.ktakilat.loan.utils.StatusBarTool;
import com.ktakilat.loan.weiget.CommonPopUtil;
import com.ktakilat.loan.weiget.GpsUtil;
import com.ktakilat.loan.weiget.LoginUtil;
import com.ktakilat.loan.weiget.PhoneCodeUtil;
import com.ktakilat.loan.weiget.PhoneUploadUtil;
import com.ktakilat.loan.weiget.TongDunEnum;
import com.pendanaan.kta.databinding.ActivityRegistOtpBinding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;

@SuppressLint({"NonConstantResourceId"})
public class RegistOtpActivity extends BaseActivity implements RegistOtpContact.View {
    public static int s = 0;
    public static boolean t = false;
    public static boolean u = false;
    public static OtpTypeEnum v;
    public RegistOtpPresenter i;
    public String j;
    public String k;
    public String l;
    public int m;
    public BaseDialog n;
    public double o;
    public double p;
    public final BroadcastReceiver q = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            try {
                String stringExtra = intent.getStringExtra("code");
                if (stringExtra != null) {
                    RegistOtpActivity.this.r.codeEdit.setText(stringExtra);
                }
            } catch (Exception unused) {
            }
        }
    };
    public ActivityRegistOtpBinding r;

    /* renamed from: com.ktakilat.loan.regist_otp.RegistOtpActivity$4  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f536a;

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
                f536a = r0
                com.ktakilat.loan.http.user.OtpTypeEnum r1 = com.ktakilat.loan.http.user.OtpTypeEnum.WA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f536a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ktakilat.loan.http.user.OtpTypeEnum r1 = com.ktakilat.loan.http.user.OtpTypeEnum.NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.regist_otp.RegistOtpActivity.AnonymousClass4.<clinit>():void");
        }
    }

    public final void A(Intent intent) {
        String str;
        KtaCollect.n_register_otp_page_exposure();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        this.r.codeEdit.setItemWidth(Math.round(((((float) displayMetrics.widthPixels) - (32.0f * f)) - ((f * 8.0f) * 5.0f)) / 6.0f));
        this.l = intent.getStringExtra("mobile");
        this.m = intent.getIntExtra("processRequestCode", 300);
        TextView textView = this.r.getCodePhone;
        String str2 = this.l;
        Intrinsics.checkNotNullParameter(str2, "mobile");
        if (str2.length() > 8) {
            try {
                Intrinsics.checkNotNullParameter(str2, "<this>");
                Intrinsics.checkNotNullParameter("******", "replacement");
                StringBuilder sb = new StringBuilder();
                sb.append(str2, 0, 2);
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                sb.append("******");
                sb.append(str2, 8, str2.length());
                Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                str = CollectionsKt.p(StringsKt.k(sb.toString()), StringUtils.SPACE, (String) null, (String) null, (Function1) null, 62);
            } catch (Exception unused) {
                str = str2;
            }
            str2 = e.B("+62 ", str);
        }
        textView.setText(str2);
        RegistOtpPresenter registOtpPresenter = this.i;
        String str3 = this.l;
        registOtpPresenter.getClass();
        boolean equals = str3.equals(RegistOtpPresenter.e);
        PhoneCodeUtil phoneCodeUtil = registOtpPresenter.f537a;
        if (equals) {
            int max = Math.max(RegistOtpPresenter.c - ((int) ((System.currentTimeMillis() - RegistOtpPresenter.d) / 1000)), 0);
            if ((RegistOtpPresenter.d != 0 || RegistOtpPresenter.c == 0) && max > 0) {
                phoneCodeUtil.f = RegistOtpPresenter.f;
                phoneCodeUtil.e = true;
                phoneCodeUtil.c(max);
            }
        } else {
            RegistOtpPresenter.d = 0;
            RegistOtpPresenter.c = 0;
            RegistOtpPresenter.e = str3;
            RegistOtpPresenter.f = null;
            phoneCodeUtil.e();
        }
        new CommonPopUtil(this).b(CommonPopUtil.PageType.Registration, (CommonPopUtil.CheckCallback) null);
    }

    public final void B() {
        OtpTypeEnum otpTypeEnum;
        if (!this.i.f537a.e || (otpTypeEnum = v) == null) {
            this.r.changeAnotherOtp.setVisibility(8);
            D((OtpTypeEnum) null);
            n();
            AppHttp.getOtpSendType().subscribe(new ApiObserver<BaseResponse<OtpTypeResp>>() {
                public final void a(BaseResponse baseResponse) {
                    RegistOtpActivity registOtpActivity = RegistOtpActivity.this;
                    registOtpActivity.u();
                    registOtpActivity.D((OtpTypeEnum) null);
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
                    RegistOtpActivity registOtpActivity = RegistOtpActivity.this;
                    if (isEmpty) {
                        RegistOtpPresenter registOtpPresenter = registOtpActivity.i;
                        String str = registOtpActivity.l;
                        registOtpPresenter.getClass();
                        registOtpPresenter.f537a.a(str, PhoneCodeType.REGISTER, OtpTypeEnum.NORMAL);
                        return;
                    }
                    RegistOtpActivity.t = arrayList.contains("NORMAL");
                    RegistOtpActivity.u = arrayList.contains("WA");
                    registOtpActivity.u();
                    registOtpActivity.runOnUiThread(new b(this, this));
                }
            });
            return;
        }
        D(otpTypeEnum);
    }

    public final void C(AcountVerifyResp acountVerifyResp) {
        this.j = acountVerifyResp.getToken();
        this.k = acountVerifyResp.getUserId();
        this.l = acountVerifyResp.getCodeDto().getMobileNo();
        DataCollectManager.d(this.k);
        BaseDialog baseDialog = this.n;
        if (baseDialog != null && baseDialog.isShowing()) {
            this.n.dismiss();
            this.n = null;
        }
        String str = this.j;
        Intrinsics.checkNotNullParameter(this, PlaceFields.CONTEXT);
        Intrinsics.checkNotNullParameter(str, "token");
        Intent intent = new Intent(this, NewPasswordActivity.class);
        intent.putExtra("token", str);
        startActivityForResult(intent, 2001);
    }

    public final void D(OtpTypeEnum otpTypeEnum) {
        v = otpTypeEnum;
        if (otpTypeEnum == null) {
            this.r.tip2Tv.setVisibility(4);
            return;
        }
        this.r.tip2Tv.setVisibility(0);
        int i2 = AnonymousClass4.f536a[v.ordinal()];
        if (i2 == 1) {
            SpannableString spannableString = new SpannableString("Kode verifikasi sudah dikirimkan ke nomor Whatsapp diatas. Silahkan masukkan kode verifikasi anda.");
            spannableString.setSpan(new StyleSpan(1), 41, 51, 17);
            spannableString.setSpan(new ForegroundColorSpan(-14541025), 41, 51, 17);
            this.r.tip2Tv.setText(spannableString);
        } else if (i2 == 2) {
            SpannableString spannableString2 = new SpannableString("Kode verifikasi sudah dikirimkan ke nomor diatas via SMS, silahkan masukkan kode verifikasi anda.");
            spannableString2.setSpan(new StyleSpan(1), 52, 57, 17);
            spannableString2.setSpan(new ForegroundColorSpan(-14541025), 52, 57, 17);
            this.r.tip2Tv.setText(spannableString2);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 2001) {
            KtakilatApplication ktakilatApplication = KtakilatApplication.m;
            String str = this.j;
            String str2 = this.k;
            String str3 = this.l;
            ud udVar = new ud(this);
            ktakilatApplication.getClass();
            KtakilatApplication.k(str, str2, str3, udVar);
        }
        if (i2 == 500) {
            HomeActivity.C(this, (String) null, false);
            EventBus.b().e(new EventHomeAct());
            finish();
        }
    }

    public final void onBackPressed() {
        KtaCollect.n_register_otp_page_clc_back();
        super.onBackPressed();
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [java.lang.Object, com.ktakilat.loan.regist_otp.RegistOtpPresenter] */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityRegistOtpBinding inflate = ActivityRegistOtpBinding.inflate(getLayoutInflater());
        this.r = inflate;
        setContentView((View) inflate.getRoot());
        try {
            int i2 = Build.VERSION.SDK_INT;
            BroadcastReceiver broadcastReceiver = this.q;
            if (i2 >= 33) {
                registerReceiver(broadcastReceiver, new IntentFilter("com.ktakilat.loan.WA_CODE_BROADCAST"), 4);
            } else {
                registerReceiver(broadcastReceiver, new IntentFilter("com.ktakilat.loan.WA_CODE_BROADCAST"));
            }
        } catch (Exception unused) {
        }
        this.r.pageTitle.title.setText(R.string.verification);
        ? obj = new Object();
        obj.b = this;
        new LoginUtil(this);
        obj.f537a = new PhoneCodeUtil(this, new PhoneCodeUtil.PhoneCodeCallback() {
            public final void a(
/*
Method generation error in method: com.ktakilat.loan.regist_otp.RegistOtpPresenter.1.a(int):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.regist_otp.RegistOtpPresenter.1.a(int):void, class status: UNLOADED
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
Method generation error in method: com.ktakilat.loan.regist_otp.RegistOtpPresenter.1.b():void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.regist_otp.RegistOtpPresenter.1.b():void, class status: UNLOADED
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
Method generation error in method: com.ktakilat.loan.regist_otp.RegistOtpPresenter.1.c(java.lang.String):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.regist_otp.RegistOtpPresenter.1.c(java.lang.String):void, class status: UNLOADED
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
        this.i = obj;
        this.r.codeEdit.setOnFocusChangeListener(new w9(7));
        this.r.codeEdit.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int length = charSequence.length();
                RegistOtpActivity registOtpActivity = RegistOtpActivity.this;
                if (length < 6) {
                    registOtpActivity.r.commitButton.setEnabled(false);
                    return;
                }
                registOtpActivity.r.commitButton.setEnabled(true);
                KtaCollect.n_register_otp_page_clc_continue();
                GpsUtil.b(registOtpActivity, new a(registOtpActivity));
            }
        });
        this.r.pageTitle.backward.setOnClickListener(new td(this, 1));
        this.r.verifyResendCodeTitle.setOnClickListener(new td(this, 2));
        this.r.commitButton.setOnClickListener(new td(this, 3));
        this.r.codeEdit.setOnClickListener(new y9(8));
        A(getIntent());
        B();
        StatusBarTool.Companion.a(getWindow(), this.r.getRoot());
    }

    public final void onDestroy() {
        RegistOtpPresenter registOtpPresenter = this.i;
        if (registOtpPresenter != null) {
            PhoneCodeUtil phoneCodeUtil = registOtpPresenter.f537a;
            if (!phoneCodeUtil.e) {
                v = null;
            }
            phoneCodeUtil.b();
            RegistOtpPresenter.d = System.currentTimeMillis();
        }
        try {
            unregisterReceiver(this.q);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        A(intent);
    }

    public final void onPause() {
        super.onPause();
        PhoneCodeUtil phoneCodeUtil = this.i.f537a;
        phoneCodeUtil.getClass();
        boolean z = SmsVerificationService.e;
        SmsVerificationService.Companion.b(phoneCodeUtil.g);
    }

    public final void onResume() {
        super.onResume();
        this.i.f537a.d();
        PhoneUploadUtil.a(TongDunEnum.USER_REGISTER_SUC);
    }

    public final int r() {
        return WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.navigationBars();
    }

    public final void v() {
        BarUtil.a(this, R.drawable.scaffold_white);
    }

    public final LifecycleTransformer z() {
        return RxLifecycle.a(this.c, ActivityEvent.DESTROY);
    }
}
