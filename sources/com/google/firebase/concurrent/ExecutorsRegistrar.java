package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

@SuppressLint({"ThreadPoolCreation"})
public class ExecutorsRegistrar implements ComponentRegistrar {
    static final Lazy<ScheduledExecutorService> BG_EXECUTOR = new Lazy<>(new x3(1));
    static final Lazy<ScheduledExecutorService> BLOCKING_EXECUTOR = new Lazy<>(new x3(3));
    static final Lazy<ScheduledExecutorService> LITE_EXECUTOR = new Lazy<>(new x3(2));
    static final Lazy<ScheduledExecutorService> SCHEDULER = new Lazy<>(new x3(4));

    private static StrictMode.ThreadPolicy bgPolicy() {
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            detectNetwork.detectResourceMismatches();
            if (i >= 26) {
                detectNetwork.detectUnbufferedIo();
            }
        }
        return detectNetwork.penaltyLog().build();
    }

    private static ThreadFactory factory(String str, int i) {
        return new CustomThreadFactory(str, i, (StrictMode.ThreadPolicy) null);
    }

    private static StrictMode.ThreadPolicy litePolicy() {
        return new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build();
    }

    /* access modifiers changed from: private */
    public static ScheduledExecutorService scheduled(ExecutorService executorService) {
        return new DelegatingScheduledExecutorService(executorService, SCHEDULER.get());
    }

    public List<Component<?>> getComponents() {
        Class<Background> cls = Background.class;
        Class<ScheduledExecutorService> cls2 = ScheduledExecutorService.class;
        Class<ExecutorService> cls3 = ExecutorService.class;
        Class<Executor> cls4 = Executor.class;
        Component<ScheduledExecutorService> build = Component.builder(Qualified.qualified(cls, cls2), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(cls, cls3), Qualified.qualified(cls, cls4)}).factory(new d(2)).build();
        Class<Blocking> cls5 = Blocking.class;
        Component<Blocking> build2 = Component.builder(Qualified.qualified(cls5, cls2), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(cls5, cls3), Qualified.qualified(cls5, cls4)}).factory(new d(3)).build();
        Class<Lightweight> cls6 = Lightweight.class;
        return Arrays.asList(new Component[]{build, build2, Component.builder(Qualified.qualified(cls6, cls2), (Qualified<? super T>[]) new Qualified[]{Qualified.qualified(cls6, cls3), Qualified.qualified(cls6, cls4)}).factory(new d(4)).build(), Component.builder(Qualified.qualified(UiThread.class, cls4)).factory(new d(5)).build()});
    }

    private static ThreadFactory factory(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        return new CustomThreadFactory(str, i, threadPolicy);
    }
}
