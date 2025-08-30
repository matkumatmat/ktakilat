package defpackage;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;

/* renamed from: s2  reason: default package */
public final /* synthetic */ class s2 implements Runnable {
    public final /* synthetic */ int c = 1;
    public final /* synthetic */ CameraX d;
    public final /* synthetic */ Context e;
    public final /* synthetic */ Executor f;
    public final /* synthetic */ int g;
    public final /* synthetic */ CallbackToFutureAdapter.Completer i;
    public final /* synthetic */ long j;

    public /* synthetic */ s2(CameraX cameraX, Context context, Executor executor, int i2, CallbackToFutureAdapter.Completer completer, long j2) {
        this.d = cameraX;
        this.e = context;
        this.f = executor;
        this.g = i2;
        this.i = completer;
        this.j = j2;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                long j2 = this.j;
                int i2 = this.g;
                this.d.lambda$initAndRetryRecursively$1(this.f, j2, i2, this.e, this.i);
                return;
            default:
                this.d.lambda$initAndRetryRecursively$2(this.e, this.f, this.g, this.i, this.j);
                return;
        }
    }

    public /* synthetic */ s2(CameraX cameraX, Executor executor, long j2, int i2, Context context, CallbackToFutureAdapter.Completer completer) {
        this.d = cameraX;
        this.f = executor;
        this.j = j2;
        this.g = i2;
        this.e = context;
        this.i = completer;
    }
}
