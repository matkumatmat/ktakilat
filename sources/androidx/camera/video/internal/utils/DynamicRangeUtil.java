package androidx.camera.video.internal.utils;

import androidx.annotation.NonNull;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class DynamicRangeUtil {
    public static final Map<Integer, Set<Integer>> DR_TO_VP_BIT_DEPTH_MAP;
    public static final Map<Integer, Set<Integer>> DR_TO_VP_FORMAT_MAP;
    private static final Map<String, Map<DynamicRange, Integer>> MIME_TO_DEFAULT_PROFILE_LEVEL_MAP;
    public static final Map<Integer, Integer> VP_TO_DR_BIT_DEPTH;
    public static final Map<Integer, Integer> VP_TO_DR_FORMAT_MAP;

    static {
        HashMap hashMap = new HashMap();
        DR_TO_VP_BIT_DEPTH_MAP = hashMap;
        HashMap hashMap2 = new HashMap();
        DR_TO_VP_FORMAT_MAP = hashMap2;
        HashMap hashMap3 = new HashMap();
        VP_TO_DR_BIT_DEPTH = hashMap3;
        HashMap hashMap4 = new HashMap();
        VP_TO_DR_FORMAT_MAP = hashMap4;
        HashMap hashMap5 = new HashMap();
        MIME_TO_DEFAULT_PROFILE_LEVEL_MAP = hashMap5;
        hashMap.put(8, new HashSet(Collections.singletonList(8)));
        hashMap.put(10, new HashSet(Collections.singletonList(10)));
        hashMap.put(0, new HashSet(Arrays.asList(new Integer[]{8, 10})));
        hashMap2.put(0, new HashSet(Arrays.asList(new Integer[]{0, 1, 2, 3, 4})));
        hashMap2.put(1, new HashSet(Collections.singletonList(0)));
        hashMap2.put(2, new HashSet(Arrays.asList(new Integer[]{1, 2, 3, 4})));
        hashMap2.put(3, new HashSet(Collections.singletonList(1)));
        hashMap2.put(4, new HashSet(Collections.singletonList(2)));
        hashMap2.put(5, new HashSet(Collections.singletonList(3)));
        hashMap2.put(6, new HashSet(Collections.singletonList(4)));
        hashMap3.put(8, 8);
        hashMap3.put(10, 10);
        hashMap4.put(0, 1);
        hashMap4.put(1, 3);
        hashMap4.put(2, 4);
        hashMap4.put(3, 5);
        hashMap4.put(4, 6);
        HashMap hashMap6 = new HashMap();
        DynamicRange dynamicRange = DynamicRange.SDR;
        hashMap6.put(dynamicRange, 1);
        DynamicRange dynamicRange2 = DynamicRange.HLG_10_BIT;
        hashMap6.put(dynamicRange2, 2);
        DynamicRange dynamicRange3 = DynamicRange.HDR10_10_BIT;
        hashMap6.put(dynamicRange3, 4096);
        DynamicRange dynamicRange4 = DynamicRange.HDR10_PLUS_10_BIT;
        hashMap6.put(dynamicRange4, 8192);
        HashMap hashMap7 = new HashMap();
        hashMap7.put(dynamicRange, 1);
        hashMap7.put(dynamicRange2, 2);
        hashMap7.put(dynamicRange3, 4096);
        hashMap7.put(dynamicRange4, 8192);
        HashMap hashMap8 = new HashMap();
        hashMap8.put(dynamicRange, 1);
        hashMap8.put(dynamicRange2, 4);
        hashMap8.put(dynamicRange3, 4096);
        hashMap8.put(dynamicRange4, 16384);
        HashMap hashMap9 = new HashMap();
        hashMap9.put(DynamicRange.DOLBY_VISION_10_BIT, 256);
        hashMap9.put(DynamicRange.DOLBY_VISION_8_BIT, 512);
        hashMap5.put("video/hevc", hashMap6);
        hashMap5.put("video/av01", hashMap7);
        hashMap5.put("video/x-vnd.on2.vp9", hashMap8);
        hashMap5.put("video/dolby-vision", hashMap9);
    }

    private DynamicRangeUtil() {
    }

    public static int dynamicRangeToCodecProfileLevelForMime(@NonNull String str, @NonNull DynamicRange dynamicRange) {
        Integer num;
        Map map = MIME_TO_DEFAULT_PROFILE_LEVEL_MAP.get(str);
        if (map == null || (num = (Integer) map.get(dynamicRange)) == null) {
            return -1;
        }
        return num.intValue();
    }

    @NonNull
    public static Set<Integer> dynamicRangeToVideoProfileBitDepth(@NonNull DynamicRange dynamicRange) {
        Set<Integer> set = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(dynamicRange.getBitDepth()));
        if (set == null) {
            return Collections.emptySet();
        }
        return set;
    }

    @NonNull
    public static Set<Integer> dynamicRangeToVideoProfileHdrFormats(@NonNull DynamicRange dynamicRange) {
        Set<Integer> set = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(dynamicRange.getEncoding()));
        if (set == null) {
            return Collections.emptySet();
        }
        return set;
    }

    private static boolean isBitDepthMatched(int i, @NonNull DynamicRange dynamicRange) {
        Set set = DR_TO_VP_BIT_DEPTH_MAP.get(Integer.valueOf(dynamicRange.getBitDepth()));
        if (set == null || !set.contains(Integer.valueOf(i))) {
            return false;
        }
        return true;
    }

    private static boolean isHdrEncodingMatched(int i, @NonNull DynamicRange dynamicRange) {
        Set set = DR_TO_VP_FORMAT_MAP.get(Integer.valueOf(dynamicRange.getEncoding()));
        if (set == null || !set.contains(Integer.valueOf(i))) {
            return false;
        }
        return true;
    }

    public static boolean isHdrSettingsMatched(@NonNull EncoderProfilesProxy.VideoProfileProxy videoProfileProxy, @NonNull DynamicRange dynamicRange) {
        if (!isBitDepthMatched(videoProfileProxy.getBitDepth(), dynamicRange) || !isHdrEncodingMatched(videoProfileProxy.getHdrFormat(), dynamicRange)) {
            return false;
        }
        return true;
    }

    public static int videoProfileBitDepthToDynamicRangeBitDepth(int i) {
        Map<Integer, Integer> map = VP_TO_DR_BIT_DEPTH;
        Preconditions.checkArgument(map.containsKey(Integer.valueOf(i)));
        Integer num = map.get(Integer.valueOf(i));
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public static int videoProfileHdrFormatsToDynamicRangeEncoding(int i) {
        Map<Integer, Integer> map = VP_TO_DR_FORMAT_MAP;
        Preconditions.checkArgument(map.containsKey(Integer.valueOf(i)));
        Integer num = map.get(Integer.valueOf(i));
        Objects.requireNonNull(num);
        return num.intValue();
    }
}
