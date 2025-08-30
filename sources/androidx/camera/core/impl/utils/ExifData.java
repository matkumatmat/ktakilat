package androidx.camera.core.impl.utils;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.core.util.Preconditions;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class ExifData {
    private static final boolean DEBUG = false;
    static final ExifTag[] EXIF_POINTER_TAGS;
    static final ExifTag[][] EXIF_TAGS;
    private static final ExifTag[] IFD_EXIF_TAGS;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    static final int IFD_TYPE_EXIF = 1;
    static final int IFD_TYPE_GPS = 2;
    static final int IFD_TYPE_INTEROPERABILITY = 3;
    static final int IFD_TYPE_PRIMARY = 0;
    private static final int MM_IN_MICRONS = 1000;
    private static final String TAG = "ExifData";
    static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    static final HashSet<String> sTagSetForCompatibility;
    private final List<Map<String, ExifAttribute>> mAttributes;
    private final ByteOrder mByteOrder;

    /* renamed from: androidx.camera.core.impl.utils.ExifData$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState[] r0 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState = r0
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r1 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.READY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r1 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.core.impl.CameraCaptureMetaData$FlashState r1 = androidx.camera.core.impl.CameraCaptureMetaData.FlashState.FIRED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Builder {
        private static final Pattern DATETIME_PRIMARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final Pattern DATETIME_SECONDARY_FORMAT_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        private static final int DATETIME_VALUE_STRING_LENGTH = 19;
        private static final Pattern GPS_TIMESTAMP_PATTERN = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        static final List<HashMap<String, ExifTag>> sExifTagMapsForWriting = Collections.list(new Enumeration<HashMap<String, ExifTag>>() {
            int mIfdIndex = 0;

            public boolean hasMoreElements() {
                if (this.mIfdIndex < ExifData.EXIF_TAGS.length) {
                    return true;
                }
                return false;
            }

            public HashMap<String, ExifTag> nextElement() {
                HashMap<String, ExifTag> hashMap = new HashMap<>();
                for (ExifTag exifTag : ExifData.EXIF_TAGS[this.mIfdIndex]) {
                    hashMap.put(exifTag.name, exifTag);
                }
                this.mIfdIndex++;
                return hashMap;
            }
        });
        final List<Map<String, ExifAttribute>> mAttributes = Collections.list(new Enumeration<Map<String, ExifAttribute>>() {
            int mIfdIndex = 0;

            public boolean hasMoreElements() {
                if (this.mIfdIndex < ExifData.EXIF_TAGS.length) {
                    return true;
                }
                return false;
            }

            public Map<String, ExifAttribute> nextElement() {
                this.mIfdIndex++;
                return new HashMap();
            }
        });
        private final ByteOrder mByteOrder;

        public Builder(@NonNull ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:67|68|69) */
        /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
            java.lang.Double.parseDouble(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x014a, code lost:
            return new android.util.Pair<>(12, -1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0150, code lost:
            return new android.util.Pair<>(2, -1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x013c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static android.util.Pair<java.lang.Integer, java.lang.Integer> guessDataFormat(java.lang.String r10) {
            /*
                java.lang.String r0 = ","
                boolean r1 = r10.contains(r0)
                r2 = 0
                r3 = 1
                r4 = 2
                java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
                r6 = -1
                java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
                if (r1 == 0) goto L_0x00a6
                java.lang.String[] r10 = r10.split(r0, r6)
                r0 = r10[r2]
                android.util.Pair r0 = guessDataFormat(r0)
                java.lang.Object r1 = r0.first
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                if (r1 != r4) goto L_0x0029
                return r0
            L_0x0029:
                int r1 = r10.length
                if (r3 >= r1) goto L_0x00a5
                r1 = r10[r3]
                android.util.Pair r1 = guessDataFormat(r1)
                java.lang.Object r2 = r1.first
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.lang.Object r4 = r0.first
                boolean r2 = r2.equals(r4)
                if (r2 != 0) goto L_0x004d
                java.lang.Object r2 = r1.second
                java.lang.Integer r2 = (java.lang.Integer) r2
                java.lang.Object r4 = r0.first
                boolean r2 = r2.equals(r4)
                if (r2 == 0) goto L_0x004b
                goto L_0x004d
            L_0x004b:
                r2 = -1
                goto L_0x0055
            L_0x004d:
                java.lang.Object r2 = r0.first
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
            L_0x0055:
                java.lang.Object r4 = r0.second
                java.lang.Integer r4 = (java.lang.Integer) r4
                int r4 = r4.intValue()
                if (r4 == r6) goto L_0x0080
                java.lang.Object r4 = r1.first
                java.lang.Integer r4 = (java.lang.Integer) r4
                java.lang.Object r8 = r0.second
                boolean r4 = r4.equals(r8)
                if (r4 != 0) goto L_0x0077
                java.lang.Object r1 = r1.second
                java.lang.Integer r1 = (java.lang.Integer) r1
                java.lang.Object r4 = r0.second
                boolean r1 = r1.equals(r4)
                if (r1 == 0) goto L_0x0080
            L_0x0077:
                java.lang.Object r1 = r0.second
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r1 = r1.intValue()
                goto L_0x0081
            L_0x0080:
                r1 = -1
            L_0x0081:
                if (r2 != r6) goto L_0x008b
                if (r1 != r6) goto L_0x008b
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            L_0x008b:
                if (r2 != r6) goto L_0x0097
                android.util.Pair r0 = new android.util.Pair
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                r0.<init>(r1, r7)
                goto L_0x00a2
            L_0x0097:
                if (r1 != r6) goto L_0x00a2
                android.util.Pair r0 = new android.util.Pair
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
                r0.<init>(r1, r7)
            L_0x00a2:
                int r3 = r3 + 1
                goto L_0x0029
            L_0x00a5:
                return r0
            L_0x00a6:
                java.lang.String r0 = "/"
                boolean r1 = r10.contains(r0)
                r8 = 0
                if (r1 == 0) goto L_0x0105
                java.lang.String[] r10 = r10.split(r0, r6)
                int r0 = r10.length
                if (r0 != r4) goto L_0x00ff
                r0 = r10[r2]     // Catch:{ NumberFormatException -> 0x00ff }
                double r0 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x00ff }
                long r0 = (long) r0     // Catch:{ NumberFormatException -> 0x00ff }
                r10 = r10[r3]     // Catch:{ NumberFormatException -> 0x00ff }
                double r2 = java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x00ff }
                long r2 = (long) r2     // Catch:{ NumberFormatException -> 0x00ff }
                r10 = 10
                int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r4 < 0) goto L_0x00f5
                int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r4 >= 0) goto L_0x00d0
                goto L_0x00f5
            L_0x00d0:
                r4 = 5
                r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
                int r6 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r6 > 0) goto L_0x00eb
                int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x00dd
                goto L_0x00eb
            L_0x00dd:
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
                r0.<init>(r10, r1)     // Catch:{ NumberFormatException -> 0x00ff }
                return r0
            L_0x00eb:
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r4)     // Catch:{ NumberFormatException -> 0x00ff }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x00ff }
                return r10
            L_0x00f5:
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x00ff }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00ff }
                r0.<init>(r10, r7)     // Catch:{ NumberFormatException -> 0x00ff }
                return r0
            L_0x00ff:
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            L_0x0105:
                long r0 = java.lang.Long.parseLong(r10)     // Catch:{ NumberFormatException -> 0x013c }
                r2 = 4
                int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r3 < 0) goto L_0x0124
                r8 = 65535(0xffff, double:3.23786E-319)
                int r4 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                if (r4 > 0) goto L_0x0124
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                r1 = 3
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
                java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r2)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x0124:
                if (r3 >= 0) goto L_0x0132
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                r1 = 9
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x0132:
                android.util.Pair r0 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x013c }
                java.lang.Integer r1 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x013c }
                r0.<init>(r1, r7)     // Catch:{ NumberFormatException -> 0x013c }
                return r0
            L_0x013c:
                java.lang.Double.parseDouble(r10)     // Catch:{ NumberFormatException -> 0x014b }
                android.util.Pair r10 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x014b }
                r0 = 12
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x014b }
                r10.<init>(r0, r7)     // Catch:{ NumberFormatException -> 0x014b }
                return r10
            L_0x014b:
                android.util.Pair r10 = new android.util.Pair
                r10.<init>(r5, r7)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.Builder.guessDataFormat(java.lang.String):android.util.Pair");
        }

        private void setAttributeIfMissing(@NonNull String str, @NonNull String str2, @NonNull List<Map<String, ExifAttribute>> list) {
            for (Map<String, ExifAttribute> containsKey : list) {
                if (containsKey.containsKey(str)) {
                    return;
                }
            }
            setAttributeInternal(str, str2, list);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0175, code lost:
            if (r7 != r0) goto L_0x012f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void setAttributeInternal(@androidx.annotation.NonNull java.lang.String r18, @androidx.annotation.Nullable java.lang.String r19, @androidx.annotation.NonNull java.util.List<java.util.Map<java.lang.String, androidx.camera.core.impl.utils.ExifAttribute>> r20) {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                r2 = r19
                r3 = r20
                java.lang.String r4 = "DateTime"
                boolean r4 = r4.equals(r0)
                java.lang.String r5 = " : "
                java.lang.String r6 = "Invalid value for "
                java.lang.String r7 = "ExifData"
                if (r4 != 0) goto L_0x0026
                java.lang.String r4 = "DateTimeOriginal"
                boolean r4 = r4.equals(r0)
                if (r4 != 0) goto L_0x0026
                java.lang.String r4 = "DateTimeDigitized"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x006a
            L_0x0026:
                if (r2 == 0) goto L_0x006a
                java.util.regex.Pattern r4 = DATETIME_PRIMARY_FORMAT_PATTERN
                java.util.regex.Matcher r4 = r4.matcher(r2)
                boolean r4 = r4.find()
                java.util.regex.Pattern r8 = DATETIME_SECONDARY_FORMAT_PATTERN
                java.util.regex.Matcher r8 = r8.matcher(r2)
                boolean r8 = r8.find()
                int r9 = r19.length()
                r10 = 19
                if (r9 != r10) goto L_0x0054
                if (r4 != 0) goto L_0x0049
                if (r8 != 0) goto L_0x0049
                goto L_0x0054
            L_0x0049:
                if (r8 == 0) goto L_0x006a
                java.lang.String r4 = "-"
                java.lang.String r8 = ":"
                java.lang.String r2 = r2.replaceAll(r4, r8)
                goto L_0x006a
            L_0x0054:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>(r6)
                r3.append(r0)
                r3.append(r5)
                r3.append(r2)
                java.lang.String r0 = r3.toString()
                androidx.camera.core.Logger.w(r7, r0)
                return
            L_0x006a:
                java.lang.String r4 = "ISOSpeedRatings"
                boolean r4 = r4.equals(r0)
                if (r4 == 0) goto L_0x0074
                java.lang.String r0 = "PhotographicSensitivity"
            L_0x0074:
                r4 = r0
                r0 = 2
                r8 = 1
                if (r2 == 0) goto L_0x010d
                java.util.HashSet<java.lang.String> r9 = androidx.camera.core.impl.utils.ExifData.sTagSetForCompatibility
                boolean r9 = r9.contains(r4)
                if (r9 == 0) goto L_0x010d
                java.lang.String r9 = "GPSTimeStamp"
                boolean r9 = r4.equals(r9)
                if (r9 == 0) goto L_0x00f6
                java.util.regex.Pattern r9 = GPS_TIMESTAMP_PATTERN
                java.util.regex.Matcher r9 = r9.matcher(r2)
                boolean r10 = r9.find()
                if (r10 != 0) goto L_0x00ab
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r6)
                r0.append(r4)
                r0.append(r5)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                androidx.camera.core.Logger.w(r7, r0)
                return
            L_0x00ab:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r5 = r9.group(r8)
                java.lang.Object r5 = androidx.core.util.Preconditions.checkNotNull(r5)
                java.lang.String r5 = (java.lang.String) r5
                int r5 = java.lang.Integer.parseInt(r5)
                r2.append(r5)
                java.lang.String r5 = "/1,"
                r2.append(r5)
                java.lang.String r6 = r9.group(r0)
                java.lang.Object r6 = androidx.core.util.Preconditions.checkNotNull(r6)
                java.lang.String r6 = (java.lang.String) r6
                int r6 = java.lang.Integer.parseInt(r6)
                r2.append(r6)
                r2.append(r5)
                r5 = 3
                java.lang.String r5 = r9.group(r5)
                java.lang.Object r5 = androidx.core.util.Preconditions.checkNotNull(r5)
                java.lang.String r5 = (java.lang.String) r5
                int r5 = java.lang.Integer.parseInt(r5)
                r2.append(r5)
                java.lang.String r5 = "/1"
                r2.append(r5)
                java.lang.String r2 = r2.toString()
                goto L_0x010d
            L_0x00f6:
                double r9 = java.lang.Double.parseDouble(r2)     // Catch:{ NumberFormatException -> 0x0104 }
                androidx.camera.core.impl.utils.LongRational r11 = new androidx.camera.core.impl.utils.LongRational     // Catch:{ NumberFormatException -> 0x0104 }
                r11.<init>(r9)     // Catch:{ NumberFormatException -> 0x0104 }
                java.lang.String r2 = r11.toString()     // Catch:{ NumberFormatException -> 0x0104 }
                goto L_0x010d
            L_0x0104:
                r0 = move-exception
                java.lang.String r2 = defpackage.e.n(r6, r4, r5, r2)
                androidx.camera.core.Logger.w(r7, r2, r0)
                return
            L_0x010d:
                r5 = 0
                r6 = 0
            L_0x010f:
                androidx.camera.core.impl.utils.ExifTag[][] r7 = androidx.camera.core.impl.utils.ExifData.EXIF_TAGS
                int r7 = r7.length
                if (r6 >= r7) goto L_0x02cc
                java.util.List<java.util.HashMap<java.lang.String, androidx.camera.core.impl.utils.ExifTag>> r7 = sExifTagMapsForWriting
                java.lang.Object r7 = r7.get(r6)
                java.util.HashMap r7 = (java.util.HashMap) r7
                java.lang.Object r7 = r7.get(r4)
                androidx.camera.core.impl.utils.ExifTag r7 = (androidx.camera.core.impl.utils.ExifTag) r7
                if (r7 == 0) goto L_0x012f
                if (r2 != 0) goto L_0x0133
                java.lang.Object r7 = r3.get(r6)
                java.util.Map r7 = (java.util.Map) r7
                r7.remove(r4)
            L_0x012f:
                r5 = r6
                r15 = 1
                goto L_0x02c5
            L_0x0133:
                android.util.Pair r9 = guessDataFormat(r2)
                int r10 = r7.primaryFormat
                java.lang.Object r11 = r9.first
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                r12 = -1
                if (r10 == r11) goto L_0x0178
                int r10 = r7.primaryFormat
                java.lang.Object r11 = r9.second
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                if (r10 != r11) goto L_0x0151
                goto L_0x0178
            L_0x0151:
                int r10 = r7.secondaryFormat
                if (r10 == r12) goto L_0x016e
                java.lang.Object r11 = r9.first
                java.lang.Integer r11 = (java.lang.Integer) r11
                int r11 = r11.intValue()
                if (r10 == r11) goto L_0x016b
                int r10 = r7.secondaryFormat
                java.lang.Object r9 = r9.second
                java.lang.Integer r9 = (java.lang.Integer) r9
                int r9 = r9.intValue()
                if (r10 != r9) goto L_0x016e
            L_0x016b:
                int r7 = r7.secondaryFormat
                goto L_0x017a
            L_0x016e:
                int r7 = r7.primaryFormat
                if (r7 == r8) goto L_0x017a
                r9 = 7
                if (r7 == r9) goto L_0x017a
                if (r7 != r0) goto L_0x012f
                goto L_0x017a
            L_0x0178:
                int r7 = r7.primaryFormat
            L_0x017a:
                java.lang.String r9 = "/"
                java.lang.String r10 = ","
                switch(r7) {
                    case 1: goto L_0x02b6;
                    case 2: goto L_0x02a6;
                    case 3: goto L_0x027e;
                    case 4: goto L_0x0256;
                    case 5: goto L_0x0211;
                    case 6: goto L_0x0181;
                    case 7: goto L_0x02a6;
                    case 8: goto L_0x0181;
                    case 9: goto L_0x01ea;
                    case 10: goto L_0x01a8;
                    case 11: goto L_0x0181;
                    case 12: goto L_0x0182;
                    default: goto L_0x0181;
                }
            L_0x0181:
                goto L_0x012f
            L_0x0182:
                java.lang.String[] r7 = r2.split(r10, r12)
                int r9 = r7.length
                double[] r9 = new double[r9]
                r10 = 0
            L_0x018a:
                int r11 = r7.length
                if (r10 >= r11) goto L_0x0198
                r11 = r7[r10]
                double r11 = java.lang.Double.parseDouble(r11)
                r9[r10] = r11
                int r10 = r10 + 1
                goto L_0x018a
            L_0x0198:
                java.lang.Object r7 = r3.get(r6)
                java.util.Map r7 = (java.util.Map) r7
                java.nio.ByteOrder r10 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r9 = androidx.camera.core.impl.utils.ExifAttribute.createDouble((double[]) r9, (java.nio.ByteOrder) r10)
                r7.put(r4, r9)
                goto L_0x012f
            L_0x01a8:
                java.lang.String[] r7 = r2.split(r10, r12)
                int r10 = r7.length
                androidx.camera.core.impl.utils.LongRational[] r10 = new androidx.camera.core.impl.utils.LongRational[r10]
                r11 = 0
            L_0x01b0:
                int r13 = r7.length
                if (r11 >= r13) goto L_0x01d7
                r13 = r7[r11]
                java.lang.String[] r13 = r13.split(r9, r12)
                androidx.camera.core.impl.utils.LongRational r14 = new androidx.camera.core.impl.utils.LongRational
                r15 = r13[r5]
                double r0 = java.lang.Double.parseDouble(r15)
                long r0 = (long) r0
                r13 = r13[r8]
                r15 = r9
                double r8 = java.lang.Double.parseDouble(r13)
                long r8 = (long) r8
                r14.<init>(r0, r8)
                r10[r11] = r14
                int r11 = r11 + 1
                r9 = r15
                r0 = 2
                r8 = 1
                r1 = r17
                goto L_0x01b0
            L_0x01d7:
                java.lang.Object r0 = r3.get(r6)
                java.util.Map r0 = (java.util.Map) r0
                r1 = r17
                java.nio.ByteOrder r7 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r7 = androidx.camera.core.impl.utils.ExifAttribute.createSRational((androidx.camera.core.impl.utils.LongRational[]) r10, (java.nio.ByteOrder) r7)
                r0.put(r4, r7)
                goto L_0x012f
            L_0x01ea:
                java.lang.String[] r0 = r2.split(r10, r12)
                int r7 = r0.length
                int[] r7 = new int[r7]
                r8 = 0
            L_0x01f2:
                int r9 = r0.length
                if (r8 >= r9) goto L_0x0200
                r9 = r0[r8]
                int r9 = java.lang.Integer.parseInt(r9)
                r7[r8] = r9
                int r8 = r8 + 1
                goto L_0x01f2
            L_0x0200:
                java.lang.Object r0 = r3.get(r6)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r8 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r7 = androidx.camera.core.impl.utils.ExifAttribute.createSLong((int[]) r7, (java.nio.ByteOrder) r8)
                r0.put(r4, r7)
                goto L_0x012f
            L_0x0211:
                r15 = r9
                java.lang.String[] r0 = r2.split(r10, r12)
                int r7 = r0.length
                androidx.camera.core.impl.utils.LongRational[] r7 = new androidx.camera.core.impl.utils.LongRational[r7]
                r8 = 0
            L_0x021a:
                int r9 = r0.length
                if (r8 >= r9) goto L_0x0243
                r9 = r0[r8]
                r10 = r15
                java.lang.String[] r9 = r9.split(r10, r12)
                androidx.camera.core.impl.utils.LongRational r11 = new androidx.camera.core.impl.utils.LongRational
                r13 = r9[r5]
                double r13 = java.lang.Double.parseDouble(r13)
                long r13 = (long) r13
                r15 = 1
                r9 = r9[r15]
                r16 = r6
                double r5 = java.lang.Double.parseDouble(r9)
                long r5 = (long) r5
                r11.<init>(r13, r5)
                r7[r8] = r11
                int r8 = r8 + 1
                r15 = r10
                r6 = r16
                r5 = 0
                goto L_0x021a
            L_0x0243:
                r5 = r6
                r15 = 1
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r6 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createURational((androidx.camera.core.impl.utils.LongRational[]) r7, (java.nio.ByteOrder) r6)
                r0.put(r4, r6)
                goto L_0x02c5
            L_0x0256:
                r5 = r6
                r15 = 1
                java.lang.String[] r0 = r2.split(r10, r12)
                int r6 = r0.length
                long[] r6 = new long[r6]
                r7 = 0
            L_0x0260:
                int r8 = r0.length
                if (r7 >= r8) goto L_0x026e
                r8 = r0[r7]
                long r8 = java.lang.Long.parseLong(r8)
                r6[r7] = r8
                int r7 = r7 + 1
                goto L_0x0260
            L_0x026e:
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r7 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createULong((long[]) r6, (java.nio.ByteOrder) r7)
                r0.put(r4, r6)
                goto L_0x02c5
            L_0x027e:
                r5 = r6
                r15 = 1
                java.lang.String[] r0 = r2.split(r10, r12)
                int r6 = r0.length
                int[] r6 = new int[r6]
                r7 = 0
            L_0x0288:
                int r8 = r0.length
                if (r7 >= r8) goto L_0x0296
                r8 = r0[r7]
                int r8 = java.lang.Integer.parseInt(r8)
                r6[r7] = r8
                int r7 = r7 + 1
                goto L_0x0288
            L_0x0296:
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                java.nio.ByteOrder r7 = r1.mByteOrder
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createUShort((int[]) r6, (java.nio.ByteOrder) r7)
                r0.put(r4, r6)
                goto L_0x02c5
            L_0x02a6:
                r5 = r6
                r15 = 1
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createString(r2)
                r0.put(r4, r6)
                goto L_0x02c5
            L_0x02b6:
                r5 = r6
                r15 = 1
                java.lang.Object r0 = r3.get(r5)
                java.util.Map r0 = (java.util.Map) r0
                androidx.camera.core.impl.utils.ExifAttribute r6 = androidx.camera.core.impl.utils.ExifAttribute.createByte(r2)
                r0.put(r4, r6)
            L_0x02c5:
                int r6 = r5 + 1
                r0 = 2
                r5 = 0
                r8 = 1
                goto L_0x010f
            L_0x02cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.impl.utils.ExifData.Builder.setAttributeInternal(java.lang.String, java.lang.String, java.util.List):void");
        }

        @NonNull
        public ExifData build() {
            ArrayList list = Collections.list(new Enumeration<Map<String, ExifAttribute>>() {
                final Enumeration<Map<String, ExifAttribute>> mMapEnumeration;

                {
                    this.mMapEnumeration = Collections.enumeration(Builder.this.mAttributes);
                }

                public boolean hasMoreElements() {
                    return this.mMapEnumeration.hasMoreElements();
                }

                public Map<String, ExifAttribute> nextElement() {
                    return new HashMap(this.mMapEnumeration.nextElement());
                }
            });
            if (!((Map) list.get(1)).isEmpty()) {
                setAttributeIfMissing(ExifInterface.TAG_EXPOSURE_PROGRAM, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_EXIF_VERSION, "0230", list);
                setAttributeIfMissing(ExifInterface.TAG_COMPONENTS_CONFIGURATION, "1,2,3,0", list);
                setAttributeIfMissing(ExifInterface.TAG_METERING_MODE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_FLASHPIX_VERSION, "0100", list);
                setAttributeIfMissing(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, String.valueOf(2), list);
                setAttributeIfMissing(ExifInterface.TAG_FILE_SOURCE, String.valueOf(3), list);
                setAttributeIfMissing(ExifInterface.TAG_SCENE_TYPE, String.valueOf(1), list);
                setAttributeIfMissing(ExifInterface.TAG_CUSTOM_RENDERED, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SCENE_CAPTURE_TYPE, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_CONTRAST, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SATURATION, String.valueOf(0), list);
                setAttributeIfMissing(ExifInterface.TAG_SHARPNESS, String.valueOf(0), list);
            }
            if (!((Map) list.get(2)).isEmpty()) {
                setAttributeIfMissing(ExifInterface.TAG_GPS_VERSION_ID, "2300", list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_SPEED_REF, "K", list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.GPS_DIRECTION_TRUE, list);
                setAttributeIfMissing(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, "K", list);
            }
            return new ExifData(this.mByteOrder, list);
        }

        @NonNull
        public Builder removeAttribute(@NonNull String str) {
            setAttributeInternal(str, (String) null, this.mAttributes);
            return this;
        }

        @NonNull
        public Builder setAttribute(@NonNull String str, @NonNull String str2) {
            setAttributeInternal(str, str2, this.mAttributes);
            return this;
        }

        @NonNull
        public Builder setExposureTimeNanos(long j) {
            return setAttribute(ExifInterface.TAG_EXPOSURE_TIME, String.valueOf(((double) j) / ((double) TimeUnit.SECONDS.toNanos(1))));
        }

        @NonNull
        public Builder setFlashState(@NonNull CameraCaptureMetaData.FlashState flashState) {
            int i;
            if (flashState == CameraCaptureMetaData.FlashState.UNKNOWN) {
                return this;
            }
            int i2 = AnonymousClass1.$SwitchMap$androidx$camera$core$impl$CameraCaptureMetaData$FlashState[flashState.ordinal()];
            if (i2 == 1) {
                i = 0;
            } else if (i2 == 2) {
                i = 32;
            } else if (i2 != 3) {
                Logger.w(ExifData.TAG, "Unknown flash state: " + flashState);
                return this;
            } else {
                i = 1;
            }
            if ((i & 1) == 1) {
                setAttribute(ExifInterface.TAG_LIGHT_SOURCE, String.valueOf(4));
            }
            return setAttribute(ExifInterface.TAG_FLASH, String.valueOf(i));
        }

        @NonNull
        public Builder setFocalLength(float f) {
            return setAttribute(ExifInterface.TAG_FOCAL_LENGTH, new LongRational((long) (f * 1000.0f), 1000).toString());
        }

        @NonNull
        public Builder setImageHeight(int i) {
            return setAttribute(ExifInterface.TAG_IMAGE_LENGTH, String.valueOf(i));
        }

        @NonNull
        public Builder setImageWidth(int i) {
            return setAttribute(ExifInterface.TAG_IMAGE_WIDTH, String.valueOf(i));
        }

        @NonNull
        public Builder setIso(int i) {
            return setAttribute(ExifInterface.TAG_SENSITIVITY_TYPE, String.valueOf(3)).setAttribute(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, String.valueOf(Math.min(65535, i)));
        }

        @NonNull
        public Builder setLensFNumber(float f) {
            return setAttribute(ExifInterface.TAG_F_NUMBER, String.valueOf(f));
        }

        @NonNull
        public Builder setOrientationDegrees(int i) {
            int i2;
            if (i == 0) {
                i2 = 1;
            } else if (i == 90) {
                i2 = 6;
            } else if (i == 180) {
                i2 = 3;
            } else if (i != 270) {
                Logger.w(ExifData.TAG, "Unexpected orientation value: " + i + ". Must be one of 0, 90, 180, 270.");
                i2 = 0;
            } else {
                i2 = 8;
            }
            return setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(i2));
        }

        @NonNull
        public Builder setWhiteBalanceMode(@NonNull WhiteBalanceMode whiteBalanceMode) {
            String str;
            int ordinal = whiteBalanceMode.ordinal();
            if (ordinal == 0) {
                str = String.valueOf(0);
            } else if (ordinal != 1) {
                str = null;
            } else {
                str = String.valueOf(1);
            }
            return setAttribute(ExifInterface.TAG_WHITE_BALANCE, str);
        }
    }

    public enum WhiteBalanceMode {
        AUTO,
        MANUAL
    }

    static {
        ExifTag exifTag = new ExifTag(ExifInterface.TAG_IMAGE_WIDTH, 256, 3, 4);
        ExifTag exifTag2 = new ExifTag(ExifInterface.TAG_IMAGE_LENGTH, 257, 3, 4);
        ExifTag exifTag3 = new ExifTag(ExifInterface.TAG_MAKE, 271, 2);
        ExifTag exifTag4 = new ExifTag(ExifInterface.TAG_MODEL, 272, 2);
        ExifTag exifTag5 = new ExifTag(ExifInterface.TAG_ORIENTATION, 274, 3);
        ExifTag exifTag6 = new ExifTag(ExifInterface.TAG_X_RESOLUTION, 282, 5);
        ExifTag exifTag7 = new ExifTag(ExifInterface.TAG_Y_RESOLUTION, 283, 5);
        ExifTag exifTag8 = new ExifTag(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3);
        ExifTag exifTag9 = new ExifTag(ExifInterface.TAG_SOFTWARE, 305, 2);
        ExifTag exifTag10 = new ExifTag(ExifInterface.TAG_DATETIME, 306, 2);
        ExifTag exifTag11 = new ExifTag(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3);
        ExifTag exifTag12 = new ExifTag(TAG_SUB_IFD_POINTER, 330, 4);
        String str = TAG_SUB_IFD_POINTER;
        ExifTag exifTag13 = new ExifTag(TAG_EXIF_IFD_POINTER, 34665, 4);
        String str2 = TAG_EXIF_IFD_POINTER;
        ExifTag[] exifTagArr = {exifTag, exifTag2, exifTag3, exifTag4, exifTag5, exifTag6, exifTag7, exifTag8, exifTag9, exifTag10, exifTag11, exifTag12, exifTag13, new ExifTag(TAG_GPS_INFO_IFD_POINTER, 34853, 4)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag exifTag14 = new ExifTag(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5);
        ExifTag exifTag15 = new ExifTag(ExifInterface.TAG_F_NUMBER, 33437, 5);
        ExifTag exifTag16 = new ExifTag(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3);
        ExifTag exifTag17 = new ExifTag(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3);
        ExifTag exifTag18 = new ExifTag(ExifInterface.TAG_SENSITIVITY_TYPE, 34864, 3);
        ExifTag exifTag19 = new ExifTag(ExifInterface.TAG_EXIF_VERSION, 36864, 2);
        ExifTag exifTag20 = new ExifTag(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2);
        ExifTag exifTag21 = new ExifTag(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2);
        ExifTag exifTag22 = new ExifTag(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7);
        String str3 = ExifInterface.TAG_F_NUMBER;
        ExifTag exifTag23 = new ExifTag(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10);
        String str4 = ExifInterface.TAG_EXPOSURE_TIME;
        ExifTag exifTag24 = new ExifTag(ExifInterface.TAG_APERTURE_VALUE, 37378, 5);
        ExifTag[] exifTagArr2 = exifTagArr;
        ExifTag exifTag25 = new ExifTag(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10);
        String str5 = TAG_GPS_INFO_IFD_POINTER;
        ExifTag exifTag26 = new ExifTag(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10);
        ExifTag exifTag27 = new ExifTag(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5);
        ExifTag exifTag28 = new ExifTag(ExifInterface.TAG_METERING_MODE, 37383, 3);
        ExifTag exifTag29 = new ExifTag(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3);
        ExifTag exifTag30 = new ExifTag(ExifInterface.TAG_FLASH, 37385, 3);
        ExifTag exifTag31 = new ExifTag(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5);
        ExifTag exifTag32 = new ExifTag(ExifInterface.TAG_SUBSEC_TIME, 37520, 2);
        ExifTag exifTag33 = new ExifTag(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2);
        ExifTag exifTag34 = new ExifTag(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2);
        ExifTag exifTag35 = new ExifTag(ExifInterface.TAG_FLASHPIX_VERSION, 40960, 7);
        ExifTag exifTag36 = new ExifTag(ExifInterface.TAG_COLOR_SPACE, 40961, 3);
        ExifTag exifTag37 = new ExifTag(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962, 3, 4);
        ExifTag exifTag38 = new ExifTag(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963, 3, 4);
        ExifTag exifTag39 = new ExifTag(TAG_INTEROPERABILITY_IFD_POINTER, 40965, 4);
        String str6 = TAG_INTEROPERABILITY_IFD_POINTER;
        ExifTag[] exifTagArr3 = {exifTag14, exifTag15, exifTag16, exifTag17, exifTag18, exifTag19, exifTag20, exifTag21, exifTag22, exifTag23, exifTag24, exifTag25, exifTag26, exifTag27, exifTag28, exifTag29, exifTag30, exifTag31, exifTag32, exifTag33, exifTag34, exifTag35, exifTag36, exifTag37, exifTag38, exifTag39, new ExifTag(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new ExifTag(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new ExifTag(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new ExifTag(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new ExifTag(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(ExifInterface.TAG_CONTRAST, 41992, 3), new ExifTag(ExifInterface.TAG_SATURATION, 41993, 3), new ExifTag(ExifInterface.TAG_SHARPNESS, 41994, 3)};
        IFD_EXIF_TAGS = exifTagArr3;
        ExifTag exifTag40 = new ExifTag(ExifInterface.TAG_GPS_VERSION_ID, 0, 1);
        ExifTag exifTag41 = new ExifTag(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2);
        ExifTag exifTag42 = new ExifTag(ExifInterface.TAG_GPS_LATITUDE, 2, 5, 10);
        ExifTag exifTag43 = new ExifTag(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2);
        ExifTag exifTag44 = new ExifTag(ExifInterface.TAG_GPS_LONGITUDE, 4, 5, 10);
        ExifTag exifTag45 = new ExifTag(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1);
        ExifTag exifTag46 = new ExifTag(ExifInterface.TAG_GPS_ALTITUDE, 6, 5);
        ExifTag exifTag47 = new ExifTag(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5);
        ExifTag exifTag48 = new ExifTag(ExifInterface.TAG_GPS_SPEED_REF, 12, 2);
        ExifTag exifTag49 = new ExifTag(ExifInterface.TAG_GPS_TRACK_REF, 14, 2);
        ExifTag exifTag50 = new ExifTag(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2);
        String str7 = ExifInterface.TAG_GPS_TIMESTAMP;
        ExifTag[] exifTagArr4 = exifTagArr3;
        ExifTag[] exifTagArr5 = {exifTag40, exifTag41, exifTag42, exifTag43, exifTag44, exifTag45, exifTag46, exifTag47, exifTag48, exifTag49, exifTag50, new ExifTag(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2)};
        IFD_GPS_TAGS = exifTagArr5;
        EXIF_POINTER_TAGS = new ExifTag[]{new ExifTag(str, 330, 4), new ExifTag(str2, 34665, 4), new ExifTag(str5, 34853, 4), new ExifTag(str6, 40965, 4)};
        ExifTag[] exifTagArr6 = {new ExifTag(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr6;
        EXIF_TAGS = new ExifTag[][]{exifTagArr2, exifTagArr4, exifTagArr5, exifTagArr6};
        sTagSetForCompatibility = new HashSet<>(Arrays.asList(new String[]{str3, str4, str7}));
    }

    public ExifData(ByteOrder byteOrder, List<Map<String, ExifAttribute>> list) {
        boolean z;
        if (list.size() == EXIF_TAGS.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z, "Malformed attributes list. Number of IFDs mismatch.");
        this.mByteOrder = byteOrder;
        this.mAttributes = list;
    }

    @NonNull
    public static Builder builderForDevice() {
        return new Builder(ByteOrder.BIG_ENDIAN).setAttribute(ExifInterface.TAG_ORIENTATION, String.valueOf(1)).setAttribute(ExifInterface.TAG_X_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_Y_RESOLUTION, "72/1").setAttribute(ExifInterface.TAG_RESOLUTION_UNIT, String.valueOf(2)).setAttribute(ExifInterface.TAG_Y_CB_CR_POSITIONING, String.valueOf(1)).setAttribute(ExifInterface.TAG_MAKE, Build.MANUFACTURER).setAttribute(ExifInterface.TAG_MODEL, Build.MODEL);
    }

    @NonNull
    public static ExifData create(@NonNull ImageProxy imageProxy, int i) {
        Builder builderForDevice = builderForDevice();
        if (imageProxy.getImageInfo() != null) {
            imageProxy.getImageInfo().populateExifData(builderForDevice);
        }
        builderForDevice.setOrientationDegrees(i);
        return builderForDevice.setImageWidth(imageProxy.getWidth()).setImageHeight(imageProxy.getHeight()).build();
    }

    @Nullable
    private ExifAttribute getExifAttribute(@NonNull String str) {
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            ExifAttribute exifAttribute = (ExifAttribute) this.mAttributes.get(i).get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mByteOrder);
            }
            if (str.equals(ExifInterface.TAG_GPS_TIMESTAMP)) {
                int i = exifAttribute.format;
                if (i == 5 || i == 10) {
                    LongRational[] longRationalArr = (LongRational[]) exifAttribute.getValue(this.mByteOrder);
                    if (longRationalArr == null || longRationalArr.length != 3) {
                        Logger.w(TAG, "Invalid GPS Timestamp array. array=" + Arrays.toString(longRationalArr));
                        return null;
                    }
                    return String.format(Locale.US, "%02d:%02d:%02d", new Object[]{Integer.valueOf((int) (((float) longRationalArr[0].getNumerator()) / ((float) longRationalArr[0].getDenominator()))), Integer.valueOf((int) (((float) longRationalArr[1].getNumerator()) / ((float) longRationalArr[1].getDenominator()))), Integer.valueOf((int) (((float) longRationalArr[2].getNumerator()) / ((float) longRationalArr[2].getDenominator())))});
                }
                Logger.w(TAG, "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                return null;
            }
            try {
                return Double.toString(exifAttribute.getDoubleValue(this.mByteOrder));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    @NonNull
    public Map<String, ExifAttribute> getAttributes(int i) {
        Preconditions.checkArgumentInRange(i, 0, EXIF_TAGS.length, ba.l(i, "Invalid IFD index: ", ". Index should be between [0, EXIF_TAGS.length] "));
        return this.mAttributes.get(i);
    }

    @NonNull
    public ByteOrder getByteOrder() {
        return this.mByteOrder;
    }
}
