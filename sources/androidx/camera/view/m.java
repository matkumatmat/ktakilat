package androidx.camera.view;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class m implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ TextureViewImplementation c;

    public /* synthetic */ m(TextureViewImplementation textureViewImplementation) {
        this.c = textureViewImplementation;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.c.lambda$waitForNextFrame$3(completer);
    }
}
