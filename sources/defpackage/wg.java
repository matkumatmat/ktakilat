package defpackage;

import android.content.Context;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.camera.extensions.internal.Version;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: wg  reason: default package */
public abstract /* synthetic */ class wg {
    public static SessionProcessor a(VendorExtender vendorExtender, Context context) {
        return null;
    }

    public static Range b(VendorExtender vendorExtender, Size size) {
        return null;
    }

    public static List c(VendorExtender vendorExtender) {
        return Collections.emptyList();
    }

    public static List d(VendorExtender vendorExtender) {
        return Collections.emptyList();
    }

    public static Map e(VendorExtender vendorExtender, Size size) {
        return Collections.emptyMap();
    }

    public static List f(VendorExtender vendorExtender) {
        return Collections.emptyList();
    }

    public static Size[] g(VendorExtender vendorExtender) {
        return new Size[0];
    }

    public static boolean i(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean j(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean k(VendorExtender vendorExtender, String str, Map map) {
        return false;
    }

    public static boolean l(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean m(VendorExtender vendorExtender) {
        return false;
    }

    public static boolean n(VendorExtender vendorExtender) {
        Version version = Version.VERSION_1_2;
        if (ClientVersion.isMaximumCompatibleVersion(version) || ExtensionVersion.isMaximumCompatibleVersion(version)) {
            return false;
        }
        return !vendorExtender.getSupportedCaptureResultKeys().isEmpty();
    }

    public static void h(VendorExtender vendorExtender, CameraInfo cameraInfo) {
    }
}
