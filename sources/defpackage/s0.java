package defpackage;

import android.util.Log;
import androidx.core.view.ViewKt;
import kotlin.jvm.functions.Function0;

/* renamed from: s0  reason: default package */
public final /* synthetic */ class s0 implements Runnable {
    public final /* synthetic */ int c;
    public final /* synthetic */ Function0 d;

    public /* synthetic */ s0(Function0 function0, int i) {
        this.c = i;
        this.d = function0;
    }

    public final void run() {
        switch (this.c) {
            case 0:
                Log.e("baidu_face", "初始化成功");
                this.d.invoke();
                return;
            default:
                ViewKt.postOnAnimationDelayed$lambda$1(this.d);
                return;
        }
    }
}
