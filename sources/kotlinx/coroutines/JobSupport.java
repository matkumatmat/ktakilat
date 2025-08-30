package kotlinx.coroutines;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.selects.SelectInstance;

@SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Synchronized.common.kt\nkotlinx/coroutines/internal/Synchronized_commonKt\n+ 4 Synchronized.kt\nkotlinx/coroutines/internal/SynchronizedKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 Concurrent.kt\nkotlinx/coroutines/internal/ConcurrentKt\n+ 7 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 8 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n+ 9 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,1583:1\n732#1,3:1587\n361#1,2:1597\n363#1,5:1602\n368#1,5:1608\n373#1,2:1616\n361#1,2:1618\n363#1,5:1623\n368#1,5:1629\n373#1,2:1637\n169#1,2:1645\n734#1:1647\n536#1:1648\n169#1,2:1649\n537#1,15:1651\n169#1,2:1666\n169#1,2:1668\n169#1,2:1681\n732#1,3:1683\n732#1,3:1686\n169#1,2:1689\n732#1,3:1691\n169#1,2:1694\n169#1,2:1698\n169#1,2:1700\n536#1:1704\n169#1,2:1705\n537#1,15:1707\n1#2:1584\n1#2:1607\n1#2:1628\n27#3:1585\n27#3:1696\n27#3:1702\n16#4:1586\n16#4:1697\n16#4:1703\n295#5,2:1590\n295#5,2:1592\n22#6:1594\n159#7:1595\n159#7:1596\n149#7,4:1722\n275#8,3:1599\n278#8,3:1613\n275#8,3:1620\n278#8,3:1634\n275#8,6:1639\n351#9,11:1670\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport\n*L\n241#1:1587,3\n324#1:1597,2\n324#1:1602,5\n324#1:1608,5\n324#1:1616,2\n357#1:1618,2\n357#1:1623,5\n357#1:1629,5\n357#1:1637,2\n377#1:1645,2\n422#1:1647\n468#1:1648\n468#1:1649,2\n468#1:1651,15\n536#1:1666,2\n579#1:1668,2\n621#1:1681,2\n648#1:1683,3\n657#1:1686,3\n721#1:1689,2\n750#1:1691,3\n763#1:1694,2\n836#1:1698,2\n858#1:1700,2\n1023#1:1704\n1023#1:1705,2\n1023#1:1707,15\n324#1:1607\n357#1:1628\n204#1:1585\n766#1:1696\n911#1:1702\n204#1:1586\n766#1:1697\n911#1:1703\n252#1:1590,2\n256#1:1592,2\n264#1:1594\n270#1:1595\n272#1:1596\n1327#1:1722,4\n324#1:1599,3\n324#1:1613,3\n357#1:1620,3\n357#1:1634,3\n362#1:1639,6\n585#1:1670,11\n*E\n"})
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0005\t\n\u000b\f\rR\u0013\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0004R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00048\u0002X\u0004¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/atomicfu/AtomicRef;", "", "_state", "Lkotlinx/coroutines/ChildHandle;", "_parentHandle", "SelectOnJoinCompletionHandler", "Finishing", "ChildCompletion", "AwaitContinuation", "SelectOnAwaitCompletionHandler", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public class JobSupport implements Job, ChildJob, ParentJob {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c;
    public static final /* synthetic */ AtomicReferenceFieldUpdater d;
    private volatile /* synthetic */ Object _parentHandle$volatile;
    private volatile /* synthetic */ Object _state$volatile;

    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$AwaitContinuation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1583:1\n1#2:1584\n*E\n"})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        public final JobSupport l;

        public AwaitContinuation(Continuation continuation, JobSupport jobSupport) {
            super(1, continuation);
            this.l = jobSupport;
        }

        public final Throwable o(JobSupport jobSupport) {
            Throwable c;
            JobSupport jobSupport2 = this.l;
            jobSupport2.getClass();
            Object obj = JobSupport.c.get(jobSupport2);
            if ((obj instanceof Finishing) && (c = ((Finishing) obj).c()) != null) {
                return c;
            }
            if (obj instanceof CompletedExceptionally) {
                return ((CompletedExceptionally) obj).f764a;
            }
            return jobSupport.g();
        }

        public final String x() {
            return "AwaitContinuation";
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ChildCompletion extends JobNode {
        public final JobSupport g;
        public final Finishing i;
        public final ChildHandleNode j;
        public final Object k;

        public ChildCompletion(JobSupport jobSupport, Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
            this.g = jobSupport;
            this.i = finishing;
            this.j = childHandleNode;
            this.k = obj;
        }

        public final boolean k() {
            return false;
        }

        public final void l(Throwable th) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = JobSupport.c;
            ChildHandleNode childHandleNode = this.j;
            JobSupport jobSupport = this.g;
            jobSupport.getClass();
            ChildHandleNode d0 = JobSupport.d0(childHandleNode);
            Finishing finishing = this.i;
            Object obj = this.k;
            if (d0 == null || !jobSupport.o0(finishing, d0, obj)) {
                finishing.c.d(2);
                ChildHandleNode d02 = JobSupport.d0(childHandleNode);
                if (d02 == null || !jobSupport.o0(finishing, d02, obj)) {
                    jobSupport.G(jobSupport.Q(finishing, obj));
                }
            }
        }
    }

    @SourceDebugExtension({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$Finishing\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1583:1\n1#2:1584\n*E\n"})
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003R\u000b\u0010\u0005\u001a\u00020\u00048\u0002X\u0004R\u0013\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0004R\u0013\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0002X\u0004¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "Lkotlinx/atomicfu/AtomicBoolean;", "_isCompleting", "Lkotlinx/atomicfu/AtomicRef;", "", "_rootCause", "_exceptionsHolder", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Finishing implements Incomplete {
        public static final /* synthetic */ AtomicIntegerFieldUpdater d;
        public static final /* synthetic */ AtomicReferenceFieldUpdater e;
        public static final /* synthetic */ AtomicReferenceFieldUpdater f;
        private volatile /* synthetic */ Object _exceptionsHolder$volatile;
        private volatile /* synthetic */ int _isCompleting$volatile = 0;
        private volatile /* synthetic */ Object _rootCause$volatile;
        public final NodeList c;

        static {
            Class<Finishing> cls = Finishing.class;
            d = AtomicIntegerFieldUpdater.newUpdater(cls, "_isCompleting$volatile");
            Class<Object> cls2 = Object.class;
            e = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_rootCause$volatile");
            f = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_exceptionsHolder$volatile");
        }

        public Finishing(NodeList nodeList, Throwable th) {
            this.c = nodeList;
            this._rootCause$volatile = th;
        }

        public final NodeList a() {
            return this.c;
        }

        public final void b(Throwable th) {
            Throwable c2 = c();
            if (c2 == null) {
                e.set(this, th);
            } else if (th != c2) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj == null) {
                    atomicReferenceFieldUpdater.set(this, th);
                } else if (obj instanceof Throwable) {
                    if (th != obj) {
                        ArrayList arrayList = new ArrayList(4);
                        arrayList.add(obj);
                        arrayList.add(th);
                        atomicReferenceFieldUpdater.set(this, arrayList);
                    }
                } else if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
        }

        public final Throwable c() {
            return (Throwable) e.get(this);
        }

        public final boolean d() {
            if (c() != null) {
                return true;
            }
            return false;
        }

        public final ArrayList e(Throwable th) {
            ArrayList arrayList;
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                arrayList = new ArrayList(4);
            } else if (obj instanceof Throwable) {
                ArrayList arrayList2 = new ArrayList(4);
                arrayList2.add(obj);
                arrayList = arrayList2;
            } else if (obj instanceof ArrayList) {
                arrayList = (ArrayList) obj;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            Throwable c2 = c();
            if (c2 != null) {
                arrayList.add(0, c2);
            }
            if (th != null && !th.equals(c2)) {
                arrayList.add(th);
            }
            atomicReferenceFieldUpdater.set(this, JobSupportKt.e);
            return arrayList;
        }

        public final boolean isActive() {
            if (c() == null) {
                return true;
            }
            return false;
        }

        public final String toString() {
            boolean z;
            StringBuilder sb = new StringBuilder("Finishing[cancelling=");
            sb.append(d());
            sb.append(", completing=");
            if (d.get(this) != 0) {
                z = true;
            } else {
                z = false;
            }
            sb.append(z);
            sb.append(", rootCause=");
            sb.append(c());
            sb.append(", exceptions=");
            sb.append(f.get(this));
            sb.append(", list=");
            sb.append(this.c);
            sb.append(']');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class SelectOnAwaitCompletionHandler extends JobNode {
        public final SelectInstance g;

        public SelectOnAwaitCompletionHandler(SelectInstance selectInstance) {
            this.g = selectInstance;
        }

        public final boolean k() {
            return false;
        }

        public final void l(Throwable th) {
            JobSupport jobSupport = JobSupport.this;
            jobSupport.getClass();
            Object obj = JobSupport.c.get(jobSupport);
            if (!(obj instanceof CompletedExceptionally)) {
                obj = JobSupportKt.a(obj);
            }
            this.g.c(jobSupport, obj);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class SelectOnJoinCompletionHandler extends JobNode {
        public final SelectInstance g;

        public SelectOnJoinCompletionHandler(SelectInstance selectInstance) {
            this.g = selectInstance;
        }

        public final boolean k() {
            return false;
        }

        public final void l(Throwable th) {
            this.g.c(JobSupport.this, Unit.f696a);
        }
    }

    static {
        Class<JobSupport> cls = JobSupport.class;
        Class<Object> cls2 = Object.class;
        c = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_state$volatile");
        d = AtomicReferenceFieldUpdater.newUpdater(cls, cls2, "_parentHandle$volatile");
    }

    public JobSupport(boolean z) {
        Empty empty;
        if (z) {
            empty = JobSupportKt.g;
        } else {
            empty = JobSupportKt.f;
        }
        this._state$volatile = empty;
    }

    public static ChildHandleNode d0(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.h()) {
            LockFreeLinkedListNode e = lockFreeLinkedListNode.e();
            if (e == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = LockFreeLinkedListNode.d;
                Object obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                while (true) {
                    lockFreeLinkedListNode = (LockFreeLinkedListNode) obj;
                    if (!lockFreeLinkedListNode.h()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lockFreeLinkedListNode);
                }
            } else {
                lockFreeLinkedListNode = e;
            }
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.g();
            if (!lockFreeLinkedListNode.h()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    public static String l0(Object obj) {
        if (obj instanceof Finishing) {
            Finishing finishing = (Finishing) obj;
            if (finishing.d()) {
                return "Cancelling";
            }
            if (Finishing.d.get(finishing) != 0) {
                return "Completing";
            }
            return "Active";
        } else if (obj instanceof Incomplete) {
            if (((Incomplete) obj).isActive()) {
                return "Active";
            }
            return "New";
        } else if (obj instanceof CompletedExceptionally) {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        } else {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
    }

    public static CancellationException m0(JobSupport jobSupport, Throwable th) {
        CancellationException cancellationException;
        jobSupport.getClass();
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        } else {
            cancellationException = null;
        }
        if (cancellationException == null) {
            return new JobCancellationException(jobSupport.M(), th, jobSupport);
        }
        return cancellationException;
    }

    public void G(Object obj) {
    }

    public void H(Object obj) {
        G(obj);
    }

    public final Object I(Continuation continuation) {
        Object obj;
        do {
            obj = c.get(this);
            if (!(obj instanceof Incomplete)) {
                if (!(obj instanceof CompletedExceptionally)) {
                    return JobSupportKt.a(obj);
                }
                throw ((CompletedExceptionally) obj).f764a;
            }
        } while (k0(obj) < 0);
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.b(continuation), this);
        awaitContinuation.q();
        CancellableContinuationKt.a(awaitContinuation, JobKt.c(this, true, new ResumeAwaitOnCompletion(awaitContinuation)));
        Object p = awaitContinuation.p();
        if (p == CoroutineSingletons.COROUTINE_SUSPENDED) {
            Intrinsics.checkNotNullParameter(continuation, TypedValues.AttributesType.S_FRAME);
        }
        return p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r0 = kotlinx.coroutines.JobSupportKt.f770a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean J(java.lang.Object r10) {
        /*
            r9 = this;
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.JobSupportKt.f770a
            boolean r1 = r9.T()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0040
        L_0x000a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = c
            java.lang.Object r0 = r0.get(r9)
            boolean r1 = r0 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L_0x0039
            boolean r1 = r0 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r1 == 0) goto L_0x0027
            r1 = r0
            kotlinx.coroutines.JobSupport$Finishing r1 = (kotlinx.coroutines.JobSupport.Finishing) r1
            r1.getClass()
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.JobSupport.Finishing.d
            int r1 = r4.get(r1)
            if (r1 == 0) goto L_0x0027
            goto L_0x0039
        L_0x0027:
            kotlinx.coroutines.CompletedExceptionally r1 = new kotlinx.coroutines.CompletedExceptionally
            java.lang.Throwable r4 = r9.P(r10)
            r1.<init>(r2, r4)
            java.lang.Object r0 = r9.n0(r0, r1)
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.JobSupportKt.c
            if (r0 == r1) goto L_0x000a
            goto L_0x003b
        L_0x0039:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.JobSupportKt.f770a
        L_0x003b:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.JobSupportKt.b
            if (r0 != r1) goto L_0x0040
            return r3
        L_0x0040:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.JobSupportKt.f770a
            if (r0 != r1) goto L_0x0103
            r0 = 0
            r1 = r0
        L_0x0046:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = c
            java.lang.Object r4 = r4.get(r9)
            boolean r5 = r4 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r5 == 0) goto L_0x009f
            monitor-enter(r4)
            r5 = r4
            kotlinx.coroutines.JobSupport$Finishing r5 = (kotlinx.coroutines.JobSupport.Finishing) r5     // Catch:{ all -> 0x007e }
            r5.getClass()     // Catch:{ all -> 0x007e }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = kotlinx.coroutines.JobSupport.Finishing.f     // Catch:{ all -> 0x007e }
            java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x007e }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.JobSupportKt.e     // Catch:{ all -> 0x007e }
            if (r5 != r6) goto L_0x0063
            r5 = 1
            goto L_0x0064
        L_0x0063:
            r5 = 0
        L_0x0064:
            if (r5 == 0) goto L_0x006c
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.JobSupportKt.d     // Catch:{ all -> 0x007e }
            monitor-exit(r4)
        L_0x0069:
            r0 = r10
            goto L_0x0103
        L_0x006c:
            r5 = r4
            kotlinx.coroutines.JobSupport$Finishing r5 = (kotlinx.coroutines.JobSupport.Finishing) r5     // Catch:{ all -> 0x007e }
            boolean r5 = r5.d()     // Catch:{ all -> 0x007e }
            if (r10 != 0) goto L_0x0077
            if (r5 != 0) goto L_0x0086
        L_0x0077:
            if (r1 != 0) goto L_0x0080
            java.lang.Throwable r1 = r9.P(r10)     // Catch:{ all -> 0x007e }
            goto L_0x0080
        L_0x007e:
            r10 = move-exception
            goto L_0x009d
        L_0x0080:
            r10 = r4
            kotlinx.coroutines.JobSupport$Finishing r10 = (kotlinx.coroutines.JobSupport.Finishing) r10     // Catch:{ all -> 0x007e }
            r10.b(r1)     // Catch:{ all -> 0x007e }
        L_0x0086:
            r10 = r4
            kotlinx.coroutines.JobSupport$Finishing r10 = (kotlinx.coroutines.JobSupport.Finishing) r10     // Catch:{ all -> 0x007e }
            java.lang.Throwable r10 = r10.c()     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0090
            r0 = r10
        L_0x0090:
            monitor-exit(r4)
            if (r0 == 0) goto L_0x009a
            kotlinx.coroutines.JobSupport$Finishing r4 = (kotlinx.coroutines.JobSupport.Finishing) r4
            kotlinx.coroutines.NodeList r10 = r4.c
            r9.e0(r10, r0)
        L_0x009a:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.JobSupportKt.f770a
            goto L_0x0069
        L_0x009d:
            monitor-exit(r4)
            throw r10
        L_0x009f:
            boolean r5 = r4 instanceof kotlinx.coroutines.Incomplete
            if (r5 == 0) goto L_0x00ff
            if (r1 != 0) goto L_0x00a9
            java.lang.Throwable r1 = r9.P(r10)
        L_0x00a9:
            r5 = r4
            kotlinx.coroutines.Incomplete r5 = (kotlinx.coroutines.Incomplete) r5
            boolean r6 = r5.isActive()
            if (r6 == 0) goto L_0x00d4
            kotlinx.coroutines.NodeList r6 = r9.U(r5)
            if (r6 != 0) goto L_0x00b9
            goto L_0x0046
        L_0x00b9:
            kotlinx.coroutines.JobSupport$Finishing r7 = new kotlinx.coroutines.JobSupport$Finishing
            r7.<init>(r6, r1)
        L_0x00be:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = c
            boolean r8 = r4.compareAndSet(r9, r5, r7)
            if (r8 == 0) goto L_0x00cc
            r9.e0(r6, r1)
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.JobSupportKt.f770a
            goto L_0x0069
        L_0x00cc:
            java.lang.Object r4 = r4.get(r9)
            if (r4 == r5) goto L_0x00be
            goto L_0x0046
        L_0x00d4:
            kotlinx.coroutines.CompletedExceptionally r5 = new kotlinx.coroutines.CompletedExceptionally
            r5.<init>(r2, r1)
            java.lang.Object r5 = r9.n0(r4, r5)
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.JobSupportKt.f770a
            if (r5 == r6) goto L_0x00e7
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.JobSupportKt.c
            if (r5 == r4) goto L_0x0046
            r0 = r5
            goto L_0x0103
        L_0x00e7:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Cannot happen in "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00ff:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.JobSupportKt.d
            goto L_0x0069
        L_0x0103:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.JobSupportKt.f770a
            if (r0 != r10) goto L_0x0109
        L_0x0107:
            r2 = 1
            goto L_0x0117
        L_0x0109:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.JobSupportKt.b
            if (r0 != r10) goto L_0x010e
            goto L_0x0107
        L_0x010e:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.JobSupportKt.d
            if (r0 != r10) goto L_0x0113
            goto L_0x0117
        L_0x0113:
            r9.G(r0)
            goto L_0x0107
        L_0x0117:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.J(java.lang.Object):boolean");
    }

    public void K(CancellationException cancellationException) {
        J(cancellationException);
    }

    public final boolean L(Throwable th) {
        if (Z()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        ChildHandle childHandle = (ChildHandle) d.get(this);
        if (childHandle == null || childHandle == NonDisposableHandle.c) {
            return z;
        }
        if (childHandle.b(th) || z) {
            return true;
        }
        return false;
    }

    public String M() {
        return "Job was cancelled";
    }

    public boolean N(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        if (!J(th) || !S()) {
            return false;
        }
        return true;
    }

    public final void O(Incomplete incomplete, Object obj) {
        CompletedExceptionally completedExceptionally;
        Throwable th;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        ChildHandle childHandle = (ChildHandle) atomicReferenceFieldUpdater.get(this);
        if (childHandle != null) {
            childHandle.dispose();
            atomicReferenceFieldUpdater.set(this, NonDisposableHandle.c);
        }
        CompletionHandlerException completionHandlerException = null;
        if (obj instanceof CompletedExceptionally) {
            completedExceptionally = (CompletedExceptionally) obj;
        } else {
            completedExceptionally = null;
        }
        if (completedExceptionally != null) {
            th = completedExceptionally.f764a;
        } else {
            th = null;
        }
        if (incomplete instanceof JobNode) {
            try {
                ((JobNode) incomplete).l(th);
            } catch (Throwable th2) {
                W(new CompletionHandlerException("Exception in completion handler " + incomplete + " for " + this, th2));
            }
        } else {
            NodeList a2 = incomplete.a();
            if (a2 != null) {
                a2.d(1);
                Object obj2 = LockFreeLinkedListNode.c.get(a2);
                Intrinsics.d(obj2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj2; !lockFreeLinkedListNode.equals(a2); lockFreeLinkedListNode = lockFreeLinkedListNode.g()) {
                    if (lockFreeLinkedListNode instanceof JobNode) {
                        JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                        try {
                            ((JobNode) lockFreeLinkedListNode).l(th);
                        } catch (Throwable th3) {
                            if (completionHandlerException != null) {
                                ExceptionsKt.a(completionHandlerException, th3);
                            } else {
                                completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNode + " for " + this, th3);
                                Unit unit = Unit.f696a;
                            }
                        }
                    }
                }
                if (completionHandlerException != null) {
                    W(completionHandlerException);
                }
            }
        }
    }

    public final Throwable P(Object obj) {
        boolean z;
        if (obj == null) {
            z = true;
        } else {
            z = obj instanceof Throwable;
        }
        if (z) {
            Throwable th = (Throwable) obj;
            if (th == null) {
                return new JobCancellationException(M(), (Throwable) null, this);
            }
            return th;
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((ParentJob) obj).x();
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094 A[LOOP:1: B:41:0x0094->B:44:0x009f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object Q(kotlinx.coroutines.JobSupport.Finishing r9, java.lang.Object r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.CompletedExceptionally
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r10
            kotlinx.coroutines.CompletedExceptionally r0 = (kotlinx.coroutines.CompletedExceptionally) r0
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 == 0) goto L_0x000e
            java.lang.Throwable r1 = r0.f764a
        L_0x000e:
            monitor-enter(r9)
            boolean r0 = r9.d()     // Catch:{ all -> 0x00a5 }
            java.util.ArrayList r2 = r9.e(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.Throwable r3 = r8.R(r9, r2)     // Catch:{ all -> 0x00a5 }
            r4 = 1
            if (r3 == 0) goto L_0x0054
            int r5 = r2.size()     // Catch:{ all -> 0x00a5 }
            if (r5 > r4) goto L_0x0025
            goto L_0x0054
        L_0x0025:
            int r5 = r2.size()     // Catch:{ all -> 0x00a5 }
            java.util.IdentityHashMap r6 = new java.util.IdentityHashMap     // Catch:{ all -> 0x00a5 }
            r6.<init>(r5)     // Catch:{ all -> 0x00a5 }
            java.util.Set r5 = java.util.Collections.newSetFromMap(r6)     // Catch:{ all -> 0x00a5 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00a5 }
        L_0x0036:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x00a5 }
            if (r6 == 0) goto L_0x0054
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x00a5 }
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00a5 }
            if (r6 == r3) goto L_0x0036
            if (r6 == r3) goto L_0x0036
            boolean r7 = r6 instanceof java.util.concurrent.CancellationException     // Catch:{ all -> 0x00a5 }
            if (r7 != 0) goto L_0x0036
            boolean r7 = r5.add(r6)     // Catch:{ all -> 0x00a5 }
            if (r7 == 0) goto L_0x0036
            kotlin.ExceptionsKt.a(r3, r6)     // Catch:{ all -> 0x00a5 }
            goto L_0x0036
        L_0x0054:
            monitor-exit(r9)
            r2 = 0
            if (r3 != 0) goto L_0x0059
            goto L_0x0061
        L_0x0059:
            if (r3 != r1) goto L_0x005c
            goto L_0x0061
        L_0x005c:
            kotlinx.coroutines.CompletedExceptionally r10 = new kotlinx.coroutines.CompletedExceptionally
            r10.<init>(r2, r3)
        L_0x0061:
            if (r3 == 0) goto L_0x007c
            boolean r1 = r8.L(r3)
            if (r1 != 0) goto L_0x006f
            boolean r1 = r8.V(r3)
            if (r1 == 0) goto L_0x007c
        L_0x006f:
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally"
            kotlin.jvm.internal.Intrinsics.d(r10, r1)
            r1 = r10
            kotlinx.coroutines.CompletedExceptionally r1 = (kotlinx.coroutines.CompletedExceptionally) r1
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r5 = kotlinx.coroutines.CompletedExceptionally.b
            r5.compareAndSet(r1, r2, r4)
        L_0x007c:
            if (r0 != 0) goto L_0x0081
            r8.f0(r3)
        L_0x0081:
            r8.g0(r10)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = c
            boolean r1 = r10 instanceof kotlinx.coroutines.Incomplete
            if (r1 == 0) goto L_0x0093
            kotlinx.coroutines.IncompleteStateBox r1 = new kotlinx.coroutines.IncompleteStateBox
            r2 = r10
            kotlinx.coroutines.Incomplete r2 = (kotlinx.coroutines.Incomplete) r2
            r1.<init>(r2)
            goto L_0x0094
        L_0x0093:
            r1 = r10
        L_0x0094:
            boolean r2 = r0.compareAndSet(r8, r9, r1)
            if (r2 == 0) goto L_0x009b
            goto L_0x00a1
        L_0x009b:
            java.lang.Object r2 = r0.get(r8)
            if (r2 == r9) goto L_0x0094
        L_0x00a1:
            r8.O(r9, r10)
            return r10
        L_0x00a5:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.Q(kotlinx.coroutines.JobSupport$Finishing, java.lang.Object):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Throwable R(kotlinx.coroutines.JobSupport.Finishing r4, java.util.ArrayList r5) {
        /*
            r3 = this;
            boolean r0 = r5.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            boolean r4 = r4.d()
            if (r4 == 0) goto L_0x0017
            kotlinx.coroutines.JobCancellationException r4 = new kotlinx.coroutines.JobCancellationException
            java.lang.String r5 = r3.M()
            r4.<init>(r5, r1, r3)
            return r4
        L_0x0017:
            return r1
        L_0x0018:
            java.util.Iterator r4 = r5.iterator()
        L_0x001c:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r4.next()
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            boolean r2 = r2 instanceof java.util.concurrent.CancellationException
            if (r2 != 0) goto L_0x001c
            goto L_0x002f
        L_0x002e:
            r0 = r1
        L_0x002f:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            if (r0 == 0) goto L_0x0034
            return r0
        L_0x0034:
            r4 = 0
            java.lang.Object r4 = r5.get(r4)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r0 = r4 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r0 == 0) goto L_0x005c
            java.util.Iterator r5 = r5.iterator()
        L_0x0043:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r5.next()
            r2 = r0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            if (r2 == r4) goto L_0x0043
            boolean r2 = r2 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r2 == 0) goto L_0x0043
            r1 = r0
        L_0x0057:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            if (r1 == 0) goto L_0x005c
            return r1
        L_0x005c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.R(kotlinx.coroutines.JobSupport$Finishing, java.util.ArrayList):java.lang.Throwable");
    }

    public boolean S() {
        return true;
    }

    public boolean T() {
        return this instanceof CompletableDeferredImpl;
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [kotlinx.coroutines.NodeList, kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public final NodeList U(Incomplete incomplete) {
        NodeList a2 = incomplete.a();
        if (a2 != null) {
            return a2;
        }
        if (incomplete instanceof Empty) {
            return new LockFreeLinkedListNode();
        }
        if (incomplete instanceof JobNode) {
            j0((JobNode) incomplete);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + incomplete).toString());
    }

    public boolean V(Throwable th) {
        return false;
    }

    public final void X(Job job) {
        NonDisposableHandle nonDisposableHandle = NonDisposableHandle.c;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d;
        if (job == null) {
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
            return;
        }
        job.start();
        ChildHandle j = job.j(this);
        atomicReferenceFieldUpdater.set(this, j);
        if (y()) {
            j.dispose();
            atomicReferenceFieldUpdater.set(this, nonDisposableHandle);
        }
    }

    public final DisposableHandle Y(boolean z, JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        NonDisposableHandle nonDisposableHandle;
        boolean z2;
        Throwable th;
        CompletedExceptionally completedExceptionally;
        boolean z3;
        Finishing finishing;
        Throwable th2;
        jobNode.f = this;
        loop0:
        while (true) {
            atomicReferenceFieldUpdater = c;
            Object obj = atomicReferenceFieldUpdater.get(this);
            boolean z4 = obj instanceof Empty;
            nonDisposableHandle = NonDisposableHandle.c;
            z2 = true;
            th = null;
            if (!z4) {
                if (!(obj instanceof Incomplete)) {
                    z2 = false;
                    break;
                }
                Incomplete incomplete = (Incomplete) obj;
                NodeList a2 = incomplete.a();
                if (a2 == null) {
                    Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    j0((JobNode) obj);
                } else {
                    if (jobNode.k()) {
                        if (incomplete instanceof Finishing) {
                            finishing = (Finishing) incomplete;
                        } else {
                            finishing = null;
                        }
                        if (finishing != null) {
                            th2 = finishing.c();
                        } else {
                            th2 = null;
                        }
                        if (th2 == null) {
                            z3 = a2.c(jobNode, 5);
                        } else {
                            if (z) {
                                jobNode.l(th2);
                            }
                            return nonDisposableHandle;
                        }
                    } else {
                        z3 = a2.c(jobNode, 1);
                    }
                    if (z3) {
                        break;
                    }
                }
            } else {
                Empty empty = (Empty) obj;
                if (empty.c) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, jobNode)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                        }
                    }
                    break loop0;
                }
                i0(empty);
            }
        }
        if (z2) {
            return jobNode;
        }
        if (z) {
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof CompletedExceptionally) {
                completedExceptionally = (CompletedExceptionally) obj2;
            } else {
                completedExceptionally = null;
            }
            if (completedExceptionally != null) {
                th = completedExceptionally.f764a;
            }
            jobNode.l(th);
        }
        return nonDisposableHandle;
    }

    public boolean Z() {
        return this instanceof BlockingCoroutine;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a0(java.lang.Object r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = c
            java.lang.Object r0 = r0.get(r3)
            java.lang.Object r0 = r3.n0(r0, r4)
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.JobSupportKt.f770a
            if (r0 != r1) goto L_0x0010
            r4 = 0
            return r4
        L_0x0010:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.JobSupportKt.b
            r2 = 1
            if (r0 != r1) goto L_0x0016
            return r2
        L_0x0016:
            kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.JobSupportKt.c
            if (r0 == r1) goto L_0x0000
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.a0(java.lang.Object):boolean");
    }

    public final Object b0(Object obj) {
        Object n0;
        CompletedExceptionally completedExceptionally;
        do {
            n0 = n0(c.get(this), obj);
            if (n0 == JobSupportKt.f770a) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                Throwable th = null;
                if (obj instanceof CompletedExceptionally) {
                    completedExceptionally = (CompletedExceptionally) obj;
                } else {
                    completedExceptionally = null;
                }
                if (completedExceptionally != null) {
                    th = completedExceptionally.f764a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (n0 == JobSupportKt.c);
        return n0;
    }

    public void c(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(M(), (Throwable) null, this);
        }
        K(cancellationException);
    }

    public String c0() {
        return getClass().getSimpleName();
    }

    public Object d() {
        Object obj = c.get(this);
        if (obj instanceof Incomplete) {
            throw new IllegalStateException("This job has not completed yet");
        } else if (!(obj instanceof CompletedExceptionally)) {
            return JobSupportKt.a(obj);
        } else {
            throw ((CompletedExceptionally) obj).f764a;
        }
    }

    public final Object e(ContinuationImpl continuationImpl) {
        Object obj;
        do {
            obj = c.get(this);
            if (!(obj instanceof Incomplete)) {
                JobKt.a(continuationImpl.getContext());
                return Unit.f696a;
            }
        } while (k0(obj) < 0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(continuationImpl));
        cancellableContinuationImpl.q();
        CancellableContinuationKt.a(cancellableContinuationImpl, JobKt.c(this, true, new ResumeOnCompletion(cancellableContinuationImpl)));
        Object p = cancellableContinuationImpl.p();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (p == coroutineSingletons) {
            Intrinsics.checkNotNullParameter(continuationImpl, TypedValues.AttributesType.S_FRAME);
        }
        if (p != coroutineSingletons) {
            p = Unit.f696a;
        }
        if (p == coroutineSingletons) {
            return p;
        }
        return Unit.f696a;
    }

    public final void e0(NodeList nodeList, Throwable th) {
        f0(th);
        nodeList.d(4);
        Object obj = LockFreeLinkedListNode.c.get(nodeList);
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        CompletionHandlerException completionHandlerException = null;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) obj; !lockFreeLinkedListNode.equals(nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.g()) {
            if ((lockFreeLinkedListNode instanceof JobNode) && ((JobNode) lockFreeLinkedListNode).k()) {
                try {
                    ((JobNode) lockFreeLinkedListNode).l(th);
                } catch (Throwable th2) {
                    if (completionHandlerException != null) {
                        ExceptionsKt.a(completionHandlerException, th2);
                    } else {
                        completionHandlerException = new CompletionHandlerException("Exception in completion handler " + lockFreeLinkedListNode + " for " + this, th2);
                        Unit unit = Unit.f696a;
                    }
                }
            }
        }
        if (completionHandlerException != null) {
            W(completionHandlerException);
        }
        L(th);
    }

    public final DisposableHandle f(boolean z, boolean z2, Function1 function1) {
        JobNode jobNode;
        if (z) {
            jobNode = new InvokeOnCancelling(function1);
        } else {
            jobNode = new InvokeOnCompletion(function1);
        }
        return Y(z2, jobNode);
    }

    public void f0(Throwable th) {
    }

    public final Object fold(Object obj, Function2 function2) {
        Intrinsics.checkNotNullParameter(function2, "operation");
        return function2.invoke(obj, this);
    }

    public final CancellationException g() {
        Object obj = c.get(this);
        CancellationException cancellationException = null;
        if (obj instanceof Finishing) {
            Throwable c2 = ((Finishing) obj).c();
            if (c2 != null) {
                String concat = getClass().getSimpleName().concat(" is cancelling");
                if (c2 instanceof CancellationException) {
                    cancellationException = (CancellationException) c2;
                }
                if (cancellationException != null) {
                    return cancellationException;
                }
                if (concat == null) {
                    concat = M();
                }
                return new JobCancellationException(concat, c2, this);
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (obj instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (obj instanceof CompletedExceptionally) {
            return m0(this, ((CompletedExceptionally) obj).f764a);
        } else {
            return new JobCancellationException(getClass().getSimpleName().concat(" has completed normally"), (Throwable) null, this);
        }
    }

    public void g0(Object obj) {
    }

    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.a(this, key);
    }

    public final CoroutineContext.Key getKey() {
        return Job.Key.c;
    }

    public void h0() {
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [kotlinx.coroutines.NodeList, kotlinx.coroutines.internal.LockFreeLinkedListNode] */
    public final void i0(Empty empty) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ? lockFreeLinkedListNode = new LockFreeLinkedListNode();
        InactiveNodeList inactiveNodeList = lockFreeLinkedListNode;
        if (!empty.c) {
            inactiveNodeList = new InactiveNodeList(lockFreeLinkedListNode);
        }
        do {
            atomicReferenceFieldUpdater = c;
            if (atomicReferenceFieldUpdater.compareAndSet(this, empty, inactiveNodeList) || atomicReferenceFieldUpdater.get(this) != empty) {
            }
            atomicReferenceFieldUpdater = c;
            return;
        } while (atomicReferenceFieldUpdater.get(this) != empty);
    }

    public boolean isActive() {
        Object obj = c.get(this);
        if (!(obj instanceof Incomplete) || !((Incomplete) obj).isActive()) {
            return false;
        }
        return true;
    }

    public final boolean isCancelled() {
        Object obj = c.get(this);
        if ((obj instanceof CompletedExceptionally) || ((obj instanceof Finishing) && ((Finishing) obj).d())) {
            return true;
        }
        return false;
    }

    public final ChildHandle j(JobSupport jobSupport) {
        CompletedExceptionally completedExceptionally;
        CompletedExceptionally completedExceptionally2;
        ChildHandleNode childHandleNode = new ChildHandleNode(jobSupport);
        childHandleNode.f = this;
        loop0:
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof Empty) {
                Empty empty = (Empty) obj;
                if (empty.c) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, childHandleNode)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                        }
                    }
                    break loop0;
                }
                i0(empty);
            } else {
                boolean z = obj instanceof Incomplete;
                NonDisposableHandle nonDisposableHandle = NonDisposableHandle.c;
                Throwable th = null;
                if (z) {
                    NodeList a2 = ((Incomplete) obj).a();
                    if (a2 == null) {
                        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                        j0((JobNode) obj);
                    } else if (!a2.c(childHandleNode, 7)) {
                        boolean c2 = a2.c(childHandleNode, 3);
                        Object obj2 = atomicReferenceFieldUpdater.get(this);
                        if (obj2 instanceof Finishing) {
                            th = ((Finishing) obj2).c();
                        } else {
                            if (obj2 instanceof CompletedExceptionally) {
                                completedExceptionally2 = (CompletedExceptionally) obj2;
                            } else {
                                completedExceptionally2 = null;
                            }
                            if (completedExceptionally2 != null) {
                                th = completedExceptionally2.f764a;
                            }
                        }
                        childHandleNode.l(th);
                        if (c2) {
                            return childHandleNode;
                        }
                        return nonDisposableHandle;
                    }
                } else {
                    Object obj3 = atomicReferenceFieldUpdater.get(this);
                    if (obj3 instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) obj3;
                    } else {
                        completedExceptionally = null;
                    }
                    if (completedExceptionally != null) {
                        th = completedExceptionally.f764a;
                    }
                    childHandleNode.l(th);
                    return nonDisposableHandle;
                }
            }
        }
        return childHandleNode;
    }

    public final void j0(JobNode jobNode) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        LockFreeLinkedListNode lockFreeLinkedListNode = new LockFreeLinkedListNode();
        jobNode.getClass();
        LockFreeLinkedListNode.d.set(lockFreeLinkedListNode, jobNode);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = LockFreeLinkedListNode.c;
        atomicReferenceFieldUpdater2.set(lockFreeLinkedListNode, jobNode);
        loop0:
        while (true) {
            if (atomicReferenceFieldUpdater2.get(jobNode) != jobNode) {
                break;
            }
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(jobNode, jobNode, lockFreeLinkedListNode)) {
                    lockFreeLinkedListNode.f(jobNode);
                    break loop0;
                } else if (atomicReferenceFieldUpdater2.get(jobNode) != jobNode) {
                }
            }
        }
        LockFreeLinkedListNode g = jobNode.g();
        do {
            atomicReferenceFieldUpdater = c;
            if (atomicReferenceFieldUpdater.compareAndSet(this, jobNode, g) || atomicReferenceFieldUpdater.get(this) != jobNode) {
            }
            atomicReferenceFieldUpdater = c;
            return;
        } while (atomicReferenceFieldUpdater.get(this) != jobNode);
    }

    public final int k0(Object obj) {
        boolean z = obj instanceof Empty;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c;
        if (z) {
            if (((Empty) obj).c) {
                return 0;
            }
            Empty empty = JobSupportKt.g;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, empty)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            h0();
            return 1;
        } else if (!(obj instanceof InactiveNodeList)) {
            return 0;
        } else {
            NodeList nodeList = ((InactiveNodeList) obj).c;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, nodeList)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    return -1;
                }
            }
            h0();
            return 1;
        }
    }

    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00b4, code lost:
        if (r1 == null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00b6, code lost:
        e0(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00b9, code lost:
        r8 = d0(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00bd, code lost:
        if (r8 == null) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00c3, code lost:
        if (o0(r2, r8, r9) == false) goto L_0x00c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00c8, code lost:
        r0.d(2);
        r8 = d0(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00d0, code lost:
        if (r8 == null) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d6, code lost:
        if (o0(r2, r8, r9) == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return Q(r2, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        return kotlinx.coroutines.JobSupportKt.b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:?, code lost:
        return kotlinx.coroutines.JobSupportKt.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object n0(java.lang.Object r8, java.lang.Object r9) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.Incomplete
            if (r0 != 0) goto L_0x0007
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.f770a
            return r8
        L_0x0007:
            boolean r0 = r8 instanceof kotlinx.coroutines.Empty
            r1 = 0
            if (r0 != 0) goto L_0x0010
            boolean r0 = r8 instanceof kotlinx.coroutines.JobNode
            if (r0 == 0) goto L_0x0045
        L_0x0010:
            boolean r0 = r8 instanceof kotlinx.coroutines.ChildHandleNode
            if (r0 != 0) goto L_0x0045
            boolean r0 = r9 instanceof kotlinx.coroutines.CompletedExceptionally
            if (r0 != 0) goto L_0x0045
            r0 = r8
            kotlinx.coroutines.Incomplete r0 = (kotlinx.coroutines.Incomplete) r0
            boolean r8 = r9 instanceof kotlinx.coroutines.Incomplete
            if (r8 == 0) goto L_0x0029
            kotlinx.coroutines.IncompleteStateBox r8 = new kotlinx.coroutines.IncompleteStateBox
            r2 = r9
            kotlinx.coroutines.Incomplete r2 = (kotlinx.coroutines.Incomplete) r2
            r8.<init>(r2)
            r2 = r8
            goto L_0x002a
        L_0x0029:
            r2 = r9
        L_0x002a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = c
            boolean r3 = r8.compareAndSet(r7, r0, r2)
            if (r3 == 0) goto L_0x003c
            r7.f0(r1)
            r7.g0(r9)
            r7.O(r0, r9)
            return r9
        L_0x003c:
            java.lang.Object r8 = r8.get(r7)
            if (r8 == r0) goto L_0x002a
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.c
            return r8
        L_0x0045:
            kotlinx.coroutines.Incomplete r8 = (kotlinx.coroutines.Incomplete) r8
            kotlinx.coroutines.NodeList r0 = r7.U(r8)
            if (r0 != 0) goto L_0x0051
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.c
            goto L_0x00df
        L_0x0051:
            boolean r2 = r8 instanceof kotlinx.coroutines.JobSupport.Finishing
            if (r2 == 0) goto L_0x0059
            r2 = r8
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            goto L_0x005a
        L_0x0059:
            r2 = r1
        L_0x005a:
            if (r2 != 0) goto L_0x0061
            kotlinx.coroutines.JobSupport$Finishing r2 = new kotlinx.coroutines.JobSupport$Finishing
            r2.<init>(r0, r1)
        L_0x0061:
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            monitor-enter(r2)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r4 = kotlinx.coroutines.JobSupport.Finishing.d     // Catch:{ all -> 0x009e }
            int r5 = r4.get(r2)     // Catch:{ all -> 0x009e }
            r6 = 1
            if (r5 == 0) goto L_0x0072
            r5 = 1
            goto L_0x0073
        L_0x0072:
            r5 = 0
        L_0x0073:
            if (r5 == 0) goto L_0x007a
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.f770a     // Catch:{ all -> 0x009e }
            monitor-exit(r2)
            goto L_0x00df
        L_0x007a:
            r4.set(r2, r6)     // Catch:{ all -> 0x009e }
            if (r2 == r8) goto L_0x0092
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = c     // Catch:{ all -> 0x009e }
        L_0x0081:
            boolean r5 = r4.compareAndSet(r7, r8, r2)     // Catch:{ all -> 0x009e }
            if (r5 == 0) goto L_0x0088
            goto L_0x0092
        L_0x0088:
            java.lang.Object r5 = r4.get(r7)     // Catch:{ all -> 0x009e }
            if (r5 == r8) goto L_0x0081
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.c     // Catch:{ all -> 0x009e }
            monitor-exit(r2)
            goto L_0x00df
        L_0x0092:
            boolean r8 = r2.d()     // Catch:{ all -> 0x009e }
            boolean r4 = r9 instanceof kotlinx.coroutines.CompletedExceptionally     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x00a0
            r4 = r9
            kotlinx.coroutines.CompletedExceptionally r4 = (kotlinx.coroutines.CompletedExceptionally) r4     // Catch:{ all -> 0x009e }
            goto L_0x00a1
        L_0x009e:
            r8 = move-exception
            goto L_0x00e0
        L_0x00a0:
            r4 = r1
        L_0x00a1:
            if (r4 == 0) goto L_0x00a8
            java.lang.Throwable r4 = r4.f764a     // Catch:{ all -> 0x009e }
            r2.b(r4)     // Catch:{ all -> 0x009e }
        L_0x00a8:
            java.lang.Throwable r4 = r2.c()     // Catch:{ all -> 0x009e }
            if (r8 != 0) goto L_0x00af
            r1 = r4
        L_0x00af:
            r3.element = r1     // Catch:{ all -> 0x009e }
            kotlin.Unit r8 = kotlin.Unit.f696a     // Catch:{ all -> 0x009e }
            monitor-exit(r2)
            if (r1 == 0) goto L_0x00b9
            r7.e0(r0, r1)
        L_0x00b9:
            kotlinx.coroutines.ChildHandleNode r8 = d0(r0)
            if (r8 == 0) goto L_0x00c8
            boolean r8 = r7.o0(r2, r8, r9)
            if (r8 == 0) goto L_0x00c8
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.b
            goto L_0x00df
        L_0x00c8:
            r8 = 2
            r0.d(r8)
            kotlinx.coroutines.ChildHandleNode r8 = d0(r0)
            if (r8 == 0) goto L_0x00db
            boolean r8 = r7.o0(r2, r8, r9)
            if (r8 == 0) goto L_0x00db
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.JobSupportKt.b
            goto L_0x00df
        L_0x00db:
            java.lang.Object r8 = r7.Q(r2, r9)
        L_0x00df:
            return r8
        L_0x00e0:
            monitor-exit(r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.n0(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    public final boolean o0(Finishing finishing, ChildHandleNode childHandleNode, Object obj) {
        while (JobKt.c(childHandleNode.g, false, new ChildCompletion(this, finishing, childHandleNode, obj)) == NonDisposableHandle.c) {
            childHandleNode = d0(childHandleNode);
            if (childHandleNode == null) {
                return false;
            }
        }
        return true;
    }

    public final DisposableHandle p(Function1 function1) {
        return Y(true, new InvokeOnCompletion(function1));
    }

    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.c(coroutineContext, this);
    }

    public boolean s(Object obj) {
        return a0(obj);
    }

    public final boolean start() {
        int k0;
        do {
            k0 = k0(c.get(this));
            if (k0 == 0) {
                return false;
            }
        } while (k0 != 1);
        return true;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(c0() + '{' + l0(c.get(this)) + '}');
        sb.append('@');
        sb.append(DebugStringsKt.a(this));
        return sb.toString();
    }

    public final CancellationException x() {
        Throwable th;
        Object obj = c.get(this);
        CancellationException cancellationException = null;
        if (obj instanceof Finishing) {
            th = ((Finishing) obj).c();
        } else if (obj instanceof CompletedExceptionally) {
            th = ((CompletedExceptionally) obj).f764a;
        } else if (!(obj instanceof Incomplete)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + obj).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = (CancellationException) th;
        }
        if (cancellationException == null) {
            return new JobCancellationException("Parent job is ".concat(l0(obj)), th, this);
        }
        return cancellationException;
    }

    public final boolean y() {
        return !(c.get(this) instanceof Incomplete);
    }

    public void W(CompletionHandlerException completionHandlerException) {
        throw completionHandlerException;
    }
}
