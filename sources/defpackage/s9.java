package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import com.ktakilat.cbase.datacollect.KtaEvent;
import com.ktakilat.loan.weiget.GestureUtil;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: s9  reason: default package */
public final /* synthetic */ class s9 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ GestureUtil c;
    public final /* synthetic */ GestureUtil.GestureSetEnum d;
    public final /* synthetic */ GestureUtil.CheckCallback e;

    public /* synthetic */ s9(GestureUtil gestureUtil, GestureUtil.GestureSetEnum gestureSetEnum, GestureUtil.CheckCallback checkCallback) {
        this.c = gestureUtil;
        this.d = gestureSetEnum;
        this.e = checkCallback;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        GestureUtil.CheckCallback checkCallback;
        GestureUtil gestureUtil = this.c;
        gestureUtil.getClass();
        String type = this.d.getType();
        Intrinsics.checkNotNullParameter(type, "scene");
        Bundle bundle = new Bundle();
        bundle.putString("scene", type);
        KtaEvent.Companion.b("n_pop_set_patter_pwd_leave", bundle);
        if (gestureUtil.h() && (checkCallback = this.e) != null) {
            checkCallback.a(false);
        }
    }
}
