package com.ktakilat.loan.normal_ui;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.ktakilat.cbase.datacollect.KtaCollect;
import com.ktakilat.cbase.ui.BaseActivity;
import com.ktakilat.cbase.ui.LogActivity;
import com.ktakilat.cbase.ui.PermissionUtils;
import com.ktakilat.cbase.utils.location.LocationUtil;
import com.ktakilat.cbase.weight.DanaDialog;
import com.ktakilat.loan.R;
import com.ktakilat.loan.weiget.GpsUtil;
import com.ktakilat.loan.weiget.i;
import com.pendanaan.kta.databinding.ActivityGoogleMapBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class GoogleMapActivity extends BaseActivity {
    public static final /* synthetic */ int q = 0;
    public GoogleMap i;
    public double j;
    public double k;
    public CameraPosition l;
    public AddressAsyncTask m;
    public String n = "";
    public LocationUtil o;
    public ActivityGoogleMapBinding p;

    public class AddressAsyncTask extends AsyncTask<String, Integer, String> {
        public AddressAsyncTask() {
        }

        public final Object doInBackground(Object[] objArr) {
            String[] strArr = (String[]) objArr;
            if (strArr.length != 2) {
                return "";
            }
            LatLng latLng = new LatLng(Double.parseDouble(strArr[0]), Double.parseDouble(strArr[1]));
            GoogleMapActivity googleMapActivity = GoogleMapActivity.this;
            googleMapActivity.getClass();
            StringBuilder sb = new StringBuilder();
            try {
                List<Address> fromLocation = new Geocoder(googleMapActivity, Locale.getDefault()).getFromLocation(latLng.latitude, latLng.longitude, 1);
                if (fromLocation.size() >= 1) {
                    for (int i = 0; i <= fromLocation.get(0).getMaxAddressLineIndex(); i++) {
                        sb.append(fromLocation.get(0).getAddressLine(i));
                        sb.append(", ");
                    }
                    String trim = sb.toString().trim();
                    googleMapActivity.n = trim;
                    if (TextUtils.isEmpty(trim)) {
                        googleMapActivity.n = "";
                    } else {
                        String str = googleMapActivity.n;
                        googleMapActivity.n = str.substring(0, str.length() - 1);
                    }
                }
            } catch (IOException e) {
                e.toString();
                ArrayList arrayList = LogActivity.k;
            }
            return googleMapActivity.n;
        }

        public final void onCancelled() {
        }

        public final void onPostExecute(Object obj) {
            String str = (String) obj;
            super.onPostExecute(str);
            GoogleMapActivity.this.p.address.setText(str);
        }

        public final void onPreExecute() {
        }

        public final void onProgressUpdate(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            GoogleMapActivity googleMapActivity = GoogleMapActivity.this;
            googleMapActivity.p.address.setText(googleMapActivity.getString(R.string.searching));
        }
    }

    public interface LocationPermissionCallback {
    }

    public static void A(BaseActivity baseActivity, int i2) {
        Intent intent = new Intent(baseActivity, GoogleMapActivity.class);
        intent.putExtra("flag", "googleMap");
        intent.putExtra("witchPage", i2);
        baseActivity.startActivityForResult(intent, 4001);
    }

    public static void B(final BaseActivity baseActivity, String str) {
        DanaDialog danaDialog = new DanaDialog(baseActivity);
        danaDialog.l = baseActivity.getString(R.string.alert_prompt);
        danaDialog.k = baseActivity.getString(R.string.permission_dialog) + StringUtils.SPACE + str + StringUtils.SPACE + baseActivity.getString(R.string.permission_dialog2);
        danaDialog.n = baseActivity.getString(R.string.nav_item_3);
        danaDialog.m = baseActivity.getString(R.string.cancel);
        danaDialog.q = new DanaDialog.OnClickListener() {
            public final void a(DanaDialog danaDialog) {
                danaDialog.dismiss();
            }

            public final void b(DanaDialog danaDialog) {
                danaDialog.dismiss();
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                StringBuilder sb = new StringBuilder("package:");
                BaseActivity baseActivity = BaseActivity.this;
                sb.append(baseActivity.getPackageName());
                intent.setData(Uri.parse(sb.toString()));
                baseActivity.startActivity(intent);
            }
        };
        danaDialog.show();
    }

    public static void C(int i2, x2 x2Var, BaseActivity baseActivity) {
        String[] strArr = {"android.permission.ACCESS_COARSE_LOCATION"};
        ArrayList arrayList = new ArrayList(0);
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(baseActivity, strArr[0]) != 0) {
                arrayList.add(strArr[0]);
            }
            if (!arrayList.isEmpty()) {
                KtaCollect.n_request_permission("Map", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                new RxPermissions(baseActivity).b((String[]) arrayList.toArray(new String[arrayList.size()])).subscribe(new Observer<Boolean>(i2, x2Var, baseActivity) {
                    public final /* synthetic */ BaseActivity c;
                    public final /* synthetic */ int d;

                    {
                        this.c = r3;
                        this.d = r1;
                    }

                    public final void onComplete() {
                    }

                    public final void onError(Throwable th) {
                        KtaCollect.n_request_permission("Map", ExifInterface.GPS_MEASUREMENT_2D);
                    }

                    public final void onNext(Object obj) {
                        String str;
                        Boolean bool = (Boolean) obj;
                        if (bool.booleanValue()) {
                            str = AppEventsConstants.EVENT_PARAM_VALUE_YES;
                        } else {
                            str = "-1";
                        }
                        KtaCollect.n_request_permission("Map", str);
                        boolean booleanValue = bool.booleanValue();
                        BaseActivity baseActivity = this.c;
                        if (booleanValue) {
                            GoogleMapActivity.A(baseActivity, this.d);
                        } else {
                            GoogleMapActivity.B(baseActivity, baseActivity.getString(R.string.gps));
                        }
                    }

                    public final void onSubscribe(Disposable disposable) {
                    }
                });
                return;
            }
            A(baseActivity, i2);
            return;
        }
        A(baseActivity, i2);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityGoogleMapBinding inflate = ActivityGoogleMapBinding.inflate(getLayoutInflater());
        this.p = inflate;
        setContentView((View) inflate.getRoot());
        KtaCollect.n_google_address_exposure(String.valueOf(getIntent().getIntExtra("witchPage", -1)));
        this.p.pageTitle.title.setText(getString(R.string.address_title));
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (supportMapFragment != null) {
            supportMapFragment.getMapAsync(new z9(this));
            if (TextUtils.equals(getIntent().getStringExtra("flag"), "googleMap")) {
                this.p.addr.setText(getString(R.string.address_title_a));
                this.p.address.setHint(getString(R.string.address_title_hint_a));
            } else {
                this.p.addr.setText(getString(R.string.address_title_c));
                this.p.address.setHint(getString(R.string.address_title_hint_c));
            }
            LocationUtil locationUtil = new LocationUtil();
            this.o = locationUtil;
            locationUtil.d = new x9(this);
            locationUtil.b(this);
        }
        this.p.address.setOnFocusChangeListener(new w9(0));
        this.p.pageTitle.backward.setOnClickListener(new t0(this, 6));
        this.p.btnOk.setOnClickListener(new a(this, 1));
        this.p.address.setOnClickListener(new y9(0));
        GpsUtil.a(this, new i((WebView) null, this), true);
    }

    public final void onDestroy() {
        KtaCollect.n_google_address_clc_back();
        AddressAsyncTask addressAsyncTask = this.m;
        if (addressAsyncTask != null) {
            if (addressAsyncTask.isCancelled()) {
                this.m.cancel(true);
            }
            this.m = null;
        }
        u();
        LocationUtil locationUtil = this.o;
        if (locationUtil != null) {
            locationUtil.c();
        }
        super.onDestroy();
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 4000) {
            int i3 = 0;
            while (true) {
                if (i3 >= strArr.length) {
                    break;
                } else if (!"android.permission.ACCESS_COARSE_LOCATION".equals(strArr[i3])) {
                    i3++;
                } else if (iArr[i3] == 0) {
                    z();
                    return;
                }
            }
            B(this, getString(R.string.gps));
        }
    }

    public final void x() {
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), new u0(this));
    }

    public final void z() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            GoogleMap googleMap = this.i;
            if (googleMap != null) {
                googleMap.setMyLocationEnabled(true);
            }
        } else if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.ACCESS_COARSE_LOCATION")) {
            Bundle bundle = new Bundle();
            bundle.putInt("requestCode", 4000);
            bundle.putBoolean(ConstantHelper.LOG_FINISH, true);
            PermissionUtils.RationaleDialog rationaleDialog = new PermissionUtils.RationaleDialog();
            rationaleDialog.setArguments(bundle);
            rationaleDialog.show(getSupportFragmentManager(), "dialog");
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 4000);
        }
    }
}
