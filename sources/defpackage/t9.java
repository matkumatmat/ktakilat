package defpackage;

import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import androidx.camera.video.internal.encoder.Encoder;
import androidx.camera.video.internal.encoder.EncoderConfig;
import androidx.camera.video.internal.encoder.EncoderFactory;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.constraintlayout.core.state.Interpolator;
import androidx.constraintlayout.core.state.Transition;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.android.installreferrer.api.InstallReferrerClient;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.cbase.utils.DeviceUtils;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.global.Config;
import com.ktakilat.loan.global.Domain;
import com.ktakilat.loan.input_pwd.InputPwdActivity;
import com.ktakilat.loan.launch.LauncherActivity;
import com.ktakilat.loan.main.HomeActivity;
import com.ktakilat.loan.mobile_check.MobileCheckV2Activity;
import com.ktakilat.loan.new_pwd.NewPasswordActivity;
import com.ktakilat.loan.normal_ui.LivenessGuideActivity;
import com.ktakilat.loan.normal_ui.TDLivenessGuideActivity;
import com.ktakilat.loan.verify_face.ChangeMobileAndForgotPwdTmpLoginUtil;
import com.ktakilat.loan.weiget.AdvertisingIdUtils;
import com.ktakilat.loan.weiget.PushTokenUtil;
import com.ktakilat.loan.weiget.WebCookieManager;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.ktakilat.loan.widgets.ReceiveWACodeActivity;
import com.tongdun.mobox.sdk.TongdunSdk;
import com.trustdecision.mobrisk.TDErrorCodeCallback;
import com.trustdecision.mobrisk.TDRiskCallback;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.ToBooleanBiFunction;

