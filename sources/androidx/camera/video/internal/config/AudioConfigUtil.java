package androidx.camera.video.internal.config;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.core.util.Supplier;
import java.util.ArrayList;
import java.util.Collections;

public final class AudioConfigUtil {
    static final int AUDIO_CHANNEL_COUNT_DEFAULT = 1;
    static final int AUDIO_SAMPLE_RATE_DEFAULT = 44100;
    static final int AUDIO_SOURCE_DEFAULT = 5;
    static final int AUDIO_SOURCE_FORMAT_DEFAULT = 2;
    private static final String TAG = "AudioConfigUtil";

    private AudioConfigUtil() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$selectSampleRateOrNearestSupported$0(int i, Integer num, Integer num2) {
        float signum;
        int abs = Math.abs(num.intValue() - i) - Math.abs(num2.intValue() - i);
        if (abs == 0) {
            signum = Math.signum((float) (num.intValue() - num2.intValue()));
        } else {
            signum = Math.signum((float) abs);
        }
        return (int) signum;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [androidx.core.util.Supplier] */
    /* JADX WARNING: type inference failed for: r8v1, types: [androidx.camera.video.internal.config.AudioEncoderConfigDefaultResolver] */
    /* JADX WARNING: type inference failed for: r0v3, types: [androidx.camera.video.internal.config.AudioEncoderConfigAudioProfileResolver] */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.encoder.AudioEncoderConfig resolveAudioEncoderConfig(@androidx.annotation.NonNull androidx.camera.video.internal.config.AudioMimeInfo r14, @androidx.annotation.NonNull androidx.camera.core.impl.Timebase r15, @androidx.annotation.NonNull androidx.camera.video.internal.audio.AudioSettings r16, @androidx.annotation.NonNull androidx.camera.video.AudioSpec r17) {
        /*
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r6 = r14.getCompatibleAudioProfile()
            if (r6 == 0) goto L_0x001a
            androidx.camera.video.internal.config.AudioEncoderConfigAudioProfileResolver r7 = new androidx.camera.video.internal.config.AudioEncoderConfigAudioProfileResolver
            java.lang.String r1 = r14.getMimeType()
            int r2 = r14.getProfile()
            r0 = r7
            r3 = r15
            r4 = r17
            r5 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6)
            goto L_0x002d
        L_0x001a:
            androidx.camera.video.internal.config.AudioEncoderConfigDefaultResolver r7 = new androidx.camera.video.internal.config.AudioEncoderConfigDefaultResolver
            java.lang.String r9 = r14.getMimeType()
            int r10 = r14.getProfile()
            r8 = r7
            r11 = r15
            r12 = r17
            r13 = r16
            r8.<init>(r9, r10, r11, r12, r13)
        L_0x002d:
            java.lang.Object r0 = r7.get()
            androidx.camera.video.internal.encoder.AudioEncoderConfig r0 = (androidx.camera.video.internal.encoder.AudioEncoderConfig) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.config.AudioConfigUtil.resolveAudioEncoderConfig(androidx.camera.video.internal.config.AudioMimeInfo, androidx.camera.core.impl.Timebase, androidx.camera.video.internal.audio.AudioSettings, androidx.camera.video.AudioSpec):androidx.camera.video.internal.encoder.AudioEncoderConfig");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00cb  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.camera.video.internal.config.AudioMimeInfo resolveAudioMimeInfo(@androidx.annotation.NonNull androidx.camera.video.MediaSpec r8, @androidx.annotation.Nullable androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy r9) {
        /*
            int r0 = r8.getOutputFormat()
            java.lang.String r0 = androidx.camera.video.MediaSpec.outputFormatToAudioMime(r0)
            int r1 = r8.getOutputFormat()
            int r1 = androidx.camera.video.MediaSpec.outputFormatToAudioProfile(r1)
            if (r9 == 0) goto L_0x00be
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r2 = r9.getDefaultAudioProfile()
            if (r2 == 0) goto L_0x00be
            androidx.camera.core.impl.EncoderProfilesProxy$AudioProfileProxy r9 = r9.getDefaultAudioProfile()
            java.lang.String r2 = r9.getMediaType()
            int r3 = r9.getProfile()
            java.lang.String r4 = "audio/none"
            boolean r4 = java.util.Objects.equals(r2, r4)
            java.lang.String r5 = ")]"
            java.lang.String r6 = "AudioConfigUtil"
            java.lang.String r7 = "(profile: "
            if (r4 == 0) goto L_0x004e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "EncoderProfiles contains undefined AUDIO mime type so cannot be used. May rely on fallback defaults to derive settings [chosen mime type: "
            r8.<init>(r9)
            r8.append(r0)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            goto L_0x00be
        L_0x004e:
            int r8 = r8.getOutputFormat()
            r4 = -1
            if (r8 != r4) goto L_0x0072
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "MediaSpec contains OUTPUT_FORMAT_AUTO. Using EncoderProfiles to derive AUDIO settings [mime type: "
            r8.<init>(r0)
            r8.append(r2)
            r8.append(r7)
            r8.append(r3)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            r0 = r2
            r1 = r3
            goto L_0x00bf
        L_0x0072:
            boolean r8 = java.util.Objects.equals(r0, r2)
            if (r8 == 0) goto L_0x0096
            if (r1 != r3) goto L_0x0096
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "MediaSpec audio mime/profile matches EncoderProfiles. Using EncoderProfiles to derive AUDIO settings [mime type: "
            r8.<init>(r0)
            r8.append(r2)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
            r0 = r2
            goto L_0x00bf
        L_0x0096:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "MediaSpec audio mime or profile does not match EncoderProfiles, so EncoderProfiles settings cannot be used. May rely on fallback defaults to derive AUDIO settings [EncoderProfiles mime type: "
            r8.<init>(r9)
            r8.append(r2)
            r8.append(r7)
            r8.append(r3)
            java.lang.String r9 = "), chosen mime type: "
            r8.append(r9)
            r8.append(r0)
            r8.append(r7)
            r8.append(r1)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            androidx.camera.core.Logger.d(r6, r8)
        L_0x00be:
            r9 = 0
        L_0x00bf:
            androidx.camera.video.internal.config.AudioMimeInfo$Builder r8 = androidx.camera.video.internal.config.AudioMimeInfo.builder(r0)
            java.lang.Object r8 = r8.setProfile(r1)
            androidx.camera.video.internal.config.AudioMimeInfo$Builder r8 = (androidx.camera.video.internal.config.AudioMimeInfo.Builder) r8
            if (r9 == 0) goto L_0x00ce
            r8.setCompatibleAudioProfile(r9)
        L_0x00ce:
            androidx.camera.video.internal.config.AudioMimeInfo r8 = r8.build()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.config.AudioConfigUtil.resolveAudioMimeInfo(androidx.camera.video.MediaSpec, androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy):androidx.camera.video.internal.config.AudioMimeInfo");
    }

    @NonNull
    public static AudioSettings resolveAudioSettings(@NonNull AudioMimeInfo audioMimeInfo, @NonNull AudioSpec audioSpec) {
        Supplier supplier;
        EncoderProfilesProxy.AudioProfileProxy compatibleAudioProfile = audioMimeInfo.getCompatibleAudioProfile();
        if (compatibleAudioProfile != null) {
            supplier = new AudioSettingsAudioProfileResolver(audioSpec, compatibleAudioProfile);
        } else {
            supplier = new AudioSettingsDefaultResolver(audioSpec);
        }
        return (AudioSettings) supplier.get();
    }

    public static int resolveAudioSource(@NonNull AudioSpec audioSpec) {
        int source = audioSpec.getSource();
        if (source == -1) {
            Logger.d(TAG, "Using default AUDIO source: 5");
            return 5;
        }
        Logger.d(TAG, "Using provided AUDIO source: " + source);
        return source;
    }

    public static int resolveAudioSourceFormat(@NonNull AudioSpec audioSpec) {
        int sourceFormat = audioSpec.getSourceFormat();
        if (sourceFormat == -1) {
            Logger.d(TAG, "Using default AUDIO source format: 2");
            return 2;
        }
        Logger.d(TAG, "Using provided AUDIO source format: " + sourceFormat);
        return sourceFormat;
    }

    public static int scaleAndClampBitrate(int i, int i2, int i3, int i4, int i5, Range<Integer> range) {
        String str;
        Rational rational = new Rational(i2, i3);
        Rational rational2 = new Rational(i4, i5);
        double doubleValue = rational.doubleValue();
        int doubleValue2 = (int) (rational2.doubleValue() * doubleValue * ((double) i));
        if (Logger.isDebugEnabled(TAG)) {
            str = String.format("Base Bitrate(%dbps) * Channel Count Ratio(%d / %d) * Sample Rate Ratio(%d / %d) = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(doubleValue2)});
        } else {
            str = "";
        }
        if (!AudioSpec.BITRATE_RANGE_AUTO.equals(range)) {
            Integer clamp = range.clamp(Integer.valueOf(doubleValue2));
            doubleValue2 = clamp.intValue();
            if (Logger.isDebugEnabled(TAG)) {
                str = str.concat(String.format("\nClamped to range %s -> %dbps", new Object[]{range, clamp}));
            }
        }
        Logger.d(TAG, str);
        return doubleValue2;
    }

    public static int selectSampleRateOrNearestSupported(@NonNull Range<Integer> range, int i, int i2, int i3) {
        ArrayList arrayList = null;
        int i4 = 0;
        int i5 = i3;
        while (true) {
            if (!range.contains(Integer.valueOf(i5))) {
                Logger.d(TAG, "Sample rate " + i5 + "Hz is not in target range " + range);
            } else if (AudioSource.isSettingsSupported(i5, i, i2)) {
                return i5;
            } else {
                StringBuilder r = e.r(i5, "Sample rate ", i, "Hz is not supported by audio source with channel count ", " and source format ");
                r.append(i2);
                Logger.d(TAG, r.toString());
            }
            if (arrayList == null) {
                Logger.d(TAG, "Trying common sample rates in proximity order to target " + i3 + "Hz");
                arrayList = new ArrayList(AudioSettings.COMMON_SAMPLE_RATES);
                Collections.sort(arrayList, new h0(i3));
            }
            if (i4 < arrayList.size()) {
                int i6 = i4 + 1;
                i5 = ((Integer) arrayList.get(i4)).intValue();
                i4 = i6;
            } else {
                Logger.d(TAG, "No sample rate found in target range or supported by audio source. Falling back to default sample rate of 44100Hz");
                return AUDIO_SAMPLE_RATE_DEFAULT;
            }
        }
    }
}
