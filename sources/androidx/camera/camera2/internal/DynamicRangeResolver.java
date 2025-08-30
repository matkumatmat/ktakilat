package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangeConversions;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

final class DynamicRangeResolver {
    private static final String TAG = "DynamicRangeResolver";
    private final CameraCharacteristicsCompat mCharacteristics;
    private final DynamicRangesCompat mDynamicRangesInfo;
    private final boolean mIs10BitSupported;

    @RequiresApi(33)
    public static final class Api33Impl {
        private Api33Impl() {
        }

        @Nullable
        public static DynamicRange getRecommended10BitDynamicRange(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
            Long l = (Long) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_RECOMMENDED_TEN_BIT_DYNAMIC_RANGE_PROFILE);
            if (l != null) {
                return DynamicRangeConversions.profileToDynamicRange(l.longValue());
            }
            return null;
        }
    }

    public DynamicRangeResolver(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        this.mCharacteristics = cameraCharacteristicsCompat;
        this.mDynamicRangesInfo = DynamicRangesCompat.fromCameraCharacteristics(cameraCharacteristicsCompat);
        int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        boolean z = false;
        if (iArr != null) {
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (iArr[i] == 18) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        this.mIs10BitSupported = z;
    }

    private static boolean canResolve(@NonNull DynamicRange dynamicRange, @NonNull DynamicRange dynamicRange2) {
        Preconditions.checkState(dynamicRange2.isFullySpecified(), "Fully specified range is not actually fully specified.");
        if (dynamicRange.getEncoding() == 2 && dynamicRange2.getEncoding() == 1) {
            return false;
        }
        if (dynamicRange.getEncoding() != 2 && dynamicRange.getEncoding() != 0 && dynamicRange.getEncoding() != dynamicRange2.getEncoding()) {
            return false;
        }
        if (dynamicRange.getBitDepth() == 0 || dynamicRange.getBitDepth() == dynamicRange2.getBitDepth()) {
            return true;
        }
        return false;
    }

    private static boolean canResolveWithinConstraints(@NonNull DynamicRange dynamicRange, @NonNull DynamicRange dynamicRange2, @NonNull Set<DynamicRange> set) {
        if (set.contains(dynamicRange2)) {
            return canResolve(dynamicRange, dynamicRange2);
        }
        Logger.d(TAG, "Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  " + dynamicRange + "\nCandidate dynamic range:\n  " + dynamicRange2);
        return false;
    }

    @Nullable
    private static DynamicRange findSupportedHdrMatch(@NonNull DynamicRange dynamicRange, @NonNull Collection<DynamicRange> collection, @NonNull Set<DynamicRange> set) {
        if (dynamicRange.getEncoding() == 1) {
            return null;
        }
        for (DynamicRange next : collection) {
            Preconditions.checkNotNull(next, "Fully specified DynamicRange cannot be null.");
            int encoding = next.getEncoding();
            Preconditions.checkState(next.isFullySpecified(), "Fully specified DynamicRange must have fully defined encoding.");
            if (encoding != 1 && canResolveWithinConstraints(dynamicRange, next, set)) {
                return next;
            }
        }
        return null;
    }

    private static boolean isFullyUnspecified(@NonNull DynamicRange dynamicRange) {
        return Objects.equals(dynamicRange, DynamicRange.UNSPECIFIED);
    }

    private static boolean isPartiallySpecified(@NonNull DynamicRange dynamicRange) {
        if (dynamicRange.getEncoding() == 2 || ((dynamicRange.getEncoding() != 0 && dynamicRange.getBitDepth() == 0) || (dynamicRange.getEncoding() == 0 && dynamicRange.getBitDepth() != 0))) {
            return true;
        }
        return false;
    }

    @Nullable
    private DynamicRange resolveDynamicRange(@NonNull DynamicRange dynamicRange, @NonNull Set<DynamicRange> set, @NonNull Set<DynamicRange> set2, @NonNull Set<DynamicRange> set3, @NonNull String str) {
        DynamicRange dynamicRange2;
        String str2;
        if (!dynamicRange.isFullySpecified()) {
            int encoding = dynamicRange.getEncoding();
            int bitDepth = dynamicRange.getBitDepth();
            if (encoding == 1 && bitDepth == 0) {
                DynamicRange dynamicRange3 = DynamicRange.SDR;
                if (set.contains(dynamicRange3)) {
                    return dynamicRange3;
                }
                return null;
            }
            DynamicRange findSupportedHdrMatch = findSupportedHdrMatch(dynamicRange, set2, set);
            if (findSupportedHdrMatch != null) {
                Logger.d(TAG, "Resolved dynamic range for use case " + str + " from existing attached surface.\n" + dynamicRange + "\n->\n" + findSupportedHdrMatch);
                return findSupportedHdrMatch;
            }
            DynamicRange findSupportedHdrMatch2 = findSupportedHdrMatch(dynamicRange, set3, set);
            if (findSupportedHdrMatch2 != null) {
                Logger.d(TAG, "Resolved dynamic range for use case " + str + " from concurrently bound use case.\n" + dynamicRange + "\n->\n" + findSupportedHdrMatch2);
                return findSupportedHdrMatch2;
            }
            DynamicRange dynamicRange4 = DynamicRange.SDR;
            if (canResolveWithinConstraints(dynamicRange, dynamicRange4, set)) {
                Logger.d(TAG, "Resolved dynamic range for use case " + str + " to no compatible HDR dynamic ranges.\n" + dynamicRange + "\n->\n" + dynamicRange4);
                return dynamicRange4;
            }
            if (encoding == 2 && (bitDepth == 10 || bitDepth == 0)) {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                if (Build.VERSION.SDK_INT >= 33) {
                    dynamicRange2 = Api33Impl.getRecommended10BitDynamicRange(this.mCharacteristics);
                    if (dynamicRange2 != null) {
                        linkedHashSet.add(dynamicRange2);
                    }
                } else {
                    dynamicRange2 = null;
                }
                linkedHashSet.add(DynamicRange.HLG_10_BIT);
                DynamicRange findSupportedHdrMatch3 = findSupportedHdrMatch(dynamicRange, linkedHashSet, set);
                if (findSupportedHdrMatch3 != null) {
                    if (findSupportedHdrMatch3.equals(dynamicRange2)) {
                        str2 = "recommended";
                    } else {
                        str2 = "required";
                    }
                    StringBuilder u = e.u("Resolved dynamic range for use case ", str, " from ", str2, " 10-bit supported dynamic range.\n");
                    u.append(dynamicRange);
                    u.append("\n->\n");
                    u.append(findSupportedHdrMatch3);
                    Logger.d(TAG, u.toString());
                    return findSupportedHdrMatch3;
                }
            }
            for (DynamicRange next : set) {
                Preconditions.checkState(next.isFullySpecified(), "Candidate dynamic range must be fully specified.");
                if (!next.equals(DynamicRange.SDR) && canResolve(dynamicRange, next)) {
                    Logger.d(TAG, "Resolved dynamic range for use case " + str + " from validated dynamic range constraints or supported HDR dynamic ranges.\n" + dynamicRange + "\n->\n" + next);
                    return next;
                }
            }
            return null;
        } else if (set.contains(dynamicRange)) {
            return dynamicRange;
        } else {
            return null;
        }
    }

    private DynamicRange resolveDynamicRangeAndUpdateConstraints(@NonNull Set<DynamicRange> set, @NonNull Set<DynamicRange> set2, @NonNull Set<DynamicRange> set3, @NonNull UseCaseConfig<?> useCaseConfig, @NonNull Set<DynamicRange> set4) {
        DynamicRange dynamicRange = useCaseConfig.getDynamicRange();
        DynamicRange resolveDynamicRange = resolveDynamicRange(dynamicRange, set4, set2, set3, useCaseConfig.getTargetName());
        if (resolveDynamicRange != null) {
            updateConstraints(set4, resolveDynamicRange, this.mDynamicRangesInfo);
            return resolveDynamicRange;
        }
        String targetName = useCaseConfig.getTargetName();
        String join = TextUtils.join("\n  ", set);
        String join2 = TextUtils.join("\n  ", set4);
        StringBuilder sb = new StringBuilder("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  ");
        sb.append(targetName);
        sb.append("\nRequested dynamic range:\n  ");
        sb.append(dynamicRange);
        sb.append("\nSupported dynamic ranges:\n  ");
        throw new IllegalArgumentException(e.q(sb, join, "\nConstrained set of concurrent dynamic ranges:\n  ", join2));
    }

    private static void updateConstraints(@NonNull Set<DynamicRange> set, @NonNull DynamicRange dynamicRange, @NonNull DynamicRangesCompat dynamicRangesCompat) {
        Preconditions.checkState(!set.isEmpty(), "Cannot update already-empty constraints.");
        Set<DynamicRange> dynamicRangeCaptureRequestConstraints = dynamicRangesCompat.getDynamicRangeCaptureRequestConstraints(dynamicRange);
        if (!dynamicRangeCaptureRequestConstraints.isEmpty()) {
            HashSet hashSet = new HashSet(set);
            set.retainAll(dynamicRangeCaptureRequestConstraints);
            if (set.isEmpty()) {
                String join = TextUtils.join("\n  ", dynamicRangeCaptureRequestConstraints);
                String join2 = TextUtils.join("\n  ", hashSet);
                throw new IllegalArgumentException("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  " + dynamicRange + "\nConstraints:\n  " + join + "\nExisting constraints:\n  " + join2);
            }
        }
    }

    public boolean is10BitDynamicRangeSupported() {
        return this.mIs10BitSupported;
    }

    public Map<UseCaseConfig<?>, DynamicRange> resolveAndValidateDynamicRanges(@NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2, @NonNull List<Integer> list3) {
        LinkedHashSet<DynamicRange> linkedHashSet = new LinkedHashSet<>();
        for (AttachedSurfaceInfo dynamicRange : list) {
            linkedHashSet.add(dynamicRange.getDynamicRange());
        }
        Set<DynamicRange> supportedDynamicRanges = this.mDynamicRangesInfo.getSupportedDynamicRanges();
        HashSet hashSet = new HashSet(supportedDynamicRanges);
        for (DynamicRange updateConstraints : linkedHashSet) {
            updateConstraints(hashSet, updateConstraints, this.mDynamicRangesInfo);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Integer intValue : list3) {
            UseCaseConfig useCaseConfig = list2.get(intValue.intValue());
            DynamicRange dynamicRange2 = useCaseConfig.getDynamicRange();
            if (isFullyUnspecified(dynamicRange2)) {
                arrayList3.add(useCaseConfig);
            } else if (isPartiallySpecified(dynamicRange2)) {
                arrayList2.add(useCaseConfig);
            } else {
                arrayList.add(useCaseConfig);
            }
        }
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        Iterator it = arrayList4.iterator();
        while (it.hasNext()) {
            UseCaseConfig useCaseConfig2 = (UseCaseConfig) it.next();
            DynamicRange resolveDynamicRangeAndUpdateConstraints = resolveDynamicRangeAndUpdateConstraints(supportedDynamicRanges, linkedHashSet, linkedHashSet2, useCaseConfig2, hashSet);
            hashMap.put(useCaseConfig2, resolveDynamicRangeAndUpdateConstraints);
            if (!linkedHashSet.contains(resolveDynamicRangeAndUpdateConstraints)) {
                linkedHashSet2.add(resolveDynamicRangeAndUpdateConstraints);
            }
        }
        return hashMap;
    }
}
