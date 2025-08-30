package com.google.android.gms.maps;

import android.content.Context;
import androidx.annotation.NonNull;

public final class MapsInitializer {
    private static final String zza = "MapsInitializer";
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(@NonNull Context context) {
        int initialize;
        synchronized (MapsInitializer.class) {
            initialize = initialize(context, (Renderer) null, (OnMapsSdkInitializedCallback) null);
        }
        return initialize;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0049 A[Catch:{ RemoteException -> 0x0073, RemoteException -> 0x004e }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c A[Catch:{ RemoteException -> 0x0073, RemoteException -> 0x004e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int initialize(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.Nullable com.google.android.gms.maps.MapsInitializer.Renderer r6, @androidx.annotation.Nullable com.google.android.gms.maps.OnMapsSdkInitializedCallback r7) {
        /*
            java.lang.Class<com.google.android.gms.maps.MapsInitializer> r0 = com.google.android.gms.maps.MapsInitializer.class
            monitor-enter(r0)
            java.lang.String r1 = "Context is null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r1)     // Catch:{ all -> 0x001e }
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x001e }
            java.lang.String r2 = "preferredRenderer: "
            r2.concat(r1)     // Catch:{ all -> 0x001e }
            boolean r1 = zzb     // Catch:{ all -> 0x001e }
            r2 = 0
            if (r1 == 0) goto L_0x0020
            if (r7 == 0) goto L_0x0071
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = zzc     // Catch:{ all -> 0x001e }
            r7.onMapsSdkInitialized(r5)     // Catch:{ all -> 0x001e }
            goto L_0x0071
        L_0x001e:
            r5 = move-exception
            goto L_0x007f
        L_0x0020:
            com.google.android.gms.maps.internal.zzf r1 = com.google.android.gms.maps.internal.zzcc.zza(r5, r6)     // Catch:{ GooglePlayServicesNotAvailableException -> 0x007a }
            com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate r3 = r1.zze()     // Catch:{ RemoteException -> 0x0073 }
            com.google.android.gms.maps.CameraUpdateFactory.zza(r3)     // Catch:{ RemoteException -> 0x0073 }
            com.google.android.gms.internal.maps.zzi r3 = r1.zzj()     // Catch:{ RemoteException -> 0x0073 }
            com.google.android.gms.maps.model.BitmapDescriptorFactory.zza(r3)     // Catch:{ RemoteException -> 0x0073 }
            r3 = 1
            zzb = r3     // Catch:{ all -> 0x001e }
            r4 = 2
            if (r6 == 0) goto L_0x0040
            int r6 = r6.ordinal()     // Catch:{ all -> 0x001e }
            if (r6 == 0) goto L_0x0043
            if (r6 == r3) goto L_0x0042
        L_0x0040:
            r3 = 0
            goto L_0x0043
        L_0x0042:
            r3 = 2
        L_0x0043:
            int r6 = r1.zzd()     // Catch:{ RemoteException -> 0x004e }
            if (r6 != r4) goto L_0x0050
            com.google.android.gms.maps.MapsInitializer$Renderer r6 = com.google.android.gms.maps.MapsInitializer.Renderer.LATEST     // Catch:{ RemoteException -> 0x004e }
            zzc = r6     // Catch:{ RemoteException -> 0x004e }
            goto L_0x0050
        L_0x004e:
            r5 = move-exception
            goto L_0x0058
        L_0x0050:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x004e }
            r1.zzl(r5, r3)     // Catch:{ RemoteException -> 0x004e }
            goto L_0x005f
        L_0x0058:
            java.lang.String r6 = zza     // Catch:{ all -> 0x001e }
            java.lang.String r1 = "Failed to retrieve renderer type or log initialization."
            android.util.Log.e(r6, r1, r5)     // Catch:{ all -> 0x001e }
        L_0x005f:
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = zzc     // Catch:{ all -> 0x001e }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x001e }
            java.lang.String r6 = "loadedRenderer: "
            r6.concat(r5)     // Catch:{ all -> 0x001e }
            if (r7 == 0) goto L_0x0071
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = zzc     // Catch:{ all -> 0x001e }
            r7.onMapsSdkInitialized(r5)     // Catch:{ all -> 0x001e }
        L_0x0071:
            monitor-exit(r0)
            return r2
        L_0x0073:
            r5 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r6 = new com.google.android.gms.maps.model.RuntimeRemoteException     // Catch:{ all -> 0x001e }
            r6.<init>(r5)     // Catch:{ all -> 0x001e }
            throw r6     // Catch:{ all -> 0x001e }
        L_0x007a:
            r5 = move-exception
            int r5 = r5.errorCode     // Catch:{ all -> 0x001e }
            monitor-exit(r0)
            return r5
        L_0x007f:
            monitor-exit(r0)     // Catch:{ all -> 0x001e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.MapsInitializer.initialize(android.content.Context, com.google.android.gms.maps.MapsInitializer$Renderer, com.google.android.gms.maps.OnMapsSdkInitializedCallback):int");
    }
}
