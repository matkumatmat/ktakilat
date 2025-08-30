package androidx.datastore.core;

import androidx.datastore.core.DataStoreImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowOperator;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", i = {}, l = {134, 135}, m = "invokeSuspend", n = {}, s = {})
public final class DataStoreImpl$incrementCollector$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$2$1(DataStoreImpl<T> dataStoreImpl, Continuation<? super DataStoreImpl$incrementCollector$2$1> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DataStoreImpl$incrementCollector$2$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Flow flow;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            DataStoreImpl.InitDataStore access$getReadAndInit$p = this.this$0.readAndInit;
            this.label = 1;
            if (access$getReadAndInit$p.awaitComplete(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            ResultKt.b(obj);
        } else if (i == 2) {
            ResultKt.b(obj);
            return Unit.f696a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Flow<Unit> updateNotifications = this.this$0.getCoordinator().getUpdateNotifications();
        BufferOverflow bufferOverflow = BufferOverflow.DROP_OLDEST;
        if (updateNotifications instanceof FusibleFlow) {
            flow = FusibleFlow.DefaultImpls.a((FusibleFlow) updateNotifications, (MainCoroutineDispatcher) null, 0, bufferOverflow, 1);
        } else {
            flow = new ChannelFlowOperator(updateNotifications, EmptyCoroutineContext.INSTANCE, 0, bufferOverflow);
        }
        final DataStoreImpl<T> dataStoreImpl = this.this$0;
        AnonymousClass1 r1 = new FlowCollector() {
            @Nullable
            public final Object emit(@NotNull Unit unit, @NotNull Continuation<? super Unit> continuation) {
                if (dataStoreImpl.inMemoryCache.getCurrentState() instanceof Final) {
                    return Unit.f696a;
                }
                Object access$readDataAndUpdateCache = dataStoreImpl.readDataAndUpdateCache(true, continuation);
                if (access$readDataAndUpdateCache == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return access$readDataAndUpdateCache;
                }
                return Unit.f696a;
            }
        };
        this.label = 2;
        if (flow.collect(r1, this) == coroutineSingletons) {
            return coroutineSingletons;
        }
        return Unit.f696a;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DataStoreImpl$incrementCollector$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f696a);
    }
}
