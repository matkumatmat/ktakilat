package androidx.datastore.core;

import androidx.annotation.RequiresApi;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(26)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Landroidx/datastore/core/Api26Impl;", "", "()V", "move", "", "srcFile", "Ljava/io/File;", "dstFile", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api26Impl {
    @NotNull
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final boolean move(@NotNull File file, @NotNull File file2) {
        Intrinsics.checkNotNullParameter(file, "srcFile");
        Intrinsics.checkNotNullParameter(file2, "dstFile");
        try {
            Files.move(file.toPath(), file2.toPath(), new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
