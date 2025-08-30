package com.ktakilat.loan.face_login_onoff;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.idl.face.platform.LivenessTypeEnum;
import com.facebook.appevents.AppEventsConstants;
import com.katkilat.baidu_face.manager.BaiduFaceManager;
import com.katkilat.baidu_face.manager.FacePointManager;
import com.katkilat.baidu_face.widget.TimeoutDialog;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.http.BaseResponse;
import com.ktakilat.cbase.http.ResponseCodeDeal;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.BaseApplication;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.cbase.utils.ImageUtil;
import com.ktakilat.cbase.utils.JsonUtil;
import com.ktakilat.cbase.utils.ToastUtil;
import com.ktakilat.cbase.utils.location.LocationUtils;
import com.ktakilat.loan.KtakilatApplication;
import com.ktakilat.loan.R;
import com.ktakilat.loan.face_login_onoff.FaceLoginOnOffContact;
import com.ktakilat.loan.http.kta_face.FaceLoginResp;
import com.ktakilat.loan.http.kta_face.FaceOpenResp;
import com.ktakilat.loan.weiget.FaceLoginOnOffUtil;
import com.pendanaan.kta.databinding.ActivityFaceLoginOnoffBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressLint({"NonConstantResourceId"})
public class FaceLoginOnOffActivity extends BaseActivity implements FaceLoginOnOffContact.View {
    public static final /* synthetic */ int p = 0;
    public FacePointManager i;
    public FaceLoginOnOffUtil j;
    public TimeoutDialog k;
    public int l = 0;
    public String m;
    public String n = null;
    public ActivityFaceLoginOnoffBinding o;

    public interface PermissionCallback {
        void c(boolean z);
    }

