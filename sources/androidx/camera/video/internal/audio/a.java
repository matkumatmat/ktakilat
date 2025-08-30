package androidx.camera.video.internal.audio;

import android.content.Context;

public final /* synthetic */ class a implements AudioStreamFactory {
    public final AudioStream create(AudioSettings audioSettings, Context context) {
        return new AudioStreamImpl(audioSettings, context);
    }
}
