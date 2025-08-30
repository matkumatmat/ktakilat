package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class TasksKt$awaitImpl$2$1<TResult> implements OnCompleteListener {
    public final /* synthetic */ CancellableContinuationImpl c;

    public TasksKt$awaitImpl$2$1(CancellableContinuationImpl cancellableContinuationImpl) {
        this.c = cancellableContinuationImpl;
    }

    public final void onComplete(Task task) {
        Exception exception = task.getException();
        CancellableContinuationImpl cancellableContinuationImpl = this.c;
        if (exception != null) {
            Result.Companion companion = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(ResultKt.a(exception)));
        } else if (task.isCanceled()) {
            cancellableContinuationImpl.u((Throwable) null);
        } else {
            Result.Companion companion2 = Result.Companion;
            cancellableContinuationImpl.resumeWith(Result.m16constructorimpl(task.getResult()));
        }
    }
}
