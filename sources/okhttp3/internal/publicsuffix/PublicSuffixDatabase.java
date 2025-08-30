package okhttp3.internal.publicsuffix;

import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.DropSequence;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PublicSuffixDatabase {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final char EXCEPTION_MARKER = '!';
    @NotNull
    private static final List<String> PREVAILING_RULE = CollectionsKt.s("*");
    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    @NotNull
    private static final byte[] WILDCARD_LABEL = {42};
    /* access modifiers changed from: private */
    @NotNull
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    @NotNull
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    @NotNull
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", "instance", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int i3;
            boolean z;
            int and;
            byte[] bArr3 = bArr;
            byte[][] bArr4 = bArr2;
            int length = bArr3.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = (i4 + length) / 2;
                while (i5 > -1 && bArr3[i5] != 10) {
                    i5--;
                }
                int i6 = i5 + 1;
                int i7 = 1;
                while (true) {
                    i2 = i6 + i7;
                    if (bArr3[i2] == 10) {
                        break;
                    }
                    i7++;
                }
                int i8 = i2 - i6;
                int i9 = i;
                boolean z2 = false;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (z2) {
                        i3 = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        i3 = Util.and(bArr4[i9][i10], 255);
                        z = z3;
                    }
                    and = i3 - Util.and(bArr3[i6 + i11], 255);
                    if (and != 0) {
                        break;
                    }
                    i11++;
                    i10++;
                    if (i11 == i8) {
                        break;
                    } else if (bArr4[i9].length != i10) {
                        z2 = z;
                    } else if (i9 == bArr4.length - 1) {
                        break;
                    } else {
                        i9++;
                        z2 = true;
                        i10 = -1;
                    }
                }
                if (and >= 0) {
                    if (and <= 0) {
                        int i12 = i8 - i11;
                        int length2 = bArr4[i9].length - i10;
                        int length3 = bArr4.length;
                        for (int i13 = i9 + 1; i13 < length3; i13++) {
                            length2 += bArr4[i13].length;
                        }
                        if (length2 >= i12) {
                            if (length2 <= i12) {
                                Charset charset = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(charset, "UTF_8");
                                return new String(bArr3, i6, i8, charset);
                            }
                        }
                    }
                    i4 = i2 + 1;
                }
                length = i5;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> findMatchingRule(java.util.List<java.lang.String> r12) {
        /*
            r11 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r11.listRead
            boolean r0 = r0.get()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0016
            java.util.concurrent.atomic.AtomicBoolean r0 = r11.listRead
            boolean r0 = r0.compareAndSet(r1, r2)
            if (r0 == 0) goto L_0x0016
            r11.readTheListUninterruptibly()
            goto L_0x0023
        L_0x0016:
            java.util.concurrent.CountDownLatch r0 = r11.readCompleteLatch     // Catch:{ InterruptedException -> 0x001c }
            r0.await()     // Catch:{ InterruptedException -> 0x001c }
            goto L_0x0023
        L_0x001c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0023:
            byte[] r0 = r11.publicSuffixListBytes
            if (r0 == 0) goto L_0x00e8
            int r0 = r12.size()
            byte[][] r3 = new byte[r0][]
            r4 = 0
        L_0x002e:
            if (r4 >= r0) goto L_0x004a
            java.lang.Object r5 = r12.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8
            java.lang.String r7 = "UTF_8"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            byte[] r5 = r5.getBytes(r6)
            java.lang.String r6 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r3[r4] = r5
            int r4 = r4 + r2
            goto L_0x002e
        L_0x004a:
            r12 = 0
        L_0x004b:
            r4 = 0
            java.lang.String r5 = "publicSuffixListBytes"
            if (r12 >= r0) goto L_0x0063
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r6 = Companion
            byte[] r7 = r11.publicSuffixListBytes
            if (r7 == 0) goto L_0x005f
            java.lang.String r6 = r6.binarySearch(r7, r3, r12)
            if (r6 == 0) goto L_0x005d
            goto L_0x0064
        L_0x005d:
            int r12 = r12 + r2
            goto L_0x004b
        L_0x005f:
            kotlin.jvm.internal.Intrinsics.k(r5)
            throw r4
        L_0x0063:
            r6 = r4
        L_0x0064:
            if (r0 <= r2) goto L_0x0088
            java.lang.Object r12 = r3.clone()
            byte[][] r12 = (byte[][]) r12
            int r7 = r12.length
            int r7 = r7 - r2
            r8 = 0
        L_0x006f:
            if (r8 >= r7) goto L_0x0088
            byte[] r9 = WILDCARD_LABEL
            r12[r8] = r9
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r9 = Companion
            byte[] r10 = r11.publicSuffixListBytes
            if (r10 == 0) goto L_0x0084
            java.lang.String r9 = r9.binarySearch(r10, r12, r8)
            if (r9 == 0) goto L_0x0082
            goto L_0x0089
        L_0x0082:
            int r8 = r8 + r2
            goto L_0x006f
        L_0x0084:
            kotlin.jvm.internal.Intrinsics.k(r5)
            throw r4
        L_0x0088:
            r9 = r4
        L_0x0089:
            if (r9 == 0) goto L_0x00a5
            int r0 = r0 - r2
            r12 = 0
        L_0x008d:
            if (r12 >= r0) goto L_0x00a5
            okhttp3.internal.publicsuffix.PublicSuffixDatabase$Companion r5 = Companion
            byte[] r7 = r11.publicSuffixExceptionListBytes
            if (r7 == 0) goto L_0x009f
            java.lang.String r5 = r5.binarySearch(r7, r3, r12)
            if (r5 == 0) goto L_0x009d
            r4 = r5
            goto L_0x00a5
        L_0x009d:
            int r12 = r12 + r2
            goto L_0x008d
        L_0x009f:
            java.lang.String r12 = "publicSuffixExceptionListBytes"
            kotlin.jvm.internal.Intrinsics.k(r12)
            throw r4
        L_0x00a5:
            r12 = 46
            if (r4 == 0) goto L_0x00b8
            java.lang.String r0 = "!"
            java.lang.String r0 = r0.concat(r4)
            char[] r2 = new char[r2]
            r2[r1] = r12
            java.util.List r12 = kotlin.text.StringsKt.F(r0, r2)
            return r12
        L_0x00b8:
            if (r6 != 0) goto L_0x00bf
            if (r9 != 0) goto L_0x00bf
            java.util.List<java.lang.String> r12 = PREVAILING_RULE
            return r12
        L_0x00bf:
            if (r6 == 0) goto L_0x00cb
            char[] r0 = new char[r2]
            r0[r1] = r12
            java.util.List r0 = kotlin.text.StringsKt.F(r6, r0)
            if (r0 != 0) goto L_0x00cd
        L_0x00cb:
            kotlin.collections.EmptyList r0 = kotlin.collections.EmptyList.INSTANCE
        L_0x00cd:
            if (r9 == 0) goto L_0x00d9
            char[] r2 = new char[r2]
            r2[r1] = r12
            java.util.List r12 = kotlin.text.StringsKt.F(r9, r2)
            if (r12 != 0) goto L_0x00db
        L_0x00d9:
            kotlin.collections.EmptyList r12 = kotlin.collections.EmptyList.INSTANCE
        L_0x00db:
            int r1 = r0.size()
            int r2 = r12.size()
            if (r1 <= r2) goto L_0x00e6
            goto L_0x00e7
        L_0x00e6:
            r0 = r12
        L_0x00e7:
            return r0
        L_0x00e8:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unable to load publicsuffixes.gz resource from the classpath."
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.findMatchingRule(java.util.List):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0064, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.io.CloseableKt.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheList() throws java.io.IOException {
        /*
            r5 = this;
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x005d }
            r0.<init>()     // Catch:{ all -> 0x005d }
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            java.lang.Class<okhttp3.internal.publicsuffix.PublicSuffixDatabase> r2 = okhttp3.internal.publicsuffix.PublicSuffixDatabase.class
            java.lang.String r3 = "publicsuffixes.gz"
            java.io.InputStream r2 = r2.getResourceAsStream(r3)     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x001a
            java.util.concurrent.CountDownLatch r0 = r5.readCompleteLatch
            r0.countDown()
            return
        L_0x001a:
            okio.GzipSource r3 = new okio.GzipSource     // Catch:{ all -> 0x005d }
            okio.Source r2 = okio.Okio.source((java.io.InputStream) r2)     // Catch:{ all -> 0x005d }
            r3.<init>(r2)     // Catch:{ all -> 0x005d }
            okio.BufferedSource r2 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x005d }
            int r3 = r2.readInt()     // Catch:{ all -> 0x0062 }
            long r3 = (long) r3     // Catch:{ all -> 0x0062 }
            byte[] r3 = r2.readByteArray(r3)     // Catch:{ all -> 0x0062 }
            r0.element = r3     // Catch:{ all -> 0x0062 }
            int r3 = r2.readInt()     // Catch:{ all -> 0x0062 }
            long r3 = (long) r3     // Catch:{ all -> 0x0062 }
            byte[] r3 = r2.readByteArray(r3)     // Catch:{ all -> 0x0062 }
            r1.element = r3     // Catch:{ all -> 0x0062 }
            kotlin.Unit r3 = kotlin.Unit.f696a     // Catch:{ all -> 0x0062 }
            r3 = 0
            kotlin.io.CloseableKt.a(r2, r3)     // Catch:{ all -> 0x005d }
            monitor-enter(r5)     // Catch:{ all -> 0x005d }
            T r0 = r0.element     // Catch:{ all -> 0x005f }
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x005f }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x005f }
            r5.publicSuffixListBytes = r0     // Catch:{ all -> 0x005f }
            T r0 = r1.element     // Catch:{ all -> 0x005f }
            kotlin.jvm.internal.Intrinsics.c(r0)     // Catch:{ all -> 0x005f }
            byte[] r0 = (byte[]) r0     // Catch:{ all -> 0x005f }
            r5.publicSuffixExceptionListBytes = r0     // Catch:{ all -> 0x005f }
            monitor-exit(r5)     // Catch:{ all -> 0x005d }
            java.util.concurrent.CountDownLatch r0 = r5.readCompleteLatch
            r0.countDown()
            return
        L_0x005d:
            r0 = move-exception
            goto L_0x0069
        L_0x005f:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x005d }
            throw r0     // Catch:{ all -> 0x005d }
        L_0x0062:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r2, r0)     // Catch:{ all -> 0x005d }
            throw r1     // Catch:{ all -> 0x005d }
        L_0x0069:
            java.util.concurrent.CountDownLatch r1 = r5.readCompleteLatch
            r1.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheList():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readTheListUninterruptibly() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            r5.readTheList()     // Catch:{ InterruptedIOException -> 0x0027, IOException -> 0x0010 }
            if (r0 == 0) goto L_0x000d
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x000d:
            return
        L_0x000e:
            r1 = move-exception
            goto L_0x002c
        L_0x0010:
            r1 = move-exception
            okhttp3.internal.platform.Platform$Companion r2 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x000e }
            okhttp3.internal.platform.Platform r2 = r2.get()     // Catch:{ all -> 0x000e }
            java.lang.String r3 = "Failed to read public suffix list"
            r4 = 5
            r2.log(r3, r4, r1)     // Catch:{ all -> 0x000e }
            if (r0 == 0) goto L_0x0026
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0026:
            return
        L_0x0027:
            java.lang.Thread.interrupted()     // Catch:{ all -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x002c:
            if (r0 == 0) goto L_0x0035
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L_0x0035:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.publicsuffix.PublicSuffixDatabase.readTheListUninterruptibly():void");
    }

    private final List<String> splitDomain(String str) {
        int i = 0;
        List<String> F = StringsKt.F(str, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR});
        if (!Intrinsics.a(CollectionsKt.q(F), "")) {
            return F;
        }
        Intrinsics.checkNotNullParameter(F, "<this>");
        Iterable iterable = F;
        int size = F.size() - 1;
        if (size >= 0) {
            i = size;
        }
        return CollectionsKt.A(iterable, i);
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String str) {
        int size;
        int size2;
        Intrinsics.checkNotNullParameter(str, "domain");
        String unicode = IDN.toUnicode(str);
        Intrinsics.checkNotNullExpressionValue(unicode, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicode);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        int i = 0;
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        int i2 = size - size2;
        Iterable splitDomain2 = splitDomain(str);
        Intrinsics.checkNotNullParameter(splitDomain2, "<this>");
        Sequence collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 = new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(splitDomain2);
        Intrinsics.checkNotNullParameter(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1, "<this>");
        if (i2 >= 0) {
            if (i2 != 0) {
                if (collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 instanceof DropTakeSequence) {
                    collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 = ((DropTakeSequence) collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1).a(i2);
                } else {
                    collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 = new DropSequence(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1, i2);
                }
            }
            Intrinsics.checkNotNullParameter(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1, "<this>");
            Intrinsics.checkNotNullParameter(".", "separator");
            Intrinsics.checkNotNullParameter("", "prefix");
            Intrinsics.checkNotNullParameter("", "postfix");
            Intrinsics.checkNotNullParameter("...", "truncated");
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullParameter(collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1, "<this>");
            Intrinsics.checkNotNullParameter(sb, "buffer");
            Intrinsics.checkNotNullParameter(".", "separator");
            Intrinsics.checkNotNullParameter("", "prefix");
            Intrinsics.checkNotNullParameter("", "postfix");
            Intrinsics.checkNotNullParameter("...", "truncated");
            sb.append("");
            for (Object next : collectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1) {
                i++;
                if (i > 1) {
                    sb.append(".");
                }
                StringsKt.j(sb, next, (Function1) null);
            }
            sb.append("");
            return sb.toString();
        }
        throw new IllegalArgumentException(ba.l(i2, "Requested element count ", " is less than zero.").toString());
    }

    public final void setListBytes(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(bArr2, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = bArr;
        this.publicSuffixExceptionListBytes = bArr2;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
