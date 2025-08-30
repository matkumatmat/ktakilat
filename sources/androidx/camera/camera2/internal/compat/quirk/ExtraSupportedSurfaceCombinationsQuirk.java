package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import com.facebook.appevents.AppEventsConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ExtraSupportedSurfaceCombinationsQuirk implements Quirk {
    private static final SurfaceCombination FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION = createFullYuvPrivYuvConfiguration();
    private static final SurfaceCombination LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION = createLevel3PrivPrivYuvSubsetConfiguration();
    private static final Set<String> SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS = new HashSet(Arrays.asList(new String[]{"PIXEL 6", "PIXEL 6 PRO", "PIXEL 7", "PIXEL 7 PRO", "PIXEL 8", "PIXEL 8 PRO"}));
    private static final Set<String> SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS = new HashSet(Arrays.asList(new String[]{"SM-S921", "SC-51E", "SCG25", "SM-S926", "SM-S928", "SC-52E", "SCG26"}));
    private static final String TAG = "ExtraSupportedSurfaceCombinationsQuirk";

    @NonNull
    private static SurfaceCombination createFullYuvPrivYuvConfiguration() {
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.VGA));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.MAXIMUM));
        return surfaceCombination;
    }

    private static SurfaceCombination createLevel3PrivPrivYuvSubsetConfiguration() {
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.PREVIEW));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, SurfaceConfig.ConfigSize.VGA));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
        return surfaceCombination;
    }

    @NonNull
    private List<SurfaceCombination> getSamsungS7ExtraCombinations(@NonNull String str) {
        ArrayList arrayList = new ArrayList();
        if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            arrayList.add(FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION);
        }
        return arrayList;
    }

    private static boolean isSamsungS7() {
        String str = Build.DEVICE;
        if ("heroqltevzw".equalsIgnoreCase(str) || "heroqltetmo".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public static boolean load() {
        if (isSamsungS7() || supportExtraLevel3ConfigurationsGoogleDevice() || supportExtraLevel3ConfigurationsSamsungDevice()) {
            return true;
        }
        return false;
    }

    private static boolean supportExtraLevel3ConfigurationsGoogleDevice() {
        if (!"google".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        return SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US));
    }

    private static boolean supportExtraLevel3ConfigurationsSamsungDevice() {
        if (!"samsung".equalsIgnoreCase(Build.BRAND)) {
            return false;
        }
        String upperCase = Build.MODEL.toUpperCase(Locale.US);
        for (String startsWith : SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_SAMSUNG_MODELS) {
            if (upperCase.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    public List<SurfaceCombination> getExtraSupportedSurfaceCombinations(@NonNull String str) {
        if (isSamsungS7()) {
            return getSamsungS7ExtraCombinations(str);
        }
        if (supportExtraLevel3ConfigurationsGoogleDevice() || supportExtraLevel3ConfigurationsSamsungDevice()) {
            return Collections.singletonList(LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION);
        }
        return Collections.emptyList();
    }
}
