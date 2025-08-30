package com.ktakilat.loan.launch;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import coil3.Extras;
import coil3.ImageLoader;
import coil3.SingletonImageLoader;
import coil3.request.ImageRequest;
import coil3.request.ImageRequestsKt;
import coil3.request.ImageRequests_androidKt;
import coil3.target.ImageViewTarget;
import coil3.transition.CrossfadeTransition;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.datacollect.KtaEvent;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.cbase.utils.DeviceUtils;
import com.ktakilat.cbase.utils.UnitUtils;
import com.ktakilat.cbase.utils.location.LocationUtils;
import com.ktakilat.cbase.weight.DanaDialog;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.global.H5Kv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.operation.SplashItem;
import com.ktakilat.loan.launch.LauncherContact;
import com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil;
import com.ktakilat.loan.weiget.AdvertisingIdUtils;
import com.ktakilat.loan.weiget.CommonPopUtil;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.ktakilat.loan.weiget.GestureUtil;
import com.ktakilat.loan.weiget.GpsUtil;
import com.ktakilat.loan.weiget.LoginUtil;
import com.ktakilat.loan.weiget.VersionUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import com.ktakilat.loan.weiget.g;
import com.pendanaan.kta.databinding.ActivityLaunchLauncherBinding;
import com.pendanaan.kta.databinding.CWidgetPrivateDialogBinding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trustdecision.mobrisk.TDRisk;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@SuppressLint({"NonConstantResourceId"})
public class LauncherActivity extends BaseActivity implements LauncherContact.View {
    public static final /* synthetic */ int q = 0;
    public LauncherPresenter i;
    public ValueAnimator j;
    public CommonPopUtil k;
    public int l = 0;
    public int m = 0;
    public volatile boolean n;
    public final Handler o;
    public ActivityLaunchLauncherBinding p;

    /* renamed from: com.ktakilat.loan.launch.LauncherActivity$1  reason: invalid class name */
    class AnonymousClass1 extends Subscriber<Boolean> {
        public final void onCompleted() {
        }

        public final void onError(Throwable th) {
        }

        public final /* bridge */ /* synthetic */ void onNext(Object obj) {
            Boolean bool = (Boolean) obj;
        }
    }

    public LauncherActivity() {
        new ArrayList(0);
        this.n = false;
        this.o = new Handler(Looper.getMainLooper());
    }

