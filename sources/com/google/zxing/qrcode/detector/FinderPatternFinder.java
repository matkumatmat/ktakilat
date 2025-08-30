package com.google.zxing.qrcode.detector;

import java.io.Serializable;
import java.util.Comparator;

public class FinderPatternFinder {

    public static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        public final int compare(Object obj, Object obj2) {
            ((FinderPattern) obj2).getClass();
            ((FinderPattern) obj).getClass();
            float abs = Math.abs(0.0f);
            float abs2 = Math.abs(0.0f);
            if (abs < abs2) {
                return 1;
            }
            if (abs == abs2) {
                return 0;
            }
            return -1;
        }
    }

    public static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        public final int compare(Object obj, Object obj2) {
            ((FinderPattern) obj2).getClass();
            float abs = Math.abs(0.0f);
            ((FinderPattern) obj).getClass();
            float abs2 = Math.abs(0.0f);
            if (abs < abs2) {
                return -1;
            }
            if (abs == abs2) {
                return 0;
            }
            return 1;
        }
    }
}
