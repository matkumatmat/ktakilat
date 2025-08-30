package com.google.firebase.perf.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@VisibleForTesting(otherwise = 3)
public class DeviceCacheManager {
    private static final String PREFS_NAME = "FirebasePerfSharedPrefs";
    private static DeviceCacheManager instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ExecutorService serialExecutor;
    private volatile SharedPreferences sharedPref;

    @VisibleForTesting
    public DeviceCacheManager(ExecutorService executorService) {
        this.serialExecutor = executorService;
    }

    @VisibleForTesting
    public static void clearInstance() {
        instance = null;
    }

    @Nullable
    private Context getFirebaseApplicationContext() {
        try {
            FirebaseApp.getInstance();
            return FirebaseApp.getInstance().getApplicationContext();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public static synchronized DeviceCacheManager getInstance() {
        DeviceCacheManager deviceCacheManager;
        synchronized (DeviceCacheManager.class) {
            try {
                if (instance == null) {
                    instance = new DeviceCacheManager(Executors.newSingleThreadExecutor());
                }
                deviceCacheManager = instance;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return deviceCacheManager;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setContext$0(Context context) {
        if (this.sharedPref == null && context != null) {
            this.sharedPref = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
        }
    }

    public void clear(String str) {
        if (str == null) {
            logger.debug("Key is null. Cannot clear nullable key");
        } else {
            this.sharedPref.edit().remove(str).apply();
        }
    }

    public boolean containsKey(String str) {
        if (this.sharedPref == null || str == null || !this.sharedPref.contains(str)) {
            return false;
        }
        return true;
    }

    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("Key is null when getting boolean value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.of(Boolean.valueOf(this.sharedPref.getBoolean(str, false)));
        } catch (ClassCastException e) {
            logger.debug("Key %s from sharedPreferences has type other than long: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        return com.google.firebase.perf.util.Optional.of(java.lang.Double.valueOf(java.lang.Float.valueOf(r4.sharedPref.getFloat(r5, 0.0f)).doubleValue()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        logger.debug("Key %s from sharedPreferences has type other than double: %s", r5, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0075, code lost:
        return com.google.firebase.perf.util.Optional.absent();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.perf.util.Optional<java.lang.Double> getDouble(java.lang.String r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x000e
            com.google.firebase.perf.logging.AndroidLogger r5 = logger
            java.lang.String r0 = "Key is null when getting double value on device cache."
            r5.debug(r0)
            com.google.firebase.perf.util.Optional r5 = com.google.firebase.perf.util.Optional.absent()
            return r5
        L_0x000e:
            android.content.SharedPreferences r0 = r4.sharedPref
            if (r0 != 0) goto L_0x0022
            android.content.Context r0 = r4.getFirebaseApplicationContext()
            r4.setContext(r0)
            android.content.SharedPreferences r0 = r4.sharedPref
            if (r0 != 0) goto L_0x0022
            com.google.firebase.perf.util.Optional r5 = com.google.firebase.perf.util.Optional.absent()
            return r5
        L_0x0022:
            android.content.SharedPreferences r0 = r4.sharedPref
            boolean r0 = r0.contains(r5)
            if (r0 != 0) goto L_0x002f
            com.google.firebase.perf.util.Optional r5 = com.google.firebase.perf.util.Optional.absent()
            return r5
        L_0x002f:
            android.content.SharedPreferences r0 = r4.sharedPref     // Catch:{ ClassCastException -> 0x0044 }
            r1 = 0
            long r0 = r0.getLong(r5, r1)     // Catch:{ ClassCastException -> 0x0044 }
            double r0 = java.lang.Double.longBitsToDouble(r0)     // Catch:{ ClassCastException -> 0x0044 }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ ClassCastException -> 0x0044 }
            com.google.firebase.perf.util.Optional r5 = com.google.firebase.perf.util.Optional.of(r0)     // Catch:{ ClassCastException -> 0x0044 }
            return r5
        L_0x0044:
            android.content.SharedPreferences r0 = r4.sharedPref     // Catch:{ ClassCastException -> 0x005c }
            r1 = 0
            float r0 = r0.getFloat(r5, r1)     // Catch:{ ClassCastException -> 0x005c }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ ClassCastException -> 0x005c }
            double r0 = r0.doubleValue()     // Catch:{ ClassCastException -> 0x005c }
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ ClassCastException -> 0x005c }
            com.google.firebase.perf.util.Optional r5 = com.google.firebase.perf.util.Optional.of(r0)     // Catch:{ ClassCastException -> 0x005c }
            return r5
        L_0x005c:
            r0 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r1 = logger
            java.lang.String r0 = r0.getMessage()
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            r2[r5] = r0
            java.lang.String r5 = "Key %s from sharedPreferences has type other than double: %s"
            r1.debug(r5, r2)
            com.google.firebase.perf.util.Optional r5 = com.google.firebase.perf.util.Optional.absent()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.config.DeviceCacheManager.getDouble(java.lang.String):com.google.firebase.perf.util.Optional");
    }

    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("Key is null when getting long value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.of(Long.valueOf(this.sharedPref.getLong(str, 0)));
        } catch (ClassCastException e) {
            logger.debug("Key %s from sharedPreferences has type other than long: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("Key is null when getting String value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.of(this.sharedPref.getString(str, ""));
        } catch (ClassCastException e) {
            logger.debug("Key %s from sharedPreferences has type other than String: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    public synchronized void setContext(Context context) {
        if (this.sharedPref == null && context != null) {
            this.serialExecutor.execute(new e0(20, this, context));
        }
    }

    public boolean setValue(String str, boolean z) {
        if (str == null) {
            logger.debug("Key is null when setting boolean value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putBoolean(str, z).apply();
        return true;
    }

    public boolean setValue(String str, String str2) {
        if (str == null) {
            logger.debug("Key is null when setting String value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.sharedPref.edit().remove(str).apply();
            return true;
        }
        this.sharedPref.edit().putString(str, str2).apply();
        return true;
    }

    public boolean setValue(String str, double d) {
        if (str == null) {
            logger.debug("Key is null when setting double value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, Double.doubleToRawLongBits(d)).apply();
        return true;
    }

    public boolean setValue(String str, long j) {
        if (str == null) {
            logger.debug("Key is null when setting long value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, j).apply();
        return true;
    }
}
