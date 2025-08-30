package com.ktakilat.loan.weiget;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.google.gson.reflect.TypeToken;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.ImageDataLoader;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.gesture_create.b;
import com.ktakilat.loan.global.AppKv;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.gesture.GestureConfigItem;
import com.ktakilat.loan.http.gesture.GestureSwitchResp;
import com.ktakilat.loan.http.gesture.IsSuccessResp;
import com.ktakilat.loan.http.user.UserLoginResp;
import com.ktakilat.loan.web.CommonWebFragment;
import com.ktakilat.loan.weiget.WebCookieManager;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.pendanaan.kta.databinding.DialogGestureGuideBinding;
import com.trello.rxlifecycle2.LifecycleTransformer;
import java.util.ArrayList;
import java.util.List;

public class GestureUtil {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f591a;
    public final Handler b = new Handler(Looper.getMainLooper());
    public CountDownTimer c;

    public interface CheckCallback {
        void a(boolean z);
    }

    public enum GestureSetEnum {
        REGISTER("register"),
        LOGIN_PWD("login_pwd_suc"),
        LOGIN_OTP("login_otp_suc"),
        LOGIN_FACE("login_face_suc"),
        FORGET_PWD("forget_pwd"),
        CHANGE_MOBILE("change_mobile"),
        OVERDUE_VERIFY("overdue_verify"),
        DEVICE_VERIFY("device_verify"),
        LOAN_CDTIME_END_AND_OPEN_HOME_PAGE("loan_cdtime_end_and_open_home_page"),
        UPLOAD_SIGNATURE_SUC("upload_signature_suc"),
        PAYMENT_END_AND_BILL_PRE("payment_end_and_bill_pre"),
        SETTING("setting");
        
        public final String c;

        /* access modifiers changed from: public */
        GestureSetEnum(String str) {
            this.c = str;
        }

        public String getType() {
            return this.c;
        }
    }

    public interface LoadGestureOpenCallback {
        void a(boolean z, boolean z2);
    }

    public interface LoginGestureCallback {
    }

    public interface SetGestureCallback {
    }

    public GestureUtil(BaseActivity baseActivity) {
        this.f591a = baseActivity;
    }

    public static void a(GestureUtil gestureUtil) {
        Activity activity;
        if (gestureUtil.h() && (activity = gestureUtil.f591a) != null && (activity instanceof BaseActivity)) {
            ((BaseActivity) activity).u();
        }
    }

    public final void b() {
        Activity activity;
        if (h() && (activity = this.f591a) != null && (activity instanceof BaseActivity)) {
            ((BaseActivity) activity).n();
        }
    }

