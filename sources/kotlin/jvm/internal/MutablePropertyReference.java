package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public abstract class MutablePropertyReference extends PropertyReference implements KMutableProperty {
    public MutablePropertyReference() {
    }

    @NotNull
    public abstract /* synthetic */ KProperty.Getter getGetter();

    @NotNull
    public abstract /* synthetic */ KMutableProperty.Setter getSetter();

    @SinceKotlin(version = "1.1")
    public MutablePropertyReference(Object obj) {
        super(obj);
    }

    @SinceKotlin(version = "1.4")
    public MutablePropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
