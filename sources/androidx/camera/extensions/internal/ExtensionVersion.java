package androidx.camera.extensions.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.extensions.impl.ExtensionVersionImpl;

public abstract class ExtensionVersion {
    private static final String TAG = "ExtenderVersion";
    private static volatile ExtensionVersion sExtensionVersion;

    public static class DefaultExtenderVersioning extends ExtensionVersion {
        public Version getVersionObject() {
            return null;
        }

        public boolean isAdvancedExtenderSupportedInternal() {
            return false;
        }
    }

    public static class VendorExtenderVersioning extends ExtensionVersion {
        private static ExtensionVersionImpl sImpl;
        private Version mRuntimeVersion;

        public VendorExtenderVersioning() {
            if (sImpl == null) {
                sImpl = new ExtensionVersionImpl();
            }
            Version parse = Version.parse(sImpl.checkApiVersion(ClientVersion.getCurrentVersion().toVersionString()));
            if (parse != null && ClientVersion.getCurrentVersion().getVersion().getMajor() == parse.getMajor()) {
                this.mRuntimeVersion = parse;
            }
            Logger.d(ExtensionVersion.TAG, "Selected vendor runtime: " + this.mRuntimeVersion);
        }

        public Version getVersionObject() {
            return this.mRuntimeVersion;
        }

        public boolean isAdvancedExtenderSupportedInternal() {
            try {
                return sImpl.isAdvancedExtenderImplemented();
            } catch (NoSuchMethodError unused) {
                return false;
            }
        }
    }

    private static ExtensionVersion getInstance() {
        if (sExtensionVersion != null) {
            return sExtensionVersion;
        }
        synchronized (ExtensionVersion.class) {
            if (sExtensionVersion == null) {
                try {
                    sExtensionVersion = new VendorExtenderVersioning();
                } catch (NoClassDefFoundError unused) {
                    Logger.d(TAG, "No versioning extender found. Falling back to default.");
                    sExtensionVersion = new DefaultExtenderVersioning();
                }
            }
        }
        return sExtensionVersion;
    }

    @Nullable
    public static Version getRuntimeVersion() {
        return getInstance().getVersionObject();
    }

    @VisibleForTesting
    public static void injectInstance(@Nullable ExtensionVersion extensionVersion) {
        sExtensionVersion = extensionVersion;
    }

    public static boolean isAdvancedExtenderSupported() {
        return getInstance().isAdvancedExtenderSupportedInternal();
    }

    public static boolean isExtensionVersionSupported() {
        if (getInstance().getVersionObject() != null) {
            return true;
        }
        return false;
    }

    public static boolean isMaximumCompatibleVersion(@NonNull Version version) {
        if (getRuntimeVersion().compareTo(version.getMajor(), version.getMinor()) <= 0) {
            return true;
        }
        return false;
    }

    public static boolean isMinimumCompatibleVersion(@NonNull Version version) {
        if (getRuntimeVersion().compareTo(version.getMajor(), version.getMinor()) >= 0) {
            return true;
        }
        return false;
    }

    public abstract Version getVersionObject();

    public abstract boolean isAdvancedExtenderSupportedInternal();
}
