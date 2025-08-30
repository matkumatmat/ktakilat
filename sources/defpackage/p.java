package defpackage;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCallerKt;
import kotlin.jvm.functions.Function1;

/* renamed from: p  reason: default package */
public final /* synthetic */ class p implements ActivityResultCallback {
    public final /* synthetic */ int c;
    public final /* synthetic */ Function1 d;

    public /* synthetic */ p(int i, Function1 function1) {
        this.c = i;
        this.d = function1;
    }

    public final void onActivityResult(Object obj) {
        switch (this.c) {
            case 0:
                ActivityResultCallerKt.registerForActivityResult$lambda$0(this.d, obj);
                return;
            default:
                ActivityResultCallerKt.registerForActivityResult$lambda$1(this.d, obj);
                return;
        }
    }
}
