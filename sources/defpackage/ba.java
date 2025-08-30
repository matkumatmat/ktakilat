package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.recyclerview.widget.RecyclerView;
import coil3.size.Dimension;
import coil3.size.RealViewSizeResolver;
import coil3.size.Size;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzh;
import com.google.android.gms.internal.measurement.zzll;
import com.ktakilat.cbase.datacollect.DataCollectManager;
import java.util.ArrayList;
import java.util.List;
import okio.Path;

/* renamed from: ba  reason: default package */
public abstract /* synthetic */ class ba {
    public static void A(String str, String str2, String str3, String str4, String str5) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        bundle.putString(str3, str4);
        DataCollectManager.b(str5, bundle);
    }

    public static Dimension a(int i, int i2, int i3) {
        if (i == -2) {
            return Dimension.Undefined.f149a;
        }
        int i4 = i - i3;
        if (i4 <= 0) {
            int i5 = i2 - i3;
            if (i5 <= 0) {
                return null;
            }
            if (i5 > 0) {
                return new Dimension.Pixels(i5);
            }
            throw new IllegalArgumentException("px must be > 0.");
        } else if (i4 > 0) {
            return new Dimension.Pixels(i4);
        } else {
            throw new IllegalArgumentException("px must be > 0.");
        }
    }

    public static Size b(RealViewSizeResolver realViewSizeResolver) {
        int i;
        int i2;
        View view = realViewSizeResolver.b;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int i3 = -1;
        if (layoutParams != null) {
            i = layoutParams.width;
        } else {
            i = -1;
        }
        int width = view.getWidth();
        boolean z = realViewSizeResolver.c;
        int i4 = 0;
        if (z) {
            i2 = view.getPaddingRight() + view.getPaddingLeft();
        } else {
            i2 = 0;
        }
        Dimension a2 = a(i, width, i2);
        if (a2 == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            i3 = layoutParams2.height;
        }
        int height = view.getHeight();
        if (z) {
            i4 = view.getPaddingBottom() + view.getPaddingTop();
        }
        Dimension a3 = a(i3, height, i4);
        if (a3 == null) {
            return null;
        }
        return new Size(a2, a3);
    }

    public static int c(int i, int i2, int i3) {
        return zzll.zzz(i) + i2 + i3;
    }

    public static int d(int i, int i2, String str) {
        return (str.hashCode() + i) * i2;
    }

    public static int e(int i, String str) {
        return String.valueOf(str).length() + i;
    }

    public static Bundle f(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        bundle.putString(str3, str4);
        return bundle;
    }

    public static SurfaceCombination g(ArrayList arrayList, SurfaceCombination surfaceCombination) {
        arrayList.add(surfaceCombination);
        return new SurfaceCombination();
    }

    public static IObjectWrapper h(Parcel parcel) {
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
        parcel.recycle();
        return asInterface;
    }

    public static Object i(zzbk zzbk, int i, List list, int i2) {
        zzh.zza(zzbk.name(), i, list);
        return list.get(i2);
    }

    public static String j(int i, int i2, String str) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static String k(int i, String str) {
        return str + i;
    }

    public static String l(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String m(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String n(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static String o(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String p(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String q(StringBuilder sb, String str, int i) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String r(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String s(Path path, String str) {
        return str + path;
    }

    public static StringBuilder t(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder u(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static StringBuilder v(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static /* bridge */ /* synthetic */ void w() {
        throw null;
    }

    public static void x(SurfaceConfig.ConfigType configType, SurfaceConfig.ConfigSize configSize, SurfaceCombination surfaceCombination, SurfaceConfig.ConfigType configType2, SurfaceConfig.ConfigSize configSize2) {
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType, configSize));
        surfaceCombination.addSurfaceConfig(SurfaceConfig.create(configType2, configSize2));
    }

    public static void y(String str) {
        DataCollectManager.b(str, new Bundle());
    }

    public static void z(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        DataCollectManager.b(str3, bundle);
    }
}
