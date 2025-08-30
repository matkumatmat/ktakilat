package com.appsflyer;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB9\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\f\u0010\nJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÇ\u0003¢\u0006\u0004\b\r\u0010\nJ@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÇ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016H×\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001c\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u0003\u0010\n"}, d2 = {"Lcom/appsflyer/AppsFlyerConsent;", "", "", "isUserSubjectToGDPR", "hasConsentForDataUsage", "hasConsentForAdsPersonalization", "hasConsentForAdStorage", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "component1", "()Ljava/lang/Boolean;", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/appsflyer/AppsFlyerConsent;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getHasConsentForAdStorage", "getHasConsentForAdsPersonalization", "getHasConsentForDataUsage", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppsFlyerConsent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private final Boolean hasConsentForAdStorage;
    @Nullable
    private final Boolean hasConsentForAdsPersonalization;
    @Nullable
    private final Boolean hasConsentForDataUsage;
    @Nullable
    private final Boolean isUserSubjectToGDPR;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/appsflyer/AppsFlyerConsent$Companion;", "", "<init>", "()V", "", "hasConsentForDataUsage", "hasConsentForAdsPersonalization", "Lcom/appsflyer/AppsFlyerConsent;", "forGDPRUser", "(ZZ)Lcom/appsflyer/AppsFlyerConsent;", "forNonGDPRUser", "()Lcom/appsflyer/AppsFlyerConsent;"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated since v6.16.1. Please use direct constructor invocation.", replaceWith = @ReplaceWith(expression = "AppsFlyerConsent()", imports = {}))
        public final AppsFlyerConsent forGDPRUser(boolean z, boolean z2) {
            return new AppsFlyerConsent(Boolean.TRUE, Boolean.valueOf(z), Boolean.valueOf(z2), (Boolean) null, 8, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated since v6.16.1. Please use direct constructor invocation.", replaceWith = @ReplaceWith(expression = "AppsFlyerConsent()", imports = {}))
        public final AppsFlyerConsent forNonGDPRUser() {
            return new AppsFlyerConsent(Boolean.FALSE, (Boolean) null, (Boolean) null, (Boolean) null, 8, (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public AppsFlyerConsent(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4) {
        this.isUserSubjectToGDPR = bool;
        this.hasConsentForDataUsage = bool2;
        this.hasConsentForAdsPersonalization = bool3;
        this.hasConsentForAdStorage = bool4;
    }

    public static /* synthetic */ AppsFlyerConsent copy$default(AppsFlyerConsent appsFlyerConsent, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = appsFlyerConsent.isUserSubjectToGDPR;
        }
        if ((i & 2) != 0) {
            bool2 = appsFlyerConsent.hasConsentForDataUsage;
        }
        if ((i & 4) != 0) {
            bool3 = appsFlyerConsent.hasConsentForAdsPersonalization;
        }
        if ((i & 8) != 0) {
            bool4 = appsFlyerConsent.hasConsentForAdStorage;
        }
        return appsFlyerConsent.copy(bool, bool2, bool3, bool4);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated since v6.16.1. Please use direct constructor invocation.", replaceWith = @ReplaceWith(expression = "AppsFlyerConsent()", imports = {}))
    public static final AppsFlyerConsent forGDPRUser(boolean z, boolean z2) {
        return Companion.forGDPRUser(z, z2);
    }

    @JvmStatic
    @NotNull
    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated since v6.16.1. Please use direct constructor invocation.", replaceWith = @ReplaceWith(expression = "AppsFlyerConsent()", imports = {}))
    public static final AppsFlyerConsent forNonGDPRUser() {
        return Companion.forNonGDPRUser();
    }

    @Nullable
    public final Boolean component1() {
        return this.isUserSubjectToGDPR;
    }

    @Nullable
    public final Boolean component2() {
        return this.hasConsentForDataUsage;
    }

    @Nullable
    public final Boolean component3() {
        return this.hasConsentForAdsPersonalization;
    }

    @Nullable
    public final Boolean component4() {
        return this.hasConsentForAdStorage;
    }

    @NotNull
    public final AppsFlyerConsent copy(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4) {
        return new AppsFlyerConsent(bool, bool2, bool3, bool4);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppsFlyerConsent)) {
            return false;
        }
        AppsFlyerConsent appsFlyerConsent = (AppsFlyerConsent) obj;
        if (Intrinsics.a(this.isUserSubjectToGDPR, appsFlyerConsent.isUserSubjectToGDPR) && Intrinsics.a(this.hasConsentForDataUsage, appsFlyerConsent.hasConsentForDataUsage) && Intrinsics.a(this.hasConsentForAdsPersonalization, appsFlyerConsent.hasConsentForAdsPersonalization) && Intrinsics.a(this.hasConsentForAdStorage, appsFlyerConsent.hasConsentForAdStorage)) {
            return true;
        }
        return false;
    }

    @Nullable
    @JvmName(name = "getHasConsentForAdStorage")
    public final Boolean getHasConsentForAdStorage() {
        return this.hasConsentForAdStorage;
    }

    @Nullable
    @JvmName(name = "getHasConsentForAdsPersonalization")
    public final Boolean getHasConsentForAdsPersonalization() {
        return this.hasConsentForAdsPersonalization;
    }

    @Nullable
    @JvmName(name = "getHasConsentForDataUsage")
    public final Boolean getHasConsentForDataUsage() {
        return this.hasConsentForDataUsage;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        Boolean bool = this.isUserSubjectToGDPR;
        int i4 = 0;
        if (bool == null) {
            i = 0;
        } else {
            i = bool.hashCode();
        }
        int i5 = i * 31;
        Boolean bool2 = this.hasConsentForDataUsage;
        if (bool2 == null) {
            i2 = 0;
        } else {
            i2 = bool2.hashCode();
        }
        int i6 = (i5 + i2) * 31;
        Boolean bool3 = this.hasConsentForAdsPersonalization;
        if (bool3 == null) {
            i3 = 0;
        } else {
            i3 = bool3.hashCode();
        }
        int i7 = (i6 + i3) * 31;
        Boolean bool4 = this.hasConsentForAdStorage;
        if (bool4 != null) {
            i4 = bool4.hashCode();
        }
        return i7 + i4;
    }

    @Nullable
    @JvmName(name = "isUserSubjectToGDPR")
    public final Boolean isUserSubjectToGDPR() {
        return this.isUserSubjectToGDPR;
    }

    @NotNull
    public final String toString() {
        Boolean bool = this.isUserSubjectToGDPR;
        Boolean bool2 = this.hasConsentForDataUsage;
        Boolean bool3 = this.hasConsentForAdsPersonalization;
        Boolean bool4 = this.hasConsentForAdStorage;
        return "AppsFlyerConsent(isUserSubjectToGDPR=" + bool + ", hasConsentForDataUsage=" + bool2 + ", hasConsentForAdsPersonalization=" + bool3 + ", hasConsentForAdStorage=" + bool4 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppsFlyerConsent(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : bool4);
    }

    @JvmOverloads
    public AppsFlyerConsent() {
        this((Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public AppsFlyerConsent(@Nullable Boolean bool) {
        this(bool, (Boolean) null, (Boolean) null, (Boolean) null, 14, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public AppsFlyerConsent(@Nullable Boolean bool, @Nullable Boolean bool2) {
        this(bool, bool2, (Boolean) null, (Boolean) null, 12, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public AppsFlyerConsent(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        this(bool, bool2, bool3, (Boolean) null, 8, (DefaultConstructorMarker) null);
    }
}
