package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.video.FallbackStrategy;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class QualitySelector {
    private static final String TAG = "QualitySelector";
    private final FallbackStrategy mFallbackStrategy;
    private final List<Quality> mPreferredQualityList;

    public QualitySelector(@NonNull List<Quality> list, @NonNull FallbackStrategy fallbackStrategy) {
        boolean z;
        if (!list.isEmpty() || fallbackStrategy != FallbackStrategy.NONE) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "No preferred quality and fallback strategy.");
        this.mPreferredQualityList = Collections.unmodifiableList(new ArrayList(list));
        this.mFallbackStrategy = fallbackStrategy;
    }

    private void addByFallbackStrategy(@NonNull List<Quality> list, @NonNull Set<Quality> set) {
        Quality quality;
        if (!list.isEmpty() && !set.containsAll(list)) {
            Logger.d(TAG, "Select quality by fallbackStrategy = " + this.mFallbackStrategy);
            FallbackStrategy fallbackStrategy = this.mFallbackStrategy;
            if (fallbackStrategy != FallbackStrategy.NONE) {
                Preconditions.checkState(fallbackStrategy instanceof FallbackStrategy.RuleStrategy, "Currently only support type RuleStrategy");
                FallbackStrategy.RuleStrategy ruleStrategy = (FallbackStrategy.RuleStrategy) this.mFallbackStrategy;
                List<Quality> sortedQualities = Quality.getSortedQualities();
                boolean z = false;
                if (ruleStrategy.getFallbackQuality() == Quality.HIGHEST) {
                    quality = sortedQualities.get(0);
                } else if (ruleStrategy.getFallbackQuality() == Quality.LOWEST) {
                    quality = (Quality) e.f(sortedQualities, 1);
                } else {
                    quality = ruleStrategy.getFallbackQuality();
                }
                int indexOf = sortedQualities.indexOf(quality);
                if (indexOf != -1) {
                    z = true;
                }
                Preconditions.checkState(z);
                ArrayList arrayList = new ArrayList();
                for (int i = indexOf - 1; i >= 0; i--) {
                    Quality quality2 = sortedQualities.get(i);
                    if (list.contains(quality2)) {
                        arrayList.add(quality2);
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = indexOf + 1; i2 < sortedQualities.size(); i2++) {
                    Quality quality3 = sortedQualities.get(i2);
                    if (list.contains(quality3)) {
                        arrayList2.add(quality3);
                    }
                }
                Logger.d(TAG, "sizeSortedQualities = " + sortedQualities + ", fallback quality = " + quality + ", largerQualities = " + arrayList + ", smallerQualities = " + arrayList2);
                int fallbackRule = ruleStrategy.getFallbackRule();
                if (fallbackRule == 0) {
                    return;
                }
                if (fallbackRule == 1) {
                    set.addAll(arrayList);
                    set.addAll(arrayList2);
                } else if (fallbackRule == 2) {
                    set.addAll(arrayList);
                } else if (fallbackRule == 3) {
                    set.addAll(arrayList2);
                    set.addAll(arrayList);
                } else if (fallbackRule == 4) {
                    set.addAll(arrayList2);
                } else {
                    throw new AssertionError("Unhandled fallback strategy: " + this.mFallbackStrategy);
                }
            }
        }
    }

    private static void checkQualityConstantsOrThrow(@NonNull List<Quality> list) {
        for (Quality next : list) {
            boolean containsQuality = Quality.containsQuality(next);
            Preconditions.checkArgument(containsQuality, "qualities contain invalid quality: " + next);
        }
    }

    @NonNull
    public static QualitySelector from(@NonNull Quality quality) {
        return from(quality, FallbackStrategy.NONE);
    }

    @NonNull
    public static QualitySelector fromOrderedList(@NonNull List<Quality> list) {
        return fromOrderedList(list, FallbackStrategy.NONE);
    }

    @NonNull
    private static Size getProfileVideoSize(@NonNull VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        EncoderProfilesProxy.VideoProfileProxy defaultVideoProfile = videoValidatedEncoderProfilesProxy.getDefaultVideoProfile();
        return new Size(defaultVideoProfile.getWidth(), defaultVideoProfile.getHeight());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Map<Quality, Size> getQualityToResolutionMap(@NonNull VideoCapabilities videoCapabilities, @NonNull DynamicRange dynamicRange) {
        HashMap hashMap = new HashMap();
        for (Quality next : videoCapabilities.getSupportedQualities(dynamicRange)) {
            VideoValidatedEncoderProfilesProxy profiles = videoCapabilities.getProfiles(next, dynamicRange);
            Objects.requireNonNull(profiles);
            hashMap.put(next, getProfileVideoSize(profiles));
        }
        return hashMap;
    }

    @Nullable
    public static Size getResolution(@NonNull CameraInfo cameraInfo, @NonNull Quality quality) {
        checkQualityConstantsOrThrow(quality);
        VideoValidatedEncoderProfilesProxy profiles = Recorder.getVideoCapabilities(cameraInfo).getProfiles(quality, DynamicRange.SDR);
        if (profiles != null) {
            return getProfileVideoSize(profiles);
        }
        return null;
    }

    @NonNull
    @Deprecated
    public static List<Quality> getSupportedQualities(@NonNull CameraInfo cameraInfo) {
        return Recorder.getVideoCapabilities(cameraInfo).getSupportedQualities(DynamicRange.SDR);
    }

    @Deprecated
    public static boolean isQualitySupported(@NonNull CameraInfo cameraInfo, @NonNull Quality quality) {
        return Recorder.getVideoCapabilities(cameraInfo).isQualitySupported(quality, DynamicRange.SDR);
    }

    @NonNull
    public List<Quality> getPrioritizedQualities(@NonNull List<Quality> list) {
        if (list.isEmpty()) {
            Logger.w(TAG, "No supported quality on the device.");
            return new ArrayList();
        }
        Logger.d(TAG, "supportedQualities = " + list);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<Quality> it = this.mPreferredQualityList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Quality next = it.next();
            if (next == Quality.HIGHEST) {
                linkedHashSet.addAll(list);
                break;
            } else if (next == Quality.LOWEST) {
                ArrayList arrayList = new ArrayList(list);
                Collections.reverse(arrayList);
                linkedHashSet.addAll(arrayList);
                break;
            } else if (list.contains(next)) {
                linkedHashSet.add(next);
            } else {
                Logger.w(TAG, "quality is not supported and will be ignored: " + next);
            }
        }
        addByFallbackStrategy(list, linkedHashSet);
        return new ArrayList(linkedHashSet);
    }

    @NonNull
    public String toString() {
        return "QualitySelector{preferredQualities=" + this.mPreferredQualityList + ", fallbackStrategy=" + this.mFallbackStrategy + "}";
    }

    @NonNull
    public static QualitySelector from(@NonNull Quality quality, @NonNull FallbackStrategy fallbackStrategy) {
        Preconditions.checkNotNull(quality, "quality cannot be null");
        Preconditions.checkNotNull(fallbackStrategy, "fallbackStrategy cannot be null");
        checkQualityConstantsOrThrow(quality);
        return new QualitySelector(Collections.singletonList(quality), fallbackStrategy);
    }

    @NonNull
    public static QualitySelector fromOrderedList(@NonNull List<Quality> list, @NonNull FallbackStrategy fallbackStrategy) {
        Preconditions.checkNotNull(list, "qualities cannot be null");
        Preconditions.checkNotNull(fallbackStrategy, "fallbackStrategy cannot be null");
        Preconditions.checkArgument(!list.isEmpty(), "qualities cannot be empty");
        checkQualityConstantsOrThrow(list);
        return new QualitySelector(list, fallbackStrategy);
    }

    private static void checkQualityConstantsOrThrow(@NonNull Quality quality) {
        boolean containsQuality = Quality.containsQuality(quality);
        Preconditions.checkArgument(containsQuality, "Invalid quality: " + quality);
    }
}
