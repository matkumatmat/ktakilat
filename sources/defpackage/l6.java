package defpackage;

import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncoderCallback;
import androidx.camera.video.internal.encoder.EncoderImpl;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;

/* renamed from: l6  reason: default package */
public final /* synthetic */ class l6 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public /* synthetic */ l6(Uploader uploader, TransportContext transportContext, int i, Runnable runnable) {
        this.c = 2;
        this.g = uploader;
        this.e = transportContext;
        this.d = i;
        this.f = runnable;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                ((EncoderCallback) this.g).onEncodeError(new EncodeException(this.d, (String) this.e, (Throwable) this.f));
                return;
            case 1:
                ((EncoderImpl) this.g).lambda$handleEncodeError$10(this.d, (String) this.e, (Throwable) this.f);
                return;
            default:
                ((Uploader) this.g).lambda$upload$1((TransportContext) this.e, this.d, (Runnable) this.f);
                return;
        }
    }

    public /* synthetic */ l6(Object obj, int i, String str, Throwable th, int i2) {
        this.c = i2;
        this.g = obj;
        this.d = i;
        this.e = str;
        this.f = th;
    }
}
