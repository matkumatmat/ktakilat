package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class k0 implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MeteringRepeatingSession f9a;

    public /* synthetic */ k0(MeteringRepeatingSession meteringRepeatingSession) {
        this.f9a = meteringRepeatingSession;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f9a.lambda$createSessionConfig$0(sessionConfig, sessionError);
    }
}
