package androidx.camera.video.internal.encoder;

import android.util.Range;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

public class SwappedVideoEncoderInfo implements VideoEncoderInfo {
    private final VideoEncoderInfo mVideoEncoderInfo;

    public SwappedVideoEncoderInfo(@NonNull VideoEncoderInfo videoEncoderInfo) {
        Preconditions.checkArgument(videoEncoderInfo.canSwapWidthHeight());
        this.mVideoEncoderInfo = videoEncoderInfo;
    }

    public boolean canSwapWidthHeight() {
        return this.mVideoEncoderInfo.canSwapWidthHeight();
    }

    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    @NonNull
    public String getName() {
        return this.mVideoEncoderInfo.getName();
    }

    @NonNull
    public Range<Integer> getSupportedBitrateRange() {
        return this.mVideoEncoderInfo.getSupportedBitrateRange();
    }

    @NonNull
    public Range<Integer> getSupportedHeights() {
        return this.mVideoEncoderInfo.getSupportedWidths();
    }

    @NonNull
    public Range<Integer> getSupportedHeightsFor(int i) {
        return this.mVideoEncoderInfo.getSupportedWidthsFor(i);
    }

    @NonNull
    public Range<Integer> getSupportedWidths() {
        return this.mVideoEncoderInfo.getSupportedHeights();
    }

    @NonNull
    public Range<Integer> getSupportedWidthsFor(int i) {
        return this.mVideoEncoderInfo.getSupportedHeightsFor(i);
    }

    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
    }

    public boolean isSizeSupported(int i, int i2) {
        return this.mVideoEncoderInfo.isSizeSupported(i2, i);
    }

    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int i, int i2) {
        return bh.a(this, i, i2);
    }
}
