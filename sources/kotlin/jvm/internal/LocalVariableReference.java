package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lkotlin/jvm/internal/LocalVariableReference;", "Lkotlin/jvm/internal/PropertyReference0;", "<init>", "()V", "getOwner", "Lkotlin/reflect/KDeclarationContainer;", "get", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SinceKotlin(version = "1.1")
public class LocalVariableReference extends PropertyReference0 {
    @Nullable
    public Object get() {
        throw new UnsupportedOperationException("Not supported for local property reference.");
    }

    @NotNull
    public KDeclarationContainer getOwner() {
        throw new UnsupportedOperationException("Not supported for local property reference.");
    }
}
