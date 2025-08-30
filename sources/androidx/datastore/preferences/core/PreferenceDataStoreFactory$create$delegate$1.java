package androidx.datastore.preferences.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import okio.Path;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokio/Path;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class PreferenceDataStoreFactory$create$delegate$1 extends Lambda implements Function0<Path> {
    final /* synthetic */ Function0<File> $produceFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreferenceDataStoreFactory$create$delegate$1(Function0<? extends File> function0) {
        super(0);
        this.$produceFile = function0;
    }

    @NotNull
    public final Path invoke() {
        File file = (File) this.$produceFile.invoke();
        Intrinsics.checkNotNullParameter(file, "<this>");
        String name = file.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        if (Intrinsics.a(StringsKt.L(name, ClassUtils.PACKAGE_SEPARATOR_CHAR, ""), PreferencesSerializer.fileExtension)) {
            Path.Companion companion = Path.Companion;
            File absoluteFile = file.getAbsoluteFile();
            Intrinsics.checkNotNullExpressionValue(absoluteFile, "file.absoluteFile");
            return Path.Companion.get$default(companion, absoluteFile, false, 1, (Object) null);
        }
        throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
    }
}
