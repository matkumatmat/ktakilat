package coil3.disk;

import coil3.disk.DiskCache;
import coil3.disk.DiskLruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okio.ByteString;
import okio.FileSystem;
import okio.Path;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/disk/RealDiskCache;", "Lcoil3/disk/DiskCache;", "RealSnapshot", "RealEditor", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRealDiskCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealDiskCache.kt\ncoil3/disk/RealDiskCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
public final class RealDiskCache implements DiskCache {

    /* renamed from: a  reason: collision with root package name */
    public final FileSystem f83a;
    public final DiskLruCache b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcoil3/disk/RealDiskCache$Companion;", "", "", "ENTRY_METADATA", "I", "ENTRY_DATA", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @SourceDebugExtension({"SMAP\nRealDiskCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealDiskCache.kt\ncoil3/disk/RealDiskCache$RealEditor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/disk/RealDiskCache$RealEditor;", "Lcoil3/disk/DiskCache$Editor;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RealEditor implements DiskCache.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final DiskLruCache.Editor f84a;

        public RealEditor(DiskLruCache.Editor editor) {
            this.f84a = editor;
        }

        public final DiskCache.Snapshot a() {
            DiskLruCache.Snapshot e;
            DiskLruCache.Editor editor = this.f84a;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache.k) {
                editor.a(true);
                e = diskLruCache.e(editor.f81a.f82a);
            }
            if (e != null) {
                return new RealSnapshot(e);
            }
            return null;
        }

        public final void abort() {
            this.f84a.a(false);
        }

        public final Path getData() {
            return this.f84a.b(1);
        }

        public final Path getMetadata() {
            return this.f84a.b(0);
        }
    }

    @SourceDebugExtension({"SMAP\nRealDiskCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealDiskCache.kt\ncoil3/disk/RealDiskCache$RealSnapshot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/disk/RealDiskCache$RealSnapshot;", "Lcoil3/disk/DiskCache$Snapshot;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class RealSnapshot implements DiskCache.Snapshot {
        public final DiskLruCache.Snapshot c;

        public RealSnapshot(DiskLruCache.Snapshot snapshot) {
            this.c = snapshot;
        }

        public final void close() {
            this.c.close();
        }

        public final Path getData() {
            DiskLruCache.Snapshot snapshot = this.c;
            if (!snapshot.d) {
                return (Path) snapshot.c.c.get(1);
            }
            throw new IllegalStateException("snapshot is closed");
        }

        public final Path getMetadata() {
            DiskLruCache.Snapshot snapshot = this.c;
            if (!snapshot.d) {
                return (Path) snapshot.c.c.get(0);
            }
            throw new IllegalStateException("snapshot is closed");
        }

        public final DiskCache.Editor l() {
            DiskLruCache.Editor d;
            DiskLruCache.Snapshot snapshot = this.c;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache.k) {
                snapshot.close();
                d = diskLruCache.d(snapshot.c.f82a);
            }
            if (d != null) {
                return new RealEditor(d);
            }
            return null;
        }
    }

    public RealDiskCache(long j, DefaultIoScheduler defaultIoScheduler, FileSystem fileSystem, Path path) {
        this.f83a = fileSystem;
        this.b = new DiskLruCache(j, defaultIoScheduler, fileSystem, path);
    }

    public final DiskCache.Editor a(String str) {
        DiskLruCache.Editor d = this.b.d(ByteString.Companion.encodeUtf8(str).sha256().hex());
        if (d != null) {
            return new RealEditor(d);
        }
        return null;
    }

    public final FileSystem b() {
        return this.f83a;
    }

    public final DiskCache.Snapshot c(String str) {
        DiskLruCache.Snapshot e = this.b.e(ByteString.Companion.encodeUtf8(str).sha256().hex());
        if (e != null) {
            return new RealSnapshot(e);
        }
        return null;
    }
}