    public static void A(int i2, Activity activity, PermissionCallback permissionCallback, String str, String str2) {
        KtaCollect.n_request_permission("Camera", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        final int i3 = i2;
        final Activity activity2 = activity;
        final PermissionCallback permissionCallback2 = permissionCallback;
        final String str3 = str2;
        final String str4 = str;
        new RxPermissions(activity).b("android.permission.CAMERA").subscribe(new Observer<Boolean>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
                KtaCollect.n_request_permission("Camera", ExifInterface.GPS_MEASUREMENT_2D);
                th.toString();
                ArrayList arrayList = LogActivity.k;
                permissionCallback2.c(false);
            }

            /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object, kotlin.Lazy] */
            public final void onNext(Object obj) {
                String str;
                Boolean bool = (Boolean) obj;
                if (bool.booleanValue()) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                } else {
                    str = "-1";
                }
                KtaCollect.n_request_permission("Camera", str);
                if (bool.booleanValue()) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(LivenessTypeEnum.HeadRight);
                    int i = i3;
                    Activity activity = activity2;
                    v6 v6Var = new v6(activity, i, str3, str4);
                    a aVar = new a(this, activity);
                    ((BaiduFaceManager) BaiduFaceManager.f457a.getValue()).getClass();
                    BaiduFaceManager.a(activity, arrayList, v6Var, aVar);
                }
                permissionCallback2.c(bool.booleanValue());
            }

            public final void onSubscribe(Disposable disposable) {
            }
        });
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityFaceLoginOnoffBinding inflate = ActivityFaceLoginOnoffBinding.inflate(getLayoutInflater());
        this.o = inflate;
        setContentView((View) inflate.getRoot());
        this.o.pageTitle.backward.setOnClickListener(new t0(this, 4));
        if (getIntent() != null) {
            this.l = getIntent().getIntExtra("requestCode", 0);
            this.n = getIntent().getStringExtra("mobileNo");
            this.m = getIntent().getStringExtra("scence");
        }
        if (this.l == 0) {
            finish();
            return;
        }
        KtaCollect.n_face_login_exposure(this.m);
        this.j = new FaceLoginOnOffUtil(this);
        FacePointManager facePointManager = new FacePointManager(this);
        this.i = facePointManager;
        this.o.faceContentLayout.addView(facePointManager.a(new FacePointManager.Companion.InitCall() {
            public final void a(String str) {
                if (str != null) {
                    FaceLoginOnOffActivity.this.o.faceTipBottom.setText(str);
                }
            }

            public final void b() {
                KtaCollect.n_face_result(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                FacePointManager facePointManager = faceLoginOnOffActivity.i;
                facePointManager.x = true;
                facePointManager.d();
                TimeoutDialog timeoutDialog = new TimeoutDialog(faceLoginOnOffActivity, new TimeoutDialog.OnTimeoutDialogClickListener() {
                    public final void a() {
                        FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                        faceLoginOnOffActivity.k.dismiss();
                        faceLoginOnOffActivity.i.b();
                    }

                    public final void b() {
                        FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                        faceLoginOnOffActivity.k.dismiss();
                        faceLoginOnOffActivity.onBackPressed();
                    }
                });
                faceLoginOnOffActivity.k = timeoutDialog;
                timeoutDialog.setCanceledOnTouchOutside(false);
                faceLoginOnOffActivity.k.setCancelable(false);
                faceLoginOnOffActivity.k.show();
            }

            public final void c(String str) {
                if (str != null) {
                    FaceLoginOnOffActivity.this.o.faceTipTop.setText(str);
                }
            }

            public final void d(byte[] bArr) {
                double d;
                KtaCollect.n_face_result(AppEventsConstants.EVENT_PARAM_VALUE_YES);
                KtakilatApplication.m.getClass();
                KtakilatApplication.j();
                KtakilatApplication.m.getClass();
                String path = new File(BaseApplication.e.getCacheDir(), System.currentTimeMillis() + ".jpg").getPath();
                boolean a2 = ImageUtil.a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), path);
                FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                FacePointManager facePointManager = faceLoginOnOffActivity.i;
                facePointManager.x = true;
                facePointManager.d();
                if (a2) {
                    int i = faceLoginOnOffActivity.l;
                    if (i == 10001) {
                        faceLoginOnOffActivity.j.j(new File(path), new FaceLoginOnOffUtil.FaceOpenOnOffCall() {
                            public final void a(FaceOpenResp faceOpenResp) {
                                FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                                if (faceOpenResp == null) {
                                    faceLoginOnOffActivity.i.b();
                                } else if (faceOpenResp.getEnableFaceLoginResult() == 1) {
                                    faceLoginOnOffActivity.getClass();
                                    ToastUtil.c(faceLoginOnOffActivity, R.string.face_onoff_opened);
                                    faceLoginOnOffActivity.setResult(-1);
                                    faceLoginOnOffActivity.onBackPressed();
                                } else if (faceOpenResp.getEnableFaceLoginResult() == 2) {
                                    faceLoginOnOffActivity.j.b(faceOpenResp.getTwoFactorVerificationToken(), faceOpenResp.getEktp(), true, new FaceLoginOnOffUtil.EktpCall() {
                                        public final void a(boolean z, BaseResponse baseResponse) {
                                            FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                                            if (z) {
                                                faceLoginOnOffActivity.getClass();
                                                ToastUtil.c(faceLoginOnOffActivity, R.string.face_onoff_opened);
                                                faceLoginOnOffActivity.setResult(-1);
                                                faceLoginOnOffActivity.onBackPressed();
                                            } else if (baseResponse == null) {
                                                faceLoginOnOffActivity.i.b();
                                            } else if (baseResponse.isSuc() || baseResponse.getCode().equals("A000030") || baseResponse.getCode().equals("A000031") || baseResponse.getCode().equals("A000293") || baseResponse.getCode().equals("A000306")) {
                                                faceLoginOnOffActivity.z(baseResponse);
                                            } else {
                                                ResponseCodeDeal.a(baseResponse);
                                            }
                                        }
                                    });
                                } else {
                                    ToastUtil.c(faceLoginOnOffActivity, R.string.face_login_open_fail);
                                    faceLoginOnOffActivity.i.b();
                                }
                            }
                        });
                    } else if (i == 10000) {
                        HashMap b = LocationUtils.b(faceLoginOnOffActivity);
                        double d2 = 0.0d;
                        if (b.get("lat") == null) {
                            d = 0.0d;
                        } else {
                            d = ((Double) b.get("lat")).doubleValue();
                        }
                        if (b.get("lon") != null) {
                            d2 = ((Double) b.get("lon")).doubleValue();
                        }
                        faceLoginOnOffActivity.j.h(faceLoginOnOffActivity.n, d, d2, new File(path), new FaceLoginOnOffUtil.FaceLoginCall() {
                            public final void a(BaseResponse baseResponse) {
                                boolean isSuc = baseResponse.isSuc();
                                FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                                if (isSuc) {
                                    KtaCollect.n_face_login_suc();
                                    if (((FaceLoginResp) baseResponse.getData()).getFaceLoginResult() == 2) {
                                        faceLoginOnOffActivity.j.b(((FaceLoginResp) baseResponse.getData()).getTwoFactorVerificationToken(), ((FaceLoginResp) baseResponse.getData()).getEktp(), false, new FaceLoginOnOffUtil.EktpCall() {
                                            public final void a(boolean z, BaseResponse baseResponse) {
                                                FaceLoginOnOffActivity faceLoginOnOffActivity = FaceLoginOnOffActivity.this;
                                                if (baseResponse == null) {
                                                    faceLoginOnOffActivity.i.b();
                                                } else if (baseResponse.isSuc() || baseResponse.getCode().equals("A000030") || baseResponse.getCode().equals("A000031") || baseResponse.getCode().equals("A000293") || baseResponse.getCode().equals("A000306")) {
                                                    faceLoginOnOffActivity.z(baseResponse);
                                                } else {
                                                    KtaCollect.n_login_page_result("4", AppEventsConstants.EVENT_PARAM_VALUE_NO, baseResponse.getMsg());
                                                    ResponseCodeDeal.a(baseResponse);
                                                }
                                            }
                                        });
                                    } else if (((FaceLoginResp) baseResponse.getData()).getFaceLoginResult() == 0) {
                                        ToastUtil.c(faceLoginOnOffActivity, R.string.face_login_result_fail);
                                        faceLoginOnOffActivity.i.b();
                                    } else {
                                        BaseResponse baseResponse2 = new BaseResponse();
                                        baseResponse2.setSuccess(true);
                                        baseResponse2.setData(((FaceLoginResp) baseResponse.getData()).getLoginResp());
                                        faceLoginOnOffActivity.z(baseResponse2);
                                    }
                                } else {
                                    KtaCollect.n_face_login_fail(baseResponse.getCode());
                                    if (baseResponse.getCode().equals("A000030") || baseResponse.getCode().equals("A000031") || baseResponse.getCode().equals("A000293") || baseResponse.getCode().equals("A000306")) {
                                        BaseResponse baseResponse3 = new BaseResponse();
                                        baseResponse3.setSuccess(baseResponse.isSuccess());
                                        baseResponse3.setCode(baseResponse.getCode());
                                        baseResponse3.setMsg(baseResponse.getMsg());
                                        faceLoginOnOffActivity.z(baseResponse3);
                                        return;
                                    }
                                    KtaCollect.n_login_page_result("4", AppEventsConstants.EVENT_PARAM_VALUE_NO, baseResponse.getMsg());
                                    faceLoginOnOffActivity.i.b();
                                    ResponseCodeDeal.a(baseResponse);
                                }
                            }
                        });
                    }
                } else {
                    faceLoginOnOffActivity.i.b();
                }
            }
        }));
        this.i.c();
    }

    public final void onDestroy() {
        FacePointManager facePointManager = this.i;
        facePointManager.f();
        if (facePointManager.l != null) {
            facePointManager.l = null;
        }
        super.onDestroy();
    }

    public final void onPause() {
        this.i.d();
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.i.e();
    }

    public final void z(BaseResponse baseResponse) {
        Intent intent = new Intent();
        intent.putExtra("response", JsonUtil.a(baseResponse));
        intent.putExtra("userLoginResp", JsonUtil.a(baseResponse.getData()));
        setResult(-1, intent);
        onBackPressed();
    }
}
