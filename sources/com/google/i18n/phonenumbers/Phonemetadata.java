package com.google.i18n.phonenumbers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public final class Phonemetadata {

    public static class NumberFormat implements Externalizable {
        private static final long serialVersionUID = 1;
        public boolean c;
        public String d = "";
        public boolean e;
        public String f = "";
        public final ArrayList g = new ArrayList();
        public boolean i;
        public String j = "";
        public boolean k;
        public boolean l = false;
        public boolean m;
        public String n = "";

        public static final class Builder extends NumberFormat {
            public NumberFormat build() {
                return this;
            }

            public Builder mergeFrom(NumberFormat numberFormat) {
                if (numberFormat.hasPattern()) {
                    setPattern(numberFormat.getPattern());
                }
                if (numberFormat.hasFormat()) {
                    setFormat(numberFormat.getFormat());
                }
                for (int i = 0; i < numberFormat.leadingDigitsPatternSize(); i++) {
                    addLeadingDigitsPattern(numberFormat.getLeadingDigitsPattern(i));
                }
                if (numberFormat.hasNationalPrefixFormattingRule()) {
                    setNationalPrefixFormattingRule(numberFormat.getNationalPrefixFormattingRule());
                }
                if (numberFormat.hasDomesticCarrierCodeFormattingRule()) {
                    setDomesticCarrierCodeFormattingRule(numberFormat.getDomesticCarrierCodeFormattingRule());
                }
                if (numberFormat.hasNationalPrefixOptionalWhenFormatting()) {
                    setNationalPrefixOptionalWhenFormatting(numberFormat.getNationalPrefixOptionalWhenFormatting());
                }
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public NumberFormat addLeadingDigitsPattern(String str) {
            str.getClass();
            this.g.add(str);
            return this;
        }

        public NumberFormat clearNationalPrefixFormattingRule() {
            this.i = false;
            this.j = "";
            return this;
        }

        public String getDomesticCarrierCodeFormattingRule() {
            return this.n;
        }

        public String getFormat() {
            return this.f;
        }

        public String getLeadingDigitsPattern(int i2) {
            return (String) this.g.get(i2);
        }

        public int getLeadingDigitsPatternCount() {
            return this.g.size();
        }

        public String getNationalPrefixFormattingRule() {
            return this.j;
        }

        public boolean getNationalPrefixOptionalWhenFormatting() {
            return this.l;
        }

        public String getPattern() {
            return this.d;
        }

        public boolean hasDomesticCarrierCodeFormattingRule() {
            return this.m;
        }

        public boolean hasFormat() {
            return this.e;
        }

        public boolean hasNationalPrefixFormattingRule() {
            return this.i;
        }

        public boolean hasNationalPrefixOptionalWhenFormatting() {
            return this.k;
        }

        public boolean hasPattern() {
            return this.c;
        }

        public List<String> leadingDigitPatterns() {
            return this.g;
        }

        @Deprecated
        public int leadingDigitsPatternSize() {
            return getLeadingDigitsPatternCount();
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            setPattern(objectInput.readUTF());
            setFormat(objectInput.readUTF());
            int readInt = objectInput.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                this.g.add(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefixFormattingRule(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setDomesticCarrierCodeFormattingRule(objectInput.readUTF());
            }
            setNationalPrefixOptionalWhenFormatting(objectInput.readBoolean());
        }

        public NumberFormat setDomesticCarrierCodeFormattingRule(String str) {
            this.m = true;
            this.n = str;
            return this;
        }

        public NumberFormat setFormat(String str) {
            this.e = true;
            this.f = str;
            return this;
        }

        public NumberFormat setNationalPrefixFormattingRule(String str) {
            this.i = true;
            this.j = str;
            return this;
        }

        public NumberFormat setNationalPrefixOptionalWhenFormatting(boolean z) {
            this.k = true;
            this.l = z;
            return this;
        }

        public NumberFormat setPattern(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeUTF(this.d);
            objectOutput.writeUTF(this.f);
            int leadingDigitsPatternSize = leadingDigitsPatternSize();
            objectOutput.writeInt(leadingDigitsPatternSize);
            for (int i2 = 0; i2 < leadingDigitsPatternSize; i2++) {
                objectOutput.writeUTF((String) this.g.get(i2));
            }
            objectOutput.writeBoolean(this.i);
            if (this.i) {
                objectOutput.writeUTF(this.j);
            }
            objectOutput.writeBoolean(this.m);
            if (this.m) {
                objectOutput.writeUTF(this.n);
            }
            objectOutput.writeBoolean(this.l);
        }
    }

    public static class PhoneMetadata implements Externalizable {
        private static final long serialVersionUID = 1;
        public PhoneNumberDesc A = null;
        public boolean B;
        public PhoneNumberDesc C = null;
        public boolean D;
        public PhoneNumberDesc E = null;
        public boolean F;
        public PhoneNumberDesc G = null;
        public boolean H;
        public PhoneNumberDesc I = null;
        public boolean J;
        public PhoneNumberDesc K = null;
        public boolean L;
        public String M = "";
        public boolean N;
        public int O = 0;
        public boolean P;
        public String Q = "";
        public boolean R;
        public String S = "";
        public boolean T;
        public String U = "";
        public boolean V;
        public String W = "";
        public boolean X;
        public String Y = "";
        public boolean Z;
        public String a0 = "";
        public boolean b0;
        public boolean c;
        public boolean c0 = false;
        public PhoneNumberDesc d = null;
        public final ArrayList d0 = new ArrayList();
        public boolean e;
        public final ArrayList e0 = new ArrayList();
        public PhoneNumberDesc f = null;
        public boolean f0;
        public boolean g;
        public boolean g0 = false;
        public boolean h0;
        public PhoneNumberDesc i = null;
        public String i0 = "";
        public boolean j;
        public boolean j0;
        public PhoneNumberDesc k = null;
        public boolean k0 = false;
        public boolean l;
        public PhoneNumberDesc m = null;
        public boolean n;
        public PhoneNumberDesc o = null;
        public boolean p;
        public PhoneNumberDesc q = null;
        public boolean r;
        public PhoneNumberDesc s = null;
        public boolean t;
        public PhoneNumberDesc u = null;
        public boolean v;
        public PhoneNumberDesc w = null;
        public boolean x;
        public PhoneNumberDesc y = null;
        public boolean z;

        public static final class Builder extends PhoneMetadata {
            public PhoneMetadata build() {
                return this;
            }

            public Builder setId(String str) {
                super.setId(str);
                return this;
            }

            public Builder setInternationalPrefix(String str) {
                super.setInternationalPrefix(str);
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public PhoneMetadata addIntlNumberFormat(NumberFormat numberFormat) {
            numberFormat.getClass();
            this.e0.add(numberFormat);
            return this;
        }

        public PhoneMetadata addNumberFormat(NumberFormat numberFormat) {
            numberFormat.getClass();
            this.d0.add(numberFormat);
            return this;
        }

        public PhoneMetadata clearIntlNumberFormat() {
            this.e0.clear();
            return this;
        }

        public PhoneMetadata clearMainCountryForCode() {
            this.f0 = false;
            this.g0 = false;
            return this;
        }

        public PhoneMetadata clearMobileNumberPortableRegion() {
            this.j0 = false;
            this.k0 = false;
            return this;
        }

        public PhoneMetadata clearNationalPrefix() {
            this.T = false;
            this.U = "";
            return this;
        }

        public PhoneMetadata clearNationalPrefixTransformRule() {
            this.Z = false;
            this.a0 = "";
            return this;
        }

        public PhoneMetadata clearPreferredExtnPrefix() {
            this.V = false;
            this.W = "";
            return this;
        }

        public PhoneMetadata clearPreferredInternationalPrefix() {
            this.R = false;
            this.S = "";
            return this;
        }

        public PhoneMetadata clearSameMobileAndFixedLinePattern() {
            this.b0 = false;
            this.c0 = false;
            return this;
        }

        public PhoneNumberDesc getCarrierSpecific() {
            return this.G;
        }

        public int getCountryCode() {
            return this.O;
        }

        public PhoneNumberDesc getEmergency() {
            return this.y;
        }

        public PhoneNumberDesc getFixedLine() {
            return this.f;
        }

        public PhoneNumberDesc getGeneralDesc() {
            return this.d;
        }

        public PhoneNumberDesc getGeneralDescBuilder() {
            if (this.d == null) {
                this.d = new PhoneNumberDesc();
            }
            return this.d;
        }

        public String getId() {
            return this.M;
        }

        public String getInternationalPrefix() {
            return this.Q;
        }

        public NumberFormat getIntlNumberFormat(int i2) {
            return (NumberFormat) this.e0.get(i2);
        }

        public int getIntlNumberFormatCount() {
            return this.e0.size();
        }

        public List<NumberFormat> getIntlNumberFormatList() {
            return this.e0;
        }

        public String getLeadingDigits() {
            return this.i0;
        }

        public boolean getMainCountryForCode() {
            return this.g0;
        }

        public PhoneNumberDesc getMobile() {
            return this.i;
        }

        public boolean getMobileNumberPortableRegion() {
            return this.k0;
        }

        public String getNationalPrefix() {
            return this.U;
        }

        public String getNationalPrefixForParsing() {
            return this.Y;
        }

        public String getNationalPrefixTransformRule() {
            return this.a0;
        }

        public PhoneNumberDesc getNoInternationalDialling() {
            return this.K;
        }

        public NumberFormat getNumberFormat(int i2) {
            return (NumberFormat) this.d0.get(i2);
        }

        public int getNumberFormatCount() {
            return this.d0.size();
        }

        public List<NumberFormat> getNumberFormatList() {
            return this.d0;
        }

        public PhoneNumberDesc getPager() {
            return this.u;
        }

        public PhoneNumberDesc getPersonalNumber() {
            return this.q;
        }

        public String getPreferredExtnPrefix() {
            return this.W;
        }

        public String getPreferredInternationalPrefix() {
            return this.S;
        }

        public PhoneNumberDesc getPremiumRate() {
            return this.m;
        }

        public boolean getSameMobileAndFixedLinePattern() {
            return this.c0;
        }

        public PhoneNumberDesc getSharedCost() {
            return this.o;
        }

        public PhoneNumberDesc getShortCode() {
            return this.C;
        }

        public PhoneNumberDesc getSmsServices() {
            return this.I;
        }

        public PhoneNumberDesc getStandardRate() {
            return this.E;
        }

        public PhoneNumberDesc getTollFree() {
            return this.k;
        }

        public PhoneNumberDesc getUan() {
            return this.w;
        }

        public PhoneNumberDesc getVoicemail() {
            return this.A;
        }

        public PhoneNumberDesc getVoip() {
            return this.s;
        }

        public boolean hasCarrierSpecific() {
            return this.F;
        }

        public boolean hasCountryCode() {
            return this.N;
        }

        public boolean hasEmergency() {
            return this.x;
        }

        public boolean hasFixedLine() {
            return this.e;
        }

        public boolean hasGeneralDesc() {
            return this.c;
        }

        public boolean hasId() {
            return this.L;
        }

        public boolean hasInternationalPrefix() {
            return this.P;
        }

        public boolean hasLeadingDigits() {
            return this.h0;
        }

        public boolean hasMainCountryForCode() {
            return this.f0;
        }

        public boolean hasMobile() {
            return this.g;
        }

        public boolean hasMobileNumberPortableRegion() {
            return this.j0;
        }

        public boolean hasNationalPrefix() {
            return this.T;
        }

        public boolean hasNationalPrefixForParsing() {
            return this.X;
        }

        public boolean hasNationalPrefixTransformRule() {
            return this.Z;
        }

        public boolean hasNoInternationalDialling() {
            return this.J;
        }

        public boolean hasPager() {
            return this.t;
        }

        public boolean hasPersonalNumber() {
            return this.p;
        }

        public boolean hasPreferredExtnPrefix() {
            return this.V;
        }

        public boolean hasPreferredInternationalPrefix() {
            return this.R;
        }

        public boolean hasPremiumRate() {
            return this.l;
        }

        public boolean hasSameMobileAndFixedLinePattern() {
            return this.b0;
        }

        public boolean hasSharedCost() {
            return this.n;
        }

        public boolean hasShortCode() {
            return this.B;
        }

        public boolean hasSmsServices() {
            return this.H;
        }

        public boolean hasStandardRate() {
            return this.D;
        }

        public boolean hasTollFree() {
            return this.j;
        }

        public boolean hasUan() {
            return this.v;
        }

        public boolean hasVoicemail() {
            return this.z;
        }

        public boolean hasVoip() {
            return this.r;
        }

        @Deprecated
        public int intlNumberFormatSize() {
            return getIntlNumberFormatCount();
        }

        @Deprecated
        public List<NumberFormat> intlNumberFormats() {
            return getIntlNumberFormatList();
        }

        public boolean isMainCountryForCode() {
            return this.g0;
        }

        @Deprecated
        public boolean isMobileNumberPortableRegion() {
            return getMobileNumberPortableRegion();
        }

        @Deprecated
        public int numberFormatSize() {
            return getNumberFormatCount();
        }

        @Deprecated
        public List<NumberFormat> numberFormats() {
            return getNumberFormatList();
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc = new PhoneNumberDesc();
                phoneNumberDesc.readExternal(objectInput);
                setGeneralDesc(phoneNumberDesc);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc2 = new PhoneNumberDesc();
                phoneNumberDesc2.readExternal(objectInput);
                setFixedLine(phoneNumberDesc2);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc3 = new PhoneNumberDesc();
                phoneNumberDesc3.readExternal(objectInput);
                setMobile(phoneNumberDesc3);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc4 = new PhoneNumberDesc();
                phoneNumberDesc4.readExternal(objectInput);
                setTollFree(phoneNumberDesc4);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc5 = new PhoneNumberDesc();
                phoneNumberDesc5.readExternal(objectInput);
                setPremiumRate(phoneNumberDesc5);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc6 = new PhoneNumberDesc();
                phoneNumberDesc6.readExternal(objectInput);
                setSharedCost(phoneNumberDesc6);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc7 = new PhoneNumberDesc();
                phoneNumberDesc7.readExternal(objectInput);
                setPersonalNumber(phoneNumberDesc7);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc8 = new PhoneNumberDesc();
                phoneNumberDesc8.readExternal(objectInput);
                setVoip(phoneNumberDesc8);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc9 = new PhoneNumberDesc();
                phoneNumberDesc9.readExternal(objectInput);
                setPager(phoneNumberDesc9);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc10 = new PhoneNumberDesc();
                phoneNumberDesc10.readExternal(objectInput);
                setUan(phoneNumberDesc10);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc11 = new PhoneNumberDesc();
                phoneNumberDesc11.readExternal(objectInput);
                setEmergency(phoneNumberDesc11);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc12 = new PhoneNumberDesc();
                phoneNumberDesc12.readExternal(objectInput);
                setVoicemail(phoneNumberDesc12);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc13 = new PhoneNumberDesc();
                phoneNumberDesc13.readExternal(objectInput);
                setShortCode(phoneNumberDesc13);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc14 = new PhoneNumberDesc();
                phoneNumberDesc14.readExternal(objectInput);
                setStandardRate(phoneNumberDesc14);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc15 = new PhoneNumberDesc();
                phoneNumberDesc15.readExternal(objectInput);
                setCarrierSpecific(phoneNumberDesc15);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc16 = new PhoneNumberDesc();
                phoneNumberDesc16.readExternal(objectInput);
                setSmsServices(phoneNumberDesc16);
            }
            if (objectInput.readBoolean()) {
                PhoneNumberDesc phoneNumberDesc17 = new PhoneNumberDesc();
                phoneNumberDesc17.readExternal(objectInput);
                setNoInternationalDialling(phoneNumberDesc17);
            }
            setId(objectInput.readUTF());
            setCountryCode(objectInput.readInt());
            setInternationalPrefix(objectInput.readUTF());
            if (objectInput.readBoolean()) {
                setPreferredInternationalPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setPreferredExtnPrefix(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefixForParsing(objectInput.readUTF());
            }
            if (objectInput.readBoolean()) {
                setNationalPrefixTransformRule(objectInput.readUTF());
            }
            setSameMobileAndFixedLinePattern(objectInput.readBoolean());
            int readInt = objectInput.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                NumberFormat numberFormat = new NumberFormat();
                numberFormat.readExternal(objectInput);
                this.d0.add(numberFormat);
            }
            int readInt2 = objectInput.readInt();
            for (int i3 = 0; i3 < readInt2; i3++) {
                NumberFormat numberFormat2 = new NumberFormat();
                numberFormat2.readExternal(objectInput);
                this.e0.add(numberFormat2);
            }
            setMainCountryForCode(objectInput.readBoolean());
            if (objectInput.readBoolean()) {
                setLeadingDigits(objectInput.readUTF());
            }
            setMobileNumberPortableRegion(objectInput.readBoolean());
        }

        public PhoneMetadata setCarrierSpecific(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.F = true;
            this.G = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setCountryCode(int i2) {
            this.N = true;
            this.O = i2;
            return this;
        }

        public PhoneMetadata setEmergency(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.x = true;
            this.y = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setFixedLine(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.e = true;
            this.f = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setGeneralDesc(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.c = true;
            this.d = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setId(String str) {
            this.L = true;
            this.M = str;
            return this;
        }

        public PhoneMetadata setInternationalPrefix(String str) {
            this.P = true;
            this.Q = str;
            return this;
        }

        public PhoneMetadata setLeadingDigits(String str) {
            this.h0 = true;
            this.i0 = str;
            return this;
        }

        public PhoneMetadata setMainCountryForCode(boolean z2) {
            this.f0 = true;
            this.g0 = z2;
            return this;
        }

        public PhoneMetadata setMobile(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.g = true;
            this.i = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setMobileNumberPortableRegion(boolean z2) {
            this.j0 = true;
            this.k0 = z2;
            return this;
        }

        public PhoneMetadata setNationalPrefix(String str) {
            this.T = true;
            this.U = str;
            return this;
        }

        public PhoneMetadata setNationalPrefixForParsing(String str) {
            this.X = true;
            this.Y = str;
            return this;
        }

        public PhoneMetadata setNationalPrefixTransformRule(String str) {
            this.Z = true;
            this.a0 = str;
            return this;
        }

        public PhoneMetadata setNoInternationalDialling(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.J = true;
            this.K = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setPager(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.t = true;
            this.u = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setPersonalNumber(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.p = true;
            this.q = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setPreferredExtnPrefix(String str) {
            this.V = true;
            this.W = str;
            return this;
        }

        public PhoneMetadata setPreferredInternationalPrefix(String str) {
            this.R = true;
            this.S = str;
            return this;
        }

        public PhoneMetadata setPremiumRate(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.l = true;
            this.m = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setSameMobileAndFixedLinePattern(boolean z2) {
            this.b0 = true;
            this.c0 = z2;
            return this;
        }

        public PhoneMetadata setSharedCost(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.n = true;
            this.o = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setShortCode(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.B = true;
            this.C = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setSmsServices(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.H = true;
            this.I = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setStandardRate(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.D = true;
            this.E = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setTollFree(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.j = true;
            this.k = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setUan(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.v = true;
            this.w = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setVoicemail(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.z = true;
            this.A = phoneNumberDesc;
            return this;
        }

        public PhoneMetadata setVoip(PhoneNumberDesc phoneNumberDesc) {
            phoneNumberDesc.getClass();
            this.r = true;
            this.s = phoneNumberDesc;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.c);
            if (this.c) {
                this.d.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.e);
            if (this.e) {
                this.f.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.g);
            if (this.g) {
                this.i.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.j);
            if (this.j) {
                this.k.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.l);
            if (this.l) {
                this.m.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.n);
            if (this.n) {
                this.o.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.p);
            if (this.p) {
                this.q.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.r);
            if (this.r) {
                this.s.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.t);
            if (this.t) {
                this.u.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.v);
            if (this.v) {
                this.w.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.x);
            if (this.x) {
                this.y.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.z);
            if (this.z) {
                this.A.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.B);
            if (this.B) {
                this.C.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.D);
            if (this.D) {
                this.E.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.F);
            if (this.F) {
                this.G.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.H);
            if (this.H) {
                this.I.writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.J);
            if (this.J) {
                this.K.writeExternal(objectOutput);
            }
            objectOutput.writeUTF(this.M);
            objectOutput.writeInt(this.O);
            objectOutput.writeUTF(this.Q);
            objectOutput.writeBoolean(this.R);
            if (this.R) {
                objectOutput.writeUTF(this.S);
            }
            objectOutput.writeBoolean(this.T);
            if (this.T) {
                objectOutput.writeUTF(this.U);
            }
            objectOutput.writeBoolean(this.V);
            if (this.V) {
                objectOutput.writeUTF(this.W);
            }
            objectOutput.writeBoolean(this.X);
            if (this.X) {
                objectOutput.writeUTF(this.Y);
            }
            objectOutput.writeBoolean(this.Z);
            if (this.Z) {
                objectOutput.writeUTF(this.a0);
            }
            objectOutput.writeBoolean(this.c0);
            int numberFormatSize = numberFormatSize();
            objectOutput.writeInt(numberFormatSize);
            for (int i2 = 0; i2 < numberFormatSize; i2++) {
                ((NumberFormat) this.d0.get(i2)).writeExternal(objectOutput);
            }
            int intlNumberFormatSize = intlNumberFormatSize();
            objectOutput.writeInt(intlNumberFormatSize);
            for (int i3 = 0; i3 < intlNumberFormatSize; i3++) {
                ((NumberFormat) this.e0.get(i3)).writeExternal(objectOutput);
            }
            objectOutput.writeBoolean(this.g0);
            objectOutput.writeBoolean(this.h0);
            if (this.h0) {
                objectOutput.writeUTF(this.i0);
            }
            objectOutput.writeBoolean(this.k0);
        }
    }

    public static class PhoneMetadataCollection implements Externalizable {
        private static final long serialVersionUID = 1;
        public final ArrayList c = new ArrayList();

        public static final class Builder extends PhoneMetadataCollection {
            public PhoneMetadataCollection build() {
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public PhoneMetadataCollection addMetadata(PhoneMetadata phoneMetadata) {
            phoneMetadata.getClass();
            this.c.add(phoneMetadata);
            return this;
        }

        public PhoneMetadataCollection clear() {
            this.c.clear();
            return this;
        }

        public int getMetadataCount() {
            return this.c.size();
        }

        public List<PhoneMetadata> getMetadataList() {
            return this.c;
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            int readInt = objectInput.readInt();
            for (int i = 0; i < readInt; i++) {
                PhoneMetadata phoneMetadata = new PhoneMetadata();
                phoneMetadata.readExternal(objectInput);
                this.c.add(phoneMetadata);
            }
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            int metadataCount = getMetadataCount();
            objectOutput.writeInt(metadataCount);
            for (int i = 0; i < metadataCount; i++) {
                ((PhoneMetadata) this.c.get(i)).writeExternal(objectOutput);
            }
        }
    }

    public static class PhoneNumberDesc implements Externalizable {
        private static final long serialVersionUID = 1;
        public boolean c;
        public String d = "";
        public final ArrayList e = new ArrayList();
        public final ArrayList f = new ArrayList();
        public boolean g;
        public String i = "";

        public static final class Builder extends PhoneNumberDesc {
            public PhoneNumberDesc build() {
                return this;
            }

            public Builder mergeFrom(PhoneNumberDesc phoneNumberDesc) {
                if (phoneNumberDesc.hasNationalNumberPattern()) {
                    setNationalNumberPattern(phoneNumberDesc.getNationalNumberPattern());
                }
                for (int i = 0; i < phoneNumberDesc.getPossibleLengthCount(); i++) {
                    addPossibleLength(phoneNumberDesc.getPossibleLength(i));
                }
                for (int i2 = 0; i2 < phoneNumberDesc.getPossibleLengthLocalOnlyCount(); i2++) {
                    addPossibleLengthLocalOnly(phoneNumberDesc.getPossibleLengthLocalOnly(i2));
                }
                if (phoneNumberDesc.hasExampleNumber()) {
                    setExampleNumber(phoneNumberDesc.getExampleNumber());
                }
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public PhoneNumberDesc addPossibleLength(int i2) {
            this.e.add(Integer.valueOf(i2));
            return this;
        }

        public PhoneNumberDesc addPossibleLengthLocalOnly(int i2) {
            this.f.add(Integer.valueOf(i2));
            return this;
        }

        public PhoneNumberDesc clearExampleNumber() {
            this.g = false;
            this.i = "";
            return this;
        }

        public PhoneNumberDesc clearNationalNumberPattern() {
            this.c = false;
            this.d = "";
            return this;
        }

        public PhoneNumberDesc clearPossibleLength() {
            this.e.clear();
            return this;
        }

        public PhoneNumberDesc clearPossibleLengthLocalOnly() {
            this.f.clear();
            return this;
        }

        public boolean exactlySameAs(PhoneNumberDesc phoneNumberDesc) {
            if (!this.d.equals(phoneNumberDesc.d) || !this.e.equals(phoneNumberDesc.e) || !this.f.equals(phoneNumberDesc.f) || !this.i.equals(phoneNumberDesc.i)) {
                return false;
            }
            return true;
        }

        public String getExampleNumber() {
            return this.i;
        }

        public String getNationalNumberPattern() {
            return this.d;
        }

        public int getPossibleLength(int i2) {
            return ((Integer) this.e.get(i2)).intValue();
        }

        public int getPossibleLengthCount() {
            return this.e.size();
        }

        public List<Integer> getPossibleLengthList() {
            return this.e;
        }

        public int getPossibleLengthLocalOnly(int i2) {
            return ((Integer) this.f.get(i2)).intValue();
        }

        public int getPossibleLengthLocalOnlyCount() {
            return this.f.size();
        }

        public List<Integer> getPossibleLengthLocalOnlyList() {
            return this.f;
        }

        public boolean hasExampleNumber() {
            return this.g;
        }

        public boolean hasNationalNumberPattern() {
            return this.c;
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readBoolean()) {
                setNationalNumberPattern(objectInput.readUTF());
            }
            int readInt = objectInput.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                this.e.add(Integer.valueOf(objectInput.readInt()));
            }
            int readInt2 = objectInput.readInt();
            for (int i3 = 0; i3 < readInt2; i3++) {
                this.f.add(Integer.valueOf(objectInput.readInt()));
            }
            if (objectInput.readBoolean()) {
                setExampleNumber(objectInput.readUTF());
            }
        }

        public PhoneNumberDesc setExampleNumber(String str) {
            this.g = true;
            this.i = str;
            return this;
        }

        public PhoneNumberDesc setNationalNumberPattern(String str) {
            this.c = true;
            this.d = str;
            return this;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeBoolean(this.c);
            if (this.c) {
                objectOutput.writeUTF(this.d);
            }
            int possibleLengthCount = getPossibleLengthCount();
            objectOutput.writeInt(possibleLengthCount);
            for (int i2 = 0; i2 < possibleLengthCount; i2++) {
                objectOutput.writeInt(((Integer) this.e.get(i2)).intValue());
            }
            int possibleLengthLocalOnlyCount = getPossibleLengthLocalOnlyCount();
            objectOutput.writeInt(possibleLengthLocalOnlyCount);
            for (int i3 = 0; i3 < possibleLengthLocalOnlyCount; i3++) {
                objectOutput.writeInt(((Integer) this.f.get(i3)).intValue());
            }
            objectOutput.writeBoolean(this.g);
            if (this.g) {
                objectOutput.writeUTF(this.i);
            }
        }
    }
}
