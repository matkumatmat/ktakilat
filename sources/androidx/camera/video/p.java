package androidx.camera.video;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class p implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ int c;
    public final /* synthetic */ VideoEncoderSession d;

    public /* synthetic */ p(VideoEncoderSession videoEncoderSession, int i) {
        this.c = i;
        this.d = videoEncoderSession;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.c) {
            case 0:
                return this.d.lambda$configure$0(completer);
            default:
                return this.d.lambda$configure$1(completer);
        }
    }
}
