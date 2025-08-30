package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.MediaSpec;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.VideoMimeInfo;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderDataSpace;
import androidx.camera.video.internal.utils.DynamicRangeUtil;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class VideoConfigUtil {
    private static final Timebase DEFAULT_TIME_BASE = Timebase.UPTIME;
    private static final Map<String, Map<Integer, VideoEncoderDataSpace>> MIME_TO_DATA_SPACE_MAP;
    private static final String TAG = "VideoConfigUtil";

    static {
        HashMap hashMap = new HashMap();
        MIME_TO_DATA_SPACE_MAP = hashMap;
        HashMap hashMap2 = new HashMap();
        VideoEncoderDataSpace videoEncoderDataSpace = VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
        hashMap2.put(1, videoEncoderDataSpace);
        VideoEncoderDataSpace videoEncoderDataSpace2 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_HLG;
        hashMap2.put(2, videoEncoderDataSpace2);
        VideoEncoderDataSpace videoEncoderDataSpace3 = VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT2020_PQ;
        hashMap2.put(4096, videoEncoderDataSpace3);
        hashMap2.put(8192, videoEncoderDataSpace3);
        HashMap hashMap3 = new HashMap();
        hashMap3.put(1, videoEncoderDataSpace);
        hashMap3.put(2, videoEncoderDataSpace2);
        hashMap3.put(4096, videoEncoderDataSpace3);
        hashMap3.put(8192, videoEncoderDataSpace3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put(1, videoEncoderDataSpace);
        hashMap4.put(4, videoEncoderDataSpace2);
        hashMap4.put(4096, videoEncoderDataSpace3);
        hashMap4.put(16384, videoEncoderDataSpace3);
        hashMap4.put(2, videoEncoderDataSpace);
        hashMap4.put(8, videoEncoderDataSpace2);
        hashMap4.put(8192, videoEncoderDataSpace3);
        hashMap4.put(32768, videoEncoderDataSpace3);
        HashMap hashMap5 = new HashMap();
        hashMap5.put(256, videoEncoderDataSpace2);
        hashMap5.put(512, VideoEncoderDataSpace.ENCODER_DATA_SPACE_BT709);
        hashMap.put("video/hevc", hashMap2);
        hashMap.put("video/av01", hashMap3);
        hashMap.put("video/x-vnd.on2.vp9", hashMap4);
        hashMap.put("video/dolby-vision", hashMap5);
    }

    private VideoConfigUtil() {
    }

    @NonNull
    private static String getDynamicRangeDefaultMime(@NonNull DynamicRange dynamicRange) {
        int encoding = dynamicRange.getEncoding();
        if (encoding == 1) {
            return "video/avc";
        }
        if (encoding == 3 || encoding == 4 || encoding == 5) {
            return "video/hevc";
        }
        if (encoding == 6) {
            return "video/dolby-vision";
        }
        throw new UnsupportedOperationException("Unsupported dynamic range: " + dynamicRange + "\nNo supported default mime type available.");
    }

    @NonNull
    public static VideoEncoderDataSpace mimeAndProfileToEncoderDataSpace(@NonNull String str, int i) {
        VideoEncoderDataSpace videoEncoderDataSpace;
        Map map = MIME_TO_DATA_SPACE_MAP.get(str);
        if (map != null && (videoEncoderDataSpace = (VideoEncoderDataSpace) map.get(Integer.valueOf(i))) != null) {
            return videoEncoderDataSpace;
        }
        Logger.w(TAG, String.format("Unsupported mime type %s or profile level %d. Data space is unspecified.", new Object[]{str, Integer.valueOf(i)}));
        return VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED;
    }

    /* JADX WARNING: type inference failed for: r8v0, types: [androidx.core.util.Supplier] */
    /* JADX WARNING: type inference failed for: r9v1, types: [androidx.camera.video.internal.config.VideoEncoderConfigDefaultResolver] */
    /* JADX WARNING: type inference failed for: r0v3, types: [androidx.camera.video.internal.config.VideoEncoderConfigVideoProfileResolver] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.VideoEncoderConfig resolveVideoEncoderConfig(@androidx.annotation.NonNull androidx.camera.video.internal.config.VideoMimeInfo r16, @androidx.annotation.NonNull androidx.camera.core.impl.Timebase r17, @androidx.annotation.NonNull androidx.camera.video.VideoSpec r18, @androidx.annotation.NonNull android.util.Size r19, @androidx.annotation.NonNull androidx.camera.core.DynamicRange r20, @androidx.annotation.NonNull android.util.Range<java.lang.Integer> r21) {
        /*
            androidx.camera.core.impl.EncoderProfilesProxy$VideoProfileProxy r5 = r16.getCompatibleVideoProfile()
            if (r5 == 0) goto L_0x001b
            androidx.camera.video.internal.config.VideoEncoderConfigVideoProfileResolver r8 = new androidx.camera.video.internal.config.VideoEncoderConfigVideoProfileResolver
            java.lang.String r1 = r16.getMimeType()
            r0 = r8
            r2 = r17
            r3 = r18
            r4 = r19
            r6 = r20
            r7 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x002f
        L_0x001b:
            androidx.camera.video.internal.config.VideoEncoderConfigDefaultResolver r8 = new androidx.camera.video.internal.config.VideoEncoderConfigDefaultResolver
            java.lang.String r10 = r16.getMimeType()
            r9 = r8
            r11 = r17
            r12 = r18
            r13 = r19
            r14 = r20
            r15 = r21
            r9.<init>(r10, r11, r12, r13, r14, r15)
        L_0x002f:
            java.lang.Object r0 = r8.get()
            androidx.camera.video.internal.encoder.VideoEncoderConfig r0 = (androidx.camera.video.internal.encoder.VideoEncoderConfig) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.config.VideoConfigUtil.resolveVideoEncoderConfig(androidx.camera.video.internal.config.VideoMimeInfo, androidx.camera.core.impl.Timebase, androidx.camera.video.VideoSpec, android.util.Size, androidx.camera.core.DynamicRange, android.util.Range):androidx.camera.video.internal.encoder.VideoEncoderConfig");
    }

    @NonNull
    public static VideoMimeInfo resolveVideoMimeInfo(@NonNull MediaSpec mediaSpec, @NonNull DynamicRange dynamicRange, @Nullable VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        boolean isFullySpecified = dynamicRange.isFullySpecified();
        Preconditions.checkState(isFullySpecified, "Dynamic range must be a fully specified dynamic range [provided dynamic range: " + dynamicRange + "]");
        String outputFormatToVideoMime = MediaSpec.outputFormatToVideoMime(mediaSpec.getOutputFormat());
        if (videoValidatedEncoderProfilesProxy != null) {
            Set<Integer> dynamicRangeToVideoProfileHdrFormats = DynamicRangeUtil.dynamicRangeToVideoProfileHdrFormats(dynamicRange);
            Set<Integer> dynamicRangeToVideoProfileBitDepth = DynamicRangeUtil.dynamicRangeToVideoProfileBitDepth(dynamicRange);
            Iterator<EncoderProfilesProxy.VideoProfileProxy> it = videoValidatedEncoderProfilesProxy.getVideoProfiles().iterator();
            while (it.hasNext()) {
                videoProfileProxy = it.next();
                if (dynamicRangeToVideoProfileHdrFormats.contains(Integer.valueOf(videoProfileProxy.getHdrFormat())) && dynamicRangeToVideoProfileBitDepth.contains(Integer.valueOf(videoProfileProxy.getBitDepth()))) {
                    String mediaType = videoProfileProxy.getMediaType();
                    if (Objects.equals(outputFormatToVideoMime, mediaType)) {
                        Logger.d(TAG, "MediaSpec video mime matches EncoderProfiles. Using EncoderProfiles to derive VIDEO settings [mime type: " + outputFormatToVideoMime + "]");
                    } else if (mediaSpec.getOutputFormat() == -1) {
                        Logger.d(TAG, "MediaSpec contains OUTPUT_FORMAT_AUTO. Using CamcorderProfile to derive VIDEO settings [mime type: " + outputFormatToVideoMime + ", dynamic range: " + dynamicRange + "]");
                    }
                    outputFormatToVideoMime = mediaType;
                    break;
                }
            }
        }
        videoProfileProxy = null;
        if (videoProfileProxy == null) {
            if (mediaSpec.getOutputFormat() == -1) {
                outputFormatToVideoMime = getDynamicRangeDefaultMime(dynamicRange);
            }
            if (videoValidatedEncoderProfilesProxy == null) {
                Logger.d(TAG, "No EncoderProfiles present. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + outputFormatToVideoMime + ", dynamic range: " + dynamicRange + "]");
            } else {
                Logger.d(TAG, "No video EncoderProfile is compatible with requested output format and dynamic range. May rely on fallback defaults to derive VIDEO settings [chosen mime type: " + outputFormatToVideoMime + ", dynamic range: " + dynamicRange + "]");
            }
        }
        VideoMimeInfo.Builder builder = VideoMimeInfo.builder(outputFormatToVideoMime);
        if (videoProfileProxy != null) {
            builder.setCompatibleVideoProfile(videoProfileProxy);
        }
        return builder.build();
    }

    public static int scaleAndClampBitrate(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, @NonNull Range<Integer> range) {
        String str;
        Range<Integer> range2 = range;
        Rational rational = new Rational(i2, i3);
        Rational rational2 = new Rational(i4, i5);
        Rational rational3 = new Rational(i6, i7);
        Rational rational4 = new Rational(i8, i9);
        int doubleValue = (int) (rational4.doubleValue() * rational3.doubleValue() * rational2.doubleValue() * rational.doubleValue() * ((double) i));
        if (Logger.isDebugEnabled(TAG)) {
            str = String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) * Frame Rate Ratio(%d / %d) * Width Ratio(%d / %d) * Height Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(doubleValue)});
        } else {
            str = "";
        }
        if (!VideoSpec.BITRATE_RANGE_AUTO.equals(range2)) {
            Integer clamp = range2.clamp(Integer.valueOf(doubleValue));
            int intValue = clamp.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                str = str.concat(String.format("\nClamped to range %s -> %dbps", new Object[]{range2, clamp}));
            }
            doubleValue = intValue;
        }
        Logger.d(TAG, str);
        return doubleValue;
    }

    @NonNull
    public static VideoEncoderConfig toVideoEncoderConfig(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy) {
        return VideoEncoderConfig.builder().setMimeType(videoProfileProxy.getMediaType()).setProfile(videoProfileProxy.getProfile()).setResolution(new Size(videoProfileProxy.getWidth(), videoProfileProxy.getHeight())).setFrameRate(videoProfileProxy.getFrameRate()).setBitrate(videoProfileProxy.getBitrate()).setInputTimebase(DEFAULT_TIME_BASE).build();
    }
}
