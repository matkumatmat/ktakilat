package com.katkilat.baidu_face.manager;

import android.view.SurfaceHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/katkilat/baidu_face/manager/FacePointManager$initParams$1", "Landroid/view/SurfaceHolder$Callback;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FacePointManager$initParams$1 implements SurfaceHolder.Callback {
    public final /* synthetic */ FacePointManager c;

    public FacePointManager$initParams$1(FacePointManager facePointManager) {
        this.c = facePointManager;
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        FacePointManager facePointManager = this.c;
        facePointManager.getClass();
        facePointManager.getClass();
        if (surfaceHolder.getSurface() != null) {
            facePointManager.g();
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        this.c.getClass();
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Intrinsics.checkNotNullParameter(surfaceHolder, "holder");
        this.c.getClass();
    }
}
