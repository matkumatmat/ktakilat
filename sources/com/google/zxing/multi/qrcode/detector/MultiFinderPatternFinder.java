package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import java.io.Serializable;
import java.util.Comparator;

final class MultiFinderPatternFinder extends FinderPatternFinder {

    public static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
        public final int compare(Object obj, Object obj2) {
            ((FinderPattern) obj2).getClass();
            ((FinderPattern) obj).getClass();
            double d = (double) 0.0f;
            if (d < 0.0d) {
                return -1;
            }
            if (d > 0.0d) {
                return 1;
            }
            return 0;
        }
    }
}
