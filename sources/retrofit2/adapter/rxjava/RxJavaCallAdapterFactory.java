package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Completable;
import rx.Observable;
import rx.Scheduler;
import rx.Single;

public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    @Nullable
    private final Scheduler scheduler;

    private RxJavaCallAdapterFactory(@Nullable Scheduler scheduler2, boolean z) {
        this.scheduler = scheduler2;
        this.isAsync = z;
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory((Scheduler) null, false);
    }

    public static RxJavaCallAdapterFactory createAsync() {
        return new RxJavaCallAdapterFactory((Scheduler) null, true);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(Scheduler scheduler2) {
        if (scheduler2 != null) {
            return new RxJavaCallAdapterFactory(scheduler2, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Type type2;
        String str;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == Single.class) {
            z = true;
        } else {
            z = false;
        }
        if (rawType == Completable.class) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (rawType != Observable.class && !z && !z2) {
            return null;
        }
        if (z2) {
            return new RxJavaCallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, true);
        } else if (!(type instanceof ParameterizedType)) {
            if (z) {
                str = "Single";
            } else {
                str = "Observable";
            }
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        } else {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
            if (rawType2 == Response.class) {
                if (parameterUpperBound instanceof ParameterizedType) {
                    type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                    z4 = false;
                } else {
                    throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
                }
            } else if (rawType2 != Result.class) {
                type2 = parameterUpperBound;
                z4 = false;
                z3 = true;
                return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z4, z3, z, false);
            } else if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z4 = true;
            } else {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            z3 = false;
            return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z4, z3, z, false);
        }
    }
}
