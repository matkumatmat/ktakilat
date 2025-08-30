package defpackage;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;

/* renamed from: p1  reason: default package */
public final /* synthetic */ class p1 implements AsyncCallable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListeningExecutorService f352a;
    public final /* synthetic */ Callable b;

    public /* synthetic */ p1(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.f352a = listeningExecutorService;
        this.b = callable;
    }

    public final ListenableFuture call() {
        return this.f352a.submit(this.b);
    }
}
