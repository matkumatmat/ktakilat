package com.google.i18n.phonenumbers;

import java.io.Serializable;

public final class Phonenumber {

    public static class PhoneNumber implements Serializable {
        private static final long serialVersionUID = 1;
        public boolean c;
        public int d = 0;
        public boolean e;
        public long f = 0;
        public boolean g;
        public String i = "";
        public boolean j;
        public boolean k = false;
        public boolean l;
        public int m = 1;
        public boolean n;
        public String o = "";
        public boolean p;
        public CountryCodeSource q = CountryCodeSource.UNSPECIFIED;
        public boolean r;
        public String s = "";

        public enum CountryCodeSource {
        }

        public final PhoneNumber clear() {
            clearCountryCode();
            clearNationalNumber();
            clearExtension();
            clearItalianLeadingZero();
            clearNumberOfLeadingZeros();
            clearRawInput();
            clearCountryCodeSource();
            clearPreferredDomesticCarrierCode();
            return this;
        }

        public PhoneNumber clearCountryCode() {
            this.c = false;
            this.d = 0;
            return this;
        }

        public PhoneNumber clearCountryCodeSource() {
            this.p = false;
            this.q = CountryCodeSource.UNSPECIFIED;
            return this;
        }

        public PhoneNumber clearExtension() {
            this.g = false;
            this.i = "";
            return this;
        }

        public PhoneNumber clearItalianLeadingZero() {
            this.j = false;
            this.k = false;
            return this;
        }

        public PhoneNumber clearNationalNumber() {
            this.e = false;
            this.f = 0;
            return this;
        }

        public PhoneNumber clearNumberOfLeadingZeros() {
            this.l = false;
            this.m = 1;
            return this;
        }

        public PhoneNumber clearPreferredDomesticCarrierCode() {
            this.r = false;
            this.s = "";
            return this;
        }

