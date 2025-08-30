package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChannelKt {
    public static BufferedChannel a(int i, BufferOverflow bufferOverflow, int i2) {
        BufferedChannel conflatedBufferedChannel;
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i == Integer.MAX_VALUE) {
                        return new BufferedChannel(Integer.MAX_VALUE, (Function1) null);
                    }
                    if (bufferOverflow == BufferOverflow.SUSPEND) {
                        return new BufferedChannel(i, (Function1) null);
                    }
                    return new ConflatedBufferedChannel(i, bufferOverflow, (Function1) null);
                } else if (bufferOverflow == BufferOverflow.SUSPEND) {
                    conflatedBufferedChannel = new BufferedChannel(0, (Function1) null);
                } else {
                    conflatedBufferedChannel = new ConflatedBufferedChannel(1, bufferOverflow, (Function1) null);
                }
            } else if (bufferOverflow == BufferOverflow.SUSPEND) {
                return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, (Function1) null);
            } else {
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
        } else if (bufferOverflow == BufferOverflow.SUSPEND) {
            Channel.h.getClass();
            conflatedBufferedChannel = new BufferedChannel(Channel.Factory.b, (Function1) null);
        } else {
            conflatedBufferedChannel = new ConflatedBufferedChannel(1, bufferOverflow, (Function1) null);
        }
        return conflatedBufferedChannel;
    }
}
