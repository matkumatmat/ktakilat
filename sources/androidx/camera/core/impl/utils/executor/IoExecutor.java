package androidx.camera.core.impl.utils.executor;

import androidx.annotation.NonNull;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class IoExecutor implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mIoService = Executors.newFixedThreadPool(2, new ThreadFactory() {
        private static final String THREAD_NAME_STEM = "CameraX-camerax_io_%d";
        private final AtomicInteger mThreadId = new AtomicInteger(0);

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            Locale locale = Locale.US;
            int andIncrement = this.mThreadId.getAndIncrement();
            thread.setName("CameraX-camerax_io_" + andIncrement);
            return thread;
        }
    });

    public static Executor getInstance() {
        if (sExecutor != null) {
            return sExecutor;
        }
        synchronized (IoExecutor.class) {
            try {
                if (sExecutor == null) {
                    sExecutor = new IoExecutor();
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
        this.mIoService.execute(runnable);
    }
}
