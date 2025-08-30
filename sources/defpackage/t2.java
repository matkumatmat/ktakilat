package defpackage;

import android.content.Context;
import android.content.Intent;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageProcessor;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Config;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.camera.extensions.internal.RequestOptionConfig;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.EnhancedIntentService;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHttpClient;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlinx.coroutines.Deferred;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableBiConsumer;
import org.apache.commons.lang3.function.FailableBiFunction;
import org.apache.commons.lang3.function.FailableBooleanSupplier;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableDoubleConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailableIntConsumer;
import org.apache.commons.lang3.function.FailableLongConsumer;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.function.FailableRunnable;
import org.apache.commons.lang3.function.FailableSupplier;
import org.apache.commons.lang3.function.TriFunction;

/* renamed from: t2  reason: default package */
public final /* synthetic */ class t2 implements CallbackToFutureAdapter.Resolver, Config.OptionMatcher, Continuation, SurfaceRequest.TransformationInfoListener, OnCompleteListener, FailableBooleanSupplier, FailableRunnable, FailableSupplier, FailableBiConsumer, FailableBiFunction, FailableConsumer, FailableDoubleConsumer, FailableIntConsumer, FailableLongConsumer, Functions.FailableSupplier, Functions.FailableRunnable, ObservableOnSubscribe, DialogUtils.SingleSelectCallback, TriFunction {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    public /* synthetic */ t2(int i, Object obj, Object obj2) {
        this.c = i;
        this.d = obj;
        this.e = obj2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "1"
            java.lang.String r3 = "2"
            java.lang.String r4 = "3"
            java.lang.String r5 = "PASSWORD_LOGIN"
            java.lang.String r7 = "FORGET_PASSWORD"
            java.lang.String r11 = "FACE_LOGIN"
            java.lang.String r12 = "CHANGE_PHONE_NUMBER"
            java.lang.String r14 = "SMS_CODE_LOGIN"
            java.lang.String r15 = "GESTURE_LOGIN"
            java.lang.String r6 = "SWITCH_ACCOUNT"
            r8 = 1
            java.lang.Object r10 = r0.e
            java.lang.Object r9 = r0.d
            int r13 = r0.c
            switch(r13) {
                case 22: goto L_0x017b;
                case 23: goto L_0x00f9;
                case 24: goto L_0x0095;
                default: goto L_0x0022;
            }
        L_0x0022:
            int r2 = com.ktakilat.loan.login_pwd.LoginPwdActivity.r
            com.ktakilat.loan.login_pwd.LoginPwdActivity r9 = (com.ktakilat.loan.login_pwd.LoginPwdActivity) r9
            r9.getClass()
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r2 = r1.hashCode()
            switch(r2) {
                case -1981665561: goto L_0x0061;
                case -1811980115: goto L_0x0059;
                case -1545997431: goto L_0x0051;
                case -395484867: goto L_0x0049;
                case 282001587: goto L_0x0041;
                case 1774777346: goto L_0x0039;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x0069
        L_0x0039:
            boolean r2 = r1.equals(r6)
            if (r2 == 0) goto L_0x0069
            r2 = 3
            goto L_0x006a
        L_0x0041:
            boolean r2 = r1.equals(r15)
            if (r2 == 0) goto L_0x0069
            r2 = 5
            goto L_0x006a
        L_0x0049:
            boolean r2 = r1.equals(r14)
            if (r2 == 0) goto L_0x0069
            r2 = 0
            goto L_0x006a
        L_0x0051:
            boolean r2 = r1.equals(r12)
            if (r2 == 0) goto L_0x0069
            r2 = 2
            goto L_0x006a
        L_0x0059:
            boolean r2 = r1.equals(r7)
            if (r2 == 0) goto L_0x0069
            r2 = 1
            goto L_0x006a
        L_0x0061:
            boolean r2 = r1.equals(r11)
            if (r2 == 0) goto L_0x0069
            r2 = 4
            goto L_0x006a
        L_0x0069:
            r2 = -1
        L_0x006a:
            if (r2 == 0) goto L_0x0081
            if (r2 == r8) goto L_0x007d
            r3 = 2
            if (r2 == r3) goto L_0x0079
            r3 = 3
            if (r2 == r3) goto L_0x0075
            goto L_0x0084
        L_0x0075:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_password_clc_switch_account()
            goto L_0x0084
        L_0x0079:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_password_clc_change_phone()
            goto L_0x0084
        L_0x007d:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_password_clc_forget_pwd()
            goto L_0x0084
        L_0x0081:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_password_clc_change_method()
        L_0x0084:
            com.ktakilat.loan.login_pwd.LoginPwdPresenter r2 = r9.n
            java.lang.String r3 = r9.p
            boolean r4 = r9.o
            com.ktakilat.loan.login_pwd.LoginPwdActivity r5 = r2.f523a
            r5.getClass()
            com.ktakilat.loan.weiget.LoginUtil r2 = r2.b
            r2.c(r5, r1, r3, r4)
            return
        L_0x0095:
            boolean r2 = com.ktakilat.loan.login_otp.LoginOtpActivity.t
            com.ktakilat.loan.login_otp.LoginOtpActivity r9 = (com.ktakilat.loan.login_otp.LoginOtpActivity) r9
            r9.getClass()
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r2 = r1.hashCode()
            switch(r2) {
                case -1981665561: goto L_0x00cc;
                case -1545997431: goto L_0x00c4;
                case -395484867: goto L_0x00bc;
                case 282001587: goto L_0x00b4;
                case 1774777346: goto L_0x00ac;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            goto L_0x00d4
        L_0x00ac:
            boolean r2 = r1.equals(r6)
            if (r2 == 0) goto L_0x00d4
            r2 = 2
            goto L_0x00d5
        L_0x00b4:
            boolean r2 = r1.equals(r15)
            if (r2 == 0) goto L_0x00d4
            r2 = 4
            goto L_0x00d5
        L_0x00bc:
            boolean r2 = r1.equals(r14)
            if (r2 == 0) goto L_0x00d4
            r2 = 0
            goto L_0x00d5
        L_0x00c4:
            boolean r2 = r1.equals(r12)
            if (r2 == 0) goto L_0x00d4
            r2 = 1
            goto L_0x00d5
        L_0x00cc:
            boolean r2 = r1.equals(r11)
            if (r2 == 0) goto L_0x00d4
            r2 = 3
            goto L_0x00d5
        L_0x00d4:
            r2 = -1
        L_0x00d5:
            if (r2 == 0) goto L_0x00e5
            if (r2 == r8) goto L_0x00e1
            r3 = 2
            if (r2 == r3) goto L_0x00dd
            goto L_0x00e8
        L_0x00dd:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_otp_clc_switch_account()
            goto L_0x00e8
        L_0x00e1:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_otp_clc_change_phone()
            goto L_0x00e8
        L_0x00e5:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_otp_clc_change_method()
        L_0x00e8:
            com.ktakilat.loan.login_otp.LoginOtpPresenter r2 = r9.n
            java.lang.String r3 = r9.p
            boolean r4 = r9.o
            com.ktakilat.loan.login_otp.LoginOtpActivity r5 = r2.f520a
            r5.getClass()
            com.ktakilat.loan.weiget.LoginUtil r2 = r2.b
            r2.c(r5, r1, r3, r4)
            return
        L_0x00f9:
            int r13 = com.ktakilat.loan.login_gesture.LoginGestureActivity.s
            com.ktakilat.loan.login_gesture.LoginGestureActivity r9 = (com.ktakilat.loan.login_gesture.LoginGestureActivity) r9
            r9.getClass()
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r10 = r1.hashCode()
            switch(r10) {
                case -1981665561: goto L_0x0140;
                case -1811980115: goto L_0x0138;
                case -1545997431: goto L_0x0130;
                case -1457625947: goto L_0x0128;
                case -395484867: goto L_0x0120;
                case 282001587: goto L_0x0118;
                case 1774777346: goto L_0x0110;
                default: goto L_0x010f;
            }
        L_0x010f:
            goto L_0x0148
        L_0x0110:
            boolean r5 = r1.equals(r6)
            if (r5 == 0) goto L_0x0148
            r6 = 4
            goto L_0x0149
        L_0x0118:
            boolean r5 = r1.equals(r15)
            if (r5 == 0) goto L_0x0148
            r6 = 6
            goto L_0x0149
        L_0x0120:
            boolean r5 = r1.equals(r14)
            if (r5 == 0) goto L_0x0148
            r6 = 1
            goto L_0x0149
        L_0x0128:
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0148
            r6 = 0
            goto L_0x0149
        L_0x0130:
            boolean r5 = r1.equals(r12)
            if (r5 == 0) goto L_0x0148
            r6 = 3
            goto L_0x0149
        L_0x0138:
            boolean r5 = r1.equals(r7)
            if (r5 == 0) goto L_0x0148
            r6 = 2
            goto L_0x0149
        L_0x0140:
            boolean r5 = r1.equals(r11)
            if (r5 == 0) goto L_0x0148
            r6 = 5
            goto L_0x0149
        L_0x0148:
            r6 = -1
        L_0x0149:
            if (r6 == 0) goto L_0x0167
            if (r6 == r8) goto L_0x0163
            r2 = 2
            if (r6 == r2) goto L_0x015f
            r2 = 3
            if (r6 == r2) goto L_0x015b
            r2 = 4
            if (r6 == r2) goto L_0x0157
            goto L_0x016a
        L_0x0157:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_switch_account(r4)
            goto L_0x016a
        L_0x015b:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_change_phone(r4)
            goto L_0x016a
        L_0x015f:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_forget_pwd(r4)
            goto L_0x016a
        L_0x0163:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_change_method(r4, r3)
            goto L_0x016a
        L_0x0167:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_change_method(r4, r2)
        L_0x016a:
            com.ktakilat.loan.login_gesture.LoginGesturePresenter r2 = r9.n
            java.lang.String r3 = r9.q
            boolean r4 = r9.p
            com.ktakilat.loan.login_gesture.LoginGestureActivity r5 = r2.f516a
            r5.getClass()
            com.ktakilat.loan.weiget.LoginUtil r2 = r2.b
            r2.c(r5, r1, r3, r4)
            return
        L_0x017b:
            int r13 = com.ktakilat.loan.login_face.LoginFaceActivity.r
            com.ktakilat.loan.login_face.LoginFaceActivity r9 = (com.ktakilat.loan.login_face.LoginFaceActivity) r9
            r9.getClass()
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r10 = r1.hashCode()
            switch(r10) {
                case -1981665561: goto L_0x01c2;
                case -1811980115: goto L_0x01ba;
                case -1545997431: goto L_0x01b2;
                case -1457625947: goto L_0x01aa;
                case -395484867: goto L_0x01a2;
                case 282001587: goto L_0x019a;
                case 1774777346: goto L_0x0192;
                default: goto L_0x0191;
            }
        L_0x0191:
            goto L_0x01ca
        L_0x0192:
            boolean r5 = r1.equals(r6)
            if (r5 == 0) goto L_0x01ca
            r6 = 4
            goto L_0x01cb
        L_0x019a:
            boolean r5 = r1.equals(r15)
            if (r5 == 0) goto L_0x01ca
            r6 = 5
            goto L_0x01cb
        L_0x01a2:
            boolean r5 = r1.equals(r14)
            if (r5 == 0) goto L_0x01ca
            r6 = 1
            goto L_0x01cb
        L_0x01aa:
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x01ca
            r6 = 0
            goto L_0x01cb
        L_0x01b2:
            boolean r5 = r1.equals(r12)
            if (r5 == 0) goto L_0x01ca
            r6 = 3
            goto L_0x01cb
        L_0x01ba:
            boolean r5 = r1.equals(r7)
            if (r5 == 0) goto L_0x01ca
            r6 = 2
            goto L_0x01cb
        L_0x01c2:
            boolean r5 = r1.equals(r11)
            if (r5 == 0) goto L_0x01ca
            r6 = 6
            goto L_0x01cb
        L_0x01ca:
            r6 = -1
        L_0x01cb:
            java.lang.String r5 = "4"
            if (r6 == 0) goto L_0x01f2
            if (r6 == r8) goto L_0x01ee
            r2 = 2
            if (r6 == r2) goto L_0x01ea
            r2 = 3
            if (r6 == r2) goto L_0x01e6
            r2 = 4
            if (r6 == r2) goto L_0x01e2
            r2 = 5
            if (r6 == r2) goto L_0x01de
            goto L_0x01f5
        L_0x01de:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_change_method(r5, r4)
            goto L_0x01f5
        L_0x01e2:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_switch_account(r5)
            goto L_0x01f5
        L_0x01e6:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_change_phone(r5)
            goto L_0x01f5
        L_0x01ea:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_forget_pwd(r5)
            goto L_0x01f5
        L_0x01ee:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_change_method(r5, r3)
            goto L_0x01f5
        L_0x01f2:
            com.ktakilat.cbase.datacollect.KtaCollect.n_login_page_clc_change_method(r5, r2)
        L_0x01f5:
            com.ktakilat.loan.login_face.LoginFacePresenter r2 = r9.n
            java.lang.String r3 = r9.p
            boolean r4 = r9.o
            com.ktakilat.loan.login_face.LoginFaceActivity r5 = r2.f513a
            r5.getClass()
            com.ktakilat.loan.weiget.LoginUtil r2 = r2.b
            r2.c(r5, r1, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t2.a(int, java.lang.String):void");
    }

    public void accept(double d2) {
        n7.b((FailableDoubleConsumer) this.d, (FailableDoubleConsumer) this.e, d2);
    }

    public /* synthetic */ FailableBiConsumer andThen(FailableBiConsumer failableBiConsumer) {
        return i7.a(this, failableBiConsumer);
    }

    public Object apply(Object obj, Object obj2) {
        return ((FailableFunction) this.e).apply(((FailableBiFunction) this.d).apply(obj, obj2));
    }

    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return ((CameraX) this.d).lambda$initInternal$0((Context) this.e, completer);
            case 5:
                return CoroutineAdapterKt.asListenableFuture$lambda$0((Deferred) this.d, this.e, completer);
            case 20:
                return ((InternalImageProcessor) this.d).lambda$safeProcess$1((ImageProcessor.Request) this.e, completer);
            case 26:
                return ProcessCameraProvider.getOrCreateCameraXInstance$lambda$18$lambda$17((ProcessCameraProvider) this.e, (CameraX) this.d, completer);
            default:
                return ((SurfaceRequest) this.d).lambda$initialSurfaceRecreationCompleter$6((AtomicReference) this.e, completer);
        }
    }

    public void d(ObservableEmitter observableEmitter) {
        ArrayList arrayList = LogActivity.k;
        ((LogActivity) this.d).getClass();
        ArrayList arrayList2 = new ArrayList(0);
        Iterator it = LogActivity.z().iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str.toLowerCase().contains(((String) this.e).toLowerCase())) {
                arrayList2.add(str);
            }
        }
        observableEmitter.onNext(arrayList2);
        observableEmitter.onComplete();
    }

    public Object get() {
        switch (this.c) {
            case 10:
                return ((FailableFunction) this.d).apply(this.e);
            default:
                return ((Functions.FailableFunction) this.d).apply(this.e);
        }
    }

    public boolean getAsBoolean() {
        switch (this.c) {
            case 8:
                return ((FailablePredicate) this.d).test(this.e);
            default:
                return ((Functions.FailablePredicate) this.d).test(this.e);
        }
    }

    public void onComplete(Task task) {
        ((EnhancedIntentService) this.d).lambda$onStartCommand$1((Intent) this.e, task);
    }

    public boolean onOptionMatched(Config.Option option) {
        switch (this.c) {
            case 1:
                return ((CaptureRequestOptions.Builder) this.d).getMutableConfig().insertOption(option, ((Config) this.e).getOptionPriority(option), ((Config) this.e).retrieveOption(option));
            default:
                return ((RequestOptionConfig.Builder) this.d).mMutableOptionsBundle.insertOption(option, ((Config) this.e).getOptionPriority(option), ((Config) this.e).retrieveOption(option));
        }
    }

    public void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
        ((DefaultSurfaceProcessor) this.d).lambda$onInputSurface$0((SurfaceRequest) this.e, transformationInfo);
    }

    public void run() {
        switch (this.c) {
            case 9:
                ((FailableConsumer) this.d).accept(this.e);
                return;
            default:
                ((Functions.FailableConsumer) this.d).accept(this.e);
                return;
        }
    }

    public Object then(Task task) {
        switch (this.c) {
            case 2:
                return ((ConfigFetchHandler) this.d).lambda$fetchIfCacheExpiredAndNotThrottled$3((Date) this.e, task);
            case 3:
                return ((ConfigFetchHandler) this.d).lambda$fetchNowWithTypeAndAttemptNumber$1((HashMap) this.e, task);
            default:
                return ((ConfigRealtimeHttpClient) this.d).lambda$beginRealtimeHttpStream$1((Task) this.e, task);
        }
    }

    public /* synthetic */ t2(ProcessCameraProvider processCameraProvider, CameraX cameraX) {
        this.c = 26;
        this.e = processCameraProvider;
        this.d = cameraX;
    }

    public void accept(int i) {
        x7.b((FailableIntConsumer) this.d, (FailableIntConsumer) this.e, i);
    }

    public /* synthetic */ FailableBiFunction andThen(FailableFunction failableFunction) {
        return j7.a(this, failableFunction);
    }

    public Object apply(Object obj, Object obj2, Object obj3) {
        return ((Function) this.e).apply(((TriFunction) this.d).apply(obj, obj2, obj3));
    }

    public void accept(long j) {
        f8.b((FailableLongConsumer) this.d, (FailableLongConsumer) this.e, j);
    }

    public /* synthetic */ FailableConsumer andThen(FailableConsumer failableConsumer) {
        return m7.a(this, failableConsumer);
    }

    public void accept(Object obj) {
        m7.b((FailableConsumer) this.d, (FailableConsumer) this.e, obj);
    }

    public /* synthetic */ FailableDoubleConsumer andThen(FailableDoubleConsumer failableDoubleConsumer) {
        return n7.a(this, failableDoubleConsumer);
    }

    public void accept(Object obj, Object obj2) {
        i7.b((FailableBiConsumer) this.d, (FailableBiConsumer) this.e, obj, obj2);
    }

    public /* synthetic */ FailableIntConsumer andThen(FailableIntConsumer failableIntConsumer) {
        return x7.a(this, failableIntConsumer);
    }

    public /* synthetic */ FailableLongConsumer andThen(FailableLongConsumer failableLongConsumer) {
        return f8.a(this, failableLongConsumer);
    }

    public /* synthetic */ TriFunction andThen(Function function) {
        return dg.a(this, function);
    }
}
