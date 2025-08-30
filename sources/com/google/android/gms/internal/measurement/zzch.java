package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import androidx.annotation.Nullable;
import java.lang.reflect.Method;

@TargetApi(24)
public final class zzch {
    @Nullable
    private static final Method zza;
    @Nullable
    private static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    static {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 6
            java.lang.String r2 = "JobSchedulerCompat"
            r3 = 0
            r4 = 24
            if (r0 < r4) goto L_0x0034
            java.lang.Class<android.app.job.JobScheduler> r0 = android.app.job.JobScheduler.class
            java.lang.String r5 = "scheduleAsPackage"
            r6 = 4
            java.lang.Class[] r6 = new java.lang.Class[r6]     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<android.app.job.JobInfo> r7 = android.app.job.JobInfo.class
            r8 = 0
            r6[r8] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r8 = 1
            r6[r8] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0028 }
            r9 = 2
            r6[r9] = r8     // Catch:{ NoSuchMethodException -> 0x0028 }
            r8 = 3
            r6[r8] = r7     // Catch:{ NoSuchMethodException -> 0x0028 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0028 }
            goto L_0x0035
        L_0x0028:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r2, r0)
        L_0x0034:
            r0 = r3
        L_0x0035:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r4) goto L_0x0050
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r4 = "myUserId"
            java.lang.reflect.Method r3 = r0.getDeclaredMethod(r4, r3)     // Catch:{ NoSuchMethodException -> 0x0044 }
            goto L_0x0050
        L_0x0044:
            boolean r0 = android.util.Log.isLoggable(r2, r1)
            if (r0 == 0) goto L_0x0050
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r2, r0)
        L_0x0050:
            zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzch.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049 A[SYNTHETIC, Splitter:B:18:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            r7 = 0
            java.lang.String r8 = "jobscheduler"
            java.lang.Object r8 = r5.getSystemService(r8)
            android.app.job.JobScheduler r8 = (android.app.job.JobScheduler) r8
            java.lang.Object r8 = com.google.common.base.Preconditions.checkNotNull(r8)
            android.app.job.JobScheduler r8 = (android.app.job.JobScheduler) r8
            java.lang.reflect.Method r0 = zza
            if (r0 == 0) goto L_0x0077
            int r5 = r5.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS")
            if (r5 == 0) goto L_0x001a
            goto L_0x0077
        L_0x001a:
            java.lang.reflect.Method r5 = zzb
            if (r5 == 0) goto L_0x0032
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            r1 = 0
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x0030, InvocationTargetException -> 0x002e }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x0030, InvocationTargetException -> 0x002e }
            if (r5 == 0) goto L_0x0032
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x0030, InvocationTargetException -> 0x002e }
            goto L_0x0043
        L_0x002e:
            r5 = move-exception
            goto L_0x0034
        L_0x0030:
            r5 = move-exception
            goto L_0x0034
        L_0x0032:
            r5 = 0
            goto L_0x0043
        L_0x0034:
            java.lang.String r0 = "JobSchedulerCompat"
            r1 = 6
            boolean r1 = android.util.Log.isLoggable(r0, r1)
            if (r1 == 0) goto L_0x0032
            java.lang.String r1 = "myUserId invocation illegal"
            android.util.Log.e(r0, r1, r5)
            goto L_0x0032
        L_0x0043:
            java.lang.String r0 = "UploadAlarm"
            java.lang.reflect.Method r1 = zza
            if (r1 == 0) goto L_0x0072
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            r2[r7] = r6     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            java.lang.String r3 = "com.google.android.gms"
            r4 = 1
            r2[r4] = r3     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            r3 = 2
            r2[r3] = r5     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            r5 = 3
            r2[r5] = r0     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            java.lang.Object r5 = r1.invoke(r8, r2)     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            if (r5 == 0) goto L_0x0076
            int r7 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x006c, InvocationTargetException -> 0x006a }
            goto L_0x0076
        L_0x006a:
            r5 = move-exception
            goto L_0x006d
        L_0x006c:
            r5 = move-exception
        L_0x006d:
            java.lang.String r7 = "error calling scheduleAsPackage"
            android.util.Log.e(r0, r7, r5)
        L_0x0072:
            int r7 = r8.schedule(r6)
        L_0x0076:
            return r7
        L_0x0077:
            int r5 = r8.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzch.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
