package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import java.lang.instrument.ClassFileTransformer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.debug.internal.ConcurrentWeakMap;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@SuppressLint({"all"})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@IgnoreJRERequirement
public final class AgentPremain {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DebugProbesTransformer implements ClassFileTransformer {
    }

    static {
        Object obj;
        Boolean bool;
        Boolean bool2 = null;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            if (property != null) {
                bool = Boolean.valueOf(Boolean.parseBoolean(property));
            } else {
                bool = null;
            }
            obj = Result.m16constructorimpl(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m16constructorimpl(ResultKt.a(th));
        }
        if (!Result.m21isFailureimpl(obj)) {
            bool2 = obj;
        }
        if (bool2 == null) {
            ConcurrentWeakMap concurrentWeakMap = DebugProbesImpl.f781a;
        }
    }
}
