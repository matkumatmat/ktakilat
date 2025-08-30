package defpackage;

import androidx.camera.core.internal.IoConfig;
import java.util.concurrent.Executor;

/* renamed from: hb  reason: default package */
public abstract /* synthetic */ class hb {
    public static Executor a(IoConfig ioConfig) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }

    public static Executor b(IoConfig ioConfig, Executor executor) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }
}
