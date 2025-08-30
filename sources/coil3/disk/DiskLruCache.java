package coil3.disk;

import coil3.util.FileSystemsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import okio.BufferedSink;
import okio.FileSystem;
import okio.ForwardingFileSystem;
import okio.Path;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcoil3/disk/DiskLruCache;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Snapshot", "Editor", "Entry", "Companion", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\ncoil3/disk/DiskLruCache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Okio.kt\nokio/Okio__OkioKt\n+ 4 FileSystem.kt\nokio/FileSystem\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 6 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,864:1\n1#2:865\n66#3:866\n52#3,4:868\n60#3,10:873\n56#3,3:883\n71#3,3:886\n52#3,4:899\n60#3,10:904\n56#3,18:914\n67#4:867\n68#4:872\n80#4:896\n165#4:897\n81#4:898\n82#4:903\n381#5,7:889\n37#6,2:932\n37#6,2:934\n*S KotlinDebug\n*F\n+ 1 DiskLruCache.kt\ncoil3/disk/DiskLruCache\n*L\n207#1:866\n207#1:868,4\n207#1:873,10\n207#1:883,3\n207#1:886,3\n319#1:899,4\n319#1:904,10\n319#1:914,18\n207#1:867\n207#1:872\n319#1:896\n319#1:897\n319#1:898\n319#1:903\n270#1:889,7\n582#1:932,2\n636#1:934,2\n*E\n"})
public final class DiskLruCache implements AutoCloseable {
    public static final Regex u = new Regex("[a-z0-9_-]{1,120}");
    public final Path c;
    public final long d;
    public final Path e;
    public final Path f;
    public final Path g;
    public final LinkedHashMap i;
    public final ContextScope j;
    public final Object k;
    public long l;
    public int m;
    public BufferedSink n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public final DiskLruCache$fileSystem$1 t;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcoil3/disk/DiskLruCache$Companion;", "", "", "CLEAN", "Ljava/lang/String;", "DIRTY", "REMOVE", "READ", "Lkotlin/text/Regex;", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\ncoil3/disk/DiskLruCache$Editor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,864:1\n1#2:865\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/disk/DiskLruCache$Editor;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Editor {

        /* renamed from: a  reason: collision with root package name */
        public final Entry f81a;
        public boolean b;
        public final boolean[] c = new boolean[2];

        public Editor(Entry entry) {
            this.f81a = entry;
            DiskLruCache.this.getClass();
        }

