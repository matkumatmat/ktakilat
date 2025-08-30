package androidx.constraintlayout.core.motion.utils;

public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double eps;
    double mS;
    double mT;

    public Schlick(String str) {
        this.str = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.mS = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    private double dfunc(double d) {
        double d2 = this.mT;
        if (d < d2) {
            double d3 = this.mS;
            return ((d3 * d2) * d2) / ((((d2 - d) * d3) + d) * (((d2 - d) * d3) + d));
        }
        double d4 = this.mS;
        double d5 = d2 - d;
        return ((d2 - 1.0d) * ((d2 - 1.0d) * d4)) / (((((d2 - d) * (-d4)) - d) + 1.0d) * (((d5 * (-d4)) - d) + 1.0d));
    }

    private double func(double d) {
        double d2 = this.mT;
        if (d < d2) {
            return (d2 * d) / (((d2 - d) * this.mS) + d);
        }
        return ((d - 1.0d) * (1.0d - d2)) / ((1.0d - d) - ((d2 - d) * this.mS));
    }

    public double get(double d) {
        return func(d);
    }

    public double getDiff(double d) {
        return dfunc(d);
    }
}
