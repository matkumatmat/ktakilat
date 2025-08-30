package kotlinx.coroutines;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.intrinsics.CancellableKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J[\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\b\u00072\u0006\u0010\t\u001a\u00028\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0002¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8FX\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/CoroutineStart;", "", "R", "T", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "receiver", "completion", "", "invoke", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "", "isLazy", "()Z", "isLazy$annotations", "()V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum CoroutineStart {
    ;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f765a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                kotlinx.coroutines.CoroutineStart[] r0 = kotlinx.coroutines.CoroutineStart.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.ATOMIC     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.CoroutineStart r1 = kotlinx.coroutines.CoroutineStart.LAZY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f765a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineStart.WhenMappings.<clinit>():void");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: kotlinx.coroutines.CoroutineStart[]} */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Enum, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARNING: type inference failed for: r5v1, types: [java.lang.Enum, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Enum, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Enum, kotlinx.coroutines.CoroutineStart] */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 3
            r1 = 2
            r2 = 1
            r3 = 0
            kotlinx.coroutines.CoroutineStart r4 = new kotlinx.coroutines.CoroutineStart
            java.lang.String r5 = "DEFAULT"
            r4.<init>(r5, r3)
            DEFAULT = r4
            kotlinx.coroutines.CoroutineStart r5 = new kotlinx.coroutines.CoroutineStart
            java.lang.String r6 = "LAZY"
            r5.<init>(r6, r2)
            LAZY = r5
            kotlinx.coroutines.CoroutineStart r6 = new kotlinx.coroutines.CoroutineStart
            java.lang.String r7 = "ATOMIC"
            r6.<init>(r7, r1)
            ATOMIC = r6
            kotlinx.coroutines.CoroutineStart r7 = new kotlinx.coroutines.CoroutineStart
            java.lang.String r8 = "UNDISPATCHED"
            r7.<init>(r8, r0)
            UNDISPATCHED = r7
            r8 = 4
            kotlinx.coroutines.CoroutineStart[] r8 = new kotlinx.coroutines.CoroutineStart[r8]
            r8[r3] = r4
            r8[r2] = r5
            r8[r1] = r6
            r8[r0] = r7
            c = r8
            kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r8)
            d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineStart.<clinit>():void");
    }

    @NotNull
    public static EnumEntries<CoroutineStart> getEntries() {
        return d;
    }

    @InternalCoroutinesApi
    public final <R, T> void invoke(@NotNull Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, @NotNull Continuation<? super T> continuation) {
        CoroutineContext context;
        Object c2;
        Object obj;
        int i = WhenMappings.f765a[ordinal()];
        if (i == 1) {
            CancellableKt.b(function2, r, continuation);
        } else if (i == 2) {
            Intrinsics.checkNotNullParameter(function2, "<this>");
            Intrinsics.checkNotNullParameter(continuation, "completion");
            Continuation b = IntrinsicsKt.b(IntrinsicsKt.a(function2, r, continuation));
            Result.Companion companion = Result.Companion;
            b.resumeWith(Result.m16constructorimpl(Unit.f696a));
        } else if (i == 3) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            try {
                context = continuation.getContext();
                c2 = ThreadContextKt.c(context, (Object) null);
                Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
                if (!(function2 instanceof BaseContinuationImpl)) {
                    obj = IntrinsicsKt.c(function2, r, continuation);
                } else {
                    TypeIntrinsics.c(2, function2);
                    obj = function2.invoke(r, continuation);
                }
                ThreadContextKt.a(context, c2);
                if (obj != CoroutineSingletons.COROUTINE_SUSPENDED) {
                    continuation.resumeWith(Result.m16constructorimpl(obj));
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(ResultKt.a(th)));
            }
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isLazy() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }
}
