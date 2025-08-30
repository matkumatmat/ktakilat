package com.appsflyer.internal;

import android.content.Intent;
import android.os.Parcelable;
import com.appsflyer.AFLogger;
import java.util.ConcurrentModificationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAFIntentWrapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AFIntentWrapper.kt\ncom/appsflyer/internal/util/AFIntentWrapper\n+ 2 MultiCatch.kt\ncom/appsflyer/internal/util/MultiCatchKt\n*L\n1#1,111:1\n16#2,7:112\n*S KotlinDebug\n*F\n+ 1 AFIntentWrapper.kt\ncom/appsflyer/internal/util/AFIntentWrapper\n*L\n84#1:112,7\n*E\n"})
public final class AFj1jSDK {
    @NotNull
    final Intent getCurrencyIso4217Code;

    public AFj1jSDK(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        this.getCurrencyIso4217Code = intent;
    }

    @Nullable
    public final <T extends Parcelable> T H_(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (Parcelable) getMonetizationNetwork(new Function0<T>(this) {
            private /* synthetic */ AFj1jSDK AFAdRevenueData;

            {
                this.AFAdRevenueData = r1;
            }

            @Nullable
            /* renamed from: J_ */
            public final T invoke() {
                return this.AFAdRevenueData.getCurrencyIso4217Code.getParcelableExtra(str);
            }
        }, ba.o("Error while trying to read ", str, " extra from intent"), (Object) null, true);
    }

    @Nullable
    public final Intent I_(@NotNull final String str, final long j) {
        Intrinsics.checkNotNullParameter(str, "");
        return (Intent) getMonetizationNetwork(new Function0<Intent>(this) {
            private /* synthetic */ AFj1jSDK getMediationNetwork;

            {
                this.getMediationNetwork = r1;
            }

            @NotNull
            /* renamed from: K_ */
            public final Intent invoke() {
                return this.getMediationNetwork.getCurrencyIso4217Code.putExtra(str, j);
            }
        }, ba.o("Error while trying to write ", str, " extra to intent"), (Object) null, true);
    }

    public final boolean getMonetizationNetwork(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Boolean bool = (Boolean) getMonetizationNetwork(new Function0<Boolean>(this) {
            private /* synthetic */ AFj1jSDK AFAdRevenueData;

            {
                this.AFAdRevenueData = r1;
            }

            @NotNull
            /* renamed from: getCurrencyIso4217Code */
            public final Boolean invoke() {
                return Boolean.valueOf(this.AFAdRevenueData.getCurrencyIso4217Code.hasExtra(str));
            }
        }, ba.o("Error while trying to check presence of ", str, " extra from intent"), Boolean.TRUE, true);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Nullable
    public final String getRevenue(@NotNull final String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (String) getMonetizationNetwork(new Function0<String>(this) {
            private /* synthetic */ AFj1jSDK getMediationNetwork;

            {
                this.getMediationNetwork = r1;
            }

            @Nullable
            /* renamed from: getMediationNetwork */
            public final String invoke() {
                return this.getMediationNetwork.getCurrencyIso4217Code.getStringExtra(str);
            }
        }, ba.o("Error while trying to read ", str, " extra from intent"), (Object) null, true);
    }

    private final <T> T getMonetizationNetwork(Function0<? extends T> function0, String str, T t, boolean z) {
        T t2;
        T t3;
        T t4;
        synchronized (this.getCurrencyIso4217Code) {
            try {
                Result.Companion companion = Result.Companion;
                t2 = Result.m16constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                t2 = Result.m16constructorimpl(ResultKt.a(th));
            }
            KClass[] kClassArr = {Reflection.a(ConcurrentModificationException.class), Reflection.a(ArrayIndexOutOfBoundsException.class)};
            Throwable r3 = Result.m19exceptionOrNullimpl(t2);
            if (r3 != null) {
                try {
                    if (ArraysKt.h(kClassArr, Reflection.a(r3.getClass()))) {
                        if (z) {
                            t4 = getMonetizationNetwork(function0, str, t, false);
                        } else {
                            AFLogger.afErrorLog(str, r3, false, false);
                            t4 = t;
                        }
                        t3 = Result.m16constructorimpl(t4);
                        t2 = t3;
                    } else {
                        throw r3;
                    }
                } catch (Throwable th2) {
                    Result.Companion companion3 = Result.Companion;
                    t3 = Result.m16constructorimpl(ResultKt.a(th2));
                }
            }
            Throwable r7 = Result.m19exceptionOrNullimpl(t2);
            if (r7 == null) {
                t = t2;
            } else {
                AFLogger.afErrorLog(str, r7, false, false);
            }
        }
        return t;
    }
}
