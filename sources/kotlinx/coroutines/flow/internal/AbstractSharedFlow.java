package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "S", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAbstractSharedFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n+ 2 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 3 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,130:1\n27#2:131\n27#2:133\n27#2:136\n16#3:132\n16#3:134\n16#3:137\n1#4:135\n13346#5,2:138\n*S KotlinDebug\n*F\n+ 1 AbstractSharedFlow.kt\nkotlinx/coroutines/flow/internal/AbstractSharedFlow\n*L\n27#1:131\n42#1:133\n73#1:136\n27#1:132\n42#1:134\n73#1:137\n92#1:138,2\n*E\n"})
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    public AbstractSharedFlowSlot[] c;
    public int d;
    public int e;

    public final AbstractSharedFlowSlot c() {
        AbstractSharedFlowSlot abstractSharedFlowSlot;
        synchronized (this) {
            try {
                AbstractSharedFlowSlot[] abstractSharedFlowSlotArr = this.c;
                if (abstractSharedFlowSlotArr == null) {
                    abstractSharedFlowSlotArr = e();
                    this.c = abstractSharedFlowSlotArr;
                } else if (this.d >= abstractSharedFlowSlotArr.length) {
                    Object[] copyOf = Arrays.copyOf(abstractSharedFlowSlotArr, abstractSharedFlowSlotArr.length * 2);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                    this.c = (AbstractSharedFlowSlot[]) copyOf;
                    abstractSharedFlowSlotArr = (AbstractSharedFlowSlot[]) copyOf;
                }
                int i = this.e;
                do {
                    abstractSharedFlowSlot = abstractSharedFlowSlotArr[i];
                    if (abstractSharedFlowSlot == null) {
                        abstractSharedFlowSlot = d();
                        abstractSharedFlowSlotArr[i] = abstractSharedFlowSlot;
                    }
                    i++;
                    if (i >= abstractSharedFlowSlotArr.length) {
                        i = 0;
                    }
                } while (!abstractSharedFlowSlot.a(this));
                this.e = i;
                this.d++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return abstractSharedFlowSlot;
    }

    public abstract AbstractSharedFlowSlot d();

    public abstract AbstractSharedFlowSlot[] e();

    public final void f(AbstractSharedFlowSlot abstractSharedFlowSlot) {
        int i;
        Continuation[] b;
        synchronized (this) {
            try {
                int i2 = this.d - 1;
                this.d = i2;
                if (i2 == 0) {
                    this.e = 0;
                }
                Intrinsics.d(abstractSharedFlowSlot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                b = abstractSharedFlowSlot.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation continuation : b) {
            if (continuation != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m16constructorimpl(Unit.f696a));
            }
        }
    }
}
