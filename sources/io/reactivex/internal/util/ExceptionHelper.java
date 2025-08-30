package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final Throwable f682a = new Termination();

    public static final class Termination extends Throwable {
        private static final long serialVersionUID = -4649703670690200604L;

        public Termination() {
            super("No further exceptions");
        }

        public final Throwable fillInStackTrace() {
            return this;
        }
    }

    public static boolean a(AtomicReference atomicReference, Throwable th) {
        Throwable th2;
        while (true) {
            Throwable th3 = (Throwable) atomicReference.get();
            if (th3 == f682a) {
                return false;
            }
            if (th3 == null) {
                th2 = th;
            } else {
                th2 = new CompositeException(th3, th);
            }
            while (true) {
                if (atomicReference.compareAndSet(th3, th2)) {
                    return true;
                }
                if (atomicReference.get() != th3) {
                }
            }
        }
    }

    public static Throwable b(AtomicReference atomicReference) {
        Throwable th = (Throwable) atomicReference.get();
        Throwable th2 = f682a;
        if (th != th2) {
            return (Throwable) atomicReference.getAndSet(th2);
        }
        return th;
    }

    public static RuntimeException c(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            return (RuntimeException) th;
        } else {
            return new RuntimeException(th);
        }
    }
}
