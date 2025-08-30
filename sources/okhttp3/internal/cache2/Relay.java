package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006<"}, d2 = {"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Relay {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long FILE_HEADER_SIZE = 32;
    @NotNull
    @JvmField
    public static final ByteString PREFIX_CLEAN;
    @NotNull
    @JvmField
    public static final ByteString PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    @NotNull
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    @Nullable
    private RandomAccessFile file;
    @NotNull
    private final ByteString metadata;
    private int sourceCount;
    @Nullable
    private Source upstream;
    @NotNull
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    @Nullable
    private Thread upstreamReader;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Relay edit(@NotNull File file, @NotNull Source source, @NotNull ByteString byteString, long j) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(source, "upstream");
            Intrinsics.checkNotNullParameter(byteString, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, source, 0, byteString, j, (DefaultConstructorMarker) null);
            randomAccessFile.setLength(0);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1, -1);
            return relay;
        }

        @NotNull
        public final Relay read(@NotNull File file) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer buffer = new Buffer();
            fileOperator.read(0, buffer, 32);
            ByteString byteString = Relay.PREFIX_CLEAN;
            if (Intrinsics.a(buffer.readByteString((long) byteString.size()), byteString)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + 32, buffer2, readLong2);
                return new Relay(randomAccessFile, (Source) null, readLong, buffer2.readByteString(), 0, (DefaultConstructorMarker) null);
            }
            throw new IOException("unreadable cache file");
        }

        private Companion() {
        }
    }

    @SourceDebugExtension({"SMAP\nRelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Relay.kt\nokhttp3/internal/cache2/Relay$RelaySource\n+ 2 Util.kt\nokhttp3/internal/Util\n*L\n1#1,356:1\n563#2:357\n*S KotlinDebug\n*F\n+ 1 Relay.kt\nokhttp3/internal/cache2/Relay$RelaySource\n*L\n267#1:357\n*E\n"})
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class RelaySource implements Source {
        @Nullable
        private FileOperator fileOperator;
        private long sourcePos;
        @NotNull
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            Intrinsics.c(file);
            FileChannel channel = file.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                Relay relay = Relay.this;
                synchronized (relay) {
                    try {
                        relay.setSourceCount(relay.getSourceCount() - 1);
                        if (relay.getSourceCount() == 0) {
                            RandomAccessFile file = relay.getFile();
                            relay.setFile((RandomAccessFile) null);
                            randomAccessFile = file;
                        }
                        Unit unit = Unit.f696a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
            r6 = r8.getUpstreamPos() - r8.getBuffer().size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
            if (r1.sourcePos >= r6) goto L_0x0148;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            r4 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
            if (r4 != 2) goto L_0x0079;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0058, code lost:
            r10 = java.lang.Math.min(r2, r1.this$0.getUpstreamPos() - r1.sourcePos);
            r2 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.c(r2);
            r2.read(r1.sourcePos + 32, r20, r10);
            r1.sourcePos += r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0078, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            r0 = r1.this$0.getUpstream();
            kotlin.jvm.internal.Intrinsics.c(r0);
            r14 = r0.read(r1.this$0.getUpstreamBuffer(), r1.this$0.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0095, code lost:
            if (r14 != -1) goto L_0x00b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
            r0 = r1.this$0;
            r0.commit(r0.getUpstreamPos());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a2, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
            r0 = kotlin.Unit.f696a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ac, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b0, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            r11 = java.lang.Math.min(r14, r2);
            r1.this$0.getUpstreamBuffer().copyTo(r20, 0, r11);
            r1.sourcePos += r11;
            r13 = r1.fileOperator;
            kotlin.jvm.internal.Intrinsics.c(r13);
            r4 = r14;
            r13.write(r1.this$0.getUpstreamPos() + 32, r1.this$0.getUpstreamBuffer().clone(), r4);
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ea, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            r2.getBuffer().write(r2.getUpstreamBuffer(), r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0104, code lost:
            if (r2.getBuffer().size() <= r2.getBufferMaxSize()) goto L_0x011d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0106, code lost:
            r2.getBuffer().skip(r2.getBuffer().size() - r2.getBufferMaxSize());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x011b, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x011d, code lost:
            r2.setUpstreamPos(r2.getUpstreamPos() + r4);
            r0 = kotlin.Unit.f696a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0128, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x012a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0131, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0132, code lost:
            return r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0137, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x0138, code lost:
            r2 = r1.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x013a, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
            r2.setUpstreamReader((java.lang.Thread) null);
            r2.notifyAll();
            r3 = kotlin.Unit.f696a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0144, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            r9 = java.lang.Math.min(r2, r8.getUpstreamPos() - r1.sourcePos);
            r8.getBuffer().copyTo(r20, r1.sourcePos - r6, r9);
            r1.sourcePos += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0168, code lost:
            return r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(@org.jetbrains.annotations.NotNull okio.Buffer r20, long r21) throws java.io.IOException {
            /*
                r19 = this;
                r1 = r19
                r2 = r21
                java.lang.String r0 = "sink"
                r5 = r20
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x016b
                okhttp3.internal.cache2.Relay r8 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r8)
            L_0x0012:
                long r6 = r8.getUpstreamPos()     // Catch:{ all -> 0x0033 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0033 }
                r0 = 2
                r11 = -1
                int r4 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x003f
                boolean r4 = r8.getComplete()     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x0027
                monitor-exit(r8)
                return r11
            L_0x0027:
                java.lang.Thread r4 = r8.getUpstreamReader()     // Catch:{ all -> 0x0033 }
                if (r4 == 0) goto L_0x0036
                okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0033 }
                r0.waitUntilNotified(r8)     // Catch:{ all -> 0x0033 }
                goto L_0x0012
            L_0x0033:
                r0 = move-exception
                goto L_0x0169
            L_0x0036:
                java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0033 }
                r8.setUpstreamReader(r4)     // Catch:{ all -> 0x0033 }
                r4 = 1
                goto L_0x0053
            L_0x003f:
                long r6 = r8.getUpstreamPos()     // Catch:{ all -> 0x0033 }
                okio.Buffer r4 = r8.getBuffer()     // Catch:{ all -> 0x0033 }
                long r9 = r4.size()     // Catch:{ all -> 0x0033 }
                long r6 = r6 - r9
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0033 }
                int r4 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                if (r4 >= 0) goto L_0x0148
                r4 = 2
            L_0x0053:
                monitor-exit(r8)
                r8 = 32
                if (r4 != r0) goto L_0x0079
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this
                long r6 = r0.getUpstreamPos()
                long r10 = r1.sourcePos
                long r6 = r6 - r10
                long r10 = java.lang.Math.min(r2, r6)
                okhttp3.internal.cache2.FileOperator r2 = r1.fileOperator
                kotlin.jvm.internal.Intrinsics.c(r2)
                long r3 = r1.sourcePos
                long r3 = r3 + r8
                r5 = r20
                r6 = r10
                r2.read(r3, r5, r6)
                long r2 = r1.sourcePos
                long r2 = r2 + r10
                r1.sourcePos = r2
                return r10
            L_0x0079:
                r10 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                okio.Source r0 = r0.getUpstream()     // Catch:{ all -> 0x00b0 }
                kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                okio.Buffer r4 = r4.getUpstreamBuffer()     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.Relay r6 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                long r6 = r6.getBufferMaxSize()     // Catch:{ all -> 0x00b0 }
                long r14 = r0.read(r4, r6)     // Catch:{ all -> 0x00b0 }
                int r0 = (r14 > r11 ? 1 : (r14 == r11 ? 0 : -1))
                if (r0 != 0) goto L_0x00b3
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x00b0 }
                r0.commit(r2)     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x00ad }
                r2.notifyAll()     // Catch:{ all -> 0x00ad }
                kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x00ad }
                monitor-exit(r2)
                return r11
            L_0x00ad:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x00b0:
                r0 = move-exception
                goto L_0x0138
            L_0x00b3:
                long r11 = java.lang.Math.min(r14, r2)     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                okio.Buffer r2 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x00b0 }
                r6 = 0
                r3 = r20
                r4 = r6
                r6 = r11
                r2.copyTo((okio.Buffer) r3, (long) r4, (long) r6)     // Catch:{ all -> 0x00b0 }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x00b0 }
                long r2 = r2 + r11
                r1.sourcePos = r2     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.FileOperator r13 = r1.fileOperator     // Catch:{ all -> 0x00b0 }
                kotlin.jvm.internal.Intrinsics.c(r13)     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                long r2 = r0.getUpstreamPos()     // Catch:{ all -> 0x00b0 }
                long r2 = r2 + r8
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                okio.Buffer r0 = r0.getUpstreamBuffer()     // Catch:{ all -> 0x00b0 }
                okio.Buffer r16 = r0.clone()     // Catch:{ all -> 0x00b0 }
                r4 = r14
                r14 = r2
                r17 = r4
                r13.write(r14, r16, r17)     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00b0 }
                monitor-enter(r2)     // Catch:{ all -> 0x00b0 }
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x011b }
                okio.Buffer r3 = r2.getUpstreamBuffer()     // Catch:{ all -> 0x011b }
                r0.write((okio.Buffer) r3, (long) r4)     // Catch:{ all -> 0x011b }
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x011b }
                long r6 = r0.size()     // Catch:{ all -> 0x011b }
                long r8 = r2.getBufferMaxSize()     // Catch:{ all -> 0x011b }
                int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x011d
                okio.Buffer r0 = r2.getBuffer()     // Catch:{ all -> 0x011b }
                okio.Buffer r3 = r2.getBuffer()     // Catch:{ all -> 0x011b }
                long r6 = r3.size()     // Catch:{ all -> 0x011b }
                long r8 = r2.getBufferMaxSize()     // Catch:{ all -> 0x011b }
                long r6 = r6 - r8
                r0.skip(r6)     // Catch:{ all -> 0x011b }
                goto L_0x011d
            L_0x011b:
                r0 = move-exception
                goto L_0x0136
            L_0x011d:
                long r6 = r2.getUpstreamPos()     // Catch:{ all -> 0x011b }
                long r6 = r6 + r4
                r2.setUpstreamPos(r6)     // Catch:{ all -> 0x011b }
                kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x011b }
                monitor-exit(r2)     // Catch:{ all -> 0x00b0 }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x0133 }
                r2.notifyAll()     // Catch:{ all -> 0x0133 }
                monitor-exit(r2)
                return r11
            L_0x0133:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0136:
                monitor-exit(r2)     // Catch:{ all -> 0x00b0 }
                throw r0     // Catch:{ all -> 0x00b0 }
            L_0x0138:
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                r2.setUpstreamReader(r10)     // Catch:{ all -> 0x0145 }
                r2.notifyAll()     // Catch:{ all -> 0x0145 }
                kotlin.Unit r3 = kotlin.Unit.f696a     // Catch:{ all -> 0x0145 }
                monitor-exit(r2)
                throw r0
            L_0x0145:
                r0 = move-exception
                monitor-exit(r2)
                throw r0
            L_0x0148:
                long r9 = r8.getUpstreamPos()     // Catch:{ all -> 0x0033 }
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0033 }
                long r9 = r9 - r11
                long r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x0033 }
                okio.Buffer r2 = r8.getBuffer()     // Catch:{ all -> 0x0033 }
                long r3 = r1.sourcePos     // Catch:{ all -> 0x0033 }
                long r6 = r3 - r6
                r3 = r20
                r4 = r6
                r6 = r9
                r2.copyTo((okio.Buffer) r3, (long) r4, (long) r6)     // Catch:{ all -> 0x0033 }
                long r2 = r1.sourcePos     // Catch:{ all -> 0x0033 }
                long r2 = r2 + r9
                r1.sourcePos = r2     // Catch:{ all -> 0x0033 }
                monitor-exit(r8)
                return r9
            L_0x0169:
                monitor-exit(r8)
                throw r0
            L_0x016b:
                java.lang.String r0 = "Check failed."
                java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        @NotNull
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        ByteString.Companion companion = ByteString.Companion;
        PREFIX_CLEAN = companion.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = companion.encodeUtf8("OkHttp DIRTY :(\n");
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j, byteString, j2);
    }

    /* access modifiers changed from: private */
    public final void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j);
        buffer2.writeLong(j2);
        if (buffer2.size() == 32) {
            RandomAccessFile randomAccessFile = this.file;
            Intrinsics.c(randomAccessFile);
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
            new FileOperator(channel).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.");
    }

    private final void writeMetadata(long j) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "file!!.channel");
        new FileOperator(channel).write(32 + j, buffer2, (long) this.metadata.size());
    }

    public final void commit(long j) throws IOException {
        writeMetadata(j);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.c(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.c(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            Unit unit = Unit.f696a;
        }
        Source source = this.upstream;
        if (source != null) {
            Util.closeQuietly((Closeable) source);
        }
        this.upstream = null;
    }

    @NotNull
    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    @Nullable
    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    @Nullable
    public final Source getUpstream() {
        return this.upstream;
    }

    @NotNull
    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    @Nullable
    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        if (this.file == null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ByteString metadata() {
        return this.metadata;
    }

    @Nullable
    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final void setFile(@Nullable RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final void setUpstream(@Nullable Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final void setUpstreamReader(@Nullable Thread thread) {
        this.upstreamReader = thread;
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }
}
