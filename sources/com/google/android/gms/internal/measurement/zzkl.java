package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

public abstract class zzkl {
    public static final /* synthetic */ int zzc = 0;
    private static final Object zzd = new Object();
    @Nullable
    private static volatile zzkg zze = null;
    private static volatile boolean zzf = false;
    private static final AtomicInteger zzh = new AtomicInteger();
    final zzkf zza;
    final String zzb;
    private Object zzg;
    private volatile int zzi = -1;
    private volatile Object zzj;
    private volatile boolean zzk;

    static {
        new AtomicReference();
        Preconditions.checkNotNull(zzkj.zza, "BuildInfo must be non-null");
    }

    public /* synthetic */ zzkl(zzkf zzkf, String str, Object obj, boolean z, byte[] bArr) {
        if (zzkf.zza != null) {
            this.zza = zzkf;
            this.zzb = str;
            this.zzg = obj;
            this.zzk = false;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static void zzb(android.content.Context r3) {
        /*
            com.google.android.gms.internal.measurement.zzkg r0 = zze
            if (r0 != 0) goto L_0x004d
            if (r3 != 0) goto L_0x0007
            goto L_0x004d
        L_0x0007:
            java.lang.Object r0 = zzd
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzkg r1 = zze     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0049
            monitor-enter(r0)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzkg r1 = zze     // Catch:{ all -> 0x0021 }
            android.content.Context r2 = r3.getApplicationContext()     // Catch:{ all -> 0x0021 }
            if (r2 == 0) goto L_0x0018
            r3 = r2
        L_0x0018:
            if (r1 == 0) goto L_0x0023
            android.content.Context r2 = r1.zza()     // Catch:{ all -> 0x0021 }
            if (r2 == r3) goto L_0x0043
            goto L_0x0023
        L_0x0021:
            r3 = move-exception
            goto L_0x0045
        L_0x0023:
            if (r1 == 0) goto L_0x002e
            com.google.android.gms.internal.measurement.zzjq.zzd()     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.measurement.zzkn.zzb()     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.measurement.zzjx.zzc()     // Catch:{ all -> 0x0021 }
        L_0x002e:
            com.google.android.gms.internal.measurement.zzkk r1 = new com.google.android.gms.internal.measurement.zzkk     // Catch:{ all -> 0x0021 }
            r1.<init>(r3)     // Catch:{ all -> 0x0021 }
            com.google.common.base.Supplier r1 = com.google.common.base.Suppliers.memoize(r1)     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.measurement.zzjn r2 = new com.google.android.gms.internal.measurement.zzjn     // Catch:{ all -> 0x0021 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0021 }
            zze = r2     // Catch:{ all -> 0x0021 }
            java.util.concurrent.atomic.AtomicInteger r3 = zzh     // Catch:{ all -> 0x0021 }
            r3.incrementAndGet()     // Catch:{ all -> 0x0021 }
        L_0x0043:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            goto L_0x0049
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0021 }
            throw r3     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r3 = move-exception
            goto L_0x004b
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            return
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0047 }
            throw r3
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkl.zzb(android.content.Context):void");
    }

    public static void zzc() {
        zzh.incrementAndGet();
    }

    @Nullable
    public abstract Object zza(Object obj);

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0090 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A[Catch:{ all -> 0x0047 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bd A[Catch:{ all -> 0x0047 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zzd() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = zzh
            int r0 = r0.get()
            int r1 = r9.zzi
            if (r1 >= r0) goto L_0x00ce
            monitor-enter(r9)
            int r1 = r9.zzi     // Catch:{ all -> 0x0047 }
            if (r1 >= r0) goto L_0x00ca
            com.google.android.gms.internal.measurement.zzkg r1 = zze     // Catch:{ all -> 0x0047 }
            com.google.common.base.Optional r2 = com.google.common.base.Optional.absent()     // Catch:{ all -> 0x0047 }
            r3 = 0
            if (r1 == 0) goto L_0x004a
            com.google.common.base.Supplier r4 = r1.zzb()     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x004a
            com.google.common.base.Supplier r2 = r1.zzb()     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = com.google.common.base.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0047 }
            com.google.common.base.Supplier r2 = (com.google.common.base.Supplier) r2     // Catch:{ all -> 0x0047 }
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0047 }
            com.google.common.base.Optional r2 = (com.google.common.base.Optional) r2     // Catch:{ all -> 0x0047 }
            boolean r4 = r2.isPresent()     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x004a
            java.lang.Object r4 = r2.get()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzjs r4 = (com.google.android.gms.internal.measurement.zzjs) r4     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzkf r5 = r9.zza     // Catch:{ all -> 0x0047 }
            android.net.Uri r6 = r5.zza     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r5.zzc     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = r9.zzb     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = r4.zza(r6, r3, r5, r7)     // Catch:{ all -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r0 = move-exception
            goto L_0x00cc
        L_0x004a:
            r4 = r3
        L_0x004b:
            if (r1 == 0) goto L_0x004f
            r5 = 1
            goto L_0x0050
        L_0x004f:
            r5 = 0
        L_0x0050:
            java.lang.String r6 = "Must call PhenotypeFlagInitializer.maybeInit() first"
            com.google.common.base.Preconditions.checkState(r5, r6)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzkf r5 = r9.zza     // Catch:{ all -> 0x0047 }
            android.net.Uri r6 = r5.zza     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x0076
            android.content.Context r7 = r1.zza()     // Catch:{ all -> 0x0047 }
            boolean r7 = com.google.android.gms.internal.measurement.zzjz.zza(r7, r6)     // Catch:{ all -> 0x0047 }
            if (r7 == 0) goto L_0x0074
            android.content.Context r7 = r1.zza()     // Catch:{ all -> 0x0047 }
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzki r8 = com.google.android.gms.internal.measurement.zzki.zza     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzjq r6 = com.google.android.gms.internal.measurement.zzjq.zza(r7, r6, r8)     // Catch:{ all -> 0x0047 }
            goto L_0x0086
        L_0x0074:
            r6 = r3
            goto L_0x0086
        L_0x0076:
            android.content.Context r6 = r1.zza()     // Catch:{ all -> 0x0047 }
            java.lang.Object r7 = com.google.common.base.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0047 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzkh r8 = com.google.android.gms.internal.measurement.zzkh.zza     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzkn r6 = com.google.android.gms.internal.measurement.zzkn.zza(r6, r7, r8)     // Catch:{ all -> 0x0047 }
        L_0x0086:
            if (r6 == 0) goto L_0x0095
            java.lang.String r7 = r9.zzb     // Catch:{ all -> 0x0047 }
            java.lang.Object r6 = r6.zze(r7)     // Catch:{ all -> 0x0047 }
            if (r6 == 0) goto L_0x0095
            java.lang.Object r6 = r9.zza(r6)     // Catch:{ all -> 0x0047 }
            goto L_0x0096
        L_0x0095:
            r6 = r3
        L_0x0096:
            if (r6 == 0) goto L_0x0099
            goto L_0x00b7
        L_0x0099:
            boolean r5 = r5.zzd     // Catch:{ all -> 0x0047 }
            if (r5 != 0) goto L_0x00b1
            android.content.Context r1 = r1.zza()     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.measurement.zzjx r1 = com.google.android.gms.internal.measurement.zzjx.zza(r1)     // Catch:{ all -> 0x0047 }
            java.lang.String r5 = r9.zzb     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = r1.zze(r5)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x00b1
            java.lang.Object r3 = r9.zza(r1)     // Catch:{ all -> 0x0047 }
        L_0x00b1:
            if (r3 != 0) goto L_0x00b6
            java.lang.Object r6 = r9.zzg     // Catch:{ all -> 0x0047 }
            goto L_0x00b7
        L_0x00b6:
            r6 = r3
        L_0x00b7:
            boolean r1 = r2.isPresent()     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x00c6
            if (r4 != 0) goto L_0x00c2
            java.lang.Object r6 = r9.zzg     // Catch:{ all -> 0x0047 }
            goto L_0x00c6
        L_0x00c2:
            java.lang.Object r6 = r9.zza(r4)     // Catch:{ all -> 0x0047 }
        L_0x00c6:
            r9.zzj = r6     // Catch:{ all -> 0x0047 }
            r9.zzi = r0     // Catch:{ all -> 0x0047 }
        L_0x00ca:
            monitor-exit(r9)     // Catch:{ all -> 0x0047 }
            goto L_0x00ce
        L_0x00cc:
            monitor-exit(r9)     // Catch:{ all -> 0x0047 }
            throw r0
        L_0x00ce:
            java.lang.Object r0 = r9.zzj
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkl.zzd():java.lang.Object");
    }
}
