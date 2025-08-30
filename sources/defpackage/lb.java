package defpackage;

import android.animation.Animator;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import androidx.activity.result.ActivityResultCallback;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.video.Recorder;
import androidx.camera.view.PreviewView;
import androidx.camera.view.impl.ZoomGestureDetector;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.search.SearchBar;
import com.google.firebase.crashlytics.internal.CrashlyticsRemoteConfigListener;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.device.DeviceUtil;
import com.ktakilat.loan.login_gesture.LoginGestureActivity;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.service.sms.SmsVerificationService;
import com.ktakilat.loan.service.sms.SmsVerifyCodeReceiver;
import com.ktakilat.loan.verify_face.SafeVerifyFaceActivity;
import com.ktakilat.loan.verify_face.VerifyMgr;
import com.ktakilat.loan.verify_face.VerifyScence;
import com.ktakilat.loan.verify_otp.SafeVerifyOtpActivity;
import com.ktakilat.loan.weiget.PhoneCodeUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.lang.ref.WeakReference;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.lang3.reflect.Typed;

/* renamed from: lb  reason: default package */
public final /* synthetic */ class lb implements ResponseCodeDeal.ResponseCodeCall, CallbackToFutureAdapter.Resolver, ActivityResultCallback, OnItemLongClickListener, DialogUtils.CommonOkClickListern, CanvasCompat.CanvasOperation, OnSuccessListener, FailableBiConsumer, SmsVerifyCodeReceiver.CallBack, ObservableOnSubscribe, ZoomGestureDetector.OnZoomGestureListener, SurfaceRequest.TransformationInfoListener, Deferred.DeferredHandler, AccessibilityManagerCompat.TouchExplorationStateChangeListener, AnimatableView.Listener, Continuation, OnFailureListener, Interpolator, Typed, SynchronizationGuard.CriticalSection, EventListener.Factory {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ lb(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public void a(String str) {
        PhoneCodeUtil.PhoneCodeCallback phoneCodeCallback = ((PhoneCodeUtil) this.d).h;
        if (phoneCodeCallback != null) {
            phoneCodeCallback.c(str);
        }
    }

    public void accept(Object obj, Object obj2) {
        Long l = (Long) obj;
        switch (this.c) {
            case 9:
                this.d.wait(l.longValue(), ((Integer) obj2).intValue());
                return;
            default:
                ((Thread) this.d).join(l.longValue(), ((Integer) obj2).intValue());
                return;
        }
    }

    public /* synthetic */ FailableBiConsumer andThen(FailableBiConsumer failableBiConsumer) {
        int i = this.c;
        return i7.a(this, failableBiConsumer);
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return ((LiveDataObservable) this.d).lambda$fetchData$1(completer);
    }

    public void b() {
        int i = LoginGestureActivity.s;
        LoginGestureActivity loginGestureActivity = (LoginGestureActivity) this.d;
        if (!loginGestureActivity.isDestroyed() && !loginGestureActivity.isFinishing()) {
            loginGestureActivity.r.moreTv.performClick();
        }
    }

    public void c(BaseQuickAdapter baseQuickAdapter, int i) {
        ArrayList arrayList = LogActivity.k;
        LogActivity logActivity = (LogActivity) this.d;
        ((ClipboardManager) logActivity.getApplicationContext().getSystemService("clipboard")).setText((CharSequence) logActivity.i.f179a.get(i));
        ToastUtil.d(logActivity, "copy success");
    }

    public EventListener create(Call call) {
        return Util.asFactory$lambda$8((EventListener) this.d, call);
    }

    public void d(ObservableEmitter observableEmitter) {
        String a2 = JsonUtil.a(DeviceUtil.a((Context) this.d));
        if (a2 == null || TextUtils.isEmpty(a2)) {
            observableEmitter.onNext("");
        } else {
            observableEmitter.onNext(a2);
        }
        observableEmitter.onComplete();
    }

    public boolean e(String str) {
        InstallReferrerClient installReferrerClient = KtakilatApplication.j;
        KtakilatApplication ktakilatApplication = (KtakilatApplication) this.d;
        ktakilatApplication.getClass();
        if (str.equals("A000006")) {
            ktakilatApplication.i();
            return true;
        } else if (!str.equals("A000293") || KtakilatApplication.f() == null || TextUtils.isEmpty(KtakilatApplication.f().getMobileNo())) {
            return true;
        } else {
            String mobileNo = KtakilatApplication.f().getMobileNo();
            ArrayList arrayList = ktakilatApplication.d;
            if (arrayList != null && arrayList.size() > 0 && !(((WeakReference) arrayList.get(arrayList.size() - 1)).get() instanceof SafeVerifyFaceActivity) && !(((WeakReference) arrayList.get(arrayList.size() - 1)).get() instanceof SafeVerifyOtpActivity)) {
                VerifyMgr.j((Activity) ((WeakReference) arrayList.get(arrayList.size() - 1)).get(), mobileNo, VerifyScence.SAFE_DEVICE);
            }
            return false;
        }
    }

    public Object execute() {
        switch (this.c) {
            case 23:
                return Integer.valueOf(((EventStore) this.d).cleanUp());
            case 24:
                return ((ClientHealthMetricsStore) this.d).loadClientMetrics();
            case 25:
                return ((Uploader) this.d).lambda$logAndUpdateState$6();
            default:
                return ((WorkInitializer) this.d).lambda$ensureContextsScheduled$0();
        }
    }

    public float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0((String) this.d, f);
    }

    public Type getType() {
        return TypeUtils.lambda$wrap$0((Type) this.d);
    }

    public void handle(Provider provider) {
        RemoteConfigDeferredProxy.lambda$setupListener$0((CrashlyticsRemoteConfigListener) this.d, provider);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|4|5|6|7|8|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0035 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.d
            int r1 = r4.c
            switch(r1) {
                case 2: goto L_0x003f;
                default: goto L_0x0007;
            }
        L_0x0007:
            com.ktakilat.loan.mobile_check.MobileCheckV2Activity r0 = (com.ktakilat.loan.mobile_check.MobileCheckV2Activity) r0
            androidx.activity.result.ActivityResult r5 = (androidx.activity.result.ActivityResult) r5
            int r1 = com.ktakilat.loan.mobile_check.MobileCheckV2Activity.g
            java.lang.String r1 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            com.google.android.gms.auth.api.identity.SignInClient r1 = com.google.android.gms.auth.api.identity.Identity.getSignInClient((android.app.Activity) r0)     // Catch:{ Exception -> 0x003e }
            android.content.Intent r5 = r5.getData()     // Catch:{ Exception -> 0x003e }
            java.lang.String r5 = r1.getPhoneNumberFromIntent(r5)     // Catch:{ Exception -> 0x003e }
            java.lang.String r1 = "getPhoneNumberFromIntent(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)     // Catch:{ Exception -> 0x003e }
            com.google.i18n.phonenumbers.PhoneNumberUtil r1 = com.google.i18n.phonenumbers.PhoneNumberUtil.c()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r2 = "ID"
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r1 = r1.j(r5, r2)     // Catch:{ Exception -> 0x0035 }
            long r1 = r1.getNationalNumber()     // Catch:{ Exception -> 0x0035 }
            java.lang.String r5 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0035 }
        L_0x0035:
            com.pendanaan.kta.databinding.ActivityMobileCheckV2Binding r0 = r0.n()     // Catch:{ Exception -> 0x003e }
            com.ktakilat.loan.mobile_check.MobileCheckEditText r0 = r0.editText     // Catch:{ Exception -> 0x003e }
            r0.setText(r5)     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            return
        L_0x003f:
            androidx.activity.result.ActivityResult r5 = (androidx.activity.result.ActivityResult) r5
            int r1 = com.ktakilat.loan.normal_ui.LivenessGuideActivity.e
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            android.content.Intent r1 = new android.content.Intent
            r1.<init>()
            android.content.Intent r2 = r5.getData()
            java.lang.String r3 = "self-result"
            if (r2 == 0) goto L_0x005a
            android.os.Bundle r2 = r2.getBundleExtra(r3)
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            com.ktakilat.loan.normal_ui.LivenessGuideActivity r0 = (com.ktakilat.loan.normal_ui.LivenessGuideActivity) r0
            if (r2 == 0) goto L_0x0066
            r1.putExtra(r3, r2)
            r2 = -1
            r0.setResult(r2, r1)
        L_0x0066:
            int r5 = r5.getResultCode()
            if (r5 != 0) goto L_0x0070
            r5 = 0
            r0.setResult(r5)
        L_0x0070:
            r0.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.lb.onActivityResult(java.lang.Object):void");
    }

    public void onAnimationEnd() {
        ((Animator) this.d).start();
    }

    public void onFailure(Exception exc) {
        boolean z = SmsVerificationService.e;
        Intrinsics.checkNotNullParameter(exc, "it");
        ((SmsVerificationService) this.d).stopSelf();
    }

    public void onSuccess(Object obj) {
        Object obj2 = this.d;
        switch (this.c) {
            case 7:
                int i = MobileCheckV2Activity.g;
                ((tc) obj2).invoke(obj);
                return;
            default:
                boolean z = SmsVerificationService.e;
                ((a) obj2).invoke(obj);
                return;
        }
    }

    public void onTouchExplorationStateChanged(boolean z) {
        ((SearchBar) this.d).lambda$new$0(z);
    }

    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((Recorder) this.d).lambda$configureInternal$7(transformationInfo);
    }

    public boolean onZoomEvent(ZoomGestureDetector.ZoomEvent zoomEvent) {
        return ((PreviewView) this.d).lambda$new$1(zoomEvent);
    }

    public void run(Canvas canvas) {
        switch (this.c) {
            case 5:
                ((MaskableFrameLayout) this.d).lambda$dispatchDraw$1(canvas);
                return;
            default:
                ((NavigationView) this.d).lambda$dispatchDraw$0(canvas);
                return;
        }
    }

    public Object then(Task task) {
        switch (this.c) {
            case 17:
                return Boolean.valueOf(((SessionReportingCoordinator) this.d).onReportSendComplete(task));
            default:
                return ((CountDownLatch) this.d).countDown();
        }
    }
}
