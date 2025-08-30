package androidx.camera.video.internal.compat.quirk;

import android.os.Build;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Quirk;
import androidx.camera.video.VideoSpec;
import androidx.camera.video.internal.config.VideoConfigUtil;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.Collections;
import java.util.Map;

public class ExtraSupportedQualityQuirk implements Quirk {
    private static final String MOTO_C_FRONT_CAM_ID = "1";

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r7 = r7.getAll(1);
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.Integer, androidx.camera.core.impl.EncoderProfilesProxy> getExtraEncoderProfilesForMotoC(@androidx.annotation.NonNull androidx.camera.core.impl.CameraInfoInternal r6, @androidx.annotation.NonNull androidx.camera.core.impl.EncoderProfilesProvider r7, @androidx.annotation.NonNull androidx.arch.core.util.Function<androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.VideoEncoderInfo> r8) {
        /*
            r5 = this;
            java.lang.String r0 = "1"
            java.lang.String r6 = r6.getCameraId()
            boolean r6 = r0.equals(r6)
            r0 = 0
            if (r6 == 0) goto L_0x006a
            r6 = 4
            boolean r1 = r7.hasProfile(r6)
            if (r1 == 0) goto L_0x0015
            goto L_0x006a
        L_0x0015:
            r1 = 1
            androidx.camera.core.impl.EncoderProfilesProxy r7 = r7.getAll(r1)
            androidx.camera.core.impl.EncoderProfilesProxy$VideoProfileProxy r2 = androidx.camera.video.internal.utils.EncoderProfilesUtil.getFirstVideoProfile(r7)
            if (r2 != 0) goto L_0x0021
            return r0
        L_0x0021:
            android.util.Range r8 = getSupportedBitrateRange(r2, r8)
            android.util.Size r0 = androidx.camera.core.internal.utils.SizeUtil.RESOLUTION_480P
            androidx.camera.core.impl.EncoderProfilesProxy$VideoProfileProxy r8 = androidx.camera.video.internal.utils.EncoderProfilesUtil.deriveVideoProfile(r2, r0, r8)
            int r3 = r7.getDefaultDurationSeconds()
            int r4 = r7.getRecommendedFileFormat()
            java.util.List r7 = r7.getAudioProfiles()
            java.util.List r8 = java.util.Collections.singletonList(r8)
            androidx.camera.core.impl.EncoderProfilesProxy$ImmutableEncoderProfilesProxy r7 = androidx.camera.core.impl.EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(r3, r4, r7, r8)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r8.put(r6, r7)
            android.util.Size r6 = new android.util.Size
            int r3 = r2.getWidth()
            int r2 = r2.getHeight()
            r6.<init>(r3, r2)
            int r0 = androidx.camera.core.internal.utils.SizeUtil.getArea(r0)
            int r6 = androidx.camera.core.internal.utils.SizeUtil.getArea(r6)
            if (r0 <= r6) goto L_0x0069
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r8.put(r6, r7)
        L_0x0069:
            return r8
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.compat.quirk.ExtraSupportedQualityQuirk.getExtraEncoderProfilesForMotoC(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.EncoderProfilesProvider, androidx.arch.core.util.Function):java.util.Map");
    }

    @NonNull
    private static Range<Integer> getSupportedBitrateRange(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, @NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function) {
        VideoEncoderInfo apply = function.apply(VideoConfigUtil.toVideoEncoderConfig(videoProfileProxy));
        if (apply != null) {
            return apply.getSupportedBitrateRange();
        }
        return VideoSpec.BITRATE_RANGE_AUTO;
    }

    private static boolean isMotoC() {
        if (!"motorola".equalsIgnoreCase(Build.BRAND) || !"moto c".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static boolean load() {
        return isMotoC();
    }

    @Nullable
    public Map<Integer, EncoderProfilesProxy> getExtraEncoderProfiles(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function) {
        if (isMotoC()) {
            return getExtraEncoderProfilesForMotoC(cameraInfoInternal, encoderProfilesProvider, function);
        }
        return Collections.emptyMap();
    }
}
