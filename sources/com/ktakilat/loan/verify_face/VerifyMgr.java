package com.ktakilat.loan.verify_face;

import android.app.Activity;
import android.content.Intent;
import com.google.logging.type.LogSeverity;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.verify.VerifyMethodResp;
import com.ktakilat.loan.verify_face.BaseVerifyFaceActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.CommonVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.LoanVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.ModifyPwdVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.SafeVerifyOtpActivity;
import com.trello.rxlifecycle2.LifecycleTransformer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class VerifyMgr {

    /* renamed from: com.ktakilat.loan.verify_face.VerifyMgr$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f562a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.ktakilat.loan.verify_face.VerifyScence[] r0 = com.ktakilat.loan.verify_face.VerifyScence.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f562a = r0
                com.ktakilat.loan.verify_face.VerifyScence r1 = com.ktakilat.loan.verify_face.VerifyScence.FORGOT_PWD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f562a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ktakilat.loan.verify_face.VerifyScence r1 = com.ktakilat.loan.verify_face.VerifyScence.CHANGE_PWD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f562a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ktakilat.loan.verify_face.VerifyScence r1 = com.ktakilat.loan.verify_face.VerifyScence.FORGOT_GESTURE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f562a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ktakilat.loan.verify_face.VerifyScence r1 = com.ktakilat.loan.verify_face.VerifyScence.CHANGE_GESTURE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f562a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.ktakilat.loan.verify_face.VerifyScence r1 = com.ktakilat.loan.verify_face.VerifyScence.SAFE_DEVICE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f562a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.ktakilat.loan.verify_face.VerifyScence r1 = com.ktakilat.loan.verify_face.VerifyScence.SAFE_PHONE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f562a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.ktakilat.loan.verify_face.VerifyScence r1 = com.ktakilat.loan.verify_face.VerifyScence.SAFE_LOAN     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.verify_face.VerifyMgr.AnonymousClass3.<clinit>():void");
        }
    }

    public static void a(Activity activity) {
        if (c(activity) && (activity instanceof BaseActivity)) {
            ((BaseActivity) activity).u();
        }
    }

    public static boolean b(Class cls) {
        ArrayList arrayList = KtakilatApplication.m.d;
        if (arrayList == null || arrayList.size() < 2 || ((Activity) ((WeakReference) arrayList.get(arrayList.size() - 2)).get()).getClass() != cls) {
            return false;
        }
        return true;
    }

    public static boolean c(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public static void d(int i, int i2, Activity activity, String str, List list) {
        Class<CommonVerifyOtpActivity> cls = CommonVerifyOtpActivity.class;
        if (b(cls)) {
            activity.finish();
            return;
        }
        int i3 = CommonVerifyOtpActivity.x;
        ArrayList arrayList = new ArrayList(list);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "mobile");
        Intrinsics.checkNotNullParameter(arrayList, "methodList");
        Intent I = BaseVerifyOtpActivity.I(activity, cls, str, i, arrayList);
        I.putExtra("SMS_TYPE", i2);
        activity.startActivityForResult(I, LogSeverity.EMERGENCY_VALUE);
    }

    public static void e(Activity activity, String str, int i, List list) {
        yg ygVar = new yg(activity, 3);
        if (b(LoanVerifyFaceActivity.class)) {
            activity.finish();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int i2 = LoanVerifyFaceActivity.t;
        BaseVerifyFaceActivity.K(activity, new BaseVerifyFaceActivity.PermissionCallback(activity, str, i, arrayList) {
            public final /* synthetic */ Activity b;
            public final /* synthetic */ String c;
            public final /* synthetic */ int d;
            public final /* synthetic */ ArrayList e;

            public final void c(
/*
Method generation error in method: com.ktakilat.loan.verify_face.LoanVerifyFaceActivity.1.c(boolean):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.verify_face.LoanVerifyFaceActivity.1.c(boolean):void, class status: UNLOADED
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
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
    }

    public static void f(int i, int i2, Activity activity, String str, List list) {
        yg ygVar = new yg(activity, 0);
        if (b(ModifyPwdVerifyFaceActivity.class)) {
            activity.finish();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int i3 = ModifyPwdVerifyFaceActivity.u;
        BaseVerifyFaceActivity.K(activity, new g(ygVar, activity, str, i, arrayList, i2));
    }

    public static void g(int i, int i2, Activity activity, String str, List list) {
        Class<ModifyPwdVerifyOtpActivity> cls = ModifyPwdVerifyOtpActivity.class;
        if (b(cls)) {
            activity.finish();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int i3 = ModifyPwdVerifyOtpActivity.x;
        Intent I = BaseVerifyOtpActivity.I(activity, cls, str, i, arrayList);
        I.putExtra("processType", i2);
        activity.startActivityForResult(I, LogSeverity.EMERGENCY_VALUE);
    }

    public static void h(Activity activity, String str, int i, List list, boolean z) {
        yg ygVar = new yg(activity, 1);
        if (b(SafeVerifyFaceActivity.class)) {
            activity.finish();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int i2 = SafeVerifyFaceActivity.u;
        BaseVerifyFaceActivity.K(activity, new BaseVerifyFaceActivity.PermissionCallback(activity, str, i, arrayList, z) {
            public final /* synthetic */ Activity b;
            public final /* synthetic */ String c;
            public final /* synthetic */ int d;
            public final /* synthetic */ ArrayList e;
            public final /* synthetic */ boolean f;

            public final void c(
/*
Method generation error in method: com.ktakilat.loan.verify_face.SafeVerifyFaceActivity.1.c(boolean):void, dex: classes3.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.verify_face.SafeVerifyFaceActivity.1.c(boolean):void, class status: UNLOADED
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
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
    }

    public static void i(Activity activity, String str, int i, List list, boolean z) {
        Class<SafeVerifyOtpActivity> cls = SafeVerifyOtpActivity.class;
        if (b(cls)) {
            activity.finish();
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        int i2 = SafeVerifyOtpActivity.x;
        Intent I = BaseVerifyOtpActivity.I(activity, cls, str, i, arrayList);
        I.putExtra("safe_device", z);
        activity.startActivityForResult(I, LogSeverity.EMERGENCY_VALUE);
    }

    public static void j(final Activity activity, final String str, final VerifyScence verifyScence) {
        if (c(activity)) {
            if (c(activity) && (activity instanceof BaseActivity)) {
                ((BaseActivity) activity).n();
            }
            AppHttp.commonVerifyByLoadMethod((LifecycleTransformer<BaseResponse<VerifyMethodResp>>) null, str, verifyScence.scence).subscribe(new ApiObserver<BaseResponse<VerifyMethodResp>>() {
                public final void a(BaseResponse baseResponse) {
                    Activity activity = activity;
                    if (VerifyMgr.c(activity)) {
                        VerifyMgr.a(activity);
                        ResponseCodeDeal.a(baseResponse);
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    Activity activity = activity;
                    if (VerifyMgr.c(activity)) {
                        VerifyMgr.a(activity);
                        List<Integer> availableMethods = ((VerifyMethodResp) baseResponse.getData()).getAvailableMethods();
                        if (availableMethods.isEmpty()) {
                            ToastUtil.d(activity, "Tidak ada metode verifikasi yang tersedia");
                            return;
                        }
                        int intValue = availableMethods.get(0).intValue();
                        int[] iArr = AnonymousClass3.f562a;
                        VerifyScence verifyScence = verifyScence;
                        int i = iArr[verifyScence.ordinal()];
                        Activity activity2 = activity;
                        String str = str;
                        switch (i) {
                            case 1:
                                VerifyMgr.l(activity2, str, verifyScence.scence, intValue, availableMethods, 101);
                                return;
                            case 2:
                                new ArrayList(1);
                                VerifyMgr.l(activity2, str, verifyScence.scence, intValue, availableMethods, 102);
                                return;
                            case 3:
                                VerifyMgr.l(activity2, str, verifyScence.scence, intValue, availableMethods, 103);
                                return;
                            case 4:
                                VerifyMgr.l(activity2, str, verifyScence.scence, intValue, availableMethods, 104);
                                return;
                            case 5:
                                int i2 = verifyScence.scence;
                                if (intValue == VerifyType.OTP.type) {
                                    VerifyMgr.i(activity2, str, i2, availableMethods, true);
                                    return;
                                } else if (intValue == VerifyType.FACE.type) {
                                    VerifyMgr.h(activity2, str, i2, availableMethods, true);
                                    return;
                                } else {
                                    return;
                                }
                            case 6:
                                int i3 = verifyScence.scence;
                                if (intValue == VerifyType.OTP.type) {
                                    VerifyMgr.i(activity2, str, i3, availableMethods, false);
                                    return;
                                } else if (intValue == VerifyType.FACE.type) {
                                    VerifyMgr.h(activity2, str, i3, availableMethods, false);
                                    return;
                                } else {
                                    return;
                                }
                            case 7:
                                int i4 = verifyScence.scence;
                                if (intValue == VerifyType.OTP.type) {
                                    Class<LoanVerifyOtpActivity> cls = LoanVerifyOtpActivity.class;
                                    if (VerifyMgr.b(cls)) {
                                        activity2.finish();
                                        return;
                                    }
                                    ArrayList arrayList = new ArrayList(availableMethods);
                                    int i5 = LoanVerifyOtpActivity.w;
                                    activity2.startActivityForResult(BaseVerifyOtpActivity.I(activity2, cls, str, i4, arrayList), LogSeverity.EMERGENCY_VALUE);
                                    return;
                                } else if (intValue == VerifyType.FACE.type) {
                                    VerifyMgr.e(activity2, str, i4, availableMethods);
                                    return;
                                } else {
                                    return;
                                }
                            default:
                                return;
                        }
                    }
                }
            });
        }
    }

    public static void k(final Activity activity, final String str, final Integer num, final Integer num2) {
        if (c(activity)) {
            if (c(activity) && (activity instanceof BaseActivity)) {
                ((BaseActivity) activity).n();
            }
            AppHttp.commonVerifyByLoadMethod((LifecycleTransformer<BaseResponse<VerifyMethodResp>>) null, str, num.intValue()).subscribe(new ApiObserver<BaseResponse<VerifyMethodResp>>() {
                public final void a(BaseResponse baseResponse) {
                    Activity activity = activity;
                    if (VerifyMgr.c(activity)) {
                        VerifyMgr.a(activity);
                        ResponseCodeDeal.a(baseResponse);
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    Activity activity = activity;
                    if (VerifyMgr.c(activity)) {
                        VerifyMgr.a(activity);
                        List<Integer> availableMethods = ((VerifyMethodResp) baseResponse.getData()).getAvailableMethods();
                        if (availableMethods.isEmpty()) {
                            ToastUtil.d(activity, "Tidak ada metode verifikasi yang tersedia");
                            return;
                        }
                        int intValue = availableMethods.get(0).intValue();
                        int intValue2 = num.intValue();
                        int intValue3 = num2.intValue();
                        int i = VerifyType.OTP.type;
                        Activity activity2 = activity;
                        String str = str;
                        if (intValue == i) {
                            VerifyMgr.d(intValue2, intValue3, activity2, str, availableMethods);
                        } else if (intValue != VerifyType.FACE.type) {
                        } else {
                            if (VerifyMgr.b(CommonVerifyFaceActivity.class)) {
                                activity2.finish();
                                return;
                            }
                            yg ygVar = new yg(activity2, 2);
                            if (VerifyMgr.b(ModifyPwdVerifyFaceActivity.class)) {
                                activity2.finish();
                                return;
                            }
                            int i2 = CommonVerifyFaceActivity.u;
                            ArrayList arrayList = new ArrayList(availableMethods);
                            Intrinsics.checkNotNullParameter(activity2, "activity");
                            Intrinsics.checkNotNullParameter(str, "mobile");
                            Intrinsics.checkNotNullParameter(arrayList, "methodList");
                            Intrinsics.checkNotNullParameter(ygVar, "callback");
                            BaseVerifyFaceActivity.K(activity2, new f3(ygVar, activity2, str, intValue2, arrayList, intValue3));
                        }
                    }
                }
            });
        }
    }

    public static void l(Activity activity, String str, int i, int i2, List list, int i3) {
        if (i2 == VerifyType.OTP.type) {
            g(i, i3, activity, str, list);
        } else if (i2 == VerifyType.FACE.type) {
            f(i, i3, activity, str, list);
        }
    }
}
