package androidx.camera.core;

import android.util.Range;
import android.util.Rational;
import androidx.annotation.NonNull;

public interface ExposureState {
    int getExposureCompensationIndex();

    @NonNull
    Range<Integer> getExposureCompensationRange();

    @NonNull
    Rational getExposureCompensationStep();

    boolean isExposureCompensationSupported();
}
