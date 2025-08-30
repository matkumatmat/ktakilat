package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.appsflyer.AFLogger;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Deprecated
public final class AFb1vSDK {

    public static final class AFa1uSDK implements IInterface {
        private final IBinder getMonetizationNetwork;

        public AFa1uSDK(IBinder iBinder) {
            this.getMonetizationNetwork = iBinder;
        }

        public final IBinder asBinder() {
            return this.getMonetizationNetwork;
        }

        public final boolean getMonetizationNetwork() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.getMonetizationNetwork.transact(2, obtain, obtain2, 0);
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

        public final String getRevenue() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.getMonetizationNetwork.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static final class AFa1vSDK {
        public final String AFAdRevenueData;
        private final boolean getMediationNetwork;

        public AFa1vSDK(String str, boolean z) {
            this.AFAdRevenueData = str;
            this.getMediationNetwork = z;
        }

        public final boolean getCurrencyIso4217Code() {
            return this.getMediationNetwork;
        }
    }

    public static final class AFa1ySDK implements ServiceConnection {
        final LinkedBlockingQueue<IBinder> getCurrencyIso4217Code = new LinkedBlockingQueue<>(1);
        boolean getRevenue = false;

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.getCurrencyIso4217Code.put(iBinder);
            } catch (InterruptedException e) {
                AFLogger.afErrorLogForExcManagerOnly("onServiceConnected Interrupted", e);
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static AFa1vSDK AFAdRevenueData(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AFa1ySDK aFa1ySDK = new AFa1ySDK();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, aFa1ySDK, 1)) {
                    context.unbindService(aFa1ySDK);
                    throw new IOException("Google Play connection failed");
                } else if (!aFa1ySDK.getRevenue) {
                    aFa1ySDK.getRevenue = true;
                    IBinder poll = aFa1ySDK.getCurrencyIso4217Code.poll(10, TimeUnit.SECONDS);
                    if (poll != null) {
                        AFa1uSDK aFa1uSDK = new AFa1uSDK(poll);
                        return new AFa1vSDK(aFa1uSDK.getRevenue(), aFa1uSDK.getMonetizationNetwork());
                    }
                    throw new TimeoutException("Timed out waiting for the service connection");
                } else {
                    throw new IllegalStateException("Cannot call get on this connection more than once");
                }
            } finally {
                context.unbindService(aFa1ySDK);
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }
}
