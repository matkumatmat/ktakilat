package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.location.LocationRequestCompat;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeTaskQueue;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\b\t\nR\u000b\u0010\u0004\u001a\u00020\u00038\u0002X\u0004R\u000b\u0010\u0005\u001a\u00020\u00038\u0002X\u0004R\u000b\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Lkotlinx/atomicfu/AtomicLong;", "parkedWorkersStack", "controlState", "Lkotlinx/atomicfu/AtomicBoolean;", "_isTerminated", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 2 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 5 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 6 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n1#1,1044:1\n286#1:1047\n284#1:1048\n284#1:1049\n286#1:1050\n281#1:1053\n282#1,5:1054\n292#1:1060\n284#1:1061\n285#1:1062\n284#1:1065\n285#1:1066\n281#1:1067\n289#1:1068\n284#1:1069\n284#1:1072\n285#1:1073\n286#1:1074\n77#2:1045\n77#2:1059\n77#2:1070\n1#3:1046\n27#4:1051\n27#4:1063\n16#5:1052\n16#5:1064\n622#6:1071\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n*L\n282#1:1047\n289#1:1048\n290#1:1049\n299#1:1050\n348#1:1053\n377#1:1054,5\n400#1:1060\n447#1:1061\n448#1:1062\n484#1:1065\n485#1:1066\n491#1:1067\n500#1:1068\n500#1:1069\n581#1:1072\n582#1:1073\n583#1:1074\n120#1:1045\n397#1:1059\n517#1:1070\n348#1:1051\n480#1:1063\n348#1:1052\n480#1:1064\n524#1:1071\n*E\n"})
public final class CoroutineScheduler implements Executor, Closeable {
    public static final /* synthetic */ AtomicLongFieldUpdater k;
    public static final /* synthetic */ AtomicLongFieldUpdater l;
    public static final /* synthetic */ AtomicIntegerFieldUpdater m;
    public static final Symbol n = new Symbol("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;
    public final int c;
    private volatile /* synthetic */ long controlState$volatile;
    public final int d;
    public final long e;
    public final String f;
    public final GlobalQueue g;
    public final GlobalQueue i;
    public final ResizableAtomicArray j;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00058\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00058\u0000XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u00058\u0000XT¢\u0006\u0006\n\u0004\b\u0012\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", "", "Lkotlinx/coroutines/internal/Symbol;", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "", "PARKED", "I", "CLAIMED", "TERMINATED", "BLOCKING_SHIFT", "", "CREATED_MASK", "J", "BLOCKING_MASK", "CPU_PERMITS_SHIFT", "CPU_PERMITS_MASK", "MIN_SUPPORTED_POOL_SIZE", "MAX_SUPPORTED_POOL_SIZE", "PARKED_INDEX_MASK", "PARKED_VERSION_MASK", "PARKED_VERSION_INC", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f811a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.PARKING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.BLOCKING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.CPU_ACQUIRED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.DORMANT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                f811a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.WhenMappings.<clinit>():void");
        }
    }

    @SourceDebugExtension({"SMAP\nCoroutineScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n+ 2 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Tasks.kt\nkotlinx/coroutines/scheduling/TasksKt\n+ 5 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 6 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n*L\n1#1,1044:1\n298#2,2:1045\n286#2:1047\n300#2,4:1048\n305#2:1052\n295#2,2:1053\n295#2,2:1058\n281#2:1062\n290#2:1063\n284#2:1064\n281#2:1065\n1#3:1055\n77#4:1056\n77#4:1057\n27#5:1060\n16#6:1061\n*S KotlinDebug\n*F\n+ 1 CoroutineScheduler.kt\nkotlinx/coroutines/scheduling/CoroutineScheduler$Worker\n*L\n687#1:1045,2\n687#1:1047\n687#1:1048,4\n702#1:1052\n776#1:1053,2\n824#1:1058,2\n875#1:1062\n901#1:1063\n901#1:1064\n974#1:1065\n815#1:1056\n818#1:1057\n871#1:1060\n871#1:1061\n*E\n"})
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001R*\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\b\u0010\u0012\u001a\u00020\u00118\u0006¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "Ljava/lang/Thread;", "", "index", "indexInArray", "I", "b", "()I", "f", "(I)V", "", "nextParkedWorker", "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", "g", "(Ljava/lang/Object;)V", "Lkotlinx/atomicfu/AtomicInt;", "workerCtl", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class Worker extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater l = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");
        public final WorkQueue c = new WorkQueue();
        public final Ref.ObjectRef d = new Ref.ObjectRef();
        public WorkerState e = WorkerState.DORMANT;
        public long f;
        public long g;
        public int i;
        private volatile int indexInArray;
        public boolean j;
        @Nullable
        private volatile Object nextParkedWorker = CoroutineScheduler.n;
        private volatile /* synthetic */ int workerCtl$volatile;

        public Worker(int i2) {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            int nanoTime = (int) System.nanoTime();
            this.i = nanoTime == 0 ? 42 : nanoTime;
            f(i2);
        }

        public final Task a(boolean z) {
            Task e2;
            Task e3;
            CoroutineScheduler coroutineScheduler;
            long j2;
            WorkerState workerState = this.e;
            WorkerState workerState2 = WorkerState.CPU_ACQUIRED;
            Task task = null;
            WorkQueue workQueue = this.c;
            boolean z2 = true;
            CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
            if (workerState != workerState2) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.l;
                do {
                    coroutineScheduler = CoroutineScheduler.this;
                    j2 = atomicLongFieldUpdater.get(coroutineScheduler);
                    if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                        workQueue.getClass();
                        loop1:
                        while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.b;
                            Task task2 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            if (task2 != null && task2.d) {
                                while (true) {
                                    if (atomicReferenceFieldUpdater.compareAndSet(workQueue, task2, (Object) null)) {
                                        task = task2;
                                        break loop1;
                                    } else if (atomicReferenceFieldUpdater.get(workQueue) != task2) {
                                    }
                                }
                            }
                        }
                        int i2 = WorkQueue.d.get(workQueue);
                        int i3 = WorkQueue.c.get(workQueue);
                        while (true) {
                            if (i2 != i3 && WorkQueue.e.get(workQueue) != 0) {
                                i3--;
                                Task c2 = workQueue.c(i3, true);
                                if (c2 != null) {
                                    task = c2;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (task != null) {
                            return task;
                        }
                        Task task3 = (Task) coroutineScheduler2.i.d();
                        if (task3 == null) {
                            return i(1);
                        }
                        return task3;
                    }
                } while (!CoroutineScheduler.l.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L));
                this.e = WorkerState.CPU_ACQUIRED;
            }
            if (z) {
                if (d(coroutineScheduler2.c * 2) != 0) {
                    z2 = false;
                }
                if (z2 && (e3 = e()) != null) {
                    return e3;
                }
                workQueue.getClass();
                Task task4 = (Task) WorkQueue.b.getAndSet(workQueue, (Object) null);
                if (task4 == null) {
                    task4 = workQueue.b();
                }
                if (task4 != null) {
                    return task4;
                }
                if (!z2 && (e2 = e()) != null) {
                    return e2;
                }
            } else {
                Task e4 = e();
                if (e4 != null) {
                    return e4;
                }
            }
            return i(3);
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int i2) {
            int i3 = this.i;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.i = i6;
            int i7 = i2 - 1;
            if ((i7 & i2) == 0) {
                return i6 & i7;
            }
            return (i6 & Integer.MAX_VALUE) % i2;
        }

        public final Task e() {
            int d2 = d(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (d2 == 0) {
                Task task = (Task) coroutineScheduler.g.d();
                if (task != null) {
                    return task;
                }
                return (Task) coroutineScheduler.i.d();
            }
            Task task2 = (Task) coroutineScheduler.i.d();
            if (task2 != null) {
                return task2;
            }
            return (Task) coroutineScheduler.g.d();
        }

        public final void f(int i2) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f);
            sb.append("-worker-");
            if (i2 == 0) {
                str = "TERMINATED";
            } else {
                str = String.valueOf(i2);
            }
            sb.append(str);
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void g(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean h(WorkerState workerState) {
            boolean z;
            WorkerState workerState2 = this.e;
            if (workerState2 == WorkerState.CPU_ACQUIRED) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                CoroutineScheduler.l.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.e = workerState;
            }
            return z;
        }

        public final Task i(int i2) {
            T t;
            long j2;
            long j3;
            int i3;
            boolean z;
            int i4 = i2;
            AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.l;
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            int i5 = (int) (atomicLongFieldUpdater.get(coroutineScheduler) & 2097151);
            if (i5 < 2) {
                return null;
            }
            int d2 = d(i5);
            long j4 = LocationRequestCompat.PASSIVE_INTERVAL;
            for (int i6 = 0; i6 < i5; i6++) {
                d2++;
                if (d2 > i5) {
                    d2 = 1;
                }
                Worker worker = (Worker) coroutineScheduler.j.b(d2);
                if (!(worker == null || worker == this)) {
                    WorkQueue workQueue = worker.c;
                    if (i4 == 3) {
                        t = workQueue.b();
                    } else {
                        workQueue.getClass();
                        int i7 = WorkQueue.d.get(workQueue);
                        int i8 = WorkQueue.c.get(workQueue);
                        if (i4 == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        while (true) {
                            if (i7 != i8 && (!z || WorkQueue.e.get(workQueue) != 0)) {
                                int i9 = i7 + 1;
                                t = workQueue.c(i7, z);
                                if (t != null) {
                                    break;
                                }
                                i7 = i9;
                            } else {
                                t = null;
                            }
                        }
                        t = null;
                    }
                    Ref.ObjectRef objectRef = this.d;
                    if (t != null) {
                        objectRef.element = t;
                        j3 = -1;
                    } else {
                        while (true) {
                            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = WorkQueue.b;
                            T t2 = (Task) atomicReferenceFieldUpdater.get(workQueue);
                            j2 = -2;
                            if (t2 == null) {
                                break;
                            }
                            if (t2.d) {
                                i3 = 1;
                            } else {
                                i3 = 2;
                            }
                            if ((i3 & i4) == 0) {
                                break;
                            }
                            TasksKt.f.getClass();
                            long nanoTime = System.nanoTime() - t2.c;
                            long j5 = TasksKt.b;
                            if (nanoTime < j5) {
                                j2 = j5 - nanoTime;
                                break;
                            }
                            while (true) {
                                if (atomicReferenceFieldUpdater.compareAndSet(workQueue, t2, (Object) null)) {
                                    objectRef.element = t2;
                                    j2 = -1;
                                    break;
                                } else if (atomicReferenceFieldUpdater.get(workQueue) != t2) {
                                }
                            }
                        }
                        j3 = j2;
                    }
                    if (j3 == -1) {
                        Task task = (Task) objectRef.element;
                        objectRef.element = null;
                        return task;
                    } else if (j3 > 0) {
                        j4 = Math.min(j4, j3);
                    }
                }
            }
            if (j4 == LocationRequestCompat.PASSIVE_INTERVAL) {
                j4 = 0;
            }
            this.g = j4;
            return null;
        }

        public final void run() {
            WorkerState workerState;
            boolean z;
            WorkerState workerState2;
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
            boolean z2;
            boolean z3 = false;
            loop0:
            while (true) {
                boolean z4 = false;
                while (true) {
                    CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                    coroutineScheduler.getClass();
                    if (CoroutineScheduler.m.get(coroutineScheduler) == 0 && this.e != (workerState = WorkerState.TERMINATED)) {
                        Task a2 = a(this.j);
                        long j2 = -2097152;
                        if (a2 != null) {
                            this.g = 0;
                            this.f = 0;
                            if (this.e == WorkerState.PARKING) {
                                this.e = WorkerState.BLOCKING;
                            }
                            boolean z5 = a2.d;
                            CoroutineScheduler coroutineScheduler2 = CoroutineScheduler.this;
                            if (z5) {
                                if (h(WorkerState.BLOCKING) && !coroutineScheduler2.h() && !coroutineScheduler2.g(CoroutineScheduler.l.get(coroutineScheduler2))) {
                                    coroutineScheduler2.h();
                                }
                                coroutineScheduler2.getClass();
                                try {
                                    a2.run();
                                } catch (Throwable th) {
                                    Throwable th2 = th;
                                    Thread currentThread = Thread.currentThread();
                                    currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
                                }
                                CoroutineScheduler.l.addAndGet(coroutineScheduler2, -2097152);
                                if (this.e != workerState) {
                                    this.e = WorkerState.DORMANT;
                                }
                            } else {
                                coroutineScheduler2.getClass();
                                try {
                                    a2.run();
                                } catch (Throwable th3) {
                                    Throwable th4 = th3;
                                    Thread currentThread2 = Thread.currentThread();
                                    currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th4);
                                }
                            }
                        } else {
                            this.j = z3;
                            if (this.g != 0) {
                                if (z4) {
                                    h(WorkerState.PARKING);
                                    Thread.interrupted();
                                    LockSupport.parkNanos(this.g);
                                    this.g = 0;
                                    break;
                                }
                                z4 = true;
                            } else {
                                Object obj = this.nextParkedWorker;
                                Symbol symbol = CoroutineScheduler.n;
                                if (obj != symbol) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    l.set(this, -1);
                                    while (this.nextParkedWorker != CoroutineScheduler.n) {
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = l;
                                        if (atomicIntegerFieldUpdater2.get(this) != -1) {
                                            break;
                                        }
                                        CoroutineScheduler coroutineScheduler3 = CoroutineScheduler.this;
                                        coroutineScheduler3.getClass();
                                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater3 = CoroutineScheduler.m;
                                        if (atomicIntegerFieldUpdater3.get(coroutineScheduler3) != 0 || this.e == (workerState2 = WorkerState.TERMINATED)) {
                                            break;
                                        }
                                        h(WorkerState.PARKING);
                                        Thread.interrupted();
                                        if (this.f == 0) {
                                            atomicIntegerFieldUpdater = atomicIntegerFieldUpdater2;
                                            this.f = System.nanoTime() + CoroutineScheduler.this.e;
                                        } else {
                                            atomicIntegerFieldUpdater = atomicIntegerFieldUpdater2;
                                        }
                                        LockSupport.parkNanos(CoroutineScheduler.this.e);
                                        if (System.nanoTime() - this.f >= 0) {
                                            this.f = 0;
                                            CoroutineScheduler coroutineScheduler4 = CoroutineScheduler.this;
                                            synchronized (coroutineScheduler4.j) {
                                                try {
                                                    if (atomicIntegerFieldUpdater3.get(coroutineScheduler4) != 0) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = false;
                                                    }
                                                    if (!z2) {
                                                        AtomicLongFieldUpdater atomicLongFieldUpdater = CoroutineScheduler.l;
                                                        if (((int) (atomicLongFieldUpdater.get(coroutineScheduler4) & 2097151)) > coroutineScheduler4.c) {
                                                            if (atomicIntegerFieldUpdater.compareAndSet(this, -1, 1)) {
                                                                int i2 = this.indexInArray;
                                                                f(0);
                                                                coroutineScheduler4.f(this, i2, 0);
                                                                int andDecrement = (int) (atomicLongFieldUpdater.getAndDecrement(coroutineScheduler4) & 2097151);
                                                                if (andDecrement != i2) {
                                                                    Object b = coroutineScheduler4.j.b(andDecrement);
                                                                    Intrinsics.c(b);
                                                                    Worker worker = (Worker) b;
                                                                    coroutineScheduler4.j.c(i2, worker);
                                                                    worker.f(i2);
                                                                    coroutineScheduler4.f(worker, andDecrement, i2);
                                                                }
                                                                coroutineScheduler4.j.c(andDecrement, (Worker) null);
                                                                Unit unit = Unit.f696a;
                                                                this.e = workerState2;
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th5) {
                                                    throw th5;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    CoroutineScheduler coroutineScheduler5 = CoroutineScheduler.this;
                                    coroutineScheduler5.getClass();
                                    if (this.nextParkedWorker == symbol) {
                                        while (true) {
                                            AtomicLongFieldUpdater atomicLongFieldUpdater2 = CoroutineScheduler.k;
                                            long j3 = atomicLongFieldUpdater2.get(coroutineScheduler5);
                                            int i3 = this.indexInArray;
                                            this.nextParkedWorker = coroutineScheduler5.j.b((int) (j3 & 2097151));
                                            if (atomicLongFieldUpdater2.compareAndSet(coroutineScheduler5, j3, ((PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j3) & j2) | ((long) i3))) {
                                                break;
                                            }
                                            j2 = -2097152;
                                        }
                                    }
                                }
                                z3 = false;
                            }
                        }
                    }
                }
            }
            h(WorkerState.TERMINATED);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public enum WorkerState {
        ;

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[]} */
        /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARNING: type inference failed for: r6v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARNING: type inference failed for: r7v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARNING: type inference failed for: r8v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARNING: type inference failed for: r9v1, types: [java.lang.Enum, kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState] */
        /* JADX WARNING: Multi-variable type inference failed */
        static {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                r4 = 0
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r5 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState
                java.lang.String r6 = "CPU_ACQUIRED"
                r5.<init>(r6, r4)
                CPU_ACQUIRED = r5
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r6 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState
                java.lang.String r7 = "BLOCKING"
                r6.<init>(r7, r3)
                BLOCKING = r6
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r7 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState
                java.lang.String r8 = "PARKING"
                r7.<init>(r8, r2)
                PARKING = r7
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r8 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState
                java.lang.String r9 = "DORMANT"
                r8.<init>(r9, r1)
                DORMANT = r8
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r9 = new kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState
                java.lang.String r10 = "TERMINATED"
                r9.<init>(r10, r0)
                TERMINATED = r9
                r10 = 5
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState[] r10 = new kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState[r10]
                r10[r4] = r5
                r10[r3] = r6
                r10[r2] = r7
                r10[r1] = r8
                r10[r0] = r9
                c = r10
                kotlin.enums.EnumEntries r0 = kotlin.enums.EnumEntriesKt.a(r10)
                d = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.<clinit>():void");
        }

        @NotNull
        public static EnumEntries<WorkerState> getEntries() {
            return d;
        }
    }

    static {
        Class<CoroutineScheduler> cls = CoroutineScheduler.class;
        k = AtomicLongFieldUpdater.newUpdater(cls, "parkedWorkersStack$volatile");
        l = AtomicLongFieldUpdater.newUpdater(cls, "controlState$volatile");
        m = AtomicIntegerFieldUpdater.newUpdater(cls, "_isTerminated$volatile");
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [kotlinx.coroutines.scheduling.GlobalQueue, kotlinx.coroutines.internal.LockFreeTaskQueue] */
    /* JADX WARNING: type inference failed for: r3v14, types: [kotlinx.coroutines.scheduling.GlobalQueue, kotlinx.coroutines.internal.LockFreeTaskQueue] */
    public CoroutineScheduler(long j2, String str, int i2, int i3) {
        this.c = i2;
        this.d = i3;
        this.e = j2;
        this.f = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(ba.l(i2, "Core pool size ", " should be at least 1").toString());
        } else if (i3 < i2) {
            throw new IllegalArgumentException(e.h(i3, "Max pool size ", " should be greater than or equals to core pool size ", i2).toString());
        } else if (i3 > 2097150) {
            throw new IllegalArgumentException(ba.l(i3, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        } else if (j2 > 0) {
            this.g = new LockFreeTaskQueue();
            this.i = new LockFreeTaskQueue();
            this.j = new ResizableAtomicArray((i2 + 1) * 2);
            this.controlState$volatile = ((long) i2) << 42;
            this._isTerminated$volatile = 0;
        } else {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
    }

    public static /* synthetic */ void e(CoroutineScheduler coroutineScheduler, Runnable runnable, boolean z, int i2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.d(runnable, false, z);
    }

    public final int c() {
        boolean z;
        synchronized (this.j) {
            try {
                if (m.get(this) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = l;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.c) {
                    return 0;
                }
                if (i2 >= this.d) {
                    return 0;
                }
                int i4 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i4 <= 0 || this.j.b(i4) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(i4);
                this.j.c(i4, worker);
                if (i4 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    int i5 = i3 + 1;
                    worker.start();
                    return i5;
                }
                throw new IllegalArgumentException("Failed requirement.");
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0089, code lost:
        if (r1 == null) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = m
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof kotlinx.coroutines.scheduling.CoroutineScheduler.Worker
            r3 = 0
            if (r1 == 0) goto L_0x0018
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r0 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r0
            goto L_0x0019
        L_0x0018:
            r0 = r3
        L_0x0019:
            if (r0 == 0) goto L_0x0024
            kotlinx.coroutines.scheduling.CoroutineScheduler r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
            boolean r1 = kotlin.jvm.internal.Intrinsics.a(r1, r8)
            if (r1 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r0 = r3
        L_0x0025:
            kotlinx.coroutines.internal.ResizableAtomicArray r1 = r8.j
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = l     // Catch:{ all -> 0x00c4 }
            long r4 = r4.get(r8)     // Catch:{ all -> 0x00c4 }
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r1)
            if (r2 > r5) goto L_0x0079
            r1 = 1
        L_0x0037:
            kotlinx.coroutines.internal.ResizableAtomicArray r4 = r8.j
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.Intrinsics.c(r4)
            kotlinx.coroutines.scheduling.CoroutineScheduler$Worker r4 = (kotlinx.coroutines.scheduling.CoroutineScheduler.Worker) r4
            if (r4 == r0) goto L_0x0074
        L_0x0044:
            java.lang.Thread$State r6 = r4.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L_0x0055
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r6 = 10000(0x2710, double:4.9407E-320)
            r4.join(r6)
            goto L_0x0044
        L_0x0055:
            kotlinx.coroutines.scheduling.WorkQueue r4 = r4.c
            kotlinx.coroutines.scheduling.GlobalQueue r6 = r8.i
            r4.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = kotlinx.coroutines.scheduling.WorkQueue.b
            java.lang.Object r7 = r7.getAndSet(r4, r3)
            kotlinx.coroutines.scheduling.Task r7 = (kotlinx.coroutines.scheduling.Task) r7
            if (r7 == 0) goto L_0x0069
            r6.a(r7)
        L_0x0069:
            kotlinx.coroutines.scheduling.Task r7 = r4.b()
            if (r7 != 0) goto L_0x0070
            goto L_0x0074
        L_0x0070:
            r6.a(r7)
            goto L_0x0069
        L_0x0074:
            if (r1 == r5) goto L_0x0079
            int r1 = r1 + 1
            goto L_0x0037
        L_0x0079:
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r8.i
            r1.b()
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r8.g
            r1.b()
        L_0x0083:
            if (r0 == 0) goto L_0x008b
            kotlinx.coroutines.scheduling.Task r1 = r0.a(r2)
            if (r1 != 0) goto L_0x00b3
        L_0x008b:
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r8.g
            java.lang.Object r1 = r1.d()
            kotlinx.coroutines.scheduling.Task r1 = (kotlinx.coroutines.scheduling.Task) r1
            if (r1 != 0) goto L_0x00b3
            kotlinx.coroutines.scheduling.GlobalQueue r1 = r8.i
            java.lang.Object r1 = r1.d()
            kotlinx.coroutines.scheduling.Task r1 = (kotlinx.coroutines.scheduling.Task) r1
            if (r1 != 0) goto L_0x00b3
            if (r0 == 0) goto L_0x00a6
            kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.TERMINATED
            r0.h(r1)
        L_0x00a6:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = k
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = l
            r0.set(r8, r1)
        L_0x00b2:
            return
        L_0x00b3:
            r1.run()     // Catch:{ all -> 0x00b7 }
            goto L_0x0083
        L_0x00b7:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L_0x0083
        L_0x00c4:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.close():void");
    }

    public final void d(Runnable runnable, boolean z, boolean z2) {
        Task task;
        long j2;
        Worker worker;
        boolean z3;
        WorkerState workerState;
        TasksKt.f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof Task) {
            task = (Task) runnable;
            task.c = nanoTime;
            task.d = z;
        } else {
            task = new TaskImpl(runnable, nanoTime, z);
        }
        boolean z4 = task.d;
        AtomicLongFieldUpdater atomicLongFieldUpdater = l;
        if (z4) {
            j2 = atomicLongFieldUpdater.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        } else {
            j2 = 0;
        }
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof Worker) {
            worker = (Worker) currentThread;
        } else {
            worker = null;
        }
        if (worker == null || !Intrinsics.a(CoroutineScheduler.this, this)) {
            worker = null;
        }
        boolean z5 = true;
        if (!(worker == null || (workerState = worker.e) == WorkerState.TERMINATED || (!task.d && workerState == WorkerState.BLOCKING))) {
            worker.j = true;
            WorkQueue workQueue = worker.c;
            if (z2) {
                task = workQueue.a(task);
            } else {
                workQueue.getClass();
                Task task2 = (Task) WorkQueue.b.getAndSet(workQueue, task);
                if (task2 == null) {
                    task = null;
                } else {
                    task = workQueue.a(task2);
                }
            }
        }
        if (task != null) {
            if (task.d) {
                z3 = this.i.a(task);
            } else {
                z3 = this.g.a(task);
            }
            if (!z3) {
                throw new RejectedExecutionException(ba.r(new StringBuilder(), this.f, " was terminated"));
            }
        }
        if (!z2 || worker == null) {
            z5 = false;
        }
        if (z4) {
            if (!z5 && !h() && !g(j2)) {
                h();
            }
        } else if (!z5 && !h() && !g(atomicLongFieldUpdater.get(this))) {
            h();
        }
    }

    public final void execute(Runnable runnable) {
        e(this, runnable, false, 6);
    }

    public final void f(Worker worker, int i2, int i3) {
        while (true) {
            long j2 = k.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
            if (i4 == i2) {
                if (i3 == 0) {
                    Object c2 = worker.c();
                    while (true) {
                        if (c2 == n) {
                            i4 = -1;
                            break;
                        } else if (c2 == null) {
                            i4 = 0;
                            break;
                        } else {
                            Worker worker2 = (Worker) c2;
                            i4 = worker2.b();
                            if (i4 != 0) {
                                break;
                            }
                            c2 = worker2.c();
                        }
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (k.compareAndSet(this, j2, j3 | ((long) i4))) {
                    return;
                }
            }
        }
    }

    public final boolean g(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.c;
        if (i2 < i3) {
            int c2 = c();
            if (c2 == 1 && i3 > 1) {
                c();
            }
            if (c2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        Symbol symbol;
        int i2;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = k;
            long j2 = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.j.b((int) (2097151 & j2));
            if (worker == null) {
                worker = null;
            } else {
                long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & -2097152;
                Object c2 = worker.c();
                while (true) {
                    symbol = n;
                    if (c2 == symbol) {
                        i2 = -1;
                        break;
                    } else if (c2 == null) {
                        i2 = 0;
                        break;
                    } else {
                        Worker worker2 = (Worker) c2;
                        i2 = worker2.b();
                        if (i2 != 0) {
                            break;
                        }
                        c2 = worker2.c();
                    }
                }
                if (i2 >= 0) {
                    if (atomicLongFieldUpdater.compareAndSet(this, j2, j3 | ((long) i2))) {
                        worker.g(symbol);
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.l.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }

    public final String toString() {
        int i2;
        ArrayList arrayList = new ArrayList();
        ResizableAtomicArray resizableAtomicArray = this.j;
        int a2 = resizableAtomicArray.a();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 1; i8 < a2; i8++) {
            Worker worker = (Worker) resizableAtomicArray.b(i8);
            if (worker != null) {
                WorkQueue workQueue = worker.c;
                workQueue.getClass();
                if (WorkQueue.b.get(workQueue) != null) {
                    i2 = (WorkQueue.c.get(workQueue) - WorkQueue.d.get(workQueue)) + 1;
                } else {
                    i2 = WorkQueue.c.get(workQueue) - WorkQueue.d.get(workQueue);
                }
                int i9 = WhenMappings.f811a[worker.e.ordinal()];
                if (i9 == 1) {
                    i5++;
                } else if (i9 == 2) {
                    i4++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i2);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i9 == 3) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i9 == 4) {
                    i6++;
                    if (i2 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i2);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i9 == 5) {
                    i7++;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        long j2 = l.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f);
        sb4.append('@');
        sb4.append(DebugStringsKt.a(this));
        sb4.append("[Pool Size {core = ");
        int i10 = this.c;
        sb4.append(i10);
        sb4.append(", max = ");
        sb4.append(this.d);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i3);
        sb4.append(", blocking = ");
        sb4.append(i4);
        sb4.append(", parked = ");
        sb4.append(i5);
        sb4.append(", dormant = ");
        sb4.append(i6);
        sb4.append(", terminated = ");
        sb4.append(i7);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.g.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.i.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j2));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j2) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i10 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
