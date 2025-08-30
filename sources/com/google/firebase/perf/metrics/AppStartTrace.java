package com.google.firebase.perf.metrics;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Process;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.ApplicationProcessState;
import com.google.firebase.perf.v1.TraceMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.BooleanUtils;

public class AppStartTrace implements Application.ActivityLifecycleCallbacks, LifecycleObserver {
    private static final int CORE_POOL_SIZE = 0;
    private static final long MAX_LATENCY_BEFORE_UI_INIT = TimeUnit.MINUTES.toMicros(1);
    private static final int MAX_POOL_SIZE = 1;
    @NonNull
    private static final Timer PERF_CLASS_LOAD_TIME = new Clock().getTime();
    private static ExecutorService executorService;
    private static volatile AppStartTrace instance;
    private Context appContext;
    private WeakReference<Activity> appStartActivity;
    private final Clock clock;
    private final ConfigResolver configResolver;
    private final TraceMetric.Builder experimentTtid;
    @Nullable
    private final Timer firebaseClassLoadTime;
    @Nullable
    private Timer firstBackgroundTime;
    private Timer firstForegroundTime;
    private boolean isRegisteredForLifecycleCallbacks = false;
    /* access modifiers changed from: private */
    public boolean isStartedFromBackground;
    private boolean isTooLateToInitUI = false;
    private WeakReference<Activity> launchActivity;
    /* access modifiers changed from: private */
    public Timer onCreateTime;
    private int onDrawCount;
    private final DrawCounter onDrawCounterListener;
    private Timer onDrawPostAtFrontOfQueueTime;
    private Timer onResumeTime;
    private Timer onStartTime;
    private Timer preDrawPostAtFrontOfQueueTime;
    private Timer preDrawPostTime;
    @Nullable
    private final Timer processStartTime;
    private PerfSession startSession;
    private boolean systemForegroundCheck;
    private final TransportManager transportManager;

    public final class DrawCounter implements ViewTreeObserver.OnDrawListener {
        private DrawCounter() {
        }

        public void onDraw() {
            AppStartTrace.access$308(AppStartTrace.this);
        }
    }

    public static class StartFromBackgroundRunnable implements Runnable {
        private final AppStartTrace trace;

        public StartFromBackgroundRunnable(AppStartTrace appStartTrace) {
            this.trace = appStartTrace;
        }

        public void run() {
            if (this.trace.onCreateTime == null) {
                boolean unused = this.trace.isStartedFromBackground = true;
            }
        }
    }

    public AppStartTrace(@NonNull TransportManager transportManager2, @NonNull Clock clock2, @NonNull ConfigResolver configResolver2, @NonNull ExecutorService executorService2) {
        Timer timer;
        Timer timer2 = null;
        this.onCreateTime = null;
        this.onStartTime = null;
        this.onResumeTime = null;
        this.firstForegroundTime = null;
        this.firstBackgroundTime = null;
        this.preDrawPostTime = null;
        this.preDrawPostAtFrontOfQueueTime = null;
        this.onDrawPostAtFrontOfQueueTime = null;
        this.isStartedFromBackground = false;
        this.onDrawCount = 0;
        this.onDrawCounterListener = new DrawCounter();
        this.systemForegroundCheck = false;
        this.transportManager = transportManager2;
        this.clock = clock2;
        this.configResolver = configResolver2;
        executorService = executorService2;
        this.experimentTtid = TraceMetric.newBuilder().setName("_experiment_app_start_ttid");
        if (Build.VERSION.SDK_INT >= 24) {
            timer = Timer.ofElapsedRealtime(Process.getStartElapsedRealtime());
        } else {
            timer = null;
        }
        this.processStartTime = timer;
        StartupTime startupTime = (StartupTime) FirebaseApp.getInstance().get(StartupTime.class);
        this.firebaseClassLoadTime = startupTime != null ? Timer.ofElapsedRealtime(startupTime.getElapsedRealtime()) : timer2;
    }

    public static /* synthetic */ int access$308(AppStartTrace appStartTrace) {
        int i = appStartTrace.onDrawCount;
        appStartTrace.onDrawCount = i + 1;
        return i;
    }

