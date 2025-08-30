package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", i = {}, l = {387, 388, 390}, m = "invokeSuspend", n = {}, s = {})
public final class DataStoreImpl$readDataOrHandleCorruption$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<T> $newData;
    final /* synthetic */ Ref.IntRef $version;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$3(Ref.ObjectRef<T> objectRef, DataStoreImpl<T> dataStoreImpl, Ref.IntRef intRef, Continuation<? super DataStoreImpl$readDataOrHandleCorruption$3> continuation) {
        super(1, continuation);
        this.$newData = objectRef;
        this.this$0 = dataStoreImpl;
        this.$version = intRef;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new DataStoreImpl$readDataOrHandleCorruption$3(this.$newData, this.this$0, this.$version, continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull T t) {
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Ref.ObjectRef<T> objectRef;
        T t2 = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            ResultKt.b(t);
            objectRef = this.$newData;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.L$0 = objectRef;
            this.label = 1;
            t = dataStoreImpl.readDataFromFileOrDefault(this);
            if (t == t2) {
                return t2;
            }
        } else if (i == 1) {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.b(t);
        } else if (i == 2) {
            intRef2 = (Ref.IntRef) this.L$0;
            try {
                ResultKt.b(t);
                intRef2.element = ((Number) t).intValue();
            } catch (CorruptionException unused) {
                Ref.IntRef intRef3 = this.$version;
                DataStoreImpl<T> dataStoreImpl2 = this.this$0;
                T t3 = this.$newData.element;
                this.L$0 = intRef3;
                this.label = 3;
                T writeData$datastore_core_release = dataStoreImpl2.writeData$datastore_core_release(t3, true, this);
                if (writeData$datastore_core_release == t2) {
                    return t2;
                }
                intRef = intRef3;
                t = writeData$datastore_core_release;
            }
            return Unit.f696a;
        } else if (i == 3) {
            intRef = (Ref.IntRef) this.L$0;
            ResultKt.b(t);
            intRef.element = ((Number) t).intValue();
            return Unit.f696a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef.element = t;
        intRef2 = this.$version;
        InterProcessCoordinator access$getCoordinator = this.this$0.getCoordinator();
        this.L$0 = intRef2;
        this.label = 2;
        t = access$getCoordinator.getVersion(this);
        if (t == t2) {
            return t2;
        }
        intRef2.element = ((Number) t).intValue();
        return Unit.f696a;
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
        return ((DataStoreImpl$readDataOrHandleCorruption$3) create(continuation)).invokeSuspend(Unit.f696a);
    }
}
