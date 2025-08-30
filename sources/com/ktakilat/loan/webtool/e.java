package com.ktakilat.loan.webtool;

import android.content.pm.PackageInfo;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.loan.R;
import com.ktakilat.loan.webtool.CommonWebViewSetting;
import com.ktakilat.loan.webtool.JsMap;
import com.ktakilat.loan.weiget.CameraPhotoUtil;
import com.ktakilat.loan.weiget.GpsUtil;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.ktakilat.loan.weiget.i;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;

public final /* synthetic */ class e implements CameraPhotoUtil.CameraPermissionCallback, GpsUtil.GpsCallback, ObservableOnSubscribe {
    public final /* synthetic */ int c;
    public final /* synthetic */ CommonWebViewSetting.JsCallAndroidInterface d;

    public /* synthetic */ e(CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface, int i) {
        this.c = i;
        this.d = jsCallAndroidInterface;
    }

    public void a(boolean z, boolean z2, double d2, double d3) {
        switch (this.c) {
            case 2:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface = this.d;
                jsCallAndroidInterface.getClass();
                if (!z || !z2) {
                    JsMap.ThirdMap.b(jsCallAndroidInterface.f577a, -1.0d, -1.0d, "");
                    return;
                } else {
                    Observable.create(new g(jsCallAndroidInterface, d2, d3)).subscribeOn(Schedulers.c).observeOn(AndroidSchedulers.a()).subscribe(new Observer<String>(d2, d3) {
                        public final /* synthetic */ double c;
                        public final /* synthetic */ double d;

                        {
                            this.c = r2;
                            this.d = r4;
                        }

                        public final void onComplete() {
                        }

                        public final void onError(Throwable th) {
                            BaseActivity baseActivity;
                            JsCallAndroidInterface jsCallAndroidInterface = JsCallAndroidInterface.this;
                            if (jsCallAndroidInterface.f577a != null && (baseActivity = jsCallAndroidInterface.b) != null && !baseActivity.isFinishing() && !jsCallAndroidInterface.b.isDestroyed()) {
                                JsMap.ThirdMap.b(jsCallAndroidInterface.f577a, this.c, this.d, "");
                            }
                        }

                        public final void onNext(Object obj) {
                            BaseActivity baseActivity;
                            String str = (String) obj;
                            JsCallAndroidInterface jsCallAndroidInterface = JsCallAndroidInterface.this;
                            if (jsCallAndroidInterface.f577a != null && (baseActivity = jsCallAndroidInterface.b) != null && !baseActivity.isFinishing() && !baseActivity.isDestroyed()) {
                                JsMap.ThirdMap.b(jsCallAndroidInterface.f577a, this.c, this.d, str);
                            }
                        }

                        public final void onSubscribe(Disposable disposable) {
                        }
                    });
                    return;
                }
            default:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface2 = this.d;
                jsCallAndroidInterface2.getClass();
                if (!z || !z2) {
                    JsMap.ThirdMap.b(jsCallAndroidInterface2.f577a, -1.0d, -1.0d, "");
                    return;
                }
                BaseActivity baseActivity = jsCallAndroidInterface2.b;
                GpsUtil.a(baseActivity, new i(jsCallAndroidInterface2.f577a, baseActivity), false);
                return;
        }
    }

    public void b(boolean z) {
        switch (this.c) {
            case 0:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface = this.d;
                if (!z) {
                    BaseActivity baseActivity = jsCallAndroidInterface.b;
                    DialogUtils.h(baseActivity, baseActivity.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                    return;
                }
                jsCallAndroidInterface.getClass();
                return;
            default:
                CommonWebViewSetting.JsCallAndroidInterface jsCallAndroidInterface2 = this.d;
                if (!z) {
                    BaseActivity baseActivity2 = jsCallAndroidInterface2.b;
                    DialogUtils.h(baseActivity2, baseActivity2.getString(R.string.camera), (DialogUtils.SettingStatusCall) null);
                    return;
                }
                jsCallAndroidInterface2.getClass();
                return;
        }
    }

    public void d(ObservableEmitter observableEmitter) {
        BaseActivity baseActivity = this.d.b;
        ArrayList arrayList = new ArrayList();
        try {
            for (PackageInfo packageInfo : baseActivity.getPackageManager().getInstalledPackages(0)) {
                try {
                    arrayList.add(packageInfo.packageName);
                } catch (Exception e) {
                    e.toString();
                    ArrayList arrayList2 = LogActivity.k;
                }
            }
        } catch (Exception e2) {
            e2.toString();
            ArrayList arrayList3 = LogActivity.k;
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }
}
