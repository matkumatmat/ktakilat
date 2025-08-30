package defpackage;

import android.net.DnsResolver;
import android.view.contentcapture.ContentCaptureSession;

/* renamed from: z  reason: default package */
public abstract /* synthetic */ class z {
    public static /* bridge */ /* synthetic */ ContentCaptureSession i(Object obj) {
        return (ContentCaptureSession) obj;
    }

    public static /* bridge */ /* synthetic */ boolean t(Throwable th) {
        return th instanceof DnsResolver.DnsException;
    }
}
