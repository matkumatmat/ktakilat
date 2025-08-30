package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.CustomKeysAndValues;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0010¢\u0006\u0002\u0010\u0005B\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0011J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0013J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/crashlytics/KeyValueBuilder;", "", "crashlytics", "Lcom/google/firebase/crashlytics/FirebaseCrashlytics;", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;)V", "()V", "builder", "Lcom/google/firebase/crashlytics/CustomKeysAndValues$Builder;", "(Lcom/google/firebase/crashlytics/FirebaseCrashlytics;Lcom/google/firebase/crashlytics/CustomKeysAndValues$Builder;)V", "build", "Lcom/google/firebase/crashlytics/CustomKeysAndValues;", "build$com_google_firebase_firebase_crashlytics", "key", "", "", "value", "", "", "", "", "", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyValueBuilder {
    @NotNull
    private final CustomKeysAndValues.Builder builder;
    @Nullable
    private final FirebaseCrashlytics crashlytics;

    private KeyValueBuilder(FirebaseCrashlytics firebaseCrashlytics, CustomKeysAndValues.Builder builder2) {
        this.crashlytics = firebaseCrashlytics;
        this.builder = builder2;
    }

    @NotNull
    public final CustomKeysAndValues build$com_google_firebase_firebase_crashlytics() {
        CustomKeysAndValues build = this.builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    public final void key(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(str, z);
            Unit unit = Unit.f696a;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.builder.putBoolean(str, z), "builder.putBoolean(key, value)");
    }

    public final void key(@NotNull String str, double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(str, d);
            Unit unit = Unit.f696a;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.builder.putDouble(str, d), "builder.putDouble(key, value)");
    }

    public final void key(@NotNull String str, float f) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(str, f);
            Unit unit = Unit.f696a;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.builder.putFloat(str, f), "builder.putFloat(key, value)");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Do not construct this directly. Use `setCustomKeys` instead. To be removed in the next major release.")
    public KeyValueBuilder(@NotNull FirebaseCrashlytics firebaseCrashlytics) {
        this(firebaseCrashlytics, new CustomKeysAndValues.Builder());
        Intrinsics.checkNotNullParameter(firebaseCrashlytics, "crashlytics");
    }

    public final void key(@NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(str, i);
            Unit unit = Unit.f696a;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.builder.putInt(str, i), "builder.putInt(key, value)");
    }

    public KeyValueBuilder() {
        this((FirebaseCrashlytics) null, new CustomKeysAndValues.Builder());
    }

    public final void key(@NotNull String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(str, j);
            Unit unit = Unit.f696a;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.builder.putLong(str, j), "builder.putLong(key, value)");
    }

    public final void key(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        FirebaseCrashlytics firebaseCrashlytics = this.crashlytics;
        if (firebaseCrashlytics != null) {
            firebaseCrashlytics.setCustomKey(str, str2);
            Unit unit = Unit.f696a;
            return;
        }
        Intrinsics.checkNotNullExpressionValue(this.builder.putString(str, str2), "builder.putString(key, value)");
    }
}
