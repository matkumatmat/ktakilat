package com.ktakilat.cbase.utils.location;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.ktakilat.loan.normal_ui.GoogleMapActivity;

public class LocationUtil {

    /* renamed from: a  reason: collision with root package name */
    public GoogleApiClient f480a;
    public LocationRequest b;
    public GoogleMapActivity c;
    public x9 d;
    public GPSLocation e;
    public LocationListener f;
    public GoogleApiClient.OnConnectionFailedListener g;
    public GoogleApiClient.ConnectionCallbacks h;
    public double i;
    public double j;
    public Handler k = new Handler(new Handler.Callback() {
        public final boolean handleMessage(Message message) {
            LocationUtil locationUtil = LocationUtil.this;
            locationUtil.d();
            if (locationUtil.i != 0.0d || locationUtil.j != 0.0d) {
                return false;
            }
            locationUtil.a(locationUtil.c);
            return false;
        }
    });

    public final void a(GoogleMapActivity googleMapActivity) {
        GPSLocation gPSLocation = new GPSLocation(googleMapActivity);
        this.e = gPSLocation;
        gPSLocation.d = this.d;
        try {
            LocationManager locationManager = (LocationManager) gPSLocation.f479a.getSystemService("location");
            gPSLocation.c = locationManager;
            gPSLocation.b = locationManager.isProviderEnabled("gps");
            boolean isProviderEnabled = gPSLocation.c.isProviderEnabled("network");
            if (gPSLocation.b || isProviderEnabled) {
                if (isProviderEnabled) {
                    try {
                        gPSLocation.c.requestLocationUpdates("network", 1000, 0.0f, gPSLocation);
                        LocationManager locationManager2 = gPSLocation.c;
                        if (locationManager2 != null) {
                            Location lastKnownLocation = locationManager2.getLastKnownLocation("network");
                            GPSLocation.e = lastKnownLocation;
                            if (lastKnownLocation != null) {
                                GPSLocation.f = lastKnownLocation.getLatitude();
                                double longitude = GPSLocation.e.getLongitude();
                                GPSLocation.g = longitude;
                                x9 x9Var = gPSLocation.d;
                                if (x9Var != null) {
                                    double d2 = GPSLocation.f;
                                    if (!(d2 == 0.0d || longitude == 0.0d)) {
                                        x9Var.a(d2, longitude);
                                        gPSLocation.d = null;
                                        return;
                                    }
                                }
                            } else {
                                gPSLocation.c.requestLocationUpdates("network", 5000, 1.0f, gPSLocation);
                            }
                        }
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
                if (gPSLocation.b && GPSLocation.e == null) {
                    try {
                        gPSLocation.c.requestLocationUpdates("gps", 1000, 0.0f, gPSLocation);
                        LocationManager locationManager3 = gPSLocation.c;
                        if (locationManager3 != null) {
                            Location lastKnownLocation2 = locationManager3.getLastKnownLocation("gps");
                            GPSLocation.e = lastKnownLocation2;
                            if (lastKnownLocation2 != null) {
                                GPSLocation.f = lastKnownLocation2.getLatitude();
                                double longitude2 = GPSLocation.e.getLongitude();
                                GPSLocation.g = longitude2;
                                x9 x9Var2 = gPSLocation.d;
                                if (x9Var2 != null) {
                                    double d3 = GPSLocation.f;
                                    if (!(d3 == 0.0d || longitude2 == 0.0d)) {
                                        x9Var2.a(d3, longitude2);
                                        gPSLocation.d = null;
                                        return;
                                    }
                                }
                            } else {
                                gPSLocation.c.requestLocationUpdates("gps", 5000, 1.0f, gPSLocation);
                            }
                        }
                    } catch (SecurityException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        x9 x9Var3 = gPSLocation.d;
        if (x9Var3 != null) {
            double d4 = GPSLocation.f;
            if (d4 != 0.0d) {
                double d5 = GPSLocation.g;
                if (d5 != 0.0d) {
                    x9Var3.a(d4, d5);
                    gPSLocation.d = null;
                }
            }
        }
    }

    public final void b(GoogleMapActivity googleMapActivity) {
        this.c = googleMapActivity;
        this.b = LocationRequest.create();
        this.f = new LocationListener() {
            public final void onLocationChanged(Location location) {
                if (location != null) {
                    LocationUtil locationUtil = LocationUtil.this;
                    if (locationUtil.d != null) {
                        locationUtil.i = location.getLatitude();
                        double longitude = location.getLongitude();
                        locationUtil.j = longitude;
                        locationUtil.d.a(locationUtil.i, longitude);
                    }
                }
            }
        };
        this.g = new GoogleApiClient.OnConnectionFailedListener() {
            public final void onConnectionFailed(ConnectionResult connectionResult) {
                LocationUtil locationUtil = LocationUtil.this;
                locationUtil.a(locationUtil.c);
            }
        };
        this.h = new GoogleApiClient.ConnectionCallbacks() {
            public final void onConnected(Bundle bundle) {
                LocationUtil locationUtil = LocationUtil.this;
                if (ContextCompat.checkSelfPermission(locationUtil.c, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                    if (locationUtil.b == null) {
                        locationUtil.b = LocationRequest.create();
                    }
                    locationUtil.b.setPriority(102);
                    locationUtil.b.setInterval(120000);
                    GoogleApiClient googleApiClient = locationUtil.f480a;
                    if (googleApiClient != null) {
                        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationUtil.b, locationUtil.f);
                        Handler handler = locationUtil.k;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(0, 2000);
                        }
                    }
                }
            }

            public final void onConnectionSuspended(int i) {
                LocationUtil locationUtil = LocationUtil.this;
                locationUtil.a(locationUtil.c);
            }
        };
        GoogleApiClient.Builder addOnConnectionFailedListener = new GoogleApiClient.Builder(this.c).addConnectionCallbacks(this.h).addOnConnectionFailedListener(this.g);
        Api<Api.ApiOptions.NoOptions> api = LocationServices.API;
        this.f480a = addOnConnectionFailedListener.addApi(api).build();
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(googleMapActivity) == 0) {
            if (this.f480a == null) {
                this.f480a = new GoogleApiClient.Builder(googleMapActivity).addConnectionCallbacks(this.h).addOnConnectionFailedListener(this.g).addApi(api).build();
            }
            GoogleApiClient googleApiClient = this.f480a;
            if (googleApiClient != null) {
                googleApiClient.connect();
                return;
            }
            return;
        }
        a(googleMapActivity);
    }

    public final void c() {
        this.i = 0.0d;
        this.j = 0.0d;
        d();
        try {
            GPSLocation gPSLocation = this.e;
            if (!(gPSLocation == null || gPSLocation.c == null || ContextCompat.checkSelfPermission(gPSLocation.f479a, "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                gPSLocation.c.removeUpdates(gPSLocation);
            }
        } catch (Exception unused) {
        }
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.k = null;
        }
    }

    public final void d() {
        try {
            GoogleApiClient googleApiClient = this.f480a;
            if (googleApiClient != null && googleApiClient.isConnected()) {
                this.f480a.disconnect();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            this.d = null;
            this.b = null;
            this.f480a = null;
            throw th;
        }
        this.d = null;
        this.b = null;
        this.f480a = null;
    }
}
