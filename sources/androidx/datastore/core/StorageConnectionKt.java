package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H@¢\u0006\u0002\u0010\u0003\u001a&\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0006\u001a\u0002H\u0001H@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"readData", "T", "Landroidx/datastore/core/StorageConnection;", "(Landroidx/datastore/core/StorageConnection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "", "value", "(Landroidx/datastore/core/StorageConnection;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "datastore-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StorageConnectionKt {
    @Nullable
    public static final <T> Object readData(@NotNull StorageConnection<T> storageConnection, @NotNull Continuation<? super T> continuation) {
        return storageConnection.readScope(new StorageConnectionKt$readData$2((Continuation<? super StorageConnectionKt$readData$2>) null), continuation);
    }

    @Nullable
    public static final <T> Object writeData(@NotNull StorageConnection<T> storageConnection, T t, @NotNull Continuation<? super Unit> continuation) {
        Object writeScope = storageConnection.writeScope(new StorageConnectionKt$writeData$2(t, (Continuation<? super StorageConnectionKt$writeData$2>) null), continuation);
        if (writeScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return writeScope;
        }
        return Unit.f696a;
    }
}
