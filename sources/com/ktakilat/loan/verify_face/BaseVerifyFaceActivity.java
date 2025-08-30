package com.ktakilat.loan.verify_face;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.facebook.appevents.AppEventsConstants;
import com.katkilat.baidu_face.manager.BaiduFaceManager;
import com.katkilat.baidu_face.manager.FacePointManager;
import com.katkilat.baidu_face.widget.TimeoutDialog;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.cbase.ui.OnSafeClickListener;
import com.ktakilat.loan.R;
import com.ktakilat.loan.utils.TrustLivenessUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.pendanaan.kta.databinding.ActivityBaseVerifyFaceBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Random;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@SuppressLint({"NonConstantResourceId"})
public abstract class BaseVerifyFaceActivity extends BaseVeritySecondActivity {
    public static final /* synthetic */ int s = 0;
    public ActivityBaseVerifyFaceBinding m;
    public FacePointManager n;
    public TimeoutDialog o;
    public String p = null;
    public int q;
    public ArrayList r;

    /* renamed from: com.ktakilat.loan.verify_face.BaseVerifyFaceActivity$8  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f555a;

        static {
            int[] iArr = new int[VerifyType.values().length];
            f555a = iArr;
            try {
                iArr[VerifyType.OTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public interface IntentCallback {
        void a(Intent intent);
    }

    public interface PermissionCallback {
        void c(boolean z);
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object, kotlin.Lazy] */
    public static void F(Activity activity, Class cls, String str, int i, ArrayList arrayList, IntentCallback intentCallback) {
        Activity activity2 = activity;
        ArrayList arrayList2 = new ArrayList(1);
        arrayList2.add(new LivenessTypeEnum[]{LivenessTypeEnum.HeadDown, LivenessTypeEnum.HeadUp, LivenessTypeEnum.HeadLeft, LivenessTypeEnum.HeadRight}[new Random().nextInt(4)]);
        b1 b1Var = new b1(activity, cls, str, i, arrayList, intentCallback);
        x xVar = new x(1, activity, intentCallback);
        ((BaiduFaceManager) BaiduFaceManager.f457a.getValue()).getClass();
        BaiduFaceManager.a(activity, arrayList2, b1Var, xVar);
    }

    public static void K(Activity activity, final PermissionCallback permissionCallback) {
        KtaCollect.n_request_permission("Camera", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        new RxPermissions(activity).b("android.permission.CAMERA").subscribe(new Observer<Boolean>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
                KtaCollect.n_request_permission("Camera", ExifInterface.GPS_MEASUREMENT_2D);
                th.toString();
                ArrayList arrayList = LogActivity.k;
                PermissionCallback.this.c(false);
            }

            public final void onNext(Object obj) {
                String str;
                Boolean bool = (Boolean) obj;
                if (bool.booleanValue()) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                } else {
                    str = "-1";
                }
                KtaCollect.n_request_permission("Camera", str);
                PermissionCallback permissionCallback = PermissionCallback.this;
                if (permissionCallback != null) {
                    permissionCallback.c(bool.booleanValue());
                }
            }

            public final void onSubscribe(Disposable disposable) {
            }
        });
    }

    public final void A() {
        FacePointManager facePointManager;
        super.A();
        if (this.k <= 0 && (facePointManager = this.n) != null && facePointManager.x) {
            facePointManager.b();
        }
    }

    public final boolean B() {
        return this.r.contains(Integer.valueOf(VerifyType.FACE.type));
    }

    public final String G() {
        int intExtra = getIntent().getIntExtra("scence", -1);
        return intExtra + "";
    }

    public abstract String H();

    public abstract void I(String str);

    public abstract void J(Intent intent);

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void distributeEvent(EventVerifyMethodUpdate eventVerifyMethodUpdate) {
        if (s()) {
            ArrayList arrayList = eventVerifyMethodUpdate.f559a;
            this.r = arrayList;
            if (arrayList == null || arrayList.size() <= 1) {
                this.m.moreTv.setVisibility(8);
            } else {
                this.m.moreTv.setVisibility(0);
            }
        }
    }

    public final void onBackPressed() {
        KtaCollect.n_face_verification_page_click(G(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
        super.onBackPressed();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityBaseVerifyFaceBinding inflate = ActivityBaseVerifyFaceBinding.inflate(getLayoutInflater());
        this.m = inflate;
        setContentView((View) inflate.getRoot());
        if (getIntent() != null) {
            this.p = getIntent().getStringExtra("mobileNo");
            this.q = getIntent().getIntExtra("scence", 0);
            this.r = getIntent().getIntegerArrayListExtra("methodList");
            J(getIntent());
        } else {
            finish();
        }
        EventBus.b().i(this);
        KtaCollect.n_face_verification_page_exposure(G());
        y();
        TrustLivenessUtil.Companion.a(new y0(this, 0), new b(this));
        this.m.openFaceButton.setOnClickListener(new t0(this, 1));
        this.m.pageTitle.backward.setOnClickListener(new OnSafeClickListener() {
            public final void a(View view) {
                BaseVerifyFaceActivity.this.onBackPressed();
            }
        });
        this.m.pageTitle.title.setText(H());
        this.m.moreTv.setOnClickListener(new OnSafeClickListener() {
            public final void a(View view) {
                BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                KtaCollect.n_face_verification_page_click(baseVerifyFaceActivity.G(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                ArrayList arrayList = new ArrayList(1);
                ArrayList arrayList2 = new ArrayList(1);
                ArrayList arrayList3 = baseVerifyFaceActivity.r;
                VerifyType verifyType = VerifyType.OTP;
                if (arrayList3.contains(Integer.valueOf(verifyType.type))) {
                    arrayList.add(verifyType);
                    arrayList2.add(baseVerifyFaceActivity.getString(R.string.verity_otp));
                }
                FacePointManager facePointManager = baseVerifyFaceActivity.n;
                if (facePointManager != null) {
                    facePointManager.x = true;
                    facePointManager.d();
                }
                DialogUtils.k(baseVerifyFaceActivity, (String[]) arrayList2.toArray(new String[arrayList2.size()]), baseVerifyFaceActivity.getString(R.string.login_pwd_more_cancel), new c(baseVerifyFaceActivity, arrayList)).setOnDismissListener(new c1((BaseActivity) baseVerifyFaceActivity, 0));
            }
        });
        ArrayList arrayList = this.r;
        if (arrayList == null || arrayList.size() <= 1) {
            this.m.moreTv.setVisibility(8);
        } else {
            this.m.moreTv.setVisibility(0);
        }
    }

    public final void onDestroy() {
        FacePointManager facePointManager = this.n;
        if (facePointManager != null) {
            facePointManager.f();
            if (facePointManager.l != null) {
                facePointManager.l = null;
            }
        }
        EventBus.b().k(this);
        super.onDestroy();
    }

    public final void onPause() {
        FacePointManager facePointManager = this.n;
        if (facePointManager != null) {
            facePointManager.d();
        }
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        FacePointManager facePointManager = this.n;
        if (facePointManager != null) {
            facePointManager.e();
        }
    }

    public final void z() {
        super.z();
        FacePointManager facePointManager = this.n;
        if (facePointManager != null && this.k > 0 && !facePointManager.x) {
            facePointManager.x = true;
            facePointManager.d();
        }
    }
}
