package androidx.datastore.core;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/datastore/core/SharedCounter;", "", "mappedAddress", "", "(J)V", "getValue", "", "incrementAndGetValue", "Factory", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SharedCounter {
    @NotNull
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final NativeSharedCounter nativeSharedCounter = new NativeSharedCounter();
    private final long mappedAddress;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0000¢\u0006\u0002\b\fJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Landroidx/datastore/core/SharedCounter$Factory;", "", "()V", "nativeSharedCounter", "Landroidx/datastore/core/NativeSharedCounter;", "getNativeSharedCounter$datastore_core_release", "()Landroidx/datastore/core/NativeSharedCounter;", "create", "Landroidx/datastore/core/SharedCounter;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "create$datastore_core_release", "createCounterFromFd", "pfd", "Landroid/os/ParcelFileDescriptor;", "loadLib", "", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SharedCounter createCounterFromFd(ParcelFileDescriptor parcelFileDescriptor) {
            int fd = parcelFileDescriptor.getFd();
            if (getNativeSharedCounter$datastore_core_release().nativeTruncateFile(fd) == 0) {
                long nativeCreateSharedCounter = getNativeSharedCounter$datastore_core_release().nativeCreateSharedCounter(fd);
                if (nativeCreateSharedCounter >= 0) {
                    return new SharedCounter(nativeCreateSharedCounter, (DefaultConstructorMarker) null);
                }
                throw new IOException("Failed to mmap counter file");
            }
            throw new IOException("Failed to truncate counter file");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
        @org.jetbrains.annotations.NotNull
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.datastore.core.SharedCounter create$datastore_core_release(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends java.io.File> r2) {
            /*
                r1 = this;
                java.lang.String r0 = "produceFile"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                java.lang.Object r2 = r2.invoke()
                java.io.File r2 = (java.io.File) r2
                r0 = 939524096(0x38000000, float:3.0517578E-5)
                android.os.ParcelFileDescriptor r2 = android.os.ParcelFileDescriptor.open(r2, r0)     // Catch:{ all -> 0x001d }
                androidx.datastore.core.SharedCounter r0 = r1.createCounterFromFd(r2)     // Catch:{ all -> 0x001b }
                if (r2 == 0) goto L_0x001a
                r2.close()
            L_0x001a:
                return r0
            L_0x001b:
                r0 = move-exception
                goto L_0x001f
            L_0x001d:
                r0 = move-exception
                r2 = 0
            L_0x001f:
                if (r2 == 0) goto L_0x0024
                r2.close()
            L_0x0024:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SharedCounter.Factory.create$datastore_core_release(kotlin.jvm.functions.Function0):androidx.datastore.core.SharedCounter");
        }

        @NotNull
        public final NativeSharedCounter getNativeSharedCounter$datastore_core_release() {
            return SharedCounter.nativeSharedCounter;
        }

        public final void loadLib() {
            System.loadLibrary("datastore_shared_counter");
        }

        private Factory() {
        }
    }

    public /* synthetic */ SharedCounter(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    public final int getValue() {
        return nativeSharedCounter.nativeGetCounterValue(this.mappedAddress);
    }

    public final int incrementAndGetValue() {
        return nativeSharedCounter.nativeIncrementAndGetCounterValue(this.mappedAddress);
    }

    private SharedCounter(long j) {
        this.mappedAddress = j;
    }
}
