package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class zzat {
    final /* synthetic */ zzav zza;
    private final String zzb;
    private long zzc;

    public zzat(zzav zzav, String str) {
        Objects.requireNonNull(zzav);
        this.zza = zzav;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = -1;
    }

    public final List zza() {
        List list;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.zza.zze().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{this.zzb, String.valueOf(this.zzc)}, (String) null, (String) null, "rowid", "1000");
            if (cursor.moveToFirst()) {
                do {
                    long j = cursor.getLong(0);
                    long j2 = cursor.getLong(3);
                    if (cursor.getLong(5) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    byte[] blob = cursor.getBlob(4);
                    if (j > this.zzc) {
                        this.zzc = j;
                    }
                    try {
                        zzhr zzhr = (zzhr) zzpj.zzw(zzhs.zzk(), blob);
                        String string = cursor.getString(1);
                        if (string == null) {
                            string = "";
                        }
                        zzhr.zzl(string);
                        zzhr.zzo(cursor.getLong(2));
                        arrayList.add(new zzas(j, j2, z, (zzhs) zzhr.zzbc()));
                    } catch (IOException e) {
                        this.zza.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgt.zzl(this.zzb), e);
                    }
                } while (cursor.moveToNext());
                list = arrayList;
            } else {
                list = Collections.emptyList();
            }
        } catch (SQLiteException e2) {
            this.zza.zzu.zzaV().zzb().zzc("Data loss. Error querying raw events batch. appId", zzgt.zzl(this.zzb), e2);
            list = arrayList;
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

    public zzat(zzav zzav, String str, long j) {
        Objects.requireNonNull(zzav);
        this.zza = zzav;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = zzav.zzaj("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j)}, -1);
    }
}
