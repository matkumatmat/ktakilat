package com.google.i18n.phonenumbers.internal;

import com.google.i18n.phonenumbers.Phonemetadata;
import java.util.regex.Matcher;

public final class RegexBasedMatcher implements MatcherApi {

    /* renamed from: a  reason: collision with root package name */
    public final RegexCache f319a = new RegexCache(100);

    public final boolean a(CharSequence charSequence, Phonemetadata.PhoneNumberDesc phoneNumberDesc) {
        String nationalNumberPattern = phoneNumberDesc.getNationalNumberPattern();
        if (nationalNumberPattern.length() == 0) {
            return false;
        }
        Matcher matcher = this.f319a.a(nationalNumberPattern).matcher(charSequence);
        if (!matcher.lookingAt()) {
            return false;
        }
        return matcher.matches();
    }
}
