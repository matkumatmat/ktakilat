package androidx.camera.video;

import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.internal.utils.SizeUtil;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class QualityRatioToResolutionsTable {
    private static final Map<Integer, Rational> sAspectRatioMap;
    private static final Map<Quality, Range<Integer>> sQualityRangeMap;
    private final Map<QualityRatio, List<Size>> mTable = new HashMap();

    @AutoValue
    public static abstract class QualityRatio {
        public static QualityRatio of(@NonNull Quality quality, int i) {
            return new AutoValue_QualityRatioToResolutionsTable_QualityRatio(quality, i);
        }

        public abstract int getAspectRatio();

        @NonNull
        public abstract Quality getQuality();
    }

    static {
        HashMap hashMap = new HashMap();
        sQualityRangeMap = hashMap;
        hashMap.put(Quality.UHD, Range.create(2160, 4319));
        hashMap.put(Quality.FHD, Range.create(1080, 1439));
        hashMap.put(Quality.HD, Range.create(720, 1079));
        hashMap.put(Quality.SD, Range.create(241, 719));
        HashMap hashMap2 = new HashMap();
        sAspectRatioMap = hashMap2;
        hashMap2.put(0, AspectRatioUtil.ASPECT_RATIO_4_3);
        hashMap2.put(1, AspectRatioUtil.ASPECT_RATIO_16_9);
    }

    public QualityRatioToResolutionsTable(@NonNull List<Size> list, @NonNull Map<Quality, Size> map) {
        for (Quality next : sQualityRangeMap.keySet()) {
            this.mTable.put(QualityRatio.of(next, -1), new ArrayList());
            for (Integer intValue : sAspectRatioMap.keySet()) {
                this.mTable.put(QualityRatio.of(next, intValue.intValue()), new ArrayList());
            }
        }
        addProfileSizesToTable(map);
        addResolutionsToTable(list);
        sortQualityRatioRow(map);
    }

    private void addProfileSizesToTable(@NonNull Map<Quality, Size> map) {
        for (Map.Entry next : map.entrySet()) {
            List<Size> qualityRatioRow = getQualityRatioRow((Quality) next.getKey(), -1);
            Objects.requireNonNull(qualityRatioRow);
            qualityRatioRow.add((Size) next.getValue());
        }
    }

    private void addResolutionsToTable(@NonNull List<Size> list) {
        Integer findMappedAspectRatio;
        for (Size next : list) {
            Quality findMappedQuality = findMappedQuality(next);
            if (!(findMappedQuality == null || (findMappedAspectRatio = findMappedAspectRatio(next)) == null)) {
                List<Size> qualityRatioRow = getQualityRatioRow(findMappedQuality, findMappedAspectRatio.intValue());
                Objects.requireNonNull(qualityRatioRow);
                qualityRatioRow.add(next);
            }
        }
    }

    @Nullable
    private static Integer findMappedAspectRatio(@NonNull Size size) {
        for (Map.Entry next : sAspectRatioMap.entrySet()) {
            if (AspectRatioUtil.hasMatchingAspectRatio(size, (Rational) next.getValue(), SizeUtil.RESOLUTION_QVGA)) {
                return (Integer) next.getKey();
            }
        }
        return null;
    }

    @Nullable
    private static Quality findMappedQuality(@NonNull Size size) {
        for (Map.Entry next : sQualityRangeMap.entrySet()) {
            if (((Range) next.getValue()).contains(Integer.valueOf(size.getHeight()))) {
                return (Quality) next.getKey();
            }
        }
        return null;
    }

    @Nullable
    private List<Size> getQualityRatioRow(@NonNull Quality quality, int i) {
        return this.mTable.get(QualityRatio.of(quality, i));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortQualityRatioRow$0(int i, Size size, Size size2) {
        return Math.abs(SizeUtil.getArea(size) - i) - Math.abs(SizeUtil.getArea(size2) - i);
    }

    private void sortQualityRatioRow(@NonNull Map<Quality, Size> map) {
        for (Map.Entry next : this.mTable.entrySet()) {
            Size size = map.get(((QualityRatio) next.getKey()).getQuality());
            if (size != null) {
                Collections.sort((List) next.getValue(), new a(SizeUtil.getArea(size)));
            }
        }
    }

    @NonNull
    public List<Size> getResolutions(@NonNull Quality quality, int i) {
        ArrayList arrayList;
        List<Size> qualityRatioRow = getQualityRatioRow(quality, i);
        if (qualityRatioRow == null) {
            arrayList = new ArrayList(0);
        }
        return arrayList;
    }
}
