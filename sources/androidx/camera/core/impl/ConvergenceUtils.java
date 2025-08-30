package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public class ConvergenceUtils {
    private static final Set<CameraCaptureMetaData.AeState> AE_CONVERGED_STATE_SET;
    private static final Set<CameraCaptureMetaData.AeState> AE_TORCH_AS_FLASH_CONVERGED_STATE_SET;
    private static final Set<CameraCaptureMetaData.AfState> AF_CONVERGED_STATE_SET = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AfState.PASSIVE_FOCUSED, CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED));
    private static final Set<CameraCaptureMetaData.AwbState> AWB_CONVERGED_STATE_SET = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AwbState.CONVERGED, CameraCaptureMetaData.AwbState.UNKNOWN));
    private static final String TAG = "ConvergenceUtils";

    static {
        CameraCaptureMetaData.AeState aeState = CameraCaptureMetaData.AeState.CONVERGED;
        CameraCaptureMetaData.AeState aeState2 = CameraCaptureMetaData.AeState.FLASH_REQUIRED;
        CameraCaptureMetaData.AeState aeState3 = CameraCaptureMetaData.AeState.UNKNOWN;
        Set<CameraCaptureMetaData.AeState> unmodifiableSet = Collections.unmodifiableSet(EnumSet.of(aeState, aeState2, aeState3));
        AE_CONVERGED_STATE_SET = unmodifiableSet;
        EnumSet<CameraCaptureMetaData.AeState> copyOf = EnumSet.copyOf(unmodifiableSet);
        copyOf.remove(aeState2);
        copyOf.remove(aeState3);
        AE_TORCH_AS_FLASH_CONVERGED_STATE_SET = Collections.unmodifiableSet(copyOf);
    }

    private ConvergenceUtils() {
    }

    public static boolean is3AConverged(@NonNull CameraCaptureResult cameraCaptureResult, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        if (cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.OFF || cameraCaptureResult.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN || AF_CONVERGED_STATE_SET.contains(cameraCaptureResult.getAfState())) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (cameraCaptureResult.getAeMode() == CameraCaptureMetaData.AeMode.OFF) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z ? z3 || AE_CONVERGED_STATE_SET.contains(cameraCaptureResult.getAeState()) : z3 || AE_TORCH_AS_FLASH_CONVERGED_STATE_SET.contains(cameraCaptureResult.getAeState())) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (cameraCaptureResult.getAwbMode() != CameraCaptureMetaData.AwbMode.OFF && !AWB_CONVERGED_STATE_SET.contains(cameraCaptureResult.getAwbState())) {
            z5 = false;
        } else {
            z5 = true;
        }
        Logger.d(TAG, "checkCaptureResult, AE=" + cameraCaptureResult.getAeState() + " AF =" + cameraCaptureResult.getAfState() + " AWB=" + cameraCaptureResult.getAwbState());
        if (!z2 || !z4 || !z5) {
            return false;
        }
        return true;
    }
}
