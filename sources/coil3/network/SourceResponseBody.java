package coil3.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b@\u0018\u00002\u00020\u0001\u0001\u0002\u0001\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcoil3/network/SourceResponseBody;", "Lcoil3/network/NetworkResponseBody;", "source", "Lokio/BufferedSource;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
@SourceDebugExtension({"SMAP\nNetworkClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NetworkClient.kt\ncoil3/network/SourceResponseBody\n+ 2 FileSystem.kt\nokio/FileSystem\n+ 3 Okio.kt\nokio/Okio__OkioKt\n*L\n1#1,136:1\n80#2:137\n165#2:138\n81#2:139\n82#2:144\n52#3,4:140\n60#3,10:145\n56#3,18:155\n*S KotlinDebug\n*F\n+ 1 NetworkClient.kt\ncoil3/network/SourceResponseBody\n*L\n127#1:137\n127#1:138\n127#1:139\n127#1:144\n127#1:140,4\n127#1:145,10\n127#1:155,18\n*E\n"})
final class SourceResponseBody implements NetworkResponseBody {
    public final BufferedSource c;

    public /* synthetic */ SourceResponseBody(BufferedSource bufferedSource) {
        this.c = bufferedSource;
    }

    public final Unit a(Buffer buffer) {
        this.c.readAll(buffer);
        return Unit.f696a;
    }

    public final void close() {
        this.c.close();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SourceResponseBody)) {
            return false;
        }
        if (!Intrinsics.a(this.c, ((SourceResponseBody) obj).c)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.c.hashCode();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Unit n(okio.FileSystem r3, okio.Path r4) {
        /*
            r2 = this;
            okio.BufferedSource r0 = r2.c
            r1 = 0
            okio.Sink r3 = r3.sink(r4, r1)
            okio.BufferedSink r3 = okio.Okio.buffer((okio.Sink) r3)
            long r0 = r0.readAll(r3)     // Catch:{ all -> 0x001e }
            java.lang.Long r4 = new java.lang.Long     // Catch:{ all -> 0x001e }
            r4.<init>(r0)     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x001c
            r3.close()     // Catch:{ all -> 0x001a }
            goto L_0x001c
        L_0x001a:
            r3 = move-exception
            goto L_0x002a
        L_0x001c:
            r3 = 0
            goto L_0x002a
        L_0x001e:
            r4 = move-exception
            if (r3 == 0) goto L_0x0029
            r3.close()     // Catch:{ all -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r3 = move-exception
            kotlin.ExceptionsKt.a(r4, r3)
        L_0x0029:
            r3 = r4
        L_0x002a:
            if (r3 != 0) goto L_0x002f
            kotlin.Unit r3 = kotlin.Unit.f696a
            return r3
        L_0x002f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.network.SourceResponseBody.n(okio.FileSystem, okio.Path):kotlin.Unit");
    }

    public final String toString() {
        return "SourceResponseBody(source=" + this.c + ')';
    }
}
