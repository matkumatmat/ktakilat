package defpackage;

import androidx.camera.video.internal.encoder.VideoEncoderInfo;

/* renamed from: bh  reason: default package */
public abstract /* synthetic */ class bh {
    public static boolean a(VideoEncoderInfo videoEncoderInfo, int i, int i2) {
        if (videoEncoderInfo.isSizeSupported(i, i2) || (videoEncoderInfo.canSwapWidthHeight() && videoEncoderInfo.isSizeSupported(i2, i))) {
            return true;
        }
        return false;
    }
}
