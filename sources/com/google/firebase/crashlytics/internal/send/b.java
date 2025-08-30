package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

public final /* synthetic */ class b implements TransportScheduleCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f313a;
    public final /* synthetic */ TaskCompletionSource b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ CrashlyticsReportWithSessionId d;

    public /* synthetic */ b(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f313a = reportQueue;
        this.b = taskCompletionSource;
        this.c = z;
        this.d = crashlyticsReportWithSessionId;
    }

    public final void onSchedule(Exception exc) {
        this.f313a.lambda$sendReport$1(this.b, this.c, this.d, exc);
    }
}
