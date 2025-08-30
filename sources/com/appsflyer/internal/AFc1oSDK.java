package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lcom/appsflyer/internal/AFc1oSDK;", "Ljava/util/concurrent/ThreadPoolExecutor;", "", "p0", "p1", "", "p2", "Ljava/util/concurrent/TimeUnit;", "p3", "Ljava/util/concurrent/BlockingQueue;", "Ljava/lang/Runnable;", "p4", "Ljava/util/Queue;", "p5", "<init>", "(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;Ljava/util/Queue;)V", "", "", "afterExecute", "(Ljava/lang/Runnable;Ljava/lang/Throwable;)V", "AFAdRevenueData", "Ljava/util/Queue;", "getCurrencyIso4217Code"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AFc1oSDK extends ThreadPoolExecutor {
    @NotNull
    private final Queue<Runnable> AFAdRevenueData;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFc1oSDK(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, Queue queue, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j, timeUnit, blockingQueue, (i3 & 32) != 0 ? new LinkedList() : queue);
    }

    /* access modifiers changed from: private */
    public static final void getCurrencyIso4217Code(Queue queue, Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Intrinsics.checkNotNullParameter(queue, "");
        Intrinsics.checkNotNullParameter(runnable, "");
        Intrinsics.checkNotNullParameter(threadPoolExecutor, "");
        queue.add(runnable);
    }

    public final void afterExecute(@NotNull Runnable runnable, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(runnable, "");
        super.afterExecute(runnable, th);
        Intrinsics.checkNotNullParameter(runnable, "");
        if (th == null) {
            synchronized (this) {
                try {
                    int size = this.AFAdRevenueData.size();
                    for (int i = 0; i < size; i++) {
                        Runnable poll = this.AFAdRevenueData.poll();
                        if (poll != null) {
                            execute(poll);
                        }
                    }
                    Unit unit = Unit.f696a;
                } finally {
                }
            }
            return;
        }
        AFLogger aFLogger = AFLogger.INSTANCE;
        AFg1cSDK aFg1cSDK = AFg1cSDK.AF_EXECUTOR;
        AFg1gSDK.e$default(aFLogger, aFg1cSDK, "Error while executing task: " + runnable, th, true, true, true, false, 64, (Object) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AFc1oSDK(int r11, int r12, long r13, @org.jetbrains.annotations.NotNull java.util.concurrent.TimeUnit r15, @org.jetbrains.annotations.NotNull java.util.concurrent.BlockingQueue<java.lang.Runnable> r16, @org.jetbrains.annotations.NotNull java.util.Queue<java.lang.Runnable> r17) {
        /*
            r10 = this;
            r0 = r17
            java.lang.String r1 = ""
            r7 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            r8 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.appsflyer.internal.i r9 = new com.appsflyer.internal.i
            r9.<init>(r0)
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r2.<init>(r3, r4, r5, r7, r8, r9)
            r1 = r10
            r1.AFAdRevenueData = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1oSDK.<init>(int, int, long, java.util.concurrent.TimeUnit, java.util.concurrent.BlockingQueue, java.util.Queue):void");
    }
}
