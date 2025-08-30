package androidx.camera.camera2.internal.compat.workaround;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.core.impl.Quirks;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ForceCloseCaptureSession {
    @Nullable
    private final CaptureSessionOnClosedNotCalledQuirk mCaptureSessionOnClosedNotCalledQuirk;

    @FunctionalInterface
    public interface OnConfigured {
        void run(@NonNull SynchronizedCaptureSession synchronizedCaptureSession);
    }

    public ForceCloseCaptureSession(@NonNull Quirks quirks) {
        this.mCaptureSessionOnClosedNotCalledQuirk = (CaptureSessionOnClosedNotCalledQuirk) quirks.get(CaptureSessionOnClosedNotCalledQuirk.class);
    }

    private void forceOnClosed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession next : set) {
            next.getStateCallback().onClosed(next);
        }
    }

    private void forceOnConfigureFailed(@NonNull Set<SynchronizedCaptureSession> set) {
        for (SynchronizedCaptureSession next : set) {
            next.getStateCallback().onConfigureFailed(next);
        }
    }

    public void onSessionConfigured(@NonNull SynchronizedCaptureSession synchronizedCaptureSession, @NonNull List<SynchronizedCaptureSession> list, @NonNull List<SynchronizedCaptureSession> list2, @NonNull OnConfigured onConfigured) {
        SynchronizedCaptureSession next;
        SynchronizedCaptureSession next2;
        if (shouldForceClose()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it = list.iterator();
            while (it.hasNext() && (next2 = it.next()) != synchronizedCaptureSession) {
                linkedHashSet.add(next2);
            }
            forceOnConfigureFailed(linkedHashSet);
        }
        onConfigured.run(synchronizedCaptureSession);
        if (shouldForceClose()) {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            Iterator<SynchronizedCaptureSession> it2 = list2.iterator();
            while (it2.hasNext() && (next = it2.next()) != synchronizedCaptureSession) {
                linkedHashSet2.add(next);
            }
            forceOnClosed(linkedHashSet2);
        }
    }

    public boolean shouldForceClose() {
        if (this.mCaptureSessionOnClosedNotCalledQuirk != null) {
            return true;
        }
        return false;
    }
}
