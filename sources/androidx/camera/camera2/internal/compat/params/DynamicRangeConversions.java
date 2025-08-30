package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.DynamicRange;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiresApi(33)
public final class DynamicRangeConversions {
    private static final Map<DynamicRange, List<Long>> DR_TO_PROFILE_MAP;
    private static final Map<Long, DynamicRange> PROFILE_TO_DR_MAP;

    static {
        HashMap hashMap = new HashMap();
        PROFILE_TO_DR_MAP = hashMap;
        HashMap hashMap2 = new HashMap();
        DR_TO_PROFILE_MAP = hashMap2;
        DynamicRange dynamicRange = DynamicRange.SDR;
        hashMap.put(1L, dynamicRange);
        hashMap2.put(dynamicRange, Collections.singletonList(1L));
        hashMap.put(2L, DynamicRange.HLG_10_BIT);
        hashMap2.put((DynamicRange) hashMap.get(2L), Collections.singletonList(2L));
        DynamicRange dynamicRange2 = DynamicRange.HDR10_10_BIT;
        hashMap.put(4L, dynamicRange2);
        hashMap2.put(dynamicRange2, Collections.singletonList(4L));
        DynamicRange dynamicRange3 = DynamicRange.HDR10_PLUS_10_BIT;
        hashMap.put(8L, dynamicRange3);
        hashMap2.put(dynamicRange3, Collections.singletonList(8L));
        List<Long> asList = Arrays.asList(new Long[]{64L, 128L, 16L, 32L});
        for (Long put : asList) {
            PROFILE_TO_DR_MAP.put(put, DynamicRange.DOLBY_VISION_10_BIT);
        }
        DR_TO_PROFILE_MAP.put(DynamicRange.DOLBY_VISION_10_BIT, asList);
        List<Long> asList2 = Arrays.asList(new Long[]{1024L, Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH), 256L, 512L});
        for (Long put2 : asList2) {
            PROFILE_TO_DR_MAP.put(put2, DynamicRange.DOLBY_VISION_8_BIT);
        }
        DR_TO_PROFILE_MAP.put(DynamicRange.DOLBY_VISION_8_BIT, asList2);
    }

    private DynamicRangeConversions() {
    }

    @Nullable
    public static Long dynamicRangeToFirstSupportedProfile(@NonNull DynamicRange dynamicRange, @NonNull DynamicRangeProfiles dynamicRangeProfiles) {
        List<Long> list = DR_TO_PROFILE_MAP.get(dynamicRange);
        if (list == null) {
            return null;
        }
        Set r = dynamicRangeProfiles.getSupportedProfiles();
        for (Long l : list) {
            if (r.contains(l)) {
                return l;
            }
        }
        return null;
    }

    @Nullable
    public static DynamicRange profileToDynamicRange(long j) {
        return PROFILE_TO_DR_MAP.get(Long.valueOf(j));
    }
}
