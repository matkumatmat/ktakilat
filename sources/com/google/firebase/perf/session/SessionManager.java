package com.google.firebase.perf.session;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.v1.ApplicationProcessState;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Keep
public class SessionManager extends AppStateUpdateHandler {
    @SuppressLint({"StaticFieldLeak"})
    private static final SessionManager instance = new SessionManager();
    private final AppStateMonitor appStateMonitor;
    private final Set<WeakReference<SessionAwareObject>> clients;
    private final GaugeManager gaugeManager;
    private PerfSession perfSession;
    private Future syncInitFuture;

    private SessionManager() {
        this(GaugeManager.getInstance(), PerfSession.createWithId(UUID.randomUUID().toString()), AppStateMonitor.getInstance());
    }

    public static SessionManager getInstance() {
        return instance;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setApplicationContext$0(Context context, PerfSession perfSession2) {
        this.gaugeManager.initializeGaugeMetadataManager(context);
        if (perfSession2.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(perfSession2.sessionId(), ApplicationProcessState.FOREGROUND);
        }
    }

    private void logGaugeMetadataIfCollectionEnabled(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.logGaugeMetadata(this.perfSession.sessionId(), applicationProcessState);
        }
    }

    private void startOrStopCollectingGauges(ApplicationProcessState applicationProcessState) {
        if (this.perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.startCollectingGauges(this.perfSession, applicationProcessState);
        } else {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    @VisibleForTesting
    public Future getSyncInitFuture() {
        return this.syncInitFuture;
    }

    public void initializeGaugeCollection() {
        ApplicationProcessState applicationProcessState = ApplicationProcessState.FOREGROUND;
        logGaugeMetadataIfCollectionEnabled(applicationProcessState);
        startOrStopCollectingGauges(applicationProcessState);
    }

    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        super.onUpdateAppState(applicationProcessState);
        if (!this.appStateMonitor.isColdStart()) {
            if (applicationProcessState == ApplicationProcessState.FOREGROUND) {
                updatePerfSession(PerfSession.createWithId(UUID.randomUUID().toString()));
            } else if (this.perfSession.isSessionRunningTooLong()) {
                updatePerfSession(PerfSession.createWithId(UUID.randomUUID().toString()));
            } else {
                startOrStopCollectingGauges(applicationProcessState);
            }
        }
    }

    public final PerfSession perfSession() {
        return this.perfSession;
    }

    public void registerForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.add(weakReference);
        }
    }

    public void setApplicationContext(Context context) {
        this.syncInitFuture = Executors.newSingleThreadExecutor().submit(new m0(this, 12, context, this.perfSession));
    }

    @VisibleForTesting
    public void setPerfSession(PerfSession perfSession2) {
        this.perfSession = perfSession2;
    }

    public void stopGaugeCollectionIfSessionRunningTooLong() {
        if (this.perfSession.isSessionRunningTooLong()) {
            this.gaugeManager.stopCollectingGauges();
        }
    }

    public void unregisterForSessionUpdates(WeakReference<SessionAwareObject> weakReference) {
        synchronized (this.clients) {
            this.clients.remove(weakReference);
        }
    }

    public void updatePerfSession(PerfSession perfSession2) {
        if (perfSession2.sessionId() != this.perfSession.sessionId()) {
            this.perfSession = perfSession2;
            synchronized (this.clients) {
                try {
                    Iterator<WeakReference<SessionAwareObject>> it = this.clients.iterator();
                    while (it.hasNext()) {
                        SessionAwareObject sessionAwareObject = (SessionAwareObject) it.next().get();
                        if (sessionAwareObject != null) {
                            sessionAwareObject.updateSession(perfSession2);
                        } else {
                            it.remove();
                        }
                    }
                } finally {
                    while (true) {
                    }
                }
            }
            logGaugeMetadataIfCollectionEnabled(this.appStateMonitor.getAppState());
            startOrStopCollectingGauges(this.appStateMonitor.getAppState());
        }
    }

    @VisibleForTesting
    public SessionManager(GaugeManager gaugeManager2, PerfSession perfSession2, AppStateMonitor appStateMonitor2) {
        this.clients = new HashSet();
        this.gaugeManager = gaugeManager2;
        this.perfSession = perfSession2;
        this.appStateMonitor = appStateMonitor2;
        registerForAppState();
    }
}
