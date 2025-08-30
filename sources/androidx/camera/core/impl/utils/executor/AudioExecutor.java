package androidx.camera.core.impl.utils.executor;

import android.os.Process;
import androidx.annotation.NonNull;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class AudioExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mAudioService = Executors.newFixedThreadPool(2, new ThreadFactory() {
        private static final String THREAD_NAME_STEM = "CameraX-camerax_audio_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$newThread$0(Runnable runnable) {
            Process.setThreadPriority(-16);
            runnable.run();
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(new a(runnable));
            Locale locale = Locale.US;
            int andIncrement = this.mThreadId.getAndIncrement();
            thread.setName("CameraX-camerax_audio_" + andIncrement);
            return thread;
        }
    });

    public static Executor getInstance() {
        if (sExecutor != null) {
            return sExecutor;
        }
        synchronized (AudioExecutor.class) {
            try {
                if (sExecutor == null) {
                    sExecutor = new AudioExecutor();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return sExecutor;
    }

    public void execute(@NonNull Runnable runnable) {
        this.mAudioService.execute(runnable);
    }
}
