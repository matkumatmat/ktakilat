package defpackage;

import androidx.camera.core.RetryPolicy;

/* renamed from: de  reason: default package */
public final /* synthetic */ class de implements RetryPolicy {
    public final /* synthetic */ long getTimeoutInMillis() {
        return ee.a(this);
    }

    public final RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState executionState) {
        return RetryPolicy.RetryConfig.NOT_RETRY;
    }
}
