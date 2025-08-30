package com.katkilat.baidu_face.manager;

import android.app.Activity;
import com.baidu.idl.face.platform.listener.IInitCallback;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.ktakilat.cbase.datacollect.KtaCollect;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/katkilat/baidu_face/manager/BaiduFaceManager$initialize$1", "Lcom/baidu/idl/face/platform/listener/IInitCallback;", "baidu_face_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaiduFaceManager$initialize$1 implements IInitCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f458a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;

    public BaiduFaceManager$initialize$1(Activity activity, Function0 function0, Function0 function02) {
        this.f458a = activity;
        this.b = function0;
        this.c = function02;
    }

    public final void initFailure(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "errMsg");
        KtaCollect.n_live_detection_init_error(String.valueOf(i));
        FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
        instance.recordException(new Throwable("百度sdk初始化失败 = " + i + StringUtils.SPACE + str));
        this.f458a.runOnUiThread(new r0(i, str, this.c));
    }

    public final void initSuccess() {
        this.f458a.runOnUiThread(new s0(this.b, 0));
    }
}
