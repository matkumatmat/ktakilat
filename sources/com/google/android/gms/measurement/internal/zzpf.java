package com.google.android.gms.measurement.internal;

import android.app.BroadcastOptions;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzca;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgx;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziu;
import com.google.android.gms.internal.measurement.zzmq;
import com.google.android.gms.internal.measurement.zzpk;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzpf implements zzjf {
    private static volatile zzpf zzb;
    private List zzA;
    private long zzB;
    private final Map zzC;
    private final Map zzD;
    private final Map zzE;
    private final Map zzF = new HashMap();
    private zzlt zzG;
    private String zzH;
    private zzay zzI;
    private long zzJ;
    private final zzpn zzK = new zzpa(this);
    @VisibleForTesting
    long zza;
    private final zzhs zzc;
    private final zzgy zzd;
    private zzav zze;
    private zzha zzf;
    private zzoj zzg;
    private zzad zzh;
    private final zzpj zzi;
    private zzlo zzj;
    private zznm zzk;
    private final zzot zzl;
    private zzhj zzm;
    private final zzib zzn;
    private final AtomicBoolean zzo = new AtomicBoolean(false);
    private boolean zzp;
    private List zzq;
    private final Deque zzr = new LinkedList();
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private FileLock zzx;
    private FileChannel zzy;
    private List zzz;

    public zzpf(zzpg zzpg, zzib zzib) {
        Preconditions.checkNotNull(zzpg);
        this.zzn = zzib.zzy(zzpg.zza, (zzdd) null, (Long) null);
        this.zzB = -1;
        this.zzl = new zzot(this);
        zzpj zzpj = new zzpj(this);
        zzpj.zzaz();
        this.zzi = zzpj;
        zzgy zzgy = new zzgy(this);
        zzgy.zzaz();
        this.zzd = zzgy;
        zzhs zzhs = new zzhs(this);
        zzhs.zzaz();
        this.zzc = zzhs;
        this.zzC = new HashMap();
        this.zzD = new HashMap();
        this.zzE = new HashMap();
        zzaW().zzj(new zzou(this, zzpg));
    }

    public static zzpf zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzpf.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzpf((zzpg) Preconditions.checkNotNull(new zzpg(context)), (zzib) null);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return zzb;
    }

    @VisibleForTesting
    public static final void zzaA(zzhr zzhr, @NonNull String str) {
        List zza2 = zzhr.zza();
        for (int i = 0; i < zza2.size(); i++) {
            if (str.equals(((zzhw) zza2.get(i)).zzb())) {
                zzhr.zzj(i);
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r1 = com.google.android.gms.measurement.internal.zzjj.AD_PERSONALIZATION;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzaB(java.lang.String r7, com.google.android.gms.measurement.internal.zzan r8) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzhs r0 = r6.zzc
            com.google.android.gms.internal.measurement.zzgf r1 = r0.zzx(r7)
            r2 = 1
            if (r1 != 0) goto L_0x0011
            com.google.android.gms.measurement.internal.zzjj r7 = com.google.android.gms.measurement.internal.zzjj.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.zzam r0 = com.google.android.gms.measurement.internal.zzam.FAILSAFE
            r8.zzc(r7, r0)
            return r2
        L_0x0011:
            com.google.android.gms.measurement.internal.zzav r1 = r6.zzj()
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzu(r7)
            r3 = 0
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = r1.zzaH()
            com.google.android.gms.measurement.internal.zze r1 = com.google.android.gms.measurement.internal.zze.zzc(r1)
            com.google.android.gms.measurement.internal.zzjh r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzjh r4 = com.google.android.gms.measurement.internal.zzjh.POLICY
            if (r1 != r4) goto L_0x0041
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.zzjh r4 = r0.zzA(r7, r1)
            com.google.android.gms.measurement.internal.zzjh r5 = com.google.android.gms.measurement.internal.zzjh.UNINITIALIZED
            if (r4 == r5) goto L_0x0041
            com.google.android.gms.measurement.internal.zzam r7 = com.google.android.gms.measurement.internal.zzam.REMOTE_ENFORCED_DEFAULT
            r8.zzc(r1, r7)
            com.google.android.gms.measurement.internal.zzjh r7 = com.google.android.gms.measurement.internal.zzjh.GRANTED
            if (r4 != r7) goto L_0x0040
            return r3
        L_0x0040:
            return r2
        L_0x0041:
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.zzam r4 = com.google.android.gms.measurement.internal.zzam.REMOTE_DEFAULT
            r8.zzc(r1, r4)
            boolean r7 = r0.zzv(r7, r1)
            if (r7 == 0) goto L_0x004f
            return r3
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzaB(java.lang.String, com.google.android.gms.measurement.internal.zzan):int");
    }

    private final Map zzaC(zzhs zzhs) {
        HashMap hashMap = new HashMap();
        zzp();
        for (Map.Entry entry : zzpj.zzH(zzhs, "gad_").entrySet()) {
            hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    private final zzay zzaD() {
        if (this.zzI == null) {
            this.zzI = new zzox(this, this.zzn);
        }
        return this.zzI;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    /* renamed from: zzaE */
    public final void zzau() {
        zzaW().zzg();
        if (!this.zzr.isEmpty() && !zzaD().zzc()) {
            long max = Math.max(0, ((long) ((Integer) zzfx.zzaB.zzb((Object) null)).intValue()) - (zzaZ().elapsedRealtime() - this.zzJ));
            zzaV().zzk().zzb("Scheduling notify next app runnable, delay in ms", Long.valueOf(max));
            zzaD().zzb(max);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0136, code lost:
        if (r4.equals("ecommerce_purchase") == false) goto L_0x016d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x038e A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03b6 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03bf A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x03d7 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x03f0 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x04b3 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x04fc A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0559 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0672 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0bac A[Catch:{ all -> 0x0bdf }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0bfd A[Catch:{ all -> 0x0bdf }] */
    /* JADX WARNING: Removed duplicated region for block: B:382:0x0c29 A[Catch:{ all -> 0x0bdf }] */
    /* JADX WARNING: Removed duplicated region for block: B:494:0x028f A[EDGE_INSN: B:494:0x028f->B:85:0x028f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x017b A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01f3 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x022a A[SYNTHETIC, Splitter:B:76:0x022a] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02c3 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0324 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0328 A[Catch:{ NumberFormatException -> 0x0b73, all -> 0x0105 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzaF(java.lang.String r47, long r48) {
        /*
            r46 = this;
            r1 = r46
            java.lang.String r2 = "_efs"
            java.lang.String r3 = "Generated trigger URI. appId, uri"
            java.lang.String r4 = "_tr"
            java.lang.String r5 = "_tu"
            java.lang.String r8 = "_ai"
            java.lang.String r9 = "purchase"
            java.lang.String r10 = "items"
            com.google.android.gms.measurement.internal.zzav r11 = r46.zzj()
            r11.zzb()
            com.google.android.gms.measurement.internal.zzpb r11 = new com.google.android.gms.measurement.internal.zzpb     // Catch:{ all -> 0x0105 }
            r14 = 0
            r11.<init>(r1, r14)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzav r12 = r46.zzj()     // Catch:{ all -> 0x0105 }
            long r6 = r1.zzB     // Catch:{ all -> 0x0105 }
            r13 = r47
            r14 = r48
            r16 = r6
            r18 = r11
            r12.zzav(r13, r14, r16, r18)     // Catch:{ all -> 0x0105 }
            java.util.List r6 = r11.zzc     // Catch:{ all -> 0x0105 }
            if (r6 == 0) goto L_0x0038
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0105 }
            if (r6 == 0) goto L_0x003c
        L_0x0038:
            r3 = r1
            r5 = 0
            goto L_0x0ef0
        L_0x003c:
            com.google.android.gms.internal.measurement.zzid r6 = r11.zza     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzma r6 = r6.zzcl()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzic r6 = (com.google.android.gms.internal.measurement.zzic) r6     // Catch:{ all -> 0x0105 }
            r6.zzi()     // Catch:{ all -> 0x0105 }
            r17 = r2
            r18 = r3
            r2 = -1
            r7 = -1
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r21 = 0
        L_0x0055:
            java.util.List r3 = r11.zzc     // Catch:{ all -> 0x0105 }
            int r3 = r3.size()     // Catch:{ all -> 0x0105 }
            r22 = r4
            java.lang.String r4 = "_et"
            r23 = r5
            java.lang.String r5 = "_fr"
            r24 = r10
            java.lang.String r10 = "_e"
            r48 = r7
            java.lang.String r7 = "_c"
            r49 = r4
            r25 = r5
            if (r15 >= r3) goto L_0x06a1
            java.util.List r3 = r11.zzc     // Catch:{ all -> 0x0105 }
            java.lang.Object r3 = r3.get(r15)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r3 = (com.google.android.gms.internal.measurement.zzhs) r3     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzma r3 = r3.zzcl()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhr r3 = (com.google.android.gms.internal.measurement.zzhr) r3     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzhs r4 = r46.zzh()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r5 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = r5.zzA()     // Catch:{ all -> 0x0105 }
            r28 = r15
            java.lang.String r15 = r3.zzk()     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.zzj(r5, r15)     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = "_err"
            if (r4 == 0) goto L_0x011a
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zze()     // Catch:{ all -> 0x0105 }
            java.lang.String r7 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r10)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzib r15 = r1.zzn     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgm r15 = r15.zzl()     // Catch:{ all -> 0x0105 }
            r29 = r14
            java.lang.String r14 = r3.zzk()     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = r15.zza(r14)     // Catch:{ all -> 0x0105 }
            r4.zzc(r7, r10, r14)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzhs r4 = r46.zzh()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r7 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.zzn(r7)     // Catch:{ all -> 0x0105 }
            if (r4 != 0) goto L_0x010a
            com.google.android.gms.measurement.internal.zzhs r4 = r46.zzh()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r7 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r7 = r7.zzA()     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.zzo(r7)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x00df
            goto L_0x010a
        L_0x00df:
            java.lang.String r4 = r3.zzk()     // Catch:{ all -> 0x0105 }
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x0105 }
            if (r4 != 0) goto L_0x010a
            com.google.android.gms.measurement.internal.zzpo r30 = r46.zzt()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzpn r4 = r1.zzK     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r5 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r32 = r5.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.String r34 = "_ev"
            java.lang.String r35 = r3.zzk()     // Catch:{ all -> 0x0105 }
            r36 = 0
            r33 = 11
            r31 = r4
            r30.zzN(r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x0105 }
            goto L_0x010a
        L_0x0105:
            r0 = move-exception
            r3 = r1
        L_0x0107:
            r1 = r0
            goto L_0x0f00
        L_0x010a:
            r4 = r48
            r3 = r2
            r31 = r8
            r32 = r9
            r10 = r24
            r7 = r28
            r14 = r29
            r2 = 1
            goto L_0x0693
        L_0x011a:
            r29 = r14
            java.lang.String r4 = r3.zzk()     // Catch:{ all -> 0x0105 }
            boolean r14 = r4.equals(r9)     // Catch:{ all -> 0x0105 }
            java.lang.String r15 = "ecommerce_purchase"
            r30 = r2
            java.lang.String r2 = "_iap"
            if (r14 != 0) goto L_0x0138
            boolean r14 = r4.equals(r2)     // Catch:{ all -> 0x0105 }
            if (r14 != 0) goto L_0x0138
            boolean r4 = r4.equals(r15)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x016d
        L_0x0138:
            com.google.android.gms.internal.measurement.zzhv r4 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = "_ct"
            r4.zzb(r14)     // Catch:{ all -> 0x0105 }
            if (r13 != 0) goto L_0x015e
            com.google.android.gms.internal.measurement.zzid r13 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r13 = r13.zzA()     // Catch:{ all -> 0x0105 }
            boolean r14 = r1.zzaO(r13, r9)     // Catch:{ all -> 0x0105 }
            if (r14 == 0) goto L_0x015e
            boolean r2 = r1.zzaO(r13, r2)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x015e
            boolean r2 = r1.zzaO(r13, r15)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x015e
            java.lang.String r2 = "new"
            goto L_0x0160
        L_0x015e:
            java.lang.String r2 = "returning"
        L_0x0160:
            r4.zzd(r2)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r2 = r4.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r2 = (com.google.android.gms.internal.measurement.zzhw) r2     // Catch:{ all -> 0x0105 }
            r3.zzf(r2)     // Catch:{ all -> 0x0105 }
            r13 = 1
        L_0x016d:
            java.lang.String r2 = r3.zzk()     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzjl.zza(r8)     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x01df
            r3.zzl(r8)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgt r2 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = "Renaming ad_impression to _ai"
            r2.zza(r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgt r2 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            java.lang.String r2 = r2.zzn()     // Catch:{ all -> 0x0105 }
            r4 = 5
            boolean r2 = android.util.Log.isLoggable(r2, r4)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x01df
            r2 = 0
        L_0x019b:
            int r4 = r3.zzb()     // Catch:{ all -> 0x0105 }
            if (r2 >= r4) goto L_0x01df
            java.lang.String r4 = "ad_platform"
            com.google.android.gms.internal.measurement.zzhw r14 = r3.zzc(r2)     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = r14.zzb()     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.equals(r14)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x01dc
            com.google.android.gms.internal.measurement.zzhw r4 = r3.zzc(r2)     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r4.zzd()     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0105 }
            if (r4 != 0) goto L_0x01dc
            java.lang.String r4 = "admob"
            com.google.android.gms.internal.measurement.zzhw r14 = r3.zzc(r2)     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = r14.zzd()     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.equalsIgnoreCase(r14)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzh()     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = "AdMob ad impression logged from app. Potentially duplicative."
            r4.zza(r14)     // Catch:{ all -> 0x0105 }
        L_0x01dc:
            r4 = 1
            int r2 = r2 + r4
            goto L_0x019b
        L_0x01df:
            com.google.android.gms.measurement.internal.zzhs r2 = r46.zzh()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r4 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r4.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = r3.zzk()     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.zzk(r4, r14)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x020f
            r46.zzp()     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r3.zzk()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0105 }
            int r14 = r4.hashCode()     // Catch:{ all -> 0x0105 }
            r15 = 95027(0x17333, float:1.33161E-40)
            if (r14 == r15) goto L_0x0207
            goto L_0x0215
        L_0x0207:
            java.lang.String r14 = "_ui"
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0215
        L_0x020f:
            r31 = r8
            r4 = 0
            r14 = 0
            r15 = 0
            goto L_0x0220
        L_0x0215:
            r31 = r8
            r32 = r9
            r34 = r12
            r33 = r13
            r2 = 0
            goto L_0x03ee
        L_0x0220:
            int r8 = r3.zzb()     // Catch:{ all -> 0x0105 }
            r32 = r9
            java.lang.String r9 = "_r"
            if (r4 >= r8) goto L_0x028f
            com.google.android.gms.internal.measurement.zzhw r8 = r3.zzc(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0105 }
            boolean r8 = r7.equals(r8)     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x0257
            com.google.android.gms.internal.measurement.zzhw r8 = r3.zzc(r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzma r8 = r8.zzcl()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r8 = (com.google.android.gms.internal.measurement.zzhv) r8     // Catch:{ all -> 0x0105 }
            r33 = r13
            r13 = 1
            r8.zzf(r13)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r8 = r8.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r8 = (com.google.android.gms.internal.measurement.zzhw) r8     // Catch:{ all -> 0x0105 }
            r3.zzd(r4, r8)     // Catch:{ all -> 0x0105 }
            r34 = r12
            r8 = 1
            r14 = 1
            goto L_0x0287
        L_0x0257:
            r33 = r13
            com.google.android.gms.internal.measurement.zzhw r8 = r3.zzc(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.zzb()     // Catch:{ all -> 0x0105 }
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x0284
            com.google.android.gms.internal.measurement.zzhw r8 = r3.zzc(r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzma r8 = r8.zzcl()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r8 = (com.google.android.gms.internal.measurement.zzhv) r8     // Catch:{ all -> 0x0105 }
            r34 = r12
            r12 = 1
            r8.zzf(r12)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r8 = r8.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r8 = (com.google.android.gms.internal.measurement.zzhw) r8     // Catch:{ all -> 0x0105 }
            r3.zzd(r4, r8)     // Catch:{ all -> 0x0105 }
            r8 = 1
            r15 = 1
            goto L_0x0287
        L_0x0284:
            r34 = r12
            r8 = 1
        L_0x0287:
            int r4 = r4 + r8
            r9 = r32
            r13 = r33
            r12 = r34
            goto L_0x0220
        L_0x028f:
            r34 = r12
            r33 = r13
            if (r14 != 0) goto L_0x02c1
            if (r2 == 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzk()     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzib r12 = r1.zzn     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgm r12 = r12.zzl()     // Catch:{ all -> 0x0105 }
            java.lang.String r13 = r3.zzk()     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r12.zza(r13)     // Catch:{ all -> 0x0105 }
            r4.zzb(r8, r12)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r4 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            r4.zzb(r7)     // Catch:{ all -> 0x0105 }
            r12 = 1
            r4.zzf(r12)     // Catch:{ all -> 0x0105 }
            r3.zzg(r4)     // Catch:{ all -> 0x0105 }
        L_0x02c1:
            if (r15 != 0) goto L_0x02ed
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzk()     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzib r12 = r1.zzn     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgm r12 = r12.zzl()     // Catch:{ all -> 0x0105 }
            java.lang.String r13 = r3.zzk()     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r12.zza(r13)     // Catch:{ all -> 0x0105 }
            r4.zzb(r8, r12)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r4 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            r4.zzb(r9)     // Catch:{ all -> 0x0105 }
            r12 = 1
            r4.zzf(r12)     // Catch:{ all -> 0x0105 }
            r3.zzg(r4)     // Catch:{ all -> 0x0105 }
        L_0x02ed:
            com.google.android.gms.measurement.internal.zzav r35 = r46.zzj()     // Catch:{ all -> 0x0105 }
            long r36 = r46.zzC()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r4 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r38 = r4.zzA()     // Catch:{ all -> 0x0105 }
            r44 = 0
            r45 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 1
            com.google.android.gms.measurement.internal.zzar r4 = r35.zzw(r36, r38, r39, r40, r41, r42, r43, r44, r45)     // Catch:{ all -> 0x0105 }
            long r12 = r4.zze     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzal r4 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r8 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfw r14 = com.google.android.gms.measurement.internal.zzfx.zzo     // Catch:{ all -> 0x0105 }
            int r4 = r4.zzm(r8, r14)     // Catch:{ all -> 0x0105 }
            long r14 = (long) r4     // Catch:{ all -> 0x0105 }
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x0328
            zzaA(r3, r9)     // Catch:{ all -> 0x0105 }
            goto L_0x032a
        L_0x0328:
            r21 = 1
        L_0x032a:
            java.lang.String r4 = r3.zzk()     // Catch:{ all -> 0x0105 }
            boolean r4 = com.google.android.gms.measurement.internal.zzpo.zzh(r4)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x03ee
            if (r2 == 0) goto L_0x03ee
            com.google.android.gms.measurement.internal.zzav r35 = r46.zzj()     // Catch:{ all -> 0x0105 }
            long r36 = r46.zzC()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r4 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r38 = r4.zzA()     // Catch:{ all -> 0x0105 }
            r44 = 0
            r45 = 0
            r39 = 0
            r40 = 0
            r41 = 1
            r42 = 0
            r43 = 0
            com.google.android.gms.measurement.internal.zzar r4 = r35.zzw(r36, r38, r39, r40, r41, r42, r43, r44, r45)     // Catch:{ all -> 0x0105 }
            long r8 = r4.zzc     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzal r4 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r12 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfw r13 = com.google.android.gms.measurement.internal.zzfx.zzn     // Catch:{ all -> 0x0105 }
            int r4 = r4.zzm(r12, r13)     // Catch:{ all -> 0x0105 }
            long r12 = (long) r4     // Catch:{ all -> 0x0105 }
            int r4 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x03ee
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zze()     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzid r9 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r9)     // Catch:{ all -> 0x0105 }
            r4.zzb(r8, r9)     // Catch:{ all -> 0x0105 }
            r4 = 0
            r8 = -1
            r9 = 0
            r14 = 0
        L_0x0388:
            int r12 = r3.zzb()     // Catch:{ all -> 0x0105 }
            if (r4 >= r12) goto L_0x03b4
            com.google.android.gms.internal.measurement.zzhw r12 = r3.zzc(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r13 = r12.zzb()     // Catch:{ all -> 0x0105 }
            boolean r13 = r7.equals(r13)     // Catch:{ all -> 0x0105 }
            if (r13 == 0) goto L_0x03a6
            com.google.android.gms.internal.measurement.zzma r8 = r12.zzcl()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r8 = (com.google.android.gms.internal.measurement.zzhv) r8     // Catch:{ all -> 0x0105 }
            r14 = r8
            r12 = 1
            r8 = r4
            goto L_0x03b2
        L_0x03a6:
            java.lang.String r12 = r12.zzb()     // Catch:{ all -> 0x0105 }
            boolean r12 = r5.equals(r12)     // Catch:{ all -> 0x0105 }
            if (r12 == 0) goto L_0x03b1
            r9 = 1
        L_0x03b1:
            r12 = 1
        L_0x03b2:
            int r4 = r4 + r12
            goto L_0x0388
        L_0x03b4:
            if (r9 == 0) goto L_0x03bd
            if (r14 == 0) goto L_0x03bc
            r3.zzj(r8)     // Catch:{ all -> 0x0105 }
            goto L_0x03ee
        L_0x03bc:
            r14 = 0
        L_0x03bd:
            if (r14 == 0) goto L_0x03d7
            com.google.android.gms.internal.measurement.zzma r4 = r14.zzaR()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r4 = (com.google.android.gms.internal.measurement.zzhv) r4     // Catch:{ all -> 0x0105 }
            r4.zzb(r5)     // Catch:{ all -> 0x0105 }
            r12 = 10
            r4.zzf(r12)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r4 = r4.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r4 = (com.google.android.gms.internal.measurement.zzhw) r4     // Catch:{ all -> 0x0105 }
            r3.zzd(r8, r4)     // Catch:{ all -> 0x0105 }
            goto L_0x03ee
        L_0x03d7:
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzid r8 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r8)     // Catch:{ all -> 0x0105 }
            r4.zzb(r5, r8)     // Catch:{ all -> 0x0105 }
        L_0x03ee:
            if (r2 == 0) goto L_0x04a7
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
            java.util.List r4 = r3.zza()     // Catch:{ all -> 0x0105 }
            r2.<init>(r4)     // Catch:{ all -> 0x0105 }
            r4 = 0
            r5 = -1
            r8 = -1
        L_0x03fc:
            int r9 = r2.size()     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = "currency"
            java.lang.String r13 = "value"
            if (r4 >= r9) goto L_0x042d
            java.lang.Object r9 = r2.get(r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r9 = (com.google.android.gms.internal.measurement.zzhw) r9     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzb()     // Catch:{ all -> 0x0105 }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x0419
            r5 = r4
        L_0x0417:
            r9 = 1
            goto L_0x042b
        L_0x0419:
            java.lang.Object r9 = r2.get(r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r9 = (com.google.android.gms.internal.measurement.zzhw) r9     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzb()     // Catch:{ all -> 0x0105 }
            boolean r9 = r12.equals(r9)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x0417
            r8 = r4
            goto L_0x0417
        L_0x042b:
            int r4 = r4 + r9
            goto L_0x03fc
        L_0x042d:
            r4 = -1
            if (r5 != r4) goto L_0x0432
            goto L_0x04a7
        L_0x0432:
            java.lang.Object r4 = r2.get(r5)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r4 = (com.google.android.gms.internal.measurement.zzhw) r4     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.zze()     // Catch:{ all -> 0x0105 }
            if (r4 != 0) goto L_0x0463
            java.lang.Object r4 = r2.get(r5)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r4 = (com.google.android.gms.internal.measurement.zzhw) r4     // Catch:{ all -> 0x0105 }
            boolean r4 = r4.zzi()     // Catch:{ all -> 0x0105 }
            if (r4 != 0) goto L_0x0463
            com.google.android.gms.measurement.internal.zzgt r2 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzh()     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = "Value must be specified with a numeric type."
            r2.zza(r4)     // Catch:{ all -> 0x0105 }
            r3.zzj(r5)     // Catch:{ all -> 0x0105 }
            zzaA(r3, r7)     // Catch:{ all -> 0x0105 }
            r2 = 18
            zzaz(r3, r2, r13)     // Catch:{ all -> 0x0105 }
            goto L_0x04a7
        L_0x0463:
            r4 = -1
            if (r8 != r4) goto L_0x0467
            goto L_0x048f
        L_0x0467:
            java.lang.Object r2 = r2.get(r8)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r2 = (com.google.android.gms.internal.measurement.zzhw) r2     // Catch:{ all -> 0x0105 }
            java.lang.String r2 = r2.zzd()     // Catch:{ all -> 0x0105 }
            int r4 = r2.length()     // Catch:{ all -> 0x0105 }
            r8 = 3
            if (r4 != r8) goto L_0x048f
            r4 = 0
        L_0x0479:
            int r8 = r2.length()     // Catch:{ all -> 0x0105 }
            if (r4 >= r8) goto L_0x04a7
            int r8 = r2.codePointAt(r4)     // Catch:{ all -> 0x0105 }
            boolean r9 = java.lang.Character.isLetter(r8)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x048f
            int r8 = java.lang.Character.charCount(r8)     // Catch:{ all -> 0x0105 }
            int r4 = r4 + r8
            goto L_0x0479
        L_0x048f:
            com.google.android.gms.measurement.internal.zzgt r2 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzh()     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.zza(r4)     // Catch:{ all -> 0x0105 }
            r3.zzj(r5)     // Catch:{ all -> 0x0105 }
            zzaA(r3, r7)     // Catch:{ all -> 0x0105 }
            r2 = 19
            zzaz(r3, r2, r12)     // Catch:{ all -> 0x0105 }
        L_0x04a7:
            java.lang.String r2 = r3.zzk()     // Catch:{ all -> 0x0105 }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x0105 }
            r4 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x04fc
            r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r2 = r3.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r2 = (com.google.android.gms.internal.measurement.zzhs) r2     // Catch:{ all -> 0x0105 }
            r8 = r25
            com.google.android.gms.internal.measurement.zzhw r2 = com.google.android.gms.measurement.internal.zzpj.zzF(r2, r8)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x04f7
            if (r34 == 0) goto L_0x04f0
            long r7 = r34.zzn()     // Catch:{ all -> 0x0105 }
            long r9 = r3.zzn()     // Catch:{ all -> 0x0105 }
            long r7 = r7 - r9
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0105 }
            int r2 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x04f0
            com.google.android.gms.internal.measurement.zzma r2 = r34.zzaR()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhr r2 = (com.google.android.gms.internal.measurement.zzhr) r2     // Catch:{ all -> 0x0105 }
            boolean r4 = r1.zzaH(r3, r2)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x04f0
            r7 = r30
            r6.zzf(r7, r2)     // Catch:{ all -> 0x0105 }
            r2 = r7
            r14 = 0
            r34 = 0
            r7 = r48
            goto L_0x0553
        L_0x04f0:
            r7 = r30
            r14 = r3
            r2 = r7
            r7 = r16
            goto L_0x0553
        L_0x04f7:
            r7 = r30
        L_0x04f9:
            r4 = r48
            goto L_0x054f
        L_0x04fc:
            r7 = r30
            java.lang.String r2 = "_vs"
            java.lang.String r8 = r3.zzk()     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.equals(r8)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x04f9
            r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r2 = r3.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r2 = (com.google.android.gms.internal.measurement.zzhs) r2     // Catch:{ all -> 0x0105 }
            r9 = r49
            com.google.android.gms.internal.measurement.zzhw r2 = com.google.android.gms.measurement.internal.zzpj.zzF(r2, r9)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x04f9
            if (r29 == 0) goto L_0x0545
            long r8 = r29.zzn()     // Catch:{ all -> 0x0105 }
            long r12 = r3.zzn()     // Catch:{ all -> 0x0105 }
            long r8 = r8 - r12
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x0105 }
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0545
            com.google.android.gms.internal.measurement.zzma r2 = r29.zzaR()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhr r2 = (com.google.android.gms.internal.measurement.zzhr) r2     // Catch:{ all -> 0x0105 }
            boolean r4 = r1.zzaH(r2, r3)     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x0545
            r4 = r48
            r6.zzf(r4, r2)     // Catch:{ all -> 0x0105 }
            r2 = r7
            r14 = 0
            r34 = 0
        L_0x0543:
            r7 = r4
            goto L_0x0553
        L_0x0545:
            r4 = r48
            r34 = r3
            r7 = r4
            r2 = r16
            r14 = r29
            goto L_0x0553
        L_0x054f:
            r2 = r7
            r14 = r29
            goto L_0x0543
        L_0x0553:
            int r4 = r3.zzb()     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x0672
            r46.zzp()     // Catch:{ all -> 0x0105 }
            java.util.List r4 = r3.zza()     // Catch:{ all -> 0x0105 }
            android.os.Bundle r4 = com.google.android.gms.measurement.internal.zzpj.zzE(r4)     // Catch:{ all -> 0x0105 }
            r5 = 0
        L_0x0565:
            int r8 = r3.zzb()     // Catch:{ all -> 0x0105 }
            if (r5 >= r8) goto L_0x061e
            com.google.android.gms.internal.measurement.zzhw r8 = r3.zzc(r5)     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r8.zzb()     // Catch:{ all -> 0x0105 }
            r10 = r24
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x05f3
            java.util.List r9 = r8.zzk()     // Catch:{ all -> 0x0105 }
            boolean r9 = r9.isEmpty()     // Catch:{ all -> 0x0105 }
            if (r9 != 0) goto L_0x05f3
            com.google.android.gms.internal.measurement.zzid r9 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0105 }
            java.util.List r8 = r8.zzk()     // Catch:{ all -> 0x0105 }
            int r12 = r8.size()     // Catch:{ all -> 0x0105 }
            android.os.Bundle[] r12 = new android.os.Bundle[r12]     // Catch:{ all -> 0x0105 }
            r13 = 0
        L_0x0596:
            int r15 = r8.size()     // Catch:{ all -> 0x0105 }
            if (r13 >= r15) goto L_0x05ea
            java.lang.Object r15 = r8.get(r13)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r15 = (com.google.android.gms.internal.measurement.zzhw) r15     // Catch:{ all -> 0x0105 }
            r46.zzp()     // Catch:{ all -> 0x0105 }
            java.util.List r24 = r15.zzk()     // Catch:{ all -> 0x0105 }
            r48 = r2
            android.os.Bundle r2 = com.google.android.gms.measurement.internal.zzpj.zzE(r24)     // Catch:{ all -> 0x0105 }
            java.util.List r15 = r15.zzk()     // Catch:{ all -> 0x0105 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ all -> 0x0105 }
        L_0x05b7:
            boolean r24 = r15.hasNext()     // Catch:{ all -> 0x0105 }
            if (r24 == 0) goto L_0x05db
            java.lang.Object r24 = r15.next()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r24 = (com.google.android.gms.internal.measurement.zzhw) r24     // Catch:{ all -> 0x0105 }
            r49 = r7
            java.lang.String r7 = r3.zzk()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzma r24 = r24.zzcl()     // Catch:{ all -> 0x0105 }
            r25 = r8
            r8 = r24
            com.google.android.gms.internal.measurement.zzhv r8 = (com.google.android.gms.internal.measurement.zzhv) r8     // Catch:{ all -> 0x0105 }
            r1.zzT(r7, r8, r2, r9)     // Catch:{ all -> 0x0105 }
            r7 = r49
            r8 = r25
            goto L_0x05b7
        L_0x05db:
            r49 = r7
            r25 = r8
            r12[r13] = r2     // Catch:{ all -> 0x0105 }
            r2 = 1
            int r13 = r13 + r2
            r2 = r48
            r7 = r49
            r8 = r25
            goto L_0x0596
        L_0x05ea:
            r48 = r2
            r49 = r7
            r4.putParcelableArray(r10, r12)     // Catch:{ all -> 0x0105 }
        L_0x05f1:
            r2 = 1
            goto L_0x0615
        L_0x05f3:
            r48 = r2
            r49 = r7
            java.lang.String r2 = r8.zzb()     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.equals(r10)     // Catch:{ all -> 0x0105 }
            if (r2 != 0) goto L_0x05f1
            java.lang.String r2 = r3.zzk()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzma r7 = r8.zzcl()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r7 = (com.google.android.gms.internal.measurement.zzhv) r7     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r8 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.zzA()     // Catch:{ all -> 0x0105 }
            r1.zzT(r2, r7, r4, r8)     // Catch:{ all -> 0x0105 }
            goto L_0x05f1
        L_0x0615:
            int r5 = r5 + r2
            r2 = r48
            r7 = r49
            r24 = r10
            goto L_0x0565
        L_0x061e:
            r48 = r2
            r49 = r7
            r10 = r24
            r3.zzi()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzpj r2 = r46.zzp()     // Catch:{ all -> 0x0105 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0105 }
            r5.<init>()     // Catch:{ all -> 0x0105 }
            java.util.Set r7 = r4.keySet()     // Catch:{ all -> 0x0105 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0105 }
        L_0x0638:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x065e
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r9 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            r9.zzb(r8)     // Catch:{ all -> 0x0105 }
            java.lang.Object r8 = r4.get(r8)     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x0638
            r2.zzd(r9, r8)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r8 = r9.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r8 = (com.google.android.gms.internal.measurement.zzhw) r8     // Catch:{ all -> 0x0105 }
            r5.add(r8)     // Catch:{ all -> 0x0105 }
            goto L_0x0638
        L_0x065e:
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x0105 }
        L_0x0662:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0105 }
            if (r4 == 0) goto L_0x0678
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r4 = (com.google.android.gms.internal.measurement.zzhw) r4     // Catch:{ all -> 0x0105 }
            r3.zzf(r4)     // Catch:{ all -> 0x0105 }
            goto L_0x0662
        L_0x0672:
            r48 = r2
            r49 = r7
            r10 = r24
        L_0x0678:
            java.util.List r2 = r11.zzc     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r4 = r3.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r4 = (com.google.android.gms.internal.measurement.zzhs) r4     // Catch:{ all -> 0x0105 }
            r7 = r28
            r2.set(r7, r4)     // Catch:{ all -> 0x0105 }
            r6.zzg(r3)     // Catch:{ all -> 0x0105 }
            r2 = 1
            int r16 = r16 + 1
            r3 = r48
            r4 = r49
            r13 = r33
            r12 = r34
        L_0x0693:
            int r15 = r7 + 1
            r2 = r3
            r7 = r4
            r4 = r22
            r5 = r23
            r8 = r31
            r9 = r32
            goto L_0x0055
        L_0x06a1:
            r9 = r49
            r8 = r25
            r2 = 0
            r12 = r2
            r5 = r16
            r4 = 0
        L_0x06ab:
            if (r4 >= r5) goto L_0x06f9
            com.google.android.gms.internal.measurement.zzhs r14 = r6.zzd(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r15 = r14.zzd()     // Catch:{ all -> 0x0105 }
            boolean r15 = r10.equals(r15)     // Catch:{ all -> 0x0105 }
            if (r15 == 0) goto L_0x06cc
            r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r15 = com.google.android.gms.measurement.internal.zzpj.zzF(r14, r8)     // Catch:{ all -> 0x0105 }
            if (r15 == 0) goto L_0x06cc
            r6.zzj(r4)     // Catch:{ all -> 0x0105 }
            r15 = -1
            int r5 = r5 + r15
            int r4 = r4 + r15
        L_0x06ca:
            r14 = 1
            goto L_0x06f7
        L_0x06cc:
            r15 = -1
            r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r14 = com.google.android.gms.measurement.internal.zzpj.zzF(r14, r9)     // Catch:{ all -> 0x0105 }
            if (r14 == 0) goto L_0x06ca
            boolean r16 = r14.zze()     // Catch:{ all -> 0x0105 }
            if (r16 == 0) goto L_0x06e5
            long r24 = r14.zzf()     // Catch:{ all -> 0x0105 }
            java.lang.Long r14 = java.lang.Long.valueOf(r24)     // Catch:{ all -> 0x0105 }
            goto L_0x06e6
        L_0x06e5:
            r14 = 0
        L_0x06e6:
            if (r14 == 0) goto L_0x06ca
            long r24 = r14.longValue()     // Catch:{ all -> 0x0105 }
            int r16 = (r24 > r2 ? 1 : (r24 == r2 ? 0 : -1))
            if (r16 <= 0) goto L_0x06ca
            long r24 = r14.longValue()     // Catch:{ all -> 0x0105 }
            long r12 = r12 + r24
            goto L_0x06ca
        L_0x06f7:
            int r4 = r4 + r14
            goto L_0x06ab
        L_0x06f9:
            r4 = 0
            r1.zzaG(r6, r12, r4)     // Catch:{ all -> 0x0105 }
            java.util.List r4 = r6.zzb()     // Catch:{ all -> 0x0105 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0105 }
        L_0x0705:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = "_se"
            if (r5 == 0) goto L_0x072a
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r5 = (com.google.android.gms.internal.measurement.zzhs) r5     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = "_s"
            java.lang.String r5 = r5.zzd()     // Catch:{ all -> 0x0105 }
            boolean r5 = r9.equals(r5)     // Catch:{ all -> 0x0105 }
            if (r5 == 0) goto L_0x0705
            com.google.android.gms.measurement.internal.zzav r4 = r46.zzj()     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = r6.zzK()     // Catch:{ all -> 0x0105 }
            r4.zzk(r5, r8)     // Catch:{ all -> 0x0105 }
        L_0x072a:
            java.lang.String r4 = "_sid"
            int r4 = com.google.android.gms.measurement.internal.zzpj.zzx(r6, r4)     // Catch:{ all -> 0x0105 }
            if (r4 < 0) goto L_0x0737
            r4 = 1
            r1.zzaG(r6, r12, r4)     // Catch:{ all -> 0x0105 }
            goto L_0x0757
        L_0x0737:
            int r4 = com.google.android.gms.measurement.internal.zzpj.zzx(r6, r8)     // Catch:{ all -> 0x0105 }
            if (r4 < 0) goto L_0x0757
            r6.zzr(r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.zzid r8 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r8)     // Catch:{ all -> 0x0105 }
            r4.zzb(r5, r8)     // Catch:{ all -> 0x0105 }
        L_0x0757:
            com.google.android.gms.internal.measurement.zzid r4 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r4.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzhy r5 = r46.zzaW()     // Catch:{ all -> 0x0105 }
            r5.zzg()     // Catch:{ all -> 0x0105 }
            r46.zzu()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzav r5 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzh r5 = r5.zzu(r4)     // Catch:{ all -> 0x0105 }
            if (r5 != 0) goto L_0x0783
            com.google.android.gms.measurement.internal.zzgt r5 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ all -> 0x0105 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r4)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = "Cannot fix consent fields without appInfo. appId"
            r5.zzb(r8, r4)     // Catch:{ all -> 0x0105 }
            goto L_0x0786
        L_0x0783:
            r1.zzI(r5, r6)     // Catch:{ all -> 0x0105 }
        L_0x0786:
            com.google.android.gms.internal.measurement.zzid r4 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r4.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzhy r5 = r46.zzaW()     // Catch:{ all -> 0x0105 }
            r5.zzg()     // Catch:{ all -> 0x0105 }
            r46.zzu()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzav r5 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzh r5 = r5.zzu(r4)     // Catch:{ all -> 0x0105 }
            if (r5 != 0) goto L_0x07b2
            com.google.android.gms.measurement.internal.zzgt r5 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zze()     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = "Cannot populate ad_campaign_info without appInfo. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r4)     // Catch:{ all -> 0x0105 }
            r5.zzb(r8, r4)     // Catch:{ all -> 0x0105 }
            goto L_0x07b5
        L_0x07b2:
            r1.zzJ(r5, r6)     // Catch:{ all -> 0x0105 }
        L_0x07b5:
            zzaR(r6)     // Catch:{ all -> 0x0105 }
            r6.zzak()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzjk r4 = com.google.android.gms.measurement.internal.zzjk.zza     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r4 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r4 = r4.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzjk r4 = r1.zzB(r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r5 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r5 = r5.zzaf()     // Catch:{ all -> 0x0105 }
            r8 = 100
            com.google.android.gms.measurement.internal.zzjk r5 = com.google.android.gms.measurement.internal.zzjk.zzf(r5, r8)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzjk r4 = r4.zzs(r5)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzav r5 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r8 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = r8.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzjk r5 = r5.zzaf(r8)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzav r8 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r9 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0105 }
            r8.zzae(r9, r4)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzjj r8 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE     // Catch:{ all -> 0x0105 }
            boolean r9 = r4.zzo(r8)     // Catch:{ all -> 0x0105 }
            if (r9 != 0) goto L_0x080e
            boolean r9 = r5.zzo(r8)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x080e
            com.google.android.gms.measurement.internal.zzav r5 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r9 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0105 }
            r5.zzi(r9)     // Catch:{ all -> 0x0105 }
            goto L_0x0827
        L_0x080e:
            boolean r9 = r4.zzo(r8)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x0827
            boolean r5 = r5.zzo(r8)     // Catch:{ all -> 0x0105 }
            if (r5 != 0) goto L_0x0827
            com.google.android.gms.measurement.internal.zzav r5 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r9 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0105 }
            r5.zzj(r9)     // Catch:{ all -> 0x0105 }
        L_0x0827:
            com.google.android.gms.measurement.internal.zzjj r5 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE     // Catch:{ all -> 0x0105 }
            boolean r9 = r4.zzo(r5)     // Catch:{ all -> 0x0105 }
            if (r9 != 0) goto L_0x0838
            r6.zzR()     // Catch:{ all -> 0x0105 }
            r6.zzU()     // Catch:{ all -> 0x0105 }
            r6.zzan()     // Catch:{ all -> 0x0105 }
        L_0x0838:
            boolean r9 = r4.zzo(r8)     // Catch:{ all -> 0x0105 }
            if (r9 != 0) goto L_0x0844
            r6.zzX()     // Catch:{ all -> 0x0105 }
            r6.zzav()     // Catch:{ all -> 0x0105 }
        L_0x0844:
            com.google.android.gms.internal.measurement.zzql.zza()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzal r9 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfw r12 = com.google.android.gms.measurement.internal.zzfx.zzaP     // Catch:{ all -> 0x0105 }
            boolean r9 = r9.zzp(r10, r12)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x0a62
            com.google.android.gms.measurement.internal.zzpo r9 = r46.zzt()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0105 }
            boolean r9 = r9.zzX(r10)     // Catch:{ all -> 0x0105 }
            if (r9 == 0) goto L_0x0a62
            com.google.android.gms.internal.measurement.zzid r9 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r9 = r9.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzjk r9 = r1.zzB(r9)     // Catch:{ all -> 0x0105 }
            boolean r5 = r9.zzo(r5)     // Catch:{ all -> 0x0105 }
            if (r5 == 0) goto L_0x0a62
            com.google.android.gms.internal.measurement.zzid r5 = r11.zza     // Catch:{ all -> 0x0105 }
            boolean r5 = r5.zzak()     // Catch:{ all -> 0x0105 }
            if (r5 == 0) goto L_0x0a62
            r5 = 0
        L_0x0882:
            int r9 = r6.zzc()     // Catch:{ all -> 0x0105 }
            if (r5 >= r9) goto L_0x0a62
            com.google.android.gms.internal.measurement.zzhs r9 = r6.zzd(r5)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzma r9 = r9.zzcl()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhr r9 = (com.google.android.gms.internal.measurement.zzhr) r9     // Catch:{ all -> 0x0105 }
            java.util.List r10 = r9.zza()     // Catch:{ all -> 0x0105 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0105 }
        L_0x089a:
            boolean r12 = r10.hasNext()     // Catch:{ all -> 0x0105 }
            if (r12 == 0) goto L_0x0a58
            java.lang.Object r12 = r10.next()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r12 = (com.google.android.gms.internal.measurement.zzhw) r12     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r12.zzb()     // Catch:{ all -> 0x0105 }
            boolean r12 = r7.equals(r12)     // Catch:{ all -> 0x0105 }
            if (r12 == 0) goto L_0x089a
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            int r10 = r10.zzar()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzal r12 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r13 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r13 = r13.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfw r14 = com.google.android.gms.measurement.internal.zzfx.zzal     // Catch:{ all -> 0x0105 }
            int r12 = r12.zzm(r13, r14)     // Catch:{ all -> 0x0105 }
            if (r10 < r12) goto L_0x0918
            com.google.android.gms.measurement.internal.zzal r10 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r12 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfw r13 = com.google.android.gms.measurement.internal.zzfx.zzay     // Catch:{ all -> 0x0105 }
            int r10 = r10.zzm(r12, r13)     // Catch:{ all -> 0x0105 }
            if (r10 <= 0) goto L_0x09b8
            com.google.android.gms.measurement.internal.zzav r28 = r46.zzj()     // Catch:{ all -> 0x0105 }
            long r29 = r46.zzC()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r12 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r31 = r12.zzA()     // Catch:{ all -> 0x0105 }
            r37 = 0
            r38 = 1
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            com.google.android.gms.measurement.internal.zzar r12 = r28.zzw(r29, r31, r32, r33, r34, r35, r36, r37, r38)     // Catch:{ all -> 0x0105 }
            long r12 = r12.zzg     // Catch:{ all -> 0x0105 }
            long r14 = (long) r10     // Catch:{ all -> 0x0105 }
            int r10 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r10 <= 0) goto L_0x091c
            com.google.android.gms.internal.measurement.zzhv r10 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = "_tnr"
            r10.zzb(r12)     // Catch:{ all -> 0x0105 }
            r12 = 1
            r10.zzf(r12)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r10 = r10.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r10 = (com.google.android.gms.internal.measurement.zzhw) r10     // Catch:{ all -> 0x0105 }
            r9.zzf(r10)     // Catch:{ all -> 0x0105 }
        L_0x0918:
            r15 = r18
            goto L_0x0a4d
        L_0x091c:
            com.google.android.gms.measurement.internal.zzal r10 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r12 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfw r13 = com.google.android.gms.measurement.internal.zzfx.zzaR     // Catch:{ all -> 0x0105 }
            boolean r10 = r10.zzp(r12, r13)     // Catch:{ all -> 0x0105 }
            if (r10 == 0) goto L_0x094c
            com.google.android.gms.measurement.internal.zzpo r10 = r46.zzt()     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = r10.zzaw()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r10 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            r12 = r23
            r10.zzb(r12)     // Catch:{ all -> 0x0105 }
            r10.zzd(r14)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r10 = r10.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r10 = (com.google.android.gms.internal.measurement.zzhw) r10     // Catch:{ all -> 0x0105 }
            r9.zzf(r10)     // Catch:{ all -> 0x0105 }
            goto L_0x094f
        L_0x094c:
            r12 = r23
            r14 = 0
        L_0x094f:
            com.google.android.gms.internal.measurement.zzhv r10 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            r13 = r22
            r10.zzb(r13)     // Catch:{ all -> 0x0105 }
            r2 = 1
            r10.zzf(r2)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r2 = r10.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r2 = (com.google.android.gms.internal.measurement.zzhw) r2     // Catch:{ all -> 0x0105 }
            r9.zzf(r2)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzpj r2 = r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzog r2 = r2.zzf(r3, r6, r9, r14)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x09b5
            com.google.android.gms.measurement.internal.zzgt r3 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzk()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = r2.zza     // Catch:{ all -> 0x0105 }
            r15 = r18
            r3.zzc(r15, r10, r14)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzav r3 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0105 }
            r3.zzaa(r10, r2)     // Catch:{ all -> 0x0105 }
            java.util.Deque r2 = r1.zzr     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            boolean r3 = r2.contains(r3)     // Catch:{ all -> 0x0105 }
            if (r3 != 0) goto L_0x09af
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            r2.add(r3)     // Catch:{ all -> 0x0105 }
        L_0x09af:
            r23 = r12
            r22 = r13
            goto L_0x0a4d
        L_0x09b5:
            r15 = r18
            goto L_0x09af
        L_0x09b8:
            r15 = r18
            r13 = r22
            r12 = r23
            com.google.android.gms.measurement.internal.zzal r2 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzfw r10 = com.google.android.gms.measurement.internal.zzfx.zzaR     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.zzp(r3, r10)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x09ec
            com.google.android.gms.measurement.internal.zzpo r2 = r46.zzt()     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = r2.zzaw()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhv r2 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            r2.zzb(r12)     // Catch:{ all -> 0x0105 }
            r2.zzd(r14)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r2 = r2.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r2 = (com.google.android.gms.internal.measurement.zzhw) r2     // Catch:{ all -> 0x0105 }
            r9.zzf(r2)     // Catch:{ all -> 0x0105 }
            goto L_0x09ed
        L_0x09ec:
            r14 = 0
        L_0x09ed:
            com.google.android.gms.internal.measurement.zzhv r2 = com.google.android.gms.internal.measurement.zzhw.zzn()     // Catch:{ all -> 0x0105 }
            r2.zzb(r13)     // Catch:{ all -> 0x0105 }
            r23 = r12
            r22 = r13
            r12 = 1
            r2.zzf(r12)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r2 = r2.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhw r2 = (com.google.android.gms.internal.measurement.zzhw) r2     // Catch:{ all -> 0x0105 }
            r9.zzf(r2)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzpj r2 = r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzog r2 = r2.zzf(r3, r6, r9, r14)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x0a4d
            com.google.android.gms.measurement.internal.zzgt r3 = r46.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzk()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x0105 }
            r3.zzc(r15, r10, r12)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzav r3 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0105 }
            r3.zzaa(r10, r2)     // Catch:{ all -> 0x0105 }
            java.util.Deque r2 = r1.zzr     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            boolean r3 = r2.contains(r3)     // Catch:{ all -> 0x0105 }
            if (r3 != 0) goto L_0x0a4d
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            r2.add(r3)     // Catch:{ all -> 0x0105 }
        L_0x0a4d:
            com.google.android.gms.internal.measurement.zzme r2 = r9.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r2 = (com.google.android.gms.internal.measurement.zzhs) r2     // Catch:{ all -> 0x0105 }
            r6.zze(r5, r2)     // Catch:{ all -> 0x0105 }
        L_0x0a56:
            r2 = 1
            goto L_0x0a5b
        L_0x0a58:
            r15 = r18
            goto L_0x0a56
        L_0x0a5b:
            int r5 = r5 + r2
            r18 = r15
            r2 = 0
            goto L_0x0882
        L_0x0a62:
            r6.zzag()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzad r28 = r46.zzm()     // Catch:{ all -> 0x0105 }
            java.lang.String r29 = r6.zzK()     // Catch:{ all -> 0x0105 }
            java.util.List r30 = r6.zzb()     // Catch:{ all -> 0x0105 }
            java.util.List r31 = r6.zzk()     // Catch:{ all -> 0x0105 }
            long r2 = r6.zzu()     // Catch:{ all -> 0x0105 }
            java.lang.Long r32 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0105 }
            long r2 = r6.zzw()     // Catch:{ all -> 0x0105 }
            java.lang.Long r33 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0105 }
            boolean r2 = r4.zzo(r8)     // Catch:{ all -> 0x0105 }
            r3 = 1
            r34 = r2 ^ 1
            java.util.List r2 = r28.zzb(r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x0105 }
            r6.zzaf(r2)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzal r2 = r46.zzd()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r3 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r3 = r3.zzA()     // Catch:{ all -> 0x0105 }
            boolean r2 = r2.zzD(r3)     // Catch:{ all -> 0x0105 }
            if (r2 == 0) goto L_0x0ddb
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0bdf }
            r2.<init>()     // Catch:{ all -> 0x0bdf }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0bdf }
            r3.<init>()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzpo r4 = r46.zzt()     // Catch:{ all -> 0x0bdf }
            java.security.SecureRandom r4 = r4.zzf()     // Catch:{ all -> 0x0bdf }
            r5 = 0
        L_0x0ab6:
            int r7 = r6.zzc()     // Catch:{ all -> 0x0bdf }
            if (r5 >= r7) goto L_0x0da3
            com.google.android.gms.internal.measurement.zzhs r7 = r6.zzd(r5)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzma r7 = r7.zzcl()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhr r7 = (com.google.android.gms.internal.measurement.zzhr) r7     // Catch:{ all -> 0x0bdf }
            java.lang.String r8 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            java.lang.String r9 = "_ep"
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0bdf }
            java.lang.String r9 = "_sr"
            if (r8 == 0) goto L_0x0b56
            r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzme r8 = r7.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r8 = (com.google.android.gms.internal.measurement.zzhs) r8     // Catch:{ all -> 0x0105 }
            java.lang.String r10 = "_en"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzpj.zzI(r8, r10)     // Catch:{ all -> 0x0105 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0105 }
            java.lang.Object r10 = r2.get(r8)     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzbc r10 = (com.google.android.gms.measurement.internal.zzbc) r10     // Catch:{ all -> 0x0105 }
            if (r10 != 0) goto L_0x0b06
            com.google.android.gms.measurement.internal.zzav r10 = r46.zzj()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzid r12 = r11.zza     // Catch:{ all -> 0x0105 }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0105 }
            java.lang.Object r13 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ all -> 0x0105 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzbc r10 = r10.zzf(r12, r13)     // Catch:{ all -> 0x0105 }
            if (r10 == 0) goto L_0x0b06
            r2.put(r8, r10)     // Catch:{ all -> 0x0105 }
        L_0x0b06:
            if (r10 == 0) goto L_0x0b45
            java.lang.Long r8 = r10.zzi     // Catch:{ all -> 0x0105 }
            if (r8 != 0) goto L_0x0b45
            java.lang.Long r8 = r10.zzj     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x0b20
            long r12 = r8.longValue()     // Catch:{ all -> 0x0105 }
            r14 = 1
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 <= 0) goto L_0x0b20
            r46.zzp()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzpj.zzC(r7, r9, r8)     // Catch:{ all -> 0x0105 }
        L_0x0b20:
            java.lang.Boolean r8 = r10.zzk     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x0b39
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0105 }
            if (r8 == 0) goto L_0x0b39
            r46.zzp()     // Catch:{ all -> 0x0105 }
            r8 = 1
            java.lang.Long r10 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0105 }
            r8 = r17
            com.google.android.gms.measurement.internal.zzpj.zzC(r7, r8, r10)     // Catch:{ all -> 0x0105 }
            goto L_0x0b3b
        L_0x0b39:
            r8 = r17
        L_0x0b3b:
            com.google.android.gms.internal.measurement.zzme r9 = r7.zzbc()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.internal.measurement.zzhs r9 = (com.google.android.gms.internal.measurement.zzhs) r9     // Catch:{ all -> 0x0105 }
            r3.add(r9)     // Catch:{ all -> 0x0105 }
            goto L_0x0b47
        L_0x0b45:
            r8 = r17
        L_0x0b47:
            r6.zzf(r5, r7)     // Catch:{ all -> 0x0105 }
            r24 = r4
            r1 = r5
            r5 = r8
            r26 = r11
            r4 = 0
            r7 = 1
            r16 = 1
            goto L_0x0d97
        L_0x0b56:
            r8 = r17
            com.google.android.gms.measurement.internal.zzhs r10 = r46.zzh()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzid r12 = r11.zza     // Catch:{ all -> 0x0bdf }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0bdf }
            java.lang.String r13 = "measurement.account.time_zone_offset_minutes"
            java.lang.String r13 = r10.zza(r12, r13)     // Catch:{ all -> 0x0bdf }
            boolean r14 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0bdf }
            if (r14 != 0) goto L_0x0b88
            long r12 = java.lang.Long.parseLong(r13)     // Catch:{ NumberFormatException -> 0x0b73 }
            goto L_0x0b8a
        L_0x0b73:
            r0 = move-exception
            r13 = r0
            com.google.android.gms.measurement.internal.zzib r10 = r10.zzu     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgt r10 = r10.zzaV()     // Catch:{ all -> 0x0105 }
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zze()     // Catch:{ all -> 0x0105 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgt.zzl(r12)     // Catch:{ all -> 0x0105 }
            java.lang.String r14 = "Unable to parse timezone offset. appId"
            r10.zzc(r14, r12, r13)     // Catch:{ all -> 0x0105 }
        L_0x0b88:
            r12 = 0
        L_0x0b8a:
            com.google.android.gms.measurement.internal.zzpo r10 = r46.zzt()     // Catch:{ all -> 0x0bdf }
            long r14 = r7.zzn()     // Catch:{ all -> 0x0bdf }
            long r14 = r10.zzaj(r14, r12)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzme r10 = r7.zzbc()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhs r10 = (com.google.android.gms.internal.measurement.zzhs) r10     // Catch:{ all -> 0x0bdf }
            r16 = 1
            java.lang.Long r1 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0bdf }
            r18 = r8
            java.lang.String r8 = "_dbg"
            boolean r19 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x0bdf }
            if (r19 != 0) goto L_0x0be7
            java.util.List r10 = r10.zza()     // Catch:{ all -> 0x0bdf }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0bdf }
        L_0x0bb4:
            boolean r19 = r10.hasNext()     // Catch:{ all -> 0x0bdf }
            if (r19 == 0) goto L_0x0be7
            java.lang.Object r19 = r10.next()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhw r19 = (com.google.android.gms.internal.measurement.zzhw) r19     // Catch:{ all -> 0x0bdf }
            r22 = r10
            java.lang.String r10 = r19.zzb()     // Catch:{ all -> 0x0bdf }
            boolean r10 = r8.equals(r10)     // Catch:{ all -> 0x0bdf }
            if (r10 == 0) goto L_0x0be4
            long r22 = r19.zzf()     // Catch:{ all -> 0x0bdf }
            java.lang.Long r8 = java.lang.Long.valueOf(r22)     // Catch:{ all -> 0x0bdf }
            boolean r8 = r1.equals(r8)     // Catch:{ all -> 0x0bdf }
            if (r8 != 0) goto L_0x0bdb
            goto L_0x0be7
        L_0x0bdb:
            r19 = r1
            r1 = 1
            goto L_0x0bfb
        L_0x0bdf:
            r0 = move-exception
            r3 = r46
            goto L_0x0107
        L_0x0be4:
            r10 = r22
            goto L_0x0bb4
        L_0x0be7:
            com.google.android.gms.measurement.internal.zzhs r8 = r46.zzh()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0bdf }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0bdf }
            r19 = r1
            java.lang.String r1 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            int r1 = r8.zzm(r10, r1)     // Catch:{ all -> 0x0bdf }
        L_0x0bfb:
            if (r1 > 0) goto L_0x0c29
            com.google.android.gms.measurement.internal.zzgt r8 = r46.zzaV()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zze()     // Catch:{ all -> 0x0bdf }
            java.lang.String r9 = "Sample rate must be positive. event, rate"
            java.lang.String r10 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0bdf }
            r8.zzc(r9, r10, r1)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzme r1 = r7.zzbc()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhs r1 = (com.google.android.gms.internal.measurement.zzhs) r1     // Catch:{ all -> 0x0bdf }
            r3.add(r1)     // Catch:{ all -> 0x0bdf }
            r6.zzf(r5, r7)     // Catch:{ all -> 0x0bdf }
            r24 = r4
            r1 = r5
            r26 = r11
            r5 = r18
            r4 = 0
        L_0x0c26:
            r7 = 1
            goto L_0x0d97
        L_0x0c29:
            java.lang.String r8 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            java.lang.Object r8 = r2.get(r8)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzbc r8 = (com.google.android.gms.measurement.internal.zzbc) r8     // Catch:{ all -> 0x0bdf }
            if (r8 != 0) goto L_0x0c88
            com.google.android.gms.measurement.internal.zzav r8 = r46.zzj()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0bdf }
            java.lang.String r10 = r10.zzA()     // Catch:{ all -> 0x0bdf }
            r22 = r12
            java.lang.String r12 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzbc r8 = r8.zzf(r10, r12)     // Catch:{ all -> 0x0bdf }
            if (r8 != 0) goto L_0x0c8a
            com.google.android.gms.measurement.internal.zzgt r8 = r46.zzaV()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zze()     // Catch:{ all -> 0x0bdf }
            java.lang.String r10 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzid r12 = r11.zza     // Catch:{ all -> 0x0bdf }
            java.lang.String r12 = r12.zzA()     // Catch:{ all -> 0x0bdf }
            java.lang.String r13 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            r8.zzc(r10, r12, r13)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzbc r8 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzid r10 = r11.zza     // Catch:{ all -> 0x0bdf }
            java.lang.String r25 = r10.zzA()     // Catch:{ all -> 0x0bdf }
            java.lang.String r26 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            long r33 = r7.zzn()     // Catch:{ all -> 0x0bdf }
            r39 = 0
            r40 = 0
            r27 = 1
            r29 = 1
            r31 = 1
            r35 = 0
            r37 = 0
            r38 = 0
            r24 = r8
            r24.<init>(r25, r26, r27, r29, r31, r33, r35, r37, r38, r39, r40)     // Catch:{ all -> 0x0bdf }
            goto L_0x0c8a
        L_0x0c88:
            r22 = r12
        L_0x0c8a:
            r46.zzp()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzme r10 = r7.zzbc()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhs r10 = (com.google.android.gms.internal.measurement.zzhs) r10     // Catch:{ all -> 0x0bdf }
            java.lang.String r12 = "_eid"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzpj.zzI(r10, r12)     // Catch:{ all -> 0x0bdf }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0bdf }
            if (r10 == 0) goto L_0x0ca0
            r12 = 1
        L_0x0c9e:
            r13 = 1
            goto L_0x0ca2
        L_0x0ca0:
            r12 = 0
            goto L_0x0c9e
        L_0x0ca2:
            if (r1 != r13) goto L_0x0cd7
            com.google.android.gms.internal.measurement.zzme r1 = r7.zzbc()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhs r1 = (com.google.android.gms.internal.measurement.zzhs) r1     // Catch:{ all -> 0x0bdf }
            r3.add(r1)     // Catch:{ all -> 0x0bdf }
            if (r12 == 0) goto L_0x0cbd
            java.lang.Long r1 = r8.zzi     // Catch:{ all -> 0x0bdf }
            if (r1 != 0) goto L_0x0cbb
            java.lang.Long r1 = r8.zzj     // Catch:{ all -> 0x0bdf }
            if (r1 != 0) goto L_0x0cbb
            java.lang.Boolean r1 = r8.zzk     // Catch:{ all -> 0x0bdf }
            if (r1 == 0) goto L_0x0cbd
        L_0x0cbb:
            r13 = 0
            goto L_0x0cbf
        L_0x0cbd:
            r13 = 0
            goto L_0x0cca
        L_0x0cbf:
            com.google.android.gms.measurement.internal.zzbc r1 = r8.zzc(r13, r13, r13)     // Catch:{ all -> 0x0bdf }
            java.lang.String r8 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            r2.put(r8, r1)     // Catch:{ all -> 0x0bdf }
        L_0x0cca:
            r6.zzf(r5, r7)     // Catch:{ all -> 0x0bdf }
            r24 = r4
            r1 = r5
            r26 = r11
            r4 = r13
            r5 = r18
            goto L_0x0c26
        L_0x0cd7:
            r13 = 0
            int r20 = r4.nextInt(r1)     // Catch:{ all -> 0x0bdf }
            if (r20 != 0) goto L_0x0d16
            r46.zzp()     // Catch:{ all -> 0x0bdf }
            r24 = r14
            long r13 = (long) r1     // Catch:{ all -> 0x0bdf }
            java.lang.Long r1 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzpj.zzC(r7, r9, r1)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzme r9 = r7.zzbc()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhs r9 = (com.google.android.gms.internal.measurement.zzhs) r9     // Catch:{ all -> 0x0bdf }
            r3.add(r9)     // Catch:{ all -> 0x0bdf }
            if (r12 == 0) goto L_0x0cfb
            r9 = 0
            com.google.android.gms.measurement.internal.zzbc r8 = r8.zzc(r9, r1, r9)     // Catch:{ all -> 0x0bdf }
        L_0x0cfb:
            java.lang.String r1 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            long r9 = r7.zzn()     // Catch:{ all -> 0x0bdf }
            r13 = r24
            com.google.android.gms.measurement.internal.zzbc r8 = r8.zzb(r9, r13)     // Catch:{ all -> 0x0bdf }
            r2.put(r1, r8)     // Catch:{ all -> 0x0bdf }
            r24 = r4
            r1 = r5
            r26 = r11
            r5 = r18
        L_0x0d13:
            r4 = 0
            goto L_0x0d92
        L_0x0d16:
            r13 = r14
            java.lang.Long r15 = r8.zzh     // Catch:{ all -> 0x0bdf }
            if (r15 == 0) goto L_0x0d28
            long r22 = r15.longValue()     // Catch:{ all -> 0x0bdf }
            r24 = r4
            r25 = r5
            r27 = r10
            r26 = r11
            goto L_0x0d3e
        L_0x0d28:
            com.google.android.gms.measurement.internal.zzpo r15 = r46.zzt()     // Catch:{ all -> 0x0bdf }
            r24 = r4
            r25 = r5
            long r4 = r7.zzp()     // Catch:{ all -> 0x0bdf }
            r27 = r10
            r26 = r11
            r10 = r22
            long r22 = r15.zzaj(r4, r10)     // Catch:{ all -> 0x0bdf }
        L_0x0d3e:
            int r4 = (r22 > r13 ? 1 : (r22 == r13 ? 0 : -1))
            if (r4 == 0) goto L_0x0d7b
            r46.zzp()     // Catch:{ all -> 0x0bdf }
            r5 = r18
            r4 = r19
            com.google.android.gms.measurement.internal.zzpj.zzC(r7, r5, r4)     // Catch:{ all -> 0x0bdf }
            r46.zzp()     // Catch:{ all -> 0x0bdf }
            long r10 = (long) r1     // Catch:{ all -> 0x0bdf }
            java.lang.Long r1 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzpj.zzC(r7, r9, r1)     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzme r4 = r7.zzbc()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.internal.measurement.zzhs r4 = (com.google.android.gms.internal.measurement.zzhs) r4     // Catch:{ all -> 0x0bdf }
            r3.add(r4)     // Catch:{ all -> 0x0bdf }
            if (r12 == 0) goto L_0x0d69
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0bdf }
            r9 = 0
            com.google.android.gms.measurement.internal.zzbc r8 = r8.zzc(r9, r1, r4)     // Catch:{ all -> 0x0bdf }
        L_0x0d69:
            java.lang.String r1 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            long r9 = r7.zzn()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzbc r4 = r8.zzb(r9, r13)     // Catch:{ all -> 0x0bdf }
            r2.put(r1, r4)     // Catch:{ all -> 0x0bdf }
            r1 = r25
            goto L_0x0d13
        L_0x0d7b:
            r5 = r18
            if (r12 == 0) goto L_0x0d90
            java.lang.String r1 = r7.zzk()     // Catch:{ all -> 0x0bdf }
            r10 = r27
            r4 = 0
            com.google.android.gms.measurement.internal.zzbc r8 = r8.zzc(r10, r4, r4)     // Catch:{ all -> 0x0bdf }
            r2.put(r1, r8)     // Catch:{ all -> 0x0bdf }
        L_0x0d8d:
            r1 = r25
            goto L_0x0d92
        L_0x0d90:
            r4 = 0
            goto L_0x0d8d
        L_0x0d92:
            r6.zzf(r1, r7)     // Catch:{ all -> 0x0bdf }
            goto L_0x0c26
        L_0x0d97:
            int r1 = r1 + r7
            r17 = r5
            r4 = r24
            r11 = r26
            r5 = r1
            r1 = r46
            goto L_0x0ab6
        L_0x0da3:
            r26 = r11
            r7 = 1
            int r1 = r3.size()     // Catch:{ all -> 0x0bdf }
            int r4 = r6.zzc()     // Catch:{ all -> 0x0bdf }
            if (r1 >= r4) goto L_0x0db6
            r6.zzi()     // Catch:{ all -> 0x0bdf }
            r6.zzh(r3)     // Catch:{ all -> 0x0bdf }
        L_0x0db6:
            java.util.Set r1 = r2.entrySet()     // Catch:{ all -> 0x0bdf }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0bdf }
        L_0x0dbe:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0bdf }
            if (r2 == 0) goto L_0x0dd8
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0bdf }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzav r3 = r46.zzj()     // Catch:{ all -> 0x0bdf }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzbc r2 = (com.google.android.gms.measurement.internal.zzbc) r2     // Catch:{ all -> 0x0bdf }
            r3.zzh(r2)     // Catch:{ all -> 0x0bdf }
            goto L_0x0dbe
        L_0x0dd8:
            r1 = r26
            goto L_0x0ddd
        L_0x0ddb:
            r7 = 1
            r1 = r11
        L_0x0ddd:
            com.google.android.gms.internal.measurement.zzid r2 = r1.zza     // Catch:{ all -> 0x0bdf }
            java.lang.String r2 = r2.zzA()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzav r3 = r46.zzj()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzh r3 = r3.zzu(r2)     // Catch:{ all -> 0x0bdf }
            if (r3 != 0) goto L_0x0e05
            com.google.android.gms.measurement.internal.zzgt r3 = r46.zzaV()     // Catch:{ all -> 0x0bdf }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x0bdf }
            java.lang.String r4 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzid r5 = r1.zza     // Catch:{ all -> 0x0bdf }
            java.lang.String r5 = r5.zzA()     // Catch:{ all -> 0x0bdf }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r5)     // Catch:{ all -> 0x0bdf }
            r3.zzb(r4, r5)     // Catch:{ all -> 0x0bdf }
            goto L_0x0e6e
        L_0x0e05:
            int r4 = r6.zzc()     // Catch:{ all -> 0x0bdf }
            if (r4 <= 0) goto L_0x0e6e
            long r4 = r3.zzp()     // Catch:{ all -> 0x0bdf }
            r8 = 0
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0e19
            r6.zzA(r4)     // Catch:{ all -> 0x0bdf }
            goto L_0x0e1c
        L_0x0e19:
            r6.zzB()     // Catch:{ all -> 0x0bdf }
        L_0x0e1c:
            long r8 = r3.zzn()     // Catch:{ all -> 0x0bdf }
            r10 = 0
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0e27
            goto L_0x0e28
        L_0x0e27:
            r4 = r8
        L_0x0e28:
            int r8 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r8 == 0) goto L_0x0e30
            r6.zzy(r4)     // Catch:{ all -> 0x0bdf }
            goto L_0x0e33
        L_0x0e30:
            r6.zzz()     // Catch:{ all -> 0x0bdf }
        L_0x0e33:
            int r4 = r6.zzc()     // Catch:{ all -> 0x0bdf }
            long r4 = (long) r4     // Catch:{ all -> 0x0bdf }
            r3.zzM(r4)     // Catch:{ all -> 0x0bdf }
            long r4 = r3.zzaF()     // Catch:{ all -> 0x0bdf }
            int r5 = (int) r4     // Catch:{ all -> 0x0bdf }
            r6.zzaJ(r5)     // Catch:{ all -> 0x0bdf }
            long r4 = r3.zzG()     // Catch:{ all -> 0x0bdf }
            int r5 = (int) r4     // Catch:{ all -> 0x0bdf }
            r6.zzZ(r5)     // Catch:{ all -> 0x0bdf }
            long r4 = r6.zzu()     // Catch:{ all -> 0x0bdf }
            r3.zzo(r4)     // Catch:{ all -> 0x0bdf }
            long r4 = r6.zzw()     // Catch:{ all -> 0x0bdf }
            r3.zzq(r4)     // Catch:{ all -> 0x0bdf }
            java.lang.String r4 = r3.zzaa()     // Catch:{ all -> 0x0bdf }
            if (r4 == 0) goto L_0x0e63
            r6.zzaa(r4)     // Catch:{ all -> 0x0bdf }
            goto L_0x0e66
        L_0x0e63:
            r6.zzab()     // Catch:{ all -> 0x0bdf }
        L_0x0e66:
            com.google.android.gms.measurement.internal.zzav r4 = r46.zzj()     // Catch:{ all -> 0x0bdf }
            r5 = 0
            r4.zzv(r3, r5, r5)     // Catch:{ all -> 0x0bdf }
        L_0x0e6e:
            int r3 = r6.zzc()     // Catch:{ all -> 0x0bdf }
            if (r3 <= 0) goto L_0x0ed6
            r3 = r46
            com.google.android.gms.measurement.internal.zzib r4 = r3.zzn     // Catch:{ all -> 0x0e9a }
            r4.zzaU()     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.measurement.internal.zzhs r4 = r46.zzh()     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.internal.measurement.zzid r5 = r1.zza     // Catch:{ all -> 0x0e9a }
            java.lang.String r5 = r5.zzA()     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.internal.measurement.zzgl r4 = r4.zzb(r5)     // Catch:{ all -> 0x0e9a }
            if (r4 == 0) goto L_0x0e9d
            boolean r5 = r4.zza()     // Catch:{ all -> 0x0e9a }
            if (r5 != 0) goto L_0x0e92
            goto L_0x0e9d
        L_0x0e92:
            long r4 = r4.zzb()     // Catch:{ all -> 0x0e9a }
            r6.zzal(r4)     // Catch:{ all -> 0x0e9a }
            goto L_0x0ec6
        L_0x0e9a:
            r0 = move-exception
            goto L_0x0107
        L_0x0e9d:
            com.google.android.gms.internal.measurement.zzid r4 = r1.zza     // Catch:{ all -> 0x0e9a }
            java.lang.String r4 = r4.zzP()     // Catch:{ all -> 0x0e9a }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0e9a }
            if (r4 == 0) goto L_0x0eaf
            r4 = -1
            r6.zzal(r4)     // Catch:{ all -> 0x0e9a }
            goto L_0x0ec6
        L_0x0eaf:
            com.google.android.gms.measurement.internal.zzgt r4 = r46.zzaV()     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zze()     // Catch:{ all -> 0x0e9a }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzid r8 = r1.zza     // Catch:{ all -> 0x0e9a }
            java.lang.String r8 = r8.zzA()     // Catch:{ all -> 0x0e9a }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r8)     // Catch:{ all -> 0x0e9a }
            r4.zzb(r5, r8)     // Catch:{ all -> 0x0e9a }
        L_0x0ec6:
            com.google.android.gms.measurement.internal.zzav r4 = r46.zzj()     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.internal.measurement.zzme r5 = r6.zzbc()     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.internal.measurement.zzid r5 = (com.google.android.gms.internal.measurement.zzid) r5     // Catch:{ all -> 0x0e9a }
            r6 = r21
            r4.zzz(r5, r6)     // Catch:{ all -> 0x0e9a }
            goto L_0x0ed8
        L_0x0ed6:
            r3 = r46
        L_0x0ed8:
            com.google.android.gms.measurement.internal.zzav r4 = r46.zzj()     // Catch:{ all -> 0x0e9a }
            java.util.List r1 = r1.zzb     // Catch:{ all -> 0x0e9a }
            r4.zzS(r1)     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.measurement.internal.zzav r1 = r46.zzj()     // Catch:{ all -> 0x0e9a }
            r1.zzT(r2)     // Catch:{ all -> 0x0e9a }
            com.google.android.gms.measurement.internal.zzav r1 = r46.zzj()     // Catch:{ all -> 0x0e9a }
            r1.zzc()     // Catch:{ all -> 0x0e9a }
            goto L_0x0ef8
        L_0x0ef0:
            com.google.android.gms.measurement.internal.zzav r1 = r46.zzj()     // Catch:{ all -> 0x0e9a }
            r1.zzc()     // Catch:{ all -> 0x0e9a }
            r7 = 0
        L_0x0ef8:
            com.google.android.gms.measurement.internal.zzav r1 = r46.zzj()
            r1.zzd()
            return r7
        L_0x0f00:
            com.google.android.gms.measurement.internal.zzav r2 = r46.zzj()
            r2.zzd()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzaF(java.lang.String, long):boolean");
    }

    @VisibleForTesting
    private final void zzaG(zzic zzic, long j, boolean z) {
        String str;
        zzpm zzpm;
        String str2;
        Object obj;
        if (true != z) {
            str = "_lte";
        } else {
            str = "_se";
        }
        zzpm zzm2 = zzj().zzm(zzic.zzK(), str);
        if (zzm2 == null || (obj = zzm2.zze) == null) {
            zzpm = new zzpm(zzic.zzK(), "auto", str, zzaZ().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzpm = new zzpm(zzic.zzK(), "auto", str, zzaZ().currentTimeMillis(), Long.valueOf(((Long) obj).longValue() + j));
        }
        zzit zzm3 = zziu.zzm();
        zzm3.zzb(str);
        zzm3.zza(zzaZ().currentTimeMillis());
        Object obj2 = zzpm.zze;
        zzm3.zze(((Long) obj2).longValue());
        zziu zziu = (zziu) zzm3.zzbc();
        int zzx2 = zzpj.zzx(zzic, str);
        if (zzx2 >= 0) {
            zzic.zzn(zzx2, zziu);
        } else {
            zzic.zzo(zziu);
        }
        if (j > 0) {
            zzj().zzl(zzpm);
            if (true != z) {
                str2 = "lifetime";
            } else {
                str2 = "session-scoped";
            }
            zzaV().zzk().zzc("Updated engagement user property. scope, value", str2, obj2);
        }
    }

    private final boolean zzaH(zzhr zzhr, zzhr zzhr2) {
        String str;
        Preconditions.checkArgument("_e".equals(zzhr.zzk()));
        zzp();
        zzhw zzF2 = zzpj.zzF((zzhs) zzhr.zzbc(), "_sc");
        String str2 = null;
        if (zzF2 == null) {
            str = null;
        } else {
            str = zzF2.zzd();
        }
        zzp();
        zzhw zzF3 = zzpj.zzF((zzhs) zzhr2.zzbc(), "_pc");
        if (zzF3 != null) {
            str2 = zzF3.zzd();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        Preconditions.checkArgument("_e".equals(zzhr.zzk()));
        zzp();
        zzhw zzF4 = zzpj.zzF((zzhs) zzhr.zzbc(), "_et");
        if (zzF4 == null || !zzF4.zze() || zzF4.zzf() <= 0) {
            return true;
        }
        long zzf2 = zzF4.zzf();
        zzp();
        zzhw zzF5 = zzpj.zzF((zzhs) zzhr2.zzbc(), "_et");
        if (zzF5 != null && zzF5.zzf() > 0) {
            zzf2 += zzF5.zzf();
        }
        zzp();
        zzpj.zzC(zzhr2, "_et", Long.valueOf(zzf2));
        zzp();
        zzpj.zzC(zzhr, "_fr", 1L);
        return true;
    }

    private final boolean zzaI() {
        zzaW().zzg();
        zzu();
        if (zzj().zzP() || !TextUtils.isEmpty(zzj().zzF())) {
            return true;
        }
        return false;
    }

    private static String zzaJ(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (!((List) entry.getValue()).isEmpty()) {
                    return (String) ((List) entry.getValue()).get(0);
                }
                return null;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01aa  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzaK() {
        /*
            r20 = this;
            r0 = r20
            com.google.android.gms.measurement.internal.zzhy r1 = r20.zzaW()
            r1.zzg()
            r20.zzu()
            long r1 = r0.zza
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x004d
            com.google.android.gms.common.util.Clock r1 = r20.zzaZ()
            long r1 = r1.elapsedRealtime()
            long r5 = r0.zza
            long r1 = r1 - r5
            long r1 = java.lang.Math.abs(r1)
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzgt r1 = r20.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzha r1 = r20.zzk()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzoj r1 = r20.zzl()
            r1.zzd()
            return
        L_0x004b:
            r0.zza = r3
        L_0x004d:
            com.google.android.gms.measurement.internal.zzib r1 = r0.zzn
            boolean r1 = r1.zzH()
            if (r1 == 0) goto L_0x024b
            boolean r1 = r20.zzaI()
            if (r1 != 0) goto L_0x005d
            goto L_0x024b
        L_0x005d:
            com.google.android.gms.common.util.Clock r1 = r20.zzaZ()
            long r1 = r1.currentTimeMillis()
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzO
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzav r5 = r20.zzj()
            boolean r5 = r5.zzR()
            r10 = 1
            if (r5 != 0) goto L_0x0090
            com.google.android.gms.measurement.internal.zzav r5 = r20.zzj()
            boolean r5 = r5.zzG()
            if (r5 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r10 = 0
        L_0x0090:
            if (r10 == 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzal r5 = r20.zzd()
            java.lang.String r5 = r5.zzA()
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x00bc
            java.lang.String r11 = ".none."
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x00bc
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzJ
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e3
        L_0x00bc:
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzI
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
            goto L_0x00e3
        L_0x00d0:
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzH
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r11 = r5.longValue()
            long r11 = java.lang.Math.max(r3, r11)
        L_0x00e3:
            com.google.android.gms.measurement.internal.zznm r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzhd r5 = r5.zzd
            long r13 = r5.zza()
            com.google.android.gms.measurement.internal.zznm r5 = r0.zzk
            com.google.android.gms.measurement.internal.zzhd r5 = r5.zze
            long r15 = r5.zza()
            com.google.android.gms.measurement.internal.zzav r5 = r20.zzj()
            r17 = r10
            long r9 = r5.zzM()
            com.google.android.gms.measurement.internal.zzav r5 = r20.zzj()
            r18 = r7
            long r6 = r5.zzO()
            long r5 = java.lang.Math.max(r9, r6)
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0112
        L_0x010f:
            r9 = r3
            goto L_0x018a
        L_0x0112:
            long r5 = r5 - r1
            long r5 = java.lang.Math.abs(r5)
            long r5 = r1 - r5
            long r13 = r13 - r1
            long r7 = java.lang.Math.abs(r13)
            long r7 = r1 - r7
            long r15 = r15 - r1
            long r9 = java.lang.Math.abs(r15)
            long r1 = r1 - r9
            long r9 = r5 + r18
            long r7 = java.lang.Math.max(r7, r1)
            if (r17 == 0) goto L_0x0137
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x0137
            long r9 = java.lang.Math.min(r5, r7)
            long r9 = r9 + r11
        L_0x0137:
            com.google.android.gms.measurement.internal.zzpj r13 = r20.zzp()
            boolean r13 = r13.zzs(r7, r11)
            if (r13 != 0) goto L_0x0143
            long r9 = r7 + r11
        L_0x0143:
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x018a
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x018a
            r5 = 0
        L_0x014c:
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r6 = com.google.android.gms.measurement.internal.zzfx.zzQ
            r7 = 0
            java.lang.Object r6 = r6.zzb(r7)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r8 = 0
            int r6 = java.lang.Math.max(r8, r6)
            r11 = 20
            int r6 = java.lang.Math.min(r11, r6)
            if (r5 >= r6) goto L_0x010f
            r11 = 1
            long r11 = r11 << r5
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r6 = com.google.android.gms.measurement.internal.zzfx.zzP
            java.lang.Object r6 = r6.zzb(r7)
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            long r6 = java.lang.Math.max(r3, r6)
            long r6 = r6 * r11
            long r9 = r9 + r6
            int r6 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x0187
            goto L_0x018a
        L_0x0187:
            int r5 = r5 + 1
            goto L_0x014c
        L_0x018a:
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01aa
            com.google.android.gms.measurement.internal.zzgt r1 = r20.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzha r1 = r20.zzk()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzoj r1 = r20.zzl()
            r1.zzd()
            return
        L_0x01aa:
            com.google.android.gms.measurement.internal.zzgy r1 = r20.zzi()
            boolean r1 = r1.zzb()
            if (r1 == 0) goto L_0x022f
            com.google.android.gms.measurement.internal.zznm r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzhd r1 = r1.zzc
            long r1 = r1.zza()
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzF
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzpj r7 = r20.zzp()
            boolean r7 = r7.zzs(r1, r5)
            if (r7 != 0) goto L_0x01df
            long r1 = r1 + r5
            long r9 = java.lang.Math.max(r9, r1)
        L_0x01df:
            com.google.android.gms.measurement.internal.zzha r1 = r20.zzk()
            r1.zzb()
            com.google.android.gms.common.util.Clock r1 = r20.zzaZ()
            long r1 = r1.currentTimeMillis()
            long r9 = r9 - r1
            int r1 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0216
            r20.zzd()
            com.google.android.gms.measurement.internal.zzfw r1 = com.google.android.gms.measurement.internal.zzfx.zzK
            r2 = 0
            java.lang.Object r1 = r1.zzb(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r9 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zznm r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzhd r1 = r1.zzd
            com.google.android.gms.common.util.Clock r2 = r20.zzaZ()
            long r2 = r2.currentTimeMillis()
            r1.zzb(r2)
        L_0x0216:
            com.google.android.gms.measurement.internal.zzgt r1 = r20.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zzb(r3, r2)
            com.google.android.gms.measurement.internal.zzoj r1 = r20.zzl()
            r1.zzc(r9)
            return
        L_0x022f:
            com.google.android.gms.measurement.internal.zzgt r1 = r20.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzha r1 = r20.zzk()
            r1.zza()
            com.google.android.gms.measurement.internal.zzoj r1 = r20.zzl()
            r1.zzd()
            return
        L_0x024b:
            com.google.android.gms.measurement.internal.zzgt r1 = r20.zzaV()
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzha r1 = r20.zzk()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzoj r1 = r20.zzl()
            r1.zzd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzaK():void");
    }

    @WorkerThread
    private final void zzaL() {
        zzaW().zzg();
        if (this.zzu || this.zzv || this.zzw) {
            zzaV().zzk().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzu), Boolean.valueOf(this.zzv), Boolean.valueOf(this.zzw));
            return;
        }
        zzaV().zzk().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzq;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) Preconditions.checkNotNull(this.zzq)).clear();
        }
    }

    @WorkerThread
    private final Boolean zzaM(zzh zzh2) {
        try {
            if (zzh2.zzt() != -2147483648L) {
                if (zzh2.zzt() == ((long) Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzh2.zzc(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = Wrappers.packageManager(this.zzn.zzaY()).getPackageInfo(zzh2.zzc(), 0).versionName;
                String zzr2 = zzh2.zzr();
                if (zzr2 != null && zzr2.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    private final zzr zzaN(String str) {
        String str2 = str;
        zzh zzu2 = zzj().zzu(str2);
        if (zzu2 == null || TextUtils.isEmpty(zzu2.zzr())) {
            zzaV().zzj().zzb("No app data available; dropping", str2);
            return null;
        }
        Boolean zzaM = zzaM(zzu2);
        if (zzaM == null || zzaM.booleanValue()) {
            return new zzr(str, zzu2.zzf(), zzu2.zzr(), zzu2.zzt(), zzu2.zzv(), zzu2.zzx(), zzu2.zzz(), (String) null, zzu2.zzD(), false, zzu2.zzl(), 0, 0, zzu2.zzac(), false, zzu2.zzae(), zzu2.zzB(), zzu2.zzag(), zzB(str).zzl(), "", (String) null, zzu2.zzai(), zzu2.zzak(), zzB(str).zzb(), zzx(str).zze(), zzu2.zzao(), zzu2.zzaw(), zzu2.zzay(), zzu2.zzaH(), 0, zzu2.zzaL());
        }
        zzaV().zzb().zzb("App version does not match; dropping. appId", zzgt.zzl(str));
        return null;
    }

    @WorkerThread
    private final boolean zzaO(String str, String str2) {
        zzbc zzf2 = zzj().zzf(str, str2);
        if (zzf2 == null || zzf2.zzc < 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static void zzaP(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT < 34) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, (String) null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
        }
    }

    private static final boolean zzaQ(zzr zzr2) {
        if (!TextUtils.isEmpty(zzr2.zzb)) {
            return true;
        }
        return false;
    }

    private static final void zzaR(zzic zzic) {
        zzic.zzv(LocationRequestCompat.PASSIVE_INTERVAL);
        zzic.zzx(Long.MIN_VALUE);
        for (int i = 0; i < zzic.zzc(); i++) {
            zzhs zzd2 = zzic.zzd(i);
            if (zzd2.zzf() < zzic.zzu()) {
                zzic.zzv(zzd2.zzf());
            }
            if (zzd2.zzf() > zzic.zzw()) {
                zzic.zzx(zzd2.zzf());
            }
        }
    }

    private static final zzor zzaS(zzor zzor) {
        if (zzor == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (zzor.zzax()) {
            return zzor;
        } else {
            throw new IllegalStateException("Component not initialized: ".concat(String.valueOf(zzor.getClass())));
        }
    }

    private static final Boolean zzaT(zzr zzr2) {
        Boolean bool = zzr2.zzp;
        String str = zzr2.zzC;
        if (!TextUtils.isEmpty(str)) {
            zzjh zza2 = zze.zzc(str).zza();
            zzjh zzjh = zzjh.UNINITIALIZED;
            int ordinal = zza2.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                return null;
            }
            if (ordinal == 2) {
                return Boolean.TRUE;
            }
            if (ordinal == 3) {
                return Boolean.FALSE;
            }
        }
        return bool;
    }

    @VisibleForTesting
    public static final void zzaz(zzhr zzhr, int i, String str) {
        List zza2 = zzhr.zza();
        int i2 = 0;
        while (i2 < zza2.size()) {
            if (!"_err".equals(((zzhw) zza2.get(i2)).zzb())) {
                i2++;
            } else {
                return;
            }
        }
        zzhv zzn2 = zzhw.zzn();
        zzn2.zzb("_err");
        zzn2.zzf((long) i);
        zzhv zzn3 = zzhw.zzn();
        zzn3.zzb("_ev");
        zzn3.zzd(str);
        zzhr.zzf((zzhw) zzn2.zzbc());
        zzhr.zzf((zzhw) zzn3.zzbc());
    }

    @WorkerThread
    public final void zzA(String str, zzjk zzjk) {
        zzaW().zzg();
        zzu();
        this.zzC.put(str, zzjk);
        zzj().zzab(str, zzjk);
    }

    @WorkerThread
    public final zzjk zzB(String str) {
        zzjk zzjk = zzjk.zza;
        zzaW().zzg();
        zzu();
        zzjk zzjk2 = (zzjk) this.zzC.get(str);
        if (zzjk2 == null) {
            zzjk2 = zzj().zzZ(str);
            if (zzjk2 == null) {
                zzjk2 = zzjk.zza;
            }
            zzA(str, zzjk2);
        }
        return zzjk2;
    }

    public final long zzC() {
        long currentTimeMillis = zzaZ().currentTimeMillis();
        zznm zznm = this.zzk;
        zznm.zzay();
        zznm.zzg();
        zzhd zzhd = zznm.zzf;
        long zza2 = zzhd.zza();
        if (zza2 == 0) {
            zza2 = ((long) zznm.zzu.zzk().zzf().nextInt(86400000)) + 1;
            zzhd.zzb(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    @WorkerThread
    public final void zzD(zzbg zzbg, String str) {
        zzbg zzbg2 = zzbg;
        String str2 = str;
        zzh zzu2 = zzj().zzu(str2);
        if (zzu2 == null || TextUtils.isEmpty(zzu2.zzr())) {
            zzaV().zzj().zzb("No app data available; dropping event", str2);
            return;
        }
        Boolean zzaM = zzaM(zzu2);
        if (zzaM == null) {
            if (!"_ui".equals(zzbg2.zza)) {
                zzaV().zze().zzb("Could not find package. appId", zzgt.zzl(str));
            }
        } else if (!zzaM.booleanValue()) {
            zzaV().zzb().zzb("App version does not match; dropping event. appId", zzgt.zzl(str));
            return;
        }
        zzr zzr2 = r2;
        zzr zzr3 = new zzr(str, zzu2.zzf(), zzu2.zzr(), zzu2.zzt(), zzu2.zzv(), zzu2.zzx(), zzu2.zzz(), (String) null, zzu2.zzD(), false, zzu2.zzl(), 0, 0, zzu2.zzac(), false, zzu2.zzae(), zzu2.zzB(), zzu2.zzag(), zzB(str2).zzl(), "", (String) null, zzu2.zzai(), zzu2.zzak(), zzB(str2).zzb(), zzx(str2).zze(), zzu2.zzao(), zzu2.zzaw(), zzu2.zzay(), zzu2.zzaH(), 0, zzu2.zzaL());
        zzE(zzbg2, zzr2);
    }

    @WorkerThread
    public final void zzE(zzbg zzbg, zzr zzr2) {
        String str = zzr2.zza;
        Preconditions.checkNotEmpty(str);
        zzgu zza2 = zzgu.zza(zzbg);
        zzt().zzI(zza2.zzd, zzj().zzW(str));
        zzt().zzG(zza2, zzd().zzd(str));
        zzbg zzb2 = zza2.zzb();
        if (!zzd().zzp((String) null, zzfx.zzbg) && Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(zzb2.zza)) {
            zzbe zzbe = zzb2.zzb;
            if ("referrer API v2".equals(zzbe.zzd("_cis"))) {
                String zzd2 = zzbe.zzd("gclid");
                if (!TextUtils.isEmpty(zzd2)) {
                    zzab(new zzpk("_lgclid", zzb2.zzd, zzd2, "auto"), zzr2);
                }
            }
        }
        zzF(zzb2, zzr2);
    }

    @WorkerThread
    public final void zzF(zzbg zzbg, zzr zzr2) {
        zzlt zzlt;
        zzbg zzbg2;
        List<zzah> list;
        List<zzah> list2;
        List<zzah> list3;
        String str;
        zzr zzr3 = zzr2;
        Preconditions.checkNotNull(zzr2);
        String str2 = zzr3.zza;
        Preconditions.checkNotEmpty(str2);
        zzaW().zzg();
        zzu();
        long j = zzbg.zzd;
        zzgu zza2 = zzgu.zza(zzbg);
        zzaW().zzg();
        if (this.zzG == null || (str = this.zzH) == null || !str.equals(str2)) {
            zzlt = null;
        } else {
            zzlt = this.zzG;
        }
        zzpo.zzav(zzlt, zza2.zzd, false);
        zzbg zzb2 = zza2.zzb();
        zzp();
        if (zzpj.zzD(zzb2, zzr3)) {
            if (!zzr3.zzh) {
                zzan(zzr3);
                return;
            }
            List list4 = zzr3.zzr;
            if (list4 != null) {
                String str3 = zzb2.zza;
                if (list4.contains(str3)) {
                    Bundle zzf2 = zzb2.zzb.zzf();
                    zzf2.putLong("ga_safelisted", 1);
                    zzbg2 = new zzbg(str3, new zzbe(zzf2), zzb2.zzc, zzb2.zzd);
                } else {
                    zzaV().zzj().zzd("Dropping non-safelisted event. appId, event name, origin", str2, zzb2.zza, zzb2.zzc);
                    return;
                }
            } else {
                zzbg2 = zzb2;
            }
            zzj().zzb();
            try {
                String str4 = zzbg2.zza;
                if ("_s".equals(str4) && !zzj().zzQ(str2, "_s") && zzbg2.zzb.zzb("_sid").longValue() != 0) {
                    if (!zzj().zzQ(str2, "_f")) {
                        if (!zzj().zzQ(str2, "_v")) {
                            zzj().zzY(str2, Long.valueOf(zzaZ().currentTimeMillis() - 15000), "_sid", zzG(str2, zzbg2));
                        }
                    }
                    zzj().zzY(str2, (Long) null, "_sid", zzG(str2, zzbg2));
                }
                zzav zzj2 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj2.zzg();
                zzj2.zzay();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzj2.zzu.zzaV().zze().zzc("Invalid time querying timed out conditional properties", zzgt.zzl(str2), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzj2.zzt("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j)});
                }
                for (zzah zzah : list) {
                    if (zzah != null) {
                        zzaV().zzk().zzd("User property timed out", zzah.zza, this.zzn.zzl().zzc(zzah.zzc.zzb), zzah.zzc.zza());
                        zzbg zzbg3 = zzah.zzg;
                        if (zzbg3 != null) {
                            zzH(new zzbg(zzbg3, j), zzr3);
                        }
                        zzj().zzr(str2, zzah.zzc.zzb);
                    }
                }
                zzav zzj3 = zzj();
                Preconditions.checkNotEmpty(str2);
                zzj3.zzg();
                zzj3.zzay();
                if (i < 0) {
                    zzj3.zzu.zzaV().zze().zzc("Invalid time querying expired conditional properties", zzgt.zzl(str2), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzj3.zzt("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzah zzah2 : list2) {
                    if (zzah2 != null) {
                        zzaV().zzk().zzd("User property expired", zzah2.zza, this.zzn.zzl().zzc(zzah2.zzc.zzb), zzah2.zzc.zza());
                        zzj().zzk(str2, zzah2.zzc.zzb);
                        zzbg zzbg4 = zzah2.zzk;
                        if (zzbg4 != null) {
                            arrayList.add(zzbg4);
                        }
                        zzj().zzr(str2, zzah2.zzc.zzb);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzH(new zzbg((zzbg) it.next(), j), zzr3);
                }
                zzav zzj4 = zzj();
                Preconditions.checkNotEmpty(str2);
                Preconditions.checkNotEmpty(str4);
                zzj4.zzg();
                zzj4.zzay();
                if (i < 0) {
                    zzib zzib = zzj4.zzu;
                    zzib.zzaV().zze().zzd("Invalid time querying triggered conditional properties", zzgt.zzl(str2), zzib.zzl().zza(str4), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzj4.zzt("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str4, String.valueOf(j)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (zzah zzah3 : list3) {
                    if (zzah3 != null) {
                        zzpk zzpk = zzah3.zzc;
                        zzpm zzpm = new zzpm((String) Preconditions.checkNotNull(zzah3.zza), zzah3.zzb, zzpk.zzb, j, Preconditions.checkNotNull(zzpk.zza()));
                        if (zzj().zzl(zzpm)) {
                            zzaV().zzk().zzd("User property triggered", zzah3.zza, this.zzn.zzl().zzc(zzpm.zzc), zzpm.zze);
                        } else {
                            zzaV().zzb().zzd("Too many active user properties, ignoring", zzgt.zzl(zzah3.zza), this.zzn.zzl().zzc(zzpm.zzc), zzpm.zze);
                        }
                        zzbg zzbg5 = zzah3.zzi;
                        if (zzbg5 != null) {
                            arrayList2.add(zzbg5);
                        }
                        zzah3.zzc = new zzpk(zzpm);
                        zzah3.zze = true;
                        zzj().zzp(zzah3);
                    }
                }
                zzH(zzbg2, zzr3);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    zzH(new zzbg((zzbg) it2.next(), j), zzr3);
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    public final Bundle zzG(String str, zzbg zzbg) {
        Bundle bundle = new Bundle();
        bundle.putLong("_sid", zzbg.zzb.zzb("_sid").longValue());
        zzpm zzm2 = zzj().zzm(str, "_sno");
        if (zzm2 != null) {
            Object obj = zzm2.zze;
            if (obj instanceof Long) {
                bundle.putLong("_sno", ((Long) obj).longValue());
            }
        }
        return bundle;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(76:108|(2:110|(3:112|(1:114)|115))|116|(2:118|(3:120|(1:122)|123))|124|125|(2:127|128)(1:129)|130|(2:134|(1:136))|137|(2:143|(2:145|146))|147|148|149|150|151|152|153|154|161|(1:163)|164|(2:166|(2:172|173)(1:169))(1:174)|175|(1:177)|178|(1:180)|181|(1:183)|184|(1:186)|187|(1:189)|190|(1:192)|193|(1:238)(6:197|(1:201)|202|(1:204)(1:205)|206|(1:208)(15:209|(1:211)(1:212)|213|(1:215)(1:216)|217|(1:219)(1:220)|221|(1:223)(1:224)|225|(1:227)(1:228)|229|(1:231)(1:232)|233|(1:235)(1:236)|237))|239|(1:241)|242|(1:244)(1:245)|(35:250|(2:251|(3:253|(3:255|256|(2:258|(2:381|260)(1:384))(1:383))(1:382)|379)(1:380))|265|(1:267)|(1:269)|270|(1:272)|273|(2:277|(4:279|(1:281)|282|(29:290|(1:292)(1:293)|294|(1:296)|297|299|(2:301|(1:303))|304|(3:306|(1:308)|309)(1:310)|311|(1:315)|316|(1:318)|319|(4:322|(2:328|386)|329|320)|330|331|332|333|334|335|(2:336|(2:338|(1:390))(3:391|341|(1:346)(1:345)))|347|348|349|(1:351)(3:354|355|356)|367|368|369)))|298|299|(0)|304|(0)(0)|311|313|315|316|(0)|319|(1:320)|330|331|332|333|334|335|(3:336|(0)(0)|339)|347|348|349|(0)(0)|367|368|369)|249|(0)|270|(0)|273|275|277|(0)|298|299|(0)|304|(0)(0)|311|313|315|316|(0)|319|(1:320)|330|331|332|333|334|335|(3:336|(0)(0)|339)|347|348|349|(0)(0)|367|368|369) */
    /* JADX WARNING: Code restructure failed: missing block: B:340:0x0a77, code lost:
        r31 = 1;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:147:0x04d2 */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x037e A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03a5 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0529 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x056a A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x05d9 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x061d A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0628 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0633 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x063e A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x064a A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x065b A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0694 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x072d A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0737 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x075d A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0762 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0791 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x07ee A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x07f2 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x0802 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0839 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x08f3 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x090a A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x0969 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0993 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x09af A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x0a6d A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0b14 A[Catch:{ SQLiteException -> 0x0b28 }] */
    /* JADX WARNING: Removed duplicated region for block: B:354:0x0b2b  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x07e8 A[EDGE_INSN: B:380:0x07e8->B:265:0x07e8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0a7a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01a7 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0206 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0218 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02d0 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0319 A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x031c A[Catch:{ SQLiteException -> 0x0298, all -> 0x0178 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzH(com.google.android.gms.measurement.internal.zzbg r50, com.google.android.gms.measurement.internal.zzr r51) {
        /*
            r49 = this;
            r1 = r49
            r2 = r51
            java.lang.String r3 = "metadata_fingerprint"
            java.lang.String r4 = "app_id"
            java.lang.String r5 = "_fx"
            java.lang.String r6 = "raw_events"
            java.lang.String r7 = "_sno"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r51)
            java.lang.String r15 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)
            long r25 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.zzhy r8 = r49.zzaW()
            r8.zzg()
            r49.zzu()
            r49.zzp()
            boolean r8 = com.google.android.gms.measurement.internal.zzpj.zzD(r50, r51)
            if (r8 != 0) goto L_0x002f
            goto L_0x00d4
        L_0x002f:
            boolean r8 = r2.zzh
            if (r8 != 0) goto L_0x0037
            r1.zzan(r2)
            return
        L_0x0037:
            com.google.android.gms.measurement.internal.zzhs r8 = r49.zzh()
            r9 = r50
            java.lang.String r13 = r9.zza
            boolean r8 = r8.zzj(r15, r13)
            java.lang.String r14 = "_err"
            r12 = 0
            if (r8 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.zzgt r2 = r49.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zze()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgt.zzl(r15)
            com.google.android.gms.measurement.internal.zzib r4 = r1.zzn
            com.google.android.gms.measurement.internal.zzgm r4 = r4.zzl()
            java.lang.String r4 = r4.zza(r13)
            java.lang.String r5 = "Dropping blocked event. appId"
            r2.zzc(r5, r3, r4)
            com.google.android.gms.measurement.internal.zzhs r2 = r49.zzh()
            boolean r2 = r2.zzn(r15)
            if (r2 != 0) goto L_0x008e
            com.google.android.gms.measurement.internal.zzhs r2 = r49.zzh()
            boolean r2 = r2.zzo(r15)
            if (r2 == 0) goto L_0x0078
            goto L_0x008e
        L_0x0078:
            boolean r2 = r14.equals(r13)
            if (r2 != 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()
            com.google.android.gms.measurement.internal.zzpn r9 = r1.zzK
            java.lang.String r12 = "_ev"
            r14 = 0
            r11 = 11
            r10 = r15
            r8.zzN(r9, r10, r11, r12, r13, r14)
            return
        L_0x008e:
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()
            com.google.android.gms.measurement.internal.zzh r2 = r2.zzu(r15)
            if (r2 == 0) goto L_0x00d4
            long r3 = r2.zzJ()
            long r5 = r2.zzH()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.common.util.Clock r5 = r49.zzaZ()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            r49.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzN
            java.lang.Object r5 = r5.zzb(r12)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d4
            com.google.android.gms.measurement.internal.zzgt r3 = r49.zzaV()
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzj()
            java.lang.String r4 = "Fetching config for blocked app"
            r3.zza(r4)
            r1.zzV(r2)
        L_0x00d4:
            return
        L_0x00d5:
            com.google.android.gms.measurement.internal.zzgu r8 = com.google.android.gms.measurement.internal.zzgu.zza(r50)
            com.google.android.gms.measurement.internal.zzpo r9 = r49.zzt()
            com.google.android.gms.measurement.internal.zzal r10 = r49.zzd()
            int r10 = r10.zzd(r15)
            r9.zzG(r8, r10)
            com.google.android.gms.measurement.internal.zzal r9 = r49.zzd()
            com.google.android.gms.measurement.internal.zzfw r10 = com.google.android.gms.measurement.internal.zzfx.zzag
            r11 = 10
            r13 = 35
            int r9 = r9.zzn(r15, r10, r11, r13)
            android.os.Bundle r10 = r8.zzd
            java.util.TreeSet r11 = new java.util.TreeSet
            java.util.Set r13 = r10.keySet()
            r11.<init>(r13)
            java.util.Iterator r11 = r11.iterator()
        L_0x0105:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0126
            java.lang.Object r13 = r11.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r12 = "items"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzpo r12 = r49.zzt()
            android.os.Parcelable[] r13 = r10.getParcelableArray(r13)
            r12.zzH(r13, r9)
        L_0x0124:
            r12 = 0
            goto L_0x0105
        L_0x0126:
            com.google.android.gms.measurement.internal.zzbg r12 = r8.zzb()
            com.google.android.gms.measurement.internal.zzgt r8 = r49.zzaV()
            java.lang.String r8 = r8.zzn()
            r9 = 2
            boolean r8 = android.util.Log.isLoggable(r8, r9)
            if (r8 == 0) goto L_0x0150
            com.google.android.gms.measurement.internal.zzgt r8 = r49.zzaV()
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzk()
            com.google.android.gms.measurement.internal.zzib r9 = r1.zzn
            com.google.android.gms.measurement.internal.zzgm r9 = r9.zzl()
            java.lang.String r9 = r9.zzd(r12)
            java.lang.String r10 = "Logging event"
            r8.zzb(r10, r9)
        L_0x0150:
            com.google.android.gms.measurement.internal.zzav r8 = r49.zzj()
            r8.zzb()
            r1.zzan(r2)     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = "ecommerce_purchase"
            java.lang.String r9 = r12.zza     // Catch:{ all -> 0x0178 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "refund"
            if (r8 != 0) goto L_0x0174
            java.lang.String r8 = "purchase"
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x0174
            boolean r8 = r10.equals(r9)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x0176
        L_0x0174:
            r8 = 1
            goto L_0x017c
        L_0x0176:
            r8 = 0
            goto L_0x017c
        L_0x0178:
            r0 = move-exception
            r2 = r0
            goto L_0x0ba9
        L_0x017c:
            java.lang.String r11 = "_iap"
            boolean r11 = r11.equals(r9)     // Catch:{ all -> 0x0178 }
            r27 = r3
            java.lang.String r3 = "value"
            if (r11 != 0) goto L_0x0199
            if (r8 == 0) goto L_0x018c
            r8 = 1
            goto L_0x0199
        L_0x018c:
            r21 = r3
            r28 = r4
            r29 = r5
            r30 = r6
            r6 = r12
            r3 = r14
        L_0x0196:
            r5 = 0
            goto L_0x0308
        L_0x0199:
            java.lang.String r11 = "_ltv_"
            com.google.android.gms.measurement.internal.zzbe r13 = r12.zzb     // Catch:{ all -> 0x0178 }
            r18 = r14
            java.lang.String r14 = "currency"
            java.lang.String r14 = r13.zzd(r14)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x0206
            java.lang.Double r8 = r13.zzc(r3)     // Catch:{ all -> 0x0178 }
            double r19 = r8.doubleValue()     // Catch:{ all -> 0x0178 }
            r21 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r19 = r19 * r21
            r23 = 0
            int r8 = (r19 > r23 ? 1 : (r19 == r23 ? 0 : -1))
            if (r8 != 0) goto L_0x01cc
            java.lang.Long r8 = r13.zzb(r3)     // Catch:{ all -> 0x0178 }
            r28 = r4
            r29 = r5
            long r4 = r8.longValue()     // Catch:{ all -> 0x0178 }
            double r4 = (double) r4     // Catch:{ all -> 0x0178 }
            double r19 = r4 * r21
            goto L_0x01d0
        L_0x01cc:
            r28 = r4
            r29 = r5
        L_0x01d0:
            r4 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 > 0) goto L_0x01e8
            r4 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x01e8
            long r4 = java.lang.Math.round(r19)     // Catch:{ all -> 0x0178 }
            boolean r8 = r10.equals(r9)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x0212
            long r4 = -r4
            goto L_0x0212
        L_0x01e8:
            com.google.android.gms.measurement.internal.zzgt r2 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zze()     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = "Data lost. Currency value is too big. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r15)     // Catch:{ all -> 0x0178 }
            java.lang.Double r5 = java.lang.Double.valueOf(r19)     // Catch:{ all -> 0x0178 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()     // Catch:{ all -> 0x0178 }
            r2.zzc()     // Catch:{ all -> 0x0178 }
            goto L_0x05b5
        L_0x0206:
            r28 = r4
            r29 = r5
            java.lang.Long r4 = r13.zzb(r3)     // Catch:{ all -> 0x0178 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x0178 }
        L_0x0212:
            boolean r8 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x02ff
            java.util.Locale r8 = java.util.Locale.US     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = r14.toUpperCase(r8)     // Catch:{ all -> 0x0178 }
            java.lang.String r9 = "[A-Z]{3}"
            boolean r9 = r8.matches(r9)     // Catch:{ all -> 0x0178 }
            if (r9 == 0) goto L_0x02ff
            java.lang.String r11 = r11.concat(r8)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzav r8 = r49.zzj()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpm r8 = r8.zzm(r15, r11)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x023a
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0178 }
            boolean r9 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0178 }
            if (r9 != 0) goto L_0x0243
        L_0x023a:
            r21 = r3
            r30 = r6
            r6 = r12
            r3 = r18
            r14 = 0
            goto L_0x026d
        L_0x0243:
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x0178 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpm r19 = new com.google.android.gms.measurement.internal.zzpm     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r12.zzc     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.util.Clock r13 = r49.zzaZ()     // Catch:{ all -> 0x0178 }
            long r13 = r13.currentTimeMillis()     // Catch:{ all -> 0x0178 }
            long r8 = r8 + r4
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0178 }
            r8 = r19
            r9 = r15
            r5 = 0
            r30 = r6
            r6 = r12
            r12 = r13
            r21 = r3
            r3 = r18
            r14 = r4
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0178 }
        L_0x026a:
            r4 = r19
            goto L_0x02c6
        L_0x026d:
            com.google.android.gms.measurement.internal.zzav r8 = r49.zzj()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzal r9 = r49.zzd()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r10 = com.google.android.gms.measurement.internal.zzfx.zzT     // Catch:{ all -> 0x0178 }
            int r9 = r9.zzm(r15, r10)     // Catch:{ all -> 0x0178 }
            int r9 = r9 + -1
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0178 }
            r8.zzg()     // Catch:{ all -> 0x0178 }
            r8.zzay()     // Catch:{ all -> 0x0178 }
            android.database.sqlite.SQLiteDatabase r10 = r8.zze()     // Catch:{ SQLiteException -> 0x0298 }
            java.lang.String r12 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '!_ltv!_%' escape '!'order by set_timestamp desc limit ?,10);"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0298 }
            java.lang.String[] r9 = new java.lang.String[]{r15, r15, r9}     // Catch:{ SQLiteException -> 0x0298 }
            r10.execSQL(r12, r9)     // Catch:{ SQLiteException -> 0x0298 }
            goto L_0x02ad
        L_0x0298:
            r0 = move-exception
            r9 = r0
            com.google.android.gms.measurement.internal.zzib r8 = r8.zzu     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgt r8 = r8.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgt.zzl(r15)     // Catch:{ all -> 0x0178 }
            r8.zzc(r10, r12, r9)     // Catch:{ all -> 0x0178 }
        L_0x02ad:
            com.google.android.gms.measurement.internal.zzpm r19 = new com.google.android.gms.measurement.internal.zzpm     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r6.zzc     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.util.Clock r8 = r49.zzaZ()     // Catch:{ all -> 0x0178 }
            long r12 = r8.currentTimeMillis()     // Catch:{ all -> 0x0178 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0178 }
            r8 = r19
            r9 = r15
            r5 = 0
            r14 = r4
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x0178 }
            goto L_0x026a
        L_0x02c6:
            com.google.android.gms.measurement.internal.zzav r8 = r49.zzj()     // Catch:{ all -> 0x0178 }
            boolean r8 = r8.zzl(r4)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x0308
            com.google.android.gms.measurement.internal.zzgt r8 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r9 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r15)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzib r11 = r1.zzn     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgm r11 = r11.zzl()     // Catch:{ all -> 0x0178 }
            java.lang.String r12 = r4.zzc     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = r11.zzc(r12)     // Catch:{ all -> 0x0178 }
            java.lang.Object r4 = r4.zze     // Catch:{ all -> 0x0178 }
            r8.zzd(r9, r10, r11, r4)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpn r9 = r1.zzK     // Catch:{ all -> 0x0178 }
            r13 = 0
            r14 = 0
            r11 = 9
            r12 = 0
            r10 = r15
            r8.zzN(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0178 }
            goto L_0x0308
        L_0x02ff:
            r21 = r3
            r30 = r6
            r6 = r12
            r3 = r18
            goto L_0x0196
        L_0x0308:
            java.lang.String r4 = r6.zza     // Catch:{ all -> 0x0178 }
            boolean r22 = com.google.android.gms.measurement.internal.zzpo.zzh(r4)     // Catch:{ all -> 0x0178 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0178 }
            r49.zzt()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzbe r14 = r6.zzb     // Catch:{ all -> 0x0178 }
            if (r14 != 0) goto L_0x031c
            r9 = 0
            goto L_0x033b
        L_0x031c:
            com.google.android.gms.measurement.internal.zzbd r8 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x0178 }
            r8.<init>(r14)     // Catch:{ all -> 0x0178 }
            r9 = 0
        L_0x0323:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x0178 }
            if (r11 == 0) goto L_0x033b
            java.lang.String r11 = r8.next()     // Catch:{ all -> 0x0178 }
            java.lang.Object r11 = r14.zza(r11)     // Catch:{ all -> 0x0178 }
            boolean r12 = r11 instanceof android.os.Parcelable[]     // Catch:{ all -> 0x0178 }
            if (r12 == 0) goto L_0x0323
            android.os.Parcelable[] r11 = (android.os.Parcelable[]) r11     // Catch:{ all -> 0x0178 }
            int r11 = r11.length     // Catch:{ all -> 0x0178 }
            long r11 = (long) r11     // Catch:{ all -> 0x0178 }
            long r9 = r9 + r11
            goto L_0x0323
        L_0x033b:
            r12 = 1
            long r18 = r9 + r12
            com.google.android.gms.measurement.internal.zzav r8 = r49.zzj()     // Catch:{ all -> 0x0178 }
            long r9 = r49.zzC()     // Catch:{ all -> 0x0178 }
            r20 = 0
            r23 = 0
            r24 = 1
            r32 = 0
            r33 = 0
            r11 = r15
            r34 = r6
            r5 = 0
            r12 = r18
            r35 = r14
            r14 = r24
            r36 = r15
            r15 = r22
            r16 = r32
            r17 = r3
            r18 = r33
            r19 = r20
            r20 = r23
            com.google.android.gms.measurement.internal.zzar r8 = r8.zzx(r9, r11, r12, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0178 }
            long r9 = r8.zzb     // Catch:{ all -> 0x0178 }
            r49.zzd()     // Catch:{ all -> 0x0178 }
            long r11 = com.google.android.gms.measurement.internal.zzal.zzH()     // Catch:{ all -> 0x0178 }
            long r9 = r9 - r11
            r11 = 1000(0x3e8, double:4.94E-321)
            int r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x03a5
            long r9 = r9 % r11
            r13 = 1
            int r2 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x039c
            com.google.android.gms.measurement.internal.zzgt r2 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r36)     // Catch:{ all -> 0x0178 }
            long r5 = r8.zzb     // Catch:{ all -> 0x0178 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0178 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0178 }
        L_0x039c:
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()     // Catch:{ all -> 0x0178 }
            r2.zzc()     // Catch:{ all -> 0x0178 }
            goto L_0x05b5
        L_0x03a5:
            r13 = 1
            if (r22 == 0) goto L_0x03fc
            long r9 = r8.zza     // Catch:{ all -> 0x0178 }
            r49.zzd()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r15 = com.google.android.gms.measurement.internal.zzfx.zzm     // Catch:{ all -> 0x0178 }
            r13 = 0
            java.lang.Object r14 = r15.zzb(r13)     // Catch:{ all -> 0x0178 }
            java.lang.Integer r14 = (java.lang.Integer) r14     // Catch:{ all -> 0x0178 }
            int r13 = r14.intValue()     // Catch:{ all -> 0x0178 }
            long r13 = (long) r13     // Catch:{ all -> 0x0178 }
            long r9 = r9 - r13
            int r13 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x03fc
            long r9 = r9 % r11
            r2 = 1
            int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x03df
            com.google.android.gms.measurement.internal.zzgt r2 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r36)     // Catch:{ all -> 0x0178 }
            long r5 = r8.zza     // Catch:{ all -> 0x0178 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0178 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0178 }
        L_0x03df:
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpn r9 = r1.zzK     // Catch:{ all -> 0x0178 }
            java.lang.String r12 = "_ev"
            r10 = r34
            java.lang.String r13 = r10.zza     // Catch:{ all -> 0x0178 }
            r14 = 0
            r11 = 16
            r10 = r36
            r8.zzN(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()     // Catch:{ all -> 0x0178 }
            r2.zzc()     // Catch:{ all -> 0x0178 }
            goto L_0x05b5
        L_0x03fc:
            r10 = r34
            r9 = 1000000(0xf4240, float:1.401298E-39)
            if (r3 == 0) goto L_0x0446
            long r11 = r8.zzd     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzal r3 = r49.zzd()     // Catch:{ all -> 0x0178 }
            java.lang.String r13 = r2.zza     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r14 = com.google.android.gms.measurement.internal.zzfx.zzl     // Catch:{ all -> 0x0178 }
            int r3 = r3.zzm(r13, r14)     // Catch:{ all -> 0x0178 }
            int r3 = java.lang.Math.min(r9, r3)     // Catch:{ all -> 0x0178 }
            r13 = 0
            int r3 = java.lang.Math.max(r13, r3)     // Catch:{ all -> 0x0178 }
            long r13 = (long) r3     // Catch:{ all -> 0x0178 }
            long r11 = r11 - r13
            int r3 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0446
            r13 = 1
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x043d
            com.google.android.gms.measurement.internal.zzgt r2 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r36)     // Catch:{ all -> 0x0178 }
            long r5 = r8.zzd     // Catch:{ all -> 0x0178 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0178 }
            r2.zzc(r3, r4, r5)     // Catch:{ all -> 0x0178 }
        L_0x043d:
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()     // Catch:{ all -> 0x0178 }
            r2.zzc()     // Catch:{ all -> 0x0178 }
            goto L_0x05b5
        L_0x0446:
            android.os.Bundle r3 = r35.zzf()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r10.zzc     // Catch:{ all -> 0x0178 }
            r8.zzM(r3, r11, r12)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = r2.zzB     // Catch:{ all -> 0x0178 }
            r15 = r36
            boolean r8 = r8.zzaa(r15, r11)     // Catch:{ all -> 0x0178 }
            java.lang.String r13 = "_r"
            if (r8 == 0) goto L_0x047c
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = "_dbg"
            r16 = 1
            java.lang.Long r14 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x0178 }
            r8.zzM(r3, r11, r14)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            r8.zzM(r3, r13, r14)     // Catch:{ all -> 0x0178 }
            goto L_0x047e
        L_0x047c:
            r16 = 1
        L_0x047e:
            java.lang.String r8 = "_s"
            boolean r8 = r8.equals(r4)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x049f
            com.google.android.gms.measurement.internal.zzav r8 = r49.zzj()     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpm r8 = r8.zzm(r11, r7)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x049f
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x0178 }
            boolean r11 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0178 }
            if (r11 == 0) goto L_0x049f
            com.google.android.gms.measurement.internal.zzpo r11 = r49.zzt()     // Catch:{ all -> 0x0178 }
            r11.zzM(r3, r7, r8)     // Catch:{ all -> 0x0178 }
        L_0x049f:
            com.google.android.gms.measurement.internal.zzal r7 = r49.zzd()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r8 = com.google.android.gms.measurement.internal.zzfx.zzaX     // Catch:{ all -> 0x0178 }
            r11 = 0
            boolean r7 = r7.zzp(r11, r8)     // Catch:{ all -> 0x0178 }
            if (r7 == 0) goto L_0x04d2
            java.lang.String r7 = "am"
            boolean r7 = java.util.Objects.equals(r12, r7)     // Catch:{ all -> 0x0178 }
            if (r7 == 0) goto L_0x04d2
            java.lang.String r7 = "_ai"
            boolean r4 = java.util.Objects.equals(r4, r7)     // Catch:{ all -> 0x0178 }
            if (r4 == 0) goto L_0x04d2
            r4 = r21
            java.lang.Object r7 = r3.get(r4)     // Catch:{ all -> 0x0178 }
            boolean r8 = r7 instanceof java.lang.String     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x04d2
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ NumberFormatException -> 0x04d2 }
            double r7 = java.lang.Double.parseDouble(r7)     // Catch:{ NumberFormatException -> 0x04d2 }
            r3.remove(r4)     // Catch:{ NumberFormatException -> 0x04d2 }
            r3.putDouble(r4, r7)     // Catch:{ NumberFormatException -> 0x04d2 }
        L_0x04d2:
            com.google.android.gms.measurement.internal.zzav r4 = r49.zzj()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0178 }
            r4.zzg()     // Catch:{ all -> 0x0178 }
            r4.zzay()     // Catch:{ all -> 0x0178 }
            android.database.sqlite.SQLiteDatabase r7 = r4.zze()     // Catch:{ SQLiteException -> 0x050d }
            com.google.android.gms.measurement.internal.zzib r8 = r4.zzu     // Catch:{ SQLiteException -> 0x050d }
            com.google.android.gms.measurement.internal.zzal r8 = r8.zzc()     // Catch:{ SQLiteException -> 0x050d }
            com.google.android.gms.measurement.internal.zzfw r11 = com.google.android.gms.measurement.internal.zzfx.zzp     // Catch:{ SQLiteException -> 0x050d }
            int r8 = r8.zzm(r15, r11)     // Catch:{ SQLiteException -> 0x050d }
            int r8 = java.lang.Math.min(r9, r8)     // Catch:{ SQLiteException -> 0x050d }
            r9 = 0
            int r8 = java.lang.Math.max(r9, r8)     // Catch:{ SQLiteException -> 0x050d }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x050d }
            java.lang.String r9 = "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)"
            java.lang.String[] r8 = new java.lang.String[]{r15, r8}     // Catch:{ SQLiteException -> 0x050d }
            r14 = r30
            int r4 = r7.delete(r14, r9, r8)     // Catch:{ SQLiteException -> 0x050a }
            long r7 = (long) r4
            goto L_0x0525
        L_0x050a:
            r0 = move-exception
        L_0x050b:
            r7 = r0
            goto L_0x0511
        L_0x050d:
            r0 = move-exception
            r14 = r30
            goto L_0x050b
        L_0x0511:
            com.google.android.gms.measurement.internal.zzib r4 = r4.zzu     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = "Error deleting over the limit events. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r15)     // Catch:{ all -> 0x0178 }
            r4.zzc(r8, r9, r7)     // Catch:{ all -> 0x0178 }
            r7 = r5
        L_0x0525:
            int r4 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x053e
            com.google.android.gms.measurement.internal.zzgt r4 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zze()     // Catch:{ all -> 0x0178 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgt.zzl(r15)     // Catch:{ all -> 0x0178 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0178 }
            r4.zzc(r9, r11, r7)     // Catch:{ all -> 0x0178 }
        L_0x053e:
            com.google.android.gms.measurement.internal.zzbb r4 = new com.google.android.gms.measurement.internal.zzbb     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzib r7 = r1.zzn     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = r10.zzc     // Catch:{ all -> 0x0178 }
            java.lang.String r12 = r10.zza     // Catch:{ all -> 0x0178 }
            long r9 = r10.zzd     // Catch:{ all -> 0x0178 }
            r18 = 0
            r8 = r4
            r20 = r9
            r9 = r7
            r10 = r11
            r11 = r15
            r40 = r13
            r37 = r14
            r13 = r20
            r5 = r15
            r15 = r18
            r17 = r3
            r8.<init>((com.google.android.gms.measurement.internal.zzib) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (long) r13, (long) r15, (android.os.Bundle) r17)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzav r3 = r49.zzj()     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r4.zzb     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzbc r3 = r3.zzf(r5, r10)     // Catch:{ all -> 0x0178 }
            if (r3 != 0) goto L_0x05d9
            com.google.android.gms.measurement.internal.zzav r3 = r49.zzj()     // Catch:{ all -> 0x0178 }
            long r8 = r3.zzU(r5)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzal r3 = r49.zzd()     // Catch:{ all -> 0x0178 }
            int r3 = r3.zzh(r5)     // Catch:{ all -> 0x0178 }
            long r11 = (long) r3     // Catch:{ all -> 0x0178 }
            int r3 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r3 < 0) goto L_0x05bd
            if (r22 == 0) goto L_0x05bd
            com.google.android.gms.measurement.internal.zzgt r2 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r5)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgm r6 = r7.zzl()     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r6.zza(r10)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzal r7 = r49.zzd()     // Catch:{ all -> 0x0178 }
            int r7 = r7.zzh(r5)     // Catch:{ all -> 0x0178 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x0178 }
            r2.zzd(r3, r4, r6, r7)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpn r9 = r1.zzK     // Catch:{ all -> 0x0178 }
            r13 = 0
            r14 = 0
            r11 = 8
            r12 = 0
            r10 = r5
            r8.zzN(r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x0178 }
        L_0x05b5:
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()
            r2.zzd()
            return
        L_0x05bd:
            com.google.android.gms.measurement.internal.zzbc r3 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ all -> 0x0178 }
            long r6 = r4.zzd     // Catch:{ all -> 0x0178 }
            r23 = 0
            r24 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r8 = r3
            r9 = r5
            r17 = r6
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r21, r22, r23, r24)     // Catch:{ all -> 0x0178 }
            goto L_0x05e5
        L_0x05d9:
            long r5 = r3.zzf     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzbb r4 = r4.zza(r7, r5)     // Catch:{ all -> 0x0178 }
            long r5 = r4.zzd     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzbc r3 = r3.zza(r5)     // Catch:{ all -> 0x0178 }
        L_0x05e5:
            com.google.android.gms.measurement.internal.zzav r5 = r49.zzj()     // Catch:{ all -> 0x0178 }
            r5.zzh(r3)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzhy r3 = r49.zzaW()     // Catch:{ all -> 0x0178 }
            r3.zzg()     // Catch:{ all -> 0x0178 }
            r49.zzu()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r51)     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = r4.zza     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0178 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r3)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.internal.measurement.zzic r3 = com.google.android.gms.internal.measurement.zzid.zzaE()     // Catch:{ all -> 0x0178 }
            r6 = 1
            r3.zza(r6)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = "android"
            r3.zzC(r7)     // Catch:{ all -> 0x0178 }
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0178 }
            if (r7 != 0) goto L_0x0620
            r3.zzL(r5)     // Catch:{ all -> 0x0178 }
        L_0x0620:
            java.lang.String r7 = r2.zzd     // Catch:{ all -> 0x0178 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x062b
            r3.zzJ(r7)     // Catch:{ all -> 0x0178 }
        L_0x062b:
            java.lang.String r7 = r2.zzc     // Catch:{ all -> 0x0178 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x0636
            r3.zzM(r7)     // Catch:{ all -> 0x0178 }
        L_0x0636:
            java.lang.String r7 = r2.zzu     // Catch:{ all -> 0x0178 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x0641
            r3.zzau(r7)     // Catch:{ all -> 0x0178 }
        L_0x0641:
            long r7 = r2.zzj     // Catch:{ all -> 0x0178 }
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 == 0) goto L_0x064e
            int r8 = (int) r7     // Catch:{ all -> 0x0178 }
            r3.zzaj(r8)     // Catch:{ all -> 0x0178 }
        L_0x064e:
            long r7 = r2.zze     // Catch:{ all -> 0x0178 }
            r3.zzN(r7)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = r2.zzb     // Catch:{ all -> 0x0178 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x065e
            r3.zzad(r7)     // Catch:{ all -> 0x0178 }
        L_0x065e:
            java.lang.Object r7 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzjk r7 = r1.zzB(r7)     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = r2.zzs     // Catch:{ all -> 0x0178 }
            r9 = 100
            com.google.android.gms.measurement.internal.zzjk r8 = com.google.android.gms.measurement.internal.zzjk.zzf(r8, r9)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzjk r7 = r7.zzs(r8)     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = r7.zzk()     // Catch:{ all -> 0x0178 }
            r3.zzat(r8)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.internal.measurement.zzql.zza()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzal r8 = r49.zzd()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r10 = com.google.android.gms.measurement.internal.zzfx.zzaP     // Catch:{ all -> 0x0178 }
            boolean r8 = r8.zzp(r5, r10)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x072d
            com.google.android.gms.measurement.internal.zzpo r8 = r49.zzt()     // Catch:{ all -> 0x0178 }
            boolean r5 = r8.zzX(r5)     // Catch:{ all -> 0x0178 }
            if (r5 == 0) goto L_0x072d
            int r5 = r2.zzz     // Catch:{ all -> 0x0178 }
            r3.zzaH(r5)     // Catch:{ all -> 0x0178 }
            long r10 = r2.zzA     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzjj r5 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE     // Catch:{ all -> 0x0178 }
            boolean r5 = r7.zzo(r5)     // Catch:{ all -> 0x0178 }
            r7 = 32
            if (r5 != 0) goto L_0x06af
            r12 = 0
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x06af
            r12 = -2
            long r10 = r10 & r12
            long r10 = r10 | r7
        L_0x06af:
            r12 = 1
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x06b7
            r5 = 1
            goto L_0x06b8
        L_0x06b7:
            r5 = 0
        L_0x06b8:
            r3.zzaz(r5)     // Catch:{ all -> 0x0178 }
            r14 = 0
            int r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x06c3
            goto L_0x072f
        L_0x06c3:
            com.google.android.gms.internal.measurement.zzhd r5 = com.google.android.gms.internal.measurement.zzhe.zzh()     // Catch:{ all -> 0x0178 }
            long r16 = r10 & r12
            int r18 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r18 == 0) goto L_0x06ce
            goto L_0x06cf
        L_0x06ce:
            r6 = 0
        L_0x06cf:
            r5.zza(r6)     // Catch:{ all -> 0x0178 }
            r16 = 2
            long r16 = r10 & r16
            int r6 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x06dc
            r6 = 1
            goto L_0x06dd
        L_0x06dc:
            r6 = 0
        L_0x06dd:
            r5.zzb(r6)     // Catch:{ all -> 0x0178 }
            r16 = 4
            long r16 = r10 & r16
            int r6 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x06ea
            r6 = 1
            goto L_0x06eb
        L_0x06ea:
            r6 = 0
        L_0x06eb:
            r5.zzc(r6)     // Catch:{ all -> 0x0178 }
            r16 = 8
            long r16 = r10 & r16
            int r6 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x06f8
            r6 = 1
            goto L_0x06f9
        L_0x06f8:
            r6 = 0
        L_0x06f9:
            r5.zzd(r6)     // Catch:{ all -> 0x0178 }
            r16 = 16
            long r16 = r10 & r16
            int r6 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0706
            r6 = 1
            goto L_0x0707
        L_0x0706:
            r6 = 0
        L_0x0707:
            r5.zze(r6)     // Catch:{ all -> 0x0178 }
            long r6 = r10 & r7
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0712
            r6 = 1
            goto L_0x0713
        L_0x0712:
            r6 = 0
        L_0x0713:
            r5.zzf(r6)     // Catch:{ all -> 0x0178 }
            r6 = 64
            long r6 = r6 & r10
            int r8 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x071f
            r6 = 1
            goto L_0x0720
        L_0x071f:
            r6 = 0
        L_0x0720:
            r5.zzg(r6)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.internal.measurement.zzme r5 = r5.zzbc()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.internal.measurement.zzhe r5 = (com.google.android.gms.internal.measurement.zzhe) r5     // Catch:{ all -> 0x0178 }
            r3.zzaI(r5)     // Catch:{ all -> 0x0178 }
            goto L_0x072f
        L_0x072d:
            r12 = 1
        L_0x072f:
            long r5 = r2.zzf     // Catch:{ all -> 0x0178 }
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 == 0) goto L_0x073a
            r3.zzY(r5)     // Catch:{ all -> 0x0178 }
        L_0x073a:
            long r5 = r2.zzq     // Catch:{ all -> 0x0178 }
            r3.zzar(r5)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpj r5 = r49.zzp()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpf r6 = r5.zzg     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzib r6 = r6.zzn     // Catch:{ all -> 0x0178 }
            android.content.Context r6 = r6.zzaY()     // Catch:{ all -> 0x0178 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = "com.google.android.gms.measurement"
            android.net.Uri r7 = com.google.android.gms.internal.measurement.zzka.zza(r7)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfu r8 = com.google.android.gms.measurement.internal.zzfu.zza     // Catch:{ all -> 0x0178 }
            com.google.android.gms.internal.measurement.zzjq r6 = com.google.android.gms.internal.measurement.zzjq.zza(r6, r7, r8)     // Catch:{ all -> 0x0178 }
            if (r6 != 0) goto L_0x0762
            java.util.Map r6 = java.util.Collections.emptyMap()     // Catch:{ all -> 0x0178 }
            goto L_0x0766
        L_0x0762:
            java.util.Map r6 = r6.zzb()     // Catch:{ all -> 0x0178 }
        L_0x0766:
            if (r6 == 0) goto L_0x076e
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0178 }
            if (r7 == 0) goto L_0x0771
        L_0x076e:
            r7 = 0
            goto L_0x07f0
        L_0x0771:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0178 }
            r7.<init>()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r8 = com.google.android.gms.measurement.internal.zzfx.zzaf     // Catch:{ all -> 0x0178 }
            r10 = 0
            java.lang.Object r8 = r8.zzb(r10)     // Catch:{ all -> 0x0178 }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x0178 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0178 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x0178 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0178 }
        L_0x078b:
            boolean r10 = r6.hasNext()     // Catch:{ all -> 0x0178 }
            if (r10 == 0) goto L_0x07e8
            java.lang.Object r10 = r6.next()     // Catch:{ all -> 0x0178 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0178 }
            java.lang.Object r11 = r10.getKey()     // Catch:{ all -> 0x0178 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0178 }
            java.lang.String r14 = "measurement.id."
            boolean r11 = r11.startsWith(r14)     // Catch:{ all -> 0x0178 }
            if (r11 == 0) goto L_0x078b
            java.lang.Object r10 = r10.getValue()     // Catch:{ NumberFormatException -> 0x07d6 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x07d6 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x07d6 }
            if (r10 == 0) goto L_0x078b
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x07d6 }
            r7.add(r10)     // Catch:{ NumberFormatException -> 0x07d6 }
            int r10 = r7.size()     // Catch:{ NumberFormatException -> 0x07d6 }
            if (r10 < r8) goto L_0x078b
            com.google.android.gms.measurement.internal.zzib r10 = r5.zzu     // Catch:{ NumberFormatException -> 0x07d6 }
            com.google.android.gms.measurement.internal.zzgt r10 = r10.zzaV()     // Catch:{ NumberFormatException -> 0x07d6 }
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zze()     // Catch:{ NumberFormatException -> 0x07d6 }
            java.lang.String r11 = "Too many experiment IDs. Number of IDs"
            int r14 = r7.size()     // Catch:{ NumberFormatException -> 0x07d6 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ NumberFormatException -> 0x07d6 }
            r10.zzb(r11, r14)     // Catch:{ NumberFormatException -> 0x07d6 }
            goto L_0x07e8
        L_0x07d6:
            r0 = move-exception
            r10 = r0
            com.google.android.gms.measurement.internal.zzib r11 = r5.zzu     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgt r11 = r11.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r11 = r11.zze()     // Catch:{ all -> 0x0178 }
            java.lang.String r14 = "Experiment ID NumberFormatException"
            r11.zzb(r14, r10)     // Catch:{ all -> 0x0178 }
            goto L_0x078b
        L_0x07e8:
            boolean r5 = r7.isEmpty()     // Catch:{ all -> 0x0178 }
            if (r5 == 0) goto L_0x07f0
            goto L_0x076e
        L_0x07f0:
            if (r7 == 0) goto L_0x07f5
            r3.zzaq(r7)     // Catch:{ all -> 0x0178 }
        L_0x07f5:
            com.google.android.gms.measurement.internal.zzal r5 = r49.zzd()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r6 = com.google.android.gms.measurement.internal.zzfx.zzbb     // Catch:{ all -> 0x0178 }
            r7 = 0
            boolean r5 = r5.zzp(r7, r6)     // Catch:{ all -> 0x0178 }
            if (r5 == 0) goto L_0x0807
            java.lang.String r5 = ""
            r3.zzaP(r5)     // Catch:{ all -> 0x0178 }
        L_0x0807:
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x0178 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzjk r6 = r1.zzB(r6)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = r2.zzs     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzjk r7 = com.google.android.gms.measurement.internal.zzjk.zzf(r7, r9)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzjk r6 = r6.zzs(r7)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzjj r7 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE     // Catch:{ all -> 0x0178 }
            boolean r8 = r6.zzo(r7)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x08b3
            boolean r8 = r2.zzn     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x08b3
            com.google.android.gms.measurement.internal.zznm r8 = r1.zzk     // Catch:{ all -> 0x0178 }
            android.util.Pair r8 = r8.zzc(r5, r6)     // Catch:{ all -> 0x0178 }
            java.lang.Object r9 = r8.first     // Catch:{ all -> 0x0178 }
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ all -> 0x0178 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0178 }
            if (r9 != 0) goto L_0x08b3
            java.lang.Object r9 = r8.first     // Catch:{ all -> 0x0178 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0178 }
            r3.zzQ(r9)     // Catch:{ all -> 0x0178 }
            java.lang.Object r9 = r8.second     // Catch:{ all -> 0x0178 }
            if (r9 == 0) goto L_0x084d
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0178 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0178 }
            r3.zzT(r9)     // Catch:{ all -> 0x0178 }
        L_0x084d:
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x0178 }
            r10 = r29
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0178 }
            if (r9 != 0) goto L_0x08b3
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x0178 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0178 }
            java.lang.String r9 = "00000000-0000-0000-0000-000000000000"
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0178 }
            if (r8 != 0) goto L_0x08b3
            com.google.android.gms.measurement.internal.zzav r8 = r49.zzj()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzh r8 = r8.zzu(r5)     // Catch:{ all -> 0x0178 }
            if (r8 == 0) goto L_0x08b3
            boolean r9 = r8.zzaq()     // Catch:{ all -> 0x0178 }
            if (r9 == 0) goto L_0x08b3
            r9 = 0
            r11 = 0
            r1.zzR(r5, r11, r9, r9)     // Catch:{ all -> 0x0178 }
            android.os.Bundle r9 = new android.os.Bundle     // Catch:{ all -> 0x0178 }
            r9.<init>()     // Catch:{ all -> 0x0178 }
            java.lang.Long r11 = r8.zzas()     // Catch:{ all -> 0x0178 }
            if (r11 == 0) goto L_0x0895
            java.lang.String r14 = "_pfo"
            long r12 = r11.longValue()     // Catch:{ all -> 0x0178 }
            r11 = r6
            r15 = r7
            r6 = 0
            long r12 = java.lang.Math.max(r6, r12)     // Catch:{ all -> 0x0178 }
            r9.putLong(r14, r12)     // Catch:{ all -> 0x0178 }
            goto L_0x0897
        L_0x0895:
            r11 = r6
            r15 = r7
        L_0x0897:
            java.lang.Long r6 = r8.zzau()     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x08a6
            java.lang.String r7 = "_uwa"
            long r12 = r6.longValue()     // Catch:{ all -> 0x0178 }
            r9.putLong(r7, r12)     // Catch:{ all -> 0x0178 }
        L_0x08a6:
            r8 = r40
            r6 = 1
            r9.putLong(r8, r6)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpn r6 = r1.zzK     // Catch:{ all -> 0x0178 }
            r6.zza(r5, r10, r9)     // Catch:{ all -> 0x0178 }
            goto L_0x08b7
        L_0x08b3:
            r11 = r6
            r15 = r7
            r8 = r40
        L_0x08b7:
            com.google.android.gms.measurement.internal.zzib r6 = r1.zzn     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzba r7 = r6.zzu()     // Catch:{ all -> 0x0178 }
            r7.zzw()     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = android.os.Build.MODEL     // Catch:{ all -> 0x0178 }
            r3.zzF(r7)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzba r7 = r6.zzu()     // Catch:{ all -> 0x0178 }
            r7.zzw()     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0178 }
            r3.zzE(r7)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzba r7 = r6.zzu()     // Catch:{ all -> 0x0178 }
            long r9 = r7.zzb()     // Catch:{ all -> 0x0178 }
            int r7 = (int) r9     // Catch:{ all -> 0x0178 }
            r3.zzI(r7)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzba r7 = r6.zzu()     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = r7.zzc()     // Catch:{ all -> 0x0178 }
            r3.zzH(r7)     // Catch:{ all -> 0x0178 }
            long r9 = r2.zzw     // Catch:{ all -> 0x0178 }
            r3.zzay(r9)     // Catch:{ all -> 0x0178 }
            boolean r7 = r6.zzB()     // Catch:{ all -> 0x0178 }
            if (r7 == 0) goto L_0x0900
            r3.zzK()     // Catch:{ all -> 0x0178 }
            r7 = 0
            boolean r9 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0178 }
            if (r9 != 0) goto L_0x0900
            r3.zzam(r7)     // Catch:{ all -> 0x0178 }
        L_0x0900:
            com.google.android.gms.measurement.internal.zzav r7 = r49.zzj()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzh r7 = r7.zzu(r5)     // Catch:{ all -> 0x0178 }
            if (r7 != 0) goto L_0x0969
            com.google.android.gms.measurement.internal.zzh r7 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0178 }
            r7.<init>(r6, r5)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r1.zzK(r11)     // Catch:{ all -> 0x0178 }
            r7.zze(r6)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r2.zzk     // Catch:{ all -> 0x0178 }
            r7.zzm(r6)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r2.zzb     // Catch:{ all -> 0x0178 }
            r7.zzg(r6)     // Catch:{ all -> 0x0178 }
            r6 = r15
            boolean r6 = r11.zzo(r6)     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x0932
            com.google.android.gms.measurement.internal.zznm r6 = r1.zzk     // Catch:{ all -> 0x0178 }
            boolean r9 = r2.zzn     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r6.zzf(r5, r9)     // Catch:{ all -> 0x0178 }
            r7.zzk(r6)     // Catch:{ all -> 0x0178 }
        L_0x0932:
            r9 = 0
            r7.zzF(r9)     // Catch:{ all -> 0x0178 }
            r7.zzo(r9)     // Catch:{ all -> 0x0178 }
            r7.zzq(r9)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r2.zzc     // Catch:{ all -> 0x0178 }
            r7.zzs(r6)     // Catch:{ all -> 0x0178 }
            long r9 = r2.zzj     // Catch:{ all -> 0x0178 }
            r7.zzu(r9)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r2.zzd     // Catch:{ all -> 0x0178 }
            r7.zzw(r6)     // Catch:{ all -> 0x0178 }
            long r9 = r2.zze     // Catch:{ all -> 0x0178 }
            r7.zzy(r9)     // Catch:{ all -> 0x0178 }
            long r9 = r2.zzf     // Catch:{ all -> 0x0178 }
            r7.zzA(r9)     // Catch:{ all -> 0x0178 }
            boolean r6 = r2.zzh     // Catch:{ all -> 0x0178 }
            r7.zzE(r6)     // Catch:{ all -> 0x0178 }
            long r9 = r2.zzq     // Catch:{ all -> 0x0178 }
            r7.zzC(r9)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzav r6 = r49.zzj()     // Catch:{ all -> 0x0178 }
            r9 = 0
            r6.zzv(r7, r9, r9)     // Catch:{ all -> 0x0178 }
            goto L_0x096a
        L_0x0969:
            r9 = 0
        L_0x096a:
            com.google.android.gms.measurement.internal.zzjj r6 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE     // Catch:{ all -> 0x0178 }
            boolean r6 = r11.zzo(r6)     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x0989
            java.lang.String r6 = r7.zzd()     // Catch:{ all -> 0x0178 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0178 }
            if (r6 != 0) goto L_0x0989
            java.lang.String r6 = r7.zzd()     // Catch:{ all -> 0x0178 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0178 }
            r3.zzW(r6)     // Catch:{ all -> 0x0178 }
        L_0x0989:
            java.lang.String r6 = r7.zzl()     // Catch:{ all -> 0x0178 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0178 }
            if (r6 != 0) goto L_0x09a0
            java.lang.String r6 = r7.zzl()     // Catch:{ all -> 0x0178 }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0178 }
            r3.zzah(r6)     // Catch:{ all -> 0x0178 }
        L_0x09a0:
            com.google.android.gms.measurement.internal.zzav r6 = r49.zzj()     // Catch:{ all -> 0x0178 }
            java.util.List r5 = r6.zzn(r5)     // Catch:{ all -> 0x0178 }
            r11 = 0
        L_0x09a9:
            int r6 = r5.size()     // Catch:{ all -> 0x0178 }
            if (r11 >= r6) goto L_0x0a0d
            com.google.android.gms.internal.measurement.zzit r6 = com.google.android.gms.internal.measurement.zziu.zzm()     // Catch:{ all -> 0x0178 }
            java.lang.Object r10 = r5.get(r11)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpm r10 = (com.google.android.gms.measurement.internal.zzpm) r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x0178 }
            r6.zzb(r10)     // Catch:{ all -> 0x0178 }
            java.lang.Object r10 = r5.get(r11)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpm r10 = (com.google.android.gms.measurement.internal.zzpm) r10     // Catch:{ all -> 0x0178 }
            long r12 = r10.zzd     // Catch:{ all -> 0x0178 }
            r6.zza(r12)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpj r10 = r49.zzp()     // Catch:{ all -> 0x0178 }
            java.lang.Object r12 = r5.get(r11)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpm r12 = (com.google.android.gms.measurement.internal.zzpm) r12     // Catch:{ all -> 0x0178 }
            java.lang.Object r12 = r12.zze     // Catch:{ all -> 0x0178 }
            r10.zzc(r6, r12)     // Catch:{ all -> 0x0178 }
            r3.zzp(r6)     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = "_sid"
            java.lang.Object r10 = r5.get(r11)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpm r10 = (com.google.android.gms.measurement.internal.zzpm) r10     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x0178 }
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x0178 }
            if (r6 == 0) goto L_0x0a0a
            long r12 = r7.zzam()     // Catch:{ all -> 0x0178 }
            r14 = 0
            int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0a0a
            com.google.android.gms.measurement.internal.zzpj r6 = r49.zzp()     // Catch:{ all -> 0x0178 }
            java.lang.String r10 = r2.zzu     // Catch:{ all -> 0x0178 }
            long r12 = r6.zzu(r10)     // Catch:{ all -> 0x0178 }
            long r14 = r7.zzam()     // Catch:{ all -> 0x0178 }
            int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0a0a
            r3.zzav()     // Catch:{ all -> 0x0178 }
        L_0x0a0a:
            int r11 = r11 + 1
            goto L_0x09a9
        L_0x0a0d:
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.internal.measurement.zzme r5 = r3.zzbc()     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.internal.measurement.zzid r5 = (com.google.android.gms.internal.measurement.zzid) r5     // Catch:{ IOException -> 0x0b46 }
            r2.zzg()     // Catch:{ IOException -> 0x0b46 }
            r2.zzay()     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ IOException -> 0x0b46 }
            java.lang.String r6 = r5.zzA()     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ IOException -> 0x0b46 }
            byte[] r6 = r5.zzcc()     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.measurement.internal.zzpf r7 = r2.zzg     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.measurement.internal.zzpj r7 = r7.zzp()     // Catch:{ IOException -> 0x0b46 }
            long r10 = r7.zzt(r6)     // Catch:{ IOException -> 0x0b46 }
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ IOException -> 0x0b46 }
            r7.<init>()     // Catch:{ IOException -> 0x0b46 }
            java.lang.String r12 = r5.zzA()     // Catch:{ IOException -> 0x0b46 }
            r13 = r28
            r7.put(r13, r12)     // Catch:{ IOException -> 0x0b46 }
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ IOException -> 0x0b46 }
            r14 = r27
            r7.put(r14, r12)     // Catch:{ IOException -> 0x0b46 }
            java.lang.String r12 = "metadata"
            r7.put(r12, r6)     // Catch:{ IOException -> 0x0b46 }
            android.database.sqlite.SQLiteDatabase r6 = r2.zze()     // Catch:{ SQLiteException -> 0x0b49 }
            java.lang.String r12 = "raw_events_metadata"
            r15 = 4
            r9 = 0
            r6.insertWithOnConflict(r12, r9, r7, r15)     // Catch:{ SQLiteException -> 0x0b49 }
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzbe r3 = r4.zzf     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzbd r5 = new com.google.android.gms.measurement.internal.zzbd     // Catch:{ all -> 0x0178 }
            r5.<init>(r3)     // Catch:{ all -> 0x0178 }
        L_0x0a67:
            boolean r3 = r5.hasNext()     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x0a7a
            java.lang.String r3 = r5.next()     // Catch:{ all -> 0x0178 }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x0a67
        L_0x0a77:
            r31 = 1
            goto L_0x0ab8
        L_0x0a7a:
            com.google.android.gms.measurement.internal.zzhs r3 = r49.zzh()     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = r4.zza     // Catch:{ all -> 0x0178 }
            java.lang.String r6 = r4.zzb     // Catch:{ all -> 0x0178 }
            boolean r3 = r3.zzk(r5, r6)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzav r38 = r49.zzj()     // Catch:{ all -> 0x0178 }
            long r39 = r49.zzC()     // Catch:{ all -> 0x0178 }
            r47 = 0
            r48 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r41 = r5
            com.google.android.gms.measurement.internal.zzar r6 = r38.zzw(r39, r41, r42, r43, r44, r45, r46, r47, r48)     // Catch:{ all -> 0x0178 }
            if (r3 == 0) goto L_0x0ab6
            long r6 = r6.zze     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzal r3 = r49.zzd()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzfw r8 = com.google.android.gms.measurement.internal.zzfx.zzo     // Catch:{ all -> 0x0178 }
            int r3 = r3.zzm(r5, r8)     // Catch:{ all -> 0x0178 }
            long r8 = (long) r3     // Catch:{ all -> 0x0178 }
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0ab6
            goto L_0x0a77
        L_0x0ab6:
            r31 = 0
        L_0x0ab8:
            r2.zzg()     // Catch:{ all -> 0x0178 }
            r2.zzay()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0178 }
            java.lang.String r3 = r4.zza     // Catch:{ all -> 0x0178 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r3)     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpf r5 = r2.zzg     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzpj r5 = r5.zzp()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.internal.measurement.zzhs r5 = r5.zzh(r4)     // Catch:{ all -> 0x0178 }
            byte[] r5 = r5.zzcc()     // Catch:{ all -> 0x0178 }
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ all -> 0x0178 }
            r6.<init>()     // Catch:{ all -> 0x0178 }
            r6.put(r13, r3)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = "name"
            java.lang.String r8 = r4.zzb     // Catch:{ all -> 0x0178 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = "timestamp"
            long r8 = r4.zzd     // Catch:{ all -> 0x0178 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0178 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0178 }
            java.lang.Long r7 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0178 }
            r6.put(r14, r7)     // Catch:{ all -> 0x0178 }
            java.lang.String r7 = "data"
            r6.put(r7, r5)     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = "realtime"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r31)     // Catch:{ all -> 0x0178 }
            r6.put(r5, r7)     // Catch:{ all -> 0x0178 }
            android.database.sqlite.SQLiteDatabase r5 = r2.zze()     // Catch:{ SQLiteException -> 0x0b28 }
            r7 = r37
            r8 = 0
            long r5 = r5.insert(r7, r8, r6)     // Catch:{ SQLiteException -> 0x0b28 }
            r7 = -1
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0b2b
            com.google.android.gms.measurement.internal.zzib r5 = r2.zzu     // Catch:{ SQLiteException -> 0x0b28 }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ SQLiteException -> 0x0b28 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x0b28 }
            java.lang.String r6 = "Failed to insert raw event (got -1). appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ SQLiteException -> 0x0b28 }
            r5.zzb(r6, r3)     // Catch:{ SQLiteException -> 0x0b28 }
            goto L_0x0b78
        L_0x0b28:
            r0 = move-exception
            r3 = r0
            goto L_0x0b30
        L_0x0b2b:
            r5 = 0
            r1.zza = r5     // Catch:{ all -> 0x0178 }
            goto L_0x0b78
        L_0x0b30:
            com.google.android.gms.measurement.internal.zzib r2 = r2.zzu     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = "Error storing raw event. appId"
            java.lang.String r4 = r4.zza     // Catch:{ all -> 0x0178 }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r4)     // Catch:{ all -> 0x0178 }
            r2.zzc(r5, r4, r3)     // Catch:{ all -> 0x0178 }
            goto L_0x0b78
        L_0x0b46:
            r0 = move-exception
            r2 = r0
            goto L_0x0b63
        L_0x0b49:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzib r2 = r2.zzu     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ IOException -> 0x0b46 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ IOException -> 0x0b46 }
            java.lang.String r6 = "Error storing raw event metadata. appId"
            java.lang.String r5 = r5.zzA()     // Catch:{ IOException -> 0x0b46 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r5)     // Catch:{ IOException -> 0x0b46 }
            r2.zzc(r6, r5, r4)     // Catch:{ IOException -> 0x0b46 }
            throw r4     // Catch:{ IOException -> 0x0b46 }
        L_0x0b63:
            com.google.android.gms.measurement.internal.zzgt r4 = r49.zzaV()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x0178 }
            java.lang.String r5 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r3 = r3.zzK()     // Catch:{ all -> 0x0178 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ all -> 0x0178 }
            r4.zzc(r5, r3, r2)     // Catch:{ all -> 0x0178 }
        L_0x0b78:
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()     // Catch:{ all -> 0x0178 }
            r2.zzc()     // Catch:{ all -> 0x0178 }
            com.google.android.gms.measurement.internal.zzav r2 = r49.zzj()
            r2.zzd()
            r49.zzaK()
            com.google.android.gms.measurement.internal.zzgt r2 = r49.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r25
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zzb(r4, r3)
            return
        L_0x0ba9:
            com.google.android.gms.measurement.internal.zzav r3 = r49.zzj()
            r3.zzd()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzH(com.google.android.gms.measurement.internal.zzbg, com.google.android.gms.measurement.internal.zzr):void");
    }

    @WorkerThread
    public final void zzI(zzh zzh2, zzic zzic) {
        zziu zziu;
        zzaW().zzg();
        zzu();
        zzan zzd2 = zzan.zzd(zzic.zzaA());
        String zzc2 = zzh2.zzc();
        zzaW().zzg();
        zzu();
        zzjk zzB2 = zzB(zzc2);
        zzjh zzjh = zzjh.UNINITIALIZED;
        int ordinal = zzB2.zzp().ordinal();
        if (ordinal == 1) {
            zzd2.zzc(zzjj.AD_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal == 2 || ordinal == 3) {
            zzd2.zzb(zzjj.AD_STORAGE, zzB2.zzb());
        } else {
            zzd2.zzc(zzjj.AD_STORAGE, zzam.FAILSAFE);
        }
        int ordinal2 = zzB2.zzq().ordinal();
        if (ordinal2 == 1) {
            zzd2.zzc(zzjj.ANALYTICS_STORAGE, zzam.REMOTE_ENFORCED_DEFAULT);
        } else if (ordinal2 == 2 || ordinal2 == 3) {
            zzd2.zzb(zzjj.ANALYTICS_STORAGE, zzB2.zzb());
        } else {
            zzd2.zzc(zzjj.ANALYTICS_STORAGE, zzam.FAILSAFE);
        }
        String zzc3 = zzh2.zzc();
        zzaW().zzg();
        zzu();
        zzaz zzz2 = zzz(zzc3, zzx(zzc3), zzB(zzc3), zzd2);
        zzic.zzaD(((Boolean) Preconditions.checkNotNull(zzz2.zzj())).booleanValue());
        if (!TextUtils.isEmpty(zzz2.zzk())) {
            zzic.zzaF(zzz2.zzk());
        }
        zzaW().zzg();
        zzu();
        Iterator it = zzic.zzk().iterator();
        while (true) {
            if (!it.hasNext()) {
                zziu = null;
                break;
            }
            zziu = (zziu) it.next();
            if ("_npa".equals(zziu.zzc())) {
                break;
            }
        }
        if (zziu != null) {
            zzjj zzjj = zzjj.AD_PERSONALIZATION;
            if (zzd2.zza(zzjj) == zzam.UNSET) {
                zzpm zzm2 = zzj().zzm(zzh2.zzc(), "_npa");
                if (zzm2 != null) {
                    String str = zzm2.zzb;
                    if ("tcf".equals(str)) {
                        zzd2.zzc(zzjj, zzam.TCF);
                    } else if ("app".equals(str)) {
                        zzd2.zzc(zzjj, zzam.API);
                    } else {
                        zzd2.zzc(zzjj, zzam.MANIFEST);
                    }
                } else {
                    Boolean zzae = zzh2.zzae();
                    if (zzae == null || ((zzae.booleanValue() && zziu.zzg() != 1) || (!zzae.booleanValue() && zziu.zzg() != 0))) {
                        zzd2.zzc(zzjj, zzam.API);
                    } else {
                        zzd2.zzc(zzjj, zzam.MANIFEST);
                    }
                }
            }
        } else {
            int zzaB = zzaB(zzh2.zzc(), zzd2);
            zzit zzm3 = zziu.zzm();
            zzm3.zzb("_npa");
            zzm3.zza(zzaZ().currentTimeMillis());
            zzm3.zze((long) zzaB);
            zzic.zzo((zziu) zzm3.zzbc());
            zzaV().zzk().zzc("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(zzaB));
        }
        zzic.zzaB(zzd2.toString());
        boolean zzy2 = this.zzc.zzy(zzh2.zzc());
        List zzb2 = zzic.zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2.size(); i2++) {
            if ("_tcf".equals(((zzhs) zzb2.get(i2)).zzd())) {
                zzhr zzhr = (zzhr) ((zzhs) zzb2.get(i2)).zzcl();
                List zza2 = zzhr.zza();
                int i3 = 0;
                while (true) {
                    if (i3 >= zza2.size()) {
                        break;
                    } else if ("_tcfd".equals(((zzhw) zza2.get(i3)).zzb())) {
                        String zzd3 = ((zzhw) zza2.get(i3)).zzd();
                        if (zzy2 && zzd3.length() > 4) {
                            char[] charArray = zzd3.toCharArray();
                            int i4 = 1;
                            while (true) {
                                if (i4 >= 64) {
                                    break;
                                } else if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i4)) {
                                    i = i4;
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                            charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i);
                            zzd3 = String.valueOf(charArray);
                        }
                        zzhv zzn2 = zzhw.zzn();
                        zzn2.zzb("_tcfd");
                        zzn2.zzd(zzd3);
                        zzhr.zze(i3, zzn2);
                    } else {
                        i3++;
                    }
                }
                zzic.zzf(i2, zzhr);
                return;
            }
        }
    }

    @WorkerThread
    public final void zzJ(zzh zzh2, zzic zzic) {
        zzaW().zzg();
        zzu();
        zzgx zzr2 = zzha.zzr();
        byte[] zzaJ = zzh2.zzaJ();
        if (zzaJ != null) {
            try {
                zzr2 = (zzgx) zzpj.zzw(zzr2, zzaJ);
            } catch (zzmq unused) {
                zzaV().zze().zzb("Failed to parse locally stored ad campaign info. appId", zzgt.zzl(zzh2.zzc()));
            }
        }
        for (zzhs zzhs : zzic.zzb()) {
            if (zzhs.zzd().equals(Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN)) {
                String str = (String) zzpj.zzJ(zzhs, "gclid", "");
                String str2 = (String) zzpj.zzJ(zzhs, "gbraid", "");
                String str3 = (String) zzpj.zzJ(zzhs, "gad_source", "");
                String[] split = ((String) zzfx.zzbh.zzb((Object) null)).split(",");
                zzp();
                if (!zzpj.zzG(zzhs, split).isEmpty()) {
                    long longValue = ((Long) zzpj.zzJ(zzhs, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = zzhs.zzf();
                    }
                    if ("referrer API v2".equals(zzpj.zzI(zzhs, "_cis"))) {
                        if (longValue > zzr2.zzo()) {
                            if (str.isEmpty()) {
                                zzr2.zzj();
                            } else {
                                zzr2.zzi(str);
                            }
                            if (str2.isEmpty()) {
                                zzr2.zzl();
                            } else {
                                zzr2.zzk(str2);
                            }
                            if (str3.isEmpty()) {
                                zzr2.zzn();
                            } else {
                                zzr2.zzm(str3);
                            }
                            zzr2.zzp(longValue);
                            zzr2.zzs();
                            zzr2.zzt(zzaC(zzhs));
                        }
                    } else if (longValue > zzr2.zzg()) {
                        if (str.isEmpty()) {
                            zzr2.zzb();
                        } else {
                            zzr2.zza(str);
                        }
                        if (str2.isEmpty()) {
                            zzr2.zzd();
                        } else {
                            zzr2.zzc(str2);
                        }
                        if (str3.isEmpty()) {
                            zzr2.zzf();
                        } else {
                            zzr2.zze(str3);
                        }
                        zzr2.zzh(longValue);
                        zzr2.zzq();
                        zzr2.zzr(zzaC(zzhs));
                    }
                }
            }
        }
        if (!((zzha) zzr2.zzbc()).equals(zzha.zzs())) {
            zzic.zzaM((zzha) zzr2.zzbc());
        }
        zzh2.zzaI(((zzha) zzr2.zzbc()).zzcc());
        if (zzh2.zza()) {
            zzj().zzv(zzh2, false, false);
        }
        if (zzd().zzp((String) null, zzfx.zzbg)) {
            zzj().zzk(zzh2.zzc(), "_lgclid");
        }
    }

    @WorkerThread
    public final String zzK(zzjk zzjk) {
        if (!zzjk.zzo(zzjj.ANALYTICS_STORAGE)) {
            return null;
        }
        byte[] bArr = new byte[16];
        zzt().zzf().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    @VisibleForTesting
    public final void zzL(List list) {
        Preconditions.checkArgument(!list.isEmpty());
        if (this.zzz != null) {
            zzaV().zzb().zza("Set uploading progress before finishing the previous upload");
        } else {
            this.zzz = new ArrayList(list);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v3 */
    /* JADX WARNING: type inference failed for: r7v4 */
    /* JADX WARNING: type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v13 */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0124, code lost:
        if (r7 == 0) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0194, code lost:
        if (r1 != null) goto L_0x0170;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b2 A[SYNTHETIC, Splitter:B:80:0x01b2] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:57:0x0170=Splitter:B:57:0x0170, B:44:0x0127=Splitter:B:44:0x0127, B:71:0x0197=Splitter:B:71:0x0197, B:35:0x0109=Splitter:B:35:0x0109} */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzM() {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.zzhy r0 = r11.zzaW()
            r0.zzg()
            r11.zzu()
            r0 = 1
            r11.zzw = r0
            r0 = 0
            com.google.android.gms.measurement.internal.zzib r1 = r11.zzn     // Catch:{ all -> 0x002c }
            r1.zzaU()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zznk r1 = r1.zzt()     // Catch:{ all -> 0x002c }
            java.lang.Boolean r1 = r1.zzJ()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzgt r1 = r11.zzaV()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zze()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r1.zza(r2)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x002c:
            r1 = move-exception
            goto L_0x01b6
        L_0x002f:
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0044
            com.google.android.gms.measurement.internal.zzgt r1 = r11.zzaV()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r1.zza(r2)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0044:
            long r1 = r11.zza     // Catch:{ all -> 0x002c }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0051
            r11.zzaK()     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0051:
            com.google.android.gms.measurement.internal.zzhy r1 = r11.zzaW()     // Catch:{ all -> 0x002c }
            r1.zzg()     // Catch:{ all -> 0x002c }
            java.util.List r1 = r11.zzz     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x006b
            com.google.android.gms.measurement.internal.zzgt r1 = r11.zzaV()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Uploading requested multiple times"
            r1.zza(r2)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x006b:
            com.google.android.gms.measurement.internal.zzgy r1 = r11.zzi()     // Catch:{ all -> 0x002c }
            boolean r1 = r1.zzb()     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x0087
            com.google.android.gms.measurement.internal.zzgt r1 = r11.zzaV()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r1.zza(r2)     // Catch:{ all -> 0x002c }
            r11.zzaK()     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0087:
            com.google.android.gms.common.util.Clock r1 = r11.zzaZ()     // Catch:{ all -> 0x002c }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzal r5 = r11.zzd()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzfw r6 = com.google.android.gms.measurement.internal.zzfx.zzai     // Catch:{ all -> 0x002c }
            r7 = 0
            int r5 = r5.zzm(r7, r6)     // Catch:{ all -> 0x002c }
            r11.zzd()     // Catch:{ all -> 0x002c }
            long r8 = com.google.android.gms.measurement.internal.zzal.zzF()     // Catch:{ all -> 0x002c }
            long r8 = r1 - r8
            r6 = 0
        L_0x00a4:
            if (r6 >= r5) goto L_0x00af
            boolean r10 = r11.zzaF(r7, r8)     // Catch:{ all -> 0x002c }
            if (r10 == 0) goto L_0x00af
            int r6 = r6 + 1
            goto L_0x00a4
        L_0x00af:
            com.google.android.gms.internal.measurement.zzql.zza()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzhy r5 = r11.zzaW()     // Catch:{ all -> 0x002c }
            r5.zzg()     // Catch:{ all -> 0x002c }
            r11.zzau()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zznm r5 = r11.zzk     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzhd r5 = r5.zzd     // Catch:{ all -> 0x002c }
            long r5 = r5.zza()     // Catch:{ all -> 0x002c }
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 == 0) goto L_0x00df
            com.google.android.gms.measurement.internal.zzgt r3 = r11.zzaV()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzj()     // Catch:{ all -> 0x002c }
            java.lang.String r4 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r5 = r1 - r5
            long r5 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x002c }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x002c }
            r3.zzb(r4, r5)     // Catch:{ all -> 0x002c }
        L_0x00df:
            com.google.android.gms.measurement.internal.zzav r3 = r11.zzj()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = r3.zzF()     // Catch:{ all -> 0x002c }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x002c }
            r5 = -1
            if (r4 != 0) goto L_0x0135
            long r8 = r11.zzB     // Catch:{ all -> 0x002c }
            int r4 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0130
            com.google.android.gms.measurement.internal.zzav r4 = r11.zzj()     // Catch:{ all -> 0x002c }
            android.database.sqlite.SQLiteDatabase r8 = r4.zze()     // Catch:{ SQLiteException -> 0x0114 }
            java.lang.String r9 = "select rowid from raw_events order by rowid desc limit 1;"
            android.database.Cursor r7 = r8.rawQuery(r9, r7)     // Catch:{ SQLiteException -> 0x0114 }
            boolean r8 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0114 }
            if (r8 != 0) goto L_0x010d
        L_0x0109:
            r7.close()     // Catch:{ all -> 0x002c }
            goto L_0x0127
        L_0x010d:
            long r5 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0114 }
            goto L_0x0109
        L_0x0112:
            r1 = move-exception
            goto L_0x012a
        L_0x0114:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzib r4 = r4.zzu     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()     // Catch:{ all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x0112 }
            java.lang.String r9 = "Error querying raw events"
            r4.zzb(r9, r8)     // Catch:{ all -> 0x0112 }
            if (r7 == 0) goto L_0x0127
            goto L_0x0109
        L_0x0127:
            r11.zzB = r5     // Catch:{ all -> 0x002c }
            goto L_0x0130
        L_0x012a:
            if (r7 == 0) goto L_0x012f
            r7.close()     // Catch:{ all -> 0x002c }
        L_0x012f:
            throw r1     // Catch:{ all -> 0x002c }
        L_0x0130:
            r11.zzN(r3, r1)     // Catch:{ all -> 0x002c }
            goto L_0x01aa
        L_0x0135:
            r11.zzB = r5     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzav r3 = r11.zzj()     // Catch:{ all -> 0x002c }
            r11.zzd()     // Catch:{ all -> 0x002c }
            long r4 = com.google.android.gms.measurement.internal.zzal.zzF()     // Catch:{ all -> 0x002c }
            long r1 = r1 - r4
            r3.zzg()     // Catch:{ all -> 0x002c }
            r3.zzay()     // Catch:{ all -> 0x002c }
            android.database.sqlite.SQLiteDatabase r4 = r3.zze()     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            java.lang.String r5 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            java.lang.String[] r1 = new java.lang.String[]{r1}     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            android.database.Cursor r1 = r4.rawQuery(r5, r1)     // Catch:{ SQLiteException -> 0x0182, all -> 0x017f }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0176 }
            if (r2 != 0) goto L_0x0178
            com.google.android.gms.measurement.internal.zzib r2 = r3.zzu     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ SQLiteException -> 0x0176 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()     // Catch:{ SQLiteException -> 0x0176 }
            java.lang.String r4 = "No expired configs for apps with pending events"
            r2.zza(r4)     // Catch:{ SQLiteException -> 0x0176 }
        L_0x0170:
            r1.close()     // Catch:{ all -> 0x002c }
            goto L_0x0197
        L_0x0174:
            r2 = move-exception
            goto L_0x017d
        L_0x0176:
            r2 = move-exception
            goto L_0x0185
        L_0x0178:
            java.lang.String r7 = r1.getString(r0)     // Catch:{ SQLiteException -> 0x0176 }
            goto L_0x0170
        L_0x017d:
            r7 = r1
            goto L_0x01b0
        L_0x017f:
            r1 = move-exception
            r2 = r1
            goto L_0x01b0
        L_0x0182:
            r1 = move-exception
            r2 = r1
            r1 = r7
        L_0x0185:
            com.google.android.gms.measurement.internal.zzib r3 = r3.zzu     // Catch:{ all -> 0x0174 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x0174 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x0174 }
            java.lang.String r4 = "Error selecting expired configs"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x0174 }
            if (r1 == 0) goto L_0x0197
            goto L_0x0170
        L_0x0197:
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x01aa
            com.google.android.gms.measurement.internal.zzav r1 = r11.zzj()     // Catch:{ all -> 0x002c }
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzu(r7)     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x01aa
            r11.zzV(r1)     // Catch:{ all -> 0x002c }
        L_0x01aa:
            r11.zzw = r0
            r11.zzaL()
            return
        L_0x01b0:
            if (r7 == 0) goto L_0x01b5
            r7.close()     // Catch:{ all -> 0x002c }
        L_0x01b5:
            throw r2     // Catch:{ all -> 0x002c }
        L_0x01b6:
            r11.zzw = r0
            r11.zzaL()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzM():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:164:0x042a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x042c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0447, code lost:
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x051d, code lost:
        r13.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01f7, code lost:
        if (r10 != null) goto L_0x006b;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0317 A[SYNTHETIC, Splitter:B:128:0x0317] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x042a A[ExcHandler: all (th java.lang.Throwable), Splitter:B:140:0x037a] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0464  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0472  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x051d  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0536  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x05b0  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x05b2  */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x05db  */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x06fe  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0743  */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0757  */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x098a  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x09d8  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x0277 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:416:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:418:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:419:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0203  */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzN(java.lang.String r32, long r33) {
        /*
            r31 = this;
            r8 = r31
            r9 = r32
            r1 = r33
            java.lang.String r3 = "data"
            com.google.android.gms.measurement.internal.zzal r0 = r31.zzd()
            com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.zzg
            int r0 = r0.zzm(r9, r4)
            com.google.android.gms.measurement.internal.zzal r4 = r31.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzh
            int r4 = r4.zzm(r9, r5)
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            com.google.android.gms.measurement.internal.zzav r6 = r31.zzj()
            r6.zzg()
            r6.zzay()
            r7 = 1
            if (r0 <= 0) goto L_0x0030
            r10 = 1
            goto L_0x0031
        L_0x0030:
            r10 = 0
        L_0x0031:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)
            if (r4 <= 0) goto L_0x0038
            r10 = 1
            goto L_0x0039
        L_0x0038:
            r10 = 0
        L_0x0039:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r10)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            android.database.sqlite.SQLiteDatabase r14 = r6.zze()     // Catch:{ SQLiteException -> 0x01da, all -> 0x01d8 }
            java.lang.String r15 = "queue"
            java.lang.String r10 = "rowid"
            java.lang.String r11 = "retry_count"
            java.lang.String[] r16 = new java.lang.String[]{r10, r3, r11}     // Catch:{ SQLiteException -> 0x01da, all -> 0x01d8 }
            java.lang.String r17 = "app_id=?"
            java.lang.String[] r18 = new java.lang.String[]{r32}     // Catch:{ SQLiteException -> 0x01da, all -> 0x01d8 }
            java.lang.String r21 = "rowid"
            java.lang.String r22 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x01da, all -> 0x01d8 }
            r19 = 0
            r20 = 0
            android.database.Cursor r10 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x01da, all -> 0x01d8 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0074 }
            if (r0 != 0) goto L_0x0077
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0074 }
        L_0x006b:
            r10.close()
        L_0x006e:
            r11 = r0
            goto L_0x01fb
        L_0x0071:
            r0 = move-exception
            goto L_0x01d5
        L_0x0074:
            r0 = move-exception
            goto L_0x01e0
        L_0x0077:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0074 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x0074 }
            r14 = 0
        L_0x007d:
            long r15 = r10.getLong(r5)     // Catch:{ SQLiteException -> 0x0074 }
            byte[] r0 = r10.getBlob(r7)     // Catch:{ IOException -> 0x01ae }
            com.google.android.gms.measurement.internal.zzpf r7 = r6.zzg     // Catch:{ IOException -> 0x01ae }
            com.google.android.gms.measurement.internal.zzpj r7 = r7.zzp()     // Catch:{ IOException -> 0x01ae }
            java.io.ByteArrayInputStream r13 = new java.io.ByteArrayInputStream     // Catch:{ IOException -> 0x0196 }
            r13.<init>(r0)     // Catch:{ IOException -> 0x0196 }
            java.util.zip.GZIPInputStream r0 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x0196 }
            r0.<init>(r13)     // Catch:{ IOException -> 0x0196 }
            java.io.ByteArrayOutputStream r12 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0196 }
            r12.<init>()     // Catch:{ IOException -> 0x0196 }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0196 }
        L_0x009e:
            int r1 = r0.read(r5)     // Catch:{ IOException -> 0x0196 }
            if (r1 > 0) goto L_0x0198
            r0.close()     // Catch:{ IOException -> 0x0196 }
            r13.close()     // Catch:{ IOException -> 0x0196 }
            byte[] r0 = r12.toByteArray()     // Catch:{ IOException -> 0x0196 }
            boolean r1 = r11.isEmpty()     // Catch:{ SQLiteException -> 0x0074 }
            if (r1 != 0) goto L_0x00ba
            int r1 = r0.length     // Catch:{ SQLiteException -> 0x0074 }
            int r1 = r1 + r14
            if (r1 <= r4) goto L_0x00ba
            goto L_0x01d1
        L_0x00ba:
            com.google.android.gms.internal.measurement.zzic r1 = com.google.android.gms.internal.measurement.zzid.zzaE()     // Catch:{ IOException -> 0x0181 }
            com.google.android.gms.internal.measurement.zznk r1 = com.google.android.gms.measurement.internal.zzpj.zzw(r1, r0)     // Catch:{ IOException -> 0x0181 }
            com.google.android.gms.internal.measurement.zzic r1 = (com.google.android.gms.internal.measurement.zzic) r1     // Catch:{ IOException -> 0x0181 }
            boolean r2 = r11.isEmpty()     // Catch:{ SQLiteException -> 0x0074 }
            if (r2 != 0) goto L_0x015f
            r2 = 0
            java.lang.Object r5 = r11.get(r2)     // Catch:{ SQLiteException -> 0x0074 }
            android.util.Pair r5 = (android.util.Pair) r5     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.Object r2 = r5.first     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.internal.measurement.zzid r2 = (com.google.android.gms.internal.measurement.zzid) r2     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.internal.measurement.zzme r5 = r1.zzbc()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.internal.measurement.zzid r5 = (com.google.android.gms.internal.measurement.zzid) r5     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r7 = r2.zzaf()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r12 = r5.zzaf()     // Catch:{ SQLiteException -> 0x0074 }
            boolean r7 = r7.equals(r12)     // Catch:{ SQLiteException -> 0x0074 }
            if (r7 == 0) goto L_0x01d1
            java.lang.String r7 = r2.zzam()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r12 = r5.zzam()     // Catch:{ SQLiteException -> 0x0074 }
            boolean r7 = r7.equals(r12)     // Catch:{ SQLiteException -> 0x0074 }
            if (r7 == 0) goto L_0x01d1
            boolean r7 = r2.zzao()     // Catch:{ SQLiteException -> 0x0074 }
            boolean r12 = r5.zzao()     // Catch:{ SQLiteException -> 0x0074 }
            if (r7 != r12) goto L_0x01d1
            java.lang.String r7 = r2.zzaq()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r12 = r5.zzaq()     // Catch:{ SQLiteException -> 0x0074 }
            boolean r7 = r7.equals(r12)     // Catch:{ SQLiteException -> 0x0074 }
            if (r7 == 0) goto L_0x01d1
            java.util.List r2 = r2.zzf()     // Catch:{ SQLiteException -> 0x0074 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ SQLiteException -> 0x0074 }
        L_0x0117:
            boolean r7 = r2.hasNext()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r12 = "_npa"
            if (r7 == 0) goto L_0x0134
            java.lang.Object r7 = r2.next()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.internal.measurement.zziu r7 = (com.google.android.gms.internal.measurement.zziu) r7     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r13 = r7.zzc()     // Catch:{ SQLiteException -> 0x0074 }
            boolean r13 = r12.equals(r13)     // Catch:{ SQLiteException -> 0x0074 }
            if (r13 == 0) goto L_0x0117
            long r21 = r7.zzg()     // Catch:{ SQLiteException -> 0x0074 }
            goto L_0x0136
        L_0x0134:
            r21 = -1
        L_0x0136:
            java.util.List r2 = r5.zzf()     // Catch:{ SQLiteException -> 0x0074 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ SQLiteException -> 0x0074 }
        L_0x013e:
            boolean r5 = r2.hasNext()     // Catch:{ SQLiteException -> 0x0074 }
            if (r5 == 0) goto L_0x0159
            java.lang.Object r5 = r2.next()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.internal.measurement.zziu r5 = (com.google.android.gms.internal.measurement.zziu) r5     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r7 = r5.zzc()     // Catch:{ SQLiteException -> 0x0074 }
            boolean r7 = r12.equals(r7)     // Catch:{ SQLiteException -> 0x0074 }
            if (r7 == 0) goto L_0x013e
            long r12 = r5.zzg()     // Catch:{ SQLiteException -> 0x0074 }
            goto L_0x015b
        L_0x0159:
            r12 = -1
        L_0x015b:
            int r2 = (r21 > r12 ? 1 : (r21 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x01d1
        L_0x015f:
            r2 = 2
            boolean r5 = r10.isNull(r2)     // Catch:{ SQLiteException -> 0x0074 }
            if (r5 != 0) goto L_0x016d
            int r5 = r10.getInt(r2)     // Catch:{ SQLiteException -> 0x0074 }
            r1.zzao(r5)     // Catch:{ SQLiteException -> 0x0074 }
        L_0x016d:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x0074 }
            int r14 = r14 + r0
            com.google.android.gms.internal.measurement.zzme r0 = r1.zzbc()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.internal.measurement.zzid r0 = (com.google.android.gms.internal.measurement.zzid) r0     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.Long r1 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteException -> 0x0074 }
            android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch:{ SQLiteException -> 0x0074 }
            r11.add(r0)     // Catch:{ SQLiteException -> 0x0074 }
            goto L_0x01c2
        L_0x0181:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r1 = r6.zzu     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r2 = "Failed to merge queued bundle. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r32)     // Catch:{ SQLiteException -> 0x0074 }
            r1.zzc(r2, r5, r0)     // Catch:{ SQLiteException -> 0x0074 }
            goto L_0x01c2
        L_0x0196:
            r0 = move-exception
            goto L_0x019e
        L_0x0198:
            r2 = 0
            r12.write(r5, r2, r1)     // Catch:{ IOException -> 0x0196 }
            goto L_0x009e
        L_0x019e:
            com.google.android.gms.measurement.internal.zzib r1 = r7.zzu     // Catch:{ IOException -> 0x01ae }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ IOException -> 0x01ae }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()     // Catch:{ IOException -> 0x01ae }
            java.lang.String r2 = "Failed to ungzip content"
            r1.zzb(r2, r0)     // Catch:{ IOException -> 0x01ae }
            throw r0     // Catch:{ IOException -> 0x01ae }
        L_0x01ae:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r1 = r6.zzu     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r2 = "Failed to unzip queued bundle. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r32)     // Catch:{ SQLiteException -> 0x0074 }
            r1.zzc(r2, r5, r0)     // Catch:{ SQLiteException -> 0x0074 }
        L_0x01c2:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0074 }
            if (r0 == 0) goto L_0x01d1
            if (r14 <= r4) goto L_0x01cb
            goto L_0x01d1
        L_0x01cb:
            r1 = r33
            r5 = 0
            r7 = 1
            goto L_0x007d
        L_0x01d1:
            r10.close()
            goto L_0x01fb
        L_0x01d5:
            r13 = r10
            goto L_0x09d6
        L_0x01d8:
            r0 = move-exception
            goto L_0x01dc
        L_0x01da:
            r0 = move-exception
            goto L_0x01df
        L_0x01dc:
            r13 = 0
            goto L_0x09d6
        L_0x01df:
            r10 = 0
        L_0x01e0:
            com.google.android.gms.measurement.internal.zzib r1 = r6.zzu     // Catch:{ all -> 0x0071 }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ all -> 0x0071 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()     // Catch:{ all -> 0x0071 }
            java.lang.String r2 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r32)     // Catch:{ all -> 0x0071 }
            r1.zzc(r2, r4, r0)     // Catch:{ all -> 0x0071 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0071 }
            if (r10 == 0) goto L_0x006e
            goto L_0x006b
        L_0x01fb:
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x0203
            goto L_0x09d5
        L_0x0203:
            com.google.android.gms.internal.measurement.zzpk.zza()
            com.google.android.gms.measurement.internal.zzal r0 = r31.zzd()
            com.google.android.gms.measurement.internal.zzfw r1 = com.google.android.gms.measurement.internal.zzfx.zzbi
            r2 = 0
            boolean r0 = r0.zzp(r2, r1)
            java.lang.String r4 = "_f"
            if (r0 == 0) goto L_0x0528
            com.google.android.gms.internal.measurement.zzpk.zza()
            com.google.android.gms.measurement.internal.zzal r0 = r31.zzd()
            boolean r0 = r0.zzp(r2, r1)
            if (r0 == 0) goto L_0x0357
            com.google.android.gms.measurement.internal.zzjk r0 = r31.zzB(r32)
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r0 = r0.zzo(r1)
            java.lang.String r1 = "no_data_mode_events"
            if (r0 != 0) goto L_0x035b
            com.google.android.gms.measurement.internal.zzhs r0 = r31.zzh()
            boolean r0 = r0.zzB(r9)
            if (r0 == 0) goto L_0x035b
            com.google.android.gms.measurement.internal.zzfw r0 = com.google.android.gms.measurement.internal.zzfx.zzbj
            java.lang.Object r0 = r0.zzb(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = ","
            java.lang.String[] r0 = r0.split(r2)
            java.util.List r2 = java.util.Arrays.asList(r0)
            java.util.Iterator r5 = r11.iterator()
        L_0x0250:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0353
            java.lang.Object r0 = r5.next()
            android.util.Pair r0 = (android.util.Pair) r0
            com.google.android.gms.measurement.internal.zzav r6 = r31.zzj()     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.Object r7 = r0.second     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ SQLiteException -> 0x02a4 }
            long r10 = r7.longValue()     // Catch:{ SQLiteException -> 0x02a4 }
            r6.zzH(r10)     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.Object r0 = r0.first     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.internal.measurement.zzid r0 = (com.google.android.gms.internal.measurement.zzid) r0     // Catch:{ SQLiteException -> 0x02a4 }
            java.util.List r0 = r0.zzc()     // Catch:{ SQLiteException -> 0x02a4 }
            java.util.Iterator r6 = r0.iterator()     // Catch:{ SQLiteException -> 0x02a4 }
        L_0x0277:
            boolean r0 = r6.hasNext()     // Catch:{ SQLiteException -> 0x02a4 }
            if (r0 == 0) goto L_0x0250
            java.lang.Object r0 = r6.next()     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.internal.measurement.zzhs r0 = (com.google.android.gms.internal.measurement.zzhs) r0     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.String r7 = r0.zzd()     // Catch:{ SQLiteException -> 0x02a4 }
            boolean r7 = r2.contains(r7)     // Catch:{ SQLiteException -> 0x02a4 }
            if (r7 == 0) goto L_0x0277
            java.lang.String r7 = r0.zzd()     // Catch:{ SQLiteException -> 0x02a4 }
            boolean r7 = r7.equals(r4)     // Catch:{ SQLiteException -> 0x02a4 }
            if (r7 != 0) goto L_0x02a8
            java.lang.String r7 = r0.zzd()     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.String r10 = "_v"
            boolean r7 = r7.equals(r10)     // Catch:{ SQLiteException -> 0x02a4 }
            if (r7 == 0) goto L_0x02c2
            goto L_0x02a8
        L_0x02a4:
            r11 = -1
            goto L_0x0344
        L_0x02a8:
            com.google.android.gms.internal.measurement.zzma r0 = r0.zzcl()     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.internal.measurement.zzhr r0 = (com.google.android.gms.internal.measurement.zzhr) r0     // Catch:{ SQLiteException -> 0x02a4 }
            r31.zzp()     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.String r7 = "_dac"
            r10 = 1
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.measurement.internal.zzpj.zzC(r0, r7, r10)     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.internal.measurement.zzme r0 = r0.zzbc()     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.internal.measurement.zzhs r0 = (com.google.android.gms.internal.measurement.zzhs) r0     // Catch:{ SQLiteException -> 0x02a4 }
        L_0x02c2:
            com.google.android.gms.measurement.internal.zzav r7 = r31.zzj()     // Catch:{ SQLiteException -> 0x02a4 }
            r7.zzg()     // Catch:{ SQLiteException -> 0x02a4 }
            r7.zzay()     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.measurement.internal.zzib r10 = r7.zzu     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.measurement.internal.zzgt r11 = r10.zzaV()     // Catch:{ SQLiteException -> 0x02a4 }
            com.google.android.gms.measurement.internal.zzgr r11 = r11.zzk()     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.String r12 = "Caching events in NO_DATA mode"
            r11.zzb(r12, r0)     // Catch:{ SQLiteException -> 0x02a4 }
            android.content.ContentValues r11 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x02a4 }
            r11.<init>()     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.String r12 = "app_id"
            r11.put(r12, r9)     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.String r12 = "name"
            java.lang.String r13 = r0.zzd()     // Catch:{ SQLiteException -> 0x02a4 }
            r11.put(r12, r13)     // Catch:{ SQLiteException -> 0x02a4 }
            byte[] r12 = r0.zzcc()     // Catch:{ SQLiteException -> 0x02a4 }
            r11.put(r3, r12)     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.String r12 = "timestamp_millis"
            long r13 = r0.zzf()     // Catch:{ SQLiteException -> 0x02a4 }
            java.lang.Long r0 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteException -> 0x02a4 }
            r11.put(r12, r0)     // Catch:{ SQLiteException -> 0x02a4 }
            android.database.sqlite.SQLiteDatabase r0 = r7.zze()     // Catch:{ SQLiteException -> 0x032c }
            r12 = 0
            long r13 = r0.insert(r1, r12, r11)     // Catch:{ SQLiteException -> 0x032c }
            r11 = -1
            int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x0277
            com.google.android.gms.measurement.internal.zzgt r0 = r10.zzaV()     // Catch:{ SQLiteException -> 0x032a }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x032a }
            java.lang.String r10 = "Failed to insert NO_DATA mode event (got -1). appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzgt.zzl(r32)     // Catch:{ SQLiteException -> 0x032a }
            r0.zzb(r10, r13)     // Catch:{ SQLiteException -> 0x032a }
            goto L_0x0277
        L_0x032a:
            r0 = move-exception
            goto L_0x032f
        L_0x032c:
            r0 = move-exception
            r11 = -1
        L_0x032f:
            com.google.android.gms.measurement.internal.zzib r7 = r7.zzu     // Catch:{ SQLiteException -> 0x0344 }
            com.google.android.gms.measurement.internal.zzgt r7 = r7.zzaV()     // Catch:{ SQLiteException -> 0x0344 }
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzb()     // Catch:{ SQLiteException -> 0x0344 }
            java.lang.String r10 = "Error storing NO_DATA mode event. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzgt.zzl(r32)     // Catch:{ SQLiteException -> 0x0344 }
            r7.zzc(r10, r13, r0)     // Catch:{ SQLiteException -> 0x0344 }
            goto L_0x0277
        L_0x0344:
            com.google.android.gms.measurement.internal.zzgt r0 = r31.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzh()
            java.lang.String r6 = "Failed handling NO_DATA mode bundles. appId"
            r0.zzb(r6, r9)
            goto L_0x0250
        L_0x0353:
            java.util.List r11 = java.util.Collections.emptyList()
        L_0x0357:
            r21 = r4
            goto L_0x0521
        L_0x035b:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r0 = r11.size()
            r2.<init>(r0)
            com.google.android.gms.measurement.internal.zzav r5 = r31.zzj()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            r5.zzg()
            r5.zzay()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.lang.String r7 = " NO_DATA mode events. appId"
            java.lang.String r10 = "Pruned "
            android.database.sqlite.SQLiteDatabase r12 = r5.zze()     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            com.google.android.gms.measurement.internal.zzib r0 = r5.zzu     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            com.google.android.gms.common.util.Clock r0 = r0.zzaZ()     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            long r13 = r0.currentTimeMillis()     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            java.lang.String r22 = "no_data_mode_events"
            java.lang.String[] r23 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            java.lang.String r24 = "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)"
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            java.lang.String[] r25 = new java.lang.String[]{r9, r0}     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            java.lang.String r28 = "rowid"
            r29 = 0
            r26 = 0
            r27 = 0
            r21 = r12
            android.database.Cursor r3 = r21.query(r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ SQLiteException -> 0x0443, all -> 0x042a }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x03cc }
            if (r0 == 0) goto L_0x0436
        L_0x03ac:
            r15 = 0
            byte[] r0 = r3.getBlob(r15)     // Catch:{ zzmq -> 0x03d1 }
            com.google.android.gms.internal.measurement.zzhr r15 = com.google.android.gms.internal.measurement.zzhs.zzk()     // Catch:{ zzmq -> 0x03d1 }
            com.google.android.gms.internal.measurement.zznk r0 = com.google.android.gms.measurement.internal.zzpj.zzw(r15, r0)     // Catch:{ zzmq -> 0x03d1 }
            com.google.android.gms.internal.measurement.zzhr r0 = (com.google.android.gms.internal.measurement.zzhr) r0     // Catch:{ zzmq -> 0x03d1 }
            com.google.android.gms.internal.measurement.zzme r0 = r0.zzbc()     // Catch:{ zzmq -> 0x03d1 }
            com.google.android.gms.internal.measurement.zzhs r0 = (com.google.android.gms.internal.measurement.zzhs) r0     // Catch:{ zzmq -> 0x03d1 }
            r6.add(r0)     // Catch:{ zzmq -> 0x03d1 }
            r21 = r4
            r16 = r6
            goto L_0x03e9
        L_0x03c9:
            r0 = move-exception
            goto L_0x0440
        L_0x03cc:
            r0 = move-exception
            r21 = r4
            goto L_0x044b
        L_0x03d1:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r15 = r5.zzu     // Catch:{ SQLiteException -> 0x03cc }
            com.google.android.gms.measurement.internal.zzgt r15 = r15.zzaV()     // Catch:{ SQLiteException -> 0x03cc }
            com.google.android.gms.measurement.internal.zzgr r15 = r15.zzh()     // Catch:{ SQLiteException -> 0x03cc }
            r16 = r6
            java.lang.String r6 = "Failed to parse stored NO_DATA mode event, appId"
            r21 = r4
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r32)     // Catch:{ SQLiteException -> 0x042e }
            r15.zzc(r6, r4, r0)     // Catch:{ SQLiteException -> 0x042e }
        L_0x03e9:
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x042e }
            if (r0 != 0) goto L_0x0430
            r3.close()     // Catch:{ SQLiteException -> 0x042e }
            java.lang.String r0 = "app_id=? AND timestamp_millis <= CAST(? AS INTEGER)"
            java.lang.String r3 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            java.lang.String[] r3 = new java.lang.String[]{r9, r3}     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            int r0 = r12.delete(r1, r0, r3)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            com.google.android.gms.measurement.internal.zzib r1 = r5.zzu     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            int r3 = r3.length()     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            int r3 = r3 + 34
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            r4.<init>(r3)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            r4.append(r10)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            r4.append(r0)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            r4.append(r7)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            java.lang.String r0 = r4.toString()     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            r1.zzb(r0, r9)     // Catch:{ SQLiteException -> 0x042c, all -> 0x042a }
            goto L_0x043d
        L_0x042a:
            r0 = move-exception
            goto L_0x0447
        L_0x042c:
            r0 = move-exception
            goto L_0x044a
        L_0x042e:
            r0 = move-exception
            goto L_0x044b
        L_0x0430:
            r6 = r16
            r4 = r21
            goto L_0x03ac
        L_0x0436:
            r21 = r4
            r16 = r6
            r3.close()
        L_0x043d:
            r6 = r16
            goto L_0x0467
        L_0x0440:
            r13 = r3
            goto L_0x051b
        L_0x0443:
            r0 = move-exception
            r21 = r4
            goto L_0x044a
        L_0x0447:
            r13 = 0
            goto L_0x051b
        L_0x044a:
            r3 = 0
        L_0x044b:
            com.google.android.gms.measurement.internal.zzib r1 = r5.zzu     // Catch:{ all -> 0x03c9 }
            com.google.android.gms.measurement.internal.zzgt r1 = r1.zzaV()     // Catch:{ all -> 0x03c9 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzb()     // Catch:{ all -> 0x03c9 }
            java.lang.String r4 = "Error flushing NO_DATA mode events. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r32)     // Catch:{ all -> 0x03c9 }
            r1.zzc(r4, r5, r0)     // Catch:{ all -> 0x03c9 }
            java.util.List r6 = java.util.Collections.emptyList()     // Catch:{ all -> 0x03c9 }
            if (r3 == 0) goto L_0x0467
            r3.close()
        L_0x0467:
            java.util.Iterator r0 = r11.iterator()
            r1 = 1
        L_0x046c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0519
            java.lang.Object r3 = r0.next()
            android.util.Pair r3 = (android.util.Pair) r3
            java.lang.Object r4 = r3.first
            com.google.android.gms.internal.measurement.zzid r4 = (com.google.android.gms.internal.measurement.zzid) r4
            com.google.android.gms.internal.measurement.zzma r4 = r4.zzcl()
            com.google.android.gms.internal.measurement.zzic r4 = (com.google.android.gms.internal.measurement.zzic) r4
            if (r1 == 0) goto L_0x0498
            boolean r5 = r6.isEmpty()
            if (r5 != 0) goto L_0x0498
            java.util.List r1 = r4.zzb()
            r4.zzi()
            r4.zzh(r6)
            r4.zzh(r1)
            r1 = 0
        L_0x0498:
            com.google.android.gms.internal.measurement.zzhh r5 = com.google.android.gms.internal.measurement.zzho.zzb()
            com.google.android.gms.measurement.internal.zzhs r7 = r31.zzh()
            com.google.android.gms.internal.measurement.zzgf r7 = r7.zzx(r9)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            if (r7 != 0) goto L_0x04ac
            goto L_0x0500
        L_0x04ac:
            java.util.List r7 = r7.zza()
            java.util.Iterator r7 = r7.iterator()
        L_0x04b4:
            boolean r11 = r7.hasNext()
            if (r11 == 0) goto L_0x0500
            java.lang.Object r11 = r7.next()
            com.google.android.gms.internal.measurement.zzfu r11 = (com.google.android.gms.internal.measurement.zzfu) r11
            com.google.android.gms.internal.measurement.zzhk r12 = com.google.android.gms.internal.measurement.zzhl.zza()
            int r13 = r11.zzb()
            com.google.android.gms.measurement.internal.zzjh r14 = com.google.android.gms.measurement.internal.zzjh.UNINITIALIZED
            int r13 = r13 + -1
            r14 = 3
            r15 = 1
            if (r13 == r15) goto L_0x04e0
            r15 = 2
            if (r13 == r15) goto L_0x04de
            r15 = 4
            if (r13 == r14) goto L_0x04dc
            if (r13 == r15) goto L_0x04da
            r13 = 1
            goto L_0x04e1
        L_0x04da:
            r13 = 5
            goto L_0x04e1
        L_0x04dc:
            r13 = 4
            goto L_0x04e1
        L_0x04de:
            r13 = 3
            goto L_0x04e1
        L_0x04e0:
            r13 = 2
        L_0x04e1:
            r12.zza(r13)
            int r11 = r11.zzd()
            int r11 = r11 + -1
            r13 = 1
            if (r11 == r13) goto L_0x04f2
            r13 = 2
            if (r11 == r13) goto L_0x04f3
            r14 = 1
            goto L_0x04f3
        L_0x04f2:
            r14 = 2
        L_0x04f3:
            r12.zzb(r14)
            com.google.android.gms.internal.measurement.zzme r11 = r12.zzbc()
            com.google.android.gms.internal.measurement.zzhl r11 = (com.google.android.gms.internal.measurement.zzhl) r11
            r10.add(r11)
            goto L_0x04b4
        L_0x0500:
            r5.zza(r10)
            r4.zzaQ(r5)
            com.google.android.gms.internal.measurement.zzme r4 = r4.zzbc()
            com.google.android.gms.internal.measurement.zzid r4 = (com.google.android.gms.internal.measurement.zzid) r4
            java.lang.Object r3 = r3.second
            java.lang.Long r3 = (java.lang.Long) r3
            android.util.Pair r3 = android.util.Pair.create(r4, r3)
            r2.add(r3)
            goto L_0x046c
        L_0x0519:
            r11 = r2
            goto L_0x0521
        L_0x051b:
            if (r13 == 0) goto L_0x0520
            r13.close()
        L_0x0520:
            throw r0
        L_0x0521:
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x09d5
            goto L_0x052a
        L_0x0528:
            r21 = r4
        L_0x052a:
            com.google.android.gms.measurement.internal.zzjk r0 = r31.zzB(r32)
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE
            boolean r0 = r0.zzo(r1)
            if (r0 == 0) goto L_0x058b
            java.util.Iterator r0 = r11.iterator()
        L_0x053a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0559
            java.lang.Object r2 = r0.next()
            android.util.Pair r2 = (android.util.Pair) r2
            java.lang.Object r2 = r2.first
            com.google.android.gms.internal.measurement.zzid r2 = (com.google.android.gms.internal.measurement.zzid) r2
            java.lang.String r3 = r2.zzG()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x053a
            java.lang.String r0 = r2.zzG()
            goto L_0x055a
        L_0x0559:
            r0 = 0
        L_0x055a:
            if (r0 == 0) goto L_0x058b
            r2 = 0
        L_0x055d:
            int r3 = r11.size()
            if (r2 >= r3) goto L_0x058b
            java.lang.Object r3 = r11.get(r2)
            android.util.Pair r3 = (android.util.Pair) r3
            java.lang.Object r3 = r3.first
            com.google.android.gms.internal.measurement.zzid r3 = (com.google.android.gms.internal.measurement.zzid) r3
            java.lang.String r4 = r3.zzG()
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0579
        L_0x0577:
            r3 = 1
            goto L_0x0589
        L_0x0579:
            java.lang.String r3 = r3.zzG()
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0577
            r3 = 0
            java.util.List r11 = r11.subList(r3, r2)
            goto L_0x058b
        L_0x0589:
            int r2 = r2 + r3
            goto L_0x055d
        L_0x058b:
            com.google.android.gms.internal.measurement.zzhz r0 = com.google.android.gms.internal.measurement.zzib.zzh()
            int r2 = r11.size()
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r11.size()
            r3.<init>(r4)
            com.google.android.gms.measurement.internal.zzal r4 = r31.zzd()
            boolean r4 = r4.zzC(r9)
            if (r4 == 0) goto L_0x05b2
            com.google.android.gms.measurement.internal.zzjk r4 = r31.zzB(r32)
            boolean r4 = r4.zzo(r1)
            if (r4 == 0) goto L_0x05b2
            r4 = 1
            goto L_0x05b3
        L_0x05b2:
            r4 = 0
        L_0x05b3:
            com.google.android.gms.measurement.internal.zzjk r5 = r31.zzB(r32)
            boolean r1 = r5.zzo(r1)
            com.google.android.gms.measurement.internal.zzjk r5 = r31.zzB(r32)
            com.google.android.gms.measurement.internal.zzjj r6 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r5 = r5.zzo(r6)
            com.google.android.gms.internal.measurement.zzqu.zza()
            com.google.android.gms.measurement.internal.zzal r6 = r31.zzd()
            com.google.android.gms.measurement.internal.zzfw r7 = com.google.android.gms.measurement.internal.zzfx.zzaM
            boolean r6 = r6.zzp(r9, r7)
            com.google.android.gms.measurement.internal.zzot r7 = r8.zzl
            com.google.android.gms.measurement.internal.zzos r10 = r7.zza(r9)
            r12 = 0
        L_0x05d9:
            if (r12 >= r2) goto L_0x073d
            java.lang.Object r13 = r11.get(r12)
            android.util.Pair r13 = (android.util.Pair) r13
            java.lang.Object r13 = r13.first
            com.google.android.gms.internal.measurement.zzid r13 = (com.google.android.gms.internal.measurement.zzid) r13
            com.google.android.gms.internal.measurement.zzma r13 = r13.zzcl()
            com.google.android.gms.internal.measurement.zzic r13 = (com.google.android.gms.internal.measurement.zzic) r13
            java.lang.Object r14 = r11.get(r12)
            android.util.Pair r14 = (android.util.Pair) r14
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            r3.add(r14)
            com.google.android.gms.measurement.internal.zzal r14 = r31.zzd()
            r14.zzi()
            r14 = 130000(0x1fbd0, double:6.42285E-319)
            r13.zzO(r14)
            r14 = r33
            r13.zzs(r14)
            r16 = r2
            com.google.android.gms.measurement.internal.zzib r2 = r8.zzn
            r2.zzaU()
            r2 = 0
            r13.zzae(r2)
            if (r4 != 0) goto L_0x061a
            r13.zzan()
        L_0x061a:
            if (r1 != 0) goto L_0x0622
            r13.zzR()
            r13.zzU()
        L_0x0622:
            if (r5 != 0) goto L_0x0627
            r13.zzX()
        L_0x0627:
            r8.zzS(r9, r13)
            if (r6 != 0) goto L_0x062f
            r13.zzav()
        L_0x062f:
            if (r5 != 0) goto L_0x0634
            r13.zzag()
        L_0x0634:
            java.lang.String r2 = r13.zzP()
            boolean r22 = android.text.TextUtils.isEmpty(r2)
            if (r22 != 0) goto L_0x0655
            r22 = r1
            java.lang.String r1 = "00000000-0000-0000-0000-000000000000"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0649
            goto L_0x0657
        L_0x0649:
            r25 = r4
            r26 = r5
            r28 = r6
            r27 = r11
            r14 = r21
            goto L_0x06f6
        L_0x0655:
            r22 = r1
        L_0x0657:
            java.util.ArrayList r1 = new java.util.ArrayList
            java.util.List r2 = r13.zzb()
            r1.<init>(r2)
            java.util.Iterator r2 = r1.iterator()
            r25 = r4
            r26 = r5
            r4 = 0
            r5 = 0
            r23 = 0
            r24 = 0
        L_0x066e:
            boolean r27 = r2.hasNext()
            if (r27 == 0) goto L_0x06de
            java.lang.Object r27 = r2.next()
            r28 = r6
            r6 = r27
            com.google.android.gms.internal.measurement.zzhs r6 = (com.google.android.gms.internal.measurement.zzhs) r6
            r27 = r11
            java.lang.String r11 = r6.zzd()
            java.lang.String r14 = "_fx"
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x069a
            r2.remove()
            r14 = r33
            r11 = r27
            r6 = r28
            r23 = 1
            r24 = 1
            goto L_0x066e
        L_0x069a:
            java.lang.String r11 = r6.zzd()
            r14 = r21
            boolean r11 = r14.equals(r11)
            if (r11 == 0) goto L_0x06d7
            r31.zzp()
            java.lang.String r11 = "_pfo"
            com.google.android.gms.internal.measurement.zzhw r11 = com.google.android.gms.measurement.internal.zzpj.zzF(r6, r11)
            if (r11 == 0) goto L_0x06b9
            long r29 = r11.zzf()
            java.lang.Long r4 = java.lang.Long.valueOf(r29)
        L_0x06b9:
            r31.zzp()
            java.lang.String r11 = "_uwa"
            com.google.android.gms.internal.measurement.zzhw r6 = com.google.android.gms.measurement.internal.zzpj.zzF(r6, r11)
            if (r6 == 0) goto L_0x06cc
            long r5 = r6.zzf()
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
        L_0x06cc:
            r21 = r14
            r11 = r27
            r6 = r28
            r24 = 1
        L_0x06d4:
            r14 = r33
            goto L_0x066e
        L_0x06d7:
            r21 = r14
            r11 = r27
            r6 = r28
            goto L_0x06d4
        L_0x06de:
            r28 = r6
            r27 = r11
            r14 = r21
            if (r23 == 0) goto L_0x06ec
            r13.zzi()
            r13.zzh(r1)
        L_0x06ec:
            if (r24 == 0) goto L_0x06f6
            java.lang.String r1 = r13.zzK()
            r2 = 1
            r8.zzR(r1, r2, r4, r5)
        L_0x06f6:
            int r1 = r13.zzc()
            if (r1 != 0) goto L_0x06fe
        L_0x06fc:
            r1 = 1
            goto L_0x072c
        L_0x06fe:
            com.google.android.gms.measurement.internal.zzal r1 = r31.zzd()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzaC
            boolean r1 = r1.zzp(r9, r2)
            if (r1 == 0) goto L_0x071f
            com.google.android.gms.internal.measurement.zzme r1 = r13.zzbc()
            com.google.android.gms.internal.measurement.zzid r1 = (com.google.android.gms.internal.measurement.zzid) r1
            byte[] r1 = r1.zzcc()
            com.google.android.gms.measurement.internal.zzpj r2 = r31.zzp()
            long r1 = r2.zzt(r1)
            r13.zzas(r1)
        L_0x071f:
            com.google.android.gms.internal.measurement.zzis r1 = r10.zzd()
            if (r1 == 0) goto L_0x0728
            r13.zzaN(r1)
        L_0x0728:
            r0.zze(r13)
            goto L_0x06fc
        L_0x072c:
            int r12 = r12 + r1
            r21 = r14
            r2 = r16
            r1 = r22
            r4 = r25
            r5 = r26
            r11 = r27
            r6 = r28
            goto L_0x05d9
        L_0x073d:
            int r1 = r0.zzb()
            if (r1 != 0) goto L_0x0757
            r8.zzL(r3)
            r5 = 0
            java.util.List r7 = java.util.Collections.emptyList()
            r2 = 0
            r3 = 204(0xcc, float:2.86E-43)
            r4 = 0
            r1 = r31
            r6 = r32
            r1.zzU(r2, r3, r4, r5, r6, r7)
            return
        L_0x0757:
            com.google.android.gms.internal.measurement.zzme r1 = r0.zzbc()
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            com.google.android.gms.measurement.internal.zzlr r2 = r10.zzc()
            com.google.android.gms.measurement.internal.zzlr r4 = com.google.android.gms.measurement.internal.zzlr.SGTM_CLIENT
            if (r2 != r4) goto L_0x076c
            r2 = 1
            goto L_0x076d
        L_0x076c:
            r2 = 0
        L_0x076d:
            com.google.android.gms.measurement.internal.zzlr r4 = r10.zzc()
            com.google.android.gms.measurement.internal.zzlr r5 = com.google.android.gms.measurement.internal.zzlr.SGTM
            if (r4 == r5) goto L_0x077e
            if (r2 == 0) goto L_0x0779
            r2 = 1
            goto L_0x077e
        L_0x0779:
            r6 = r33
            r12 = 0
            goto L_0x0980
        L_0x077e:
            com.google.android.gms.internal.measurement.zzme r1 = r0.zzbc()
            com.google.android.gms.internal.measurement.zzib r1 = (com.google.android.gms.internal.measurement.zzib) r1
            java.util.List r1 = r1.zza()
            java.util.Iterator r1 = r1.iterator()
        L_0x078c:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x07a7
            java.lang.Object r4 = r1.next()
            com.google.android.gms.internal.measurement.zzid r4 = (com.google.android.gms.internal.measurement.zzid) r4
            boolean r4 = r4.zzY()
            if (r4 == 0) goto L_0x078c
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            goto L_0x07a8
        L_0x07a7:
            r1 = 0
        L_0x07a8:
            com.google.android.gms.internal.measurement.zzme r4 = r0.zzbc()
            com.google.android.gms.internal.measurement.zzib r4 = (com.google.android.gms.internal.measurement.zzib) r4
            com.google.android.gms.measurement.internal.zzhy r5 = r31.zzaW()
            r5.zzg()
            r31.zzu()
            com.google.android.gms.internal.measurement.zzhz r5 = com.google.android.gms.internal.measurement.zzib.zzi(r4)
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 != 0) goto L_0x07c5
            r5.zzi(r1)
        L_0x07c5:
            com.google.android.gms.measurement.internal.zzhs r6 = r31.zzh()
            java.lang.String r6 = r6.zzc(r9)
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 != 0) goto L_0x07d6
            r5.zzj(r6)
        L_0x07d6:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r4 = r4.zza()
            java.util.Iterator r4 = r4.iterator()
        L_0x07e3:
            boolean r12 = r4.hasNext()
            if (r12 == 0) goto L_0x0800
            java.lang.Object r12 = r4.next()
            com.google.android.gms.internal.measurement.zzid r12 = (com.google.android.gms.internal.measurement.zzid) r12
            com.google.android.gms.internal.measurement.zzic r12 = com.google.android.gms.internal.measurement.zzid.zzaF(r12)
            r12.zzan()
            com.google.android.gms.internal.measurement.zzme r12 = r12.zzbc()
            com.google.android.gms.internal.measurement.zzid r12 = (com.google.android.gms.internal.measurement.zzid) r12
            r6.add(r12)
            goto L_0x07e3
        L_0x0800:
            r5.zzg()
            r5.zzf(r6)
            com.google.android.gms.measurement.internal.zzgt r4 = r31.zzaV()
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzk()
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L_0x0817
            java.lang.String r6 = "null"
            goto L_0x081b
        L_0x0817:
            java.lang.String r6 = r5.zzh()
        L_0x081b:
            java.lang.String r12 = "[sgtm] Processed MeasurementBatch for sGTM with sgtmJoinId: "
            r4.zzb(r12, r6)
            com.google.android.gms.internal.measurement.zzme r4 = r5.zzbc()
            com.google.android.gms.internal.measurement.zzib r4 = (com.google.android.gms.internal.measurement.zzib) r4
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x090a
            com.google.android.gms.internal.measurement.zzme r0 = r0.zzbc()
            com.google.android.gms.internal.measurement.zzib r0 = (com.google.android.gms.internal.measurement.zzib) r0
            com.google.android.gms.measurement.internal.zzhy r5 = r31.zzaW()
            r5.zzg()
            r31.zzu()
            com.google.android.gms.internal.measurement.zzhz r5 = com.google.android.gms.internal.measurement.zzib.zzh()
            com.google.android.gms.measurement.internal.zzgt r6 = r31.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzk()
            java.lang.String r12 = "[sgtm] Processing Google Signal, sgtmJoinId:"
            r6.zzb(r12, r1)
            r5.zzi(r1)
            java.util.List r0 = r0.zza()
            java.util.Iterator r0 = r0.iterator()
        L_0x0858:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x087a
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzid r1 = (com.google.android.gms.internal.measurement.zzid) r1
            com.google.android.gms.internal.measurement.zzic r6 = com.google.android.gms.internal.measurement.zzid.zzaE()
            java.lang.String r12 = r1.zzZ()
            r6.zzam(r12)
            int r1 = r1.zzav()
            r6.zzaJ(r1)
            r5.zze(r6)
            goto L_0x0858
        L_0x087a:
            com.google.android.gms.internal.measurement.zzme r0 = r5.zzbc()
            com.google.android.gms.internal.measurement.zzib r0 = (com.google.android.gms.internal.measurement.zzib) r0
            com.google.android.gms.measurement.internal.zzpf r1 = r7.zzg
            com.google.android.gms.measurement.internal.zzhs r1 = r1.zzh()
            java.lang.String r1 = r1.zzc(r9)
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L_0x08e9
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzr
            r6 = 0
            java.lang.Object r5 = r5.zzb(r6)
            java.lang.String r5 = (java.lang.String) r5
            android.net.Uri r5 = android.net.Uri.parse(r5)
            android.net.Uri$Builder r6 = r5.buildUpon()
            java.lang.String r5 = r5.getAuthority()
            java.lang.String r7 = java.lang.String.valueOf(r1)
            int r7 = r7.length()
            java.lang.String r12 = java.lang.String.valueOf(r5)
            r13 = 1
            int r7 = r7 + r13
            int r12 = r12.length()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            int r7 = r7 + r12
            r13.<init>(r7)
            r13.append(r1)
            java.lang.String r1 = "."
            r13.append(r1)
            r13.append(r5)
            java.lang.String r1 = r13.toString()
            r6.authority(r1)
            com.google.android.gms.measurement.internal.zzos r1 = new com.google.android.gms.measurement.internal.zzos
            android.net.Uri r5 = r6.build()
            java.lang.String r5 = r5.toString()
            if (r2 == 0) goto L_0x08de
            com.google.android.gms.measurement.internal.zzlr r6 = com.google.android.gms.measurement.internal.zzlr.GOOGLE_SIGNAL_PENDING
            goto L_0x08e0
        L_0x08de:
            com.google.android.gms.measurement.internal.zzlr r6 = com.google.android.gms.measurement.internal.zzlr.GOOGLE_SIGNAL
        L_0x08e0:
            java.util.Map r7 = java.util.Collections.emptyMap()
            r12 = 0
            r1.<init>(r5, r7, r6, r12)
            goto L_0x0902
        L_0x08e9:
            r12 = 0
            com.google.android.gms.measurement.internal.zzos r1 = new com.google.android.gms.measurement.internal.zzos
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzr
            java.lang.Object r5 = r5.zzb(r12)
            java.lang.String r5 = (java.lang.String) r5
            if (r2 == 0) goto L_0x08f9
            com.google.android.gms.measurement.internal.zzlr r6 = com.google.android.gms.measurement.internal.zzlr.GOOGLE_SIGNAL_PENDING
            goto L_0x08fb
        L_0x08f9:
            com.google.android.gms.measurement.internal.zzlr r6 = com.google.android.gms.measurement.internal.zzlr.GOOGLE_SIGNAL
        L_0x08fb:
            java.util.Map r7 = java.util.Collections.emptyMap()
            r1.<init>(r5, r7, r6, r12)
        L_0x0902:
            android.util.Pair r0 = android.util.Pair.create(r0, r1)
            r11.add(r0)
            goto L_0x090b
        L_0x090a:
            r12 = 0
        L_0x090b:
            if (r2 == 0) goto L_0x097d
            com.google.android.gms.internal.measurement.zzma r0 = r4.zzcl()
            com.google.android.gms.internal.measurement.zzhz r0 = (com.google.android.gms.internal.measurement.zzhz) r0
            r5 = 0
        L_0x0914:
            int r1 = r4.zzb()
            if (r5 >= r1) goto L_0x0932
            com.google.android.gms.internal.measurement.zzid r1 = r4.zzc(r5)
            com.google.android.gms.internal.measurement.zzma r1 = r1.zzcl()
            com.google.android.gms.internal.measurement.zzic r1 = (com.google.android.gms.internal.measurement.zzic) r1
            r1.zzt()
            r6 = r33
            r1.zzaO(r6)
            r0.zzd(r5, r1)
            r1 = 1
            int r5 = r5 + r1
            goto L_0x0914
        L_0x0932:
            com.google.android.gms.internal.measurement.zzme r0 = r0.zzbc()
            com.google.android.gms.internal.measurement.zzib r0 = (com.google.android.gms.internal.measurement.zzib) r0
            android.util.Pair r0 = android.util.Pair.create(r0, r10)
            r11.add(r0)
            r8.zzL(r3)
            r4 = 0
            r5 = 0
            r2 = 0
            r3 = 204(0xcc, float:2.86E-43)
            r1 = r31
            r6 = r32
            r7 = r11
            r1.zzU(r2, r3, r4, r5, r6, r7)
            java.lang.String r0 = r10.zza()
            boolean r0 = r8.zzO(r9, r0)
            if (r0 == 0) goto L_0x09d5
            com.google.android.gms.measurement.internal.zzgt r0 = r31.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()
            java.lang.String r1 = "[sgtm] Sending sgtm batches available notification to app"
            r0.zzb(r1, r9)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "com.google.android.gms.measurement.BATCHES_AVAILABLE"
            r0.setAction(r1)
            r0.setPackage(r9)
            com.google.android.gms.measurement.internal.zzib r1 = r8.zzn
            android.content.Context r1 = r1.zzaY()
            zzaP(r1, r0)
            return
        L_0x097d:
            r6 = r33
            r1 = r4
        L_0x0980:
            com.google.android.gms.measurement.internal.zzgy r0 = r31.zzi()
            boolean r0 = r0.zzb()
            if (r0 == 0) goto L_0x09d5
            com.google.android.gms.measurement.internal.zzgt r0 = r31.zzaV()
            java.lang.String r0 = r0.zzn()
            r2 = 2
            boolean r0 = android.util.Log.isLoggable(r0, r2)
            if (r0 == 0) goto L_0x09a2
            com.google.android.gms.measurement.internal.zzpj r0 = r31.zzp()
            java.lang.String r13 = r0.zzi(r1)
            goto L_0x09a3
        L_0x09a2:
            r13 = r12
        L_0x09a3:
            r31.zzp()
            byte[] r0 = r1.zzcc()
            r8.zzL(r3)
            com.google.android.gms.measurement.internal.zznm r2 = r8.zzk
            com.google.android.gms.measurement.internal.zzhd r2 = r2.zze
            r2.zzb(r6)
            com.google.android.gms.measurement.internal.zzgt r2 = r31.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r3 = "Uploading data. app, uncompressed size, data"
            r2.zzd(r3, r9, r0, r13)
            r2 = 1
            r8.zzv = r2
            com.google.android.gms.measurement.internal.zzgy r0 = r31.zzi()
            com.google.android.gms.measurement.internal.zzov r2 = new com.google.android.gms.measurement.internal.zzov
            r2.<init>(r8, r9, r11)
            r0.zzc(r9, r10, r1, r2)
        L_0x09d5:
            return
        L_0x09d6:
            if (r13 == 0) goto L_0x09db
            r13.close()
        L_0x09db:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzN(java.lang.String, long):void");
    }

    @VisibleForTesting
    @WorkerThread
    public final boolean zzO(String str, String str2) {
        zzh zzu2 = zzj().zzu(str);
        if (zzu2 == null || !zzt().zzaa(str, zzu2.zzay())) {
            zzpd zzpd = (zzpd) this.zzF.get(str2);
            if (zzpd == null) {
                return true;
            }
            return zzpd.zzb();
        }
        this.zzF.remove(str2);
        return true;
    }

    @WorkerThread
    public final void zzP(String str) {
        zzpi zzpi;
        zzib zzd2;
        zzaW().zzg();
        zzu();
        this.zzw = true;
        try {
            zzib zzib = this.zzn;
            zzib.zzaU();
            Boolean zzJ2 = zzib.zzt().zzJ();
            if (zzJ2 == null) {
                zzaV().zze().zza("Upload data called on the client side before use of service was decided");
            } else if (zzJ2.booleanValue()) {
                zzaV().zzb().zza("Upload called in the client side when service should be used");
            } else if (this.zza > 0) {
                zzaK();
            } else if (!zzi().zzb()) {
                zzaV().zzk().zza("Network not connected, ignoring upload request");
                zzaK();
            } else if (!zzj().zzD(str)) {
                zzaV().zzk().zzb("[sgtm] Upload queue has no batches for appId", str);
            } else {
                zzav zzj2 = zzj();
                Preconditions.checkNotEmpty(str);
                zzj2.zzg();
                zzj2.zzay();
                List zzC2 = zzj2.zzC(str, zzon.zza(zzlr.GOOGLE_SIGNAL), 1);
                if (zzC2.isEmpty()) {
                    zzpi = null;
                } else {
                    zzpi = (zzpi) zzC2.get(0);
                }
                if (!(zzpi == null || (zzd2 = zzpi.zzd()) == null)) {
                    zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, type, url", str, zzpi.zzf(), zzpi.zze());
                    byte[] zzcc = zzd2.zzcc();
                    if (Log.isLoggable(zzaV().zzn(), 2)) {
                        zzaV().zzk().zzd("[sgtm] Uploading data from upload queue. appId, uncompressed size, data", str, Integer.valueOf(zzcc.length), zzp().zzi(zzd2));
                    }
                    zzos zza2 = zzpi.zza();
                    this.zzv = true;
                    zzi().zzc(str, zza2, zzd2, new zzow(this, str, zzpi));
                }
            }
        } finally {
            this.zzw = false;
            zzaL();
        }
    }

    /* JADX WARNING: type inference failed for: r7v4, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0080 A[Catch:{ all -> 0x0010 }] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzQ(@androidx.annotation.NonNull java.lang.String r4, int r5, java.lang.Throwable r6, byte[] r7, com.google.android.gms.measurement.internal.zzpi r8) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.zzhy r0 = r3.zzaW()
            r0.zzg()
            r3.zzu()
            r0 = 0
            if (r7 != 0) goto L_0x0013
            byte[] r7 = new byte[r0]     // Catch:{ all -> 0x0010 }
            goto L_0x0013
        L_0x0010:
            r4 = move-exception
            goto L_0x009c
        L_0x0013:
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 == r1) goto L_0x001d
            r1 = 204(0xcc, float:2.86E-43)
            if (r5 != r1) goto L_0x005b
            r5 = 204(0xcc, float:2.86E-43)
        L_0x001d:
            if (r6 != 0) goto L_0x005b
            com.google.android.gms.measurement.internal.zzav r6 = r3.zzj()     // Catch:{ all -> 0x0010 }
            long r7 = r8.zzc()     // Catch:{ all -> 0x0010 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0010 }
            r6.zzE(r7)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgt r6 = r3.zzaV()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzk()     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0010 }
            r6.zzc(r7, r4, r5)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgy r5 = r3.zzi()     // Catch:{ all -> 0x0010 }
            boolean r5 = r5.zzb()     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x0057
            com.google.android.gms.measurement.internal.zzav r5 = r3.zzj()     // Catch:{ all -> 0x0010 }
            boolean r5 = r5.zzD(r4)     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x0057
            r3.zzP(r4)     // Catch:{ all -> 0x0010 }
            goto L_0x0096
        L_0x0057:
            r3.zzaK()     // Catch:{ all -> 0x0010 }
            goto L_0x0096
        L_0x005b:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0010 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0010 }
            r1.<init>(r7, r2)     // Catch:{ all -> 0x0010 }
            int r7 = r1.length()     // Catch:{ all -> 0x0010 }
            r2 = 32
            int r7 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = r1.substring(r0, r7)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgt r1 = r3.zzaV()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzh()     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0010 }
            if (r6 != 0) goto L_0x0081
            r6 = r7
        L_0x0081:
            r1.zzd(r2, r4, r5, r6)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.zzav r4 = r3.zzj()     // Catch:{ all -> 0x0010 }
            long r5 = r8.zzc()     // Catch:{ all -> 0x0010 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0010 }
            r4.zzK(r5)     // Catch:{ all -> 0x0010 }
            r3.zzaK()     // Catch:{ all -> 0x0010 }
        L_0x0096:
            r3.zzv = r0
            r3.zzaL()
            return
        L_0x009c:
            r3.zzv = r0
            r3.zzaL()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzQ(java.lang.String, int, java.lang.Throwable, byte[], com.google.android.gms.measurement.internal.zzpi):void");
    }

    @WorkerThread
    public final void zzR(String str, boolean z, Long l, Long l2) {
        zzh zzu2 = zzj().zzu(str);
        if (zzu2 != null) {
            zzu2.zzar(z);
            zzu2.zzat(l);
            zzu2.zzav(l2);
            if (zzu2.zza()) {
                zzj().zzv(zzu2, false, false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        if ((zzd().zzl(r8, com.google.android.gms.measurement.internal.zzfx.zzak) + r1.zzb) < zzaZ().elapsedRealtime()) goto L_0x009d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzS(java.lang.String r8, com.google.android.gms.internal.measurement.zzic r9) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzhs r0 = r7.zzh()
            java.util.Set r0 = r0.zzl(r8)
            if (r0 == 0) goto L_0x000d
            r9.zzaw(r0)
        L_0x000d:
            com.google.android.gms.measurement.internal.zzhs r0 = r7.zzh()
            boolean r0 = r0.zzp(r8)
            if (r0 == 0) goto L_0x001a
            r9.zzG()
        L_0x001a:
            com.google.android.gms.measurement.internal.zzhs r0 = r7.zzh()
            boolean r0 = r0.zzq(r8)
            r1 = -1
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r9.zzD()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x003f
            java.lang.String r2 = "."
            int r2 = r0.indexOf(r2)
            if (r2 == r1) goto L_0x003f
            r3 = 0
            java.lang.String r0 = r0.substring(r3, r2)
            r9.zzE(r0)
        L_0x003f:
            com.google.android.gms.measurement.internal.zzhs r0 = r7.zzh()
            boolean r0 = r0.zzr(r8)
            if (r0 == 0) goto L_0x0054
            java.lang.String r0 = "_id"
            int r0 = com.google.android.gms.measurement.internal.zzpj.zzx(r9, r0)
            if (r0 == r1) goto L_0x0054
            r9.zzr(r0)
        L_0x0054:
            com.google.android.gms.measurement.internal.zzhs r0 = r7.zzh()
            boolean r0 = r0.zzs(r8)
            if (r0 == 0) goto L_0x0061
            r9.zzan()
        L_0x0061:
            com.google.android.gms.measurement.internal.zzhs r0 = r7.zzh()
            boolean r0 = r0.zzt(r8)
            if (r0 == 0) goto L_0x00ab
            r9.zzX()
            com.google.android.gms.measurement.internal.zzjk r0 = r7.zzB(r8)
            com.google.android.gms.measurement.internal.zzjj r1 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r0 = r0.zzo(r1)
            if (r0 == 0) goto L_0x00ab
            java.util.Map r0 = r7.zzE
            java.lang.Object r1 = r0.get(r8)
            com.google.android.gms.measurement.internal.zzpc r1 = (com.google.android.gms.measurement.internal.zzpc) r1
            if (r1 == 0) goto L_0x009d
            long r2 = r1.zzb
            com.google.android.gms.measurement.internal.zzal r4 = r7.zzd()
            com.google.android.gms.measurement.internal.zzfw r5 = com.google.android.gms.measurement.internal.zzfx.zzak
            long r4 = r4.zzl(r8, r5)
            long r4 = r4 + r2
            com.google.android.gms.common.util.Clock r2 = r7.zzaZ()
            long r2 = r2.elapsedRealtime()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 >= 0) goto L_0x00a6
        L_0x009d:
            com.google.android.gms.measurement.internal.zzpc r1 = new com.google.android.gms.measurement.internal.zzpc
            r2 = 0
            r1.<init>((com.google.android.gms.measurement.internal.zzpf) r7, (byte[]) r2)
            r0.put(r8, r1)
        L_0x00a6:
            java.lang.String r0 = r1.zza
            r9.zzax(r0)
        L_0x00ab:
            com.google.android.gms.measurement.internal.zzhs r0 = r7.zzh()
            boolean r8 = r0.zzu(r8)
            if (r8 == 0) goto L_0x00b8
            r9.zzav()
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzS(java.lang.String, com.google.android.gms.internal.measurement.zzic):void");
    }

    @VisibleForTesting
    public final void zzT(String str, zzhv zzhv, Bundle bundle, String str2) {
        int zzf2;
        List listOf = CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"});
        if (zzpo.zzZ(zzhv.zza()) || zzpo.zzZ(str)) {
            zzf2 = zzd().zzf(str2, true);
        } else {
            zzf2 = zzd().zze(str2, true);
        }
        long j = (long) zzf2;
        long codePointCount = (long) zzhv.zzc().codePointCount(0, zzhv.zzc().length());
        zzpo zzt2 = zzt();
        String zza2 = zzhv.zza();
        zzd();
        String zzC2 = zzt2.zzC(zza2, 40, true);
        if (codePointCount > j && !listOf.contains(zzhv.zza())) {
            if ("_ev".equals(zzhv.zza())) {
                bundle.putString("_ev", zzt().zzC(zzhv.zzc(), zzd().zzf(str2, true), true));
                return;
            }
            zzaV().zzh().zzc("Param value is too long; discarded. Name, value length", zzC2, Long.valueOf(codePointCount));
            if (bundle.getLong("_err") == 0) {
                bundle.putLong("_err", 4);
                if (bundle.getString("_ev") == null) {
                    bundle.putString("_ev", zzC2);
                    bundle.putLong("_el", codePointCount);
                }
            }
            bundle.remove(zzhv.zza());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r2 != null) goto L_0x0038;
     */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzU(boolean r22, int r23, java.lang.Throwable r24, byte[] r25, java.lang.String r26, java.util.List r27) {
        /*
            r21 = this;
            r1 = r21
            r0 = r23
            r2 = r24
            r9 = r26
            r10 = 1
            com.google.android.gms.measurement.internal.zzhy r3 = r21.zzaW()
            r3.zzg()
            r21.zzu()
            r11 = 0
            if (r25 != 0) goto L_0x001c
            byte[] r3 = new byte[r11]     // Catch:{ all -> 0x0019 }
            goto L_0x001e
        L_0x0019:
            r0 = move-exception
            goto L_0x0299
        L_0x001c:
            r3 = r25
        L_0x001e:
            java.util.List r4 = r1.zzz     // Catch:{ all -> 0x0019 }
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x0019 }
            r12 = r4
            java.util.List r12 = (java.util.List) r12     // Catch:{ all -> 0x0019 }
            r13 = 0
            r1.zzz = r13     // Catch:{ all -> 0x0019 }
            if (r22 == 0) goto L_0x0090
            r4 = 200(0xc8, float:2.8E-43)
            if (r0 == r4) goto L_0x0036
            r4 = 204(0xcc, float:2.86E-43)
            if (r0 != r4) goto L_0x0038
            r0 = 204(0xcc, float:2.86E-43)
        L_0x0036:
            if (r2 == 0) goto L_0x0090
        L_0x0038:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0019 }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0019 }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0019 }
            int r3 = r4.length()     // Catch:{ all -> 0x0019 }
            r5 = 32
            int r3 = java.lang.Math.min(r5, r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = r4.substring(r11, r3)     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzgt r4 = r21.zzaV()     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzh()     // Catch:{ all -> 0x0019 }
            java.lang.String r5 = "Network upload failed. Will retry later. code, error"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0019 }
            r4.zzd(r5, r6, r2, r3)     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zznm r2 = r1.zzk     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzhd r2 = r2.zze     // Catch:{ all -> 0x0019 }
            com.google.android.gms.common.util.Clock r3 = r21.zzaZ()     // Catch:{ all -> 0x0019 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0019 }
            r2.zzb(r3)     // Catch:{ all -> 0x0019 }
            r2 = 503(0x1f7, float:7.05E-43)
            if (r0 == r2) goto L_0x0075
            r2 = 429(0x1ad, float:6.01E-43)
            if (r0 != r2) goto L_0x0084
        L_0x0075:
            com.google.android.gms.measurement.internal.zznm r0 = r1.zzk     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzhd r0 = r0.zzc     // Catch:{ all -> 0x0019 }
            com.google.android.gms.common.util.Clock r2 = r21.zzaZ()     // Catch:{ all -> 0x0019 }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x0019 }
            r0.zzb(r2)     // Catch:{ all -> 0x0019 }
        L_0x0084:
            com.google.android.gms.measurement.internal.zzav r0 = r21.zzj()     // Catch:{ all -> 0x0019 }
            r0.zzJ(r12)     // Catch:{ all -> 0x0019 }
            r21.zzaK()     // Catch:{ all -> 0x0019 }
            goto L_0x0293
        L_0x0090:
            com.google.android.gms.measurement.internal.zzgt r2 = r21.zzaV()     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()     // Catch:{ all -> 0x0019 }
            java.lang.String r4 = "Network upload successful with code, uploadAttempted"
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0019 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r22)     // Catch:{ all -> 0x0019 }
            r2.zzc(r4, r0, r5)     // Catch:{ all -> 0x0019 }
            if (r22 == 0) goto L_0x00ba
            com.google.android.gms.measurement.internal.zznm r2 = r1.zzk     // Catch:{ SQLiteException -> 0x00b7 }
            com.google.android.gms.measurement.internal.zzhd r2 = r2.zzd     // Catch:{ SQLiteException -> 0x00b7 }
            com.google.android.gms.common.util.Clock r4 = r21.zzaZ()     // Catch:{ SQLiteException -> 0x00b7 }
            long r4 = r4.currentTimeMillis()     // Catch:{ SQLiteException -> 0x00b7 }
            r2.zzb(r4)     // Catch:{ SQLiteException -> 0x00b7 }
            goto L_0x00ba
        L_0x00b7:
            r0 = move-exception
            goto L_0x0269
        L_0x00ba:
            com.google.android.gms.measurement.internal.zznm r2 = r1.zzk     // Catch:{ SQLiteException -> 0x00b7 }
            com.google.android.gms.measurement.internal.zzhd r2 = r2.zze     // Catch:{ SQLiteException -> 0x00b7 }
            r14 = 0
            r2.zzb(r14)     // Catch:{ SQLiteException -> 0x00b7 }
            r21.zzaK()     // Catch:{ SQLiteException -> 0x00b7 }
            if (r22 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzgt r2 = r21.zzaV()     // Catch:{ SQLiteException -> 0x00b7 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzk()     // Catch:{ SQLiteException -> 0x00b7 }
            java.lang.String r4 = "Successful upload. Got network response. code, size"
            int r3 = r3.length     // Catch:{ SQLiteException -> 0x00b7 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00b7 }
            r2.zzc(r4, r0, r3)     // Catch:{ SQLiteException -> 0x00b7 }
            goto L_0x00e8
        L_0x00db:
            com.google.android.gms.measurement.internal.zzgt r0 = r21.zzaV()     // Catch:{ SQLiteException -> 0x00b7 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x00b7 }
            java.lang.String r2 = "Purged empty bundles"
            r0.zza(r2)     // Catch:{ SQLiteException -> 0x00b7 }
        L_0x00e8:
            com.google.android.gms.measurement.internal.zzav r0 = r21.zzj()     // Catch:{ SQLiteException -> 0x00b7 }
            r0.zzb()     // Catch:{ SQLiteException -> 0x00b7 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x015d }
            r0.<init>()     // Catch:{ all -> 0x015d }
            java.util.Iterator r16 = r27.iterator()     // Catch:{ all -> 0x015d }
        L_0x00f8:
            boolean r2 = r16.hasNext()     // Catch:{ all -> 0x015d }
            r7 = -1
            if (r2 == 0) goto L_0x0160
            java.lang.Object r2 = r16.next()     // Catch:{ all -> 0x015d }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x015d }
            java.lang.Object r3 = r2.first     // Catch:{ all -> 0x015d }
            r17 = r3
            com.google.android.gms.internal.measurement.zzib r17 = (com.google.android.gms.internal.measurement.zzib) r17     // Catch:{ all -> 0x015d }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x015d }
            r18 = r2
            com.google.android.gms.measurement.internal.zzos r18 = (com.google.android.gms.measurement.internal.zzos) r18     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r2 = r18.zzc()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r3 = com.google.android.gms.measurement.internal.zzlr.SGTM_CLIENT     // Catch:{ all -> 0x015d }
            if (r2 == r3) goto L_0x00f8
            com.google.android.gms.measurement.internal.zzav r2 = r21.zzj()     // Catch:{ all -> 0x015d }
            java.lang.String r5 = r18.zza()     // Catch:{ all -> 0x015d }
            java.util.Map r6 = r18.zzb()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r19 = r18.zzc()     // Catch:{ all -> 0x015d }
            r20 = 0
            r3 = r26
            r4 = r17
            r14 = r7
            r7 = r19
            r8 = r20
            long r2 = r2.zzA(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r4 = r18.zzc()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r5 = com.google.android.gms.measurement.internal.zzlr.GOOGLE_SIGNAL_PENDING     // Catch:{ all -> 0x015d }
            if (r4 != r5) goto L_0x015a
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 == 0) goto L_0x015a
            java.lang.String r4 = r17.zze()     // Catch:{ all -> 0x015d }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x015d }
            if (r4 != 0) goto L_0x015a
            java.lang.String r4 = r17.zze()     // Catch:{ all -> 0x015d }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x015d }
            r0.put(r4, r2)     // Catch:{ all -> 0x015d }
        L_0x015a:
            r14 = 0
            goto L_0x00f8
        L_0x015d:
            r0 = move-exception
            goto L_0x0261
        L_0x0160:
            r14 = r7
            java.util.Iterator r16 = r27.iterator()     // Catch:{ all -> 0x015d }
        L_0x0165:
            boolean r2 = r16.hasNext()     // Catch:{ all -> 0x015d }
            if (r2 == 0) goto L_0x01a4
            java.lang.Object r2 = r16.next()     // Catch:{ all -> 0x015d }
            android.util.Pair r2 = (android.util.Pair) r2     // Catch:{ all -> 0x015d }
            java.lang.Object r3 = r2.first     // Catch:{ all -> 0x015d }
            r4 = r3
            com.google.android.gms.internal.measurement.zzib r4 = (com.google.android.gms.internal.measurement.zzib) r4     // Catch:{ all -> 0x015d }
            java.lang.Object r2 = r2.second     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzos r2 = (com.google.android.gms.measurement.internal.zzos) r2     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r3 = r2.zzc()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r5 = com.google.android.gms.measurement.internal.zzlr.SGTM_CLIENT     // Catch:{ all -> 0x015d }
            if (r3 != r5) goto L_0x0165
            java.lang.String r3 = r4.zze()     // Catch:{ all -> 0x015d }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x015d }
            r8 = r3
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzav r3 = r21.zzj()     // Catch:{ all -> 0x015d }
            java.lang.String r5 = r2.zza()     // Catch:{ all -> 0x015d }
            java.util.Map r6 = r2.zzb()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r7 = r2.zzc()     // Catch:{ all -> 0x015d }
            r2 = r3
            r3 = r26
            r2.zzA(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x015d }
            goto L_0x0165
        L_0x01a4:
            com.google.android.gms.measurement.internal.zzav r0 = r21.zzj()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr[] r2 = new com.google.android.gms.measurement.internal.zzlr[r10]     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzlr r3 = com.google.android.gms.measurement.internal.zzlr.SGTM_CLIENT     // Catch:{ all -> 0x015d }
            r2[r11] = r3     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzon r2 = com.google.android.gms.measurement.internal.zzon.zza(r2)     // Catch:{ all -> 0x015d }
            java.util.List r0 = r0.zzC(r9, r2, r10)     // Catch:{ all -> 0x015d }
            boolean r2 = r0.isEmpty()     // Catch:{ all -> 0x015d }
            if (r2 != 0) goto L_0x01f0
            java.lang.Object r0 = r0.get(r11)     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzpi r0 = (com.google.android.gms.measurement.internal.zzpi) r0     // Catch:{ all -> 0x015d }
            long r2 = r0.zzg()     // Catch:{ all -> 0x015d }
            com.google.android.gms.common.util.Clock r0 = r21.zzaZ()     // Catch:{ all -> 0x015d }
            long r4 = r0.currentTimeMillis()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzfw r0 = com.google.android.gms.measurement.internal.zzfx.zzE     // Catch:{ all -> 0x015d }
            java.lang.Object r0 = r0.zzb(r13)     // Catch:{ all -> 0x015d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x015d }
            long r6 = r0.longValue()     // Catch:{ all -> 0x015d }
            long r6 = r6 + r2
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzgt r0 = r21.zzaV()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ all -> 0x015d }
            java.lang.String r4 = "[sgtm] client batches are queued too long. appId, creationTime"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x015d }
            r0.zzc(r4, r9, r2)     // Catch:{ all -> 0x015d }
        L_0x01f0:
            java.util.Iterator r2 = r12.iterator()     // Catch:{ all -> 0x015d }
        L_0x01f4:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x015d }
            if (r0 == 0) goto L_0x021a
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x015d }
            r3 = r0
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzav r0 = r21.zzj()     // Catch:{ SQLiteException -> 0x020d }
            long r4 = r3.longValue()     // Catch:{ SQLiteException -> 0x020d }
            r0.zzH(r4)     // Catch:{ SQLiteException -> 0x020d }
            goto L_0x01f4
        L_0x020d:
            r0 = move-exception
            java.util.List r4 = r1.zzA     // Catch:{ all -> 0x015d }
            if (r4 == 0) goto L_0x0219
            boolean r3 = r4.contains(r3)     // Catch:{ all -> 0x015d }
            if (r3 == 0) goto L_0x0219
            goto L_0x01f4
        L_0x0219:
            throw r0     // Catch:{ all -> 0x015d }
        L_0x021a:
            com.google.android.gms.measurement.internal.zzav r0 = r21.zzj()     // Catch:{ all -> 0x015d }
            r0.zzc()     // Catch:{ all -> 0x015d }
            com.google.android.gms.measurement.internal.zzav r0 = r21.zzj()     // Catch:{ SQLiteException -> 0x00b7 }
            r0.zzd()     // Catch:{ SQLiteException -> 0x00b7 }
            r1.zzA = r13     // Catch:{ SQLiteException -> 0x00b7 }
            com.google.android.gms.measurement.internal.zzgy r0 = r21.zzi()     // Catch:{ SQLiteException -> 0x00b7 }
            boolean r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x00b7 }
            if (r0 == 0) goto L_0x0244
            com.google.android.gms.measurement.internal.zzav r0 = r21.zzj()     // Catch:{ SQLiteException -> 0x00b7 }
            boolean r0 = r0.zzD(r9)     // Catch:{ SQLiteException -> 0x00b7 }
            if (r0 == 0) goto L_0x0244
            r1.zzP(r9)     // Catch:{ SQLiteException -> 0x00b7 }
        L_0x0241:
            r2 = 0
            goto L_0x025e
        L_0x0244:
            com.google.android.gms.measurement.internal.zzgy r0 = r21.zzi()     // Catch:{ SQLiteException -> 0x00b7 }
            boolean r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x00b7 }
            if (r0 == 0) goto L_0x0258
            boolean r0 = r21.zzaI()     // Catch:{ SQLiteException -> 0x00b7 }
            if (r0 == 0) goto L_0x0258
            r21.zzM()     // Catch:{ SQLiteException -> 0x00b7 }
            goto L_0x0241
        L_0x0258:
            r1.zzB = r14     // Catch:{ SQLiteException -> 0x00b7 }
            r21.zzaK()     // Catch:{ SQLiteException -> 0x00b7 }
            goto L_0x0241
        L_0x025e:
            r1.zza = r2     // Catch:{ SQLiteException -> 0x00b7 }
            goto L_0x0293
        L_0x0261:
            com.google.android.gms.measurement.internal.zzav r2 = r21.zzj()     // Catch:{ SQLiteException -> 0x00b7 }
            r2.zzd()     // Catch:{ SQLiteException -> 0x00b7 }
            throw r0     // Catch:{ SQLiteException -> 0x00b7 }
        L_0x0269:
            com.google.android.gms.measurement.internal.zzgt r2 = r21.zzaV()     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = "Database error while trying to delete uploaded bundles"
            r2.zzb(r3, r0)     // Catch:{ all -> 0x0019 }
            com.google.android.gms.common.util.Clock r0 = r21.zzaZ()     // Catch:{ all -> 0x0019 }
            long r2 = r0.elapsedRealtime()     // Catch:{ all -> 0x0019 }
            r1.zza = r2     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzgt r0 = r21.zzaV()     // Catch:{ all -> 0x0019 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()     // Catch:{ all -> 0x0019 }
            java.lang.String r2 = "Disable upload, time"
            long r3 = r1.zza     // Catch:{ all -> 0x0019 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x0019 }
            r0.zzb(r2, r3)     // Catch:{ all -> 0x0019 }
        L_0x0293:
            r1.zzv = r11
            r21.zzaL()
            return
        L_0x0299:
            r1.zzv = r11
            r21.zzaL()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzU(boolean, int, java.lang.Throwable, byte[], java.lang.String, java.util.List):void");
    }

    @WorkerThread
    public final void zzV(zzh zzh2) {
        zzaW().zzg();
        if (TextUtils.isEmpty(zzh2.zzf())) {
            zzW((String) Preconditions.checkNotNull(zzh2.zzc()), 204, (Throwable) null, (byte[]) null, (Map) null);
            return;
        }
        String str = (String) Preconditions.checkNotNull(zzh2.zzc());
        zzaV().zzk().zzb("Fetching remote configuration", str);
        zzgl zzb2 = zzh().zzb(str);
        String zzd2 = zzh().zzd(str);
        ArrayMap arrayMap = null;
        if (zzb2 != null) {
            if (!TextUtils.isEmpty(zzd2)) {
                arrayMap = new ArrayMap();
                arrayMap.put(HttpHeaders.IF_MODIFIED_SINCE, zzd2);
            }
            String zze2 = zzh().zze(str);
            if (!TextUtils.isEmpty(zze2)) {
                if (arrayMap == null) {
                    arrayMap = new ArrayMap();
                }
                arrayMap.put(HttpHeaders.IF_NONE_MATCH, zze2);
            }
        }
        this.zzu = true;
        zzi().zzd(zzh2, arrayMap, new zzpe(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d A[Catch:{ all -> 0x0060, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063 A[Catch:{ all -> 0x0060, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fe A[Catch:{ all -> 0x0060, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c A[Catch:{ all -> 0x0060, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012d A[Catch:{ all -> 0x0060, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0131 A[Catch:{ all -> 0x0060, all -> 0x0013 }] */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzW(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map r11) {
        /*
            r6 = this;
            com.google.android.gms.measurement.internal.zzhy r0 = r6.zzaW()
            r0.zzg()
            r6.zzu()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x0016
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0013 }
            goto L_0x0016
        L_0x0013:
            r7 = move-exception
            goto L_0x0170
        L_0x0016:
            com.google.android.gms.measurement.internal.zzgt r1 = r6.zzaV()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.zzgr r1 = r1.zzk()     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0013 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0013 }
            r1.zzb(r2, r3)     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.zzav r1 = r6.zzj()     // Catch:{ all -> 0x0013 }
            r1.zzb()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.zzav r1 = r6.zzj()     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzh r1 = r1.zzu(r7)     // Catch:{ all -> 0x0060 }
            r2 = 200(0xc8, float:2.8E-43)
            r4 = 304(0x130, float:4.26E-43)
            if (r8 == r2) goto L_0x0048
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x0048
            if (r8 != r4) goto L_0x0046
            r8 = 304(0x130, float:4.26E-43)
            goto L_0x0048
        L_0x0046:
            r2 = 0
            goto L_0x004b
        L_0x0048:
            if (r9 != 0) goto L_0x0046
            r2 = 1
        L_0x004b:
            if (r1 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzgt r8 = r6.zzaV()     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zze()     // Catch:{ all -> 0x0060 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgt.zzl(r7)     // Catch:{ all -> 0x0060 }
            r8.zzb(r9, r7)     // Catch:{ all -> 0x0060 }
            goto L_0x0154
        L_0x0060:
            r7 = move-exception
            goto L_0x0168
        L_0x0063:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00bf
            if (r8 != r5) goto L_0x006a
            goto L_0x00bf
        L_0x006a:
            com.google.android.gms.common.util.Clock r10 = r6.zzaZ()     // Catch:{ all -> 0x0060 }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r1.zzK(r10)     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzav r10 = r6.zzj()     // Catch:{ all -> 0x0060 }
            r10.zzv(r1, r0, r0)     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzgt r10 = r6.zzaV()     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zzk()     // Catch:{ all -> 0x0060 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0060 }
            r10.zzc(r11, r1, r9)     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzhs r9 = r6.zzh()     // Catch:{ all -> 0x0060 }
            r9.zzf(r7)     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zznm r7 = r6.zzk     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzhd r7 = r7.zze     // Catch:{ all -> 0x0060 }
            com.google.android.gms.common.util.Clock r9 = r6.zzaZ()     // Catch:{ all -> 0x0060 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r7.zzb(r9)     // Catch:{ all -> 0x0060 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ab
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ba
        L_0x00ab:
            com.google.android.gms.measurement.internal.zznm r7 = r6.zzk     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzhd r7 = r7.zzc     // Catch:{ all -> 0x0060 }
            com.google.android.gms.common.util.Clock r8 = r6.zzaZ()     // Catch:{ all -> 0x0060 }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r7.zzb(r8)     // Catch:{ all -> 0x0060 }
        L_0x00ba:
            r6.zzaK()     // Catch:{ all -> 0x0060 }
            goto L_0x0154
        L_0x00bf:
            java.lang.String r9 = "Last-Modified"
            java.lang.String r9 = zzaJ(r11, r9)     // Catch:{ all -> 0x0060 }
            java.lang.String r2 = "ETag"
            java.lang.String r11 = zzaJ(r11, r2)     // Catch:{ all -> 0x0060 }
            if (r8 == r5) goto L_0x00d8
            if (r8 != r4) goto L_0x00d0
            goto L_0x00d8
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzhs r2 = r6.zzh()     // Catch:{ all -> 0x0060 }
            r2.zzi(r7, r10, r9, r11)     // Catch:{ all -> 0x0060 }
            goto L_0x00ea
        L_0x00d8:
            com.google.android.gms.measurement.internal.zzhs r9 = r6.zzh()     // Catch:{ all -> 0x0060 }
            com.google.android.gms.internal.measurement.zzgl r9 = r9.zzb(r7)     // Catch:{ all -> 0x0060 }
            if (r9 != 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.zzhs r9 = r6.zzh()     // Catch:{ all -> 0x0060 }
            r10 = 0
            r9.zzi(r7, r10, r10, r10)     // Catch:{ all -> 0x0060 }
        L_0x00ea:
            com.google.android.gms.common.util.Clock r9 = r6.zzaZ()     // Catch:{ all -> 0x0060 }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x0060 }
            r1.zzI(r9)     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzav r9 = r6.zzj()     // Catch:{ all -> 0x0060 }
            r9.zzv(r1, r0, r0)     // Catch:{ all -> 0x0060 }
            if (r8 != r5) goto L_0x010c
            com.google.android.gms.measurement.internal.zzgt r8 = r6.zzaV()     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzh()     // Catch:{ all -> 0x0060 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zzb(r9, r7)     // Catch:{ all -> 0x0060 }
            goto L_0x011d
        L_0x010c:
            com.google.android.gms.measurement.internal.zzgt r7 = r6.zzaV()     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzk()     // Catch:{ all -> 0x0060 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0060 }
            r7.zzc(r9, r8, r3)     // Catch:{ all -> 0x0060 }
        L_0x011d:
            com.google.android.gms.measurement.internal.zzgy r7 = r6.zzi()     // Catch:{ all -> 0x0060 }
            boolean r7 = r7.zzb()     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x0131
            boolean r7 = r6.zzaI()     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x0131
            r6.zzM()     // Catch:{ all -> 0x0060 }
            goto L_0x0154
        L_0x0131:
            com.google.android.gms.measurement.internal.zzgy r7 = r6.zzi()     // Catch:{ all -> 0x0060 }
            boolean r7 = r7.zzb()     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x0151
            com.google.android.gms.measurement.internal.zzav r7 = r6.zzj()     // Catch:{ all -> 0x0060 }
            java.lang.String r8 = r1.zzc()     // Catch:{ all -> 0x0060 }
            boolean r7 = r7.zzD(r8)     // Catch:{ all -> 0x0060 }
            if (r7 == 0) goto L_0x0151
            java.lang.String r7 = r1.zzc()     // Catch:{ all -> 0x0060 }
            r6.zzP(r7)     // Catch:{ all -> 0x0060 }
            goto L_0x0154
        L_0x0151:
            r6.zzaK()     // Catch:{ all -> 0x0060 }
        L_0x0154:
            com.google.android.gms.measurement.internal.zzav r7 = r6.zzj()     // Catch:{ all -> 0x0060 }
            r7.zzc()     // Catch:{ all -> 0x0060 }
            com.google.android.gms.measurement.internal.zzav r7 = r6.zzj()     // Catch:{ all -> 0x0013 }
            r7.zzd()     // Catch:{ all -> 0x0013 }
            r6.zzu = r0
            r6.zzaL()
            return
        L_0x0168:
            com.google.android.gms.measurement.internal.zzav r8 = r6.zzj()     // Catch:{ all -> 0x0013 }
            r8.zzd()     // Catch:{ all -> 0x0013 }
            throw r7     // Catch:{ all -> 0x0013 }
        L_0x0170:
            r6.zzu = r0
            r6.zzaL()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzW(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    @WorkerThread
    public final void zzX(Runnable runnable) {
        zzaW().zzg();
        if (this.zzq == null) {
            this.zzq = new ArrayList();
        }
        this.zzq.add(runnable);
    }

    @WorkerThread
    public final void zzY() {
        zzaW().zzg();
        zzu();
        if (!this.zzp) {
            this.zzp = true;
            if (zzZ()) {
                FileChannel fileChannel = this.zzy;
                zzaW().zzg();
                int i = 0;
                if (fileChannel == null || !fileChannel.isOpen()) {
                    zzaV().zzb().zza("Bad channel to read from");
                } else {
                    ByteBuffer allocate = ByteBuffer.allocate(4);
                    try {
                        fileChannel.position(0);
                        int read = fileChannel.read(allocate);
                        if (read == 4) {
                            allocate.flip();
                            i = allocate.getInt();
                        } else if (read != -1) {
                            zzaV().zze().zzb("Unexpected data length. Bytes read", Integer.valueOf(read));
                        }
                    } catch (IOException e) {
                        zzaV().zzb().zzb("Failed to read from channel", e);
                    }
                }
                int zzm2 = this.zzn.zzv().zzm();
                zzaW().zzg();
                if (i > zzm2) {
                    zzaV().zzb().zzc("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                } else if (i < zzm2) {
                    FileChannel fileChannel2 = this.zzy;
                    zzaW().zzg();
                    if (fileChannel2 == null || !fileChannel2.isOpen()) {
                        zzaV().zzb().zza("Bad channel to read from");
                    } else {
                        ByteBuffer allocate2 = ByteBuffer.allocate(4);
                        allocate2.putInt(zzm2);
                        allocate2.flip();
                        try {
                            fileChannel2.truncate(0);
                            fileChannel2.write(allocate2);
                            fileChannel2.force(true);
                            if (fileChannel2.size() != 4) {
                                zzaV().zzb().zzb("Error writing to channel. Bytes written", Long.valueOf(fileChannel2.size()));
                            }
                            zzaV().zzk().zzc("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                            return;
                        } catch (IOException e2) {
                            zzaV().zzb().zzb("Failed to write to channel", e2);
                        }
                    }
                    zzaV().zzb().zzc("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(zzm2));
                }
            }
        }
    }

    @VisibleForTesting
    @WorkerThread
    public final boolean zzZ() {
        zzaW().zzg();
        FileLock fileLock = this.zzx;
        if (fileLock == null || !fileLock.isValid()) {
            this.zze.zzu.zzc();
            File filesDir = this.zzn.zzaY().getFilesDir();
            zzbv.zza();
            int i = zzca.zzb;
            try {
                FileChannel channel = new RandomAccessFile(new File(new File(filesDir, "google_app_measurement.db").getPath()), "rw").getChannel();
                this.zzy = channel;
                FileLock tryLock = channel.tryLock();
                this.zzx = tryLock;
                if (tryLock != null) {
                    zzaV().zzk().zza("Storage concurrent access okay");
                    return true;
                }
                zzaV().zzb().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                zzaV().zzb().zzb("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                zzaV().zzb().zzb("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                zzaV().zze().zzb("Storage lock already acquired", e3);
                return false;
            }
        } else {
            zzaV().zzk().zza("Storage concurrent access okay");
            return true;
        }
    }

    public final zzae zzaU() {
        return this.zzn.zzaU();
    }

    public final zzgt zzaV() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaV();
    }

    public final zzhy zzaW() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaW();
    }

    public final Context zzaY() {
        return this.zzn.zzaY();
    }

    public final Clock zzaZ() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzaZ();
    }

    @VisibleForTesting(otherwise = 4)
    @WorkerThread
    public final void zzaa(zzr zzr2) {
        if (this.zzz != null) {
            ArrayList arrayList = new ArrayList();
            this.zzA = arrayList;
            arrayList.addAll(this.zzz);
        }
        zzav zzj2 = zzj();
        String str = (String) Preconditions.checkNotNull(zzr2.zza);
        Preconditions.checkNotEmpty(str);
        zzj2.zzg();
        zzj2.zzay();
        try {
            SQLiteDatabase zze2 = zzj2.zze();
            String[] strArr = {str};
            int delete = zze2.delete("apps", "app_id=?", strArr) + zze2.delete("events", "app_id=?", strArr) + zze2.delete("events_snapshot", "app_id=?", strArr) + zze2.delete("user_attributes", "app_id=?", strArr) + zze2.delete("conditional_properties", "app_id=?", strArr) + zze2.delete("raw_events", "app_id=?", strArr) + zze2.delete("raw_events_metadata", "app_id=?", strArr) + zze2.delete("queue", "app_id=?", strArr) + zze2.delete("audience_filter_values", "app_id=?", strArr) + zze2.delete("main_event_params", "app_id=?", strArr) + zze2.delete("default_event_params", "app_id=?", strArr) + zze2.delete("trigger_uris", "app_id=?", strArr) + zze2.delete("upload_queue", "app_id=?", strArr);
            zzpk.zza();
            zzib zzib = zzj2.zzu;
            if (zzib.zzc().zzp((String) null, zzfx.zzbi)) {
                delete += zze2.delete("no_data_mode_events", "app_id=?", strArr);
            }
            if (delete > 0) {
                zzib.zzaV().zzk().zzc("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzj2.zzu.zzaV().zzb().zzc("Error resetting analytics data. appId, error", zzgt.zzl(str), e);
        }
        if (zzr2.zzh) {
            zzag(zzr2);
        }
    }

    @WorkerThread
    public final void zzab(zzpk zzpk, zzr zzr2) {
        String str;
        zzpm zzm2;
        long j;
        int i;
        int i2;
        zzpk zzpk2 = zzpk;
        zzr zzr3 = zzr2;
        zzaW().zzg();
        zzu();
        if (zzaQ(zzr2)) {
            if (!zzr3.zzh) {
                zzan(zzr3);
                return;
            }
            zzpo zzt2 = zzt();
            String str2 = zzpk2.zzb;
            int zzp2 = zzt2.zzp(str2);
            if (zzp2 != 0) {
                zzpo zzt3 = zzt();
                zzd();
                String zzC2 = zzt3.zzC(str2, 24, true);
                if (str2 != null) {
                    i2 = str2.length();
                } else {
                    i2 = 0;
                }
                zzt().zzN(this.zzK, zzr3.zza, zzp2, "_ev", zzC2, i2);
                return;
            }
            int zzK2 = zzt().zzK(str2, zzpk.zza());
            if (zzK2 != 0) {
                zzpo zzt4 = zzt();
                zzd();
                String zzC3 = zzt4.zzC(str2, 24, true);
                Object zza2 = zzpk.zza();
                if (zza2 == null || (!(zza2 instanceof String) && !(zza2 instanceof CharSequence))) {
                    i = 0;
                } else {
                    i = zza2.toString().length();
                }
                zzt().zzN(this.zzK, zzr3.zza, zzK2, "_ev", zzC3, i);
                return;
            }
            Object zzL = zzt().zzL(str2, zzpk.zza());
            if (zzL != null) {
                if ("_sid".equals(str2)) {
                    long j2 = zzpk2.zzc;
                    String str3 = zzpk2.zzf;
                    String str4 = (String) Preconditions.checkNotNull(zzr3.zza);
                    zzpm zzm3 = zzj().zzm(str4, "_sno");
                    if (zzm3 != null) {
                        Object obj = zzm3.zze;
                        if (obj instanceof Long) {
                            j = ((Long) obj).longValue();
                            str = "_sid";
                            zzab(new zzpk("_sno", j2, Long.valueOf(j + 1), str3), zzr3);
                        }
                    }
                    if (zzm3 != null) {
                        zzaV().zze().zzb("Retrieved last session number from database does not contain a valid (long) value", zzm3.zze);
                    }
                    zzbc zzf2 = zzj().zzf(str4, "_s");
                    if (zzf2 != null) {
                        zzgr zzk2 = zzaV().zzk();
                        str = "_sid";
                        long j3 = zzf2.zzc;
                        zzk2.zzb("Backfill the session number. Last used session number", Long.valueOf(j3));
                        j = j3;
                    } else {
                        str = "_sid";
                        j = 0;
                    }
                    zzab(new zzpk("_sno", j2, Long.valueOf(j + 1), str3), zzr3);
                } else {
                    str = "_sid";
                }
                String str5 = zzr3.zza;
                zzpm zzpm = new zzpm((String) Preconditions.checkNotNull(str5), (String) Preconditions.checkNotNull(zzpk2.zzf), str2, zzpk2.zzc, zzL);
                zzgr zzk3 = zzaV().zzk();
                zzib zzib = this.zzn;
                String str6 = zzpm.zzc;
                zzk3.zzc("Setting user property", zzib.zzl().zzc(str6), zzL);
                zzj().zzb();
                try {
                    if ("_id".equals(str6) && (zzm2 = zzj().zzm(str5, "_id")) != null && !zzpm.zze.equals(zzm2.zze)) {
                        zzj().zzk(str5, "_lair");
                    }
                    zzan(zzr3);
                    boolean zzl2 = zzj().zzl(zzpm);
                    if (str.equals(str2)) {
                        long zzu2 = zzp().zzu(zzr3.zzu);
                        zzh zzu3 = zzj().zzu(str5);
                        if (zzu3 != null) {
                            zzu3.zzan(zzu2);
                            if (zzu3.zza()) {
                                zzj().zzv(zzu3, false, false);
                            }
                        }
                    }
                    zzj().zzc();
                    if (!zzl2) {
                        zzaV().zzb().zzc("Too many unique user properties are set. Ignoring user property", zzib.zzl().zzc(str6), zzpm.zze);
                        zzt().zzN(this.zzK, str5, 9, (String) null, (String) null, 0);
                    }
                    zzj().zzd();
                } catch (Throwable th) {
                    zzj().zzd();
                    throw th;
                }
            }
        }
    }

    @WorkerThread
    public final void zzac(String str, zzr zzr2) {
        long j;
        zzaW().zzg();
        zzu();
        if (zzaQ(zzr2)) {
            if (!zzr2.zzh) {
                zzan(zzr2);
                return;
            }
            Boolean zzaT = zzaT(zzr2);
            if (!"_npa".equals(str) || zzaT == null) {
                zzgr zzj2 = zzaV().zzj();
                zzib zzib = this.zzn;
                zzj2.zzb("Removing user property", zzib.zzl().zzc(str));
                zzj().zzb();
                try {
                    zzan(zzr2);
                    if ("_id".equals(str)) {
                        zzj().zzk((String) Preconditions.checkNotNull(zzr2.zza), "_lair");
                    }
                    zzj().zzk((String) Preconditions.checkNotNull(zzr2.zza), str);
                    zzj().zzc();
                    zzaV().zzj().zzb("User property removed", zzib.zzl().zzc(str));
                    zzj().zzd();
                } catch (Throwable th) {
                    zzj().zzd();
                    throw th;
                }
            } else {
                zzaV().zzj().zza("Falling back to manifest metadata value for ad personalization");
                long currentTimeMillis = zzaZ().currentTimeMillis();
                if (true != zzaT.booleanValue()) {
                    j = 0;
                } else {
                    j = 1;
                }
                zzab(new zzpk("_npa", currentTimeMillis, Long.valueOf(j), "auto"), zzr2);
            }
        }
    }

    public final void zzad() {
        this.zzs++;
    }

    public final void zzae() {
        this.zzt++;
    }

    public final zzib zzaf() {
        return this.zzn;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0352 A[Catch:{ RuntimeException -> 0x0206, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x03d9 A[Catch:{ RuntimeException -> 0x0206, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f5 A[Catch:{ RuntimeException -> 0x0206, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fb A[Catch:{ RuntimeException -> 0x0206, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0103 A[Catch:{ RuntimeException -> 0x0206, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010f A[Catch:{ RuntimeException -> 0x0206, all -> 0x00b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011c A[Catch:{ RuntimeException -> 0x0206, all -> 0x00b1 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzag(com.google.android.gms.measurement.internal.zzr r26) {
        /*
            r25 = this;
            r1 = r25
            r2 = r26
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r0 = "com.android.vending"
            java.lang.String r6 = "_npa"
            java.lang.String r7 = "_uwa"
            com.google.android.gms.measurement.internal.zzhy r8 = r25.zzaW()
            r8.zzg()
            r25.zzu()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r26)
            java.lang.String r8 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            boolean r9 = zzaQ(r26)
            if (r9 != 0) goto L_0x0029
            return
        L_0x0029:
            com.google.android.gms.measurement.internal.zzav r9 = r25.zzj()
            com.google.android.gms.measurement.internal.zzh r9 = r9.zzu(r8)
            r10 = 0
            r11 = 0
            if (r9 == 0) goto L_0x0059
            java.lang.String r13 = r9.zzf()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x0059
            java.lang.String r13 = r2.zzb
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x0059
            r9.zzI(r11)
            com.google.android.gms.measurement.internal.zzav r13 = r25.zzj()
            r13.zzv(r9, r10, r10)
            com.google.android.gms.measurement.internal.zzhs r9 = r25.zzh()
            r9.zzh(r8)
        L_0x0059:
            boolean r9 = r2.zzh
            if (r9 != 0) goto L_0x0061
            r25.zzan(r26)
            return
        L_0x0061:
            long r13 = r2.zzl
            int r9 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x006f
            com.google.android.gms.common.util.Clock r9 = r25.zzaZ()
            long r13 = r9.currentTimeMillis()
        L_0x006f:
            int r9 = r2.zzm
            r15 = 1
            if (r9 == 0) goto L_0x008c
            if (r9 == r15) goto L_0x008c
            com.google.android.gms.measurement.internal.zzgt r16 = r25.zzaV()
            com.google.android.gms.measurement.internal.zzgr r11 = r16.zze()
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgt.zzl(r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r10 = "Incorrect app type, assuming installed app. appId, appType"
            r11.zzc(r10, r12, r9)
            r9 = 0
        L_0x008c:
            com.google.android.gms.measurement.internal.zzav r10 = r25.zzj()
            r10.zzb()
            com.google.android.gms.measurement.internal.zzav r10 = r25.zzj()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzpm r10 = r10.zzm(r8, r6)     // Catch:{ all -> 0x00b1 }
            java.lang.Boolean r11 = zzaT(r26)     // Catch:{ all -> 0x00b1 }
            r12 = r3
            r21 = r4
            if (r10 == 0) goto L_0x00b4
            java.lang.String r3 = "auto"
            java.lang.String r4 = r10.zzb     // Catch:{ all -> 0x00b1 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x00af
            goto L_0x00b4
        L_0x00af:
            r4 = 1
            goto L_0x00e8
        L_0x00b1:
            r0 = move-exception
            goto L_0x0409
        L_0x00b4:
            if (r11 == 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzpk r3 = new com.google.android.gms.measurement.internal.zzpk     // Catch:{ all -> 0x00b1 }
            java.lang.String r16 = "_npa"
            boolean r4 = r11.booleanValue()     // Catch:{ all -> 0x00b1 }
            if (r15 == r4) goto L_0x00c3
            r17 = 0
            goto L_0x00c5
        L_0x00c3:
            r17 = 1
        L_0x00c5:
            java.lang.Long r19 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x00b1 }
            java.lang.String r20 = "auto"
            r4 = 1
            r15 = r3
            r17 = r13
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b1 }
            if (r10 == 0) goto L_0x00de
            java.lang.Object r6 = r10.zze     // Catch:{ all -> 0x00b1 }
            java.lang.Long r10 = r3.zzd     // Catch:{ all -> 0x00b1 }
            boolean r6 = r6.equals(r10)     // Catch:{ all -> 0x00b1 }
            if (r6 != 0) goto L_0x00e8
        L_0x00de:
            r1.zzab(r3, r2)     // Catch:{ all -> 0x00b1 }
            goto L_0x00e8
        L_0x00e2:
            r4 = 1
            if (r10 == 0) goto L_0x00e8
            r1.zzac(r6, r2)     // Catch:{ all -> 0x00b1 }
        L_0x00e8:
            com.google.android.gms.measurement.internal.zzal r3 = r25.zzd()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzfw r6 = com.google.android.gms.measurement.internal.zzfx.zzbc     // Catch:{ all -> 0x00b1 }
            r10 = 0
            boolean r3 = r3.zzp(r10, r6)     // Catch:{ all -> 0x00b1 }
            if (r3 == 0) goto L_0x00fb
            long r10 = r2.zzD     // Catch:{ all -> 0x00b1 }
            r1.zzam(r2, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x00fe
        L_0x00fb:
            r1.zzam(r2, r13)     // Catch:{ all -> 0x00b1 }
        L_0x00fe:
            r25.zzan(r26)     // Catch:{ all -> 0x00b1 }
            if (r9 != 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzav r6 = r25.zzj()     // Catch:{ all -> 0x00b1 }
            java.lang.String r9 = "_f"
            com.google.android.gms.measurement.internal.zzbc r6 = r6.zzf(r8, r9)     // Catch:{ all -> 0x00b1 }
            r15 = 0
            goto L_0x011a
        L_0x010f:
            com.google.android.gms.measurement.internal.zzav r6 = r25.zzj()     // Catch:{ all -> 0x00b1 }
            java.lang.String r9 = "_v"
            com.google.android.gms.measurement.internal.zzbc r6 = r6.zzf(r8, r9)     // Catch:{ all -> 0x00b1 }
            r15 = 1
        L_0x011a:
            if (r6 != 0) goto L_0x03d9
            r9 = 3600000(0x36ee80, double:1.7786363E-317)
            long r16 = r13 / r9
            r18 = 1
            long r16 = r16 + r18
            long r16 = r16 * r9
            java.lang.String r6 = "_dac"
            java.lang.String r9 = "_et"
            java.lang.String r10 = "_r"
            java.lang.String r11 = "_c"
            if (r15 != 0) goto L_0x038a
            com.google.android.gms.measurement.internal.zzpk r15 = new com.google.android.gms.measurement.internal.zzpk     // Catch:{ all -> 0x00b1 }
            java.lang.String r18 = "_fot"
            java.lang.Long r19 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x00b1 }
            java.lang.String r20 = "auto"
            r22 = r15
            r15 = r22
            r16 = r18
            r17 = r13
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b1 }
            r1.zzab(r15, r2)     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzhy r15 = r25.zzaW()     // Catch:{ all -> 0x00b1 }
            r15.zzg()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzhj r15 = r1.zzm     // Catch:{ all -> 0x00b1 }
            java.lang.Object r15 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzhj r15 = (com.google.android.gms.measurement.internal.zzhj) r15     // Catch:{ all -> 0x00b1 }
            if (r8 == 0) goto L_0x0160
            boolean r16 = r8.isEmpty()     // Catch:{ all -> 0x00b1 }
            if (r16 == 0) goto L_0x0164
        L_0x0160:
            r23 = r13
            goto L_0x023e
        L_0x0164:
            com.google.android.gms.measurement.internal.zzib r3 = r15.zza     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzhy r16 = r3.zzaW()     // Catch:{ all -> 0x00b1 }
            r16.zzg()     // Catch:{ all -> 0x00b1 }
            boolean r16 = r15.zza()     // Catch:{ all -> 0x00b1 }
            if (r16 != 0) goto L_0x0184
            com.google.android.gms.measurement.internal.zzgt r0 = r3.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzi()     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "Install Referrer Reporter is not available"
            r0.zza(r3)     // Catch:{ all -> 0x00b1 }
            r23 = r13
            goto L_0x024d
        L_0x0184:
            com.google.android.gms.measurement.internal.zzhi r4 = new com.google.android.gms.measurement.internal.zzhi     // Catch:{ all -> 0x00b1 }
            r4.<init>(r15, r8)     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzhy r8 = r3.zzaW()     // Catch:{ all -> 0x00b1 }
            r8.zzg()     // Catch:{ all -> 0x00b1 }
            android.content.Intent r8 = new android.content.Intent     // Catch:{ all -> 0x00b1 }
            r23 = r13
            java.lang.String r13 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r8.<init>(r13)     // Catch:{ all -> 0x00b1 }
            android.content.ComponentName r13 = new android.content.ComponentName     // Catch:{ all -> 0x00b1 }
            java.lang.String r14 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r13.<init>(r0, r14)     // Catch:{ all -> 0x00b1 }
            r8.setComponent(r13)     // Catch:{ all -> 0x00b1 }
            android.content.Context r13 = r3.zzaY()     // Catch:{ all -> 0x00b1 }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x00b1 }
            if (r13 != 0) goto L_0x01bc
            com.google.android.gms.measurement.internal.zzgt r0 = r3.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzf()     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.zza(r3)     // Catch:{ all -> 0x00b1 }
            goto L_0x024d
        L_0x01bc:
            r14 = 0
            java.util.List r13 = r13.queryIntentServices(r8, r14)     // Catch:{ all -> 0x00b1 }
            if (r13 == 0) goto L_0x0230
            boolean r16 = r13.isEmpty()     // Catch:{ all -> 0x00b1 }
            if (r16 != 0) goto L_0x0230
            java.lang.Object r13 = r13.get(r14)     // Catch:{ all -> 0x00b1 }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x00b1 }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x00b1 }
            if (r13 == 0) goto L_0x024d
            java.lang.String r14 = r13.packageName     // Catch:{ all -> 0x00b1 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x00b1 }
            if (r13 == 0) goto L_0x0222
            boolean r0 = r0.equals(r14)     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0222
            boolean r0 = r15.zza()     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0222
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x00b1 }
            r0.<init>(r8)     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.common.stats.ConnectionTracker r8 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ RuntimeException -> 0x0206 }
            android.content.Context r13 = r3.zzaY()     // Catch:{ RuntimeException -> 0x0206 }
            r14 = 1
            boolean r0 = r8.bindService(r13, r0, r4, r14)     // Catch:{ RuntimeException -> 0x0206 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ RuntimeException -> 0x0206 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzk()     // Catch:{ RuntimeException -> 0x0206 }
            java.lang.String r4 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x0208
            java.lang.String r0 = "available"
            goto L_0x020a
        L_0x0206:
            r0 = move-exception
            goto L_0x020e
        L_0x0208:
            java.lang.String r0 = "not available"
        L_0x020a:
            r3.zzb(r4, r0)     // Catch:{ RuntimeException -> 0x0206 }
            goto L_0x024d
        L_0x020e:
            com.google.android.gms.measurement.internal.zzib r3 = r15.zza     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00b1 }
            r3.zzb(r4, r0)     // Catch:{ all -> 0x00b1 }
            goto L_0x024d
        L_0x0222:
            com.google.android.gms.measurement.internal.zzgt r0 = r3.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.zza(r3)     // Catch:{ all -> 0x00b1 }
            goto L_0x024d
        L_0x0230:
            com.google.android.gms.measurement.internal.zzgt r0 = r3.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzi()     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.zza(r3)     // Catch:{ all -> 0x00b1 }
            goto L_0x024d
        L_0x023e:
            com.google.android.gms.measurement.internal.zzib r0 = r15.zza     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzf()     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "Install Referrer Reporter was called with invalid app package name"
            r0.zza(r3)     // Catch:{ all -> 0x00b1 }
        L_0x024d:
            com.google.android.gms.measurement.internal.zzhy r0 = r25.zzaW()     // Catch:{ all -> 0x00b1 }
            r0.zzg()     // Catch:{ all -> 0x00b1 }
            r25.zzu()     // Catch:{ all -> 0x00b1 }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x00b1 }
            r3.<init>()     // Catch:{ all -> 0x00b1 }
            r13 = 1
            r3.putLong(r11, r13)     // Catch:{ all -> 0x00b1 }
            r3.putLong(r10, r13)     // Catch:{ all -> 0x00b1 }
            r10 = 0
            r3.putLong(r7, r10)     // Catch:{ all -> 0x00b1 }
            r3.putLong(r5, r10)     // Catch:{ all -> 0x00b1 }
            r4 = r21
            r3.putLong(r4, r10)     // Catch:{ all -> 0x00b1 }
            r3.putLong(r12, r10)     // Catch:{ all -> 0x00b1 }
            r3.putLong(r9, r13)     // Catch:{ all -> 0x00b1 }
            boolean r0 = r2.zzo     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x027e
            r3.putLong(r6, r13)     // Catch:{ all -> 0x00b1 }
        L_0x027e:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x00b1 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x00b1 }
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzav r0 = r25.zzj()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)     // Catch:{ all -> 0x00b1 }
            r0.zzg()     // Catch:{ all -> 0x00b1 }
            r0.zzay()     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "first_open_count"
            long r10 = r0.zzN(r6, r8)     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzn     // Catch:{ all -> 0x00b1 }
            android.content.Context r8 = r0.zzaY()     // Catch:{ all -> 0x00b1 }
            android.content.pm.PackageManager r8 = r8.getPackageManager()     // Catch:{ all -> 0x00b1 }
            if (r8 != 0) goto L_0x02bb
            com.google.android.gms.measurement.internal.zzgt r0 = r25.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ all -> 0x00b1 }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgt.zzl(r6)     // Catch:{ all -> 0x00b1 }
            r0.zzb(r4, r6)     // Catch:{ all -> 0x00b1 }
        L_0x02b7:
            r6 = 0
            goto L_0x036b
        L_0x02bb:
            android.content.Context r0 = r0.zzaY()     // Catch:{ NameNotFoundException -> 0x02c9 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x02c9 }
            r8 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r6, r8)     // Catch:{ NameNotFoundException -> 0x02c9 }
            goto L_0x02dc
        L_0x02c9:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgt r8 = r25.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzb()     // Catch:{ all -> 0x00b1 }
            java.lang.String r9 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzgt.zzl(r6)     // Catch:{ all -> 0x00b1 }
            r8.zzc(r9, r13, r0)     // Catch:{ all -> 0x00b1 }
            r0 = 0
        L_0x02dc:
            if (r0 == 0) goto L_0x032c
            long r8 = r0.firstInstallTime     // Catch:{ all -> 0x00b1 }
            r13 = 0
            int r15 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x032c
            long r13 = r0.lastUpdateTime     // Catch:{ all -> 0x00b1 }
            int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x030e
            com.google.android.gms.measurement.internal.zzal r0 = r25.zzd()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzfw r8 = com.google.android.gms.measurement.internal.zzfx.zzaI     // Catch:{ all -> 0x00b1 }
            r9 = 0
            boolean r0 = r0.zzp(r9, r8)     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0308
            r13 = 0
            int r0 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x0306
            r13 = 1
            r3.putLong(r7, r13)     // Catch:{ all -> 0x00b1 }
            r10 = 0
        L_0x0306:
            r15 = 0
            goto L_0x0310
        L_0x0308:
            r13 = 1
            r3.putLong(r7, r13)     // Catch:{ all -> 0x00b1 }
            goto L_0x0306
        L_0x030e:
            r9 = 0
            r15 = 1
        L_0x0310:
            com.google.android.gms.measurement.internal.zzpk r0 = new com.google.android.gms.measurement.internal.zzpk     // Catch:{ all -> 0x00b1 }
            java.lang.String r16 = "_fi"
            r7 = 1
            if (r7 == r15) goto L_0x031a
            r7 = 0
            goto L_0x031c
        L_0x031a:
            r7 = 1
        L_0x031c:
            java.lang.Long r19 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x00b1 }
            java.lang.String r20 = "auto"
            r15 = r0
            r17 = r23
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b1 }
            r1.zzab(r0, r2)     // Catch:{ all -> 0x00b1 }
            goto L_0x032d
        L_0x032c:
            r9 = 0
        L_0x032d:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzn     // Catch:{ NameNotFoundException -> 0x033d }
            android.content.Context r0 = r0.zzaY()     // Catch:{ NameNotFoundException -> 0x033d }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x033d }
            r7 = 0
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r6, r7)     // Catch:{ NameNotFoundException -> 0x033d }
            goto L_0x0350
        L_0x033d:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgt r7 = r25.zzaV()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzb()     // Catch:{ all -> 0x00b1 }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgt.zzl(r6)     // Catch:{ all -> 0x00b1 }
            r7.zzc(r8, r6, r0)     // Catch:{ all -> 0x00b1 }
            r0 = r9
        L_0x0350:
            if (r0 == 0) goto L_0x02b7
            int r6 = r0.flags     // Catch:{ all -> 0x00b1 }
            r7 = 1
            r6 = r6 & r7
            if (r6 == 0) goto L_0x035e
            r6 = 1
            r3.putLong(r4, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x0360
        L_0x035e:
            r6 = 1
        L_0x0360:
            int r0 = r0.flags     // Catch:{ all -> 0x00b1 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x02b7
            r3.putLong(r12, r6)     // Catch:{ all -> 0x00b1 }
            goto L_0x02b7
        L_0x036b:
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x0372
            r3.putLong(r5, r10)     // Catch:{ all -> 0x00b1 }
        L_0x0372:
            com.google.android.gms.measurement.internal.zzbg r0 = new com.google.android.gms.measurement.internal.zzbg     // Catch:{ all -> 0x00b1 }
            java.lang.String r16 = "_f"
            com.google.android.gms.measurement.internal.zzbe r4 = new com.google.android.gms.measurement.internal.zzbe     // Catch:{ all -> 0x00b1 }
            r4.<init>(r3)     // Catch:{ all -> 0x00b1 }
            java.lang.String r18 = "auto"
            r15 = r0
            r17 = r4
            r19 = r23
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00b1 }
            r1.zzE(r0, r2)     // Catch:{ all -> 0x00b1 }
            goto L_0x03fa
        L_0x038a:
            r23 = r13
            com.google.android.gms.measurement.internal.zzpk r0 = new com.google.android.gms.measurement.internal.zzpk     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "_fvt"
            java.lang.Long r19 = java.lang.Long.valueOf(r16)     // Catch:{ all -> 0x00b1 }
            java.lang.String r20 = "auto"
            r15 = r0
            r16 = r3
            r17 = r23
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00b1 }
            r1.zzab(r0, r2)     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzhy r0 = r25.zzaW()     // Catch:{ all -> 0x00b1 }
            r0.zzg()     // Catch:{ all -> 0x00b1 }
            r25.zzu()     // Catch:{ all -> 0x00b1 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00b1 }
            r0.<init>()     // Catch:{ all -> 0x00b1 }
            r3 = 1
            r0.putLong(r11, r3)     // Catch:{ all -> 0x00b1 }
            r0.putLong(r10, r3)     // Catch:{ all -> 0x00b1 }
            r0.putLong(r9, r3)     // Catch:{ all -> 0x00b1 }
            boolean r5 = r2.zzo     // Catch:{ all -> 0x00b1 }
            if (r5 == 0) goto L_0x03c2
            r0.putLong(r6, r3)     // Catch:{ all -> 0x00b1 }
        L_0x03c2:
            com.google.android.gms.measurement.internal.zzbg r3 = new com.google.android.gms.measurement.internal.zzbg     // Catch:{ all -> 0x00b1 }
            java.lang.String r16 = "_v"
            com.google.android.gms.measurement.internal.zzbe r4 = new com.google.android.gms.measurement.internal.zzbe     // Catch:{ all -> 0x00b1 }
            r4.<init>(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r18 = "auto"
            r15 = r3
            r17 = r4
            r19 = r23
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00b1 }
            r1.zzE(r3, r2)     // Catch:{ all -> 0x00b1 }
            goto L_0x03fa
        L_0x03d9:
            r23 = r13
            boolean r0 = r2.zzi     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x03fa
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00b1 }
            r0.<init>()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzbg r3 = new com.google.android.gms.measurement.internal.zzbg     // Catch:{ all -> 0x00b1 }
            java.lang.String r16 = "_cd"
            com.google.android.gms.measurement.internal.zzbe r4 = new com.google.android.gms.measurement.internal.zzbe     // Catch:{ all -> 0x00b1 }
            r4.<init>(r0)     // Catch:{ all -> 0x00b1 }
            java.lang.String r18 = "auto"
            r15 = r3
            r17 = r4
            r19 = r23
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00b1 }
            r1.zzE(r3, r2)     // Catch:{ all -> 0x00b1 }
        L_0x03fa:
            com.google.android.gms.measurement.internal.zzav r0 = r25.zzj()     // Catch:{ all -> 0x00b1 }
            r0.zzc()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.measurement.internal.zzav r0 = r25.zzj()
            r0.zzd()
            return
        L_0x0409:
            com.google.android.gms.measurement.internal.zzav r2 = r25.zzj()
            r2.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzag(com.google.android.gms.measurement.internal.zzr):void");
    }

    @WorkerThread
    public final void zzah(zzr zzr2) {
        zzaW().zzg();
        zzu();
        Preconditions.checkNotNull(zzr2);
        String str = zzr2.zza;
        Preconditions.checkNotEmpty(str);
        int i = 0;
        if (zzd().zzp((String) null, zzfx.zzaz)) {
            long currentTimeMillis = zzaZ().currentTimeMillis();
            int zzm2 = zzd().zzm((String) null, zzfx.zzai);
            zzd();
            long zzF2 = currentTimeMillis - zzal.zzF();
            while (i < zzm2 && zzaF((String) null, zzF2)) {
                i++;
            }
        } else {
            zzd();
            long zzH2 = zzal.zzH();
            while (((long) i) < zzH2 && zzaF(str, 0)) {
                i++;
            }
        }
        if (zzd().zzp((String) null, zzfx.zzaA)) {
            zzaW().zzg();
            zzau();
        }
        if (this.zzl.zzc(str, zzin.zzb(zzr2.zzE))) {
            zzaV().zzk().zzb("[sgtm] Going background, trigger client side upload. appId", str);
            zzN(str, zzaZ().currentTimeMillis());
        }
    }

    @WorkerThread
    public final void zzai(zzah zzah) {
        zzr zzaN = zzaN((String) Preconditions.checkNotNull(zzah.zza));
        if (zzaN != null) {
            zzaj(zzah, zzaN);
        }
    }

    @WorkerThread
    public final void zzaj(zzah zzah, zzr zzr2) {
        Preconditions.checkNotNull(zzah);
        Preconditions.checkNotEmpty(zzah.zza);
        Preconditions.checkNotNull(zzah.zzb);
        Preconditions.checkNotNull(zzah.zzc);
        Preconditions.checkNotEmpty(zzah.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaQ(zzr2)) {
            if (!zzr2.zzh) {
                zzan(zzr2);
                return;
            }
            zzah zzah2 = new zzah(zzah);
            boolean z = false;
            zzah2.zze = false;
            zzj().zzb();
            try {
                zzah zzq2 = zzj().zzq((String) Preconditions.checkNotNull(zzah2.zza), zzah2.zzc.zzb);
                if (zzq2 != null && !zzq2.zzb.equals(zzah2.zzb)) {
                    zzaV().zze().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzn.zzl().zzc(zzah2.zzc.zzb), zzah2.zzb, zzq2.zzb);
                }
                if (zzq2 != null && zzq2.zze) {
                    zzah2.zzb = zzq2.zzb;
                    zzah2.zzd = zzq2.zzd;
                    zzah2.zzh = zzq2.zzh;
                    zzah2.zzf = zzq2.zzf;
                    zzah2.zzi = zzq2.zzi;
                    zzah2.zze = true;
                    zzpk zzpk = zzah2.zzc;
                    zzah2.zzc = new zzpk(zzpk.zzb, zzq2.zzc.zzc, zzpk.zza(), zzq2.zzc.zzf);
                } else if (TextUtils.isEmpty(zzah2.zzf)) {
                    zzpk zzpk2 = zzah2.zzc;
                    zzah2.zzc = new zzpk(zzpk2.zzb, zzah2.zzd, zzpk2.zza(), zzah2.zzc.zzf);
                    zzah2.zze = true;
                    z = true;
                }
                if (zzah2.zze) {
                    zzpk zzpk3 = zzah2.zzc;
                    zzpm zzpm = new zzpm((String) Preconditions.checkNotNull(zzah2.zza), zzah2.zzb, zzpk3.zzb, zzpk3.zzc, Preconditions.checkNotNull(zzpk3.zza()));
                    if (zzj().zzl(zzpm)) {
                        zzaV().zzj().zzd("User property updated immediately", zzah2.zza, this.zzn.zzl().zzc(zzpm.zzc), zzpm.zze);
                    } else {
                        zzaV().zzb().zzd("(2)Too many active user properties, ignoring", zzgt.zzl(zzah2.zza), this.zzn.zzl().zzc(zzpm.zzc), zzpm.zze);
                    }
                    if (z && zzah2.zzi != null) {
                        zzH(new zzbg(zzah2.zzi, zzah2.zzd), zzr2);
                    }
                }
                if (zzj().zzp(zzah2)) {
                    zzaV().zzj().zzd("Conditional property added", zzah2.zza, this.zzn.zzl().zzc(zzah2.zzc.zzb), zzah2.zzc.zza());
                } else {
                    zzaV().zzb().zzd("Too many conditional properties, ignoring", zzgt.zzl(zzah2.zza), this.zzn.zzl().zzc(zzah2.zzc.zzb), zzah2.zzc.zza());
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    @WorkerThread
    public final void zzak(zzah zzah) {
        zzr zzaN = zzaN((String) Preconditions.checkNotNull(zzah.zza));
        if (zzaN != null) {
            zzal(zzah, zzaN);
        }
    }

    @WorkerThread
    public final void zzal(zzah zzah, zzr zzr2) {
        Bundle bundle;
        Preconditions.checkNotNull(zzah);
        Preconditions.checkNotEmpty(zzah.zza);
        Preconditions.checkNotNull(zzah.zzc);
        Preconditions.checkNotEmpty(zzah.zzc.zzb);
        zzaW().zzg();
        zzu();
        if (zzaQ(zzr2)) {
            if (!zzr2.zzh) {
                zzan(zzr2);
                return;
            }
            zzj().zzb();
            try {
                zzan(zzr2);
                String str = (String) Preconditions.checkNotNull(zzah.zza);
                zzah zzq2 = zzj().zzq(str, zzah.zzc.zzb);
                if (zzq2 != null) {
                    zzaV().zzj().zzc("Removing conditional user property", zzah.zza, this.zzn.zzl().zzc(zzah.zzc.zzb));
                    zzj().zzr(str, zzah.zzc.zzb);
                    if (zzq2.zze) {
                        zzj().zzk(str, zzah.zzc.zzb);
                    }
                    zzbg zzbg = zzah.zzk;
                    if (zzbg != null) {
                        zzbe zzbe = zzbg.zzb;
                        if (zzbe != null) {
                            bundle = zzbe.zzf();
                        } else {
                            bundle = null;
                        }
                        zzH((zzbg) Preconditions.checkNotNull(zzt().zzac(str, ((zzbg) Preconditions.checkNotNull(zzbg)).zza, bundle, zzq2.zzb, zzbg.zzd, true, true)), zzr2);
                    }
                } else {
                    zzaV().zze().zzc("Conditional user property doesn't exist", zzgt.zzl(zzah.zza), this.zzn.zzl().zzc(zzah.zzc.zzb));
                }
                zzj().zzc();
                zzj().zzd();
            } catch (Throwable th) {
                zzj().zzd();
                throw th;
            }
        }
    }

    @WorkerThread
    public final void zzam(zzr zzr2, long j) {
        boolean z;
        zzh zzu2 = zzj().zzu((String) Preconditions.checkNotNull(zzr2.zza));
        if (zzu2 != null && zzt().zzB(zzr2.zzb, zzu2.zzf())) {
            zzaV().zze().zzb("New GMP App Id passed in. Removing cached database data. appId", zzgt.zzl(zzu2.zzc()));
            zzav zzj2 = zzj();
            String zzc2 = zzu2.zzc();
            zzj2.zzay();
            zzj2.zzg();
            Preconditions.checkNotEmpty(zzc2);
            try {
                SQLiteDatabase zze2 = zzj2.zze();
                String[] strArr = {zzc2};
                int delete = zze2.delete("events", "app_id=?", strArr) + zze2.delete("user_attributes", "app_id=?", strArr) + zze2.delete("conditional_properties", "app_id=?", strArr) + zze2.delete("apps", "app_id=?", strArr) + zze2.delete("raw_events", "app_id=?", strArr) + zze2.delete("raw_events_metadata", "app_id=?", strArr) + zze2.delete("event_filters", "app_id=?", strArr) + zze2.delete("property_filters", "app_id=?", strArr) + zze2.delete("audience_filter_values", "app_id=?", strArr) + zze2.delete("consent_settings", "app_id=?", strArr) + zze2.delete("default_event_params", "app_id=?", strArr) + zze2.delete("trigger_uris", "app_id=?", strArr);
                zzpk.zza();
                zzib zzib = zzj2.zzu;
                if (zzib.zzc().zzp((String) null, zzfx.zzbi)) {
                    delete += zze2.delete("no_data_mode_events", "app_id=?", strArr);
                }
                if (delete > 0) {
                    zzib.zzaV().zzk().zzc("Deleted application data. app, records", zzc2, Integer.valueOf(delete));
                }
            } catch (SQLiteException e) {
                zzj2.zzu.zzaV().zzb().zzc("Error deleting application data. appId, error", zzgt.zzl(zzc2), e);
            }
            zzu2 = null;
        }
        if (zzu2 != null) {
            boolean z2 = true;
            if (zzu2.zzt() == -2147483648L || zzu2.zzt() == zzr2.zzj) {
                z = false;
            } else {
                z = true;
            }
            String zzr3 = zzu2.zzr();
            if (zzu2.zzt() != -2147483648L || zzr3 == null || zzr3.equals(zzr2.zzc)) {
                z2 = false;
            }
            if (z2 || z) {
                zzbg zzbg = new zzbg("_au", new zzbe(e.c("_pv", zzr3)), "auto", j);
                if (zzd().zzp((String) null, zzfx.zzbd)) {
                    zzE(zzbg, zzr2);
                } else {
                    zzF(zzbg, zzr2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01df, code lost:
        if (r11 != false) goto L_0x01e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01e2  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzh zzan(com.google.android.gms.measurement.internal.zzr r14) {
        /*
            r13 = this;
            com.google.android.gms.measurement.internal.zzhy r0 = r13.zzaW()
            r0.zzg()
            r13.zzu()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            java.lang.String r2 = r14.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)
            java.lang.String r0 = r14.zzt
            boolean r1 = r0.isEmpty()
            r8 = 0
            if (r1 != 0) goto L_0x0025
            java.util.Map r1 = r13.zzE
            com.google.android.gms.measurement.internal.zzpc r3 = new com.google.android.gms.measurement.internal.zzpc
            r3.<init>(r13, r0, r8)
            r1.put(r2, r3)
        L_0x0025:
            com.google.android.gms.measurement.internal.zzav r0 = r13.zzj()
            com.google.android.gms.measurement.internal.zzh r0 = r0.zzu(r2)
            com.google.android.gms.measurement.internal.zzjk r1 = r13.zzB(r2)
            java.lang.String r3 = r14.zzs
            r4 = 100
            com.google.android.gms.measurement.internal.zzjk r3 = com.google.android.gms.measurement.internal.zzjk.zzf(r3, r4)
            com.google.android.gms.measurement.internal.zzjk r1 = r1.zzs(r3)
            com.google.android.gms.measurement.internal.zzjj r3 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE
            boolean r4 = r1.zzo(r3)
            if (r4 == 0) goto L_0x004e
            com.google.android.gms.measurement.internal.zznm r4 = r13.zzk
            boolean r5 = r14.zzn
            java.lang.String r4 = r4.zzf(r2, r5)
            goto L_0x0050
        L_0x004e:
            java.lang.String r4 = ""
        L_0x0050:
            r9 = 1
            r10 = 0
            if (r0 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzib r0 = r13.zzn
            com.google.android.gms.measurement.internal.zzh r5 = new com.google.android.gms.measurement.internal.zzh
            r5.<init>(r0, r2)
            com.google.android.gms.measurement.internal.zzjj r0 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r0 = r1.zzo(r0)
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = r13.zzK(r1)
            r5.zze(r0)
        L_0x006a:
            boolean r0 = r1.zzo(r3)
            if (r0 == 0) goto L_0x0073
            r5.zzk(r4)
        L_0x0073:
            r0 = r5
        L_0x0074:
            r11 = 0
            goto L_0x012a
        L_0x0077:
            boolean r3 = r1.zzo(r3)
            if (r3 == 0) goto L_0x010f
            if (r4 == 0) goto L_0x010f
            java.lang.String r3 = r0.zzj()
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x010f
            java.lang.String r3 = r0.zzj()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r0.zzk(r4)
            boolean r4 = r14.zzn
            if (r4 == 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zznm r4 = r13.zzk
            android.util.Pair r4 = r4.zzc(r2, r1)
            java.lang.Object r4 = r4.first
            java.lang.String r5 = "00000000-0000-0000-0000-000000000000"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00f4
            if (r3 != 0) goto L_0x00f4
            com.google.android.gms.measurement.internal.zzjj r3 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r3 = r1.zzo(r3)
            if (r3 == 0) goto L_0x00bb
            java.lang.String r1 = r13.zzK(r1)
            r0.zze(r1)
            r11 = 0
            goto L_0x00bc
        L_0x00bb:
            r11 = 1
        L_0x00bc:
            com.google.android.gms.measurement.internal.zzav r1 = r13.zzj()
            java.lang.String r3 = "_id"
            com.google.android.gms.measurement.internal.zzpm r1 = r1.zzm(r2, r3)
            if (r1 == 0) goto L_0x012a
            com.google.android.gms.measurement.internal.zzav r1 = r13.zzj()
            java.lang.String r3 = "_lair"
            com.google.android.gms.measurement.internal.zzpm r1 = r1.zzm(r2, r3)
            if (r1 != 0) goto L_0x012a
            com.google.android.gms.common.util.Clock r1 = r13.zzaZ()
            long r5 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzpm r12 = new com.google.android.gms.measurement.internal.zzpm
            r3 = 1
            java.lang.Long r7 = java.lang.Long.valueOf(r3)
            java.lang.String r3 = "auto"
            java.lang.String r4 = "_lair"
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r7)
            com.google.android.gms.measurement.internal.zzav r1 = r13.zzj()
            r1.zzl(r12)
            goto L_0x012a
        L_0x00f4:
            java.lang.String r2 = r0.zzd()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzjj r2 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r2 = r1.zzo(r2)
            if (r2 == 0) goto L_0x0074
            java.lang.String r1 = r13.zzK(r1)
            r0.zze(r1)
            goto L_0x0074
        L_0x010f:
            java.lang.String r2 = r0.zzd()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzjj r2 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE
            boolean r2 = r1.zzo(r2)
            if (r2 == 0) goto L_0x0074
            java.lang.String r1 = r13.zzK(r1)
            r0.zze(r1)
            goto L_0x0074
        L_0x012a:
            java.lang.String r1 = r14.zzb
            r0.zzg(r1)
            java.lang.String r1 = r14.zzk
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x013a
            r0.zzm(r1)
        L_0x013a:
            long r1 = r14.zze
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0145
            r0.zzy(r1)
        L_0x0145:
            java.lang.String r1 = r14.zzc
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0150
            r0.zzs(r1)
        L_0x0150:
            long r1 = r14.zzj
            r0.zzu(r1)
            java.lang.String r1 = r14.zzd
            if (r1 == 0) goto L_0x015c
            r0.zzw(r1)
        L_0x015c:
            long r1 = r14.zzf
            r0.zzA(r1)
            boolean r1 = r14.zzh
            r0.zzE(r1)
            java.lang.String r1 = r14.zzg
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0171
            r0.zzab(r1)
        L_0x0171:
            boolean r1 = r14.zzn
            r0.zzad(r1)
            java.lang.Boolean r1 = r14.zzp
            r0.zzaf(r1)
            long r1 = r14.zzq
            r0.zzC(r1)
            java.lang.String r1 = r14.zzu
            r0.zzi(r1)
            com.google.android.gms.internal.measurement.zzpn.zza()
            com.google.android.gms.measurement.internal.zzal r1 = r13.zzd()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzaL
            boolean r1 = r1.zzp(r8, r2)
            if (r1 == 0) goto L_0x019a
            java.util.List r1 = r14.zzr
            r0.zzah(r1)
            goto L_0x01ac
        L_0x019a:
            com.google.android.gms.internal.measurement.zzpn.zza()
            com.google.android.gms.measurement.internal.zzal r1 = r13.zzd()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzaK
            boolean r1 = r1.zzp(r8, r2)
            if (r1 == 0) goto L_0x01ac
            r0.zzah(r8)
        L_0x01ac:
            boolean r1 = r14.zzv
            r0.zzaj(r1)
            java.lang.String r1 = r14.zzB
            r0.zzaz(r1)
            com.google.android.gms.internal.measurement.zzql.zza()
            com.google.android.gms.measurement.internal.zzal r1 = r13.zzd()
            com.google.android.gms.measurement.internal.zzfw r2 = com.google.android.gms.measurement.internal.zzfx.zzaP
            boolean r1 = r1.zzp(r8, r2)
            if (r1 == 0) goto L_0x01ca
            int r1 = r14.zzz
            r0.zzap(r1)
        L_0x01ca:
            long r1 = r14.zzw
            r0.zzal(r1)
            java.lang.String r1 = r14.zzC
            r0.zzaG(r1)
            int r14 = r14.zzE
            r0.zzaK(r14)
            boolean r14 = r0.zza()
            if (r14 != 0) goto L_0x01e2
            if (r11 == 0) goto L_0x01ea
            goto L_0x01e3
        L_0x01e2:
            r9 = r11
        L_0x01e3:
            com.google.android.gms.measurement.internal.zzav r14 = r13.zzj()
            r14.zzv(r0, r9, r10)
        L_0x01ea:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzan(com.google.android.gms.measurement.internal.zzr):com.google.android.gms.measurement.internal.zzh");
    }

    public final String zzao(zzr zzr2) {
        try {
            return (String) zzaW().zzh(new zzoy(this, zzr2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzaV().zzb().zzc("Failed to get app instance id. appId", zzgt.zzl(zzr2.zza), e);
            return null;
        }
    }

    @WorkerThread
    public final List zzap(zzr zzr2, Bundle bundle) {
        List list;
        zzr zzr3 = zzr2;
        Bundle bundle2 = bundle;
        zzaW().zzg();
        zzql.zza();
        zzal zzd2 = zzd();
        String str = zzr3.zza;
        if (!zzd2.zzp(str, zzfx.zzaP) || str == null) {
            return new ArrayList();
        }
        if (bundle2 != null) {
            int[] intArray = bundle2.getIntArray("uriSources");
            long[] longArray = bundle2.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzaV().zzb().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i = 0; i < intArray.length; i++) {
                        zzav zzj2 = zzj();
                        int i2 = intArray[i];
                        long j = longArray[i];
                        Preconditions.checkNotEmpty(str);
                        zzj2.zzg();
                        zzj2.zzay();
                        try {
                            int delete = zzj2.zze().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i2), String.valueOf(j)});
                            zzgr zzk2 = zzj2.zzu.zzaV().zzk();
                            StringBuilder sb = new StringBuilder(String.valueOf(delete).length() + 46);
                            sb.append("Pruned ");
                            sb.append(delete);
                            sb.append(" trigger URIs. appId, source, timestamp");
                            zzk2.zzd(sb.toString(), str, Integer.valueOf(i2), Long.valueOf(j));
                        } catch (SQLiteException e) {
                            zzj2.zzu.zzaV().zzb().zzc("Error pruning trigger URIs. appId", zzgt.zzl(str), e);
                        }
                    }
                }
            }
        }
        zzav zzj3 = zzj();
        String str2 = zzr3.zza;
        Preconditions.checkNotEmpty(str2);
        zzj3.zzg();
        zzj3.zzay();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = zzj3.zze().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str2}, (String) null, (String) null, "rowid", (String) null);
            list = arrayList;
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    arrayList.add(new zzog(string, cursor.getLong(1), cursor.getInt(2)));
                } while (cursor.moveToNext());
                list = arrayList;
            }
        } catch (SQLiteException e2) {
            zzj3.zzu.zzaV().zzb().zzc("Error querying trigger uris. appId", zzgt.zzl(str2), e2);
            list = Collections.emptyList();
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

    @WorkerThread
    public final void zzaq(String str, zzaf zzaf) {
        zzaW().zzg();
        zzu();
        zzav zzj2 = zzj();
        long j = zzaf.zza;
        zzpi zzB2 = zzj2.zzB(j);
        if (zzB2 == null) {
            zzaV().zze().zzc("[sgtm] Queued batch doesn't exist. appId, rowId", str, Long.valueOf(j));
            return;
        }
        String zze2 = zzB2.zze();
        if (zzaf.zzb == zzlq.SUCCESS.zza()) {
            Map map = this.zzF;
            if (map.containsKey(zze2)) {
                map.remove(zze2);
            }
            zzav zzj3 = zzj();
            Long valueOf = Long.valueOf(j);
            zzj3.zzE(valueOf);
            zzaV().zzk().zzc("[sgtm] queued batch deleted after successful client upload. appId, rowId", str, valueOf);
            long j2 = zzaf.zzc;
            if (j2 > 0) {
                zzav zzj4 = zzj();
                zzj4.zzg();
                zzj4.zzay();
                Long valueOf2 = Long.valueOf(j2);
                Preconditions.checkNotNull(valueOf2);
                ContentValues contentValues = new ContentValues();
                contentValues.put("upload_type", Integer.valueOf(zzlr.GOOGLE_SIGNAL.zza()));
                zzib zzib = zzj4.zzu;
                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzib.zzaZ().currentTimeMillis()));
                try {
                    if (((long) zzj4.zze().update("upload_queue", contentValues, "rowid=? AND app_id=? AND upload_type=?", new String[]{String.valueOf(j2), str, String.valueOf(zzlr.GOOGLE_SIGNAL_PENDING.zza())})) != 1) {
                        zzib.zzaV().zze().zzc("Google Signal pending batch not updated. appId, rowId", str, valueOf2);
                    }
                    zzaV().zzk().zzc("[sgtm] queued Google Signal batch updated. appId, signalRowId", str, Long.valueOf(zzaf.zzc));
                    zzP(str);
                } catch (SQLiteException e) {
                    zzj4.zzu.zzaV().zzb().zzd("Failed to update google Signal pending batch. appid, rowId", str, Long.valueOf(j2), e);
                    throw e;
                }
            }
        } else {
            if (zzaf.zzb == zzlq.BACKOFF.zza()) {
                Map map2 = this.zzF;
                zzpd zzpd = (zzpd) map2.get(zze2);
                if (zzpd == null) {
                    zzpd = new zzpd(this);
                    map2.put(zze2, zzpd);
                } else {
                    zzpd.zza();
                }
                zzaV().zzk().zzd("[sgtm] Putting sGTM server in backoff mode. appId, destination, nextRetryInSeconds", str, zze2, Long.valueOf((zzpd.zzc() - zzaZ().currentTimeMillis()) / 1000));
            }
            zzav zzj5 = zzj();
            Long valueOf3 = Long.valueOf(zzaf.zza);
            zzj5.zzK(valueOf3);
            zzaV().zzk().zzc("[sgtm] increased batch retry count after failed client upload. appId, rowId", str, valueOf3);
        }
    }

    public final void zzar(boolean z) {
        zzaK();
    }

    @WorkerThread
    public final void zzas(String str, zzlt zzlt) {
        zzaW().zzg();
        String str2 = this.zzH;
        if (str2 == null || str2.equals(str) || zzlt != null) {
            this.zzH = str;
            this.zzG = zzlt;
        }
    }

    public final /* synthetic */ void zzat(zzpg zzpg) {
        zzaW().zzg();
        this.zzm = new zzhj(this);
        zzav zzav = new zzav(this);
        zzav.zzaz();
        this.zze = zzav;
        zzd().zza((zzak) Preconditions.checkNotNull(this.zzc));
        zznm zznm = new zznm(this);
        zznm.zzaz();
        this.zzk = zznm;
        zzad zzad = new zzad(this);
        zzad.zzaz();
        this.zzh = zzad;
        zzlo zzlo = new zzlo(this);
        zzlo.zzaz();
        this.zzj = zzlo;
        zzoj zzoj = new zzoj(this);
        zzoj.zzaz();
        this.zzg = zzoj;
        this.zzf = new zzha(this);
        if (this.zzs != this.zzt) {
            zzaV().zzb().zzc("Not all upload components initialized", Integer.valueOf(this.zzs), Integer.valueOf(this.zzt));
        }
        this.zzo.set(true);
        zzaV().zzk().zza("UploadController is now fully initialized");
    }

    public final /* synthetic */ zzib zzaw() {
        return this.zzn;
    }

    public final /* synthetic */ Deque zzax() {
        return this.zzr;
    }

    public final /* synthetic */ void zzay(long j) {
        this.zzJ = j;
    }

    @WorkerThread
    public final void zzc() {
        zzaW().zzg();
        zzj().zzI();
        zzav zzj2 = zzj();
        zzj2.zzg();
        zzj2.zzay();
        if (zzj2.zzai()) {
            zzfw zzfw = zzfx.zzav;
            if (((Long) zzfw.zzb((Object) null)).longValue() != 0) {
                SQLiteDatabase zze2 = zzj2.zze();
                zzib zzib = zzj2.zzu;
                int delete = zze2.delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(zzib.zzaZ().currentTimeMillis()), String.valueOf(zzfw.zzb((Object) null))});
                if (delete > 0) {
                    zzib.zzaV().zzk().zzb("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
        if (this.zzk.zzd.zza() == 0) {
            this.zzk.zzd.zzb(zzaZ().currentTimeMillis());
        }
        zzaK();
    }

    public final zzal zzd() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzc();
    }

    public final zzot zzf() {
        return this.zzl;
    }

    public final zzhs zzh() {
        zzhs zzhs = this.zzc;
        zzaS(zzhs);
        return zzhs;
    }

    public final zzgy zzi() {
        zzgy zzgy = this.zzd;
        zzaS(zzgy);
        return zzgy;
    }

    public final zzav zzj() {
        zzav zzav = this.zze;
        zzaS(zzav);
        return zzav;
    }

    public final zzha zzk() {
        zzha zzha = this.zzf;
        if (zzha != null) {
            return zzha;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public final zzoj zzl() {
        zzoj zzoj = this.zzg;
        zzaS(zzoj);
        return zzoj;
    }

    public final zzad zzm() {
        zzad zzad = this.zzh;
        zzaS(zzad);
        return zzad;
    }

    public final zzlo zzn() {
        zzlo zzlo = this.zzj;
        zzaS(zzlo);
        return zzlo;
    }

    public final zzpj zzp() {
        zzpj zzpj = this.zzi;
        zzaS(zzpj);
        return zzpj;
    }

    public final zznm zzq() {
        return this.zzk;
    }

    public final zzgm zzs() {
        return this.zzn.zzl();
    }

    public final zzpo zzt() {
        return ((zzib) Preconditions.checkNotNull(this.zzn)).zzk();
    }

    public final void zzu() {
        if (!this.zzo.get()) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    public final void zzv(zzr zzr2) {
        zzaW().zzg();
        zzu();
        String str = zzr2.zza;
        Preconditions.checkNotEmpty(str);
        zzjk zzf2 = zzjk.zzf(zzr2.zzs, zzr2.zzx);
        zzB(str);
        zzaV().zzk().zzc("Setting storage consent for package", str, zzf2);
        zzA(str, zzf2);
    }

    @WorkerThread
    public final void zzw(zzr zzr2) {
        boolean z;
        zzaW().zzg();
        zzu();
        String str = zzr2.zza;
        Preconditions.checkNotEmpty(str);
        zzaz zzg2 = zzaz.zzg(zzr2.zzy);
        zzaV().zzk().zzc("Setting DMA consent for package", str, zzg2);
        zzaW().zzg();
        zzu();
        zzjh zzc2 = zzaz.zzh(zzy(str), 100).zzc();
        this.zzD.put(str, zzg2);
        zzj().zzad(str, zzg2);
        zzjh zzc3 = zzaz.zzh(zzy(str), 100).zzc();
        zzaW().zzg();
        zzu();
        zzjh zzjh = zzjh.DENIED;
        boolean z2 = true;
        if (zzc2 == zzjh && zzc3 == zzjh.GRANTED) {
            z = true;
        } else {
            z = false;
        }
        if (!(zzc2 == zzjh.GRANTED && zzc3 == zzjh)) {
            z2 = false;
        }
        if (z || z2) {
            zzaV().zzk().zzb("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (zzj().zzw(zzC(), str, false, false, false, false, false, false, false).zzf < ((long) zzd().zzm(str, zzfx.zzam))) {
                bundle.putLong("_r", 1);
                zzaV().zzk().zzc("_dcu realtime event count", str, Long.valueOf(zzj().zzw(zzC(), str, false, false, false, false, false, true, false).zzf));
            }
            this.zzK.zza(str, "_dcu", bundle);
        }
    }

    @WorkerThread
    public final zzaz zzx(String str) {
        zzaW().zzg();
        zzu();
        Map map = this.zzD;
        zzaz zzaz = (zzaz) map.get(str);
        if (zzaz != null) {
            return zzaz;
        }
        zzaz zzac = zzj().zzac(str);
        map.put(str, zzac);
        return zzac;
    }

    @WorkerThread
    public final Bundle zzy(String str) {
        int i;
        String str2;
        zzaW().zzg();
        zzu();
        if (zzh().zzx(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        zzjk zzB2 = zzB(str);
        bundle.putAll(zzB2.zzn());
        bundle.putAll(zzz(str, zzx(str), zzB2, new zzan()).zzf());
        zzpm zzm2 = zzj().zzm(str, "_npa");
        if (zzm2 != null) {
            i = zzm2.zze.equals(1L);
        } else {
            i = zzaB(str, new zzan());
        }
        if (1 != i) {
            str2 = "granted";
        } else {
            str2 = "denied";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r11 = r9.zzc;
        r0 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA;
     */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzaz zzz(java.lang.String r10, com.google.android.gms.measurement.internal.zzaz r11, com.google.android.gms.measurement.internal.zzjk r12, com.google.android.gms.measurement.internal.zzan r13) {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzhs r0 = r9.zzh()
            com.google.android.gms.internal.measurement.zzgf r0 = r0.zzx(r10)
            java.lang.String r1 = "-"
            r2 = 90
            if (r0 != 0) goto L_0x0031
            com.google.android.gms.measurement.internal.zzjh r10 = r11.zzc()
            com.google.android.gms.measurement.internal.zzjh r12 = com.google.android.gms.measurement.internal.zzjh.DENIED
            if (r10 != r12) goto L_0x0020
            int r2 = r11.zzb()
            com.google.android.gms.measurement.internal.zzjj r10 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA
            r13.zzb(r10, r2)
            goto L_0x0027
        L_0x0020:
            com.google.android.gms.measurement.internal.zzjj r10 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzam r11 = com.google.android.gms.measurement.internal.zzam.FAILSAFE
            r13.zzc(r10, r11)
        L_0x0027:
            com.google.android.gms.measurement.internal.zzaz r10 = new com.google.android.gms.measurement.internal.zzaz
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r10.<init>((java.lang.Boolean) r11, (int) r2, (java.lang.Boolean) r12, (java.lang.String) r1)
            return r10
        L_0x0031:
            com.google.android.gms.measurement.internal.zzjh r0 = r11.zzc()
            com.google.android.gms.measurement.internal.zzjh r3 = com.google.android.gms.measurement.internal.zzjh.GRANTED
            if (r0 == r3) goto L_0x0085
            com.google.android.gms.measurement.internal.zzjh r4 = com.google.android.gms.measurement.internal.zzjh.DENIED
            if (r0 != r4) goto L_0x003e
            goto L_0x0085
        L_0x003e:
            com.google.android.gms.measurement.internal.zzjh r11 = com.google.android.gms.measurement.internal.zzjh.POLICY
            if (r0 != r11) goto L_0x0055
            com.google.android.gms.measurement.internal.zzhs r11 = r9.zzc
            com.google.android.gms.measurement.internal.zzjj r0 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzjh r11 = r11.zzA(r10, r0)
            com.google.android.gms.measurement.internal.zzjh r5 = com.google.android.gms.measurement.internal.zzjh.UNINITIALIZED
            if (r11 == r5) goto L_0x0055
            com.google.android.gms.measurement.internal.zzam r12 = com.google.android.gms.measurement.internal.zzam.REMOTE_ENFORCED_DEFAULT
            r13.zzc(r0, r12)
            r0 = r11
            goto L_0x008e
        L_0x0055:
            com.google.android.gms.measurement.internal.zzhs r11 = r9.zzc
            com.google.android.gms.measurement.internal.zzjj r0 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA
            com.google.android.gms.measurement.internal.zzjj r5 = r11.zzw(r10, r0)
            com.google.android.gms.measurement.internal.zzjh r12 = r12.zzp()
            r6 = 1
            if (r12 == r3) goto L_0x0066
            if (r12 != r4) goto L_0x0068
        L_0x0066:
            r7 = 1
            goto L_0x0069
        L_0x0068:
            r7 = 0
        L_0x0069:
            com.google.android.gms.measurement.internal.zzjj r8 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE
            if (r5 != r8) goto L_0x0076
            if (r7 == 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzam r11 = com.google.android.gms.measurement.internal.zzam.REMOTE_DELEGATION
            r13.zzc(r0, r11)
            r0 = r12
            goto L_0x008e
        L_0x0076:
            com.google.android.gms.measurement.internal.zzam r12 = com.google.android.gms.measurement.internal.zzam.REMOTE_DEFAULT
            r13.zzc(r0, r12)
            boolean r11 = r11.zzv(r10, r0)
            if (r6 == r11) goto L_0x0083
            r0 = r4
            goto L_0x008e
        L_0x0083:
            r0 = r3
            goto L_0x008e
        L_0x0085:
            int r2 = r11.zzb()
            com.google.android.gms.measurement.internal.zzjj r11 = com.google.android.gms.measurement.internal.zzjj.AD_USER_DATA
            r13.zzb(r11, r2)
        L_0x008e:
            com.google.android.gms.measurement.internal.zzhs r11 = r9.zzc
            boolean r11 = r11.zzy(r10)
            com.google.android.gms.measurement.internal.zzhs r12 = r9.zzh()
            java.util.SortedSet r10 = r12.zzz(r10)
            com.google.android.gms.measurement.internal.zzjh r12 = com.google.android.gms.measurement.internal.zzjh.DENIED
            if (r0 == r12) goto L_0x00bb
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L_0x00a7
            goto L_0x00bb
        L_0x00a7:
            com.google.android.gms.measurement.internal.zzaz r12 = new com.google.android.gms.measurement.internal.zzaz
            java.lang.Boolean r13 = java.lang.Boolean.TRUE
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            java.lang.String r1 = ""
            if (r11 == 0) goto L_0x00b7
            java.lang.String r1 = android.text.TextUtils.join(r1, r10)
        L_0x00b7:
            r12.<init>((java.lang.Boolean) r13, (int) r2, (java.lang.Boolean) r0, (java.lang.String) r1)
            return r12
        L_0x00bb:
            com.google.android.gms.measurement.internal.zzaz r10 = new com.google.android.gms.measurement.internal.zzaz
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r10.<init>((java.lang.Boolean) r12, (int) r2, (java.lang.Boolean) r11, (java.lang.String) r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzpf.zzz(java.lang.String, com.google.android.gms.measurement.internal.zzaz, com.google.android.gms.measurement.internal.zzjk, com.google.android.gms.measurement.internal.zzan):com.google.android.gms.measurement.internal.zzaz");
    }
}
