package rx;

public final class Notification<T> {
    private static final Notification<Void> ON_COMPLETED = new Notification<>(Kind.OnCompleted, (Object) null, (Throwable) null);
    private final Kind kind;
    private final Throwable throwable;
    private final T value;

    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    private Notification(Kind kind2, T t, Throwable th) {
        this.value = t;
        this.throwable = th;
        this.kind = kind2;
    }

    public static <T> Notification<T> createOnCompleted() {
        return ON_COMPLETED;
    }

    public static <T> Notification<T> createOnError(Throwable th) {
        return new Notification<>(Kind.OnError, (Object) null, th);
    }

    public static <T> Notification<T> createOnNext(T t) {
        return new Notification<>(Kind.OnNext, t, (Throwable) null);
    }

    public void accept(Observer<? super T> observer) {
        Kind kind2 = this.kind;
        if (kind2 == Kind.OnNext) {
            observer.onNext(getValue());
        } else if (kind2 == Kind.OnCompleted) {
            observer.onCompleted();
        } else {
            observer.onError(getThrowable());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.getKind() != getKind()) {
            return false;
        }
        T t = this.value;
        T t2 = notification.value;
        if (t != t2 && (t == null || !t.equals(t2))) {
            return false;
        }
        Throwable th = this.throwable;
        Throwable th2 = notification.throwable;
        if (th == th2 || (th != null && th.equals(th2))) {
            return true;
        }
        return false;
    }

    public Kind getKind() {
        return this.kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasThrowable() {
        if (!isOnError() || this.throwable == null) {
            return false;
        }
        return true;
    }

    public boolean hasValue() {
        if (!isOnNext() || this.value == null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = getKind().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (hasThrowable()) {
            return (hashCode * 31) + getThrowable().hashCode();
        }
        return hashCode;
    }

    public boolean isOnCompleted() {
        if (getKind() == Kind.OnCompleted) {
            return true;
        }
        return false;
    }

    public boolean isOnError() {
        if (getKind() == Kind.OnError) {
            return true;
        }
        return false;
    }

    public boolean isOnNext() {
        if (getKind() == Kind.OnNext) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        sb.append(getKind());
        if (hasValue()) {
            sb.append(' ');
            sb.append(getValue());
        }
        if (hasThrowable()) {
            sb.append(' ');
            sb.append(getThrowable().getMessage());
        }
        sb.append(']');
        return sb.toString();
    }

    @Deprecated
    public static <T> Notification<T> createOnCompleted(Class<T> cls) {
        return ON_COMPLETED;
    }
}
