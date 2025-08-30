package com.google.firebase.crashlytics.internal.concurrency;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CrashlyticsWorkers$Companion$checkNotMainThread$2 extends Lambda implements Function0<String> {
    public static final CrashlyticsWorkers$Companion$checkNotMainThread$2 INSTANCE = new CrashlyticsWorkers$Companion$checkNotMainThread$2();

    public CrashlyticsWorkers$Companion$checkNotMainThread$2() {
        super(0);
    }

    @NotNull
    public final String invoke() {
        return "Must not be called on a main thread, was called on " + CrashlyticsWorkers.Companion.getThreadName() + ClassUtils.PACKAGE_SEPARATOR_CHAR;
    }
}
