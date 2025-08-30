package defpackage;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.streamsharing.StreamSharing;

/* renamed from: ff  reason: default package */
public final /* synthetic */ class ff implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamSharing f192a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ UseCaseConfig d;
    public final /* synthetic */ StreamSpec e;
    public final /* synthetic */ StreamSpec f;

    public /* synthetic */ ff(StreamSharing streamSharing, String str, String str2, UseCaseConfig useCaseConfig, StreamSpec streamSpec, StreamSpec streamSpec2) {
        this.f192a = streamSharing;
        this.b = str;
        this.c = str2;
        this.d = useCaseConfig;
        this.e = streamSpec;
        this.f = streamSpec2;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f192a.lambda$addCameraErrorListener$1(this.b, this.c, this.d, this.e, this.f, sessionConfig, sessionError);
    }
}
