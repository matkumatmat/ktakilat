package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;

final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    private final String applicationBuild;
    private final String country;
    private final String device;
    private final String fingerprint;
    private final String hardware;
    private final String locale;
    private final String manufacturer;
    private final String mccMnc;
    private final String model;
    private final String osBuild;
    private final String product;
    private final Integer sdkVersion;

    public static final class Builder extends AndroidClientInfo.Builder {
        private String applicationBuild;
        private String country;
        private String device;
        private String fingerprint;
        private String hardware;
        private String locale;
        private String manufacturer;
        private String mccMnc;
        private String model;
        private String osBuild;
        private String product;
        private Integer sdkVersion;

        public AndroidClientInfo build() {
            return new AutoValue_AndroidClientInfo(this.sdkVersion, this.model, this.hardware, this.device, this.product, this.osBuild, this.manufacturer, this.fingerprint, this.locale, this.country, this.mccMnc, this.applicationBuild);
        }

        public AndroidClientInfo.Builder setApplicationBuild(@Nullable String str) {
            this.applicationBuild = str;
            return this;
        }

        public AndroidClientInfo.Builder setCountry(@Nullable String str) {
            this.country = str;
            return this;
        }

        public AndroidClientInfo.Builder setDevice(@Nullable String str) {
            this.device = str;
            return this;
        }

        public AndroidClientInfo.Builder setFingerprint(@Nullable String str) {
            this.fingerprint = str;
            return this;
        }

        public AndroidClientInfo.Builder setHardware(@Nullable String str) {
            this.hardware = str;
            return this;
        }

        public AndroidClientInfo.Builder setLocale(@Nullable String str) {
            this.locale = str;
            return this;
        }

        public AndroidClientInfo.Builder setManufacturer(@Nullable String str) {
            this.manufacturer = str;
            return this;
        }

        public AndroidClientInfo.Builder setMccMnc(@Nullable String str) {
            this.mccMnc = str;
            return this;
        }

        public AndroidClientInfo.Builder setModel(@Nullable String str) {
            this.model = str;
            return this;
        }

        public AndroidClientInfo.Builder setOsBuild(@Nullable String str) {
            this.osBuild = str;
            return this;
        }

        public AndroidClientInfo.Builder setProduct(@Nullable String str) {
            this.product = str;
            return this;
        }

        public AndroidClientInfo.Builder setSdkVersion(@Nullable Integer num) {
            this.sdkVersion = num;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AndroidClientInfo)) {
            return false;
        }
        AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
        Integer num = this.sdkVersion;
        if (num != null ? num.equals(androidClientInfo.getSdkVersion()) : androidClientInfo.getSdkVersion() == null) {
            String str = this.model;
            if (str != null ? str.equals(androidClientInfo.getModel()) : androidClientInfo.getModel() == null) {
                String str2 = this.hardware;
                if (str2 != null ? str2.equals(androidClientInfo.getHardware()) : androidClientInfo.getHardware() == null) {
                    String str3 = this.device;
                    if (str3 != null ? str3.equals(androidClientInfo.getDevice()) : androidClientInfo.getDevice() == null) {
                        String str4 = this.product;
                        if (str4 != null ? str4.equals(androidClientInfo.getProduct()) : androidClientInfo.getProduct() == null) {
                            String str5 = this.osBuild;
                            if (str5 != null ? str5.equals(androidClientInfo.getOsBuild()) : androidClientInfo.getOsBuild() == null) {
                                String str6 = this.manufacturer;
                                if (str6 != null ? str6.equals(androidClientInfo.getManufacturer()) : androidClientInfo.getManufacturer() == null) {
                                    String str7 = this.fingerprint;
                                    if (str7 != null ? str7.equals(androidClientInfo.getFingerprint()) : androidClientInfo.getFingerprint() == null) {
                                        String str8 = this.locale;
                                        if (str8 != null ? str8.equals(androidClientInfo.getLocale()) : androidClientInfo.getLocale() == null) {
                                            String str9 = this.country;
                                            if (str9 != null ? str9.equals(androidClientInfo.getCountry()) : androidClientInfo.getCountry() == null) {
                                                String str10 = this.mccMnc;
                                                if (str10 != null ? str10.equals(androidClientInfo.getMccMnc()) : androidClientInfo.getMccMnc() == null) {
                                                    String str11 = this.applicationBuild;
                                                    if (str11 == null) {
                                                        if (androidClientInfo.getApplicationBuild() == null) {
                                                            return true;
                                                        }
                                                    } else if (str11.equals(androidClientInfo.getApplicationBuild())) {
                                                        return true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Nullable
    public String getApplicationBuild() {
        return this.applicationBuild;
    }

    @Nullable
    public String getCountry() {
        return this.country;
    }

    @Nullable
    public String getDevice() {
        return this.device;
    }

    @Nullable
    public String getFingerprint() {
        return this.fingerprint;
    }

    @Nullable
    public String getHardware() {
        return this.hardware;
    }

    @Nullable
    public String getLocale() {
        return this.locale;
    }

    @Nullable
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Nullable
    public String getMccMnc() {
        return this.mccMnc;
    }

    @Nullable
    public String getModel() {
        return this.model;
    }

    @Nullable
    public String getOsBuild() {
        return this.osBuild;
    }

    @Nullable
    public String getProduct() {
        return this.product;
    }

    @Nullable
    public Integer getSdkVersion() {
        return this.sdkVersion;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Integer num = this.sdkVersion;
        int i12 = 0;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        int i13 = (i ^ 1000003) * 1000003;
        String str = this.model;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i14 = (i13 ^ i2) * 1000003;
        String str2 = this.hardware;
        if (str2 == null) {
            i3 = 0;
        } else {
            i3 = str2.hashCode();
        }
        int i15 = (i14 ^ i3) * 1000003;
        String str3 = this.device;
        if (str3 == null) {
            i4 = 0;
        } else {
            i4 = str3.hashCode();
        }
        int i16 = (i15 ^ i4) * 1000003;
        String str4 = this.product;
        if (str4 == null) {
            i5 = 0;
        } else {
            i5 = str4.hashCode();
        }
        int i17 = (i16 ^ i5) * 1000003;
        String str5 = this.osBuild;
        if (str5 == null) {
            i6 = 0;
        } else {
            i6 = str5.hashCode();
        }
        int i18 = (i17 ^ i6) * 1000003;
        String str6 = this.manufacturer;
        if (str6 == null) {
            i7 = 0;
        } else {
            i7 = str6.hashCode();
        }
        int i19 = (i18 ^ i7) * 1000003;
        String str7 = this.fingerprint;
        if (str7 == null) {
            i8 = 0;
        } else {
            i8 = str7.hashCode();
        }
        int i20 = (i19 ^ i8) * 1000003;
        String str8 = this.locale;
        if (str8 == null) {
            i9 = 0;
        } else {
            i9 = str8.hashCode();
        }
        int i21 = (i20 ^ i9) * 1000003;
        String str9 = this.country;
        if (str9 == null) {
            i10 = 0;
        } else {
            i10 = str9.hashCode();
        }
        int i22 = (i21 ^ i10) * 1000003;
        String str10 = this.mccMnc;
        if (str10 == null) {
            i11 = 0;
        } else {
            i11 = str10.hashCode();
        }
        int i23 = (i22 ^ i11) * 1000003;
        String str11 = this.applicationBuild;
        if (str11 != null) {
            i12 = str11.hashCode();
        }
        return i23 ^ i12;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.sdkVersion);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", hardware=");
        sb.append(this.hardware);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", product=");
        sb.append(this.product);
        sb.append(", osBuild=");
        sb.append(this.osBuild);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", fingerprint=");
        sb.append(this.fingerprint);
        sb.append(", locale=");
        sb.append(this.locale);
        sb.append(", country=");
        sb.append(this.country);
        sb.append(", mccMnc=");
        sb.append(this.mccMnc);
        sb.append(", applicationBuild=");
        return ba.r(sb, this.applicationBuild, "}");
    }

    private AutoValue_AndroidClientInfo(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }
}
