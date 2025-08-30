package kotlin.uuid;

import java.security.SecureRandom;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlin/uuid/SecureRandomHolder;", "", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SecureRandomHolder {
    static {
        new SecureRandom();
    }
}
