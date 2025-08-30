package androidx.camera.extensions;

import androidx.camera.extensions.internal.VendorExtender;

public final /* synthetic */ class a implements VendorExtenderFactory {
    public final VendorExtender createVendorExtender(int i) {
        return ExtensionsInfo.getVendorExtender(i);
    }
}
