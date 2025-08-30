package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ ProcessingNode d;
    public final /* synthetic */ ProcessingNode.InputPacket e;

    public /* synthetic */ e(ProcessingNode processingNode, ProcessingNode.InputPacket inputPacket, int i) {
        this.c = i;
        this.d = processingNode;
        this.e = inputPacket;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                this.d.lambda$transform$2(this.e);
                return;
            default:
                this.d.lambda$transform$0(this.e);
                return;
        }
    }
}
