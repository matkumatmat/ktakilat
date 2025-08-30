package defpackage;

import android.view.Choreographer;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* renamed from: ea  reason: default package */
public final /* synthetic */ class ea implements Choreographer.FrameCallback {
    public final void doFrame(long j) {
        int i = HandlerDispatcherKt.f772a;
        DefaultScheduler defaultScheduler = Dispatchers.f767a;
        MainCoroutineDispatcher mainCoroutineDispatcher = MainDispatcherLoader.f801a;
        throw null;
    }
}
