package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Identifier {
    @NonNull
    public static Identifier create(@NonNull Object obj) {
        return new AutoValue_Identifier(obj);
    }

    @NonNull
    public abstract Object getValue();
}
