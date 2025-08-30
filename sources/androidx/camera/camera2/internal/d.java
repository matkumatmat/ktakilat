package androidx.camera.camera2.internal;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import java.util.List;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraImpl d;
    public final /* synthetic */ String e;
    public final /* synthetic */ SessionConfig f;
    public final /* synthetic */ UseCaseConfig g;
    public final /* synthetic */ StreamSpec i;
    public final /* synthetic */ List j;

    public /* synthetic */ d(Camera2CameraImpl camera2CameraImpl, String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list, int i2) {
        this.c = i2;
        this.d = camera2CameraImpl;
        this.e = str;
        this.f = sessionConfig;
        this.g = useCaseConfig;
        this.i = streamSpec;
        this.j = list;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$onUseCaseActive$7(this.e, this.f, this.g, this.i, this.j);
                return;
            case 1:
                this.d.lambda$resetUseCase$10(this.e, this.f, this.g, this.i, this.j);
                return;
            default:
                this.d.lambda$onUseCaseUpdated$9(this.e, this.f, this.g, this.i, this.j);
                return;
        }
    }
}
