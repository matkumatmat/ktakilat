package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CameraImpl;

public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Camera2CameraImpl.ErrorTimeoutReopenScheduler.ScheduleNode d;

    public /* synthetic */ m(Camera2CameraImpl.ErrorTimeoutReopenScheduler.ScheduleNode scheduleNode, int i) {
        this.c = i;
        this.d = scheduleNode;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.execute();
                return;
            default:
                this.d.executeInternal();
                return;
        }
    }
}
