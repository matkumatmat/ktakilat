package bolts;

import java.util.Locale;
import java.util.concurrent.CancellationException;

public class CancellationToken {
    private final CancellationTokenSource tokenSource;

    public CancellationToken(CancellationTokenSource cancellationTokenSource) {
        this.tokenSource = cancellationTokenSource;
    }

    public boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    public CancellationTokenRegistration register(Runnable runnable) {
        return this.tokenSource.register(runnable);
    }

    public void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested();
    }

    public String toString() {
        Locale locale = Locale.US;
        String name = getClass().getName();
        String hexString = Integer.toHexString(hashCode());
        String bool = Boolean.toString(this.tokenSource.isCancellationRequested());
        return name + "@" + hexString + "[cancellationRequested=" + bool + "]";
    }
}
