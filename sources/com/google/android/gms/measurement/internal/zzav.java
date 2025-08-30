package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzql;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

final class zzav extends zzor {
    static final String[] zza = {"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzj = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzk = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzl = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzau zzm;
    private final zzof zzn = new zzof(this.zzu.zzaZ());

    public zzav(zzpf zzpf) {
        super(zzpf);
        this.zzu.zzc();
        this.zzm = new zzau(this, this.zzu.zzaY(), "google_app_measurement.db");
    }

    @WorkerThread
    private final long zzaA(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = zze().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                cursor.close();
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zzaB(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zze().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
            }
            rawQuery.close();
            return j;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final String zzaC(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = zze().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                rawQuery.close();
                return string;
            }
            rawQuery.close();
            return "";
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final void zzaD(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase zze2 = zze();
            String asString = contentValues.getAsString("app_id");
            if (asString == null) {
                this.zzu.zzaV().zzd().zzb("Value of the primary key is not set.", zzgt.zzl("app_id"));
                return;
            }
            StringBuilder sb = new StringBuilder(10);
            sb.append("app_id = ?");
            if (((long) zze2.update("consent_settings", contentValues, sb.toString(), new String[]{asString})) == 0 && zze2.insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzc("Failed to insert/update table (got -1). key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzd("Error storing into table. key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0131  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.zzbc zzaE(java.lang.String r30, java.lang.String r31, java.lang.String r32) {
        /*
            r29 = this;
            r1 = r29
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            r29.zzg()
            r29.zzay()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String r10 = "current_session_count"
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r0.<init>(r2)
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r29.zze()     // Catch:{ SQLiteException -> 0x010a, all -> 0x0108 }
            r11 = 0
            java.lang.String[] r4 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x010a, all -> 0x0108 }
            java.lang.Object[] r0 = r0.toArray(r4)     // Catch:{ SQLiteException -> 0x010a, all -> 0x0108 }
            r5 = r0
            java.lang.String[] r5 = (java.lang.String[]) r5     // Catch:{ SQLiteException -> 0x010a, all -> 0x0108 }
            java.lang.String r6 = "app_id=? and name=?"
            java.lang.String[] r7 = new java.lang.String[]{r31, r32}     // Catch:{ SQLiteException -> 0x010a, all -> 0x0108 }
            r9 = 0
            r10 = 0
            r8 = 0
            r4 = r30
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x010a, all -> 0x0108 }
            boolean r0 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x00ca }
            if (r0 != 0) goto L_0x0053
            goto L_0x0129
        L_0x0053:
            long r15 = r3.getLong(r11)     // Catch:{ SQLiteException -> 0x00ca }
            r0 = 1
            long r17 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x00ca }
            r4 = 2
            long r21 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r4 = 3
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r6 = 0
            if (r5 == 0) goto L_0x006d
            r23 = r6
            goto L_0x0073
        L_0x006d:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r23 = r4
        L_0x0073:
            r4 = 4
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 == 0) goto L_0x007d
            r25 = r2
            goto L_0x0087
        L_0x007d:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r25 = r4
        L_0x0087:
            r4 = 5
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 == 0) goto L_0x0091
            r26 = r2
            goto L_0x009b
        L_0x0091:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r26 = r4
        L_0x009b:
            r4 = 6
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 == 0) goto L_0x00a5
            r27 = r2
            goto L_0x00af
        L_0x00a5:
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r27 = r4
        L_0x00af:
            r4 = 7
            boolean r5 = r3.isNull(r4)     // Catch:{ SQLiteException -> 0x00ca }
            if (r5 != 0) goto L_0x00cc
            long r4 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ca }
            r8 = 1
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x00c1
            r11 = 1
        L_0x00c1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)     // Catch:{ SQLiteException -> 0x00ca }
            r28 = r0
            goto L_0x00ce
        L_0x00c8:
            r0 = move-exception
            goto L_0x0106
        L_0x00ca:
            r0 = move-exception
            goto L_0x010c
        L_0x00cc:
            r28 = r2
        L_0x00ce:
            r0 = 8
            boolean r4 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x00ca }
            if (r4 == 0) goto L_0x00d9
            r19 = r6
            goto L_0x00df
        L_0x00d9:
            long r4 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x00ca }
            r19 = r4
        L_0x00df:
            com.google.android.gms.measurement.internal.zzbc r0 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ SQLiteException -> 0x00ca }
            r12 = r0
            r13 = r31
            r14 = r32
            r12.<init>(r13, r14, r15, r17, r19, r21, r23, r25, r26, r27, r28)     // Catch:{ SQLiteException -> 0x00ca }
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x00ca }
            if (r4 == 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzib r4 = r1.zzu     // Catch:{ SQLiteException -> 0x00ca }
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()     // Catch:{ SQLiteException -> 0x00ca }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ SQLiteException -> 0x00ca }
            java.lang.String r5 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgt.zzl(r31)     // Catch:{ SQLiteException -> 0x00ca }
            r4.zzb(r5, r6)     // Catch:{ SQLiteException -> 0x00ca }
        L_0x0102:
            r3.close()
            return r0
        L_0x0106:
            r2 = r3
            goto L_0x012f
        L_0x0108:
            r0 = move-exception
            goto L_0x012f
        L_0x010a:
            r0 = move-exception
            r3 = r2
        L_0x010c:
            com.google.android.gms.measurement.internal.zzib r4 = r1.zzu     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.zzgt r5 = r4.zzaV()     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ all -> 0x00c8 }
            java.lang.String r6 = "Error querying events. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgt.zzl(r31)     // Catch:{ all -> 0x00c8 }
            com.google.android.gms.measurement.internal.zzgm r4 = r4.zzl()     // Catch:{ all -> 0x00c8 }
            r8 = r32
            java.lang.String r4 = r4.zza(r8)     // Catch:{ all -> 0x00c8 }
            r5.zzd(r6, r7, r4, r0)     // Catch:{ all -> 0x00c8 }
        L_0x0129:
            if (r3 == 0) goto L_0x012e
            r3.close()
        L_0x012e:
            return r2
        L_0x012f:
            if (r2 == 0) goto L_0x0134
            r2.close()
        L_0x0134:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzaE(java.lang.String, java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbc");
    }

    @WorkerThread
    private final void zzaF(String str, zzbc zzbc) {
        long j;
        Preconditions.checkNotNull(zzbc);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        String str2 = zzbc.zza;
        contentValues.put("app_id", str2);
        contentValues.put("name", zzbc.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbc.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbc.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbc.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbc.zzg));
        contentValues.put("last_bundled_day", zzbc.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbc.zzi);
        contentValues.put("last_sampling_rate", zzbc.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbc.zze));
        Boolean bool = zzbc.zzk;
        if (bool == null || !bool.booleanValue()) {
            j = null;
        } else {
            j = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j);
        try {
            if (zze().insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzgt.zzl(str2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing event aggregates. appId", zzgt.zzl(zzbc.zza), e);
        }
    }

    private final void zzaG(String str, String str2) {
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete(str, "app_id=?", new String[]{str2});
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error deleting snapshot. appId", zzgt.zzl(str2), e);
        }
    }

    private final zzpi zzaH(String str, long j, byte[] bArr, String str2, String str3, int i, int i2, long j2, long j3, long j4) {
        String str4 = str3;
        int i3 = i2;
        if (TextUtils.isEmpty(str2)) {
            this.zzu.zzaV().zzj().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzhz zzhz = (zzhz) zzpj.zzw(zzib.zzh(), bArr);
            zzlr zzb2 = zzlr.zzb(i);
            if (!(zzb2 == zzlr.GOOGLE_SIGNAL || zzb2 == zzlr.GOOGLE_SIGNAL_PENDING || i3 <= 0)) {
                ArrayList arrayList = new ArrayList();
                for (zzid zzcl : zzhz.zza()) {
                    zzic zzic = (zzic) zzcl.zzcl();
                    zzic.zzao(i3);
                    arrayList.add((zzid) zzic.zzbc());
                }
                zzhz.zzg();
                zzhz.zzf(arrayList);
            }
            HashMap hashMap = new HashMap();
            if (str4 != null) {
                String[] split = str4.split("\r\n");
                int length = split.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    String str5 = split[i4];
                    if (str5.isEmpty()) {
                        break;
                    }
                    String[] split2 = str5.split("=", 2);
                    if (split2.length != 2) {
                        this.zzu.zzaV().zzb().zzb("Invalid upload header: ", str5);
                        break;
                    }
                    hashMap.put(split2[0], split2[1]);
                    i4++;
                }
            }
            zzph zzph = new zzph();
            zzph.zzb(j);
            zzph.zzc((zzib) zzhz.zzbc());
            zzph.zzd(str2);
            zzph.zze(hashMap);
            zzph.zzf(zzb2);
            zzph.zzg(j2);
            zzph.zzh(j3);
            zzph.zzi(j4);
            zzph.zzj(i3);
            return zzph.zza();
        } catch (IOException e) {
            String str6 = str;
            this.zzu.zzaV().zzb().zzc("Failed to queued MeasurementBatch from upload_queue. appId", str, e);
            return null;
        }
    }

    private final String zzaI() {
        zzib zzib = this.zzu;
        long currentTimeMillis = zzib.zzaZ().currentTimeMillis();
        Locale locale = Locale.US;
        zzlr zzlr = zzlr.GOOGLE_SIGNAL;
        int zza2 = zzlr.zza();
        zzib.zzc();
        Long l = (Long) zzfx.zzS.zzb((Object) null);
        l.longValue();
        String str = "(upload_type = " + zza2 + " AND ABS(creation_timestamp - " + currentTimeMillis + ") > " + l + ")";
        int zza3 = zzlr.zza();
        zzib.zzc();
        String str2 = "(upload_type != " + zza3 + " AND ABS(creation_timestamp - " + currentTimeMillis + ") > " + zzal.zzI() + ")";
        StringBuilder sb = new StringBuilder(str.length() + 5 + str2.length() + 1);
        sb.append("(");
        sb.append(str);
        sb.append(" OR ");
        sb.append(str2);
        sb.append(")");
        return sb.toString();
    }

    private static final String zzaJ(List list) {
        if (list.isEmpty()) {
            return "";
        }
        return ba.o(" AND (upload_type IN (", TextUtils.join(", ", list), "))");
    }

    @WorkerThread
    public static final void zzaw(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put("value", (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    public final long zzA(String str, zzib zzib, String str2, Map map, zzlr zzlr, Long l) {
        int delete;
        String str3 = str;
        Long l2 = l;
        zzg();
        zzay();
        Preconditions.checkNotNull(zzib);
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        if (zzai()) {
            zzpf zzpf = this.zzg;
            long zza2 = zzpf.zzq().zzb.zza();
            zzib zzib2 = this.zzu;
            long elapsedRealtime = zzib2.zzaZ().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzib2.zzc();
            if (abs > zzal.zzJ()) {
                zzpf.zzq().zzb.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai() && (delete = zze().delete("upload_queue", zzaI(), new String[0])) > 0) {
                    zzib2.zzaV().zzk().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", Integer.valueOf(delete));
                }
                Preconditions.checkNotEmpty(str);
                zzg();
                zzay();
                try {
                    int zzm2 = zzib2.zzc().zzm(str, zzfx.zzz);
                    if (zzm2 > 0) {
                        zze().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{str, String.valueOf(zzm2)});
                    }
                } catch (SQLiteException e) {
                    this.zzu.zzaV().zzb().zzc("Error deleting over the limit queued batches. appId", zzgt.zzl(str), e);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            String str4 = (String) entry.getKey();
            String str5 = (String) entry.getValue();
            StringBuilder sb = new StringBuilder(ba.e(1, str4) + String.valueOf(str5).length());
            sb.append(str4);
            sb.append("=");
            sb.append(str5);
            arrayList.add(sb.toString());
        }
        byte[] zzcc = zzib.zzcc();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("measurement_batch", zzcc);
        contentValues.put("upload_uri", str2);
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb2.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb2.append("\r\n");
            }
        }
        contentValues.put("upload_headers", sb2.toString());
        contentValues.put("upload_type", Integer.valueOf(zzlr.zza()));
        zzib zzib3 = this.zzu;
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzib3.zzaZ().currentTimeMillis()));
        contentValues.put("retry_count", 0);
        if (l2 != null) {
            contentValues.put("associated_row_id", l2);
        }
        try {
            long insert = zze().insert("upload_queue", (String) null, contentValues);
            if (insert != -1) {
                return insert;
            }
            zzib3.zzaV().zzb().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", str);
            return -1;
        } catch (SQLiteException e2) {
            this.zzu.zzaV().zzb().zzc("Error storing MeasurementBatch to upload_queue. appId", str, e2);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b6  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzpi zzB(long r19) {
        /*
            r18 = this;
            r18.zzg()
            r18.zzay()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r18.zze()     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String r3 = "upload_queue"
            java.lang.String r4 = "rowId"
            java.lang.String r5 = "app_id"
            java.lang.String r6 = "measurement_batch"
            java.lang.String r7 = "upload_uri"
            java.lang.String r8 = "upload_headers"
            java.lang.String r9 = "upload_type"
            java.lang.String r10 = "retry_count"
            java.lang.String r11 = "creation_timestamp"
            java.lang.String r12 = "associated_row_id"
            java.lang.String r13 = "last_upload_timestamp"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String r5 = "rowId=?"
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            java.lang.String r10 = "1"
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008f }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            if (r0 != 0) goto L_0x0042
            r3 = r18
            goto L_0x00ac
        L_0x0042:
            r0 = 1
            java.lang.String r0 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r4 = r0
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 2
            byte[] r7 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 3
            java.lang.String r8 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 4
            java.lang.String r9 = r2.getString(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 5
            int r10 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 6
            int r11 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 7
            long r12 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 8
            long r14 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0 = 9
            long r16 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r3 = r18
            r5 = r19
            com.google.android.gms.measurement.internal.zzpi r0 = r3.zzaH(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r2.close()
            return r0
        L_0x0084:
            r0 = move-exception
            goto L_0x0088
        L_0x0086:
            r0 = move-exception
            goto L_0x008c
        L_0x0088:
            r3 = r18
        L_0x008a:
            r1 = r2
            goto L_0x00b4
        L_0x008c:
            r3 = r18
            goto L_0x0099
        L_0x008f:
            r0 = move-exception
            goto L_0x0093
        L_0x0091:
            r0 = move-exception
            goto L_0x0096
        L_0x0093:
            r3 = r18
            goto L_0x00b4
        L_0x0096:
            r3 = r18
            r2 = r1
        L_0x0099:
            com.google.android.gms.measurement.internal.zzib r4 = r3.zzu     // Catch:{ all -> 0x00b2 }
            com.google.android.gms.measurement.internal.zzgt r4 = r4.zzaV()     // Catch:{ all -> 0x00b2 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x00b2 }
            java.lang.String r5 = "Error to querying MeasurementBatch from upload_queue. rowId"
            java.lang.Long r6 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x00b2 }
            r4.zzc(r5, r6, r0)     // Catch:{ all -> 0x00b2 }
        L_0x00ac:
            if (r2 == 0) goto L_0x00b1
            r2.close()
        L_0x00b1:
            return r1
        L_0x00b2:
            r0 = move-exception
            goto L_0x008a
        L_0x00b4:
            if (r1 == 0) goto L_0x00b9
            r1.close()
        L_0x00b9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzB(long):com.google.android.gms.measurement.internal.zzpi");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.util.ArrayList} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e3  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzC(java.lang.String r19, com.google.android.gms.measurement.internal.zzon r20, int r21) {
        /*
            r18 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            r18.zzg()
            r18.zzay()
            java.lang.String r0 = " AND NOT "
            java.lang.String r1 = "app_id=?"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r18.zze()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r4 = "upload_queue"
            java.lang.String r5 = "rowId"
            java.lang.String r6 = "app_id"
            java.lang.String r7 = "measurement_batch"
            java.lang.String r8 = "upload_uri"
            java.lang.String r9 = "upload_headers"
            java.lang.String r10 = "upload_type"
            java.lang.String r11 = "retry_count"
            java.lang.String r12 = "creation_timestamp"
            java.lang.String r13 = "associated_row_id"
            java.lang.String r14 = "last_upload_timestamp"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14}     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r6 = r20
            java.util.List r6 = r6.zza     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r6 = zzaJ(r6)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r7 = r18.zzaI()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            int r8 = r8.length()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            int r8 = r8 + 17
            int r9 = r7.length()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            int r8 = r8 + r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.<init>(r8)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r6)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r0)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r9.append(r7)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r6 = r9.toString()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String[] r7 = new java.lang.String[]{r19}     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.lang.String r10 = "creation_timestamp ASC"
            if (r21 <= 0) goto L_0x006a
            java.lang.String r0 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r11 = r0
            goto L_0x006b
        L_0x006a:
            r11 = r2
        L_0x006b:
            r8 = 0
            r9 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
        L_0x0076:
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            if (r1 == 0) goto L_0x00bd
            r1 = 0
            long r5 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 2
            byte[] r7 = r2.getBlob(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 3
            java.lang.String r8 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 4
            java.lang.String r9 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 5
            int r10 = r2.getInt(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 6
            int r11 = r2.getInt(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 7
            long r12 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 8
            long r14 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r1 = 9
            long r16 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            r3 = r18
            r4 = r19
            com.google.android.gms.measurement.internal.zzpi r1 = r3.zzaH(r4, r5, r7, r8, r9, r10, r11, r12, r14, r16)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            if (r1 == 0) goto L_0x0076
            r0.add(r1)     // Catch:{ SQLiteException -> 0x00bb, all -> 0x00b9 }
            goto L_0x0076
        L_0x00b9:
            r0 = move-exception
            goto L_0x00c0
        L_0x00bb:
            r0 = move-exception
            goto L_0x00c3
        L_0x00bd:
            r1 = r18
            goto L_0x00da
        L_0x00c0:
            r1 = r18
            goto L_0x00e1
        L_0x00c3:
            r1 = r18
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu     // Catch:{ all -> 0x00e0 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x00e0 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "Error to querying MeasurementBatch from upload_queue. appId"
            r5 = r19
            r3.zzc(r4, r5, r0)     // Catch:{ all -> 0x00e0 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00e0 }
        L_0x00da:
            if (r2 == 0) goto L_0x00df
            r2.close()
        L_0x00df:
            return r0
        L_0x00e0:
            r0 = move-exception
        L_0x00e1:
            if (r2 == 0) goto L_0x00e6
            r2.close()
        L_0x00e6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzC(java.lang.String, com.google.android.gms.measurement.internal.zzon, int):java.util.List");
    }

    @WorkerThread
    public final boolean zzD(String str) {
        zzlr[] zzlrArr = {zzlr.GOOGLE_SIGNAL};
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(zzlrArr[0].zza()));
        String zzaJ = zzaJ(arrayList);
        String zzaI = zzaI();
        StringBuilder sb = new StringBuilder(String.valueOf(zzaJ).length() + 61 + zzaI.length());
        sb.append("SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?");
        sb.append(zzaJ);
        sb.append(" AND NOT ");
        sb.append(zzaI);
        if (zzaA(sb.toString(), new String[]{str}) != 0) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final void zzE(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        try {
            if (zze().delete("upload_queue", "rowid=?", new String[]{l.toString()}) != 1) {
                this.zzu.zzaV().zze().zza("Deleted fewer rows from upload_queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a MeasurementBatch in a upload_queue table", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003e  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzF() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zze()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0024, all -> 0x0022 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x001c }
            if (r2 == 0) goto L_0x0036
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x001c }
            r0.close()
            return r1
        L_0x001a:
            r1 = move-exception
            goto L_0x001e
        L_0x001c:
            r2 = move-exception
            goto L_0x0027
        L_0x001e:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003c
        L_0x0022:
            r0 = move-exception
            goto L_0x003c
        L_0x0024:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L_0x0027:
            com.google.android.gms.measurement.internal.zzib r3 = r6.zzu     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x001a }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r4, r2)     // Catch:{ all -> 0x001a }
        L_0x0036:
            if (r0 == 0) goto L_0x003b
            r0.close()
        L_0x003b:
            return r1
        L_0x003c:
            if (r1 == 0) goto L_0x0041
            r1.close()
        L_0x0041:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzF():java.lang.String");
    }

    public final boolean zzG() {
        if (zzaA("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    @WorkerThread
    public final void zzH(long j) {
        zzg();
        zzay();
        try {
            if (zze().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a bundle in a queue table", e);
            throw e;
        }
    }

    @WorkerThread
    public final void zzI() {
        zzg();
        zzay();
        if (zzai()) {
            zzpf zzpf = this.zzg;
            long zza2 = zzpf.zzq().zza.zza();
            zzib zzib = this.zzu;
            long elapsedRealtime = zzib.zzaZ().elapsedRealtime();
            long abs = Math.abs(elapsedRealtime - zza2);
            zzib.zzc();
            if (abs > zzal.zzJ()) {
                zzpf.zzq().zza.zzb(elapsedRealtime);
                zzg();
                zzay();
                if (zzai()) {
                    SQLiteDatabase zze2 = zze();
                    String valueOf = String.valueOf(zzib.zzaZ().currentTimeMillis());
                    zzib.zzc();
                    int delete = zze2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{valueOf, String.valueOf(zzal.zzI())});
                    if (delete > 0) {
                        zzib.zzaV().zzk().zzb("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                    }
                }
            }
        }
    }

    @VisibleForTesting
    @WorkerThread
    public final void zzJ(List list) {
        zzg();
        zzay();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzai()) {
            String join = TextUtils.join(",", list);
            String q = e.q(new StringBuilder(String.valueOf(join).length() + 2), "(", join, ")");
            if (zzaA(e.q(new StringBuilder(q.length() + 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", q, " AND retry_count =  2147483647 LIMIT 1"), (String[]) null) > 0) {
                e.C(this.zzu, "The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                StringBuilder sb = new StringBuilder(q.length() + 127);
                sb.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb.append(q);
                sb.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                zze2.execSQL(sb.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    @WorkerThread
    public final void zzK(Long l) {
        zzg();
        zzay();
        Preconditions.checkNotNull(l);
        if (zzai()) {
            StringBuilder sb = new StringBuilder(l.toString().length() + 86);
            sb.append("SELECT COUNT(1) FROM upload_queue WHERE rowid = ");
            sb.append(l);
            sb.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzaA(sb.toString(), (String[]) null) > 0) {
                e.C(this.zzu, "The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase zze2 = zze();
                long currentTimeMillis = this.zzu.zzaZ().currentTimeMillis();
                StringBuilder sb2 = new StringBuilder(String.valueOf(currentTimeMillis).length() + 60);
                sb2.append(" SET retry_count = retry_count + 1, last_upload_timestamp = ");
                sb2.append(currentTimeMillis);
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder(sb3.length() + 34 + l.toString().length() + 29);
                sb4.append("UPDATE upload_queue");
                sb4.append(sb3);
                sb4.append(" WHERE rowid = ");
                sb4.append(l);
                sb4.append(" AND retry_count < 2147483647");
                zze2.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", e);
            }
        }
    }

    @VisibleForTesting
    @WorkerThread
    public final Object zzL(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            e.w(this.zzu, "Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                this.zzu.zzaV().zzb().zzb("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            e.w(this.zzu, "Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    @WorkerThread
    public final long zzM() {
        return zzaB("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    @VisibleForTesting
    @WorkerThread
    public final long zzN(String str, String str2) {
        long j;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzay();
        SQLiteDatabase zze2 = zze();
        zze2.beginTransaction();
        long j2 = 0;
        try {
            StringBuilder sb = new StringBuilder(48);
            sb.append("select first_open_count from app2 where app_id=?");
            j = -1;
            long zzaB = zzaB(sb.toString(), new String[]{str}, -1);
            if (zzaB == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (zze2.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    this.zzu.zzaV().zzb().zzc("Failed to insert column (got -1). appId", zzgt.zzl(str), "first_open_count");
                    zze2.endTransaction();
                    return j;
                }
                zzaB = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + zzaB));
                if (((long) zze2.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    this.zzu.zzaV().zzb().zzc("Failed to update column (got 0). appId", zzgt.zzl(str), "first_open_count");
                } else {
                    zze2.setTransactionSuccessful();
                    j = zzaB;
                }
            } catch (SQLiteException e) {
                e = e;
                j2 = zzaB;
                try {
                    this.zzu.zzaV().zzb().zzd("Error inserting column. appId", zzgt.zzl(str), "first_open_count", e);
                    j = j2;
                    zze2.endTransaction();
                    return j;
                } catch (Throwable th) {
                    zze2.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            this.zzu.zzaV().zzb().zzd("Error inserting column. appId", zzgt.zzl(str), "first_open_count", e);
            j = j2;
            zze2.endTransaction();
            return j;
        }
        zze2.endTransaction();
        return j;
    }

    @WorkerThread
    public final long zzO() {
        return zzaB("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzP() {
        if (zzaA("select count(1) > 0 from raw_events", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzQ(String str, String str2) {
        if (zzaA("select count(1) from raw_events where app_id = ? and name = ?", new String[]{str, str2}) > 0) {
            return true;
        }
        return false;
    }

    public final boolean zzR() {
        if (zzaA("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0) {
            return true;
        }
        return false;
    }

    public final void zzS(List list) {
        Preconditions.checkNotNull(list);
        zzg();
        zzay();
        StringBuilder sb = new StringBuilder("rowid in (");
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(((Long) list.get(i)).longValue());
        }
        sb.append(")");
        int delete = zze().delete("raw_events", sb.toString(), (String[]) null);
        if (delete != list.size()) {
            this.zzu.zzaV().zzb().zzc("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    public final void zzT(String str) {
        try {
            zze().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Failed to remove unused event metadata. appId", zzgt.zzl(str), e);
        }
    }

    public final long zzU(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaB("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    public final boolean zzV(String str, Long l, long j, zzhs zzhs) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzhs);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        zzib zzib = this.zzu;
        byte[] zzcc = zzhs.zzcc();
        zzib.zzaV().zzk().zzc("Saving complex main event, appId, data size", zzib.zzl().zza(str), Integer.valueOf(zzcc.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzcc);
        try {
            if (zze().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzib.zzaV().zzb().zzb("Failed to insert complex main event (got -1). appId", zzgt.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing complex main event. appId", zzgt.zzl(str), e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzW(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzg()
            r5.zzay()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.zze()     // Catch:{ SQLiteException -> 0x006e, all -> 0x006c }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            java.lang.String[] r3 = new java.lang.String[]{r6}     // Catch:{ SQLiteException -> 0x006e, all -> 0x006c }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x006e, all -> 0x006c }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x002d }
            if (r2 != 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzib r6 = r5.zzu     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzk()     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch:{ SQLiteException -> 0x002d }
            goto L_0x007f
        L_0x002b:
            r6 = move-exception
            goto L_0x006a
        L_0x002d:
            r6 = move-exception
            goto L_0x0070
        L_0x002f:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.internal.measurement.zzhr r3 = com.google.android.gms.internal.measurement.zzhs.zzk()     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.zznk r2 = com.google.android.gms.measurement.internal.zzpj.zzw(r3, r2)     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.zzhr r2 = (com.google.android.gms.internal.measurement.zzhr) r2     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.zzme r2 = r2.zzbc()     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.zzhs r2 = (com.google.android.gms.internal.measurement.zzhs) r2     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.measurement.internal.zzpf r6 = r5.zzg     // Catch:{ SQLiteException -> 0x002d }
            r6.zzp()     // Catch:{ SQLiteException -> 0x002d }
            java.util.List r6 = r2.zza()     // Catch:{ SQLiteException -> 0x002d }
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zzpj.zzE(r6)     // Catch:{ SQLiteException -> 0x002d }
            r1.close()
            return r6
        L_0x0055:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzib r3 = r5.zzu     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ SQLiteException -> 0x002d }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x002d }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgt.zzl(r6)     // Catch:{ SQLiteException -> 0x002d }
            r3.zzc(r4, r6, r2)     // Catch:{ SQLiteException -> 0x002d }
            goto L_0x007f
        L_0x006a:
            r0 = r1
            goto L_0x0085
        L_0x006c:
            r6 = move-exception
            goto L_0x0085
        L_0x006e:
            r6 = move-exception
            r1 = r0
        L_0x0070:
            com.google.android.gms.measurement.internal.zzib r2 = r5.zzu     // Catch:{ all -> 0x002b }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x002b }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x002b }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zzb(r3, r6)     // Catch:{ all -> 0x002b }
        L_0x007f:
            if (r1 == 0) goto L_0x0084
            r1.close()
        L_0x0084:
            return r0
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.close()
        L_0x008a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzW(java.lang.String):android.os.Bundle");
    }

    public final boolean zzX(String str, long j) {
        try {
            if (zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0) <= 0 && zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name like '!_%' escape '!' limit 1;", new String[]{str, String.valueOf(j)}, 0) > 0) {
                return true;
            }
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Error checking backfill conditions", e);
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: com.google.android.gms.internal.measurement.zzid} */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r4v24, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r4v26 */
    /* JADX WARNING: type inference failed for: r0v36, types: [com.google.android.gms.internal.measurement.zzme] */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0084, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0086, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d9, code lost:
        r4 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00db, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0123, code lost:
        r4.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x002e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0084 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:16:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x02b0 A[Catch:{ SQLiteException -> 0x02c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzY(java.lang.String r26, java.lang.Long r27, java.lang.String r28, android.os.Bundle r29) {
        /*
            r25 = this;
            r1 = r25
            r12 = r26
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)
            r25.zzg()
            r25.zzay()
            if (r27 == 0) goto L_0x001a
            com.google.android.gms.measurement.internal.zzat r0 = new com.google.android.gms.measurement.internal.zzat
            long r2 = r27.longValue()
            r0.<init>(r1, r12, r2)
        L_0x0018:
            r13 = r0
            goto L_0x0020
        L_0x001a:
            com.google.android.gms.measurement.internal.zzat r0 = new com.google.android.gms.measurement.internal.zzat
            r0.<init>(r1, r12)
            goto L_0x0018
        L_0x0020:
            java.util.List r0 = r13.zza()
        L_0x0024:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x02e5
            java.util.Iterator r14 = r0.iterator()
        L_0x002e:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x02df
            java.lang.Object r0 = r14.next()
            r15 = r0
            com.google.android.gms.measurement.internal.zzas r15 = (com.google.android.gms.measurement.internal.zzas) r15
            boolean r0 = android.text.TextUtils.isEmpty(r28)
            if (r0 != 0) goto L_0x011e
            long r2 = r15.zzb
            r4 = 0
            android.database.sqlite.SQLiteDatabase r16 = r25.zze()     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String r17 = "raw_events_metadata"
            java.lang.String r0 = "metadata"
            java.lang.String[] r18 = new java.lang.String[]{r0}     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String r19 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String r0 = java.lang.Long.toString(r2)     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String[] r20 = new java.lang.String[]{r12, r0}     // Catch:{ SQLiteException -> 0x00df }
            java.lang.String r23 = "rowid"
            java.lang.String r24 = "2"
            r21 = 0
            r22 = 0
            android.database.Cursor r2 = r16.query(r17, r18, r19, r20, r21, r22, r23, r24)     // Catch:{ SQLiteException -> 0x00df }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            if (r0 != 0) goto L_0x0088
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r3 = "Raw event metadata record is missing. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r26)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r0.zzb(r3, r5)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
        L_0x007f:
            r2.close()
            goto L_0x00fa
        L_0x0084:
            r0 = move-exception
            goto L_0x00d9
        L_0x0086:
            r0 = move-exception
            goto L_0x00db
        L_0x0088:
            r0 = 0
            byte[] r0 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.internal.measurement.zzic r3 = com.google.android.gms.internal.measurement.zzid.zzaE()     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.zznk r0 = com.google.android.gms.measurement.internal.zzpj.zzw(r3, r0)     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.zzic r0 = (com.google.android.gms.internal.measurement.zzic) r0     // Catch:{ IOException -> 0x00c4 }
            com.google.android.gms.internal.measurement.zzme r0 = r0.zzbc()     // Catch:{ IOException -> 0x00c4 }
            r3 = r0
            com.google.android.gms.internal.measurement.zzid r3 = (com.google.android.gms.internal.measurement.zzid) r3     // Catch:{ IOException -> 0x00c4 }
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            if (r0 == 0) goto L_0x00ba
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            java.lang.String r4 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r26)     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            r0.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            goto L_0x00ba
        L_0x00b8:
            r0 = move-exception
            goto L_0x00c2
        L_0x00ba:
            r2.close()     // Catch:{ SQLiteException -> 0x00b8, all -> 0x0084 }
            r2.close()
        L_0x00c0:
            r4 = r3
            goto L_0x00fa
        L_0x00c2:
            r4 = r2
            goto L_0x00e1
        L_0x00c4:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            java.lang.String r5 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgt.zzl(r26)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            r3.zzc(r5, r6, r0)     // Catch:{ SQLiteException -> 0x0086, all -> 0x0084 }
            goto L_0x007f
        L_0x00d9:
            r4 = r2
            goto L_0x0121
        L_0x00db:
            r3 = r4
            goto L_0x00c2
        L_0x00dd:
            r0 = move-exception
            goto L_0x0121
        L_0x00df:
            r0 = move-exception
            r3 = r4
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ all -> 0x00dd }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x00dd }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x00dd }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgt.zzl(r26)     // Catch:{ all -> 0x00dd }
            r2.zzc(r5, r6, r0)     // Catch:{ all -> 0x00dd }
            if (r4 == 0) goto L_0x00c0
            r4.close()
            goto L_0x00c0
        L_0x00fa:
            if (r4 == 0) goto L_0x011e
            java.util.List r0 = r4.zzf()
            java.util.Iterator r0 = r0.iterator()
        L_0x0104:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x011e
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.measurement.zziu r2 = (com.google.android.gms.internal.measurement.zziu) r2
            java.lang.String r2 = r2.zzc()
            r11 = r28
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x0104
            goto L_0x002e
        L_0x011e:
            r11 = r28
            goto L_0x0127
        L_0x0121:
            if (r4 == 0) goto L_0x0126
            r4.close()
        L_0x0126:
            throw r0
        L_0x0127:
            com.google.android.gms.measurement.internal.zzpf r0 = r1.zzg
            com.google.android.gms.measurement.internal.zzpj r2 = r0.zzp()
            com.google.android.gms.internal.measurement.zzhs r3 = r15.zzd
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            java.util.List r4 = r3.zza()
            java.util.Iterator r4 = r4.iterator()
        L_0x013c:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x01ba
            java.lang.Object r5 = r4.next()
            com.google.android.gms.internal.measurement.zzhw r5 = (com.google.android.gms.internal.measurement.zzhw) r5
            boolean r6 = r5.zzi()
            if (r6 == 0) goto L_0x015a
            java.lang.String r6 = r5.zzb()
            double r8 = r5.zzj()
            r7.putDouble(r6, r8)
            goto L_0x013c
        L_0x015a:
            boolean r6 = r5.zzg()
            if (r6 == 0) goto L_0x016c
            java.lang.String r6 = r5.zzb()
            float r5 = r5.zzh()
            r7.putFloat(r6, r5)
            goto L_0x013c
        L_0x016c:
            boolean r6 = r5.zze()
            if (r6 == 0) goto L_0x017e
            java.lang.String r6 = r5.zzb()
            long r8 = r5.zzf()
            r7.putLong(r6, r8)
            goto L_0x013c
        L_0x017e:
            boolean r6 = r5.zzc()
            if (r6 == 0) goto L_0x0190
            java.lang.String r6 = r5.zzb()
            java.lang.String r5 = r5.zzd()
            r7.putString(r6, r5)
            goto L_0x013c
        L_0x0190:
            java.util.List r6 = r5.zzk()
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x01aa
            java.lang.String r6 = r5.zzb()
            java.util.List r5 = r5.zzk()
            android.os.Bundle[] r5 = com.google.android.gms.measurement.internal.zzpj.zzy(r5)
            r7.putParcelableArray(r6, r5)
            goto L_0x013c
        L_0x01aa:
            com.google.android.gms.measurement.internal.zzib r6 = r2.zzu
            com.google.android.gms.measurement.internal.zzgt r6 = r6.zzaV()
            com.google.android.gms.measurement.internal.zzgr r6 = r6.zzb()
            java.lang.String r8 = "Unexpected parameter type for parameter"
            r6.zzb(r8, r5)
            goto L_0x013c
        L_0x01ba:
            java.lang.String r2 = "_o"
            java.lang.String r4 = r7.getString(r2)
            r7.remove(r2)
            com.google.android.gms.measurement.internal.zzgu r2 = new com.google.android.gms.measurement.internal.zzgu
            java.lang.String r5 = r3.zzd()
            if (r4 != 0) goto L_0x01cd
            java.lang.String r4 = ""
        L_0x01cd:
            r6 = r4
            long r8 = r3.zzf()
            r4 = r2
            r4.<init>(r5, r6, r7, r8)
            com.google.android.gms.measurement.internal.zzib r9 = r1.zzu
            android.os.Bundle r10 = r2.zzd
            java.lang.String r4 = r2.zza
            com.google.android.gms.measurement.internal.zzpo r5 = r9.zzk()
            java.lang.String r6 = "_cmp"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x01ec
            r4 = r29
            r7 = r4
            goto L_0x0217
        L_0x01ec:
            android.os.Bundle r4 = new android.os.Bundle
            r7 = r29
            r4.<init>(r7)
            java.util.Set r6 = r29.keySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x01fb:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0217
            java.lang.Object r8 = r6.next()
            java.lang.String r8 = (java.lang.String) r8
            r27 = r6
            java.lang.String r6 = "gad_"
            boolean r6 = r8.startsWith(r6)
            if (r6 == 0) goto L_0x0214
            r4.remove(r8)
        L_0x0214:
            r6 = r27
            goto L_0x01fb
        L_0x0217:
            r5.zzI(r10, r4)
            com.google.android.gms.measurement.internal.zzib r4 = r1.zzu
            java.lang.String r5 = r2.zzb
            com.google.android.gms.measurement.internal.zzbb r8 = new com.google.android.gms.measurement.internal.zzbb
            java.lang.String r6 = r3.zzd()
            long r16 = r3.zzf()
            long r18 = r3.zzh()
            r2 = r8
            r3 = r4
            r4 = r5
            r5 = r26
            r27 = r8
            r7 = r16
            r16 = r9
            r17 = r10
            r9 = r18
            r11 = r17
            r2.<init>((com.google.android.gms.measurement.internal.zzib) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (long) r7, (long) r9, (android.os.Bundle) r11)
            long r2 = r15.zza
            long r4 = r15.zzb
            boolean r6 = r15.zzc
            r25.zzg()
            r25.zzay()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r27)
            r7 = r27
            java.lang.String r8 = r7.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            com.google.android.gms.measurement.internal.zzpj r0 = r0.zzp()
            com.google.android.gms.internal.measurement.zzhs r0 = r0.zzh(r7)
            byte[] r0 = r0.zzcc()
            android.content.ContentValues r9 = new android.content.ContentValues
            r9.<init>()
            java.lang.String r10 = "app_id"
            r9.put(r10, r8)
            java.lang.String r10 = r7.zzb
            java.lang.String r11 = "name"
            r9.put(r11, r10)
            long r10 = r7.zzd
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            java.lang.String r11 = "timestamp"
            r9.put(r11, r10)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "metadata_fingerprint"
            r9.put(r5, r4)
            java.lang.String r4 = "data"
            r9.put(r4, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            java.lang.String r4 = "realtime"
            r9.put(r4, r0)
            android.database.sqlite.SQLiteDatabase r0 = r25.zze()     // Catch:{ SQLiteException -> 0x02c7 }
            java.lang.String r4 = "raw_events"
            java.lang.String r5 = "rowid = ?"
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ SQLiteException -> 0x02c7 }
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch:{ SQLiteException -> 0x02c7 }
            int r0 = r0.update(r4, r9, r5, r2)     // Catch:{ SQLiteException -> 0x02c7 }
            long r2 = (long) r0     // Catch:{ SQLiteException -> 0x02c7 }
            r4 = 1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzgt r0 = r16.zzaV()     // Catch:{ SQLiteException -> 0x02c7 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x02c7 }
            java.lang.String r4 = "Failed to update raw event. appId, updatedRows"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r8)     // Catch:{ SQLiteException -> 0x02c7 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x02c7 }
            r0.zzc(r4, r5, r2)     // Catch:{ SQLiteException -> 0x02c7 }
            goto L_0x002e
        L_0x02c7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()
            java.lang.String r3 = r7.zza
            java.lang.String r4 = "Error updating raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)
            r2.zzc(r4, r3, r0)
            goto L_0x002e
        L_0x02df:
            java.util.List r0 = r13.zza()
            goto L_0x0024
        L_0x02e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzY(java.lang.String, java.lang.Long, java.lang.String, android.os.Bundle):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.google.android.gms.measurement.internal.zzjk} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r5 != null) goto L_0x002d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzjk zzZ(java.lang.String r5) {
        /*
            r4 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)
            r4.zzg()
            r4.zzay()
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.lang.String r0 = "select consent_state, consent_source from consent_settings where app_id=? limit 1;"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r4.zze()     // Catch:{ SQLiteException -> 0x0049, all -> 0x0046 }
            android.database.Cursor r5 = r2.rawQuery(r0, r5)     // Catch:{ SQLiteException -> 0x0049, all -> 0x0046 }
            boolean r0 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0033 }
            if (r0 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.zzib r0 = r4.zzu     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzk()     // Catch:{ SQLiteException -> 0x0033 }
            java.lang.String r2 = "No data found"
            r0.zza(r2)     // Catch:{ SQLiteException -> 0x0033 }
        L_0x002d:
            r5.close()
            goto L_0x005e
        L_0x0031:
            r0 = move-exception
            goto L_0x0044
        L_0x0033:
            r0 = move-exception
            goto L_0x004c
        L_0x0035:
            r0 = 0
            java.lang.String r0 = r5.getString(r0)     // Catch:{ SQLiteException -> 0x0033 }
            r2 = 1
            int r2 = r5.getInt(r2)     // Catch:{ SQLiteException -> 0x0033 }
            com.google.android.gms.measurement.internal.zzjk r1 = com.google.android.gms.measurement.internal.zzjk.zzf(r0, r2)     // Catch:{ SQLiteException -> 0x0033 }
            goto L_0x002d
        L_0x0044:
            r1 = r5
            goto L_0x0064
        L_0x0046:
            r5 = move-exception
            r0 = r5
            goto L_0x0064
        L_0x0049:
            r5 = move-exception
            r0 = r5
            r5 = r1
        L_0x004c:
            com.google.android.gms.measurement.internal.zzib r2 = r4.zzu     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x0031 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0031 }
            java.lang.String r3 = "Error querying database."
            r2.zzb(r3, r0)     // Catch:{ all -> 0x0031 }
            if (r5 == 0) goto L_0x005e
            goto L_0x002d
        L_0x005e:
            if (r1 != 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzjk r5 = com.google.android.gms.measurement.internal.zzjk.zza
            return r5
        L_0x0063:
            return r1
        L_0x0064:
            if (r1 == 0) goto L_0x0069
            r1.close()
        L_0x0069:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzZ(java.lang.String):com.google.android.gms.measurement.internal.zzjk");
    }

    @WorkerThread
    public final boolean zzaa(String str, zzog zzog) {
        zzg();
        zzay();
        Preconditions.checkNotNull(zzog);
        Preconditions.checkNotEmpty(str);
        zzib zzib = this.zzu;
        long currentTimeMillis = zzib.zzaZ().currentTimeMillis();
        zzfw zzfw = zzfx.zzav;
        long j = zzog.zzb;
        if (j < currentTimeMillis - ((Long) zzfw.zzb((Object) null)).longValue() || j > ((Long) zzfw.zzb((Object) null)).longValue() + currentTimeMillis) {
            zzib.zzaV().zze().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgt.zzl(str), Long.valueOf(currentTimeMillis), Long.valueOf(j));
        }
        zzib.zzaV().zzk().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzog.zza);
        contentValues.put("source", Integer.valueOf(zzog.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(j));
        try {
            if (zze().insert("trigger_uris", (String) null, contentValues) != -1) {
                return true;
            }
            zzib.zzaV().zzb().zzb("Failed to insert trigger URI (got -1). appId", zzgt.zzl(str));
            return false;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing trigger URI. appId", zzgt.zzl(str), e);
            return false;
        }
    }

    public final void zzab(String str, zzjk zzjk) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjk);
        zzg();
        zzay();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzjk.zzl());
        contentValues.put("consent_source", Integer.valueOf(zzjk.zzb()));
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzaz zzac(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzaz.zzg(zzaC("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final void zzad(String str, zzaz zzaz) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzaz);
        zzg();
        zzay();
        zzjk zzZ = zzZ(str);
        zzjk zzjk = zzjk.zza;
        if (zzZ == zzjk) {
            zzab(str, zzjk);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("dma_consent_settings", zzaz.zze());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final void zzae(String str, zzjk zzjk) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzjk);
        zzg();
        zzay();
        zzab(str, zzZ(str));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("storage_consent_at_bundling", zzjk.zzl());
        zzaD("consent_settings", "app_id", contentValues);
    }

    public final zzjk zzaf(String str) {
        Preconditions.checkNotNull(str);
        zzg();
        zzay();
        return zzjk.zzf(zzaC("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{str}, ""), 100);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x032d, code lost:
        r0 = java.lang.Boolean.valueOf(r3.zzh());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0336, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0337, code lost:
        r10.put("session_scoped", r0);
        r10.put("data", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x034b, code lost:
        if (zze().insertWithOnConflict("property_filters", (java.lang.String) null, r10, 5) != -1) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x034d, code lost:
        r1.zzu.zzaV().zzb().zzb("Failed to insert property filter (got -1). appId", com.google.android.gms.measurement.internal.zzgt.zzl(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0361, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0363, code lost:
        r0 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r1.zzu.zzaV().zzb().zzc("Error storing property filter. appId", com.google.android.gms.measurement.internal.zzgt.zzl(r24), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03a7, code lost:
        r3 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x017b, code lost:
        r10 = r0.zzc().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0187, code lost:
        if (r10.hasNext() == false) goto L_0x01ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0193, code lost:
        if (((com.google.android.gms.internal.measurement.zzfn) r10.next()).zza() != false) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0195, code lost:
        r1.zzu.zzaV().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.measurement.internal.zzgt.zzl(r24), java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ae, code lost:
        r10 = r0.zzf().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01c4, code lost:
        if (r10.hasNext() == false) goto L_0x029a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r11 = (com.google.android.gms.internal.measurement.zzff) r10.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e0, code lost:
        if (r11.zzc().isEmpty() == false) goto L_0x0214;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e2, code lost:
        r0 = r1.zzu.zzaV().zze();
        r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r24);
        r12 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01fa, code lost:
        if (r11.zza() == false) goto L_0x0207;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01fc, code lost:
        r16 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0207, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0209, code lost:
        r0.zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r10, r12, java.lang.String.valueOf(r16));
        r21 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0214, code lost:
        r3 = r11.zzcc();
        r21 = r7;
        r7 = new android.content.ContentValues();
        r7.put("app_id", r2);
        r7.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x022d, code lost:
        if (r11.zza() == false) goto L_0x0238;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x022f, code lost:
        r8 = java.lang.Integer.valueOf(r11.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0238, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0239, code lost:
        r7.put("filter_id", r8);
        r7.put(bolts.MeasurementEvent.MEASUREMENT_EVENT_NAME_KEY, r11.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0249, code lost:
        if (r11.zzk() == false) goto L_0x0254;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x024b, code lost:
        r8 = java.lang.Boolean.valueOf(r11.zzm());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0254, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0255, code lost:
        r7.put("session_scoped", r8);
        r7.put("data", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0269, code lost:
        if (zze().insertWithOnConflict("event_filters", (java.lang.String) null, r7, 5) != -1) goto L_0x027e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x026b, code lost:
        r1.zzu.zzaV().zzb().zzb("Failed to insert event filter (got -1). appId", com.google.android.gms.measurement.internal.zzgt.zzl(r24));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x027e, code lost:
        r3 = r25;
        r7 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x029a, code lost:
        r21 = r7;
        r0 = r0.zzc().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02a8, code lost:
        if (r0.hasNext() == false) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02aa, code lost:
        r3 = (com.google.android.gms.internal.measurement.zzfn) r0.next();
        zzay();
        zzg();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24);
        com.google.android.gms.common.internal.Preconditions.checkNotNull(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x02c4, code lost:
        if (r3.zzc().isEmpty() == false) goto L_0x02f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02c6, code lost:
        r0 = r1.zzu.zzaV().zze();
        r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r24);
        r10 = java.lang.Integer.valueOf(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02de, code lost:
        if (r3.zza() == false) goto L_0x02eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02e0, code lost:
        r16 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02eb, code lost:
        r16 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02ed, code lost:
        r0.zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r8, r10, java.lang.String.valueOf(r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02f6, code lost:
        r7 = r3.zzcc();
        r10 = new android.content.ContentValues();
        r10.put("app_id", r2);
        r10.put("audience_id", java.lang.Integer.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x030d, code lost:
        if (r3.zza() == false) goto L_0x0318;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x030f, code lost:
        r11 = java.lang.Integer.valueOf(r3.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0318, code lost:
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0319, code lost:
        r10.put("filter_id", r11);
        r22 = r0;
        r10.put("property_name", r3.zzc());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x032b, code lost:
        if (r3.zzg() == false) goto L_0x0336;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzag(java.lang.String r24, java.util.List r25) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            java.lang.String r4 = "app_id=? and audience_id=?"
            java.lang.String r0 = "app_id=?"
            java.lang.String r5 = "event_filters"
            java.lang.String r6 = "property_filters"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r8 = 0
        L_0x0012:
            int r9 = r25.size()
            if (r8 >= r9) goto L_0x00dc
            java.lang.Object r9 = r3.get(r8)
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9
            com.google.android.gms.internal.measurement.zzma r9 = r9.zzcl()
            com.google.android.gms.internal.measurement.zzfc r9 = (com.google.android.gms.internal.measurement.zzfc) r9
            int r10 = r9.zzd()
            if (r10 == 0) goto L_0x009d
            r10 = 0
        L_0x002b:
            int r11 = r9.zzd()
            if (r10 >= r11) goto L_0x009d
            com.google.android.gms.internal.measurement.zzff r11 = r9.zze(r10)
            com.google.android.gms.internal.measurement.zzma r11 = r11.zzcl()
            com.google.android.gms.internal.measurement.zzfe r11 = (com.google.android.gms.internal.measurement.zzfe) r11
            com.google.android.gms.internal.measurement.zzma r12 = r11.zzaR()
            com.google.android.gms.internal.measurement.zzfe r12 = (com.google.android.gms.internal.measurement.zzfe) r12
            java.lang.String r13 = r11.zza()
            java.lang.String r13 = com.google.android.gms.measurement.internal.zzjl.zzb(r13)
            if (r13 == 0) goto L_0x0050
            r12.zzb(r13)
            r13 = 1
            goto L_0x0051
        L_0x0050:
            r13 = 0
        L_0x0051:
            r15 = 0
        L_0x0052:
            int r14 = r11.zzc()
            if (r15 >= r14) goto L_0x0088
            com.google.android.gms.internal.measurement.zzfh r14 = r11.zzd(r15)
            java.lang.String r7 = r14.zzh()
            r17 = r11
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzjm.zza
            r18 = r4
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.zzjm.zzb
            java.lang.String r4 = com.google.android.gms.measurement.internal.zzls.zzc(r7, r11, r4)
            if (r4 == 0) goto L_0x0081
            com.google.android.gms.internal.measurement.zzma r7 = r14.zzcl()
            com.google.android.gms.internal.measurement.zzfg r7 = (com.google.android.gms.internal.measurement.zzfg) r7
            r7.zza(r4)
            com.google.android.gms.internal.measurement.zzme r4 = r7.zzbc()
            com.google.android.gms.internal.measurement.zzfh r4 = (com.google.android.gms.internal.measurement.zzfh) r4
            r12.zze(r15, r4)
            r13 = 1
        L_0x0081:
            int r15 = r15 + 1
            r11 = r17
            r4 = r18
            goto L_0x0052
        L_0x0088:
            r18 = r4
            if (r13 == 0) goto L_0x0098
            r9.zzf(r10, r12)
            com.google.android.gms.internal.measurement.zzme r4 = r9.zzbc()
            com.google.android.gms.internal.measurement.zzfd r4 = (com.google.android.gms.internal.measurement.zzfd) r4
            r3.set(r8, r4)
        L_0x0098:
            int r10 = r10 + 1
            r4 = r18
            goto L_0x002b
        L_0x009d:
            r18 = r4
            int r4 = r9.zza()
            if (r4 == 0) goto L_0x00d6
            r4 = 0
        L_0x00a6:
            int r7 = r9.zza()
            if (r4 >= r7) goto L_0x00d6
            com.google.android.gms.internal.measurement.zzfn r7 = r9.zzb(r4)
            java.lang.String r10 = r7.zzc()
            java.lang.String[] r11 = com.google.android.gms.measurement.internal.zzjn.zza
            java.lang.String[] r12 = com.google.android.gms.measurement.internal.zzjn.zzb
            java.lang.String r10 = com.google.android.gms.measurement.internal.zzls.zzc(r10, r11, r12)
            if (r10 == 0) goto L_0x00d3
            com.google.android.gms.internal.measurement.zzma r7 = r7.zzcl()
            com.google.android.gms.internal.measurement.zzfm r7 = (com.google.android.gms.internal.measurement.zzfm) r7
            r7.zza(r10)
            r9.zzc(r4, r7)
            com.google.android.gms.internal.measurement.zzme r7 = r9.zzbc()
            com.google.android.gms.internal.measurement.zzfd r7 = (com.google.android.gms.internal.measurement.zzfd) r7
            r3.set(r8, r7)
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00a6
        L_0x00d6:
            int r8 = r8 + 1
            r4 = r18
            goto L_0x0012
        L_0x00dc:
            r18 = r4
            r23.zzay()
            r23.zzg()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            android.database.sqlite.SQLiteDatabase r4 = r23.zze()
            r4.beginTransaction()
            r23.zzay()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r7 = r23.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String[] r8 = new java.lang.String[]{r24}     // Catch:{ all -> 0x0142 }
            r7.delete(r6, r0, r8)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r8 = new java.lang.String[]{r24}     // Catch:{ all -> 0x0142 }
            r7.delete(r5, r0, r8)     // Catch:{ all -> 0x0142 }
            java.util.Iterator r7 = r25.iterator()     // Catch:{ all -> 0x0142 }
        L_0x0110:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x0142 }
            if (r0 == 0) goto L_0x03aa
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzfd r0 = (com.google.android.gms.internal.measurement.zzfd) r0     // Catch:{ all -> 0x0142 }
            r23.zzay()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ all -> 0x0142 }
            boolean r9 = r0.zza()     // Catch:{ all -> 0x0142 }
            if (r9 != 0) goto L_0x0145
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Audience with no ID. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            r0.zzb(r8, r9)     // Catch:{ all -> 0x0142 }
            goto L_0x0110
        L_0x0142:
            r0 = move-exception
            goto L_0x0495
        L_0x0145:
            int r9 = r0.zzb()     // Catch:{ all -> 0x0142 }
            java.util.List r10 = r0.zzf()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0142 }
        L_0x0151:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x017b
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzff r11 = (com.google.android.gms.internal.measurement.zzff) r11     // Catch:{ all -> 0x0142 }
            boolean r11 = r11.zza()     // Catch:{ all -> 0x0142 }
            if (r11 != 0) goto L_0x0151
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r0.zzc(r8, r10, r9)     // Catch:{ all -> 0x0142 }
            goto L_0x0110
        L_0x017b:
            java.util.List r10 = r0.zzc()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0142 }
        L_0x0183:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x01ae
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzfn r11 = (com.google.android.gms.internal.measurement.zzfn) r11     // Catch:{ all -> 0x0142 }
            boolean r11 = r11.zza()     // Catch:{ all -> 0x0142 }
            if (r11 != 0) goto L_0x0183
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r0.zzc(r8, r10, r9)     // Catch:{ all -> 0x0142 }
            goto L_0x0110
        L_0x01ae:
            java.util.List r10 = r0.zzf()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0142 }
        L_0x01b6:
            boolean r11 = r10.hasNext()     // Catch:{ all -> 0x0142 }
            java.lang.String r15 = "data"
            java.lang.String r12 = "session_scoped"
            java.lang.String r13 = "filter_id"
            java.lang.String r8 = "audience_id"
            java.lang.String r14 = "app_id"
            if (r11 == 0) goto L_0x029a
            java.lang.Object r11 = r10.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzff r11 = (com.google.android.gms.internal.measurement.zzff) r11     // Catch:{ all -> 0x0142 }
            r23.zzay()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)     // Catch:{ all -> 0x0142 }
            java.lang.String r21 = r11.zzc()     // Catch:{ all -> 0x0142 }
            boolean r21 = r21.isEmpty()     // Catch:{ all -> 0x0142 }
            if (r21 == 0) goto L_0x0214
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "Event filter had no event name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            boolean r13 = r11.zza()     // Catch:{ all -> 0x0142 }
            if (r13 == 0) goto L_0x0207
            int r11 = r11.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0142 }
            r16 = r11
            goto L_0x0209
        L_0x0207:
            r16 = 0
        L_0x0209:
            java.lang.String r11 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x0142 }
            r0.zzd(r8, r10, r12, r11)     // Catch:{ all -> 0x0142 }
            r21 = r7
            goto L_0x037a
        L_0x0214:
            byte[] r3 = r11.zzcc()     // Catch:{ all -> 0x0142 }
            r21 = r7
            android.content.ContentValues r7 = new android.content.ContentValues     // Catch:{ all -> 0x0142 }
            r7.<init>()     // Catch:{ all -> 0x0142 }
            r7.put(r14, r2)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r7.put(r8, r14)     // Catch:{ all -> 0x0142 }
            boolean r8 = r11.zza()     // Catch:{ all -> 0x0142 }
            if (r8 == 0) goto L_0x0238
            int r8 = r11.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0142 }
            goto L_0x0239
        L_0x0238:
            r8 = 0
        L_0x0239:
            r7.put(r13, r8)     // Catch:{ all -> 0x0142 }
            java.lang.String r8 = "event_name"
            java.lang.String r13 = r11.zzc()     // Catch:{ all -> 0x0142 }
            r7.put(r8, r13)     // Catch:{ all -> 0x0142 }
            boolean r8 = r11.zzk()     // Catch:{ all -> 0x0142 }
            if (r8 == 0) goto L_0x0254
            boolean r8 = r11.zzm()     // Catch:{ all -> 0x0142 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0142 }
            goto L_0x0255
        L_0x0254:
            r8 = 0
        L_0x0255:
            r7.put(r12, r8)     // Catch:{ all -> 0x0142 }
            r7.put(r15, r3)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r3 = r23.zze()     // Catch:{ SQLiteException -> 0x0284 }
            r8 = 0
            r11 = 5
            long r11 = r3.insertWithOnConflict(r5, r8, r7, r11)     // Catch:{ SQLiteException -> 0x0284 }
            r7 = -1
            int r3 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x027e
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu     // Catch:{ SQLiteException -> 0x0284 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ SQLiteException -> 0x0284 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0284 }
            java.lang.String r7 = "Failed to insert event filter (got -1). appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ SQLiteException -> 0x0284 }
            r3.zzb(r7, r8)     // Catch:{ SQLiteException -> 0x0284 }
        L_0x027e:
            r3 = r25
            r7 = r21
            goto L_0x01b6
        L_0x0284:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = "Error storing event filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0142 }
            goto L_0x037a
        L_0x029a:
            r21 = r7
            java.util.List r0 = r0.zzc()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0142 }
        L_0x02a4:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0142 }
            if (r3 == 0) goto L_0x03a7
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzfn r3 = (com.google.android.gms.internal.measurement.zzfn) r3     // Catch:{ all -> 0x0142 }
            r23.zzay()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = r3.zzc()     // Catch:{ all -> 0x0142 }
            boolean r7 = r7.isEmpty()     // Catch:{ all -> 0x0142 }
            if (r7 == 0) goto L_0x02f6
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = "Property filter had no property name. Audience definition ignored. appId, audienceId, filterId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            boolean r11 = r3.zza()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x02eb
            int r3 = r3.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0142 }
            r16 = r3
            goto L_0x02ed
        L_0x02eb:
            r16 = 0
        L_0x02ed:
            java.lang.String r3 = java.lang.String.valueOf(r16)     // Catch:{ all -> 0x0142 }
            r0.zzd(r7, r8, r10, r3)     // Catch:{ all -> 0x0142 }
            goto L_0x037a
        L_0x02f6:
            byte[] r7 = r3.zzcc()     // Catch:{ all -> 0x0142 }
            android.content.ContentValues r10 = new android.content.ContentValues     // Catch:{ all -> 0x0142 }
            r10.<init>()     // Catch:{ all -> 0x0142 }
            r10.put(r14, r2)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r9)     // Catch:{ all -> 0x0142 }
            r10.put(r8, r11)     // Catch:{ all -> 0x0142 }
            boolean r11 = r3.zza()     // Catch:{ all -> 0x0142 }
            if (r11 == 0) goto L_0x0318
            int r11 = r3.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0142 }
            goto L_0x0319
        L_0x0318:
            r11 = 0
        L_0x0319:
            r10.put(r13, r11)     // Catch:{ all -> 0x0142 }
            java.lang.String r11 = "property_name"
            r22 = r0
            java.lang.String r0 = r3.zzc()     // Catch:{ all -> 0x0142 }
            r10.put(r11, r0)     // Catch:{ all -> 0x0142 }
            boolean r0 = r3.zzg()     // Catch:{ all -> 0x0142 }
            if (r0 == 0) goto L_0x0336
            boolean r0 = r3.zzh()     // Catch:{ all -> 0x0142 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0142 }
            goto L_0x0337
        L_0x0336:
            r0 = 0
        L_0x0337:
            r10.put(r12, r0)     // Catch:{ all -> 0x0142 }
            r10.put(r15, r7)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zze()     // Catch:{ SQLiteException -> 0x0361 }
            r3 = 0
            r7 = 5
            long r10 = r0.insertWithOnConflict(r6, r3, r10, r7)     // Catch:{ SQLiteException -> 0x0361 }
            r19 = -1
            int r0 = (r10 > r19 ? 1 : (r10 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x0363
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteException -> 0x0361 }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x0361 }
            java.lang.String r3 = "Failed to insert property filter (got -1). appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ SQLiteException -> 0x0361 }
            r0.zzb(r3, r7)     // Catch:{ SQLiteException -> 0x0361 }
            goto L_0x037a
        L_0x0361:
            r0 = move-exception
            goto L_0x0367
        L_0x0363:
            r0 = r22
            goto L_0x02a4
        L_0x0367:
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.String r7 = "Error storing property filter. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            r3.zzc(r7, r8, r0)     // Catch:{ all -> 0x0142 }
        L_0x037a:
            r23.zzay()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r0 = r23.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0142 }
            r7 = r18
            r0.delete(r6, r7, r3)     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r3 = new java.lang.String[]{r2, r3}     // Catch:{ all -> 0x0142 }
            r0.delete(r5, r7, r3)     // Catch:{ all -> 0x0142 }
            r3 = r25
            r18 = r7
        L_0x03a3:
            r7 = r21
            goto L_0x0110
        L_0x03a7:
            r3 = r25
            goto L_0x03a3
        L_0x03aa:
            r3 = 0
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0142 }
            r0.<init>()     // Catch:{ all -> 0x0142 }
            java.util.Iterator r5 = r25.iterator()     // Catch:{ all -> 0x0142 }
        L_0x03b4:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0142 }
            if (r6 == 0) goto L_0x03d4
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.internal.measurement.zzfd r6 = (com.google.android.gms.internal.measurement.zzfd) r6     // Catch:{ all -> 0x0142 }
            boolean r7 = r6.zza()     // Catch:{ all -> 0x0142 }
            if (r7 == 0) goto L_0x03cf
            int r6 = r6.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0142 }
            goto L_0x03d0
        L_0x03cf:
            r8 = r3
        L_0x03d0:
            r0.add(r8)     // Catch:{ all -> 0x0142 }
            goto L_0x03b4
        L_0x03d4:
            java.lang.String r3 = "("
            java.lang.String r5 = ")"
            java.lang.String r6 = "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in "
            java.lang.String r7 = " order by rowid desc limit -1 offset ?)"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)     // Catch:{ all -> 0x0142 }
            r23.zzay()     // Catch:{ all -> 0x0142 }
            r23.zzg()     // Catch:{ all -> 0x0142 }
            android.database.sqlite.SQLiteDatabase r8 = r23.zze()     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = "select count(1) from audience_filter_values where app_id=?"
            java.lang.String[] r10 = new java.lang.String[]{r24}     // Catch:{ SQLiteException -> 0x047a }
            long r9 = r1.zzaA(r9, r10)     // Catch:{ SQLiteException -> 0x047a }
            com.google.android.gms.measurement.internal.zzib r11 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzal r11 = r11.zzc()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzfw r12 = com.google.android.gms.measurement.internal.zzfx.zzU     // Catch:{ all -> 0x0142 }
            int r11 = r11.zzm(r2, r12)     // Catch:{ all -> 0x0142 }
            r12 = 2000(0x7d0, float:2.803E-42)
            int r11 = java.lang.Math.min(r12, r11)     // Catch:{ all -> 0x0142 }
            r12 = 0
            int r11 = java.lang.Math.max(r12, r11)     // Catch:{ all -> 0x0142 }
            long r13 = (long) r11     // Catch:{ all -> 0x0142 }
            int r15 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r15 > 0) goto L_0x0411
            goto L_0x048e
        L_0x0411:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0142 }
            r9.<init>()     // Catch:{ all -> 0x0142 }
        L_0x0416:
            int r10 = r0.size()     // Catch:{ all -> 0x0142 }
            if (r12 >= r10) goto L_0x0432
            java.lang.Object r10 = r0.get(r12)     // Catch:{ all -> 0x0142 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x0142 }
            if (r10 == 0) goto L_0x048e
            int r10 = r10.intValue()     // Catch:{ all -> 0x0142 }
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ all -> 0x0142 }
            r9.add(r10)     // Catch:{ all -> 0x0142 }
            int r12 = r12 + 1
            goto L_0x0416
        L_0x0432:
            java.lang.String r0 = ","
            java.lang.String r0 = android.text.TextUtils.join(r0, r9)     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0142 }
            int r9 = r9.length()     // Catch:{ all -> 0x0142 }
            int r9 = r9 + 2
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r10.<init>(r9)     // Catch:{ all -> 0x0142 }
            r10.append(r3)     // Catch:{ all -> 0x0142 }
            r10.append(r0)     // Catch:{ all -> 0x0142 }
            r10.append(r5)     // Catch:{ all -> 0x0142 }
            java.lang.String r0 = r10.toString()     // Catch:{ all -> 0x0142 }
            java.lang.String r3 = "audience_filter_values"
            int r5 = r0.length()     // Catch:{ all -> 0x0142 }
            int r5 = r5 + 140
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0142 }
            r9.<init>(r5)     // Catch:{ all -> 0x0142 }
            r9.append(r6)     // Catch:{ all -> 0x0142 }
            r9.append(r0)     // Catch:{ all -> 0x0142 }
            r9.append(r7)     // Catch:{ all -> 0x0142 }
            java.lang.String r0 = r9.toString()     // Catch:{ all -> 0x0142 }
            java.lang.String r5 = java.lang.Integer.toString(r11)     // Catch:{ all -> 0x0142 }
            java.lang.String[] r2 = new java.lang.String[]{r2, r5}     // Catch:{ all -> 0x0142 }
            r8.delete(r3, r0, r2)     // Catch:{ all -> 0x0142 }
            goto L_0x048e
        L_0x047a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r3 = r1.zzu     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x0142 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x0142 }
            java.lang.String r5 = "Database error querying filters. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgt.zzl(r24)     // Catch:{ all -> 0x0142 }
            r3.zzc(r5, r2, r0)     // Catch:{ all -> 0x0142 }
        L_0x048e:
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0142 }
            r4.endTransaction()
            return
        L_0x0495:
            r4.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzag(java.lang.String, java.util.List):void");
    }

    @WorkerThread
    public final zzbc zzah(String str, zzhs zzhs, String str2) {
        zzbc zzaE = zzaE("events", str, zzhs.zzd());
        if (zzaE == null) {
            zzib zzib = this.zzu;
            zzib.zzaV().zze().zzc("Event aggregate wasn't created during raw event logging. appId, event", zzgt.zzl(str), zzib.zzl().zza(str2));
            return new zzbc(str, zzhs.zzd(), 1, 1, 1, zzhs.zzf(), 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
        }
        long j = zzaE.zze + 1;
        long j2 = zzaE.zzd + 1;
        return new zzbc(zzaE.zza, zzaE.zzb, zzaE.zzc + 1, j2, j, zzaE.zzf, zzaE.zzg, zzaE.zzh, zzaE.zzi, zzaE.zzj, zzaE.zzk);
    }

    @VisibleForTesting
    public final boolean zzai() {
        zzib zzib = this.zzu;
        Context zzaY = zzib.zzaY();
        zzib.zzc();
        return zzaY.getDatabasePath("google_app_measurement.db").exists();
    }

    public final /* synthetic */ long zzaj(String str, String[] strArr, long j) {
        return zzaB("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", strArr, -1);
    }

    public final /* synthetic */ zzof zzau() {
        return this.zzn;
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzav(java.lang.String r20, long r21, long r23, com.google.android.gms.measurement.internal.zzpb r25) {
        /*
            r19 = this;
            r1 = r19
            r2 = r25
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r25)
            r19.zzg()
            r19.zzay()
            java.lang.String r0 = " order by rowid limit 1;"
            java.lang.String r3 = "select metadata_fingerprint from raw_events where app_id = ?"
            java.lang.String r4 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            java.lang.String r5 = "select app_id, metadata_fingerprint from raw_events where "
            r6 = 0
            android.database.sqlite.SQLiteDatabase r15 = r19.zze()     // Catch:{ SQLiteException -> 0x0037 }
            boolean r7 = android.text.TextUtils.isEmpty(r20)     // Catch:{ SQLiteException -> 0x0037 }
            r14 = 1
            java.lang.String r8 = ""
            r16 = -1
            r13 = 0
            if (r7 == 0) goto L_0x0083
            int r0 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x003c
            java.lang.String r3 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String r7 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String[] r3 = new java.lang.String[]{r3, r7}     // Catch:{ SQLiteException -> 0x0037 }
            goto L_0x0044
        L_0x0037:
            r0 = move-exception
            r7 = r20
            goto L_0x01e4
        L_0x003c:
            java.lang.String r3 = java.lang.String.valueOf(r21)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0037 }
        L_0x0044:
            if (r0 == 0) goto L_0x0048
            java.lang.String r8 = "rowid <= ? and "
        L_0x0048:
            int r0 = r8.length()     // Catch:{ SQLiteException -> 0x0037 }
            int r0 = r0 + 148
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0037 }
            r7.<init>(r0)     // Catch:{ SQLiteException -> 0x0037 }
            r7.append(r5)     // Catch:{ SQLiteException -> 0x0037 }
            r7.append(r8)     // Catch:{ SQLiteException -> 0x0037 }
            r7.append(r4)     // Catch:{ SQLiteException -> 0x0037 }
            java.lang.String r0 = r7.toString()     // Catch:{ SQLiteException -> 0x0037 }
            android.database.Cursor r6 = r15.rawQuery(r0, r3)     // Catch:{ SQLiteException -> 0x0037 }
            boolean r0 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x007e }
            if (r0 != 0) goto L_0x006c
            goto L_0x01f8
        L_0x006c:
            java.lang.String r3 = r6.getString(r13)     // Catch:{ SQLiteException -> 0x007e }
            java.lang.String r0 = r6.getString(r14)     // Catch:{ SQLiteException -> 0x007b }
            r6.close()     // Catch:{ SQLiteException -> 0x007b }
            goto L_0x00c8
        L_0x0078:
            r0 = move-exception
            goto L_0x01fe
        L_0x007b:
            r0 = move-exception
            goto L_0x01e5
        L_0x007e:
            r0 = move-exception
            r3 = r20
            goto L_0x01e5
        L_0x0083:
            int r4 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0092
            java.lang.String r5 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x0037 }
            r7 = r20
            java.lang.String[] r5 = new java.lang.String[]{r7, r5}     // Catch:{ SQLiteException -> 0x01e3 }
            goto L_0x0098
        L_0x0092:
            r7 = r20
            java.lang.String[] r5 = new java.lang.String[]{r20}     // Catch:{ SQLiteException -> 0x01e3 }
        L_0x0098:
            if (r4 == 0) goto L_0x009c
            java.lang.String r8 = " and rowid <= ?"
        L_0x009c:
            int r4 = r8.length()     // Catch:{ SQLiteException -> 0x01e3 }
            int r4 = r4 + 84
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x01e3 }
            r9.<init>(r4)     // Catch:{ SQLiteException -> 0x01e3 }
            r9.append(r3)     // Catch:{ SQLiteException -> 0x01e3 }
            r9.append(r8)     // Catch:{ SQLiteException -> 0x01e3 }
            r9.append(r0)     // Catch:{ SQLiteException -> 0x01e3 }
            java.lang.String r0 = r9.toString()     // Catch:{ SQLiteException -> 0x01e3 }
            android.database.Cursor r6 = r15.rawQuery(r0, r5)     // Catch:{ SQLiteException -> 0x01e3 }
            boolean r0 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x01e3 }
            if (r0 != 0) goto L_0x00c0
            goto L_0x01f8
        L_0x00c0:
            java.lang.String r0 = r6.getString(r13)     // Catch:{ SQLiteException -> 0x01e3 }
            r6.close()     // Catch:{ SQLiteException -> 0x01e3 }
            r3 = r7
        L_0x00c8:
            java.lang.String r8 = "raw_events_metadata"
            java.lang.String r4 = "metadata"
            java.lang.String[] r9 = new java.lang.String[]{r4}     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r11 = new java.lang.String[]{r3, r0}     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r4 = "rowid"
            java.lang.String r5 = "2"
            r12 = 0
            r18 = 0
            r7 = r15
            r13 = r18
            r14 = r4
            r4 = r15
            r15 = r5
            android.database.Cursor r6 = r7.query(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ SQLiteException -> 0x007b }
            boolean r5 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x007b }
            if (r5 != 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r2 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ SQLiteException -> 0x007b }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x007b }
            goto L_0x01f8
        L_0x0102:
            r5 = 0
            byte[] r7 = r6.getBlob(r5)     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.internal.measurement.zzic r8 = com.google.android.gms.internal.measurement.zzid.zzaE()     // Catch:{ IOException -> 0x01ce }
            com.google.android.gms.internal.measurement.zznk r7 = com.google.android.gms.measurement.internal.zzpj.zzw(r8, r7)     // Catch:{ IOException -> 0x01ce }
            com.google.android.gms.internal.measurement.zzic r7 = (com.google.android.gms.internal.measurement.zzic) r7     // Catch:{ IOException -> 0x01ce }
            com.google.android.gms.internal.measurement.zzme r7 = r7.zzbc()     // Catch:{ IOException -> 0x01ce }
            com.google.android.gms.internal.measurement.zzid r7 = (com.google.android.gms.internal.measurement.zzid) r7     // Catch:{ IOException -> 0x01ce }
            boolean r8 = r6.moveToNext()     // Catch:{ SQLiteException -> 0x007b }
            if (r8 == 0) goto L_0x0130
            com.google.android.gms.measurement.internal.zzib r8 = r1.zzu     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgt r8 = r8.zzaV()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgr r8 = r8.zze()     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r9 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ SQLiteException -> 0x007b }
            r8.zzb(r9, r10)     // Catch:{ SQLiteException -> 0x007b }
        L_0x0130:
            r6.close()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ SQLiteException -> 0x007b }
            r2.zza = r7     // Catch:{ SQLiteException -> 0x007b }
            int r7 = (r23 > r16 ? 1 : (r23 == r16 ? 0 : -1))
            if (r7 == 0) goto L_0x0149
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String r8 = java.lang.String.valueOf(r23)     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String[] r0 = new java.lang.String[]{r3, r0, r8}     // Catch:{ SQLiteException -> 0x007b }
        L_0x0146:
            r11 = r0
            r10 = r7
            goto L_0x0150
        L_0x0149:
            java.lang.String r7 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r0 = new java.lang.String[]{r3, r0}     // Catch:{ SQLiteException -> 0x007b }
            goto L_0x0146
        L_0x0150:
            java.lang.String r8 = "raw_events"
            java.lang.String r0 = "rowid"
            java.lang.String r7 = "name"
            java.lang.String r9 = "timestamp"
            java.lang.String r12 = "data"
            java.lang.String[] r9 = new java.lang.String[]{r0, r7, r9, r12}     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r14 = "rowid"
            r15 = 0
            r12 = 0
            r13 = 0
            r7 = r4
            android.database.Cursor r6 = r7.query(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ SQLiteException -> 0x007b }
            boolean r0 = r6.moveToFirst()     // Catch:{ SQLiteException -> 0x007b }
            if (r0 == 0) goto L_0x01ba
        L_0x016e:
            long r7 = r6.getLong(r5)     // Catch:{ SQLiteException -> 0x007b }
            r0 = 3
            byte[] r0 = r6.getBlob(r0)     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.internal.measurement.zzhr r4 = com.google.android.gms.internal.measurement.zzhs.zzk()     // Catch:{ IOException -> 0x019e }
            com.google.android.gms.internal.measurement.zznk r0 = com.google.android.gms.measurement.internal.zzpj.zzw(r4, r0)     // Catch:{ IOException -> 0x019e }
            com.google.android.gms.internal.measurement.zzhr r0 = (com.google.android.gms.internal.measurement.zzhr) r0     // Catch:{ IOException -> 0x019e }
            r4 = 1
            java.lang.String r9 = r6.getString(r4)     // Catch:{ SQLiteException -> 0x007b }
            r0.zzl(r9)     // Catch:{ SQLiteException -> 0x007b }
            r9 = 2
            long r9 = r6.getLong(r9)     // Catch:{ SQLiteException -> 0x007b }
            r0.zzo(r9)     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.internal.measurement.zzme r0 = r0.zzbc()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.internal.measurement.zzhs r0 = (com.google.android.gms.internal.measurement.zzhs) r0     // Catch:{ SQLiteException -> 0x007b }
            boolean r0 = r2.zza(r7, r0)     // Catch:{ SQLiteException -> 0x007b }
            if (r0 != 0) goto L_0x01b3
            goto L_0x01f8
        L_0x019e:
            r0 = move-exception
            r4 = 1
            com.google.android.gms.measurement.internal.zzib r7 = r1.zzu     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgt r7 = r7.zzaV()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgr r7 = r7.zzb()     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r8 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ SQLiteException -> 0x007b }
            r7.zzc(r8, r9, r0)     // Catch:{ SQLiteException -> 0x007b }
        L_0x01b3:
            boolean r0 = r6.moveToNext()     // Catch:{ SQLiteException -> 0x007b }
            if (r0 != 0) goto L_0x016e
            goto L_0x01f8
        L_0x01ba:
            com.google.android.gms.measurement.internal.zzib r0 = r1.zzu     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r2 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ SQLiteException -> 0x007b }
            r0.zzb(r2, r4)     // Catch:{ SQLiteException -> 0x007b }
            goto L_0x01f8
        L_0x01ce:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ SQLiteException -> 0x007b }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ SQLiteException -> 0x007b }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ SQLiteException -> 0x007b }
            r2.zzc(r4, r5, r0)     // Catch:{ SQLiteException -> 0x007b }
            goto L_0x01f8
        L_0x01e3:
            r0 = move-exception
        L_0x01e4:
            r3 = r7
        L_0x01e5:
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ all -> 0x0078 }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x0078 }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x0078 }
            java.lang.String r4 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)     // Catch:{ all -> 0x0078 }
            r2.zzc(r4, r3, r0)     // Catch:{ all -> 0x0078 }
        L_0x01f8:
            if (r6 == 0) goto L_0x01fd
            r6.close()
        L_0x01fd:
            return
        L_0x01fe:
            if (r6 == 0) goto L_0x0203
            r6.close()
        L_0x0203:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzav(java.lang.String, long, long, com.google.android.gms.measurement.internal.zzpb):void");
    }

    @WorkerThread
    public final void zzb() {
        zzay();
        zze().beginTransaction();
    }

    public final boolean zzbb() {
        return false;
    }

    @WorkerThread
    public final void zzc() {
        zzay();
        zze().setTransactionSuccessful();
    }

    @WorkerThread
    public final void zzd() {
        zzay();
        zze().endTransaction();
    }

    @VisibleForTesting
    @WorkerThread
    public final SQLiteDatabase zze() {
        zzg();
        try {
            return this.zzm.getWritableDatabase();
        } catch (SQLiteException e) {
            this.zzu.zzaV().zze().zzb("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public final zzbc zzf(String str, String str2) {
        return zzaE("events", str, str2);
    }

    @WorkerThread
    public final void zzh(zzbc zzbc) {
        zzaF("events", zzbc);
    }

    public final void zzi(String str) {
        zzbc zzaE;
        zzaG("events_snapshot", str);
        Cursor cursor = null;
        try {
            cursor = zze().query("events", (String[]) Collections.singletonList("name").toArray(new String[0]), "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    if (!(string == null || (zzaE = zzaE("events", str, string)) == null)) {
                        zzaF("events_snapshot", zzaE);
                    }
                } while (cursor.moveToNext());
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error creating snapshot. appId", zzgt.zzl(str), e);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c0, code lost:
        if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0059, code lost:
        if (r8 != null) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x005b, code lost:
        zzaF("events", r8);
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cf A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "events_snapshot"
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r4 = "lifetime_count"
            java.lang.String r5 = "name"
            java.lang.String[] r4 = new java.lang.String[]{r5, r4}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r0.<init>(r4)
            java.lang.String r4 = "events"
            java.lang.String r5 = "_f"
            com.google.android.gms.measurement.internal.zzbc r6 = r1.zzaE(r4, r2, r5)
            java.lang.String r7 = "_v"
            com.google.android.gms.measurement.internal.zzbc r8 = r1.zzaE(r4, r2, r7)
            r1.zzaG(r4, r2)
            r9 = 0
            r10 = 0
            android.database.sqlite.SQLiteDatabase r11 = r19.zze()     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            java.lang.String r12 = "events_snapshot"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            java.lang.Object[] r0 = r0.toArray(r13)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            r13 = r0
            java.lang.String[] r13 = (java.lang.String[]) r13     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            java.lang.String r14 = "app_id=?"
            java.lang.String[] r15 = new java.lang.String[]{r20}     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            r17 = 0
            r18 = 0
            r16 = 0
            android.database.Cursor r9 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            boolean r0 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x009e, all -> 0x009b }
            if (r0 != 0) goto L_0x0060
            r9.close()
            if (r6 == 0) goto L_0x0059
        L_0x0054:
            r1.zzaF(r4, r6)
            goto L_0x00c3
        L_0x0059:
            if (r8 == 0) goto L_0x00c3
        L_0x005b:
            r1.zzaF(r4, r8)
            goto L_0x00c3
        L_0x0060:
            r11 = 0
            r12 = 0
        L_0x0062:
            java.lang.String r0 = r9.getString(r10)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            r13 = 1
            long r14 = r9.getLong(r13)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            r16 = 1
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 < 0) goto L_0x0080
            boolean r14 = r5.equals(r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r14 == 0) goto L_0x0079
            r11 = 1
            goto L_0x0080
        L_0x0079:
            boolean r14 = r7.equals(r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r14 == 0) goto L_0x0080
            r12 = 1
        L_0x0080:
            if (r0 == 0) goto L_0x0090
            com.google.android.gms.measurement.internal.zzbc r0 = r1.zzaE(r3, r2, r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r0 == 0) goto L_0x0090
            r1.zzaF(r4, r0)     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r0 = move-exception
            goto L_0x0097
        L_0x008e:
            r0 = move-exception
            goto L_0x0099
        L_0x0090:
            boolean r0 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x008e, all -> 0x008c }
            if (r0 != 0) goto L_0x0062
            goto L_0x00b4
        L_0x0097:
            r10 = r11
            goto L_0x00c8
        L_0x0099:
            r10 = r11
            goto L_0x00a0
        L_0x009b:
            r0 = move-exception
            r12 = 0
            goto L_0x00c8
        L_0x009e:
            r0 = move-exception
            r12 = 0
        L_0x00a0:
            com.google.android.gms.measurement.internal.zzib r5 = r1.zzu     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ all -> 0x00c7 }
            java.lang.String r7 = "Error querying snapshot. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgt.zzl(r20)     // Catch:{ all -> 0x00c7 }
            r5.zzc(r7, r11, r0)     // Catch:{ all -> 0x00c7 }
            r11 = r10
        L_0x00b4:
            if (r9 == 0) goto L_0x00b9
            r9.close()
        L_0x00b9:
            if (r11 != 0) goto L_0x00be
            if (r6 == 0) goto L_0x00be
            goto L_0x0054
        L_0x00be:
            if (r12 != 0) goto L_0x00c3
            if (r8 == 0) goto L_0x00c3
            goto L_0x005b
        L_0x00c3:
            r1.zzaG(r3, r2)
            return
        L_0x00c7:
            r0 = move-exception
        L_0x00c8:
            if (r9 == 0) goto L_0x00cd
            r9.close()
        L_0x00cd:
            if (r10 != 0) goto L_0x00d6
            if (r6 != 0) goto L_0x00d2
            goto L_0x00d6
        L_0x00d2:
            r1.zzaF(r4, r6)
            goto L_0x00dd
        L_0x00d6:
            if (r12 != 0) goto L_0x00dd
            if (r8 == 0) goto L_0x00dd
            r1.zzaF(r4, r8)
        L_0x00dd:
            r1.zzaG(r3, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzj(java.lang.String):void");
    }

    @WorkerThread
    public final void zzk(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            zze().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzib zzib = this.zzu;
            zzib.zzaV().zzb().zzd("Error deleting user property. appId", zzgt.zzl(str), zzib.zzl().zzc(str2), e);
        }
    }

    @WorkerThread
    public final boolean zzl(zzpm zzpm) {
        Preconditions.checkNotNull(zzpm);
        zzg();
        zzay();
        String str = zzpm.zza;
        String str2 = zzpm.zzc;
        if (zzm(str, str2) == null) {
            if (zzpo.zzh(str2)) {
                if (zzaA("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= ((long) this.zzu.zzc().zzn(str, zzfx.zzV, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long zzaA = zzaA("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, zzpm.zzb});
                this.zzu.zzc();
                if (zzaA >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzpm.zzb);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzpm.zzd));
        zzaw(contentValues, "value", zzpm.zze);
        try {
            if (zze().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) != -1) {
                return true;
            }
            this.zzu.zzaV().zzb().zzb("Failed to insert/update user property (got -1). appId", zzgt.zzl(str));
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing user property. appId", zzgt.zzl(zzpm.zza), e);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0097  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzpm zzm(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r10.zzg()
            r10.zzay()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.zze()     // Catch:{ SQLiteException -> 0x0071, all -> 0x006f }
            java.lang.String r2 = "user_attributes"
            java.lang.String r3 = "set_timestamp"
            java.lang.String r4 = "value"
            java.lang.String r5 = "origin"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch:{ SQLiteException -> 0x0071, all -> 0x006f }
            java.lang.String r4 = "app_id=? and name=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch:{ SQLiteException -> 0x0071, all -> 0x006f }
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0071, all -> 0x006f }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0067 }
            if (r2 != 0) goto L_0x0031
            goto L_0x008f
        L_0x0031:
            r2 = 0
            long r7 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0067 }
            r2 = 1
            java.lang.Object r9 = r10.zzL(r1, r2)     // Catch:{ SQLiteException -> 0x0067 }
            if (r9 != 0) goto L_0x003e
            goto L_0x008f
        L_0x003e:
            r2 = 2
            java.lang.String r5 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x0067 }
            com.google.android.gms.measurement.internal.zzpm r2 = new com.google.android.gms.measurement.internal.zzpm     // Catch:{ SQLiteException -> 0x0067 }
            r3 = r2
            r4 = r11
            r6 = r12
            r3.<init>(r4, r5, r6, r7, r9)     // Catch:{ SQLiteException -> 0x0067 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0067 }
            if (r3 == 0) goto L_0x0069
            com.google.android.gms.measurement.internal.zzib r3 = r10.zzu     // Catch:{ SQLiteException -> 0x0067 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ SQLiteException -> 0x0067 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0067 }
            java.lang.String r4 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r11)     // Catch:{ SQLiteException -> 0x0067 }
            r3.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x0067 }
            goto L_0x0069
        L_0x0065:
            r11 = move-exception
            goto L_0x006d
        L_0x0067:
            r2 = move-exception
            goto L_0x0074
        L_0x0069:
            r1.close()
            return r2
        L_0x006d:
            r0 = r1
            goto L_0x0095
        L_0x006f:
            r11 = move-exception
            goto L_0x0095
        L_0x0071:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0074:
            com.google.android.gms.measurement.internal.zzib r3 = r10.zzu     // Catch:{ all -> 0x0065 }
            com.google.android.gms.measurement.internal.zzgt r4 = r3.zzaV()     // Catch:{ all -> 0x0065 }
            com.google.android.gms.measurement.internal.zzgr r4 = r4.zzb()     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = "Error querying user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzgt.zzl(r11)     // Catch:{ all -> 0x0065 }
            com.google.android.gms.measurement.internal.zzgm r3 = r3.zzl()     // Catch:{ all -> 0x0065 }
            java.lang.String r12 = r3.zzc(r12)     // Catch:{ all -> 0x0065 }
            r4.zzd(r5, r11, r12, r2)     // Catch:{ all -> 0x0065 }
        L_0x008f:
            if (r1 == 0) goto L_0x0094
            r1.close()
        L_0x0094:
            return r0
        L_0x0095:
            if (r0 == 0) goto L_0x009a
            r0.close()
        L_0x009a:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzm(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzpm");
    }

    @WorkerThread
    public final List zzn(String str) {
        List list;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            zzib zzib = this.zzu;
            zzib.zzc();
            cursor = zze().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            list = arrayList;
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j = cursor.getLong(2);
                    Object zzL = zzL(cursor, 3);
                    if (zzL == null) {
                        zzib.zzaV().zzb().zzb("Read invalid user property value, ignoring it. appId", zzgt.zzl(str));
                    } else {
                        arrayList.add(new zzpm(str, str2, string, j, zzL));
                    }
                } while (cursor.moveToNext());
                list = arrayList;
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error querying user properties. appId", zzgt.zzl(str), e);
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

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cc, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ce, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0113, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0115, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013f, code lost:
        r12.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0039, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cc A[Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }, ExcHandler: all (th java.lang.Throwable), Splitter:B:16:0x00a3] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0039 A[Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0016] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzo(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            r22 = this;
            r1 = r22
            r0 = r25
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzg()
            r22.zzay()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.lang.String r11 = "1001"
            java.lang.String r3 = "*"
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0117, all -> 0x0039 }
            r13 = 3
            r4.<init>(r13)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0039 }
            r15 = r23
            r4.add(r15)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0039 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0117, all -> 0x0039 }
            java.lang.String r6 = "app_id=?"
            r5.<init>(r6)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0039 }
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0039 }
            if (r6 != 0) goto L_0x003f
            r14 = r24
            r4.add(r14)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r6 = " and origin=?"
            r5.append(r6)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            goto L_0x0041
        L_0x0039:
            r0 = move-exception
            goto L_0x011b
        L_0x003c:
            r0 = move-exception
            goto L_0x011d
        L_0x003f:
            r14 = r24
        L_0x0041:
            boolean r6 = android.text.TextUtils.isEmpty(r25)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r10 = 1
            if (r6 != 0) goto L_0x0068
            java.lang.String r6 = java.lang.String.valueOf(r25)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            int r6 = r6.length()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            int r6 = r6 + r10
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r7.<init>(r6)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r7.append(r0)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r7.append(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r3 = r7.toString()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r3 = " and name glob ?"
            r5.append(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
        L_0x0068:
            int r3 = r4.size()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.Object[] r3 = r4.toArray(r3)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r7 = r3
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            android.database.sqlite.SQLiteDatabase r3 = r22.zze()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r4 = "user_attributes"
            java.lang.String r6 = "name"
            java.lang.String r8 = "set_timestamp"
            java.lang.String r9 = "value"
            java.lang.String r10 = "origin"
            java.lang.String[] r6 = new java.lang.String[]{r6, r8, r9, r10}     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r8 = r5.toString()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            java.lang.String r10 = "rowid"
            com.google.android.gms.measurement.internal.zzib r9 = r1.zzu     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r9.zzc()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            r17 = 0
            r18 = 0
            r5 = r6
            r6 = r8
            r8 = r17
            r21 = r9
            r9 = r18
            r12 = 1
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x003c, all -> 0x0039 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            if (r4 != 0) goto L_0x00ab
            goto L_0x0136
        L_0x00ab:
            int r4 = r2.size()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            r21.zzc()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r5) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzgt r0 = r21.zzaV()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            r21.zzc()     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            r0.zzb(r4, r5)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            goto L_0x0136
        L_0x00cc:
            r0 = move-exception
            goto L_0x0115
        L_0x00ce:
            r0 = move-exception
            goto L_0x0113
        L_0x00d0:
            r4 = 0
            java.lang.String r17 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            long r18 = r3.getLong(r12)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            r4 = 2
            java.lang.Object r20 = r1.zzL(r3, r4)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            java.lang.String r4 = r3.getString(r13)     // Catch:{ SQLiteException -> 0x00ce, all -> 0x00cc }
            if (r20 != 0) goto L_0x00f8
            com.google.android.gms.measurement.internal.zzgt r5 = r21.zzaV()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            java.lang.String r6 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgt.zzl(r23)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            r5.zzd(r6, r7, r4, r0)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            goto L_0x0105
        L_0x00f6:
            r0 = move-exception
            goto L_0x0110
        L_0x00f8:
            com.google.android.gms.measurement.internal.zzpm r5 = new com.google.android.gms.measurement.internal.zzpm     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            r14 = r5
            r15 = r23
            r16 = r4
            r14.<init>(r15, r16, r17, r18, r20)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            r2.add(r5)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
        L_0x0105:
            boolean r5 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00cc }
            if (r5 != 0) goto L_0x010c
            goto L_0x0136
        L_0x010c:
            r15 = r23
            r14 = r4
            goto L_0x00ab
        L_0x0110:
            r12 = r3
            r14 = r4
            goto L_0x011e
        L_0x0113:
            r12 = r3
            goto L_0x011e
        L_0x0115:
            r12 = r3
            goto L_0x013d
        L_0x0117:
            r0 = move-exception
            r14 = r24
            goto L_0x011d
        L_0x011b:
            r12 = 0
            goto L_0x013d
        L_0x011d:
            r12 = 0
        L_0x011e:
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ all -> 0x013c }
            com.google.android.gms.measurement.internal.zzgt r2 = r2.zzaV()     // Catch:{ all -> 0x013c }
            com.google.android.gms.measurement.internal.zzgr r2 = r2.zzb()     // Catch:{ all -> 0x013c }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzgt.zzl(r23)     // Catch:{ all -> 0x013c }
            r2.zzd(r3, r4, r14, r0)     // Catch:{ all -> 0x013c }
            java.util.List r2 = java.util.Collections.emptyList()     // Catch:{ all -> 0x013c }
            r3 = r12
        L_0x0136:
            if (r3 == 0) goto L_0x013b
            r3.close()
        L_0x013b:
            return r2
        L_0x013c:
            r0 = move-exception
        L_0x013d:
            if (r12 == 0) goto L_0x0142
            r12.close()
        L_0x0142:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzo(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zzp(zzah zzah) {
        Preconditions.checkNotNull(zzah);
        zzg();
        zzay();
        String str = zzah.zza;
        Preconditions.checkNotNull(str);
        if (zzm(str, zzah.zzc.zzb) == null) {
            long zzaA = zzaA("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.zzu.zzc();
            if (zzaA >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzah.zzb);
        contentValues.put("name", zzah.zzc.zzb);
        zzaw(contentValues, "value", Preconditions.checkNotNull(zzah.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzah.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzah.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzah.zzh));
        zzib zzib = this.zzu;
        contentValues.put("timed_out_event", zzib.zzk().zzae(zzah.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzah.zzd));
        contentValues.put("triggered_event", zzib.zzk().zzae(zzah.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzah.zzc.zzc));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzah.zzj));
        contentValues.put("expired_event", zzib.zzk().zzae(zzah.zzk));
        try {
            if (zze().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzib.zzaV().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzgt.zzl(str));
            return true;
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing conditional user property", zzgt.zzl(str), e);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011d  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzah zzq(java.lang.String r27, java.lang.String r28) {
        /*
            r26 = this;
            r1 = r26
            r8 = r28
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r28)
            r26.zzg()
            r26.zzay()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r26.zze()     // Catch:{ SQLiteException -> 0x00f8, all -> 0x00f6 }
            java.lang.String r11 = "conditional_properties"
            java.lang.String r12 = "origin"
            java.lang.String r13 = "value"
            java.lang.String r14 = "active"
            java.lang.String r15 = "trigger_event_name"
            java.lang.String r16 = "trigger_timeout"
            java.lang.String r17 = "timed_out_event"
            java.lang.String r18 = "creation_timestamp"
            java.lang.String r19 = "triggered_event"
            java.lang.String r20 = "triggered_timestamp"
            java.lang.String r21 = "time_to_live"
            java.lang.String r22 = "expired_event"
            java.lang.String[] r12 = new java.lang.String[]{r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22}     // Catch:{ SQLiteException -> 0x00f8, all -> 0x00f6 }
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[]{r27, r28}     // Catch:{ SQLiteException -> 0x00f8, all -> 0x00f6 }
            r16 = 0
            r17 = 0
            r15 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x00f8, all -> 0x00f6 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0056 }
            if (r0 != 0) goto L_0x0048
            goto L_0x0115
        L_0x0048:
            r0 = 0
            java.lang.String r2 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0056 }
            if (r2 != 0) goto L_0x0051
            java.lang.String r2 = ""
        L_0x0051:
            r13 = r2
            goto L_0x0059
        L_0x0053:
            r0 = move-exception
            goto L_0x00f4
        L_0x0056:
            r0 = move-exception
            goto L_0x00fa
        L_0x0059:
            r2 = 1
            java.lang.Object r6 = r1.zzL(r10, r2)     // Catch:{ SQLiteException -> 0x0056 }
            r3 = 2
            int r3 = r10.getInt(r3)     // Catch:{ SQLiteException -> 0x0056 }
            if (r3 == 0) goto L_0x0068
            r17 = 1
            goto L_0x006a
        L_0x0068:
            r17 = 0
        L_0x006a:
            r0 = 3
            java.lang.String r18 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0056 }
            r0 = 4
            long r20 = r10.getLong(r0)     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzpf r0 = r1.zzg     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzpj r2 = r0.zzp()     // Catch:{ SQLiteException -> 0x0056 }
            r3 = 5
            byte[] r3 = r10.getBlob(r3)     // Catch:{ SQLiteException -> 0x0056 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbg> r4 = com.google.android.gms.measurement.internal.zzbg.CREATOR     // Catch:{ SQLiteException -> 0x0056 }
            android.os.Parcelable r2 = r2.zzl(r3, r4)     // Catch:{ SQLiteException -> 0x0056 }
            r19 = r2
            com.google.android.gms.measurement.internal.zzbg r19 = (com.google.android.gms.measurement.internal.zzbg) r19     // Catch:{ SQLiteException -> 0x0056 }
            r2 = 6
            long r15 = r10.getLong(r2)     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzpj r2 = r0.zzp()     // Catch:{ SQLiteException -> 0x0056 }
            r3 = 7
            byte[] r3 = r10.getBlob(r3)     // Catch:{ SQLiteException -> 0x0056 }
            android.os.Parcelable r2 = r2.zzl(r3, r4)     // Catch:{ SQLiteException -> 0x0056 }
            r22 = r2
            com.google.android.gms.measurement.internal.zzbg r22 = (com.google.android.gms.measurement.internal.zzbg) r22     // Catch:{ SQLiteException -> 0x0056 }
            r2 = 8
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteException -> 0x0056 }
            r2 = 9
            long r23 = r10.getLong(r2)     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzpj r0 = r0.zzp()     // Catch:{ SQLiteException -> 0x0056 }
            r2 = 10
            byte[] r2 = r10.getBlob(r2)     // Catch:{ SQLiteException -> 0x0056 }
            android.os.Parcelable r0 = r0.zzl(r2, r4)     // Catch:{ SQLiteException -> 0x0056 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzbg r25 = (com.google.android.gms.measurement.internal.zzbg) r25     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzpk r14 = new com.google.android.gms.measurement.internal.zzpk     // Catch:{ SQLiteException -> 0x0056 }
            r2 = r14
            r3 = r28
            r4 = r11
            r7 = r13
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzah r0 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ SQLiteException -> 0x0056 }
            r11 = r0
            r12 = r27
            r11.<init>(r12, r13, r14, r15, r17, r18, r19, r20, r22, r23, r25)     // Catch:{ SQLiteException -> 0x0056 }
            boolean r2 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0056 }
            if (r2 == 0) goto L_0x00f0
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzgt r3 = r2.zzaV()     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x0056 }
            java.lang.String r4 = "Got multiple records for conditional property, expected one"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r27)     // Catch:{ SQLiteException -> 0x0056 }
            com.google.android.gms.measurement.internal.zzgm r2 = r2.zzl()     // Catch:{ SQLiteException -> 0x0056 }
            java.lang.String r2 = r2.zzc(r8)     // Catch:{ SQLiteException -> 0x0056 }
            r3.zzc(r4, r5, r2)     // Catch:{ SQLiteException -> 0x0056 }
        L_0x00f0:
            r10.close()
            return r0
        L_0x00f4:
            r9 = r10
            goto L_0x011b
        L_0x00f6:
            r0 = move-exception
            goto L_0x011b
        L_0x00f8:
            r0 = move-exception
            r10 = r9
        L_0x00fa:
            com.google.android.gms.measurement.internal.zzib r2 = r1.zzu     // Catch:{ all -> 0x0053 }
            com.google.android.gms.measurement.internal.zzgt r3 = r2.zzaV()     // Catch:{ all -> 0x0053 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = "Error querying conditional property"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzgt.zzl(r27)     // Catch:{ all -> 0x0053 }
            com.google.android.gms.measurement.internal.zzgm r2 = r2.zzl()     // Catch:{ all -> 0x0053 }
            java.lang.String r2 = r2.zzc(r8)     // Catch:{ all -> 0x0053 }
            r3.zzd(r4, r5, r2, r0)     // Catch:{ all -> 0x0053 }
        L_0x0115:
            if (r10 == 0) goto L_0x011a
            r10.close()
        L_0x011a:
            return r9
        L_0x011b:
            if (r9 == 0) goto L_0x0120
            r9.close()
        L_0x0120:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzq(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzah");
    }

    @WorkerThread
    public final int zzr(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzay();
        try {
            return zze().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzib zzib = this.zzu;
            zzib.zzaV().zzb().zzd("Error deleting conditional property", zzgt.zzl(str), zzib.zzl().zzc(str2), e);
            return 0;
        }
    }

    @WorkerThread
    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List zzt(String str, String[] strArr) {
        List list;
        boolean z;
        zzg();
        zzay();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase zze2 = zze();
            String[] strArr2 = {"app_id", "origin", "name", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"};
            zzib zzib = this.zzu;
            zzib.zzc();
            cursor = zze2.query("conditional_properties", strArr2, str, strArr, (String) null, (String) null, "rowid", "1001");
            list = arrayList;
            if (cursor.moveToFirst()) {
                while (true) {
                    int size = arrayList.size();
                    zzib.zzc();
                    if (size < 1000) {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        String string3 = cursor.getString(2);
                        Object zzL = zzL(cursor, 3);
                        if (cursor.getInt(4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        String string4 = cursor.getString(5);
                        long j = cursor.getLong(6);
                        zzpf zzpf = this.zzg;
                        zzpj zzp = zzpf.zzp();
                        byte[] blob = cursor.getBlob(7);
                        Parcelable.Creator<zzbg> creator = zzbg.CREATOR;
                        long j2 = cursor.getLong(8);
                        arrayList.add(new zzah(string, string2, new zzpk(string3, cursor.getLong(10), zzL, string2), j2, z, string4, (zzbg) zzp.zzl(blob, creator), j, (zzbg) zzpf.zzp().zzl(cursor.getBlob(9), creator), cursor.getLong(11), (zzbg) zzpf.zzp().zzl(cursor.getBlob(12), creator)));
                        if (!cursor.moveToNext()) {
                            list = arrayList;
                            break;
                        }
                    } else {
                        zzgr zzb2 = zzib.zzaV().zzb();
                        zzib.zzc();
                        zzb2.zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        list = arrayList;
                        break;
                    }
                }
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzb("Error querying conditional user property value", e);
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

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0306  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzh zzu(java.lang.String r52) {
        /*
            r51 = this;
            r1 = r51
            r2 = r52
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r52)
            r51.zzg()
            r51.zzay()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r51.zze()     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            java.lang.String r5 = "apps"
            java.lang.String r6 = "app_instance_id"
            java.lang.String r7 = "gmp_app_id"
            java.lang.String r8 = "resettable_device_id_hash"
            java.lang.String r9 = "last_bundle_index"
            java.lang.String r10 = "last_bundle_start_timestamp"
            java.lang.String r11 = "last_bundle_end_timestamp"
            java.lang.String r12 = "app_version"
            java.lang.String r13 = "app_store"
            java.lang.String r14 = "gmp_version"
            java.lang.String r15 = "dev_cert_hash"
            java.lang.String r16 = "measurement_enabled"
            java.lang.String r17 = "day"
            java.lang.String r18 = "daily_public_events_count"
            java.lang.String r19 = "daily_events_count"
            java.lang.String r20 = "daily_conversions_count"
            java.lang.String r21 = "config_fetched_time"
            java.lang.String r22 = "failed_config_fetch_time"
            java.lang.String r23 = "app_version_int"
            java.lang.String r24 = "firebase_instance_id"
            java.lang.String r25 = "daily_error_events_count"
            java.lang.String r26 = "daily_realtime_events_count"
            java.lang.String r27 = "health_monitor_sample"
            java.lang.String r28 = "android_id"
            java.lang.String r29 = "adid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String r34 = "session_stitching_token"
            java.lang.String r35 = "sgtm_upload_enabled"
            java.lang.String r36 = "target_os_version"
            java.lang.String r37 = "session_stitching_token_hash"
            java.lang.String r38 = "ad_services_version"
            java.lang.String r39 = "unmatched_first_open_without_ad_id"
            java.lang.String r40 = "npa_metadata_value"
            java.lang.String r41 = "attribution_eligibility_status"
            java.lang.String r42 = "sgtm_preview_key"
            java.lang.String r43 = "dma_consent_state"
            java.lang.String r44 = "daily_realtime_dcu_count"
            java.lang.String r45 = "bundle_delivery_index"
            java.lang.String r46 = "serialized_npa_metadata"
            java.lang.String r47 = "unmatched_pfo"
            java.lang.String r48 = "unmatched_uwa"
            java.lang.String r49 = "ad_campaign_info"
            java.lang.String r50 = "client_upload_eligibility"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50}     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            java.lang.String r7 = "app_id=?"
            java.lang.String[] r8 = new java.lang.String[]{r52}     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            r10 = 0
            r11 = 0
            r9 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x02e9, all -> 0x02e7 }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x00aa }
            if (r0 != 0) goto L_0x0087
            goto L_0x02fe
        L_0x0087:
            com.google.android.gms.measurement.internal.zzh r0 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzpf r5 = r1.zzg     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzib r6 = r5.zzaf()     // Catch:{ SQLiteException -> 0x00aa }
            r0.<init>(r6, r2)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzjk r6 = r5.zzB(r2)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzjj r7 = com.google.android.gms.measurement.internal.zzjj.ANALYTICS_STORAGE     // Catch:{ SQLiteException -> 0x00aa }
            boolean r6 = r6.zzo(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r8 = 0
            if (r6 == 0) goto L_0x00ad
            java.lang.String r6 = r4.getString(r8)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zze(r6)     // Catch:{ SQLiteException -> 0x00aa }
            goto L_0x00ad
        L_0x00a7:
            r0 = move-exception
            goto L_0x02e5
        L_0x00aa:
            r0 = move-exception
            goto L_0x02eb
        L_0x00ad:
            r6 = 1
            java.lang.String r9 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzg(r9)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzjk r9 = r5.zzB(r2)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzjj r10 = com.google.android.gms.measurement.internal.zzjj.AD_STORAGE     // Catch:{ SQLiteException -> 0x00aa }
            boolean r9 = r9.zzo(r10)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x00c9
            r9 = 2
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzk(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x00c9:
            r9 = 3
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzF(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 4
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzo(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 5
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzq(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 6
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzs(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 7
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzw(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 8
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzy(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 9
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzA(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 10
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 != 0) goto L_0x0111
            int r9 = r4.getInt(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x0113
        L_0x0111:
            r9 = 1
            goto L_0x0114
        L_0x0113:
            r9 = 0
        L_0x0114:
            r0.zzE(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 11
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzO(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 12
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzQ(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 13
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzS(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 14
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzU(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 15
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzI(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 16
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzK(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 17
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 == 0) goto L_0x0159
            r9 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x015e
        L_0x0159:
            int r9 = r4.getInt(r9)     // Catch:{ SQLiteException -> 0x00aa }
            long r9 = (long) r9     // Catch:{ SQLiteException -> 0x00aa }
        L_0x015e:
            r0.zzu(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 18
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzm(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 19
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzY(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 20
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzW(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 21
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzab(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 23
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 != 0) goto L_0x0193
            int r9 = r4.getInt(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x0195
        L_0x0193:
            r9 = 1
            goto L_0x0196
        L_0x0195:
            r9 = 0
        L_0x0196:
            r0.zzad(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 25
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 == 0) goto L_0x01a4
            r9 = 0
            goto L_0x01a8
        L_0x01a4:
            long r9 = r4.getLong(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x01a8:
            r0.zzC(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r9 = 26
            boolean r10 = r4.isNull(r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r10 != 0) goto L_0x01c5
            java.lang.String r9 = r4.getString(r9)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.String r10 = ","
            r11 = -1
            java.lang.String[] r9 = r9.split(r10, r11)     // Catch:{ SQLiteException -> 0x00aa }
            java.util.List r9 = java.util.Arrays.asList(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzah(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x01c5:
            com.google.android.gms.measurement.internal.zzjk r5 = r5.zzB(r2)     // Catch:{ SQLiteException -> 0x00aa }
            boolean r5 = r5.zzo(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r5 == 0) goto L_0x01d8
            r5 = 28
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzi(r5)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x01d8:
            r5 = 29
            boolean r7 = r4.isNull(r5)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x01e8
            int r5 = r4.getInt(r5)     // Catch:{ SQLiteException -> 0x00aa }
            if (r5 == 0) goto L_0x01e8
            r5 = 1
            goto L_0x01e9
        L_0x01e8:
            r5 = 0
        L_0x01e9:
            r0.zzaj(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 39
            long r9 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzaE(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 36
            java.lang.String r5 = r4.getString(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzaz(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 30
            long r9 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzal(r9)     // Catch:{ SQLiteException -> 0x00aa }
            r5 = 31
            long r9 = r4.getLong(r5)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzan(r9)     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.internal.measurement.zzql.zza()     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzib r5 = r1.zzu     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzal r7 = r5.zzc()     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzfw r9 = com.google.android.gms.measurement.internal.zzfx.zzaP     // Catch:{ SQLiteException -> 0x00aa }
            boolean r7 = r7.zzp(r2, r9)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x0233
            r7 = 32
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzap(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r7 = 35
            long r9 = r4.getLong(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzax(r9)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x0233:
            r7 = 33
            boolean r9 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 != 0) goto L_0x0243
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x0243
            r7 = 1
            goto L_0x0244
        L_0x0243:
            r7 = 0
        L_0x0244:
            r0.zzar(r7)     // Catch:{ SQLiteException -> 0x00aa }
            r7 = 34
            boolean r9 = r4.isNull(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r9 == 0) goto L_0x0251
            r6 = r3
            goto L_0x025c
        L_0x0251:
            int r7 = r4.getInt(r7)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x0258
            r8 = 1
        L_0x0258:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r8)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x025c:
            r0.zzaf(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 37
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzaB(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 38
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzaD(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 40
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 == 0) goto L_0x027c
            java.lang.String r6 = ""
            goto L_0x0286
        L_0x027c:
            java.lang.String r6 = r4.getString(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.Object r6 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ SQLiteException -> 0x00aa }
        L_0x0286:
            r0.zzaG(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 41
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x029c
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzat(r6)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x029c:
            r6 = 42
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x02af
            long r6 = r4.getLong(r6)     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzav(r6)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x02af:
            r6 = 43
            byte[] r6 = r4.getBlob(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzaI(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r6 = 44
            boolean r7 = r4.isNull(r6)     // Catch:{ SQLiteException -> 0x00aa }
            if (r7 != 0) goto L_0x02c7
            int r6 = r4.getInt(r6)     // Catch:{ SQLiteException -> 0x00aa }
            r0.zzaK(r6)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x02c7:
            r0.zzb()     // Catch:{ SQLiteException -> 0x00aa }
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x00aa }
            if (r6 == 0) goto L_0x02e1
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ SQLiteException -> 0x00aa }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x00aa }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgt.zzl(r52)     // Catch:{ SQLiteException -> 0x00aa }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x00aa }
        L_0x02e1:
            r4.close()
            return r0
        L_0x02e5:
            r3 = r4
            goto L_0x0304
        L_0x02e7:
            r0 = move-exception
            goto L_0x0304
        L_0x02e9:
            r0 = move-exception
            r4 = r3
        L_0x02eb:
            com.google.android.gms.measurement.internal.zzib r5 = r1.zzu     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ all -> 0x00a7 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ all -> 0x00a7 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgt.zzl(r52)     // Catch:{ all -> 0x00a7 }
            r5.zzc(r6, r2, r0)     // Catch:{ all -> 0x00a7 }
        L_0x02fe:
            if (r4 == 0) goto L_0x0303
            r4.close()
        L_0x0303:
            return r3
        L_0x0304:
            if (r3 == 0) goto L_0x0309
            r3.close()
        L_0x0309:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzu(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    @WorkerThread
    public final void zzv(zzh zzh2, boolean z, boolean z2) {
        Preconditions.checkNotNull(zzh2);
        zzg();
        zzay();
        String zzc2 = zzh2.zzc();
        Preconditions.checkNotNull(zzc2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzc2);
        if (z) {
            contentValues.put("app_instance_id", (String) null);
        } else if (this.zzg.zzB(zzc2).zzo(zzjj.ANALYTICS_STORAGE)) {
            contentValues.put("app_instance_id", zzh2.zzd());
        }
        contentValues.put("gmp_app_id", zzh2.zzf());
        zzpf zzpf = this.zzg;
        if (zzpf.zzB(zzc2).zzo(zzjj.AD_STORAGE)) {
            contentValues.put("resettable_device_id_hash", zzh2.zzj());
        }
        contentValues.put("last_bundle_index", Long.valueOf(zzh2.zzG()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzh2.zzn()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzh2.zzp()));
        contentValues.put("app_version", zzh2.zzr());
        contentValues.put("app_store", zzh2.zzv());
        contentValues.put("gmp_version", Long.valueOf(zzh2.zzx()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzh2.zzz()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzh2.zzD()));
        contentValues.put("day", Long.valueOf(zzh2.zzN()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzh2.zzP()));
        contentValues.put("daily_events_count", Long.valueOf(zzh2.zzR()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzh2.zzT()));
        contentValues.put("config_fetched_time", Long.valueOf(zzh2.zzH()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzh2.zzJ()));
        contentValues.put("app_version_int", Long.valueOf(zzh2.zzt()));
        contentValues.put("firebase_instance_id", zzh2.zzl());
        contentValues.put("daily_error_events_count", Long.valueOf(zzh2.zzX()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzh2.zzV()));
        contentValues.put("health_monitor_sample", zzh2.zzZ());
        contentValues.put("android_id", 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzh2.zzac()));
        contentValues.put("dynamite_version", Long.valueOf(zzh2.zzB()));
        if (zzpf.zzB(zzc2).zzo(zzjj.ANALYTICS_STORAGE)) {
            contentValues.put("session_stitching_token", zzh2.zzh());
        }
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzh2.zzai()));
        contentValues.put("target_os_version", Long.valueOf(zzh2.zzak()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzh2.zzam()));
        zzql.zza();
        zzib zzib = this.zzu;
        if (zzib.zzc().zzp(zzc2, zzfx.zzaP)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzh2.zzao()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzh2.zzaw()));
        }
        contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzh2.zzaq()));
        contentValues.put("npa_metadata_value", zzh2.zzae());
        contentValues.put("bundle_delivery_index", Long.valueOf(zzh2.zzaF()));
        contentValues.put("sgtm_preview_key", zzh2.zzay());
        contentValues.put("dma_consent_state", Integer.valueOf(zzh2.zzaA()));
        contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzh2.zzaC()));
        contentValues.put("serialized_npa_metadata", zzh2.zzaH());
        contentValues.put("client_upload_eligibility", Integer.valueOf(zzh2.zzaL()));
        List zzag = zzh2.zzag();
        if (zzag != null) {
            if (zzag.isEmpty()) {
                zzib.zzaV().zze().zzb("Safelisted events should not be an empty list. appId", zzc2);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzag));
            }
        }
        zzpn.zza();
        if (zzib.zzc().zzp((String) null, zzfx.zzaK) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        contentValues.put("unmatched_pfo", zzh2.zzas());
        contentValues.put("unmatched_uwa", zzh2.zzau());
        contentValues.put("ad_campaign_info", zzh2.zzaJ());
        try {
            SQLiteDatabase zze2 = zze();
            if (((long) zze2.update("apps", contentValues, "app_id = ?", new String[]{zzc2})) == 0 && zze2.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzib.zzaV().zzb().zzb("Failed to insert/update app (got -1). appId", zzgt.zzl(zzc2));
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error storing app. appId", zzgt.zzl(zzc2), e);
        }
    }

    @WorkerThread
    public final zzar zzw(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return zzx(j, str, 1, false, false, z3, false, z5, z6, z7);
    }

    @WorkerThread
    public final zzar zzx(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzay();
        String[] strArr = {str};
        zzar zzar = new zzar();
        Cursor cursor = null;
        try {
            SQLiteDatabase zze2 = zze();
            cursor = zze2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                this.zzu.zzaV().zze().zzb("Not updating daily counts, app is not known. appId", zzgt.zzl(str));
            } else {
                if (cursor.getLong(0) == j) {
                    zzar.zzb = cursor.getLong(1);
                    zzar.zza = cursor.getLong(2);
                    zzar.zzc = cursor.getLong(3);
                    zzar.zzd = cursor.getLong(4);
                    zzar.zze = cursor.getLong(5);
                    zzar.zzf = cursor.getLong(6);
                    zzar.zzg = cursor.getLong(7);
                }
                if (z) {
                    zzar.zzb += j2;
                }
                if (z2) {
                    zzar.zza += j2;
                }
                if (z3) {
                    zzar.zzc += j2;
                }
                if (z4) {
                    zzar.zzd += j2;
                }
                if (z5) {
                    zzar.zze += j2;
                }
                if (z6) {
                    zzar.zzf += j2;
                }
                if (z7) {
                    zzar.zzg += j2;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j));
                contentValues.put("daily_public_events_count", Long.valueOf(zzar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzar.zze));
                contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzar.zzf));
                contentValues.put("daily_registered_triggers_count", Long.valueOf(zzar.zzg));
                zze2.update("apps", contentValues, "app_id=?", strArr);
            }
        } catch (SQLiteException e) {
            this.zzu.zzaV().zzb().zzc("Error updating daily counts. appId", zzgt.zzl(str), e);
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        if (cursor != null) {
            cursor.close();
        }
        return zzar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzaq zzy(java.lang.String r10) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r9.zzg()
            r9.zzay()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r9.zze()     // Catch:{ SQLiteException -> 0x006b, all -> 0x0069 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch:{ SQLiteException -> 0x006b, all -> 0x0069 }
            java.lang.String r4 = "app_id=?"
            java.lang.String[] r5 = new java.lang.String[]{r10}     // Catch:{ SQLiteException -> 0x006b, all -> 0x0069 }
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x006b, all -> 0x0069 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0059 }
            if (r2 != 0) goto L_0x002e
            goto L_0x0081
        L_0x002e:
            r2 = 0
            byte[] r2 = r1.getBlob(r2)     // Catch:{ SQLiteException -> 0x0059 }
            r3 = 1
            java.lang.String r3 = r1.getString(r3)     // Catch:{ SQLiteException -> 0x0059 }
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLiteException -> 0x0059 }
            boolean r5 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0059 }
            if (r5 == 0) goto L_0x005b
            com.google.android.gms.measurement.internal.zzib r5 = r9.zzu     // Catch:{ SQLiteException -> 0x0059 }
            com.google.android.gms.measurement.internal.zzgt r5 = r5.zzaV()     // Catch:{ SQLiteException -> 0x0059 }
            com.google.android.gms.measurement.internal.zzgr r5 = r5.zzb()     // Catch:{ SQLiteException -> 0x0059 }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgt.zzl(r10)     // Catch:{ SQLiteException -> 0x0059 }
            r5.zzb(r6, r7)     // Catch:{ SQLiteException -> 0x0059 }
            goto L_0x005b
        L_0x0057:
            r10 = move-exception
            goto L_0x0067
        L_0x0059:
            r2 = move-exception
            goto L_0x006e
        L_0x005b:
            if (r2 != 0) goto L_0x005e
            goto L_0x0081
        L_0x005e:
            com.google.android.gms.measurement.internal.zzaq r5 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ SQLiteException -> 0x0059 }
            r5.<init>(r2, r3, r4)     // Catch:{ SQLiteException -> 0x0059 }
            r1.close()
            return r5
        L_0x0067:
            r0 = r1
            goto L_0x0087
        L_0x0069:
            r10 = move-exception
            goto L_0x0087
        L_0x006b:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x006e:
            com.google.android.gms.measurement.internal.zzib r3 = r9.zzu     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.zzgt r3 = r3.zzaV()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzb()     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzgt.zzl(r10)     // Catch:{ all -> 0x0057 }
            r3.zzc(r4, r10, r2)     // Catch:{ all -> 0x0057 }
        L_0x0081:
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            return r0
        L_0x0087:
            if (r0 == 0) goto L_0x008c
            r0.close()
        L_0x008c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzy(java.lang.String):com.google.android.gms.measurement.internal.zzaq");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0043, code lost:
        if (r3 > (com.google.android.gms.measurement.internal.zzal.zzI() + r1)) goto L_0x0045;
     */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzz(com.google.android.gms.internal.measurement.zzid r9, boolean r10) {
        /*
            r8 = this;
            r8.zzg()
            r8.zzay()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            java.lang.String r0 = r9.zzA()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            boolean r0 = r9.zzn()
            com.google.android.gms.common.internal.Preconditions.checkState(r0)
            r8.zzI()
            com.google.android.gms.measurement.internal.zzib r0 = r8.zzu
            com.google.android.gms.common.util.Clock r1 = r0.zzaZ()
            long r1 = r1.currentTimeMillis()
            long r3 = r9.zzo()
            r0.zzc()
            long r5 = com.google.android.gms.measurement.internal.zzal.zzI()
            long r5 = r1 - r5
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x0045
            long r3 = r9.zzo()
            r0.zzc()
            long r5 = com.google.android.gms.measurement.internal.zzal.zzI()
            long r5 = r5 + r1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0066
        L_0x0045:
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zze()
            java.lang.String r3 = r9.zzA()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgt.zzl(r3)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            long r4 = r9.zzo()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            java.lang.String r4 = "Storing bundle outside of the max uploading time span. appId, now, timestamp"
            r0.zzd(r4, r3, r1, r2)
        L_0x0066:
            byte[] r0 = r9.zzcc()
            r1 = 0
            com.google.android.gms.measurement.internal.zzpf r2 = r8.zzg     // Catch:{ IOException -> 0x0108 }
            com.google.android.gms.measurement.internal.zzpj r2 = r2.zzp()     // Catch:{ IOException -> 0x0108 }
            byte[] r0 = r2.zzv(r0)     // Catch:{ IOException -> 0x0108 }
            com.google.android.gms.measurement.internal.zzib r2 = r8.zzu
            com.google.android.gms.measurement.internal.zzgt r3 = r2.zzaV()
            com.google.android.gms.measurement.internal.zzgr r3 = r3.zzk()
            int r4 = r0.length
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "Saving bundle, size"
            r3.zzb(r5, r4)
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.String r4 = r9.zzA()
            java.lang.String r5 = "app_id"
            r3.put(r5, r4)
            long r4 = r9.zzo()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.String r5 = "bundle_end_timestamp"
            r3.put(r5, r4)
            java.lang.String r4 = "data"
            r3.put(r4, r0)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r0 = "has_realtime"
            r3.put(r0, r10)
            boolean r10 = r9.zzaa()
            if (r10 == 0) goto L_0x00c5
            int r10 = r9.zzab()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r0 = "retry_count"
            r3.put(r0, r10)
        L_0x00c5:
            android.database.sqlite.SQLiteDatabase r10 = r8.zze()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r0 = "queue"
            r4 = 0
            long r3 = r10.insert(r0, r4, r3)     // Catch:{ SQLiteException -> 0x00ec }
            r5 = -1
            int r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x00ee
            com.google.android.gms.measurement.internal.zzgt r10 = r2.zzaV()     // Catch:{ SQLiteException -> 0x00ec }
            com.google.android.gms.measurement.internal.zzgr r10 = r10.zzb()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r0 = "Failed to insert bundle (got -1). appId"
            java.lang.String r2 = r9.zzA()     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzgt.zzl(r2)     // Catch:{ SQLiteException -> 0x00ec }
            r10.zzb(r0, r2)     // Catch:{ SQLiteException -> 0x00ec }
            return r1
        L_0x00ec:
            r10 = move-exception
            goto L_0x00f0
        L_0x00ee:
            r9 = 1
            return r9
        L_0x00f0:
            com.google.android.gms.measurement.internal.zzib r0 = r8.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()
            java.lang.String r9 = r9.zzA()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r9)
            java.lang.String r2 = "Error storing bundle. appId"
            r0.zzc(r2, r9, r10)
            return r1
        L_0x0108:
            r10 = move-exception
            com.google.android.gms.measurement.internal.zzib r0 = r8.zzu
            com.google.android.gms.measurement.internal.zzgt r0 = r0.zzaV()
            com.google.android.gms.measurement.internal.zzgr r0 = r0.zzb()
            java.lang.String r9 = r9.zzA()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzgt.zzl(r9)
            java.lang.String r2 = "Data loss. Failed to serialize bundle. appId"
            r0.zzc(r2, r9, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzav.zzz(com.google.android.gms.internal.measurement.zzid, boolean):boolean");
    }
}
