package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
@ParametersAreNonnullByDefault
public class AdvertisingIdClient {
    @GuardedBy("this")
    @Nullable
    BlockingServiceConnection zza;
    @GuardedBy("this")
    @Nullable
    zzf zzb;
    @GuardedBy("this")
    boolean zzc;
    final Object zzd;
    @GuardedBy("mAutoDisconnectTaskLock")
    @Nullable
    zzb zze;
    final long zzf;
    @GuardedBy("this")
    private final Context zzg;

    @KeepForSdkWithMembers
    public static final class Info {
        @Nullable
        private final String zza;
        private final boolean zzb;

        @Deprecated
        public Info(@Nullable String str, boolean z) {
            this.zza = str;
            this.zzb = z;
        }

        @Nullable
        public String getId() {
            return this.zza;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzb;
        }

        @NonNull
        public String toString() {
            String str = this.zza;
            boolean z = this.zzb;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    @KeepForSdk
    public AdvertisingIdClient(@NonNull Context context) {
        this(context, 30000, false, false);
    }

    @NonNull
    @KeepForSdk
    public static Info getAdvertisingIdInfo(@NonNull Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1, true, false);
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            advertisingIdClient.zzb(false);
            Info zzd2 = advertisingIdClient.zzd(-1);
            advertisingIdClient.zzc(zzd2, true, 0.0f, SystemClock.elapsedRealtime() - elapsedRealtime, "", (Throwable) null);
            advertisingIdClient.zza();
            return zzd2;
        } catch (Throwable th) {
            advertisingIdClient.zza();
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:45|46|47) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x006d, code lost:
        throw new java.io.IOException("Remote exception");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0066 */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getIsAdIdFakeForDebugLogging(@androidx.annotation.NonNull android.content.Context r7) throws java.io.IOException, com.google.android.gms.common.GooglePlayServicesNotAvailableException, com.google.android.gms.common.GooglePlayServicesRepairableException {
        /*
            com.google.android.gms.ads.identifier.AdvertisingIdClient r6 = new com.google.android.gms.ads.identifier.AdvertisingIdClient
            r4 = 0
            r5 = 0
            r2 = -1
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r4, r5)
            r7 = 0
            r6.zzb(r7)     // Catch:{ all -> 0x0064 }
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r0)     // Catch:{ all -> 0x0064 }
            monitor-enter(r6)     // Catch:{ all -> 0x0064 }
            boolean r0 = r6.zzc     // Catch:{ all -> 0x0035 }
            if (r0 != 0) goto L_0x004c
            java.lang.Object r0 = r6.zzd     // Catch:{ all -> 0x0035 }
            monitor-enter(r0)     // Catch:{ all -> 0x0035 }
            com.google.android.gms.ads.identifier.zzb r1 = r6.zze     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0042
            boolean r1 = r1.zzb     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0042
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            r6.zzb(r7)     // Catch:{ Exception -> 0x0037 }
            boolean r7 = r6.zzc     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x002d
            goto L_0x004c
        L_0x002d:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "AdvertisingIdClient cannot reconnect."
            r7.<init>(r0)     // Catch:{ all -> 0x0035 }
            throw r7     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r7 = move-exception
            goto L_0x006e
        L_0x0037:
            r7 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = "AdvertisingIdClient cannot reconnect."
            r0.<init>(r1, r7)     // Catch:{ all -> 0x0035 }
            throw r0     // Catch:{ all -> 0x0035 }
        L_0x0040:
            r7 = move-exception
            goto L_0x004a
        L_0x0042:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0040 }
            java.lang.String r1 = "AdvertisingIdClient is not connected."
            r7.<init>(r1)     // Catch:{ all -> 0x0040 }
            throw r7     // Catch:{ all -> 0x0040 }
        L_0x004a:
            monitor-exit(r0)     // Catch:{ all -> 0x0040 }
            throw r7     // Catch:{ all -> 0x0035 }
        L_0x004c:
            com.google.android.gms.common.BlockingServiceConnection r7 = r6.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads_identifier.zzf r7 = r6.zzb     // Catch:{ all -> 0x0035 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads_identifier.zzf r7 = r6.zzb     // Catch:{ RemoteException -> 0x0066 }
            boolean r7 = r7.zzd()     // Catch:{ RemoteException -> 0x0066 }
            monitor-exit(r6)     // Catch:{ all -> 0x0035 }
            r6.zze()     // Catch:{ all -> 0x0064 }
            r6.zza()
            return r7
        L_0x0064:
            r7 = move-exception
            goto L_0x0070
        L_0x0066:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "Remote exception"
            r7.<init>(r0)     // Catch:{ all -> 0x0035 }
            throw r7     // Catch:{ all -> 0x0035 }
        L_0x006e:
            monitor-exit(r6)     // Catch:{ all -> 0x0035 }
            throw r7     // Catch:{ all -> 0x0064 }
        L_0x0070:
            r6.zza()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.getIsAdIdFakeForDebugLogging(android.content.Context):boolean");
    }

    @ShowFirstParty
    @KeepForSdk
    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:41|42|43) */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
        throw new java.io.IOException("Remote exception");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x005f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.identifier.AdvertisingIdClient.Info zzd(int r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r4 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r4)
            monitor-enter(r3)
            boolean r4 = r3.zzc     // Catch:{ all -> 0x0027 }
            if (r4 != 0) goto L_0x003e
            java.lang.Object r4 = r3.zzd     // Catch:{ all -> 0x0027 }
            monitor-enter(r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.ads.identifier.zzb r0 = r3.zze     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0034
            boolean r0 = r0.zzb     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x0034
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            r4 = 0
            r3.zzb(r4)     // Catch:{ Exception -> 0x0029 }
            boolean r4 = r3.zzc     // Catch:{ all -> 0x0027 }
            if (r4 == 0) goto L_0x001f
            goto L_0x003e
        L_0x001f:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0027 }
            java.lang.String r0 = "AdvertisingIdClient cannot reconnect."
            r4.<init>(r0)     // Catch:{ all -> 0x0027 }
            throw r4     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r4 = move-exception
            goto L_0x0067
        L_0x0029:
            r4 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0027 }
            java.lang.String r1 = "AdvertisingIdClient cannot reconnect."
            r0.<init>(r1, r4)     // Catch:{ all -> 0x0027 }
            throw r0     // Catch:{ all -> 0x0027 }
        L_0x0032:
            r0 = move-exception
            goto L_0x003c
        L_0x0034:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = "AdvertisingIdClient is not connected."
            r0.<init>(r1)     // Catch:{ all -> 0x0032 }
            throw r0     // Catch:{ all -> 0x0032 }
        L_0x003c:
            monitor-exit(r4)     // Catch:{ all -> 0x0032 }
            throw r0     // Catch:{ all -> 0x0027 }
        L_0x003e:
            com.google.android.gms.common.BlockingServiceConnection r4 = r3.zza     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.ads_identifier.zzf r4 = r3.zzb     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r4 = new com.google.android.gms.ads.identifier.AdvertisingIdClient$Info     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.internal.ads_identifier.zzf r0 = r3.zzb     // Catch:{ RemoteException -> 0x005f }
            java.lang.String r0 = r0.zzc()     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.internal.ads_identifier.zzf r1 = r3.zzb     // Catch:{ RemoteException -> 0x005f }
            r2 = 1
            boolean r1 = r1.zze(r2)     // Catch:{ RemoteException -> 0x005f }
            r4.<init>(r0, r1)     // Catch:{ RemoteException -> 0x005f }
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            r3.zze()
            return r4
        L_0x005f:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0027 }
            java.lang.String r0 = "Remote exception"
            r4.<init>(r0)     // Catch:{ all -> 0x0027 }
            throw r4     // Catch:{ all -> 0x0027 }
        L_0x0067:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zzd(int):com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|(3:5|6|7)|9|10|(1:12)|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zze() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzd
            monitor-enter(r0)
            com.google.android.gms.ads.identifier.zzb r1 = r6.zze     // Catch:{ all -> 0x0012 }
            if (r1 == 0) goto L_0x0014
            java.util.concurrent.CountDownLatch r1 = r1.zza     // Catch:{ all -> 0x0012 }
            r1.countDown()     // Catch:{ all -> 0x0012 }
            com.google.android.gms.ads.identifier.zzb r1 = r6.zze     // Catch:{ InterruptedException -> 0x0014 }
            r1.join()     // Catch:{ InterruptedException -> 0x0014 }
            goto L_0x0014
        L_0x0012:
            r1 = move-exception
            goto L_0x0025
        L_0x0014:
            long r1 = r6.zzf     // Catch:{ all -> 0x0012 }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0023
            com.google.android.gms.ads.identifier.zzb r3 = new com.google.android.gms.ads.identifier.zzb     // Catch:{ all -> 0x0012 }
            r3.<init>(r6, r1)     // Catch:{ all -> 0x0012 }
            r6.zze = r3     // Catch:{ all -> 0x0012 }
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            return
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0012 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zze():void");
    }

    public final void finalize() throws Throwable {
        zza();
        super.finalize();
    }

    @NonNull
    @KeepForSdk
    public Info getInfo() throws IOException {
        return zzd(-1);
    }

    @KeepForSdk
    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza() {
        /*
            r3 = this;
            java.lang.String r0 = "Calling this from your main thread can lead to deadlock"
            com.google.android.gms.common.internal.Preconditions.checkNotMainThread(r0)
            monitor-enter(r3)
            android.content.Context r0 = r3.zzg     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.common.BlockingServiceConnection r0 = r3.zza     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x000f
            goto L_0x002a
        L_0x000f:
            boolean r0 = r3.zzc     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.common.stats.ConnectionTracker r0 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ all -> 0x001e }
            android.content.Context r1 = r3.zzg     // Catch:{ all -> 0x001e }
            com.google.android.gms.common.BlockingServiceConnection r2 = r3.zza     // Catch:{ all -> 0x001e }
            r0.unbindService(r1, r2)     // Catch:{ all -> 0x001e }
        L_0x001e:
            r0 = 0
            r3.zzc = r0     // Catch:{ all -> 0x0028 }
            r0 = 0
            r3.zzb = r0     // Catch:{ all -> 0x0028 }
            r3.zza = r0     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            return
        L_0x0028:
            r0 = move-exception
            goto L_0x002c
        L_0x002a:
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            return
        L_0x002c:
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.zza():void");
    }

    @VisibleForTesting
    public final void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.zzc) {
                    zza();
                }
                Context context = this.zzg;
                context.getPackageManager().getPackageInfo("com.android.vending", 0);
                int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                if (isGooglePlayServicesAvailable != 0) {
                    if (isGooglePlayServicesAvailable != 2) {
                        throw new IOException("Google Play services not available");
                    }
                }
                BlockingServiceConnection blockingServiceConnection = new BlockingServiceConnection();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                if (ConnectionTracker.getInstance().bindService(context, intent, blockingServiceConnection, 1)) {
                    this.zza = blockingServiceConnection;
                    this.zzb = zze.zza(blockingServiceConnection.getServiceWithTimeout(10000, TimeUnit.MILLISECONDS));
                    this.zzc = true;
                    if (z) {
                        zze();
                    }
                } else {
                    throw new IOException("Connection failure");
                }
            } catch (PackageManager.NameNotFoundException unused) {
                throw new GooglePlayServicesNotAvailableException(9);
            } catch (InterruptedException unused2) {
                throw new IOException("Interrupted exception");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public final boolean zzc(@Nullable Info info, boolean z, float f, long j, String str, @Nullable Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap hashMap = new HashMap();
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_YES;
        hashMap.put("app_context", str2);
        if (info != null) {
            if (true != info.isLimitAdTrackingEnabled()) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            }
            hashMap.put("limit_ad_tracking", str2);
            String id = info.getId();
            if (id != null) {
                hashMap.put("ad_id_size", Integer.toString(id.length()));
            }
        }
        if (th != null) {
            hashMap.put("error", th.getClass().getName());
        }
        hashMap.put("tag", "AdvertisingIdClient");
        hashMap.put("time_spent", Long.toString(j));
        new zza(this, hashMap).start();
        return true;
    }

    @VisibleForTesting
    public AdvertisingIdClient(@NonNull Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        this.zzd = new Object();
        Preconditions.checkNotNull(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.zzg = context;
        this.zzc = false;
        this.zzf = j;
    }
}
