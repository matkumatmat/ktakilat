package androidx.camera.camera2.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.List;

public final class GuaranteedConfigurationsUtil {
    private GuaranteedConfigurationsUtil() {
    }

    @NonNull
    public static List<SurfaceCombination> generateSupportedCombinationList(int i, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getLegacySupportedCombinationList());
        if (i == 0 || i == 1 || i == 3) {
            arrayList.addAll(getLimitedSupportedCombinationList());
        }
        if (i == 1 || i == 3) {
            arrayList.addAll(getFullSupportedCombinationList());
        }
        if (z) {
            arrayList.addAll(getRAWSupportedCombinationList());
        }
        if (z2 && i == 0) {
            arrayList.addAll(getBurstSupportedCombinationList());
        }
        if (i == 3) {
            arrayList.addAll(getLevel3SupportedCombinationList());
        }
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> get10BitSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d = e.d(configType, configSize, surfaceCombination, arrayList, surfaceCombination);
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceCombination d2 = e.d(configType2, configSize, d, arrayList, d);
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        d2.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceCombination d3 = e.d(configType3, configSize, d2, arrayList, d2);
        ba.x(configType, configSize2, d3, configType2, configSize);
        SurfaceCombination g = ba.g(arrayList, d3);
        ba.x(configType2, configSize2, g, configType2, configSize);
        SurfaceCombination g2 = ba.g(arrayList, g);
        g2.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        SurfaceCombination d4 = e.d(configType, configSize3, g2, arrayList, g2);
        ba.x(configType, configSize2, d4, configType, configSize3);
        SurfaceCombination d5 = e.d(configType2, configSize3, d4, arrayList, d4);
        ba.x(configType, configSize2, d5, configType, configSize3);
        d5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3));
        arrayList.add(d5);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getBurstSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d = e.d(configType, configSize2, surfaceCombination, arrayList, surfaceCombination);
        d.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceCombination d2 = e.d(configType2, configSize2, d, arrayList, d);
        ba.x(configType2, configSize, d2, configType2, configSize2);
        arrayList.add(d2);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getConcurrentSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        SurfaceCombination d = e.d(configType, configSize, surfaceCombination, arrayList, surfaceCombination);
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceCombination d2 = e.d(configType2, configSize, d, arrayList, d);
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceCombination d3 = e.d(configType3, configSize, d2, arrayList, d2);
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.s720p;
        ba.x(configType, configSize2, d3, configType3, configSize);
        SurfaceCombination g = ba.g(arrayList, d3);
        ba.x(configType2, configSize2, g, configType3, configSize);
        SurfaceCombination g2 = ba.g(arrayList, g);
        ba.x(configType, configSize2, g2, configType, configSize);
        SurfaceCombination g3 = ba.g(arrayList, g2);
        ba.x(configType, configSize2, g3, configType2, configSize);
        SurfaceCombination g4 = ba.g(arrayList, g3);
        ba.x(configType2, configSize2, g4, configType, configSize);
        SurfaceCombination g5 = ba.g(arrayList, g4);
        ba.x(configType2, configSize2, g5, configType2, configSize);
        arrayList.add(g5);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getFullSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d = e.d(configType, configSize2, surfaceCombination, arrayList, surfaceCombination);
        d.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceCombination d2 = e.d(configType2, configSize2, d, arrayList, d);
        ba.x(configType2, configSize, d2, configType2, configSize2);
        SurfaceCombination g = ba.g(arrayList, d2);
        ba.x(configType, configSize, g, configType, configSize);
        SurfaceCombination d3 = e.d(SurfaceConfig.ConfigType.JPEG, configSize2, g, arrayList, g);
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.VGA;
        ba.x(configType2, configSize3, d3, configType, configSize);
        SurfaceCombination d4 = e.d(configType2, configSize2, d3, arrayList, d3);
        ba.x(configType2, configSize3, d4, configType2, configSize);
        d4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        arrayList.add(d4);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getLegacySupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d = e.d(configType, configSize, surfaceCombination, arrayList, surfaceCombination);
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.JPEG;
        SurfaceCombination d2 = e.d(configType2, configSize, d, arrayList, d);
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        SurfaceCombination d3 = e.d(configType3, configSize, d2, arrayList, d2);
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        ba.x(configType, configSize2, d3, configType2, configSize);
        SurfaceCombination g = ba.g(arrayList, d3);
        ba.x(configType3, configSize2, g, configType2, configSize);
        SurfaceCombination g2 = ba.g(arrayList, g);
        ba.x(configType, configSize2, g2, configType, configSize2);
        SurfaceCombination g3 = ba.g(arrayList, g2);
        ba.x(configType, configSize2, g3, configType3, configSize2);
        SurfaceCombination g4 = ba.g(arrayList, g3);
        ba.x(configType, configSize2, g4, configType3, configSize2);
        g4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize));
        arrayList.add(g4);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getLevel3SupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.VGA;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize2));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.RAW;
        SurfaceCombination d = e.d(configType3, configSize3, surfaceCombination, arrayList, surfaceCombination);
        ba.x(configType, configSize, d, configType, configSize2);
        ba.x(SurfaceConfig.ConfigType.JPEG, configSize3, d, configType3, configSize3);
        arrayList.add(d);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getLimitedSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        SurfaceCombination d = e.d(configType, configSize2, surfaceCombination, arrayList, surfaceCombination);
        d.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceCombination d2 = e.d(configType2, configSize2, d, arrayList, d);
        ba.x(configType2, configSize, d2, configType2, configSize2);
        SurfaceCombination g = ba.g(arrayList, d2);
        ba.x(configType, configSize, g, configType, configSize2);
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceCombination d3 = e.d(configType3, configSize2, g, arrayList, g);
        ba.x(configType, configSize, d3, configType2, configSize2);
        SurfaceCombination d4 = e.d(configType3, configSize2, d3, arrayList, d3);
        ba.x(configType2, configSize, d4, configType2, configSize);
        d4.addSurfaceConfig(SurfaceConfig.create(configType3, SurfaceConfig.ConfigSize.MAXIMUM));
        arrayList.add(d4);
        return arrayList;
    }

    @RequiresApi(api = 33)
    @NonNull
    public static List<SurfaceCombination> getPreviewStabilizationSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        SurfaceCombination d = e.d(configType, configSize, surfaceCombination, arrayList, surfaceCombination);
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        SurfaceCombination d2 = e.d(configType2, configSize, d, arrayList, d);
        d2.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d3 = e.d(configType3, configSize2, d2, arrayList, d2);
        ba.x(configType2, configSize, d3, configType3, configSize2);
        SurfaceCombination g = ba.g(arrayList, d3);
        ba.x(configType, configSize, g, configType2, configSize2);
        SurfaceCombination g2 = ba.g(arrayList, g);
        ba.x(configType2, configSize, g2, configType2, configSize2);
        SurfaceCombination g3 = ba.g(arrayList, g2);
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.PREVIEW;
        ba.x(configType, configSize3, g3, configType, configSize);
        SurfaceCombination g4 = ba.g(arrayList, g3);
        ba.x(configType2, configSize3, g4, configType, configSize);
        SurfaceCombination g5 = ba.g(arrayList, g4);
        ba.x(configType, configSize3, g5, configType2, configSize);
        SurfaceCombination g6 = ba.g(arrayList, g5);
        ba.x(configType2, configSize3, g6, configType2, configSize);
        arrayList.add(g6);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getRAWSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.RAW;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d = e.d(configType, configSize, surfaceCombination, arrayList, surfaceCombination);
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        ba.x(configType2, configSize2, d, configType, configSize);
        SurfaceCombination g = ba.g(arrayList, d);
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.YUV;
        ba.x(configType3, configSize2, g, configType, configSize);
        SurfaceCombination g2 = ba.g(arrayList, g);
        ba.x(configType2, configSize2, g2, configType2, configSize2);
        SurfaceCombination d2 = e.d(configType, configSize, g2, arrayList, g2);
        ba.x(configType2, configSize2, d2, configType3, configSize2);
        SurfaceCombination d3 = e.d(configType, configSize, d2, arrayList, d2);
        ba.x(configType3, configSize2, d3, configType3, configSize2);
        SurfaceCombination d4 = e.d(configType, configSize, d3, arrayList, d3);
        d4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.JPEG;
        ba.x(configType4, configSize, d4, configType, configSize);
        SurfaceCombination g3 = ba.g(arrayList, d4);
        ba.x(configType3, configSize2, g3, configType4, configSize);
        g3.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        arrayList.add(g3);
        return arrayList;
    }

    @RequiresApi(api = 33)
    @NonNull
    public static List<SurfaceCombination> getStreamUseCaseSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.s1440p;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize, 4));
        arrayList.add(surfaceCombination);
        SurfaceCombination surfaceCombination2 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.YUV;
        surfaceCombination2.addSurfaceConfig(SurfaceConfig.create(configType2, configSize, 4));
        arrayList.add(surfaceCombination2);
        SurfaceCombination surfaceCombination3 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.RECORD;
        surfaceCombination3.addSurfaceConfig(SurfaceConfig.create(configType, configSize2, 3));
        arrayList.add(surfaceCombination3);
        SurfaceCombination surfaceCombination4 = new SurfaceCombination();
        surfaceCombination4.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2, 3));
        arrayList.add(surfaceCombination4);
        SurfaceCombination surfaceCombination5 = new SurfaceCombination();
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.MAXIMUM;
        surfaceCombination5.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3, 2));
        arrayList.add(surfaceCombination5);
        SurfaceCombination surfaceCombination6 = new SurfaceCombination();
        surfaceCombination6.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3, 2));
        arrayList.add(surfaceCombination6);
        SurfaceCombination surfaceCombination7 = new SurfaceCombination();
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination7.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3, 2));
        arrayList.add(surfaceCombination7);
        SurfaceCombination surfaceCombination8 = new SurfaceCombination();
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination8.addSurfaceConfig(SurfaceConfig.create(configType2, configSize3, 2));
        arrayList.add(surfaceCombination8);
        SurfaceCombination surfaceCombination9 = new SurfaceCombination();
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination9.addSurfaceConfig(SurfaceConfig.create(configType, configSize2, 3));
        arrayList.add(surfaceCombination9);
        SurfaceCombination surfaceCombination10 = new SurfaceCombination();
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination10.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2, 3));
        arrayList.add(surfaceCombination10);
        SurfaceCombination surfaceCombination11 = new SurfaceCombination();
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination11.addSurfaceConfig(SurfaceConfig.create(configType2, configSize4, 1));
        arrayList.add(surfaceCombination11);
        SurfaceCombination surfaceCombination12 = new SurfaceCombination();
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType, configSize2, 3));
        surfaceCombination12.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2, 2));
        arrayList.add(surfaceCombination12);
        SurfaceCombination surfaceCombination13 = new SurfaceCombination();
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2, 3));
        surfaceCombination13.addSurfaceConfig(SurfaceConfig.create(configType3, configSize2, 2));
        arrayList.add(surfaceCombination13);
        SurfaceCombination surfaceCombination14 = new SurfaceCombination();
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.create(configType, configSize4, 1));
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.create(configType2, configSize4, 1));
        surfaceCombination14.addSurfaceConfig(SurfaceConfig.create(configType3, configSize3, 2));
        arrayList.add(surfaceCombination14);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getUltraHdrSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.JPEG_R;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d = e.d(configType, configSize, surfaceCombination, arrayList, surfaceCombination);
        ba.x(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW, d, configType, configSize);
        arrayList.add(d);
        return arrayList;
    }

    @NonNull
    public static List<SurfaceCombination> getUltraHighResolutionSupportedCombinationList() {
        ArrayList arrayList = new ArrayList();
        SurfaceCombination surfaceCombination = new SurfaceCombination();
        SurfaceConfig.ConfigType configType = SurfaceConfig.ConfigType.YUV;
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.ConfigSize.ULTRA_MAXIMUM;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        SurfaceConfig.ConfigType configType2 = SurfaceConfig.ConfigType.PRIV;
        SurfaceConfig.ConfigSize configSize2 = SurfaceConfig.ConfigSize.PREVIEW;
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
        SurfaceConfig.ConfigSize configSize3 = SurfaceConfig.ConfigSize.RECORD;
        SurfaceCombination d = e.d(configType2, configSize3, surfaceCombination, arrayList, surfaceCombination);
        SurfaceConfig.ConfigType configType3 = SurfaceConfig.ConfigType.JPEG;
        ba.x(configType3, configSize, d, configType2, configSize2);
        SurfaceCombination d2 = e.d(configType2, configSize3, d, arrayList, d);
        SurfaceConfig.ConfigType configType4 = SurfaceConfig.ConfigType.RAW;
        ba.x(configType4, configSize, d2, configType2, configSize2);
        SurfaceCombination d3 = e.d(configType2, configSize3, d2, arrayList, d2);
        ba.x(configType, configSize, d3, configType2, configSize2);
        SurfaceConfig.ConfigSize configSize4 = SurfaceConfig.ConfigSize.MAXIMUM;
        SurfaceCombination d4 = e.d(configType3, configSize4, d3, arrayList, d3);
        ba.x(configType3, configSize, d4, configType2, configSize2);
        SurfaceCombination d5 = e.d(configType3, configSize4, d4, arrayList, d4);
        ba.x(configType4, configSize, d5, configType2, configSize2);
        SurfaceCombination d6 = e.d(configType3, configSize4, d5, arrayList, d5);
        ba.x(configType, configSize, d6, configType2, configSize2);
        SurfaceCombination d7 = e.d(configType, configSize4, d6, arrayList, d6);
        ba.x(configType3, configSize, d7, configType2, configSize2);
        SurfaceCombination d8 = e.d(configType, configSize4, d7, arrayList, d7);
        ba.x(configType4, configSize, d8, configType2, configSize2);
        SurfaceCombination d9 = e.d(configType, configSize4, d8, arrayList, d8);
        ba.x(configType, configSize, d9, configType2, configSize2);
        SurfaceCombination d10 = e.d(configType4, configSize4, d9, arrayList, d9);
        ba.x(configType3, configSize, d10, configType2, configSize2);
        SurfaceCombination d11 = e.d(configType4, configSize4, d10, arrayList, d10);
        ba.x(configType4, configSize, d11, configType2, configSize2);
        d11.addSurfaceConfig(SurfaceConfig.create(configType4, configSize4));
        arrayList.add(d11);
        return arrayList;
    }
}