        public PhoneNumber clearRawInput() {
            this.n = false;
            this.o = "";
            return this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof PhoneNumber) || !exactlySameAs((PhoneNumber) obj)) {
                return false;
            }
            return true;
        }

        public boolean exactlySameAs(PhoneNumber phoneNumber) {
            if (phoneNumber == null) {
                return false;
            }
            if (this == phoneNumber) {
                return true;
            }
            if (this.d == phoneNumber.d && this.f == phoneNumber.f && this.i.equals(phoneNumber.i) && this.k == phoneNumber.k && this.m == phoneNumber.m && this.o.equals(phoneNumber.o) && this.q == phoneNumber.q && this.s.equals(phoneNumber.s) && hasPreferredDomesticCarrierCode() == phoneNumber.hasPreferredDomesticCarrierCode()) {
                return true;
            }
            return false;
        }

        public int getCountryCode() {
            return this.d;
        }

        public CountryCodeSource getCountryCodeSource() {
            return this.q;
        }

        public String getExtension() {
            return this.i;
        }

        public long getNationalNumber() {
            return this.f;
        }

        public int getNumberOfLeadingZeros() {
            return this.m;
        }

        public String getPreferredDomesticCarrierCode() {
            return this.s;
        }

        public String getRawInput() {
            return this.o;
        }

        public boolean hasCountryCode() {
            return this.c;
        }

        public boolean hasCountryCodeSource() {
            return this.p;
        }

        public boolean hasExtension() {
            return this.g;
        }

        public boolean hasItalianLeadingZero() {
            return this.j;
        }

        public boolean hasNationalNumber() {
            return this.e;
        }

        public boolean hasNumberOfLeadingZeros() {
            return this.l;
        }

        public boolean hasPreferredDomesticCarrierCode() {
            return this.r;
        }

        public boolean hasRawInput() {
            return this.n;
        }

        public int hashCode() {
            int i2;
            int hashCode = Long.valueOf(getNationalNumber()).hashCode();
            int hashCode2 = (getExtension().hashCode() + ((hashCode + ((getCountryCode() + 2173) * 53)) * 53)) * 53;
            int i3 = 1237;
            if (isItalianLeadingZero()) {
                i2 = 1231;
            } else {
                i2 = 1237;
            }
            int numberOfLeadingZeros = getNumberOfLeadingZeros();
            int hashCode3 = getRawInput().hashCode();
            int hashCode4 = getCountryCodeSource().hashCode();
            int hashCode5 = (getPreferredDomesticCarrierCode().hashCode() + ((hashCode4 + ((hashCode3 + ((numberOfLeadingZeros + ((hashCode2 + i2) * 53)) * 53)) * 53)) * 53)) * 53;
            if (hasPreferredDomesticCarrierCode()) {
                i3 = 1231;
            }
            return hashCode5 + i3;
        }

        public boolean isItalianLeadingZero() {
            return this.k;
        }

        public PhoneNumber mergeFrom(PhoneNumber phoneNumber) {
            if (phoneNumber.hasCountryCode()) {
                setCountryCode(phoneNumber.getCountryCode());
            }
            if (phoneNumber.hasNationalNumber()) {
                setNationalNumber(phoneNumber.getNationalNumber());
            }
            if (phoneNumber.hasExtension()) {
                setExtension(phoneNumber.getExtension());
            }
            if (phoneNumber.hasItalianLeadingZero()) {
                setItalianLeadingZero(phoneNumber.isItalianLeadingZero());
            }
            if (phoneNumber.hasNumberOfLeadingZeros()) {
                setNumberOfLeadingZeros(phoneNumber.getNumberOfLeadingZeros());
            }
            if (phoneNumber.hasRawInput()) {
                setRawInput(phoneNumber.getRawInput());
            }
            if (phoneNumber.hasCountryCodeSource()) {
                setCountryCodeSource(phoneNumber.getCountryCodeSource());
            }
            if (phoneNumber.hasPreferredDomesticCarrierCode()) {
                setPreferredDomesticCarrierCode(phoneNumber.getPreferredDomesticCarrierCode());
            }
            return this;
        }

        public PhoneNumber setCountryCode(int i2) {
            this.c = true;
            this.d = i2;
            return this;
        }

        public PhoneNumber setCountryCodeSource(CountryCodeSource countryCodeSource) {
            countryCodeSource.getClass();
            this.p = true;
            this.q = countryCodeSource;
            return this;
        }

        public PhoneNumber setExtension(String str) {
            str.getClass();
            this.g = true;
            this.i = str;
            return this;
        }

        public PhoneNumber setItalianLeadingZero(boolean z) {
            this.j = true;
            this.k = z;
            return this;
        }

        public PhoneNumber setNationalNumber(long j2) {
            this.e = true;
            this.f = j2;
            return this;
        }

        public PhoneNumber setNumberOfLeadingZeros(int i2) {
            this.l = true;
            this.m = i2;
            return this;
        }

        public PhoneNumber setPreferredDomesticCarrierCode(String str) {
            str.getClass();
            this.r = true;
            this.s = str;
            return this;
        }

        public PhoneNumber setRawInput(String str) {
            str.getClass();
            this.n = true;
            this.o = str;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Country Code: ");
            sb.append(this.d);
            sb.append(" National Number: ");
            sb.append(this.f);
            if (hasItalianLeadingZero() && isItalianLeadingZero()) {
                sb.append(" Leading Zero(s): true");
            }
            if (hasNumberOfLeadingZeros()) {
                sb.append(" Number of leading zeros: ");
                sb.append(this.m);
            }
            if (hasExtension()) {
                sb.append(" Extension: ");
                sb.append(this.i);
            }
            if (hasCountryCodeSource()) {
                sb.append(" Country Code Source: ");
                sb.append(this.q);
            }
            if (hasPreferredDomesticCarrierCode()) {
                sb.append(" Preferred Domestic Carrier Code: ");
                sb.append(this.s);
            }
            return sb.toString();
        }
    }
}
