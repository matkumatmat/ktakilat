package com.ktakilat.cbase.utils.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

public class GPSLocation implements LocationListener {
    public static Location e;
    public static double f;
    public static double g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f479a;
    public boolean b = false;
    public LocationManager c;
    public x9 d;

    public GPSLocation(Context context) {
        this.f479a = context;
    }

    public final void onLocationChanged(Location location) {
        if (location != null) {
            f = location.getLatitude();
            double longitude = location.getLongitude();
            g = longitude;
            x9 x9Var = this.d;
            if (x9Var != null) {
                x9Var.a(f, longitude);
                this.d = null;
            }
        }
        if (this.c != null && ContextCompat.checkSelfPermission(this.f479a, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
            this.c.removeUpdates(this);
        }
    }

    public final void onProviderDisabled(String str) {
    }

    public final void onProviderEnabled(String str) {
    }

    public final void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
