package defpackage;

import androidx.camera.camera2.internal.VideoUsageControl;

/* renamed from: ch  reason: default package */
public final /* synthetic */ class ch implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ VideoUsageControl d;

    public /* synthetic */ ch(VideoUsageControl videoUsageControl, int i) {
        this.c = i;
        this.d = videoUsageControl;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                VideoUsageControl.decrementUsage$lambda$1(this.d);
                return;
            case 1:
                VideoUsageControl.reset$lambda$2(this.d);
                return;
            default:
                VideoUsageControl.incrementUsage$lambda$0(this.d);
                return;
        }
    }
}
