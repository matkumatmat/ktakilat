package coil3.network.okhttp.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012#\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\b¨\u0006\t"}, d2 = {"Lcoil3/network/okhttp/internal/ContinuationCallback;", "Lokhttp3/Callback;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "coil-network-okhttp"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ContinuationCallback implements Callback, Function1<Throwable, Unit> {
    public final Call c;
    public final CancellableContinuationImpl d;

    public ContinuationCallback(Call call, CancellableContinuationImpl cancellableContinuationImpl) {
        this.c = call;
        this.d = cancellableContinuationImpl;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        try {
            this.c.cancel();
        } catch (Throwable unused) {
        }
        return Unit.f696a;
    }

    public final void onFailure(Call call, IOException iOException) {
        if (!call.isCanceled()) {
            Result.Companion companion = Result.Companion;
            this.d.resumeWith(Result.m16constructorimpl(ResultKt.a(iOException)));
        }
    }

    public final void onResponse(Call call, Response response) {
        this.d.resumeWith(Result.m16constructorimpl(response));
    }
}
