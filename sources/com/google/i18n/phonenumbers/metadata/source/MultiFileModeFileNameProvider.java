package com.google.i18n.phonenumbers.metadata.source;

public final class MultiFileModeFileNameProvider implements PhoneMetadataFileNameProvider {

    /* renamed from: a  reason: collision with root package name */
    public final String f330a;

    public MultiFileModeFileNameProvider(String str) {
        this.f330a = str.concat("_");
    }

    public final String a(Object obj) {
        String obj2 = obj.toString();
        if (!(obj2 == null || obj2.length() == 0)) {
            int length = obj2.length();
            int i = 0;
            while (i < length) {
                int codePointAt = obj2.codePointAt(i);
                if (Character.isLetterOrDigit(codePointAt)) {
                    i += Character.charCount(codePointAt);
                }
            }
            return this.f330a + obj;
        }
        throw new IllegalArgumentException(e.B("Invalid key: ", obj2));
    }
}
