package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final /* synthetic */ class zzky implements zzlk {
    private final /* synthetic */ zzli zza;
    private final /* synthetic */ AtomicReference zzb;
    private final /* synthetic */ zzol zzc;

    public /* synthetic */ zzky(zzli zzli, AtomicReference atomicReference, zzol zzol) {
        this.zza = zzli;
        this.zzb = atomicReference;
        this.zzc = zzol;
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
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final /* synthetic */ void zza(java.lang.String r10, int r11, java.lang.Throwable r12, byte[] r13, java.util.Map r14) {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzli r10 = r9.zza
            r10.zzg()
            com.google.android.gms.measurement.internal.zzol r13 = r9.zzc
            r14 = 200(0xc8, float:2.8E-43)
            if (r11 == r14) goto L_0x0015
            r14 = 204(0xcc, float:2.86E-43)
            if (r11 == r14) goto L_0x0015
            r14 = 304(0x130, float:4.26E-43)
            if (r11 != r14) goto L_0x002f
            r11 = 304(0x130, float:4.26E-43)
        L_0x0015:
            if (r12 != 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzib r11 = r10.zzu
            com.google.android.gms.measurement.internal.zzgt r11 = r11.zzaV()
            com.google.android.gms.measurement.internal.zzgr r11 = r11.zzk()
            long r0 = r13.zza
            java.lang.Long r12 = java.lang.Long.valueOf(r0)
            java.lang.String r14 = "[sgtm] Upload succeeded for row_id"
            r11.zzb(r14, r12)
            com.google.android.gms.measurement.internal.zzlq r11 = com.google.android.gms.measurement.internal.zzlq.zzb
            goto L_0x006a
        L_0x002f:
            com.google.android.gms.measurement.internal.zzib r14 = r10.zzu
            com.google.android.gms.measurement.internal.zzgt r14 = r14.zzaV()
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zze()
            long r0 = r13.zza
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            java.lang.String r2 = "[sgtm] Upload failed for row_id. response, exception"
            r14.zzd(r2, r0, r1, r12)
            com.google.android.gms.measurement.internal.zzfw r12 = com.google.android.gms.measurement.internal.zzfx.zzt
            r14 = 0
            java.lang.Object r12 = r12.zzb(r14)
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r14 = ","
            java.lang.String[] r12 = r12.split(r14)
            java.util.List r12 = java.util.Arrays.asList(r12)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            boolean r11 = r12.contains(r11)
            if (r11 == 0) goto L_0x0068
            com.google.android.gms.measurement.internal.zzlq r11 = com.google.android.gms.measurement.internal.zzlq.zzd
            goto L_0x006a
        L_0x0068:
            com.google.android.gms.measurement.internal.zzlq r11 = com.google.android.gms.measurement.internal.zzlq.zzc
        L_0x006a:
            java.util.concurrent.atomic.AtomicReference r12 = r9.zzb
            com.google.android.gms.measurement.internal.zzib r14 = r10.zzu
            com.google.android.gms.measurement.internal.zznk r14 = r14.zzt()
            com.google.android.gms.measurement.internal.zzaf r6 = new com.google.android.gms.measurement.internal.zzaf
            long r7 = r13.zza
            int r3 = r11.zza()
            long r4 = r13.zzf
            r0 = r6
            r1 = r7
            r0.<init>(r1, r3, r4)
            r14.zzy(r6)
            com.google.android.gms.measurement.internal.zzib r10 = r10.zzu
            com.google.android.gms.measurement.internal.zzgt r10 = r10.zzaV()
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zzk()
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            java.lang.String r14 = "[sgtm] Updated status for row_id"
            r10.zzc(r14, r13, r11)
            monitor-enter(r12)
            r12.set(r11)     // Catch:{ all -> 0x00a0 }
            r12.notifyAll()     // Catch:{ all -> 0x00a0 }
            monitor-exit(r12)     // Catch:{ all -> 0x00a0 }
            return
        L_0x00a0:
            r10 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00a0 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzky.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }
}
