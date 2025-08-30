package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class WithinAppServiceConnection implements ServiceConnection {
    @Nullable
    private WithinAppServiceBinder binder;
    @GuardedBy("this")
    private boolean connectionInProgress;
    private final Intent connectionIntent;
    private final Context context;
    private final Queue<BindRequest> intentQueue;
    private final ScheduledExecutorService scheduledExecutorService;

    public static class BindRequest {
        final Intent intent;
        private final TaskCompletionSource<Void> taskCompletionSource = new TaskCompletionSource<>();

        public BindRequest(Intent intent2) {
            this.intent = intent2;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$arrangeTimeout$0() {
            Log.w(Constants.TAG, "Service took too long to process intent: " + this.intent.getAction() + " finishing.");
            finish();
        }

        public void arrangeTimeout(ScheduledExecutorService scheduledExecutorService) {
            getTask().addOnCompleteListener((Executor) scheduledExecutorService, new c(scheduledExecutorService.schedule(new i(this, 1), 20, TimeUnit.SECONDS), 4));
        }

        public void finish() {
            this.taskCompletionSource.trySetResult(null);
        }

        public Task<Void> getTask() {
            return this.taskCompletionSource.getTask();
        }
    }

    public WithinAppServiceConnection(Context context2, String str) {
        this(context2, str, createScheduledThreadPoolExecutor());
    }

    @SuppressLint({"ThreadPoolCreation"})
    private static ScheduledThreadPoolExecutor createScheduledThreadPoolExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return scheduledThreadPoolExecutor;
    }

    @GuardedBy("this")
    private void finishAllInQueue() {
        while (!this.intentQueue.isEmpty()) {
            this.intentQueue.poll().finish();
        }
    }

    private synchronized void flushQueue() {
        try {
            Log.isLoggable(Constants.TAG, 3);
            while (!this.intentQueue.isEmpty()) {
                Log.isLoggable(Constants.TAG, 3);
                WithinAppServiceBinder withinAppServiceBinder = this.binder;
                if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                    startConnectionIfNeeded();
                    return;
                }
                Log.isLoggable(Constants.TAG, 3);
                this.binder.send(this.intentQueue.poll());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    @GuardedBy("this")
    private void startConnectionIfNeeded() {
        Log.isLoggable(Constants.TAG, 3);
        if (!this.connectionInProgress) {
            this.connectionInProgress = true;
            try {
                if (!ConnectionTracker.getInstance().bindService(this.context, this.connectionIntent, this, 65)) {
                    Log.e(Constants.TAG, "binding to the service failed");
                    this.connectionInProgress = false;
                    finishAllInQueue();
                }
            } catch (SecurityException e) {
                Log.e(Constants.TAG, "Exception while binding the service", e);
            }
        }
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Objects.toString(componentName);
            }
            this.connectionInProgress = false;
            if (!(iBinder instanceof WithinAppServiceBinder)) {
                Log.e(Constants.TAG, "Invalid service connection: " + iBinder);
                finishAllInQueue();
                return;
            }
            this.binder = (WithinAppServiceBinder) iBinder;
            flushQueue();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Objects.toString(componentName);
        }
        flushQueue();
    }

    @CanIgnoreReturnValue
    public synchronized Task<Void> sendIntent(Intent intent) {
        BindRequest bindRequest;
        Log.isLoggable(Constants.TAG, 3);
        bindRequest = new BindRequest(intent);
        bindRequest.arrangeTimeout(this.scheduledExecutorService);
        this.intentQueue.add(bindRequest);
        flushQueue();
        return bindRequest.getTask();
    }

    @VisibleForTesting
    public WithinAppServiceConnection(Context context2, String str, ScheduledExecutorService scheduledExecutorService2) {
        this.intentQueue = new ArrayDeque();
        this.connectionInProgress = false;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.connectionIntent = new Intent(str).setPackage(applicationContext.getPackageName());
        this.scheduledExecutorService = scheduledExecutorService2;
    }
}
