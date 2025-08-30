package com.ktakilat.loan.weiget;

import android.app.Activity;
import android.location.LocationManager;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.AppEventsConstants;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.utils.location.LocationUtils;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.dialog.DialogUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

public class GpsUtil {

    public interface GpsCallback {
        void a(boolean z, boolean z2, double d, double d2);
    }

    public interface GpsIgnoreCallback {
        void a(double d, double d2);
    }

    public static void a(final Activity activity, final GpsCallback gpsCallback, final boolean z) {
        KtaCollect.n_request_permission("Access_coarse_location", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        new RxPermissions(activity).b("android.permission.ACCESS_COARSE_LOCATION").subscribe(new Observer<Boolean>() {
            public final void onComplete() {
            }

            public final void onError(Throwable th) {
                KtaCollect.n_request_permission("Access_coarse_location", ExifInterface.GPS_MEASUREMENT_2D);
            }

            public final void onNext(Object obj) {
                String str;
                double d2;
                double d3;
                Boolean bool = (Boolean) obj;
                if (bool.booleanValue()) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                } else {
                    str = "-1";
                }
                KtaCollect.n_request_permission("Access_coarse_location", str);
                boolean booleanValue = bool.booleanValue();
                GpsCallback gpsCallback = gpsCallback;
                boolean z = z;
                Activity activity = activity;
                if (booleanValue) {
                    LocationManager locationManager = (LocationManager) activity.getSystemService("location");
                    boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
                    boolean isProviderEnabled2 = locationManager.isProviderEnabled("network");
                    if (isProviderEnabled || isProviderEnabled2) {
                        HashMap b = LocationUtils.b(activity);
                        if (b.get("lat") == null) {
                            d2 = 0.0d;
                        } else {
                            d2 = ((Double) b.get("lat")).doubleValue();
                        }
                        if (b.get("lon") == null) {
                            d3 = 0.0d;
                        } else {
                            d3 = ((Double) b.get("lon")).doubleValue();
                        }
                        gpsCallback.a(true, true, d2, d3);
                        return;
                    }
                    if (z) {
                        DialogUtils.h(activity, activity.getString(R.string.gps), (DialogUtils.SettingStatusCall) null);
                    }
                    gpsCallback.a(true, false, 0.0d, 0.0d);
                    return;
                }
                if (z) {
                    DialogUtils.h(activity, activity.getString(R.string.gps), (DialogUtils.SettingStatusCall) null);
                }
                gpsCallback.a(false, false, 0.0d, 0.0d);
            }

            public final void onSubscribe(Disposable disposable) {
            }
        });
    }

    public static void b(BaseActivity baseActivity, GpsIgnoreCallback gpsIgnoreCallback) {
        double d;
        HashMap b = LocationUtils.b(baseActivity);
        double d2 = 0.0d;
        if (b.get("lat") == null) {
            d = 0.0d;
        } else {
            d = ((Double) b.get("lat")).doubleValue();
        }
        if (b.get("lon") != null) {
            d2 = ((Double) b.get("lon")).doubleValue();
        }
        gpsIgnoreCallback.a(d, d2);
    }
}
