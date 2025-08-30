package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class RotationProvider {
    @VisibleForTesting
    boolean mIgnoreCanDetectForTest = false;
    @GuardedBy("mLock")
    @NonNull
    final Map<Listener, ListenerWrapper> mListeners = new HashMap();
    final Object mLock = new Object();
    @VisibleForTesting
    @GuardedBy("mLock")
    @NonNull
    final OrientationEventListener mOrientationListener;

    public interface Listener {
        void onRotationChanged(int i);
    }

    public static class ListenerWrapper {
        private final AtomicBoolean mEnabled = new AtomicBoolean(true);
        private final Executor mExecutor;
        private final Listener mListener;

        public ListenerWrapper(Listener listener, Executor executor) {
            this.mListener = listener;
            this.mExecutor = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onRotationChanged$0(int i) {
            if (this.mEnabled.get()) {
                this.mListener.onRotationChanged(i);
            }
        }

        public void disable() {
            this.mEnabled.set(false);
        }

        public void onRotationChanged(int i) {
            this.mExecutor.execute(new i(this, i));
        }
    }

    public RotationProvider(@NonNull Context context) {
        this.mOrientationListener = new OrientationEventListener(context) {
            private static final int INVALID_SURFACE_ROTATION = -1;
            private int mRotation = -1;

            public void onOrientationChanged(int i) {
                int orientationToSurfaceRotation;
                ArrayList arrayList;
                if (i != -1 && this.mRotation != (orientationToSurfaceRotation = RotationProvider.orientationToSurfaceRotation(i))) {
                    this.mRotation = orientationToSurfaceRotation;
                    synchronized (RotationProvider.this.mLock) {
                        arrayList = new ArrayList(RotationProvider.this.mListeners.values());
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ListenerWrapper) it.next()).onRotationChanged(orientationToSurfaceRotation);
                        }
                    }
                }
            }
        };
    }

    @VisibleForTesting
    public static int orientationToSurfaceRotation(int i) {
        if (i >= 315 || i < 45) {
            return 0;
        }
        if (i >= 225) {
            return 1;
        }
        return i >= 135 ? 2 : 3;
    }

    @CheckResult
    public boolean addListener(@NonNull Executor executor, @NonNull Listener listener) {
        synchronized (this.mLock) {
            try {
                if (!this.mOrientationListener.canDetectOrientation() && !this.mIgnoreCanDetectForTest) {
                    return false;
                }
                this.mListeners.put(listener, new ListenerWrapper(listener, executor));
                this.mOrientationListener.enable();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeListener(@NonNull Listener listener) {
        synchronized (this.mLock) {
            try {
                ListenerWrapper listenerWrapper = this.mListeners.get(listener);
                if (listenerWrapper != null) {
                    listenerWrapper.disable();
                    this.mListeners.remove(listener);
                }
                if (this.mListeners.isEmpty()) {
                    this.mOrientationListener.disable();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
