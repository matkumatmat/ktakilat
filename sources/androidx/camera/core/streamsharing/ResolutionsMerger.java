package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.SupportedOutputSizesSorter;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ResolutionsMerger {
    private static final double SAME_AREA_WIDTH_HEIGHT_RATIO = Math.sqrt(2.3703703703703702d);
    private static final String TAG = "ResolutionsMerger";
    @NonNull
    private final CameraInfoInternal mCameraInfo;
    @NonNull
    private final Map<UseCaseConfig<?>, List<Size>> mChildSizesCache;
    @NonNull
    private final Set<UseCaseConfig<?>> mChildrenConfigs;
    @NonNull
    private final Rational mFallbackAspectRatio;
    @NonNull
    private final Rational mSensorAspectRatio;
    @NonNull
    private final Size mSensorSize;
    @NonNull
    private final SupportedOutputSizesSorter mSizeSorter;

    public static class CompareAspectRatioByOverlappingAreaToReference implements Comparator<Rational> {
        @NonNull
        private final Rational mReferenceAspectRatio;
        private final boolean mReverse;

        public CompareAspectRatioByOverlappingAreaToReference(@NonNull Rational rational, boolean z) {
            this.mReferenceAspectRatio = rational;
            this.mReverse = z;
        }

        public int compare(@NonNull Rational rational, @NonNull Rational rational2) {
            float access$000 = ResolutionsMerger.computeAreaOverlapping(rational, this.mReferenceAspectRatio);
            float access$0002 = ResolutionsMerger.computeAreaOverlapping(rational2, this.mReferenceAspectRatio);
            if (this.mReverse) {
                return Float.compare(access$0002, access$000);
            }
            return Float.compare(access$000, access$0002);
        }
    }

    public ResolutionsMerger(@NonNull CameraInternal cameraInternal, @NonNull Set<UseCaseConfig<?>> set) {
        this(TransformUtils.rectToSize(cameraInternal.getCameraControlInternal().getSensorRect()), cameraInternal.getCameraInfoInternal(), set);
    }

    private boolean areCroppingInDifferentDirection(float f, float f2, float f3) {
        int i;
        int i2 = (f > f2 ? 1 : (f == f2 ? 0 : -1));
        if (i2 == 0 || f2 == f3) {
            return false;
        }
        return i2 > 0 ? f2 < f3 : i > 0;
    }

    /* access modifiers changed from: private */
    public static float computeAreaOverlapping(@NonNull Rational rational, @NonNull Rational rational2) {
        float floatValue = rational.floatValue();
        float floatValue2 = rational2.floatValue();
        if (floatValue > floatValue2) {
            return floatValue2 / floatValue;
        }
        return floatValue / floatValue2;
    }

    @NonNull
    private List<Size> filterOutChildSizesCausingDoubleCropping(@NonNull Rational rational, @NonNull List<Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Size next : list) {
            if (!isDoubleCropping(rational, next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static List<Size> filterOutChildSizesThatWillNeverBeSelected(@NonNull List<Size> list) {
        Rational rational;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (Size next : list) {
            Iterator it = hashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    rational = null;
                    break;
                }
                rational = (Rational) it.next();
                if (AspectRatioUtil.hasMatchingAspectRatio(next, rational)) {
                    break;
                }
            }
            if (rational != null) {
                Size size = (Size) hashMap.get(rational);
                Objects.requireNonNull(size);
                if (next.getHeight() <= size.getHeight() && next.getWidth() <= size.getWidth()) {
                    if (next.getWidth() == size.getWidth() && next.getHeight() == size.getHeight()) {
                    }
                }
            } else {
                rational = toRational(next);
            }
            arrayList.add(next);
            hashMap.put(rational, next);
        }
        return arrayList;
    }

    @VisibleForTesting
    @NonNull
    public static List<Size> filterOutParentSizeThatIsTooSmall(@NonNull Collection<Size> collection, @NonNull List<Size> list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Size next : list) {
            if (isAnyChildSizeCanBeCroppedOutWithoutUpscalingParent(collection, next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    @NonNull
    public static List<Size> filterResolutionsByAspectRatio(@NonNull Rational rational, @NonNull List<Size> list) {
        ArrayList arrayList = new ArrayList();
        for (Size next : list) {
            if (AspectRatioUtil.hasMatchingAspectRatio(next, rational)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NonNull
    private static Rational findCloserAspectRatio(@NonNull Size size) {
        if (((double) size.getWidth()) / ((double) size.getHeight()) > SAME_AREA_WIDTH_HEIGHT_RATIO) {
            return AspectRatioUtil.ASPECT_RATIO_16_9;
        }
        return AspectRatioUtil.ASPECT_RATIO_4_3;
    }

    @NonNull
    private List<Size> getCameraSupportedHighResolutions() {
        return this.mCameraInfo.getSupportedHighResolutions(34);
    }

    @NonNull
    private List<Size> getCameraSupportedResolutions() {
        return this.mCameraInfo.getSupportedResolutions(34);
    }

    @NonNull
    private static Rect getCenterCroppedRectangle(@NonNull Rational rational, @NonNull Size size) {
        RectF rectF;
        RectF rectF2;
        int width = size.getWidth();
        int height = size.getHeight();
        Rational rational2 = toRational(size);
        if (rational.floatValue() == rational2.floatValue()) {
            rectF = new RectF(0.0f, 0.0f, (float) width, (float) height);
        } else {
            if (rational.floatValue() > rational2.floatValue()) {
                float f = (float) width;
                float floatValue = f / rational.floatValue();
                float f2 = (((float) height) - floatValue) / 2.0f;
                rectF2 = new RectF(0.0f, f2, f, floatValue + f2);
            } else {
                float f3 = (float) height;
                float floatValue2 = rational.floatValue() * f3;
                float f4 = (((float) width) - floatValue2) / 2.0f;
                rectF2 = new RectF(f4, 0.0f, floatValue2 + f4, f3);
            }
            rectF = rectF2;
        }
        Rect rect = new Rect();
        rectF.round(rect);
        return rect;
    }

    @NonNull
    private Set<Size> getChildrenRequiredResolutions() {
        HashSet hashSet = new HashSet();
        for (UseCaseConfig<?> sortedChildSizes : this.mChildrenConfigs) {
            hashSet.addAll(getSortedChildSizes(sortedChildSizes));
        }
        return hashSet;
    }

    @VisibleForTesting
    @NonNull
    public static Rect getCropRectOfReferenceAspectRatio(@NonNull Size size, @NonNull Size size2) {
        return getCenterCroppedRectangle(toRational(size2), size);
    }

    @NonNull
    private static Rational getFallbackAspectRatio(@NonNull Rational rational) {
        Rational rational2 = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (rational.equals(rational2)) {
            return AspectRatioUtil.ASPECT_RATIO_16_9;
        }
        if (rational.equals(AspectRatioUtil.ASPECT_RATIO_16_9)) {
            return rational2;
        }
        throw new IllegalArgumentException("Invalid sensor aspect-ratio: " + rational);
    }

    @VisibleForTesting
    @NonNull
    public static List<Size> getParentSizesThatAreTooLarge(@NonNull Collection<Size> collection, @NonNull List<Size> list) {
        if (collection.isEmpty() || list.isEmpty()) {
            return new ArrayList();
        }
        List<Size> removeDuplicates = removeDuplicates(list);
        ArrayList arrayList = new ArrayList();
        for (Size next : removeDuplicates) {
            if (isAllChildSizesCanBeCroppedOutWithoutUpscalingParent(collection, next)) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
        return arrayList;
    }

    @NonNull
    private Pair<Rect, Size> getPreferredChildSizePairInternal(@NonNull Rect rect, @NonNull UseCaseConfig<?> useCaseConfig, boolean z) {
        Size size;
        if (z) {
            size = getPreferredChildSizeForViewport(TransformUtils.rectToSize(rect), useCaseConfig);
        } else {
            Size rectToSize = TransformUtils.rectToSize(rect);
            size = getPreferredChildSize(rectToSize, useCaseConfig);
            rect = getCropRectOfReferenceAspectRatio(rectToSize, size);
        }
        return new Pair<>(rect, size);
    }

    @NonNull
    private static Rational getSensorAspectRatio(@NonNull Size size) {
        Rational findCloserAspectRatio = findCloserAspectRatio(size);
        Logger.d(TAG, "The closer aspect ratio to the sensor size (" + size + ") is " + findCloserAspectRatio + ".");
        return findCloserAspectRatio;
    }

    @NonNull
    private List<Size> getSortedChildSizes(@NonNull UseCaseConfig<?> useCaseConfig) {
        if (!this.mChildrenConfigs.contains(useCaseConfig)) {
            throw new IllegalArgumentException("Invalid child config: " + useCaseConfig);
        } else if (this.mChildSizesCache.containsKey(useCaseConfig)) {
            List<Size> list = this.mChildSizesCache.get(useCaseConfig);
            Objects.requireNonNull(list);
            return list;
        } else {
            List<Size> filterOutChildSizesThatWillNeverBeSelected = filterOutChildSizesThatWillNeverBeSelected(this.mSizeSorter.getSortedSupportedOutputSizes(useCaseConfig));
            this.mChildSizesCache.put(useCaseConfig, filterOutChildSizesThatWillNeverBeSelected);
            return filterOutChildSizesThatWillNeverBeSelected;
        }
    }

    @NonNull
    private static List<Size> getSupportedPrivResolutions(@NonNull List<Pair<Integer, Size[]>> list) {
        for (Pair next : list) {
            if (((Integer) next.first).equals(34)) {
                return Arrays.asList((Size[]) next.second);
            }
        }
        return new ArrayList();
    }

    @NonNull
    private Map<Rational, List<Size>> groupSizesByAspectRatio(@NonNull List<Size> list) {
        List list2;
        HashMap hashMap = new HashMap();
        Rational rational = AspectRatioUtil.ASPECT_RATIO_4_3;
        hashMap.put(rational, new ArrayList());
        Rational rational2 = AspectRatioUtil.ASPECT_RATIO_16_9;
        hashMap.put(rational2, new ArrayList());
        ArrayList arrayList = new ArrayList();
        arrayList.add(rational);
        arrayList.add(rational2);
        for (Size next : list) {
            if (next.getHeight() > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        list2 = null;
                        break;
                    }
                    Rational rational3 = (Rational) it.next();
                    if (AspectRatioUtil.hasMatchingAspectRatio(next, rational3)) {
                        list2 = (List) hashMap.get(rational3);
                        break;
                    }
                }
                if (list2 == null) {
                    list2 = new ArrayList();
                    Rational rational4 = toRational(next);
                    arrayList.add(rational4);
                    hashMap.put(rational4, list2);
                }
                list2.add(next);
            }
        }
        return hashMap;
    }

    @VisibleForTesting
    public static boolean hasUpscaling(@NonNull Size size, @NonNull Size size2) {
        if (size.getHeight() > size2.getHeight() || size.getWidth() > size2.getWidth()) {
            return true;
        }
        return false;
    }

    private static boolean isAllChildSizesCanBeCroppedOutWithoutUpscalingParent(@NonNull Collection<Size> collection, @NonNull Size size) {
        for (Size hasUpscaling : collection) {
            if (hasUpscaling(hasUpscaling, size)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnyChildSizeCanBeCroppedOutWithoutUpscalingParent(@NonNull Collection<Size> collection, @NonNull Size size) {
        for (Size hasUpscaling : collection) {
            if (!hasUpscaling(hasUpscaling, size)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDoubleCropping(@NonNull Rational rational, @NonNull Size size) {
        if (this.mSensorAspectRatio.equals(rational) || AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
            return false;
        }
        return areCroppingInDifferentDirection(this.mSensorAspectRatio.floatValue(), rational.floatValue(), toRationalWithMod16Considered(size).floatValue());
    }

    private boolean needToAddSensorResolutions() {
        for (Size hasMatchingAspectRatio : getChildrenRequiredResolutions()) {
            if (!AspectRatioUtil.hasMatchingAspectRatio(hasMatchingAspectRatio, this.mFallbackAspectRatio)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    private static List<Size> removeDuplicates(@NonNull List<Size> list) {
        if (list.isEmpty()) {
            return list;
        }
        return new ArrayList(new LinkedHashSet(list));
    }

    @VisibleForTesting
    @NonNull
    public static Rect reverseRect(@NonNull Rect rect) {
        return new Rect(rect.top, rect.left, rect.bottom, rect.right);
    }

    @NonNull
    private List<Size> selectOtherAspectRatioParentResolutionsWithFovPriority(@NonNull List<Size> list, boolean z) {
        Map<Rational, List<Size>> groupSizesByAspectRatio = groupSizesByAspectRatio(list);
        ArrayList arrayList = new ArrayList(groupSizesByAspectRatio.keySet());
        sortByFov(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Rational rational = (Rational) it.next();
            if (!rational.equals(AspectRatioUtil.ASPECT_RATIO_16_9) && !rational.equals(AspectRatioUtil.ASPECT_RATIO_4_3)) {
                List list2 = groupSizesByAspectRatio.get(rational);
                Objects.requireNonNull(list2);
                arrayList2.addAll(selectParentResolutionsByAspectRatio(rational, list2, z));
            }
        }
        return arrayList2;
    }

    @NonNull
    private List<Size> selectParentResolutions(@NonNull List<Size> list) {
        ArrayList arrayList = new ArrayList();
        if (needToAddSensorResolutions()) {
            arrayList.addAll(selectParentResolutionsByAspectRatio(this.mSensorAspectRatio, list, false));
        }
        arrayList.addAll(selectParentResolutionsByAspectRatio(this.mFallbackAspectRatio, list, false));
        arrayList.addAll(selectOtherAspectRatioParentResolutionsWithFovPriority(list, false));
        if (arrayList.isEmpty()) {
            Logger.w(TAG, "Failed to find a parent resolution that does not result in double-cropping, this might due to camera not supporting 4:3 and 16:9resolutions or a strict ResolutionSelector settings. Starting resolution selection process with resolutions that might have a smaller FOV.");
            arrayList.addAll(selectOtherAspectRatioParentResolutionsWithFovPriority(list, true));
        }
        Logger.d(TAG, "Parent resolutions: " + arrayList);
        return arrayList;
    }

    private List<Size> selectParentResolutionsByAspectRatio(@NonNull Rational rational, @NonNull List<Size> list, boolean z) {
        List<Size> filterResolutionsByAspectRatio = filterResolutionsByAspectRatio(rational, list);
        sortInDescendingOrder(filterResolutionsByAspectRatio);
        HashSet hashSet = new HashSet(filterResolutionsByAspectRatio);
        for (UseCaseConfig<?> sortedChildSizes : this.mChildrenConfigs) {
            List<Size> sortedChildSizes2 = getSortedChildSizes(sortedChildSizes);
            if (!z) {
                sortedChildSizes2 = filterOutChildSizesCausingDoubleCropping(rational, sortedChildSizes2);
            }
            if (sortedChildSizes2.isEmpty()) {
                return new ArrayList();
            }
            filterResolutionsByAspectRatio = filterOutParentSizeThatIsTooSmall(sortedChildSizes2, filterResolutionsByAspectRatio);
            hashSet.retainAll(getParentSizesThatAreTooLarge(sortedChildSizes2, filterResolutionsByAspectRatio));
        }
        ArrayList arrayList = new ArrayList();
        for (Size next : filterResolutionsByAspectRatio) {
            if (!hashSet.contains(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private boolean shouldIncludeHighResolutions() {
        boolean z;
        ResolutionSelector resolutionSelector;
        Iterator<UseCaseConfig<?>> it = this.mChildrenConfigs.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            UseCaseConfig next = it.next();
            if (!next.isHighResolutionDisabled(false) && (next instanceof ImageOutputConfig) && (resolutionSelector = ((ImageOutputConfig) next).getResolutionSelector((ResolutionSelector) null)) != null) {
                z = true;
                if (resolutionSelector.getAllowedResolutionMode() == 1) {
                    break;
                }
            }
        }
        return z;
    }

    private void sortByFov(@NonNull List<Rational> list) {
        Collections.sort(list, new CompareAspectRatioByOverlappingAreaToReference(toRational(this.mSensorSize), true));
    }

    @VisibleForTesting
    public static void sortInDescendingOrder(@NonNull List<Size> list) {
        Collections.sort(list, new CompareSizesByArea(true));
    }

    @NonNull
    private static Rational toRational(@NonNull Size size) {
        return new Rational(size.getWidth(), size.getHeight());
    }

    @NonNull
    private static Rational toRationalWithMod16Considered(@NonNull Size size) {
        Rational rational = AspectRatioUtil.ASPECT_RATIO_4_3;
        if (AspectRatioUtil.hasMatchingAspectRatio(size, rational)) {
            return rational;
        }
        Rational rational2 = AspectRatioUtil.ASPECT_RATIO_16_9;
        if (AspectRatioUtil.hasMatchingAspectRatio(size, rational2)) {
            return rational2;
        }
        return toRational(size);
    }

    @NonNull
    public List<Size> getMergedResolutions(@NonNull MutableConfig mutableConfig) {
        List<Size> cameraSupportedResolutions = getCameraSupportedResolutions();
        if (shouldIncludeHighResolutions()) {
            ArrayList arrayList = new ArrayList(cameraSupportedResolutions);
            arrayList.addAll(getCameraSupportedHighResolutions());
            cameraSupportedResolutions = arrayList;
        }
        List list = (List) mutableConfig.retrieveOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, null);
        if (list != null) {
            cameraSupportedResolutions = getSupportedPrivResolutions(list);
        }
        return selectParentResolutions(cameraSupportedResolutions);
    }

    @VisibleForTesting
    @NonNull
    public Size getPreferredChildSize(@NonNull Size size, @NonNull UseCaseConfig<?> useCaseConfig) {
        List<Size> sortedChildSizes = getSortedChildSizes(useCaseConfig);
        for (Size next : sortedChildSizes) {
            if (!isDoubleCropping(size, next) && !hasUpscaling(next, size)) {
                return next;
            }
        }
        for (Size next2 : sortedChildSizes) {
            if (!hasUpscaling(next2, size)) {
                return next2;
            }
        }
        return size;
    }

    @VisibleForTesting
    @NonNull
    public Size getPreferredChildSizeForViewport(@NonNull Size size, @NonNull UseCaseConfig<?> useCaseConfig) {
        for (Size cropRectOfReferenceAspectRatio : getSortedChildSizes(useCaseConfig)) {
            Size rectToSize = TransformUtils.rectToSize(getCropRectOfReferenceAspectRatio(cropRectOfReferenceAspectRatio, size));
            if (!hasUpscaling(rectToSize, size)) {
                return rectToSize;
            }
        }
        return size;
    }

    @NonNull
    public Pair<Rect, Size> getPreferredChildSizePair(@NonNull UseCaseConfig<?> useCaseConfig, @NonNull Rect rect, int i, boolean z) {
        boolean z2;
        if (TransformUtils.is90or270(i)) {
            rect = reverseRect(rect);
            z2 = true;
        } else {
            z2 = false;
        }
        Pair<Rect, Size> preferredChildSizePairInternal = getPreferredChildSizePairInternal(rect, useCaseConfig, z);
        Rect rect2 = (Rect) preferredChildSizePairInternal.first;
        Size size = (Size) preferredChildSizePairInternal.second;
        if (z2) {
            size = TransformUtils.reverseSize(size);
            rect2 = reverseRect(rect2);
        }
        return new Pair<>(rect2, size);
    }

    private ResolutionsMerger(@NonNull Size size, @NonNull CameraInfoInternal cameraInfoInternal, @NonNull Set<UseCaseConfig<?>> set) {
        this(size, cameraInfoInternal, set, new SupportedOutputSizesSorter(cameraInfoInternal, size));
    }

    @VisibleForTesting
    public ResolutionsMerger(@NonNull Size size, @NonNull CameraInfoInternal cameraInfoInternal, @NonNull Set<UseCaseConfig<?>> set, @NonNull SupportedOutputSizesSorter supportedOutputSizesSorter) {
        this.mChildSizesCache = new HashMap();
        this.mSensorSize = size;
        Rational sensorAspectRatio = getSensorAspectRatio(size);
        this.mSensorAspectRatio = sensorAspectRatio;
        this.mFallbackAspectRatio = getFallbackAspectRatio(sensorAspectRatio);
        this.mCameraInfo = cameraInfoInternal;
        this.mChildrenConfigs = set;
        this.mSizeSorter = supportedOutputSizesSorter;
    }

    private boolean isDoubleCropping(@NonNull Size size, @NonNull Size size2) {
        return isDoubleCropping(toRationalWithMod16Considered(size), size2);
    }
}