/* renamed from: t9  reason: default package */
public final /* synthetic */ class t9 implements DialogUtils.CommonOkClickListern, OnCompleteListener, DialogUtils.CommonCancleClickListern, ObservableOnSubscribe, Consumer, TongdunSdk.TDErrorCallback, OnApplyWindowInsetsListener, ShapeAppearanceModel.CornerSizeUnaryOperator, Transformer, EncoderFactory, ToBooleanBiFunction, TextInputLayout.LengthCounter, FailableBiConsumer, TDErrorCodeCallback, TDRiskCallback, Interpolator {
    public final /* synthetic */ int c;

    public /* synthetic */ t9(int i) {
        this.c = i;
    }

    public void a() {
        int i = InputPwdActivity.p;
        KtaCollect.n_change_pho_ektp_pop_clc_close();
        ChangeMobileAndForgotPwdTmpLoginUtil.a();
    }

    public void accept(Object obj) {
        Boolean bool = (Boolean) obj;
        InstallReferrerClient installReferrerClient = KtakilatApplication.j;
    }

    public /* synthetic */ FailableBiConsumer andThen(FailableBiConsumer failableBiConsumer) {
        return i7.a(this, failableBiConsumer);
    }

    public CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    public boolean applyAsBoolean(Object obj, Object obj2) {
        CharSequence charSequence = (CharSequence) obj;
        CharSequence charSequence2 = (CharSequence) obj2;
        switch (this.c) {
            case 13:
                return StringUtils.contains(charSequence, charSequence2);
            default:
                return StringUtils.containsIgnoreCase(charSequence, charSequence2);
        }
    }

    public void b() {
        KtaCollect.n_pattern_guide_clc_ok();
    }

    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    public Encoder createEncoder(Executor executor, EncoderConfig encoderConfig) {
        return new EncoderImpl(executor, encoderConfig);
    }

    public void d(ObservableEmitter observableEmitter) {
        BaseApplication baseApplication;
        switch (this.c) {
            case 3:
                InstallReferrerClient installReferrerClient = KtakilatApplication.j;
                InstallReferrerClient installReferrerClient2 = KtakilatApplication.j;
                String str = null;
                if (!KtakilatApplication.k.booleanValue() && (baseApplication = BaseApplication.e) != null) {
                    if (AdvertisingIdUtils.b(baseApplication).type == AdvertisingIdUtils.ADVERTISING_TYPE.NOT_ENABLE.type) {
                        KtakilatApplication.k = Boolean.FALSE;
                    } else {
                        KtakilatApplication.k = Boolean.TRUE;
                        int i = 0;
                        while (true) {
                            if (i < 3) {
                                try {
                                    str = DeviceUtils.a(BaseApplication.e);
                                    if (TextUtils.isEmpty(str)) {
                                        Thread.sleep(500);
                                        i++;
                                    }
                                } catch (Exception unused) {
                                    ArrayList arrayList = LogActivity.k;
                                }
                            }
                        }
                        KtakilatApplication.k = Boolean.FALSE;
                    }
                }
                if (str != null) {
                    observableEmitter.onNext(str);
                } else {
                    observableEmitter.onError(new Throwable("adid = null"));
                }
                observableEmitter.onComplete();
                return;
            default:
                synchronized (WebCookieManager.class) {
                    CookieManager.getInstance().removeAllCookie();
                    WebCookieManager.b(Domain.a());
                }
                observableEmitter.onNext(Boolean.TRUE);
                observableEmitter.onComplete();
                return;
        }
    }

    public float getInterpolation(float f) {
        switch (this.c) {
            case 20:
                return Transition.lambda$getInterpolator$1(f);
            case 21:
                return Transition.lambda$getInterpolator$2(f);
            case 22:
                return Transition.lambda$getInterpolator$3(f);
            case 23:
                return Transition.lambda$getInterpolator$4(f);
            case 24:
                return Transition.lambda$getInterpolator$5(f);
            case 25:
                return Transition.lambda$getInterpolator$6(f);
            default:
                return Transition.lambda$getInterpolator$7(f);
        }
    }

    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        switch (this.c) {
            case 6:
                int i = LivenessGuideActivity.e;
                Intrinsics.checkNotNullParameter(view, "v");
                Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
                view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
                return windowInsetsCompat;
            case 9:
                int i2 = MobileCheckV2Activity.g;
                Intrinsics.checkNotNullParameter(view, "v");
                Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.ime());
                Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
                view.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
                return windowInsetsCompat;
            case 10:
                int i3 = NewPasswordActivity.f;
                Intrinsics.checkNotNullParameter(view, "v");
                Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
                Insets insets3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics.checkNotNullExpressionValue(insets3, "getInsets(...)");
                view.setPadding(insets3.left, insets3.top, insets3.right, insets3.bottom);
                return windowInsetsCompat;
            case 11:
                int i4 = ReceiveWACodeActivity.c;
                Intrinsics.checkNotNullParameter(view, "v");
                Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
                Insets insets4 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics.checkNotNullExpressionValue(insets4, "getInsets(...)");
                view.setPadding(insets4.left, insets4.top, insets4.right, insets4.bottom);
                return windowInsetsCompat;
            default:
                int i5 = TDLivenessGuideActivity.d;
                Intrinsics.checkNotNullParameter(view, "v");
                Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
                Insets insets5 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Intrinsics.checkNotNullExpressionValue(insets5, "getInsets(...)");
                view.setPadding(insets5.left, insets5.top, insets5.right, insets5.bottom);
                return windowInsetsCompat;
        }
    }

    public void onComplete(Task task) {
        String str;
        int i = HomeActivity.p;
        if (!task.isSuccessful()) {
            str = null;
        } else {
            str = (String) task.getResult();
        }
        if (TextUtils.isEmpty(Config.f495a) && !TextUtils.isEmpty(str)) {
            Config.f495a = str;
            PushTokenUtil.a(str);
        }
    }

    public void onEvent(String str) {
    }

    public void onResult(int i, String str) {
        int i2 = LauncherActivity.q;
        try {
            FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
            instance.recordException(new Exception(i + ":" + str));
        } catch (Throwable unused) {
        }
    }

    public /* synthetic */ t9(t9 t9Var) {
        this.c = 18;
    }

    public void accept(Object obj, Object obj2) {
        Thread.sleep(((Long) obj).longValue(), ((Integer) obj2).intValue());
    }

    public Object apply(Object obj) {
        return ((MessagingClientEventExtension) obj).toByteArray();
    }
}
