package defpackage;

import androidx.camera.core.internal.ThreadConfig;
import java.util.concurrent.Executor;

/* renamed from: yf  reason: default package */
public abstract /* synthetic */ class yf {
    public static Executor a(ThreadConfig threadConfig) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    public static Executor b(ThreadConfig threadConfig, Executor executor) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
    }
}