    public final void c(ArrayList arrayList, final b bVar) {
        if (h() && arrayList != null && !arrayList.isEmpty()) {
            b();
            AppHttp.setGesture((LifecycleTransformer<BaseResponse<IsSuccessResp>>) null, arrayList).subscribe(new ApiObserver<BaseResponse<IsSuccessResp>>() {
                public final void a(BaseResponse baseResponse) {
                    GestureUtil gestureUtil = GestureUtil.this;
                    if (gestureUtil.h()) {
                        ResponseCodeDeal.a(baseResponse);
                        GestureUtil.a(gestureUtil);
                        bVar.a(false);
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    GestureUtil gestureUtil = GestureUtil.this;
                    if (gestureUtil.h()) {
                        GestureUtil.a(gestureUtil);
                        bVar.a(((IsSuccessResp) baseResponse.getData()).isSuccess());
                    }
                }
            });
        }
    }

    /* JADX WARNING: type inference failed for: r5v1, types: [u9, java.lang.Object] */
    public final void d() {
        if (h() && !AppKv.g().f465a.getBoolean("gesture_guid_dialog", false)) {
            AppKv.g().f465a.putBoolean("gesture_guid_dialog", true);
            Activity g = g();
            if (g != null) {
                DialogGestureGuideBinding inflate = DialogGestureGuideBinding.inflate(LayoutInflater.from(g));
                ImageDataLoader.Companion.a(inflate.gestureGifImage, Integer.valueOf(R.drawable.gif_gesture_guid));
                KtaCollect.n_pattern_guide_exposure();
                DialogUtils.b(g(), inflate.getRoot(), inflate.nextTv, new t9(0), new Object()).show();
                final TextView textView = inflate.nextTv;
                if (h()) {
                    CountDownTimer countDownTimer = this.c;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                        this.c = null;
                    }
                    AnonymousClass7 r1 = new CountDownTimer() {
                        public final void onFinish() {
                            GestureUtil gestureUtil = GestureUtil.this;
                            if (gestureUtil.h()) {
                                gestureUtil.b.post(new b(1, this, textView));
                            }
                        }

                        public final void onTick(long j) {
                            GestureUtil gestureUtil = GestureUtil.this;
                            if (gestureUtil.h()) {
                                gestureUtil.b.post(new h(this, textView, j));
                            }
                        }
                    };
                    this.c = r1;
                    r1.start();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e(final com.ktakilat.loan.weiget.GestureUtil.GestureSetEnum r7, final com.ktakilat.loan.weiget.GestureUtil.CheckCallback r8) {
        /*
            r6 = this;
            boolean r0 = r6.h()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.util.List r0 = com.ktakilat.loan.global.AppKv.e()
            boolean r1 = r6.h()
            r2 = 0
            if (r1 != 0) goto L_0x0014
        L_0x0012:
            r1 = r2
            goto L_0x003a
        L_0x0014:
            if (r7 == 0) goto L_0x0012
            if (r0 == 0) goto L_0x0012
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0012
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0012
            java.lang.Object r1 = r0.next()
            com.ktakilat.loan.http.gesture.GestureConfigItem r1 = (com.ktakilat.loan.http.gesture.GestureConfigItem) r1
            java.lang.String r3 = r7.getType()
            java.lang.String r4 = r1.scence
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0022
        L_0x003a:
            if (r1 == 0) goto L_0x00af
            boolean r0 = r1.canSet
            if (r0 != 0) goto L_0x0041
            goto L_0x00af
        L_0x0041:
            boolean r0 = r1.canDialog
            if (r0 == 0) goto L_0x0086
            android.app.Activity r0 = r6.g()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            com.pendanaan.kta.databinding.DialogGestureTipBinding r0 = com.pendanaan.kta.databinding.DialogGestureTipBinding.inflate(r0)
            android.app.Activity r3 = r6.g()
            android.widget.RelativeLayout r4 = r0.getRoot()
            android.widget.TextView r0 = r0.nextTv
            com.ktakilat.loan.weiget.GestureUtil$4 r5 = new com.ktakilat.loan.weiget.GestureUtil$4
            r5.<init>(r7, r1, r8)
            com.ktakilat.cbase.ui.BaseDialog r0 = com.ktakilat.loan.weiget.dialog.DialogUtils.b(r3, r4, r0, r5, r2)
            s9 r1 = new s9
            r1.<init>(r6, r7, r8)
            r0.setOnCancelListener(r1)
            java.lang.String r7 = r7.getType()
            java.lang.String r8 = "scene"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r1.putString(r8, r7)
            java.lang.String r7 = "n_pop_set_patter_pwd_exposure"
            com.ktakilat.cbase.datacollect.KtaEvent.Companion.b(r7, r1)
            r0.show()
            goto L_0x00ae
        L_0x0086:
            android.app.Activity r0 = r6.g()
            java.lang.String r7 = r7.getType()
            boolean r1 = r1.canSkip
            int r2 = com.ktakilat.loan.gesture_create.GestureCreateActivity.o
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.ktakilat.loan.gesture_create.GestureCreateActivity> r3 = com.ktakilat.loan.gesture_create.GestureCreateActivity.class
            r2.<init>(r0, r3)
            java.lang.String r3 = "isCanSkip"
            r2.putExtra(r3, r1)
            java.lang.String r1 = "scence"
            r2.putExtra(r1, r7)
            r7 = 500(0x1f4, float:7.0E-43)
            r0.startActivityForResult(r2, r7)
            if (r8 == 0) goto L_0x00ae
            r7 = 1
            r8.a(r7)
        L_0x00ae:
            return
        L_0x00af:
            if (r8 == 0) goto L_0x00b5
            r7 = 0
            r8.a(r7)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ktakilat.loan.weiget.GestureUtil.e(com.ktakilat.loan.weiget.GestureUtil$GestureSetEnum, com.ktakilat.loan.weiget.GestureUtil$CheckCallback):void");
    }

    public final void f(final GestureSetEnum gestureSetEnum, final CheckCallback checkCallback) {
        if (h()) {
            List e = AppKv.e();
            b();
            if (e == null || e.isEmpty()) {
                i(new g(this, gestureSetEnum, checkCallback));
            } else if (h()) {
                AppHttp.getGestureSwitch((LifecycleTransformer<BaseResponse<GestureSwitchResp>>) null).subscribe(new ApiObserver<BaseResponse<GestureSwitchResp>>() {
                    public final void a(BaseResponse baseResponse) {
                        GestureUtil gestureUtil = GestureUtil.this;
                        if (gestureUtil.h()) {
                            if (gestureSetEnum == GestureSetEnum.SETTING) {
                                ToastUtil.d(gestureUtil.g(), baseResponse.getMsg());
                            }
                            CheckCallback checkCallback = checkCallback;
                            if (checkCallback != null) {
                                checkCallback.a(false);
                            }
                            GestureUtil.a(gestureUtil);
                        }
                    }

                    public final void b(BaseResponse baseResponse) {
                        GestureUtil gestureUtil = GestureUtil.this;
                        if (gestureUtil.h()) {
                            GestureUtil.a(gestureUtil);
                            Object data = baseResponse.getData();
                            CheckCallback checkCallback = checkCallback;
                            GestureSetEnum gestureSetEnum = gestureSetEnum;
                            if (data == null || !((GestureSwitchResp) baseResponse.getData()).isMasterSwitchOn() || !((GestureSwitchResp) baseResponse.getData()).isVersionSupportedOn()) {
                                if (gestureSetEnum == GestureSetEnum.SETTING) {
                                    ToastUtil.c(gestureUtil.g(), R.string.gesture_not_enable);
                                }
                            } else if (gestureSetEnum == GestureSetEnum.SETTING) {
                                gestureUtil.e(gestureSetEnum, checkCallback);
                                return;
                            } else if (!((GestureSwitchResp) baseResponse.getData()).isHasGesture()) {
                                gestureUtil.e(gestureSetEnum, checkCallback);
                                return;
                            }
                            if (checkCallback != null) {
                                checkCallback.a(false);
                            }
                        }
                    }
                });
            }
        }
    }

    public final Activity g() {
        Activity activity;
        if (!h() || (activity = this.f591a) == null) {
            return null;
        }
        return activity;
    }

    public final boolean h() {
        Activity activity = this.f591a;
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    public final void i(final g gVar) {
        if (h()) {
            AppHttp.getGestureConfig((LifecycleTransformer<BaseResponse<String>>) null).subscribe(new ApiObserver<BaseResponse<String>>() {

                /* renamed from: com.ktakilat.loan.weiget.GestureUtil$1$1  reason: invalid class name */
                class AnonymousClass1 extends TypeToken<List<GestureConfigItem>> {
                }

                public final void a(BaseResponse baseResponse) {
                    g gVar = g.this;
                    if (gVar != null) {
                        gVar.a(true);
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    Object obj;
                    List b = JsonUtil.b((String) baseResponse.getData(), new TypeToken());
                    if (b == null) {
                        obj = "null";
                    } else {
                        obj = Integer.valueOf(b.size());
                    }
                    obj.toString();
                    AppKv.g().b("gesture_config", JsonUtil.a(b));
                    g gVar = g.this;
                    if (gVar != null) {
                        gVar.a(true);
                    }
                }
            });
        }
    }

    public final void j(final LoadGestureOpenCallback loadGestureOpenCallback) {
        if (h()) {
            b();
            AppHttp.getGestureSwitch((LifecycleTransformer<BaseResponse<GestureSwitchResp>>) null).subscribe(new ApiObserver<BaseResponse<GestureSwitchResp>>() {
                public final void a(BaseResponse baseResponse) {
                    GestureUtil gestureUtil = GestureUtil.this;
                    if (gestureUtil.h()) {
                        ResponseCodeDeal.a(baseResponse);
                        GestureUtil.a(gestureUtil);
                        LoadGestureOpenCallback loadGestureOpenCallback = loadGestureOpenCallback;
                        if (loadGestureOpenCallback != null) {
                            loadGestureOpenCallback.a(false, false);
                        }
                    }
                }

                public final void b(BaseResponse baseResponse) {
                    GestureUtil gestureUtil = GestureUtil.this;
                    if (gestureUtil.h()) {
                        Object data = baseResponse.getData();
                        LoadGestureOpenCallback loadGestureOpenCallback = loadGestureOpenCallback;
                        if (data == null || !((GestureSwitchResp) baseResponse.getData()).isMasterSwitchOn() || !((GestureSwitchResp) baseResponse.getData()).isVersionSupportedOn()) {
                            loadGestureOpenCallback.a(false, false);
                        } else {
                            loadGestureOpenCallback.a(true, ((GestureSwitchResp) baseResponse.getData()).isHasGesture());
                        }
                        GestureUtil.a(gestureUtil);
                    }
                }
            });
        }
    }

    public final void k(String str, ArrayList arrayList, double d, double d2, final com.ktakilat.loan.login_gesture.b bVar) {
        if (h()) {
            b();
            AppHttp.loginGesture((LifecycleTransformer<BaseResponse<UserLoginResp>>) null, str, arrayList, d, d2).subscribe(new ApiObserver<BaseResponse<UserLoginResp>>() {
                public final void a(BaseResponse baseResponse) {
                    GestureUtil gestureUtil = GestureUtil.this;
                    if (gestureUtil.h()) {
                        KtaCollect.n_login_page_result(ExifInterface.GPS_MEASUREMENT_3D, AppEventsConstants.EVENT_PARAM_VALUE_NO, baseResponse.getMsg());
                        GestureUtil.a(gestureUtil);
                        boolean equals = "A000306".equals(baseResponse.getCode());
                        com.ktakilat.loan.login_gesture.b bVar = bVar;
                        if (equals) {
                            bVar.a(true, (UserLoginResp) null, (Boolean) null);
                        } else if (baseResponse.getCode().equals("A000030") || baseResponse.getCode().equals("A000031")) {
                            bVar.a(true, (UserLoginResp) null, Boolean.TRUE);
                        } else if (baseResponse.getCode().equals("A000293")) {
                            bVar.a(true, (UserLoginResp) null, Boolean.FALSE);
                        } else {
                            ResponseCodeDeal.a(baseResponse);
                        }
                    }
                }

                public final void b(final BaseResponse baseResponse) {
                    GestureUtil gestureUtil = GestureUtil.this;
                    if (gestureUtil.h()) {
                        if (baseResponse.getData() != null) {
                            KtaCollect.n_login_page_result(ExifInterface.GPS_MEASUREMENT_3D, AppEventsConstants.EVENT_PARAM_VALUE_YES, (String) null);
                            KtakilatApplication ktakilatApplication = KtakilatApplication.m;
                            String token = ((UserLoginResp) baseResponse.getData()).getToken();
                            String userId = ((UserLoginResp) baseResponse.getData()).getUserId();
                            String mobileNo = ((UserLoginResp) baseResponse.getData()).getMobileNo();
                            AnonymousClass1 r4 = new WebCookieManager.CookieCallback() {
                                public final void d() {
                                    AnonymousClass6 r0 = AnonymousClass6.this;
                                    if (GestureUtil.this.h()) {
                                        bVar.a(false, (UserLoginResp) baseResponse.getData(), (Boolean) null);
                                        GestureUtil.a(GestureUtil.this);
                                    }
                                }
                            };
                            ktakilatApplication.getClass();
                            KtakilatApplication.k(token, userId, mobileNo, r4);
                            return;
                        }
                        KtaCollect.n_login_page_result(ExifInterface.GPS_MEASUREMENT_3D, AppEventsConstants.EVENT_PARAM_VALUE_NO, baseResponse.getMsg());
                        bVar.a(false, (UserLoginResp) null, (Boolean) null);
                        GestureUtil.a(gestureUtil);
                    }
                }
            });
        }
    }

    public GestureUtil(Activity activity) {
        this.f591a = activity;
    }

    public GestureUtil(CommonWebFragment commonWebFragment) {
        this.f591a = commonWebFragment.b();
    }
}
