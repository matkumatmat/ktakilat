package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.core.util.Consumer;

public final /* synthetic */ class f implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ ProcessingNode d;

    public /* synthetic */ f(ProcessingNode processingNode, int i) {
        this.c = i;
        this.d = processingNode;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                this.d.lambda$transform$1((ProcessingNode.InputPacket) obj);
                return;
            default:
                this.d.lambda$transform$3((ProcessingNode.InputPacket) obj);
                return;
        }
    }
}
