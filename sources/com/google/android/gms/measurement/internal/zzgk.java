package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;

public final class zzgk extends zzg {
    /* access modifiers changed from: private */
    public static final String[] zza = {"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    private final zzgi zzb;
    private boolean zzc;

    public zzgk(zzib zzib) {
        super(zzib);
        Context zzaY = this.zzu.zzaY();
        this.zzu.zzc();
        this.zzb = new zzgi(this, zzaY, "google_app_measurement_local.db");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ff A[SYNTHETIC, Splitter:B:56:0x00ff] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0152 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0152 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0152 A[SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzs(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            r17.zzg()
            boolean r0 = r1.zzc
            r2 = 0
            if (r0 == 0) goto L_0x000b
            goto L_0x006a
        L_0x000b:
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu
            com.google.android.gms.measurement.internal.zzal r0 = r3.zzc()
            com.google.android.gms.measurement.internal.zzfw r4 = com.google.android.gms.measurement.internal.zzfx.zzbc
            r5 = 0
            boolean r0 = r0.zzp(r5, r4)
            if (r0 == 0) goto L_0x0025
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzgh r0 = r0.zzv()
            com.google.android.gms.measurement.internal.zzr r0 = r0.zzh(r5)
            goto L_0x0026
        L_0x0025:
            r0 = r5
        L_0x0026:
            android.content.ContentValues r6 = new android.content.ContentValues
            r6.<init>()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r18)
            java.lang.String r8 = "type"
            r6.put(r8, r7)
            java.lang.String r7 = "entry"
            r8 = r19
            r6.put(r7, r8)
            com.google.android.gms.measurement.internal.zzal r7 = r3.zzc()
            boolean r4 = r7.zzp(r5, r4)
            if (r4 == 0) goto L_0x0059
            if (r0 == 0) goto L_0x0059
            java.lang.String r4 = "app_version"
            java.lang.String r7 = r0.zzc
            r6.put(r4, r7)
            long r7 = r0.zzj
            java.lang.Long r0 = java.lang.Long.valueOf(r7)
            java.lang.String r4 = "app_version_int"
            r6.put(r4, r0)
        L_0x0059:
            r3.zzc()
            r4 = 5
            r7 = 0
            r8 = 5
        L_0x005f:
            if (r7 >= r4) goto L_0x0163
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r17.zzp()     // Catch:{ SQLiteFullException -> 0x0135, SQLiteDatabaseLockedException -> 0x0122, SQLiteException -> 0x00fa, all -> 0x00f7 }
            if (r10 != 0) goto L_0x0074
            r1.zzc = r9     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x006e, all -> 0x006b }
        L_0x006a:
            return r2
        L_0x006b:
            r0 = move-exception
            goto L_0x0158
        L_0x006e:
            r0 = move-exception
            goto L_0x00f1
        L_0x0071:
            r0 = move-exception
            goto L_0x00f5
        L_0x0074:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x006e, all -> 0x006b }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r11 = r10.rawQuery(r0, r5)     // Catch:{ SQLiteFullException -> 0x0071, SQLiteDatabaseLockedException -> 0x00f3, SQLiteException -> 0x006e, all -> 0x006b }
            r12 = 0
            if (r11 == 0) goto L_0x0094
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            if (r0 == 0) goto L_0x0094
            long r12 = r11.getLong(r2)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            goto L_0x0094
        L_0x008c:
            r0 = move-exception
            goto L_0x00ee
        L_0x008e:
            r0 = move-exception
            goto L_0x00fd
        L_0x0091:
            r0 = move-exception
            goto L_0x0138
        L_0x0094:
            r14 = 100000(0x186a0, double:4.94066E-319)
            java.lang.String r0 = "messages"
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzgt r14 = r3.zzaV()     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zzb()     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            java.lang.String r15 = "Data loss, local db full"
            r14.zza(r15)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            java.lang.String r14 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            r15 = 100001(0x186a1, double:4.9407E-319)
            long r15 = r15 - r12
            java.lang.String r12 = java.lang.Long.toString(r15)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            java.lang.String[] r12 = new java.lang.String[]{r12}     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            int r12 = r10.delete(r0, r14, r12)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            long r12 = (long) r12     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            int r14 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r14 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzgt r14 = r3.zzaV()     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            com.google.android.gms.measurement.internal.zzgr r14 = r14.zzb()     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            java.lang.String r4 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r2 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            java.lang.Long r9 = java.lang.Long.valueOf(r12)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            long r15 = r15 - r12
            java.lang.Long r12 = java.lang.Long.valueOf(r15)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            r14.zzd(r4, r2, r9, r12)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
        L_0x00db:
            r10.insertOrThrow(r0, r5, r6)     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x0091, SQLiteDatabaseLockedException -> 0x0124, SQLiteException -> 0x008e }
            if (r11 == 0) goto L_0x00e9
            r11.close()
        L_0x00e9:
            r10.close()
            r2 = 1
            return r2
        L_0x00ee:
            r5 = r11
            goto L_0x0158
        L_0x00f1:
            r11 = r5
            goto L_0x00fd
        L_0x00f3:
            r11 = r5
            goto L_0x0124
        L_0x00f5:
            r11 = r5
            goto L_0x0138
        L_0x00f7:
            r0 = move-exception
            r10 = r5
            goto L_0x0158
        L_0x00fa:
            r0 = move-exception
            r10 = r5
            r11 = r10
        L_0x00fd:
            if (r10 == 0) goto L_0x0108
            boolean r2 = r10.inTransaction()     // Catch:{ all -> 0x008c }
            if (r2 == 0) goto L_0x0108
            r10.endTransaction()     // Catch:{ all -> 0x008c }
        L_0x0108:
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ all -> 0x008c }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x008c }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x008c }
            java.lang.String r4 = "Error writing entry to local database"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x008c }
            r2 = 1
            r1.zzc = r2     // Catch:{ all -> 0x008c }
            if (r11 == 0) goto L_0x011f
            r11.close()
        L_0x011f:
            if (r10 == 0) goto L_0x0152
            goto L_0x0131
        L_0x0122:
            r10 = r5
            r11 = r10
        L_0x0124:
            long r12 = (long) r8
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x008c }
            int r8 = r8 + 20
            if (r11 == 0) goto L_0x012f
            r11.close()
        L_0x012f:
            if (r10 == 0) goto L_0x0152
        L_0x0131:
            r10.close()
            goto L_0x0152
        L_0x0135:
            r0 = move-exception
            r10 = r5
            r11 = r10
        L_0x0138:
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ all -> 0x008c }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x008c }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x008c }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.zzb(r4, r0)     // Catch:{ all -> 0x008c }
            r2 = 1
            r1.zzc = r2     // Catch:{ all -> 0x008c }
            if (r11 == 0) goto L_0x014f
            r11.close()
        L_0x014f:
            if (r10 == 0) goto L_0x0152
            goto L_0x0131
        L_0x0152:
            int r7 = r7 + 1
            r2 = 0
            r4 = 5
            goto L_0x005f
        L_0x0158:
            if (r5 == 0) goto L_0x015d
            r5.close()
        L_0x015d:
            if (r10 == 0) goto L_0x0162
            r10.close()
        L_0x0162:
            throw r0
        L_0x0163:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.zza(r2)
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgk.zzs(int, byte[]):boolean");
    }

    public final boolean zze() {
        return false;
    }

    @WorkerThread
    public final void zzh() {
        int delete;
        zzg();
        try {
            SQLiteDatabase zzp = zzp();
            if (zzp != null && (delete = zzp.delete("messages", (String) null, (String[]) null)) > 0) {
                this.zzu.zzaV().zzk().zzb("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zzi(zzbg zzbg) {
        Parcel obtain = Parcel.obtain();
        zzbh.zza(zzbg, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzs(0, marshall);
        }
        this.zzu.zzaV().zzc().zza("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zzj(zzpk zzpk) {
        Parcel obtain = Parcel.obtain();
        zzpl.zza(zzpk, obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zzs(1, marshall);
        }
        this.zzu.zzaV().zzc().zza("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzk(zzah zzah) {
        zzib zzib = this.zzu;
        byte[] zzae = zzib.zzk().zzae(zzah);
        if (zzae.length <= 131072) {
            return zzs(2, zzae);
        }
        zzib.zzaV().zzc().zza("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean zzl(zzbe zzbe) {
        zzib zzib = this.zzu;
        byte[] zzae = zzib.zzk().zzae(zzbe);
        if (zzae == null) {
            zzib.zzaV().zzc().zza("Null default event parameters; not writing to database");
            return false;
        } else if (zzae.length <= 131072) {
            return zzs(4, zzae);
        } else {
            zzib.zzaV().zzc().zza("Default event parameters too long for local database. Sending directly to service");
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v29, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v30, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v31, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v43, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.util.List, java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:107|108|109|110) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:123|124|125|126) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:139|140|141|142) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:93|94|95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:108:?, code lost:
        r1.zzu.zzaV().zzb().zza("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01b6, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r15.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:?, code lost:
        r1.zzu.zzaV().zzb().zza("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01f4, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r15.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        r1.zzu.zzaV().zzb().zza("Failed to load default event parameters from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0233, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        r15.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r1.zzu.zzaV().zzb().zza("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0183, code lost:
        r17 = r17;
        r17 = r17;
        r17 = r17;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r15.recycle();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:107:0x01a7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x01e5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x0224 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:93:0x0174 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x02db A[SYNTHETIC, Splitter:B:186:0x02db] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x02fd A[SYNTHETIC, Splitter:B:206:0x02fd] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x031b  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0333  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0352  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x036a  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x02e5 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x035a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x035a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzm(int r29) {
        /*
            r28 = this;
            r1 = r28
            java.lang.String r2 = "Error reading entries from local database"
            java.lang.String r3 = "entry"
            java.lang.String r4 = "type"
            java.lang.String r5 = "rowid"
            r28.zzg()
            boolean r0 = r1.zzc
            r6 = 0
            if (r0 == 0) goto L_0x0013
            return r6
        L_0x0013:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            boolean r0 = r28.zzq()
            if (r0 == 0) goto L_0x0377
            r8 = 5
            r9 = 0
            r10 = 0
            r11 = 5
        L_0x0022:
            if (r10 >= r8) goto L_0x036e
            r12 = 1
            android.database.sqlite.SQLiteDatabase r15 = r28.zzp()     // Catch:{ SQLiteFullException -> 0x033c, SQLiteDatabaseLockedException -> 0x0328, SQLiteException -> 0x02f8, all -> 0x02f3 }
            if (r15 != 0) goto L_0x003d
            r1.zzc = r12     // Catch:{ SQLiteFullException -> 0x0039, SQLiteDatabaseLockedException -> 0x0036, SQLiteException -> 0x0032, all -> 0x002e }
            return r6
        L_0x002e:
            r0 = move-exception
            r12 = r15
            goto L_0x02e6
        L_0x0032:
            r0 = move-exception
            r12 = r15
            goto L_0x02e9
        L_0x0036:
            r12 = r15
            goto L_0x02ec
        L_0x0039:
            r0 = move-exception
            r12 = r15
            goto L_0x02f0
        L_0x003d:
            r15.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0039, SQLiteDatabaseLockedException -> 0x0036, SQLiteException -> 0x0032, all -> 0x002e }
            java.lang.String r0 = "3"
            java.lang.String r14 = "messages"
            java.lang.String[] r16 = new java.lang.String[]{r5}     // Catch:{ all -> 0x02d6 }
            java.lang.String r17 = "type=?"
            java.lang.String[] r0 = new java.lang.String[]{r0}     // Catch:{ all -> 0x02d6 }
            java.lang.String r20 = "rowid desc"
            java.lang.String r21 = "1"
            r18 = 0
            r19 = 0
            r13 = r15
            r29 = r15
            r15 = r16
            r16 = r17
            r17 = r0
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02d2 }
            boolean r0 = r13.moveToFirst()     // Catch:{ all -> 0x0086 }
            r22 = -1
            if (r0 == 0) goto L_0x008b
            long r14 = r13.getLong(r9)     // Catch:{ all -> 0x0086 }
            r13.close()     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            goto L_0x0090
        L_0x0073:
            r0 = move-exception
            r12 = r29
            goto L_0x02e6
        L_0x0078:
            r0 = move-exception
            r12 = r29
            goto L_0x02e9
        L_0x007d:
            r12 = r29
            goto L_0x02ec
        L_0x0081:
            r0 = move-exception
            r12 = r29
            goto L_0x02f0
        L_0x0086:
            r0 = move-exception
            r12 = r29
            goto L_0x02d9
        L_0x008b:
            r13.close()     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r14 = r22
        L_0x0090:
            int r0 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x00a3
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r13[r9] = r14     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r16 = r0
            r17 = r13
            goto L_0x00a7
        L_0x00a3:
            r16 = r6
            r17 = r16
        L_0x00a7:
            java.lang.String[] r0 = new java.lang.String[]{r5, r4, r3}     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            com.google.android.gms.measurement.internal.zzib r15 = r1.zzu     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            com.google.android.gms.measurement.internal.zzal r13 = r15.zzc()     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            com.google.android.gms.measurement.internal.zzfw r14 = com.google.android.gms.measurement.internal.zzfx.zzbc     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            boolean r13 = r13.zzp(r6, r14)     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r6 = 2
            if (r13 == 0) goto L_0x00ce
            java.lang.String[] r0 = new java.lang.String[r8]     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r0[r9] = r5     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r0[r12] = r4     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r0[r6] = r3     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            java.lang.String r13 = "app_version"
            r18 = 3
            r0[r18] = r13     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            java.lang.String r13 = "app_version_int"
            r18 = 4
            r0[r18] = r13     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
        L_0x00ce:
            java.lang.String r18 = "messages"
            java.lang.String r20 = "rowid asc"
            r13 = 100
            java.lang.String r21 = java.lang.Integer.toString(r13)     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
            r19 = 0
            r24 = 0
            r13 = r29
            r8 = r14
            r14 = r18
            r25 = r15
            r15 = r0
            r18 = r19
            r19 = r24
            android.database.Cursor r13 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteFullException -> 0x0081, SQLiteDatabaseLockedException -> 0x007d, SQLiteException -> 0x0078, all -> 0x0073 }
        L_0x00ec:
            boolean r0 = r13.moveToNext()     // Catch:{ SQLiteFullException -> 0x012f, SQLiteDatabaseLockedException -> 0x0129, SQLiteException -> 0x0122, all -> 0x011b }
            if (r0 == 0) goto L_0x0282
            long r22 = r13.getLong(r9)     // Catch:{ SQLiteFullException -> 0x027d, SQLiteDatabaseLockedException -> 0x0279, SQLiteException -> 0x0274, all -> 0x026f }
            int r0 = r13.getInt(r12)     // Catch:{ SQLiteFullException -> 0x027d, SQLiteDatabaseLockedException -> 0x0279, SQLiteException -> 0x0274, all -> 0x026f }
            byte[] r14 = r13.getBlob(r6)     // Catch:{ SQLiteFullException -> 0x027d, SQLiteDatabaseLockedException -> 0x0279, SQLiteException -> 0x0274, all -> 0x026f }
            com.google.android.gms.measurement.internal.zzal r15 = r25.zzc()     // Catch:{ SQLiteFullException -> 0x027d, SQLiteDatabaseLockedException -> 0x0279, SQLiteException -> 0x0274, all -> 0x026f }
            r6 = 0
            boolean r15 = r15.zzp(r6, r8)     // Catch:{ SQLiteFullException -> 0x027d, SQLiteDatabaseLockedException -> 0x0279, SQLiteException -> 0x0274, all -> 0x026f }
            if (r15 == 0) goto L_0x0136
            r6 = 3
            java.lang.String r15 = r13.getString(r6)     // Catch:{ SQLiteFullException -> 0x012f, SQLiteDatabaseLockedException -> 0x0129, SQLiteException -> 0x0122, all -> 0x011b }
            r6 = 4
            long r17 = r13.getLong(r6)     // Catch:{ SQLiteFullException -> 0x012f, SQLiteDatabaseLockedException -> 0x0129, SQLiteException -> 0x0122, all -> 0x011b }
            r6 = r15
        L_0x0114:
            r26 = r17
            r17 = r13
            r12 = r26
            goto L_0x013a
        L_0x011b:
            r0 = move-exception
            r12 = r29
            r17 = r13
            goto L_0x02bf
        L_0x0122:
            r0 = move-exception
            r12 = r29
            r17 = r13
            goto L_0x02c3
        L_0x0129:
            r12 = r29
            r17 = r13
            goto L_0x02c7
        L_0x012f:
            r0 = move-exception
            r12 = r29
            r17 = r13
            goto L_0x02cd
        L_0x0136:
            r17 = 0
            r6 = 0
            goto L_0x0114
        L_0x013a:
            if (r0 != 0) goto L_0x018b
            android.os.Parcel r15 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            int r0 = r14.length     // Catch:{ ParseException -> 0x0174 }
            r15.unmarshall(r14, r9, r0)     // Catch:{ ParseException -> 0x0174 }
            r15.setDataPosition(r9)     // Catch:{ ParseException -> 0x0174 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbg> r0 = com.google.android.gms.measurement.internal.zzbg.CREATOR     // Catch:{ ParseException -> 0x0174 }
            java.lang.Object r0 = r0.createFromParcel(r15)     // Catch:{ ParseException -> 0x0174 }
            com.google.android.gms.measurement.internal.zzbg r0 = (com.google.android.gms.measurement.internal.zzbg) r0     // Catch:{ ParseException -> 0x0174 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            if (r0 == 0) goto L_0x015c
            com.google.android.gms.measurement.internal.zzgj r14 = new com.google.android.gms.measurement.internal.zzgj     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r14.<init>(r0, r6, r12)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r7.add(r14)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
        L_0x015c:
            r6 = 3
            goto L_0x0269
        L_0x015f:
            r0 = move-exception
        L_0x0160:
            r12 = r29
            goto L_0x02bf
        L_0x0164:
            r0 = move-exception
        L_0x0165:
            r12 = r29
            goto L_0x02c3
        L_0x0169:
            r12 = r29
            goto L_0x02c7
        L_0x016d:
            r0 = move-exception
        L_0x016e:
            r12 = r29
            goto L_0x02cd
        L_0x0172:
            r0 = move-exception
            goto L_0x0187
        L_0x0174:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x0172 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x0172 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ all -> 0x0172 }
            java.lang.String r6 = "Failed to load event from local database"
            r0.zza(r6)     // Catch:{ all -> 0x0172 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x015c
        L_0x0187:
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            throw r0     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
        L_0x018b:
            r15 = 1
            if (r0 != r15) goto L_0x01c9
            android.os.Parcel r15 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            int r0 = r14.length     // Catch:{ ParseException -> 0x01a7 }
            r15.unmarshall(r14, r9, r0)     // Catch:{ ParseException -> 0x01a7 }
            r15.setDataPosition(r9)     // Catch:{ ParseException -> 0x01a7 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzpk> r0 = com.google.android.gms.measurement.internal.zzpk.CREATOR     // Catch:{ ParseException -> 0x01a7 }
            java.lang.Object r0 = r0.createFromParcel(r15)     // Catch:{ ParseException -> 0x01a7 }
            com.google.android.gms.measurement.internal.zzpk r0 = (com.google.android.gms.measurement.internal.zzpk) r0     // Catch:{ ParseException -> 0x01a7 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x01ba
        L_0x01a5:
            r0 = move-exception
            goto L_0x01c5
        L_0x01a7:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x01a5 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x01a5 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ all -> 0x01a5 }
            java.lang.String r14 = "Failed to load user property from local database"
            r0.zza(r14)     // Catch:{ all -> 0x01a5 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r0 = 0
        L_0x01ba:
            if (r0 == 0) goto L_0x015c
            com.google.android.gms.measurement.internal.zzgj r14 = new com.google.android.gms.measurement.internal.zzgj     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r14.<init>(r0, r6, r12)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r7.add(r14)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x015c
        L_0x01c5:
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            throw r0     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
        L_0x01c9:
            r15 = 2
            if (r0 != r15) goto L_0x0208
            android.os.Parcel r15 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            int r0 = r14.length     // Catch:{ ParseException -> 0x01e5 }
            r15.unmarshall(r14, r9, r0)     // Catch:{ ParseException -> 0x01e5 }
            r15.setDataPosition(r9)     // Catch:{ ParseException -> 0x01e5 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzah> r0 = com.google.android.gms.measurement.internal.zzah.CREATOR     // Catch:{ ParseException -> 0x01e5 }
            java.lang.Object r0 = r0.createFromParcel(r15)     // Catch:{ ParseException -> 0x01e5 }
            com.google.android.gms.measurement.internal.zzah r0 = (com.google.android.gms.measurement.internal.zzah) r0     // Catch:{ ParseException -> 0x01e5 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x01f8
        L_0x01e3:
            r0 = move-exception
            goto L_0x0204
        L_0x01e5:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x01e3 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x01e3 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ all -> 0x01e3 }
            java.lang.String r14 = "Failed to load conditional user property from local database"
            r0.zza(r14)     // Catch:{ all -> 0x01e3 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r0 = 0
        L_0x01f8:
            if (r0 == 0) goto L_0x015c
            com.google.android.gms.measurement.internal.zzgj r14 = new com.google.android.gms.measurement.internal.zzgj     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r14.<init>(r0, r6, r12)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r7.add(r14)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x015c
        L_0x0204:
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            throw r0     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
        L_0x0208:
            r15 = 4
            if (r0 != r15) goto L_0x0247
            android.os.Parcel r15 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            int r0 = r14.length     // Catch:{ ParseException -> 0x0224 }
            r15.unmarshall(r14, r9, r0)     // Catch:{ ParseException -> 0x0224 }
            r15.setDataPosition(r9)     // Catch:{ ParseException -> 0x0224 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbe> r0 = com.google.android.gms.measurement.internal.zzbe.CREATOR     // Catch:{ ParseException -> 0x0224 }
            java.lang.Object r0 = r0.createFromParcel(r15)     // Catch:{ ParseException -> 0x0224 }
            com.google.android.gms.measurement.internal.zzbe r0 = (com.google.android.gms.measurement.internal.zzbe) r0     // Catch:{ ParseException -> 0x0224 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x0237
        L_0x0222:
            r0 = move-exception
            goto L_0x0243
        L_0x0224:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x0222 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x0222 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ all -> 0x0222 }
            java.lang.String r14 = "Failed to load default event parameters from local database"
            r0.zza(r14)     // Catch:{ all -> 0x0222 }
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r0 = 0
        L_0x0237:
            if (r0 == 0) goto L_0x015c
            com.google.android.gms.measurement.internal.zzgj r14 = new com.google.android.gms.measurement.internal.zzgj     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r14.<init>(r0, r6, r12)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r7.add(r14)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x015c
        L_0x0243:
            r15.recycle()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            throw r0     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
        L_0x0247:
            r6 = 3
            if (r0 != r6) goto L_0x025a
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            java.lang.String r12 = "Skipping app launch break"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            goto L_0x0269
        L_0x025a:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            java.lang.String r12 = "Unknown record type in local database"
            r0.zza(r12)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
        L_0x0269:
            r13 = r17
            r6 = 2
            r12 = 1
            goto L_0x00ec
        L_0x026f:
            r0 = move-exception
            r17 = r13
            goto L_0x0160
        L_0x0274:
            r0 = move-exception
            r17 = r13
            goto L_0x0165
        L_0x0279:
            r17 = r13
            goto L_0x0169
        L_0x027d:
            r0 = move-exception
            r17 = r13
            goto L_0x016e
        L_0x0282:
            r17 = r13
            java.lang.String r0 = "messages"
            java.lang.String r6 = "rowid <= ?"
            java.lang.String r8 = java.lang.Long.toString(r22)     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch:{ SQLiteFullException -> 0x016d, SQLiteDatabaseLockedException -> 0x0169, SQLiteException -> 0x0164, all -> 0x015f }
            r12 = r29
            int r0 = r12.delete(r0, r6, r8)     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            int r6 = r7.size()     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            if (r0 >= r6) goto L_0x02b2
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            java.lang.String r6 = "Fewer entries removed from local database than expected"
            r0.zza(r6)     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            goto L_0x02b2
        L_0x02ac:
            r0 = move-exception
            goto L_0x02bf
        L_0x02ae:
            r0 = move-exception
            goto L_0x02c3
        L_0x02b0:
            r0 = move-exception
            goto L_0x02cd
        L_0x02b2:
            r12.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            r12.endTransaction()     // Catch:{ SQLiteFullException -> 0x02b0, SQLiteDatabaseLockedException -> 0x02c7, SQLiteException -> 0x02ae, all -> 0x02ac }
            r17.close()
            r12.close()
            return r7
        L_0x02bf:
            r6 = r17
            goto L_0x0363
        L_0x02c3:
            r15 = r12
            r13 = r17
            goto L_0x02fb
        L_0x02c7:
            r6 = r10
            r15 = r12
            r13 = r17
            goto L_0x032b
        L_0x02cd:
            r6 = r10
            r13 = r17
            goto L_0x0340
        L_0x02d2:
            r0 = move-exception
            r12 = r29
            goto L_0x02d8
        L_0x02d6:
            r0 = move-exception
            r12 = r15
        L_0x02d8:
            r13 = 0
        L_0x02d9:
            if (r13 == 0) goto L_0x02e5
            r13.close()     // Catch:{ SQLiteFullException -> 0x02e3, SQLiteDatabaseLockedException -> 0x02ec, SQLiteException -> 0x02e1, all -> 0x02df }
            goto L_0x02e5
        L_0x02df:
            r0 = move-exception
            goto L_0x02e6
        L_0x02e1:
            r0 = move-exception
            goto L_0x02e9
        L_0x02e3:
            r0 = move-exception
            goto L_0x02f0
        L_0x02e5:
            throw r0     // Catch:{ SQLiteFullException -> 0x02e3, SQLiteDatabaseLockedException -> 0x02ec, SQLiteException -> 0x02e1, all -> 0x02df }
        L_0x02e6:
            r6 = 0
            goto L_0x0363
        L_0x02e9:
            r15 = r12
            r13 = 0
            goto L_0x02fb
        L_0x02ec:
            r6 = r10
            r15 = r12
            r13 = 0
            goto L_0x032b
        L_0x02f0:
            r6 = r10
        L_0x02f1:
            r13 = 0
            goto L_0x0340
        L_0x02f3:
            r0 = move-exception
            r6 = 0
            r12 = 0
            goto L_0x0363
        L_0x02f8:
            r0 = move-exception
            r13 = 0
            r15 = 0
        L_0x02fb:
            if (r15 == 0) goto L_0x0309
            boolean r6 = r15.inTransaction()     // Catch:{ all -> 0x0307 }
            if (r6 == 0) goto L_0x0309
            r15.endTransaction()     // Catch:{ all -> 0x0307 }
            goto L_0x0309
        L_0x0307:
            r0 = move-exception
            goto L_0x0325
        L_0x0309:
            com.google.android.gms.measurement.internal.zzib r6 = r1.zzu     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()     // Catch:{ all -> 0x0307 }
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()     // Catch:{ all -> 0x0307 }
            r6.zzb(r2, r0)     // Catch:{ all -> 0x0307 }
            r6 = 1
            r1.zzc = r6     // Catch:{ all -> 0x0307 }
            if (r13 == 0) goto L_0x031e
            r13.close()
        L_0x031e:
            if (r15 == 0) goto L_0x0323
            r15.close()
        L_0x0323:
            r6 = r10
            goto L_0x035a
        L_0x0325:
            r6 = r13
            r12 = r15
            goto L_0x0363
        L_0x0328:
            r6 = r10
            r13 = 0
            r15 = 0
        L_0x032b:
            long r9 = (long) r11
            android.os.SystemClock.sleep(r9)     // Catch:{ all -> 0x0307 }
            int r11 = r11 + 20
            if (r13 == 0) goto L_0x0336
            r13.close()
        L_0x0336:
            if (r15 == 0) goto L_0x035a
            r15.close()
            goto L_0x035a
        L_0x033c:
            r0 = move-exception
            r6 = r10
            r12 = 0
            goto L_0x02f1
        L_0x0340:
            com.google.android.gms.measurement.internal.zzib r8 = r1.zzu     // Catch:{ all -> 0x0361 }
            com.google.android.gms.measurement.internal.zzgt r8 = r8.zzaV()     // Catch:{ all -> 0x0361 }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zzb()     // Catch:{ all -> 0x0361 }
            r8.zzb(r2, r0)     // Catch:{ all -> 0x0361 }
            r8 = 1
            r1.zzc = r8     // Catch:{ all -> 0x0361 }
            if (r13 == 0) goto L_0x0355
            r13.close()
        L_0x0355:
            if (r12 == 0) goto L_0x035a
            r12.close()
        L_0x035a:
            int r10 = r6 + 1
            r6 = 0
            r8 = 5
            r9 = 0
            goto L_0x0022
        L_0x0361:
            r0 = move-exception
            r6 = r13
        L_0x0363:
            if (r6 == 0) goto L_0x0368
            r6.close()
        L_0x0368:
            if (r12 == 0) goto L_0x036d
            r12.close()
        L_0x036d:
            throw r0
        L_0x036e:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            defpackage.e.C(r0, r2)
            r2 = 0
            return r2
        L_0x0377:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgk.zzm(int):java.util.List");
    }

    @WorkerThread
    public final boolean zzn() {
        return zzs(3, new byte[0]);
    }

    @WorkerThread
    public final boolean zzo() {
        zzg();
        if (!this.zzc && zzq()) {
            int i = 0;
            int i2 = 5;
            while (true) {
                if (i >= 5) {
                    e.C(this.zzu, "Error deleting app launch break from local database in reasonable time");
                    break;
                }
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzp = zzp();
                    if (zzp == null) {
                        this.zzc = true;
                    } else {
                        zzp.beginTransaction();
                        zzp.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                        zzp.setTransactionSuccessful();
                        zzp.endTransaction();
                        zzp.close();
                        return true;
                    }
                } catch (SQLiteFullException e) {
                    this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e);
                    this.zzc = true;
                    if (sQLiteDatabase == null) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep((long) i2);
                    i2 += 20;
                    if (sQLiteDatabase == null) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteException e2) {
                    if (sQLiteDatabase != null) {
                        if (sQLiteDatabase.inTransaction()) {
                            sQLiteDatabase.endTransaction();
                        }
                    }
                    this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", e2);
                    this.zzc = true;
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                } catch (Throwable th) {
                    if (sQLiteDatabase != null) {
                        sQLiteDatabase.close();
                    }
                    throw th;
                }
                i++;
            }
        }
        return false;
    }

    @VisibleForTesting
    @WorkerThread
    public final SQLiteDatabase zzp() throws SQLiteException {
        if (this.zzc) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzb.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzc = true;
        return null;
    }

    @VisibleForTesting
    public final boolean zzq() {
        zzib zzib = this.zzu;
        Context zzaY = zzib.zzaY();
        zzib.zzc();
        return zzaY.getDatabasePath("google_app_measurement_local.db").exists();
    }
}
