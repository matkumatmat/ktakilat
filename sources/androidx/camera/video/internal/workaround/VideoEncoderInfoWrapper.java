package androidx.camera.video.internal.workaround;

import android.util.Range;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.Logger;
import androidx.camera.video.internal.compat.quirk.DeviceQuirks;
import androidx.camera.video.internal.compat.quirk.MediaCodecInfoReportIncorrectInfoQuirk;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import androidx.core.util.Preconditions;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashSet;
import java.util.Set;

public class VideoEncoderInfoWrapper implements VideoEncoderInfo {
    private static final int HEIGHT_4KDCI = 2160;
    private static final String TAG = "VideoEncoderInfoWrapper";
    private static final int WIDTH_4KDCI = 4096;
    private final Set<Size> mExtraSupportedSizes;
    private final Range<Integer> mSupportedHeights;
    private final Range<Integer> mSupportedWidths;
    private final VideoEncoderInfo mVideoEncoderInfo;

    private VideoEncoderInfoWrapper(@NonNull VideoEncoderInfo videoEncoderInfo) {
        HashSet hashSet = new HashSet();
        this.mExtraSupportedSizes = hashSet;
        this.mVideoEncoderInfo = videoEncoderInfo;
        int widthAlignment = videoEncoderInfo.getWidthAlignment();
        this.mSupportedWidths = Range.create(Integer.valueOf(widthAlignment), Integer.valueOf(((int) Math.ceil(4096.0d / ((double) widthAlignment))) * widthAlignment));
        int heightAlignment = videoEncoderInfo.getHeightAlignment();
        this.mSupportedHeights = Range.create(Integer.valueOf(heightAlignment), Integer.valueOf(((int) Math.ceil(2160.0d / ((double) heightAlignment))) * heightAlignment));
        hashSet.addAll(MediaCodecInfoReportIncorrectInfoQuirk.getExtraSupportedSizes());
    }

    private void addExtraSupportedSize(@NonNull Size size) {
        this.mExtraSupportedSizes.add(size);
    }

    @NonNull
    public static VideoEncoderInfo from(@NonNull VideoEncoderInfo videoEncoderInfo, @Nullable Size size) {
        if (!(videoEncoderInfo instanceof VideoEncoderInfoWrapper)) {
            if (DeviceQuirks.get(MediaCodecInfoReportIncorrectInfoQuirk.class) == null) {
                if (size != null && !videoEncoderInfo.isSizeSupportedAllowSwapping(size.getWidth(), size.getHeight())) {
                    Range<Integer> supportedWidths = videoEncoderInfo.getSupportedWidths();
                    Range<Integer> supportedHeights = videoEncoderInfo.getSupportedHeights();
                    Logger.w(TAG, "Detected that the device does not support a size " + size + " that should be valid in widths/heights = " + supportedWidths + RemoteSettings.FORWARD_SLASH_STRING + supportedHeights);
                }
            }
            videoEncoderInfo = new VideoEncoderInfoWrapper(videoEncoderInfo);
        }
        if (size != null && (videoEncoderInfo instanceof VideoEncoderInfoWrapper)) {
            ((VideoEncoderInfoWrapper) videoEncoderInfo).addExtraSupportedSize(size);
        }
        return videoEncoderInfo;
    }

    public boolean canSwapWidthHeight() {
        return this.mVideoEncoderInfo.canSwapWidthHeight();
    }

    public int getHeightAlignment() {
        return this.mVideoEncoderInfo.getHeightAlignment();
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
        return this.mSupportedHeights;
    }

    @NonNull
    public Range<Integer> getSupportedHeightsFor(int i) {
        boolean z;
        if (!this.mSupportedWidths.contains(Integer.valueOf(i)) || i % this.mVideoEncoderInfo.getWidthAlignment() != 0) {
            z = false;
        } else {
            z = true;
        }
        StringBuilder t = ba.t(i, "Not supported width: ", " which is not in ");
        t.append(this.mSupportedWidths);
        t.append(" or can not be divided by alignment ");
        t.append(this.mVideoEncoderInfo.getWidthAlignment());
        Preconditions.checkArgument(z, t.toString());
        return this.mSupportedHeights;
    }

    @NonNull
    public Range<Integer> getSupportedWidths() {
        return this.mSupportedWidths;
    }

    @NonNull
    public Range<Integer> getSupportedWidthsFor(int i) {
        boolean z;
        if (!this.mSupportedHeights.contains(Integer.valueOf(i)) || i % this.mVideoEncoderInfo.getHeightAlignment() != 0) {
            z = false;
        } else {
            z = true;
        }
        StringBuilder t = ba.t(i, "Not supported height: ", " which is not in ");
        t.append(this.mSupportedHeights);
        t.append(" or can not be divided by alignment ");
        t.append(this.mVideoEncoderInfo.getHeightAlignment());
        Preconditions.checkArgument(z, t.toString());
        return this.mSupportedWidths;
    }

    public int getWidthAlignment() {
        return this.mVideoEncoderInfo.getWidthAlignment();
    }

    public boolean isSizeSupported(int i, int i2) {
        if (this.mVideoEncoderInfo.isSizeSupported(i, i2)) {
            return true;
        }
        for (Size next : this.mExtraSupportedSizes) {
            if (next.getWidth() == i && next.getHeight() == i2) {
                return true;
            }
        }
        if (!this.mSupportedWidths.contains(Integer.valueOf(i)) || !this.mSupportedHeights.contains(Integer.valueOf(i2)) || i % this.mVideoEncoderInfo.getWidthAlignment() != 0 || i2 % this.mVideoEncoderInfo.getHeightAlignment() != 0) {
            return false;
        }
        return true;
    }

    public final /* synthetic */ boolean isSizeSupportedAllowSwapping(int i, int i2) {
        return bh.a(this, i, i2);
    }
}
