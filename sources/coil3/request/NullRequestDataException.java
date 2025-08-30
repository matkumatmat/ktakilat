package coil3.request;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcoil3/request/NullRequestDataException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NullRequestDataException extends RuntimeException {
    public NullRequestDataException() {
        super("The request's data is null.");
    }
}
