package coil3.util;

import android.os.Build;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HardwareBitmapsKt {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f156a;

    static {
        String str;
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i == 26) {
            String str2 = Build.MODEL;
            if (str2 != null) {
                if (StringsKt.I(StringsKt.z(str2, "SAMSUNG-"), "SM-", false)) {
                    z = true;
                } else {
                    String str3 = Build.DEVICE;
                    if (str3 != null) {
                        z = ArraysKt.h(new String[]{"nora", "nora_8917", "nora_8917_n", "james", "rjames_f", "rjames_go", "pettyl", "hannah", "ahannah", "rhannah", "ali", "ali_n", "aljeter", "aljeter_n", "jeter", "evert", "evert_n", "evert_nt", "G3112", "G3116", "G3121", "G3123", "G3125", "G3412", "G3416", "G3421", "G3423", "G3426", "G3212", "G3221", "G3223", "G3226", "BV6800Pro", "CatS41", "Hi9Pro", "manning", "N5702L"}, str3);
                    }
                }
            }
        } else if (i == 27 && (str = Build.DEVICE) != null) {
            z = ArraysKt.h(new String[]{"mcv1s", "mcv3", "mcv5a", "mcv7a", "A30ATMO", "A70AXLTMO", "A3A_8_4G_TMO", "Edison_CKT", "EDISON_TF", "FERMI_TF", "U50A_ATT", "U50A_PLUS_ATT", "U50A_PLUS_TF", "U50APLUSTMO", "U5A_PLUS_4G", "RCT6513W87DK5e", "RCT6873W42BMF9A", "RCT6A03W13", "RCT6B03W12", "RCT6B03W13", "RCT6T06E13", "A3_Pro", "One", "One_Max", "One_Pro", "Z2", "Z2_PRO", "Armor_3", "Armor_6", "Blackview", "BV9500", "BV9500Pro", "A6L-C", "N5002LA", "N5501LA", "Power_2_Pro", "Power_5", "Z9", "V0310WW", "V0330WW", "A3", "ASUS_X018_4", "C210AE", "fireball", "ILA_X1", "Infinix-X605_sprout", "j7maxlte", "KING_KONG_3", "M10500", "S70", "S80Lite", "SGINO6", "st18c10bnn", "TECNO-CA8", "SHIFT6m"}, str);
        }
        f156a = z;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [coil3.util.HardwareBitmapService, java.lang.Object] */
    public static final HardwareBitmapService a() {
        int i = Build.VERSION.SDK_INT;
        if (i < 26 || f156a) {
            return new ImmutableHardwareBitmapService(false);
        }
        if (i == 26 || i == 27) {
            return new Object();
        }
        return new ImmutableHardwareBitmapService(true);
    }
}
