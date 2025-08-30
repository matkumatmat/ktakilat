package defpackage;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;
import java.util.concurrent.Callable;

/* renamed from: z4  reason: default package */
public final /* synthetic */ class z4 implements Callable {
    public final /* synthetic */ int c;
    public final /* synthetic */ DefaultHeartBeatController d;

    public /* synthetic */ z4(DefaultHeartBeatController defaultHeartBeatController, int i) {
        this.c = i;
        this.d = defaultHeartBeatController;
    }

    public final Object call() {
        switch (this.c) {
            case 0:
                return this.d.lambda$getHeartBeatsHeader$1();
            default:
                return this.d.lambda$registerHeartBeat$0();
        }
    }
}
