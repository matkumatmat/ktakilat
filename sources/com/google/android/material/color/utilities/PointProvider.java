package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface PointProvider {
    double distance(double[] dArr, double[] dArr2);

    double[] fromInt(int i);

    int toInt(double[] dArr);
}
