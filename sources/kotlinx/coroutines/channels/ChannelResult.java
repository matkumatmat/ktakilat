package kotlinx.coroutines.channels;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InternalCoroutinesApi;

@JvmInline
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b@\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0001\u0006\u0001\u0004\u0018\u00010\u0002¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", "T", "", "Failed", "Closed", "Companion", "holder", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChannelResult<T> {
    public static final Failed b = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Object f775a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Closed extends Failed {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f776a;

        public Closed(Throwable th) {
            this.f776a = th;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Closed) {
                if (Intrinsics.a(this.f776a, ((Closed) obj).f776a)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Throwable th = this.f776a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public final String toString() {
            return "Closed(" + this.f776a + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "failed", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @InternalCoroutinesApi
    public static final class Companion {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0010\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class Failed {
        public String toString() {
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED;
        }
    }

    public /* synthetic */ ChannelResult(Object obj) {
        this.f775a = obj;
    }

    public static final Throwable a(Object obj) {
        Closed closed;
        if (obj instanceof Closed) {
            closed = (Closed) obj;
        } else {
            closed = null;
        }
        if (closed != null) {
            return closed.f776a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ChannelResult)) {
            return false;
        }
        if (!Intrinsics.a(this.f775a, ((ChannelResult) obj).f775a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.f775a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f775a;
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
