package io.reactivex.exceptions;

import io.reactivex.annotations.NonNull;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    public final List c;
    public final String d;
    public Throwable e;

    public static final class CompositeExceptionCausalChain extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        public final String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    public static abstract class PrintStreamOrWriter {
        public abstract void a(String str);
    }

    public static final class WrappedPrintStream extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        public final PrintStream f660a;

        public WrappedPrintStream(PrintStream printStream) {
            this.f660a = printStream;
        }

        public final void a(String str) {
            this.f660a.println(str);
        }
    }

    public static final class WrappedPrintWriter extends PrintStreamOrWriter {

        /* renamed from: a  reason: collision with root package name */
        public final PrintWriter f661a;

        public WrappedPrintWriter(PrintWriter printWriter) {
            this.f661a = printWriter;
        }

        public final void a(String str) {
            this.f661a.println(str);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CompositeException(@NonNull Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public static void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append(10);
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append(10);
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    public final void b(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i = 1;
        for (Throwable a2 : this.c) {
            sb.append("  ComposedException ");
            sb.append(i);
            sb.append(" :\n");
            a(sb, a2, "\t");
            i++;
        }
        printStreamOrWriter.a(sb.toString());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|(1:(1:13)(1:(2:14|(1:55)(1:(2:56|17)(1:18)))))(0)|19|(4:22|(2:24|58)(2:27|59)|57|20)|28|29|30|31|(1:52)(2:33|(2:35|53)(3:(2:36|(1:65)(1:(2:64|39)(1:40)))|41|54))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x006f */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0075 A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0016 A[SYNTHETIC] */
    @io.reactivex.annotations.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Throwable getCause() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.Throwable r0 = r8.e     // Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0089
            io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain r0 = new io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain     // Catch:{ all -> 0x0066 }
            r0.<init>()     // Catch:{ all -> 0x0066 }
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0066 }
            r1.<init>()     // Catch:{ all -> 0x0066 }
            java.util.List r2 = r8.c     // Catch:{ all -> 0x0066 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0066 }
            r3 = r0
        L_0x0016:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x0087
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0066 }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x0066 }
            boolean r5 = r1.contains(r4)     // Catch:{ all -> 0x0066 }
            if (r5 == 0) goto L_0x0029
            goto L_0x0016
        L_0x0029:
            r1.add(r4)     // Catch:{ all -> 0x0066 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0066 }
            r5.<init>()     // Catch:{ all -> 0x0066 }
            java.lang.Throwable r6 = r4.getCause()     // Catch:{ all -> 0x0066 }
            if (r6 == 0) goto L_0x0048
            if (r6 != r4) goto L_0x003a
            goto L_0x0048
        L_0x003a:
            r5.add(r6)     // Catch:{ all -> 0x0066 }
            java.lang.Throwable r7 = r6.getCause()     // Catch:{ all -> 0x0066 }
            if (r7 == 0) goto L_0x0048
            if (r7 != r6) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r6 = r7
            goto L_0x003a
        L_0x0048:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0066 }
        L_0x004c:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0066 }
            if (r6 == 0) goto L_0x006c
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0066 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x0066 }
            boolean r7 = r1.contains(r6)     // Catch:{ all -> 0x0066 }
            if (r7 == 0) goto L_0x0068
            java.lang.RuntimeException r4 = new java.lang.RuntimeException     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = "Duplicate found in causal chain so cropping to prevent loop ..."
            r4.<init>(r6)     // Catch:{ all -> 0x0066 }
            goto L_0x004c
        L_0x0066:
            r0 = move-exception
            goto L_0x008d
        L_0x0068:
            r1.add(r6)     // Catch:{ all -> 0x0066 }
            goto L_0x004c
        L_0x006c:
            r3.initCause(r4)     // Catch:{ all -> 0x006f }
        L_0x006f:
            java.lang.Throwable r4 = r3.getCause()     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x0016
            java.lang.Throwable r5 = r8.e     // Catch:{ all -> 0x0066 }
            if (r5 != r4) goto L_0x007a
            goto L_0x0016
        L_0x007a:
            java.lang.Throwable r3 = r4.getCause()     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x0085
            if (r3 != r4) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r4 = r3
            goto L_0x007a
        L_0x0085:
            r3 = r4
            goto L_0x0016
        L_0x0087:
            r8.e = r0     // Catch:{ all -> 0x0066 }
        L_0x0089:
            java.lang.Throwable r0 = r8.e     // Catch:{ all -> 0x0066 }
            monitor-exit(r8)
            return r0
        L_0x008d:
            monitor-exit(r8)     // Catch:{ all -> 0x0066 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.exceptions.CompositeException.getCause():java.lang.Throwable");
    }

    @NonNull
    public List<Throwable> getExceptions() {
        return this.c;
    }

    @NonNull
    public String getMessage() {
        return this.d;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public int size() {
        return this.c.size();
    }

    public void printStackTrace(PrintStream printStream) {
        b(new WrappedPrintStream(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        b(new WrappedPrintWriter(printWriter));
    }

    public CompositeException(@NonNull Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            List unmodifiableList = Collections.unmodifiableList(arrayList);
            this.c = unmodifiableList;
            this.d = unmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