        public final void a(boolean z) {
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache.k) {
                try {
                    if (!this.b) {
                        if (Intrinsics.a(this.f81a.g, this)) {
                            DiskLruCache.c(diskLruCache, this, z);
                        }
                        this.b = true;
                        Unit unit = Unit.f696a;
                    } else {
                        throw new IllegalStateException("editor is closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final Path b(int i) {
            Path path;
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache.k) {
                if (!this.b) {
                    this.c[i] = true;
                    Object obj = this.f81a.d.get(i);
                    FileSystemsKt.a(diskLruCache.t, (Path) obj);
                    path = (Path) obj;
                } else {
                    throw new IllegalStateException("editor is closed");
                }
            }
            return path;
        }
    }

    @SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\ncoil3/disk/DiskLruCache$Entry\n+ 2 collections.kt\ncoil3/util/CollectionsKt\n*L\n1#1,864:1\n43#2,4:865\n*S KotlinDebug\n*F\n+ 1 DiskLruCache.kt\ncoil3/disk/DiskLruCache$Entry\n*L\n836#1:865,4\n*E\n"})
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcoil3/disk/DiskLruCache$Entry;", "", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Entry {

        /* renamed from: a  reason: collision with root package name */
        public final String f82a;
        public final long[] b = new long[2];
        public final ArrayList c = new ArrayList(2);
        public final ArrayList d = new ArrayList(2);
        public boolean e;
        public boolean f;
        public Editor g;
        public int h;

        public Entry(String str) {
            this.f82a = str;
            DiskLruCache.this.getClass();
            StringBuilder sb = new StringBuilder(str);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
            int length = sb.length();
            for (int i2 = 0; i2 < 2; i2++) {
                sb.append(i2);
                this.c.add(DiskLruCache.this.c.resolve(sb.toString()));
                sb.append(".tmp");
                this.d.add(DiskLruCache.this.c.resolve(sb.toString()));
                sb.setLength(length);
            }
        }

        public final Snapshot a() {
            if (!this.e || this.g != null || this.f) {
                return null;
            }
            ArrayList arrayList = this.c;
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                DiskLruCache diskLruCache = DiskLruCache.this;
                if (i2 < size) {
                    if (!diskLruCache.t.exists((Path) arrayList.get(i2))) {
                        try {
                            diskLruCache.k(this);
                        } catch (IOException unused) {
                        }
                        return null;
                    }
                    i2++;
                } else {
                    this.h++;
                    return new Snapshot(this);
                }
            }
        }
    }

    @SourceDebugExtension({"SMAP\nDiskLruCache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiskLruCache.kt\ncoil3/disk/DiskLruCache$Snapshot\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,864:1\n1#2:865\n*E\n"})
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"Lcoil3/disk/DiskLruCache$Snapshot;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Snapshot implements AutoCloseable {
        public final Entry c;
        public boolean d;

        public Snapshot(Entry entry) {
            this.c = entry;
        }

        public final void close() {
            if (!this.d) {
                this.d = true;
                DiskLruCache diskLruCache = DiskLruCache.this;
                synchronized (diskLruCache.k) {
                    Entry entry = this.c;
                    int i = entry.h - 1;
                    entry.h = i;
                    if (i == 0 && entry.f) {
                        diskLruCache.k(entry);
                    }
                    Unit unit = Unit.f696a;
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v14, types: [okio.ForwardingFileSystem, coil3.disk.DiskLruCache$fileSystem$1] */
    public DiskLruCache(long j2, DefaultIoScheduler defaultIoScheduler, FileSystem fileSystem, Path path) {
        this.c = path;
        this.d = j2;
        if (j2 > 0) {
            this.e = path.resolve("journal");
            this.f = path.resolve("journal.tmp");
            this.g = path.resolve("journal.bkp");
            this.i = new LinkedHashMap(0, 0.75f, true);
            this.j = CoroutineScopeKt.a(CoroutineContext.Element.DefaultImpls.c(CoroutineDispatcher.limitedParallelism$default(defaultIoScheduler, 1, (String) null, 2, (Object) null), (JobSupport) SupervisorKt.b()));
            this.k = new Object();
            this.t = new ForwardingFileSystem(fileSystem);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010c, code lost:
        if (r0 != false) goto L_0x010e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void c(coil3.disk.DiskLruCache r11, coil3.disk.DiskLruCache.Editor r12, boolean r13) {
        /*
            r0 = 1
            java.lang.Object r1 = r11.k
            monitor-enter(r1)
            coil3.disk.DiskLruCache$Entry r2 = r12.f81a     // Catch:{ all -> 0x0035 }
            coil3.disk.DiskLruCache$Editor r3 = r2.g     // Catch:{ all -> 0x0035 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r12)     // Catch:{ all -> 0x0035 }
            if (r3 == 0) goto L_0x0115
            r3 = 2
            r4 = 0
            if (r13 == 0) goto L_0x008b
            boolean r5 = r2.f     // Catch:{ all -> 0x0035 }
            if (r5 != 0) goto L_0x008b
            r5 = 0
        L_0x0017:
            if (r5 >= r3) goto L_0x003a
            boolean[] r6 = r12.c     // Catch:{ all -> 0x0035 }
            boolean r6 = r6[r5]     // Catch:{ all -> 0x0035 }
            if (r6 == 0) goto L_0x0038
            coil3.disk.DiskLruCache$fileSystem$1 r6 = r11.t     // Catch:{ all -> 0x0035 }
            java.util.ArrayList r7 = r2.d     // Catch:{ all -> 0x0035 }
            java.lang.Object r7 = r7.get(r5)     // Catch:{ all -> 0x0035 }
            okio.Path r7 = (okio.Path) r7     // Catch:{ all -> 0x0035 }
            boolean r6 = r6.exists(r7)     // Catch:{ all -> 0x0035 }
            if (r6 != 0) goto L_0x0038
            r12.a(r4)     // Catch:{ all -> 0x0035 }
            monitor-exit(r1)
            goto L_0x0114
        L_0x0035:
            r11 = move-exception
            goto L_0x011d
        L_0x0038:
            int r5 = r5 + r0
            goto L_0x0017
        L_0x003a:
            r12 = 0
        L_0x003b:
            if (r12 >= r3) goto L_0x009d
            java.util.ArrayList r5 = r2.d     // Catch:{ all -> 0x0035 }
            java.lang.Object r5 = r5.get(r12)     // Catch:{ all -> 0x0035 }
            okio.Path r5 = (okio.Path) r5     // Catch:{ all -> 0x0035 }
            java.util.ArrayList r6 = r2.c     // Catch:{ all -> 0x0035 }
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x0035 }
            okio.Path r6 = (okio.Path) r6     // Catch:{ all -> 0x0035 }
            coil3.disk.DiskLruCache$fileSystem$1 r7 = r11.t     // Catch:{ all -> 0x0035 }
            boolean r7 = r7.exists(r5)     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x005b
            coil3.disk.DiskLruCache$fileSystem$1 r7 = r11.t     // Catch:{ all -> 0x0035 }
            r7.atomicMove(r5, r6)     // Catch:{ all -> 0x0035 }
            goto L_0x0068
        L_0x005b:
            coil3.disk.DiskLruCache$fileSystem$1 r5 = r11.t     // Catch:{ all -> 0x0035 }
            java.util.ArrayList r7 = r2.c     // Catch:{ all -> 0x0035 }
            java.lang.Object r7 = r7.get(r12)     // Catch:{ all -> 0x0035 }
            okio.Path r7 = (okio.Path) r7     // Catch:{ all -> 0x0035 }
            coil3.util.FileSystemsKt.a(r5, r7)     // Catch:{ all -> 0x0035 }
        L_0x0068:
            long[] r5 = r2.b     // Catch:{ all -> 0x0035 }
            r7 = r5[r12]     // Catch:{ all -> 0x0035 }
            coil3.disk.DiskLruCache$fileSystem$1 r5 = r11.t     // Catch:{ all -> 0x0035 }
            okio.FileMetadata r5 = r5.metadata(r6)     // Catch:{ all -> 0x0035 }
            java.lang.Long r5 = r5.getSize()     // Catch:{ all -> 0x0035 }
            if (r5 == 0) goto L_0x007d
            long r5 = r5.longValue()     // Catch:{ all -> 0x0035 }
            goto L_0x007f
        L_0x007d:
            r5 = 0
        L_0x007f:
            long[] r9 = r2.b     // Catch:{ all -> 0x0035 }
            r9[r12] = r5     // Catch:{ all -> 0x0035 }
            long r9 = r11.l     // Catch:{ all -> 0x0035 }
            long r9 = r9 - r7
            long r9 = r9 + r5
            r11.l = r9     // Catch:{ all -> 0x0035 }
            int r12 = r12 + r0
            goto L_0x003b
        L_0x008b:
            r12 = 0
        L_0x008c:
            if (r12 >= r3) goto L_0x009d
            coil3.disk.DiskLruCache$fileSystem$1 r5 = r11.t     // Catch:{ all -> 0x0035 }
            java.util.ArrayList r6 = r2.d     // Catch:{ all -> 0x0035 }
            java.lang.Object r6 = r6.get(r12)     // Catch:{ all -> 0x0035 }
            okio.Path r6 = (okio.Path) r6     // Catch:{ all -> 0x0035 }
            r5.delete(r6)     // Catch:{ all -> 0x0035 }
            int r12 = r12 + r0
            goto L_0x008c
        L_0x009d:
            r12 = 0
            r2.g = r12     // Catch:{ all -> 0x0035 }
            boolean r12 = r2.f     // Catch:{ all -> 0x0035 }
            if (r12 == 0) goto L_0x00a9
            r11.k(r2)     // Catch:{ all -> 0x0035 }
            monitor-exit(r1)
            goto L_0x0114
        L_0x00a9:
            int r12 = r11.m     // Catch:{ all -> 0x0035 }
            int r12 = r12 + r0
            r11.m = r12     // Catch:{ all -> 0x0035 }
            okio.BufferedSink r12 = r11.n     // Catch:{ all -> 0x0035 }
            kotlin.jvm.internal.Intrinsics.c(r12)     // Catch:{ all -> 0x0035 }
            r3 = 32
            r5 = 10
            if (r13 != 0) goto L_0x00d6
            boolean r13 = r2.e     // Catch:{ all -> 0x0035 }
            if (r13 == 0) goto L_0x00be
            goto L_0x00d6
        L_0x00be:
            java.util.LinkedHashMap r13 = r11.i     // Catch:{ all -> 0x0035 }
            java.lang.String r6 = r2.f82a     // Catch:{ all -> 0x0035 }
            r13.remove(r6)     // Catch:{ all -> 0x0035 }
            java.lang.String r13 = "REMOVE"
            r12.writeUtf8(r13)     // Catch:{ all -> 0x0035 }
            r12.writeByte(r3)     // Catch:{ all -> 0x0035 }
            java.lang.String r13 = r2.f82a     // Catch:{ all -> 0x0035 }
            r12.writeUtf8(r13)     // Catch:{ all -> 0x0035 }
            r12.writeByte(r5)     // Catch:{ all -> 0x0035 }
            goto L_0x00f9
        L_0x00d6:
            r2.e = r0     // Catch:{ all -> 0x0035 }
            java.lang.String r13 = "CLEAN"
            r12.writeUtf8(r13)     // Catch:{ all -> 0x0035 }
            r12.writeByte(r3)     // Catch:{ all -> 0x0035 }
            java.lang.String r13 = r2.f82a     // Catch:{ all -> 0x0035 }
            r12.writeUtf8(r13)     // Catch:{ all -> 0x0035 }
            long[] r13 = r2.b     // Catch:{ all -> 0x0035 }
            int r2 = r13.length     // Catch:{ all -> 0x0035 }
            r6 = 0
        L_0x00e9:
            if (r6 >= r2) goto L_0x00f6
            r7 = r13[r6]     // Catch:{ all -> 0x0035 }
            okio.BufferedSink r9 = r12.writeByte(r3)     // Catch:{ all -> 0x0035 }
            r9.writeDecimalLong(r7)     // Catch:{ all -> 0x0035 }
            int r6 = r6 + r0
            goto L_0x00e9
        L_0x00f6:
            r12.writeByte(r5)     // Catch:{ all -> 0x0035 }
        L_0x00f9:
            r12.flush()     // Catch:{ all -> 0x0035 }
            long r12 = r11.l     // Catch:{ all -> 0x0035 }
            long r2 = r11.d     // Catch:{ all -> 0x0035 }
            int r5 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x010e
            int r12 = r11.m     // Catch:{ all -> 0x0035 }
            r13 = 2000(0x7d0, float:2.803E-42)
            if (r12 < r13) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            r0 = 0
        L_0x010c:
            if (r0 == 0) goto L_0x0111
        L_0x010e:
            r11.g()     // Catch:{ all -> 0x0035 }
        L_0x0111:
            kotlin.Unit r11 = kotlin.Unit.f696a     // Catch:{ all -> 0x0035 }
            monitor-exit(r1)
        L_0x0114:
            return
        L_0x0115:
            java.lang.String r11 = "Check failed."
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0035 }
            r12.<init>(r11)     // Catch:{ all -> 0x0035 }
            throw r12     // Catch:{ all -> 0x0035 }
        L_0x011d:
            monitor-exit(r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.c(coil3.disk.DiskLruCache, coil3.disk.DiskLruCache$Editor, boolean):void");
    }

    public static void p(String str) {
        if (!u.matches(str)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
        }
    }

    public final void close() {
        synchronized (this.k) {
            try {
                if (this.p) {
                    if (!this.q) {
                        for (Entry entry : (Entry[]) this.i.values().toArray(new Entry[0])) {
                            Editor editor = entry.g;
                            if (editor != null) {
                                Entry entry2 = editor.f81a;
                                if (Intrinsics.a(entry2.g, editor)) {
                                    entry2.f = true;
                                }
                            }
                        }
                        m();
                        CoroutineScopeKt.b(this.j, (CancellationException) null);
                        BufferedSink bufferedSink = this.n;
                        Intrinsics.c(bufferedSink);
                        bufferedSink.close();
                        this.n = null;
                        this.q = true;
                        Unit unit = Unit.f696a;
                        return;
                    }
                }
                this.q = true;
            } finally {
            }
        }
    }

    public final Editor d(String str) {
        Editor editor;
        synchronized (this.k) {
            if (!this.q) {
                p(str);
                f();
                Entry entry = (Entry) this.i.get(str);
                if (entry != null) {
                    editor = entry.g;
                } else {
                    editor = null;
                }
                if (editor != null) {
                    return null;
                }
                if (entry != null) {
                    if (entry.h != 0) {
                        return null;
                    }
                }
                try {
                    if (!this.r) {
                        if (!this.s) {
                            BufferedSink bufferedSink = this.n;
                            Intrinsics.c(bufferedSink);
                            bufferedSink.writeUtf8("DIRTY");
                            bufferedSink.writeByte(32);
                            bufferedSink.writeUtf8(str);
                            bufferedSink.writeByte(10);
                            bufferedSink.flush();
                            if (this.o) {
                                return null;
                            }
                            if (entry == null) {
                                entry = new Entry(str);
                                this.i.put(str, entry);
                            }
                            Editor editor2 = new Editor(entry);
                            entry.g = editor2;
                            return editor2;
                        }
                    }
                    g();
                    return null;
                } finally {
                }
            } else {
                throw new IllegalStateException("cache is closed");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil3.disk.DiskLruCache.Snapshot e(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.k
            monitor-enter(r0)
            boolean r1 = r5.q     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x0053
            p(r6)     // Catch:{ all -> 0x004c }
            r5.f()     // Catch:{ all -> 0x004c }
            java.util.LinkedHashMap r1 = r5.i     // Catch:{ all -> 0x004c }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x004c }
            coil3.disk.DiskLruCache$Entry r1 = (coil3.disk.DiskLruCache.Entry) r1     // Catch:{ all -> 0x004c }
            if (r1 == 0) goto L_0x0050
            coil3.disk.DiskLruCache$Snapshot r1 = r1.a()     // Catch:{ all -> 0x004c }
            if (r1 != 0) goto L_0x001e
            goto L_0x0050
        L_0x001e:
            int r2 = r5.m     // Catch:{ all -> 0x004c }
            r3 = 1
            int r2 = r2 + r3
            r5.m = r2     // Catch:{ all -> 0x004c }
            okio.BufferedSink r2 = r5.n     // Catch:{ all -> 0x004c }
            kotlin.jvm.internal.Intrinsics.c(r2)     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "READ"
            r2.writeUtf8(r4)     // Catch:{ all -> 0x004c }
            r4 = 32
            r2.writeByte(r4)     // Catch:{ all -> 0x004c }
            r2.writeUtf8(r6)     // Catch:{ all -> 0x004c }
            r6 = 10
            r2.writeByte(r6)     // Catch:{ all -> 0x004c }
            r2.flush()     // Catch:{ all -> 0x004c }
            int r6 = r5.m     // Catch:{ all -> 0x004c }
            r2 = 2000(0x7d0, float:2.803E-42)
            if (r6 < r2) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r3 = 0
        L_0x0046:
            if (r3 == 0) goto L_0x004e
            r5.g()     // Catch:{ all -> 0x004c }
            goto L_0x004e
        L_0x004c:
            r6 = move-exception
            goto L_0x005b
        L_0x004e:
            monitor-exit(r0)
            return r1
        L_0x0050:
            monitor-exit(r0)
            r6 = 0
            return r6
        L_0x0053:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004c }
            java.lang.String r1 = "cache is closed"
            r6.<init>(r1)     // Catch:{ all -> 0x004c }
            throw r6     // Catch:{ all -> 0x004c }
        L_0x005b:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.e(java.lang.String):coil3.disk.DiskLruCache$Snapshot");
    }

    public final void f() {
        synchronized (this.k) {
            try {
                if (!this.p) {
                    this.t.delete(this.f);
                    if (this.t.exists(this.g)) {
                        if (this.t.exists(this.e)) {
                            this.t.delete(this.g);
                        } else {
                            this.t.atomicMove(this.g, this.e);
                        }
                    }
                    if (this.t.exists(this.e)) {
                        i();
                        h();
                        this.p = true;
                        return;
                    }
                    q();
                    this.p = true;
                    Unit unit = Unit.f696a;
                }
            } catch (IOException unused) {
                close();
                FileSystemsKt.b(this.t, this.c);
                this.q = false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void g() {
        BuildersKt.b(this.j, (MainCoroutineDispatcher) null, (CoroutineStart) null, new DiskLruCache$launchCleanup$1(this, (Continuation) null), 3);
    }

    public final void h() {
        Iterator it = this.i.values().iterator();
        long j2 = 0;
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            int i2 = 0;
            if (entry.g == null) {
                while (i2 < 2) {
                    j2 += entry.b[i2];
                    i2++;
                }
            } else {
                entry.g = null;
                while (i2 < 2) {
                    DiskLruCache$fileSystem$1 diskLruCache$fileSystem$1 = this.t;
                    diskLruCache$fileSystem$1.delete((Path) entry.c.get(i2));
                    diskLruCache$fileSystem$1.delete((Path) entry.d.get(i2));
                    i2++;
                }
                it.remove();
            }
        }
        this.l = j2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:17|18|(1:20)(1:21)|22|23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r12.m = r1 - r12.i.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (r5.exhausted() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006c, code lost:
        q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        r12.n = okio.Okio.buffer((okio.Sink) new coil3.disk.FaultHidingSink(r3.appendingSink(r4), new defpackage.a(r12, 3)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0084, code lost:
        r0 = kotlin.Unit.f696a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0089, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x005d=Splitter:B:17:0x005d, B:27:0x008d=Splitter:B:27:0x008d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r12 = this;
            r0 = 3
            java.lang.String r1 = ", "
            java.lang.String r2 = "unexpected journal header: ["
            coil3.disk.DiskLruCache$fileSystem$1 r3 = r12.t
            okio.Path r4 = r12.e
            okio.Source r5 = r3.source(r4)
            okio.BufferedSource r5 = okio.Okio.buffer((okio.Source) r5)
            java.lang.String r6 = r5.readUtf8LineStrict()     // Catch:{ all -> 0x005b }
            java.lang.String r7 = r5.readUtf8LineStrict()     // Catch:{ all -> 0x005b }
            java.lang.String r8 = r5.readUtf8LineStrict()     // Catch:{ all -> 0x005b }
            java.lang.String r9 = r5.readUtf8LineStrict()     // Catch:{ all -> 0x005b }
            java.lang.String r10 = r5.readUtf8LineStrict()     // Catch:{ all -> 0x005b }
            java.lang.String r11 = "libcore.io.DiskLruCache"
            boolean r11 = r11.equals(r6)     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x008d
            java.lang.String r11 = "1"
            boolean r11 = r11.equals(r7)     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x008d
            java.lang.String r11 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x005b }
            boolean r11 = kotlin.jvm.internal.Intrinsics.a(r11, r8)     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x008d
            r11 = 2
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x005b }
            boolean r11 = kotlin.jvm.internal.Intrinsics.a(r11, r9)     // Catch:{ all -> 0x005b }
            if (r11 == 0) goto L_0x008d
            int r11 = r10.length()     // Catch:{ all -> 0x005b }
            if (r11 > 0) goto L_0x008d
            r1 = 0
        L_0x0051:
            java.lang.String r2 = r5.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005d }
            r12.j(r2)     // Catch:{ EOFException -> 0x005d }
            int r1 = r1 + 1
            goto L_0x0051
        L_0x005b:
            r0 = move-exception
            goto L_0x00bc
        L_0x005d:
            java.util.LinkedHashMap r2 = r12.i     // Catch:{ all -> 0x005b }
            int r2 = r2.size()     // Catch:{ all -> 0x005b }
            int r1 = r1 - r2
            r12.m = r1     // Catch:{ all -> 0x005b }
            boolean r1 = r5.exhausted()     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0070
            r12.q()     // Catch:{ all -> 0x005b }
            goto L_0x0084
        L_0x0070:
            okio.Sink r1 = r3.appendingSink(r4)     // Catch:{ all -> 0x005b }
            coil3.disk.FaultHidingSink r2 = new coil3.disk.FaultHidingSink     // Catch:{ all -> 0x005b }
            a r3 = new a     // Catch:{ all -> 0x005b }
            r3.<init>(r12, r0)     // Catch:{ all -> 0x005b }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x005b }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x005b }
            r12.n = r0     // Catch:{ all -> 0x005b }
        L_0x0084:
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x005b }
            r5.close()     // Catch:{ all -> 0x008b }
            r0 = 0
            goto L_0x00c6
        L_0x008b:
            r0 = move-exception
            goto L_0x00c6
        L_0x008d:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x005b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005b }
            r3.<init>(r2)     // Catch:{ all -> 0x005b }
            r3.append(r6)     // Catch:{ all -> 0x005b }
            r3.append(r1)     // Catch:{ all -> 0x005b }
            r3.append(r7)     // Catch:{ all -> 0x005b }
            r3.append(r1)     // Catch:{ all -> 0x005b }
            r3.append(r8)     // Catch:{ all -> 0x005b }
            r3.append(r1)     // Catch:{ all -> 0x005b }
            r3.append(r9)     // Catch:{ all -> 0x005b }
            r3.append(r1)     // Catch:{ all -> 0x005b }
            r3.append(r10)     // Catch:{ all -> 0x005b }
            r1 = 93
            r3.append(r1)     // Catch:{ all -> 0x005b }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x005b }
            r0.<init>(r1)     // Catch:{ all -> 0x005b }
            throw r0     // Catch:{ all -> 0x005b }
        L_0x00bc:
            if (r5 == 0) goto L_0x00c6
            r5.close()     // Catch:{ all -> 0x00c2 }
            goto L_0x00c6
        L_0x00c2:
            r1 = move-exception
            kotlin.ExceptionsKt.a(r0, r1)
        L_0x00c6:
            if (r0 != 0) goto L_0x00c9
            return
        L_0x00c9:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.i():void");
    }

    public final void j(String str) {
        String str2;
        int r2 = StringsKt.r(str, ' ', 0, false, 6);
        if (r2 != -1) {
            int i2 = r2 + 1;
            int r3 = StringsKt.r(str, ' ', i2, false, 4);
            LinkedHashMap linkedHashMap = this.i;
            if (r3 == -1) {
                str2 = str.substring(i2);
                Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
                if (r2 == 6 && StringsKt.I(str, "REMOVE", false)) {
                    linkedHashMap.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, r3);
                Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
            }
            Object obj = linkedHashMap.get(str2);
            if (obj == null) {
                obj = new Entry(str2);
                linkedHashMap.put(str2, obj);
            }
            Entry entry = (Entry) obj;
            if (r3 != -1 && r2 == 5 && StringsKt.I(str, "CLEAN", false)) {
                String substring = str.substring(r3 + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                List F = StringsKt.F(substring, new char[]{' '});
                entry.e = true;
                entry.g = null;
                int size = F.size();
                DiskLruCache.this.getClass();
                if (size == 2) {
                    try {
                        int size2 = F.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            entry.b[i3] = Long.parseLong((String) F.get(i3));
                        }
                    } catch (NumberFormatException unused) {
                        throw new IOException("unexpected journal line: " + F);
                    }
                } else {
                    throw new IOException("unexpected journal line: " + F);
                }
            } else if (r3 == -1 && r2 == 5 && StringsKt.I(str, "DIRTY", false)) {
                entry.g = new Editor(entry);
            } else if (r3 != -1 || r2 != 4 || !StringsKt.I(str, "READ", false)) {
                throw new IOException("unexpected journal line: ".concat(str));
            }
        } else {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    public final void k(Entry entry) {
        BufferedSink bufferedSink;
        int i2 = entry.h;
        String str = entry.f82a;
        if (i2 > 0 && (bufferedSink = this.n) != null) {
            bufferedSink.writeUtf8("DIRTY");
            bufferedSink.writeByte(32);
            bufferedSink.writeUtf8(str);
            bufferedSink.writeByte(10);
            bufferedSink.flush();
        }
        if (entry.h > 0 || entry.g != null) {
            entry.f = true;
            return;
        }
        for (int i3 = 0; i3 < 2; i3++) {
            this.t.delete((Path) entry.c.get(i3));
            long j2 = this.l;
            long[] jArr = entry.b;
            this.l = j2 - jArr[i3];
            jArr[i3] = 0;
        }
        this.m++;
        BufferedSink bufferedSink2 = this.n;
        if (bufferedSink2 != null) {
            bufferedSink2.writeUtf8("REMOVE");
            bufferedSink2.writeByte(32);
            bufferedSink2.writeUtf8(str);
            bufferedSink2.writeByte(10);
            bufferedSink2.flush();
        }
        this.i.remove(str);
        if (this.m >= 2000) {
            g();
        }
    }

    public final void m() {
        while (this.l > this.d) {
            for (Entry entry : this.i.values()) {
                if (!entry.f) {
                    k(entry);
                }
            }
            return;
        }
        this.r = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ac A[Catch:{ all -> 0x0071, all -> 0x00a5, all -> 0x000c }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A[SYNTHETIC, Splitter:B:43:0x00fb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q() {
        /*
            r13 = this;
            r0 = 3
            java.lang.Object r1 = r13.k
            monitor-enter(r1)
            okio.BufferedSink r2 = r13.n     // Catch:{ all -> 0x000c }
            if (r2 == 0) goto L_0x000f
            r2.close()     // Catch:{ all -> 0x000c }
            goto L_0x000f
        L_0x000c:
            r0 = move-exception
            goto L_0x00fc
        L_0x000f:
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r13.t     // Catch:{ all -> 0x000c }
            okio.Path r3 = r13.f     // Catch:{ all -> 0x000c }
            r4 = 0
            okio.Sink r2 = r2.sink(r3, r4)     // Catch:{ all -> 0x000c }
            okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x000c }
            java.lang.String r3 = "libcore.io.DiskLruCache"
            okio.BufferedSink r3 = r2.writeUtf8(r3)     // Catch:{ all -> 0x0071 }
            r5 = 10
            r3.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r3 = "1"
            okio.BufferedSink r3 = r2.writeUtf8(r3)     // Catch:{ all -> 0x0071 }
            r3.writeByte(r5)     // Catch:{ all -> 0x0071 }
            long r6 = (long) r0     // Catch:{ all -> 0x0071 }
            okio.BufferedSink r3 = r2.writeDecimalLong(r6)     // Catch:{ all -> 0x0071 }
            r3.writeByte(r5)     // Catch:{ all -> 0x0071 }
            r3 = 2
            long r6 = (long) r3     // Catch:{ all -> 0x0071 }
            okio.BufferedSink r3 = r2.writeDecimalLong(r6)     // Catch:{ all -> 0x0071 }
            r3.writeByte(r5)     // Catch:{ all -> 0x0071 }
            r2.writeByte(r5)     // Catch:{ all -> 0x0071 }
            java.util.LinkedHashMap r3 = r13.i     // Catch:{ all -> 0x0071 }
            java.util.Collection r3 = r3.values()     // Catch:{ all -> 0x0071 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0071 }
        L_0x004e:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x0071 }
            if (r6 == 0) goto L_0x0096
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x0071 }
            coil3.disk.DiskLruCache$Entry r6 = (coil3.disk.DiskLruCache.Entry) r6     // Catch:{ all -> 0x0071 }
            coil3.disk.DiskLruCache$Editor r7 = r6.g     // Catch:{ all -> 0x0071 }
            r8 = 32
            if (r7 == 0) goto L_0x0073
            java.lang.String r7 = "DIRTY"
            r2.writeUtf8(r7)     // Catch:{ all -> 0x0071 }
            r2.writeByte(r8)     // Catch:{ all -> 0x0071 }
            java.lang.String r6 = r6.f82a     // Catch:{ all -> 0x0071 }
            r2.writeUtf8(r6)     // Catch:{ all -> 0x0071 }
            r2.writeByte(r5)     // Catch:{ all -> 0x0071 }
            goto L_0x004e
        L_0x0071:
            r3 = move-exception
            goto L_0x009f
        L_0x0073:
            java.lang.String r7 = "CLEAN"
            r2.writeUtf8(r7)     // Catch:{ all -> 0x0071 }
            r2.writeByte(r8)     // Catch:{ all -> 0x0071 }
            java.lang.String r7 = r6.f82a     // Catch:{ all -> 0x0071 }
            r2.writeUtf8(r7)     // Catch:{ all -> 0x0071 }
            long[] r6 = r6.b     // Catch:{ all -> 0x0071 }
            int r7 = r6.length     // Catch:{ all -> 0x0071 }
            r9 = 0
        L_0x0084:
            if (r9 >= r7) goto L_0x0092
            r10 = r6[r9]     // Catch:{ all -> 0x0071 }
            okio.BufferedSink r12 = r2.writeByte(r8)     // Catch:{ all -> 0x0071 }
            r12.writeDecimalLong(r10)     // Catch:{ all -> 0x0071 }
            int r9 = r9 + 1
            goto L_0x0084
        L_0x0092:
            r2.writeByte(r5)     // Catch:{ all -> 0x0071 }
            goto L_0x004e
        L_0x0096:
            kotlin.Unit r3 = kotlin.Unit.f696a     // Catch:{ all -> 0x0071 }
            r2.close()     // Catch:{ all -> 0x009d }
            r2 = 0
            goto L_0x00aa
        L_0x009d:
            r2 = move-exception
            goto L_0x00aa
        L_0x009f:
            if (r2 == 0) goto L_0x00a9
            r2.close()     // Catch:{ all -> 0x00a5 }
            goto L_0x00a9
        L_0x00a5:
            r2 = move-exception
            kotlin.ExceptionsKt.a(r3, r2)     // Catch:{ all -> 0x000c }
        L_0x00a9:
            r2 = r3
        L_0x00aa:
            if (r2 != 0) goto L_0x00fb
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r13.t     // Catch:{ all -> 0x000c }
            okio.Path r3 = r13.e     // Catch:{ all -> 0x000c }
            boolean r2 = r2.exists(r3)     // Catch:{ all -> 0x000c }
            if (r2 == 0) goto L_0x00d0
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r13.t     // Catch:{ all -> 0x000c }
            okio.Path r3 = r13.e     // Catch:{ all -> 0x000c }
            okio.Path r5 = r13.g     // Catch:{ all -> 0x000c }
            r2.atomicMove(r3, r5)     // Catch:{ all -> 0x000c }
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r13.t     // Catch:{ all -> 0x000c }
            okio.Path r3 = r13.f     // Catch:{ all -> 0x000c }
            okio.Path r5 = r13.e     // Catch:{ all -> 0x000c }
            r2.atomicMove(r3, r5)     // Catch:{ all -> 0x000c }
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r13.t     // Catch:{ all -> 0x000c }
            okio.Path r3 = r13.g     // Catch:{ all -> 0x000c }
            r2.delete(r3)     // Catch:{ all -> 0x000c }
            goto L_0x00d9
        L_0x00d0:
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r13.t     // Catch:{ all -> 0x000c }
            okio.Path r3 = r13.f     // Catch:{ all -> 0x000c }
            okio.Path r5 = r13.e     // Catch:{ all -> 0x000c }
            r2.atomicMove(r3, r5)     // Catch:{ all -> 0x000c }
        L_0x00d9:
            coil3.disk.DiskLruCache$fileSystem$1 r2 = r13.t     // Catch:{ all -> 0x000c }
            okio.Path r3 = r13.e     // Catch:{ all -> 0x000c }
            okio.Sink r2 = r2.appendingSink(r3)     // Catch:{ all -> 0x000c }
            coil3.disk.FaultHidingSink r3 = new coil3.disk.FaultHidingSink     // Catch:{ all -> 0x000c }
            a r5 = new a     // Catch:{ all -> 0x000c }
            r5.<init>(r13, r0)     // Catch:{ all -> 0x000c }
            r3.<init>(r2, r5)     // Catch:{ all -> 0x000c }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r3)     // Catch:{ all -> 0x000c }
            r13.n = r0     // Catch:{ all -> 0x000c }
            r13.m = r4     // Catch:{ all -> 0x000c }
            r13.o = r4     // Catch:{ all -> 0x000c }
            r13.s = r4     // Catch:{ all -> 0x000c }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x000c }
            monitor-exit(r1)
            return
        L_0x00fb:
            throw r2     // Catch:{ all -> 0x000c }
        L_0x00fc:
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.disk.DiskLruCache.q():void");
    }
}