    @NonNull
    private Timer getClassLoadTimeCompat() {
        Timer timer = this.firebaseClassLoadTime;
        if (timer != null) {
            return timer;
        }
        return PERF_CLASS_LOAD_TIME;
    }

    public static AppStartTrace getInstance() {
        return instance != null ? instance : getInstance(TransportManager.getInstance(), new Clock());
    }

    @NonNull
    private Timer getStartTimerCompat() {
        Timer timer = this.processStartTime;
        if (timer != null) {
            return timer;
        }
        return getClassLoadTimeCompat();
    }

    public static boolean isAnyAppProcessInForeground(Context context) {
        boolean z;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        String l = e.l(packageName, ":");
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.importance == 100 && (next.processName.equals(packageName) || next.processName.startsWith(l))) {
                if (Build.VERSION.SDK_INT < 23) {
                    z = isScreenOn(context);
                } else {
                    z = true;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isScreenOn(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return true;
        }
        return powerManager.isInteractive();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logExperimentTrace$0(TraceMetric.Builder builder) {
        this.transportManager.log((TraceMetric) builder.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    /* access modifiers changed from: private */
    public void logAppStartTrace() {
        TraceMetric.Builder durationUs = TraceMetric.newBuilder().setName(Constants.TraceNames.APP_START_TRACE_NAME.toString()).setClientStartTimeUs(getClassLoadTimeCompat().getMicros()).setDurationUs(getClassLoadTimeCompat().getDurationMicros(this.onResumeTime));
        ArrayList arrayList = new ArrayList(3);
        arrayList.add((TraceMetric) TraceMetric.newBuilder().setName(Constants.TraceNames.ON_CREATE_TRACE_NAME.toString()).setClientStartTimeUs(getClassLoadTimeCompat().getMicros()).setDurationUs(getClassLoadTimeCompat().getDurationMicros(this.onCreateTime)).build());
        if (this.onStartTime != null) {
            TraceMetric.Builder newBuilder = TraceMetric.newBuilder();
            newBuilder.setName(Constants.TraceNames.ON_START_TRACE_NAME.toString()).setClientStartTimeUs(this.onCreateTime.getMicros()).setDurationUs(this.onCreateTime.getDurationMicros(this.onStartTime));
            arrayList.add((TraceMetric) newBuilder.build());
            TraceMetric.Builder newBuilder2 = TraceMetric.newBuilder();
            newBuilder2.setName(Constants.TraceNames.ON_RESUME_TRACE_NAME.toString()).setClientStartTimeUs(this.onStartTime.getMicros()).setDurationUs(this.onStartTime.getDurationMicros(this.onResumeTime));
            arrayList.add((TraceMetric) newBuilder2.build());
        }
        durationUs.addAllSubtraces(arrayList).addPerfSessions(this.startSession.build());
        this.transportManager.log((TraceMetric) durationUs.build(), ApplicationProcessState.FOREGROUND_BACKGROUND);
    }

    private void logExperimentTrace(TraceMetric.Builder builder) {
        if (this.preDrawPostTime != null && this.preDrawPostAtFrontOfQueueTime != null && this.onDrawPostAtFrontOfQueueTime != null) {
            executorService.execute(new e0(0, this, builder));
            unregisterActivityLifecycleCallbacks();
        }
    }

    /* access modifiers changed from: private */
    public void recordOnDrawFrontOfQueue() {
        String str;
        if (this.onDrawPostAtFrontOfQueueTime == null) {
            this.onDrawPostAtFrontOfQueueTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_onDrawFoQ").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.onDrawPostAtFrontOfQueueTime)).build());
            if (this.processStartTime != null) {
                this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_procStart_to_classLoad").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(getClassLoadTimeCompat())).build());
            }
            TraceMetric.Builder builder = this.experimentTtid;
            if (this.systemForegroundCheck) {
                str = "true";
            } else {
                str = BooleanUtils.FALSE;
            }
            builder.putCustomAttributes("systemDeterminedForeground", str);
            this.experimentTtid.putCounters("onDrawCount", (long) this.onDrawCount);
            this.experimentTtid.addPerfSessions(this.startSession.build());
            logExperimentTrace(this.experimentTtid);
        }
    }

    /* access modifiers changed from: private */
    public void recordPreDraw() {
        if (this.preDrawPostTime == null) {
            this.preDrawPostTime = this.clock.getTime();
            this.experimentTtid.setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.preDrawPostTime));
            logExperimentTrace(this.experimentTtid);
        }
    }

    /* access modifiers changed from: private */
    public void recordPreDrawFrontOfQueue() {
        if (this.preDrawPostAtFrontOfQueueTime == null) {
            this.preDrawPostAtFrontOfQueueTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_preDrawFoQ").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.preDrawPostAtFrontOfQueueTime)).build());
            logExperimentTrace(this.experimentTtid);
        }
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    @VisibleForTesting
    @Nullable
    public Activity getAppStartActivity() {
        return this.appStartActivity.get();
    }

    @VisibleForTesting
    @Nullable
    public Activity getLaunchActivity() {
        return this.launchActivity.get();
    }

    @VisibleForTesting
    public Timer getOnCreateTime() {
        return this.onCreateTime;
    }

    @VisibleForTesting
    public Timer getOnResumeTime() {
        return this.onResumeTime;
    }

    @VisibleForTesting
    public Timer getOnStartTime() {
        return this.onStartTime;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A[Catch:{ all -> 0x001a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityCreated(android.app.Activity r5, android.os.Bundle r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r6 = r4.isStartedFromBackground     // Catch:{ all -> 0x001a }
            if (r6 != 0) goto L_0x0042
            com.google.firebase.perf.util.Timer r6 = r4.onCreateTime     // Catch:{ all -> 0x001a }
            if (r6 == 0) goto L_0x000a
            goto L_0x0042
        L_0x000a:
            boolean r6 = r4.systemForegroundCheck     // Catch:{ all -> 0x001a }
            r0 = 1
            if (r6 != 0) goto L_0x001c
            android.content.Context r6 = r4.appContext     // Catch:{ all -> 0x001a }
            boolean r6 = isAnyAppProcessInForeground(r6)     // Catch:{ all -> 0x001a }
            if (r6 == 0) goto L_0x0018
            goto L_0x001c
        L_0x0018:
            r6 = 0
            goto L_0x001d
        L_0x001a:
            r5 = move-exception
            goto L_0x0044
        L_0x001c:
            r6 = 1
        L_0x001d:
            r4.systemForegroundCheck = r6     // Catch:{ all -> 0x001a }
            java.lang.ref.WeakReference r6 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x001a }
            r6.<init>(r5)     // Catch:{ all -> 0x001a }
            r4.launchActivity = r6     // Catch:{ all -> 0x001a }
            com.google.firebase.perf.util.Clock r5 = r4.clock     // Catch:{ all -> 0x001a }
            com.google.firebase.perf.util.Timer r5 = r5.getTime()     // Catch:{ all -> 0x001a }
            r4.onCreateTime = r5     // Catch:{ all -> 0x001a }
            com.google.firebase.perf.util.Timer r5 = r4.getStartTimerCompat()     // Catch:{ all -> 0x001a }
            com.google.firebase.perf.util.Timer r6 = r4.onCreateTime     // Catch:{ all -> 0x001a }
            long r5 = r5.getDurationMicros(r6)     // Catch:{ all -> 0x001a }
            long r1 = MAX_LATENCY_BEFORE_UI_INIT     // Catch:{ all -> 0x001a }
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0040
            r4.isTooLateToInitUI = r0     // Catch:{ all -> 0x001a }
        L_0x0040:
            monitor-exit(r4)
            return
        L_0x0042:
            monitor-exit(r4)
            return
        L_0x0044:
            monitor-exit(r4)     // Catch:{ all -> 0x001a }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        View findViewById;
        if (!this.isStartedFromBackground && !this.isTooLateToInitUI && this.configResolver.getIsExperimentTTIDEnabled() && (findViewById = activity.findViewById(16908290)) != null) {
            findViewById.getViewTreeObserver().removeOnDrawListener(this.onDrawCounterListener);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityResumed(android.app.Activity r7) {
        /*
            r6 = this;
            java.lang.String r0 = "onResume(): "
            monitor-enter(r6)
            boolean r1 = r6.isStartedFromBackground     // Catch:{ all -> 0x0040 }
            if (r1 != 0) goto L_0x00a5
            boolean r1 = r6.isTooLateToInitUI     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x000d
            goto L_0x00a5
        L_0x000d:
            com.google.firebase.perf.config.ConfigResolver r1 = r6.configResolver     // Catch:{ all -> 0x0040 }
            boolean r1 = r1.getIsExperimentTTIDEnabled()     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0042
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r7.findViewById(r2)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0042
            android.view.ViewTreeObserver r3 = r2.getViewTreeObserver()     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.metrics.AppStartTrace$DrawCounter r4 = r6.onDrawCounterListener     // Catch:{ all -> 0x0040 }
            r3.addOnDrawListener(r4)     // Catch:{ all -> 0x0040 }
            d0 r3 = new d0     // Catch:{ all -> 0x0040 }
            r4 = 0
            r3.<init>(r6, r4)     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.util.FirstDrawDoneListener.registerForNextDraw(r2, r3)     // Catch:{ all -> 0x0040 }
            d0 r3 = new d0     // Catch:{ all -> 0x0040 }
            r4 = 1
            r3.<init>(r6, r4)     // Catch:{ all -> 0x0040 }
            d0 r4 = new d0     // Catch:{ all -> 0x0040 }
            r5 = 2
            r4.<init>(r6, r5)     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.util.PreDrawListener.registerForNextDraw(r2, r3, r4)     // Catch:{ all -> 0x0040 }
            goto L_0x0042
        L_0x0040:
            r7 = move-exception
            goto L_0x00a7
        L_0x0042:
            com.google.firebase.perf.util.Timer r2 = r6.onResumeTime     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x0048
            monitor-exit(r6)
            return
        L_0x0048:
            java.lang.ref.WeakReference r2 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0040 }
            r2.<init>(r7)     // Catch:{ all -> 0x0040 }
            r6.appStartActivity = r2     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.util.Clock r2 = r6.clock     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.util.Timer r2 = r2.getTime()     // Catch:{ all -> 0x0040 }
            r6.onResumeTime = r2     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.session.SessionManager r2 = com.google.firebase.perf.session.SessionManager.getInstance()     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.session.PerfSession r2 = r2.perfSession()     // Catch:{ all -> 0x0040 }
            r6.startSession = r2     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.logging.AndroidLogger r2 = com.google.firebase.perf.logging.AndroidLogger.getInstance()     // Catch:{ all -> 0x0040 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0040 }
            r3.<init>(r0)     // Catch:{ all -> 0x0040 }
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x0040 }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0040 }
            r3.append(r7)     // Catch:{ all -> 0x0040 }
            java.lang.String r7 = ": "
            r3.append(r7)     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.util.Timer r7 = r6.getClassLoadTimeCompat()     // Catch:{ all -> 0x0040 }
            com.google.firebase.perf.util.Timer r0 = r6.onResumeTime     // Catch:{ all -> 0x0040 }
            long r4 = r7.getDurationMicros(r0)     // Catch:{ all -> 0x0040 }
            r3.append(r4)     // Catch:{ all -> 0x0040 }
            java.lang.String r7 = " microseconds"
            r3.append(r7)     // Catch:{ all -> 0x0040 }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x0040 }
            r2.debug(r7)     // Catch:{ all -> 0x0040 }
            java.util.concurrent.ExecutorService r7 = executorService     // Catch:{ all -> 0x0040 }
            d0 r0 = new d0     // Catch:{ all -> 0x0040 }
            r2 = 3
            r0.<init>(r6, r2)     // Catch:{ all -> 0x0040 }
            r7.execute(r0)     // Catch:{ all -> 0x0040 }
            if (r1 != 0) goto L_0x00a3
            r6.unregisterActivityLifecycleCallbacks()     // Catch:{ all -> 0x0040 }
        L_0x00a3:
            monitor-exit(r6)
            return
        L_0x00a5:
            monitor-exit(r6)
            return
        L_0x00a7:
            monitor-exit(r6)     // Catch:{ all -> 0x0040 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityResumed(android.app.Activity):void");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStarted(android.app.Activity r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r1 = r0.isStartedFromBackground     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x001a
            com.google.firebase.perf.util.Timer r1 = r0.onStartTime     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x001a
            boolean r1 = r0.isTooLateToInitUI     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x000e
            goto L_0x001a
        L_0x000e:
            com.google.firebase.perf.util.Clock r1 = r0.clock     // Catch:{ all -> 0x0018 }
            com.google.firebase.perf.util.Timer r1 = r1.getTime()     // Catch:{ all -> 0x0018 }
            r0.onStartTime = r1     // Catch:{ all -> 0x0018 }
            monitor-exit(r0)
            return
        L_0x0018:
            r1 = move-exception
            goto L_0x001c
        L_0x001a:
            monitor-exit(r0)
            return
        L_0x001c:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityStarted(android.app.Activity):void");
    }

    public void onActivityStopped(Activity activity) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    @Keep
    public void onAppEnteredBackground() {
        if (!this.isStartedFromBackground && !this.isTooLateToInitUI && this.firstBackgroundTime == null) {
            this.firstBackgroundTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_firstBackgrounding").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.firstBackgroundTime)).build());
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    @Keep
    public void onAppEnteredForeground() {
        if (!this.isStartedFromBackground && !this.isTooLateToInitUI && this.firstForegroundTime == null) {
            this.firstForegroundTime = this.clock.getTime();
            this.experimentTtid.addSubtraces((TraceMetric) TraceMetric.newBuilder().setName("_experiment_firstForegrounding").setClientStartTimeUs(getStartTimerCompat().getMicros()).setDurationUs(getStartTimerCompat().getDurationMicros(this.firstForegroundTime)).build());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void registerActivityLifecycleCallbacks(@androidx.annotation.NonNull android.content.Context r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isRegisteredForLifecycleCallbacks     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            androidx.lifecycle.LifecycleOwner r0 = androidx.lifecycle.ProcessLifecycleOwner.get()     // Catch:{ all -> 0x002e }
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()     // Catch:{ all -> 0x002e }
            r0.addObserver(r2)     // Catch:{ all -> 0x002e }
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x002e }
            boolean r0 = r3 instanceof android.app.Application     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x0037
            r0 = r3
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x002e }
            r0.registerActivityLifecycleCallbacks(r2)     // Catch:{ all -> 0x002e }
            boolean r0 = r2.systemForegroundCheck     // Catch:{ all -> 0x002e }
            r1 = 1
            if (r0 != 0) goto L_0x0030
            boolean r0 = isAnyAppProcessInForeground(r3)     // Catch:{ all -> 0x002e }
            if (r0 == 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            r0 = 0
            goto L_0x0031
        L_0x002e:
            r3 = move-exception
            goto L_0x0039
        L_0x0030:
            r0 = 1
        L_0x0031:
            r2.systemForegroundCheck = r0     // Catch:{ all -> 0x002e }
            r2.isRegisteredForLifecycleCallbacks = r1     // Catch:{ all -> 0x002e }
            r2.appContext = r3     // Catch:{ all -> 0x002e }
        L_0x0037:
            monitor-exit(r2)
            return
        L_0x0039:
            monitor-exit(r2)     // Catch:{ all -> 0x002e }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.registerActivityLifecycleCallbacks(android.content.Context):void");
    }

    @VisibleForTesting
    public void setIsStartFromBackground() {
        this.isStartedFromBackground = true;
    }

    public synchronized void unregisterActivityLifecycleCallbacks() {
        if (this.isRegisteredForLifecycleCallbacks) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(this);
            ((Application) this.appContext).unregisterActivityLifecycleCallbacks(this);
            this.isRegisteredForLifecycleCallbacks = false;
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public static AppStartTrace getInstance(TransportManager transportManager2, Clock clock2) {
        if (instance == null) {
            synchronized (AppStartTrace.class) {
                try {
                    if (instance == null) {
                        instance = new AppStartTrace(transportManager2, clock2, ConfigResolver.getInstance(), new ThreadPoolExecutor(0, 1, MAX_LATENCY_BEFORE_UI_INIT + 10, TimeUnit.SECONDS, new LinkedBlockingQueue()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }
}