    public final void A() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            this.p.ignoreLayout.setVisibility(0);
            int i2 = this.l;
            if (i2 <= 0 || i2 > 10) {
                this.l = 3;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
            this.j = ofInt;
            ofInt.addUpdateListener(new q5(this, 1));
            this.j.setRepeatCount(0);
            this.j.setDuration(((long) this.l) * 1000);
            this.j.start();
        }
    }

    public final void B() {
        TDRisk.setOnErrorCodeListener(new t9(new t9(5)));
        TDRisk.Builder builder = new TDRisk.Builder();
        builder.disableDebugger().partnerCode("Kilat_id").appName("kilat_and").appKey("ef494b7ac2898cee08a2062630f9d763").country(TDRisk.COUNTRY_IDNA);
        TDRisk.initWithOptions((Context) this, builder);
        TDRisk.getBlackBox(new t9(19));
    }

    public final void C(String str) {
        Extras.Builder builder;
        if (s()) {
            if (!TextUtils.isEmpty(str)) {
                ImageView imageView = this.p.splashSrc;
                Intrinsics.checkNotNullParameter(imageView, "iv");
                Intrinsics.checkNotNullParameter(str, "data");
                ImageLoader a2 = SingletonImageLoader.a(imageView.getContext());
                ImageRequest.Builder builder2 = new ImageRequest.Builder(imageView.getContext());
                builder2.c = str;
                Extras.Key key = ImageRequests_androidKt.f142a;
                builder2.d = new ImageViewTarget(imageView);
                Extras.Key key2 = ImageRequestsKt.f141a;
                CrossfadeTransition.Factory factory = new CrossfadeTransition.Factory(200);
                Object obj = builder2.m;
                if (obj instanceof Extras.Builder) {
                    builder = (Extras.Builder) obj;
                } else if (obj instanceof Extras) {
                    Extras extras = (Extras) obj;
                    extras.getClass();
                    Extras.Builder builder3 = new Extras.Builder(extras);
                    builder2.m = builder3;
                    builder = builder3;
                } else {
                    throw new AssertionError();
                }
                builder.b(ImageRequests_androidKt.b, factory);
                a2.a(builder2.a());
            }
            n();
            AnonymousClass5 r5 = new Runnable() {
                public final void run() {
                    LauncherActivity launcherActivity = LauncherActivity.this;
                    if (launcherActivity.s()) {
                        launcherActivity.o();
                        if (launcherActivity.k == null) {
                            CommonPopUtil commonPopUtil = new CommonPopUtil(launcherActivity);
                            launcherActivity.k = commonPopUtil;
                            commonPopUtil.b(CommonPopUtil.PageType.OpenScreen, new CommonPopUtil.CheckCallback() {
                                public final void a(int i) {
                                    AnonymousClass5 r0 = AnonymousClass5.this;
                                    if (LauncherActivity.this.s() && i == 0) {
                                        LauncherActivity.this.A();
                                    }
                                }
                            });
                        }
                    }
                }
            };
            DanaDialog danaDialog = VersionUtil.f600a;
            if (danaDialog == null || !danaDialog.isShowing()) {
                VersionUtil.a(r5, new u4(r5));
            }
        }
    }

    /* JADX WARNING: type inference failed for: r9v13, types: [java.lang.Object, com.ktakilat.loan.launch.LauncherPresenter] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.ktakilat.cbase.utils.Debouncer, java.lang.Object] */
    public final void onCreate(Bundle bundle) {
        H5Kv.a().f465a.clearAll();
        BaseApplication.f = Boolean.FALSE;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(1280);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(1280);
        }
        ActivityLaunchLauncherBinding inflate = ActivityLaunchLauncherBinding.inflate(getLayoutInflater());
        this.p = inflate;
        setContentView((View) inflate.getRoot());
        KtaCollect.n_splash_exposure();
        Locale locale = getResources().getConfiguration().locale;
        if (locale != null) {
            locale.getLanguage();
        }
        Locale locale2 = getResources().getConfiguration().locale;
        if (locale2 != null) {
            locale2.getCountry();
        }
        this.p.ignoreProgress.setIndeterminate(false);
        ? obj = new Object();
        obj.f506a = this;
        obj.b = new GestureUtil((Activity) this);
        obj.c = new LoginUtil(this);
        this.i = obj;
        if (AppKv.g().f465a.getBoolean("isCanUse", false)) {
            z();
            B();
        } else {
            mb mbVar = new mb(this, 0);
            mb mbVar2 = new mb(this, 1);
            KtaEvent.Companion.b("n_gg_permission_pop_expose", (Bundle) null);
            BaseDialog baseDialog = new BaseDialog(this, R.style.common_dialog);
            CWidgetPrivateDialogBinding inflate2 = CWidgetPrivateDialogBinding.inflate(LayoutInflater.from(this));
            baseDialog.setCancelable(true);
            baseDialog.setCanceledOnTouchOutside(true);
            baseDialog.show();
            Window window = baseDialog.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 17;
                attributes.width = ((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() - UnitUtils.a(this);
                attributes.height = ((WindowManager) getSystemService("window")).getDefaultDisplay().getHeight() - UnitUtils.a(this);
                baseDialog.getWindow().setAttributes(attributes);
                baseDialog.setContentView(inflate2.getRoot());
                baseDialog.setCancelable(false);
                inflate2.scrollView.getViewTreeObserver().addOnScrollChangedListener(new n5(new Object()));
                inflate2.cancel.setOnClickListener(new l5((View.OnClickListener) mbVar, baseDialog, 1));
                inflate2.ok.setOnClickListener(new l5((View.OnClickListener) mbVar2, baseDialog, 2));
            }
        }
        this.o.postDelayed(new v(6), 200);
    }

    public final void onDestroy() {
        ValueAnimator valueAnimator = this.j;
        if (valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                this.j.cancel();
            }
            this.j = null;
        }
        LauncherPresenter launcherPresenter = this.i;
        if (launcherPresenter != null) {
            launcherPresenter.getClass();
        }
        super.onDestroy();
    }

    public final void onResume() {
        super.onResume();
        if (AppKv.g().f465a.getBoolean("isCanUse", false)) {
            z();
            if (this.k != null) {
                A();
            }
        }
    }

    public final void z() {
        Observable.create(new Observable.OnSubscribe<Boolean>() {
            public final void call(Object obj) {
                Subscriber subscriber = (Subscriber) obj;
                if (AdvertisingIdUtils.a(LauncherActivity.this) && !LauncherActivity.this.n) {
                    LauncherActivity.this.n = true;
                    final String a2 = DeviceUtils.a(LauncherActivity.this);
                    LauncherActivity.this.runOnUiThread(new Runnable() {
                        public final void run() {
                            AnonymousClass2 r0 = AnonymousClass2.this;
                            if (!LauncherActivity.this.isDestroyed()) {
                                LauncherActivity launcherActivity = LauncherActivity.this;
                                if (!launcherActivity.isFinishing()) {
                                    KtakilatApplication.g(a2);
                                    launcherActivity.getClass();
                                    ChangeMobileAndForgotPwdTmpLoginUtil.a();
                                    GpsUtil.b(launcherActivity, new b(launcherActivity));
                                    WebCookieManager.a(new WebCookieManager.CookieCallback() {
                                        /* JADX WARNING: type inference failed for: r2v3, types: [io.reactivex.Observer, java.lang.Object] */
                                        public final void d() {
                                            LauncherActivity launcherActivity = LauncherActivity.this;
                                            if (!launcherActivity.isDestroyed() && !launcherActivity.isFinishing()) {
                                                launcherActivity.i.getClass();
                                                if (AppKv.g().f465a.getBoolean("getFirstRun5.3.4", true)) {
                                                    AppKv.g().f465a.putBoolean("getFirstRun5.3.4", false);
                                                }
                                                launcherActivity.C(AppKv.g().f465a.getString("luncherImg", (String) null));
                                                LauncherPresenter launcherPresenter = launcherActivity.i;
                                                launcherPresenter.getClass();
                                                AppHttp.getOpSplashList((LifecycleTransformer<BaseResponse<SplashItem>>) null).subscribe(new ApiObserver<BaseResponse<SplashItem>>() {
                                                    /*  JADX ERROR: Method generation error
                                                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.a(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
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
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    /*  JADX ERROR: Method generation error: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.a(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
                                                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.a(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
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
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    public final void a(
/*
Method generation error in method: com.ktakilat.loan.launch.LauncherPresenter.1.a(com.ktakilat.cbase.http.BaseResponse):void, dex: classes3.dex
                                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.a(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
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

                                                    /*  JADX ERROR: Method generation error
                                                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.b(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
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
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    /*  JADX ERROR: Method generation error: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.b(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
                                                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.b(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
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
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
Method generation error in method: com.ktakilat.loan.launch.LauncherPresenter.1.b(com.ktakilat.cbase.http.BaseResponse):void, dex: classes3.dex
                                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.ktakilat.loan.launch.LauncherPresenter.1.b(com.ktakilat.cbase.http.BaseResponse):void, class status: UNLOADED
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:91)
                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:697)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
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
                                                AppHttp.getNewPwdTip((LifecycleTransformer<BaseResponse<String>>) null).subscribe(new Object());
                                                FaceLoginOnOffUtil.m((FaceLoginOnOffUtil.ScenceCall) null);
                                                launcherPresenter.b.i((g) null);
                                            }
                                        }
                                    });
                                    try {
                                        if (ContextCompat.checkSelfPermission(launcherActivity, "android.permission.ACCESS_COARSE_LOCATION") != -1 && LocationUtils.b(launcherActivity).isEmpty()) {
                                            LocationManager locationManager = (LocationManager) launcherActivity.getSystemService("location");
                                            if (locationManager != null) {
                                                for (String requestSingleUpdate : locationManager.getProviders(true)) {
                                                    locationManager.requestSingleUpdate(requestSingleUpdate, new a(launcherActivity), (Looper) null);
                                                }
                                            }
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                        }
                    });
                    subscriber.onNext(Boolean.TRUE);
                }
                subscriber.onNext(Boolean.FALSE);
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber());
    }
}
