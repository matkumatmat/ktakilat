package com.ktakilat.loan.webtool;

import com.ktakilat.loan.KtakilatApplication;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class FixWebProcess {
    public static void a(KtakilatApplication ktakilatApplication, String str) {
        boolean z;
        File file = new File(ktakilatApplication.getDataDir().getAbsolutePath() + "/app_webview" + str + "/webview_data.lock");
        if (file.exists()) {
            try {
                FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
                if (tryLock != null) {
                    tryLock.close();
                } else if (file.delete()) {
                    try {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (file.exists()) {
                    z = file.delete();
                } else {
                    z = false;
                }
                if (z) {
                    try {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }
}
