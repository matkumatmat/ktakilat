package coil3.network;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcoil3/network/HttpException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcoil3/network/NetworkResponse;", "response", "<init>", "(Lcoil3/network/NetworkResponse;)V", "c", "Lcoil3/network/NetworkResponse;", "getResponse", "()Lcoil3/network/NetworkResponse;", "coil-network-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HttpException extends RuntimeException {
    public final NetworkResponse c;

    public HttpException(@NotNull NetworkResponse networkResponse) {
        super("HTTP " + networkResponse.f131a);
        this.c = networkResponse;
    }

    @NotNull
    public final NetworkResponse getResponse() {
        return this.c;
    }
}
