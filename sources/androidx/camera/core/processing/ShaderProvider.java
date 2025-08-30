package androidx.camera.core.processing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface ShaderProvider {
    @Nullable
    String createFragmentShader(@NonNull String str, @NonNull String str2);
}
