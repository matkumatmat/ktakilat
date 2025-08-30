package com.google.zxing.datamatrix.detector;

import java.io.Serializable;
import java.util.Comparator;

public final class Detector {

    public static final class ResultPointsAndTransitions {
        public final String toString() {
            return "null/null/0";
        }
    }

    public static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        public final int compare(Object obj, Object obj2) {
            ((ResultPointsAndTransitions) obj).getClass();
            ((ResultPointsAndTransitions) obj2).getClass();
            return 0;
        }
    }
}
