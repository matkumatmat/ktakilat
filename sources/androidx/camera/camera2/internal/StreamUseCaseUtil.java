package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.SupportedSurfaceCombination;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class StreamUseCaseUtil {
    public static final Config.Option<Long> STREAM_USE_CASE_STREAM_SPEC_OPTION = Config.Option.create("camera2.streamSpec.streamUseCase", Long.TYPE);
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
    private static final Map<Long, Set<UseCaseConfigFactory.CaptureType>> STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
    private static final String TAG = "StreamUseCaseUtil";

    static {
        HashMap hashMap = new HashMap();
        STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP = hashMap;
        HashMap hashMap2 = new HashMap();
        STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP = hashMap2;
        if (Build.VERSION.SDK_INT >= 33) {
            HashSet hashSet = new HashSet();
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.PREVIEW;
            hashSet.add(captureType);
            UseCaseConfigFactory.CaptureType captureType2 = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
            hashSet.add(captureType2);
            hashMap.put(4L, hashSet);
            HashSet hashSet2 = new HashSet();
            hashSet2.add(captureType);
            hashSet2.add(captureType2);
            hashSet2.add(UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS);
            hashMap.put(1L, hashSet2);
            HashSet hashSet3 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType3 = UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE;
            hashSet3.add(captureType3);
            hashMap.put(2L, hashSet3);
            HashSet hashSet4 = new HashSet();
            UseCaseConfigFactory.CaptureType captureType4 = UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE;
            hashSet4.add(captureType4);
            hashMap.put(3L, hashSet4);
            HashSet hashSet5 = new HashSet();
            hashSet5.add(captureType);
            hashSet5.add(captureType3);
            hashSet5.add(captureType4);
            hashMap2.put(4L, hashSet5);
            HashSet hashSet6 = new HashSet();
            hashSet6.add(captureType);
            hashSet6.add(captureType4);
            hashMap2.put(3L, hashSet6);
        }
    }

    private StreamUseCaseUtil() {
    }

    public static boolean areCaptureTypesEligible(@NonNull Map<Integer, AttachedSurfaceInfo> map, @NonNull Map<Integer, UseCaseConfig<?>> map2, @NonNull List<SurfaceConfig> list) {
        List<UseCaseConfigFactory.CaptureType> list2;
        UseCaseConfigFactory.CaptureType captureType;
        for (int i = 0; i < list.size(); i++) {
            long streamUseCase = list.get(i).getStreamUseCase();
            if (map.containsKey(Integer.valueOf(i))) {
                AttachedSurfaceInfo attachedSurfaceInfo = map.get(Integer.valueOf(i));
                if (attachedSurfaceInfo.getCaptureTypes().size() == 1) {
                    captureType = attachedSurfaceInfo.getCaptureTypes().get(0);
                } else {
                    captureType = UseCaseConfigFactory.CaptureType.STREAM_SHARING;
                }
                if (!isEligibleCaptureType(captureType, streamUseCase, attachedSurfaceInfo.getCaptureTypes())) {
                    return false;
                }
            } else if (map2.containsKey(Integer.valueOf(i))) {
                UseCaseConfig useCaseConfig = map2.get(Integer.valueOf(i));
                UseCaseConfigFactory.CaptureType captureType2 = useCaseConfig.getCaptureType();
                if (useCaseConfig.getCaptureType() == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
                    list2 = ((StreamSharingConfig) useCaseConfig).getCaptureTypes();
                } else {
                    list2 = Collections.emptyList();
                }
                if (!isEligibleCaptureType(captureType2, streamUseCase, list2)) {
                    return false;
                }
            } else {
                throw new AssertionError("SurfaceConfig does not map to any use case");
            }
        }
        return true;
    }

    private static boolean areStreamUseCasesAvailable(Set<Long> set, Set<Long> set2) {
        for (Long contains : set2) {
            if (!set.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public static boolean areStreamUseCasesAvailableForSurfaceConfigs(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull List<SurfaceConfig> list) {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) {
            return false;
        }
        HashSet hashSet = new HashSet();
        for (long valueOf : jArr) {
            hashSet.add(Long.valueOf(valueOf));
        }
        for (SurfaceConfig streamUseCase : list) {
            if (!hashSet.contains(Long.valueOf(streamUseCase.getStreamUseCase()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsZslUseCase(@NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2) {
        for (AttachedSurfaceInfo next : list) {
            if (isZslUseCase(next.getImplementationOptions(), next.getCaptureTypes().get(0))) {
                return true;
            }
        }
        for (UseCaseConfig next2 : list2) {
            if (isZslUseCase(next2, next2.getCaptureType())) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static Camera2ImplConfig getStreamSpecImplementationOptions(@NonNull UseCaseConfig<?> useCaseConfig) {
        MutableOptionsBundle create = MutableOptionsBundle.create();
        Config.Option<Long> option = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
        if (useCaseConfig.containsOption(option)) {
            create.insertOption(option, (Long) useCaseConfig.retrieveOption(option));
        }
        Config.Option<Boolean> option2 = UseCaseConfig.OPTION_ZSL_DISABLED;
        if (useCaseConfig.containsOption(option2)) {
            create.insertOption(option2, (Boolean) useCaseConfig.retrieveOption(option2));
        }
        Config.Option<Integer> option3 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (useCaseConfig.containsOption(option3)) {
            create.insertOption(option3, (Integer) useCaseConfig.retrieveOption(option3));
        }
        Config.Option<Integer> option4 = ImageInputConfig.OPTION_INPUT_FORMAT;
        if (useCaseConfig.containsOption(option4)) {
            create.insertOption(option4, (Integer) useCaseConfig.retrieveOption(option4));
        }
        return new Camera2ImplConfig(create);
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    @Nullable
    private static Config getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(Config config, long j) {
        Config.Option<Long> option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (config.containsOption(option) && ((Long) config.retrieveOption(option)).longValue() == j) {
            return null;
        }
        MutableOptionsBundle from = MutableOptionsBundle.from(config);
        from.insertOption(option, Long.valueOf(j));
        return new Camera2ImplConfig(from);
    }

    private static boolean isEligibleCaptureType(UseCaseConfigFactory.CaptureType captureType, long j, List<UseCaseConfigFactory.CaptureType> list) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        if (captureType == UseCaseConfigFactory.CaptureType.STREAM_SHARING) {
            Map<Long, Set<UseCaseConfigFactory.CaptureType>> map = STREAM_USE_CASE_TO_ELIGIBLE_STREAM_SHARING_CHILDREN_TYPES_MAP;
            if (!map.containsKey(Long.valueOf(j))) {
                return false;
            }
            Set set = map.get(Long.valueOf(j));
            if (list.size() != set.size()) {
                return false;
            }
            for (UseCaseConfigFactory.CaptureType contains : list) {
                if (!set.contains(contains)) {
                    return false;
                }
            }
            return true;
        }
        Map<Long, Set<UseCaseConfigFactory.CaptureType>> map2 = STREAM_USE_CASE_TO_ELIGIBLE_CAPTURE_TYPES_MAP;
        if (!map2.containsKey(Long.valueOf(j)) || !map2.get(Long.valueOf(j)).contains(captureType)) {
            return false;
        }
        return true;
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static boolean isStreamUseCaseSupported(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        long[] jArr;
        if (Build.VERSION.SDK_INT < 33 || (jArr = (long[]) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0086 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @androidx.annotation.OptIn(markerClass = {androidx.camera.camera2.interop.ExperimentalCamera2Interop.class})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isValidCamera2InteropOverride(java.util.List<androidx.camera.core.impl.AttachedSurfaceInfo> r10, java.util.List<androidx.camera.core.impl.UseCaseConfig<?>> r11, java.util.Set<java.lang.Long> r12) {
        /*
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            java.util.Iterator r10 = r10.iterator()
            boolean r1 = r10.hasNext()
            r2 = 0
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x003e
            java.lang.Object r10 = r10.next()
            androidx.camera.core.impl.AttachedSurfaceInfo r10 = (androidx.camera.core.impl.AttachedSurfaceInfo) r10
            androidx.camera.core.impl.Config r1 = r10.getImplementationOptions()
            androidx.camera.core.impl.Config$Option<java.lang.Long> r6 = androidx.camera.camera2.impl.Camera2ImplConfig.STREAM_USE_CASE_OPTION
            boolean r1 = r1.containsOption(r6)
            if (r1 != 0) goto L_0x0028
        L_0x0025:
            r10 = 0
            r1 = 1
            goto L_0x0040
        L_0x0028:
            androidx.camera.core.impl.Config r10 = r10.getImplementationOptions()
            java.lang.Object r10 = r10.retrieveOption(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r6 = r10.longValue()
            int r10 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r10 != 0) goto L_0x003b
            goto L_0x0025
        L_0x003b:
            r10 = 1
        L_0x003c:
            r1 = 0
            goto L_0x0040
        L_0x003e:
            r10 = 0
            goto L_0x003c
        L_0x0040:
            java.util.Iterator r11 = r11.iterator()
        L_0x0044:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L_0x007d
            java.lang.Object r6 = r11.next()
            androidx.camera.core.impl.UseCaseConfig r6 = (androidx.camera.core.impl.UseCaseConfig) r6
            androidx.camera.core.impl.Config$Option<java.lang.Long> r7 = androidx.camera.camera2.impl.Camera2ImplConfig.STREAM_USE_CASE_OPTION
            boolean r8 = r6.containsOption(r7)
            if (r8 != 0) goto L_0x005f
            if (r10 == 0) goto L_0x005d
            throwInvalidCamera2InteropOverrideException()
        L_0x005d:
            r1 = 1
            goto L_0x0044
        L_0x005f:
            java.lang.Object r6 = r6.retrieveOption(r7)
            java.lang.Long r6 = (java.lang.Long) r6
            long r7 = r6.longValue()
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 != 0) goto L_0x0073
            if (r10 == 0) goto L_0x005d
            throwInvalidCamera2InteropOverrideException()
            goto L_0x005d
        L_0x0073:
            if (r1 == 0) goto L_0x0078
            throwInvalidCamera2InteropOverrideException()
        L_0x0078:
            r0.add(r6)
            r10 = 1
            goto L_0x0044
        L_0x007d:
            if (r1 != 0) goto L_0x0086
            boolean r10 = areStreamUseCasesAvailable(r12, r0)
            if (r10 == 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r4 = 0
        L_0x0087:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.StreamUseCaseUtil.isValidCamera2InteropOverride(java.util.List, java.util.List, java.util.Set):boolean");
    }

    private static boolean isZslUseCase(Config config, UseCaseConfigFactory.CaptureType captureType) {
        if (((Boolean) config.retrieveOption(UseCaseConfig.OPTION_ZSL_DISABLED, Boolean.FALSE)).booleanValue()) {
            return false;
        }
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
        if (config.containsOption(option) && TemplateTypeUtil.getSessionConfigTemplateType(captureType, ((Integer) config.retrieveOption(option)).intValue()) == 5) {
            return true;
        }
        return false;
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static boolean populateStreamUseCaseStreamSpecOptionWithInteropOverride(@NonNull CameraCharacteristicsCompat cameraCharacteristicsCompat, @NonNull List<AttachedSurfaceInfo> list, @NonNull Map<UseCaseConfig<?>, StreamSpec> map, @NonNull Map<AttachedSurfaceInfo, StreamSpec> map2) {
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        for (AttachedSurfaceInfo implementationOptions : list) {
            Preconditions.checkNotNull(implementationOptions.getImplementationOptions());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Preconditions.checkNotNull(((StreamSpec) Preconditions.checkNotNull(map.get((UseCaseConfig) it.next()))).getImplementationOptions());
        }
        long[] jArr = (long[]) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
        if (!(jArr == null || jArr.length == 0)) {
            HashSet hashSet = new HashSet();
            for (long valueOf : jArr) {
                hashSet.add(Long.valueOf(valueOf));
            }
            if (isValidCamera2InteropOverride(list, arrayList, hashSet)) {
                for (AttachedSurfaceInfo next : list) {
                    Config implementationOptions2 = next.getImplementationOptions();
                    Config updatedImplementationOptionsWithUseCaseStreamSpecOption = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions2, ((Long) implementationOptions2.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                        map2.put(next, next.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    UseCaseConfig useCaseConfig = (UseCaseConfig) it2.next();
                    StreamSpec streamSpec = map.get(useCaseConfig);
                    Config implementationOptions3 = streamSpec.getImplementationOptions();
                    Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(implementationOptions3, ((Long) implementationOptions3.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                        map.put(useCaseConfig, streamSpec.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build());
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void populateStreamUseCaseStreamSpecOptionWithSupportedSurfaceConfigs(@NonNull Map<UseCaseConfig<?>, StreamSpec> map, @NonNull Map<AttachedSurfaceInfo, StreamSpec> map2, @NonNull Map<Integer, AttachedSurfaceInfo> map3, @NonNull Map<Integer, UseCaseConfig<?>> map4, @NonNull List<SurfaceConfig> list) {
        for (int i = 0; i < list.size(); i++) {
            long streamUseCase = list.get(i).getStreamUseCase();
            if (map3.containsKey(Integer.valueOf(i))) {
                AttachedSurfaceInfo attachedSurfaceInfo = map3.get(Integer.valueOf(i));
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(attachedSurfaceInfo.getImplementationOptions(), streamUseCase);
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                    map2.put(attachedSurfaceInfo, attachedSurfaceInfo.toStreamSpec(updatedImplementationOptionsWithUseCaseStreamSpecOption));
                }
            } else if (map4.containsKey(Integer.valueOf(i))) {
                UseCaseConfig useCaseConfig = map4.get(Integer.valueOf(i));
                StreamSpec streamSpec = map.get(useCaseConfig);
                Config updatedImplementationOptionsWithUseCaseStreamSpecOption2 = getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(streamSpec.getImplementationOptions(), streamUseCase);
                if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                    map.put(useCaseConfig, streamSpec.toBuilder().setImplementationOptions(updatedImplementationOptionsWithUseCaseStreamSpecOption2).build());
                }
            } else {
                throw new AssertionError("SurfaceConfig does not map to any use case");
            }
        }
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public static void populateSurfaceToStreamUseCaseMapping(@NonNull Collection<SessionConfig> collection, @NonNull Collection<UseCaseConfig<?>> collection2, @NonNull Map<DeferrableSurface, Long> map) {
        ArrayList arrayList = new ArrayList(collection2);
        for (SessionConfig next : collection) {
            Config implementationOptions = next.getImplementationOptions();
            Config.Option<Long> option = STREAM_USE_CASE_STREAM_SPEC_OPTION;
            if (implementationOptions.containsOption(option) && next.getSurfaces().size() != 1) {
                Logger.e(TAG, String.format("SessionConfig has stream use case but also contains %d surfaces, abort populateSurfaceToStreamUseCaseMapping().", new Object[]{Integer.valueOf(next.getSurfaces().size())}));
                return;
            } else if (next.getImplementationOptions().containsOption(option)) {
                int i = 0;
                for (SessionConfig next2 : collection) {
                    if (((UseCaseConfig) arrayList.get(i)).getCaptureType() == UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                        Preconditions.checkState(!next2.getSurfaces().isEmpty(), "MeteringRepeating should contain a surface");
                        map.put(next2.getSurfaces().get(0), 1L);
                    } else {
                        Config implementationOptions2 = next2.getImplementationOptions();
                        Config.Option<Long> option2 = STREAM_USE_CASE_STREAM_SPEC_OPTION;
                        if (implementationOptions2.containsOption(option2) && !next2.getSurfaces().isEmpty()) {
                            map.put(next2.getSurfaces().get(0), (Long) next2.getImplementationOptions().retrieveOption(option2));
                        }
                    }
                    i++;
                }
                return;
            }
        }
    }

    public static boolean shouldUseStreamUseCase(@NonNull SupportedSurfaceCombination.FeatureSettings featureSettings) {
        if (featureSettings.getCameraMode() == 0 && featureSettings.getRequiredMaxBitDepth() == 8) {
            return true;
        }
        return false;
    }

    private static void throwInvalidCamera2InteropOverrideException() {
        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
    }
}
