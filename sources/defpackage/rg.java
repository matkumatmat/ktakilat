package defpackage;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

/* renamed from: rg  reason: default package */
public final /* synthetic */ class rg implements ThreadFactory {
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;

    public /* synthetic */ rg(String str, boolean z) {
        this.c = str;
        this.d = z;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.threadFactory$lambda$1(this.c, this.d, runnable);
    }
}
