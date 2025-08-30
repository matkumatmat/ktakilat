package com.google.android.gms.measurement.internal;

import androidx.annotation.GuardedBy;

public final class zzfw {
    private static final Object zze = new Object();
    private final String zza;
    private final zzbn zzb;
    private final Object zzc;
    private final Object zzd = new Object();
    @GuardedBy("overrideLock")
    private volatile Object zzf = null;
    @GuardedBy("cachingLock")
    private volatile Object zzg = null;

    public /* synthetic */ zzfw(String str, Object obj, Object obj2, zzbn zzbn, byte[] bArr) {
        this.zza = str;
        this.zzc = obj;
        this.zzb = zzbn;
    }

    public final String zza() {
        return this.zza;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x004b */
    public final java.lang.Object zzb(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzd
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x006b }
            if (r4 == 0) goto L_0x0007
            return r4
        L_0x0007:
            com.google.android.gms.measurement.internal.zzae r4 = com.google.android.gms.measurement.internal.zzfr.zza
            if (r4 != 0) goto L_0x000e
            java.lang.Object r4 = r3.zzc
            return r4
        L_0x000e:
            java.lang.Object r4 = zze
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.zzae.zza()     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r3.zzg     // Catch:{ all -> 0x001e }
            if (r0 != 0) goto L_0x0020
            java.lang.Object r0 = r3.zzc     // Catch:{ all -> 0x001e }
            goto L_0x0022
        L_0x001e:
            r0 = move-exception
            goto L_0x0069
        L_0x0020:
            java.lang.Object r0 = r3.zzg     // Catch:{ all -> 0x001e }
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            goto L_0x0068
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            java.util.List r4 = com.google.android.gms.measurement.internal.zzfx.zzbk     // Catch:{ SecurityException -> 0x0049 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x0049 }
        L_0x002d:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x0049 }
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x0049 }
            com.google.android.gms.measurement.internal.zzfw r0 = (com.google.android.gms.measurement.internal.zzfw) r0     // Catch:{ SecurityException -> 0x0049 }
            boolean r1 = com.google.android.gms.measurement.internal.zzae.zza()     // Catch:{ SecurityException -> 0x0049 }
            if (r1 != 0) goto L_0x0055
            r1 = 0
            com.google.android.gms.measurement.internal.zzbn r2 = r0.zzb     // Catch:{ IllegalStateException -> 0x004b }
            if (r2 == 0) goto L_0x004b
            java.lang.Object r1 = r2.zza()     // Catch:{ IllegalStateException -> 0x004b }
            goto L_0x004b
        L_0x0049:
            goto L_0x005d
        L_0x004b:
            java.lang.Object r2 = zze     // Catch:{ SecurityException -> 0x0049 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0049 }
            r0.zzg = r1     // Catch:{ all -> 0x0052 }
            monitor-exit(r2)     // Catch:{ all -> 0x0052 }
            goto L_0x002d
        L_0x0052:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0052 }
            throw r4     // Catch:{ SecurityException -> 0x0049 }
        L_0x0055:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x0049 }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x0049 }
            throw r4     // Catch:{ SecurityException -> 0x0049 }
        L_0x005d:
            com.google.android.gms.measurement.internal.zzbn r4 = r3.zzb
            if (r4 != 0) goto L_0x0064
        L_0x0061:
            java.lang.Object r0 = r3.zzc
            goto L_0x0068
        L_0x0064:
            java.lang.Object r0 = r4.zza()     // Catch:{ IllegalStateException | SecurityException -> 0x0061 }
        L_0x0068:
            return r0
        L_0x0069:
            monitor-exit(r4)     // Catch:{ all -> 0x001e }
            throw r0
        L_0x006b:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006b }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfw.zzb(java.lang.Object):java.lang.Object");
    }
}
