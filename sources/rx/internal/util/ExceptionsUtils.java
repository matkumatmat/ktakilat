package rx.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

public enum ExceptionsUtils {
    ;
    
    private static final Throwable TERMINATED = null;

    static {
        TERMINATED = new Throwable("Terminated");
    }

    public static boolean addThrowable(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        while (true) {
            Throwable th3 = atomicReference.get();
            if (th3 == TERMINATED) {
                return false;
            }
            if (th3 == null) {
                th2 = th;
            } else if (th3 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th3).getExceptions());
                arrayList.add(th);
                th2 = new CompositeException((Collection<? extends Throwable>) arrayList);
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

    public static boolean isTerminated(AtomicReference<Throwable> atomicReference) {
        return isTerminated(atomicReference.get());
    }

    public static Throwable terminate(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = TERMINATED;
        if (th != th2) {
            return atomicReference.getAndSet(th2);
        }
        return th;
    }

    public static boolean isTerminated(Throwable th) {
        return th == TERMINATED;
    }
}
