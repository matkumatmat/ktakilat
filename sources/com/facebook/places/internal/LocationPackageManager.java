package com.facebook.places.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.places.internal.ScannerException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class LocationPackageManager {
    private static final String TAG = "LocationPackageManager";

    public interface Listener {
        void onLocationPackage(LocationPackage locationPackage);
    }

    /* access modifiers changed from: private */
    public static void logException(String str, Throwable th) {
        if (FacebookSdk.isDebugEnabled()) {
            Log.e(TAG, str, th);
        }
    }

    /* access modifiers changed from: private */
    public static FutureTask<LocationPackage> newBluetoothScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|6|8|9|(1:11)(3:14|(1:16)|17)) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0023 */
            /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[Catch:{ all -> 0x0021, Exception -> 0x0035 }] */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0037 A[Catch:{ all -> 0x0021, Exception -> 0x0035 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.facebook.places.internal.LocationPackage call() throws java.lang.Exception {
                /*
                    r6 = this;
                    r0 = 1
                    r1 = 0
                    com.facebook.places.internal.LocationPackage r2 = new com.facebook.places.internal.LocationPackage
                    r2.<init>()
                    android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x0035 }
                    com.facebook.places.internal.LocationPackageRequestParams r4 = r2     // Catch:{ Exception -> 0x0035 }
                    com.facebook.places.internal.BleScanner r3 = com.facebook.places.internal.ScannerFactory.newBleScanner(r3, r4)     // Catch:{ Exception -> 0x0035 }
                    r3.initAndCheckEligibility()     // Catch:{ Exception -> 0x0035 }
                    r3.startScanning()     // Catch:{ all -> 0x0021 }
                    com.facebook.places.internal.LocationPackageRequestParams r4 = r2     // Catch:{ Exception -> 0x0023 }
                    long r4 = r4.getBluetoothScanDurationMs()     // Catch:{ Exception -> 0x0023 }
                    java.lang.Thread.sleep(r4)     // Catch:{ Exception -> 0x0023 }
                    goto L_0x0023
                L_0x0021:
                    r0 = move-exception
                    goto L_0x004d
                L_0x0023:
                    r3.stopScanning()     // Catch:{ Exception -> 0x0035 }
                    int r4 = r3.getErrorCode()     // Catch:{ Exception -> 0x0035 }
                    if (r4 != 0) goto L_0x0037
                    java.util.List r3 = r3.getScanResults()     // Catch:{ Exception -> 0x0035 }
                    r2.ambientBluetoothLe = r3     // Catch:{ Exception -> 0x0035 }
                    r2.isBluetoothScanningEnabled = r0     // Catch:{ Exception -> 0x0035 }
                    goto L_0x0058
                L_0x0035:
                    r0 = move-exception
                    goto L_0x0051
                L_0x0037:
                    boolean r3 = com.facebook.FacebookSdk.isDebugEnabled()     // Catch:{ Exception -> 0x0035 }
                    if (r3 == 0) goto L_0x004a
                    java.lang.String r3 = "Bluetooth LE scan failed with error: %d"
                    java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0035 }
                    java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0035 }
                    r0[r1] = r4     // Catch:{ Exception -> 0x0035 }
                    java.lang.String.format(r3, r0)     // Catch:{ Exception -> 0x0035 }
                L_0x004a:
                    r2.isBluetoothScanningEnabled = r1     // Catch:{ Exception -> 0x0035 }
                    goto L_0x0058
                L_0x004d:
                    r3.stopScanning()     // Catch:{ Exception -> 0x0035 }
                    throw r0     // Catch:{ Exception -> 0x0035 }
                L_0x0051:
                    java.lang.String r3 = "Exception scanning for bluetooth beacons"
                    com.facebook.places.internal.LocationPackageManager.logException(r3, r0)
                    r2.isBluetoothScanningEnabled = r1
                L_0x0058:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.places.internal.LocationPackageManager.AnonymousClass3.call():com.facebook.places.internal.LocationPackage");
            }
        });
    }

    /* access modifiers changed from: private */
    public static FutureTask<LocationPackage> newLocationScanFuture(final LocationScanner locationScanner, LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            public LocationPackage call() throws Exception {
                LocationPackage locationPackage = new LocationPackage();
                try {
                    locationPackage.location = locationScanner.getLocation();
                } catch (ScannerException e) {
                    locationPackage.locationError = e.type;
                    LocationPackageManager.logException("Exception while getting location", e);
                } catch (Exception unused) {
                    locationPackage.locationError = ScannerException.Type.UNKNOWN_ERROR;
                }
                return locationPackage;
            }
        });
    }

    /* access modifiers changed from: private */
    public static FutureTask<LocationPackage> newWifiScanFuture(final LocationPackageRequestParams locationPackageRequestParams) {
        return new FutureTask<>(new Callable<LocationPackage>() {
            public LocationPackage call() throws Exception {
                LocationPackage locationPackage = new LocationPackage();
                try {
                    WifiScanner newWifiScanner = ScannerFactory.newWifiScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                    newWifiScanner.initAndCheckEligibility();
                    locationPackage.connectedWifi = newWifiScanner.getConnectedWifi();
                    boolean isWifiScanningEnabled = newWifiScanner.isWifiScanningEnabled();
                    locationPackage.isWifiScanningEnabled = isWifiScanningEnabled;
                    if (isWifiScanningEnabled) {
                        locationPackage.ambientWifi = newWifiScanner.getWifiScans();
                    }
                } catch (Exception e) {
                    LocationPackageManager.logException("Exception scanning for wifi access points", e);
                    locationPackage.isWifiScanningEnabled = false;
                }
                return locationPackage;
            }
        });
    }

    public static void requestLocationPackage(final LocationPackageRequestParams locationPackageRequestParams, final Listener listener) {
        FacebookSdk.getExecutor().execute(new Runnable() {
            public void run() {
                FutureTask futureTask;
                FutureTask futureTask2;
                LocationPackage locationPackage = new LocationPackage();
                try {
                    FutureTask futureTask3 = null;
                    if (locationPackageRequestParams.isLocationScanEnabled()) {
                        LocationScanner newLocationScanner = ScannerFactory.newLocationScanner(FacebookSdk.getApplicationContext(), locationPackageRequestParams);
                        newLocationScanner.initAndCheckEligibility();
                        futureTask = LocationPackageManager.newLocationScanFuture(newLocationScanner, locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask);
                    } else {
                        futureTask = null;
                    }
                    if (locationPackageRequestParams.isWifiScanEnabled()) {
                        futureTask2 = LocationPackageManager.newWifiScanFuture(locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask2);
                    } else {
                        futureTask2 = null;
                    }
                    if (locationPackageRequestParams.isBluetoothScanEnabled()) {
                        futureTask3 = LocationPackageManager.newBluetoothScanFuture(locationPackageRequestParams);
                        FacebookSdk.getExecutor().execute(futureTask3);
                    }
                    if (futureTask3 != null) {
                        try {
                            LocationPackage locationPackage2 = (LocationPackage) futureTask3.get();
                            locationPackage.ambientBluetoothLe = locationPackage2.ambientBluetoothLe;
                            locationPackage.isBluetoothScanningEnabled = locationPackage2.isBluetoothScanningEnabled;
                        } catch (Exception e) {
                            LocationPackageManager.logException("Exception scanning for bluetooth beacons", e);
                        }
                    }
                    if (futureTask2 != null) {
                        try {
                            LocationPackage locationPackage3 = (LocationPackage) futureTask2.get();
                            locationPackage.isWifiScanningEnabled = locationPackage3.isWifiScanningEnabled;
                            locationPackage.connectedWifi = locationPackage3.connectedWifi;
                            locationPackage.ambientWifi = locationPackage3.ambientWifi;
                        } catch (Exception e2) {
                            LocationPackageManager.logException("Exception scanning for wifi access points", e2);
                        }
                    }
                    if (futureTask != null) {
                        try {
                            LocationPackage locationPackage4 = (LocationPackage) futureTask.get();
                            locationPackage.locationError = locationPackage4.locationError;
                            locationPackage.location = locationPackage4.location;
                        } catch (Exception e3) {
                            LocationPackageManager.logException("Exception getting location", e3);
                        }
                    }
                } catch (ScannerException e4) {
                    LocationPackageManager.logException("Exception scanning for locations", e4);
                    locationPackage.locationError = e4.type;
                } catch (Exception e5) {
                    LocationPackageManager.logException("Exception requesting a location package", e5);
                }
                listener.onLocationPackage(locationPackage);
            }
        });
    }
}
