package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.facebook.FacebookException;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = "com.facebook.internal.AttributionIdentifiers";
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    public static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private IBinder binder;

        public GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        private GoogleAdServiceConnection() {
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
        }

        public IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                return this.queue.take();
            }
            throw new IllegalStateException("Binder already consumed");
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        return attributionIdentifiers;
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection != null) {
            return androidIdViaReflection;
        }
        AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
        if (androidIdViaService == null) {
            return new AttributionIdentifiers();
        }
        return androidIdViaService;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        Object invokeMethodQuietly;
        Class<Context> cls = Context.class;
        try {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{cls});
                if (methodQuietly == null) {
                    return null;
                }
                Object invokeMethodQuietly2 = Utility.invokeMethodQuietly((Object) null, methodQuietly, context);
                if (invokeMethodQuietly2 instanceof Integer) {
                    if (((Integer) invokeMethodQuietly2).intValue() == 0) {
                        Method methodQuietly2 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{cls});
                        if (methodQuietly2 == null || (invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly2, context)) == null) {
                            return null;
                        }
                        Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                        Method methodQuietly4 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                        if (methodQuietly3 != null) {
                            if (methodQuietly4 != null) {
                                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                                attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                                attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly4, new Object[0])).booleanValue();
                                return attributionIdentifiers;
                            }
                        }
                    }
                }
                return null;
            }
            throw new FacebookException("getAndroidId cannot be called on the main thread.");
        } catch (Exception e) {
            Utility.logd("android_id", e);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                return attributionIdentifiers;
            } catch (Exception e) {
                Utility.logd("android_id", e);
            } finally {
                context.unbindService(googleAdServiceConnection);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b A[Catch:{ Exception -> 0x004d, all -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f A[Catch:{ Exception -> 0x004d, all -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0074 A[Catch:{ Exception -> 0x004d, all -> 0x004a }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r12) {
        /*
            java.lang.String r0 = "limit_tracking"
            java.lang.String r1 = "androidid"
            java.lang.String r2 = "aid"
            android.os.Looper r3 = android.os.Looper.myLooper()
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            if (r3 != r4) goto L_0x0017
            java.lang.String r3 = TAG
            java.lang.String r4 = "getAttributionIdentifiers should not be called from the main thread"
            android.util.Log.e(r3, r4)
        L_0x0017:
            com.facebook.internal.AttributionIdentifiers r3 = recentlyFetchedIdentifiers
            if (r3 == 0) goto L_0x002c
            long r3 = java.lang.System.currentTimeMillis()
            com.facebook.internal.AttributionIdentifiers r5 = recentlyFetchedIdentifiers
            long r6 = r5.fetchTime
            long r3 = r3 - r6
            r6 = 3600000(0x36ee80, double:1.7786363E-317)
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x002c
            return r5
        L_0x002c:
            com.facebook.internal.AttributionIdentifiers r3 = getAndroidId(r12)
            r4 = 0
            java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            java.lang.String r6 = "com.facebook.katana.provider.AttributionIdProvider"
            r8 = 0
            android.content.pm.ProviderInfo r5 = r5.resolveContentProvider(r6, r8)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r5 == 0) goto L_0x0051
            java.lang.String r5 = "content://com.facebook.katana.provider.AttributionIdProvider"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
        L_0x0048:
            r6 = r5
            goto L_0x0065
        L_0x004a:
            r12 = move-exception
            goto L_0x00db
        L_0x004d:
            r12 = move-exception
            r0 = r4
            goto L_0x00d0
        L_0x0051:
            android.content.pm.PackageManager r5 = r12.getPackageManager()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            java.lang.String r6 = "com.facebook.wakizashi.provider.AttributionIdProvider"
            android.content.pm.ProviderInfo r5 = r5.resolveContentProvider(r6, r8)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r5 == 0) goto L_0x0064
            java.lang.String r5 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            goto L_0x0048
        L_0x0064:
            r6 = r4
        L_0x0065:
            java.lang.String r5 = getInstallerPackageName(r12)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r5 == 0) goto L_0x006d
            r3.androidInstallerPackage = r5     // Catch:{ Exception -> 0x004d, all -> 0x004a }
        L_0x006d:
            if (r6 != 0) goto L_0x0074
            com.facebook.internal.AttributionIdentifiers r12 = cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            return r12
        L_0x0074:
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            r9 = 0
            r10 = 0
            r8 = 0
            android.database.Cursor r12 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004d, all -> 0x004a }
            if (r12 == 0) goto L_0x00c6
            boolean r5 = r12.moveToFirst()     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r5 != 0) goto L_0x0088
            goto L_0x00c6
        L_0x0088:
            int r2 = r12.getColumnIndex(r2)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            int r1 = r12.getColumnIndex(r1)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            int r0 = r12.getColumnIndex(r0)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            java.lang.String r2 = r12.getString(r2)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            r3.attributionId = r2     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r1 <= 0) goto L_0x00be
            if (r0 <= 0) goto L_0x00be
            java.lang.String r2 = r3.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r2 != 0) goto L_0x00be
            java.lang.String r1 = r12.getString(r1)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            r3.androidAdvertiserId = r1     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            java.lang.String r0 = r12.getString(r0)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            r3.limitTracking = r0     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            goto L_0x00be
        L_0x00b5:
            r0 = move-exception
            r4 = r12
            r12 = r0
            goto L_0x00db
        L_0x00b9:
            r0 = move-exception
            r11 = r0
            r0 = r12
            r12 = r11
            goto L_0x00d0
        L_0x00be:
            r12.close()
            com.facebook.internal.AttributionIdentifiers r12 = cacheAndReturnIdentifiers(r3)
            return r12
        L_0x00c6:
            com.facebook.internal.AttributionIdentifiers r0 = cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00b9, all -> 0x00b5 }
            if (r12 == 0) goto L_0x00cf
            r12.close()
        L_0x00cf:
            return r0
        L_0x00d0:
            r12.toString()     // Catch:{ all -> 0x00d9 }
            if (r0 == 0) goto L_0x00d8
            r0.close()
        L_0x00d8:
            return r4
        L_0x00d9:
            r12 = move-exception
            r4 = r0
        L_0x00db:
            if (r4 == 0) goto L_0x00e0
            r4.close()
        L_0x00e0:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    @Nullable
    private static String getInstallerPackageName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
        return null;
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }
}
