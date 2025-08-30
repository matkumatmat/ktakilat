package org.greenrobot.eventbus;

import android.os.Looper;

public interface MainThreadSupport {

    public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {

        /* renamed from: a  reason: collision with root package name */
        public final Looper f831a;

        public AndroidHandlerMainThreadSupport(Looper looper) {
            this.f831a = looper;
        }
    }
}
