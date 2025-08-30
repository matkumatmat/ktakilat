package com.google.firebase.sessions;

import android.content.Context;
import androidx.datastore.preferences.PreferenceDataStoreFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2 extends Lambda implements Function0<File> {
    final /* synthetic */ Context $appContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FirebaseSessionsComponent$MainModule$Companion$sessionDetailsDataStore$2(Context context) {
        super(0);
        this.$appContext = context;
    }

    @NotNull
    public final File invoke() {
        return PreferenceDataStoreFile.preferencesDataStoreFile(this.$appContext, SessionDataStoreConfigs.INSTANCE.getSESSIONS_CONFIG_NAME());
    }
}
