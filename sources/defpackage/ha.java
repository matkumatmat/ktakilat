package defpackage;

import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.VideoCapture;

/* renamed from: ha  reason: default package */
public final /* synthetic */ class ha implements SessionConfig.ErrorListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f198a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ha(Object obj, int i) {
        this.f198a = i;
        this.b = obj;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        switch (this.f198a) {
            case 0:
                ((ImageAnalysis) this.b).lambda$createPipeline$2(sessionConfig, sessionError);
                return;
            case 1:
                ((ImageCapture) this.b).lambda$createPipeline$3(sessionConfig, sessionError);
                return;
            case 2:
                ((Preview) this.b).lambda$addCameraSurfaceAndErrorListener$1(sessionConfig, sessionError);
                return;
            case 3:
                ((SessionConfig.ValidatingBuilder) this.b).lambda$build$0(sessionConfig, sessionError);
                return;
            default:
                ((VideoCapture) this.b).lambda$createPipeline$3(sessionConfig, sessionError);
                return;
        }
    }
}
