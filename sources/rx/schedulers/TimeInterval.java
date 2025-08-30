package rx.schedulers;

public class TimeInterval<T> {
    private final long intervalInMilliseconds;
    private final T value;

    public TimeInterval(long j, T t) {
        this.value = t;
        this.intervalInMilliseconds = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TimeInterval timeInterval = (TimeInterval) obj;
        if (this.intervalInMilliseconds != timeInterval.intervalInMilliseconds) {
            return false;
        }
        T t = this.value;
        if (t == null) {
            if (timeInterval.value != null) {
                return false;
            }
        } else if (!t.equals(timeInterval.value)) {
            return false;
        }
        return true;
    }

    public long getIntervalInMilliseconds() {
        return this.intervalInMilliseconds;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        int i;
        long j = this.intervalInMilliseconds;
        int i2 = (((int) (j ^ (j >>> 32))) + 31) * 31;
        T t = this.value;
        if (t == null) {
            i = 0;
        } else {
            i = t.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.intervalInMilliseconds + ", value=" + this.value + "]";
    }
}
