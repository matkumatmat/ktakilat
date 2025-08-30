package okio.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0002\u001a\u001f\u0010\u0019\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u001c\u001a\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0000\u001a.\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0014\b\u0002\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020&0%H\u0000\u001a\f\u0010'\u001a\u00020\u0016*\u00020(H\u0000\u001a\f\u0010)\u001a\u00020**\u00020(H\u0002\u001a.\u0010+\u001a\u00020,*\u00020(2\u0006\u0010-\u001a\u00020\u00012\u0018\u0010.\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020,0/H\u0002\u001a\u0014\u00100\u001a\u00020\u0016*\u00020(2\u0006\u00101\u001a\u00020\u0016H\u0000\u001a\u0018\u00102\u001a\u0004\u0018\u00010\u0016*\u00020(2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0002\u001a\u0014\u00103\u001a\u00020**\u00020(2\u0006\u00104\u001a\u00020*H\u0002\u001a\f\u00105\u001a\u00020,*\u00020(H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0018\u0010\u000f\u001a\u00020\u0010*\u00020\u00018BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u00066"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_NTFS_EXTRA", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "filetimeToEpochMillis", "filetime", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readCentralDirectoryZipEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "centralDirectoryZipEntry", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nZipFiles.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n+ 2 Okio.kt\nokio/Okio__OkioKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,503:1\n52#2,4:504\n52#2,4:508\n52#2,22:512\n60#2,10:534\n56#2,3:544\n71#2,3:547\n52#2,22:550\n60#2,10:572\n56#2,3:582\n71#2,3:585\n1045#3:588\n*S KotlinDebug\n*F\n+ 1 ZipFiles.kt\nokio/internal/ZipFilesKt\n*L\n66#1:504,4\n101#1:508,4\n109#1:512,22\n101#1:534,10\n101#1:544,3\n101#1:547,3\n125#1:550,22\n66#1:572,10\n66#1:582,3\n66#1:585,3\n155#1:588\n*E\n"})
public final class ZipFilesKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_NTFS_EXTRA = 10;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        Path path = Path.Companion.get$default(Path.Companion, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null);
        LinkedHashMap f = MapsKt.f(new Pair(path, new ZipEntry(path, true, (String) null, 0, 0, 0, 0, 0, 0, 0, (Long) null, (Long) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, 65532, (DefaultConstructorMarker) null)));
        Iterator it = CollectionsKt.z(list, new ZipFilesKt$buildIndex$$inlined$sortedBy$1()).iterator();
        while (it.hasNext()) {
            ZipEntry zipEntry = (ZipEntry) it.next();
            if (((ZipEntry) f.put(zipEntry.getCanonicalPath(), zipEntry)) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = (ZipEntry) f.get(parent);
                    if (zipEntry2 != null) {
                        zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                        break;
                    }
                    Iterator it2 = it;
                    ZipEntry zipEntry3 = r4;
                    ZipEntry zipEntry4 = new ZipEntry(parent, true, (String) null, 0, 0, 0, 0, 0, 0, 0, (Long) null, (Long) null, (Long) null, (Integer) null, (Integer) null, (Integer) null, 65532, (DefaultConstructorMarker) null);
                    f.put(parent, zipEntry3);
                    zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                    zipEntry = zipEntry3;
                    it = it2;
                }
            }
        }
        return f;
    }

    @Nullable
    public static final Long dosDateTimeToEpochMillis(int i, int i2) {
        if (i2 == -1) {
            return null;
        }
        return Long.valueOf(_ZlibJvmKt.datePartsToEpochMillis(((i >> 9) & 127) + 1980, (i >> 5) & 15, i & 31, (i2 >> 11) & 31, (i2 >> 5) & 63, (i2 & 31) << 1));
    }

    public static final long filetimeToEpochMillis(long j) {
        return (j / ((long) 10000)) - 11644473600000L;
    }

    private static final String getHex(int i) {
        StringBuilder sb = new StringBuilder("0x");
        String num = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        sb.append(num);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x016c, code lost:
        r3 = new okio.ZipFileSystem(r1, r2, buildIndex(r5), r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0175, code lost:
        if (r4 != null) goto L_0x0177;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x017a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        throw r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r11.close();
        r5 = r5 - ((long) 20);
        r11 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
        if (r5 <= 0) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        r5 = okio.Okio.buffer(r4.source(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006b, code lost:
        if (r5.readIntLe() != ZIP64_LOCATOR_SIGNATURE) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006d, code lost:
        r0 = r5.readIntLe();
        r12 = r5.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007a, code lost:
        if (r5.readIntLe() != 1) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007c, code lost:
        if (r0 != 0) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007e, code lost:
        r6 = okio.Okio.buffer(r4.source(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r0 = r6.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        if (r0 != ZIP64_EOCD_RECORD_SIGNATURE) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008f, code lost:
        r9 = readZip64EocdRecord(r6, r9);
        r0 = kotlin.Unit.f696a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (r6 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009d, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a0, code lost:
        r12 = r9;
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c9, code lost:
        throw new java.io.IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
        if (r6 != null) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        kotlin.ExceptionsKt.a(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d7, code lost:
        r6 = r0;
        r9 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e1, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ea, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (r5 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0107, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010b, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x010c, code lost:
        r5 = new java.util.ArrayList();
        r6 = okio.Okio.buffer(r4.source(r9.getCentralDirectoryOffset()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r12 = r9.getEntryCount();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0123, code lost:
        if (r7 < r12) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0125, code lost:
        r0 = readCentralDirectoryZipEntry(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0133, code lost:
        if (r0.getOffset() < r9.getCentralDirectoryOffset()) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013f, code lost:
        if (((java.lang.Boolean) r3.invoke(r0)).booleanValue() != false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0141, code lost:
        r5.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0145, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0146, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0148, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0153, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0154, code lost:
        r0 = kotlin.Unit.f696a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0156, code lost:
        if (r6 != null) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x015c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x015d, code lost:
        r11 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x015f, code lost:
        if (r6 != null) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0165, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        kotlin.ExceptionsKt.a(r11, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x016a, code lost:
        if (r11 == null) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0043, code lost:
        r9 = readEocdRecord(r11);
        r10 = r11.readUtf8((long) r9.getCommentByteCount());
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00df A[SYNTHETIC, Splitter:B:46:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ef A[SYNTHETIC, Splitter:B:54:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x010a A[Catch:{ all -> 0x017c, all -> 0x00fd, all -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010b A[Catch:{ all -> 0x017c, all -> 0x00fd, all -> 0x0103 }] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.ZipFileSystem openZip(@org.jetbrains.annotations.NotNull okio.Path r19, @org.jetbrains.annotations.NotNull okio.FileSystem r20, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super okio.internal.ZipEntry, java.lang.Boolean> r21) throws java.io.IOException {
        /*
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r0 = "not a zip: size="
            java.lang.String r4 = "zipPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "fileSystem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "predicate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            okio.FileHandle r4 = r2.openReadOnly(r1)
            long r5 = r4.size()     // Catch:{ all -> 0x0103 }
            r7 = 22
            long r7 = (long) r7     // Catch:{ all -> 0x0103 }
            long r5 = r5 - r7
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 < 0) goto L_0x0196
            r9 = 65536(0x10000, double:3.2379E-319)
            long r9 = r5 - r9
            long r9 = java.lang.Math.max(r9, r7)     // Catch:{ all -> 0x0103 }
        L_0x0032:
            okio.Source r0 = r4.source(r5)     // Catch:{ all -> 0x0103 }
            okio.BufferedSource r11 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x0103 }
            int r0 = r11.readIntLe()     // Catch:{ all -> 0x017c }
            r12 = 101010256(0x6054b50, float:2.506985E-35)
            if (r0 != r12) goto L_0x017e
            okio.internal.EocdRecord r9 = readEocdRecord(r11)     // Catch:{ all -> 0x017c }
            int r0 = r9.getCommentByteCount()     // Catch:{ all -> 0x017c }
            long r12 = (long) r0     // Catch:{ all -> 0x017c }
            java.lang.String r10 = r11.readUtf8(r12)     // Catch:{ all -> 0x017c }
            r11.close()     // Catch:{ all -> 0x0103 }
            r0 = 20
            long r11 = (long) r0     // Catch:{ all -> 0x0103 }
            long r5 = r5 - r11
            r11 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x010c
            okio.Source r0 = r4.source(r5)     // Catch:{ all -> 0x0103 }
            okio.BufferedSource r5 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x0103 }
            int r0 = r5.readIntLe()     // Catch:{ all -> 0x00e0 }
            r6 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r0 != r6) goto L_0x00eb
            int r0 = r5.readIntLe()     // Catch:{ all -> 0x00e0 }
            long r12 = r5.readLongLe()     // Catch:{ all -> 0x00e0 }
            int r6 = r5.readIntLe()     // Catch:{ all -> 0x00e0 }
            r14 = 1
            if (r6 != r14) goto L_0x00e3
            if (r0 != 0) goto L_0x00e3
            okio.Source r0 = r4.source(r12)     // Catch:{ all -> 0x00e0 }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x00e0 }
            int r0 = r6.readIntLe()     // Catch:{ all -> 0x009f }
            r12 = 101075792(0x6064b50, float:2.525793E-35)
            if (r0 != r12) goto L_0x00a3
            okio.internal.EocdRecord r9 = readZip64EocdRecord(r6, r9)     // Catch:{ all -> 0x009f }
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x009f }
            if (r6 == 0) goto L_0x009d
            r6.close()     // Catch:{ all -> 0x009b }
            goto L_0x009d
        L_0x009b:
            r0 = move-exception
            goto L_0x00dc
        L_0x009d:
            r0 = r11
            goto L_0x00dc
        L_0x009f:
            r0 = move-exception
            r12 = r9
            r9 = r0
            goto L_0x00ca
        L_0x00a3:
            java.io.IOException r13 = new java.io.IOException     // Catch:{ all -> 0x009f }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r14.<init>()     // Catch:{ all -> 0x009f }
            java.lang.String r15 = "bad zip: expected "
            r14.append(r15)     // Catch:{ all -> 0x009f }
            java.lang.String r12 = getHex(r12)     // Catch:{ all -> 0x009f }
            r14.append(r12)     // Catch:{ all -> 0x009f }
            java.lang.String r12 = " but was "
            r14.append(r12)     // Catch:{ all -> 0x009f }
            java.lang.String r0 = getHex(r0)     // Catch:{ all -> 0x009f }
            r14.append(r0)     // Catch:{ all -> 0x009f }
            java.lang.String r0 = r14.toString()     // Catch:{ all -> 0x009f }
            r13.<init>(r0)     // Catch:{ all -> 0x009f }
            throw r13     // Catch:{ all -> 0x009f }
        L_0x00ca:
            if (r6 == 0) goto L_0x00da
            r6.close()     // Catch:{ all -> 0x00d0 }
            goto L_0x00da
        L_0x00d0:
            r0 = move-exception
            r6 = r0
            kotlin.ExceptionsKt.a(r9, r6)     // Catch:{ all -> 0x00d6 }
            goto L_0x00da
        L_0x00d6:
            r0 = move-exception
            r6 = r0
            r9 = r12
            goto L_0x00f7
        L_0x00da:
            r0 = r9
            r9 = r12
        L_0x00dc:
            if (r0 != 0) goto L_0x00df
            goto L_0x00eb
        L_0x00df:
            throw r0     // Catch:{ all -> 0x00e0 }
        L_0x00e0:
            r0 = move-exception
            r6 = r0
            goto L_0x00f7
        L_0x00e3:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00e0 }
            java.lang.String r6 = "unsupported zip: spanned"
            r0.<init>(r6)     // Catch:{ all -> 0x00e0 }
            throw r0     // Catch:{ all -> 0x00e0 }
        L_0x00eb:
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x00e0 }
            if (r5 == 0) goto L_0x00f5
            r5.close()     // Catch:{ all -> 0x00f3 }
            goto L_0x00f5
        L_0x00f3:
            r0 = move-exception
            goto L_0x0108
        L_0x00f5:
            r0 = r11
            goto L_0x0108
        L_0x00f7:
            if (r5 == 0) goto L_0x0107
            r5.close()     // Catch:{ all -> 0x00fd }
            goto L_0x0107
        L_0x00fd:
            r0 = move-exception
            r5 = r0
            kotlin.ExceptionsKt.a(r6, r5)     // Catch:{ all -> 0x0103 }
            goto L_0x0107
        L_0x0103:
            r0 = move-exception
            r1 = r0
            goto L_0x01ac
        L_0x0107:
            r0 = r6
        L_0x0108:
            if (r0 != 0) goto L_0x010b
            goto L_0x010c
        L_0x010b:
            throw r0     // Catch:{ all -> 0x0103 }
        L_0x010c:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0103 }
            r5.<init>()     // Catch:{ all -> 0x0103 }
            long r12 = r9.getCentralDirectoryOffset()     // Catch:{ all -> 0x0103 }
            okio.Source r0 = r4.source(r12)     // Catch:{ all -> 0x0103 }
            okio.BufferedSource r6 = okio.Okio.buffer((okio.Source) r0)     // Catch:{ all -> 0x0103 }
            long r12 = r9.getEntryCount()     // Catch:{ all -> 0x0145 }
        L_0x0121:
            int r0 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r0 >= 0) goto L_0x0154
            okio.internal.ZipEntry r0 = readCentralDirectoryZipEntry(r6)     // Catch:{ all -> 0x0145 }
            long r14 = r0.getOffset()     // Catch:{ all -> 0x0145 }
            long r16 = r9.getCentralDirectoryOffset()     // Catch:{ all -> 0x0145 }
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x014c
            java.lang.Object r14 = r3.invoke(r0)     // Catch:{ all -> 0x0145 }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x0145 }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x0145 }
            if (r14 == 0) goto L_0x0148
            r5.add(r0)     // Catch:{ all -> 0x0145 }
            goto L_0x0148
        L_0x0145:
            r0 = move-exception
            r11 = r0
            goto L_0x015f
        L_0x0148:
            r14 = 1
            long r7 = r7 + r14
            goto L_0x0121
        L_0x014c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0145 }
            java.lang.String r3 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r3)     // Catch:{ all -> 0x0145 }
            throw r0     // Catch:{ all -> 0x0145 }
        L_0x0154:
            kotlin.Unit r0 = kotlin.Unit.f696a     // Catch:{ all -> 0x0145 }
            if (r6 == 0) goto L_0x016a
            r6.close()     // Catch:{ all -> 0x015c }
            goto L_0x016a
        L_0x015c:
            r0 = move-exception
            r11 = r0
            goto L_0x016a
        L_0x015f:
            if (r6 == 0) goto L_0x016a
            r6.close()     // Catch:{ all -> 0x0165 }
            goto L_0x016a
        L_0x0165:
            r0 = move-exception
            r3 = r0
            kotlin.ExceptionsKt.a(r11, r3)     // Catch:{ all -> 0x0103 }
        L_0x016a:
            if (r11 != 0) goto L_0x017b
            java.util.Map r0 = buildIndex(r5)     // Catch:{ all -> 0x0103 }
            okio.ZipFileSystem r3 = new okio.ZipFileSystem     // Catch:{ all -> 0x0103 }
            r3.<init>(r1, r2, r0, r10)     // Catch:{ all -> 0x0103 }
            if (r4 == 0) goto L_0x017a
            r4.close()     // Catch:{ all -> 0x017a }
        L_0x017a:
            return r3
        L_0x017b:
            throw r11     // Catch:{ all -> 0x0103 }
        L_0x017c:
            r0 = move-exception
            goto L_0x0192
        L_0x017e:
            r11.close()     // Catch:{ all -> 0x0103 }
            r11 = -1
            long r5 = r5 + r11
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x018a
            goto L_0x0032
        L_0x018a:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0103 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x0103 }
            throw r0     // Catch:{ all -> 0x0103 }
        L_0x0192:
            r11.close()     // Catch:{ all -> 0x0103 }
            throw r0     // Catch:{ all -> 0x0103 }
        L_0x0196:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x0103 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0103 }
            r2.<init>(r0)     // Catch:{ all -> 0x0103 }
            long r5 = r4.size()     // Catch:{ all -> 0x0103 }
            r2.append(r5)     // Catch:{ all -> 0x0103 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0103 }
            r1.<init>(r0)     // Catch:{ all -> 0x0103 }
            throw r1     // Catch:{ all -> 0x0103 }
        L_0x01ac:
            if (r4 == 0) goto L_0x01b7
            r4.close()     // Catch:{ all -> 0x01b2 }
            goto L_0x01b7
        L_0x01b2:
            r0 = move-exception
            r2 = r0
            kotlin.ExceptionsKt.a(r1, r2)
        L_0x01b7:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ZipFilesKt.openZip(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1):okio.ZipFileSystem");
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 4) != 0) {
            function1 = ZipFilesKt$openZip$1.INSTANCE;
        }
        return openZip(path, fileSystem, function1);
    }

    @NotNull
    public static final ZipEntry readCentralDirectoryZipEntry(@NotNull BufferedSource bufferedSource) throws IOException {
        String str;
        long j;
        BufferedSource bufferedSource2 = bufferedSource;
        Intrinsics.checkNotNullParameter(bufferedSource2, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource2.skip(4);
            short readShortLe = bufferedSource.readShortLe();
            short s = readShortLe & 65535;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = bufferedSource.readShortLe() & 65535;
                short readShortLe3 = bufferedSource.readShortLe() & 65535;
                short readShortLe4 = bufferedSource.readShortLe() & 65535;
                long readIntLe2 = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef = new Ref.LongRef();
                longRef.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                short readShortLe5 = bufferedSource.readShortLe() & 65535;
                short readShortLe6 = bufferedSource.readShortLe() & 65535;
                bufferedSource2.skip(8);
                Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = ((long) bufferedSource.readIntLe()) & MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE;
                String readUtf8 = bufferedSource2.readUtf8((long) (bufferedSource.readShortLe() & 65535));
                if (!StringsKt.m(readUtf8, 0)) {
                    if (longRef2.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j = (long) 8;
                        str = readUtf8;
                    } else {
                        str = readUtf8;
                        j = 0;
                    }
                    if (longRef.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j += (long) 8;
                    }
                    if (longRef3.element == MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE) {
                        j += (long) 8;
                    }
                    long j2 = j;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                    Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    ZipFilesKt$readCentralDirectoryZipEntry$1 zipFilesKt$readCentralDirectoryZipEntry$1 = r0;
                    Ref.LongRef longRef4 = longRef2;
                    Ref.LongRef longRef5 = longRef2;
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    Ref.ObjectRef objectRef4 = objectRef3;
                    Ref.ObjectRef objectRef5 = objectRef2;
                    Ref.LongRef longRef6 = longRef;
                    String str2 = str;
                    Ref.ObjectRef objectRef6 = objectRef;
                    Ref.LongRef longRef7 = longRef3;
                    short s2 = readShortLe6;
                    ZipFilesKt$readCentralDirectoryZipEntry$1 zipFilesKt$readCentralDirectoryZipEntry$12 = new ZipFilesKt$readCentralDirectoryZipEntry$1(booleanRef, j2, longRef4, bufferedSource, longRef, longRef3, objectRef, objectRef5, objectRef4);
                    readExtra(bufferedSource2, readShortLe5, zipFilesKt$readCentralDirectoryZipEntry$1);
                    if (j2 <= 0 || booleanRef2.element) {
                        String str3 = str2;
                        return new ZipEntry(Path.Companion.get$default(Path.Companion, RemoteSettings.FORWARD_SLASH_STRING, false, 1, (Object) null).resolve(str3), StringsKt.p(str3, RemoteSettings.FORWARD_SLASH_STRING, false), bufferedSource2.readUtf8((long) s2), readIntLe2, longRef6.element, longRef5.element, readShortLe2, longRef7.element, readShortLe4, readShortLe3, (Long) objectRef6.element, (Long) objectRef5.element, (Long) objectRef4.element, (Integer) null, (Integer) null, (Integer) null, 57344, (DefaultConstructorMarker) null);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(s));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        short readShortLe = bufferedSource.readShortLe() & 65535;
        short readShortLe2 = bufferedSource.readShortLe() & 65535;
        long readShortLe3 = (long) (bufferedSource.readShortLe() & 65535);
        if (readShortLe3 == ((long) (bufferedSource.readShortLe() & 65535)) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4);
            return new EocdRecord(readShortLe3, MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE & ((long) bufferedSource.readIntLe()), bufferedSource.readShortLe() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    /* access modifiers changed from: private */
    public static final void readExtra(BufferedSource bufferedSource, int i, Function2<? super Integer, ? super Long, Unit> function2) {
        long j = (long) i;
        while (j != 0) {
            if (j >= 4) {
                short readShortLe = bufferedSource.readShortLe() & 65535;
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j2 = j - ((long) 4);
                if (j2 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    int i2 = (size2 > 0 ? 1 : (size2 == 0 ? 0 : -1));
                    if (i2 >= 0) {
                        if (i2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j = j2 - readShortLe2;
                    } else {
                        throw new IOException(ba.k(readShortLe, "unsupported zip: too many bytes processed for "));
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    @NotNull
    public static final ZipEntry readLocalHeader(@NotNull BufferedSource bufferedSource, @NotNull ZipEntry zipEntry) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(zipEntry, "centralDirectoryZipEntry");
        ZipEntry readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, zipEntry);
        Intrinsics.c(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    private static final ZipEntry readOrSkipLocalHeader(BufferedSource bufferedSource, ZipEntry zipEntry) {
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource.skip(2);
            short readShortLe = bufferedSource.readShortLe();
            short s = readShortLe & 65535;
            if ((readShortLe & 1) == 0) {
                bufferedSource.skip(18);
                long readShortLe2 = ((long) bufferedSource.readShortLe()) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                short readShortLe3 = bufferedSource.readShortLe() & 65535;
                bufferedSource.skip(readShortLe2);
                if (zipEntry == null) {
                    bufferedSource.skip((long) readShortLe3);
                    return null;
                }
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                readExtra(bufferedSource, readShortLe3, new ZipFilesKt$readOrSkipLocalHeader$1(bufferedSource, objectRef, objectRef2, objectRef3));
                return zipEntry.copy$okio((Integer) objectRef.element, (Integer) objectRef2.element, (Integer) objectRef3.element);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(s));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, (ZipEntry) null);
    }
}
