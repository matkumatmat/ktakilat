package com.appsflyer.internal;

import android.graphics.Color;
import android.media.AudioTrack;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class AFi1iSDKI22864$AFa1tSDK implements OnCompleteListener<IntegrityTokenResponse> {
    private /* synthetic */ AFi1fSDK AFAdRevenueData;
    private final long getMediationNetwork;

    public AFi1iSDKI22864$AFa1tSDK(AFi1fSDK aFi1fSDK, long j) {
        this.AFAdRevenueData = aFi1fSDK;
        this.getMediationNetwork = j;
    }

    public final void onComplete(@NotNull Task<IntegrityTokenResponse> task) {
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(task, "");
        if (task.isSuccessful()) {
            str = task.getResult().token();
            obj = null;
        } else {
            AFi1fSDK aFi1fSDK = this.AFAdRevenueData;
            try {
                Object[] objArr = new Object[2];
                objArr[1] = task.getException();
                objArr[0] = aFi1fSDK;
                Map map = AFi1jSDK.e;
                Object obj2 = map.get(1949440882);
                if (obj2 == null) {
                    obj2 = ((Class) AFi1jSDK.AFAdRevenueData(ViewConfiguration.getPressedStateDuration() >> 16, (char) (ViewConfiguration.getEdgeSlop() >> 16), 37 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("AFAdRevenueData", new Class[]{(Class) AFi1jSDK.AFAdRevenueData(1 - (SystemClock.currentThreadTimeMillis() > -1 ? 1 : (SystemClock.currentThreadTimeMillis() == -1 ? 0 : -1)), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 37 - TextUtils.indexOf("", "", 0)), Exception.class});
                    map.put(1949440882, obj2);
                }
                obj = ((Method) obj2).invoke((Object) null, objArr);
                str = null;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        AFi1fSDK aFi1fSDK2 = this.AFAdRevenueData;
        long j = this.getMediationNetwork;
        Object[] objArr2 = new Object[4];
        objArr2[3] = obj;
        objArr2[2] = str;
        objArr2[1] = Long.valueOf(j);
        objArr2[0] = aFi1fSDK2;
        Map map2 = AFi1jSDK.e;
        Object obj3 = map2.get(-1326367481);
        if (obj3 == null) {
            Class<String> cls = String.class;
            obj3 = ((Class) AFi1jSDK.AFAdRevenueData(View.MeasureSpec.getMode(0), (char) (ViewConfiguration.getTouchSlop() >> 8), 37 - View.MeasureSpec.getMode(0))).getMethod("getMonetizationNetwork", new Class[]{(Class) AFi1jSDK.AFAdRevenueData(ViewConfiguration.getTapTimeout() >> 16, (char) (1 - (SystemClock.elapsedRealtime() > 0 ? 1 : (SystemClock.elapsedRealtime() == 0 ? 0 : -1))), 37 - (ViewConfiguration.getLongPressTimeout() >> 16)), Long.TYPE, cls, cls});
            map2.put(-1326367481, obj3);
        }
        ((Method) obj3).invoke((Object) null, objArr2);
        Object[] objArr3 = {this.AFAdRevenueData};
        Object obj4 = map2.get(-2030000374);
        if (obj4 == null) {
            obj4 = ((Class) AFi1jSDK.AFAdRevenueData(View.MeasureSpec.makeMeasureSpec(0, 0), (char) Color.red(0), 36 - TextUtils.lastIndexOf("", '0', 0, 0))).getMethod("getRevenue", new Class[]{(Class) AFi1jSDK.AFAdRevenueData(TextUtils.getOffsetBefore("", 0), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 36 - TextUtils.indexOf("", '0', 0, 0))});
            map2.put(-2030000374, obj4);
        }
        ((CountDownLatch) ((Method) obj4).invoke((Object) null, objArr3)).countDown();
    }
}
