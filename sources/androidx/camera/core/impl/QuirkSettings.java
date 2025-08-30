package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class QuirkSettings {
    private final boolean mEnabledWhenDeviceHasQuirk;
    private final Set<Class<? extends Quirk>> mForceDisabledQuirks;
    private final Set<Class<? extends Quirk>> mForceEnabledQuirks;

    public static class Builder {
        private boolean mEnabledWhenDeviceHasQuirk = true;
        private Set<Class<? extends Quirk>> mForceDisabledQuirks;
        private Set<Class<? extends Quirk>> mForceEnabledQuirks;

        @NonNull
        public QuirkSettings build() {
            return new QuirkSettings(this.mEnabledWhenDeviceHasQuirk, this.mForceEnabledQuirks, this.mForceDisabledQuirks);
        }

        @NonNull
        public Builder forceDisableQuirks(@NonNull Set<Class<? extends Quirk>> set) {
            this.mForceDisabledQuirks = new HashSet(set);
            return this;
        }

        @NonNull
        public Builder forceEnableQuirks(@NonNull Set<Class<? extends Quirk>> set) {
            this.mForceEnabledQuirks = new HashSet(set);
            return this;
        }

        @NonNull
        public Builder setEnabledWhenDeviceHasQuirk(boolean z) {
            this.mEnabledWhenDeviceHasQuirk = z;
            return this;
        }
    }

    @NonNull
    public static QuirkSettings withAllQuirksDisabled() {
        return new Builder().setEnabledWhenDeviceHasQuirk(false).build();
    }

    @NonNull
    public static QuirkSettings withDefaultBehavior() {
        return new Builder().setEnabledWhenDeviceHasQuirk(true).build();
    }

    @NonNull
    public static QuirkSettings withQuirksForceDisabled(@NonNull Set<Class<? extends Quirk>> set) {
        return new Builder().forceDisableQuirks(set).build();
    }

    @NonNull
    public static QuirkSettings withQuirksForceEnabled(@NonNull Set<Class<? extends Quirk>> set) {
        return new Builder().forceEnableQuirks(set).build();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof QuirkSettings)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        QuirkSettings quirkSettings = (QuirkSettings) obj;
        if (this.mEnabledWhenDeviceHasQuirk != quirkSettings.mEnabledWhenDeviceHasQuirk || !Objects.equals(this.mForceEnabledQuirks, quirkSettings.mForceEnabledQuirks) || !Objects.equals(this.mForceDisabledQuirks, quirkSettings.mForceDisabledQuirks)) {
            return false;
        }
        return true;
    }

    @NonNull
    public Set<Class<? extends Quirk>> getForceDisabledQuirks() {
        return Collections.unmodifiableSet(this.mForceDisabledQuirks);
    }

    @NonNull
    public Set<Class<? extends Quirk>> getForceEnabledQuirks() {
        return Collections.unmodifiableSet(this.mForceEnabledQuirks);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.mEnabledWhenDeviceHasQuirk), this.mForceEnabledQuirks, this.mForceDisabledQuirks});
    }

    public boolean isEnabledWhenDeviceHasQuirk() {
        return this.mEnabledWhenDeviceHasQuirk;
    }

    public boolean shouldEnableQuirk(@NonNull Class<? extends Quirk> cls, boolean z) {
        if (this.mForceEnabledQuirks.contains(cls)) {
            return true;
        }
        if (!this.mForceDisabledQuirks.contains(cls) && this.mEnabledWhenDeviceHasQuirk && z) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "QuirkSettings{enabledWhenDeviceHasQuirk=" + this.mEnabledWhenDeviceHasQuirk + ", forceEnabledQuirks=" + this.mForceEnabledQuirks + ", forceDisabledQuirks=" + this.mForceDisabledQuirks + '}';
    }

    private QuirkSettings(boolean z, @Nullable Set<Class<? extends Quirk>> set, @Nullable Set<Class<? extends Quirk>> set2) {
        this.mEnabledWhenDeviceHasQuirk = z;
        this.mForceEnabledQuirks = set == null ? Collections.emptySet() : new HashSet<>(set);
        this.mForceDisabledQuirks = set2 == null ? Collections.emptySet() : new HashSet<>(set2);
    }
}
