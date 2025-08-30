package defpackage;

import android.app.Activity;
import android.hardware.camera2.CameraDevice;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.ComponentDialog;
import androidx.activity.FullyDrawnReporter;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessor;
import androidx.camera.core.processing.concurrent.DualSurfaceProcessorNode;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.idl.face.platform.utils.DensityUtils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.installations.FirebaseInstallations;
import com.katkilat.baidu_face.BaseLivenessBaiduActivity;
import com.katkilat.baidu_face.manager.FacePointManager;
import com.katkilat.baidu_face.widget.FaceDetectRoundView;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseDialog;
import com.ktakilat.loan.R;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;
import com.ktakilat.loan.normal_ui.LivenessGuideActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpActivity;
import com.ktakilat.loan.verify_otp.BaseVerifyOtpSms;
import com.ktakilat.loan.web.CommonWebActivity;
import com.pendanaan.kta.databinding.CDialogPickOtpTypeBinding;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableRunnable;

/* renamed from: x0  reason: default package */
public final /* synthetic */ class x0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ x0(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void run() {
        Object obj = this.d;
        switch (this.c) {
            case 0:
                int i = BaseLivenessBaiduActivity.E;
                BaseLivenessBaiduActivity baseLivenessBaiduActivity = (BaseLivenessBaiduActivity) obj;
                baseLivenessBaiduActivity.m = new ImageView(baseLivenessBaiduActivity);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                BaseLivenessBaiduActivity baseLivenessBaiduActivity2 = baseLivenessBaiduActivity.B;
                if (baseLivenessBaiduActivity2 != null) {
                    layoutParams.height = DensityUtils.dip2px(baseLivenessBaiduActivity2, 110.0f);
                    BaseLivenessBaiduActivity baseLivenessBaiduActivity3 = baseLivenessBaiduActivity.B;
                    if (baseLivenessBaiduActivity3 != null) {
                        layoutParams.width = DensityUtils.dip2px(baseLivenessBaiduActivity3, 87.0f);
                        FaceDetectRoundView faceDetectRoundView = baseLivenessBaiduActivity.l;
                        if (faceDetectRoundView != null) {
                            float height = (float) (faceDetectRoundView.getHeight() / 2);
                            layoutParams.setMargins(0, ((int) (height - (0.1f * height))) - (layoutParams.height / 2), 0, 0);
                            layoutParams.addRule(14);
                            ImageView imageView = baseLivenessBaiduActivity.m;
                            if (imageView != null) {
                                imageView.setLayoutParams(layoutParams);
                            }
                            ImageView imageView2 = baseLivenessBaiduActivity.m;
                            if (imageView2 != null) {
                                imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                            baseLivenessBaiduActivity.z().addImageLayout.addView(baseLivenessBaiduActivity.m);
                            return;
                        }
                        Intrinsics.k("mFaceDetectRoundView");
                        throw null;
                    }
                    Intrinsics.k("mContext");
                    throw null;
                }
                Intrinsics.k("mContext");
                throw null;
            case 1:
                BaseVerifyOtpSms baseVerifyOtpSms = BaseVerifyOtpActivity.s;
                BaseVerifyOtpActivity baseVerifyOtpActivity = (BaseVerifyOtpActivity) obj;
                KtaCollect.n_safe_auth_otp_select_popup_exposure(baseVerifyOtpActivity.K());
                String str = baseVerifyOtpActivity.m;
                f1 f1Var = new f1(baseVerifyOtpActivity, 2);
                f1 f1Var2 = new f1(baseVerifyOtpActivity, 3);
                d1 d1Var = new d1(baseVerifyOtpActivity);
                BaseDialog baseDialog = new BaseDialog(baseVerifyOtpActivity, R.style.common_dialog);
                baseDialog.setCancelable(true);
                baseDialog.setCanceledOnTouchOutside(true);
                baseDialog.show();
                Window window = baseDialog.getWindow();
                if (window != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.gravity = 17;
                    attributes.width = -1;
                    attributes.height = -1;
                    window.setAttributes(attributes);
                    CDialogPickOtpTypeBinding inflate = CDialogPickOtpTypeBinding.inflate(LayoutInflater.from(baseVerifyOtpActivity));
                    baseDialog.setContentView(inflate.getRoot());
                    SpannableString spannableString = new SpannableString("Demi keamanan akun Anda, kami perlu melakukan verifikasi keamanan. Kode verifikasi akan dikirim ke WhatsApp Anda");
                    spannableString.setSpan(new StyleSpan(1), 98, 108, 17);
                    inflate.contentText.append(spannableString);
                    inflate.phoneNumber.setText(str);
                    inflate.defaultOtpType.setOnClickListener(new l5((View.OnClickListener) f1Var, baseDialog, 3));
                    inflate.whatsappOtpType.setOnClickListener(new l5((View.OnClickListener) f1Var2, baseDialog, 4));
                    baseDialog.setOnCancelListener(d1Var);
                    return;
                }
                return;
            case 2:
                ((View) obj).requestLayout();
                return;
            case 3:
                ((Camera2CameraControl) obj).completeInFlightUpdate();
                return;
            case 4:
                ((Camera2CameraControlImpl) obj).updateSessionConfigSynchronous();
                return;
            case 5:
                ((CameraDevice) obj).close();
                return;
            case 6:
                ((ImageCapture.ScreenFlash) obj).clear();
                return;
            case 7:
                ((CameraStateRegistry.OnOpenAvailableListener) obj).onOpenAvailable();
                return;
            case 8:
                ((CameraStateRegistry.OnConfigureAvailableListener) obj).onConfigureAvailable();
                return;
            case 9:
                ((Carousel) obj).lambda$updateItems$0();
                return;
            case 10:
                ComponentActivity.menuHostHelper$lambda$0((ComponentActivity) obj);
                return;
            case 11:
                ComponentDialog.onBackPressedDispatcher$lambda$1((ComponentDialog) obj);
                return;
            case 12:
                ViewUtils.requestFocusAndShowKeyboard((EditText) obj, false);
                return;
            case 13:
                ((DefaultSurfaceProcessor) obj).lambda$release$5();
                return;
            case 14:
                ((SurfaceOutput) obj).close();
                return;
            case 15:
                ((ListenableFuture) obj).cancel(true);
                return;
            case 16:
                ((DualSurfaceProcessor) obj).lambda$release$4();
                return;
            case 17:
                ((DualSurfaceProcessorNode) obj).lambda$release$1();
                return;
            case 18:
                FacePointManager facePointManager = (FacePointManager) obj;
                facePointManager.g = new ImageView(facePointManager.f459a);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
                Activity activity = facePointManager.f459a;
                layoutParams2.height = DensityUtils.dip2px(activity, 110.0f);
                layoutParams2.width = DensityUtils.dip2px(activity, 87.0f);
                FaceDetectRoundView faceDetectRoundView2 = facePointManager.c;
                if (faceDetectRoundView2 != null) {
                    float height2 = (float) (faceDetectRoundView2.getHeight() / 2);
                    layoutParams2.setMargins(0, ((int) (height2 - (0.1f * height2))) - (layoutParams2.height / 2), 0, 0);
                    layoutParams2.addRule(14);
                    ImageView imageView3 = facePointManager.g;
                    if (imageView3 != null) {
                        imageView3.setLayoutParams(layoutParams2);
                    }
                    ImageView imageView4 = facePointManager.g;
                    if (imageView4 != null) {
                        imageView4.setScaleType(ImageView.ScaleType.FIT_XY);
                    }
                    RelativeLayout relativeLayout = facePointManager.d;
                    if (relativeLayout != null) {
                        relativeLayout.addView(facePointManager.g);
                        return;
                    } else {
                        Intrinsics.k("mAddIvLayout");
                        throw null;
                    }
                } else {
                    Intrinsics.k("mFaceRoundView");
                    throw null;
                }
            case 19:
                Failable.run((FailableRunnable) obj);
                return;
            case 20:
                ((FirebaseInstallations) obj).lambda$getId$1();
                return;
            case 21:
                ((Fragment) obj).lambda$performCreateView$0();
                return;
            case 22:
                ((FragmentManager) obj).lambda$cancelBackStackTransition$4();
                return;
            case 23:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) obj);
                return;
            case 24:
                Functions.run((Functions.FailableRunnable) obj);
                return;
            case 25:
                int i2 = GoogleMapActivity.q;
                GoogleMapActivity googleMapActivity = (GoogleMapActivity) obj;
                googleMapActivity.getClass();
                LatLng latLng = new LatLng(googleMapActivity.j, googleMapActivity.k);
                GoogleMap googleMap = googleMapActivity.i;
                if (googleMap != null) {
                    googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    return;
                }
                return;
            case 26:
                int i3 = LivenessGuideActivity.e;
                CommonWebActivity.C((LivenessGuideActivity) obj, (String) null, "/UserCenter/PusatBantuan", false, 0);
                return;
            case 27:
                ((MaterialTimePicker) obj).lambda$onViewCreated$0();
                return;
            case 28:
                ((MaterialBackOrchestrator) obj).startListeningForBackCallbacksWithPriorityOverlay();
                return;
            default:
                ((Preview) obj).notifyReset();
                return;
        }
    }
}
