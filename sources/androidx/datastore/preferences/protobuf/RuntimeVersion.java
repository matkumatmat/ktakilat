package androidx.datastore.preferences.protobuf;

import java.util.logging.Logger;

public final class RuntimeVersion {
    public static final RuntimeDomain DOMAIN;
    public static final int MAJOR = 4;
    public static final int MINOR = 28;
    public static final RuntimeDomain OSS_DOMAIN;
    public static final int OSS_MAJOR = 4;
    public static final int OSS_MINOR = 28;
    public static final int OSS_PATCH = 2;
    public static final String OSS_SUFFIX = "";
    public static final int PATCH = 2;
    public static final String SUFFIX = "";
    private static final String VERSION_STRING = versionString(4, 28, 2, "");
    private static final Logger logger = Logger.getLogger(RuntimeVersion.class.getName());

    public static final class ProtobufRuntimeVersionException extends RuntimeException {
        public ProtobufRuntimeVersionException(String str) {
            super(str);
        }
    }

    public enum RuntimeDomain {
        GOOGLE_INTERNAL,
        PUBLIC
    }

    static {
        RuntimeDomain runtimeDomain = RuntimeDomain.PUBLIC;
        OSS_DOMAIN = runtimeDomain;
        DOMAIN = runtimeDomain;
    }

    private RuntimeVersion() {
    }

    private static boolean checkDisabled() {
        String str = System.getenv("TEMORARILY_DISABLE_PROTOBUF_VERSION_CHECK");
        if (str == null || !str.equals("true")) {
            return false;
        }
        return true;
    }

    public static void validateProtobufGencodeVersion(RuntimeDomain runtimeDomain, int i, int i2, int i3, String str, String str2) {
        if (!checkDisabled()) {
            validateProtobufGencodeVersionImpl(runtimeDomain, i, i2, i3, str, str2);
        }
    }

    private static void validateProtobufGencodeVersionImpl(RuntimeDomain runtimeDomain, int i, int i2, int i3, String str, String str2) {
        if (!checkDisabled()) {
            String versionString = versionString(i, i2, i3, str);
            if (i < 0 || i2 < 0 || i3 < 0) {
                throw new ProtobufRuntimeVersionException(e.B("Invalid gencode version: ", versionString));
            }
            RuntimeDomain runtimeDomain2 = DOMAIN;
            if (runtimeDomain == runtimeDomain2) {
                if (i != 4) {
                    if (i == 3) {
                        Logger logger2 = logger;
                        StringBuilder u = e.u(" Protobuf gencode version ", versionString, " is exactly one major version older than the runtime version ", VERSION_STRING, " at ");
                        u.append(str2);
                        u.append(". Please update the gencode to avoid compatibility violations in the next runtime release.");
                        logger2.warning(u.toString());
                    } else {
                        throw new ProtobufRuntimeVersionException(ba.r(e.u("Detected mismatched Protobuf Gencode/Runtime major versions when loading ", str2, ": gencode ", versionString, ", runtime "), VERSION_STRING, ". Same major version is required."));
                    }
                }
                if (28 < i2 || (i2 == 28 && 2 < i3)) {
                    throw new ProtobufRuntimeVersionException(ba.r(e.u("Detected incompatible Protobuf Gencode/Runtime versions when loading ", str2, ": gencode ", versionString, ", runtime "), VERSION_STRING, ". Runtime version cannot be older than the linked gencode version."));
                }
                if (28 > i2 || 2 > i3) {
                    Logger logger3 = logger;
                    StringBuilder u2 = e.u(" Protobuf gencode version ", versionString, " is older than the runtime version ", VERSION_STRING, " at ");
                    u2.append(str2);
                    u2.append(". Please avoid checked-in Protobuf gencode that can be obsolete.");
                    logger3.warning(u2.toString());
                }
                if (!str.equals("")) {
                    throw new ProtobufRuntimeVersionException(ba.r(e.u("Detected mismatched Protobuf Gencode/Runtime version suffixes when loading ", str2, ": gencode ", versionString, ", runtime "), VERSION_STRING, ". Version suffixes must be the same."));
                }
                return;
            }
            throw new ProtobufRuntimeVersionException("Detected mismatched Protobuf Gencode/Runtime domains when loading " + str2 + ": gencode " + runtimeDomain + ", runtime " + runtimeDomain2 + ". Cross-domain usage of Protobuf is not supported.");
        }
    }

    private static String versionString(int i, int i2, int i3, String str) {
        return String.format("%d.%d.%d%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
    }
}
