package defpackage;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.perf.v1.PerfMetric;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableLongFunction;
import org.apache.commons.lang3.function.FailableLongPredicate;
import org.apache.commons.lang3.function.FailableLongToDoubleFunction;
import org.apache.commons.lang3.function.FailableLongToIntFunction;
import org.apache.commons.lang3.function.FailableLongUnaryOperator;
import org.apache.commons.lang3.function.FailableObjDoubleConsumer;
import org.apache.commons.lang3.function.FailableObjIntConsumer;
import org.apache.commons.lang3.function.FailableObjLongConsumer;
import org.apache.commons.lang3.function.FailablePredicate;
import org.apache.commons.lang3.function.FailableToDoubleBiFunction;
import org.apache.commons.lang3.function.FailableToDoubleFunction;
import org.apache.commons.lang3.function.FailableToIntBiFunction;
import org.apache.commons.lang3.function.FailableToIntFunction;
import org.apache.commons.lang3.function.FailableToLongBiFunction;
import org.apache.commons.lang3.function.FailableToLongFunction;

/* renamed from: g8  reason: default package */
public final /* synthetic */ class g8 implements FailableLongFunction, FailableLongPredicate, FailableLongToDoubleFunction, FailableLongToIntFunction, FailableLongUnaryOperator, FailableObjDoubleConsumer, FailableObjIntConsumer, FailableObjLongConsumer, FailablePredicate, FailableToDoubleBiFunction, FailableToDoubleFunction, FailableToIntBiFunction, FailableToIntFunction, FailableToLongBiFunction, FailableToLongFunction, Continuation, LibraryVersionComponent.VersionExtractor, OnFailureListener, SuccessContinuation, Transformer, Functions.FailableConsumer {
    public final /* synthetic */ int c;

    public /* synthetic */ g8(int i) {
        this.c = i;
    }

    public void accept(Object obj) {
        Functions.rethrow((Throwable) obj);
    }

    public /* synthetic */ FailableLongPredicate and(FailableLongPredicate failableLongPredicate) {
        int i = this.c;
        return j8.a(this, failableLongPredicate);
    }

    public /* synthetic */ FailableLongUnaryOperator andThen(FailableLongUnaryOperator failableLongUnaryOperator) {
        int i = this.c;
        return n8.a(this, failableLongUnaryOperator);
    }

    public Object apply(long j) {
        return h8.a(j);
    }

    public double applyAsDouble(long j) {
        return k8.a(j);
    }

    public int applyAsInt(long j) {
        return l8.a(j);
    }

    public long applyAsLong(long j) {
        switch (this.c) {
            case 5:
                return n8.f(j);
            default:
                return n8.g(j);
        }
    }

    public /* synthetic */ FailableLongUnaryOperator compose(FailableLongUnaryOperator failableLongUnaryOperator) {
        int i = this.c;
        return n8.b(this, failableLongUnaryOperator);
    }

    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.c) {
            case 20:
                return FirebaseCommonRegistrar.lambda$getComponents$0(context);
            case 21:
                return FirebaseCommonRegistrar.lambda$getComponents$1(context);
            case 22:
                return FirebaseCommonRegistrar.lambda$getComponents$2(context);
            default:
                return FirebaseCommonRegistrar.lambda$getComponents$3(context);
        }
    }

    public void onFailure(Exception exc) {
        Logger.getLogger().e("Error fetching settings.", exc);
    }

    public /* synthetic */ FailableLongPredicate or(FailableLongPredicate failableLongPredicate) {
        int i = this.c;
        return j8.c(this, failableLongPredicate);
    }

    public boolean test(long j) {
        switch (this.c) {
            case 1:
                return j8.h(j);
            default:
                return j8.i(j);
        }
    }

    public Task then(Object obj) {
        switch (this.c) {
            case 25:
                return Tasks.forResult(null);
            case 26:
                return Tasks.forResult(null);
            default:
                return Tasks.forResult(null);
        }
    }

    public void accept(Object obj, double d) {
        o8.a(obj, d);
    }

    public /* synthetic */ FailablePredicate and(FailablePredicate failablePredicate) {
        int i = this.c;
        return s8.a(this, failablePredicate);
    }

    public Object apply(Object obj) {
        return ((PerfMetric) obj).toByteArray();
    }

    public double applyAsDouble(Object obj) {
        return u8.a(obj);
    }

    public int applyAsInt(Object obj) {
        return w8.a(obj);
    }

    public long applyAsLong(Object obj) {
        return y8.a(obj);
    }

    public /* synthetic */ FailablePredicate or(FailablePredicate failablePredicate) {
        int i = this.c;
        return s8.c(this, failablePredicate);
    }

    public boolean test(Object obj) {
        switch (this.c) {
            case 10:
                return s8.h(obj);
            default:
                return s8.i(obj);
        }
    }

    public Object then(Task task) {
        switch (this.c) {
            case 18:
                return Integer.valueOf(TypedValues.CycleType.TYPE_ALPHA);
            default:
                return FcmBroadcastProcessor.lambda$bindToMessagingService$3(task);
        }
    }

    public void accept(Object obj, int i) {
        p8.a(obj, i);
    }

    public double applyAsDouble(Object obj, Object obj2) {
        return t8.a(obj, obj2);
    }

    public int applyAsInt(Object obj, Object obj2) {
        return v8.a(obj, obj2);
    }

    public long applyAsLong(Object obj, Object obj2) {
        return x8.a(obj, obj2);
    }

    public void accept(Object obj, long j) {
        q8.a(obj, j);
    }
}
