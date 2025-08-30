package androidx.camera.video.internal;

import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.internal.encoder.VideoEncoderConfig;
import androidx.camera.video.internal.encoder.VideoEncoderInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BackupHdrProfileEncoderProfilesProvider implements EncoderProfilesProvider {
    private static final String TAG = "BackupHdrProfileEncoderProfilesProvider";
    private final Map<Integer, EncoderProfilesProxy> mEncoderProfilesCache = new HashMap();
    private final EncoderProfilesProvider mEncoderProfilesProvider;
    private final Function<VideoEncoderConfig, VideoEncoderInfo> mVideoEncoderInfoFinder;

    public BackupHdrProfileEncoderProfilesProvider(@NonNull EncoderProfilesProvider encoderProfilesProvider, @NonNull Function<VideoEncoderConfig, VideoEncoderInfo> function) {
        this.mEncoderProfilesProvider = encoderProfilesProvider;
        this.mVideoEncoderInfoFinder = function;
    }

    @Nullable
    private EncoderProfilesProxy appendBackupVideoProfile(@Nullable EncoderProfilesProxy encoderProfilesProxy, int i, int i2) {
        EncoderProfilesProxy.VideoProfileProxy videoProfileProxy;
        if (encoderProfilesProxy == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(encoderProfilesProxy.getVideoProfiles());
        Iterator<EncoderProfilesProxy.VideoProfileProxy> it = encoderProfilesProxy.getVideoProfiles().iterator();
        while (true) {
            if (!it.hasNext()) {
                videoProfileProxy = null;
                break;
            }
            videoProfileProxy = it.next();
            if (videoProfileProxy.getHdrFormat() == 0) {
                break;
            }
        }
        EncoderProfilesProxy.VideoProfileProxy validateOrAdapt = validateOrAdapt(generateBackupProfile(videoProfileProxy, i, i2), this.mVideoEncoderInfoFinder);
        if (validateOrAdapt != null) {
            arrayList.add(validateOrAdapt);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return EncoderProfilesProxy.ImmutableEncoderProfilesProxy.create(encoderProfilesProxy.getDefaultDurationSeconds(), encoderProfilesProxy.getRecommendedFileFormat(), encoderProfilesProxy.getAudioProfiles(), arrayList);
    }

    private static int deriveCodec(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
            return 5;
        }
        throw new IllegalArgumentException(ba.k(i, "Unexpected HDR format: "));
    }

    @NonNull
    private static String deriveMediaType(int i) {
        return q6.c(i);
    }

    private static int deriveProfile(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 4096;
        }
        if (i == 3) {
            return 8192;
        }
        if (i == 4) {
            return -1;
        }
        throw new IllegalArgumentException(ba.k(i, "Unexpected HDR format: "));
    }

    @Nullable
    private static EncoderProfilesProxy.VideoProfileProxy generateBackupProfile(@Nullable EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i, int i2) {
        if (videoProfileProxy == null) {
            return null;
        }
        int codec = videoProfileProxy.getCodec();
        String mediaType = videoProfileProxy.getMediaType();
        int profile = videoProfileProxy.getProfile();
        if (i != videoProfileProxy.getHdrFormat()) {
            codec = deriveCodec(i);
            mediaType = deriveMediaType(codec);
            profile = deriveProfile(i);
        }
        return EncoderProfilesProxy.VideoProfileProxy.create(codec, mediaType, scaleBitrate(videoProfileProxy.getBitrate(), i2, videoProfileProxy.getBitDepth()), videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), profile, i2, videoProfileProxy.getChromaSubsampling(), i);
    }

    @Nullable
    private EncoderProfilesProxy getProfilesInternal(int i) {
        if (this.mEncoderProfilesCache.containsKey(Integer.valueOf(i))) {
            return this.mEncoderProfilesCache.get(Integer.valueOf(i));
        }
        if (!this.mEncoderProfilesProvider.hasProfile(i)) {
            return null;
        }
        EncoderProfilesProxy appendBackupVideoProfile = appendBackupVideoProfile(this.mEncoderProfilesProvider.getAll(i), 1, 10);
        this.mEncoderProfilesCache.put(Integer.valueOf(i), appendBackupVideoProfile);
        return appendBackupVideoProfile;
    }

    @NonNull
    private static EncoderProfilesProxy.VideoProfileProxy modifyBitrate(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, int i) {
        return EncoderProfilesProxy.VideoProfileProxy.create(videoProfileProxy.getCodec(), videoProfileProxy.getMediaType(), i, videoProfileProxy.getFrameRate(), videoProfileProxy.getWidth(), videoProfileProxy.getHeight(), videoProfileProxy.getProfile(), videoProfileProxy.getBitDepth(), videoProfileProxy.getChromaSubsampling(), videoProfileProxy.getHdrFormat());
    }

    private static int scaleBitrate(int i, int i2, int i3) {
        if (i2 == i3) {
            return i;
        }
        int doubleValue = (int) (new Rational(i2, i3).doubleValue() * ((double) i));
        if (Logger.isDebugEnabled(TAG)) {
            Logger.d(TAG, String.format("Base Bitrate(%dbps) * Bit Depth Ratio (%d / %d) = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(doubleValue)}));
        }
        return doubleValue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = androidx.camera.video.internal.config.VideoConfigUtil.toVideoEncoderConfig(r4);
     */
    @androidx.annotation.VisibleForTesting
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy validateOrAdapt(@androidx.annotation.Nullable androidx.camera.core.impl.EncoderProfilesProxy.VideoProfileProxy r4, @androidx.annotation.NonNull androidx.arch.core.util.Function<androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.VideoEncoderInfo> r5) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            androidx.camera.video.internal.encoder.VideoEncoderConfig r1 = androidx.camera.video.internal.config.VideoConfigUtil.toVideoEncoderConfig(r4)
            java.lang.Object r5 = r5.apply(r1)
            androidx.camera.video.internal.encoder.VideoEncoderInfo r5 = (androidx.camera.video.internal.encoder.VideoEncoderInfo) r5
            if (r5 == 0) goto L_0x003d
            int r2 = r4.getWidth()
            int r3 = r4.getHeight()
            boolean r2 = r5.isSizeSupportedAllowSwapping(r2, r3)
            if (r2 != 0) goto L_0x001f
            goto L_0x003d
        L_0x001f:
            int r0 = r1.getBitrate()
            android.util.Range r5 = r5.getSupportedBitrateRange()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            java.lang.Comparable r5 = r5.clamp(r1)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 != r0) goto L_0x0038
            goto L_0x003c
        L_0x0038:
            androidx.camera.core.impl.EncoderProfilesProxy$VideoProfileProxy r4 = modifyBitrate(r4, r5)
        L_0x003c:
            return r4
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.BackupHdrProfileEncoderProfilesProvider.validateOrAdapt(androidx.camera.core.impl.EncoderProfilesProxy$VideoProfileProxy, androidx.arch.core.util.Function):androidx.camera.core.impl.EncoderProfilesProxy$VideoProfileProxy");
    }

    @Nullable
    public EncoderProfilesProxy getAll(int i) {
        return getProfilesInternal(i);
    }

    public boolean hasProfile(int i) {
        if (this.mEncoderProfilesProvider.hasProfile(i) && getProfilesInternal(i) != null) {
            return true;
        }
        return false;
    }
}
