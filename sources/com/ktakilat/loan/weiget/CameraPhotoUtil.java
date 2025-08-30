package com.ktakilat.loan.weiget;

import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.loan.normal_ui.EktpCameraActivity;
import com.ktakilat.loan.normal_ui.LivenessGuideActivity;
import com.ktakilat.loan.webtool.e;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

public class CameraPhotoUtil {

    public interface CameraPermissionCallback {
    }

    public static void a(final BaseActivity baseActivity, File file, final e eVar) {
        final Uri uriForFile = FileProvider.getUriForFile(baseActivity, baseActivity.getPackageName() + ".fileprovider", file);
        KtaCollect.n_request_permission("Camera", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        new RxPermissions(baseActivity).b("android.permission.CAMERA").subscribe(new Observer<Boolean>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
                KtaCollect.n_request_permission("Camera", ExifInterface.GPS_MEASUREMENT_2D);
                th.toString();
                ArrayList arrayList = LogActivity.k;
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
                e.this.b(bool.booleanValue());
                if (bool.booleanValue()) {
                    int i = EktpCameraActivity.x;
                    BaseActivity baseActivity = baseActivity;
                    Intent intent = new Intent(baseActivity, EktpCameraActivity.class);
                    intent.putExtra(ShareConstants.MEDIA_URI, uriForFile);
                    baseActivity.startActivityForResult(intent, 3000);
                }
            }

            public final void onSubscribe(Disposable disposable) {
            }
        });
    }

    public static void b(final BaseActivity baseActivity, final e eVar) {
        KtaCollect.n_request_permission("Camera", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        new RxPermissions(baseActivity).b("android.permission.CAMERA").subscribe(new Observer<Boolean>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
                KtaCollect.n_request_permission("Camera", ExifInterface.GPS_MEASUREMENT_2D);
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
                eVar.b(bool.booleanValue());
                if (bool.booleanValue()) {
                    int i = LivenessGuideActivity.e;
                    BaseActivity baseActivity = baseActivity;
                    Intrinsics.checkNotNullParameter(baseActivity, "activity");
                    baseActivity.startActivityForResult(new Intent(baseActivity, LivenessGuideActivity.class), AuthApiStatusCodes.AUTH_API_SERVER_ERROR);
                }
            }

            public final void onSubscribe(Disposable disposable) {
            }
        });
    }
}
