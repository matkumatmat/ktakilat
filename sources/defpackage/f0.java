package defpackage;

import android.location.Location;
import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;
import org.apache.commons.lang3.ArchUtils;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.arch.Processor;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;

/* renamed from: f0  reason: default package */
public final /* synthetic */ class f0 implements Consumer {
    public final /* synthetic */ int c;
    public final /* synthetic */ Object d;

    public /* synthetic */ f0(Object obj, int i) {
        this.c = i;
        this.d = obj;
    }

    public final void accept(Object obj) {
        switch (this.c) {
            case 0:
                ArchUtils.addProcessor((String) obj, (Processor) this.d);
                return;
            case 1:
                Failable.accept((FailableConsumer) this.d, obj);
                return;
            case 2:
                Functions.accept((Functions.FailableConsumer) this.d, obj);
                return;
            case 3:
                ((androidx.core.util.Consumer) this.d).accept((Location) obj);
                return;
            default:
                ((List) this.d).add((Method) obj);
                return;
        }
    }
}
