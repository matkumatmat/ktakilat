package androidx.datastore.preferences.core;

import androidx.datastore.core.DataMigration;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.Storage;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.core.okio.OkioStorage;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007JN\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007JN\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010H\u0007¨\u0006\u0014"}, d2 = {"Landroidx/datastore/preferences/core/PreferenceDataStoreFactory;", "", "()V", "create", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "storage", "Landroidx/datastore/core/Storage;", "corruptionHandler", "Landroidx/datastore/core/handlers/ReplaceFileCorruptionHandler;", "migrations", "", "Landroidx/datastore/core/DataMigration;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "createWithPath", "Lokio/Path;", "datastore-preferences-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PreferenceDataStoreFactory {
    @NotNull
    public static final PreferenceDataStoreFactory INSTANCE = new PreferenceDataStoreFactory();

    private PreferenceDataStoreFactory() {
    }

    public static DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, Storage storage, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, int i, Object obj) {
        if ((i & 2) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 4) != 0) {
            list = EmptyList.INSTANCE;
        }
        if ((i & 8) != 0) {
            coroutineScope = CoroutineScopeKt.a(Actual_jvmKt.ioDispatcher().plus(SupervisorKt.b()));
        }
        return preferenceDataStoreFactory.create((Storage<Preferences>) storage, (ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, coroutineScope);
    }

    public static DataStore createWithPath$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 2) != 0) {
            list = EmptyList.INSTANCE;
        }
        if ((i & 4) != 0) {
            coroutineScope = CoroutineScopeKt.a(Actual_jvmKt.ioDispatcher().plus(SupervisorKt.b()));
        }
        return preferenceDataStoreFactory.createWithPath(replaceFileCorruptionHandler, list, coroutineScope, function0);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@NotNull Storage<Preferences> storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) null, (List) null, (CoroutineScope) null, 14, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> createWithPath(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull Function0<Path> function0) {
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, list, (CoroutineScope) null, function0, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@NotNull Storage<Preferences> storage, @Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) null, (CoroutineScope) null, 12, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> createWithPath(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull Function0<Path> function0) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return createWithPath$default(this, replaceFileCorruptionHandler, (List) null, (CoroutineScope) null, function0, 6, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@NotNull Storage<Preferences> storage, @Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(list, "migrations");
        return create$default(this, (Storage) storage, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) list, (CoroutineScope) null, 8, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> createWithPath(@NotNull Function0<Path> function0) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return createWithPath$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (CoroutineScope) null, function0, 7, (Object) null);
    }

    public static DataStore create$default(PreferenceDataStoreFactory preferenceDataStoreFactory, ReplaceFileCorruptionHandler replaceFileCorruptionHandler, List list, CoroutineScope coroutineScope, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            replaceFileCorruptionHandler = null;
        }
        if ((i & 2) != 0) {
            list = EmptyList.INSTANCE;
        }
        if ((i & 4) != 0) {
            DefaultScheduler defaultScheduler = Dispatchers.f767a;
            coroutineScope = CoroutineScopeKt.a(DefaultIoScheduler.c.plus(SupervisorKt.b()));
        }
        return preferenceDataStoreFactory.create((ReplaceFileCorruptionHandler<Preferences>) replaceFileCorruptionHandler, (List<? extends DataMigration<Preferences>>) list, coroutineScope, (Function0<? extends File>) function0);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) list, (CoroutineScope) null, (Function0) function0, 4, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> createWithPath(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull CoroutineScope coroutineScope, @NotNull Function0<Path> function0) {
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create(replaceFileCorruptionHandler, list, coroutineScope, (Function0<? extends File>) new PreferenceDataStoreFactory$createWithPath$1(function0));
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) replaceFileCorruptionHandler, (List) null, (CoroutineScope) null, (Function0) function0, 6, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return create$default(this, (ReplaceFileCorruptionHandler) null, (List) null, (CoroutineScope) null, (Function0) function0, 7, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull CoroutineScope coroutineScope, @NotNull Function0<? extends File> function0) {
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        return new PreferenceDataStore(create((Storage<Preferences>) new OkioStorage(FileSystem.SYSTEM, PreferencesSerializer.INSTANCE, (Function2) null, new PreferenceDataStoreFactory$create$delegate$1(function0), 4, (DefaultConstructorMarker) null), replaceFileCorruptionHandler, list, coroutineScope));
    }

    @NotNull
    @JvmOverloads
    public final DataStore<Preferences> create(@NotNull Storage<Preferences> storage, @Nullable ReplaceFileCorruptionHandler<Preferences> replaceFileCorruptionHandler, @NotNull List<? extends DataMigration<Preferences>> list, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(list, "migrations");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        return new PreferenceDataStore(DataStoreFactory.INSTANCE.create(storage, replaceFileCorruptionHandler, list, coroutineScope));
    }
}
