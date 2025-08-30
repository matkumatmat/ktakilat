package com.google.firebase.perf.session.gauges;

import android.app.ActivityManager;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Utils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GaugeMetadataManager {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ActivityManager activityManager;
    private final Context appContext;
    private final ActivityManager.MemoryInfo memoryInfo;
    private final Runtime runtime;

    public GaugeMetadataManager(Context context) {
        this(Runtime.getRuntime(), context);
    }

    public int getDeviceRamSizeKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.memoryInfo.totalMem));
    }

    public int getMaxAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.maxMemory()));
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.MEGABYTES.toKilobytes((long) this.activityManager.getMemoryClass()));
    }

    @VisibleForTesting
    public int readTotalRAM(String str) {
        BufferedReader bufferedReader;
        String readLine;
        int i;
        try {
            bufferedReader = new BufferedReader(new FileReader(str));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return 0;
                }
            } while (!readLine.startsWith("MemTotal"));
            Matcher matcher = Pattern.compile("\\d+").matcher(readLine);
            if (matcher.find()) {
                i = Integer.parseInt(matcher.group());
            } else {
                i = 0;
            }
            bufferedReader.close();
            return i;
        } catch (IOException e) {
            AndroidLogger androidLogger = logger;
            StringBuilder t = e.t("Unable to read '", str, "' file: ");
            t.append(e.getMessage());
            androidLogger.warn(t.toString());
        } catch (NumberFormatException e2) {
            AndroidLogger androidLogger2 = logger;
            StringBuilder t2 = e.t("Unable to parse '", str, "' file: ");
            t2.append(e2.getMessage());
            androidLogger2.warn(t2.toString());
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @VisibleForTesting
    public GaugeMetadataManager(Runtime runtime2, Context context) {
        this.runtime = runtime2;
        this.appContext = context;
        ActivityManager activityManager2 = (ActivityManager) context.getSystemService("activity");
        this.activityManager = activityManager2;
        ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
        this.memoryInfo = memoryInfo2;
        activityManager2.getMemoryInfo(memoryInfo2);
    }
}
