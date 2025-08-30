package com.chad.library.adapter.base.diff;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer;", "T", "Lcom/chad/library/adapter/base/diff/DifferImp;", "MainThreadExecutor", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
public final class BrvahAsyncDiffer<T> implements DifferImp<T> {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer$MainThreadExecutor;", "Ljava/util/concurrent/Executor;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 4, 0})
    public static final class MainThreadExecutor implements Executor {
        public final void execute(Runnable runnable) {
            Intrinsics.e(runnable, "command");
            throw null;
        }
    }
}
