package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.measurement.zzbv;
import com.google.android.gms.internal.measurement.zzca;
import java.io.File;

public final class zzaw {
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r2 == false) goto L_0x003d;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007e A[Catch:{ all -> 0x00e2, SQLiteException -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b7 A[Catch:{ all -> 0x00e2, SQLiteException -> 0x00b3 }, LOOP:1: B:35:0x00b7->B:40:0x00c9, LOOP_START, PHI: r2 
      PHI: (r2v5 int) = (r2v4 int), (r2v6 int) binds: [B:34:0x00b5, B:40:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d2 A[Catch:{ all -> 0x00e2, SQLiteException -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[Catch:{  }, RETURN, SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void zza(com.google.android.gms.measurement.internal.zzgt r9, android.database.sqlite.SQLiteDatabase r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String[] r14) throws android.database.sqlite.SQLiteException {
        /*
            if (r9 == 0) goto L_0x00f7
            r0 = 0
            java.lang.String r2 = "SQLITE_MASTER"
            java.lang.String r1 = "name"
            java.lang.String[] r3 = new java.lang.String[]{r1}     // Catch:{ SQLiteException -> 0x002c, all -> 0x0029 }
            java.lang.String r4 = "name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11}     // Catch:{ SQLiteException -> 0x002c, all -> 0x0029 }
            r7 = 0
            r8 = 0
            r6 = 0
            r1 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x002c, all -> 0x0029 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0027 }
            r1.close()
            if (r2 != 0) goto L_0x0040
            goto L_0x003d
        L_0x0023:
            r9 = move-exception
            r0 = r1
            goto L_0x00f1
        L_0x0027:
            r2 = move-exception
            goto L_0x002f
        L_0x0029:
            r9 = move-exception
            goto L_0x00f1
        L_0x002c:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002f:
            com.google.android.gms.measurement.internal.zzgr r3 = r9.zze()     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = "Error querying for table"
            r3.zzc(r4, r11, r2)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x003d
            r1.close()
        L_0x003d:
            r10.execSQL(r12)
        L_0x0040:
            java.lang.String r12 = "Table "
            java.lang.String r1 = " is missing required column: "
            java.lang.String r2 = "SELECT * FROM "
            java.lang.String r3 = " LIMIT 0"
            java.util.HashSet r4 = new java.util.HashSet     // Catch:{ SQLiteException -> 0x00b3 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x00b3 }
            int r5 = r11.length()     // Catch:{ SQLiteException -> 0x00b3 }
            int r5 = r5 + 22
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00b3 }
            r6.<init>(r5)     // Catch:{ SQLiteException -> 0x00b3 }
            r6.append(r2)     // Catch:{ SQLiteException -> 0x00b3 }
            r6.append(r11)     // Catch:{ SQLiteException -> 0x00b3 }
            r6.append(r3)     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.String r2 = r6.toString()     // Catch:{ SQLiteException -> 0x00b3 }
            android.database.Cursor r0 = r10.rawQuery(r2, r0)     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.String[] r2 = r0.getColumnNames()     // Catch:{ all -> 0x00e2 }
            java.util.Collections.addAll(r4, r2)     // Catch:{ all -> 0x00e2 }
            r0.close()     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.String r0 = ","
            java.lang.String[] r13 = r13.split(r0)     // Catch:{ SQLiteException -> 0x00b3 }
            int r0 = r13.length     // Catch:{ SQLiteException -> 0x00b3 }
            r2 = 0
            r3 = 0
        L_0x007c:
            if (r3 >= r0) goto L_0x00b5
            r5 = r13[r3]     // Catch:{ SQLiteException -> 0x00b3 }
            boolean r6 = r4.remove(r5)     // Catch:{ SQLiteException -> 0x00b3 }
            if (r6 == 0) goto L_0x0089
            int r3 = r3 + 1
            goto L_0x007c
        L_0x0089:
            android.database.sqlite.SQLiteException r10 = new android.database.sqlite.SQLiteException     // Catch:{ SQLiteException -> 0x00b3 }
            int r13 = r11.length()     // Catch:{ SQLiteException -> 0x00b3 }
            int r13 = r13 + 35
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x00b3 }
            int r14 = r14.length()     // Catch:{ SQLiteException -> 0x00b3 }
            int r13 = r13 + r14
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00b3 }
            r14.<init>(r13)     // Catch:{ SQLiteException -> 0x00b3 }
            r14.append(r12)     // Catch:{ SQLiteException -> 0x00b3 }
            r14.append(r11)     // Catch:{ SQLiteException -> 0x00b3 }
            r14.append(r1)     // Catch:{ SQLiteException -> 0x00b3 }
            r14.append(r5)     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.String r12 = r14.toString()     // Catch:{ SQLiteException -> 0x00b3 }
            r10.<init>(r12)     // Catch:{ SQLiteException -> 0x00b3 }
            throw r10     // Catch:{ SQLiteException -> 0x00b3 }
        L_0x00b3:
            r10 = move-exception
            goto L_0x00e7
        L_0x00b5:
            if (r14 == 0) goto L_0x00cc
        L_0x00b7:
            int r12 = r14.length     // Catch:{ SQLiteException -> 0x00b3 }
            if (r2 >= r12) goto L_0x00cc
            r12 = r14[r2]     // Catch:{ SQLiteException -> 0x00b3 }
            boolean r12 = r4.remove(r12)     // Catch:{ SQLiteException -> 0x00b3 }
            if (r12 != 0) goto L_0x00c9
            int r12 = r2 + 1
            r12 = r14[r12]     // Catch:{ SQLiteException -> 0x00b3 }
            r10.execSQL(r12)     // Catch:{ SQLiteException -> 0x00b3 }
        L_0x00c9:
            int r2 = r2 + 2
            goto L_0x00b7
        L_0x00cc:
            boolean r10 = r4.isEmpty()     // Catch:{ SQLiteException -> 0x00b3 }
            if (r10 != 0) goto L_0x00e1
            com.google.android.gms.measurement.internal.zzgr r10 = r9.zze()     // Catch:{ SQLiteException -> 0x00b3 }
            java.lang.String r12 = "Table has extra columns. table, columns"
            java.lang.String r13 = ", "
            java.lang.String r13 = android.text.TextUtils.join(r13, r4)     // Catch:{ SQLiteException -> 0x00b3 }
            r10.zzc(r12, r11, r13)     // Catch:{ SQLiteException -> 0x00b3 }
        L_0x00e1:
            return
        L_0x00e2:
            r10 = move-exception
            r0.close()     // Catch:{ SQLiteException -> 0x00b3 }
            throw r10     // Catch:{ SQLiteException -> 0x00b3 }
        L_0x00e7:
            com.google.android.gms.measurement.internal.zzgr r9 = r9.zzb()
            java.lang.String r12 = "Failed to verify columns on table that was just created"
            r9.zzb(r12, r11)
            throw r10
        L_0x00f1:
            if (r0 == 0) goto L_0x00f6
            r0.close()
        L_0x00f6:
            throw r9
        L_0x00f7:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Monitor must not be null"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaw.zza(com.google.android.gms.measurement.internal.zzgt, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static void zzb(zzgt zzgt, SQLiteDatabase sQLiteDatabase) {
        if (zzgt != null) {
            zzbv.zza();
            String path = sQLiteDatabase.getPath();
            int i = zzca.zzb;
            File file = new File(path);
            if (!file.setReadable(false, false)) {
                zzgt.zze().zza("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                zzgt.zze().zza("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                zzgt.zze().zza("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                zzgt.zze().zza("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }
}
