package retrofit2;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$await$2$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, k = 1, mv = {1, 1, 15})
public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation $continuation;

    public KotlinExtensions$await$2$2(CancellableContinuation cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(@NotNull Call<T> call, @NotNull Throwable th) {
        Intrinsics.e(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.e(th, "t");
        CancellableContinuation cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m16constructorimpl(ResultKt.a(th)));
    }

    public void onResponse(@NotNull Call<T> call, @NotNull Response<T> response) {
        Intrinsics.e(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.e(response, "response");
        if (response.isSuccessful()) {
            T body = response.body();
            if (body == null) {
                Object tag = call.request().tag(Invocation.class);
                if (tag == null) {
                    Intrinsics.i();
                }
                Intrinsics.b(tag, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) tag).method();
                StringBuilder sb = new StringBuilder("Response from ");
                Intrinsics.b(method, FirebaseAnalytics.Param.METHOD);
                Class<?> declaringClass = method.getDeclaringClass();
                Intrinsics.b(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                CancellableContinuation cancellableContinuation = this.$continuation;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m16constructorimpl(ResultKt.a(kotlinNullPointerException)));
                return;
            }
            this.$continuation.resumeWith(Result.m16constructorimpl(body));
            return;
        }
        CancellableContinuation cancellableContinuation2 = this.$continuation;
        HttpException httpException = new HttpException(response);
        Result.Companion companion2 = Result.Companion;
        cancellableContinuation2.resumeWith(Result.m16constructorimpl(ResultKt.a(httpException)));
    }
}
