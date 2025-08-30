package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.DynamicRangeProfiles;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.core.DynamicRange;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RequiresApi(33)
class DynamicRangesCompatApi33Impl implements DynamicRangesCompat.DynamicRangeProfilesCompatImpl {
    private final DynamicRangeProfiles mDynamicRangeProfiles;

    public DynamicRangesCompatApi33Impl(@NonNull Object obj) {
        this.mDynamicRangeProfiles = (DynamicRangeProfiles) obj;
    }

    @Nullable
    private Long dynamicRangeToFirstSupportedProfile(@NonNull DynamicRange dynamicRange) {
        return DynamicRangeConversions.dynamicRangeToFirstSupportedProfile(dynamicRange, this.mDynamicRangeProfiles);
    }

    @NonNull
    private static Set<DynamicRange> profileSetToDynamicRangeSet(@NonNull Set<Long> set) {
        if (set.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(set.size());
        for (Long longValue : set) {
            hashSet.add(profileToDynamicRange(longValue.longValue()));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    private static DynamicRange profileToDynamicRange(long j) {
        DynamicRange profileToDynamicRange = DynamicRangeConversions.profileToDynamicRange(j);
        return (DynamicRange) Preconditions.checkNotNull(profileToDynamicRange, "Dynamic range profile cannot be converted to a DynamicRange object: " + j);
    }

    @NonNull
    public Set<DynamicRange> getDynamicRangeCaptureRequestConstraints(@NonNull DynamicRange dynamicRange) {
        boolean z;
        Long dynamicRangeToFirstSupportedProfile = dynamicRangeToFirstSupportedProfile(dynamicRange);
        if (dynamicRangeToFirstSupportedProfile != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "DynamicRange is not supported: " + dynamicRange);
        return profileSetToDynamicRangeSet(this.mDynamicRangeProfiles.getProfileCaptureRequestConstraints(dynamicRangeToFirstSupportedProfile.longValue()));
    }

    @NonNull
    public Set<DynamicRange> getSupportedDynamicRanges() {
        return profileSetToDynamicRangeSet(this.mDynamicRangeProfiles.getSupportedProfiles());
    }

    public boolean isExtraLatencyPresent(@NonNull DynamicRange dynamicRange) {
        boolean z;
        Long dynamicRangeToFirstSupportedProfile = dynamicRangeToFirstSupportedProfile(dynamicRange);
        if (dynamicRangeToFirstSupportedProfile != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "DynamicRange is not supported: " + dynamicRange);
        return this.mDynamicRangeProfiles.isExtraLatencyPresent(dynamicRangeToFirstSupportedProfile.longValue());
    }

    @Nullable
    public DynamicRangeProfiles unwrap() {
        return this.mDynamicRangeProfiles;
    }
}
