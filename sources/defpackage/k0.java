package defpackage;

import android.graphics.Matrix;
import android.hardware.camera2.CameraCharacteristics;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.webkit.WebChromeClient;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.resolutionselector.ResolutionFilter;
import androidx.camera.extensions.ExtensionsManager;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.view.CameraController;
import androidx.camera.view.RotationProvider;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentResultListener;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorker;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.sessions.EventGDTLogger;
import com.google.firebase.sessions.SessionEvent;
import com.google.gson.JsonObject;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.weight.CommonWebView;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffActivity;
import com.ktakilat.loan.http.bank_card.BankResp;
import com.ktakilat.loan.login_face.BaseLoginActivity;
import com.ktakilat.loan.service.sms.SmsVerifyCodeReceiver;
import com.ktakilat.loan.web.CommonWebFragment;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.ktakilat.loan.webtool.JsMap;
import com.ktakilat.loan.widgets.CityPickerFragment;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function2;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableBiPredicate;
import org.apache.commons.lang3.function.FailableCallable;
import org.apache.commons.lang3.function.FailableDoublePredicate;
import org.apache.commons.lang3.function.FailableIntPredicate;
import org.apache.commons.lang3.function.FailableLongPredicate;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.function.FailableSupplier;

/* renamed from: k0  reason: default package */
public final /* synthetic */ class k0 implements CallbackToFutureAdapter.Resolver, OnItemClickListener, ObservableOnSubscribe, FaceLoginOnOffActivity.PermissionCallback, AccessibilityViewCommand, CameraCharacteristicsProvider, RotationProvider.Listener, SwipeRefreshLayout.OnRefreshListener, ActivityResultCallback, SmsVerifyCodeReceiver.CallBack, SuccessContinuation, Deferred.DeferredHandler, Continuation, Transformer, FailableSupplier, FailableBiPredicate, FailableDoublePredicate, FailableIntPredicate, FailableLongPredicate, FailablePredicate, FragmentResultListener, Functions.FailableSupplier, ImageAnalysis.Analyzer, ResolutionFilter, InputConnectionCompat.OnCommitContentListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ k0(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public void a(String str) {
        BaseActivity baseActivity;
        CommonWebViewSetting commonWebViewSetting = (CommonWebViewSetting) this.d;
        if (commonWebViewSetting.e != null && (baseActivity = commonWebViewSetting.d) != null && !baseActivity.isFinishing() && !baseActivity.isDestroyed()) {
            CommonWebView commonWebView = commonWebViewSetting.e;
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("code", str);
            JsMap.a(commonWebView, "naviCallSmsCode", jsonObject.toString());
        }
    }

    public void analyze(ImageProxy imageProxy) {
        ((ImageAnalysis.Analyzer) this.d).analyze(imageProxy);
    }

    public /* synthetic */ FailableBiPredicate and(FailableBiPredicate failableBiPredicate) {
        return l7.a(this, failableBiPredicate);
    }

    public Object apply(Object obj) {
        return ((EventGDTLogger) this.d).encode((SessionEvent) obj);
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return ((AudioSource) this.d).lambda$release$5(completer);
            case 5:
                return ((Camera2CameraControlImpl) this.d).lambda$updateSessionConfigAsync$7(completer);
            case 8:
                return ((CameraRepository) this.d).lambda$deinit$0(completer);
            case 9:
                return ((CameraX) this.d).lambda$shutdownInternal$4(completer);
            default:
                return ((ExtensionsManager) this.d).lambda$shutdown$1(completer);
        }
    }

    public void c(boolean z) {
        int i = BaseLoginActivity.m;
        BaseLoginActivity baseLoginActivity = (BaseLoginActivity) this.d;
        if (!z) {
            baseLoginActivity.B();
        } else {
            baseLoginActivity.getClass();
        }
    }

    public void d(ObservableEmitter observableEmitter) {
        ArrayList arrayList = new ArrayList(0);
        for (BankResp bankResp : (List) this.d) {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(bankResp.getIsDisabled())) {
                arrayList.add(bankResp);
            }
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    public List filter(List list, int i) {
        return ImageAnalysis.lambda$onMergeConfig$0((Size) this.d, list, i);
    }

    public Object get() {
        switch (this.c) {
            case 18:
                return ((FailableCallable) this.d).call();
            default:
                return ((Functions.FailableCallable) this.d).call();
        }
    }

    public /* synthetic */ Size getDefaultTargetResolution() {
        return ia.a(this);
    }

    public /* synthetic */ int getTargetCoordinateSystem() {
        return ia.b(this);
    }

    public void handle(Provider provider) {
        ((CrashlyticsNativeComponentDeferredProxy) this.d).lambda$new$0(provider);
    }

    public void onActivityResult(Object obj) {
        ActivityResult activityResult = (ActivityResult) obj;
        CommonWebFragment commonWebFragment = (CommonWebFragment) this.d;
        if (commonWebFragment.s != null) {
            try {
                commonWebFragment.s.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(activityResult.getResultCode(), activityResult.getData()));
                commonWebFragment.s = null;
            } catch (Exception unused) {
            }
        }
    }

    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.d, inputContentInfoCompat, i, bundle);
    }

    public void onFragmentResult(String str, Bundle bundle) {
        FragmentKt.setFragmentResultListener$lambda$0((Function2) this.d, str, bundle);
    }

    public void onRefresh() {
        ((CityPickerFragment) this.d).c();
    }

    public void onRotationChanged(int i) {
        ((CameraController) this.d).lambda$new$1(i);
    }

    public /* synthetic */ FailableBiPredicate or(FailableBiPredicate failableBiPredicate) {
        return l7.c(this, failableBiPredicate);
    }

    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return ((BottomSheetDragHandleView) this.d).lambda$onBottomSheetStateChanged$0(view, commandArguments);
    }

    public boolean test(double d2) {
        return q7.e((FailableDoublePredicate) this.d, d2);
    }

    public Task then(Object obj) {
        return Tasks.forResult((ConfigFetchHandler.FetchResponse) this.d);
    }

    public /* synthetic */ void updateTransform(Matrix matrix) {
        ia.c(this, matrix);
    }

    public /* synthetic */ FailableDoublePredicate and(FailableDoublePredicate failableDoublePredicate) {
        return q7.a(this, failableDoublePredicate);
    }

    public Object get(CameraCharacteristics.Key key) {
        return ((CameraCharacteristicsCompat) this.d).get(key);
    }

    public /* synthetic */ FailableDoublePredicate or(FailableDoublePredicate failableDoublePredicate) {
        return q7.c(this, failableDoublePredicate);
    }

    public boolean test(int i) {
        return a8.e((FailableIntPredicate) this.d, i);
    }

    public Object then(Task task) {
        switch (this.c) {
            case 15:
                return CrashlyticsWorker.lambda$submitTaskOnSuccess$5((SuccessContinuation) this.d, task);
            default:
                return FirebaseRemoteConfig.lambda$ensureInitialized$0((Task) this.d, task);
        }
    }

    public /* synthetic */ FailableIntPredicate and(FailableIntPredicate failableIntPredicate) {
        return a8.a(this, failableIntPredicate);
    }

    public /* synthetic */ FailableIntPredicate or(FailableIntPredicate failableIntPredicate) {
        return a8.c(this, failableIntPredicate);
    }

    public boolean test(long j) {
        return j8.e((FailableLongPredicate) this.d, j);
    }

    public /* synthetic */ FailableLongPredicate and(FailableLongPredicate failableLongPredicate) {
        return j8.a(this, failableLongPredicate);
    }

    public /* synthetic */ FailableLongPredicate or(FailableLongPredicate failableLongPredicate) {
        return j8.c(this, failableLongPredicate);
    }

    public boolean test(Object obj) {
        return s8.e((FailablePredicate) this.d, obj);
    }

    public /* synthetic */ FailablePredicate and(FailablePredicate failablePredicate) {
        return s8.a(this, failablePredicate);
    }

    public /* synthetic */ FailablePredicate or(FailablePredicate failablePredicate) {
        return s8.c(this, failablePredicate);
    }

    public boolean test(Object obj, Object obj2) {
        return l7.e((FailableBiPredicate) this.d, obj, obj2);
    }
}
