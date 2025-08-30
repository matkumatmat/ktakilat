package kotlinx.coroutines.debug.internal;

import java.io.Serializable;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.EmptyList;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u001b\u0010\u0012R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010$\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b%\u0010\u0012R\u0017\u0010&\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "source", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "", "c", "Ljava/lang/Long;", "getCoroutineId", "()Ljava/lang/Long;", "coroutineId", "", "d", "Ljava/lang/String;", "getDispatcher", "()Ljava/lang/String;", "dispatcher", "e", "getState", "state", "f", "getLastObservedThreadState", "lastObservedThreadState", "g", "getLastObservedThreadName", "lastObservedThreadName", "", "Ljava/lang/StackTraceElement;", "i", "Ljava/util/List;", "getLastObservedStackTrace", "()Ljava/util/List;", "lastObservedStackTrace", "name", "getName", "sequenceNumber", "J", "getSequenceNumber", "()J", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@PublishedApi
public final class DebuggerInfo implements Serializable {
    public final Long c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final Object i;

    public DebuggerInfo(@NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @NotNull CoroutineContext coroutineContext) {
        long j;
        String str;
        String str2;
        String str3;
        EmptyList emptyList;
        Thread.State state;
        CoroutineStackFrame coroutineStackFrame = null;
        if (((CoroutineId) coroutineContext.get(CoroutineId.c)) != null) {
            j = 0L;
        } else {
            j = null;
        }
        this.c = j;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.b);
        if (continuationInterceptor != null) {
            str = continuationInterceptor.toString();
        } else {
            str = null;
        }
        this.d = str;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.c);
        this.e = debugCoroutineInfoImpl._state;
        Thread thread = debugCoroutineInfoImpl.lastObservedThread;
        if (thread == null || (state = thread.getState()) == null) {
            str2 = null;
        } else {
            str2 = state.toString();
        }
        this.f = str2;
        Thread thread2 = debugCoroutineInfoImpl.lastObservedThread;
        if (thread2 != null) {
            str3 = thread2.getName();
        } else {
            str3 = null;
        }
        this.g = str3;
        WeakReference<CoroutineStackFrame> weakReference = debugCoroutineInfoImpl._lastObservedFrame;
        coroutineStackFrame = weakReference != null ? weakReference.get() : coroutineStackFrame;
        if (coroutineStackFrame == null) {
            emptyList = EmptyList.INSTANCE;
        } else {
            ArrayList arrayList = new ArrayList();
            while (coroutineStackFrame != null) {
                StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
                if (stackTraceElement != null) {
                    arrayList.add(stackTraceElement);
                }
                coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            }
            emptyList = arrayList;
        }
        this.i = emptyList;
    }

    @Nullable
    public final Long getCoroutineId() {
        return this.c;
    }

    @Nullable
    public final String getDispatcher() {
        return this.d;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.Object, java.util.List<java.lang.StackTraceElement>] */
    @NotNull
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.i;
    }

    @Nullable
    public final String getLastObservedThreadName() {
        return this.g;
    }

    @Nullable
    public final String getLastObservedThreadState() {
        return this.f;
    }

    @Nullable
    public final String getName() {
        return null;
    }

    public final long getSequenceNumber() {
        return 0;
    }

    @NotNull
    public final String getState() {
        return this.e;
    }
}
