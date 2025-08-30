package com.ktakilat.loan.verify_face;

import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.katkilat.baidu_face.manager.FacePointManager;
import com.katkilat.baidu_face.widget.TimeoutDialog;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.ApiObserver;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.utils.ImageUtil;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.http.AppHttp;
import com.ktakilat.loan.http.verify.VerifyOtpResp;
import com.ktakilat.loan.weiget.GpsUtil;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import java.io.File;
import kotlin.jvm.functions.Function0;
import org.greenrobot.eventbus.EventBus;

public final /* synthetic */ class b implements Function0 {
    public final /* synthetic */ BaseVerifyFaceActivity c;

    public /* synthetic */ b(BaseVerifyFaceActivity baseVerifyFaceActivity) {
        this.c = baseVerifyFaceActivity;
    }

    public final Object invoke() {
        int i = BaseVerifyFaceActivity.s;
        BaseVerifyFaceActivity baseVerifyFaceActivity = this.c;
        baseVerifyFaceActivity.getClass();
        baseVerifyFaceActivity.runOnUiThread(new a1(baseVerifyFaceActivity, 3));
        baseVerifyFaceActivity.n = new FacePointManager(baseVerifyFaceActivity);
        if (baseVerifyFaceActivity.getWindow() != null) {
            baseVerifyFaceActivity.getWindow().getDecorView().setSystemUiVisibility(1280);
        }
        baseVerifyFaceActivity.m.faceContentLayout.addView(baseVerifyFaceActivity.n.a(new FacePointManager.Companion.InitCall() {
            public final void a(String str) {
                if (str != null) {
                    BaseVerifyFaceActivity.this.m.faceSecondTip.setText(str);
                }
            }

            public final void b() {
                int i = BaseVerifyFaceActivity.s;
                BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                baseVerifyFaceActivity.z();
                TimeoutDialog timeoutDialog = new TimeoutDialog(baseVerifyFaceActivity, new TimeoutDialog.OnTimeoutDialogClickListener() {
                    public final void a() {
                        BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                        baseVerifyFaceActivity.o.dismiss();
                        baseVerifyFaceActivity.A();
                    }

                    public final void b() {
                        BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                        baseVerifyFaceActivity.o.dismiss();
                        baseVerifyFaceActivity.finish();
                    }
                });
                baseVerifyFaceActivity.o = timeoutDialog;
                timeoutDialog.setCanceledOnTouchOutside(false);
                baseVerifyFaceActivity.o.setCancelable(false);
                baseVerifyFaceActivity.o.show();
            }

            public final void c(String str) {
                if (str != null) {
                    BaseVerifyFaceActivity.this.m.faceTopTip.setText(str);
                }
            }

            public final void d(byte[] bArr) {
                KtakilatApplication.m.getClass();
                KtakilatApplication.j();
                KtakilatApplication.m.getClass();
                File cacheDir = BaseApplication.e.getCacheDir();
                String path = new File(cacheDir, System.currentTimeMillis() + ".jpg").getPath();
                boolean a2 = ImageUtil.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), path);
                BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                baseVerifyFaceActivity.z();
                if (a2) {
                    baseVerifyFaceActivity.y();
                    GpsUtil.b(baseVerifyFaceActivity, new GpsUtil.GpsIgnoreCallback(path) {

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ String f554a;

                        {
                            this.f554a = r2;
                        }

                        public final void a(double d, double d2) {
                            ActivityEvent activityEvent = ActivityEvent.DESTROY;
                            BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                            AppHttp.commonFirstVerifyByFace(RxLifecycle.a(baseVerifyFaceActivity.c, activityEvent), baseVerifyFaceActivity.p, baseVerifyFaceActivity.q, new File(this.f554a), this.f554a, d, d2).subscribe(new ApiObserver<BaseResponse<VerifyOtpResp>>() {
                                public final void a(BaseResponse baseResponse) {
                                    AnonymousClass6 r0 = AnonymousClass6.this;
                                    BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                                    int i = BaseVerifyFaceActivity.s;
                                    baseVerifyFaceActivity.o();
                                    ResponseCodeDeal.b(baseResponse);
                                    BaseVerifyFaceActivity.this.A();
                                    KtaCollect.n_face_verification_page_result(BaseVerifyFaceActivity.this.G(), ExifInterface.GPS_MEASUREMENT_2D);
                                    if ("A100322".equals(baseResponse.getCode())) {
                                        try {
                                            BaseVerifyFaceActivity.this.r.remove(Integer.valueOf(VerifyType.FACE.type));
                                            EventBus.b().e(new EventVerifyMethodUpdate(BaseVerifyFaceActivity.this.r));
                                        } catch (Exception unused) {
                                        }
                                        if (BaseVerifyFaceActivity.this.r.contains(Integer.valueOf(VerifyType.OTP.type))) {
                                            BaseVerifyFaceActivity baseVerifyFaceActivity2 = BaseVerifyFaceActivity.this;
                                            baseVerifyFaceActivity2.I(baseVerifyFaceActivity2.p);
                                            return;
                                        }
                                        BaseVerifyFaceActivity.this.finish();
                                    }
                                }

                                public final void b(BaseResponse baseResponse) {
                                    AnonymousClass6 r0 = AnonymousClass6.this;
                                    BaseVerifyFaceActivity baseVerifyFaceActivity = BaseVerifyFaceActivity.this;
                                    int i = BaseVerifyFaceActivity.s;
                                    baseVerifyFaceActivity.o();
                                    int result = ((VerifyOtpResp) baseResponse.getData()).getResult();
                                    BaseVerifyFaceActivity baseVerifyFaceActivity2 = BaseVerifyFaceActivity.this;
                                    if (result == 1) {
                                        KtaCollect.n_face_verification_page_result(baseVerifyFaceActivity2.G(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                        baseVerifyFaceActivity2.E(((VerifyOtpResp) baseResponse.getData()).getSuccessfulValidationToken(), ((VerifyOtpResp) baseResponse.getData()).getAuthStatusList(), ((VerifyOtpResp) baseResponse.getData()).getLoginResp());
                                    } else if (((VerifyOtpResp) baseResponse.getData()).getResult() == 2) {
                                        KtaCollect.n_face_verification_page_result(baseVerifyFaceActivity2.G(), AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                        baseVerifyFaceActivity2.D(((VerifyOtpResp) baseResponse.getData()).getTwoFactorVerificationToken(), ((VerifyOtpResp) baseResponse.getData()).getEktp());
                                    } else {
                                        KtaCollect.n_face_verification_page_result(baseVerifyFaceActivity2.G(), AppEventsConstants.EVENT_PARAM_VALUE_YES);
                                    }
                                    baseVerifyFaceActivity2.A();
                                }
                            });
                        }
                    });
                    return;
                }
                baseVerifyFaceActivity.A();
            }
        }));
        baseVerifyFaceActivity.n.c();
        return null;
    }
}
