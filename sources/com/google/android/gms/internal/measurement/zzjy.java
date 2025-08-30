package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.common.base.Optional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public final class zzjy {
    private static volatile Optional zza;

    private zzjy() {
    }

    public static Optional zza(Context context) {
        Context context2;
        StrictMode.ThreadPolicy allowThreadDiskReads;
        Optional optional;
        BufferedReader bufferedReader;
        Throwable th;
        Optional optional2 = zza;
        if (optional2 == null) {
            synchronized (zzjy.class) {
                try {
                    optional2 = zza;
                    if (optional2 == null) {
                        String str = Build.TYPE;
                        String str2 = Build.TAGS;
                        int i = zzka.zza;
                        if (!str.equals("eng")) {
                            if (str.equals("userdebug")) {
                            }
                            optional2 = Optional.absent();
                            zza = optional2;
                        }
                        if (!str2.contains("dev-keys")) {
                            if (str2.contains("test-keys")) {
                            }
                            optional2 = Optional.absent();
                            zza = optional2;
                        }
                        if (!zzjm.zza() || context.isDeviceProtectedStorage()) {
                            context2 = context;
                        } else {
                            context2 = context.createDeviceProtectedStorageContext();
                        }
                        allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        StrictMode.allowThreadDiskWrites();
                        char c = 0;
                        try {
                            File file = new File(context2.getDir("phenotype_hermetic", 0), "overrides.txt");
                            if (file.exists()) {
                                optional = Optional.of(file);
                            } else {
                                optional = Optional.absent();
                            }
                        } catch (RuntimeException e) {
                            Log.e("HermeticFileOverrides", "no data dir", e);
                            optional = Optional.absent();
                        }
                        if (optional.isPresent()) {
                            File file2 = (File) optional.get();
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                                SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
                                HashMap hashMap = new HashMap();
                                while (true) {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    String[] split = readLine.split(StringUtils.SPACE, 3);
                                    if (split.length != 3) {
                                        StringBuilder sb = new StringBuilder(readLine.length() + 9);
                                        sb.append("Invalid: ");
                                        sb.append(readLine);
                                        Log.e("HermeticFileOverrides", sb.toString());
                                    } else {
                                        String str3 = new String(split[c]);
                                        String decode = Uri.decode(new String(split[1]));
                                        String str4 = (String) hashMap.get(split[2]);
                                        if (str4 == null) {
                                            String str5 = new String(split[2]);
                                            str4 = Uri.decode(str5);
                                            if (str4.length() < 1024 || str4 == str5) {
                                                hashMap.put(str5, str4);
                                            }
                                        }
                                        SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(str3);
                                        if (simpleArrayMap2 == null) {
                                            simpleArrayMap2 = new SimpleArrayMap();
                                            simpleArrayMap.put(str3, simpleArrayMap2);
                                        }
                                        simpleArrayMap2.put(decode, str4);
                                        c = 0;
                                    }
                                }
                                String obj = file2.toString();
                                String packageName = context2.getPackageName();
                                StringBuilder sb2 = new StringBuilder(obj.length() + 28 + String.valueOf(packageName).length());
                                sb2.append("Parsed ");
                                sb2.append(obj);
                                sb2.append(" for Android package ");
                                sb2.append(packageName);
                                Log.w("HermeticFileOverrides", sb2.toString());
                                zzjs zzjs = new zzjs(simpleArrayMap);
                                bufferedReader.close();
                                optional2 = Optional.of(zzjs);
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            optional2 = Optional.absent();
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        zza = optional2;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return optional2;
        throw th;
    }
}
