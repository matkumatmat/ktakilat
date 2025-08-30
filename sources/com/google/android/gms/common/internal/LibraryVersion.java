package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ConcurrentHashMap;

@KeepForSdk
@Deprecated
public class LibraryVersion {
    private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    private static final LibraryVersion zzb = new LibraryVersion();
    private final ConcurrentHashMap zzc = new ConcurrentHashMap();

    @NonNull
    @KeepForSdk
    public static LibraryVersion getInstance() {
        return zzb;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ab  */
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getVersion(@androidx.annotation.NonNull java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "LibraryVersion"
            java.lang.String r1 = "Failed to get app version for libraryName: "
            java.lang.String r2 = "/"
            java.lang.String r3 = "Please provide a valid libraryName"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9, r3)
            java.util.concurrent.ConcurrentHashMap r3 = r8.zzc
            boolean r3 = r3.containsKey(r9)
            if (r3 == 0) goto L_0x001c
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            java.lang.Object r9 = r0.get(r9)
            java.lang.String r9 = (java.lang.String) r9
            return r9
        L_0x001c:
            java.util.Properties r3 = new java.util.Properties
            r3.<init>()
            r4 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0079 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x0079 }
            r5.append(r9)     // Catch:{ IOException -> 0x0079 }
            java.lang.String r2 = ".properties"
            r5.append(r2)     // Catch:{ IOException -> 0x0079 }
            java.lang.String r2 = r5.toString()     // Catch:{ IOException -> 0x0079 }
            java.lang.Class<com.google.android.gms.common.internal.LibraryVersion> r5 = com.google.android.gms.common.internal.LibraryVersion.class
            java.io.InputStream r2 = r5.getResourceAsStream(r2)     // Catch:{ IOException -> 0x0079 }
            if (r2 == 0) goto L_0x0065
            r3.load(r2)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            java.lang.String r5 = "version"
            java.lang.String r4 = r3.getProperty(r5, r4)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            com.google.android.gms.common.internal.GmsLogger r3 = zza     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r5.<init>()     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r5.append(r9)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            java.lang.String r6 = " version is "
            r5.append(r6)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r5.append(r4)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r3.v(r0, r5)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            goto L_0x0093
        L_0x005e:
            r9 = move-exception
            goto L_0x0077
        L_0x0060:
            r3 = move-exception
            r7 = r4
            r4 = r2
            r2 = r7
            goto L_0x007f
        L_0x0065:
            com.google.android.gms.common.internal.GmsLogger r3 = zza     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r5.append(r9)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            java.lang.String r5 = r5.toString()     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            r3.w(r0, r5)     // Catch:{ IOException -> 0x0060, all -> 0x005e }
            goto L_0x0093
        L_0x0077:
            r4 = r2
            goto L_0x00a9
        L_0x0079:
            r2 = move-exception
            r3 = r2
            goto L_0x007e
        L_0x007c:
            r9 = move-exception
            goto L_0x00a9
        L_0x007e:
            r2 = r4
        L_0x007f:
            com.google.android.gms.common.internal.GmsLogger r5 = zza     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r6.<init>(r1)     // Catch:{ all -> 0x007c }
            r6.append(r9)     // Catch:{ all -> 0x007c }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x007c }
            r5.e(r0, r1, r3)     // Catch:{ all -> 0x007c }
            r7 = r4
            r4 = r2
            r2 = r7
        L_0x0093:
            if (r2 == 0) goto L_0x0098
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r2)
        L_0x0098:
            if (r4 != 0) goto L_0x00a3
            com.google.android.gms.common.internal.GmsLogger r1 = zza
            java.lang.String r2 = ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"
            r1.d(r0, r2)
            java.lang.String r4 = "UNKNOWN"
        L_0x00a3:
            java.util.concurrent.ConcurrentHashMap r0 = r8.zzc
            r0.put(r9, r4)
            return r4
        L_0x00a9:
            if (r4 == 0) goto L_0x00ae
            com.google.android.gms.common.util.IOUtils.closeQuietly((java.io.Closeable) r4)
        L_0x00ae:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.LibraryVersion.getVersion(java.lang.String):java.lang.String");
    }
}
