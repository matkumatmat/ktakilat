package androidx.camera.video;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.DynamicRanges;
import androidx.camera.core.impl.EncoderProfilesProvider;
import androidx.camera.video.internal.DynamicRangeMatchedEncoderProfilesProvider;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class RecorderVideoCapabilities implements VideoCapabilities {
    private final Map<DynamicRange, CapabilitiesByQuality> mCapabilitiesMapForFullySpecifiedDynamicRange = new HashMap();
    private final Map<DynamicRange, CapabilitiesByQuality> mCapabilitiesMapForNonFullySpecifiedDynamicRange = new HashMap();
    private final boolean mIsStabilizationSupported;
    private final EncoderProfilesProvider mProfilesProvider;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: androidx.camera.video.internal.workaround.QualityAddedEncoderProfilesProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.camera.video.internal.workaround.QualityAddedEncoderProfilesProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: androidx.camera.video.internal.QualityExploredEncoderProfilesProvider} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: androidx.camera.video.internal.workaround.QualityAddedEncoderProfilesProvider} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RecorderVideoCapabilities(int r10, @androidx.annotation.NonNull androidx.camera.core.impl.CameraInfoInternal r11, @androidx.annotation.NonNull androidx.arch.core.util.Function<androidx.camera.video.internal.encoder.VideoEncoderConfig, androidx.camera.video.internal.encoder.VideoEncoderInfo> r12) {
        /*
            r9 = this;
            r9.<init>()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r9.mCapabilitiesMapForFullySpecifiedDynamicRange = r0
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r9.mCapabilitiesMapForNonFullySpecifiedDynamicRange = r0
            r0 = 1
            if (r10 == 0) goto L_0x0019
            if (r10 != r0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r1 = 0
            goto L_0x001a
        L_0x0019:
            r1 = 1
        L_0x001a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Not a supported video capabilities source: "
            r2.<init>(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            androidx.core.util.Preconditions.checkArgument(r1, r2)
            androidx.camera.core.impl.EncoderProfilesProvider r1 = r11.getEncoderProfilesProvider()
            androidx.camera.core.impl.Quirks r2 = androidx.camera.video.internal.compat.quirk.DeviceQuirks.getAll()
            androidx.camera.video.internal.workaround.QualityAddedEncoderProfilesProvider r4 = new androidx.camera.video.internal.workaround.QualityAddedEncoderProfilesProvider
            r4.<init>(r1, r2, r11, r12)
            if (r10 != r0) goto L_0x0052
            androidx.camera.video.internal.QualityExploredEncoderProfilesProvider r10 = new androidx.camera.video.internal.QualityExploredEncoderProfilesProvider
            java.util.List r5 = androidx.camera.video.Quality.getSortedQualities()
            androidx.camera.core.DynamicRange r0 = androidx.camera.core.DynamicRange.SDR
            java.util.Set r6 = java.util.Collections.singleton(r0)
            r0 = 34
            java.util.List r7 = r11.getSupportedResolutions(r0)
            r3 = r10
            r8 = r12
            r3.<init>(r4, r5, r6, r7, r8)
            r4 = r10
        L_0x0052:
            androidx.camera.video.internal.workaround.QualityResolutionModifiedEncoderProfilesProvider r10 = new androidx.camera.video.internal.workaround.QualityResolutionModifiedEncoderProfilesProvider
            r10.<init>(r4, r2)
            boolean r0 = isHlg10SupportedByCamera(r11)
            if (r0 == 0) goto L_0x0063
            androidx.camera.video.internal.BackupHdrProfileEncoderProfilesProvider r0 = new androidx.camera.video.internal.BackupHdrProfileEncoderProfilesProvider
            r0.<init>(r10, r12)
            r10 = r0
        L_0x0063:
            androidx.camera.video.internal.workaround.QualityValidatedEncoderProfilesProvider r12 = new androidx.camera.video.internal.workaround.QualityValidatedEncoderProfilesProvider
            r12.<init>(r10, r11, r2)
            r9.mProfilesProvider = r12
            java.util.Set r10 = r11.getSupportedDynamicRanges()
            java.util.Iterator r10 = r10.iterator()
        L_0x0072:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x009a
            java.lang.Object r12 = r10.next()
            androidx.camera.core.DynamicRange r12 = (androidx.camera.core.DynamicRange) r12
            androidx.camera.video.internal.DynamicRangeMatchedEncoderProfilesProvider r0 = new androidx.camera.video.internal.DynamicRangeMatchedEncoderProfilesProvider
            androidx.camera.core.impl.EncoderProfilesProvider r1 = r9.mProfilesProvider
            r0.<init>(r1, r12)
            androidx.camera.video.CapabilitiesByQuality r1 = new androidx.camera.video.CapabilitiesByQuality
            r1.<init>(r0)
            java.util.List r0 = r1.getSupportedQualities()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0072
            java.util.Map<androidx.camera.core.DynamicRange, androidx.camera.video.CapabilitiesByQuality> r0 = r9.mCapabilitiesMapForFullySpecifiedDynamicRange
            r0.put(r12, r1)
            goto L_0x0072
        L_0x009a:
            boolean r10 = r11.isVideoStabilizationSupported()
            r9.mIsStabilizationSupported = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.RecorderVideoCapabilities.<init>(int, androidx.camera.core.impl.CameraInfoInternal, androidx.arch.core.util.Function):void");
    }

    @Nullable
    private CapabilitiesByQuality generateCapabilitiesForNonFullySpecifiedDynamicRange(@NonNull DynamicRange dynamicRange) {
        if (!DynamicRanges.canResolve(dynamicRange, getSupportedDynamicRanges())) {
            return null;
        }
        return new CapabilitiesByQuality(new DynamicRangeMatchedEncoderProfilesProvider(this.mProfilesProvider, dynamicRange));
    }

    @Nullable
    private CapabilitiesByQuality getCapabilities(@NonNull DynamicRange dynamicRange) {
        if (dynamicRange.isFullySpecified()) {
            return this.mCapabilitiesMapForFullySpecifiedDynamicRange.get(dynamicRange);
        }
        if (this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.containsKey(dynamicRange)) {
            return this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.get(dynamicRange);
        }
        CapabilitiesByQuality generateCapabilitiesForNonFullySpecifiedDynamicRange = generateCapabilitiesForNonFullySpecifiedDynamicRange(dynamicRange);
        this.mCapabilitiesMapForNonFullySpecifiedDynamicRange.put(dynamicRange, generateCapabilitiesForNonFullySpecifiedDynamicRange);
        return generateCapabilitiesForNonFullySpecifiedDynamicRange;
    }

    private static boolean isHlg10SupportedByCamera(@NonNull CameraInfoInternal cameraInfoInternal) {
        for (DynamicRange next : cameraInfoInternal.getSupportedDynamicRanges()) {
            Integer valueOf = Integer.valueOf(next.getEncoding());
            int bitDepth = next.getBitDepth();
            if (valueOf.equals(3) && bitDepth == 10) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public VideoValidatedEncoderProfilesProxy findNearestHigherSupportedEncoderProfilesFor(@NonNull Size size, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities == null) {
            return null;
        }
        return capabilities.findNearestHigherSupportedEncoderProfilesFor(size);
    }

    @NonNull
    public Quality findNearestHigherSupportedQualityFor(@NonNull Size size, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities == null) {
            return Quality.NONE;
        }
        return capabilities.findNearestHigherSupportedQualityFor(size);
    }

    @Nullable
    public VideoValidatedEncoderProfilesProxy getProfiles(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities == null) {
            return null;
        }
        return capabilities.getProfiles(quality);
    }

    @NonNull
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return this.mCapabilitiesMapForFullySpecifiedDynamicRange.keySet();
    }

    @NonNull
    public List<Quality> getSupportedQualities(@NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities == null) {
            return new ArrayList();
        }
        return capabilities.getSupportedQualities();
    }

    public boolean isQualitySupported(@NonNull Quality quality, @NonNull DynamicRange dynamicRange) {
        CapabilitiesByQuality capabilities = getCapabilities(dynamicRange);
        if (capabilities == null || !capabilities.isQualitySupported(quality)) {
            return false;
        }
        return true;
    }

    public boolean isStabilizationSupported() {
        return this.mIsStabilizationSupported;
    }
}
